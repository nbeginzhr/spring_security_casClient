package cn.haoyu.account.repository;

import cn.haoyu.account.entity.Haccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by haoyu on 2018/5/1.
 */
@Repository
public interface HaccountRepository extends JpaRepository<Haccount , String>{

    Haccount findByUsername(String username);
}
