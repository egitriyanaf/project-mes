package com.agit.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.project.common.DataTables;
import com.agit.entity.security.JdcAdpMstComponent;
import com.agit.entity.security.JdcAdpMstMenu;
import com.agit.entity.security.JdcAdpMstRole;
import com.agit.entity.security.JdcAdpMstRoledetail;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.entity.security.JdcAdpMstUserrole;

/**
 *
 * @author Ridwan
 */
public interface AdpAdminDao extends AdpInterfaceBaseDao<JdcAdpMstUser> {

    /**
     *
     * @param username
     * @return
     */
    public JdcAdpMstUser getSecUser(String username);

    /**
     *
     * @param id
     * @return
     */
    public JdcAdpMstUser getSecUser(Long id);

    /**
     *
     * @return
     */
    public List<String> getAllRights();

    /**
     *
     * @param user
     * @return
     */
    public List<String> getRightsByUser(JdcAdpMstUser user);

    /**
     *
     * @param username
     */
    public void resetFailAttempts(String username);

    /**
     *
     * @return
     */
    public List<JdcAdpMstMenu> getAllParentMenu();

    /**
     *
     * @param parent
     * @return
     */
    public List<JdcAdpMstMenu> getChildMenuByParent(JdcAdpMstMenu parent);

    /**
     *
     * @param menu
     * @return
     */
    public List<JdcAdpMstComponent> getComponentByMenu(JdcAdpMstMenu menu);

    /**
     *
     * @param user
     * @param priviledge
     * @return
     */
    public boolean getPriviledge(Long user, String priviledge);

    /**
     *
     * @return
     */
    public List<JdcAdpMstRole> roles();

    /**
     *
     * @param userId
     * @return
     */
    public List<JdcAdpMstUserrole> listSecUserrole(Long userId);

    /**
     *
     * @param roleId
     * @return
     */
    public List<JdcAdpMstRoledetail> listSecRoledetail(Long roleId);

    /**
     *
     * @param dataTables
     * @param searchMap
     * @return
     */
    public DataTables searchByMapCriteria(DataTables dataTables, HashMap<String, Object> searchMap);

    /**
     *
     * @param user
     * @param priviledge
     * @return
     */
    public List<String> getComponent(Long user, String priviledge);

    /**
     *
     * @param user
     * @param menu
     * @param component
     * @return
     */
    public boolean getPriviledge(Long user, String menu, String component);

    /**
     *
     * @param parenId
     * @return
     */
    public List<Integer> getChildsUserIdList(Long parenId);

    /**
     *
     * @param name
     * @param secUser
     * @return
     */
    public Collection<String> getMenuByName(String name, JdcAdpMstUser secUser);

}
