package com.heshi.seckill.entity;

/**
 * @author Paosin
 * @version 1.0
 * @className User
 * @date 2018/3/17 22:08
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private String avatar;

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
