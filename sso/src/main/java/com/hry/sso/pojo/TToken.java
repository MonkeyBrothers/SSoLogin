package com.hry.sso.pojo;

public class TToken {
    /** 主键记录token数量 */
    private Integer id;

    /** 记录token信息 */
    private String token;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }
}