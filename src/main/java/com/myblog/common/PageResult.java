package com.myblog.common;

import java.util.List;

/**
 * Week 07 - 分页载荷：{items, total, page, size}。
 * total 是关键字段——它回答"还有没有下一页"。
 */
public class PageResult<T> {
    private List<T> items;
    private long total;
    private int page;
    private int size;

    public PageResult(List<T> items, long total, int page, int size) {
        this.items = items;
        this.total = total;
        this.page = page;
        this.size = size;
    }

    public List<T> getItems() { return items; }
    public long getTotal() { return total; }
    public int getPage() { return page; }
    public int getSize() { return size; }
}
