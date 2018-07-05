package cn.haoyu.account.manage;

import cn.haoyu.account.entity.Authorities;
import cn.haoyu.account.repository.AuthoritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by haoyu on 2018/6/14.
 */
@Component("authoritiesBiz")
public class AuthoritiesBiz {

    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    public Authorities save(Authorities entity) {
        return authoritiesRepository.save(entity);
    }

    public Authorities findByUserHid(String userHid) {
        Authorities result = authoritiesRepository.findByUserhid(userHid);
        return result;
    }

}
