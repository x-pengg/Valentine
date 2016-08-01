package me.ridog.valentine.mapper;

import me.ridog.valentine.pojo.auto.Metas;

import java.util.List;

/**
 * Created by Tate on 2016/8/1.
 */
public interface IMetasMapper {

    List<Metas> selectAll(String type);
}
