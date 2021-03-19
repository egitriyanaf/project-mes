package com.agit.services.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.common.DataTables;
import com.agit.entity.JdcAdpMstlookup;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.services.AdpLookupService;

/**
 *
 * @author erwin
 */
@Service
@Transactional(readOnly = true)
public class AdpLookupServiceImpl extends AdpSimpleServiceImpl<JdcAdpMstlookup> implements AdpLookupService {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     *
     * @return
     */
    @Override
    public Class<JdcAdpMstlookup> getRealClass() {
        return JdcAdpMstlookup.class;
    }

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap) {
        String name = (String) searchMap.get("name");

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstlookup.class);

        if (StringUtils.isNotBlank(name)) {
            criteria.add(Restrictions.ilike("type", name, MatchMode.ANYWHERE));
        }

        return getDataTablesFromCriteria(criteria, dataTables);
    }

    /**
     *
     * @param model
     * @param user
     */
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveLookup(JdcAdpMstlookup model, JdcAdpMstUser user) {

        JdcAdpMstlookup lookup = null;

        if (model.getId() != null) {
            lookup = findById(model.getId());
            lookup.setUpdateBy(user.getId());
            lookup.setUpdateDate(new Date());
        } else {
            lookup = new JdcAdpMstlookup();
            lookup.setCreateBy(user.getId());
            lookup.setCreateDate(new Date());
            //lookup.setType(new String("VISIT_TYPE"));
        }

        lookup.setType(model.getType());
        lookup.setValue(model.getDescription());
        lookup.setDescription(model.getDescription());
        lookup.setActiveFlag(model.getActiveFlag());

        saveOrUpdate(lookup);
        model.setId(lookup.getId());

    }

    /**
     *
     * @param code
     * @param type
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public String checkExistingByCodeAndType(String code,
            String type) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstlookup.class);
        criteria.add(Restrictions.eq("code", code).ignoreCase());
        criteria.add(Restrictions.eq("type", type).ignoreCase());

        List<JdcAdpMstlookup> sts = criteria.list();
        if (!sts.isEmpty()) {
            return "Y";
        }

        return "N";
    }

    /**
     *
     * @param mapsSearch
     * @return
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public List<JdcAdpMstlookup> findByMapCriteria(Map mapsSearch) {
        String type = (String) mapsSearch.get("type");

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstlookup.class);

        if (StringUtils.isNotBlank(type)) {
            criteria.add(Restrictions.eq("type", type));
        }

        return criteria.list();
    }

    /**
     *
     * @param code
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean isExist(String code, Long id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstlookup.class);
        criteria.add(Restrictions.eq("code", code).ignoreCase());
        if (id != null) {
            criteria.add(Restrictions.ne("id", id));
        }
        List<JdcAdpMstlookup> list = criteria.list();

        if (list.isEmpty()) {
            return false;
        }

        return true;
    }

}
