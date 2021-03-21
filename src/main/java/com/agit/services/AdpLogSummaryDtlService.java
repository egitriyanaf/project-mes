package com.agit.services;

import java.util.HashMap;

import com.project.common.DataTables;
import com.agit.controller.qc.model.AdpProduksiModel;
import com.agit.entity.JdcAdpTxnLogsummaryDtl;
import com.agit.entity.security.JdcAdpMstUser;

/**
 *
 * @author erwin
 */
public interface AdpLogSummaryDtlService {

    /**
     *
     * @param id
     * @return
     */
    public JdcAdpTxnLogsummaryDtl findById(Long id);
    
    /**
     *
     * @param model
     * @param userLogin
     */
    public void save(AdpProduksiModel model, JdcAdpMstUser userLogin);

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap);

    /**
     *
     * @param model
     * @param loginSecUser
     */
    public void submit(AdpProduksiModel model, JdcAdpMstUser loginSecUser);

    /**
     *
     * @param model
     */
    public void deleteLines(AdpProduksiModel model);

}
