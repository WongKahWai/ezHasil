package com.example.kahwai.ezhasil;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ReportViewSelectActivity extends AppCompatActivity {

    private static final String TAG ="" ;
    private EditText newpw, newpw_2;
    private Button btnChange;
    private String strnewpw,strnewpw_2;
    private FirebaseDatabase db2;
    private FirebaseAuth auth;
    //private FirebaseUser user;
    private IncomeTax income_tax;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    //String newPassword = "SOME-SECURE-PASSWORD";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        setContentView(R.layout.activity_report_view_select);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar_layout);
        View view = getSupportActionBar().getCustomView();

        //db2 = FirebaseDatabase.getInstance();
        //DatabaseReference ref2 = db2.getReference().child("Users").child(EncodeString(user.getEmail())).child("IncomeTax");

        //oldpw = (EditText) findViewById(R.id.oldpw);
        newpw = (EditText) findViewById(R.id.newpw);
        newpw_2 = (EditText) findViewById(R.id.newpw_2);
        btnChange = (Button) findViewById(R.id.btnChange);



        btnChange.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                strnewpw = String.valueOf(newpw.getText().toString());
                strnewpw_2 = String.valueOf(newpw_2.getText().toString());
                if(strnewpw.length()<6){
                    Toast.makeText(getApplicationContext(), "Your password must be longer than 5 characters!", Toast.LENGTH_SHORT).show();
                }
                else if(strnewpw_2.equals("")){
                    Toast.makeText(getApplicationContext(), "Type in your password again to confirm your password!", Toast.LENGTH_SHORT).show();
                }
                else if(!strnewpw.equals(strnewpw_2)){
                    Toast.makeText(getApplicationContext(), "Your confirm password must be the same with your new password!", Toast.LENGTH_SHORT).show();
                }



                    user.updatePassword(strnewpw)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {


                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(getApplicationContext(), "User password updated!", Toast.LENGTH_SHORT).show();
                                    if (task.isSuccessful()) {


                                        Log.d(TAG, "User password updated.");
                                    }
                                    startActivity(new Intent(ReportViewSelectActivity.this, MenuActivity.class));
                                }

                            });
                }


        });
    }



}
