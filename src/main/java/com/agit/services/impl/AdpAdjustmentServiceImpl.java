/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.services.impl;

import com.agit.controller.qc.model.AdpAdjustmentModel;
import java.util.HashMap;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.common.DataTables;
import com.agit.dao.AdpAdjustmentDao;
import com.agit.entity.JdcAdpMstAdjustment;
import com.agit.entity.JdcAdpMstAdjustmentHistoryView;
import com.agit.entity.security.JdcAdpMstUser;
//import com.agit.entity.JdcAdpMstproduksi;
import com.agit.services.AdpAdjustmentService;
import java.util.ArrayList;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Propagation;
/**
 *
 * @author erwin guna setiawan
 */
@Service
@Transactional(readOnly = true)
public class AdpAdjustmentServiceImpl extends AdpSimpleServiceImpl<JdcAdpMstAdjustment> implements AdpAdjustmentService{
    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    AdpAdjustmentDao adpAdjustmentDao;
    
    @Override
    public Class<JdcAdpMstAdjustment> getRealClass() {
        return JdcAdpMstAdjustment.class;
    }
    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @Override
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap) {
        Long total = adpAdjustmentDao.getCountAdjustment(searchMap);
//        List<AdpProduksiModel> data = adpAdjustmentDao.getDataAdjustment(dataTables, searchMap);
        List<AdpAdjustmentModel> data = adpAdjustmentDao.getDataAdjustment(dataTables, searchMap);
        return dataTables.extract(data, total);
    }
    
    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @Override
    public DataTables searchHistory(DataTables dataTables, HashMap<String, Object> searchMap) {
        Long total = adpAdjustmentDao.getCountAdjustmentHistory(searchMap);
        List<JdcAdpMstAdjustmentHistoryView> data = adpAdjustmentDao.getDataAdjustmentHistory(dataTables, searchMap);
        return dataTables.extract(data, total);
    }
    
    /**
     *
     * @param ID
     * @param ncvs
     * @param po
     * @param item
     * @param demandclass
     * @return 
     */
    @Override
    public AdpAdjustmentModel findByAdjustment(String ID, String ncvs, String po, String item, String demandclass) {
        List <String> listtype= new ArrayList();
        listtype.add("B-Grade");
        listtype.add("C-Grade");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstAdjustment.class);
        criteria.add(Restrictions.isNotNull("demandClass"));
        criteria.add(Restrictions.in("type",listtype));
        criteria.add(Restrictions.ilike("area", "Assembly", MatchMode.ANYWHERE));
        if (StringUtils.isNotBlank(ncvs)) {
            criteria.add(Restrictions.eq("lineCode", ncvs));
        }
        if (StringUtils.isNotBlank(ID)) {
            long lID = Long.parseLong(ID);
            criteria.add(Restrictions.eq("id", lID));
        }
        if (StringUtils.isNotBlank(item)) {
            criteria.add(Restrictions.eq("poItem", item));
        }
        if (StringUtils.isNotBlank(po)) {
            criteria.add(Restrictions.eq("poNo", po));
        }
        if (StringUtils.isNotBlank(demandclass)) {
            criteria.add(Restrictions.eq("demandClass", demandclass));
        }
        //dpt_id, line_code, sample_request, demand_class
        criteria.setProjection(Projections.projectionList()
            .add(Projections.property("id"), "id")
            .add(Projections.property("createBy"), "createBy")
            .add(Projections.property("updateBy"), "updateBy")
            .add(Projections.property("updateDate"), "updateDate")
            .add(Projections.property("productCode"), "productCode")
            .add(Projections.property("category"), "category")
            .add(Projections.property("defect"), "defect")
            .add(Projections.property("productDesc"), "productDesc")
            .add(Projections.property("position"), "position")
            .add(Projections.property("dptId"), "dptId")
            .add(Projections.property("poNo"), "poNo")
            .add(Projections.property("poItem"), "poItem")
            .add(Projections.property("demandClass"), "demandClass")
            .add(Projections.property("type"), "type")
            .add(Projections.property("lineCode"), "lineCode")
            .add(Projections.property("area"), "area")
            .add(Projections.property("createDate"), "createDate")
            .add(Projections.property("sampleRequest"), "sampleRequest")
            .add(Projections.groupProperty("id"))
            .add(Projections.groupProperty("createBy"))
            .add(Projections.groupProperty("updateBy"))
            .add(Projections.groupProperty("updateDate"))
            .add(Projections.groupProperty("category"))
            .add(Projections.groupProperty("defect"))
            .add(Projections.groupProperty("productDesc"))
            .add(Projections.groupProperty("position"))
            .add(Projections.groupProperty("dptId"))
            .add(Projections.groupProperty("sampleRequest"))
            .add(Projections.groupProperty("productCode"))
            .add(Projections.groupProperty("poNo"))
            .add(Projections.groupProperty("poItem"))
            .add(Projections.groupProperty("demandClass"))
            .add(Projections.groupProperty("type"))
            .add(Projections.groupProperty("lineCode"))
            .add(Projections.groupProperty("area"))
            .add(Projections.groupProperty("createDate")))
            .setResultTransformer(Transformers.aliasToBean(AdpAdjustmentModel.class));
        return (AdpAdjustmentModel) criteria.uniqueResult();
    }
    
    /**
     *
     * @param ADJ
     * @param findUser
     * @param typeupdate
     */
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateToQC(AdpAdjustmentModel ADJ, JdcAdpMstUser findUser, String typeupdate) {
        JdcAdpMstAdjustment list = new JdcAdpMstAdjustment();
//     sample_request, demand_class
        list.setId(ADJ.getId());
        list.setCreateBy(ADJ.getCreateBy());
        String date = ADJ.getCreateDate().toString();
        list.setCreateDate(ADJ.getCreateDate());
        list.setUpdateBy(ADJ.getUpdateBy());
        list.setUpdateDate(ADJ.getUpdateDate());
        list.setArea(ADJ.getArea());
        list.setCategory(ADJ.getCategory());
        list.setDefect(ADJ.getDefect());
        list.setProductDesc(ADJ.getProductDesc());
        list.setPosition(ADJ.getPosition());
        list.setProductCode(ADJ.getProductCode());
        list.setDptId(ADJ.getDptId());
        list.setLineCode(ADJ.getLineCode());
        list.setType(typeupdate);
        list.setPoNo(ADJ.getPoNo());
        list.setPoItem(ADJ.getPoItem());
        list.setSampleRequest(ADJ.getSampleRequest());
        list.setDemandClass(ADJ.getDemandClass());
        saveOrUpdate(list);
    }
    

    
}
