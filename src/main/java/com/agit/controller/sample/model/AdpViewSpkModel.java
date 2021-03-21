package com.agit.controller.sample.model;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.agit.entity.util.CustomJsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
*
* @author ridwans
*/
public class AdpViewSpkModel {
	
	private Long id;
	@Temporal(TemporalType.DATE)
	@JsonSerialize(using=CustomJsonDateSerializer.class)
	private Date createDate ;
	private Long createBy ;
	@Temporal(TemporalType.DATE)
	@JsonSerialize(using=CustomJsonDateSerializer.class)
	private Date updateDate ;
	private Long updateBy;
	@Temporal(TemporalType.DATE)
	@JsonSerialize(using=CustomJsonDateSerializer.class)
	private Date etc_date;
	private String category;
	private String model;
	private String product_code;
	private Double qty;
	private String sample_req;
	private String season;
	private String size;
	private String type_sample;
	@Temporal(TemporalType.DATE)
	@JsonSerialize(using=CustomJsonDateSerializer.class)
	private Date start_date;
	
	private Double assmblyIn;
	private Double assmblyOut;
	private Double cuttingIn;
	private Double cuttingOut;
	private Double sewingIn;
	private Double sewingOut;
	private Double stokfitIn;
	private Double stokfitOut;

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
    public Date getEtc_date() {
		return etc_date;
	}

    /**
     *
     * @param etc_date
     */
    public void setEtc_date(Date etc_date) {
		this.etc_date = etc_date;
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
    public String getProduct_code() {
		return product_code;
	}

    /**
     *
     * @param product_code
     */
    public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

    /**
     *
     * @return
     */
    public Double getQty() {
		return qty;
	}

    /**
     *
     * @param qty
     */
    public void setQty(Double qty) {
		this.qty = qty;
	}

    /**
     *
     * @return
     */
    public String getSample_req() {
		return sample_req;
	}

    /**
     *
     * @param sample_req
     */
    public void setSample_req(String sample_req) {
		this.sample_req = sample_req;
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
    public String getType_sample() {
		return type_sample;
	}

    /**
     *
     * @param type_sample
     */
    public void setType_sample(String type_sample) {
		this.type_sample = type_sample;
	}

    /**
     *
     * @return
     */
    public Date getStart_date() {
		return start_date;
	}

    /**
     *
     * @param start_date
     */
    public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

    /**
     *
     * @return
     */
    public Double getAssmblyIn() {
		return assmblyIn;
	}

    /**
     *
     * @param assmblyIn
     */
    public void setAssmblyIn(Double assmblyIn) {
		this.assmblyIn = assmblyIn;
	}

    /**
     *
     * @return
     */
    public Double getAssmblyOut() {
		return assmblyOut;
	}

    /**
     *
     * @param assmblyOut
     */
    public void setAssmblyOut(Double assmblyOut) {
		this.assmblyOut = assmblyOut;
	}

    /**
     *
     * @return
     */
    public Double getCuttingIn() {
		return cuttingIn;
	}

    /**
     *
     * @param cuttingIn
     */
    public void setCuttingIn(Double cuttingIn) {
		this.cuttingIn = cuttingIn;
	}

    /**
     *
     * @return
     */
    public Double getCuttingOut() {
		return cuttingOut;
	}

    /**
     *
     * @param cuttingOut
     */
    public void setCuttingOut(Double cuttingOut) {
		this.cuttingOut = cuttingOut;
	}

    /**
     *
     * @return
     */
    public Double getSewingIn() {
		return sewingIn;
	}

    /**
     *
     * @param sewingIn
     */
    public void setSewingIn(Double sewingIn) {
		this.sewingIn = sewingIn;
	}

    /**
     *
     * @return
     */
    public Double getSewingOut() {
		return sewingOut;
	}

    /**
     *
     * @param sewingOut
     */
    public void setSewingOut(Double sewingOut) {
		this.sewingOut = sewingOut;
	}

    /**
     *
     * @return
     */
    public Double getStokfitIn() {
		return stokfitIn;
	}

    /**
     *
     * @param stokfitIn
     */
    public void setStokfitIn(Double stokfitIn) {
		this.stokfitIn = stokfitIn;
	}

    /**
     *
     * @return
     */
    public Double getStokfitOut() {
		return stokfitOut;
	}

    /**
     *
     * @param stokfitOut
     */
    public void setStokfitOut(Double stokfitOut) {
		this.stokfitOut = stokfitOut;
	}
	
}
