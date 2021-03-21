package com.agit.controller.qc.model;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.agit.entity.util.CustomJsonDateDeserializer;
import com.agit.entity.util.CustomJsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 *
 * @author erwin
 */
public class AdpProduksiDetailModel {
	private Long id;
	private Date createDate ;
	private Long createBy ;
	private Date updateDate ;
	private Long updateBy;
	@Temporal(TemporalType.DATE)
	@JsonSerialize(using=CustomJsonDateSerializer.class)
	@JsonDeserialize(using=CustomJsonDateDeserializer.class)
	private Date inputDate ;
	private Long partial ;
	private Long totalPairs ;
	private Long cartoon ;
	private Long sample ;
	private Long pairs;
	private Long persentase ;
	private String code ;
	private String issue ;
	private String result ;
	private String lineCode ;
	private String poItem ;
	private String poNo ;
	private Long save ;
	private Long submit;
	private String remark;
	
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
    public Date getInputDate() {
		return inputDate;
	}

    /**
     *
     * @param inputDate
     */
    public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

    /**
     *
     * @return
     */
    public Long getPartial() {
		return partial;
	}

    /**
     *
     * @param partial
     */
    public void setPartial(Long partial) {
		this.partial = partial;
	}

    /**
     *
     * @return
     */
    public Long getTotalPairs() {
		return totalPairs;
	}

    /**
     *
     * @param totalPairs
     */
    public void setTotalPairs(Long totalPairs) {
		this.totalPairs = totalPairs;
	}

    /**
     *
     * @return
     */
    public Long getCartoon() {
		return cartoon;
	}

    /**
     *
     * @param cartoon
     */
    public void setCartoon(Long cartoon) {
		this.cartoon = cartoon;
	}

    /**
     *
     * @return
     */
    public Long getSample() {
		return sample;
	}

    /**
     *
     * @param sample
     */
    public void setSample(Long sample) {
		this.sample = sample;
	}

    /**
     *
     * @return
     */
    public Long getPairs() {
		return pairs;
	}

    /**
     *
     * @param pairs
     */
    public void setPairs(Long pairs) {
		this.pairs = pairs;
	}

    /**
     *
     * @return
     */
    public Long getPersentase() {
		return persentase;
	}

    /**
     *
     * @param persentase
     */
    public void setPersentase(Long persentase) {
		this.persentase = persentase;
	}

    /**
     *
     * @return
     */
    public String getCode() {
		return code;
	}

    /**
     *
     * @param code
     */
    public void setCode(String code) {
		this.code = code;
	}

    /**
     *
     * @return
     */
    public String getIssue() {
		return issue;
	}

    /**
     *
     * @param issue
     */
    public void setIssue(String issue) {
		this.issue = issue;
	}

    /**
     *
     * @return
     */
    public String getResult() {
		return result;
	}

    /**
     *
     * @param result
     */
    public void setResult(String result) {
		this.result = result;
	}

    /**
     *
     * @return
     */
    public String getLineCode() {
		return lineCode;
	}

    /**
     *
     * @param lineCode
     */
    public void setLineCode(String lineCode) {
		this.lineCode = lineCode;
	}

    /**
     *
     * @return
     */
    public String getPoItem() {
		return poItem;
	}

    /**
     *
     * @param poItem
     */
    public void setPoItem(String poItem) {
		this.poItem = poItem;
	}

    /**
     *
     * @return
     */
    public String getPoNo() {
		return poNo;
	}

    /**
     *
     * @param poNo
     */
    public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

    /**
     *
     * @return
     */
    public Long getSave() {
		return save;
	}

    /**
     *
     * @param save
     */
    public void setSave(Long save) {
		this.save = save;
	}

    /**
     *
     * @return
     */
    public Long getSubmit() {
		return submit;
	}

    /**
     *
     * @param submit
     */
    public void setSubmit(Long submit) {
		this.submit = submit;
	}

    /**
     *
     * @return
     */
    public String getRemark() {
		return remark;
	}

    /**
     *
     * @param remark
     */
    public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
