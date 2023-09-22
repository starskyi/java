package com.star.domain;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String telephone;
    private Integer isMerchant;
    private String sex;
    private String address;
    private Double money;

    public User() {
    }

    public User(Integer id, String username, String password, String name, String telephone, Integer isMerchant, String sex, String address, Double money) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.telephone = telephone;
        this.isMerchant = isMerchant;
        this.sex = sex;
        this.address = address;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getIsMerchant() {
        return isMerchant;
    }

    public void setIsMerchant(Integer isMerchant) {
        this.isMerchant = isMerchant;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", isMerchant=" + isMerchant +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", money=" + money +
                '}';
    }
}
