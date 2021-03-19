package com.agit.services.impl;

import com.agit.controller.sample.model.AdpDailyDefectQCAssemblyReportModel;
import com.agit.controller.sample.model.AdpDailyDefectQCPreparationReportModel;
import com.agit.controller.sample.model.AdpDailyDefectQCSewingReportModel;
import com.agit.controller.sample.model.AdpQualityRateModel;
import com.agit.entity.JdcAdpTxnqcctrl;
import com.agit.services.AdpParamConfigService;
import com.agit.services.AdpQualityRateService;
import com.agit.util.DateUtil;
import com.agit.util.StringUtils;
import com.project.common.DataTables;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    
    @Autowired
    protected AdpParamConfigService config;
    
    private  Map<String, Object> bindparams;

    @Override
    public Class<JdcAdpTxnqcctrl> getRealClass() {
        return JdcAdpTxnqcctrl.class;
    }

    @Override
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AdpQualityRateModel> getreportQualityRate(Map<String, Object> searchMap) {
        String productCode = (String) searchMap.get("productCode");
        Date dateNow = new Date();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpTxnqcctrl.class);
        criteria.add(Restrictions.eq("createDate", dateNow));
        if (StringUtils.isNotEmpty(productCode)) {
            criteria.add(Restrictions.eq("productCode", productCode));
        }
        criteria.add(Restrictions.isNotNull("sampleReq"));
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("type"), "type")
                .add(Projections.rowCount(), "countType")
                .add(Projections.groupProperty("type"))).setResultTransformer(Transformers.aliasToBean(AdpQualityRateModel.class));
        criteria.addOrder(Order.asc("type"));
        return criteria.list();
    }

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
   
    @Override
    public List<AdpDailyDefectQCAssemblyReportModel> getDataReportAssembly(HashMap<String, Object> searchMap) {
        
        AdpDailyDefectQCAssemblyReportModel retVal;
        List<AdpDailyDefectQCAssemblyReportModel> data = new ArrayList<AdpDailyDefectQCAssemblyReportModel>();
        
        String ncvs = (String) searchMap.get("ncvs");
        String supervisor = (String) searchMap.get("supervisor");
        String startDate = (String) searchMap.get("startDate");
        String endDate = (String) searchMap.get("endDate");
        
        bindparams = new HashMap<>();
        
        StringBuilder sql = new StringBuilder("SELECT "
                +" c.usr_type, "
                +" a.created_date, "
                +" b.product_desc, "
                +" a.product_code, "
                +" COUNT ( overCement.qc_id ) AS OverCement, "
                +" COUNT ( stainUpper.qc_id ) AS StainUpper, "
                +" COUNT ( stainGaugeMarking.qc_id ) AS StainGaugeMarking, "
                +" COUNT ( stainOutsole.qc_id ) AS StainOutsole, "
                +" COUNT ( stainLace.qc_id ) AS StainLace, "
                +" COUNT ( overBuff.qc_id ) AS OverBuffing, "
                +" COUNT ( xRay.qc_id ) AS XRay, "
                +" COUNT ( overColor.qc_id ) AS OverColor, "
                +" COUNT ( wrinkleUpper.qc_id ) AS WrinkleUpper, "
                +" COUNT ( painting.qc_id ) AS Painting, "
                +" COUNT ( crooked.qc_id ) AS Crooked, "
                +" COUNT ( difToeHeel.qc_id ) AS DifToeHeel, "
                +" COUNT ( lineUp.qc_id ) AS LineUp, "
                +" COUNT ( collarTongueShape.qc_id ) AS CollarTongueShape, "
                +" COUNT ( bondGapOsUp.qc_id ) AS BondGapOsUp, "
                +" COUNT ( bondGapOsMs.qc_id ) AS BondGapOsMs, "
                +" COUNT ( brokenStitching.qc_id ) AS BrokenStitching, "
                +" COUNT ( ariance.qc_id ) AS Ariance, "
                +" COUNT ( peelOff.qc_id ) AS PeelOff, "
                +" COUNT ( sockliner.qc_id ) AS Sockliner, "
                +" COUNT ( docDate.qc_id ) AS DocDate, "
                +" COUNT ( others.qc_id ) AS Others, "
                +" COUNT ( defect.qc_id ) AS Defect, "
                +" COUNT ( output.qc_id ) AS output "
        +" FROM "
                +" jdcadp_txnqctrl "
                +" a LEFT JOIN jdcadp_mstproduksi b ON a.product_code = b.jo_ppic "
                +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Over cement' ) overcement ON a.qc_id = overcement.qc_id "
                +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Stain Upper' ) stainUpper ON a.qc_id = stainUpper.qc_id "
                +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Stain Gauge Marking' ) stainGaugeMarking ON a.qc_id = stainGaugeMarking.qc_id "
                +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Stain Outsole' ) stainOutsole ON a.qc_id = stainOutsole.qc_id "
                +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Stain Lace' ) stainLace ON a.qc_id = stainLace.qc_id "
                +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Over buffing' ) overbuff ON a.qc_id = overbuff.qc_id "
                +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'X-ray' ) xRay ON a.qc_id = xRay.qc_id "
                +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Over color o/s' ) overColor ON a.qc_id = overColor.qc_id "
                +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Wrinkle upper' ) wrinkleUpper ON a.qc_id = wrinkleUpper.qc_id "
                +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Painting' ) painting ON a.qc_id = painting.qc_id "
                +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Crooked' ) crooked ON a.qc_id = crooked.qc_id  "
                +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Dif Toe/ Heel' ) difToeHeel ON a.qc_id = difToeHeel.qc_id  "
                +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Line Up' ) lineUp ON a.qc_id = lineUp.qc_id  "
                +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Collar /Tongue shape' ) collarTongueShape ON a.qc_id = collarTongueShape.qc_id  "
                +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Bond gap O/s to U/p' ) bondGapOsUp ON a.qc_id = bondGapOsUp.qc_id  "
                +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Bond gap O/s to M/s' ) bondGapOsMs ON a.qc_id = bondGapOsMs.qc_id  "
                +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Broken stitching' ) brokenStitching ON a.qc_id = brokenStitching.qc_id  "
                +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Ariance' ) ariance ON a.qc_id = ariance.qc_id  "
                +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Peel off' ) peelOff ON a.qc_id = peelOff.qc_id "
                +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Sockliner' ) sockliner ON a.qc_id = sockliner.qc_id  "
                +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Doc Date' ) docDate ON a.qc_id = docDate.qc_id  "
                +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl a WHERE a.defect = 'Others' ) others ON a.qc_id = others.qc_id "
                +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl WHERE jdcadp_txnqctrl.\"type\" != 'A-Grade' ) defect ON A.qc_id = defect.qc_id "
                +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl ) output on a.qc_id = output.qc_id "
                +" LEFT JOIN jdcuam_mstuser c on c.usr_id = a.created_by "
                +" WHERE ");        
        
        
        sql.append("a.line_code = :NCVS ");
        bindparams.put("NCVS",ncvs);
        
        Date startVal = DateUtil.stringToDate(startDate);
        sql.append("AND DATE(a.created_date) >= :StartDate ");
        bindparams.put("StartDate", startVal);
        
        Date endVal = DateUtil.stringToDate(endDate);
        sql.append("AND DATE(a.created_date) <=  :EndDate ");
        bindparams.put("EndDate", endVal);
        
        sql.append("AND UPPER(c.usr_type) = UPPER(:Supervisor)");
        bindparams.put("Supervisor", supervisor);
        
        sql.append( " GROUP BY c.usr_type, a.created_date, a.product_code, b.product_desc ");
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
            retVal.setDate((Date) obj[1]);
            retVal.setProduct_desc((String) obj[2]);
            retVal.setProduct_code((String) obj[3]);
            retVal.setOver_cement(((BigInteger) obj[4]).longValue());
            retVal.setStain_upper(((BigInteger) obj[5]).longValue());
            retVal.setStain_gauge_mk(((BigInteger) obj[6]).longValue());
            retVal.setStain_outsole(((BigInteger) obj[7]).longValue());
            retVal.setStain_lace(((BigInteger) obj[8]).longValue());
            retVal.setOver_buff(((BigInteger) obj[9]).longValue());
            retVal.setX_ray(((BigInteger) obj[10]).longValue());
            retVal.setOver_color(((BigInteger) obj[11]).longValue());
            retVal.setWrinkle_up(((BigInteger) obj[12]).longValue());
            retVal.setPainting(((BigInteger) obj[13]).longValue());
            retVal.setCrooked(((BigInteger) obj[14]).longValue());
            retVal.setDiff_toe(((BigInteger) obj[15]).longValue());
            retVal.setLine_up(((BigInteger) obj[16]).longValue());
            retVal.setCol_tongue_sp(((BigInteger) obj[17]).longValue());
            retVal.setBond_gap_os_up(((BigInteger) obj[18]).longValue());
            retVal.setBond_gap_os_ms(((BigInteger) obj[19]).longValue());
            retVal.setBroken_st(((BigInteger) obj[20]).longValue());
            retVal.setAriance(((BigInteger) obj[21]).longValue());
            retVal.setPeel_off(((BigInteger) obj[22]).longValue());
            retVal.setSock_liner(((BigInteger) obj[23]).longValue());
            retVal.setDoc_date(((BigInteger) obj[24]).longValue());
            retVal.setOthers(((BigInteger) obj[25]).longValue());
            long defect = ((BigInteger) obj[26]).longValue();
            retVal.setDefect(defect);
            long output = ((BigInteger) obj[27]).longValue();
            retVal.setOutput(output);            
            retVal.setPercentage( (((Number) defect).floatValue() / ((Number) output).floatValue())*100f );
            data.add(retVal);
        }

        return data;
    }

    @Override
    public List<AdpDailyDefectQCSewingReportModel> getDataReportSewing(HashMap<String, Object> searchMap) {
        AdpDailyDefectQCSewingReportModel retVal;
        List<AdpDailyDefectQCSewingReportModel> data = new ArrayList<AdpDailyDefectQCSewingReportModel>();
        
        String ncvs = (String) searchMap.get("ncvs");
        String supervisor = (String) searchMap.get("supervisor");
        String startDate = (String) searchMap.get("startDate");
        String endDate = (String) searchMap.get("endDate");
        
        bindparams = new HashMap<>();
        
        StringBuilder sql = new StringBuilder(
                "SELECT "
               +" c.usr_type, "
               +" A.created_date, "
               +" b.product_desc, "
               +" A.product_code, "
               +" COUNT ( looseStitching.qc_id ) AS LooseStitching, "
               +" COUNT ( poorTrim.qc_id ) AS PoorTrim, "
               +" COUNT ( stainUpper.qc_id ) AS StainUpper, "
               +" COUNT ( stainGaugeMark.qc_id ) AS StainGaugeMark, "
               +" COUNT ( crooked.qc_id ) AS Crooked, "
               +" COUNT ( lineUp.qc_id ) AS lineUp, "
               +" COUNT ( stitchMargin.qc_id ) AS stitchMargin, "
               +" COUNT ( tongueShape.qc_id ) AS tongueShape, "
               +" COUNT ( wrinkle.qc_id ) AS wrinkle, "
               +" COUNT ( brokenStitch.qc_id ) AS brokenStitch, "
               +" COUNT ( joinTongue.qc_id ) AS joinTongue, "
               +" COUNT ( peelOff.qc_id ) AS peelOff, "
               +" COUNT ( materialFail.qc_id ) AS materialFail, "
               +" COUNT ( vampShape.qc_id ) AS vampShape, "
               +" COUNT ( collarBlackShape.qc_id ) AS collarBlackShape, "
               +" COUNT ( computerStitch.qc_id ) AS computerStitch, "
               +" COUNT ( diffColor.qc_id ) AS diffColor, "
               +" COUNT ( other.qc_id ) AS Other, "
               +" COUNT ( defect.qc_id ) AS Defect, "
               +" COUNT ( output.qc_id ) AS Output "
                        
        +"FROM "
               +" jdcadp_txnqctrl A LEFT JOIN jdcadp_mstproduksi b ON A.product_code = b.jo_ppic "
               +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Loose Stitching' ) looseStitching ON A.qc_id = looseStitching.qc_id "
               +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Poor Trimming Thread' ) poorTrim ON A.qc_id = poorTrim.qc_id "
               +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Stain Upper' ) stainUpper ON A.qc_id = stainUpper.qc_id "
               +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Stain Gauge Marking' ) stainGaugeMark ON A.qc_id = stainGaugeMark.qc_id "
               +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Crooked' ) crooked ON A.qc_id = crooked.qc_id "
               +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Line Up' ) lineUp ON A.qc_id = lineUp.qc_id "
               +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Stitch Margin' ) stitchMargin ON A.qc_id = stitchMargin.qc_id "
               +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Tongue Shape' ) tongueShape ON A.qc_id = tongueShape.qc_id "
               +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Wrinkle' ) wrinkle ON A.qc_id = wrinkle.qc_id "
               +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Broken Stitching' ) brokenStitch ON A.qc_id = brokenStitch.qc_id "
               +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Join Tongue' ) joinTongue ON A.qc_id = joinTongue.qc_id "
               +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Peel Off' ) peelOff ON A.qc_id = peelOff.qc_id "
               +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Material Failure' ) materialFail ON A.qc_id = materialFail.qc_id "
               +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Tip/Vamp Shape' ) vampShape ON A.qc_id = vampShape.qc_id "
               +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Collar/ Black Shape' ) collarBlackShape ON A.qc_id = collarBlackShape.qc_id "
               +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Computer Stitching (PLK)' ) computerStitch ON A.qc_id = computerStitch.qc_id "
               +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Different Color' ) diffColor ON A.qc_id = diffColor.qc_id "
               +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Other' ) other ON A.qc_id = other.qc_id "               
               +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl WHERE jdcadp_txnqctrl.\"type\" != 'A-Grade' ) defect ON A.qc_id = defect.qc_id "
               +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl ) output on a.qc_id = output.qc_id "
               +" LEFT JOIN jdcuam_mstuser c on c.usr_id = a.created_by "
               +" WHERE ");
        
        sql.append(" a.line_code = :NCVS ");
        bindparams.put("NCVS",ncvs);
        
        Date startVal = DateUtil.stringToDate(startDate);
        sql.append(" AND DATE(a.created_date) >= :StartDate ");
        bindparams.put("StartDate", startVal);
        
        Date endVal = DateUtil.stringToDate(endDate);
        sql.append(" AND DATE(a.created_date) <=  :EndDate ");
        bindparams.put("EndDate", endVal);
        
        sql.append(" AND UPPER(c.usr_type) = UPPER(:supervisor) ");
        bindparams.put("supervisor", supervisor);
        
        sql.append( " GROUP BY  c.usr_type, a.created_date, a.product_code, b.product_desc ");
        sql.append(" ORDER BY  a.created_date ");
        
        Query query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
        for (Map.Entry<String, Object> bindparam : bindparams.entrySet()) {
            query.setParameter(bindparam.getKey(), bindparam.getValue());
        }
       
        List queryResult = query.list();
        
        Object[] obj;
        for (Object object : queryResult) {
            obj = (Object[]) object;
            retVal = new AdpDailyDefectQCSewingReportModel();
            retVal.setDate((Date) obj[1]);
//            retVal.setDate(((Date) obj[1]).toString());
            retVal.setProduct_desc((String) obj[2]);
            retVal.setProduct_code((String) obj[3]);
            retVal.setLoose_st(((BigInteger) obj[4]).longValue());
            retVal.setPoor_trim_td(((BigInteger) obj[5]).longValue());
            retVal.setStain_up(((BigInteger) obj[6]).longValue());
            retVal.setStain_gauge_mk(((BigInteger) obj[7]).longValue());
            retVal.setCrooked(((BigInteger) obj[8]).longValue());
            retVal.setLine_up(((BigInteger) obj[9]).longValue());
            retVal.setSt_margin(((BigInteger) obj[10]).longValue());
            retVal.setTongue_sp(((BigInteger) obj[11]).longValue());
            retVal.setWrinkle(((BigInteger) obj[12]).longValue());
            retVal.setBroken_st(((BigInteger) obj[13]).longValue());
            retVal.setJoin_tongue(((BigInteger) obj[14]).longValue());
            retVal.setPeel_off(((BigInteger) obj[15]).longValue());
            retVal.setMaterial_fail(((BigInteger) obj[16]).longValue());
            retVal.setVamp_sp(((BigInteger) obj[17]).longValue());
            retVal.setCol_blacksp(((BigInteger) obj[18]).longValue());
            retVal.setComputer_st(((BigInteger) obj[19]).longValue());
            retVal.setDiff_color(((BigInteger) obj[20]).longValue());
            retVal.setOther(((BigInteger) obj[21]).longValue());
            long defect = ((BigInteger) obj[22]).longValue();
            retVal.setDefect(defect);
            long output = ((BigInteger) obj[23]).longValue();
            retVal.setOutput(output);
            retVal.setPercentage( (((Number) defect).floatValue() / ((Number) output).floatValue())*100f );
            data.add(retVal);
        }

        return data;
    }

    @Override
    public List<AdpDailyDefectQCPreparationReportModel> getDataReportPreparation(HashMap<String, Object> searchMap) {
       AdpDailyDefectQCPreparationReportModel retVal;
        List<AdpDailyDefectQCPreparationReportModel> data = new ArrayList<AdpDailyDefectQCPreparationReportModel>();
        
        String ncvs = (String) searchMap.get("ncvs");
        String supervisor = (String) searchMap.get("supervisor");
        String startDate = (String) searchMap.get("startDate");
        String endDate = (String) searchMap.get("endDate");
        
        bindparams = new HashMap<>();
        
        StringBuilder sql = new StringBuilder(
        "SELECT " 
            +" c.usr_type, "
            +" A.created_date, "
            +" b.product_desc, "
            +" A.product_code, "
            +" COUNT ( looseStitching.qc_id ) AS LooseStitching, "
            +" COUNT ( poorTrim.qc_id ) AS PoorTrim, "
            +" COUNT ( stainComponent.qc_id ) AS StainComponent, "
            +" COUNT ( stainGaugeMark.qc_id ) AS StainGaugeMark, "
            +" COUNT ( materialFail.qc_id ) AS MaterialFail, "
            +" COUNT ( diffColor.qc_id ) AS DiffColor, "
            +" COUNT ( computerStitching.qc_id ) AS ComputerStitching, "
            +" COUNT ( logoQuality.qc_id ) AS LogoQuality, "
            +" COUNT ( hairy.qc_id ) AS Hairy, "
            +" COUNT ( stitchMargin.qc_id ) AS StitchMargin, "
            +" COUNT ( crooked.qc_id ) AS Crooked, "
            +" COUNT ( lineUp.qc_id ) AS LineUp, "
            +" COUNT ( wrinkle.qc_id ) AS Wrinkle, "
            +" COUNT ( visibleLining.qc_id ) AS VisibleLining, "
            +" COUNT ( brokenStitch.qc_id ) AS BrokenStitch, "
            +" COUNT ( peelOff.qc_id ) AS PeelOff, "
            +" COUNT ( others.qc_id ) AS Others, "
            +" COUNT ( defect.qc_id ) AS Defect, "
            +" COUNT ( output.qc_id ) AS Output "
        +" FROM "
            +" jdcadp_txnqctrl A LEFT JOIN jdcadp_mstproduksi b ON A.product_code = b.jo_ppic "
            +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Loose Stitching' ) looseStitching ON A.qc_id = looseStitching.qc_id "
            +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Poor Trimming Thread' ) poorTrim ON A.qc_id = poorTrim.qc_id "
            +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Stain Component' ) stainComponent ON A.qc_id = stainComponent.qc_id "
            +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Stain Gauge Marking' ) stainGaugeMark ON A.qc_id = stainGaugeMark.qc_id "
            +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Material Failure' ) materialFail ON A.qc_id = materialFail.qc_id "
            +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Different Color' ) diffColor ON A.qc_id = diffColor.qc_id "
            +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Computer Stitching (PLK)' ) computerStitching ON A.qc_id = computerStitching.qc_id "
            +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Logo Quality' ) logoQuality ON A.qc_id = logoQuality.qc_id "
            +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Hairy' ) hairy ON A.qc_id = hairy.qc_id "
            +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Stitch Margin' ) stitchMargin ON A.qc_id = stitchMargin.qc_id "
            +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Crooked' ) crooked ON A.qc_id = crooked.qc_id "
            +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Line Up' ) lineUp ON A.qc_id = lineUp.qc_id "
            +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Wrinkle' ) wrinkle ON A.qc_id = wrinkle.qc_id "
            +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Visible Lining' ) visibleLining ON A.qc_id = visibleLining.qc_id "
            +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Broken Stitching' ) brokenStitch ON A.qc_id = brokenStitch.qc_id "
            +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Peel Off' ) peelOff ON A.qc_id = peelOff.qc_id "
            +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl A WHERE A.defect = 'Others' ) others ON A.qc_id = others.qc_id "
            +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl WHERE jdcadp_txnqctrl.\"type\" != 'A-Grade' ) defect ON A.qc_id = defect.qc_id "
            +" LEFT JOIN ( SELECT qc_id FROM jdcadp_txnqctrl ) output on a.qc_id = output.qc_id "
            +" LEFT JOIN jdcuam_mstuser c on c.usr_id = a.created_by "
            +" WHERE "); 
        
        sql.append(" a.line_code = :NCVS ");
        bindparams.put("NCVS",ncvs);
        
        Date startVal = DateUtil.stringToDate(startDate);
        sql.append(" AND DATE(a.created_date) >= :StartDate ");
        bindparams.put("StartDate", startVal);
        
        Date endVal = DateUtil.stringToDate(endDate);
        sql.append(" AND DATE(a.created_date) <=  :EndDate ");
        bindparams.put("EndDate", endVal);
        
        sql.append(" AND UPPER(c.usr_type) = UPPER(:supervisor) ");
        bindparams.put("supervisor", supervisor);
        
        sql.append( " GROUP BY  c.usr_type, a.created_date, a.product_code, b.product_desc ");
        sql.append(" ORDER BY  a.created_date ");
        
        Query query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
        for (Map.Entry<String, Object> bindparam : bindparams.entrySet()) {
            query.setParameter(bindparam.getKey(), bindparam.getValue());
        }
        List queryResult = query.list();
        
        Object[] obj;
        for (Object object : queryResult) {
            obj = (Object[]) object;            
            retVal = new AdpDailyDefectQCPreparationReportModel();
            retVal.setDate((Date) obj[1]);
            retVal.setProduct_desc((String) obj[2]);
            retVal.setProduct_code((String) obj[3]);
            retVal.setLoose_st(((BigInteger) obj[4]).longValue());
            retVal.setPoor_trim_td(((BigInteger) obj[5]).longValue());
            retVal.setStain_comp(((BigInteger) obj[6]).longValue());
            retVal.setStain_gauge_mk(((BigInteger) obj[7]).longValue());
            retVal.setMaterial_fail(((BigInteger) obj[8]).longValue());
            retVal.setDiff_color(((BigInteger) obj[9]).longValue());
            retVal.setComputer_st(((BigInteger) obj[10]).longValue());
            retVal.setLogo_quality(((BigInteger) obj[11]).longValue());
            retVal.setHairy(((BigInteger) obj[12]).longValue());
            retVal.setSt_margin(((BigInteger) obj[13]).longValue());
            retVal.setCrooked(((BigInteger) obj[14]).longValue());
            retVal.setLine_up(((BigInteger) obj[15]).longValue());
            retVal.setWrinkle(((BigInteger) obj[16]).longValue());
            retVal.setVisible_lining(((BigInteger) obj[17]).longValue());
            retVal.setBroken_st(((BigInteger) obj[18]).longValue());
            retVal.setPeel_off(((BigInteger) obj[19]).longValue());
            retVal.setOther(((BigInteger) obj[20]).longValue());
            long defect = ((BigInteger) obj[21]).longValue();
            retVal.setDefect(defect);
            long output = ((BigInteger) obj[22]).longValue();
            retVal.setOutput(output);            
            retVal.setPercentage( (((Number) defect).floatValue() / ((Number) output).floatValue())*100f );
            data.add(retVal);
        }

        return data;
    }
}
