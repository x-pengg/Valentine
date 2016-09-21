package me.ridog.valentine.mapper;

import me.ridog.valentine.db.Page;
import me.ridog.valentine.pojo.auto.Content;
import me.ridog.valentine.result.ArchiveContent;
import me.ridog.valentine.result.ArchiveResult;
import me.ridog.valentine.result.ContentResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Tate on 2016/8/2.
 */
public interface IContentMapper {

    ContentResult selectBySlug(String slug);

    List<Content> findByPage(Page<Content> page);

    List<Content> findByPageOfAdmin(Page<Content> page);

    List<ArchiveResult> selectContentIdGroup();

    List<ArchiveContent> selectArchive(@Param("ids") String[] ids);

}
