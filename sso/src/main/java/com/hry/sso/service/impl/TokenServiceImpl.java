package com.hry.sso.service.impl;

import com.hry.sso.mapper.TTokenMapper;
import com.hry.sso.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private TTokenMapper tokenMapper;

    /**
     *往数据库存放token信息
     * @param token
     */
    @Override
    public void addToken(String token) {
        tokenMapper.insertByToken(token);
    }
}
