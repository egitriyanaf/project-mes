package com.agit.controller.administration.model;

/**
 *
 * @author erwin
 */
public class AdpComponentModel {
	private Long id;
    private String name;
    private String description;
    private String icon;
    private Long idMenu;
    
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
    public Long getIdMenu() {
		return idMenu;
	}

    /**
     *
     * @param idMenu
     */
    public void setIdMenu(Long idMenu) {
		this.idMenu = idMenu;
	}

}
