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

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.entity.util.CustomJsonDateDeserializer;
import com.agit.entity.util.CustomJsonDateSerializer;

/**
 *
 * @author erwin
 */
@Entity
@Table(name = "jdcadp_txnlogsummarydtl")
public class JdcAdpTxnLogsummaryDtl implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4766966230697392291L;

    @Id
    @SequenceGenerator(name = "seq_summary_dtl", sequenceName = "seq_summary_dtl", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_summary_dtl")
    @Column(name = "log_id")
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

    @Column(name = "last_updated_date")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    private Date updateDate;

    @Column(name = "last_updated_by")
    private Long updateBy;

    @Column(name = "input_date")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date inputDate;

//    @Column(name = "size_")
//    private Long size;
    @Column(name = "size_")
    private String size;

    @Column(name = "line_code")
    private String lineCode;

    @Column(name = "po_item")
    private String poItem;

    @Column(name = "po_no")
    private String poNo;

    @Column(name = "flag_save")
    private Long save;

    @Column(name = "flag_submit")
    private Long submit;

    @Column(name = "remark")
    private String remark;
    
    @Column(name = "spec_lace")
    private Long specLace;

    @Column(name = "actual_lace")
    private Long actualLace;

    @Column(name = "category_lace")
    private String categoryLace;
    
    @Column(name = "spec_heel")
    private Long specHeel;

    @Column(name = "left_heel")
    private Long leftHeel;
    
    @Column(name = "right_heel")
    private Long rightHeel;

    @Column(name = "category_heel")
    private String categoryHeel;

    @Column(name = "spec_medial")
    private Long specMedial;

    @Column(name = "left_medial")
    private Long leftMedial;
    
    @Column(name = "right_medial")
    private Long rightMedial;

    @Column(name = "category_medial")
    private String categoryMedial;
    
    @Column(name = "spec_lateral")
    private Long specLateral;

    @Column(name = "left_lateral")
    private Long leftLateral;
    
    @Column(name = "right_lateral")
    private Long rightLateral;

    @Column(name = "category_lateral")
    private String categoryLateral;

    @Column(name = "spec_ibox")
    private Long specIbox;

    @Column(name = "actual_ibox")
    private Long actualIbox;

    @Column(name = "category_ibox")
    private String categoryIbox;
    
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

//    /**
//     *
//     * @return
//     */
//    public Long getSize() {
//        return size;
//    }
//
//    /**
//     *
//     * @param size
//     */
//    public void setSize(Long size) {
//        this.size = size;
//    }

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

    /**
     *
     * @return
     */
    public Long getSpecLace() {
        return specLace;
    }

    /**
     *
     * @param specLace
     */
    public void setSpecLace(Long specLace) {
        this.specLace = specLace;
    }

    /**
     *
     * @return
     */
    public Long getActualLace() {
        return actualLace;
    }

    /**
     *
     * @param actualLace
     */
    public void setActualLace(Long actualLace) {
        this.actualLace = actualLace;
    }

    /**
     *
     * @return
     */
    public String getCategoryLace() {
        return categoryLace;
    }

    /**
     *
     * @param categoryLace
     */
    public void setCategoryLace(String categoryLace) {
        this.categoryLace = categoryLace;
    }

    /**
     *
     * @return
     */
    public Long getSpecHeel() {
        return specHeel;
    }

    /**
     *
     * @param specHeel
     */
    public void setSpecHeel(Long specHeel) {
        this.specHeel = specHeel;
    }

    /**
     *
     * @return
     */
    public Long getLeftHeel() {
        return leftHeel;
    }

    /**
     *
     * @param leftHeel
     */
    public void setLeftHeel(Long leftHeel) {
        this.leftHeel = leftHeel;
    }

    /**
     *
     * @return
     */
    public Long getRightHeel() {
        return rightHeel;
    }

    /**
     *
     * @param rightHeel
     */
    public void setRightHeel(Long rightHeel) {
        this.rightHeel = rightHeel;
    }

    /**
     *
     * @return
     */
    public String getCategoryHeel() {
        return categoryHeel;
    }

    /**
     *
     * @param categoryHeel
     */
    public void setCategoryHeel(String categoryHeel) {
        this.categoryHeel = categoryHeel;
    }

    /**
     *
     * @return
     */
    public Long getSpecMedial() {
        return specMedial;
    }

    /**
     *
     * @param specMedial
     */
    public void setSpecMedial(Long specMedial) {
        this.specMedial = specMedial;
    }

    /**
     *
     * @return
     */
    public Long getLeftMedial() {
        return leftMedial;
    }

    /**
     *
     * @param leftMedial
     */
    public void setLeftMedial(Long leftMedial) {
        this.leftMedial = leftMedial;
    }

    /**
     *
     * @return
     */
    public Long getRightMedial() {
        return rightMedial;
    }

    /**
     *
     * @param rightMedial
     */
    public void setRightMedial(Long rightMedial) {
        this.rightMedial = rightMedial;
    }

    /**
     *
     * @return
     */
    public String getCategoryMedial() {
        return categoryMedial;
    }

    /**
     *
     * @param categoryMedial
     */
    public void setCategoryMedial(String categoryMedial) {
        this.categoryMedial = categoryMedial;
    }

    /**
     *
     * @return
     */
    public Long getSpecLateral() {
        return specLateral;
    }

    /**
     *
     * @param specLateral
     */
    public void setSpecLateral(Long specLateral) {
        this.specLateral = specLateral;
    }

    /**
     *
     * @return
     */
    public Long getLeftLateral() {
        return leftLateral;
    }

    /**
     *
     * @param leftLateral
     */
    public void setLeftLateral(Long leftLateral) {
        this.leftLateral = leftLateral;
    }

    /**
     *
     * @return
     */
    public Long getRightLateral() {
        return rightLateral;
    }

    /**
     *
     * @param rightLateral
     */
    public void setRightLateral(Long rightLateral) {
        this.rightLateral = rightLateral;
    }

    /**
     *
     * @return
     */
    public String getCategoryLateral() {
        return categoryLateral;
    }

    /**
     *
     * @param categoryLateral
     */
    public void setCategoryLateral(String categoryLateral) {
        this.categoryLateral = categoryLateral;
    }

    /**
     *
     * @return
     */
    public Long getSpecIbox() {
        return specIbox;
    }

    /**
     *
     * @param specIbox
     */
    public void setSpecIbox(Long specIbox) {
        this.specIbox = specIbox;
    }

    /**
     *
     * @return
     */
    public Long getActualIbox() {
        return actualIbox;
    }

    /**
     *
     * @param actualIbox
     */
    public void setActualIbox(Long actualIbox) {
        this.actualIbox = actualIbox;
    }

    /**
     *
     * @return
     */
    public String getCategoryIbox() {
        return categoryIbox;
    }

    /**
     *
     * @param categoryIbox
     */
    public void setCategoryIbox(String categoryIbox) {
        this.categoryIbox = categoryIbox;
    }


}
