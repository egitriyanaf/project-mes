package com.agit.services;

import com.agit.controller.maintenance.model.AdpProduksiAdressModel;
import com.agit.controller.maintenance.model.AdpProduksiSearchModel;
import com.agit.entity.JdcAdpMstimages;
import com.agit.entity.security.JdcAdpMstUser;
import com.project.common.DataTables;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author TriAA
 */
public interface AdpImageService {

    /**
     *
     * @param id
     * @return
     */
    public JdcAdpMstimages findByCode(String id);

    /**
     *
     * @param images
     * @param userLogin
     */
    public void saveMstImages(JdcAdpMstimages images, JdcAdpMstUser userLogin);

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap);

    /**
     *
     * @param searchMap
     * @return
     */
    public List<AdpProduksiSearchModel> searchProduct(Map<String, Object> searchMap);

    /**
     *
     * @param searchMap
     * @return
     */
    public List<AdpProduksiAdressModel> searchAddress(Map<String, Object> searchMap);

    /**
     *
     * @return
     */
    public List<JdcAdpMstimages> list();

}
