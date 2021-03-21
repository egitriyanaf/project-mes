package com.agit.dao;


import java.util.HashMap;
import java.util.List;

import com.agit.controller.qc.model.AdpProduksiModel;
import com.agit.entity.JdcAdpMstproduksi;
import com.project.common.DataTables;
/**
*
* @author Ridwan
*/
public interface AdpProduksiDao extends AdpInterfaceBaseDao<JdcAdpMstproduksi> {
	
    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    List<AdpProduksiModel> getDataProduksi(DataTables dataTables, HashMap<String, Object> searchMap);

    /**
     *
     * @param searchMap
     * @return
     */
    Long getCountProduksi(HashMap<String, Object> searchMap);
	
    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    List<AdpProduksiModel> getAllDataProduksi(DataTables dataTables, HashMap<String, Object> searchMap);
        
    /**
     *
     * @param searchMap
     * @return
     */
    Long getAllCountProduksi(HashMap<String, Object> searchMap);
        
    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    List<AdpProduksiModel> getAllDataDiamondMark(DataTables dataTables, HashMap<String, Object> searchMap);
        
    /**
     *
     * @param searchMap
     * @return
     */
    Long getAllCountDiamondMark(HashMap<String, Object> searchMap);
}
