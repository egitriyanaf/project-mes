package com.agit.entity.security;

import java.io.Serializable;
import java.util.Date;

import com.agit.entity.Entity;

/**
 *
 * @author erwin
 */
public class JdcAdpMstRole implements Serializable, Entity {

    /**
     *
     * @author Ridwan
     */
    private static final long serialVersionUID = -4574678311322292520L;
    private Long id;
    private String name;
    private String description;
    private Date createdDate;
    private Long createdBy;
    private Long lastUpdatedBy;
    private Date lastUpdatedDate;

    /**
     *
     * @return
     */
    public boolean isNew() {
        return getId() == null;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     *
     * @param createdDate
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     *
     * @return
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     *
     * @param createdBy
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     *
     * @return
     */
    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    /**
     *
     * @param lastUpdatedBy
     */
    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     *
     * @return
     */
    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    /**
     *
     * @param lastUpdatedDate
     */
    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    /**
     *
     * @param secRole
     * @return
     */
    public boolean equals(JdcAdpMstRole secRole) {
        return getId().equals(secRole.getId());
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof JdcAdpMstRole) {
            JdcAdpMstRole secRole = (JdcAdpMstRole) obj;
            return equals(secRole);
        }

        return false;
    }
}
