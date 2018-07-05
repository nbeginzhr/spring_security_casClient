package cn.haoyu.account.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by haoyu on 2018/4/21.
 */
@Configuration
@ConfigurationProperties(prefix = "security.cas.server")
public class CasServerConfig {
    private String host;
    private String login;
    private String logout;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogout() {
        return logout;
    }

    public void setLogout(String logout) {
        this.logout = logout;
    }
}
