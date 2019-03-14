package com.example.demo.service.UserServiceImpl;

import com.example.demo.config.PageBean;
import com.example.demo.dao.VoteDao;
import com.example.demo.dao.VoteSomeDao;
import com.example.demo.domain.Vote;
import com.example.demo.domain.VoteSome;
import com.example.demo.service.VoteService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteServiceImpl  implements VoteService {

    @Autowired
    private VoteSomeDao voteSomeDao = null;

    @Autowired
    public VoteDao voteDao=null;

    @Override
    public int Insert(Vote v) {

      int i =   voteDao.InsertVote(v);

        return i;
    }

    @Override
    public List<Vote> findItemByPage(int currentPage, int pageSize) {

        PageHelper.startPage(currentPage, pageSize);

        List<Vote> allItems = voteDao.findAll();
        int countNums = voteDao.countItem();
        for(Vote vote:allItems){

            int id = vote.getId();

            List<VoteSome> someList = voteSomeDao.selectByid(id);

            vote.setVoteSomeList(someList);
        }
        PageBean<Vote> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allItems);


        return pageData.getItems();
    }
}
