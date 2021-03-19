package com.agit.services;

import java.util.HashMap;

import com.project.common.DataTables;
import com.agit.entity.JdcAdpFndparams;
import com.agit.entity.security.JdcAdpMstUser;

/**
 *
 * @author erwin
 */
public interface AdpParamConfigService {

    /**
     *
     * @param id
     * @return
     */
    public JdcAdpFndparams findById(Long id);

    /**
     *
     * @param model
     * @param userLogin
     */
    public void saveParamConfig(JdcAdpFndparams model, JdcAdpMstUser userLogin);

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap);

    /**
     *
     * @param param
     * @return
     */
    public String checkExistingByCode(String param);

    /**
     *
     * @param id
     * @return
     */
    public boolean isExist(Long id);

    /**
     *
     * @return
     */
    public String getImageLogoDirectory();

    /**
     *
     * @return
     */
    public String getDocumentDirectory();

    /**
     *
     * @return
     */
    public String getDownloadDirectory();
}
