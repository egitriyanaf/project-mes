package com.agit.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.agit.entity.JdcAdpMstspk;
import com.agit.util.DateUtil;
import com.project.common.DataTables;
import com.project.common.SortField;
import com.agit.controller.sample.model.AdpViewSpkModel;
import com.agit.dao.AdpGenericDao;
import com.agit.dao.AdpSpkDao;

/**
 *
 * @author Ridwan
 */
@Repository
public class AdpSpkDaoImpl extends AdpBaseDao<JdcAdpMstspk> implements AdpSpkDao {

    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    AdpGenericDao genericDao;
    private Map<String, Object> bindparams;

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @SuppressWarnings("rawtypes")
    @Override
    public List<AdpViewSpkModel> getDataSpk(DataTables dataTables, HashMap<String, Object> searchMap) {
        String startDate = (String) searchMap.get("startDate");
        String endDate = (String) searchMap.get("endDate");
        String etcStart = (String) searchMap.get("etcStart");
        String etcEnd = (String) searchMap.get("etcEnd");
        String season = (String) searchMap.get("season");
        String category = (String) searchMap.get("category");
        String sample = (String) searchMap.get("sample");
        String sampleReq = (String) searchMap.get("sampleReq");

        bindparams = new HashMap<>();
        List<AdpViewSpkModel> data = new ArrayList<AdpViewSpkModel>();
        StringBuilder sql = new StringBuilder("select  "
                + "     a.qty,  "
                + "    	a.season,  "
                + "    	a.category,  "
                + "    	a.size,  "
                + "    	a.sample_req,  "
                + "    	a.etc_date,  "
                + "    	a.start_date,  "
                + "    	a.product_code,  "
                + "    	a.model,  "
                + "    	ASSMBLYIN.qty AS assmblyIn,  "
                + "    	ASSMBLYOUT.qty AS assmblyOut,  "
                + "    	CUTTINGIN.qty AS cuttingIn,  "
                + "    	CUTTINGOUT.qty AS cuttingOut,  "
                + "    	SEWINGIN.qty AS sewingIn,  "
                + "    	SEWINGOUT.qty AS sewingOut, "
                + "		STOKFITIN.qty AS stokfitIn, "
                + "		STOKFITOUT.qty AS stokfitOut,	 "
                + "		a.type_sample	 "
                + "    from jdcadp_mstspk a  "
                + "    LEFT JOIN(  "
                + "    	SELECT  A.product_code,sum(A.qty) AS qty,A.sample_req FROM jdcadp_txnbcode A   "
                + "    	WHERE A.TYPE='In' and A.dpt_id = '18' "
                + "    	GROUP BY A .product_code,A .qty,A .sample_req "
                + "    )ASSMBLYIN ON a.sample_req = ASSMBLYIN.sample_req  "
                + "    LEFT JOIN(  "
                + "    	SELECT  A.product_code,sum(A.qty) AS qty,A.sample_req FROM jdcadp_txnbcode A    "
                + "    	WHERE A.TYPE='Out' and A.dpt_id = '18'  "
                + "    	GROUP BY A .product_code,A .qty,A .sample_req "
                + "    )ASSMBLYOUT ON a.sample_req = ASSMBLYOUT.sample_req  "
                + "    LEFT JOIN(  "
                + "    	SELECT  A.product_code,sum(A.qty) AS qty,A.sample_req FROM jdcadp_txnbcode A     "
                + "    	WHERE A.TYPE='In' and A.dpt_id = '20' "
                + "    	GROUP BY A .product_code,A .qty,A .sample_req "
                + "    )CUTTINGIN ON  a.sample_req = CUTTINGIN.sample_req  "
                + "    LEFT JOIN(  "
                + "    	SELECT  A.product_code,sum(A.qty) AS qty,A.sample_req FROM jdcadp_txnbcode A   "
                + "    	WHERE A.TYPE='Out' and A.dpt_id = '20' "
                + "    	GROUP BY A .product_code,A .qty,A .sample_req "
                + "    )CUTTINGOUT ON a.sample_req = CUTTINGOUT.sample_req  "
                + "    LEFT JOIN(  "
                + "    	SELECT  A.product_code,sum(A.qty) AS qty,A.sample_req FROM jdcadp_txnbcode A     "
                + "    	WHERE A.TYPE='In' and A.dpt_id = '19' "
                + "    	GROUP BY A .product_code,A .qty,A .sample_req "
                + "    )SEWINGIN ON  a.sample_req = SEWINGIN.sample_req  "
                + "    LEFT JOIN(  "
                + "    	SELECT  A.product_code,sum(A.qty) AS qty,A.sample_req FROM jdcadp_txnbcode A    "
                + "    	WHERE A.TYPE='Out' and A.dpt_id = '19'  "
                + "    	GROUP BY A .product_code,A .qty,A .sample_req "
                + "    )SEWINGOUT ON  a.sample_req = SEWINGOUT.sample_req  "
                + "     LEFT JOIN(  "
                + "    	SELECT  A.product_code,sum(A.qty) AS qty,A.sample_req FROM jdcadp_txnbcode A   "
                + "    	WHERE A.TYPE='In' and A.dpt_id = '23' "
                + "    	GROUP BY A .product_code,A .qty,A .sample_req "
                + "    )STOKFITIN ON  a.sample_req = STOKFITIN.sample_req 	 "
                + "    LEFT JOIN(  "
                + "    	SELECT  A.product_code,sum(A.qty) AS qty,A.sample_req FROM jdcadp_txnbcode A    "
                + "    	WHERE A.TYPE='Out' and A.dpt_id = '23'  "
                + "    	GROUP BY A .product_code,A .qty,A .sample_req "
                + "    )STOKFITOUT ON a.sample_req = STOKFITOUT.sample_req ");
        sql.append("WHERE 1=1 ");
        if (StringUtils.isNotBlank(startDate)) {
            Date value = DateUtil.stringToDate(startDate);
            sql.append("AND DATE(a.start_date) >= :STARTDATE ");
            bindparams.put("STARTDATE", value);
        }

        if (StringUtils.isNotBlank(endDate)) {
            Date value = DateUtil.stringToDate(endDate);
            sql.append("AND DATE(a.start_date) <= :ENDDATE ");
            bindparams.put("ENDDATE", value);
        }

        if (StringUtils.isNotBlank(etcStart)) {
            Date value = DateUtil.stringToDate(etcStart);
            sql.append("AND DATE(a.etc_date) >= :ETCSTART ");
            bindparams.put("ETCSTART", value);
        }

        if (StringUtils.isNotBlank(etcEnd)) {
            Date value = DateUtil.stringToDate(etcEnd);
            sql.append("AND DATE(a.etc_date) <= :ETCEND ");
            bindparams.put("ETCEND", value);
        }
        if (StringUtils.isNotBlank(season)) {
            sql.append("AND upper(a.season) LIKE upper(:bindseason) ");
            bindparams.put("bindseason", "%" + season + "%");

        }
        if (StringUtils.isNotBlank(sample)) {
            sql.append("AND upper(a.type_sample) LIKE upper(:bindsample) ");
            bindparams.put("bindsample", "%" + sample + "%");
        }
        if (StringUtils.isNotBlank(category)) {
            sql.append("AND upper(a.category) LIKE upper(:bindcategory)");
            bindparams.put("bindcategory", "%" + category + "%");
        }

        if (StringUtils.isNotBlank(sampleReq)) {
            sql.append("AND upper(a.sample_req) LIKE upper(:bindsamplereq)");
            bindparams.put("bindsamplereq", "%" + sampleReq + "%");
        }

        sql.append("GROUP BY   "
                + " a.qty, "
                + "	a.season,  "
                + "	a.category,  "
                + "	a.\"size\",  "
                + "	a.sample_req,  "
                + "	a.etc_date,  "
                + "	a.start_date,  "
                + "	a.product_code,  "
                + "	a.model,  "
                + "	ASSMBLYIN.qty,  "
                + "	ASSMBLYOUT.qty,  "
                + "	CUTTINGIN.qty,  "
                + "	CUTTINGOUT.qty,  "
                + "	SEWINGIN.qty,  "
                + "	SEWINGOUT.qty,  "
                + "	STOKFITIN.qty,  "
                + "	STOKFITOUT.qty, "
                + "	a.type_sample ");

        List<SortField> sortFields = dataTables.generateSortFields();
        if (sortFields.isEmpty()) {
            sql.append("ORDER BY a.start_date DESC");
        } else {
            for (SortField sf : sortFields) {
                if ("asc".equalsIgnoreCase(sf.getDirection())) {
                    sql.append("ORDER BY ").append(sf.getField()).append(" ");
                    sql.append("ASC");
                } else {
                    sql.append("ORDER BY ").append(sf.getField()).append(" ");
                    sql.append("DESC");
                }
            }
        }

        Query query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
        for (Map.Entry<String, Object> bindparam : bindparams.entrySet()) {
            query.setParameter(bindparam.getKey(), bindparam.getValue());
        }
        query.setFirstResult(dataTables.getiDisplayStart());
        query.setMaxResults(dataTables.getiDisplayLength());
        List queryResult = query.list();
        AdpViewSpkModel retVal;
        Object[] obj;
        for (Object object : queryResult) {
            obj = (Object[]) object;
            retVal = new AdpViewSpkModel();
            retVal.setQty((Double) obj[0]);
            retVal.setSeason((String) obj[1]);
            retVal.setCategory((String) obj[2]);
            retVal.setSize((String) obj[3]);
            retVal.setSample_req((String) obj[4]);
            retVal.setEtc_date((Date) obj[5]);
            retVal.setStart_date((Date) obj[6]);
            retVal.setProduct_code((String) obj[7]);
            retVal.setModel((String) obj[8]);
            retVal.setAssmblyIn((Double) obj[9]);
            retVal.setAssmblyOut((Double) obj[10]);
            retVal.setCuttingIn((Double) obj[11]);
            retVal.setCuttingOut((Double) obj[12]);
            retVal.setSewingIn((Double) obj[13]);
            retVal.setSewingOut((Double) obj[14]);
            retVal.setStokfitIn((Double) obj[15]);
            retVal.setStokfitOut((Double) obj[16]);
            retVal.setType_sample((String) obj[17]);
            data.add(retVal);
        }

        return data;

    }

    /**
     *
     * @param searchMap
     * @return
     */
    @SuppressWarnings("unused")
    @Override
    public Long getCountSpk(HashMap<String, Object> searchMap) {
        String startDate = (String) searchMap.get("startDate");
        String endDate = (String) searchMap.get("endDate");
        String etcStart = (String) searchMap.get("etcStart");
        String etcEnd = (String) searchMap.get("etcEnd");
        String season = (String) searchMap.get("season");
        String category = (String) searchMap.get("category");
        String sample = (String) searchMap.get("sample");
        String sampleReq = (String) searchMap.get("sampleReq");

        bindparams = new HashMap<>();
        List<AdpViewSpkModel> data = new ArrayList<AdpViewSpkModel>();
        StringBuilder sql = new StringBuilder("select  "
                + "     a.qty,  "
                + "    	a.season,  "
                + "    	a.category,  "
                + "    	a.size,  "
                + "    	a.sample_req,  "
                + "    	a.etc_date,  "
                + "    	a.start_date,  "
                + "    	a.product_code,  "
                + "    	a.model,  "
                + "    	ASSMBLYIN.qty AS assmblyIn,  "
                + "    	ASSMBLYOUT.qty AS assmblyOut,  "
                + "    	CUTTINGIN.qty AS cuttingIn,  "
                + "    	CUTTINGOUT.qty AS cuttingOut,  "
                + "    	SEWINGIN.qty AS sewingIn,  "
                + "    	SEWINGOUT.qty AS sewingOut, "
                + "		STOKFITIN.qty AS stokfitIn, "
                + "		STOKFITOUT.qty AS stokfitOut,	 "
                + "		a.type_sample	 "
                + "    from jdcadp_mstspk a  "
                + "    LEFT JOIN(  "
                + "    	SELECT  A.product_code,sum(A.qty) AS qty,A.sample_req FROM jdcadp_txnbcode A   "
                + "    	WHERE A.TYPE='In' and A.dpt_id = '18' "
                + "    	GROUP BY A .product_code,A .qty,A .sample_req "
                + "    )ASSMBLYIN ON a.sample_req = ASSMBLYIN.sample_req  "
                + "    LEFT JOIN(  "
                + "    	SELECT  A.product_code,sum(A.qty) AS qty,A.sample_req FROM jdcadp_txnbcode A    "
                + "    	WHERE A.TYPE='Out' and A.dpt_id = '18'  "
                + "    	GROUP BY A .product_code,A .qty,A .sample_req "
                + "    )ASSMBLYOUT ON a.sample_req = ASSMBLYOUT.sample_req  "
                + "    LEFT JOIN(  "
                + "    	SELECT  A.product_code,sum(A.qty) AS qty,A.sample_req FROM jdcadp_txnbcode A     "
                + "    	WHERE A.TYPE='In' and A.dpt_id = '20' "
                + "    	GROUP BY A .product_code,A .qty,A .sample_req "
                + "    )CUTTINGIN ON  a.sample_req = CUTTINGIN.sample_req  "
                + "    LEFT JOIN(  "
                + "    	SELECT  A.product_code,sum(A.qty) AS qty,A.sample_req FROM jdcadp_txnbcode A   "
                + "    	WHERE A.TYPE='Out' and A.dpt_id = '20' "
                + "    	GROUP BY A .product_code,A .qty,A .sample_req "
                + "    )CUTTINGOUT ON a.sample_req = CUTTINGOUT.sample_req  "
                + "    LEFT JOIN(  "
                + "    	SELECT  A.product_code,sum(A.qty) AS qty,A.sample_req FROM jdcadp_txnbcode A     "
                + "    	WHERE A.TYPE='In' and A.dpt_id = '19' "
                + "    	GROUP BY A .product_code,A .qty,A .sample_req "
                + "    )SEWINGIN ON  a.sample_req = SEWINGIN.sample_req  "
                + "    LEFT JOIN(  "
                + "    	SELECT  A.product_code,sum(A.qty) AS qty,A.sample_req FROM jdcadp_txnbcode A    "
                + "    	WHERE A.TYPE='Out' and A.dpt_id = '19'  "
                + "    	GROUP BY A .product_code,A .qty,A .sample_req "
                + "    )SEWINGOUT ON  a.sample_req = SEWINGOUT.sample_req  "
                + "     LEFT JOIN(  "
                + "    	SELECT  A.product_code,sum(A.qty) AS qty,A.sample_req FROM jdcadp_txnbcode A   "
                + "    	WHERE A.TYPE='In' and A.dpt_id = '23' "
                + "    	GROUP BY A .product_code,A .qty,A .sample_req "
                + "    )STOKFITIN ON  a.sample_req = STOKFITIN.sample_req 	 "
                + "    LEFT JOIN(  "
                + "    	SELECT  A.product_code,sum(A.qty) AS qty,A.sample_req FROM jdcadp_txnbcode A    "
                + "    	WHERE A.TYPE='Out' and A.dpt_id = '23'  "
                + "    	GROUP BY A .product_code,A .qty,A .sample_req "
                + "    )STOKFITOUT ON a.sample_req = STOKFITOUT.sample_req ");
        sql.append("WHERE 1=1 ");
        if (StringUtils.isNotBlank(startDate)) {
            Date value = DateUtil.stringToDate(startDate);
            sql.append("AND DATE(a.start_date) >= :STARTDATE ");
            bindparams.put("STARTDATE", value);
        }

        if (StringUtils.isNotBlank(endDate)) {
            Date value = DateUtil.stringToDate(endDate);
            sql.append("AND DATE(a.start_date) <= :ENDDATE ");
            bindparams.put("ENDDATE", value);
        }

        if (StringUtils.isNotBlank(etcStart)) {
            Date value = DateUtil.stringToDate(etcStart);
            sql.append("AND DATE(a.etc_date) >= :ETCSTART ");
            bindparams.put("ETCSTART", value);
        }

        if (StringUtils.isNotBlank(etcEnd)) {
            Date value = DateUtil.stringToDate(etcEnd);
            sql.append("AND DATE(a.etc_date) <= :ETCEND ");
            bindparams.put("ETCEND", value);
        }
        if (StringUtils.isNotBlank(season)) {
            sql.append("AND upper(a.season) LIKE upper(:bindseason) ");
            bindparams.put("bindseason", "%" + season + "%");

        }
        if (StringUtils.isNotBlank(sample)) {
            sql.append("AND upper(a.type_sample) LIKE upper(:bindsample) ");
            bindparams.put("bindsample", "%" + sample + "%");
        }
        if (StringUtils.isNotBlank(category)) {
            sql.append("AND upper(a.category) LIKE upper(:bindcategory)");
            bindparams.put("bindcategory", "%" + category + "%");
        }
        if (StringUtils.isNotBlank(sampleReq)) {
            sql.append("AND upper(a.sample_req) LIKE upper(:bindsamplereq)");
            bindparams.put("bindsamplereq", "%" + sampleReq + "%");
        }

        sql.append("GROUP BY   "
                + " a.qty, "
                + "	a.season,  "
                + "	a.category,  "
                + "	a.\"size\",  "
                + "	a.sample_req,  "
                + "	a.etc_date,  "
                + "	a.start_date,  "
                + "	a.product_code,  "
                + "	a.model,  "
                + "	ASSMBLYIN.qty,  "
                + "	ASSMBLYOUT.qty,  "
                + "	CUTTINGIN.qty,  "
                + "	CUTTINGOUT.qty,  "
                + "	SEWINGIN.qty,  "
                + "	SEWINGOUT.qty,  "
                + "	STOKFITIN.qty,  "
                + "	STOKFITOUT.qty, "
                + "	a.type_sample ");

        Query query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
        for (Map.Entry<String, Object> bindparam : bindparams.entrySet()) {
            query.setParameter(bindparam.getKey(), bindparam.getValue());
        }

        return (long) query.list().size();
    }

}
