package me.ridog.valentine.service;

import me.ridog.valentine.db.Page;
import me.ridog.valentine.pojo.auto.Content;
import me.ridog.valentine.result.ArchiveResult;
import me.ridog.valentine.result.ContentResult;

import java.util.List;

/**
 * Created by Tate on 2016/8/2.
 */
public interface IContentService {

    Page<Content> getByPage(Page<Content> page);

    Page<Content> getByPageOfAdmin(Page<Content> page);

    Content getById(Integer cid);

    ContentResult getBySlug(String slug);

    List<ArchiveResult> getArchive();


}
