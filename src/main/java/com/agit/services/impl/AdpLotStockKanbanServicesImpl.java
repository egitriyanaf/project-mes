package com.agit.services.impl;

import com.agit.controller.operator.model.AdpExpressKanbanModel;
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
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
    
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void approveIn(AdpExpressKanbanModel model, JdcAdpMstUser loginSecUser) {
        JdcAdpTxnLotapprv val = null;

        if (model.getId() != null) {
            val = findById(model.getId());
            val.setUpdateBy(loginSecUser.getId());
            val.setUpdateDate(new Date(System.currentTimeMillis()));

            if (model.getSize1() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize1(1l);
                }
            }
            if (model.getSize2() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize2(1l);
                }
            }

            if (model.getSize3() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize3(1l);
                }
            }

            if (model.getSize4() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize4(1l);
                }
            }

            if (model.getSize5() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize5(1l);
                }
            }

            if (model.getSize6() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize6(1l);
                }
            }

            if (model.getSize7() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize7(1l);
                }
            }

            if (model.getSize8() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize8(1l);
                }
            }

            if (model.getSize9() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize9(1l);
                }
            }

            if (model.getSize10() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize10(1l);
                }
            }

            if (model.getSize11() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize11(1l);
                }
            }

            if (model.getSize12() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize12(1l);
                }
            }

            if (model.getSize13() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize13(1l);
                }
            }

            if (model.getSize14() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize14(1l);
                }
            }

            if (model.getSize15() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize15(1l);
                }
            }

            if (model.getSize16() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize16(1l);
                }
            }

            if (model.getSize17() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize17(1l);
                }
            }

            if (model.getSize18() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize18(1l);
                }
            }

            if (model.getSize1T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize1T(1l);
                }
            }

            if (model.getSize2T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize2T(1l);
                }
            }

            if (model.getSize3T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize3T(1l);
                }
            }

            if (model.getSize4T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize4T(1l);
                }
            }

            if (model.getSize5T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize5T(1l);
                }
            }

            if (model.getSize6T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize6T(1l);
                }
            }

            if (model.getSize7T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize7T(1l);
                }
            }

            if (model.getSize8T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize8T(1l);
                }
            }

            if (model.getSize9T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize9T(1l);
                }
            }

            if (model.getSize10T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize10T(1l);
                }
            }

            if (model.getSize11T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize11T(1l);
                }
            }

            if (model.getSize12T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize12T(1l);
                }
            }

            if (model.getSize13T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize13T(1l);
                }
            }
        }
        saveOrUpdate(val);
        model.setId(model.getId());

    }
    
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void approveOut(AdpExpressKanbanModel model, JdcAdpMstUser loginSecUser) {
        
    
        JdcAdpTxnLotapprv val = null;

        if (model.getId() != null) {
            val = findById(model.getId());
            val.setUpdateBy(loginSecUser.getId());
            val.setUpdateDate(new Date(System.currentTimeMillis()));

            if (model.getSize1() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize1(1l);
                }
            }
            if (model.getSize2() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize2(1l);
                }
            }

            if (model.getSize3() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize3(1l);
                }
            }

            if (model.getSize4() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize4(1l);
                }
            }

            if (model.getSize5() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize5(1l);
                }
            }

            if (model.getSize6() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize6(1l);
                }
            }

            if (model.getSize7() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize7(1l);
                }
            }

            if (model.getSize8() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize8(1l);
                }
            }

            if (model.getSize9() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize9(1l);
                }
            }

            if (model.getSize10() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize10(1l);
                }
            }

            if (model.getSize11() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize11(1l);
                }
            }

            if (model.getSize12() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize12(1l);
                }
            }

            if (model.getSize13() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize13(1l);
                }
            }

            if (model.getSize14() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize14(1l);
                }
            }

            if (model.getSize15() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize15(1l);
                }
            }

            if (model.getSize16() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize16(1l);
                }
            }

            if (model.getSize17() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize17(1l);
                }
            }

            if (model.getSize18() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize18(1l);
                }
            }

            if (model.getSize1T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize1T(1l);
                }
            }

            if (model.getSize2T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize2T(1l);
                }
            }

            if (model.getSize3T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize3T(1l);
                }
            }

            if (model.getSize4T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize4T(1l);
                }
            }

            if (model.getSize5T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize5T(1l);
                }
            }

            if (model.getSize6T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize6T(1l);
                }
            }

            if (model.getSize7T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize7T(1l);
                }
            }

            if (model.getSize8T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize8T(1l);
                }
            }

            if (model.getSize9T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize9T(1l);
                }
            }

            if (model.getSize10T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize10T(1l);
                }
            }

            if (model.getSize11T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize11T(1l);
                }
            }

            if (model.getSize12T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize12T(1l);
                }
            }

            if (model.getSize13T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize13T(1l);
                }
            }
        }
        saveOrUpdate(val);
        model.setId(model.getId());
    }

    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void rejectIn(AdpExpressKanbanModel model, JdcAdpMstUser loginSecUser) {
        
        JdcAdpTxnLotapprv val = null;

        if (model.getId() != null) {
            val = findById(model.getId());
            val.setUpdateBy(loginSecUser.getId());
            val.setUpdateDate(new Date(System.currentTimeMillis()));

            if (model.getSize1() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize1(null);
                }
            }
            if (model.getSize2() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize2(null);
                }
            }

            if (model.getSize3() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize3(null);
                }
            }

            if (model.getSize4() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize4(null);
                }
            }

            if (model.getSize5() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize5(null);
                }
            }

            if (model.getSize6() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize6(null);
                }
            }

            if (model.getSize7() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize7(null);
                }
            }

            if (model.getSize8() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize8(null);
                }
            }

            if (model.getSize9() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize9(null);
                }
            }

            if (model.getSize10() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize10(null);
                }
            }

            if (model.getSize11() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize11(null);
                }
            }

            if (model.getSize12() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize12(null);
                }
            }

            if (model.getSize13() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize13(null);
                }
            }

            if (model.getSize14() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize14(null);
                }
            }

            if (model.getSize15() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize15(null);
                }
            }

            if (model.getSize16() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize16(null);
                }
            }

            if (model.getSize17() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize17(null);
                }
            }

            if (model.getSize18() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize18(null);
                }
            }

            if (model.getSize1T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize1T(null);
                }
            }

            if (model.getSize2T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize2T(null);
                }
            }

            if (model.getSize3T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize3T(null);
                }
            }

            if (model.getSize4T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize4T(null);
                }
            }

            if (model.getSize5T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize5T(null);
                }
            }

            if (model.getSize6T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize6T(null);
                }
            }

            if (model.getSize7T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize7T(null);
                }
            }

            if (model.getSize8T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize8T(null);
                }
            }

            if (model.getSize9T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize9T(null);
                }
            }

            if (model.getSize10T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize10T(null);
                }
            }

            if (model.getSize11T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize11T(null);
                }
            }

            if (model.getSize12T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize12T(null);
                }
            }

            if (model.getSize13T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtInSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepInSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscInSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsInSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScInSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsInSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStInSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsInSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutInSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepInSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelInSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserInSize13T(null);
                }
            }
        }
        saveOrUpdate(val);
        model.setId(model.getId());
    }
    
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void rejectOut(AdpExpressKanbanModel model, JdcAdpMstUser loginSecUser) {
        
    
        JdcAdpTxnLotapprv val = null;

        if (model.getId() != null) {
            val = findById(model.getId());
            val.setUpdateBy(loginSecUser.getId());
            val.setUpdateDate(new Date(System.currentTimeMillis()));

            if (model.getSize1() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize1(null);
                }
            }
            if (model.getSize2() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize2(null);
                }
            }

            if (model.getSize3() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize3(null);
                }
            }

            if (model.getSize4() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize4(null);
                }
            }

            if (model.getSize5() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize5(null);
                }
            }

            if (model.getSize6() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize6(null);
                }
            }

            if (model.getSize7() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize7(null);
                }
            }

            if (model.getSize8() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize8(null);
                }
            }

            if (model.getSize9() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize9(null);
                }
            }

            if (model.getSize10() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize10(null);
                }
            }

            if (model.getSize11() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize11(null);
                }
            }

            if (model.getSize12() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize12(null);
                }
            }

            if (model.getSize13() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize13(null);
                }
            }

            if (model.getSize14() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize14(null);
                }
            }

            if (model.getSize15() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize15(null);
                }
            }

            if (model.getSize16() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize16(null);
                }
            }

            if (model.getSize17() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize17(null);
                }
            }

            if (model.getSize18() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize18(null);
                }
            }

            if (model.getSize1T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize1T(null);
                }
            }

            if (model.getSize2T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize2T(null);
                }
            }

            if (model.getSize3T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize3T(null);
                }
            }

            if (model.getSize4T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize4T(null);
                }
            }

            if (model.getSize5T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize5T(null);
                }
            }

            if (model.getSize6T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize6T(null);
                }
            }

            if (model.getSize7T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize7T(null);
                }
            }

            if (model.getSize8T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize8T(null);
                }
            }

            if (model.getSize9T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize9T(null);
                }
            }

            if (model.getSize10T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize10T(null);
                }
            }

            if (model.getSize11T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize11T(null);
                }
            }

            if (model.getSize12T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize12T(null);
                }
            }

            if (model.getSize13T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagExCtOutSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagExPrepOutSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagExCscOutSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagExNsOutSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagExScOutSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagExOsOutSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagExStOutSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagExAsOutSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagExSpcutOutSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagExSpprepOutSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagExLabelOutSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagExLaserOutSize13T(null);
                }
            }
        }
        saveOrUpdate(val);
        model.setId(model.getId());
    }

}
