package com.agit.services.impl;

import com.agit.controller.sample.model.AdpStockTransferReportModel;
import com.agit.controller.sample.model.AdpStockModel;
import com.agit.dao.AdpStockDao;
import com.agit.entity.JdcAdpMstabsen;
import com.agit.entity.JdcAdpMstspk;
import com.agit.entity.JdcAdpTxnstock;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.services.AdpStockTransferService;
import com.agit.util.Constantas;
import com.agit.util.DateUtil;
import org.apache.commons.lang.StringUtils;
import com.project.common.DataTables;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ridwans
 */
@Service
@Transactional(readOnly = true)
public class AdpStockTransferServiceImpl extends AdpSimpleServiceImpl<JdcAdpTxnstock> implements AdpStockTransferService {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    AdpStockDao adpStockDao;

    private Map<String, Object> bindparams;

    /**
     *
     * @return
     */
    @Override
    public Class<JdcAdpTxnstock> getRealClass() {
        return JdcAdpTxnstock.class;
    }

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @Override
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap) {
        String sampleReq = (String) searchMap.get("sampleReq");
        Long spkId = (Long) searchMap.get("spkId");

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpTxnstock.class);
        criteria.createAlias("jdcAdpMstspk", "jdcAdpMstspk", JoinType.INNER_JOIN);
        if (StringUtils.isNotBlank(sampleReq)) {
            criteria.add(Restrictions.ilike("jdcAdpMstspk.sampleReq", sampleReq, MatchMode.ANYWHERE));
        }
        if (spkId != null) {
            criteria.add(Restrictions.eq("spkId", spkId));
        }
        criteria.addOrder(Order.asc("transferTo"));
        return getDataTablesFromCriteria(criteria, dataTables);
    }

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @Override
    public DataTables searchByMapCriteriaByGroup(DataTables dataTables, HashMap<String, Object> searchMap) {
        Long total = adpStockDao.getCountData(searchMap);
        List<AdpStockModel> data = adpStockDao.getDataList(dataTables, searchMap);
        return dataTables.extract(data, total);
    }

    /**
     *
     * @param param
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<JdcAdpMstspk> findBySampleReq(String param) {
        String sampleReq = param;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstspk.class);
        if (StringUtils.isNotBlank(sampleReq)) {
            criteria.add(Restrictions.ilike("sampleReq", sampleReq, MatchMode.ANYWHERE));
        }
        return criteria.list();
    }

    /**
     *
     * @param transfer
     * @param userLogin
     */
    @Override
    @Transactional
    public void saveTransfer(JdcAdpTxnstock transfer, JdcAdpMstUser userLogin) {
        JdcAdpTxnstock data = null;
        data = new JdcAdpTxnstock();
        data.setCreateBy(userLogin.getId());
        data.setCreateDate(new Date(System.currentTimeMillis()));
        data.setEstimatedDate(transfer.getEstimatedDate());
        data.setSpkId(transfer.getSpkId());
        data.setRemark(transfer.getRemark());
        data.setTransferTo(transfer.getTransferTo());
        data.setTransferQty(transfer.getTransferQty());
        saveOrUpdate(data);
        transfer.setId(data.getId());
    }

    /**
     *
     * @param transfer
     * @param userLogin
     */
    @Override
    @Transactional
    public void returnTransfer(JdcAdpTxnstock transfer, JdcAdpMstUser userLogin) {
        JdcAdpTxnstock data = findById(transfer.getId());
        JdcAdpTxnstock val = null;
        val = new JdcAdpTxnstock();
        val.setRequestId(data.getId());
        val.setCreateBy(userLogin.getId());
        val.setCreateDate(new Date(System.currentTimeMillis()));
        val.setSpkId(data.getSpkId());
        val.setTransferTo(data.getTransferTo());
        val.setRemark(data.getRemark());
        val.setReturnDate(transfer.getReturnDate());
        val.setReturnQty(transfer.getReturnQty());
        val.setEstimatedDate(data.getEstimatedDate());
        saveOrUpdate(val);
        transfer.setId(val.getId());
    }

    /**
     *
     * @param param
     * @return
     */
    @Override
    public List<AdpStockModel> getStock(String param) {
        bindparams = new HashMap<>();
        List<AdpStockModel> data = new ArrayList<AdpStockModel>();
        AdpStockModel retVal = new AdpStockModel();
        StringBuilder sql = new StringBuilder("SELECT  "
                + "((b.qty) - sum(coalesce(a.transfer_qty,0)) + sum(coalesce(a.return_qty,0))) as onHand  "
                + "from jdcadp_txnstock a "
                + "left join jdcadp_mstspk b on a.spk_id = b.spk_id ");
        sql.append("WHERE 1=1 ");
        if (StringUtils.isNotBlank(param)) {
            sql.append("AND upper(b.sample_req) LIKE upper(:bindsample) ");
            bindparams.put("bindsample", "%" + param + "%");
        }
        sql.append("GROUP BY "
                + "b.sample_req, "
                + "b.model, "
                + "b.qty, "
                + "b.\"size\", "
                + "b.product_code, "
                + "b.spk_id ");
        Query query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
        for (Map.Entry<String, Object> bindparam : bindparams.entrySet()) {
            query.setParameter(bindparam.getKey(), bindparam.getValue());
        }
        List queryResult = query.list();
        if (!queryResult.isEmpty()) {
            retVal.setOnHand((Double) queryResult.get(0));
            data.add(retVal);
        }
        if (data.size() < 1) {
            return null;
        } else {
            return data;
        }

    }

    /**
     *
     * @param param
     * @return
     */
    @Override
    public List<AdpStockModel> getRemainingQty(Long param) {
        bindparams = new HashMap<>();
        List<AdpStockModel> data = new ArrayList<AdpStockModel>();
        AdpStockModel retVal = new AdpStockModel();
        StringBuilder sql = new StringBuilder("SELECT  "
                + "(sum(coalesce(a.transfer_qty,0)) - sum(coalesce(stock.qty,0)))  "
                + "from jdcadp_txnstock a   "
                + "left join(  "
                + " SELECT sum(coalesce(a.return_qty,0))as qty,a.request_id "
                + " from jdcadp_txnstock a    "
                + " GROUP BY a.request_id "
                + ")stock on a.trf_id = stock.request_id ");
        sql.append("WHERE 1=1 ");
        if (param != null) {
            sql.append("AND a.trf_id = :PARAMS ");
            bindparams.put("PARAMS", param);
        }
        Query query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
        for (Map.Entry<String, Object> bindparam : bindparams.entrySet()) {
            query.setParameter(bindparam.getKey(), bindparam.getValue());
        }
        List queryResult = query.list();
        if (!queryResult.isEmpty()) {
            retVal.setOnHand((Double) queryResult.get(0));
            data.add(retVal);
        }
        return data;
    }

    /**
     *
     * @param searchMap
     * @return
     */
    @Override
    public List<AdpStockTransferReportModel> getDataReport(HashMap<String, Object> searchMap) {
        List<AdpStockTransferReportModel> retVal = new ArrayList<>();
        String startDate = (String) searchMap.get("startDate");
        String endDate = (String) searchMap.get("endDate");

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpTxnstock.class);
        criteria.createAlias("jdcAdpMstspk", "jdcAdpMstspk");
        
        if (StringUtils.isNotBlank(startDate)) {
            Date value = null;
            try {
                value = Constantas.fdate.parse(startDate);
            } catch (ParseException ex) {
                Logger.getLogger(AdpAbsenServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            criteria.add(Restrictions.ge("createDate", DateUtil.truncate(value)));
        }
        if (StringUtils.isNotBlank(endDate)) {
            Date value = null;
            try {
                value = Constantas.fdate.parse(endDate);
            } catch (ParseException ex) {
                Logger.getLogger(AdpAbsenServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            criteria.add(Restrictions.le("createDate", DateUtil.endOfDay(value)));
        }
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("jdcAdpMstspk.sampleReq"), "sample_req")
                .add(Projections.property("jdcAdpMstspk.qty"), "qty")
                .add(Projections.property("remark"), "remark")
                .add(Projections.property("transferQty"), "transfer_qty")
                .add(Projections.property("returnQty"), "return_qty"))
                .setResultTransformer(Transformers.aliasToBean(AdpStockTransferReportModel.class));
        List<AdpStockTransferReportModel> result = criteria.list();
       
        for(AdpStockTransferReportModel data:result){
             AdpStockTransferReportModel list = new AdpStockTransferReportModel();
            list.setSample_req(data.getSample_req());
            list.setQty(data.getQty());
            list.setRemark(data.getRemark());
            
            
            if(data.getReturn_qty()== null){
                list.setReturn_qty(0f);
            }else{
                list.setReturn_qty(data.getReturn_qty());
            }
            
            if(data.getTransfer_qty() == null){
                list.setTransfer_qty(0f);         
            }else{
                list.setTransfer_qty(data.getTransfer_qty());         
            }
            
            retVal.add(list);
        }
        return retVal;
    }
}
