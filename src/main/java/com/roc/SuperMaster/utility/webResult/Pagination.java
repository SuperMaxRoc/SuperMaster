package com.roc.SuperMaster.utility.webResult;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Pagination
 * @Description TODO
 * @Author WangPeng
 * @date 2022/8/25 9:39
 * @Version 1.0
 */
public class Pagination<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<T> records;
    private Integer pageCount = 0;
    private Integer pageSize = 10;
    private Integer pageIndex = 1;
    private Integer rowCount = 0;

    public Pagination() {
    }

    public int getFirstResult() {
        return (this.pageIndex - 1) * this.pageSize;
    }

    public Pagination(int pageSize, int pageIndex) {
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
    }

    public Pagination(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setQueryResult(int rowCount, List<T> records) {
        this.setRowCount(rowCount);
        this.setRecords(records);
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
        this.setPageCount(this.rowCount % this.pageSize == 0 ? this.rowCount / this.pageSize : this.rowCount / this.pageSize + 1);
    }

    public int getRowCount() {
        return this.rowCount;
    }

    public List<T> getRecords() {
        return this.records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageCount() {
        return this.pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
