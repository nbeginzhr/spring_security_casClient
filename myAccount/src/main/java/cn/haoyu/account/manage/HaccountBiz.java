package cn.haoyu.account.manage;

import cn.haoyu.account.entity.Haccount;
import cn.haoyu.account.repository.HaccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by haoyu on 2018/5/3.
 */
@Component("haccountBiz")
public class HaccountBiz {
    @Autowired
    private HaccountRepository haccountRepository;

    public Haccount save(Haccount haccount){
        return haccountRepository.save(haccount);
    }

    public Haccount fetch(String hid){
        return haccountRepository.findOne(hid);
    }

    public Haccount findByUserName(String username){
        return haccountRepository.findByUsername(username);
    }



}
