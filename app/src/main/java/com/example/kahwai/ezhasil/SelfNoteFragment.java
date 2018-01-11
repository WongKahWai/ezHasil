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
    private FirebaseDatabase db;
    private FirebaseAuth auth;
    private FirebaseUser user;

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

        user = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference ref = db.getReference().child("Users").child(EncodeString(user.getEmail()));

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                System.out.println(user);
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
       /* String pdfFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) + "/ezHasil";
        File dir = new File(pdfFolder);


        if (!dir.exists()) {
            dir.mkdirs();
            Log.i(LOG_TAG, "Pdf Directory created");
            System.out.println(dir);
        }
*/        /*File pdfFolder = new File(Context.getExtrernalFilesDirs(),"ezHasil");
        if (!pdfFolder.exists()) {
            pdfFolder.mkdir();
            Log.i(LOG_TAG, "Pdf Directory created");
        }*/
        File folder = new File(Environment.getExternalStorageDirectory() + "/ezHasil/");
        if(!folder.exists()){
            folder.mkdir();
            System.out.println(folder);
        }

        File path = new File(folder,"result.pdf");
        if(!path.exists()){
            path.createNewFile();
            System.out.println(path);
        }

        Date date = new Date() ;
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(date);

      /*  File myFile = new File(dir, timeStamp + ".pdf");

        System.out.println(myFile);
*/
//        OutputStream output = new FileOutputStream(myFile.getAbsolutePath());

        try{
            OutputStream output = new FileOutputStream(path);
            PdfReader reader = new PdfReader(getResources().openRawResource(R.raw.form_be2016));
            PdfStamper stamper = new PdfStamper(reader, output);
            AcroFields acroFields = stamper.getAcroFields();
            acroFields.setField("D2", user.getEmail().toString());

            stamper.setFormFlattening(true);
            stamper.close();
        }catch(FileNotFoundException e){
            Log.e("Ex==",""+e.toString());
        }

        //Step 4 Add content
/*        document.add(new Paragraph(mSubjectEditText.getText().toString()));
        document.add(new Paragraph(mBodyEditText.getText().toString()));*/

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
