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
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
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
        data.setRef_rework(model.getRef_rework());
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
      
        
        StringBuilder sql = new StringBuilder("SELECT\n" + 
"sum(b.agrade) AS gradea,\n" + 
"sum(b.bgrade) AS gradeb,\n" + 
"sum(b.cgrade) AS gradec,\n" + 
"sum(b.rework) AS grader,\n" + 
"sum(b.pembagi) AS pembagi\n" + 
"FROM ( select distinct a.area, a.type, a.ref_rework, a.created_by, a.dates,\n" + 
"a.line_code, a.demand_class,\n" + 
"sum(\n" + 
"CASE\n" + 
"WHEN a.type = 'A-Grade' THEN 1\n" + 
"ELSE 0\n" + 
"END) AS agrade,\n" + 
"sum(\n" + 
"CASE\n" + 
"WHEN a.type = 'B-Grade' and a.position = 'Pairs' THEN 1\n" + 
"when a.type = 'B-Grade' and a.position != 'Pairs' then 0.5\n" + 
"ELSE 0\n" + 
"END) AS bgrade,\n" + 
"sum(\n" + 
"CASE\n" + 
"WHEN a.type = 'C-Grade' and a.position = 'Pairs' THEN 1\n" + 
"when a.type = 'C-Grade' and a.position != 'Pairs' then 0.5\n" + 
"ELSE 0\n" + 
"END) AS cgrade,\n" + 
"sum(\n" + 
"CASE\n" + 
"WHEN a.type = 'Rework' and a.position !='Pairs' THEN 0.5\n" + 
"WHEN a.type = 'Rework' and a.position = 'Pairs' THEN 1\n" + 
"ELSE 0\n" + 
"END) AS rework,\n" + 
"sum(\n" + 
"case\n" + 
"when a.type = 'Rework' then 0\n" + 
"when a.type != 'Rework' and a.position = 'Pairs' then 1\n" + 
"when a.type != 'Rework' and a.position != 'Pairs' then 0.5\n" + 
"end\n" + 
") as pembagi\n" + 
"FROM ( SELECT DISTINCT jdcadp_txnqctrl.area, jdcadp_txnqctrl.type,\n" + 
"jdcadp_txnqctrl.line_code, jdcadp_txnqctrl.demand_class,\n" + 
"jdcadp_txnqctrl.ref_rework, jdcadp_txnqctrl.created_by, jdcadp_txnqctrl.position,\n" + 
"date(jdcadp_txnqctrl.created_date) AS dates\n" + 
"FROM jdcadp_txnqctrl\n" + 
"WHERE date(created_date) = current_date) as a\n" + 
"GROUP BY a.area, a.type, a.ref_rework, a.created_by, a.dates, a.line_code, a.demand_class) as b\n" + 
"where date(b.dates)=current_date and b.area='"+loginSecUser.getUsrType()+"' and b.created_by="+loginSecUser.getId()+"");
                
                
//        StringBuilder sql = new StringBuilder("SELECT\n" + 
//"sum(b.agrade) AS gradea,\n" + 
//"sum(b.bgrade) AS gradeb,\n" + 
//"sum(b.cgrade) AS gradec,\n" + 
//"sum(b.rework) AS grader,\n" + 
//"sum(b.total_output) as pembagi\n" + 
//"FROM ( select distinct a.area, a.type, a.ref_rework, a.created_by, a.dates,\n" + 
//"a.line_code, a.demand_class,\n" + 
//"sum(\n" + 
//"CASE\n" + 
//"WHEN a.type = 'A-Grade' THEN 1\n" + 
//"ELSE 0\n" + 
//"END) AS agrade,\n" + 
//"sum(\n" + 
//"CASE\n" + 
//"WHEN a.type = 'B-Grade' THEN 1\n" + 
//"ELSE 0\n" + 
//"END) AS bgrade,\n" + 
//"sum(\n" + 
//"CASE\n" + 
//"WHEN a.type = 'C-Grade' THEN 1\n" + 
//"ELSE 0\n" + 
//"END) AS cgrade,\n" + 
//"sum(\n" + 
//"CASE\n" + 
//"WHEN a.type = 'Rework' THEN 0.5\n" + 
//"WHEN a.type = 'A-Grade' THEN 0\n" + 
//"WHEN a.type = 'B-Grade' THEN 0\n" + 
//"WHEN a.type = 'C-Grade' THEN 0\n" + 
//"ELSE NULL\n" + 
//"END) AS rework,\n" + 
//"sum(\n" + 
//"case when a.type ='Rework' then 0 else 1 end\n" + 
//") as total_output\n" + 
//"FROM ( SELECT DISTINCT jdcadp_txnqctrl.area, jdcadp_txnqctrl.type,\n" + 
//"jdcadp_txnqctrl.line_code, jdcadp_txnqctrl.demand_class,\n" + 
//"jdcadp_txnqctrl.ref_rework, jdcadp_txnqctrl.created_by,\n" + 
//"date(jdcadp_txnqctrl.created_date) AS dates\n" + 
//"FROM jdcadp_txnqctrl\n" + 
//"WHERE date(created_date) = current_date) as a\n" + 
//"GROUP BY a.area, a.type, a.ref_rework, a.created_by, a.dates, a.line_code, a.demand_class) as b \n" + 
//"where date(b.dates)=current_date and b.area='"+loginSecUser.getUsrType()+"' and b.created_by="+loginSecUser.getId()+"");
                
                
//        StringBuilder sql = new StringBuilder("select\n" + 
//            "sum(gradea)as gradea,\n" + 
//            "sum(gradebb)as gradeb,\n" + 
//            "sum(gradecc)as gradec,\n" + 
//            "sum(grader)as grader,\n" + 
//            "sum(pembagi)as pembagi\n" + 
//            "from\n" + 
//            "(select gradea,gradeb,gradec,sum(case when type ='Rework' then 0.5 else 0 end) as grader,\n" + 
//            "sum(case when type ='B-Grade' then 1 else 0 end) as gradebb,\n" + 
//            "sum(case when type ='C-Grade' then 1 else 0 end) as gradecc,\n" + 
//            "pembagi from\n" + 
//            "(select distinct type,ref_rework,gradea,gradeb,gradec,pembagi from\n" + 
//            "(select gradea,gradeb,gradec,pembagi,type,position,ref_rework,area,sample_request,created_by from\n" + 
//            "(select type,position,ref_rework,area,sample_request,created_by,\n" + 
//            "sum(case when type ='A-Grade' then qty_inspection else 0 end) as gradea,\n" + 
//            "sum(case when type ='B-Grade' then qty_inspection else 0 end) as gradeb,\n" + 
//            "sum(case when type ='C-Grade' then qty_inspection else 0 end) as gradec,\n" + 
//            "sum(case when type ='Rework' then 0 else qty_inspection end) as pembagi\n" + 
//            "from(select type,position,ref_rework,area,sample_request,created_by,\n" + 
//            "(case when position = 'Pairs' then 1 else 0.5 end) as qty_inspection\n" + 
//            "from jdcadp_txnqctrl where date(created_date)=current_date and sample_request is null\n" + 
//            "and area='"+loginSecUser.getUsrType()+"'\n" + 
//            "and created_by="+loginSecUser.getId()+" )a group by type,position,ref_rework,area,sample_request,created_by)b)c)d\n" + 
//            "group by gradea,gradeb,gradec,pembagi)e"); 
        
//        StringBuilder sql = new StringBuilder("SELECT "
//                + "count(agrade.qc_id) as gradea, "
//                + "count(bgrade.qc_id) as gradeb, "
//                + "count(cgrade.qc_id) as gradec, "
//                + "count(rewok.qc_id) as grader, "
//                + "b.dpt_name, "
//                + "b.dpt_id "
//                //                + "a.created_date "
//                + "FROM jdcadp_txnqctrl a "
//                + "LEFT JOIN jdcadp_mstdptunit b on a.dpt_id = b.dpt_id "
//                + "LEFT JOIN( "
//                + "SELECT qc_id "
//                + "FROM jdcadp_txnqctrl a "
//                + "WHERE a.\"type\"='A-Grade' "
//                + ")agrade on a.qc_id = agrade.qc_id "
//                + "LEFT JOIN( "
//                + "SELECT qc_id "
//                + "FROM jdcadp_txnqctrl a "
//                + "WHERE a.\"type\"='B-Grade' "
//                + ")bgrade on a.qc_id = bgrade.qc_id "
//                + "LEFT JOIN( "
//                + "SELECT qc_id "
//                + "FROM jdcadp_txnqctrl a "
//                + "WHERE a.\"type\"='C-Grade' "
//                + ")cgrade on a.qc_id = cgrade.qc_id "
//                + "LEFT JOIN( "
//                + "SELECT qc_id "
//                + "FROM jdcadp_txnqctrl a "
//                + "WHERE a.\"type\"='Rework' "
//                + ")rewok on a.qc_id = rewok.qc_id ");
//
//        sql.append("where a.sample_request is NULL ");
//        sql.append("AND a.area= :AREA ");
//        bindparams.put("AREA", loginSecUser.getUsrType());
//        sql.append("AND DATE(a.created_date) = CURRENT_DATE ");
//        sql.append("AND a.created_by= :CREATEDBY ");
//        bindparams.put("CREATEDBY", loginSecUser.getId());
//        if (!lineCode.isEmpty()) {
//            sql.append("AND a.line_code= :LINECODE ");
//            bindparams.put("LINECODE", lineCode);
//        }
////        bindparams.put("PARAMSDATE", dateNow);
//        sql.append("GROUP BY "
//                + "b.dpt_name, "
//                + "b.dpt_id ");
////                + "a.created_date ");
        Query query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
        for (Map.Entry<String, Object> bindparam : bindparams.entrySet()) {
            query.setParameter(bindparam.getKey(), bindparam.getValue());
        }
        List queryResult = query.list();
        if (!queryResult.isEmpty()) {
            Object[] obj = (Object[]) queryResult.get(0);
            retVal.setAgrade((BigDecimal) obj[0]);
            retVal.setBgrade((BigDecimal) obj[1]);
            retVal.setCgrade((BigDecimal) obj[2]);
            retVal.setRewok((BigDecimal) obj[3]);
            retVal.setPembagi((BigDecimal) obj[4]);
            //retVal.setDptName((String) obj[4]);
        }
        return retVal;
    }

}
