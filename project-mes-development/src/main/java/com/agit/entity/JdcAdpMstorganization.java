package com.agit.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.entity.util.CustomJsonDateSerializer;

/**
 *
 * @author erwin
 */
@Entity
@Table(name = "jdcadp_mstorgunit")
public class JdcAdpMstorganization implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4766966230697392291L;

	@Id
	@SequenceGenerator(name = "seq_org", sequenceName = "seq_org", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_org")
	@Column(name = "org_id")
	private Long id;
	
	@Column(name="created_date")
	@Temporal(TemporalType.DATE)
	@JsonSerialize(using=CustomJsonDateSerializer.class)
	private Date createDate ;
	
	@Column(name="created_by")
	private Long createBy ;
	
	@Column(name="last_updated_date")
	@Temporal(TemporalType.DATE)
	@JsonSerialize(using=CustomJsonDateSerializer.class)
	private Date updateDate ;
	
	@Column(name="last_updated_by")
	private Long updateBy;
	
	@Column(name="date_input")
	@Temporal(TemporalType.DATE)
	@JsonSerialize(using=CustomJsonDateSerializer.class)
	private Date dateInput ;
	
	@Column(name="development")
	private Long development ;
	
	@Column(name="org_code")
	private String orgCode ;
	
	@Column(name="org_name")
	private String orgName ;

    /**
     *
     * @return
     */
    public Long getId() {
		return id;
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
    public Date getCreateDate() {
		return createDate;
	}

    /**
     *
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

    /**
     *
     * @return
     */
    public Long getCreateBy() {
		return createBy;
	}

    /**
     *
     * @param createBy
     */
    public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

    /**
     *
     * @return
     */
    public Date getUpdateDate() {
		return updateDate;
	}

    /**
     *
     * @param updateDate
     */
    public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

    /**
     *
     * @return
     */
    public Long getUpdateBy() {
		return updateBy;
	}

    /**
     *
     * @param updateBy
     */
    public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

    /**
     *
     * @return
     */
    public Date getDateInput() {
		return dateInput;
	}

    /**
     *
     * @param dateInput
     */
    public void setDateInput(Date dateInput) {
		this.dateInput = dateInput;
	}

    /**
     *
     * @return
     */
    public Long getDevelopment() {
		return development;
	}

    /**
     *
     * @param development
     */
    public void setDevelopment(Long development) {
		this.development = development;
	}

    /**
     *
     * @return
     */
    public String getOrgCode() {
		return orgCode;
	}

    /**
     *
     * @param orgCode
     */
    public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

    /**
     *
     * @return
     */
    public String getOrgName() {
		return orgName;
	}

    /**
     *
     * @param orgName
     */
    public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

}