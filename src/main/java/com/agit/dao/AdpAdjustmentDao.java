/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.dao;

import com.agit.controller.qc.model.AdpAdjustmentModel;
import com.agit.controller.qc.model.AdpProduksiModel;
import com.agit.entity.JdcAdpMstAdjustmentHistoryView;
import com.agit.entity.JdcAdpMstproduksi;
import com.project.common.DataTables;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author erwin
 */
public interface AdpAdjustmentDao extends AdpInterfaceBaseDao<JdcAdpMstproduksi>{
    
     /**
     *
     * @param searchMap
     * @return
     */
    Long getCountAdjustment(HashMap<String, Object> searchMap);
    
     /**
     *
     * @param searchMap
     * @return
     */
    Long getCountAdjustmentHistory(HashMap<String, Object> searchMap);
    
    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    List<AdpAdjustmentModel> getDataAdjustment(DataTables dataTables, HashMap<String, Object> searchMap);
    
    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    List<JdcAdpMstAdjustmentHistoryView> getDataAdjustmentHistory(DataTables dataTables, HashMap<String, Object> searchMap);
}
