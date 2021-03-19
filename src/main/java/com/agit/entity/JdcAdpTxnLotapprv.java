package com.agit.entity;

import com.agit.entity.security.JdcAdpMstUser;
import com.agit.entity.util.CustomJsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ridwans
 */
@Entity
@Table(name = "jdcadp_txnlotapprv")
public class JdcAdpTxnLotapprv implements Serializable {

    private static final long serialVersionUID = -4766966230697392291L;

    @Id
    @SequenceGenerator(name = "seq_lotapprv", sequenceName = "seq_lotapprv", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_lotapprv")
    @Column(name = "lotapprv_id")
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

    @Column(name = "hourly")
    private Long hourly;

    @Column(name = "size_1")
    private Long size1;

    @Column(name = "size_1_t")
    private Long size1T;

    @Column(name = "size_2")
    private Long size2;

    @Column(name = "size_2_t")
    private Long size2T;

    @Column(name = "size_3")
    private Long size3;

    @Column(name = "size_3_t")
    private Long size3T;

    @Column(name = "size_4")
    private Long size4;

    @Column(name = "size_4_t")
    private Long size4T;

    @Column(name = "size_5")
    private Long size5;

    @Column(name = "size_5_t")
    private Long size5T;

    @Column(name = "size_6")
    private Long size6;

    @Column(name = "size_6_t")
    private Long size6T;

    @Column(name = "size_7")
    private Long size7;

    @Column(name = "size_7_t")
    private Long size7T;

    @Column(name = "size_8")
    private Long size8;

    @Column(name = "size_8_t")
    private Long size8T;

    @Column(name = "size_9")
    private Long size9;

    @Column(name = "size_9_t")
    private Long size9T;

    @Column(name = "size_10")
    private Long size10;

    @Column(name = "size_10_t")
    private Long size10T;

    @Column(name = "size_11")
    private Long size11;

    @Column(name = "size_11_t")
    private Long size11T;

    @Column(name = "size_12")
    private Long size12;

    @Column(name = "size_12_t")
    private Long size12T;

    @Column(name = "size_13")
    private Long size13;

    @Column(name = "size_13_t")
    private Long size13T;

    @Column(name = "size_14")
    private Long size14;

    @Column(name = "size_15")
    private Long size15;

    @Column(name = "size_16")
    private Long size16;

    @Column(name = "size_17")
    private Long size17;

    @Column(name = "size_18")
    private Long size18;

    @Column(name = "approve_1")
    private Long approve1;

    @Column(name = "approve_2")
    private Long approve2;

    @Column(name = "assign_to")
    private Long assignTo;

    @Column(name = "persentase")
    private Long persentase;

    @Column(name = "status")
    private Long status;

    @Column(name = "line_code")
    private String lineCode;

    @Column(name = "po_item")
    private String poItem;

    @Column(name = "po_no")
    private String poNo;

    @Column(name = "remark")
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
    public Long getHourly() {
        return hourly;
    }

    /**
     *
     * @param hourly
     */
    public void setHourly(Long hourly) {
        this.hourly = hourly;
    }

    /**
     *
     * @return
     */
    public Long getSize1() {
        return size1;
    }

    /**
     *
     * @param size1
     */
    public void setSize1(Long size1) {
        this.size1 = size1;
    }

    /**
     *
     * @return
     */
    public Long getSize1T() {
        return size1T;
    }

    /**
     *
     * @param size1T
     */
    public void setSize1T(Long size1T) {
        this.size1T = size1T;
    }

    /**
     *
     * @return
     */
    public Long getSize2() {
        return size2;
    }

    /**
     *
     * @param size2
     */
    public void setSize2(Long size2) {
        this.size2 = size2;
    }

    /**
     *
     * @return
     */
    public Long getSize2T() {
        return size2T;
    }

    /**
     *
     * @param size2T
     */
    public void setSize2T(Long size2T) {
        this.size2T = size2T;
    }

    /**
     *
     * @return
     */
    public Long getSize3() {
        return size3;
    }

    /**
     *
     * @param size3
     */
    public void setSize3(Long size3) {
        this.size3 = size3;
    }

    /**
     *
     * @return
     */
    public Long getSize3T() {
        return size3T;
    }

    /**
     *
     * @param size3T
     */
    public void setSize3T(Long size3T) {
        this.size3T = size3T;
    }

    /**
     *
     * @return
     */
    public Long getSize4() {
        return size4;
    }

    /**
     *
     * @param size4
     */
    public void setSize4(Long size4) {
        this.size4 = size4;
    }

    /**
     *
     * @return
     */
    public Long getSize4T() {
        return size4T;
    }

    /**
     *
     * @param size4T
     */
    public void setSize4T(Long size4T) {
        this.size4T = size4T;
    }

    /**
     *
     * @return
     */
    public Long getSize5() {
        return size5;
    }

    /**
     *
     * @param size5
     */
    public void setSize5(Long size5) {
        this.size5 = size5;
    }

    /**
     *
     * @return
     */
    public Long getSize5T() {
        return size5T;
    }

    /**
     *
     * @param size5T
     */
    public void setSize5T(Long size5T) {
        this.size5T = size5T;
    }

    /**
     *
     * @return
     */
    public Long getSize6() {
        return size6;
    }

    /**
     *
     * @param size6
     */
    public void setSize6(Long size6) {
        this.size6 = size6;
    }

    /**
     *
     * @return
     */
    public Long getSize6T() {
        return size6T;
    }

    /**
     *
     * @param size6T
     */
    public void setSize6T(Long size6T) {
        this.size6T = size6T;
    }

    /**
     *
     * @return
     */
    public Long getSize7() {
        return size7;
    }

    /**
     *
     * @param size7
     */
    public void setSize7(Long size7) {
        this.size7 = size7;
    }

    /**
     *
     * @return
     */
    public Long getSize7T() {
        return size7T;
    }

    /**
     *
     * @param size7T
     */
    public void setSize7T(Long size7T) {
        this.size7T = size7T;
    }

    /**
     *
     * @return
     */
    public Long getSize8() {
        return size8;
    }

    /**
     *
     * @param size8
     */
    public void setSize8(Long size8) {
        this.size8 = size8;
    }

    /**
     *
     * @return
     */
    public Long getSize8T() {
        return size8T;
    }

    /**
     *
     * @param size8T
     */
    public void setSize8T(Long size8T) {
        this.size8T = size8T;
    }

    /**
     *
     * @return
     */
    public Long getSize9() {
        return size9;
    }

    /**
     *
     * @param size9
     */
    public void setSize9(Long size9) {
        this.size9 = size9;
    }

    /**
     *
     * @return
     */
    public Long getSize9T() {
        return size9T;
    }

    /**
     *
     * @param size9T
     */
    public void setSize9T(Long size9T) {
        this.size9T = size9T;
    }

    /**
     *
     * @return
     */
    public Long getSize10() {
        return size10;
    }

    /**
     *
     * @param size10
     */
    public void setSize10(Long size10) {
        this.size10 = size10;
    }

    /**
     *
     * @return
     */
    public Long getSize10T() {
        return size10T;
    }

    /**
     *
     * @param size10T
     */
    public void setSize10T(Long size10T) {
        this.size10T = size10T;
    }

    /**
     *
     * @return
     */
    public Long getSize11() {
        return size11;
    }

    /**
     *
     * @param size11
     */
    public void setSize11(Long size11) {
        this.size11 = size11;
    }

    /**
     *
     * @return
     */
    public Long getSize11T() {
        return size11T;
    }

    /**
     *
     * @param size11T
     */
    public void setSize11T(Long size11T) {
        this.size11T = size11T;
    }

    /**
     *
     * @return
     */
    public Long getSize12() {
        return size12;
    }

    /**
     *
     * @param size12
     */
    public void setSize12(Long size12) {
        this.size12 = size12;
    }

    /**
     *
     * @return
     */
    public Long getSize12T() {
        return size12T;
    }

    /**
     *
     * @param size12T
     */
    public void setSize12T(Long size12T) {
        this.size12T = size12T;
    }

    /**
     *
     * @return
     */
    public Long getSize13() {
        return size13;
    }

    /**
     *
     * @param size13
     */
    public void setSize13(Long size13) {
        this.size13 = size13;
    }

    /**
     *
     * @return
     */
    public Long getSize13T() {
        return size13T;
    }

    /**
     *
     * @param size13T
     */
    public void setSize13T(Long size13T) {
        this.size13T = size13T;
    }

    /**
     *
     * @return
     */
    public Long getSize14() {
        return size14;
    }

    /**
     *
     * @param size14
     */
    public void setSize14(Long size14) {
        this.size14 = size14;
    }

    /**
     *
     * @return
     */
    public Long getSize15() {
        return size15;
    }

    /**
     *
     * @param size15
     */
    public void setSize15(Long size15) {
        this.size15 = size15;
    }

    /**
     *
     * @return
     */
    public Long getSize16() {
        return size16;
    }

    /**
     *
     * @param size16
     */
    public void setSize16(Long size16) {
        this.size16 = size16;
    }

    /**
     *
     * @return
     */
    public Long getSize17() {
        return size17;
    }

    /**
     *
     * @param size17
     */
    public void setSize17(Long size17) {
        this.size17 = size17;
    }

    /**
     *
     * @return
     */
    public Long getSize18() {
        return size18;
    }

    /**
     *
     * @param size18
     */
    public void setSize18(Long size18) {
        this.size18 = size18;
    }

    /**
     *
     * @return
     */
    public Long getApprove1() {
        return approve1;
    }

    /**
     *
     * @param approve1
     */
    public void setApprove1(Long approve1) {
        this.approve1 = approve1;
    }

    /**
     *
     * @return
     */
    public Long getApprove2() {
        return approve2;
    }

    /**
     *
     * @param approve2
     */
    public void setApprove2(Long approve2) {
        this.approve2 = approve2;
    }

    /**
     *
     * @return
     */
    public Long getAssignTo() {
        return assignTo;
    }

    /**
     *
     * @param assignTo
     */
    public void setAssignTo(Long assignTo) {
        this.assignTo = assignTo;
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
    public Long getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(Long status) {
        this.status = status;
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
