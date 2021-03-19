package com.agit.services;

import com.agit.entity.JdcAdpMsttemplate;
import com.agit.entity.security.JdcAdpMstUser;
import com.project.common.DataTables;
import java.util.HashMap;

/**
 *
 * @author TriAA
 */
public interface AdpTemplateService {

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
    public JdcAdpMsttemplate findById(Long id);

    /**
     *
     * @param template
     * @param user
     */
    public void save(JdcAdpMsttemplate template, JdcAdpMstUser user);
}
