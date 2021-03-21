package com.agit.services;

import com.agit.controller.administration.model.AdpDptSearchModel;
import java.util.HashMap;
import java.util.List;

import com.project.common.DataTables;
import com.agit.controller.administration.model.AdpMenuModel;
import com.agit.controller.administration.model.AdpUserModel;
import com.agit.entity.security.JdcAdpMstRoledetail;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.entity.security.JdcAdpMstUserrole;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author erwin
 */
public interface AdpAdminService {

    /**
     *
     * @param secUser
     */
    public void saveOrUpdate(JdcAdpMstUser secUser);
	
    /**
     *
     * @param password
     * @return
     */
    public String encodePassword(String password);

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
     * @param secUser
     * @return
     */
    public List<AdpMenuModel> getAllMenuModel(JdcAdpMstUser secUser);
	
    /**
     *
     * @param secUser
     * @return
     */
    public List<AdpMenuModel> getAllMenuModelByUser(JdcAdpMstUser secUser);
        
    /**
     *
     * @param user
     * @param priviledge
     * @return
     */
    public boolean getPriviledge(Long user, String priviledge);

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
     * @param model
     * @param userLogin
     */
    public void saveSecUser(AdpUserModel model, JdcAdpMstUser userLogin);
	
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
     * @param id
     * @return
     */
    public List<Long> getChildsUserIdList(Long id);
        
    /**
     *
     * @param searchMap
     * @return
     */
    public List<AdpDptSearchModel> getDpt(Map<String, Object> searchMap);

}
