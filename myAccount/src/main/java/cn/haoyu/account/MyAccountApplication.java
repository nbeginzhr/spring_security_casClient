package cn.haoyu.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by haoyu on 2018/4/10.
 */
@SpringBootApplication(scanBasePackages = "cn.haoyu.account")
@ServletComponentScan(basePackages = "cn.haoyu.account")
public class MyAccountApplication extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MyAccountApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MyAccountApplication.class);
    }
}
