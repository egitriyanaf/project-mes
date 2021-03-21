package com.agit.services;

import com.agit.entity.JdcAdpFndapprv;
import com.agit.entity.JdcAdpTxnLotapprv;
import com.agit.entity.security.JdcAdpMstUser;
import com.project.common.DataTables;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author TriAA
 */
public interface AdpLotStockKanbanServices {

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
    public JdcAdpTxnLotapprv findById(Long id);

    /**
     *
     * @return
     */
    public List<JdcAdpTxnLotapprv> findByStatus();

    /**
     *
     * @param txn
     * @param findUser
     */
    public void save(JdcAdpTxnLotapprv txn, JdcAdpMstUser findUser);

    /**
     *
     * @param persentase
     * @return
     */
    public JdcAdpFndapprv getApprovalBypers(Long persentase);

    /**
     *
     * @param approve
     * @param loginSecUser
     */
    public void saveUpdate(JdcAdpTxnLotapprv approve, JdcAdpMstUser loginSecUser);

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    public DataTables searchByMapCriteriaLotKanban(DataTables dataTables, HashMap<String, Object> searchMap);

}
