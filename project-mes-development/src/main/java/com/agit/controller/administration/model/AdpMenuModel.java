/**
 * 
 */
package com.agit.controller.administration.model;

import java.util.List;

import com.agit.entity.security.JdcAdpMstComponent;
import com.agit.entity.security.JdcAdpMstMenu;
/**
*
* @author Ridwan
*/

public class AdpMenuModel {
	private JdcAdpMstMenu menu;
	private List<AdpMenuModel> childs;
	private List<JdcAdpMstComponent> components;
	
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
     * @return
     */
    public List<AdpMenuModel> getChilds() {
		return childs;
	}

    /**
     *
     * @param childs
     */
    public void setChilds(List<AdpMenuModel> childs) {
		this.childs = childs;
	}

    /**
     *
     * @return
     */
    public List<JdcAdpMstComponent> getComponents() {
		return components;
	}

    /**
     *
     * @param components
     */
    public void setComponents(List<JdcAdpMstComponent> components) {
		this.components = components;
	}
}
