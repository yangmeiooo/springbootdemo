package com.example.demo.config;

import org.springframework.context.annotation.Configuration;

import javax.xml.bind.SchemaOutputResolver;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@Configuration
public class MyMd5Util {



    public static String encode(String str) throws NoSuchAlgorithmException {

        String key = "";

        MessageDigest m = MessageDigest.getInstance("md5");

        try{
            byte[] b =  str.getBytes("utf-8");

            m.update(b);

            byte[] keys = m.digest();

            //String strs = new String(keys,"utf-8");

            for(int i=0;i<keys.length;i++){

                int v = keys[i] & 0xFF;
                if(v<16){
                    key+="0";
                }
                key+=Integer.toString(v,16).toUpperCase()+"";


            }






        }catch (Exception e){


            e.printStackTrace();
        }


            return key;
    }

}
