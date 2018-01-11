package com.example.kahwai.ezhasil;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.firebase.database.DatabaseReference;

public class AccountActivity extends AppCompatActivity {

    FragmentAccountEdit saveFragment;

    private Button btnSave;
    private DatabaseReference mDatabase;

    public AccountActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_account);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar_layout);
        View view = getSupportActionBar().getCustomView();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.replace(R.id.fragment_layout, new FragmentAccountEdit());
        ft.replace(R.id.fragment_layout, new FragmentViewProfile());
        ft.commit();
    }




}
