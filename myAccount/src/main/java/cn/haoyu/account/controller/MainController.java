package cn.haoyu.account.controller;

import cn.haoyu.account.configuration.CasServerConfig;
import cn.haoyu.account.configuration.CasServiceConfig;
import cn.haoyu.account.model.HaccountUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by haoyu on 2018/4/10.
 */
@Controller
public class MainController {

    @Autowired
    private CasServerConfig casServerConfig;
    @Autowired
    private CasServiceConfig casServiceConfig;

    @RequestMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/user")
    public String userIndex(@AuthenticationPrincipal HaccountUser user) {
        System.out.println("hello CurrentUser---------------》" + user.getUsername());
        return "user/index";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String postLogin() {
        // TODO Enable form login with Spring Security (trigger error for now)
        System.out.println("login--------------");
//        return "redirect:/user/index";
        return "redirect:/login-error";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @PostMapping(value = "/logoutTest")
    public String logout(){
        return "redirect:" + this.casServerConfig.getLogout() + "?service=" + this.casServiceConfig.getHost();
    }

}
