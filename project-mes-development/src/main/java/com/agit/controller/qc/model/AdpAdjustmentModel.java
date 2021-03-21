/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.controller.qc.model;

import com.agit.entity.security.JdcAdpMstUser;
import java.util.Date;

/**
 *
 * @author erwin
 */
public class AdpAdjustmentModel {

    private Long id;
    private Date createDate;
    private Long createBy;
    private JdcAdpMstUser user;
    private Date updateDate;
    private Long updateBy;
    private String area;
    private String category;
    private String defect;
    private String productDesc;
    private String position;
    private String productCode;
    private String poNo;
    private String poItem;
    private String type;
    private Long dptId;
    private String lineCode;
    private String sampleRequest;
    private String demandClass;
    
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return the createBy
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy the createBy to set
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * @return the user
     */
    public JdcAdpMstUser getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(JdcAdpMstUser user) {
        this.user = user;
    }

    /**
     * @return the updateDate
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate the updateDate to set
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * @return the updateBy
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * @param updateBy the updateBy to set
     */
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the defect
     */
    public String getDefect() {
        return defect;
    }

    /**
     * @param defect the defect to set
     */
    public void setDefect(String defect) {
        this.defect = defect;
    }

    /**
     * @return the productDesc
     */
    public String getProductDesc() {
        return productDesc;
    }

    /**
     * @param productDesc the productDesc to set
     */
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the productCode
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * @param productCode the productCode to set
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    /**
     * @return the poNo
     */
    public String getPoNo() {
        return poNo;
    }

    /**
     * @param poNo the poNo to set
     */
    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    /**
     * @return the poItem
     */
    public String getPoItem() {
        return poItem;
    }

    /**
     * @param poItem the poItem to set
     */
    public void setPoItem(String poItem) {
        this.poItem = poItem;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the dptId
     */
    public Long getDptId() {
        return dptId;
    }

    /**
     * @param dptId the dptId to set
     */
    public void setDptId(Long dptId) {
        this.dptId = dptId;
    }

    /**
     * @return the lineCode
     */
    public String getLineCode() {
        return lineCode;
    }

    /**
     * @param lineCode the lineCode to set
     */
    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    /**
     * @return the sampleRequest
     */
    public String getSampleRequest() {
        return sampleRequest;
    }

    /**
     * @param sampleRequest the sampleRequest to set
     */
    public void setSampleRequest(String sampleRequest) {
        this.sampleRequest = sampleRequest;
    }

    /**
     * @return the demandClass
     */
    public String getDemandClass() {
        return demandClass;
    }

    /**
     * @param demandClass the demandClass to set
     */
    public void setDemandClass(String demandClass) {
        this.demandClass = demandClass;
    }
    
}
