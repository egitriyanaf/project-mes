package com.agit.services.impl;

import com.agit.entity.JdcAdpMstspk;
import com.agit.entity.JdcAdpTxnqcctrl;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.services.AdpWorkshopInspectionService;
import com.project.common.DataTables;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author TriAA
 */

@Service
@Transactional(readOnly = true)
public class AdpWorkshopInspectionServiceImpl extends AdpSimpleServiceImpl<JdcAdpTxnqcctrl> implements AdpWorkshopInspectionService {

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param model
     * @param user
     */
    @Modifying
    @Transactional
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
     * @param sampleReq
     * @return
     */
    @Override
    public List<JdcAdpMstspk> findBySpk(String sampleReq) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstspk.class);
        criteria.add(Restrictions.ilike("sampleReq", sampleReq, MatchMode.ANYWHERE));
        return (List<JdcAdpMstspk>) criteria.list();
    }

    /**
     *
     * @return
     */
    @Override
    public List<JdcAdpMstspk> findAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstspk.class);
        return (List<JdcAdpMstspk>) criteria.list();
    }

}
