package cn.haoyu.account.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by haoyu on 2018/6/14.
 */
@Entity
public class Authorities implements GrantedAuthority, Serializable{
    private static final long serialVersionUID = -3443542846227845340L;

    private String hid;
    private String userhid;
    private String authority;

    @Id
    @Column(name = "hid")
    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String getUserhid() {
        return userhid;
    }

    public void setUserhid(String userhid) {
        this.userhid = userhid;
    }

    @Column(name = "authority")
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
