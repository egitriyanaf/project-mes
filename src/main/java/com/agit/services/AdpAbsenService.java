/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.services;

import com.agit.controller.sample.model.AdpAbsenModel;
import com.agit.controller.sample.model.AdpCostCodeModel;
import com.agit.controller.sample.model.AdpReportAbsenModel;
import com.agit.entity.JdcAdpMstabsen;
import com.project.common.DataTables;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author TriAA
 */
public interface AdpAbsenService {

    /**
     *
     * @param id
     * @return
     */
    public JdcAdpMstabsen findById(Long id);

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap);

    /**
     *
     * @return
     */
    public List<AdpAbsenModel> getDashboardAbsen();
    
    /**
     *
     * @return
     */
    public List<AdpCostCodeModel> groupCostCode();

    /**
     *
     * @param searchMap
     * @return
     */
    public List<AdpReportAbsenModel> getDataReport(HashMap<String, Object> searchMap);
}
