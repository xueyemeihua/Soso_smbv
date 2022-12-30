package com.sky.soso.pojo;

public class User {
    private Integer uid;
    private String username;
    private String pwd;
    private String name;
    private String phone;
    private String cardid;
    private Integer money;
    private Integer points;

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", cardid='" + cardid + '\'' +
                ", money=" + money +
                ", points=" + points +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public User() {
    }

    public User(Integer uid, String username, String pwd, String name, String phone, String cardid, Integer money, Integer points) {
        this.uid = uid;
        this.username = username;
        this.pwd = pwd;
        this.name = name;
        this.phone = phone;
        this.cardid = cardid;
        this.money = money;
        this.points = points;
    }
}
