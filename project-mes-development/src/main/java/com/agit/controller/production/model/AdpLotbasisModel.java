package com.agit.controller.production.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.agit.entity.util.CustomJsonDateDeserializer;
import com.agit.entity.util.CustomJsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 *
 * @author ridwan s
 */

public class AdpLotbasisModel {
	private Long id;
	private String lineCode;
	private String poItem;
	private String poNo;
        private String demandClass;
	private Long jobOrder;
	@Temporal(TemporalType.DATE)
	@JsonSerialize(using=CustomJsonDateSerializer.class)
	@JsonDeserialize(using=CustomJsonDateDeserializer.class)
	private Date jobStart;
	@Temporal(TemporalType.DATE)
	@JsonSerialize(using=CustomJsonDateSerializer.class)
	@JsonDeserialize(using=CustomJsonDateDeserializer.class)
	private Date jobStop;
	private String alias;
	private String labelIns;
	private List<AdpLotbasisDetailModel> lines ;
	
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
    public Long getJobOrder() {
		return jobOrder;
	}

    /**
     *
     * @param jobOrder
     */
    public void setJobOrder(Long jobOrder) {
		this.jobOrder = jobOrder;
	}

    /**
     *
     * @return
     */
    public Date getJobStart() {
		return jobStart;
	}

    /**
     *
     * @param jobStart
     */
    public void setJobStart(Date jobStart) {
		this.jobStart = jobStart;
	}

    /**
     *
     * @return
     */
    public Date getJobStop() {
		return jobStop;
	}

    /**
     *
     * @param jobStop
     */
    public void setJobStop(Date jobStop) {
		this.jobStop = jobStop;
	}

    /**
     *
     * @return
     */
    public String getAlias() {
		return alias;
	}

    /**
     *
     * @param alias
     */
    public void setAlias(String alias) {
		this.alias = alias;
	}

    /**
     *
     * @return
     */
    public String getLabelIns() {
		return labelIns;
	}

    /**
     *
     * @param labelIns
     */
    public void setLabelIns(String labelIns) {
		this.labelIns = labelIns;
	}

    /**
     *
     * @return
     */
    public List<AdpLotbasisDetailModel> getLines() {
		return lines;
	}

    /**
     *
     * @param lines
     */
    public void setLines(List<AdpLotbasisDetailModel> lines) {
		this.lines = lines;
	}

    /**
     *
     * @return
     */
    public String getDemandClass() {
        return demandClass;
    }

    /**
     *
     * @param demandClass
     */
    public void setDemandClass(String demandClass) {
        this.demandClass = demandClass;
    }
	
}
