package com.agit.services.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.common.DataTables;
import com.agit.entity.JdcAdpMstdepartement;
import com.agit.services.AdpDepartementService;

/**
 *
 * @author erwin
 */
@Service
@Transactional(readOnly = true)
public class AdpDepartementServiceImpl extends AdpSimpleServiceImpl<JdcAdpMstdepartement> implements AdpDepartementService {

    @Autowired
    SessionFactory sessionFactory;

    /**
     *
     * @return
     */
    @Override
    public Class<JdcAdpMstdepartement> getRealClass() {
        return JdcAdpMstdepartement.class;
    }

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @Override
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap) {
        String name = (String) searchMap.get("name");

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstdepartement.class);

        if (StringUtils.isNotBlank(name)) {
            criteria.add(Restrictions.ilike("dptName", name, MatchMode.ANYWHERE));
        }

        return getDataTablesFromCriteria(criteria, dataTables);
    }

    /**
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<JdcAdpMstdepartement> getAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstdepartement.class);
        return criteria.list();
    }

    /**
     *
     * @return
     */
    @Override
    public List<JdcAdpMstdepartement> getPcc() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstdepartement.class);
        criteria.add(Restrictions.ilike("dptName", "PCC", MatchMode.ANYWHERE));
        return criteria.list();
    }
}
