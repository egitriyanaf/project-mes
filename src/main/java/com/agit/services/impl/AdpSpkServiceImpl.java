package com.agit.services.impl;

import java.util.HashMap;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.common.DataTables;
import com.agit.controller.sample.model.AdpViewSpkModel;
import com.agit.dao.AdpSpkDao;
import com.agit.entity.JdcAdpMstspk;
import com.agit.services.AdpSpkService;

/**
 *
 * @author ridwans
 */
@Service
@Transactional(readOnly = true)
public class AdpSpkServiceImpl extends AdpSimpleServiceImpl<JdcAdpMstspk> implements AdpSpkService {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    AdpSpkDao adpSpkDao;

    /**
     *
     * @return
     */
    @Override
    public Class<JdcAdpMstspk> getRealClass() {
        return JdcAdpMstspk.class;
    }

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @Override
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap) {
        Long total = adpSpkDao.getCountSpk(searchMap);
        List<AdpViewSpkModel> data = adpSpkDao.getDataSpk(dataTables, searchMap);
        return dataTables.extract(data, total);
    }

}
