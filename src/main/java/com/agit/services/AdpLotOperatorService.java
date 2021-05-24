/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.services;

import com.agit.controller.operator.model.AdpLotOperatorModel;
import com.agit.entity.JdcAdpTxnlotbasis;
import com.agit.entity.JdcAdpTxnLotapprv;
import com.agit.entity.security.JdcAdpMstUser;
import com.project.common.DataTables;
import java.util.HashMap;

/**
 *
 * @author ridwans
 */
public interface AdpLotOperatorService {

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
    public JdcAdpTxnlotbasis findById(Long id);

    /**
     *
     * @param model
     * @param loginSecUser
     */
    public void approveIn(AdpLotOperatorModel model, JdcAdpMstUser loginSecUser);
	
    /**
     *
     * @param model
     * @param loginSecUser
     */
    public void approveOut(AdpLotOperatorModel model, JdcAdpMstUser loginSecUser);
	
    /**
     *
     * @param model
     * @param loginSecUser
     */
    public void rejectIn(AdpLotOperatorModel model, JdcAdpMstUser loginSecUser);
	
    /**
     *
     * @param model
     * @param loginSecUser
     */
    public void rejectOut(AdpLotOperatorModel model, JdcAdpMstUser loginSecUser);

}
