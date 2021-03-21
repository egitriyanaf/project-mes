package com.agit.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.agit.entity.JdcAdpMstproduksi;
import com.project.common.DataTables;
import com.agit.controller.qc.model.AdpProduksiModel;
import com.agit.dao.AdpGenericDao;
import com.agit.dao.AdpProduksiDao;

/**
 *
 * @author Ridwan
 */
@Repository
public class AdpProduksiDaoImpl extends AdpBaseDao<JdcAdpMstproduksi> implements AdpProduksiDao {

    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    AdpGenericDao genericDao;

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<AdpProduksiModel> getDataProduksi(DataTables dataTables, HashMap<String, Object> searchMap) {
        Long flagUpload = (Long) searchMap.get("flagUpload");
        String ncvs = (String) searchMap.get("ncvs");
        String poItem = (String) searchMap.get("poItem");
        String poNo = (String) searchMap.get("poNo");
        String demandClass = (String) searchMap.get("demandClass");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstproduksi.class);
        if (StringUtils.isNotBlank(ncvs)) {
            criteria.add(Restrictions.ilike("lineCode", ncvs, MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotBlank(poItem)) {
            criteria.add(Restrictions.ilike("poItem", poItem, MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotBlank(poNo)) {
            criteria.add(Restrictions.ilike("poNo", poNo, MatchMode.ANYWHERE));
        }
         if (StringUtils.isNotBlank(demandClass)) {
            criteria.add(Restrictions.ilike("demandClass", demandClass, MatchMode.ANYWHERE));
        }
        if (flagUpload != null) {
            criteria.add(Restrictions.eq("flagUpload", flagUpload));
        }
        criteria.setFirstResult(dataTables.getiDisplayStart());
        criteria.setMaxResults(dataTables.getiDisplayLength());
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("gacDate"), "gacDate")
                .add(Projections.property("igacDate"), "igacDate")
                .add(Projections.property("ogacDate"), "ogacDate")
                .add(Projections.property("rgacDate"), "rgacDate")
                .add(Projections.property("schStartdate"), "schStartdate")
                .add(Projections.property("address1"), "address1")
                .add(Projections.property("addressLine"), "addressLine")
                .add(Projections.property("city"), "city")
                .add(Projections.property("fgDesc"), "fgDesc")
                .add(Projections.property("joPpic"), "joPpic")
                .add(Projections.property("lineCode"), "lineCode")
                .add(Projections.property("poItem"), "poItem")
                .add(Projections.property("poNo"), "poNo")
                .add(Projections.property("logSave"), "logSave")
                .add(Projections.property("logSubmit"), "logSubmit")
                .add(Projections.property("flagUpload"), "flagUpload")
                .add(Projections.property("jobOrder"), "jobOrder")
                .add(Projections.property("joStartDate"), "joStartDate")
                .add(Projections.property("joEndDate"), "joEndDate")
                .add(Projections.property("projectAlias"), "projectAlias")
                .add(Projections.property("labelIns"), "labelIns")
                .add(Projections.property("demandClass"), "demandClass")
                .add(Projections.sum("qty"), "qty")
                .add(Projections.groupProperty("demandClass"))
                .add(Projections.groupProperty("gacDate"))
                .add(Projections.groupProperty("igacDate"))
                .add(Projections.groupProperty("ogacDate"))
                .add(Projections.groupProperty("rgacDate"))
                .add(Projections.groupProperty("schStartdate"))
                .add(Projections.groupProperty("address1"))
                .add(Projections.groupProperty("addressLine"))
                .add(Projections.groupProperty("city"))
                .add(Projections.groupProperty("fgDesc"))
                .add(Projections.groupProperty("joPpic"))
                .add(Projections.groupProperty("lineCode"))
                .add(Projections.groupProperty("poItem"))
                .add(Projections.groupProperty("logSave"))
                .add(Projections.groupProperty("logSubmit"))
                .add(Projections.groupProperty("flagUpload"))
                .add(Projections.groupProperty("jobOrder"))
                .add(Projections.groupProperty("joStartDate"))
                .add(Projections.groupProperty("joEndDate"))
                .add(Projections.groupProperty("projectAlias"))
                .add(Projections.groupProperty("labelIns"))
                .add(Projections.groupProperty("poNo")))
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
    public Long getCountProduksi(HashMap<String, Object> searchMap) {
        Long flagUpload = (Long) searchMap.get("flagUpload");
        String ncvs = (String) searchMap.get("ncvs");
        String poItem = (String) searchMap.get("poItem");
        String poNo = (String) searchMap.get("poNo");
        String demandClass = (String) searchMap.get("demandClass");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstproduksi.class);
        if (StringUtils.isNotBlank(ncvs)) {
            criteria.add(Restrictions.ilike("lineCode", ncvs, MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotBlank(poItem)) {
            criteria.add(Restrictions.ilike("poItem", poItem, MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotBlank(poNo)) {
            criteria.add(Restrictions.ilike("poNo", poNo, MatchMode.ANYWHERE));
        }
         if (StringUtils.isNotBlank(demandClass)) {
            criteria.add(Restrictions.ilike("demandClass", demandClass, MatchMode.ANYWHERE));
        }
        if (flagUpload != null) {
            criteria.add(Restrictions.eq("flagUpload", flagUpload));
        }

        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("gacDate"), "gacDate")
                .add(Projections.property("igacDate"), "igacDate")
                .add(Projections.property("ogacDate"), "ogacDate")
                .add(Projections.property("rgacDate"), "rgacDate")
                .add(Projections.property("schStartdate"), "schStartdate")
                .add(Projections.property("address1"), "address1")
                .add(Projections.property("addressLine"), "addressLine")
                .add(Projections.property("city"), "city")
                .add(Projections.property("productDesc"), "productDesc")
                .add(Projections.property("fgDesc"), "fgDesc")
                .add(Projections.property("joPpic"), "joPpic")
                .add(Projections.property("lineCode"), "lineCode")
                .add(Projections.property("poItem"), "poItem")
                .add(Projections.property("poNo"), "poNo")
                .add(Projections.property("logSave"), "logSave")
                .add(Projections.property("logSubmit"), "logSubmit")
                .add(Projections.property("flagUpload"), "flagUpload")
                .add(Projections.property("jobOrder"), "jobOrder")
                .add(Projections.property("joStartDate"), "joStartDate")
                .add(Projections.property("joEndDate"), "joEndDate")
                .add(Projections.property("projectAlias"), "projectAlias")
                .add(Projections.property("labelIns"), "labelIns")
                .add(Projections.property("demandClass"), "demandClass")
                .add(Projections.sum("qty"), "qty")
                .add(Projections.groupProperty("demandClass"))
                .add(Projections.groupProperty("gacDate"))
                .add(Projections.groupProperty("igacDate"))
                .add(Projections.groupProperty("ogacDate"))
                .add(Projections.groupProperty("rgacDate"))
                .add(Projections.groupProperty("schStartdate"))
                .add(Projections.groupProperty("address1"))
                .add(Projections.groupProperty("addressLine"))
                .add(Projections.groupProperty("city"))
                .add(Projections.groupProperty("productDesc"))
                .add(Projections.groupProperty("fgDesc"))
                .add(Projections.groupProperty("joPpic"))
                .add(Projections.groupProperty("lineCode"))
                .add(Projections.groupProperty("poItem"))
                .add(Projections.groupProperty("logSave"))
                .add(Projections.groupProperty("logSubmit"))
                .add(Projections.groupProperty("flagUpload"))
                .add(Projections.groupProperty("jobOrder"))
                .add(Projections.groupProperty("joStartDate"))
                .add(Projections.groupProperty("joEndDate"))
                .add(Projections.groupProperty("projectAlias"))
                .add(Projections.groupProperty("labelIns"))
                .add(Projections.groupProperty("poNo")))
                .setResultTransformer(Transformers.aliasToBean(AdpProduksiModel.class));
        List<AdpProduksiModel> result = criteria.list();
        return (long) result.size();
    }

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @Override
    public List<AdpProduksiModel> getAllDataProduksi(DataTables dataTables, HashMap<String, Object> searchMap) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstproduksi.class);
        String name = (String) searchMap.get("name");
        if (StringUtils.isNotBlank(name)) {
            criteria.add(buildResctrictionsAndForAllProperty(new String[]{
                                            "joPpic",
                                            "productDesc"}, com.agit.util.StringUtils.splitBySpace(name)));
        }
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("productDesc"), "productDesc")
                .add(Projections.property("joPpic"), "joPpic")
                .add(Projections.groupProperty("productDesc"))
                .add(Projections.groupProperty("joPpic")))
                .setResultTransformer(Transformers.aliasToBean(AdpProduksiModel.class));
        List<AdpProduksiModel> result = criteria.list();
        return result;
    }

    /**
     *
     * @param searchMap
     * @return
     */
    @Override
    public Long getAllCountProduksi(HashMap<String, Object> searchMap) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstproduksi.class);
        String name = (String) searchMap.get("name");
        if (StringUtils.isNotBlank(name)) {
            criteria.add(buildResctrictionsAndForAllProperty(new String[]{
                                            "productDesc",
                                            "joPpic"}, com.agit.util.StringUtils.splitBySpace(name)));
        }
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("productDesc"), "productDesc")
                .add(Projections.property("joPpic"), "joPpic")
                .add(Projections.groupProperty("productDesc"))
                .add(Projections.groupProperty("joPpic")))
                .setResultTransformer(Transformers.aliasToBean(AdpProduksiModel.class));
        List<AdpProduksiModel> result = criteria.list();
         return (long) result.size();
    }

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @Override
    public List<AdpProduksiModel> getAllDataDiamondMark(DataTables dataTables, HashMap<String, Object> searchMap) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstproduksi.class);
        String name = (String) searchMap.get("name");
        criteria.add(Restrictions.isNotNull("addressLine"));
        if (StringUtils.isNotBlank(name)) {
            criteria.add(buildResctrictionsAndForAllProperty(new String[]{
                                            "city",
                                            "addressLine"}, com.agit.util.StringUtils.splitBySpace(name)));
        }
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("city"), "city")
                .add(Projections.property("addressLine"), "addressLine")
                .add(Projections.groupProperty("addressLine"))
                .add(Projections.groupProperty("city")))
                .setResultTransformer(Transformers.aliasToBean(AdpProduksiModel.class));
        List<AdpProduksiModel> result = criteria.list();
        return result;
    }

    /**
     *
     * @param searchMap
     * @return
     */
    @Override
    public Long getAllCountDiamondMark(HashMap<String, Object> searchMap) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstproduksi.class);
        String name = (String) searchMap.get("name");
        criteria.add(Restrictions.isNotNull("addressLine"));
        if (StringUtils.isNotBlank(name)) {
            criteria.add(buildResctrictionsAndForAllProperty(new String[]{
                                            "city",
                                            "addressLine"}, com.agit.util.StringUtils.splitBySpace(name)));
        }
        
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("city"), "city")
                .add(Projections.property("addressLine"), "addressLine")
                .add(Projections.groupProperty("addressLine"))
                .add(Projections.groupProperty("city")))
                .setResultTransformer(Transformers.aliasToBean(AdpProduksiModel.class));
        List<AdpProduksiModel> result = criteria.list();
         return (long) result.size();
    }

}
