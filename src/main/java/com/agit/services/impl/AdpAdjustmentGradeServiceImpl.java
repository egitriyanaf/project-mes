/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.services.impl;

import com.agit.controller.qc.model.AdpAdjustmentModel;
import com.agit.entity.JdcAdpMstAdjGrade;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.services.AdpAdjustmentGradeService;
import com.project.common.DataTables;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author erwin
 */
@Service
@Transactional(readOnly = true)
public class AdpAdjustmentGradeServiceImpl extends AdpSimpleServiceImpl<JdcAdpMstAdjGrade> 
        implements AdpAdjustmentGradeService{
    @Autowired
    SessionFactory sessionFactory;

//    @Autowired
//    AdpAdjustmentDao adpAdjustmentDao;
    
    @Override
    public Class<JdcAdpMstAdjGrade> getRealClass() {
        return JdcAdpMstAdjGrade.class;
    }
    
    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @Override
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap) {
        //belum di edit
        String lineCode = (String) searchMap.get("lineCode");
        String poNo = (String) searchMap.get("poNo");
        String poItem = (String) searchMap.get("poItem");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstAdjGrade.class);
        criteria.add(Restrictions.eq("lineCode", lineCode));
        criteria.add(Restrictions.eq("poNo", poNo));
        criteria.add(Restrictions.eq("poItem", poItem));
        criteria.addOrder(Order.desc("id"));
        return getDataTablesFromCriteria(criteria, dataTables);
    }
    
    /**
     *
     * @param ADJ
     * @param findUser
     * @param typeupdate
     * 
     */
    
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveToGrade(AdpAdjustmentModel ADJ, JdcAdpMstUser findUser, String typeupdate) {
        JdcAdpMstAdjGrade data = new JdcAdpMstAdjGrade();
        data.setQcId(ADJ.getId());
        data.setProductCode(ADJ.getProductCode());
        data.setPoNo(ADJ.getPoNo());
        data.setPoItem(ADJ.getPoItem());
        data.setType(ADJ.getType());
        data.setLineCode(ADJ.getLineCode());
        data.setArea(ADJ.getArea());
        data.setDemandClass(ADJ.getDemandClass());
        data.setCreateBy(ADJ.getCreateBy());
        data.setUpdateBy(findUser.getId());
        data.setTypeUpdate(typeupdate);
        data.setCreateDate(ADJ.getCreateDate());
        data.setUpdateDate(new Date(System.currentTimeMillis()));
        saveOrUpdate(data);
    }
    
    /**
     *
     * @param searchMap
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public Long getCountAdjustmentHistory(HashMap<String, Object> searchMap) {
        String ncvs = (String) searchMap.get("ncvs");
        String tgl = (String) searchMap.get("insptgl");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstAdjGrade.class);
        if (StringUtils.isNotBlank(ncvs)) {
            criteria.add(Restrictions.ilike("lineCode", ncvs, MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotBlank(tgl)) {
            criteria.add(Restrictions.sqlRestriction("created_date between '"+tgl+" 00:00:00' and '"+tgl+" 23:59:59'"));
        }
                criteria.setProjection(Projections.projectionList()
                .add(Projections.property("productCode"), "productCode")
                .add(Projections.property("poNo"), "poNo")
                .add(Projections.property("poItem"), "poItem")
                .add(Projections.property("demandClass"), "demandClass")
                .add(Projections.property("type"), "type")
                .add(Projections.property("lineCode"), "lineCode")
                .add(Projections.property("area"), "area")
                .add(Projections.property("createDate"), "createDate")
//                .add(Projections.groupProperty("productCode"))
//                .add(Projections.groupProperty("poNo"))
//                .add(Projections.groupProperty("poItem"))
//                .add(Projections.groupProperty("demandClass"))
//                .add(Projections.groupProperty("type"))
//                .add(Projections.groupProperty("lineCode"))
//                .add(Projections.groupProperty("area"))
//                .add(Projections.groupProperty("createDate"))
                )
                .setResultTransformer(Transformers.aliasToBean(JdcAdpMstAdjGrade.class));
        List<JdcAdpMstAdjGrade> result = criteria.list();
        return (long) result.size();
    }
    
    
}
