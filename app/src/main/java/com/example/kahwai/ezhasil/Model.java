package com.example.kahwai.ezhasil;

/**
 * Created by kahwai on 12/01/2018.
 */

public class Model {

    String status,submit_status;
    int value; /* 0 -&gt; checkbox disable, 1 -&gt; checkbox enable */

    Model(String status, int value){
        this.status = status;
        this.value = value;
    }

    public String getSubmit_status() {
        return submit_status;
    }

    public void setSubmit_status(String submit_status) {
        this.submit_status = submit_status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getStatus(){
        return this.status;
    }
    public int getValue(){
        return this.value;
    }
}
