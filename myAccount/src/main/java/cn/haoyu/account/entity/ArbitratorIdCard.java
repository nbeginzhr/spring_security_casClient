package cn.haoyu.account.entity;

/**
 * Created by haoyu on 2018/4/13.
 */
public class ArbitratorIdCard {

    private String name;
    private String receivedate;

    public ArbitratorIdCard() {}
  public ArbitratorIdCard(String name, String receivedate) {
        this.name = name;
        this.receivedate = receivedate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReceivedate() {
        return receivedate;
    }

    public void setReceivedate(String receivedate) {
        this.receivedate = receivedate;
    }
}
