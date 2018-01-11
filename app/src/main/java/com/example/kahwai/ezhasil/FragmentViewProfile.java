package com.example.kahwai.ezhasil;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class FragmentViewProfile extends Fragment {
    public FragmentViewProfile() { }

    private DatabaseReference mDatabase;
    private View rootView;

    private TextView tvName, tvIcNo, tvGender, tvEmail, tvMobile, tvHome, tvIncomeTax, tvPassport, tvRegistered, tvBank, tvBankAccount;

    private String emailUser;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_view_profile, container, false);

        tvName = (TextView)rootView.findViewById(R.id.tv_name);
        tvIcNo = (TextView)rootView.findViewById(R.id.tv_icNo);
        tvGender = (TextView)rootView.findViewById(R.id.tv_gender);
        tvEmail = (TextView)rootView.findViewById(R.id.tv_email);
        tvMobile = (TextView)rootView.findViewById(R.id.tv_mobile);
        tvHome = (TextView)rootView.findViewById(R.id.tv_home);
        tvIncomeTax = (TextView)rootView.findViewById(R.id.tv_incomeTax);
        tvPassport = (TextView)rootView.findViewById(R.id.tv_passport);
        tvRegistered = (TextView)rootView.findViewById(R.id.tv_registeredPassport);
        tvBank = (TextView)rootView.findViewById(R.id.tv_bank);
        tvBankAccount = (TextView)rootView.findViewById(R.id.tv_bankAccount);

        //Get firebase user
        final FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        emailUser = firebaseUser.getEmail();

        //Get firebase database
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.child("Users").child(EncodeString(emailUser)).getValue(User.class);

                tvName.setText(user.getName());
                tvIcNo.setText(user.getIcNo());
                tvGender.setText(user.getSex());
                tvEmail.setText(emailUser);
                tvMobile.setText(user.getPhoneNo());
                tvHome.setText(user.getHomePhoneNo());
                tvIncomeTax.setText(user.getIncomeTaxNo());
                tvPassport.setText(user.getPassportNo());
                tvRegistered.setText(user.getRegisteredPassport());
                tvBank.setText(user.getBankName());
                tvBankAccount.setText(user.getBankAccountNo());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });

        return rootView;
    }

    public static String EncodeString(String string) {
        return string.replace(".", ",");
    }

    public static String DecodeString(String string) {
        return string.replace(",", ".");
    }


}