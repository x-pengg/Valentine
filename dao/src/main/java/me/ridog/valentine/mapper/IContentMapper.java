package me.ridog.valentine.mapper;

import me.ridog.valentine.db.Page;
import me.ridog.valentine.pojo.auto.Content;

import java.util.List;

/**
 * Created by Tate on 2016/8/2.
 */
public interface IContentMapper {

    List<Content> findByPage(Page<Content> page);
}
