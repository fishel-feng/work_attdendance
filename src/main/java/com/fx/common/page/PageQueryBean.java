package com.fx.common.page;

import java.util.Collections;
import java.util.List;

public class PageQueryBean {

    private static final int DEFAULT_PAGE_SIZE = 10;

    private Integer currentPage;

    private Integer pageSize;

    private int totalRows;

    private Integer startRow;

    private Integer totalPage;

    private List<?> items;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public final Integer getPageSize() {
        return pageSize == null ? DEFAULT_PAGE_SIZE : pageSize;
    }

    public final void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public final int getTotalRows() {
        return totalRows;
    }

    public final void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
        int totalPage = totalRows % getPageSize() == 0 ? totalRows / getPageSize() : totalRows / getPageSize() + 1;
        setTotalPage(totalPage);
    }

    public final Integer getStartRow() {
        if (startRow == null) {
            startRow = (currentPage == null ? 0 : (currentPage - 1) * getPageSize());
        }
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public final List<?> getItems() {
        return items == null ? Collections.EMPTY_LIST : items;
    }

    public final void setItems(List<?> items) {
        this.items = items;
    }
}
