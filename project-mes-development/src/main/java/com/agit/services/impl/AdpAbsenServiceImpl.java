/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.services.impl;

import com.agit.controller.sample.model.AdpAbsenModel;
import com.agit.controller.sample.model.AdpCostCodeModel;
import com.agit.controller.sample.model.AdpReportAbsenModel;
import com.agit.entity.JdcAdpMstabsen;
import com.agit.services.AdpAbsenService;
import com.agit.util.Constantas;
import com.agit.util.DateUtil;
import com.project.common.DataTables;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author TriAA
 */
@Service
@Transactional(readOnly = true)
public class AdpAbsenServiceImpl extends AdpSimpleServiceImpl<JdcAdpMstabsen> implements AdpAbsenService {

    @Autowired
    SessionFactory sessionFactory;

    /**
     *
     * @return
     */
    @Override
    public Class<JdcAdpMstabsen> getRealClass() {
        return JdcAdpMstabsen.class;
    }

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @Override
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap) {
        String fullname = (String) searchMap.get("fullname");
        String nik = (String) searchMap.get("nik");
        String department = (String) searchMap.get("department");
        Date attend = new Date();
        String chooseAttend = (String) searchMap.get("attendDate");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstabsen.class);
        if (chooseAttend == "") {
            criteria.add(Restrictions.eq("attenDate", attend));
        } else {
            Date valChooseAttend = DateUtil.stringToDate(chooseAttend);
            criteria.add(Restrictions.eq("attenDate", valChooseAttend));
        }
        if (StringUtils.isNotBlank(fullname)) {
            criteria.add(Restrictions.ilike("fullname", fullname, MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotBlank(nik)) {
            criteria.add(Restrictions.ilike("nik", nik, MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotBlank(department)) {
            criteria.add(Restrictions.eq("costCode", department));
        }
        return getDataTablesFromCriteria(criteria, dataTables);

    }

    /**
     *
     * @return
     */
    @SuppressWarnings("rawtypes")
    @Override
    public List<AdpAbsenModel> getDashboardAbsen() {
        List<AdpAbsenModel> retVal = new ArrayList<>();
        AdpAbsenModel data = new AdpAbsenModel();
        StringBuilder sql = new StringBuilder("select "
                + "count(*) "
                + "from jdcadp_mstabsen a "
                + "WHERE DATE(A.attend_date) = CURRENT_DATE "
                + "GROUP BY "
                + "DATE(A.start_date) "
                + "ORDER BY "
                + "DATE(A.start_date) ASC ");
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
        List queryResult = sqlQuery.list();
        if (!queryResult.isEmpty()) {
            data.setHadir((BigInteger) queryResult.get(0));
            data.setAbsen((BigInteger) queryResult.get(1));
            retVal.add(data);
        }
        return retVal;
    }

    /**
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<AdpCostCodeModel> groupCostCode() {
        SQLQuery sQLQuery = sessionFactory.getCurrentSession().createSQLQuery("SELECT cost_code FROM jdcadp_mstabsen GROUP BY cost_code");
        List<AdpCostCodeModel> result = sQLQuery.list();
        return result;
    }

    /**
     *
     * @param searchMap
     * @return
     */
    @Override
    public List<AdpReportAbsenModel> getDataReport(HashMap<String, Object> searchMap) {
        String startDate = (String) searchMap.get("startDate");
        String endDate = (String) searchMap.get("endDate");
        String departemen = (String) searchMap.get("departemen");

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstabsen.class);
        if (StringUtils.isNotBlank(departemen)) {
            if (!departemen.equals("0")) {
                criteria.add(Restrictions.eq("costCode", departemen));
            }
        }

        if (StringUtils.isNotBlank(startDate)) {
            Date value = null;
            try {
                value = Constantas.fdate.parse(startDate);
            } catch (ParseException ex) {
                Logger.getLogger(AdpAbsenServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            criteria.add(Restrictions.ge("attenDate", DateUtil.truncate(value)));
        }
        if (StringUtils.isNotBlank(endDate)) {
            Date value = null;
            try {
                value = Constantas.fdate.parse(endDate);
            } catch (ParseException ex) {
                Logger.getLogger(AdpAbsenServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            criteria.add(Restrictions.le("attenDate", DateUtil.endOfDay(value)));
        }
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("nik"), "nik")
                .add(Projections.property("fullname"), "fullname")
                .add(Projections.property("attendCode"), "attend_code")
                .add(Projections.property("costCode"), "cost_code"))
                .setResultTransformer(Transformers.aliasToBean(AdpReportAbsenModel.class));
        List<AdpReportAbsenModel> result = criteria.list();
        return result;
    }

}
