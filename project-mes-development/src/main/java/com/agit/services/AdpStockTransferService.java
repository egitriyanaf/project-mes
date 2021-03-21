/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.services;
import com.agit.controller.sample.model.AdpStockTransferReportModel;
import com.agit.controller.sample.model.AdpStockModel;
import com.agit.entity.JdcAdpMstspk;
import com.agit.entity.JdcAdpTxnstock;
import com.agit.entity.security.JdcAdpMstUser;
import com.project.common.DataTables;
import java.util.HashMap;
import java.util.List;


/**
 *
 * @author ridwans
 */
public interface AdpStockTransferService {

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
    public List<JdcAdpMstspk> findBySampleReq(String param);

    /**
     *
     * @param Id
     * @return
     */
    public JdcAdpTxnstock findById(Long Id);

    /**
     *
     * @param transfer
     * @param userLogin
     */
    public void saveTransfer(JdcAdpTxnstock transfer, JdcAdpMstUser userLogin);

    /**
     *
     * @param transfer
     * @param userLogin
     */
    public void returnTransfer(JdcAdpTxnstock transfer, JdcAdpMstUser userLogin);

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    public DataTables searchByMapCriteriaByGroup(DataTables dataTables, HashMap<String, Object> searchMap);

    /**
     *
     * @param param
     * @return
     */
    public List<AdpStockModel> getStock(String param);

    /**
     *
     * @param param
     * @return
     */
    public List<AdpStockModel> getRemainingQty(Long param);
    
    /**
     *
     * @param searchMap
     * @return
     */
    public List<AdpStockTransferReportModel> getDataReport(HashMap<String, Object> searchMap);
}
