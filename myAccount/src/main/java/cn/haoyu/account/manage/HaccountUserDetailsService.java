package cn.haoyu.account.manage;

import cn.haoyu.account.entity.Authorities;
import cn.haoyu.account.entity.User;
import cn.haoyu.account.model.HaccountUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by haoyu on 2018/5/3.
 */
@Component
public class HaccountUserDetailsService implements UserDetailsService {
    private final Logger logger = LoggerFactory.getLogger(HaccountUserDetailsService.class);


    @Autowired
    private UserBiz usersBiz;
    @Autowired
    private AuthoritiesBiz authoritiesBiz;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Assert.hasText(username, "用户名不能为空！");
        logger.info("userHid----------------------->{}",username);
        User user = usersBiz.findByUserHid(username);
//        User user = usersBiz.findByUserName(username);
        if (user == null) {
            logger.error("根据用户名查询无用户信息记录:username--->{}", username);
            throw new UsernameNotFoundException("用户不存在！");
        }
        Authorities authority = authoritiesBiz.findByUserHid(user.getHid());
        Set<Authorities> authorities = new HashSet<Authorities>();
        authorities.add(authority);
        HaccountUser userDetails = new HaccountUser(user.getHid(), user.getUsername(), authorities, true);
        return userDetails;
    }


}
