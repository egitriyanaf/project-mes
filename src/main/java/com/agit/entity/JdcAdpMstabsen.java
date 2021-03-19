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
@Table(name = "jdcadp_mstabsen")
public class JdcAdpMstabsen implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4766966230697392291L;

    @Id
    @SequenceGenerator(name = "seq_absen", sequenceName = "seq_absen", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_absen")
    @Column(name = "absen_id")
    private Long id;

    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    private Date createDate;

    @Column(name = "created_by")
    private Long createBy;

    @Column(name = "last_updated_date")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    private Date updateDate;

    @Column(name = "last_updated_by")
    private Long updateBy;

    @Column(name = "attend_date")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    private Date attenDate;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    private Date endDate;

    @Column(name = "total")
    private Long total;

    @Column(name = "attend_code")
    private String attendCode;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "cost_code")
    private String costCode;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "grade_code")
    private String grade_code;

    @Column(name = "kelamin")
    private String kelamin;

    @Column(name = "nik")
    private String nik;

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
    public Date getAttenDate() {
        return attenDate;
    }

    /**
     *
     * @param attenDate
     */
    public void setAttenDate(Date attenDate) {
        this.attenDate = attenDate;
    }

    /**
     *
     * @return
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     *
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     *
     * @return
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     *
     * @param endDate
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     *
     * @return
     */
    public Long getTotal() {
        return total;
    }

    /**
     *
     * @param total
     */
    public void setTotal(Long total) {
        this.total = total;
    }

    /**
     *
     * @return
     */
    public String getAttendCode() {
        return attendCode;
    }

    /**
     *
     * @param attendCode
     */
    public void setAttendCode(String attendCode) {
        this.attendCode = attendCode;
    }

    /**
     *
     * @return
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     *
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     *
     * @return
     */
    public String getCostCode() {
        return costCode;
    }

    /**
     *
     * @param costCode
     */
    public void setCostCode(String costCode) {
        this.costCode = costCode;
    }

    /**
     *
     * @return
     */
    public String getFullname() {
        return fullname;
    }

    /**
     *
     * @param fullname
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     *
     * @return
     */
    public String getGrade_code() {
        return grade_code;
    }

    /**
     *
     * @param grade_code
     */
    public void setGrade_code(String grade_code) {
        this.grade_code = grade_code;
    }

    /**
     *
     * @return
     */
    public String getKelamin() {
        return kelamin;
    }

    /**
     *
     * @param kelamin
     */
    public void setKelamin(String kelamin) {
        this.kelamin = kelamin;
    }

    /**
     *
     * @return
     */
    public String getNik() {
        return nik;
    }

    /**
     *
     * @param nik
     */
    public void setNik(String nik) {
        this.nik = nik;
    }

}
