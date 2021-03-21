package com.agit.services;

import java.util.HashMap;
import java.util.List;

import com.project.common.DataTables;
import com.agit.controller.administration.model.AdpRoleModel;
import com.agit.entity.security.JdcAdpMstRole;
import com.agit.entity.security.JdcAdpMstUser;

/**
 *
 * @author erwin
 */
public interface AdpRoleService {

    /**
     *
     * @param id
     * @return
     */
    public JdcAdpMstRole findById(Long id);

    /**
     *
     * @return
     */
    public List<JdcAdpMstRole> list();

    /**
     *
     * @param model
     * @param userLogin
     */
    public void saveSecRole(AdpRoleModel model, JdcAdpMstUser userLogin);
	
    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap);
}
