package com.agit.entity;

import com.agit.entity.security.JdcAdpMstUser;
import com.agit.entity.util.CustomJsonDateDeserializer;
import com.agit.entity.util.CustomJsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
@Table(name = "jdcadp_txnstock")
public class JdcAdpTxnstock implements Serializable {

    private static final long serialVersionUID = -4766966230697392291L;

    @Id
    @SequenceGenerator(name = "seq_stock", sequenceName = "seq_stock", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_stock")
    @Column(name = "trf_id")
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

    @Column(name = "transfer_to")
    private String transferTo;

    @Column(name = "estimated_date")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date estimatedDate;

    @Column(name = "return_date")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date returnDate;

    @Column(name = "remark")
    private String remark;

    @Column(name = "transfer_qty")
    private Float transferQty;

    @Column(name = "return_qty")
    private Float returnQty;

    @Column(name = "spk_id")
    private Long spkId;

    @ManyToOne
    @JoinColumn(name = "spk_id", insertable = false, nullable = false, updatable = false)
    private JdcAdpMstspk jdcAdpMstspk;
    
    @Column(name = "request_id")
    private Long requestId;

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
    public String getTransferTo() {
        return transferTo;
    }

    /**
     *
     * @param transferTo
     */
    public void setTransferTo(String transferTo) {
        this.transferTo = transferTo;
    }

    /**
     *
     * @return
     */
    public Date getEstimatedDate() {
        return estimatedDate;
    }

    /**
     *
     * @param estimatedDate
     */
    public void setEstimatedDate(Date estimatedDate) {
        this.estimatedDate = estimatedDate;
    }

    /**
     *
     * @return
     */
    public Date getReturnDate() {
        return returnDate;
    }

    /**
     *
     * @param returnDate
     */
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
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
    public Float getTransferQty() {
        return transferQty;
    }

    /**
     *
     * @param transferQty
     */
    public void setTransferQty(Float transferQty) {
        this.transferQty = transferQty;
    }

    /**
     *
     * @return
     */
    public Float getReturnQty() {
        return returnQty;
    }

    /**
     *
     * @param returnQty
     */
    public void setReturnQty(Float returnQty) {
        this.returnQty = returnQty;
    }

    /**
     *
     * @return
     */
    public Long getSpkId() {
        return spkId;
    }

    /**
     *
     * @param spkId
     */
    public void setSpkId(Long spkId) {
        this.spkId = spkId;
    }

    /**
     *
     * @return
     */
    public JdcAdpMstspk getJdcAdpMstspk() {
        return jdcAdpMstspk;
    }

    /**
     *
     * @param jdcAdpMstspk
     */
    public void setJdcAdpMstspk(JdcAdpMstspk jdcAdpMstspk) {
        this.jdcAdpMstspk = jdcAdpMstspk;
    }

    /**
     *
     * @return
     */
    public Long getRequestId() {
        return requestId;
    }

    /**
     *
     * @param requestId
     */
    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    

}
