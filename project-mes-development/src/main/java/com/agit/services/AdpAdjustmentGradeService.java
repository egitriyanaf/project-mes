/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.services;

import com.agit.controller.qc.model.AdpAdjustmentModel;
import com.agit.entity.security.JdcAdpMstUser;
import java.util.HashMap;

/**
 *
 * @author erwin
 */
public interface AdpAdjustmentGradeService {
    
    /**
     *
     * @param id
     * @return
     */
//    public JdcAdpMstAdjustment findById(Long id);
    
    /**
     *
     * @param ADJ
     * @param findUser
     * @param typeupdate
     */
    public void saveToGrade(AdpAdjustmentModel ADJ, JdcAdpMstUser findUser, String typeupdate);
    
     /**
     *
     * @param searchMap
     * @return
     */
    Long getCountAdjustmentHistory(HashMap<String, Object> searchMap);
}
