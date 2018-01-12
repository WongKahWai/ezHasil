package com.example.kahwai.ezhasil;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ValueEventListener;

public class MenuActivity extends AppCompatActivity {

    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    private FirebaseDatabase db,db2;
    private Button btnSignOut;
    private TextView btn1,btn2,btn3,btn4,btn5,btn6;
    private IncomeTax income_tax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar_layout);
        View view = getSupportActionBar().getCustomView();

        final TextView user_name = (TextView)findViewById(R.id.user_name);
        final TextView income_tax_id = (TextView)findViewById(R.id.user_profile_short_bio);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        db2 = FirebaseDatabase.getInstance();

        //get current user
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference ref = db.getReference().child("Users").child(EncodeString(user.getEmail())).child("Profile");
        DatabaseReference ref2 = db2.getReference().child("Users").child(EncodeString(user.getEmail())).child("IncomeTax");
        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(MenuActivity.this, LoginActivity.class));
                    finish();
                }
            }
        };

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name =  dataSnapshot.child("name").getValue(String.class);
                String income_tax_no =  dataSnapshot.child("incomeTaxNo").getValue(String.class);
                user_name.setText(name);
                income_tax_id.setText("Income Tax No : " + income_tax_no);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });

        btnSignOut = (Button) findViewById(R.id.btnSignOut);
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logout();
            }
        });

        btn1 = (TextView) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, AccountActivity.class));
            }
        });

        btn2 = (TextView) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(MenuActivity.this, GeneratePDFActivity.class));
                startActivity(new Intent(MenuActivity.this, ReportViewSelectActivity.class));
            }
        });

        btn3 = (TextView) findViewById(R.id.btn3);
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
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!income_tax.getSubmit_status().equals("Submitted")) {
                    startActivity(new Intent(MenuActivity.this, Manual_eBE.class));

                }else {
                    Toast.makeText(getApplicationContext(), "You have already submitted your form!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        btn4 = (TextView) findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, Chatbot_eBE.class));
            }
        });

        btn5 = (TextView) findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, HistoryActivity.class));
            }
        });

        btn6 = (TextView) findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, Payment.class));
            }
        });
    }

    private void Logout() {
        auth.signOut();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    public void onStop() {
        super.onStop();
       if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }

    public static String EncodeString(String string) {
        return string.replace(".", ",");
    }

    public static String DecodeString(String string) {
        return string.replace(",", ".");
    }
}
