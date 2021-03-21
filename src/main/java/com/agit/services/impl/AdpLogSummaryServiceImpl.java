package com.agit.services.impl;

import com.agit.controller.qc.model.AdpInspectionLogSummaryReportModel;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.agit.entity.JdcAdpMstproduksi;
import com.agit.entity.JdcAdpTxnLogsummary;
import com.agit.entity.JdcAdpTxnLogsummaryDtl;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.services.AdpLogSummaryService;
import java.util.ArrayList;
import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Order;

/**
 *
 * @author erwin
 */
@Service
@Transactional(readOnly = true)
public class AdpLogSummaryServiceImpl extends AdpSimpleServiceImpl<JdcAdpTxnLogsummary>
        implements AdpLogSummaryService {

    @Autowired
    SessionFactory sessionFactory;

    /**
     *
     * @return
     */
    @Override
    public Class<JdcAdpTxnLogsummary> getRealClass() {
        return JdcAdpTxnLogsummary.class;
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
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpTxnLogsummary.class);
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
        for (AdpProduksiDetailModel list : model.getLines()) {
            JdcAdpTxnLogsummary data = null;
            if (list.getId() != null) {
                data = findById(list.getId());
                data.setUpdateBy(userLogin.getId());
                data.setUpdateDate(new Date(System.currentTimeMillis()));
                data.setLineCode(model.getLineCode());
                data.setPoItem(model.getPoItem());
                data.setPoNo(model.getPoNo());
                data.setSave(1l);
                data.setInputDate(list.getInputDate());
                data.setPartial(list.getPartial());
                data.setTotalPairs(list.getTotalPairs());
                data.setSample(list.getSample());
                data.setPairs(list.getPairs());
                data.setCartoon(list.getCartoon());
                data.setPersentase(list.getPersentase());
                data.setCode(list.getCode());
                data.setIssue(list.getIssue());
                data.setResult(list.getResult());
                data.setRemark(list.getRemark());
                saveOrUpdate(data);
            } else {
                if (list.getId() == null) {
                    data = new JdcAdpTxnLogsummary();
                    data.setCreateBy(userLogin.getId());
                    data.setCreateDate(new Date(System.currentTimeMillis()));
                }
                data.setLineCode(model.getLineCode());
                data.setPoItem(model.getPoItem());
                data.setPoNo(model.getPoNo());
                data.setSave(1l);
                data.setInputDate(list.getInputDate());
                data.setPartial(list.getPartial());
                data.setTotalPairs(list.getTotalPairs());
                data.setSample(list.getSample());
                data.setPairs(list.getPairs());
                data.setCartoon(list.getCartoon());
                data.setPersentase(list.getPersentase());
                data.setCode(list.getCode());
                data.setIssue(list.getIssue());
                data.setResult(list.getResult());
                data.setRemark(list.getRemark());
                saveOrUpdate(data);
            }
//            data.setLineCode(model.getLineCode());
//            data.setPoItem(model.getPoItem());
//            data.setPoNo(model.getPoNo());
//            data.setSave(1l);
//            data.setInputDate(list.getInputDate());
//            data.setPartial(list.getPartial());
//            data.setTotalPairs(list.getTotalPairs());
//            data.setSample(list.getSample());
//            data.setPairs(list.getPairs());
//            data.setCartoon(list.getCartoon());
//            data.setPersentase(list.getPersentase());
//            data.setCode(list.getCode());
//            data.setIssue(list.getIssue());
//            data.setResult(list.getResult());
//            data.setRemark(list.getRemark());
//            saveOrUpdate(data);
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
        for (AdpProduksiDetailModel list : model.getLines()) {
            JdcAdpTxnLogsummary data = null;
            if (model.getId() != null) {
                data = findById(model.getId());
                data.setUpdateBy(loginSecUser.getId());
                data.setUpdateDate(new Date(System.currentTimeMillis()));
            } else {
                data = new JdcAdpTxnLogsummary();
                data.setCreateBy(loginSecUser.getId());
                data.setCreateDate(new Date(System.currentTimeMillis()));
            }
            data.setLineCode(model.getLineCode());
            data.setPoItem(model.getPoItem());
            data.setPoNo(model.getPoNo());
            data.setSubmit(1l);
            data.setInputDate(list.getInputDate());
            data.setPartial(list.getPartial());
            data.setTotalPairs(list.getTotalPairs());
            data.setSample(list.getSample());
            data.setCartoon(list.getCartoon());
            data.setPairs(list.getPairs());
            data.setPersentase(list.getPersentase());
            data.setCode(list.getCode());
            data.setIssue(list.getIssue());
            data.setResult(list.getResult());
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
            Query query = this.sessionFactory.getCurrentSession().createQuery("delete from JdcAdpTxnLogsummary where id =:id ");
            query.setLong("id", data.getId());
            query.executeUpdate();
        }
    }

    @SuppressWarnings("unchecked")
    private List<AdpProduksiModel> getListDelete(String lineCode, String poNo, String poItem) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpTxnLogsummary.class);
        criteria.add(Restrictions.eq("lineCode", lineCode));
        criteria.add(Restrictions.eq("poNo", poNo));
        criteria.add(Restrictions.eq("poItem", poItem));
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("id"), "id"))
                .setResultTransformer(Transformers.aliasToBean(AdpProduksiModel.class));
        List<AdpProduksiModel> result = criteria.list();
        return result;
    }

    /**
     *
     * @param searchMap
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<JdcAdpTxnLogsummary> retrieveData(Map<String, Object> searchMap) {
        String lineCode = (String) searchMap.get("lineCode");
        String poNo = (String) searchMap.get("poNo");
        String poItem = (String) searchMap.get("poItem");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpTxnLogsummary.class);
        criteria.add(Restrictions.eq("lineCode", lineCode));
        criteria.add(Restrictions.eq("poNo", poNo));
        criteria.add(Restrictions.eq("poItem", poItem));
        return criteria.list();
    }

    /**
     *
     * @param searchMap
     * @return
     */
    @Override
    public List<AdpInspectionLogSummaryReportModel> getDataReport(HashMap<String, Object> searchMap) {
        List<AdpInspectionLogSummaryReportModel> retVal = new ArrayList<>();
        String ncvs = (String) searchMap.get("ncvs");
        String po_item = (String) searchMap.get("po_item");
        String po_no = (String) searchMap.get("po_no");

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpTxnLogsummary.class);

        if (StringUtils.isNotBlank(ncvs)) {
            criteria.add(Restrictions.eq("lineCode", ncvs));
        }
        if (StringUtils.isNotBlank(po_item)) {
            criteria.add(Restrictions.eq("poItem", po_item));
        }
        if (StringUtils.isNotBlank(po_no)) {
            criteria.add(Restrictions.eq("poNo", po_no));
        }
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("inputDate"), "input_date")
                .add(Projections.property("partial"), "partial")
                .add(Projections.property("totalPairs"), "total_pairs")
                .add(Projections.property("cartoon"), "cartoon")
                .add(Projections.property("sample"), "sample")
                .add(Projections.property("pairs"), "pairs")
                .add(Projections.property("persentase"), "percentage")
                .add(Projections.property("code"), "code")
                .add(Projections.property("issue"), "issue")
                .add(Projections.property("result"), "result"))
                .setResultTransformer(Transformers.aliasToBean(AdpInspectionLogSummaryReportModel.class));
        List<AdpInspectionLogSummaryReportModel> result = criteria.list();

        for (AdpInspectionLogSummaryReportModel data : result) {
            AdpInspectionLogSummaryReportModel list = new AdpInspectionLogSummaryReportModel();
            list.setInput_date(data.getInput_date());
            list.setPartial(data.getPartial());
            list.setTotal_pairs(data.getTotal_pairs());
            list.setCartoon(data.getCartoon());
            list.setSample(data.getSample());;
            list.setPairs(data.getPairs());
            list.setPercentage(data.getPercentage());
            list.setCode(data.getCode());
            if (data.getIssue() == null) {
                list.setIssue("");
            } else {
                list.setIssue(data.getIssue());
            }
            list.setResult(data.getResult());

            retVal.add(list);
        }
        return retVal;
    }
}
