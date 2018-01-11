package com.example.kahwai.ezhasil;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;


public class FragmentViewProfile extends Fragment {
    public FragmentViewProfile() { }

    private DatabaseReference mDatabase;
    private View rootView;

    //private TextView

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_view_profile, container, false);


        return rootView;
    }

}
