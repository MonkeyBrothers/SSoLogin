package com.hry.sso.mapper;

import com.hry.sso.pojo.TToken;
import com.hry.sso.pojo.TTokenExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TTokenMapper {
    int countByExample(TTokenExample example);

    int deleteByExample(TTokenExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TToken record);

    int insertByToken(String token);

    int insertSelective(TToken record);

    List<TToken> selectByExample(TTokenExample example);

    TToken selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TToken record, @Param("example") TTokenExample example);

    int updateByExample(@Param("record") TToken record, @Param("example") TTokenExample example);

    int updateByPrimaryKeySelective(TToken record);

    int updateByPrimaryKey(TToken record);
}