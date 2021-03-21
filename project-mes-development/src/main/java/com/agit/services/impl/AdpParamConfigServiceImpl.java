package com.agit.services.impl;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.common.DataTables;
import com.agit.entity.JdcAdpFndparams;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.services.AdpGenericService;
import com.agit.services.AdpParamConfigService;

/**
 *
 * @author erwin
 */
@Service
@Transactional(readOnly = true)
public class AdpParamConfigServiceImpl extends AdpSimpleServiceImpl<JdcAdpFndparams> implements AdpParamConfigService {

    @Autowired
    SessionFactory sessionFactory;

    /**
     *
     */
    @Autowired
    protected AdpGenericService genericService;

    /**
     *
     * @return
     */
    @Override
    public Class<JdcAdpFndparams> getRealClass() {
        return JdcAdpFndparams.class;
    }

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @Override
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap) {
        String name = (String) searchMap.get("name");
        Long parentId = (Long) searchMap.get("parentId");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpFndparams.class);
        if (StringUtils.isNotBlank(name)) {
            criteria.add(Restrictions.ilike("name", name, MatchMode.ANYWHERE));
        }
        if (parentId != null) {
            criteria.add(Restrictions.isNull("parent.id"));
        }
        return getDataTablesFromCriteria(criteria, dataTables);
    }

    /**
     *
     * @param param
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public String checkExistingByCode(String param) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpFndparams.class);
        criteria.add(Restrictions.eq("name", param).ignoreCase());

        List<JdcAdpFndparams> sts = criteria.list();
        if (!sts.isEmpty()) {
            return "Y";
        }
        return "N";
    }

    /**
     *
     * @param model
     * @param userLogin
     */
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveParamConfig(JdcAdpFndparams model, JdcAdpMstUser userLogin) {
        JdcAdpFndparams param = null;
        if (model.getId() != null) {
            param = findById(model.getId());
            param.setUpdateBy(userLogin.getId());
            param.setUpdateDate(new Date(System.currentTimeMillis()));
        } else {
            param = new JdcAdpFndparams();
            param.setCreateBy(userLogin.getId());
            param.setCreateDate(new Date(System.currentTimeMillis()));
            param.setName(model.getName());
        }
        param.setType(model.getType());
        param.setDesc(model.getDesc());
        param.setValue(model.getValue());
        saveOrUpdate(param);
        model.setId(param.getId());

    }

    /**
     *
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean isExist(Long id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpFndparams.class);
        criteria.add(Restrictions.eq("id", id).ignoreCase());
        List<JdcAdpFndparams> list = criteria.list();
        if (list.isEmpty()) {
            return false;
        }

        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public String getImageLogoDirectory() {
        JdcAdpFndparams config = genericService.getConfigByName(JdcAdpFndparams.LOGO_UPLOAD);
        if (config != null) {
            File dir = new File(config.getValue());
            if (!dir.exists()) {
                dir.mkdirs();
            }

            return config.getValue();
        }

        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public String getDocumentDirectory() {
        JdcAdpFndparams config = genericService.getConfigByName(JdcAdpFndparams.DOCUMENT_UPLOAD);
        if (config != null) {
            File dir = new File(config.getValue());
            if (!dir.exists()) {
                dir.mkdirs();
            }

            return config.getValue();
        }

        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public String getDownloadDirectory() {
        JdcAdpFndparams config = genericService.getConfigByName(JdcAdpFndparams.DOCUMENT_DOWNLOAD);
        if (config != null) {
            File dir = new File(config.getValue());
            if (!dir.exists()) {
                dir.mkdirs();
            }

            return config.getValue();
        }

        return null;
    }

}
