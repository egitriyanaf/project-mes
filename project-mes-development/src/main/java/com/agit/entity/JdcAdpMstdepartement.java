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
@Table(name = "jdcadp_mstdptunit")
public class JdcAdpMstdepartement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4766966230697392291L;

	@Id
	@SequenceGenerator(name = "seq_dpt", sequenceName = "seq_dpt", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_dpt")
	@Column(name = "dpt_id")
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
	
	@Column(name="dpt_code")
	private String dptCode ;
	
	@Column(name="dpt_name")
	private String dptName ;
	
	@Column(name="org_id")
	private Long orgId ;
	
	@ManyToOne
	@JoinColumn(name="org_id" ,insertable = false, nullable=false,updatable = false)
	private JdcAdpMstorganization organization;

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
    public String getDptCode() {
		return dptCode;
	}

    /**
     *
     * @param dptCode
     */
    public void setDptCode(String dptCode) {
		this.dptCode = dptCode;
	}

    /**
     *
     * @return
     */
    public String getDptName() {
		return dptName;
	}

    /**
     *
     * @param dptName
     */
    public void setDptName(String dptName) {
		this.dptName = dptName;
	}

    /**
     *
     * @return
     */
    public Long getOrgId() {
		return orgId;
	}

    /**
     *
     * @param orgId
     */
    public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

    /**
     *
     * @return
     */
    public JdcAdpMstorganization getOrganization() {
		return organization;
	}

    /**
     *
     * @param organization
     */
    public void setOrganization(JdcAdpMstorganization organization) {
		this.organization = organization;
	}

	
}