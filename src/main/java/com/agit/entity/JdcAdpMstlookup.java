package com.agit.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.agit.entity.util.CustomJsonDateSerializer;

/**
 *
 * @author erwin
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "jdcfnd_mstlookup")
public class JdcAdpMstlookup implements Serializable {

    /**
     *
     */

    /*POSITION TYPE*/
    public static final String LOOKUP_POSITION_TYPE = "POSITION_TYPE";

    /*USER ENABLE*/

    /**
     *
     */

    public static final String LOOKUP_USER_STATUS_TYPE = "USER_STATUS_TYPE";

    /**
     *
     */
    public static final String LOOKUP_USER_STATUS_TYPE_0 = "0";

    /**
     *
     */
    public static final String LOOKUP_USER_STATUS_TYPE_1 = "1";

    /*USER TYPE*/

    /**
     *
     */

    public static final String LOOKUP_USER_TYPE = "USER_TYPE";

    /*ICONS TYPE*/

    /**
     *
     */

    public static final String LOOKUP_MASTER_ICONS = "ICONS_TYPE";

    /*ICONS TYPE*/

    /**
     *
     */

    public static final String LOOKUP_TYPE_MENU = "TYPE_MENU";

    /*KATEGORI TYPE*/

    /**
     *
     */

    public static final String LOOKUP_KATEGORI = "KATEGORI";
    
    /*APP TYPE*/

    /**
     *
     */

    public static final String LOOKUP_APP_TYPE = "APP_TYPE";
    
    /*REMARK_TYPE*/

    /**
     *
     */

    public static final String LOOKUP_REMARK_TYPE = "REMARK_TYPE";
    
    /*ISSUE_TYPE*/

    /**
     *
     */

    public static final String LOOKUP_ISSUE_TYPE = "ISSUE_TYPE";

    @Id
    @SequenceGenerator(name = "cms.lookup_id_seq", sequenceName = "cms.lookup_id_seq", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cms.lookup_id_seq")
    @Column(name = "lookup_id")
    private Long id;

    @Column(name = "lookup_type", length = 30)
    private String type;

    @Column(name = "lookup_value", length = 50)
    private String value;

    @Column(name = "lookup_description", length = 100)
    private String description;

    @Column(name = "display_flag", length = 1)
    private String activeFlag;

    @Column(name = "creation_date")
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
    
    @Column(name="colorcode", length = 25)
    private String colorFlag;

    public String getColorFlag() {
        return colorFlag;
    }

    public void setColorFlag(String colorFlag) {
        this.colorFlag = colorFlag;
    }

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
    public String getValue() {
        return value;
    }

    /**
     *
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public String getActiveFlag() {
        return activeFlag;
    }

    /**
     *
     * @param activeFlag
     */
    public void setActiveFlag(String activeFlag) {
        this.activeFlag = activeFlag;
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

}
