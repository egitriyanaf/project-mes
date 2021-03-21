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
import com.agit.entity.util.CustomJsonDatetimeSerializer;

/**
 *
 * @author erwin
 */
@Entity
@Table(name = "jdcadp_txnqctrl")
public class JdcAdpTxnqcctrl implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4766966230697392291L;

    @Id
    @SequenceGenerator(name = "seq_qctrl", sequenceName = "seq_qctrl", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_qctrl")
    @Column(name = "qc_id")
    private Long id;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = CustomJsonDatetimeSerializer.class)
    private Date createDate;

    @Column(name = "created_by")
    private Long createBy;

    @ManyToOne
    @JoinColumn(name = "created_by", insertable = false, nullable = false, updatable = false)
    private JdcAdpMstUser user;

    @Column(name = "last_updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = CustomJsonDatetimeSerializer.class)
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
    private String sampleReq;

    @Column(name = "demand_class")
    private String demandClass;

    @ManyToOne
    @JoinColumn(name = "dpt_id", insertable = false, nullable = false, updatable = false)
    private JdcAdpMstdepartement departemen;

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
    public String getArea() {
        return area;
    }

    /**
     *
     * @param area
     */
    public void setArea(String area) {
        this.area = area;
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
    public String getDefect() {
        return defect;
    }

    /**
     *
     * @param defect
     */
    public void setDefect(String defect) {
        this.defect = defect;
    }

    /**
     *
     * @return
     */
    public String getProductDesc() {
        return productDesc;
    }

    /**
     *
     * @param productDesc
     */
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    /**
     *
     * @return
     */
    public String getPosition() {
        return position;
    }

    /**
     *
     * @param position
     */
    public void setPosition(String position) {
        this.position = position;
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
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public Long getDptId() {
        return dptId;
    }

    /**
     *
     * @param dptId
     */
    public void setDptId(Long dptId) {
        this.dptId = dptId;
    }

    /**
     *
     * @return
     */
    public JdcAdpMstdepartement getDepartemen() {
        return departemen;
    }

    /**
     *
     * @param departemen
     */
    public void setDepartemen(JdcAdpMstdepartement departemen) {
        this.departemen = departemen;
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
