package com.agit.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.agit.dao.AdpInterfaceBaseDao;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
/**
*
* @author Ridwan
 * @param <T>
*/
@SuppressWarnings("unchecked")
public class AdpBaseDao<T> implements AdpInterfaceBaseDao<T> {

    /**
     *
     */
    @Autowired
	protected SessionFactory sessionFactory;

    /**
     *
     * @param entity
     * @return
     * @throws org.springframework.dao.DataAccessException
     */
    @Override
	public T merge(T entity) throws DataAccessException {
		return (T) sessionFactory.getCurrentSession().merge(entity);
	}

    /**
     *
     * @param entity
     * @throws org.springframework.dao.DataAccessException
     */
    @Override
	public void persist(T entity) throws DataAccessException {
		sessionFactory.getCurrentSession().persist(entity);
	}

    /**
     *
     * @param entity
     * @throws org.springframework.dao.DataAccessException
     */
    @Override
	public void refresh(T entity) throws DataAccessException {
		sessionFactory.getCurrentSession().refresh(entity);
	}

    /**
     *
     * @param entity
     * @throws org.springframework.dao.DataAccessException
     */
    @Override
	public void save(T entity) throws DataAccessException {
		sessionFactory.getCurrentSession().save(entity);
	}

    /**
     *
     * @param entity
     * @throws org.springframework.dao.DataAccessException
     */
    @Override
	public void saveOrUpdate(T entity) throws DataAccessException {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

    /**
     *
     * @param entities
     * @throws org.springframework.dao.DataAccessException
     */
    @Override
	public void saveOrUpdateAll(Collection<T> entities) throws DataAccessException {
		for (T entity : entities) {
			saveOrUpdate(entity);
		}
	}

    /**
     *
     * @param entity
     * @throws org.springframework.dao.DataAccessException
     */
    @Override
	public void update(T entity) throws DataAccessException {
		sessionFactory.getCurrentSession().update(entity);
	}

    /**
     *
     * @param entity
     * @throws org.springframework.dao.DataAccessException
     */
    @Override
	public void delete(T entity) throws DataAccessException {
		sessionFactory.getCurrentSession().delete(entity);
	}

    /**
     *
     * @param entities
     * @throws org.springframework.dao.DataAccessException
     */
    @Override
	public void deleteAll(Collection<T> entities) throws DataAccessException {
		for (T entity : entities) {
			delete(entity);
		}
	}

    /**
     *
     * @param entityClass
     * @param id
     * @return
     * @throws org.springframework.dao.DataAccessException
     */
    @Override
	public T get(Class<T> entityClass, Long id) throws DataAccessException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(entityClass);
		criteria.add(Restrictions.eq("id", id));
		return (T) criteria.uniqueResult();
	}

    /**
     *
     * @param clazz
     * @return
     */
    @Override
	public List<T> loadAll(Class<T> clazz) {
		return sessionFactory.getCurrentSession().createCriteria(clazz).list();
	}
        
    /**
     *
     * @param listProp
     * @param listValueLike
     * @return
     */
    public Criterion buildResctrictionsAndForAllProperty(String[] listProp, String[] listValueLike) {
        Criterion criterion = null;
        for (String valueLike : listValueLike) {
            if (criterion == null) {
                criterion = buildResctrictionsOrForAllProperty(listProp, valueLike);
            } else {
                criterion = Restrictions.and(criterion, buildResctrictionsOrForAllProperty(listProp, valueLike));
            }
        }
        return criterion;
    }

    /**
     *
     * @param listProp
     * @param valueLike
     * @return
     */
    public Criterion buildResctrictionsOrForAllProperty(String[] listProp, String valueLike) {
        Criterion criterion = null;
        for (String prop : listProp) {
            if (criterion == null) {
                criterion = Restrictions.ilike(prop, valueLike, MatchMode.ANYWHERE);
            } else {
                String valueLikeTemp = null;
                valueLikeTemp = valueLike;
                criterion = Restrictions.or(criterion, Restrictions.ilike(prop, valueLikeTemp, MatchMode.ANYWHERE));
            }
        }
        return criterion;
    }
}
