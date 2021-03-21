package com.agit.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.common.DataTables;
import com.agit.entity.JdcAdpMstlookup;
import com.agit.entity.security.JdcAdpMstUser;;

/**
 *
 * @author erwin
 */
@SuppressWarnings("rawtypes")
public interface AdpLookupService {

    /**
     *
     * @param id
     * @return
     */
    public JdcAdpMstlookup findById(Long id);
	
    /**
     *
     * @param model
     * @param user
     */
    public void saveLookup(JdcAdpMstlookup model, JdcAdpMstUser user);
	
    /**
     *
     * @return
     */
    public List<JdcAdpMstlookup> list();
	
    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap);

    /**
     *
     * @param param
     * @param lookupVisitType
     * @return
     */
    public String checkExistingByCodeAndType(String param, String lookupVisitType);
	
    /**
     *
     * @param code
     * @param id
     * @return
     */
    public boolean isExist(String code,Long id);
	
    /**
     *
     * @param mapsSearch
     * @return
     */
    public List<JdcAdpMstlookup> findByMapCriteria(Map mapsSearch);
	
}
