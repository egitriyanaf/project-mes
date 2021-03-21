package com.agit.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.agit.entity.JdcAdpMstlookup;
import com.agit.entity.JdcAdpFndparams;
import com.agit.dao.AdpGenericDao;
/**
*
* @author Ridwan
*/
@Repository
public class AdpGenericDaoImpl implements AdpGenericDao {

    /**
     *
     */
    @Autowired
	protected SessionFactory sessionFactory;

    /**
     *
     * @param type
     * @return
     */
    @SuppressWarnings("unchecked")
	@Override
	public List<JdcAdpMstlookup> lookup(String type) {
		return sessionFactory.getCurrentSession()
				.createQuery("from JdcAdpMstlookup where type = :type and activeFlag='Y'")
				.setParameter("type", type).list();
	}
	
    /**
     *
     * @param type
     * @param value
     * @return
     */
    @Override
	public JdcAdpMstlookup getLookupByValue(String type, String value) {
		return (JdcAdpMstlookup) sessionFactory.getCurrentSession()
				.createQuery("from JdcAdpMstlookup where type = :type and value= :value")
				.setParameter("type", type)
				.setParameter("value", value).uniqueResult();
	}

    /**
     *
     * @param type
     * @param value
     * @return
     */
    @Override
	public String getLookupDesc(String type, String value) {
		JdcAdpMstlookup lookup = (JdcAdpMstlookup) sessionFactory.getCurrentSession()
				.createQuery("from JdcAdpMstlookup where type = :type and value= :value")
				.setParameter("type", type)
				.setParameter("value", value).uniqueResult();

		if (lookup != null)
			return lookup.getDescription();

		return null;
	}

    /**
     *
     * @param name
     * @return
     */
    @Override
	public JdcAdpFndparams getConfigByName(String name) {
		return (JdcAdpFndparams) sessionFactory.getCurrentSession()
				.createQuery("from JdcAdpFndparams where name = :name")
				.setParameter("name", name).uniqueResult();
	}

	/*@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getChildIds(Long parenId) {
		List<Integer> result = null;
		try {
			result = sessionFactory.getCurrentSession().createSQLQuery("select btncol.user_tree("+parenId+")").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		//if(result==null) return new ArrayList<Integer>();
		
		return result;

	}*/

}