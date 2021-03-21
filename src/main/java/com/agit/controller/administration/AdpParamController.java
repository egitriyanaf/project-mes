package com.agit.controller.administration;

import java.net.URLDecoder;
import java.util.HashMap;

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
import com.agit.entity.JdcAdpMstlookup;
import com.agit.entity.JdcAdpFndparams;

/**
 *
 * @author Ridwan
 */
@Controller
@RequestMapping("/administration/param")
public class AdpParamController extends BaseController {

	final static String MENU = "ADMINISTRATION";
	final static String PRIVILEDGE = "PARAM_CONFIG";
	String BASE_VIEW = "02.administration/";
	String LIST_VIEW = "adpparam";
	String EDIT_VIEW = "adpparam-edit";

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
	public @ResponseBody DataTables search(DataTables dataTables, @RequestParam String name) {

		HashMap<String, Object> searchMap = new HashMap<>();
		searchMap.put("name", name);

		return paramConfigService.searchByMapCriteria(dataTables, searchMap);
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

			JdcAdpFndparams conf = paramConfigService.findById(id);
			model.addAttribute("conf", conf);
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
    @RequestMapping(value = "/save", method = RequestMethod.POST, headers = { "content-type=application/json" })
	public @ResponseBody AjaxResponse save(@RequestBody JdcAdpFndparams model, HttpSession session) {

		paramConfigService.saveParamConfig(model, getLoginSecUser(session));

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
	public @ResponseBody AjaxResponse checkExisting(@RequestBody String name, HttpSession session) {
		String param = URLDecoder.decode(name).replace("=", "");
		// LOOKUP
		String returnVal = paramConfigService.checkExistingByCode(param);
		return new AjaxResponse(returnVal);
	}

	private void putIntoRequest(Model model) {
		model.addAttribute("SELECTED_MENU", MENU);
		model.addAttribute("SELECTED_SUBMENU", PRIVILEDGE);
		model.addAttribute("listAppType", genericService.lookup(JdcAdpMstlookup.LOOKUP_APP_TYPE));
	}
}
