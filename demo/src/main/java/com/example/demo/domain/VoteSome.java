package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@Alias(value = "votesome")
public class VoteSome {

    private int id;

    private String vote_name;

    private int vote_num;

    private int vote_by;

    public VoteSome(){


    }
    public VoteSome(int id,String vote_name,int vote_num,int vote_by){
        this.id = id;
        this.vote_name = vote_name;
        this.vote_num = vote_num;
        this.vote_by = vote_by;


    }


}
