package com.agit.controller.administration.model;

import java.util.ArrayList;
import java.util.List;

import com.agit.entity.security.JdcAdpMstComponent;

/**
 *
 * @author erwin
 */
public class AdpMstMenuModel {
	private Long id;
    private String name;
    private String url;
    private String icon;
    private String description;
    private Integer sequence;
    private Integer enabled;
    private String parentName;
    private Long parentId;
	private List<JdcAdpMstComponent> comp = new ArrayList<JdcAdpMstComponent>();
	private String flagNew;
	private String typeMenu;
    
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
    public String getName() {
		return name;
	}

    /**
     *
     * @param name
     */
    public void setName(String name) {
		this.name = name;
	}

    /**
     *
     * @return
     */
    public String getUrl() {
		return url;
	}

    /**
     *
     * @param url
     */
    public void setUrl(String url) {
		this.url = url;
	}

    /**
     *
     * @return
     */
    public String getIcon() {
		return icon;
	}

    /**
     *
     * @param icon
     */
    public void setIcon(String icon) {
		this.icon = icon;
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
    public Integer getSequence() {
		return sequence;
	}

    /**
     *
     * @param sequence
     */
    public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

    /**
     *
     * @return
     */
    public Integer getEnabled() {
		return enabled;
	}

    /**
     *
     * @param enabled
     */
    public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

    /**
     *
     * @return
     */
    public String getParentName() {
		return parentName;
	}

    /**
     *
     * @param parentName
     */
    public void setParentName(String parentName) {
		this.parentName = parentName;
	}

    /**
     *
     * @return
     */
    public Long getParentId() {
		return parentId;
	}

    /**
     *
     * @param parentId
     */
    public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

    /**
     *
     * @return
     */
    public List<JdcAdpMstComponent> getComp() {
		return comp;
	}

    /**
     *
     * @param comp
     */
    public void setComp(List<JdcAdpMstComponent> comp) {
		this.comp = comp;
	}

    /**
     *
     * @return
     */
    public String getFlagNew() {
		return flagNew;
	}

    /**
     *
     * @param flagNew
     */
    public void setFlagNew(String flagNew) {
		this.flagNew = flagNew;
	}

    /**
     *
     * @return
     */
    public String getTypeMenu() {
		return typeMenu;
	}

    /**
     *
     * @param typeMenu
     */
    public void setTypeMenu(String typeMenu) {
		this.typeMenu = typeMenu;
	}
	
	
}
