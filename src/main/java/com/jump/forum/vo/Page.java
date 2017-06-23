package com.jump.forum.vo;

import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
public class Page {
    private static final int DEFAULT_PAGE_SIZE = 10;
    private int pageSize;
    private long start;
    private List data;
    private long totalCount;

    public static int getDefaultPageSize() {
        return DEFAULT_PAGE_SIZE;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }
}
