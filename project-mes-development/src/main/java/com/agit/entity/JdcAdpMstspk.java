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
@Table(name = "jdcadp_mstspk")
public class JdcAdpMstspk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4766966230697392291L;

	@Id
	@SequenceGenerator(name = "seq_spk", sequenceName = "seq_spk", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_spk")
	@Column(name = "spk_id")
	private Long id;
	
	@Column(name="created_date")
	@Temporal(TemporalType.DATE)
	@JsonSerialize(using=CustomJsonDateSerializer.class)
	private Date createDate ;
	
	@Column(name="created_by")
	private Long createBy ;
	
	@ManyToOne
	@JoinColumn(name="created_by" ,insertable = false, nullable=false,updatable = false)
	private JdcAdpMstUser user;
	
	@Column(name="last_updated_date")
	@Temporal(TemporalType.DATE)
	@JsonSerialize(using=CustomJsonDateSerializer.class)
	private Date updateDate ;
	
	@Column(name="last_updated_by")
	private Long updateBy;
	
	@Column(name="etc_date")
	@Temporal(TemporalType.DATE)
	@JsonSerialize(using=CustomJsonDateSerializer.class)
	private Date etcDate;
	
	@Column(name="category")
	private String category;
	
	@Column(name="model")
	private String model;
	
	@Column(name="product_code")
	private String productCode;
	
	@Column(name="qty")
	private Float qty;
	
	@Column(name="sample_req")
	private String sampleReq;
	
	@Column(name="season")
	private String season;
	
	@Column(name="size")
	private String size;
	
	@Column(name="type_sample")
	private String typeSample;
	
	@Column(name="start_date")
	@Temporal(TemporalType.DATE)
	@JsonSerialize(using=CustomJsonDateSerializer.class)
	private Date startDate;

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
    public JdcAdpMstUser getUser() {
		return user;
	}

    /**
     *
     * @param user
     */
    public void setUser(JdcAdpMstUser user) {
		this.user = user;
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
    public Date getEtcDate() {
		return etcDate;
	}

    /**
     *
     * @param etcDate
     */
    public void setEtcDate(Date etcDate) {
		this.etcDate = etcDate;
	}

    /**
     *
     * @return
     */
    public String getCategory() {
		return category;
	}

    /**
     *
     * @param category
     */
    public void setCategory(String category) {
		this.category = category;
	}

    /**
     *
     * @return
     */
    public String getModel() {
		return model;
	}

    /**
     *
     * @param model
     */
    public void setModel(String model) {
		this.model = model;
	}

    /**
     *
     * @return
     */
    public String getProductCode() {
		return productCode;
	}

    /**
     *
     * @param productCode
     */
    public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

    /**
     *
     * @return
     */
    public Float getQty() {
		return qty;
	}

    /**
     *
     * @param qty
     */
    public void setQty(Float qty) {
		this.qty = qty;
	}

    /**
     *
     * @return
     */
    public String getSampleReq() {
		return sampleReq;
	}

    /**
     *
     * @param sampleReq
     */
    public void setSampleReq(String sampleReq) {
		this.sampleReq = sampleReq;
	}

    /**
     *
     * @return
     */
    public String getSeason() {
		return season;
	}

    /**
     *
     * @param season
     */
    public void setSeason(String season) {
		this.season = season;
	}

    /**
     *
     * @return
     */
    public String getSize() {
		return size;
	}

    /**
     *
     * @param size
     */
    public void setSize(String size) {
		this.size = size;
	}

    /**
     *
     * @return
     */
    public String getTypeSample() {
		return typeSample;
	}

    /**
     *
     * @param typeSample
     */
    public void setTypeSample(String typeSample) {
		this.typeSample = typeSample;
	}

    /**
     *
     * @return
     */
    public Date getStartDate() {
		return startDate;
	}

    /**
     *
     * @param startDate
     */
    public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
}