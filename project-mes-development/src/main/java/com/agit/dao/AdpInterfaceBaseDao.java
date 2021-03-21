package com.agit.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;
/**
*
* @author Ridwan
 * @param <T>
*/
public interface AdpInterfaceBaseDao<T> {

    /**
     *
     * @param entity
     * @return
     * @throws org.springframework.dao.DataAccessException
     */
    public T merge(T entity) throws DataAccessException;
	
    /**
     *
     * @param entity
     * @throws org.springframework.dao.DataAccessException
     */
    public void persist(T entity) throws DataAccessException;

    /**
     *
     * @param entity
     * @throws org.springframework.dao.DataAccessException
     */
    public void refresh(T entity) throws DataAccessException;

    /**
     *
     * @param entity
     * @throws org.springframework.dao.DataAccessException
     */
    public void save(T entity) throws DataAccessException;

    /**
     *
     * @param entity
     * @throws org.springframework.dao.DataAccessException
     */
    public void saveOrUpdate(T entity) throws DataAccessException;

    /**
     *
     * @param entities
     * @throws org.springframework.dao.DataAccessException
     */
    public void saveOrUpdateAll(Collection<T> entities) throws DataAccessException;

    /**
     *
     * @param entity
     * @throws org.springframework.dao.DataAccessException
     */
    public void update(T entity) throws DataAccessException;

    /**
     *
     * @param entity
     * @throws org.springframework.dao.DataAccessException
     */
    public void delete(T entity) throws DataAccessException;

    /**
     *
     * @param entities
     * @throws org.springframework.dao.DataAccessException
     */
    public void deleteAll(Collection<T> entities) throws DataAccessException;

    /**
     *
     * @param entityClass
     * @param id
     * @return
     * @throws org.springframework.dao.DataAccessException
     */
    public T get(Class<T> entityClass, Long id) throws DataAccessException;

    /**
     *
     * @param clazz
     * @return
     * @throws org.springframework.dao.DataAccessException
     */
    public List<T> loadAll(Class<T> clazz) throws DataAccessException;
}
