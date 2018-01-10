package com.example.kahwai.ezhasil;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

public class Manual_eBE extends AppCompatActivity {

    ExpandableRelativeLayout expandableLayout1, expandableLayout2, expandableLayout3, expandableLayout4, expandableLayout5, expandableLayout6,expandableLayout8;
    private Button btnSubmit;
    private EditText a5,b1,b2,b3,b5,b7,c1,c2,c3,c4,d5,e1a,e1b,e1c,e2a,e2b,e2c,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15a_num,f15b_num,f15c_num,f15d_num,f15e_num,f16,f17,f18,f19,g1,g2,g3;
    private RadioGroup a4,a6,d6a,d6b,f15_e;
    private double eligibility;

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

            b1 = (EditText) findViewById(R.id.b1);
            b2 = (EditText) findViewById(R.id.b2);
            b3 = (EditText) findViewById(R.id.b3);
            b5 = (EditText) findViewById(R.id.b5);
            b7 = (EditText) findViewById(R.id.b7);

            c1 = (EditText) findViewById(R.id.c1);
            c2 = (EditText) findViewById(R.id.c2);
            c3 = (EditText) findViewById(R.id.c3);
            c4 = (EditText) findViewById(R.id.c4);

            d5 = (EditText) findViewById(R.id.d5);
            d6a =(RadioGroup) findViewById(R.id.d6a);
            d6b = (RadioGroup) findViewById(R.id.d6b);

            e1a = (EditText) findViewById(R.id.e1a);
            e1b = (EditText) findViewById(R.id.e1b);
            e1c = (EditText) findViewById(R.id.e1c);
            e2a = (EditText) findViewById(R.id.e2a);
            e2b = (EditText) findViewById(R.id.e2b);
            e2c = (EditText) findViewById(R.id.e2c);

            f2 = (EditText) findViewById(R.id.f2);
            f3 = (EditText) findViewById(R.id.f3);
            f4 = (EditText) findViewById(R.id.f4);
            f5 = (EditText) findViewById(R.id.f5);
            f6 = (EditText) findViewById(R.id.f6);
            f7 = (EditText) findViewById(R.id.f7);
            f8 = (EditText) findViewById(R.id.f8);
            f9 = (EditText) findViewById(R.id.f9);
            f10 = (EditText) findViewById(R.id.f10);
            f11 = (EditText) findViewById(R.id.f11);
            f12 = (EditText) findViewById(R.id.f12);
            f13 = (EditText) findViewById(R.id.f13);
            f14 = (EditText) findViewById(R.id.f14);
            f15a_num = (EditText) findViewById(R.id.f15a_num);
            f15b_num = (EditText) findViewById(R.id.f15b_num);
            f15c_num = (EditText) findViewById(R.id.f15c_num);
            f15d_num = (EditText) findViewById(R.id.f15d_num);
            f15e_num = (EditText) findViewById(R.id.f15e_num);
            f15_e = (RadioGroup) findViewById(R.id.f15_e);
            f16 = (EditText) findViewById(R.id.f16);
            f17 = (EditText) findViewById(R.id.f17);
            f18 = (EditText) findViewById(R.id.f18);
            f19 = (EditText) findViewById(R.id.f19);

            g1 = (EditText) findViewById(R.id.g1);
            g2 = (EditText) findViewById(R.id.g2);
            g3 = (EditText) findViewById(R.id.g3);

            btnSubmit = (Button) findViewById(R.id.btnSubmit);




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
            f15_e.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId==(R.id.f15_100))
                {
                    eligibility=1.0;

                }
                else if(checkedId==R.id.f15_50)
                {

                    eligibility=0.5;
                }
            }

        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            int intb1,intb2,intb3,intb5,intb7;
            int intf2,intf3,intf4,intf5,intf6,intf7,intf8,intf9,intf10,intf11,intf12,intf13,intf14,intf15a_num,intf15b_num,intf15c_num,intf15d_num,intf15e_num,intf16,intf17,intf18,intf19,intf20;
            int intb4,intb6,intb8,intb9,intb10;
            double intf15a_total,intf15b_total,intf15c_total,intf15d_total,intf15e_total;
            int intf15a,intf15b,intf15c;
            @Override
            public void onClick(View v) {





                if(b1.getText().toString().matches("")){
                    intb1=0;
                }else{
                    intb1 = Integer.parseInt(b1.getText().toString());
                }

                if(b2.getText().toString().matches("")){
                    intb2=0;
                }else{
                    intb2 = Integer.parseInt(b2.getText().toString());
                }
                if(b3.getText().toString().matches("")){
                    intb3=0;
                }else{
                    intb3 = Integer.parseInt(b3.getText().toString());
                }
                if(b5.getText().toString().matches("")){
                    intb5=0;
                }else{
                    intb5 = Integer.parseInt(b5.getText().toString());
                }
                if(b7.getText().toString().matches("")){
                    intb7=0;
                }else{
                    intb7 = Integer.parseInt(b7.getText().toString());
                }


                if(f2.getText().toString().matches("")){
                    intf2=0;
                }else{
                    intf2 = Integer.parseInt(f2.getText().toString());
                    if(intf2>5000){
                        intf2=5000;
                    }
                }
                if(f3.getText().toString().matches("")){
                    intf3=0;
                }else{
                    intf3 = Integer.parseInt(f3.getText().toString());
                    if(intf3>6000){
                        intf3=6000;
                    }
                }
                if(f4.getText().toString().matches("")){
                    intf4=0;
                }else{
                    intf4 = Integer.parseInt(f4.getText().toString());

                }
                if(f5.getText().toString().matches("")){
                    intf5=0;
                }else{
                    intf5 = Integer.parseInt(f5.getText().toString());
                    if(intf5>7000){
                        intf5=7000;
                    }
                }
                if(f6.getText().toString().matches("")){
                    intf6=0;
                }else{
                    intf6 = Integer.parseInt(f6.getText().toString());
                    if(intf6>6000){
                        intf6=6000;
                    }
                }
                if(f7.getText().toString().matches("")){
                    intf7=0;
                }else{
                    intf7 = Integer.parseInt(f7.getText().toString());
                    if(intf7>500){
                        intf7=500;
                    }
                }
                if(intf7==500&&intf6==6000){
                    intf6=5500;
                }

                if(f8.getText().toString().matches("")){
                    intf8=0;
                }else{
                    intf8 = Integer.parseInt(f8.getText().toString());
                    if(intf8>1000){
                        intf8=1000;
                    }
                }
                if(f9.getText().toString().matches("")){
                    intf9=0;
                }else{
                    intf9 = Integer.parseInt(f9.getText().toString());
                    if(intf9>3000){
                        intf9=3000;
                    }
                }
                if(f10.getText().toString().matches("")){
                    intf10=0;
                }else{
                    intf10 = Integer.parseInt(f10.getText().toString());
                    if(intf10>6000){
                        intf10=6000;
                    }
                }
                if(f11.getText().toString().matches("")){
                    intf11=0;
                }else{
                    intf11 = Integer.parseInt(f11.getText().toString());
                    if(intf11>300){
                        intf11=300;
                    }
                }
                if(f12.getText().toString().matches("")){
                    intf12=0;
                }else{
                    intf12 = Integer.parseInt(f12.getText().toString());
                    if(intf12>10000){
                        intf12=10000;
                    }
                }
                if(f13.getText().toString().matches("")){
                    intf13=0;
                }else{
                    intf13 = Integer.parseInt(f13.getText().toString());
                    if(intf13>4000){
                        intf13=4000;
                    }
                }
                if(f14.getText().toString().matches("")){
                    intf14=0;
                }else{
                    intf14 = Integer.parseInt(f14.getText().toString());

                }
                if(f15a_num.getText().toString().matches("")){
                    intf15a_num=0;
                }else{
                    intf15a_num = Integer.parseInt(f15a_num.getText().toString());
                }
                if(f15b_num.getText().toString().matches("")){
                    intf15b_num=0;
                }else{
                    intf15b_num = Integer.parseInt(f15b_num.getText().toString());
                }
                if(f15c_num.getText().toString().matches("")){
                    intf15c_num=0;
                }else{
                    intf15c_num = Integer.parseInt(f15c_num.getText().toString());
                }
                if(f15d_num.getText().toString().matches("")){
                    intf15d_num=0;
                }else{
                    intf15d_num = Integer.parseInt(f15d_num.getText().toString());
                }
                if(f15e_num.getText().toString().matches("")){
                    intf15e_num=0;
                }else{
                    intf15e_num = Integer.parseInt(f15e_num.getText().toString());
                }
                if(f16.getText().toString().matches("")){
                    intf16=0;
                }else{
                    intf16 = Integer.parseInt(f16.getText().toString());
                    if(intf16>6000){
                        intf16=6000;
                    }
                }
                if(f17.getText().toString().matches("")){
                    intf17=0;
                }else{
                    intf17 = Integer.parseInt(f17.getText().toString());
                    if(intf17>3000){
                        intf17=3000;
                    }
                }
                if(f18.getText().toString().matches("")){
                    intf18=0;
                }else{
                    intf18 = Integer.parseInt(f18.getText().toString());
                    if(intf18>3000){
                        intf18=3000;
                    }
                }
                if(f19.getText().toString().matches("")){
                    intf19=0;
                }else{
                    intf19 = Integer.parseInt(f19.getText().toString());
                    if(intf19>250){
                        intf19=250;
                    }
                }
                //intf20=intb9
                
                intb4 = intb1+intb2+intb3;
                intb6 = intb4-intb5;
                if(intb6<0){
                    intb6=0;
                }

                intb9=calcF();

                intb8=intb6+intb7;

                intb10=intb8-intb9;



            }
            public int calcF(){

                intf15a_total=intf15a_num*2000*eligibility;
                intf15b_total=intf15a_num*2000*eligibility;
                intf15c_total=intf15a_num*8000*eligibility;
                intf15d_total=intf15a_num*6000*eligibility;
                intf15e_total=intf15a_num*14000*eligibility;
                intf15a=(int)intf15a_total;
                intf15b=(int)intf15b_total+(int)intf15c_total;
                intf15c=(int)intf15d_total+(int)intf15e_total;

                intf20=9000+intf2+intf3+intf4+intf5+intf6+intf7+intf8+intf9+intf10+intf11+intf12+intf13+intf14+intf15a+intf15b+intf15c+intf16+intf17+intf18+intf19;


                return intf20;
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
