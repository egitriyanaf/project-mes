package com.agit.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.common.DataTables;
import com.agit.controller.administration.model.AdpRoleModel;
import com.agit.controller.administration.model.AdpStateModel;
import com.agit.entity.security.JdcAdpMstComponent;
import com.agit.entity.security.JdcAdpMstRole;
import com.agit.entity.security.JdcAdpMstRoledetail;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.services.AdpRoleService;

/**
 *
 * @author erwin
 */
@Service
@Transactional(readOnly = true)
public class AdpRoleServiceImpl extends AdpSimpleServiceImpl<JdcAdpMstRole> implements AdpRoleService{

	@Autowired
	SessionFactory sessionFactory;
	
    /**
     *
     * @return
     */
    @Override
	public Class<JdcAdpMstRole> getRealClass() {
		return JdcAdpMstRole.class;
	}

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @Override
	public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap) {
		
		String name	= (String) searchMap.get("name");

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstRole.class);
		if (StringUtils.isNotBlank(name))
			criteria.add(Restrictions.ilike("name", name, MatchMode.ANYWHERE));

		return getDataTablesFromCriteria(criteria, dataTables);
	}
	
    /**
     *
     * @param model
     * @param userLogin
     */
    @Modifying
    @Transactional(propagation=Propagation.REQUIRED)
	@Override
    public void saveSecRole(AdpRoleModel model, JdcAdpMstUser userLogin) {
    	List<Long> unchecked = new ArrayList<Long>();
    	List<Long> checked = new ArrayList<Long>();
    	for(AdpStateModel stateModel : model.getStates()){
    		if (stateModel.getId()!= null){
	    		if ("1".equals(stateModel.getState())){
	    			checked.add(stateModel.getId());
	    		}else if ("0".equals(stateModel.getState())){
	    			unchecked.add(stateModel.getId());
	    		}
    		}
    	}
    	
    	JdcAdpMstRole role = null;
    	if (model.getId() != null){
    		
    		// delete any unchecked mapping for the group
    		List<Long> all = new ArrayList<Long>();
        	all.addAll(checked);
        	all.addAll(unchecked);
        	if(all.size() > 0){
        		sessionFactory.getCurrentSession()
            	.createQuery("delete from JdcAdpMstRoledetail where role.id = :roleId and component.id in :all")
            	.setParameter("roleId", model.getId())
        		.setParameterList("all", all)
            	.executeUpdate();
        	}
        	
        	role =  findById(model.getId());
	        /*role.setLastUpdatedBy(userLogin.getId());
	        role.setLastUpdatedDate(new Date(System.currentTimeMillis()));*/
    	}else{
    		role = new JdcAdpMstRole();
    		/*role.setCreatedBy(userLogin.getId());
    		role.setCreatedDate(new Date(System.currentTimeMillis()));*/
    	}
    	
    	role.setName(model.getName());
    	role.setDescription(model.getDescription());
    	
    	saveOrUpdate(role);
    	model.setId(role.getId());
    	
    	if (!checked.isEmpty()){
	        @SuppressWarnings("unchecked")
			List<JdcAdpMstComponent> components = sessionFactory.getCurrentSession()
	        		.createCriteria(JdcAdpMstComponent.class)
	            	.add(Restrictions.in("id", checked))
	        		.list();
	        
	        for(JdcAdpMstComponent component : components){
	        	JdcAdpMstRoledetail roledetail = new JdcAdpMstRoledetail();
	        	roledetail.setRole(role);
	        	roledetail.setComponent(component);
	        	roledetail.setCreatedBy(userLogin.getId());
	        	roledetail.setCreatedDate(new Date(System.currentTimeMillis()));
	        	
	        	sessionFactory.getCurrentSession().save(roledetail);
	        }
    	}
        
    }
}
