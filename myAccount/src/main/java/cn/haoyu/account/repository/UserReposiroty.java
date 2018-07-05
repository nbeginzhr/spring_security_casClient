package cn.haoyu.account.repository;

import cn.haoyu.account.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by haoyu on 2018/6/14.
 */
@Repository
public interface UserReposiroty extends JpaRepository<User,String>{

    User findByUsername(String username);

    User findByHid(String hid);

}
