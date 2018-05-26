package com.hry.sso.service;

public interface TokenService {
    // 往数据库存放token信息
    void addToken(String token);
}
