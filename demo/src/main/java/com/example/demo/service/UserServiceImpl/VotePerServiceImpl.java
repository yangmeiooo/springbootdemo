package com.example.demo.service.UserServiceImpl;

import com.example.demo.dao.VotePerDao;
import com.example.demo.domain.VotePer;
import com.example.demo.service.VotePerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotePerServiceImpl implements VotePerService {

    @Autowired
    private VotePerDao votePerDao = null;

    @Override
    public int insert(VotePer p) {

        return  votePerDao.insertperon(p);
    }
}
