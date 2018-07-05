package cn.haoyu.account.model;

import cn.haoyu.account.entity.Authorities;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

/**
 * Created by haoyu on 2018/5/3.
 */
public class HaccountUser implements UserDetails {

    private String accountHid;
    private String username;
    private Set<Authorities> authorities;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;

    public HaccountUser() {
    }

    public HaccountUser(String accountHid, String username, Set<Authorities> authorities, boolean enabled) {
        this.accountHid = accountHid;
        this.username = username;
        this.authorities = authorities;
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }


    public String getAccountHid() {
        return accountHid;
    }

    public void setAccountHid(String accountHid) {
        this.accountHid = accountHid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAuthorities(Set<Authorities> authorities) {
        this.authorities = authorities;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
