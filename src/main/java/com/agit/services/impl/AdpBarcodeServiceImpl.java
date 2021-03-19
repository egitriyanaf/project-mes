package com.agit.services.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.common.DataTables;
import com.agit.controller.sample.model.AdpScannerModel;
import com.agit.entity.JdcAdpTxnbarcode;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.services.AdpBarcodeService;
import com.agit.util.DateUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erwin
 */
@Service
@Transactional(readOnly = true)
public class AdpBarcodeServiceImpl extends AdpSimpleServiceImpl<JdcAdpTxnbarcode> implements AdpBarcodeService {

    private Map<String, Object> bindparams;

    @Autowired
    SessionFactory sessionFactory;

    /**
     *
     * @return
     */
    @Override
    public Class<JdcAdpTxnbarcode> getRealClass() {
        return JdcAdpTxnbarcode.class;
    }

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @Override
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpTxnbarcode.class);
        return getDataTablesFromCriteria(criteria, dataTables);
    }

    /**
     *
     * @param model
     * @param user
     */
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void save(JdcAdpTxnbarcode model, JdcAdpMstUser user) {
        JdcAdpTxnbarcode data = null;
        if (model.getId() != null) {
            data = findById(model.getId());
            data.setUpdateBy(user.getId());
            data.setUpdateDate(new Date(System.currentTimeMillis()));
        } else {
            data = new JdcAdpTxnbarcode();
            data.setDptId(user.getDptId());
            data.setCreateBy(user.getId());
            data.setCreateDate(new Date(System.currentTimeMillis()));
        }

        data.setQrCode(model.getQrCode());
        data.setProductCode(model.getProductCode());
        data.setSampleReq(model.getSampleReq());
        data.setQty(model.getQty());
        data.setSize(model.getSize());
        data.setType(model.getType());
        saveOrUpdate(data);
        model.setId(data.getId());

    }

    /**
     *
     * @param qrCode
     * @param productCode
     * @param sampleReq
     * @param qty
     * @param size
     * @param dptId
     * @param type
     * @return
     */
    @Override
    public JdcAdpTxnbarcode findValidasi(String qrCode, String productCode, String sampleReq, Float qty, String size,
            Long dptId, String type) {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpTxnbarcode.class);
        if (StringUtils.isNotBlank(qrCode)) {
            criteria.add(Restrictions.eq("qrCode", qrCode));
        }
        if (StringUtils.isNotBlank(productCode)) {
            criteria.add(Restrictions.eq("productCode", productCode));
        }
        if (StringUtils.isNotBlank(sampleReq)) {
            criteria.add(Restrictions.eq("sampleReq", sampleReq));
        }
        if (qty != null) {
            criteria.add(Restrictions.eq("qty", qty));
        }
        if (StringUtils.isNotBlank(size)) {
            criteria.add(Restrictions.eq("size", size));
        }
        if (dptId != null) {
            criteria.add(Restrictions.eq("dptId", dptId));
        }
        if (StringUtils.isNotBlank(type)) {
            criteria.add(Restrictions.eq("type", type));
        }
        return (JdcAdpTxnbarcode) criteria.uniqueResult();
    }

    /**
     *
     * @param searchMap
     * @return
     */
    @Override
    public List<AdpScannerModel> getDashboardAbsen(Map<String, Object> searchMap) {
        bindparams = new HashMap<>();
        Long dptId = (Long) searchMap.get("dptId");
        String scanDate = (String) searchMap.get("scanDate");
        Date date = new Date();
        String nDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
        Date sDate = null;
        try {
            sDate = new SimpleDateFormat("yyyy-MM-dd").parse(nDate);
        } catch (ParseException ex) {
            Logger.getLogger(AdpBarcodeServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<AdpScannerModel> retVal = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT "
                + "b.dpt_id, "
                + "b.dpt_name, "
                + "SUM ( bcIn.qty ) AS typeIn, "
                + "SUM ( bcOut.qty ) AS typeOut "
                + "FROM "
                + "jdcadp_txnbcode "
                + "A LEFT JOIN jdcadp_mstdptunit b ON A.dpt_id = b.dpt_id "
                + "LEFT JOIN ( SELECT qty, barcode_id FROM jdcadp_txnbcode A WHERE A.TYPE = 'In' ) bcIn ON A.barcode_id = bcIn.barcode_id "
                + "LEFT JOIN ( SELECT qty, barcode_id FROM jdcadp_txnbcode A WHERE A.TYPE = 'Out' ) bcOut ON A.barcode_id = bcOut.barcode_id ");
        sql.append("WHERE 1=1 ");
        if (dptId != null) {
            bindparams.put("FILTER1", dptId);
        }
        if (dptId != null) {
            sql.append(" AND b.dpt_id = :FILTER1 ");
        }
        if (scanDate != null) {
            Date nScanDate = DateUtil.stringToDate(scanDate);
            bindparams.put("FILTERDATE", nScanDate);
            sql.append(" AND A.created_date = :FILTERDATE ");
        } else {
            bindparams.put("FILTER2", sDate);
            sql.append(" AND A.created_date = :FILTER2 ");
        }
        sql.append("GROUP BY b.dpt_id, b.dpt_name ");
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
        for (Map.Entry<String, Object> bindparams : bindparams.entrySet()) {
            sqlQuery.setParameter(bindparams.getKey(), bindparams.getValue());
        }
        List queryResult = sqlQuery.list();
        if (queryResult.size() > 0) {
            AdpScannerModel adpScannerModel;
            Object[] obj;
            for (Object object : queryResult) {
                obj = (Object[]) object;
                adpScannerModel = new AdpScannerModel();
                adpScannerModel.setDptId((BigInteger) obj[0]);
                adpScannerModel.setDepartement((String) obj[1]);
                adpScannerModel.setTotalIn((Double) obj[2]);
                adpScannerModel.setTotalOut((Double) obj[3]);
                retVal.add(adpScannerModel);
            }
        }
        return retVal;
    }

}
