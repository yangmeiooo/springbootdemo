package com.example.demo.domain;


import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@Alias(value = "voteper")
public class VotePer {

    private int id;

    private String ip;

    private int user_id;

    private int vona_id;

    private Timestamp vote_time;


    public VotePer(){


    }

    public VotePer(int id,String ip,int user_id,int vona_id,Timestamp vote_time){
        this.id = id;
        this.ip = ip;
        this.user_id = user_id;
        this.vona_id = vona_id;
        this.vote_time = vote_time;

    }

}
