package com.agit.services;

import java.util.HashMap;
import java.util.List;

import com.project.common.DataTables;
import com.agit.entity.JdcAdpTxnrpph;
import java.util.Map;

/**
 *
 * @author erwin
 */
public interface AdpReportPphService {

    /**
     *
     * @param id
     * @return
     */
    public JdcAdpTxnrpph findById(Long id);
	
    /**
     *
     * @param searchMap
     * @return
     */
    public List<JdcAdpTxnrpph> getDataReport(Map<String, Object> searchMap);
	
    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap);

	
}
