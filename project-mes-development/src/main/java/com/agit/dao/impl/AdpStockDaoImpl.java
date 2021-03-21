package com.agit.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.agit.entity.JdcAdpTxnstock;
import com.project.common.DataTables;
import com.agit.controller.sample.model.AdpStockModel;
import com.agit.dao.AdpStockDao;
import com.project.common.SortField;
import java.math.BigInteger;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

/**
 *
 * @author Ridwan
 */
@Repository
public class AdpStockDaoImpl extends AdpBaseDao<JdcAdpTxnstock> implements AdpStockDao {

    @Autowired
    SessionFactory sessionFactory;

    private Map<String, Object> bindparams;

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @Override
    public List<AdpStockModel> getDataList(DataTables dataTables, HashMap<String, Object> searchMap) {
        String sampleReq = (String) searchMap.get("sampleReq");

        bindparams = new HashMap<>();
        List<AdpStockModel> data = new ArrayList<AdpStockModel>();
        StringBuilder sql = new StringBuilder("SELECT  "
                + "b.sample_req, "
                + "b.model, "
                + "b.product_code, "
                + "b.\"size\", "
                + "b.qty, "
                + "((b.qty) - sum(coalesce(a.transfer_qty,0)) + sum(coalesce(a.return_qty,0))) as onHand,  "
                + "b.spk_id "
                + "from jdcadp_txnstock a "
                + "inner join jdcadp_mstspk b on a.spk_id = b.spk_id ");
        sql.append("WHERE 1=1 ");
        if (StringUtils.isNotBlank(sampleReq)) {
            sql.append("AND upper(b.sample_req) LIKE upper(:bindsample) ");
            bindparams.put("bindsample", "%" + sampleReq + "%");
        }
        sql.append("GROUP BY "
                + "b.sample_req, "
                + "b.model, "
                + "b.qty, "
                + "b.\"size\", "
                + "b.product_code, "
                + "b.spk_id ");
        List<SortField> sortFields = dataTables.generateSortFields();
        for (SortField sf : sortFields) {
            if ("asc".equalsIgnoreCase(sf.getDirection())) {
                sql.append("ORDER BY ").append(sf.getField()).append(" ");
                sql.append("ASC");
            } else {
                sql.append("ORDER BY ").append(sf.getField()).append(" ");
                sql.append("DESC");
            }
        }
        Query query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
        for (Map.Entry<String, Object> bindparam : bindparams.entrySet()) {
            query.setParameter(bindparam.getKey(), bindparam.getValue());
        }
        query.setFirstResult(dataTables.getiDisplayStart());
        query.setMaxResults(dataTables.getiDisplayLength());
        List queryResult = query.list();
        AdpStockModel retVal;
        Object[] obj;
        for (Object object : queryResult) {
            obj = (Object[]) object;
            retVal = new AdpStockModel();
            retVal.setSample_req((String) obj[0]);
            retVal.setModel((String) obj[1]);
            retVal.setProduct_code((String) obj[2]);
            retVal.setSize((String) obj[3]);
            retVal.setQty((Double) obj[4]);
            retVal.setOnHand((Double) obj[5]);
            retVal.setSpk_id((BigInteger) obj[6]);
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
    public Long getCountData(HashMap<String, Object> searchMap) {
        String sampleReq = (String) searchMap.get("sampleReq");
        bindparams = new HashMap<>();
        List<AdpStockModel> data = new ArrayList<AdpStockModel>();
        StringBuilder sql = new StringBuilder("SELECT  "
                + "b.sample_req, "
                + "b.model, "
                + "b.product_code, "
                + "b.\"size\", "
                + "b.qty, "
                + "((b.qty) - sum(coalesce(a.transfer_qty,0)) + sum(coalesce(a.return_qty,0))) as onHand,  "
                + "b.spk_id "
                + "from jdcadp_txnstock a "
                + "inner join jdcadp_mstspk b on a.spk_id = b.spk_id ");
        sql.append("WHERE 1=1 ");
        if (StringUtils.isNotBlank(sampleReq)) {
            sql.append("AND upper(b.sample_req) LIKE upper(:bindsample) ");
            bindparams.put("bindsample", "%" + sampleReq + "%");
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
        return (long) query.list().size();
    }

}
