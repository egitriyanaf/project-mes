package com.agit.entity.security;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.agit.entity.Entity;

/**
 *
 * @author erwin
 */
public class JdcAdpMstMenu implements Serializable, Entity {

    /**
     *
     * @author Ridwan
     */
    private static final long serialVersionUID = -11061142604251222L;
    private Long id;
    private String name;
    private String url;
    private String icon;
    private String description;
    private Integer sequence;
    private Integer enabled;
    private String parentName;
    
    private JdcAdpMstMenu parent;
    private Set<JdcAdpMstMenu> childs = new HashSet<JdcAdpMstMenu>(0);
    private Set<JdcAdpMstComponent> components = new HashSet<JdcAdpMstComponent>(0);

    /**
     *
     * @return
     */
    public boolean isNew() {
        return this.getId() == null;
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
    public Long getId() {
        return id;
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
    public JdcAdpMstMenu getParent() {
        return parent;
    }

    /**
     *
     * @param parent
     */
    public void setParent(JdcAdpMstMenu parent) {
        this.parent = parent;
    }

    /**
     *
     * @return
     */
    public Set<JdcAdpMstMenu> getChilds() {
        return childs;
    }

    /**
     *
     * @param childs
     */
    public void setChilds(Set<JdcAdpMstMenu> childs) {
        this.childs = childs;
    }

    /**
     *
     * @return
     */
    public Set<JdcAdpMstComponent> getComponents() {
        return components;
    }

    /**
     *
     * @param components
     */
    public void setComponents(Set<JdcAdpMstComponent> components) {
        this.components = components;
    }

    /**
     *
     * @param secMenu
     * @return
     */
    public boolean equals(JdcAdpMstMenu secMenu) {
        return getId().equals(secMenu.getId());
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
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof JdcAdpMstMenu) {
            JdcAdpMstMenu secMenu = (JdcAdpMstMenu) obj;
            return equals(secMenu);
        }

        return false;
    }
}
