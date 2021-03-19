package com.agit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import com.agit.entity.security.JdcAdpMstMenu;
import com.agit.entity.JdcAdpMstMenuTbl;
import com.agit.entity.util.CustomJsonDateDeserializer;
import com.agit.entity.util.CustomJsonDateSerializer;

/**
 *
 * @author erwin
 */
@Entity
@Table(name = "jdcuam_mstmenu")
public class JdcAdpMstMenuTbl implements Serializable {

    
    /**
     *
     */
    private static final long serialVersionUID = -4766966230697392291L;
    
    @Id
    @SequenceGenerator(name = "seq_menu", sequenceName = "seq_menu", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_menu")
    
    @Column(name = "menu_id")
    private Long id;
    
    @Column(name="menu_name")
    private String menuName;
    
    @Column(name="menu_desc")
    private String menuDesc;
    
    @Column(name="menu_url")
    private String menuUrl;
    
    @Column(name="menu_icon")
    private String menuIcon;
    
    @Column(name = "menu_parent_id")
    private Long menuParentId;
    
    @Column(name = "menu_enabled")
    private Long menuEnabled;
    
    @Column(name = "menu_seq_no")
    private Long menuSeqNo;
    
    @Column(name="menu_parent_name")
    private String menuParentName;
    
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the menuName
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * @param menuName the menuName to set
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * @return the menuDesc
     */
    public String getMenuDesc() {
        return menuDesc;
    }

    /**
     * @param menuDesc the menuDesc to set
     */
    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    /**
     * @return the menuUrl
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * @param menuUrl the menuUrl to set
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    /**
     * @return the menuIcon
     */
    public String getMenuIcon() {
        return menuIcon;
    }

    /**
     * @param menuIcon the menuIcon to set
     */
    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    /**
     * @return the menuParentId
     */
    public Long getMenuParentId() {
        return menuParentId;
    }

    /**
     * @param menuParentId the menuParentId to set
     */
    public void setMenuParentId(Long menuParentId) {
        this.menuParentId = menuParentId;
    }

    /**
     * @return the menuEnabled
     */
    public Long getMenuEnabled() {
        return menuEnabled;
    }

    /**
     * @param menuEnabled the menuEnabled to set
     */
    public void setMenuEnabled(Long menuEnabled) {
        this.menuEnabled = menuEnabled;
    }

    /**
     * @return the menuSeqNo
     */
    public Long getMenuSeqNo() {
        return menuSeqNo;
    }

    /**
     * @param menuSeqNo the menuSeqNo to set
     */
    public void setMenuSeqNo(Long menuSeqNo) {
        this.menuSeqNo = menuSeqNo;
    }

    /**
     * @return the menuParentName
     */
    public String getMenuParentName() {
        return menuParentName;
    }

    /**
     * @param menuParentName the menuParentName to set
     */
    public void setMenuParentName(String menuParentName) {
        this.menuParentName = menuParentName;
    }
}
