package com.agit.services.impl;

import com.agit.controller.sample.model.AdpDailyDefectQCAssemblyReportModel;
import com.agit.controller.sample.model.AdpDailyDefectQCPreparationReportModel;
import com.agit.controller.sample.model.AdpDailyDefectQCSewingReportModel;
import com.agit.controller.qc.model.AdpInspectionLogSummaryReportModel;
import com.agit.controller.qc.model.AdpQcCounterModel;
import com.agit.entity.JdcAdpTxnbarcode;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.common.DataTables;
import com.agit.entity.JdcAdpMstlookup;
import com.agit.entity.JdcAdpTxnLogsummary;
import com.agit.entity.JdcAdpTxnqcctrl;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.services.AdpHourlyInspectionService;
import com.agit.util.DateUtil;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static net.sf.dynamicreports.report.builder.DynamicReports.query;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

/**
 *
 * @author erwin
 */
@Service
@Transactional(readOnly = true)
public class AdpHourlyInspectionServiceImpl extends AdpSimpleServiceImpl<JdcAdpTxnqcctrl> implements AdpHourlyInspectionService {

    private Map<String, Object> bindparams;

    @Autowired
    SessionFactory sessionFactory;

    /**
     *
     * @return
     */
    @Override
    public Class<JdcAdpTxnqcctrl> getRealClass() {
        return JdcAdpTxnqcctrl.class;
    }

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @Override
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpTxnqcctrl.class);
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
    public void save(JdcAdpTxnqcctrl model, JdcAdpMstUser user) {

        JdcAdpTxnqcctrl data = null;
        if (model.getId() != null) {
            data = findById(model.getId());
            data.setUpdateBy(user.getId());
            data.setUpdateDate(new Date(System.currentTimeMillis()));
        } else {
            data = new JdcAdpTxnqcctrl();
            data.setDptId(user.getDptId());
            data.setCreateBy(user.getId());
            data.setCreateDate(new Date(System.currentTimeMillis()));
        }
        data.setDemandClass(model.getDemandClass());
        data.setSampleReq(model.getSampleReq());
        data.setDefect(model.getDefect());
        data.setArea(model.getArea());
        data.setCategory(model.getCategory());
        data.setLineCode(model.getLineCode());
        data.setDptId(user.getDptId());
        data.setPoItem(model.getPoItem());
        data.setPoNo(model.getPoNo());
        data.setPosition(model.getPosition());
        data.setProductCode(model.getProductCode());
        data.setProductDesc(model.getProductDesc());
        data.setType(model.getType());
        saveOrUpdate(data);
        model.setId(data.getId());
    }

    /**
     *
     * @param secUser
     * @param value
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<JdcAdpMstlookup> getAllDefectByLogin(JdcAdpMstUser secUser, String value) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstlookup.class);
        criteria.add(Restrictions.eq("type", secUser.getUsrType()));
        criteria.add(Restrictions.eq("value", value));
        criteria.add(Restrictions.eq("activeFlag", "Y"));
//        criteria.setMaxResults(5);
        return criteria.list();
    }

    /**
     *
     * @param user
     * @return
     */
    @Override
    public List<JdcAdpTxnqcctrl> findByCategory(JdcAdpMstUser user) {
        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String tDate = format.format(dateNow);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpTxnqcctrl.class);
        try {
            criteria.add(Restrictions.ge("createDate", format.parse(tDate)));
        } catch (ParseException ex) {
            Logger.getLogger(AdpHourlyInspectionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        criteria.add(Restrictions.lt("createDate", DateUtil.addDays(dateNow, +1)));
        criteria.add(Restrictions.eq("createBy", user.getId()));
        criteria.add(Restrictions.eq("dptId", user.getDptId()));
        criteria.add(Restrictions.isNull("sampleReq"));
        criteria.add(Restrictions.not(Restrictions.in("type", new String[]{"A-Grade"})));
        criteria.setProjection(Projections.projectionList()
                .add(Projections.count("id"))
                .add(Projections.groupProperty("category")));
        return criteria.list();
    }

    /**
     *
     * @return
     */
    @Override
    public List<JdcAdpTxnbarcode> sumBarcodeOut() {
        Date dateNow = new Date();
        Long dptId = 19l;
        String tipe = "Out";
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpTxnbarcode.class);
        criteria.add(Restrictions.eq("createDate", dateNow));
        criteria.add(Restrictions.eq("dptId", dptId));
        criteria.add(Restrictions.ilike("type", tipe));
        criteria.setProjection(Projections.projectionList()
                .add(Projections.sum("qty")));
        return (List<JdcAdpTxnbarcode>) criteria.list();
    }

    /**
     *
     * @param user
     * @return
     */
    @Override
    public List<JdcAdpTxnqcctrl> countAGrade(JdcAdpMstUser user) {
        Date dateNow = new Date();
        String type = "A-Grade";

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpTxnqcctrl.class);
        criteria.add(Restrictions.eq("createBy", user.getId()));
        criteria.add(Restrictions.eq("dptId", user.getDptId()));
        criteria.add(Restrictions.eq("type", type));
        criteria.add(Restrictions.eq("createDate", dateNow));
        criteria.add(Restrictions.isNull("sampleReq"));
        return criteria.list();

    }

    /**
     *
     * @param user
     * @return
     */
    @Override
    public List<JdcAdpTxnqcctrl> getCounterWorkshop(JdcAdpMstUser user) {
        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String tDate = format.format(dateNow);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpTxnqcctrl.class);
        try {
            criteria.add(Restrictions.ge("createDate", format.parse(tDate)));
        } catch (ParseException ex) {
            Logger.getLogger(AdpHourlyInspectionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }        
        criteria.add(Restrictions.lt("createDate", DateUtil.addDays(dateNow, +1)));
        criteria.add(Restrictions.eq("createBy", user.getId()));
        criteria.add(Restrictions.eq("dptId", user.getDptId()));
        criteria.add(Restrictions.isNotNull("sampleReq"));
        criteria.add(Restrictions.not(Restrictions.in("type", new String[]{"A-Grade"})));
        criteria.setProjection(Projections.projectionList()
                .add(Projections.count("id"))
                .add(Projections.groupProperty("category")));
        return criteria.list();
    }

    /**
     *
     * @param loginSecUser
     * @param searchMap
     * @return
     */
    @Override
    public AdpQcCounterModel getAllCounter(JdcAdpMstUser loginSecUser, Map<String, Object> searchMap) {
        bindparams = new HashMap<>();
        AdpQcCounterModel retVal = new AdpQcCounterModel();
        StringBuilder sql = new StringBuilder(" SELECT "
                + " count(a.qc_id) "
                + " FROM jdcadp_txnqctrl a ");
        sql.append("where a.sample_request is NULL ");
        sql.append("AND a.area= :AREA ");
        bindparams.put("AREA", loginSecUser.getUsrType());
        sql.append("AND DATE(a.created_date) = CURRENT_DATE ");
//        sql.append("GROUP BY a.dpt_id,a.created_date");
        Query query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
        for (Map.Entry<String, Object> bindparam : bindparams.entrySet()) {
            query.setParameter(bindparam.getKey(), bindparam.getValue());
        }
        List queryResult = query.list();
        if (!queryResult.isEmpty()) {
            retVal.setCounter((BigInteger) queryResult.get(0));
        }
        return retVal;
    }
    
//     @Override
//    public AdpQcCounterModel getAllCounterNew(JdcAdpMstUser loginSecUser, Map<String, Object> searchMap) {
//        bindparams = new HashMap<>();
//        AdpQcCounterModel retVal = new AdpQcCounterModel();
//        StringBuilder sql = new StringBuilder(" SELECT "
//                + " count(a.qc_id) "
//                + " FROM jdcadp_txnqctrl a ");
//        sql.append("where a.sample_request is NULL ");
//        sql.append("AND a.area= :AREA ");
//        bindparams.put("AREA", loginSecUser.getUsrType());
//        sql.append("AND a.area= :AREA ");
//        sql.append("AND a.type != 'Rework' ");
//        sql.append("AND DATE(a.created_date) = CURRENT_DATE ");
////        sql.append("GROUP BY a.dpt_id,a.created_date");
//        Query query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
//        for (Map.Entry<String, Object> bindparam : bindparams.entrySet()) {
//            query.setParameter(bindparam.getKey(), bindparam.getValue());
//        }
//        List queryResult = query.list();
//        if (!queryResult.isEmpty()) {
//            retVal.setCounter((BigInteger) queryResult.get(0));
//        }
//        return retVal;
//    }

    /**
     *
     * @param loginSecUser
     * @param searchMap
     * @return
     */
    
    @Override
    public AdpQcCounterModel getAllCounterNew(JdcAdpMstUser loginSecUser, Map<String, Object> searchMap) {
        bindparams = new HashMap<>();
        AdpQcCounterModel retVal = new AdpQcCounterModel();
        StringBuilder sql = new StringBuilder(" SELECT "
                + " count(a.qc_id) "
                + " FROM jdcadp_txnqctrl a ");
        sql.append("where a.sample_request is NULL ");
        sql.append("AND a.area= :AREA ");
        bindparams.put("AREA", loginSecUser.getUsrType());
        sql.append("AND a.created_by= :CREATEDBY ");
        bindparams.put("CREATEDBY", loginSecUser.getId());
        sql.append("AND a.type != 'Rework' ");
        sql.append("AND DATE(a.created_date) = CURRENT_DATE ");
//        sql.append("GROUP BY a.dpt_id,a.created_date");
        Query query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
        for (Map.Entry<String, Object> bindparam : bindparams.entrySet()) {
            query.setParameter(bindparam.getKey(), bindparam.getValue());
        }
        List queryResult = query.list();
        if (!queryResult.isEmpty()) {
            retVal.setCounter((BigInteger) queryResult.get(0));
        }
        return retVal;
    }

    /**
     *
     * @param loginSecUser
     * @param searchMap
     * @return
     */
    @Override
    public AdpQcCounterModel getDetailCounter(JdcAdpMstUser loginSecUser, Map<String, Object> searchMap) {
        bindparams = new HashMap<>();
        String lineCode = (String) searchMap.get("lineCode");
        Date dateNow = new Date();
        AdpQcCounterModel retVal = new AdpQcCounterModel();
        StringBuilder sql = new StringBuilder("SELECT "
                + "count(agrade.qc_id) as gradea, "
                + "count(bgrade.qc_id) as gradeb, "
                + "count(cgrade.qc_id) as gradec, "
                + "count(rewok.qc_id) as grader, "
                + "b.dpt_name, "
                + "b.dpt_id "
                //                + "a.created_date "
                + "FROM jdcadp_txnqctrl a "
                + "LEFT JOIN jdcadp_mstdptunit b on a.dpt_id = b.dpt_id "
                + "LEFT JOIN( "
                + "SELECT qc_id "
                + "FROM jdcadp_txnqctrl a "
                + "WHERE a.\"type\"='A-Grade' "
                + ")agrade on a.qc_id = agrade.qc_id "
                + "LEFT JOIN( "
                + "SELECT qc_id "
                + "FROM jdcadp_txnqctrl a "
                + "WHERE a.\"type\"='B-Grade' "
                + ")bgrade on a.qc_id = bgrade.qc_id "
                + "LEFT JOIN( "
                + "SELECT qc_id "
                + "FROM jdcadp_txnqctrl a "
                + "WHERE a.\"type\"='C-Grade' "
                + ")cgrade on a.qc_id = cgrade.qc_id "
                + "LEFT JOIN( "
                + "SELECT qc_id "
                + "FROM jdcadp_txnqctrl a "
                + "WHERE a.\"type\"='Rework' "
                + ")rewok on a.qc_id = rewok.qc_id ");

        sql.append("where a.sample_request is NULL ");
        sql.append("AND a.area= :AREA ");
        bindparams.put("AREA", loginSecUser.getUsrType());
        sql.append("AND DATE(a.created_date) = CURRENT_DATE ");
        sql.append("AND a.created_by= :CREATEDBY ");
        bindparams.put("CREATEDBY", loginSecUser.getId());
        if (!lineCode.isEmpty()) {
            sql.append("AND a.line_code= :LINECODE ");
            bindparams.put("LINECODE", lineCode);
        }
//        bindparams.put("PARAMSDATE", dateNow);
        sql.append("GROUP BY "
                + "b.dpt_name, "
                + "b.dpt_id ");
//                + "a.created_date ");
        Query query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
        for (Map.Entry<String, Object> bindparam : bindparams.entrySet()) {
            query.setParameter(bindparam.getKey(), bindparam.getValue());
        }
        List queryResult = query.list();
        if (!queryResult.isEmpty()) {
            Object[] obj = (Object[]) queryResult.get(0);
            retVal.setAgrade((BigInteger) obj[0]);
            retVal.setBgrade((BigInteger) obj[1]);
            retVal.setCgrade((BigInteger) obj[2]);
            retVal.setRewok((BigInteger) obj[3]);
            retVal.setDptName((String) obj[4]);
        }
        return retVal;
    }

}
