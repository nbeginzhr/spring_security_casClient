package cn.haoyu.account.repository;

import cn.haoyu.account.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by haoyu on 2018/5/3.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role,String> {

    List<Role> findByHaccountHid(String haccountHid);
}
