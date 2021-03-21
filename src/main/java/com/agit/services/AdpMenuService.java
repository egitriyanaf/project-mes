package com.agit.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.common.DataTables;
import com.agit.controller.administration.model.AdpMstMenuModel;
import com.agit.controller.maintenance.model.AdpProduksiSearchModel;
import com.agit.entity.security.JdcAdpMstMenu;
import com.agit.entity.security.JdcAdpMstUser;

/**
 *
 * @author erwin
 */
public interface AdpMenuService {

    /**
     *
     * @param id
     * @return
     */
    public JdcAdpMstMenu findById(Long id);

    /**
     *
     * @return
     */
    public List<JdcAdpMstMenu> list();

    /**
     *
     * @param model
     * @param userLogin
     */
    public void saveSecRole(AdpMstMenuModel model, JdcAdpMstUser userLogin);
	
    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap);

    /**
     *
     * @param param
     * @return
     */
    public String checkExistingByCode(String param);

    /**
     *
     * @param filters
     * @return
     */
    public String checkExistingBySequence(Map<String, Object> filters);

    /**
     *
     * @param filters
     * @return
     */
    public JdcAdpMstMenu checkExistingBySequenceLast(Map<String, Object> filters);
    
    /**
     *
     * @param searchMap
     * @return
     */
    public List<AdpMstMenuModel> searchParentMenu(Map<String, Object> searchMap);
}
