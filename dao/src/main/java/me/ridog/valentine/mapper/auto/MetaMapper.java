package me.ridog.valentine.mapper.auto;

import me.ridog.valentine.pojo.auto.Meta;

public interface MetaMapper {

    int deleteByPrimaryKey(Integer mid);

    int insert(Meta record);

    int insertSelective(Meta record);

    Meta selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(Meta record);

    int updateByPrimaryKey(Meta record);
}