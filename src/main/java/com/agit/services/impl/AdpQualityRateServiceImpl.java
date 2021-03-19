package com.agit.services.impl;

import com.agit.controller.sample.model.AdpDailyDefectQCAssemblyReportModel;
import com.agit.controller.sample.model.AdpDailyDefectQCPreparationReportModel;
import com.agit.controller.sample.model.AdpDailyDefectQCSewingReportModel;
import com.agit.controller.sample.model.AdpQualityRateModel;
import com.agit.entity.JdcAdpTxnqcctrl;
import com.agit.services.AdpParamConfigService;
import com.agit.services.AdpQualityRateService;
import com.agit.util.Constantas;
import com.agit.util.DateUtil;
import com.agit.util.StringUtils;
import com.project.common.DataTables;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author TriAA
 */
@Service
@Transactional(readOnly = true)
public class AdpQualityRateServiceImpl extends AdpSimpleServiceImpl<JdcAdpTxnqcctrl> implements AdpQualityRateService {

    @Autowired
    SessionFactory sessionFactory;

    /**
     *
     */
    @Autowired
    protected AdpParamConfigService config;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param searchMap
     * @return
     */
    @Override
    public List<AdpQualityRateModel> getreportQualityRate(Map<String, Object> searchMap) {
        String productCode = (String) searchMap.get("productCode");
        String area = (String) searchMap.get("area");
        String dates = (String) searchMap.get("dates");
//        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        String tDate = format.format(dateNow);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpTxnqcctrl.class);
        if (org.apache.commons.lang.StringUtils.isNotBlank(dates)) {
            Date value = null;
            
            try {
                value = format.parse(dates);
            } catch (ParseException ex) {
                Logger.getLogger(AdpHourlyInspectionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            criteria.add(Restrictions.ge("createDate", DateUtil.truncate(value)));
        }
        if (org.apache.commons.lang.StringUtils.isNotBlank(dates)) {
            Date value = null;
            try {
                value = format.parse(dates);
            } catch (ParseException ex) {
                Logger.getLogger(AdpHourlyInspectionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            criteria.add(Restrictions.le("createDate", DateUtil.endOfDay(value)));
        }
        if (StringUtils.isNotEmpty(productCode)) {
            criteria.add(Restrictions.eq("productCode", productCode));
        }
        if (StringUtils.isNotEmpty(area)) {
            criteria.add(Restrictions.eq("area", area));
        }
        criteria.add(Restrictions.isNotNull("sampleReq"));
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("type"), "type")
                .add(Projections.rowCount(), "countType")
                .add(Projections.groupProperty("type"))).setResultTransformer(Transformers.aliasToBean(AdpQualityRateModel.class));
        criteria.addOrder(Order.asc("type"));
        return criteria.list();
    }

    /**
     *
     * @return
     */
    @Override
    public List<JdcAdpTxnqcctrl> getListProductCode() {
        Date dateNow = new Date();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpTxnqcctrl.class);
        criteria.add(Restrictions.eq("createDate", dateNow));
        criteria.add(Restrictions.isNotNull("sampleReq"));
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("productCode"), "productCode")
                .add(Projections.groupProperty("productCode")))
                .setResultTransformer(Transformers.aliasToBean(JdcAdpTxnqcctrl.class));
        criteria.addOrder(Order.asc("productCode"));
        return criteria.list();
    }

    /**
     *
     * @param searchMap
     * @return
     */
    @Override
    public List<AdpDailyDefectQCAssemblyReportModel> getDataReportAssembly(HashMap<String, Object> searchMap) {

        AdpDailyDefectQCAssemblyReportModel retVal;
        List<AdpDailyDefectQCAssemblyReportModel> data = new ArrayList<AdpDailyDefectQCAssemblyReportModel>();

        String ncvs = (String) searchMap.get("ncvs");
        String supervisor = (String) searchMap.get("supervisor");
        String startDate = (String) searchMap.get("startDate");
        String endDate = (String) searchMap.get("endDate");

        Map<String, Object> bindparams = new HashMap<>();

        StringBuilder sql = new StringBuilder("SELECT "
                + " a.created_date, "
                + " b.product_desc, "
                + " a.product_code, "
                + " COUNT ( overCement.qc_id ) AS OverCement, "
                + " COUNT ( stainUpper.qc_id ) AS StainUpper, "
                + " COUNT ( stainGaugeMarking.qc_id ) AS StainGaugeMarking, "
                + " COUNT ( stainOutsole.qc_id ) AS StainOutsole, "
                + " COUNT ( stainLace.qc_id ) AS StainLace, "
                + " COUNT ( overBuff.qc_id ) AS OverBuffing, "
                + " COUNT ( xRay.qc_id ) AS XRay, "
                + " COUNT ( overColor.qc_id ) AS OverColor, "
                + " COUNT ( wrinkleUpper.qc_id ) AS WrinkleUpper, "
                + " COUNT ( painting.qc_id ) AS Painting, "
                + " COUNT ( crooked.qc_id ) AS Crooked, "
                + " COUNT ( difToeHeel.qc_id ) AS DifToeHeel, "
                + " COUNT ( lineUp.qc_id ) AS LineUp, "
                + " COUNT ( collarTongueShape.qc_id ) AS CollarTongueShape, "
                + " COUNT ( bondGapOsUp.qc_id ) AS BondGapOsUp, "
                + " COUNT ( bondGapOsMs.qc_id ) AS BondGapOsMs, "
                + " COUNT ( brokenStitching.qc_id ) AS BrokenStitching, "
                + " COUNT ( ariance.qc_id ) AS Ariance, "
                + " COUNT ( peelOff.qc_id ) AS PeelOff, "
                + " COUNT ( sockliner.qc_id ) AS Sockliner, "
                + " COUNT ( docDate.qc_id ) AS DocDate, "
                + " COUNT ( others.qc_id ) AS Others	 "
                + " FROM "
                + " jdcadp_txnqctrl "
                + " a LEFT JOIN jdcadp_mstproduksi b ON a.product_code = b.jo_ppic "
                + " LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Over cement' ) overcement ON a.qc_id = overcement.qc_id "
                + " LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Stain Upper' ) stainUpper ON a.qc_id = stainUpper.qc_id "
                + " LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Stain Gauge Marking' ) stainGaugeMarking ON a.qc_id = stainGaugeMarking.qc_id "
                + " LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Stain Outsole' ) stainOutsole ON a.qc_id = stainOutsole.qc_id "
                + " LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Stain Lace' ) stainLace ON a.qc_id = stainLace.qc_id "
                + " LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Over buffing' ) overbuff ON a.qc_id = overbuff.qc_id "
                + " LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'X-ray' ) xRay ON a.qc_id = xRay.qc_id "
                + " LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Over color o/s' ) overColor ON a.qc_id = overColor.qc_id "
                + " LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Wrinkle upper' ) wrinkleUpper ON a.qc_id = wrinkleUpper.qc_id "
                + " LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Painting' ) painting ON a.qc_id = painting.qc_id "
                + " LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Crooked' ) crooked ON a.qc_id = crooked.qc_id  "
                + " LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Dif Toe/ Heel' ) difToeHeel ON a.qc_id = difToeHeel.qc_id  "
                + " LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Line Up' ) lineUp ON a.qc_id = lineUp.qc_id  "
                + " LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Collar /Tongue shape' ) collarTongueShape ON a.qc_id = collarTongueShape.qc_id  "
                + " LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Bond gap O/s to U/p' ) bondGapOsUp ON a.qc_id = bondGapOsUp.qc_id  "
                + " LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Bond gap O/s to M/s' ) bondGapOsMs ON a.qc_id = bondGapOsMs.qc_id  "
                + " LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Broken stitching' ) brokenStitching ON a.qc_id = brokenStitching.qc_id  "
                + " LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Ariance' ) ariance ON a.qc_id = ariance.qc_id  "
                + " LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Peel off' ) peelOff ON a.qc_id = peelOff.qc_id "
                + " LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Sockliner' ) sockliner ON a.qc_id = sockliner.qc_id  "
                + " LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Doc Date' ) docDate ON a.qc_id = docDate.qc_id  "
                + " LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Others' ) others ON a.qc_id = others.qc_id  WHERE ");

        sql.append("b.line_code = '" + ncvs + "' ");
        bindparams.put("NCVS", ncvs);

        Date startVal = DateUtil.stringToDate(startDate);
        sql.append("AND a.createdDate >= '" + startVal + "' ");
        bindparams.put("StartDate", startVal);

        Date endVal = DateUtil.stringToDate(endDate);
        sql.append("AND a.createdDate <= '" + endVal + "' ");
        bindparams.put("EndDate", endVal);

        sql.append(" GROUP BY  a.created_date, a.product_code, b.product_desc ");
        sql.append(" ORDER BY  a.created_date ");

        Query query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
        for (Map.Entry<String, Object> bindparam : bindparams.entrySet()) {
            query.setParameter(bindparam.getKey(), bindparam.getValue());
        }
        List queryResult = query.list();

        Object[] obj;
        for (Object object : queryResult) {
            obj = (Object[]) object;
            retVal = new AdpDailyDefectQCAssemblyReportModel();
            retVal.setDate((Date) obj[0]);
            retVal.setProduct_desc((String) obj[1]);
            retVal.setProduct_code((String) obj[2]);
            retVal.setOver_cement((Long) obj[3]);
            retVal.setStain_gauge_mk((Long) obj[4]);
            retVal.setStain_lace((Long) obj[5]);
            retVal.setStain_outsole((Long) obj[6]);
            retVal.setCol_tongue_sp((Long) obj[7]);
            retVal.setCrooked((Long) obj[8]);
            retVal.setDiff_toe((Long) obj[9]);
            retVal.setLine_up((Long) obj[10]);
            retVal.setAriance((Long) obj[11]);
            retVal.setBond_gap_os_up((Long) obj[12]);
            retVal.setBond_gap_os_ms((Long) obj[13]);
            retVal.setBroken_st((Long) obj[14]);
            retVal.setPeel_off((Long) obj[15]);
            retVal.setOver_buff((Long) obj[16]);
            retVal.setOver_color((Long) obj[17]);
            retVal.setPainting((Long) obj[18]);
            retVal.setWrinkle_up((Long) obj[19]);
            retVal.setX_ray((Long) obj[20]);
            retVal.setDoc_date((Long) obj[21]);
            retVal.setOthers((Long) obj[22]);
            retVal.setSock_liner((Long) obj[23]);
            retVal.setDefect((Long) obj[24]);
            retVal.setOutput((Long) obj[25]);
            retVal.setPercentage((Float) obj[26]);
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
    public List<AdpDailyDefectQCSewingReportModel> getDataReportSewing(HashMap<String, Object> searchMap) {
        List<AdpDailyDefectQCSewingReportModel> retVal = new ArrayList<>();
        String ncvs = (String) searchMap.get("ncvs");
        String month = (String) searchMap.get("month");
        String supervisor = (String) searchMap.get("supervisor");

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpTxnqcctrl.class);

        if (org.apache.commons.lang.StringUtils.isNotBlank(ncvs)) {
            criteria.add(Restrictions.eq("lineCode", ncvs));
        }

        return retVal;
    }

    /**
     *
     * @param searchMap
     * @return
     */
    @Override
    public List<AdpDailyDefectQCPreparationReportModel> getDataReportPreparation(HashMap<String, Object> searchMap) {
        List<AdpDailyDefectQCPreparationReportModel> retVal = new ArrayList<>();
        String ncvs = (String) searchMap.get("ncvs");
        String month = (String) searchMap.get("month");
        String supervisor = (String) searchMap.get("supervisor");

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpTxnqcctrl.class);

        if (org.apache.commons.lang.StringUtils.isNotBlank(ncvs)) {
            criteria.add(Restrictions.eq("lineCode", ncvs));
        }

        return retVal;
    }

}
