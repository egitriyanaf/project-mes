package com.agit.controller.qc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.agit.entity.security.JdcAdpMstUser;
import com.agit.entity.util.CustomJsonDateDeserializer;
import com.agit.entity.util.CustomJsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 *
 * @author erwin
 */
public class AdpProduksiModel {

    private Long id;
    private Date createDate;
    private Long createBy;
    private JdcAdpMstUser user;
    private Date updateDate;
    private Long updateBy;
    private Date demandDate;
    private Date gacDate;
    private Date igacDate;
    private Date ogacDate;
    private Date rgacDate;
    private Date schStartdate;
    private String address1;
    private String addressLine;
    private String city;
    private String productDesc;
    private String fgDesc;
    private String joPpic;
    private String lineCode;
    private String poItem;
    private String poNo;
    private Double qty;
    private String size;
    private Long orgId;
    private Long logSave;
    private Long logSubmit;
    private Long flagUpload;
    private Long jobOrder;
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date joStartDate;
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date joEndDate;
    private String projectAlias;
    private String labelIns;
    private String userType;
    private String remark;
    private String demandClass;

    private List<AdpProduksiDetailModel> lines = new ArrayList<AdpProduksiDetailModel>();
    
    private List<AdpProduksiDtlModel> linesDtl = new ArrayList<AdpProduksiDtlModel>();

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
    public Double getQty() {
        return qty;
    }

    /**
     *
     * @param qty
     */
    public void setQty(Double qty) {
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
    public List<AdpProduksiDetailModel> getLines() {
        return lines;
    }

    /**
     *
     * @param lines
     */
    public void setLines(List<AdpProduksiDetailModel> lines) {
        this.lines = lines;
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
    public String getUserType() {
        return userType;
    }

    /**
     *
     * @param userType
     */
    public void setUserType(String userType) {
        this.userType = userType;
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
    public List<AdpProduksiDtlModel> getLinesDtl() {
        return linesDtl;
    }

    /**
     *
     * @param linesDtl
     */
    public void setLinesDtl(List<AdpProduksiDtlModel> linesDtl) {
        this.linesDtl = linesDtl;
    }

}
