package com.example.demo.web;


import com.example.demo.domain.User;
import com.example.demo.domain.Vote;
import com.example.demo.domain.VotePer;
import com.example.demo.domain.VoteSome;
import com.example.demo.service.UserService;
import com.example.demo.service.VotePerService;
import com.example.demo.service.VoteService;
import com.example.demo.service.VoteSomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("my")
public class MyController {


    @Autowired
    private UserService userService = null;

    @Autowired
    private VoteService voteService = null;

    @Autowired
    private VoteSomeService voteSomeService = null;

    @Autowired
    private VotePerService votePerService = null;

    @RequestMapping("/getUser")
    public User getUser(long id){

       return userService.getUser(id);
    }
    @PostMapping("/login")
    public User login(@RequestParam("name") String name,@RequestParam("pass") String pass, Model model) throws NoSuchAlgorithmException {

        System.out.println(name);

        System.out.println(pass);

        User user = userService.login(name,pass);

        System.out.println(user+"----------->");

        if(user!=null){
            model.addAttribute("user",user);
        }

        return user;
    }


    /*
    @v 建立投票项目
    @return 无
     */
    @PostMapping("/insert")
    public int Insert(@RequestParam("votename") String vote_name,
                      @RequestParam("allperson") int all_person,
                      @RequestParam("endtime") Timestamp endtime,

                      @RequestParam("voteleve") int vote_leve,
                      @RequestParam("vote_name") String[] vote_names
                      //@SessionAttribute("user_id") int user_id
                      ){
        Date date  = new Date();

        Timestamp begintime = new Timestamp(date.getTime());

        Vote v =  new Vote(vote_name,1,all_person,endtime,begintime,vote_leve);

        //建立投票项目后，插入每个的投票项目
        //从数据库的vote表返回插入的主键id


          int i = voteService.Insert(v);

          System.out.println("****"+v.getId());

          System.out.println("----->"+i);

          //拿到vote返回的主键Id代表一个对应的投票表单
        //拿这个id继续往vote_some写入,投票项目

        //遍历数组
        for(String s:vote_names){

            VoteSome voteSome = new VoteSome();
            voteSome.setVote_name(s);
            voteSome.setVote_num(0);
            voteSome.setVote_by(v.getId());
            int b = voteSomeService.Insert(voteSome);
            if(b!=1){

                //最好封装一个返回的服务器对象
                return 400;
            }

        }

        //完成上面的变相插入了2个表，这个流程差不多结束了


          //遍历数组，把每一个的表单项目名插入vote_some表中

           if(i==1) {

               return 200;
           }else{

               return 400;
           }


    }

    @RequestMapping("/votePage")
    public List<Vote> itemPage(@RequestParam("currentPage") String currentPage,@RequestParam("pageSize") String pageSize){

            int cu = Integer.valueOf(currentPage);
            int page = Integer.valueOf(pageSize);

            return voteService.findItemByPage(cu,page);
    }

    /*
     通过Id查询投票情况,返回应该包含很多信息
     显示在投票页面，并在前端做业务逻辑
     */
    @RequestMapping("/votesome")
    public List<VoteSome> itemVoteSome(int id){


            return voteSomeService.selectbyId(id);
    }

    /*
    投票传递多来的投票项目，进行加1,记录每个投票用户的记录
    点击进行加1
     */
    @RequestMapping("/vote")
    public int vote(@RequestParam("id") int[] id){

        Date date = new Date();
        Timestamp q = new Timestamp(date.getTime());

        for(int vona_id:id){

            VotePer per = new VotePer();
            per.setIp("127.0.0.1");
            per.setUser_id(1);
            per.setVona_id(vona_id);
            per.setVote_time(q);
            System.out.println(123);

            int i =   votePerService.insert(per);
            if(i!=1){

                return 400;
            }
           int m =  voteSomeService.update(vona_id);

            if(m!=1){

                return 400;
            }
        }




            return 200;

    }




}
