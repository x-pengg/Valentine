package me.ridog.valentine.result;

import java.util.List;

/**
 * Created by Tate on 2016/8/4.
 */
public class ArchiveResult {

    private String id;
    private String year;
    private List<ArchiveContent> archive;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<ArchiveContent> getArchive() {
        return archive;
    }

    public void setArchive(List<ArchiveContent> archive) {
        this.archive = archive;
    }
}

