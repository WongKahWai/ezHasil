package com.example.kahwai.ezhasil;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

public class Manual_eBE extends AppCompatActivity {

    ExpandableRelativeLayout expandableLayout1, expandableLayout2, expandableLayout3, expandableLayout4, expandableLayout5, expandableLayout6,expandableLayout8;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_manual_e_be);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar_layout);
        View view = getSupportActionBar().getCustomView();

            RadioGroup a4 =(RadioGroup) findViewById(R.id.a4);
            EditText a5 = (EditText) findViewById(R.id.a5);
            RadioGroup a6 =(RadioGroup) findViewById(R.id.a6);

            EditText b1 = (EditText) findViewById(R.id.b1);
            EditText b2 = (EditText) findViewById(R.id.b2);
            EditText b4 = (EditText) findViewById(R.id.b4);
            EditText b5 = (EditText) findViewById(R.id.b5);
            EditText b7 = (EditText) findViewById(R.id.b7);

            EditText c1 = (EditText) findViewById(R.id.c1);
            EditText c2 = (EditText) findViewById(R.id.c2);
            EditText c3 = (EditText) findViewById(R.id.c3);
            EditText c4 = (EditText) findViewById(R.id.c4);

            EditText d5 = (EditText) findViewById(R.id.d5);
            RadioGroup d6a =(RadioGroup) findViewById(R.id.d6a);
            final RadioGroup d6b = (RadioGroup) findViewById(R.id.d6b);

            EditText e1a = (EditText) findViewById(R.id.e1a);
            EditText e1b = (EditText) findViewById(R.id.e1b);
            EditText e1c = (EditText) findViewById(R.id.e1c);
            EditText e2a = (EditText) findViewById(R.id.e2a);
            EditText e2b = (EditText) findViewById(R.id.e2b);
            EditText e2c = (EditText) findViewById(R.id.e2c);


            EditText f2 = (EditText) findViewById(R.id.f2);
            EditText f3 = (EditText) findViewById(R.id.f3);
            EditText f4 = (EditText) findViewById(R.id.f4);
            EditText f5 = (EditText) findViewById(R.id.f5);
            EditText f6 = (EditText) findViewById(R.id.f6);
            EditText f7 = (EditText) findViewById(R.id.f7);
            EditText f8 = (EditText) findViewById(R.id.f8);
            EditText f9 = (EditText) findViewById(R.id.f9);
            EditText f10 = (EditText) findViewById(R.id.f10);
            EditText f11 = (EditText) findViewById(R.id.f11);
            EditText f12 = (EditText) findViewById(R.id.f12);
            EditText f13 = (EditText) findViewById(R.id.f13);
            EditText f14 = (EditText) findViewById(R.id.f14);
            EditText f15a_num = (EditText) findViewById(R.id.f15a_num);
            EditText f15b_num = (EditText) findViewById(R.id.f15b_num);
            EditText f15c_num = (EditText) findViewById(R.id.f15c_num);
            EditText f15d_num = (EditText) findViewById(R.id.f15d_num);
            EditText f15e_num = (EditText) findViewById(R.id.f15e_num);
            RadioGroup f15_e = (RadioGroup) findViewById(R.id.f15_e);
            EditText f16 = (EditText) findViewById(R.id.f16);
            EditText f17 = (EditText) findViewById(R.id.f17);
            EditText f18 = (EditText) findViewById(R.id.f18);
            EditText f19 = (EditText) findViewById(R.id.f19);

            EditText g1 = (EditText) findViewById(R.id.g1);
            EditText g2 = (EditText) findViewById(R.id.g2);
            EditText g3 = (EditText) findViewById(R.id.g3);


            d6b.setVisibility(View.INVISIBLE);
            d6a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    if(checkedId==(R.id.d6a_1))
                    {
                        d6b.setVisibility(View.VISIBLE);

                    }
                    else if(checkedId==R.id.d6a_2)
                    {

                        d6b.setVisibility(View.INVISIBLE);
                    }
                }
            });



    }

    public void expandableButton1(View view) {
        expandableLayout1 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout1);
        expandableLayout1.toggle(); // toggle expand and collapse
    }

    public void expandableButton2(View view) {
        expandableLayout2 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout2);
        expandableLayout2.toggle(); // toggle expand and collapse
    }

    public void expandableButton3(View view) {
        expandableLayout3 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout3);
        expandableLayout3.toggle(); // toggle expand and collapse
    }

    public void expandableButton4(View view) {
        expandableLayout4 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout4);
        expandableLayout4.toggle(); // toggle expand and collapse
    }
    public void expandableButton5(View view) {
        expandableLayout5 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout5);
        expandableLayout5.toggle(); // toggle expand and collapse
    }
    public void expandableButton6(View view) {
        expandableLayout6 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout6);
        expandableLayout6.toggle(); // toggle expand and collapse
    }

    public void expandableButton8(View view) {
        expandableLayout8 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout8);
        expandableLayout8.toggle(); // toggle expand and collapse
    }


}
