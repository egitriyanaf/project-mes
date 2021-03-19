/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.entity;

import com.agit.entity.security.JdcAdpMstUser;
import com.agit.entity.util.CustomJsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Where;

/**
 *
 * @author erwin guna setiawan
 */
@javax.persistence.Entity
@Table(name = "jdcadp_txnqctrl")
public class JdcAdpMstAdjustment implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = -4766966230697392291L;
    
    @Id
    @SequenceGenerator(name = "seq_adjust", sequenceName = "seq_adjust", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_adjust")
    
    @Column(name = "qc_id")
    private Long id;
    
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    private Date createDate;

    @Column(name = "created_by")
    private Long createBy;

    @ManyToOne
    @JoinColumn(name = "created_by", insertable = false, nullable = false, updatable = false)
    private JdcAdpMstUser user;
    
//    @ManyToOne
//    @JoinColumn(name = "qc_id", insertable = false, nullable = false, updatable = false)
//    @Where(clause = "update_by is null")
//    private JdcAdpMstAdjGrade adjGrade;

    @Column(name = "last_updated_date")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    private Date updateDate;

    @Column(name = "last_updated_by")
    private Long updateBy;
            
    @Column(name = "area")
    private String area;        
            
    @Column(name = "category")
    private String category;      
            
    @Column(name = "defect")
    private String defect;        
            
    @Column(name = "product_desc")
    private String productDesc;        
            
    @Column(name = "position")
    private String position;        
            
    @Column(name = "product_code")
    private String productCode;        
            
    @Column(name = "po_no")
    private String poNo;        
            
    @Column(name = "po_item")
    private String poItem;        
            
    @Column(name = "type")
    private String type;
    
    @Column(name = "dpt_id")
    private Long dptId;
    
    @Column(name = "line_code")
    private String lineCode;
    
    @Column(name = "sample_request")
    private String sampleRequest;
    
    @Column(name = "demand_class")
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
    
//    /**
//     * @return the adjGrade
//     */
//    public JdcAdpMstAdjGrade getAdjGrade() {
//        return adjGrade;
//    }
//
//    /**
//     * @param adjGrade the adjGrade to set
//     */
//    public void setAdjGrade(JdcAdpMstAdjGrade adjGrade) {
//        this.adjGrade = adjGrade;
//    }
    
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
