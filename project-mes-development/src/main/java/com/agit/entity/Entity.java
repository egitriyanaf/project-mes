package com.agit.entity;

/**
 *
 * @author erwin
 */
public interface Entity {

    /**
     *
     * @return
     */
    public boolean isNew();

    /**
     *
     * @return
     */
    public Long getId();

    /**
     *
     * @param id
     */
    public void setId(Long id);
}
