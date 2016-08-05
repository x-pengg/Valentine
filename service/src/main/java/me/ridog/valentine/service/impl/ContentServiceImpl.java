package me.ridog.valentine.service.impl;

import com.google.common.base.Strings;
import me.ridog.valentine.db.Page;
import me.ridog.valentine.mapper.IContentMapper;
import me.ridog.valentine.mapper.auto.ContentMapper;
import me.ridog.valentine.pojo.auto.Comment;
import me.ridog.valentine.pojo.auto.Content;
import me.ridog.valentine.result.ArchiveResult;
import me.ridog.valentine.result.ContentResult;
import me.ridog.valentine.service.IContentService;
import me.ridog.valentine.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tate on 2016/8/2.
 */

@Service
public class ContentServiceImpl implements IContentService {

    @Autowired
    private IContentMapper contentMapperEx;
    @Autowired
    private ContentMapper contentMapper;

    public Page<Content> getByPage(Page<Content> page) {
        page.setPageData(contentMapperEx.findByPage(page));
        return page;
    }

    public Content getById(Integer cid) {
        return contentMapper.selectByPrimaryKey(cid);
    }

    public ContentResult getBySlug(String slug) {
        ContentResult contentResult = contentMapperEx.selectBySlug(slug);
        for (Comment comment : contentResult.getComments()) {
            if (!Strings.isNullOrEmpty(comment.getMail())) {
                comment.setGravatarPrefix(MD5Utils.MD5(comment.getMail()));
            }
        }
        return contentResult;
    }

    public List<ArchiveResult> getArchive() {
        List<ArchiveResult> archiveResults = contentMapperEx.selectContentIdGroup();
        for (ArchiveResult archiveResult : archiveResults) {
            if (null != archiveResult.getId() && archiveResult.getId() != "") {
                String[] ids = archiveResult.getId().split(",");
                archiveResult.setArchive(contentMapperEx.selectArchive(ids));
            }
        }
        return archiveResults;
    }
}
