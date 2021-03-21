package com.agit.dao;


import java.util.HashMap;
import java.util.List;

import com.agit.controller.sample.model.AdpViewSpkModel;
import com.agit.entity.JdcAdpMstspk;
import com.project.common.DataTables;
/**
*
* @author Ridwan
*/
public interface AdpSpkDao extends AdpInterfaceBaseDao<JdcAdpMstspk> {
	
    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    List<AdpViewSpkModel> getDataSpk(DataTables dataTables, HashMap<String, Object> searchMap);

    /**
     *
     * @param searchMap
     * @return
     */
    Long getCountSpk(HashMap<String, Object> searchMap);
	
}
