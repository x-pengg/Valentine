package me.ridog.valentine.service;

import me.ridog.valentine.db.Page;
import me.ridog.valentine.pojo.auto.Content;

/**
 * Created by Tate on 2016/8/2.
 */
public interface IContentService {

    Page<Content> getByPage(Page<Content> page);

    Content getById(Integer cid);

}
