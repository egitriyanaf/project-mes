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

/**
 *
 * @author erwin guna setiawan
 */
@javax.persistence.Entity
@Table(name = "jdcadp_grade")
public class JdcAdpMstAdjGrade implements Serializable {
    private static final long serialVersionUID = -4766966230697392291L;
    @Id
    @SequenceGenerator(name = "seq_grade", sequenceName = "seq_grade", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_grade")
    
    @Column(name = "grade_id")
    private Long id;
    
    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    private Date createDate;

    @Column(name = "created_by")
    private Long createBy;
    
    @ManyToOne
    @JoinColumn(name = "created_by", insertable = false, nullable = false, updatable = false)
    private JdcAdpMstUser user;
    
    @Column(name = "updated_date")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    private Date updateDate;

    @Column(name = "update_by")
    private Long updateBy;
    
    @Column(name = "qc_id")
    private Long qcId;
    
    @Column(name = "product_code")
    private String productCode;
    
    @Column(name = "po_no")
    private String poNo;        
            
    @Column(name = "po_item")
    private String poItem;        
            
    @Column(name = "type")
    private String type;
    
    @Column(name = "line_code")
    private String lineCode;
    
    @Column(name = "area")
    private String area;
    
    @Column(name = "demand_class")
    private String demandClass;
    
    @Column(name = "type_update")
    private String typeUpdate;
    
    @Column(name = "size_")
    private String size;
    
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
     * @return the qcId
     */
    public Long getQcId() {
        return qcId;
    }

    /**
     * @param qcId the qcId to set
     */
    public void setQcId(Long qcId) {
        this.qcId = qcId;
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

    /**
     * @return the typeUpdate
     */
    public String getTypeUpdate() {
        return typeUpdate;
    }

    /**
     * @param typeUpdate the typeUpdate to set
     */
    public void setTypeUpdate(String typeUpdate) {
        this.typeUpdate = typeUpdate;
    }

    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
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
}
