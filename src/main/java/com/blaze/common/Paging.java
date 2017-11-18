package com.blaze.common;

import java.util.ArrayList;
import java.util.List;

public class Paging<T> extends PageParam {
	
	public static final Integer DEFAULT_PAGE_SIZE = 2;

	/**
	 * 单页数据
	 */
    private List<T> results;
    
    /**
     * 总数
     */
    private Integer total;

    public static <T> Paging<T> of(List<T> results, int total, int page, int pageSize) {
        Paging<T> paging = new Paging<>();
        paging.setTotal(total);
        paging.setResults(results);
        paging.setPageSize(pageSize);
        paging.setPage(page);
        return paging;
    }

    /**
     * copy 属性，不copy result
     * @param sourcePaing
     * @param <T>
     * @param <S>
     * @return
     */
    public static <T,S> Paging<T> copyWithOutResult(Paging<S> sourcePaing){
        Paging<T> paging = new Paging<T>();
        paging.setResults(new ArrayList<T>());
        paging.setTotal(sourcePaing.getTotal());
        paging.setPageSize(sourcePaing.getPageSize());
        paging.setPage(sourcePaing.getPage());
        return paging;
    }

    public static <T> Paging<T> empty(int pageSize) {
        Paging<T> paging = new Paging<>();
        paging.setTotal(0);
        paging.setResults(new ArrayList<>());
        paging.setPageSize(pageSize);
        paging.setPage(1);
        return paging;
    }

    public static <T, S> Paging of(List<T> list, Paging<S> sourcePaging){
        Paging<T> paging = new Paging<>();
        paging.setTotal(sourcePaging.getTotal());
        paging.setResults(list);
        paging.setPage(sourcePaging.getPage());
        paging.setPageSize(sourcePaging.getPageSize());
        return paging;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getMaxPage() {
        return (total + getPageSize() - 1) / this.getPageSize();
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public boolean getHasNext() {
        return getMaxPage() > this.getPage();
    }

    public ShowPage getShowPage(int showSize){
        int totalPage = getMaxPage();
        int startPage = getPage() - showSize / 2;
        if (startPage < 1)
            startPage = 1;
        int endPage = startPage + showSize - 1;
        if (endPage > totalPage) {
            endPage = totalPage;
            startPage = endPage - showSize - 1;
            if (startPage < 1)
                startPage = 1;
        }
        ShowPage showPage = new ShowPage();
        showPage.setStartPage(startPage);
        showPage.setEndPage(endPage);
        return showPage;
    }
}
