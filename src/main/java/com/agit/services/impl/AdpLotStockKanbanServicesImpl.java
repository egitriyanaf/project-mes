package com.agit.services.impl;

import com.agit.entity.JdcAdpFndapprv;
import com.agit.entity.JdcAdpTxnLotapprv;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.services.AdpLotStockKanbanServices;
import com.agit.services.AdpParamConfigService;
import com.agit.util.StringUtils;
import com.project.common.DataTables;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ridwans
 */
@Service
@Transactional(readOnly = true)
public class AdpLotStockKanbanServicesImpl extends AdpSimpleServiceImpl<JdcAdpTxnLotapprv> implements AdpLotStockKanbanServices {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    AdpParamConfigService adpParamConfigService;

    /**
     *
     * @return
     */
    @Override
    public Class<JdcAdpTxnLotapprv> getRealClass() {
        return JdcAdpTxnLotapprv.class;
    }

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @Override
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap) {
        String lineCode = (String) searchMap.get("lineCode");
        String poItem = (String) searchMap.get("poItem");
        String poNo = (String) searchMap.get("poNo");
        Long userId = (Long) searchMap.get("userId");

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpTxnLotapprv.class);

        criteria.add(Restrictions.not(Restrictions.in("status", new Long[]{2l, 3l})));
        criteria.add(Restrictions.eq("assignTo", userId));
        if (StringUtils.isNotEmpty(lineCode)) {
            criteria.add(Restrictions.ilike("lineCode", lineCode, MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotEmpty(poItem)) {
            criteria.add(Restrictions.ilike("poItem", poItem, MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotEmpty(poNo)) {
            criteria.add(Restrictions.ilike("poNo", poNo, MatchMode.ANYWHERE));
        }
        return getDataTablesFromCriteria(criteria, dataTables);
    }

    /**
     *
     * @return
     */
    @Override
    public List<JdcAdpTxnLotapprv> findByStatus() {
        Long status = 0L;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpTxnLotapprv.class);
        criteria.add(Restrictions.eq("status", status));
        return criteria.list();
    }

    /**
     *
     * @param txn
     * @param findUser
     */
    @Override
    @Transactional
    public void save(JdcAdpTxnLotapprv txn, JdcAdpMstUser findUser) {
        JdcAdpTxnLotapprv data = null;

        data = new JdcAdpTxnLotapprv();
        data.setCreateBy(findUser.getId());
        data.setCreateDate(new Date(System.currentTimeMillis()));
        data.setStatus(0L);
        data.setAssignTo(txn.getAssignTo());
        data.setPersentase(txn.getPersentase());
        data.setHourly(txn.getHourly());
        data.setLineCode(txn.getLineCode());
        data.setPoNo(txn.getPoNo());
        data.setPoItem(txn.getPoItem());
        data.setRemark(txn.getRemark());
        data.setSize1(txn.getSize1());
        data.setSize1T(txn.getSize1T());
        data.setSize2(txn.getSize2());
        data.setSize2T(txn.getSize2T());
        data.setSize3(txn.getSize3());
        data.setSize4(txn.getSize4());
        data.setSize4T(txn.getSize4T());
        data.setSize5(txn.getSize5());
        data.setSize5T(txn.getSize5T());
        data.setSize6(txn.getSize6());
        data.setSize6T(txn.getSize6T());
        data.setSize7(txn.getSize7());
        data.setSize7T(txn.getSize7T());
        data.setSize8(txn.getSize8());
        data.setSize8T(txn.getSize8T());
        data.setSize9(txn.getSize9());
        data.setSize9T(txn.getSize9T());
        data.setSize10(txn.getSize10());
        data.setSize10T(txn.getSize10T());
        data.setSize11(txn.getSize11());
        data.setSize11T(txn.getSize11T());
        data.setSize12(txn.getSize12T());
        data.setSize12T(txn.getSize12T());
        data.setSize13(txn.getSize13());
        data.setSize13T(txn.getSize13T());
        data.setSize14(txn.getSize14());
        data.setSize15(txn.getSize15());
        data.setSize16(txn.getSize16());
        data.setSize17(txn.getSize17());
        data.setSize18(txn.getSize18());
        saveOrUpdate(data);
        txn.setId(data.getId());
    }

    /**
     *
     * @param persentase
     * @return
     */
    @Override
    public JdcAdpFndapprv getApprovalBypers(Long persentase) {
        String type = "";
        if (persentase <= 10) {
            type = "approval 1";
        } else {
            type = "approval 2";
        }
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpFndapprv.class);
        criteria.add(Restrictions.eq("type", type));
        return (JdcAdpFndapprv) criteria.uniqueResult();

    }

    /**
     *
     * @param approve
     * @param loginSecUser
     */
    @Override
    @Transactional
    public void saveUpdate(JdcAdpTxnLotapprv approve, JdcAdpMstUser loginSecUser) {
        JdcAdpTxnLotapprv data = null;
        if (approve.getId() != null) {
            data = findById(approve.getId());
            data.setUpdateBy(loginSecUser.getId());
            data.setUpdateDate(new Date());
        } else {
            data = new JdcAdpTxnLotapprv();
            data.setCreateBy(loginSecUser.getId());
            data.setCreateDate(new Date());
        }
        data.setApprove1(approve.getApprove1());
        data.setApprove2(approve.getApprove2());
        data.setAssignTo(approve.getAssignTo());
        data.setStatus(approve.getStatus());
        saveOrUpdate(data);
        approve.setId(data.getId());
    }

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @Override
    public DataTables searchByMapCriteriaLotKanban(DataTables dataTables, HashMap<String, Object> searchMap) {
        String lineCode = (String) searchMap.get("lineCode");
        String poItem = (String) searchMap.get("poItem");
        String poNo = (String) searchMap.get("poNo");

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpTxnLotapprv.class);
        
        criteria.add(Restrictions.in("status", new Long[]{2l}));
        if (StringUtils.isNotEmpty(lineCode)) {
            criteria.add(Restrictions.ilike("lineCode", lineCode, MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotEmpty(poItem)) {
            criteria.add(Restrictions.ilike("poItem", poItem, MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotEmpty(poNo)) {
            criteria.add(Restrictions.ilike("poNo", poNo, MatchMode.ANYWHERE));
        }
        return getDataTablesFromCriteria(criteria, dataTables);
    }

}
