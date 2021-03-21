package com.agit.services.impl;

import com.agit.entity.JdcAdpMsttemplate;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.services.AdpTemplateService;
import com.project.common.DataTables;
import java.util.HashMap;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author TriAA
 */
@Service
public class AdpTemplateServiceImpl extends AdpSimpleServiceImpl<JdcAdpMsttemplate> implements AdpTemplateService {

    @Autowired
    SessionFactory sessionFactory;

    /**
     *
     * @return
     */
    @Override
    public Class<JdcAdpMsttemplate> getRealClass() {
        return JdcAdpMsttemplate.class;
    }

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @Override
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMsttemplate.class);
        return getDataTablesFromCriteria(criteria, dataTables);
    }

    /**
     *
     * @param template
     * @param user
     */
    @Override
    public void save(JdcAdpMsttemplate template, JdcAdpMstUser user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
