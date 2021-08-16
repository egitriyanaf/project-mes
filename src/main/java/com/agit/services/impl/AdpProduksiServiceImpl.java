package com.agit.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.common.DataTables;
import com.agit.controller.production.model.AdpLotbasisModel;
import com.agit.controller.qc.model.AdpProduksiModel;
import com.agit.dao.AdpProduksiDao;
import com.agit.entity.JdcAdpMstproduksi;
import com.agit.entity.JdcAdpTxnlotbasis;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.services.AdpProduksiService;
import org.hibernate.criterion.Order;

/**
 *
 * @author erwin
 */
@Service
@Transactional(readOnly = true)
public class AdpProduksiServiceImpl extends AdpSimpleServiceImpl<JdcAdpMstproduksi> implements AdpProduksiService {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    AdpProduksiDao adpProduksiDao;

    /**
     *
     * @return
     */
    @Override
    public Class<JdcAdpMstproduksi> getRealClass() {
        return JdcAdpMstproduksi.class;
    }

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @Override
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap) {
        Long total = adpProduksiDao.getCountProduksi(searchMap);
        List<AdpProduksiModel> data = adpProduksiDao.getDataProduksi(dataTables, searchMap);
        return dataTables.extract(data, total);
    }

    /**
     *
     * @param ncvs
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<JdcAdpMstproduksi> findBynCVS(String ncvs) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstproduksi.class);
        if (StringUtils.isNotBlank(ncvs)) {
            criteria.add(Restrictions.ilike("lineCode", ncvs, MatchMode.ANYWHERE));
        }

        criteria.setProjection(Projections.projectionList().add(Projections.property("lineCode"), "lineCode")
                .add(Projections.groupProperty("lineCode")))
                .setResultTransformer(Transformers.aliasToBean(JdcAdpMstproduksi.class));
        List<JdcAdpMstproduksi> result = criteria.list();
        return result;
    }

    /**
     *
     * @param searchMap
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<JdcAdpMstproduksi> findProductByPO(Map<String, Object> searchMap) {//edit erwin
        String poItem = (String) searchMap.get("term"); 
        String poNo = (String) searchMap.get("poNo");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstproduksi.class);
        if (StringUtils.isNotBlank(poNo)) {
            criteria.add(Restrictions.eq("poNo", poNo));
        }
        if (StringUtils.isNotBlank(poItem)) {
            criteria.add(Restrictions.ilike("poItem", poItem, MatchMode.ANYWHERE));
        }
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("poNo"), "poNo")
                .add(Projections.property("poItem"), "poItem")
                .add(Projections.groupProperty("poNo"))
                .add(Projections.groupProperty("poItem")))
                .setResultTransformer(Transformers.aliasToBean(JdcAdpMstproduksi.class));
        List<JdcAdpMstproduksi> result = criteria.list();
        return result;
    }

    /**
     *
     * @param searchMap
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<JdcAdpMstproduksi> findByLineCode(Map<String, Object> searchMap) {
        String term = (String) searchMap.get("term");
        String demand = (String) searchMap.get("demand");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstproduksi.class);
        if (StringUtils.isNotBlank(term)) {
            criteria.add(Restrictions.ilike("lineCode", term, MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotBlank(demand)) {
            criteria.add(Restrictions.ilike("demandClass", demand, MatchMode.ANYWHERE));
        }
        criteria.setMaxResults(5);
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("lineCode"), "lineCode")
                .add(Projections.groupProperty("lineCode")))
                .setResultTransformer(Transformers.aliasToBean(JdcAdpMstproduksi.class));
        List<JdcAdpMstproduksi> result = criteria.list();
        return result;
    }
    
    /**
     *
     * @param searchMap
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<JdcAdpMstproduksi> findByLineCodeNew(Map<String, Object> searchMap) {//modify erwin 21/06/23
        String term = (String) searchMap.get("term");
        String poItem = (String) searchMap.get("poItem");
        String poNo = (String) searchMap.get("poNo");
        String demand = (String) searchMap.get("demand");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstproduksi.class);
        if (StringUtils.isNotBlank(poNo)) {
            criteria.add(Restrictions.eq("poNo", poNo));
        }
        if (StringUtils.isNotBlank(poItem)) {
            criteria.add(Restrictions.eq("poItem", poItem));
        }
         if (StringUtils.isNotBlank(demand)) {
            criteria.add(Restrictions.eq("demandClass", demand));
        }
        if (StringUtils.isNotBlank(term)) {
            criteria.add(Restrictions.ilike("lineCode", term, MatchMode.ANYWHERE));
        }
     
        criteria.setMaxResults(5);
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("lineCode"), "lineCode")
                .add(Projections.property("poNo"), "poNo")
                .add(Projections.property("poItem"), "poItem")
                .add(Projections.property("demandClass"), "demandClass")
                .add(Projections.groupProperty("poNo"))
                .add(Projections.groupProperty("poItem"))
                .add(Projections.groupProperty("demandClass"))
                .add(Projections.groupProperty("lineCode")))
                .setResultTransformer(Transformers.aliasToBean(JdcAdpMstproduksi.class));
        List<JdcAdpMstproduksi> result = criteria.list();
        return result;
    }
    
    /**
     *
     * @param searchMap
     * @return
     */
    @Override
    public List<JdcAdpMstproduksi> findByDemandClass(Map<String, Object> searchMap) {//modify by erwin
        String demandClass = (String) searchMap.get("term");
        String poNo = (String) searchMap.get("poNo");
        String poItem = (String) searchMap.get("poItem");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstproduksi.class);
        if (StringUtils.isNotBlank(poNo)) {
            criteria.add(Restrictions.eq("poNo", poNo));
        }
        if (StringUtils.isNotBlank(poItem)) {
            criteria.add(Restrictions.eq("poItem", poItem));
        }
        if (StringUtils.isNotBlank(demandClass)) {
            criteria.add(Restrictions.ilike("demandClass", demandClass, MatchMode.ANYWHERE));
        }
        criteria.setMaxResults(5);
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("demandClass"), "demandClass")
                .add(Projections.property("poNo"), "poNo")
                .add(Projections.property("poItem"), "poItem")
                .add(Projections.groupProperty("poNo"))
                .add(Projections.groupProperty("poItem"))
                .add(Projections.groupProperty("demandClass")))
                .setResultTransformer(Transformers.aliasToBean(JdcAdpMstproduksi.class));
        List<JdcAdpMstproduksi> result = criteria.list();
        return result;
    }
    
    /**
     *
     * @param searchMap
     * @return
     */
    @Override
    public List<JdcAdpMstproduksi> findByDemandClassNew(Map<String, Object> searchMap) {
        String demandClass = (String) searchMap.get("term");
        String ncvs = (String) searchMap.get("ncvs");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstproduksi.class);
        if (StringUtils.isNotBlank(demandClass)) {
            criteria.add(Restrictions.ilike("demandClass", demandClass, MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotBlank(ncvs)) {
            criteria.add(Restrictions.eq("lineCode", ncvs));
        }
        criteria.setMaxResults(5);
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("demandClass"), "demandClass")
                .add(Projections.groupProperty("demandClass")))
                .setResultTransformer(Transformers.aliasToBean(JdcAdpMstproduksi.class));
        List<JdcAdpMstproduksi> result = criteria.list();
        return result;
    }

    /**
     *
     * @param searchMap
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<JdcAdpMstproduksi> findPoItemByNcvs(Map<String, Object> searchMap) {
        String ncvs = (String) searchMap.get("ncvs");
        String poItem = (String) searchMap.get("poItem");
        String poNo = (String) searchMap.get("poNo");
        String term = (String) searchMap.get("term");

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstproduksi.class);
        if (StringUtils.isNotBlank(term)) {
            criteria.add(Restrictions.ilike("poItem", term, MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotBlank(ncvs)) {
            criteria.add(Restrictions.eq("lineCode", ncvs));
        }
        if (StringUtils.isNotBlank(poItem)) {
            criteria.add(Restrictions.ilike("poItem", ncvs, MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotBlank(poNo)) {
            criteria.add(Restrictions.ilike("poNo", poNo, MatchMode.ANYWHERE));
        }
        criteria.setMaxResults(5);
        criteria.setProjection(Projections.projectionList().add(Projections.property("lineCode"), "lineCode")
                .add(Projections.property("poItem"), "poItem").add(Projections.groupProperty("lineCode"))
                .add(Projections.groupProperty("poItem")))
                .setResultTransformer(Transformers.aliasToBean(JdcAdpMstproduksi.class));
        List<JdcAdpMstproduksi> result = criteria.list();
        return result;
    }
    
    /**
     *
     * @param searchMap
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<JdcAdpMstproduksi> findPoItemByNcvsNew(Map<String, Object> searchMap) {
        String ncvs = (String) searchMap.get("ncvs");        
        String poNo = (String) searchMap.get("poNo");
        String demand = (String) searchMap.get("demand");
        String term = (String) searchMap.get("term"); 

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstproduksi.class);
        if (StringUtils.isNotBlank(term)) {
            criteria.add(Restrictions.ilike("poItem", term, MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotBlank(ncvs)) {
            criteria.add(Restrictions.eq("lineCode", ncvs));
        }
      
        if (StringUtils.isNotBlank(poNo)) {
            criteria.add(Restrictions.eq("poNo", poNo));
        }
        if (StringUtils.isNotBlank(demand)) {
            criteria.add(Restrictions.eq("demandClass", demand));
        }
        criteria.setMaxResults(5);
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("lineCode"), "lineCode")
                .add(Projections.property("poItem"), "poItem")
                .add(Projections.property("poNo"), "poNo")
                .add(Projections.property("demandClass"), "demandClass")
                .add(Projections.groupProperty("lineCode"))
                .add(Projections.groupProperty("poItem"))
                .add(Projections.groupProperty("demandClass"))
                .add(Projections.groupProperty("poNo")))
                .setResultTransformer(Transformers.aliasToBean(JdcAdpMstproduksi.class));
        List<JdcAdpMstproduksi> result = criteria.list();
        return result;
    }

    /**
     *
     * @param searchMap
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<JdcAdpMstproduksi> findPoNoByNcvs(Map<String, Object> searchMap) {
        String ncvs = (String) searchMap.get("ncvs");
        String poItem = (String) searchMap.get("poItem");
        String poNo = (String) searchMap.get("poNo");
        String term = (String) searchMap.get("term");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstproduksi.class);
        if (StringUtils.isNotBlank(term)) {
            criteria.add(Restrictions.ilike("poNo", term, MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotBlank(ncvs)) {
            criteria.add(Restrictions.eq("lineCode", ncvs));
        }
        if (StringUtils.isNotBlank(poItem)) {
            criteria.add(Restrictions.eq("poItem", poItem));
        }
        if (StringUtils.isNotBlank(poNo)) {
            criteria.add(Restrictions.ilike("poNo", poNo, MatchMode.ANYWHERE));
        }
        criteria.setMaxResults(5);
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("lineCode"), "lineCode")
                .add(Projections.property("poItem"), "poItem")
                .add(Projections.property("poNo"), "poNo")
                .add(Projections.groupProperty("lineCode"))
                .add(Projections.groupProperty("poItem"))
                .add(Projections.groupProperty("poNo")))
                .setResultTransformer(Transformers.aliasToBean(JdcAdpMstproduksi.class));
        List<JdcAdpMstproduksi> result = criteria.list();
        return result;
    }
    
    /**
     *
     * @param searchMap
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<JdcAdpMstproduksi> findPoNoOk(Map<String, Object> searchMap) {
        String ncvs = (String) searchMap.get("ncvs");
        String poNo = (String) searchMap.get("poNo");
        String demand = (String) searchMap.get("demand");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstproduksi.class);
        if (StringUtils.isNotBlank(demand)) {
            criteria.add(Restrictions.eq("demandClass", demand));
        }
        if (StringUtils.isNotBlank(poNo)) {
            criteria.add(Restrictions.ilike("poNo", poNo, MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotBlank(ncvs)) {
            criteria.add(Restrictions.eq("lineCode", ncvs));
        }
        criteria.setMaxResults(5);
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("lineCode"), "lineCode")
                .add(Projections.property("demandClass"), "demandClass")
                .add(Projections.property("poNo"), "poNo")
                .add(Projections.groupProperty("lineCode"))
                .add(Projections.groupProperty("demandClass"))
                .add(Projections.groupProperty("poNo")))
                .setResultTransformer(Transformers.aliasToBean(JdcAdpMstproduksi.class));
        List<JdcAdpMstproduksi> result = criteria.list();
        return result;
    }
    
    /**
     *
     * @param searchMap
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<JdcAdpMstproduksi> findPoNoFrst(Map<String, Object> searchMap) {//add by erwin
//        String poNo = (String) searchMap.get("poNo");
        String poNo = (String) searchMap.get("term"); 
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstproduksi.class);
        if (StringUtils.isNotBlank(poNo)) {
            criteria.add(Restrictions.ilike("poNo", poNo, MatchMode.ANYWHERE));
        }
//        criteria.add(Restrictions.between("created_date", "date('2020-03-18')", "date('2021-03-18')"));
        criteria.addOrder(Order.desc("createDate") );
        criteria.setMaxResults(5);
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("poNo"), "poNo")
                .add(Projections.property("createDate"), "createDate")
                .add(Projections.groupProperty("createDate"))
                .add(Projections.groupProperty("poNo")))
                .setResultTransformer(Transformers.aliasToBean(JdcAdpMstproduksi.class));
        List<JdcAdpMstproduksi> result = criteria.list();
        return result;
    }

    /**
     *
     * @param searchMap
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<AdpProduksiModel> retrieveData(Map<String, Object> searchMap) {
        String ncvs = (String) searchMap.get("ncvs");
        String poItem = (String) searchMap.get("poItem");
        String poNo = (String) searchMap.get("poNo");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstproduksi.class);
        if (StringUtils.isNotBlank(ncvs)) {
            criteria.add(Restrictions.eq("lineCode", ncvs));
        }
        if (StringUtils.isNotBlank(poItem)) {
            criteria.add(Restrictions.eq("poItem", poItem));
        }
        if (StringUtils.isNotBlank(poNo)) {
            criteria.add(Restrictions.ilike("poNo", poNo, MatchMode.ANYWHERE));
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
                .add(Projections.property("logRemark"), "remark")
                .add(Projections.sum("qty"), "qty")
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
                .add(Projections.groupProperty("logRemark"))
                .add(Projections.groupProperty("poNo")))
                .setResultTransformer(Transformers.aliasToBean(AdpProduksiModel.class));
        List<AdpProduksiModel> result = criteria.list();
        return result;
    }

    /**
     *
     * @param model
     * @param loginSecUser
     */
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void save(AdpProduksiModel model, JdcAdpMstUser loginSecUser) {
        List<AdpProduksiModel> data = getDataById(model.getLineCode(), model.getPoNo(), model.getPoItem());
        for (AdpProduksiModel list : data) {
            JdcAdpMstproduksi retVal = null;
            if (list.getId() != null) {
                retVal = findById(list.getId());
                retVal.setLogSave(1l);
                retVal.setLogRemark(model.getRemark());
                saveOrUpdate(retVal);
                model.setId(retVal.getId());
            }
        }
    }

    @SuppressWarnings("unchecked")
    private List<AdpProduksiModel> getDataById(String lineCode, String poNo, String poItem) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstproduksi.class);
        criteria.add(Restrictions.eq("lineCode", lineCode));
        criteria.add(Restrictions.eq("poNo", poNo));
        criteria.add(Restrictions.eq("poItem", poItem));
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("id"), "id")
                .add(Projections.property("lineCode"), "lineCode")
                .add(Projections.property("poNo"), "poNo")
                .add(Projections.property("poItem"), "poItem")
                .add(Projections.groupProperty("id"))
                .add(Projections.groupProperty("lineCode"))
                .add(Projections.groupProperty("poNo"))
                .add(Projections.groupProperty("poItem")))
                .setResultTransformer(Transformers.aliasToBean(AdpProduksiModel.class));
        List<AdpProduksiModel> result = criteria.list();
        return result;
    }

    @SuppressWarnings("unchecked")
    private List<AdpLotbasisModel> getDataByLot(String lineCode, String poNo, String poItem, String demandClass) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstproduksi.class);
        if (StringUtils.isNotEmpty(lineCode)) {
            criteria.add(Restrictions.eq("lineCode", lineCode));
        }
        if (StringUtils.isNotEmpty(poNo)) {
            criteria.add(Restrictions.eq("poNo", poNo));
        }
        if (StringUtils.isNotEmpty(poItem)) {
            criteria.add(Restrictions.eq("poItem", poItem));
        }
        if (StringUtils.isNotEmpty(demandClass)) {
            criteria.add(Restrictions.eq("demandClass", demandClass));
        }
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("id"), "id")
                .add(Projections.property("lineCode"), "lineCode")
                .add(Projections.property("poNo"), "poNo")
                .add(Projections.property("poItem"), "poItem")
                .add(Projections.property("demandClass"), "demandClass")
                .add(Projections.groupProperty("id"))
                .add(Projections.groupProperty("lineCode"))
                .add(Projections.groupProperty("poNo"))
                .add(Projections.groupProperty("poItem"))
                .add(Projections.groupProperty("demandClass")))
                .setResultTransformer(Transformers.aliasToBean(AdpLotbasisModel.class));
        List<AdpLotbasisModel> result = criteria.list();
        return result;
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
        List<AdpProduksiModel> data = getDataById(model.getLineCode(), model.getPoNo(), model.getPoItem());
        for (AdpProduksiModel list : data) {
            JdcAdpMstproduksi retVal = null;
            if (list.getId() != null) {
                retVal = findById(list.getId());
                retVal.setLogSubmit(1l);
                retVal.setLogRemark(model.getRemark());
                saveOrUpdate(retVal);
                model.setId(retVal.getId());
            }
        }

    }

    /**
     *
     * @param ncvs
     * @param po
     * @param item
     * @param demandclass
     * @return
     */
    @Override
    public AdpProduksiModel findByLotBasis(String ncvs, String po, String item, String demandclass) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstproduksi.class);
        if (StringUtils.isNotBlank(ncvs)) {
            criteria.add(Restrictions.eq("lineCode", ncvs));
        }
        if (StringUtils.isNotBlank(item)) {
            criteria.add(Restrictions.eq("poItem", item));
        }
        if (StringUtils.isNotBlank(po)) {
            criteria.add(Restrictions.eq("poNo", po));
        }
        if (StringUtils.isNotBlank(demandclass)) {
            criteria.add(Restrictions.eq("demandClass", demandclass));
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
                .add(Projections.groupProperty("poNo"))
                .add(Projections.groupProperty("demandClass")))
                .setResultTransformer(Transformers.aliasToBean(AdpProduksiModel.class));
        return (AdpProduksiModel) criteria.uniqueResult();
    }

    /**
     *
     * @param model
     * @param loginSecUser
     */
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveLotBasis(AdpLotbasisModel model, JdcAdpMstUser loginSecUser) {
        List<AdpLotbasisModel> data = getDataByLot(model.getLineCode(), model.getPoNo(), model.getPoItem(), model.getDemandClass());
        for (AdpLotbasisModel list : data) {
            JdcAdpMstproduksi retVal = null;
            if (list.getId() != null) {
                retVal = findById(list.getId());
                retVal.setFlagUpload(1l);
                retVal.setJobOrder(model.getJobOrder());
                retVal.setJoStartDate(model.getJobStart());
                retVal.setJoEndDate(model.getJobStop());
                retVal.setProjectAlias(model.getAlias());
                retVal.setLabelIns(model.getLabelIns());
                saveOrUpdate(retVal);
                model.setId(retVal.getId());
            }
        }

    }

    /**
     *
     * @param ncvs
     * @param po
     * @param item
     * @param hourly
     * @return
     */
    @Override
    public JdcAdpTxnlotbasis findByToKanban(String ncvs, String po, String item, Long hourly) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpTxnlotbasis.class);
        criteria.add(Restrictions.eq("lineCode", ncvs));
        criteria.add(Restrictions.eq("poNo", po));
        criteria.add(Restrictions.eq("poItem", item));
        criteria.add(Restrictions.eq("hourly", hourly));
        return (JdcAdpTxnlotbasis) criteria.uniqueResult();
    }

    /**
     *
     * @param model
     * @param loginSecUser
     */
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveRemark(AdpProduksiModel model, JdcAdpMstUser loginSecUser) {
        List<AdpLotbasisModel> data = getDataByLot(model.getLineCode(), model.getPoNo(), model.getPoItem(), model.getDemandClass());
        for (AdpLotbasisModel list : data) {
            JdcAdpMstproduksi retVal = null;
            if (list.getId() != null) {
                retVal = findById(list.getId());
                retVal.setLogRemark(model.getRemark());
                saveOrUpdate(retVal);
                model.setId(retVal.getId());
            }
        }
    }

    /**
     *
     * @return
     */
    @Override
    public List<JdcAdpMstproduksi> getAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstproduksi.class);
        return criteria.list();
    }

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @Override
    public DataTables searchByMapCriteriaProduct(DataTables dataTables, HashMap<String, Object> searchMap) {
        Long total = adpProduksiDao.getAllCountProduksi(searchMap);
        List<AdpProduksiModel> data = adpProduksiDao.getAllDataProduksi(dataTables, searchMap);
        return dataTables.extract(data, total);
    }

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @Override
    public DataTables searchByMapCriteriaDiamondMark(DataTables dataTables, HashMap<String, Object> searchMap) {
        Long total = adpProduksiDao.getAllCountDiamondMark(searchMap);
        List<AdpProduksiModel> data = adpProduksiDao.getAllDataDiamondMark(dataTables, searchMap);
        return dataTables.extract(data, total);
    }

    /**
     *
     * @param searchMap
     * @return
     */
    @Override
    public List<JdcAdpMstproduksi> findProductNoProductDesc(Map<String, Object> searchMap) {
        String ncvs = (String) searchMap.get("ncvs");
        String poNo = (String) searchMap.get("poNo");
        String poItem = (String) searchMap.get("poItem");
        String demand = (String) searchMap.get("demand");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstproduksi.class);
        if (StringUtils.isNotBlank(ncvs)) {
            criteria.add(Restrictions.eq("lineCode", ncvs));
        }
        if (StringUtils.isNotBlank(poNo)) {
            criteria.add(Restrictions.eq("poNo", poNo));
        }
        if (StringUtils.isNotBlank(poItem)) {
            criteria.add(Restrictions.eq("poItem", poItem));
        }
        if (StringUtils.isNotBlank(demand)) {
            criteria.add(Restrictions.eq("demandClass", demand));
        }

        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("lineCode"), "lineCode")
                .add(Projections.property("poNo"), "poNo")
                .add(Projections.property("poItem"), "poItem")
                .add(Projections.property("joPpic"), "joPpic")
                .add(Projections.groupProperty("lineCode"))
                .add(Projections.groupProperty("poNo"))
                .add(Projections.groupProperty("poItem"))
                .add(Projections.groupProperty("joPpic")))
                .setResultTransformer(Transformers.aliasToBean(JdcAdpMstproduksi.class));
        List<JdcAdpMstproduksi> result = criteria.list();
        return result;
    }

}
