package com.example.demo.service;

import com.example.demo.domain.VoteSome;

import java.util.List;

public interface VoteSomeService {

    public int Insert(VoteSome v);

    public List<VoteSome> selectbyId(int id);

    public int update(int id);

}
