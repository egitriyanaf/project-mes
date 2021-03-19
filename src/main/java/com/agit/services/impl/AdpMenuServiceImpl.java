package com.agit.services.impl;

import com.agit.controller.administration.model.AdpDptSearchModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.common.DataTables;
import com.agit.controller.administration.model.AdpMstMenuModel;
import com.agit.entity.JdcAdpMstMenuTbl;
import com.agit.entity.security.JdcAdpMstMenu;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.services.AdpMenuService;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

/**
 *
 * @author erwin
 */
@Service
@Transactional(readOnly = true)
public class AdpMenuServiceImpl extends AdpSimpleServiceImpl<JdcAdpMstMenu> implements AdpMenuService {

	@Autowired
	SessionFactory sessionFactory;

    /**
     *
     * @return
     */
    @Override
	public Class<JdcAdpMstMenu> getRealClass() {
		return JdcAdpMstMenu.class;
	}

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @Override
	public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap) {
		String name = (String) searchMap.get("name");
		Long parentId = (Long) searchMap.get("parentId");
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstMenu.class);
		if (StringUtils.isNotBlank(name)) {
			criteria.add(Restrictions.ilike("name", name, MatchMode.ANYWHERE));
		}
		if (parentId != null) {
			criteria.add(Restrictions.isNull("parent.id"));
		}
		return getDataTablesFromCriteria(criteria, dataTables);
	}

    /**
     *
     * @param model
     * @param userLogin
     */
    @Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void saveSecRole(AdpMstMenuModel model, JdcAdpMstUser userLogin) {
		JdcAdpMstMenu menu = null;
		if (model.getId() != null) {
			menu = findById(model.getId());

		} else {
			menu = new JdcAdpMstMenu();
		}
//		String parenta = model.getParentId().toString();
		JdcAdpMstMenu parent = findById(model.getParentId());
		menu.setParent(parent);
		menu.setEnabled(model.getEnabled());
		menu.setName(model.getName());
		menu.setDescription(model.getDescription());
		menu.setParentName(model.getParentName());
		menu.setSequence(model.getSequence());
		menu.setUrl(model.getUrl());
		menu.setIcon(model.getIcon());

		saveOrUpdate(menu);
		model.setId(menu.getId());

	}

    /**
     *
     * @param param
     * @return
     */
    @SuppressWarnings("unchecked")
	@Override
	public String checkExistingByCode(String param) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstMenu.class);
		criteria.add(Restrictions.eq("name", param).ignoreCase());

		List<JdcAdpMstMenu> sts = criteria.list();
		if (!sts.isEmpty()) {
			return "Y";
		}
		return "N";
	}

    /**
     *
     * @param filters
     * @return
     */
    @Override
	public String checkExistingBySequence(Map<String, Object> filters) {
		String sequenceNo = (String) filters.get("sequenceNo");
		String parentId = (String) filters.get("parentId");
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstMenu.class);
		if (StringUtils.isNotBlank(sequenceNo)) {
			Integer value = Integer.parseInt(sequenceNo);
			criteria.add(Restrictions.eq("sequence", value));
		}
		if (StringUtils.isNotBlank(parentId)) {
			Long value = Long.valueOf(parentId);
			criteria.add(Restrictions.eq("parent.id", value));
		} else {
			criteria.add(Restrictions.isNull("parent.id"));
		}
		JdcAdpMstMenu menu = (JdcAdpMstMenu) criteria.uniqueResult();
		if(menu != null){
			return "Y";
		}
		return "N";
	}

    /**
     *
     * @param filters
     * @return
     */
    @Override
	public JdcAdpMstMenu checkExistingBySequenceLast(Map<String, Object> filters) {
		String parentId = (String) filters.get("parentId");
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstMenu.class);
		if (StringUtils.isNotBlank(parentId)) {
			Long value = Long.valueOf(parentId);
			criteria.add(Restrictions.eq("parent.id", value));
		} else {
			criteria.add(Restrictions.isNull("parent.id"));
		}
		criteria.addOrder(Order.desc("sequence"));
		criteria.setMaxResults(1);
		
		JdcAdpMstMenu menu = (JdcAdpMstMenu) criteria.uniqueResult();
		if(menu != null){
			return menu;
		}
		return null;
	}
     
    // erwin g setiawan
    /**
     *
     * @param searchMap
     * @return
     */
    @Override
    public List<AdpMstMenuModel> searchParentMenu(Map<String, Object> searchMap) {
		String parentName = (String) searchMap.get("parentName");
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstMenuTbl.class);
                if (StringUtils.isNotEmpty(parentName)) {
                    criteria.add(Restrictions.ilike("menuDesc", parentName, MatchMode.ANYWHERE));
                    criteria.add(Restrictions.isNull("menuParentId"));
//                    criteria.add(Projections.distinct(projectionList.add(Projections.property("distinctColumn"), "distinctColumn")));
                }
//		if (StringUtils.isNotBlank(parentName)) {
//			Long value = Long.valueOf(parentName);
//			criteria.add(Restrictions.eq("parent.name", value));
//		} else {
//			criteria.add(Restrictions.isNull("parent.name"));
//		}
//		criteria.addOrder(Order.desc("sequence"));
		criteria.setMaxResults(10);
                criteria.setProjection(Projections.projectionList()
                        .add(Projections.property("id"), "parentId")//filed model, filed di js
                        .add(Projections.property("menuDesc"), "parentName")
                        .add(Projections.groupProperty("id"))
                        .add(Projections.groupProperty("menuDesc"))).setResultTransformer(Transformers.aliasToBean(AdpMstMenuModel.class));
                return criteria.list();
	}

}
