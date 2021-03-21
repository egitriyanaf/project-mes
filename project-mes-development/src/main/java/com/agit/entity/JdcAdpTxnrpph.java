package com.agit.entity;

import com.agit.entity.util.CustomJsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ridwans
 */
@Entity
@Table(name = "jdcadp_txnrpph")
public class JdcAdpTxnrpph implements Serializable {

    private static final long serialVersionUID = -4766966230697392291L;

    @Column(name = "pph_as")
    private Float pphAs;

    @Column(name = "pph_st")
    private Float pphSt;

    @Column(name = "pph_ct")
    private Float pphCt;
    
    @Column(name = "pph_sf")
    private Float pphSf;

    @Id
    @Column(name = "date_scan")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    private Date scanDate;

    /**
     *
     * @return
     */
    public Float getPphAs() {
        return pphAs;
    }

    /**
     *
     * @param pphAs
     */
    public void setPphAs(Float pphAs) {
        this.pphAs = pphAs;
    }

    /**
     *
     * @return
     */
    public Float getPphSt() {
        return pphSt;
    }

    /**
     *
     * @param pphSt
     */
    public void setPphSt(Float pphSt) {
        this.pphSt = pphSt;
    }

    /**
     *
     * @return
     */
    public Float getPphCt() {
        return pphCt;
    }

    /**
     *
     * @param pphCt
     */
    public void setPphCt(Float pphCt) {
        this.pphCt = pphCt;
    }

    /**
     *
     * @return
     */
    public Float getPphSf() {
        return pphSf;
    }

    /**
     *
     * @param pphSf
     */
    public void setPphSf(Float pphSf) {
        this.pphSf = pphSf;
    }

    /**
     *
     * @return
     */
    public Date getScanDate() {
        return scanDate;
    }

    /**
     *
     * @param scanDate
     */
    public void setScanDate(Date scanDate) {
        this.scanDate = scanDate;
    }

}
