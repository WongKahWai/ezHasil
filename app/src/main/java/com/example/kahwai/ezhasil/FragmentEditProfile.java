package com.example.kahwai.ezhasil;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FragmentEditProfile extends Fragment {
    public FragmentEditProfile() {}

    private View rootView;
    private User user_data;
    private DatabaseReference mDatabase;
    private String email;

    EditText edtMobile, edtHome, edtPassport, edtRegistered, edtBank, edtBankAccount;
    Button btnSave;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_edit_profile, container, false);
        final FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        email = firebaseUser.getEmail();
        user_data = (User) getArguments().getSerializable("user");

        edtMobile = (EditText)rootView.findViewById(R.id.edit_mobile_phone);
        edtHome = (EditText)rootView.findViewById(R.id.edit_home_phone);
        edtPassport = (EditText)rootView.findViewById(R.id.edit_passport);
        edtRegistered = (EditText)rootView.findViewById(R.id.edit_registered_passport);
        edtBank = (EditText)rootView.findViewById(R.id.edit_bank);
        edtBankAccount = (EditText)rootView.findViewById(R.id.edit_bank_account_no);
        btnSave = (Button)rootView.findViewById(R.id.edit_btnSave);

        edtMobile.setText(user_data.getPhoneNo());
        edtHome.setText(user_data.getHomePhoneNo());
        edtPassport.setText(user_data.getPassportNo());
        edtRegistered.setText(user_data.getRegisteredPassport());
        edtBank.setText(user_data.getBankName());
        edtBankAccount.setText(user_data.getBankAccountNo());

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_data.setPhoneNo(edtMobile.getText().toString());
                user_data.setHomePhoneNo(edtHome.getText().toString());
                user_data.setPassportNo(edtPassport.getText().toString());
                user_data.setRegisteredPassport(edtRegistered.getText().toString());
                user_data.setBankName(edtBank.getText().toString());
                user_data.setBankAccountNo(edtBankAccount.getText().toString());

                mDatabase.child("Users").child(EncodeString(email)).child("Profile").setValue(user_data);
            }
        });

        return rootView;
    }

    public static String EncodeString(String string) {
        return string.replace(".", ",");
    }
}
