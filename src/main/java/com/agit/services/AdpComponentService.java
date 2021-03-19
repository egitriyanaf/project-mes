/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.services;

import com.agit.controller.administration.model.AdpMstMenuModel;
import com.agit.entity.security.JdcAdpMstComponent;
import com.agit.entity.security.JdcAdpMstUser;
import com.project.common.DataTables;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author BayuHS
 */
public interface AdpComponentService {

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap);

    /**
     *
     * @param id
     * @return
     */
    public JdcAdpMstComponent findById(Long id);

    /**
     *
     * @param model
     * @param user
     */
    public void save(AdpMstMenuModel model,JdcAdpMstUser user);

    /**
     *
     * @param id
     * @return
     */
    public List<JdcAdpMstComponent> findByMenuId(Long id);
    
}
