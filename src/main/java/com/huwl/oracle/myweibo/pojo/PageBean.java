package com.huwl.oracle.myweibo.pojo;

/**
 * Created by aierxuan on 2017/7/24.
 */
public class PageBean {
    private Integer pageNo;
    private Integer pageSize;
    private Integer prevPage;
    private Integer nextPage;
    private Integer pageCount;
    private Integer objCount;
    private Integer offsetInDB;

    public Integer getOffsetInDB() {
        return offsetInDB;
    }
    public void setOffsetInDB(Integer offsetInDB) {
        this.offsetInDB = offsetInDB;
    }
    public Integer getObjCount() {
        return objCount;
    }
    public void setObjCount(Integer objCount) {
        this.objCount = objCount;
    }
    public Integer getPageCount() {
        return pageCount;
    }
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }
    public Integer getPageNo() {
        return pageNo;
    }
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public Integer getPrevPage() {
        return prevPage;
    }
    public void setPrevPage(Integer prevPage) {
        this.prevPage = prevPage;
    }
    public Integer getNextPage() {
        return nextPage;
    }
    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }
    public PageBean(Integer pageSize,Integer pageNo,Integer objCount) {
        this.setPageSize(pageSize);
        this.setPageNo(pageNo);
        this.setObjCount(objCount);
        this.setPageCount(objCount%pageSize==0?objCount/pageSize:objCount/pageSize+1);
        this.setPrevPage(pageNo-1);
        this.setNextPage(pageNo+1);
        this.setOffsetInDB((pageNo-1)*pageSize);
    }
    @Override
    public String toString() {
        return "PageBean [pageNo=" + pageNo + ", pageSize=" + pageSize
                + ", prevPage=" + prevPage + ", nextPage=" + nextPage
                + ", pageCount=" + pageCount + ", objCount=" + objCount + "]";
    }
}
