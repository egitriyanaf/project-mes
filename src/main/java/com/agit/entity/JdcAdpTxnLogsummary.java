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
@Table(name = "jdcadp_txnlogsummary")
public class JdcAdpTxnLogsummary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4766966230697392291L;

	@Id
	@SequenceGenerator(name = "seq_summary", sequenceName = "seq_summary", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_summary")
	@Column(name = "log_id")
	private Long id;
	
	@Column(name="created_date")
	@Temporal(TemporalType.DATE)
	@JsonSerialize(using=CustomJsonDateSerializer.class)
	private Date createDate ;
	
	@Column(name="created_by")
	private Long createBy ;
	
	@ManyToOne
	@JoinColumn(name="created_by" ,insertable = false, nullable=false,updatable = false)
	private JdcAdpMstUser user;
	
	@Column(name="last_updated_date")
	@Temporal(TemporalType.DATE)
	@JsonSerialize(using=CustomJsonDateSerializer.class)
	private Date updateDate ;
	
	@Column(name="last_updated_by")
	private Long updateBy;
	
	@Column(name="input_date")
	@Temporal(TemporalType.DATE)
	@JsonSerialize(using=CustomJsonDateSerializer.class)
	@JsonDeserialize(using=CustomJsonDateDeserializer.class)
	private Date inputDate ;
	
	@Column(name="partial")
	private Long partial ;
	
	@Column(name="total_pairs")
	private Long totalPairs ;
	
	@Column(name="cartoon")
	private Long cartoon ;
	
	@Column(name="sample")
	private Long sample ;
	
	@Column(name="pairs")
	private Long pairs;
	
	@Column(name="persentase")
	private Long persentase ;
	
	@Column(name="code")
	private String code ;
	
	@Column(name="issue")
	private String issue ;
	
	@Column(name="result")
	private String result ;
	
	@Column(name="line_code")
	private String lineCode ;
	
	@Column(name="po_item")
	private String poItem ;
	
	@Column(name="po_no")
	private String poNo ;
	
	@Column(name="flag_save")
	private Long save ;
	
	@Column(name="flag_submit")
	private Long submit;
	
	@Column(name="remark")
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
     *
     * @return
     */
    public Long getPartial() {
		return partial;
	}

    /**
     *
     * @param partial
     */
    public void setPartial(Long partial) {
		this.partial = partial;
	}

    /**
     *
     * @return
     */
    public Long getTotalPairs() {
		return totalPairs;
	}

    /**
     *
     * @param totalPairs
     */
    public void setTotalPairs(Long totalPairs) {
		this.totalPairs = totalPairs;
	}

    /**
     *
     * @return
     */
    public Long getCartoon() {
		return cartoon;
	}

    /**
     *
     * @param cartoon
     */
    public void setCartoon(Long cartoon) {
		this.cartoon = cartoon;
	}

    /**
     *
     * @return
     */
    public Long getSample() {
		return sample;
	}

    /**
     *
     * @param sample
     */
    public void setSample(Long sample) {
		this.sample = sample;
	}

    /**
     *
     * @return
     */
    public Long getPairs() {
		return pairs;
	}

    /**
     *
     * @param pairs
     */
    public void setPairs(Long pairs) {
		this.pairs = pairs;
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
    public String getCode() {
		return code;
	}

    /**
     *
     * @param code
     */
    public void setCode(String code) {
		this.code = code;
	}

    /**
     *
     * @return
     */
    public String getIssue() {
		return issue;
	}

    /**
     *
     * @param issue
     */
    public void setIssue(String issue) {
		this.issue = issue;
	}

    /**
     *
     * @return
     */
    public String getResult() {
		return result;
	}

    /**
     *
     * @param result
     */
    public void setResult(String result) {
		this.result = result;
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
	
	

}