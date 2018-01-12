package com.example.kahwai.ezhasil;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link SelfNoteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelfNoteFragment extends Fragment {
    private View mRootView;
    private Button mSaveButton, buttonCreate;
    private String LOG_TAG;
    private File myFile;
    private FirebaseDatabase db,db2;
    private FirebaseAuth auth;
    private FirebaseUser user;
    private User user_data;
    private IncomeTax income_tax;
    public SelfNoteFragment() {
        // Required empty public constructor
    }

    public static SelfNoteFragment newInstance(){
        SelfNoteFragment fragment = new SelfNoteFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_self_note, container, false);
//        mSaveButton = (Button) mRootView.findViewById(R.id.button_save);
        buttonCreate = (Button) mRootView.findViewById(R.id.button_create);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        db2 = FirebaseDatabase.getInstance();

        user = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference ref = db.getReference().child("Users").child(EncodeString(user.getEmail())).child("Profile");
        DatabaseReference ref2 = db2.getReference().child("Users").child(EncodeString(user.getEmail())).child("IncomeTax");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                user_data =  dataSnapshot.getValue(User.class);
                System.out.println(user_data);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });

        ref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                income_tax =  dataSnapshot.getValue(IncomeTax.class);
                System.out.println(income_tax);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            try {
                createPdf();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (DocumentException e) {
                e.printStackTrace();
            }}});

        return mRootView;
    }

    private void createPdf() throws IOException, DocumentException, FileNotFoundException {

        File folder = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/ezHasil/");
        if(!folder.exists()){
            folder.mkdir();
        }

        File path = new File(folder,"result.pdf");
        if(!path.exists()){
            path.createNewFile();
        }

        myFile = path;
        Date date = new Date() ;
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(date);

        try{
            OutputStream output = new FileOutputStream(path);
            PdfReader reader = new PdfReader(getResources().openRawResource(R.raw.form_be2016));
            PdfStamper stamper = new PdfStamper(reader, output);
            AcroFields acroFields = stamper.getAcroFields();

            acroFields.setField("name", String.valueOf(user_data.getName()));
            acroFields.setField("income_tax_no", String.valueOf(user_data.getIncomeTaxNo()));
            acroFields.setField("identification_no", String.valueOf(user_data.getIcNo()));
            acroFields.setField("passport_no", String.valueOf(user_data.getPassportNo()));
            acroFields.setField("passport_no_reg", String.valueOf(user_data.getRegisteredPassport()));
            acroFields.setField("citizen", String.valueOf(user_data.getCitizen()));
            if(String.valueOf(user_data.getSex()).equals("Male")){
                acroFields.setField("sex", "1");
            }else{
                acroFields.setField("sex", "2");
            }

            acroFields.setField("date_of_birth", String.valueOf(user_data.getDob()));
            acroFields.setField("marital_status", String.valueOf(income_tax.getStra4()));
            acroFields.setField("date_of_marriage", String.valueOf(income_tax.getStra5()));
            acroFields.setField("type_of_assessment", String.valueOf(income_tax.getStra6()));
            acroFields.setField("B1", String.valueOf(income_tax.getIntb1()));
            acroFields.setField("B2", String.valueOf(income_tax.getIntb2()));
            acroFields.setField("B3", String.valueOf(income_tax.getIntb3()));
            acroFields.setField("B4", String.valueOf(income_tax.getIntb4()));
            acroFields.setField("B5", String.valueOf(income_tax.getIntb5()));
            acroFields.setField("B6", String.valueOf(income_tax.getIntb6()));
            acroFields.setField("B7", String.valueOf(income_tax.getIntb7()));
            acroFields.setField("B8", String.valueOf(income_tax.getIntb8()));
            acroFields.setField("B9", String.valueOf(income_tax.getIntb9()));
            acroFields.setField("B10", String.valueOf(income_tax.getIntb10()));
            acroFields.setField("B11", String.valueOf(income_tax.getIntb11a_1()));
            acroFields.setField("B11a", String.valueOf(income_tax.getIntb11a()));
            acroFields.setField("B11b", String.valueOf(income_tax.getIntb11b()));
            acroFields.setField("B11b1", String.valueOf(income_tax.getIntb11b_1()));
            acroFields.setField("B11bRate", String.valueOf(income_tax.getIntb11b_2())); //need to convert to percent
            acroFields.setField("B12", String.valueOf(income_tax.getIntb12()));
            acroFields.setField("B13", String.valueOf(income_tax.getIntb13()));
            acroFields.setField("B13a", String.valueOf(income_tax.getIntb13a()));
            acroFields.setField("B13b", String.valueOf(income_tax.getIntb13b()));
            acroFields.setField("B13c", String.valueOf(income_tax.getIntb13c()));
            acroFields.setField("B14", String.valueOf(income_tax.getIntb14()));
            acroFields.setField("B15", String.valueOf(income_tax.getIntb15()));
            acroFields.setField("B15a", String.valueOf(income_tax.getIntb15a()));
            acroFields.setField("B15b", String.valueOf(income_tax.getIntb15b()));
            acroFields.setField("B16", String.valueOf(income_tax.getIntb16()));
            acroFields.setField("B17", String.valueOf(income_tax.getIntb17()));
            acroFields.setField("B18", String.valueOf(income_tax.getIntb18()));
            acroFields.setField("B19", String.valueOf(income_tax.getIntb19()));
            if(income_tax.isRefundable()) {
                acroFields.setField("refundable", "X");
            }
            acroFields.setField("declaration_name", String.valueOf(user_data.getName()));
            acroFields.setField("ic_passport", String.valueOf(user_data.getIcNo()));
            acroFields.setField("date_declared", String.valueOf(income_tax.getSubmit_date()));
            acroFields.setField("date", String.valueOf(income_tax.getSubmit_date()));
            acroFields.setField("C1", String.valueOf(income_tax.getStrc1()));
            acroFields.setField("C2", String.valueOf(income_tax.getStrc2()));
            acroFields.setField("C3", String.valueOf(income_tax.getStrc3()));
            acroFields.setField("C4", String.valueOf(income_tax.getStrc4()));
            acroFields.setField("name2", String.valueOf(user_data.getName()));
            acroFields.setField("income_tax_no2", String.valueOf(user_data.getIncomeTaxNo()));
            acroFields.setField("D1a", String.valueOf(user_data.getHomePhoneNo()));
            acroFields.setField("D1b", String.valueOf(user_data.getPhoneNo()));
            acroFields.setField("D2", String.valueOf(user_data.getEmail()));
            acroFields.setField("D3", String.valueOf(user_data.getBankName()));
            acroFields.setField("D4", String.valueOf(user_data.getBankAccountNo()));
            acroFields.setField("D5", String.valueOf(income_tax.getStrd5()));
            acroFields.setField("D6a", String.valueOf(income_tax.getStrd6a()));
            acroFields.setField("D6b", String.valueOf(income_tax.getStrd6b()));
            acroFields.setField("E1a", String.valueOf(income_tax.getStre1a()));
            acroFields.setField("E1b", String.valueOf(income_tax.getStre1b()));
            acroFields.setField("E1c", String.valueOf(income_tax.getStre1c()));
            acroFields.setField("E2a", String.valueOf(income_tax.getStre2a()));
            acroFields.setField("E2b", String.valueOf(income_tax.getStre2b()));
            acroFields.setField("E2c", String.valueOf(income_tax.getStre2c()));
            acroFields.setField("F2a", String.valueOf(income_tax.getIntf2a()));
            acroFields.setField("F2", String.valueOf(income_tax.getIntf2()));
            acroFields.setField("F3", String.valueOf(income_tax.getIntf3()));
            acroFields.setField("F4", String.valueOf(income_tax.getIntf4()));
            acroFields.setField("F5", String.valueOf(income_tax.getIntf5()));
            acroFields.setField("F6", String.valueOf(income_tax.getIntf6()));
            acroFields.setField("F7", String.valueOf(income_tax.getIntf7()));
            acroFields.setField("F8", String.valueOf(income_tax.getIntf8()));
            acroFields.setField("F9", String.valueOf(income_tax.getIntf9()));
            acroFields.setField("F10", String.valueOf(income_tax.getIntf10()));
            acroFields.setField("F11", String.valueOf(income_tax.getIntf11()));
            acroFields.setField("F12", String.valueOf(income_tax.getIntf12()));
            acroFields.setField("F13", String.valueOf(income_tax.getIntf13()));
            acroFields.setField("F14", String.valueOf(income_tax.getIntf14()));
            acroFields.setField("F15a", String.valueOf(income_tax.getIntf15a()));
            acroFields.setField("F15b", String.valueOf(income_tax.getIntf15b()));
            acroFields.setField("F15c", String.valueOf(income_tax.getIntf15c()));
            acroFields.setField("F16", String.valueOf(income_tax.getIntf16()));
            acroFields.setField("F17", String.valueOf(income_tax.getIntf17()));
            acroFields.setField("F18", String.valueOf(income_tax.getIntf18()));
            acroFields.setField("F19", String.valueOf(income_tax.getIntf19()));
            acroFields.setField("F20", String.valueOf(income_tax.getIntf20()));
            acroFields.setField("G1", String.valueOf(income_tax.getStrg1()));
            acroFields.setField("G2", String.valueOf(income_tax.getStrg2()));
            acroFields.setField("G3", String.valueOf(income_tax.getStrg3()));

            if(income_tax.getIntf15_eligibility()==1){
                acroFields.setField("F15a100No", String.valueOf(income_tax.getIntf15a_num()));
                acroFields.setField("F15b100No1", String.valueOf(income_tax.getIntf15b_num()));
                acroFields.setField("F15b100No2", String.valueOf(income_tax.getIntf15c_num()));
                acroFields.setField("F15c100No1", String.valueOf(income_tax.getIntf15d_num()));
                acroFields.setField("F15c100No2", String.valueOf(income_tax.getIntf15e_num()));
                acroFields.setField("F15a100Amount", String.valueOf(income_tax.getIntf15a_total()));
                acroFields.setField("F15b100Amount1", String.valueOf(income_tax.getIntf15b_total()));
                acroFields.setField("F15b100Amount2", String.valueOf(income_tax.getIntf15c_total()));
                acroFields.setField("F15c100Amount1", String.valueOf(income_tax.getIntf15d_total()));
                acroFields.setField("F15c100Amount2", String.valueOf(income_tax.getIntf15e_total()));

                acroFields.setField("F15a50No", "0");
                acroFields.setField("F15b50No1", "0");
                acroFields.setField("F15b50No2", "0");
                acroFields.setField("F15c50No1", "0");
                acroFields.setField("F15c50No2", "0");
                acroFields.setField("F15a50Amount", "0");
                acroFields.setField("F15b50Amount1", "0");
                acroFields.setField("F15b50Amount2", "0");
                acroFields.setField("F15c50Amount1", "0");
                acroFields.setField("F15c50Amount2", "0");

            }else if(income_tax.getIntf15_eligibility()==0.5){
                acroFields.setField("F15a50No", String.valueOf(income_tax.getIntf15a_num()));
                acroFields.setField("F15b50No1", String.valueOf(income_tax.getIntf15b_num()));
                acroFields.setField("F15b50No2", String.valueOf(income_tax.getIntf15c_num()));
                acroFields.setField("F15c50No1", String.valueOf(income_tax.getIntf15d_num()));
                acroFields.setField("F15c50No2", String.valueOf(income_tax.getIntf15e_num()));
                acroFields.setField("F15a50Amount", String.valueOf(income_tax.getIntf15a_total()));
                acroFields.setField("F15b50Amount1", String.valueOf(income_tax.getIntf15b_total()));
                acroFields.setField("F15b50Amount2", String.valueOf(income_tax.getIntf15c_total()));
                acroFields.setField("F15c50Amount1", String.valueOf(income_tax.getIntf15d_total()));
                acroFields.setField("F15c50Amount2", String.valueOf(income_tax.getIntf15e_total()));

                acroFields.setField("F15a100No", "0");
                acroFields.setField("F15b100No1", "0");
                acroFields.setField("F15b100No2", "0");
                acroFields.setField("F15c100No1", "0");
                acroFields.setField("F15c100No2", "0");
                acroFields.setField("F15a100Amount", "0");
                acroFields.setField("F15b100Amount1", "0");
                acroFields.setField("F15b100Amount2", "0");
                acroFields.setField("F15c100Amount1", "0");
                acroFields.setField("F15c100Amount2", "0");
            }else{
                acroFields.setField("F15a100No", "0");
                acroFields.setField("F15b100No1", "0");
                acroFields.setField("F15b100No2", "0");
                acroFields.setField("F15c100No1", "0");
                acroFields.setField("F15c100No2", "0");
                acroFields.setField("F15a100Amount", "0");
                acroFields.setField("F15b100Amount1", "0");
                acroFields.setField("F15b100Amount2", "0");
                acroFields.setField("F15c100Amount1", "0");
                acroFields.setField("F15c100Amount2", "0");

                acroFields.setField("F15a50No", "0");
                acroFields.setField("F15b50No1", "0");
                acroFields.setField("F15b50No2", "0");
                acroFields.setField("F15c50No1", "0");
                acroFields.setField("F15c50No2", "0");
                acroFields.setField("F15a50Amount", "0");
                acroFields.setField("F15b50Amount1", "0");
                acroFields.setField("F15b50Amount2", "0");
                acroFields.setField("F15c50Amount1", "0");
                acroFields.setField("F15c50Amount2", "0");
            }




            stamper.setFormFlattening(true);
            stamper.close();
            System.out.println("Done");
        }catch(FileNotFoundException e){
            Log.e("Ex==",""+e.toString());
        }

        viewPdf();
    }

    private void viewPdf(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(myFile), "application/pdf");
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }

    public static String EncodeString(String string) {
        return string.replace(".", ",");
    }

    public static String DecodeString(String string) {
        return string.replace(",", ".");
    }


}
