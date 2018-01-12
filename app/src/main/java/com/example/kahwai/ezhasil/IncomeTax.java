package com.example.kahwai.ezhasil;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by user on 11/1/2018.
 */

public class IncomeTax {
    int intb1,intb2,intb3,intb5,intb7,intb13a,intb13b,intb13c;
    int intf1,intf2,intf3,intf4,intf5,intf6,intf7,intf8,intf9,intf10,intf11,intf12,intf13,intf14,intf15a_num,intf15b_num,intf15c_num,intf15d_num,intf15e_num,intf16,intf17,intf18,intf19,intf20;
    int intb4,intb6,intb8,intb9,intb10;
    double intb15a,intb15b;
    double intb13,intb15,intb18;
    double intf15a_total,intf15b_total,intf15c_total,intf15d_total,intf15e_total;
    int intf15a,intf15b,intf15c;
    int  intf2b_iia, intf2b_ia, intf2b_b,intf2b_ic,intf2b_iic,intf2a;
    double intb11a_1,intb11b_1,intb11b_2;
    double intb11a,intb11b,intb12,intb14,intb16=0,intb17,intb19;
    String stra5,strc1,strc2,strc3,strc4,strd5,stre1a,stre1b,stre1c,stre2a,stre2b,stre2c,strg1,strg2,strg3,stra4,stra6,strd6a,strd6b;
    double intf15_eligibility;
    String submit_status,submit_date;
    boolean refundable;

    public IncomeTax() {
    }

    public String getSubmit_status() {
        return submit_status;
    }

    public void setSubmit_status(String submit_status) {
        this.submit_status = submit_status;
    }

    public String getSubmit_date() {
        return submit_date;
    }

    public void setSubmit_date(String submit_date) {
        this.submit_date = submit_date;
    }

    public int getIntb1() {
        return intb1;
    }

    public int getIntb2() {
        return intb2;
    }

    public int getIntb3() {
        return intb3;
    }

    public int getIntb5() {
        return intb5;
    }

    public int getIntb7() {
        return intb7;
    }

    public int getIntb13a() {
        return intb13a;
    }

    public int getIntb13b() {
        return intb13b;
    }

    public int getIntb13c() {
        return intb13c;
    }

    public int getIntf1() {
        return intf1;
    }

    public int getIntf2() {
        return intf2;
    }

    public int getIntf3() {
        return intf3;
    }

    public int getIntf4() {
        return intf4;
    }

    public int getIntf5() {
        return intf5;
    }

    public int getIntf6() {
        return intf6;
    }

    public int getIntf7() {
        return intf7;
    }

    public int getIntf8() {
        return intf8;
    }

    public int getIntf9() {
        return intf9;
    }

    public int getIntf10() {
        return intf10;
    }

    public int getIntf11() {
        return intf11;
    }

    public int getIntf12() {
        return intf12;
    }

    public int getIntf13() {
        return intf13;
    }

    public int getIntf14() {
        return intf14;
    }

    public int getIntf15a_num() {
        return intf15a_num;
    }

    public int getIntf15b_num() {
        return intf15b_num;
    }

    public int getIntf15c_num() {
        return intf15c_num;
    }

    public int getIntf15d_num() {
        return intf15d_num;
    }

    public int getIntf15e_num() {
        return intf15e_num;
    }

    public int getIntf16() {
        return intf16;
    }

    public int getIntf17() {
        return intf17;
    }

    public int getIntf18() {
        return intf18;
    }

    public int getIntf19() {
        return intf19;
    }

    public int getIntf20() {
        return intf20;
    }

    public int getIntb4() {
        return intb4;
    }

    public int getIntb6() {
        return intb6;
    }

    public int getIntb8() {
        return intb8;
    }

    public int getIntb9() {
        return intb9;
    }

    public int getIntb10() {
        return intb10;
    }

    public double getIntb15a() {
        return intb15a;
    }

    public double getIntb15b() {
        return intb15b;
    }

    public double getIntb13() {
        return intb13;
    }

    public double getIntb15() {
        return intb15;
    }

    public double getIntb18() {
        return intb18;
    }

    public double getIntf15a_total() {
        return intf15a_total;
    }

    public double getIntf15b_total() {
        return intf15b_total;
    }

    public double getIntf15c_total() {
        return intf15c_total;
    }

    public double getIntf15d_total() {
        return intf15d_total;
    }

    public double getIntf15e_total() {
        return intf15e_total;
    }

    public int getIntf15a() {
        return intf15a;
    }

    public int getIntf15b() {
        return intf15b;
    }

    public int getIntf15c() {
        return intf15c;
    }

    public double getIntb11a_1() {
        return intb11a_1;
    }

    public double getIntb11b_1() {
        return intb11b_1;
    }

    public double getIntb11b_2() {
        return intb11b_2*100;
    }

    public double getIntb11a() {
        return intb11a;
    }

    public double getIntb11b() {
        return intb11b;
    }

    public double getIntb12() {
        return intb12;
    }

    public double getIntb14() {
        return intb14;
    }

    public double getIntb16() {
        return intb16;
    }

    public double getIntb17() {
        return intb17;
    }

    public double getIntb19() {
        return intb19;
    }

    public String getStra5() {
        return stra5;
    }

    public String getStrc1() {
        return strc1;
    }

    public String getStrc2() {
        return strc2;
    }

    public String getStrc3() {
        return strc3;
    }

    public String getStrc4() {
        return strc4;
    }

    public String getStrd5() {
        return strd5;
    }

    public String getStre1a() {
        return stre1a;
    }

    public String getStre1b() {
        return stre1b;
    }

    public String getStre1c() {
        return stre1c;
    }

    public String getStre2a() {
        return stre2a;
    }

    public String getStre2b() {
        return stre2b;
    }

    public String getStre2c() {
        return stre2c;
    }

    public String getStrg1() {
        return strg1;
    }

    public String getStrg2() {
        return strg2;
    }

    public String getStrg3() {
        return strg3;
    }

    public String getStra4() {
        return stra4;
    }

    public String getStra6() {
        return stra6;
    }

    public int getIntf2b_iia() {
        return intf2b_iia;
    }

    public int getIntf2b_ia() {
        return intf2b_ia;
    }

    public int getIntf2b_b() {
        return intf2b_b;
    }

    public int getIntf2b_ic() {
        return intf2b_ic;
    }

    public int getIntf2b_iic() {
        return intf2b_iic;
    }

    public int getIntf2a() {
        return intf2a;
    }

    public String getStrd6a() {
        return strd6a;
    }

    public String getStrd6b() {
        return strd6b;
    }

    public double getIntf15_eligibility() {
        return intf15_eligibility;
    }

    public boolean isRefundable() {
        return refundable;
    }

    public IncomeTax(int intb1, int intb2, int intb3, int intb5, int intb7, int intb13a, int intb13b, int intb13c, int intf1,int intf2a,int intf2b_iia,int intf2b_ia,int intf2b_b,int intf2b_ic,int intf2b_iic ,int intf2, int intf3, int intf4, int intf5, int intf6, int intf7, int intf8, int intf9, int intf10, int intf11, int intf12, int intf13, int intf14, int intf15a_num, int intf15b_num, int intf15c_num, int intf15d_num, int intf15e_num, int intf16, int intf17, int intf18, int intf19, int intf20, int intb4, int intb6, int intb8, int intb9, int intb10, double intb15a, double intb15b, double intb13, double intb15, double intb18, double intf15a_total, double intf15b_total, double intf15c_total, double intf15d_total, double intf15e_total, int intf15a, int intf15b, int intf15c, double intb11a_1, double intb11b_1, double intb11b_2, double intb11a, double intb11b, double intb12, double intb14, double intb16, double intb17, double intb19, String stra5, String strc1, String strc2, String strc3, String strc4, String strd5, String stre1a, String stre1b, String stre1c, String stre2a, String stre2b, String stre2c, String strg1, String strg2, String strg3, String stra4, String stra6, String strd6a, String strd6b, double intf15_eligibility, String submit_status, boolean refundable) {
        this.intb1 = intb1;
        this.intb2 = intb2;
        this.intb3 = intb3;
        this.intb5 = intb5;
        this.intb7 = intb7;
        this.intb13a = intb13a;
        this.intb13b = intb13b;
        this.intb13c = intb13c;
        this.intf1 = intf1;
        this.intf2 = intf2;
        this.intf2a = intf2a;
        this.intf3 = intf3;
        this.intf4 = intf4;
        this.intf5 = intf5;
        this.intf6 = intf6;
        this.intf7 = intf7;
        this.intf8 = intf8;
        this.intf9 = intf9;
        this.intf10 = intf10;
        this.intf11 = intf11;
        this.intf12 = intf12;
        this.intf13 = intf13;
        this.intf14 = intf14;
        this.intf15a_num = intf15a_num;
        this.intf15b_num = intf15b_num;
        this.intf15c_num = intf15c_num;
        this.intf15d_num = intf15d_num;
        this.intf15e_num = intf15e_num;
        this.intf16 = intf16;
        this.intf17 = intf17;
        this.intf18 = intf18;
        this.intf19 = intf19;
        this.intf20 = intf20;
        this.intb4 = intb4;
        this.intb6 = intb6;
        this.intb8 = intb8;
        this.intb9 = intb9;
        this.intb10 = intb10;
        this.intb15a = intb15a;
        this.intb15b = intb15b;
        this.intb13 = intb13;
        this.intb15 = intb15;
        this.intb18 = intb18;
        this.intf15a_total = intf15a_total;
        this.intf15b_total = intf15b_total;
        this.intf15c_total = intf15c_total;
        this.intf15d_total = intf15d_total;
        this.intf15e_total = intf15e_total;
        this.intf15a = intf15a;
        this.intf15b = intf15b;
        this.intf15c = intf15c;
        this.intb11a_1 = intb11a_1;
        this.intb11b_1 = intb11b_1;
        this.intb11b_2 = intb11b_2;
        this.intb11a = intb11a;
        this.intb11b = intb11b;
        this.intb12 = intb12;
        this.intb14 = intb14;
        this.intb16 = intb16;
        this.intb17 = intb17;
        this.intb19 = intb19;
        this.stra5 = stra5;
        this.strc1 = strc1;
        this.strc2 = strc2;
        this.strc3 = strc3;
        this.strc4 = strc4;
        this.strd5 = strd5;
        this.stre1a = stre1a;
        this.stre1b = stre1b;
        this.stre1c = stre1c;
        this.stre2a = stre2a;
        this.stre2b = stre2b;
        this.stre2c = stre2c;
        this.strg1 = strg1;
        this.strg2 = strg2;
        this.strg3 = strg3;
        this.stra4 = stra4;
        this.stra6 = stra6;

        this.strd6a = strd6a;
        this.strd6b = strd6b;
        this.intf15_eligibility = intf15_eligibility;

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = df.format(c.getTime());;

        this.submit_date = formattedDate;
        this.submit_status = submit_status;
        this.refundable = refundable;


        this.intf2b_iia=intf2b_iia;
        this.intf2b_ia=intf2b_ia;
        this.intf2b_b=intf2b_b;
        this.intf2b_ic=intf2b_ic;
        this.intf2b_iic=intf2b_iic;
    }
    public String getSubmitDate() {

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = df.format(c.getTime());;

        this.submit_date = formattedDate;
        return formattedDate;
    }
}
