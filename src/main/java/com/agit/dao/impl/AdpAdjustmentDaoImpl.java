/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.dao.impl;

import com.agit.controller.qc.model.AdpAdjustmentModel;
//import com.agit.controller.qc.model.AdpProduksiModel;
import com.agit.dao.AdpAdjustmentDao;
import com.agit.dao.AdpGenericDao;
import com.agit.entity.JdcAdpMstAdjustmentHistoryView;
//import com.agit.entity.JdcAdpMstAdjustment;
import com.agit.entity.JdcAdpMstAdjustmentView;
import com.agit.entity.JdcAdpMstproduksi;
import com.project.common.DataTables;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
//import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author erwin
 */
@Repository
public class AdpAdjustmentDaoImpl extends AdpBaseDao<JdcAdpMstproduksi> implements AdpAdjustmentDao{
    
    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    AdpGenericDao genericDao;

    /**
     *
     * @param searchMap
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public Long getCountAdjustment(HashMap<String, Object> searchMap) {
        String ncvs = (String) searchMap.get("ncvs");
        String tgl = (String) searchMap.get("insptgl");
//        List <String> listtype= new ArrayList();
//        listtype.add("B-Grade");
//        listtype.add("C-Grade");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstAdjustmentView.class);
//        criteria.add(Restrictions.isNotNull("demandClass"));
//        criteria.add(Restrictions.in("type",listtype));
//        criteria.add(Restrictions.ilike("area", "Assembly", MatchMode.ANYWHERE));
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
                .add(Projections.groupProperty("productCode"))
                .add(Projections.groupProperty("poNo"))
                .add(Projections.groupProperty("poItem"))
                .add(Projections.groupProperty("demandClass"))
                .add(Projections.groupProperty("type"))
                .add(Projections.groupProperty("lineCode"))
                .add(Projections.groupProperty("area"))
                .add(Projections.groupProperty("createDate")))
                .setResultTransformer(Transformers.aliasToBean(AdpAdjustmentModel.class));
        List<AdpAdjustmentModel> result = criteria.list();
        return (long) result.size();
    }
    
    /**
     *
     * @param searchMap
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public Long getCountAdjustmentHistory(HashMap<String, Object> searchMap) {
        String ncvs = (String) searchMap.get("listNcvs");
        String tgl = (String) searchMap.get("updateTgl");
        String ProdCode = (String) searchMap.get("prodCode");
        String PoNo = (String) searchMap.get("pono");
        String PoItem = (String) searchMap.get("poitem");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstAdjustmentHistoryView.class);
        if (StringUtils.isNotBlank(ncvs)) {
            criteria.add(Restrictions.ilike("lineCode", ncvs, MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotBlank(ProdCode)) {
            criteria.add(Restrictions.ilike("productCode", ProdCode, MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotBlank(PoNo)) {
            criteria.add(Restrictions.ilike("poNo", PoNo, MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotBlank(PoItem)) {
            criteria.add(Restrictions.ilike("poItem", PoItem, MatchMode.ANYWHERE));
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
//                .add(Projections.groupProperty("createDate")))
                )
                .setResultTransformer(Transformers.aliasToBean(JdcAdpMstAdjustmentHistoryView.class));
        List<JdcAdpMstAdjustmentHistoryView> result = criteria.list();
        return (long) result.size();
    }

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<AdpAdjustmentModel> getDataAdjustment(DataTables dataTables, HashMap<String, Object> searchMap) {
        String ncvs = (String) searchMap.get("ncvs");
        String tgl = (String) searchMap.get("insptgl");
//        List <String> listtype= new ArrayList();
//        listtype.add("B-Grade");
//        listtype.add("C-Grade");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstAdjustmentView.class);
//        criteria.add(Restrictions.isNotNull("demandClass"));
//        criteria.add(Restrictions.in("type",listtype));
//        criteria.add(Restrictions.ilike("area", "Assembly", MatchMode.ANYWHERE));
        if (StringUtils.isNotBlank(ncvs)) {
            criteria.add(Restrictions.ilike("lineCode", ncvs, MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotBlank(tgl)) {
            criteria.add(Restrictions.sqlRestriction("created_date between '"+tgl+" 00:00:00' and '"+tgl+" 23:59:59'"));
        }
//        if (dataTables != null) {//additional erwin
            criteria.setFirstResult(dataTables.getiDisplayStart());
            criteria.setMaxResults(dataTables.getiDisplayLength());
//        }
        criteria.addOrder(Order.desc("createDate"));//addition 10-06-2020
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("id"), "id")
                .add(Projections.property("productCode"), "productCode")
                .add(Projections.property("poNo"), "poNo")
                .add(Projections.property("poItem"), "poItem")
                .add(Projections.property("demandClass"), "demandClass")
                .add(Projections.property("type"), "type")
                .add(Projections.property("lineCode"), "lineCode")
                .add(Projections.property("area"), "area")
                .add(Projections.property("defect"), "defect")
                .add(Projections.property("position"), "position")
                .add(Projections.property("createDate"), "createDate")
                .add(Projections.property("createBy"), "createBy")
                .add(Projections.groupProperty("id"))
                .add(Projections.groupProperty("productCode"))
                .add(Projections.groupProperty("poNo"))
                .add(Projections.groupProperty("poItem"))
                .add(Projections.groupProperty("demandClass"))
                .add(Projections.groupProperty("type"))
                .add(Projections.groupProperty("lineCode"))
                .add(Projections.groupProperty("area"))
                .add(Projections.groupProperty("defect"))
                .add(Projections.groupProperty("position"))
                .add(Projections.groupProperty("createDate"))
                .add(Projections.groupProperty("createBy")))
                
                .setResultTransformer(Transformers.aliasToBean(AdpAdjustmentModel.class));
        List<AdpAdjustmentModel> result = criteria.list();
//        result.get(0).setCategory("4");
        return result;
    }

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<JdcAdpMstAdjustmentHistoryView> getDataAdjustmentHistory(DataTables dataTables, HashMap<String, Object> searchMap) {
        String ncvs = (String) searchMap.get("listNcvs");
        String tgl = (String) searchMap.get("updateTgl");
        String ProdCode = (String) searchMap.get("prodCode");
        String PoNo = (String) searchMap.get("pono");
        String PoItem = (String) searchMap.get("poitem");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstAdjustmentHistoryView.class);
        if (StringUtils.isNotBlank(ncvs)) {
            criteria.add(Restrictions.ilike("lineCode", ncvs, MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotBlank(ProdCode)) {
            criteria.add(Restrictions.ilike("productCode", ProdCode, MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotBlank(PoNo)) {
            criteria.add(Restrictions.ilike("poNo", PoNo, MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotBlank(PoItem)) {
            criteria.add(Restrictions.ilike("poItem", PoItem, MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotBlank(tgl)) {
            criteria.add(Restrictions.sqlRestriction("created_date between '"+tgl+" 00:00:00' and '"+tgl+" 23:59:59'"));
        }
        criteria.addOrder(Order.desc("createDate"));//addition 10-06-2020
//        criteria.add((Criterion) Order.desc("created_date"));//addition 10-06-2020
        criteria.setFirstResult(dataTables.getiDisplayStart());
        criteria.setMaxResults(dataTables.getiDisplayLength());
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("userNik"), "userNik")
                .add(Projections.property("userName"), "userName")
                .add(Projections.property("id"), "id")
                .add(Projections.property("productCode"), "productCode")
                .add(Projections.property("poNo"), "poNo")
                .add(Projections.property("poItem"), "poItem")
                .add(Projections.property("demandClass"), "demandClass")
                .add(Projections.property("type"), "type")
                .add(Projections.property("typeUpdate"), "typeUpdate")
                .add(Projections.property("lineCode"), "lineCode")
                .add(Projections.property("area"), "area")
                .add(Projections.property("createDate"), "createDate")
                .add(Projections.groupProperty("userNik"))
                .add(Projections.groupProperty("userName"))
                .add(Projections.groupProperty("id"))
                .add(Projections.groupProperty("productCode"))
                .add(Projections.groupProperty("poNo"))
                .add(Projections.groupProperty("poItem"))
                .add(Projections.groupProperty("demandClass"))
                .add(Projections.groupProperty("type"))
                .add(Projections.groupProperty("typeUpdate"))
                .add(Projections.groupProperty("lineCode"))
                .add(Projections.groupProperty("area"))
                .add(Projections.groupProperty("createDate")))
                .setResultTransformer(Transformers.aliasToBean(JdcAdpMstAdjustmentHistoryView.class));
        List<JdcAdpMstAdjustmentHistoryView> result = criteria.list();
        return result;
    }
    
    
}
