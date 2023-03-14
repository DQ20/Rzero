package com.Husky.superMarket.pojo;

public class manager {
    private String account;
    private String password;

    public String getAccount() {
        return account;
    }

    public manager(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public manager() {
    }

}
