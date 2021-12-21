/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.services;

import com.agit.controller.sample.model.AdpScannerModel;
import com.agit.entity.JdcAdpTxnbarcode;
import com.agit.entity.security.JdcAdpMstUser;
import com.project.common.DataTables;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ridwans
 */
public interface AdpBarcodeService {

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
    public JdcAdpTxnbarcode findById(Long id);

    /**
     *
     * @param model
     * @param user
     */
    public void save(JdcAdpTxnbarcode model,JdcAdpMstUser user);
    
    /**
     *
     * @param qrCode
     * @param productCode
     * @param sampleReq
     * @param qty
     * @param size
     * @param dptId
     * @param type
     * @return
     */
//    public JdcAdpTxnbarcode findValidasi(String qrCode,String productCode,String sampleReq,Float qty,String size,Long dptId,String type);

    /**
     *
     * @param searchMap
     * @return
     */
    public List<AdpScannerModel> getDashboardAbsen(Map<String, Object> searchMap);

    public JdcAdpTxnbarcode findValidasi(String qrCode, String productCode, String sampleReq, Float qty, String size, Long dptId, String type, String itemNumber, String workOrderNumber);
    
    
}
