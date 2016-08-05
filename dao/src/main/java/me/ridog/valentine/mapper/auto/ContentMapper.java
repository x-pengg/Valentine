package me.ridog.valentine.mapper.auto;

import me.ridog.valentine.pojo.auto.Content;

public interface ContentMapper {

    int deleteByPrimaryKey(Integer cid);

    int insert(Content record);

    int insertSelective(Content record);

    Content selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Content record);

    int updateByPrimaryKeyWithBLOBs(Content record);

    int updateByPrimaryKey(Content record);
}