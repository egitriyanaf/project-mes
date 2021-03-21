package com.agit.services.impl;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.common.DataTables;
import com.agit.entity.JdcAdpTxnrpph;
import com.agit.services.AdpReportPphService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author erwin
 */
@Service
@Transactional(readOnly = true)
public class AdpReportPphServiceImpl extends AdpSimpleServiceImpl<JdcAdpTxnrpph> implements AdpReportPphService {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     *
     * @return
     */
    @Override
    public Class<JdcAdpTxnrpph> getRealClass() {
        return JdcAdpTxnrpph.class;
    }

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @Override
	public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpTxnrpph.class);
        return getDataTablesFromCriteria(criteria, dataTables);
	}

    /**
     *
     * @param searchMap
     * @return
     */
    @SuppressWarnings("unchecked")
	@Override
	public List<JdcAdpTxnrpph> getDataReport(Map<String, Object> searchMap) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpTxnrpph.class);
        try {
            String scanDate = (String) searchMap.get("scanDate");
            if (scanDate != null) {
                Date sDate = new SimpleDateFormat("dd-MMM-yyyy").parse(scanDate);
                criteria.add(Restrictions.eq("scanDate", sDate));
            }
        } catch (ParseException ex) {
            Logger.getLogger(AdpReportPphServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        criteria.setFirstResult(0);
        criteria.setMaxResults(10);
        criteria.addOrder(Order.desc("scanDate"));
        return criteria.list();
	}



}
