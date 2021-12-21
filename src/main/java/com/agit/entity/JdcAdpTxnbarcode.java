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
import com.agit.entity.util.CustomJsonDateSerializer;

/**
 *
 * @author erwin
 */
@Entity
@Table(name = "jdcadp_txnbcode")
public class JdcAdpTxnbarcode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4766966230697392291L;

	@Id
	@SequenceGenerator(name = "seq_barcode", sequenceName = "seq_barcode", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_barcode")
	@Column(name = "barcode_id")
	private Long id;
	
	@Column(name="created_date")
	@Temporal(TemporalType.DATE)
	@JsonSerialize(using=CustomJsonDateSerializer.class)
	private Date createDate ;
	
	@Column(name="created_by")
	private Long createBy ;
	
	@Column(name="qr_code")
	private String qrCode ;
	
	@ManyToOne
	@JoinColumn(name="created_by" ,insertable = false, nullable=false,updatable = false)
	private JdcAdpMstUser user;
	
	
	@Column(name="last_updated_date")
	@Temporal(TemporalType.DATE)
	@JsonSerialize(using=CustomJsonDateSerializer.class)
	private Date updateDate ;
	
	@Column(name="last_updated_by")
	private Long updateBy;
	
	@Column(name="trs_date")
	@Temporal(TemporalType.DATE)
	@JsonSerialize(using=CustomJsonDateSerializer.class)
	private Date trsDate ;
	
	@Column(name="dpt_id")
	private Long dptId ;
	
	@ManyToOne
	@JoinColumn(name="dpt_id" ,insertable = false, nullable=false,updatable = false)
	private JdcAdpMstdepartement departement;
	
	@Column(name="product_code")
	private String productCode ;
	
	@Column(name="qty")
	private Float qty;
	
	@Column(name="sample_req")
	private String sampleReq;
	
	@Column(name="size")
	private String size;
	
	@Column(name="type")
	private String type;
        
	@Column(name="organization_code")
	private String organizationCode;
        
	@Column(name="work_order_number")
	private String workOrderNumber;
        
	@Column(name="wo_status_code")
	private String woStatusCode;
	
        @Column(name="item_number")
	private String itemNumber;
        
        @Column(name="transaction_uom")
	private String transactionUom;
        
        @Column(name="work_center_name")
	private String workCenterName;
        
        @Column(name="operation_sequence_number")
	private String operationSequenceNumber;
        
        @Column(name="operation_name")
	private String operationName;
        
        @Column(name="subinventory_code")
	private String subinventoryCode;
        
        @Column(name="lot_number")
	private String lotNumber;
        
        @Column(name="opr_trx_reference")
	private String oprTrxReference;
        
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
    public String getQrCode() {
		return qrCode;
	}

    /**
     *
     * @param qrCode
     */
    public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
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
    public Date getTrsDate() {
		return trsDate;
	}

    /**
     *
     * @param trsDate
     */
    public void setTrsDate(Date trsDate) {
		this.trsDate = trsDate;
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
    public JdcAdpMstdepartement getDepartement() {
		return departement;
	}

    /**
     *
     * @param departement
     */
    public void setDepartement(JdcAdpMstdepartement departement) {
		this.departement = departement;
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

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
    }

    public String getWoStatusCode() {
        return woStatusCode;
    }

    public void setWoStatusCode(String woStatusCode) {
        this.woStatusCode = woStatusCode;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getTransactionUom() {
        return transactionUom;
    }

    public void setTransactionUom(String transactionUom) {
        this.transactionUom = transactionUom;
    }

    public String getWorkCenterName() {
        return workCenterName;
    }

    public void setWorkCenterName(String workCenterName) {
        this.workCenterName = workCenterName;
    }

    public String getOperationSequenceNumber() {
        return operationSequenceNumber;
    }

    public void setOperationSequenceNumber(String operationSequenceNumber) {
        this.operationSequenceNumber = operationSequenceNumber;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getSubinventoryCode() {
        return subinventoryCode;
    }

    public void setSubinventoryCode(String subinventoryCode) {
        this.subinventoryCode = subinventoryCode;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getOprTrxReference() {
        return oprTrxReference;
    }

    public void setOprTrxReference(String oprTrxReference) {
        this.oprTrxReference = oprTrxReference;
    }
    
    


}