package com.example.demo.service;

import com.example.demo.domain.Vote;

import java.util.List;

public interface VoteService {

    public int Insert(Vote v);

    public List<Vote> findItemByPage(int currentPage, int pageSize);

}
