package com.agit.controller.administration;

import com.agit.common.ParamPaging;
import com.agit.controller.administration.model.AdpUserModel;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.common.AjaxResponse;
import com.project.common.DataTables;
import com.agit.controller.BaseController;
import com.agit.controller.administration.model.AdpDptSearchModel;
import com.agit.entity.JdcAdpMstlookup;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.util.StringUtils;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ridwan
 */
@Controller
@RequestMapping("/administration/user")
public class AdpUserController extends BaseController {

    final static String MENU = "ADMINISTRATION";
    final static String PRIVILEDGE = "USER_MANAGEMENT";
    private String BASE_VIEW = "02.administration/";
    private String LIST_VIEW = "adpuser";
    private String EDIT_VIEW = "adpuser-edit";

    /**
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/")
    public String index(Model model, HttpSession session) {

        if (getPriviledgeUser(session, PRIVILEDGE, VIEW)) {

            putIntoRequest(model);

            return BASE_VIEW + LIST_VIEW;
        }

        return getUnauthorizedPage();
    }

    /**
     *
     * @param dataTables
     * @param usrLogin
     * @param usrFirstName
     * @param usrLastName
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/search")
    public @ResponseBody
    DataTables search(DataTables dataTables,
            @RequestParam(required = false) String usrLogin,
            @RequestParam(required = false) String usrFirstName,
            @RequestParam(required = false) String usrLastName,
            HttpSession session, HttpServletRequest request) {

        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("usrLogin", usrLogin);
        searchMap.put("usrFirstName", usrFirstName);
        searchMap.put("usrLastName", usrLastName);

        DataTables dt = adminService.searchByMapCriteria(dataTables, searchMap);
        return dt;
    }

    /**
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/create")
    public String create(Model model, HttpSession session) {

        if (getPriviledgeUser(session, PRIVILEDGE, NEW)) {

            model.addAttribute("listRole", roleService.list());
            putIntoRequest(model);

            return BASE_VIEW + EDIT_VIEW;
        }

        return getUnauthorizedPage();
    }

    /**
     *
     * @param id
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model, HttpSession session) {

        if (getPriviledgeUser(session, PRIVILEDGE, EDIT)) {

            JdcAdpMstUser user = adminService.getSecUser(id);

            model.addAttribute("user", user);
            model.addAttribute("listUserrole", adminService.listSecUserrole(id));
            model.addAttribute("listRole", roleService.list());

            putIntoRequest(model);

            return BASE_VIEW + EDIT_VIEW;
        }

        return getUnauthorizedPage();
    }

    /**
     *
     * @param model
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    AjaxResponse save(@RequestBody AdpUserModel model, HttpSession session) throws Exception {

//        JdcAdpMstUser findUser = adminService.getSecUser(model.getUsrLogin());
//        if (model.getId() != null && StringUtils.hasValue(findUser)) {
//            return new AjaxResponse(false, "Username is already exists !");
//        }
        if (StringUtils.isNotEmpty(model.getUsrPassword())) {
            model.setUsrPassword(adminService.encodePassword(model.getUsrPassword()));
        }

        adminService.saveSecUser(model, getLoginSecUser(session));

        return new AjaxResponse(model);
    }

    /**
     *
     * @param param
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/search-dpt")
    public @ResponseBody
    List<AdpDptSearchModel> searchaddress(@RequestBody ParamPaging param, HttpSession session, HttpServletRequest request) {
        Map<String, Object> searchMap = param.getSearch();
        List<AdpDptSearchModel> dpt = adminService.getDpt(searchMap);
        return dpt;

    }

    private void putIntoRequest(Model model) {
        model.addAttribute("SELECTED_MENU", MENU);
        model.addAttribute("SELECTED_SUBMENU", PRIVILEDGE);
        model.addAttribute("listPositionType", genericService.lookup(JdcAdpMstlookup.LOOKUP_POSITION_TYPE));
        model.addAttribute("listUserStatus", genericService.lookup(JdcAdpMstlookup.LOOKUP_USER_STATUS_TYPE));
        model.addAttribute("listUserType", genericService.lookup(JdcAdpMstlookup.LOOKUP_USER_TYPE));
    }

}
