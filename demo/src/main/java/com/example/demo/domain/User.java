package com.example.demo.domain;

import org.apache.ibatis.type.Alias;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.print.DocFlavor;
import java.sql.Timestamp;
import java.util.Date;

@Alias(value = "user")
public class User {

    private int user_id;

    private String user_name;

    private String user_pass;

    private String user_salt;

    private String user_email;

    private Timestamp user_date;

    private int user_level;

    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_salt(String user_salt) {
        this.user_salt = user_salt;
    }


    public String getUser_salt(){

        return user_salt;
    }
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public Timestamp getUser_date() {
        return user_date;
    }

    public void setUser_date(Timestamp user_date) {
        this.user_date = user_date;
    }

    public int getUser_level() {
        return user_level;
    }

    public void setUser_level(int user_level) {
        this.user_level = user_level;
    }
    public User(){
    }
    public User(int user_id,String user_name,String user_pass,String user_email,Timestamp user_date,int user_level,String user_salt,String path){
        this.user_id =user_id;
        this.user_name = user_name;
        this.user_pass = user_pass;
        this.user_salt = user_salt;
        this.user_email = user_email;
        this.user_date = user_date;
        this.user_level= user_level;
        this.path = path;

    }
}
