package com.example.kahwai.ezhasil;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GeneratePDFActivity extends AppCompatActivity {

    private File myFile;
    private FirebaseDatabase db;
    private FirebaseAuth auth;
    private FirebaseUser user;
    private Button buttonCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_generate_pdf);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar_layout);
        View view = getSupportActionBar().getCustomView();

        SelfNoteFragment noteFragment = SelfNoteFragment.newInstance();

        android.support.v4.app.FragmentTransaction fragTransaction= this.getSupportFragmentManager().beginTransaction();
        fragTransaction.replace(R.id.container, noteFragment);
        fragTransaction.commit();

       /* buttonCreate = (Button) findViewById(R.id.button_create);

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
                }}});*/
    }
   /* private void createPdf() throws IOException, DocumentException, FileNotFoundException {
        String pdfFolder = Environment.getExternalStorageDirectory().getAbsolutePath() + "/ezHasil";
        File dir = new File(pdfFolder);

        if (!dir.exists()) {
            dir.mkdir();
            System.out.println(dir);
        }

        *//*File pdfFolder = new File(Context.getExtrernalFilesDirs(),"ezHasil");
        if (!pdfFolder.exists()) {
            pdfFolder.mkdir();
            Log.i(LOG_TAG, "Pdf Directory created");
        }*//*

        Date date = new Date() ;
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(date);

        File myFile = new File(dir, timeStamp + ".pdf");

        System.out.println(myFile);

        OutputStream output = new FileOutputStream(myFile);
        output.flush();

        //Step 1
        Document document = new Document();

        //Step 2
        PdfWriter.getInstance(document, output);

        //Step 3
        document.open();

        PdfReader reader = new PdfReader(getResources().openRawResource(R.raw.form_be2016));
        PdfStamper stamper = new PdfStamper(reader, output);
        AcroFields acroFields = stamper.getAcroFields();

        acroFields.setField("D2", user.getEmail().toString());

        stamper.setFormFlattening(true);
        stamper.close();
        //Step 4 Add content
*//*        document.add(new Paragraph(mSubjectEditText.getText().toString()));
        document.add(new Paragraph(mBodyEditText.getText().toString()));*//*

        //output.flush();
        //Step 5: Close the document
        document.close();

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
*/
}
