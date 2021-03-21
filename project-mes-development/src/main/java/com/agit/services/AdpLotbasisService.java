/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.services;

import com.agit.controller.operator.model.AdpLotOperatorModel;
import com.agit.controller.production.model.AdpLotbasisModel;
import com.agit.entity.JdcAdpTxnlotbasis;
import com.agit.entity.security.JdcAdpMstUser;
import com.project.common.DataTables;
import java.util.HashMap;

/**
 *
 * @author ridwans
 */
public interface AdpLotbasisService {

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
     * @param list
     * @param findUser
     */
    public void save(JdcAdpTxnlotbasis list, JdcAdpMstUser findUser);
	
    /**
     *
     * @param list
     * @param findUser
     */
    public void saveLot(AdpLotbasisModel list, JdcAdpMstUser findUser);

    /**
     *
     * @param data
     * @param findUser
     */
    public void saveApproveKanban(JdcAdpTxnlotbasis data, JdcAdpMstUser findUser);

}
