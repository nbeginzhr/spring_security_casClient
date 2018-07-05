package cn.haoyu.account.restController;

import cn.haoyu.account.entity.Haccount;
import cn.haoyu.account.entity.Role;
import cn.haoyu.account.manage.HaccountBiz;
import cn.haoyu.account.manage.RoleBiz;
import cn.haoyu.account.utils.HID;
import cn.haoyu.account.utils.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by haoyu on 2018/5/3.
 */
@RestController
@RequestMapping(value = "/api/haccount/")
public class HaccountRestController {
    private final Logger logger = LoggerFactory.getLogger(HaccountRestController.class);

    @Autowired
    private HaccountBiz haccountBiz;
    @Autowired
    private RoleBiz roleBiz;

    @GetMapping(value = "addUser")
    public ResponseEntity addUser(String username, String password, String rol) {
        try {
            Haccount haccount = new Haccount();
            haccount.setHid(HID.create());
            haccount.setCreateTime(new Date());
            haccount.setUsername(username);
            haccount.setPassword(MD5Util.encode(password));

            Role role = new Role(HID.create(), haccount.getHid(), "ADMIN", "ADMIN");
            haccountBiz.save(haccount);
            roleBiz.save(role);
            return ResponseEntity.ok("添加用户成功！");
        } catch (Exception e) {
            logger.error("添加用户失败：{}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("添加用户失败！");
        }
    }

    @GetMapping(value = "hello")
    public ResponseEntity addUser() {
        return ResponseEntity.ok().body("hello hello");
    }

}
