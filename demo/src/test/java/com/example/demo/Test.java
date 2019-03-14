package com.example.demo;

import java.sql.Timestamp;

public class Test {

    public static void main(String[] args){

        String time = "1997-01-12 08:15:00";

        Timestamp SQL = Timestamp.valueOf(time);

        System.out.println(SQL);

    }

}
