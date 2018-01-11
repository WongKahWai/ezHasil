package com.example.kahwai.ezhasil;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SuccessFillingFragment extends Fragment {

    public SuccessFillingFragment() {
        // Required empty public constructor
    }

    public static SuccessFillingFragment newInstance(){
        SuccessFillingFragment fragment = new SuccessFillingFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_success_filling, container, false);
    }

}
