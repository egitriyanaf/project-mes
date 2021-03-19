package com.agit.services;

import com.agit.entity.JdcAdpMstspk;
import com.agit.entity.JdcAdpTxnqcctrl;
import com.agit.entity.security.JdcAdpMstUser;
import java.util.List;

/**
 *
 * @author TriAA
 */
public interface AdpWorkshopInspectionService {

    /**
     *
     * @param id
     * @return
     */
    public JdcAdpTxnqcctrl findById(Long id);

    /**
     *
     * @param model
     * @param user
     */
    public void save(JdcAdpTxnqcctrl model, JdcAdpMstUser user);

    /**
     *
     * @param sampleReq
     * @return
     */
    public List<JdcAdpMstspk> findBySpk(String sampleReq);

    /**
     *
     * @return
     */
    public List<JdcAdpMstspk> findAll();
}
