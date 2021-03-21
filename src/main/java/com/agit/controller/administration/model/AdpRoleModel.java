/**
 * 
 */
package com.agit.controller.administration.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
*
* @author Ridwan
*/
public class AdpRoleModel {
	private Long id;
    private String name;
    private String description;
    
    @JsonProperty("menus")
    private List<AdpStateModel> states = new ArrayList<AdpStateModel>();

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
    public List<AdpStateModel> getStates() {
		return states;
	}

    /**
     *
     * @param states
     */
    public void setStates(List<AdpStateModel> states) {
		this.states = states;
	}
}
