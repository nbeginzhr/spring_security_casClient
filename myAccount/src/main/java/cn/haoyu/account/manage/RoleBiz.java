package cn.haoyu.account.manage;

import cn.haoyu.account.entity.Role;
import cn.haoyu.account.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by haoyu on 2018/5/3.
 */
@Component("roleBiz")
public class RoleBiz {
    @Autowired
    private RoleRepository roleRepository;


    public List<Role> findByHaccountHid(String accountHid){
        return roleRepository.findByHaccountHid(accountHid);
    }


    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
