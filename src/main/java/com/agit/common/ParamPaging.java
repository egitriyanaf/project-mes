package com.agit.common;

import java.util.Map;

/**
 *
 * @author erwin
 */
public class ParamPaging {

    private String id_fact_klaim;
    private int offset;
    private int limit;
    // field yang akan diurutkan
    private String sort;

    //descending atau ascending
    private String order;
    private Map<String, Object> search;

    /**
     *
     * @return
     */
    public String getId_fact_klaim() {
        return id_fact_klaim;
    }

    /**
     *
     * @param id_fact_klaim
     */
    public void setId_fact_klaim(String id_fact_klaim) {
        this.id_fact_klaim = id_fact_klaim;
    }

    /**
     *
     * @return
     */
    public int getOffset() {
        return offset;
    }

    /**
     *
     * @param offset
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     *
     * @return
     */
    public int getLimit() {
        return limit;
    }

    /**
     *
     * @param limit
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     *
     * @return
     */
    public String getSort() {
        return sort;
    }

    /**
     *
     * @param sort
     */
    public void setSort(String sort) {
        this.sort = sort;
    }

    /**
     *
     * @return
     */
    public String getOrder() {
        return order;
    }

    /**
     *
     * @param order
     */
    public void setOrder(String order) {
        this.order = order;
    }

    /**
     *
     * @return
     */
    public Map<String, Object> getSearch() {
        return search;
    }

    /**
     *
     * @param search
     */
    public void setSearch(Map<String, Object> search) {
        this.search = search;
    }

}
