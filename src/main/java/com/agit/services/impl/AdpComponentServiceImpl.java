package com.agit.services.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.common.DataTables;
import com.agit.controller.administration.model.AdpMstMenuModel;
import com.agit.entity.security.JdcAdpMstComponent;
import com.agit.entity.security.JdcAdpMstMenu;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.services.AdpComponentService;
import com.agit.services.AdpMenuService;

/**
 *
 * @author erwin
 */
@Service
@Transactional(readOnly = true)
public class AdpComponentServiceImpl extends AdpSimpleServiceImpl<JdcAdpMstComponent> implements AdpComponentService {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	AdpMenuService menuService;

    /**
     *
     * @return
     */
    @Override
	public Class<JdcAdpMstComponent> getRealClass() {
		return JdcAdpMstComponent.class;
	}

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @Override
	public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstComponent.class);
		return getDataTablesFromCriteria(criteria, dataTables);
	}

    /**
     *
     * @param model
     * @param user
     */
    @Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void save(AdpMstMenuModel model, JdcAdpMstUser user) {
		JdcAdpMstComponent comp = null;
		Set<JdcAdpMstComponent> data = new HashSet<JdcAdpMstComponent>();
		for (int i = 0; i < 4; i++) {
			if (model.getTypeMenu().equalsIgnoreCase("menu")) {
				if (i == 0) {
					comp = new JdcAdpMstComponent();
					JdcAdpMstMenu menu = menuService.findById(model.getId());
					comp.setMenu(menu);
					comp.setDescription("VIEW");
					comp.setName("VIEW");
					data.add(comp);
					saveOrUpdate(comp);
				}
			} else {
				if (i == 0) {
					comp = new JdcAdpMstComponent();
					JdcAdpMstMenu menu = menuService.findById(model.getId());
					comp.setMenu(menu);
					comp.setDescription("VIEW");
					comp.setName("VIEW");
					data.add(comp);
					saveOrUpdate(comp);
				}
				if (i == 1) {
					comp = new JdcAdpMstComponent();
					JdcAdpMstMenu menu = menuService.findById(model.getId());
					comp.setMenu(menu);
					comp.setDescription("NEW");
					comp.setName("NEW");
					data.add(comp);
					saveOrUpdate(comp);
				}
				if (i == 2) {
					comp = new JdcAdpMstComponent();
					JdcAdpMstMenu menu = menuService.findById(model.getId());
					comp.setMenu(menu);
					comp.setDescription("EDIT");
					comp.setName("EDIT");
					data.add(comp);
					saveOrUpdate(comp);
				}
				if (i == 3) {
					comp = new JdcAdpMstComponent();
					JdcAdpMstMenu menu = menuService.findById(model.getId());
					comp.setMenu(menu);
					comp.setDescription("DELETE");
					comp.setName("DELETE");
					data.add(comp);
					saveOrUpdate(comp);
				}
			}
		}
		model.setId(model.getId());

	}

    /**
     *
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
	@Override
	public List<JdcAdpMstComponent> findByMenuId(Long id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstComponent.class);
		criteria.add(Restrictions.eq("menu.id", id));
		return criteria.list();
	}

}
