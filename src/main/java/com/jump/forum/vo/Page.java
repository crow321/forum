package com.jump.forum.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页对象，包含当前页数据及分页信息如总页数
 * Created by Administrator on 2017/6/23.
 */
public class Page implements Serializable {
    private static final int DEFAULT_PAGE_SIZE = 10;
    private int pageSize;//每页的记录数
    private long start;//当前页第一条记录在list中的位置，从 0 开始
    private List data;//当前页存放数据的位置 为list
    private long totalCount;//总记录数

    public Page() {
        this(0, 0, DEFAULT_PAGE_SIZE, new ArrayList());
    }

    public Page(long start, long totalCount, int pageSize, List data) {
        this.pageSize = pageSize;
        this.start = start;
        this.data = data;
        this.totalCount = totalCount;
    }

    /**
     * 获取任一页第一条数据在数据集中的位置，每页条数使用默认值
     *
     * @param pageNo 任一页的第一条数据位置
     * @return
     */
    public static int getStartOfPage(int pageNo) {
        return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE);
    }

    /**
     * 获取任一页第一条数据在数据集中的位置
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    public static int getStartOfPage(int pageNo, int pageSize) {
        return (pageNo - 1) * pageSize;
    }

    public static int getDefaultPageSize() {
        return DEFAULT_PAGE_SIZE;
    }

    /**
     * 获取总页数
     *
     * @return 总页数
     */
    public long getTotalPageCount() {
        if (totalCount % pageSize == 0) {
            return (totalCount / pageSize);
        } else
            return totalCount / pageSize + 1;
    }

    /**
     * 获取当前页码 从1开始
     *
     * @return
     */
    public long getCurrentPageNo() {
        return start / pageSize + 1;
    }

    /**
     * 判断是否有下一页
     *
     * @return
     */
    public boolean isHasNextPage() {
        return this.getCurrentPageNo() < this.getTotalPageCount();
    }

    /**
     * 判断是否有上一页
     *
     * @return
     */
    public boolean isHasPreviousPage() {
        return this.getCurrentPageNo() > 1;
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
