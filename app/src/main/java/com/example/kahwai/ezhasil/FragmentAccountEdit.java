package com.example.kahwai.ezhasil;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FragmentAccountEdit extends Fragment implements View.OnClickListener{
    EditText edtFullName, edtCitizen, edtDOB, edtIC, edtHome, edtMobile, edtIncomeTax, edtPassport, edtRegisteredPassport, edtBank, edtBankAccount;
    RadioGroup rgGender;
    RadioButton rbGender;
    String email;

    private View rootView;
    private DatabaseReference mDatabase;

    public FragmentAccountEdit() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_account_edit, container, false);

        final FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        email = firebaseUser.getEmail();

        rgGender = (RadioGroup)rootView.findViewById(R.id.gender);

        edtFullName = (EditText)rootView.findViewById(R.id.full_name);
        edtCitizen = (EditText)rootView.findViewById(R.id.citizen);
        edtDOB = (EditText)rootView.findViewById(R.id.dob);
        edtIC = (EditText)rootView.findViewById(R.id.ic_no);
        edtHome = (EditText)rootView.findViewById(R.id.home_phone);
        edtMobile = (EditText)rootView.findViewById(R.id.mobile_phone);
        edtIncomeTax = (EditText)rootView.findViewById(R.id.income_tax_no);
        edtPassport = (EditText)rootView.findViewById(R.id.passport);
        edtRegisteredPassport = (EditText)rootView.findViewById(R.id.registered_passport);
        edtBank = (EditText)rootView.findViewById(R.id.bank);
        edtBankAccount = (EditText)rootView.findViewById(R.id.bank_account_no);


        Button save = rootView.findViewById(R.id.btnSave);
        save.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View view) {

        rbGender = ((RadioButton)rootView.findViewById(rgGender.getCheckedRadioButtonId()));
        String full_name = edtFullName.getText().toString();
        String citizen = edtCitizen.getText().toString();
        String gender = rbGender.getText().toString();
        String dob = edtDOB.getText().toString();
        String home = edtHome.getText().toString();
        String mobile = edtMobile.getText().toString();
        String ic = edtIC.getText().toString();
        String incomeTax = edtIncomeTax.getText().toString();
        String passport = edtPassport.getText().toString();
        String registeredPassport = edtRegisteredPassport.getText().toString();
        String bank = edtBank.getText().toString();
        String bankAccount = edtBankAccount.getText().toString();

        if (TextUtils.isEmpty(full_name))
            edtFullName.setError(getString(R.string.error_field_required));
        else if(TextUtils.isEmpty(citizen))
            edtCitizen.setError(getString(R.string.error_field_required));
        else if(TextUtils.isEmpty(dob))
            edtDOB.setError(getString(R.string.error_field_required));
        else {
            User user = new User(email, full_name, citizen, gender, dob, home, mobile, ic, incomeTax, passport, registeredPassport, bank, bankAccount);
            mDatabase.child("Users").child(EncodeString(email)).setValue(user);
        }
    }

    public static String EncodeString(String string) {
        return string.replace(".", ",");
    }

    public static String DecodeString(String string) {
        return string.replace(",", ".");
    }



}
