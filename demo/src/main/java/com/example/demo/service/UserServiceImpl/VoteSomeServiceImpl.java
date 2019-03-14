package com.example.demo.service.UserServiceImpl;

import com.example.demo.dao.VoteSomeDao;
import com.example.demo.domain.VoteSome;
import com.example.demo.service.VoteSomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteSomeServiceImpl implements VoteSomeService {

    @Autowired
    private VoteSomeDao voteSomeDao = null;

    @Override
    public int Insert(VoteSome v) {

        int i =   voteSomeDao.InsertSome(v);

        return i;
    }

    @Override
    public List<VoteSome> selectbyId(int id) {
        return voteSomeDao.selectByid(id);
    }

    @Override
    public int update(int id) {

         int i = voteSomeDao.updateone(id);
        return i;
    }
}
