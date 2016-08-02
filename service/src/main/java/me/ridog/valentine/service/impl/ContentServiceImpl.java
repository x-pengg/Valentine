package me.ridog.valentine.service.impl;

import me.ridog.valentine.db.Page;
import me.ridog.valentine.mapper.IContentMapper;
import me.ridog.valentine.pojo.auto.Content;
import me.ridog.valentine.service.IContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tate on 2016/8/2.
 */

@Service
public class ContentServiceImpl implements IContentService {

    @Autowired
    private IContentMapper contentMapper;

    public Page<Content> getByPage(Page<Content> page) {
        page.setPageData(contentMapper.findByPage(page));
        return page;
    }
}
