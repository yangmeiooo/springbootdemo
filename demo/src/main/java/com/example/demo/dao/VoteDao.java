package com.example.demo.dao;

import com.example.demo.domain.Vote;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VoteDao {

    public int InsertVote( Vote v);

    public List<Vote> findAll();

    public int countItem();

}
