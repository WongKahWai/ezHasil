package com.example.kahwai.ezhasil;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HistoryActivity extends AppCompatActivity {

    ListView lv;
    Model[] modelItems;
    private FirebaseDatabase db;
    private DatabaseReference ref;
    private FirebaseAuth auth;
    private FirebaseUser user;
    private String status, status2;
    private Button btnSubmit;
    private int value=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_history);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar_layout);
        View view = getSupportActionBar().getCustomView();

        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();

        user = FirebaseAuth.getInstance().getCurrentUser();
        final DatabaseReference ref = db.getReference().child("Users").child(EncodeString(user.getEmail())).child("IncomeTax");

        lv = (ListView) findViewById(R.id.listView1);
        modelItems = new Model[1];
        final CustomAdapter adapter = new CustomAdapter(this, modelItems);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                status =  dataSnapshot.child("submit_status").getValue(String.class);
                System.out.println("1" + status);

                if(status=="Submitted"){
                    value=1;
                }


                modelItems[0] = new Model("Submission for BE 2016", value);
                modelItems[0].setSubmit_status(status);
                lv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "You have submitted before!", Toast.LENGTH_SHORT).show();
                    ref.child("submit_status").setValue("Submitted");
                    modelItems[0].setValue(1);


/*                Intent intent = getIntent();
                finish();
                startActivity(intent);*/
            }});
    }

    public static String EncodeString(String string) {
        return string.replace(".", ",");
    }

    public static String DecodeString(String string) {
        return string.replace(",", ".");
    }
}
