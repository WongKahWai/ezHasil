package com.example.kahwai.ezhasil;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ReportViewSelectActivity extends AppCompatActivity {

    private EditText oldpw, newpw, newpw_2;
    private Button btnChange;
    private FirebaseDatabase db2;
    private FirebaseAuth auth;
    private FirebaseUser user;
    private IncomeTax income_tax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_report_view_select);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar_layout);
        View view = getSupportActionBar().getCustomView();

//        db2 = FirebaseDatabase.getInstance();
//        DatabaseReference ref2 = db2.getReference().child("Users").child(EncodeString(user.getEmail())).child("IncomeTax");
//
//        oldpw = (EditText) findViewById(R.id.oldpw);
//        newpw = (EditText) findViewById(R.id.newpw);
//        newpw_2 = (EditText) findViewById(R.id.newpw_2);
//        btnChange = (Button) findViewById(R.id.btnChange);
//
//        btnChange.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
//            }
//
//        });
    }
//    public static String EncodeString(String string) {
//        return string.replace(".", ",");
//    }
//
//    public static String DecodeString(String string) {
//        return string.replace(",", ".");
//    }


}
