package cn.haoyu.account.manage;

import cn.haoyu.account.entity.User;
import cn.haoyu.account.repository.UserReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by haoyu on 2018/6/14.
 */
@Component("usersBiz")
public class UserBiz {

    @Autowired
    private UserReposiroty usersReposiroty;

    public User save(User user){
        return usersReposiroty.save(user);
    }

    public User fetch(String hid){
        return usersReposiroty.findOne(hid);
    }

    public User findByUserName(String username){
        return usersReposiroty.findByUsername(username);
    }

    public User findByUserHid(String hid){
        return usersReposiroty.findByHid(hid);
    }

}
