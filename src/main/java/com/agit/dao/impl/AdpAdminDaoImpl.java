package com.agit.dao.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.RowCountProjection;
import org.hibernate.internal.CriteriaImpl;
import org.hibernate.internal.CriteriaImpl.OrderEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.common.DataTables;
import com.project.common.SortField;
import com.agit.entity.security.JdcAdpMstComponent;
import com.agit.entity.security.JdcAdpMstMenu;
import com.agit.entity.security.JdcAdpMstRole;
import com.agit.entity.security.JdcAdpMstRoledetail;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.entity.security.JdcAdpMstUserrole;
import com.agit.dao.AdpAdminDao;
import com.agit.dao.AdpGenericDao;

/**
 *
 * @author Ridwan
 */
@Repository
public class AdpAdminDaoImpl extends AdpBaseDao<JdcAdpMstUser> implements AdpAdminDao {

    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    AdpGenericDao genericDao;

    /**
     *
     * @param username
     * @return
     */
    @Override
    public JdcAdpMstUser getSecUser(String username) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstUser.class);
        criteria.add(Restrictions.eq("usrLogin", username));
        JdcAdpMstUser user = (JdcAdpMstUser) criteria.uniqueResult();
        JdcAdpMstUser jdcAdpMstUser = new JdcAdpMstUser();
        if (user != null) {
            jdcAdpMstUser = user;
            jdcAdpMstUser.setDptId(user.getDepartement() != null ? user.getDepartement().getId() : null);
        }
        return jdcAdpMstUser;
//        return (JdcAdpMstUser) sessionFactory.getCurrentSession().createQuery("from JdcAdpMstUser where usrLogin = :username")
//                .setParameter("username", username).uniqueResult();
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public JdcAdpMstUser getSecUser(Long id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstUser.class);
        criteria.add(Restrictions.eq("id", id));
        JdcAdpMstUser user = (JdcAdpMstUser) criteria.list().get(0);

        return user;
    }

    /**
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<String> getAllRights() {
        return sessionFactory.getCurrentSession().createSQLQuery("select menu_name from  jdcuam_mstmenu").list();
    }

    /**
     *
     * @param user
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<String> getRightsByUser(JdcAdpMstUser user) {
        return sessionFactory.getCurrentSession().createSQLQuery("select distinct m.menu_name "
                + "from  jdcuam_mstmenu m "
                + "inner join  jdcuam_mstcomponent c on c.menu_id = m.menu_id "
                + "inner join  jdcuam_mstroledtl rd on rd.menu_comp_id = c.menu_comp_id "
                + "inner join  jdcuam_mstrole r on r.role_id = rd.role_id "
                + "inner join  jdcuam_mstuserole ur on ur.role_id = r.role_id "
                + "where ur.user_id=:userId").setParameter("userId", user.getId()).list();
    }

    /**
     *
     * @param name
     * @param secUser
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<String> getMenuByName(String name, JdcAdpMstUser secUser) {
        return sessionFactory.getCurrentSession().createSQLQuery("select distinct m.menu_name "
                + "from  jdcuam_mstmenu m "
                + "inner join  jdcuam_mstcomponent c on c.menu_id = m.menu_id "
                + "inner join  jdcuam_mstroledtl rd on rd.menu_comp_id = c.menu_comp_id "
                + "inner join  jdcuam_mstrole r on r.role_id = rd.role_id "
                + "inner join  jdcuam_mstuserole ur on ur.role_id = r.role_id "
                + "where m.menu_name=:menuName and ur.user_id=:userId").setParameter("menuName", name)
                .setParameter("userId", secUser.getId()).list();
    }

    /**
     *
     * @param username
     */
    @Override
    public void resetFailAttempts(String username) {
        JdcAdpMstUser user = getSecUser(username);
        if (user != null) {
            //		user.setLoginAttempts(0);
            sessionFactory.getCurrentSession().save(user);
        }
    }

    /*@Override
	public void updateFailAttempts(String username, int maxRetry) {
		JdcAdpMstUser user = getSecUser(username);
		if(user != null){
			Integer attempts = user.getLoginAttempts();
			if(attempts == null){
				attempts = 0;
			}
			attempts++;
			user.setLoginAttempts(attempts);
			
			if(attempts >= maxRetry){
				user.setUsrStatus(Lookup.LOOKUP_USER_STATUS_TYPE_0);
			}
			
			sessionFactory.getCurrentSession().save(user);
		}
	}*/

    /**
     *
     * @return
     */

    @SuppressWarnings("unchecked")
    @Override
    public List<JdcAdpMstMenu> getAllParentMenu() {
        //return sessionFactory.getCurrentSession().createQuery("from JdcAdpMstMenu where parent is null  order by sequence ").list();
        return sessionFactory.getCurrentSession().createQuery("from JdcAdpMstMenu where parent is null  and enabled =:enabled order by sequence ").setParameter("enabled", 1).list();
    }

    /**
     *
     * @param parent
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<JdcAdpMstMenu> getChildMenuByParent(JdcAdpMstMenu parent) {
        //	return sessionFactory.getCurrentSession().createQuery("from JdcAdpMstMenu where parent = :parent  order by sequence ").setParameter("parent", parent).list();
        return sessionFactory.getCurrentSession().createQuery("from JdcAdpMstMenu where parent = :parent and enabled =:enabled order by sequence ").setParameter("parent", parent).setParameter("enabled", 1).list();
    }

    /**
     *
     * @param menu
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<JdcAdpMstComponent> getComponentByMenu(JdcAdpMstMenu menu) {
        return sessionFactory.getCurrentSession().createQuery("from JdcAdpMstComponent where menu = :menu").setParameter("menu", menu).list();
    }

    /**
     *
     * @param user
     * @param priviledge
     * @return
     */
    @SuppressWarnings("rawtypes")
    @Override
    public boolean getPriviledge(Long user, String priviledge) {
        List list = sessionFactory.getCurrentSession()
                .createSQLQuery("select 1 from  jdcuam_mstuser u "
                        + "inner join  jdcuam_mstuserole ur on ur.user_id = u.usr_id "
                        + "inner join  jdcuam_mstrole r on r.role_id = ur.role_id "
                        + "inner join  jdcuam_mstroledtl rd on rd.role_id = r.role_id "
                        + "inner join  jdcuam_mstcomponent c on c.menu_comp_id=rd.menu_comp_id "
                        + "inner join  jdcuam_mstmenu m on m.menu_id=c.menu_id "
                        + "where m.menu_name = :menuName "
                        + "and u.usr_id = :userId")
                .setParameter("menuName", priviledge).setParameter("userId", user).list();

        if (list.isEmpty()) {
            return false;
        }

        return true;
    }

    /**
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<JdcAdpMstRole> roles() {
        return sessionFactory.getCurrentSession()
                .createQuery("from JdcAdpMstRole").list();
    }

    /**
     *
     * @param userId
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<JdcAdpMstUserrole> listSecUserrole(Long userId) {
        return sessionFactory.getCurrentSession()
                .createQuery("from JdcAdpMstUserrole where user.id = :userId")
                .setParameter("userId", userId)
                .list();
    }

    /**
     *
     * @param roleId
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<JdcAdpMstRoledetail> listSecRoledetail(Long roleId) {
        return sessionFactory.getCurrentSession()
                .createQuery("from JdcAdpMstRoledetail where role.id = :roleId")
                .setParameter("roleId", roleId)
                .list();
    }

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked", "unused"})
    @Override
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap) {
        String usrLogin = (String) searchMap.get("usrLogin");
        String usrFirstName = (String) searchMap.get("usrFirstName");
        String usrLastName = (String) searchMap.get("usrLastName");
        String searchString = null;

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JdcAdpMstUser.class);

        if (StringUtils.isNotBlank(usrLogin)) {
            criteria.add(Restrictions.ilike("usrLogin", usrLogin, MatchMode.ANYWHERE));
        }

        if (StringUtils.isNotBlank(usrFirstName)) {
            criteria.add(Restrictions.ilike("usrFirstName", usrFirstName, MatchMode.ANYWHERE));
        }

        if (StringUtils.isNotBlank(usrLastName)) {
            criteria.add(Restrictions.ilike("usrLastName", usrLastName, MatchMode.ANYWHERE));
        }

        List<SortField> sortFields = dataTables.generateSortFields();
        for (SortField sf : sortFields) {
            if ("asc".equalsIgnoreCase(sf.getDirection())) {
                criteria.addOrder(Order.asc(sf.getField()));
            } else {
                criteria.addOrder(Order.desc(sf.getField()));
            }
        }

        List data = criteria.setFirstResult(dataTables.getiDisplayStart()).setMaxResults(dataTables.getiDisplayLength()).list();
        for (Object object : data) {
            JdcAdpMstUser user = (JdcAdpMstUser) object;
            String roles = null;

            List<JdcAdpMstUserrole> userroleList = listSecUserrole(user.getId());
            for (JdcAdpMstUserrole ur : userroleList) {
                if (StringUtils.isBlank(roles)) {
                    roles = "";
                } else {
                    roles += " - ";
                }
                roles += ur.getRole().getDescription();
            }

            user.setRoles(roles);;
            data.set(data.indexOf(object), user);
        }

        Long total = 0l;
        if (data != null) {
            Iterator<OrderEntry> orderIter = ((CriteriaImpl) criteria).iterateOrderings();
            while (orderIter.hasNext()) {
                orderIter.next();
                orderIter.remove();
            }
            total = (Long) criteria.setProjection(new RowCountProjection()).setFirstResult(0).uniqueResult();
        }
        return dataTables.extract(data, total);
    }

    /**
     *
     * @param user
     * @param priviledge
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<String> getComponent(Long user, String priviledge) {
        return sessionFactory.getCurrentSession().createSQLQuery("select distinct c.menu_comp_name "
                + "from  jdcuam_mstmenu m "
                + "inner join  jdcuam_mstcomponent c on c.menu_id = m.menu_id "
                + "inner join  jdcuam_mstroledtl rd on rd.menu_comp_id = c.menu_comp_id "
                + "inner join  jdcuam_mstrole r on r.role_id = rd.role_id "
                + "inner join  jdcuam_mstuserole ur on ur.role_id = r.role_id "
                + "where ur.user_id=:userId "
                + "and m.menu_name=:menu")
                .setParameter("userId", user)
                .setParameter("menu", priviledge).list();
    }

    /**
     *
     * @param user
     * @param menu
     * @param component
     * @return
     */
    @SuppressWarnings("rawtypes")
    @Override
    public boolean getPriviledge(Long user, String menu, String component) {
        List list = sessionFactory.getCurrentSession()
                .createSQLQuery("select 1 from  jdcuam_mstuser u "
                        + "inner join  jdcuam_mstuserole ur on ur.user_id = u.usr_id "
                        + "inner join  jdcuam_mstrole r on r.role_id = ur.role_id "
                        + "inner join  jdcuam_mstroledtl rd on rd.role_id = r.role_id "
                        + "inner join  jdcuam_mstcomponent c on c.menu_comp_id=rd.menu_comp_id "
                        + "inner join  jdcuam_mstmenu m on m.menu_id=c.menu_id "
                        + "where m.menu_name = :menuName "
                        + "and c.menu_comp_name = :compName "
                        + "and u.usr_id = :userId")
                .setParameter("menuName", menu).setParameter("compName", component).setParameter("userId", user).list();

        if (list.isEmpty()) {
            return false;
        }

        return true;
    }

    /**
     *
     * @param parenId
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Integer> getChildsUserIdList(Long parenId) {
        List<Integer> result = null;
        try {
            result = sessionFactory.getCurrentSession().createSQLQuery("select  user_tree(" + parenId + ")").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return result;
    }

}
