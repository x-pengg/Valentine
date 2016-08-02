package me.ridog.valentine.db;

import java.util.List;

/**
 * Created by Tate on 2016/8/2.
 */
public class Page<T> {

    public static final int DEFAULT_PAGESIZE = 6;

    private int pageNo;

    private int pageSize;

    private long totalRecord;

    private int totalPage;

    private List<T> pageData;

    public Page() {
        pageNo = 1;
        pageSize = DEFAULT_PAGESIZE;
    }

    public Page(Integer currentPageNo, Integer pageSize) {
        this.pageNo = currentPageNo == null ? 1 : currentPageNo;
        this.pageSize = pageSize == null ? DEFAULT_PAGESIZE : pageSize;
    }

    public static int getDefaultPagesize() {
        return DEFAULT_PAGESIZE;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }
}
