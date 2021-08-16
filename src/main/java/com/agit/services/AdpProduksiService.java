/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.services;

import com.agit.controller.production.model.AdpLotbasisModel;
import com.agit.controller.qc.model.AdpProduksiModel;
import com.agit.entity.JdcAdpMstproduksi;
import com.agit.entity.JdcAdpTxnlotbasis;
import com.agit.entity.security.JdcAdpMstUser;
import com.project.common.DataTables;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ridwans
 */
public interface AdpProduksiService {

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap);

    /**
     *
     * @param id
     * @return
     */
    public JdcAdpMstproduksi findById(Long id);

    /**
     *
     * @param searchMap
     * @return
     */
    public List<JdcAdpMstproduksi> findByLineCode(Map<String, Object> searchMap);
    
    /**
     *
     * @param searchMap
     * @return
     */
    public List<JdcAdpMstproduksi> findByLineCodeNew(Map<String, Object> searchMap);

    /**
     *
     * @param searchMap
     * @return
     */
    public List<JdcAdpMstproduksi> findPoItemByNcvs(Map<String, Object> searchMap);
    
    /**
     *
     * @param searchMap
     * @return
     */
    public List<JdcAdpMstproduksi> findPoItemByNcvsNew(Map<String, Object> searchMap);

    /**
     *
     * @param searchMap
     * @return
     */
    public List<JdcAdpMstproduksi> findPoNoByNcvs(Map<String, Object> searchMap);
    
    /**
     *
     * @param searchMap
     * @return
     */
    public List<JdcAdpMstproduksi> findPoNoOk(Map<String, Object> searchMap);
    
    /**
     *
     * @param searchMap
     * @return
     */
    public List<JdcAdpMstproduksi> findPoNoFrst(Map<String, Object> searchMap);

    /**
     *
     * @param searchMap
     * @return
     */
    public List<JdcAdpMstproduksi> findProductByPO(Map<String, Object> searchMap);

    /**
     *
     * @param searchMap
     * @return
     */
    public List<JdcAdpMstproduksi> findProductNoProductDesc(Map<String, Object> searchMap);

    /**
     *
     * @param ncvs
     * @return
     */
    public List<JdcAdpMstproduksi> findBynCVS(String ncvs);

    /**
     *
     * @param searchMap
     * @return
     */
    public List<AdpProduksiModel> retrieveData(Map<String, Object> searchMap);

    /**
     *
     * @param model
     * @param loginSecUser
     */
    public void save(AdpProduksiModel model, JdcAdpMstUser loginSecUser);

    /**
     *
     * @param model
     * @param loginSecUser
     */
    public void submit(AdpProduksiModel model, JdcAdpMstUser loginSecUser);

    /**
     *
     * @param ncvs
     * @param po
     * @param item
     * @param demandclass
     * @return
     */
    public AdpProduksiModel findByLotBasis(String ncvs, String po, String item, String demandclass);

    /**
     *
     * @param model
     * @param loginSecUser
     */
    public void saveLotBasis(AdpLotbasisModel model, JdcAdpMstUser loginSecUser);

    /**
     *
     * @param ncvs
     * @param po
     * @param item
     * @param hourly
     * @return
     */
    public JdcAdpTxnlotbasis findByToKanban(String ncvs, String po, String item, Long hourly);

    /**
     *
     * @param searchMap
     * @return
     */
    public List<JdcAdpMstproduksi> findByDemandClass(Map<String, Object> searchMap);
    
    /**
     *
     * @param searchMap
     * @return
     */
    public List<JdcAdpMstproduksi> findByDemandClassNew(Map<String, Object> searchMap);

    /**
     *
     * @param model
     * @param loginSecUser
     */
    public void saveRemark(AdpProduksiModel model, JdcAdpMstUser loginSecUser);

    /**
     *
     * @return
     */
    public List<JdcAdpMstproduksi> getAll();

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    public DataTables searchByMapCriteriaProduct(DataTables dataTables, HashMap<String, Object> searchMap);

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    public DataTables searchByMapCriteriaDiamondMark(DataTables dataTables, HashMap<String, Object> searchMap);

}
