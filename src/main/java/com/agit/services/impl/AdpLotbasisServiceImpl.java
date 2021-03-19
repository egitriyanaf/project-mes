package com.agit.services.impl;

import java.util.Date;
import java.util.HashMap;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.common.DataTables;
import com.agit.controller.operator.model.AdpLotOperatorModel;
import com.agit.controller.production.model.AdpLotbasisDetailModel;
import com.agit.controller.production.model.AdpLotbasisModel;
import com.agit.entity.JdcAdpTxnlotbasis;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.services.AdpLotbasisService;

/**
 *
 * @author erwin
 */
@Service
@Transactional(readOnly = true)
public class AdpLotbasisServiceImpl extends AdpSimpleServiceImpl<JdcAdpTxnlotbasis> implements AdpLotbasisService {

    @Autowired
    SessionFactory sessionFactory;

    /**
     *
     * @return
     */
    @Override
    public Class<JdcAdpTxnlotbasis> getRealClass() {
        return JdcAdpTxnlotbasis.class;
    }

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @Override
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap) {
        String ncvs = (String) searchMap.get("ncvs");
        String poItem = (String) searchMap.get("poItem");
        String poNo = (String) searchMap.get("poNo");
        String demandClass = (String) searchMap.get("demandClass");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpTxnlotbasis.class);
        criteria.add(Restrictions.eq("lineCode", ncvs));
        criteria.add(Restrictions.eq("poItem", poItem));
        criteria.add(Restrictions.eq("poNo", poNo));
        criteria.add(Restrictions.eq("demandClass", demandClass));
        criteria.addOrder(Order.asc("hourly"));

        return getDataTablesFromCriteria(criteria, dataTables);
    }

    /**
     *
     * @param list
     * @param findUser
     */
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void save(JdcAdpTxnlotbasis list, JdcAdpMstUser findUser) {
        saveOrUpdate(list);
    }

    /**
     *
     * @param list
     * @param findUser
     */
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveLot(AdpLotbasisModel list, JdcAdpMstUser findUser) {
        for (AdpLotbasisDetailModel data : list.getLines()) {
            JdcAdpTxnlotbasis val = null;
            if (data.getId() != null) {
                val = findById(data.getId());
                val.setUpdateBy(findUser.getId());
                val.setUpdateDate(new Date(System.currentTimeMillis()));
            } else {
                val = new JdcAdpTxnlotbasis();
                val.setCreateBy(findUser.getId());
                val.setCreateDate(new Date(System.currentTimeMillis()));
            }
            val.setHourly(data.getHourly());
            val.setSize1(data.getSize1());
            val.setSize1T(data.getSize1T());
            val.setSize2(data.getSize2());
            val.setSize2T(data.getSize2T());
            val.setSize3(data.getSize3());
            val.setSize4(data.getSize4());
            val.setSize4T(data.getSize4T());
            val.setSize5(data.getSize5());
            val.setSize5T(data.getSize5T());
            val.setSize6(data.getSize6());
            val.setSize6T(data.getSize6T());
            val.setSize7(data.getSize7());
            val.setSize7T(data.getSize7T());
            val.setSize8(data.getSize8());
            val.setSize8T(data.getSize8T());
            val.setSize9(data.getSize9());
            val.setSize9T(data.getSize9T());
            val.setSize10(data.getSize10());
            val.setSize10T(data.getSize10T());
            val.setSize11(data.getSize11());
            val.setSize11T(data.getSize11T());
            val.setSize12(data.getSize12());
            val.setSize12T(data.getSize12T());
            val.setSize13(data.getSize13());
            val.setSize13T(data.getSize13T());
            val.setSize14(data.getSize14());
            val.setSize15(data.getSize15());
            val.setSize16(data.getSize16());
            val.setSize17(data.getSize17());
            val.setSize18(data.getSize18());

            saveOrUpdate(val);
            data.setId(data.getId());
        }
    }
    
    /**
     *
     * @param data
     * @param findUser
     */
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveApproveKanban(JdcAdpTxnlotbasis data, JdcAdpMstUser findUser) {

            JdcAdpTxnlotbasis val = null;
            if (data.getId() != null) {
                val = findById(data.getId());
                val.setUpdateBy(findUser.getId());
                val.setUpdateDate(new Date(System.currentTimeMillis()));
            } else {
                val = new JdcAdpTxnlotbasis();
                val.setCreateBy(findUser.getId());
                val.setCreateDate(new Date(System.currentTimeMillis()));
            }
            val.setHourly(data.getHourly());
            val.setSize1(data.getSize1());
            val.setSize1T(data.getSize1T());
            val.setSize2(data.getSize2());
            val.setSize2T(data.getSize2T());
            val.setSize3(data.getSize3());
            val.setSize4(data.getSize4());
            val.setSize4T(data.getSize4T());
            val.setSize5(data.getSize5());
            val.setSize5T(data.getSize5T());
            val.setSize6(data.getSize6());
            val.setSize6T(data.getSize6T());
            val.setSize7(data.getSize7());
            val.setSize7T(data.getSize7T());
            val.setSize8(data.getSize8());
            val.setSize8T(data.getSize8T());
            val.setSize9(data.getSize9());
            val.setSize9T(data.getSize9T());
            val.setSize10(data.getSize10());
            val.setSize10T(data.getSize10T());
            val.setSize11(data.getSize11());
            val.setSize11T(data.getSize11T());
            val.setSize12(data.getSize12T());
            val.setSize12T(data.getSize12T());
            val.setSize13(data.getSize13());
            val.setSize13T(data.getSize13T());
            val.setSize14(data.getSize14());
            val.setSize15(data.getSize15());
            val.setSize16(data.getSize16());
            val.setSize17(data.getSize17());
            val.setSize18(data.getSize18());

            saveOrUpdate(val);
            data.setId(data.getId());
    }

}
