package com.agit.controller.maintenance;

import com.agit.controller.BaseController;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author TriAA
 */
@Controller
@RequestMapping("/maintenance/template")
public class AdpMasterTemplateController extends BaseController {

    final static String MENU = "MNTC";
    final static String PRIVILEDGE = "TMPLT";
    private String BASE_VIEW = "07.maintenance/";
    private String LIST_VIEW = "adpTemplate";
    private String EDIT_VIEW = "adpTemplate-detail";

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
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/create")
    public String create(Model model, HttpSession session) {

        return BASE_VIEW + EDIT_VIEW;

    }

    private void putIntoRequest(Model model) {
        model.addAttribute("SELECTED_MENU", MENU);
        model.addAttribute("SELECTED_SUBMENU", PRIVILEDGE);
    }
}
