package com.blaze.biz;

import java.io.Serializable;

public class User implements Serializable{

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String username;
    private String password;
    
    public User() {
        super();
    }
    
    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public User(Integer id, String username, String password, Double account) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
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


    @Override
    public String toString() {
        return "UserBean [id=" + id + ", username=" + username + ", password=" + password + "]";
    }
    
    
    

}