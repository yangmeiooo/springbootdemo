package com.example.demo.dao;


import com.example.demo.domain.VoteSome;

import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface VoteSomeDao {

    public int InsertSome(VoteSome v);

    public List<VoteSome> selectByid(int id);

    public int updateone(int id);
}
