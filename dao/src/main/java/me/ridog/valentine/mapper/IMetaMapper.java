package me.ridog.valentine.mapper;

import me.ridog.valentine.pojo.auto.Meta;

import java.util.List;

/**
 * Created by Tate on 2016/8/1.
 */
public interface IMetaMapper {

    List<Meta> selectAll(String type);
}
