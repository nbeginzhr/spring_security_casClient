package cn.haoyu.account.repository;

import cn.haoyu.account.entity.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by haoyu on 2018/6/14.
 */
@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities,String> {

    Authorities findByUserhid(String userhid);

}
