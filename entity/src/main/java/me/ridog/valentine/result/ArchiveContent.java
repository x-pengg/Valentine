package me.ridog.valentine.result;

import java.util.Date;

/**
 * Created by Tate on 2016/8/4.
 */
public class ArchiveContent {

    private Integer cid;
    private String title;
    private Date created;
    private String slug;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
