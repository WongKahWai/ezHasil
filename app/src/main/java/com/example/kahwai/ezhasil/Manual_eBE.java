package com.example.kahwai.ezhasil;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.google.firebase.database.DatabaseReference;

public class Manual_eBE extends AppCompatActivity {

    private DatabaseReference mDatabase;
    ExpandableRelativeLayout expandableLayout1, expandableLayout2, expandableLayout3, expandableLayout4, expandableLayout5, expandableLayout6,expandableLayout8;
    private Button btnSubmit;
    private EditText a5,b1,b2,b3,b5,b7,b13a,b13b,b13c,b15a,b15b,b18,c1,c2,c3,c4,d5,e1a,e1b,e1c,e2a,e2b,e2c;
    private EditText f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15a_num,f15b_num,f15c_num,f15d_num,f15e_num,f16,f17,f18,f19,g1,g2,g3;
    private RadioGroup a4,a6,d6a,d6b,f15_e;
    private RadioButton rb_a4,rb_a6,rb_d6a,rb_d6b;
    private double eligibility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_manual_e_be);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar_layout);
        View view = getSupportActionBar().getCustomView();

            a4 =(RadioGroup) findViewById(R.id.a4);
            a5 = (EditText) findViewById(R.id.a5);
            a6 =(RadioGroup) findViewById(R.id.a6);

            b1 = (EditText) findViewById(R.id.b1);
            b2 = (EditText) findViewById(R.id.b2);
            b3 = (EditText) findViewById(R.id.b3);
            b5 = (EditText) findViewById(R.id.b5);
            b7 = (EditText) findViewById(R.id.b7);
            b13a = (EditText) findViewById(R.id.b13a);
            b13b = (EditText) findViewById(R.id.b13b);
            b13c = (EditText) findViewById(R.id.b13c);
            b15a = (EditText) findViewById(R.id.b15a);
            b15b = (EditText) findViewById(R.id.b15b);
            b18 = (EditText) findViewById(R.id.b18);

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

            int intb1,intb2,intb3,intb5,intb7,intb13a,intb13b,intb13c;
            int intf1=9000,intf2,intf3,intf4,intf5,intf6,intf7,intf8,intf9,intf10,intf11,intf12,intf13,intf14,intf15a_num,intf15b_num,intf15c_num,intf15d_num,intf15e_num,intf16,intf17,intf18,intf19,intf20;
            int intb4,intb6,intb8,intb9,intb10;
            double intb15a,intb15b;
            double intb13,intb15,intb18;
            double intf15a_total,intf15b_total,intf15c_total,intf15d_total,intf15e_total;
            int intf15a,intf15b,intf15c;
            double intb11a_1,intb11b_1,intb11b_2;
            double intb11a=0,intb11b=0,intb12,intb14,intb16=0,intb17,intb19;
            String stra5,strc1,strc2,strc3,strc4,strd5,stre1a,stre1b,stre1c,stre2a,stre2b,stre2c,strg1,strg2,strg3,stra4,stra6,strd6a,strd6b;
            @Override
            public void onClick(View v) {
                rb_a4= ((RadioButton) findViewById(a4.getCheckedRadioButtonId()));
                rb_a6= ((RadioButton) findViewById(a6.getCheckedRadioButtonId()));
                rb_d6a= ((RadioButton) findViewById(d6a.getCheckedRadioButtonId()));
                rb_d6b= ((RadioButton) findViewById(d6b.getCheckedRadioButtonId()));

                stra5 = a5.getText().toString();
                strc1 = c1.getText().toString();
                strc2 = c2.getText().toString();
                strc3 = c3.getText().toString();
                strc4 = c4.getText().toString();
                strd5 = d5.getText().toString();
                stre1a = e1a.getText().toString();
                stre1b = e1b.getText().toString();
                stre1c = e1c.getText().toString();
                stre2a = e2a.getText().toString();
                stre2b = e2b.getText().toString();
                stre2c = e2c.getText().toString();
                strg1 = g1.getText().toString();
                strg2 = g2.getText().toString();
                strg3 = g3.getText().toString();
                stra4 = rb_a4.getText().toString();
                stra6 = rb_a6.getText().toString();
                strd6a = rb_d6a.getText().toString();
                strd6b = rb_d6b.getText().toString();



                if(stra4.equals("Single")){
                    stra4 = "1";
                }
                else if(stra4.equals("Married")){
                    stra4 = "2";
                }
                else if(stra4.equals("Divorce/Widow/Widower")){
                    stra4 = "3";
                }
                else if(stra4.equals("Deceased")){
                    stra4 = "4";
                }
                else{
                    stra4 = "";
                }


                if(stra6.equals("Joint in the name of husband")){
                    stra6 = "1";
                }
                else if(stra6.equals("Joint in the name of wife")){
                    stra6 = "2";
                }
                else if(stra6.equals("Separate")){
                    stra6 = "3";
                }
                else if(stra6.equals("Self whose spouse has no income or no source of income/ has tax exempt income")){
                    stra6 = "4";
                }
                else if(stra6.equals("Self (Single/Divorcee/Widow/Widower/Deceased)")){
                    stra6 = "5";
                }
                else{
                    stra6 = "";
                }


                if(strd6a.equals("Yes")){
                    strd6a = "1";
                }
                else if(strd6a.equals("No")){
                    strd6a = "2";
                }
                else{
                    strd6a = "";
                }


                if(strd6b.equals("Yes")){
                    strd6b = "1";
                }
                else if(strd6b.equals("No")){
                    strd6b = "2";
                }
                else{
                    strd6b = "";
                }

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
                if(b13a.getText().toString().matches("")){
                    intb13a=0;
                }else{
                    intb13a = Integer.parseInt(b13a.getText().toString());
                }
                if(b13b.getText().toString().matches("")){
                    intb13b=0;
                }else{
                    intb13b = Integer.parseInt(b13b.getText().toString());
                }
                if(b13c.getText().toString().matches("")){
                    intb13c=0;
                }else{
                    intb13c = Integer.parseInt(b13c.getText().toString());
                }
                if(b15a.getText().toString().matches("")){
                    intb15a=0;
                }else{
                    intb15a = Double.parseDouble(b15a.getText().toString());

                }
                if(b15b.getText().toString().matches("")){
                    intb15b=0;
                }else{
                    intb15b = Double.parseDouble(b15b.getText().toString());
                }
                if(b18.getText().toString().matches("")){
                    intb18=0;
                }else{
                    intb18 = Double.parseDouble(b18.getText().toString());
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
                intb13 = intb13a+intb13b+intb13c;
                intb15 = intb15a+intb15b;
                if(intb6<0){
                    intb6=0;
                }

                intb9=calcF();

                intb8=intb6+intb7;

                intb10=intb8-intb9;
                if(intb10<0){
                    intb10=0;
                }



                //calculation



                if(intb10<=5000){
                    intb11a_1=0;                    //tax on the first
                    intb11a=0;                      //charge tax on the first
                    intb11b_1=intb10-0;             //calculate tax on the balance
                    intb11b_2=0;                    //tax on the balance rate
                    intb11b=intb11b_1*intb11b_2;    //charge tax on the balance

                }
                else if(intb10>5000&&intb10<=20000){
                    intb11a_1=5000;                 //tax on the first
                    intb11a=0;                      //charge tax on the first
                    intb11b_1=intb10-5000;          //calculate tax on the balance
                    intb11b_2=0.01;                 //tax on the balance rate
                    intb11b=intb11b_1*intb11b_2;    //charge tax on the balance
                }
                else if(intb10>20000&&intb10<=35000){
                    intb11a_1=20000;                 //tax on the first
                    intb11a=150;                      //charge tax on the first
                    intb11b_1=intb10-20000;          //calculate tax on the balance
                    intb11b_2=0.05;                 //tax on the balance rate
                    intb11b=intb11b_1*intb11b_2;    //charge tax on the balance
                }
                else if(intb10>35000&&intb10<=50000){
                    intb11a_1=35000;                 //tax on the first
                    intb11a=900;                      //charge tax on the first
                    intb11b_1=intb10-35000;          //calculate tax on the balance
                    intb11b_2=0.1;                 //tax on the balance rate
                    intb11b=intb11b_1*intb11b_2;    //charge tax on the balance
                }
                else if(intb10>50000&&intb10<=70000){
                    intb11a_1=50000;                 //tax on the first
                    intb11a=2400;                      //charge tax on the first
                    intb11b_1=intb10-50000;          //calculate tax on the balance
                    intb11b_2=0.16;                 //tax on the balance rate
                    intb11b=intb11b_1*intb11b_2;    //charge tax on the balance
                }
                else if(intb10>70000&&intb10<=100000){
                    intb11a_1=70000;                 //tax on the first
                    intb11a=5600;                      //charge tax on the first
                    intb11b_1=intb10-70000;          //calculate tax on the balance
                    intb11b_2=0.21;                 //tax on the balance rate
                    intb11b=intb11b_1*intb11b_2;    //charge tax on the balance
                }
                else if(intb10>100000&&intb10<=250000){
                    intb11a_1=100000;                 //tax on the first
                    intb11a=11900;                      //charge tax on the first
                    intb11b_1=intb10-100000;          //calculate tax on the balance
                    intb11b_2=0.24;                 //tax on the balance rate
                    intb11b=intb11b_1*intb11b_2;    //charge tax on the balance
                }
                else if(intb10>250000&&intb10<=400000){
                    intb11a_1=250000;                 //tax on the first
                    intb11a=47900;                      //charge tax on the first
                    intb11b_1=intb10-250000;          //calculate tax on the balance
                    intb11b_2=0.245;                 //tax on the balance rate
                    intb11b=intb11b_1*intb11b_2;    //charge tax on the balance
                }
                else if(intb10>400000&&intb10<=600000){
                    intb11a_1=400000;                 //tax on the first
                    intb11a=84650;                      //charge tax on the first
                    intb11b_1=intb10-400000;          //calculate tax on the balance
                    intb11b_2=0.25;                 //tax on the balance rate
                    intb11b=intb11b_1*intb11b_2;    //charge tax on the balance
                }
                else if(intb10>600000&&intb10<=1000000){
                    intb11a_1=600000;                 //tax on the first
                    intb11a=134650;                      //charge tax on the first
                    intb11b_1=intb10-600000;          //calculate tax on the balance
                    intb11b_2=0.26;                 //tax on the balance rate
                    intb11b=intb11b_1*intb11b_2;    //charge tax on the balance
                }
                else if(intb10>1000000){
                    intb11a_1=1000000;                 //tax on the first
                    intb11a=238650;                      //charge tax on the first
                    intb11b_1=intb10-1000000;          //calculate tax on the balance
                    intb11b_2=0.28;                 //tax on the balance rate
                    intb11b=intb11b_1*intb11b_2;    //charge tax on the balance
                }

                intb12 = intb11a+intb11b;
                intb14 = intb12 - intb13;
                if(intb14>intb15) {
                    intb16 = intb14 - intb15;
                    intb17 = 0;
                }
                else if(intb15>intb14){
                    intb17 = intb15 - intb14;
                    intb16 = 0;
                }
                if(intb16>intb18){
                    intb19 = intb16-intb18;
                }
                else{
                    intb19 = intb18-intb16;
                }
                IncomeTax it = new IncomeTax(intb1, intb2, intb3, intb5, intb7, intb13a, intb13b, intb13c, intf1, intf2, intf3, intf4, intf5, intf6, intf7, intf8, intf9, intf10, intf11, intf12, intf13,  intf14, intf15a_num, intf15b_num, intf15c_num, intf15d_num,  intf15e_num, intf16, intf17, intf18, intf19, intf20, intb4, intb6, intb8, intb9, intb10, intb15a, intb15b, intb13, intb15, intb18, intf15a_total, intf15b_total, intf15c_total, intf15d_total, intf15e_total, intf15a,intf15b,  intf15c,  intb11a_1, intb11b_1,  intb11b_2,  intb11a,  intb11b,  intb12,  intb14,  intb16,  intb17, intb19, stra5, strc1, strc2, strc3,  strc4, strd5, stre1a,  stre1b, stre1c,stre2a, stre2b, stre2c,strg1,  strg2,  strg3, stra4,  stra6,  strd6a, strd6b);

                mDatabase.child("Users").child("Testing").setValue(it);
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

                intf20=intf1+intf2+intf3+intf4+intf5+intf6+intf7+intf8+intf9+intf10+intf11+intf12+intf13+intf14+intf15a+intf15b+intf15c+intf16+intf17+intf18+intf19;


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
