/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.services;
import com.agit.controller.qc.model.AdpAdjustmentModel;
import com.agit.entity.security.JdcAdpMstUser;
import com.project.common.DataTables;
import java.util.HashMap;
/**
 *
 * @author erwin
 */
public interface AdpAdjustmentService {
    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap);
    
    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    public DataTables searchHistory(DataTables dataTables, HashMap<String, Object> searchMap);

    /**
     *
     * @param ID
     * @param ncvs
     * @param po
     * @param item
     * @param bucket
     * @return 
     */
    public AdpAdjustmentModel findByAdjustment(String ID, String ncvs, String po, String item, String bucket);

    /**
     *
     * @param ADJ
     * @param findUser
     * @param typeupdate
     */
    public void updateToQC(AdpAdjustmentModel ADJ, JdcAdpMstUser findUser, String typeupdate);
    
}
