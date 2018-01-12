package com.example.kahwai.ezhasil;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {
    private static final String TAG = "";
    private EditText email;
    private String strEmail;
    private Button btn_reset_password;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //String emailAddress = "kenyong1997@gmail.com";


        setContentView(R.layout.activity_forgot_password);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar_layout);
        View view = getSupportActionBar().getCustomView();

        email = (EditText) findViewById(R.id.email);
        btn_reset_password = (Button) findViewById(R.id.btn_reset_password);

        btn_reset_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strEmail = String.valueOf(email.getText());

                auth.sendPasswordResetEmail(strEmail)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(getApplicationContext(), "An reset password link will be sent to your email shortly!", Toast.LENGTH_SHORT).show();

                                if (task.isSuccessful()) {
                                    Log.d(TAG, "Email sent.");

                                }
                                startActivity(new Intent(ForgotPasswordActivity.this, LoginActivity.class));
                            }
                        });
            }

    });
}
}
