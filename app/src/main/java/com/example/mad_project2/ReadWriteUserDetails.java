package com.example.mad_project2;

public class ReadWriteUserDetails {

    String main_name,main_email,main_password,main_cf_password;
    public ReadWriteUserDetails(String name,String email,String password , String cf_password){
        this.main_name=name;
        this.main_email = email;
        this.main_password = password;
        this.main_cf_password = cf_password;
    }
}
