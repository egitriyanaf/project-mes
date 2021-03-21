package com.agit.dao;


import java.util.HashMap;
import java.util.List;

import com.agit.controller.sample.model.AdpStockModel;
import com.agit.entity.JdcAdpTxnstock;
import com.project.common.DataTables;
/**
*
* @author Ridwan
*/
public interface AdpStockDao extends AdpInterfaceBaseDao<JdcAdpTxnstock> {
	
    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    List<AdpStockModel> getDataList(DataTables dataTables, HashMap<String, Object> searchMap);

    /**
     *
     * @param searchMap
     * @return
     */
    Long getCountData(HashMap<String, Object> searchMap);
	
}
