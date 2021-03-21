package com.agit.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.common.DataTables;
import com.agit.controller.qc.model.AdpProduksiModel;
import com.agit.controller.qc.model.AdpInspectionLogSummaryReportModel;
import com.agit.entity.JdcAdpTxnLogsummary;
import com.agit.entity.security.JdcAdpMstUser;

/**
 *
 * @author erwin
 */
public interface AdpLogSummaryService {

    /**
     *
     * @param id
     * @return
     */
    public JdcAdpTxnLogsummary findById(Long id);

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
    
    /**
     *
     * @param searchMap
     * @return
     */
    public List<JdcAdpTxnLogsummary> retrieveData(Map<String, Object> searchMap);

    /**
     *
     * @param searchMap
     * @return
     */
    public List<AdpInspectionLogSummaryReportModel> getDataReport(HashMap<String, Object> searchMap);
}
