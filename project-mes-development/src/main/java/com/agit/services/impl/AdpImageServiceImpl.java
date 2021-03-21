package com.agit.services.impl;

import com.agit.controller.maintenance.model.AdpProduksiAdressModel;
import com.agit.controller.maintenance.model.AdpProduksiSearchModel;
import com.agit.entity.JdcAdpMstimages;
import com.agit.entity.JdcAdpMstproduksi;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.services.AdpImageService;
import com.project.common.DataTables;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
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

/**
 *
 * @author TriAA
 */
@Service
@Transactional(readOnly = true)
public class AdpImageServiceImpl extends AdpSimpleServiceImpl<JdcAdpMstimages> implements AdpImageService {

    @Autowired
    SessionFactory sessionFactory;

    /**
     *
     * @return
     */
    @Override
    public Class<JdcAdpMstimages> getRealClass() {
        return JdcAdpMstimages.class;
    }

    private Map<String, Object> bindparams;

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @Override
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap) {
        String imagesName = (String) searchMap.get("nameImage");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstimages.class);
        if (StringUtils.isNotBlank(imagesName)) {
            criteria.add(buildResctrictionsAndForAllProperty(new String[]{
                "id",
                "imageName"}, com.agit.util.StringUtils.splitBySpace(imagesName)));
        }
        return getDataTablesFromCriteria(criteria, dataTables);
    }

    /**
     *
     * @param images
     * @param userLogin
     */
    @SuppressWarnings("unused")
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveMstImages(JdcAdpMstimages images, JdcAdpMstUser userLogin) {
        JdcAdpMstimages image = null;
        saveOrUpdate(images);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public JdcAdpMstimages findByCode(String id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstimages.class);
        criteria.add(Restrictions.eq("id", id));
        return (JdcAdpMstimages) criteria.uniqueResult();
    }

    /**
     *
     * @param searchMap
     * @return
     */
    @Override
    public List<AdpProduksiSearchModel> searchProduct(Map<String, Object> searchMap) {
        String joppic = (String) searchMap.get("joppic");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstproduksi.class);
        criteria.add(Restrictions.isNotNull("joPpic"));
        if (StringUtils.isNotBlank(joppic)) {
            criteria.add(Restrictions.ilike("joPpic", joppic, MatchMode.ANYWHERE));
        }
        criteria.setMaxResults(10);
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("joPpic"), "joppic")
                .add(Projections.property("productDesc"), "productDesc")
                .add(Projections.groupProperty("joPpic"))
                .add(Projections.groupProperty("productDesc"))).setResultTransformer(Transformers.aliasToBean(AdpProduksiSearchModel.class));
        return criteria.list();
    }

    /**
     *
     * @param searchMap
     * @return
     */
    @Override
    public List<AdpProduksiAdressModel> searchAddress(Map<String, Object> searchMap) {
        String addressLine = (String) searchMap.get("addressLine");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstproduksi.class);
        criteria.add(Restrictions.isNotNull("addressLine"));
        if (StringUtils.isNotBlank(addressLine)) {
            criteria.add(Restrictions.ilike("addressLine", addressLine, MatchMode.ANYWHERE));
        }
        criteria.setMaxResults(10);
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("addressLine"), "address")
                .add(Projections.property("city"), "city")
                .add(Projections.groupProperty("addressLine"))
                .add(Projections.groupProperty("city"))).setResultTransformer(Transformers.aliasToBean(AdpProduksiAdressModel.class));
        return criteria.list();
    }

}
