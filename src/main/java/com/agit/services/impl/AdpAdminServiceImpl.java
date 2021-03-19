package com.agit.services.impl;

import com.agit.controller.administration.model.AdpDptSearchModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.common.DataTables;
import com.agit.controller.administration.model.AdpMenuModel;
import com.agit.controller.administration.model.AdpStateModel;
import com.agit.controller.administration.model.AdpUserModel;
import com.agit.entity.security.JdcAdpMstComponent;
import com.agit.entity.security.JdcAdpMstMenu;
import com.agit.entity.security.JdcAdpMstRole;
import com.agit.entity.security.JdcAdpMstRoledetail;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.entity.security.JdcAdpMstUserrole;
import com.agit.util.StringUtils;
import com.agit.dao.AdpAdminDao;
import com.agit.dao.AdpInterfaceBaseDao;
import com.agit.entity.JdcAdpMstdepartement;
import com.agit.services.AdpAdminService;
import com.agit.services.AdpGenericService;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

/**
 *
 * @author erwin
 */
@Service
@Transactional(readOnly = true)
public class AdpAdminServiceImpl extends AdpAbstractServiceImpl<JdcAdpMstUser> implements AdpAdminService {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    private AdpAdminDao adminDao;

    /**
     *
     */
    @Autowired
    protected AdpGenericService genericService;

    /**
     *
     * @return
     */
    @Override
    public Class<JdcAdpMstUser> getRealClass() {
        return JdcAdpMstUser.class;
    }

    /**
     *
     * @return
     */
    @Override
    public AdpInterfaceBaseDao<JdcAdpMstUser> getDao() {
        return this.adminDao;
    }

    Md5PasswordEncoder encoder = new Md5PasswordEncoder();

    /**
     *
     * @param secUser
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveOrUpdate(JdcAdpMstUser secUser) {
        super.saveOrUpdate(secUser);
    }

    /**
     *
     * @param password
     * @return
     */
    @Override
    public String encodePassword(String password) {
        return encoder.encodePassword(password, null);
    }

    /**
     *
     * @param username
     * @return
     */
    @Override
    public JdcAdpMstUser getSecUser(String username) {
        return adminDao.getSecUser(username);
    }

    /**
     *
     * @return
     */
    @Override
    public List<String> getAllRights() {
        return adminDao.getAllRights();
    }

    /**
     *
     * @param user
     * @return
     */
    @Override
    public List<String> getRightsByUser(JdcAdpMstUser user) {
        return adminDao.getRightsByUser(user);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public JdcAdpMstUser getSecUser(Long id) {
        return adminDao.getSecUser(id);
    }

    /**
     *
     * @param username
     */
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void resetFailAttempts(String username) {
        adminDao.resetFailAttempts(username);
    }

    /**
     *
     * @param secUser
     * @return
     */
    @Override
    public List<AdpMenuModel> getAllMenuModel(JdcAdpMstUser secUser) {
        List<AdpMenuModel> menuModels = new ArrayList<AdpMenuModel>();

        List<JdcAdpMstMenu> parentMenu = adminDao.getAllParentMenu();
        for (JdcAdpMstMenu parent : parentMenu) {
            menuModels.add(generateMenuModel(parent, secUser));
        }

        return menuModels;
    }

    private AdpMenuModel generateMenuModel(JdcAdpMstMenu menu, JdcAdpMstUser secUser) {
        List<JdcAdpMstMenu> childs = adminDao.getChildMenuByParent(menu);
        List<JdcAdpMstComponent> components = adminDao.getComponentByMenu(menu);

        AdpMenuModel parentModel = new AdpMenuModel();
        parentModel.setMenu(menu);
        parentModel.setComponents(components);

        if (childs.size() > 0) {
            List<AdpMenuModel> childModelList = new ArrayList<AdpMenuModel>();
            for (JdcAdpMstMenu child : childs) {
                Collection<String> rights = adminDao.getMenuByName(child.getName(), secUser);
                if (rights.size() > 0) {
                    AdpMenuModel childModel = generateMenuModel((JdcAdpMstMenu) child, secUser);
                    childModelList.add(childModel);
                }

            }
            parentModel.setChilds(childModelList);
        }

        return parentModel;
    }

    /**
     *
     * @param secUser
     * @return
     */
    @Override
    public List<AdpMenuModel> getAllMenuModelByUser(JdcAdpMstUser secUser) {
        List<AdpMenuModel> menuModels = new ArrayList<AdpMenuModel>();

        List<JdcAdpMstMenu> parentMenu = adminDao.getAllParentMenu();
        for (JdcAdpMstMenu parent : parentMenu) {
            menuModels.add(generateMenuModel(parent));
        }

        return menuModels;
    }

    private AdpMenuModel generateMenuModel(JdcAdpMstMenu menu) {
        List<JdcAdpMstMenu> childs = adminDao.getChildMenuByParent(menu);
        List<JdcAdpMstComponent> components = adminDao.getComponentByMenu(menu);

        AdpMenuModel parentModel = new AdpMenuModel();
        parentModel.setMenu(menu);
        parentModel.setComponents(components);

        if (childs.size() > 0) {
            List<AdpMenuModel> childModelList = new ArrayList<AdpMenuModel>();
            for (Object child : childs) {
                AdpMenuModel childModel = generateMenuModel((JdcAdpMstMenu) child);
                childModelList.add(childModel);
            }
            parentModel.setChilds(childModelList);
        }

        return parentModel;
    }

    /**
     *
     * @param user
     * @param priviledge
     * @return
     */
    @Override
    public boolean getPriviledge(Long user, String priviledge) {
        return adminDao.getPriviledge(user, priviledge);
    }

    /**
     *
     * @param userId
     * @return
     */
    @Override
    public List<JdcAdpMstUserrole> listSecUserrole(Long userId) {
        return adminDao.listSecUserrole(userId);
    }

    /**
     *
     * @param roleId
     * @return
     */
    @Override
    public List<JdcAdpMstRoledetail> listSecRoledetail(Long roleId) {
        return adminDao.listSecRoledetail(roleId);
    }

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @Override
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap) {
        return adminDao.searchByMapCriteria(dataTables, searchMap);
    }

    /**
     *
     * @param model
     * @param userLogin
     */
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveSecUser(AdpUserModel model, JdcAdpMstUser userLogin) {

        List<Long> unchecked = new ArrayList<Long>();
        List<Long> checked = new ArrayList<Long>();
        for (AdpStateModel stateModel : model.getStates()) {
            if (stateModel.getId() != null) {
                if ("1".equals(stateModel.getState())) {
                    checked.add(stateModel.getId());
                } else if ("0".equals(stateModel.getState())) {
                    unchecked.add(stateModel.getId());
                }
            }
        }

        JdcAdpMstUser user = null;
        if (model.getId() != null) {

            // delete any unchecked mapping for the group
            List<Long> all = new ArrayList<Long>();
            all.addAll(checked);
            all.addAll(unchecked);
            if (all.size() > 0) {
                sessionFactory.getCurrentSession()
                        .createQuery("delete from JdcAdpMstUserrole where user.id = :userId and role.id in :all")
                        .setParameter("userId", model.getId()).setParameterList("all", all).executeUpdate();
            }

            user = (JdcAdpMstUser) adminDao.get(JdcAdpMstUser.class, model.getId());
            user.setLastUpdatedBy(userLogin.getId());
            user.setLastUpdatedDate(new Date(System.currentTimeMillis()));
        } else {
            user = new JdcAdpMstUser();
            user.setCreatedBy(userLogin.getId());
            user.setCreatedDate(new Date(System.currentTimeMillis()));

        }
        if (StringUtils.isNotEmpty(model.getUsrPassword())) {
            user.setUsrPassword(model.getUsrPassword());
        }

        user.setUsrLogin(model.getUsrLogin());
        user.setUsrFirstName(model.getUsrFirstName());
        user.setUsrLastName(model.getUsrLastName());
        user.setUsrEmail(model.getUsrEmail());
        user.setUsrPhone(model.getUsrPhone());
        user.setUsrType(model.getUsrType());
        user.setEnabled(model.getEnabled());
        user.setDptId(model.getDptId());
        adminDao.save(user);
        model.setId(user.getId());

        if (!checked.isEmpty()) {
            @SuppressWarnings("unchecked")
            List<JdcAdpMstRole> roles = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstRole.class)
                    .add(Restrictions.in("id", checked)).list();
            JdcAdpMstUserrole userrole = null;
            for (JdcAdpMstRole role : roles) {
                userrole = new JdcAdpMstUserrole();
                userrole.setUser(user);
                userrole.setRole(role);
                userrole.setCreatedBy(userLogin.getId());
                userrole.setCreatedDate(new Date(System.currentTimeMillis()));

                sessionFactory.getCurrentSession().save(userrole);
            }
        }
    }

    /**
     *
     * @param user
     * @param priviledge
     * @return
     */
    @Override
    public List<String> getComponent(Long user, String priviledge) {
        return adminDao.getComponent(user, priviledge);
    }

    /**
     *
     * @param user
     * @param menu
     * @param component
     * @return
     */
    @Override
    public boolean getPriviledge(Long user, String menu, String component) {
        return adminDao.getPriviledge(user, menu, component);
    }

    /**
     *
     * @param parenId
     * @return
     */
    @Override
    public List<Long> getChildsUserIdList(Long parenId) {
        List<Integer> res = adminDao.getChildsUserIdList(parenId);
        List<Long> result = null;
        ;
        if (res != null) {
            result = new ArrayList<Long>();
            for (Integer integer : res) {
                result.add(integer.longValue());
            }
        }
        return result;
    }

    /**
     *
     * @param searchMap
     * @return
     */
    @Override
    public List<AdpDptSearchModel> getDpt(Map<String, Object> searchMap) {
        String dptName = (String) searchMap.get("dptName");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstdepartement.class);
        if (StringUtils.isNotEmpty(dptName)) {
            criteria.add(Restrictions.ilike("dptName", dptName, MatchMode.ANYWHERE));
        }
        criteria.setMaxResults(10);
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("id"), "dptId")
                .add(Projections.property("dptName"), "dptName")
                .add(Projections.property("dptCode"), "dptCode")
                .add(Projections.groupProperty("id"))).setResultTransformer(Transformers.aliasToBean(AdpDptSearchModel.class));
        return criteria.list();
    }
}
