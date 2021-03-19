package com.agit.controller.administration;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

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
import com.agit.common.ParamPaging;
import com.agit.controller.BaseController;
//import com.agit.controller.administration.model.AdpDptSearchModel;
import com.agit.controller.administration.model.AdpMstMenuModel;
import com.agit.controller.administration.model.AdpSequenceMenuModel;
import com.agit.controller.administration.model.AdpMenuModel;
import com.agit.entity.JdcAdpMstMenuTbl;
import com.agit.entity.JdcAdpMstlookup;
import com.agit.entity.security.JdcAdpMstMenu;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Ridwan
 */
@Controller
@RequestMapping("/administration/menu")
public class AdpMenuController extends BaseController {

    final static String MENU = "ADMINISTRATION";
    final static String PRIVILEDGE = "MENU";
    String BASE_VIEW = "02.administration/";
    String LIST_VIEW = "adpmenu";
    String EDIT_VIEW = "adpmenu-edit";

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
     * @param name
     * @return
     */
    @RequestMapping("/search")
    public @ResponseBody
    DataTables search(DataTables dataTables, @RequestParam String name) {

        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("name", name);

        return menuService.searchByMapCriteria(dataTables, searchMap);
    }
    
    @RequestMapping("/search-menu")
    public @ResponseBody
    List<AdpMstMenuModel> searchmenu(@RequestBody ParamPaging param, HttpSession session, HttpServletRequest request) {
        Map<String, Object> searchMap = param.getSearch();
        List<AdpMstMenuModel> dpt = menuService.searchParentMenu(searchMap);// getDpt(searchMap);
        return dpt;

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
            JdcAdpMstMenu menu = menuService.findById(null);
            model.addAttribute("menu", menu);
            model.addAttribute("flagNew", "Y");
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

            JdcAdpMstMenu menu = menuService.findById(id);
            model.addAttribute("menu", menu);
            model.addAttribute("flagNew", "N");
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
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    AjaxResponse save(@RequestBody AdpMstMenuModel model, HttpSession session) {

        menuService.saveSecRole(model, getLoginSecUser(session));
        if (model.getFlagNew().equals("Y")) {
            componentService.save(model, getLoginSecUser(session));
        }

        return new AjaxResponse(model);
    }

    /**
     *
     * @param name
     * @param session
     * @return
     */
    @SuppressWarnings("deprecation")
    @RequestMapping(value = "/checkExisting", method = RequestMethod.POST)
    public @ResponseBody
    AjaxResponse checkExisting(@RequestBody String name,
            HttpSession session) {
        String param = URLDecoder.decode(name).replace("=", "");
        //LOOKUP
        String returnVal = menuService.checkExistingByCode(param);
        return new AjaxResponse(returnVal);
    }
    
    /**
     *
     * @param param
     * @param session
     * @return
     */
    @RequestMapping(value = "/checkExistingSequence", method = RequestMethod.POST)
    public @ResponseBody
    AjaxResponse checkExistingSequence(@RequestBody ParamPaging param,
            HttpSession session) {
        //LOOKUP
    	Map<String, Object> filters = param.getSearch();
    	AdpSequenceMenuModel returnVal = new AdpSequenceMenuModel();
        String menu = menuService.checkExistingBySequence(filters);
        JdcAdpMstMenu last = menuService.checkExistingBySequenceLast(filters);
        returnVal.setFlag(menu);
        
        if(last == null){
        	returnVal.setLastSequence(0);
        }else{
        	returnVal.setLastSequence(last.getSequence());
        }
        
        return new AjaxResponse(returnVal);
    }

    private void putIntoRequest(Model model) {
         model.addAttribute("SELECTED_MENU", MENU);
        model.addAttribute("SELECTED_SUBMENU", PRIVILEDGE);
        model.addAttribute("listIcons", genericService.lookup(JdcAdpMstlookup.LOOKUP_MASTER_ICONS));
        model.addAttribute("listTypeMenu", genericService.lookup(JdcAdpMstlookup.LOOKUP_TYPE_MENU));
        model.addAttribute("listOfStatus", genericService.lookup(JdcAdpMstlookup.LOOKUP_USER_STATUS_TYPE));
    }
}
