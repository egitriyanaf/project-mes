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
@Table(name = "jdcadp_mstproduksi")
public class JdcAdpMstproduksi implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4766966230697392291L;

    @Id
    @SequenceGenerator(name = "seq_produksi", sequenceName = "seq_produksi", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produksi")
    @Column(name = "product_id")
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

    @Column(name = "demand_date")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    private Date demandDate;

    @Column(name = "gac_date")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    private Date gacDate;

    @Column(name = "igac_date")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    private Date igacDate;

    @Column(name = "ogac_date")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    private Date ogacDate;

    @Column(name = "rgac_date")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    private Date rgacDate;

    @Column(name = "sch_start_date")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    private Date schStartdate;

    @Column(name = "address1")
    private String address1;

    @Column(name = "address1_line")
    private String addressLine;

    @Column(name = "city")
    private String city;

    @Column(name = "product_desc")
    private String productDesc;

    @Column(name = "fg_desc")
    private String fgDesc;

    @Column(name = "jo_ppic")
    private String joPpic;

    @Column(name = "line_code")
    private String lineCode;

    @Column(name = "po_item")
    private String poItem;

    @Column(name = "po_no")
    private String poNo;

    @Column(name = "qty")
    private Float qty;

    @Column(name = "size")
    private String size;

    @Column(name = "org_id")
    private Long orgId;

    @ManyToOne
    @JoinColumn(name = "org_id", insertable = false, nullable = false, updatable = false)
    private JdcAdpMstorganization organization;

    @Column(name = "flag_log_save")
    private Long logSave;

    @Column(name = "flag_log_submit")
    private Long logSubmit;

    @Column(name = "flag_lot_upload")
    private Long flagUpload;

    @Column(name = "job_order")
    private Long jobOrder;

    @Column(name = "jo_start_date")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date joStartDate;

    @Column(name = "jo_end_date")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date joEndDate;

    @Column(name = "project_alias")
    private String projectAlias;

    @Column(name = "label_ins")
    private String labelIns;

    @Column(name = "demand_class")
    private String demandClass;

    @Column(name = "log_remark")
    private String logRemark;

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
    public Date getDemandDate() {
        return demandDate;
    }

    /**
     *
     * @param demandDate
     */
    public void setDemandDate(Date demandDate) {
        this.demandDate = demandDate;
    }

    /**
     *
     * @return
     */
    public Date getGacDate() {
        return gacDate;
    }

    /**
     *
     * @param gacDate
     */
    public void setGacDate(Date gacDate) {
        this.gacDate = gacDate;
    }

    /**
     *
     * @return
     */
    public Date getIgacDate() {
        return igacDate;
    }

    /**
     *
     * @param igacDate
     */
    public void setIgacDate(Date igacDate) {
        this.igacDate = igacDate;
    }

    /**
     *
     * @return
     */
    public Date getOgacDate() {
        return ogacDate;
    }

    /**
     *
     * @param ogacDate
     */
    public void setOgacDate(Date ogacDate) {
        this.ogacDate = ogacDate;
    }

    /**
     *
     * @return
     */
    public Date getRgacDate() {
        return rgacDate;
    }

    /**
     *
     * @param rgacDate
     */
    public void setRgacDate(Date rgacDate) {
        this.rgacDate = rgacDate;
    }

    /**
     *
     * @return
     */
    public Date getSchStartdate() {
        return schStartdate;
    }

    /**
     *
     * @param schStartdate
     */
    public void setSchStartdate(Date schStartdate) {
        this.schStartdate = schStartdate;
    }

    /**
     *
     * @return
     */
    public String getAddress1() {
        return address1;
    }

    /**
     *
     * @param address1
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     *
     * @return
     */
    public String getAddressLine() {
        return addressLine;
    }

    /**
     *
     * @param addressLine
     */
    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
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
    public String getFgDesc() {
        return fgDesc;
    }

    /**
     *
     * @param fgDesc
     */
    public void setFgDesc(String fgDesc) {
        this.fgDesc = fgDesc;
    }

    /**
     *
     * @return
     */
    public String getJoPpic() {
        return joPpic;
    }

    /**
     *
     * @param joPpic
     */
    public void setJoPpic(String joPpic) {
        this.joPpic = joPpic;
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
    public Float getQty() {
        return qty;
    }

    /**
     *
     * @param qty
     */
    public void setQty(Float qty) {
        this.qty = qty;
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
    public Long getOrgId() {
        return orgId;
    }

    /**
     *
     * @param orgId
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     *
     * @return
     */
    public JdcAdpMstorganization getOrganization() {
        return organization;
    }

    /**
     *
     * @param organization
     */
    public void setOrganization(JdcAdpMstorganization organization) {
        this.organization = organization;
    }

    /**
     *
     * @return
     */
    public Long getLogSave() {
        return logSave;
    }

    /**
     *
     * @param logSave
     */
    public void setLogSave(Long logSave) {
        this.logSave = logSave;
    }

    /**
     *
     * @return
     */
    public Long getLogSubmit() {
        return logSubmit;
    }

    /**
     *
     * @param logSubmit
     */
    public void setLogSubmit(Long logSubmit) {
        this.logSubmit = logSubmit;
    }

    /**
     *
     * @return
     */
    public Long getFlagUpload() {
        return flagUpload;
    }

    /**
     *
     * @param flagUpload
     */
    public void setFlagUpload(Long flagUpload) {
        this.flagUpload = flagUpload;
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
    public Date getJoStartDate() {
        return joStartDate;
    }

    /**
     *
     * @param joStartDate
     */
    public void setJoStartDate(Date joStartDate) {
        this.joStartDate = joStartDate;
    }

    /**
     *
     * @return
     */
    public Date getJoEndDate() {
        return joEndDate;
    }

    /**
     *
     * @param joEndDate
     */
    public void setJoEndDate(Date joEndDate) {
        this.joEndDate = joEndDate;
    }

    /**
     *
     * @return
     */
    public String getProjectAlias() {
        return projectAlias;
    }

    /**
     *
     * @param projectAlias
     */
    public void setProjectAlias(String projectAlias) {
        this.projectAlias = projectAlias;
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

    /**
     *
     * @return
     */
    public String getLogRemark() {
        return logRemark;
    }

    /**
     *
     * @param logRemark
     */
    public void setLogRemark(String logRemark) {
        this.logRemark = logRemark;
    }

}
