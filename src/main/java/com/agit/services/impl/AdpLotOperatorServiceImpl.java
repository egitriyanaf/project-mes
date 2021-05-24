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
import com.agit.entity.JdcAdpTxnlotbasis;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.services.AdpLotOperatorService;

/**
 *
 * @author erwin
 */
@Service
@Transactional(readOnly = true)
public class AdpLotOperatorServiceImpl extends AdpSimpleServiceImpl<JdcAdpTxnlotbasis> implements AdpLotOperatorService {

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
     * @param model
     * @param loginSecUser
     */
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void approveIn(AdpLotOperatorModel model, JdcAdpMstUser loginSecUser) {

        JdcAdpTxnlotbasis val = null;
        if (model.getId() != null) {
            val = findById(model.getId());
            val.setUpdateBy(loginSecUser.getId());
            val.setUpdateDate(new Date(System.currentTimeMillis()));

            if (model.getSize1() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize1(1l);
                }
            }
            if (model.getSize1T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize1T(1l);
                }
            }
            if (model.getSize2() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize2(1l);
                }
            }
            if (model.getSize2T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize2T(1l);
                }
            }
            if (model.getSize3() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize3(1l);
                }
            }
            if (model.getSize3T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize3T(1l);
                }
            }
            if (model.getSize4() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize4(1l);
                }
            }
            if (model.getSize4T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize4T(1l);
                }
            }
            if (model.getSize5() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize5(1l);
                }
            }
            if (model.getSize5T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize5T(1l);
                }
            }
            if (model.getSize6() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize6(1l);
                }
            }
            if (model.getSize6T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize6T(1l);
                }
            }
            if (model.getSize7() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize7(1l);
                }
            }
            if (model.getSize7T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize7T(1l);
                }
            }
            if (model.getSize8() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize8(1l);
                }
            }
            if (model.getSize8T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize8T(1l);
                }
            }
            if (model.getSize9() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize9(1l);
                }
            }
            if (model.getSize9T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize9T(1l);
                }
            }
            if (model.getSize10() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize10(1l);
                }
            }
            if (model.getSize10T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize10T(1l);
                }
            }
            if (model.getSize11() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize11(1l);
                }
            }
            if (model.getSize11T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize11T(1l);
                }
            }
            if (model.getSize12() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize12(1l);
                }
            }
            if (model.getSize12T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize12T(1l);
                }
            }
            if (model.getSize13() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize13(1l);
                }
            }
            if (model.getSize13T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize13T(1l);
                }
            }
            if (model.getSize14() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize14(1l);
                }
            }
            if (model.getSize15() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize15(1l);
                }
            }
            if (model.getSize16() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize16(1l);
                }
            }
            if (model.getSize17() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize17(1l);
                }
            }
            if (model.getSize18() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize18(1l);
                }
            }
        }
        saveOrUpdate(val);
        model.setId(model.getId());

    }

    /**
     *
     * @param model
     * @param loginSecUser
     */
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void approveOut(AdpLotOperatorModel model, JdcAdpMstUser loginSecUser) {
        JdcAdpTxnlotbasis val = null;

        if (model.getId() != null) {
            val = findById(model.getId());
            val.setUpdateBy(loginSecUser.getId());
            val.setUpdateDate(new Date(System.currentTimeMillis()));

            if (model.getSize1() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize1(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize1(1l);
                }
            }
            if (model.getSize1T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize1T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize1T(1l);
                }
            }
            if (model.getSize2() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize2(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize2(1l);
                }
            }
            if (model.getSize2T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize2T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize2T(1l);
                }
            }
            if (model.getSize3() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize3(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize3(1l);
                }
            }
            if (model.getSize3T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize3T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize3T(1l);
                }
            }
            if (model.getSize4() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize4(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize4(1l);
                }
            }
            if (model.getSize4T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize4T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize4T(1l);
                }
            }
            if (model.getSize5() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize5(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize5(1l);
                }
            }
            if (model.getSize5T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize5T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize5T(1l);
                }
            }
            if (model.getSize6() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize6(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize6(1l);
                }
            }
            if (model.getSize6T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize6T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize6T(1l);
                }
            }
            if (model.getSize7() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize7(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize7(1l);
                }
            }
            if (model.getSize7T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize7T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize7T(1l);
                }
            }
            if (model.getSize8() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize8(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize8(1l);
                }
            }
            if (model.getSize8T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize8T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize8T(1l);
                }
            }
            if (model.getSize9() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize9(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize9(1l);
                }
            }
            if (model.getSize9T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize9T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize9T(1l);
                }
            }
            if (model.getSize10() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize10(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize10(1l);
                }
            }
            if (model.getSize10T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize10T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize10T(1l);
                }
            }
            if (model.getSize11() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize11(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize11(1l);
                }
            }
            if (model.getSize11T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize11T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize11T(1l);
                }
            }
            if (model.getSize12() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize12(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize12(1l);
                }
            }
            if (model.getSize12T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize12T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize12T(1l);
                }
            }
            if (model.getSize13() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize13(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize13(1l);
                }
            }
            if (model.getSize13T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize13T(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize13T(1l);
                }
            }
            if (model.getSize14() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize14(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize14(1l);
                }
            }
            if (model.getSize15() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize15(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize15(1l);
                }
            }
            if (model.getSize16() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize16(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize16(1l);
                }
            }
            if (model.getSize17() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize17(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize17(1l);
                }
            }
            if (model.getSize18() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize18(1l);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize18(1l);
                }
            }
        }
        saveOrUpdate(val);
        model.setId(model.getId());

    }

    /**
     *
     * @param model
     * @param loginSecUser
     */
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void rejectIn(AdpLotOperatorModel model, JdcAdpMstUser loginSecUser) {
        JdcAdpTxnlotbasis val = null;

        if (model.getId() != null) {
            val = findById(model.getId());
            val.setUpdateBy(loginSecUser.getId());
            val.setUpdateDate(new Date(System.currentTimeMillis()));

            if (model.getSize1() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize1(null);
                }
            }
            if (model.getSize1T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize1T(null);
                }
            }
            if (model.getSize2() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize2(null);
                }
            }
            if (model.getSize2T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize2T(null);
                }
            }
            if (model.getSize3() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize3(null);
                }
            }
            if (model.getSize3T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize3T(null);
                }
            }
            if (model.getSize4() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize4(null);
                }
            }
            if (model.getSize4T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize4T(null);
                }
            }
            if (model.getSize5() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize5(null);
                }
            }
            if (model.getSize5T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize5T(null);
                }
            }
            if (model.getSize6() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize6(null);
                }
            }
            if (model.getSize6T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize6T(null);
                }
            }
            if (model.getSize7() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize7(null);
                }
            }
            if (model.getSize7T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize7T(null);
                }
            }
            if (model.getSize8() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize8(null);
                }
            }
            if (model.getSize8T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize8T(null);
                }
            }
            if (model.getSize9() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize9(null);
                }
            }
            if (model.getSize9T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize9T(null);
                }
            }
            if (model.getSize10() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize10(null);
                }
            }
            if (model.getSize10T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize10T(null);
                }
            }
            if (model.getSize11() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize11(null);
                }
            }
            if (model.getSize11T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize11T(null);
                }
            }
            if (model.getSize12() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize12(null);
                }
            }
            if (model.getSize12T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize12T(null);
                }
            }
            if (model.getSize13() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize13(null);
                }
            }
            if (model.getSize13T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize13T(null);
                }
            }
            if (model.getSize14() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize14(null);
                }
            }
            if (model.getSize15() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize15(null);
                }
            }
            if (model.getSize16() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize16(null);
                }
            }
            if (model.getSize17() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize17(null);
                }
            }
            if (model.getSize18() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtInSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepInSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscInSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsInSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScInSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsInSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStInSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsInSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutInSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepInSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelInSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserInSize18(null);
                }
            }
        }
        saveOrUpdate(val);
        model.setId(model.getId());

    }

    /**
     *
     * @param model
     * @param loginSecUser
     */
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void rejectOut(AdpLotOperatorModel model, JdcAdpMstUser loginSecUser) {
        JdcAdpTxnlotbasis val = null;

        if (model.getId() != null) {
            val = findById(model.getId());
            val.setUpdateBy(loginSecUser.getId());
            val.setUpdateDate(new Date(System.currentTimeMillis()));

            if (model.getSize1() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize1(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize1(null);
                }
            }
            if (model.getSize1T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize1T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize1T(null);
                }
            }
            if (model.getSize2() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize2(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize2(null);
                }
            }
            if (model.getSize2T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize2T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize2T(null);
                }
            }
            if (model.getSize3() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize3(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize3(null);
                }
            }
            if (model.getSize3T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize3T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize3T(null);
                }
            }
            if (model.getSize4() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize4(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize4(null);
                }
            }
            if (model.getSize4T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize4T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize4T(null);
                }
            }
            if (model.getSize5() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize5(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize5(null);
                }
            }
            if (model.getSize5T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize5T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize5T(null);
                }
            }
            if (model.getSize6() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize6(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize6(null);
                }
            }
            if (model.getSize6T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize6T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize6T(null);
                }
            }
            if (model.getSize7() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize7(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize7(null);
                }
            }
            if (model.getSize7T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize7T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize7T(null);
                }
            }
            if (model.getSize8() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize8(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize8(null);
                }
            }
            if (model.getSize8T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize8T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize8T(null);
                }
            }
            if (model.getSize9() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize9(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize9(null);
                }
            }
            if (model.getSize9T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize9T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize9T(null);
                }
            }
            if (model.getSize10() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize10(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize10(null);
                }
            }
            if (model.getSize10T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize10T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize10T(null);
                }
            }
            if (model.getSize11() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize11(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize11(null);
                }
            }
            if (model.getSize11T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize11T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize11T(null);
                }
            }
            if (model.getSize12() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize12(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize12(null);
                }
            }
            if (model.getSize12T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize12T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize12T(null);
                }
            }
            if (model.getSize13() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize13(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize13(null);
                }
            }
            if (model.getSize13T() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize13T(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize13T(null);
                }
            }
            if (model.getSize14() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize14(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize14(null);
                }
            }
            if (model.getSize15() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize15(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize15(null);
                }
            }
            if (model.getSize16() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize16(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize16(null);
                }
            }
            if (model.getSize17() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize17(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize17(null);
                }
            }
            if (model.getSize18() != null) {
                if (model.getDepartement().equalsIgnoreCase("Cutting")) {
                    val.setFlagCtOutSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Preparation")) {
                    val.setFlagPrepOutSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("CSC")) {
                    val.setFlagCscOutSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("No Sew")) {
                    val.setFlagNsOutSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Subcon")) {
                    val.setFlagScOutSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("OutSole")) {
                    val.setFlagOsOutSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Stiching")) {
                    val.setFlagStOutSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("Assembly")) {
                    val.setFlagAsOutSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spcut")) {
                    val.setFlagspcutOutSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("spprep")) {
                    val.setFlagspprepOutSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("label")) {
                    val.setFlagLabelOutSize18(null);
                }
                if (model.getDepartement().equalsIgnoreCase("laser")) {
                    val.setFlagLaserOutSize18(null);
                }
            }
        }
        saveOrUpdate(val);
        model.setId(model.getId());

    }
    
}
