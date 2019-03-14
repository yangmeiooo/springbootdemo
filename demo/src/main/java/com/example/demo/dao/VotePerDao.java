package com.example.demo.dao;


import com.example.demo.domain.VotePer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VotePerDao {

    public int insertperon(VotePer p);

}
