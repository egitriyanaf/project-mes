package com.agit.entity.security;

import java.io.Serializable;

import com.agit.entity.Entity;

/**
 *
 * @author erwin
 */
public class JdcAdpMstComponent implements Serializable, Entity {
	/**
	 *
	 * @author Ridwan
	 */
	private static final long serialVersionUID = 319169014234109029L;
	private Long id;
    private String name;
    private String description;
    private String icon;
    private JdcAdpMstMenu menu;
    
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
    public JdcAdpMstMenu getMenu() {
		return menu;
	}

    /**
     *
     * @param menu
     */
    public void setMenu(JdcAdpMstMenu menu) {
		this.menu = menu;
	}

    /**
     *
     * @param secComponent
     * @return
     */
    public boolean equals(JdcAdpMstComponent secComponent) {
        return getId().equals(secComponent.getId());
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

        if (obj instanceof JdcAdpMstComponent) {
            JdcAdpMstComponent secComponent = (JdcAdpMstComponent) obj;
            return equals(secComponent);
        }

        return false;
    }
}
