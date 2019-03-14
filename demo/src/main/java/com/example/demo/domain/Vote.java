package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Setter
@Getter
@Alias(value = "vote")
public class Vote {

    private int id;

    private String vote_name;

    private int user_id;

    private int all_person;

    private Timestamp endtime;

    private Timestamp begintime;

    private int vote_leve;

    private List<VoteSome> voteSomeList;


    public Vote()
    { }
    public Vote(String vote_name,int user_id,int all_person,Timestamp endtime,Timestamp begintime,int vote_leve){

        this.vote_name = vote_name;
        this.user_id = user_id;
        this.all_person = all_person;
        this.endtime = endtime;
        this.begintime = begintime;
        this.vote_leve = vote_leve;


    }
}
