/**
 * 
 */
package com.agit.services.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.common.DataTables;
import com.agit.dao.AdpInterfaceBaseDao;

/**
 *
 * @author erwin
 * @param <T>
 */
@Service
@Transactional(readOnly = true)
public abstract class AdpAbstractServiceImpl<T>{

    /**
     *
     * @return
     */
    public abstract Class<T> getRealClass();
	
    /**
     *
     * @return
     */
    public abstract AdpInterfaceBaseDao<T> getDao();

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    public abstract DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap);
	
    /**
     *
     * @param t
     */
    @Transactional(propagation = Propagation.REQUIRED)
	@Modifying
	public void saveOrUpdate(T t) {
		this.getDao().saveOrUpdate(t);
	}
	
    /**
     *
     * @param entities
     * @throws org.springframework.dao.DataAccessException
     */
    @Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveOrUpdateAll(Collection<T> entities) throws DataAccessException {
		this.getDao().saveOrUpdateAll(entities);
	}
	
    /**
     *
     * @param entity
     * @throws org.springframework.dao.DataAccessException
     */
    @Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(T entity) throws DataAccessException {
		this.getDao().delete(entity);
	}

    /**
     *
     * @param entities
     * @throws org.springframework.dao.DataAccessException
     */
    @Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteAll(Collection<T> entities) throws DataAccessException {
		this.getDao().deleteAll(entities);
	}

    /**
     *
     * @param id
     * @return
     */
    public T findById(Long id) {
		return this.getDao().get(this.getRealClass(), id);
	}
	
    /**
     *
     * @param clazz
     * @return
     */
    public List<T> loadAll(Class<T> clazz){
		return this.getDao().loadAll(clazz);
	}
}
