package com.agit.services.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.common.DataTables;
import com.agit.controller.qc.model.AdpProduksiDetailModel;
import com.agit.controller.qc.model.AdpProduksiDtlModel;
import com.agit.controller.qc.model.AdpProduksiModel;
import com.agit.entity.JdcAdpTxnLogsummary;
import com.agit.entity.JdcAdpTxnLogsummaryDtl;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.services.AdpLogSummaryDtlService;
import org.hibernate.criterion.Order;

/**
 *
 * @author erwin
 */
@Service
@Transactional(readOnly = true)
public class AdpLogSummaryDtlServiceImpl extends AdpSimpleServiceImpl<JdcAdpTxnLogsummaryDtl>
        implements AdpLogSummaryDtlService {

    @Autowired
    SessionFactory sessionFactory;

    /**
     *
     * @return
     */
    @Override
    public Class<JdcAdpTxnLogsummaryDtl> getRealClass() {
        return JdcAdpTxnLogsummaryDtl.class;
    }

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @Override
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap) {
        String lineCode = (String) searchMap.get("lineCode");
        String poNo = (String) searchMap.get("poNo");
        String poItem = (String) searchMap.get("poItem");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpTxnLogsummaryDtl.class);
        criteria.add(Restrictions.eq("lineCode", lineCode));
        criteria.add(Restrictions.eq("poNo", poNo));
        criteria.add(Restrictions.eq("poItem", poItem));
        criteria.addOrder(Order.desc("id"));
        return getDataTablesFromCriteria(criteria, dataTables);
    }

    /**
     *
     * @param model
     * @param userLogin
     */
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void save(AdpProduksiModel model, JdcAdpMstUser userLogin) {
        for (AdpProduksiDtlModel list : model.getLinesDtl()) {
            JdcAdpTxnLogsummaryDtl data = null;
            if (model.getId() != null) {
                data = findById(model.getId());
                data.setUpdateBy(userLogin.getId());
                data.setUpdateDate(new Date(System.currentTimeMillis()));
            } else {
                data = new JdcAdpTxnLogsummaryDtl();
                data.setCreateBy(userLogin.getId());
                data.setCreateDate(new Date(System.currentTimeMillis()));
            }
            data.setLineCode(model.getLineCode());
            data.setPoItem(model.getPoItem());
            data.setPoNo(model.getPoNo());
            data.setSave(1l);
            data.setSize(list.getSize());
            data.setSpecLace(list.getSpecLace());
            data.setActualLace(list.getActualLace());
            data.setCategoryLace(list.getSizeTypeLace());
            data.setSpecHeel(list.getSpecHeel());
            data.setLeftHeel(list.getLeftHeel());
            data.setRightHeel(list.getRightHeel());
            data.setCategoryHeel(list.getSizeTypeHeel());
            data.setSpecMedial(list.getSpecMedial());
            data.setLeftMedial(list.getLeftMedial());
            data.setRightMedial(list.getRightMedial());
            data.setCategoryMedial(list.getSizeTypeMedial());
            data.setSpecLateral(list.getSpecLateral());
            data.setLeftLateral(list.getLeftLateral());
            data.setRightLateral(list.getRightLateral());
            data.setCategoryLateral(list.getSizeTypeLateral());
            data.setActualIbox(list.getActualIbox());
            data.setSpecIbox(list.getSpecIbox());
            data.setCategoryIbox(list.getSizeTypeIbox());
            saveOrUpdate(data);
            model.setId(model.getId());
        }
    }

    /**
     *
     * @param model
     * @param loginSecUser
     */
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void submit(AdpProduksiModel model, JdcAdpMstUser loginSecUser) {
        for (AdpProduksiDtlModel list : model.getLinesDtl()) {
            JdcAdpTxnLogsummaryDtl data = null;
            if (model.getId() != null) {
                data = findById(model.getId());
                data.setUpdateBy(loginSecUser.getId());
                data.setUpdateDate(new Date(System.currentTimeMillis()));
            } else {
                data = new JdcAdpTxnLogsummaryDtl();
                data.setCreateBy(loginSecUser.getId());
                data.setCreateDate(new Date(System.currentTimeMillis()));
            }
            data.setLineCode(model.getLineCode());
            data.setPoItem(model.getPoItem());
            data.setPoNo(model.getPoNo());
            data.setSubmit(1l);
            data.setSize(list.getSize());
            data.setSpecLace(list.getSpecLace());
            data.setActualLace(list.getActualLace());
            data.setCategoryLace(list.getSizeTypeLace());
            data.setSpecHeel(list.getSpecHeel());
            data.setLeftHeel(list.getLeftHeel());
            data.setRightHeel(list.getRightHeel());
            data.setCategoryHeel(list.getSizeTypeHeel());
            data.setSpecMedial(list.getSpecMedial());
            data.setLeftMedial(list.getLeftMedial());
            data.setRightMedial(list.getRightMedial());
            data.setCategoryMedial(list.getSizeTypeMedial());
            data.setSpecLateral(list.getSpecLateral());
            data.setLeftLateral(list.getLeftLateral());
            data.setRightLateral(list.getRightLateral());
            data.setCategoryLateral(list.getSizeTypeLateral());
            data.setActualIbox(list.getActualIbox());
            data.setSpecIbox(list.getSpecIbox());
            data.setCategoryIbox(list.getSizeTypeIbox());
            saveOrUpdate(data);
            model.setId(model.getId());
        }
    }

    /**
     *
     * @param model
     */
    @Override
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteLines(AdpProduksiModel model) {
        List<AdpProduksiModel> list = getListDelete(model.getLineCode(), model.getPoNo(), model.getPoItem());
        for (AdpProduksiModel data : list) {
            Query query = this.sessionFactory.getCurrentSession().createQuery("delete from JdcAdpTxnLogsummaryDtl where id =:id ");
            query.setLong("id", data.getId());
            query.executeUpdate();
        }
    }

    @SuppressWarnings("unchecked")
    private List<AdpProduksiModel> getListDelete(String lineCode, String poNo, String poItem) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpTxnLogsummaryDtl.class);
        criteria.add(Restrictions.eq("lineCode", lineCode));
        criteria.add(Restrictions.eq("poNo", poNo));
        criteria.add(Restrictions.eq("poItem", poItem));
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("id"), "id"))
                .setResultTransformer(Transformers.aliasToBean(AdpProduksiModel.class));
        List<AdpProduksiModel> result = criteria.list();
        return result;
    }
}
