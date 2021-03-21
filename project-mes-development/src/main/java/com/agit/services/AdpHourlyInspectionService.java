/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.services;

import com.agit.controller.qc.model.AdpQcCounterModel;
import com.agit.entity.JdcAdpTxnbarcode;
import com.agit.entity.JdcAdpMstlookup;
import com.agit.entity.JdcAdpTxnqcctrl;
import com.agit.entity.security.JdcAdpMstUser;
import com.project.common.DataTables;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ridwans
 */
public interface AdpHourlyInspectionService {

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
    public JdcAdpTxnqcctrl findById(Long id);

    /**
     *
     * @param model
     * @param user
     */
    public void save(JdcAdpTxnqcctrl model, JdcAdpMstUser user);

    /**
     *
     * @param secUser
     * @param value
     * @return
     */
    public List<JdcAdpMstlookup> getAllDefectByLogin(JdcAdpMstUser secUser, String value);

    /**
     *
     * @param user
     * @return
     */
    public List<JdcAdpTxnqcctrl> findByCategory(JdcAdpMstUser user);

    /**
     *
     * @return
     */
    public List<JdcAdpTxnbarcode> sumBarcodeOut();

    /**
     *
     * @param user
     * @return
     */
    public List<JdcAdpTxnqcctrl> countAGrade(JdcAdpMstUser user);

    /**
     *
     * @param loginSecUser
     * @return
     */
    public List<JdcAdpTxnqcctrl> getCounterWorkshop(JdcAdpMstUser loginSecUser);

    /**
     *
     * @param loginSecUser
     * @param searchMap
     * @return
     */
    public AdpQcCounterModel getAllCounter(JdcAdpMstUser loginSecUser, Map<String, Object> searchMap);
    
    /**
     *
     * @param loginSecUser
     * @param searchMap
     * @return
     */
    public AdpQcCounterModel getAllCounterNew(JdcAdpMstUser loginSecUser, Map<String, Object> searchMap);

    /**
     *
     * @param loginSecUser
     * @param searchMap
     * @return
     */
    public AdpQcCounterModel getDetailCounter(JdcAdpMstUser loginSecUser, Map<String, Object> searchMap);
}
