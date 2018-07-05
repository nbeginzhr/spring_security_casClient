//package cn.haoyu.account.configuration;
//
//import cn.haoyu.account.utils.MD5Util;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import javax.sql.DataSource;
//
///**
// * Created by haoyu on 2018/4/11.
// */
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//// requests matched against /css/** and /index are fully accessible
//// requests matched against /user/** require a user to be authenticated and must be associated to the USER role
//// form-based authentication is enabled with a custom login page and failure url
//
//    @Autowired
//    private DataSource dataSource;
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/css/**", "/index").permitAll()
//                .antMatchers("/user/**").hasRole("USER")
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/user/index")
//                .failureUrl("/login-error")
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/index");
////                .logoutSuccessHandler(logoutSuccessHandler)
////                .invalidateHttpSession(true)
////                .addLogoutHandler(logoutHandler)
////                .deleteCookies(cookieNamesToClear);
//
//    }
//
////    @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        // 基于内存的认证
//////        auth
//////                .inMemoryAuthentication()
//////                .withUser("user").password("password").roles("USER");
////        // 基于jdbc 的认证
//////        auth.userDetailsService()
////        auth.jdbcAuthentication()
////                .dataSource(dataSource)
////                .usersByUsernameQuery("select username,password,enabled from users where username = ?")
////                .authoritiesByUsernameQuery("select username,authority from authorities where username = ?");
////
////    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        JdbcDaoImpl jdbcDao = new JdbcDaoImpl();
//        jdbcDao.setDataSource(dataSource);
//        auth.userDetailsService(jdbcDao).passwordEncoder(new PasswordEncoder() {
//
//            @Override
//            public String encode(CharSequence rawPassword) {
//                return MD5Util.encode((String) rawPassword);
//            }
//
//            @Override
//            public boolean matches(CharSequence rawPassword, String encodedPassword) {
//                return encodedPassword.equals(MD5Util.encode((String) rawPassword));
//            }
//        });
//    }
//
//
//}
