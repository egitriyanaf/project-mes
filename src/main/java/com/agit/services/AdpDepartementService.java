/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.services;

import com.agit.entity.JdcAdpMstdepartement;
import com.project.common.DataTables;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author ridwans
 */
public interface AdpDepartementService {

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
    public List<JdcAdpMstdepartement> getAll();
    
    /**
     *
     * @return
     */
    public List<JdcAdpMstdepartement> getPcc();

}
