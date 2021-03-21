/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.controller.sample;

import com.agit.controller.BaseController;


import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ridwans
 */
@Controller
@RequestMapping("/sr/dashboard")
public class AdpDashboardSrController extends BaseController {

    final static String MENU = "SAMPLE_ROOM";
    final static String PRIVILEDGE = "DASHBOARD_AS";
    private String BASE_VIEW = "03.sample/";
    private String LIST_VIEW = "adpdashboard";

    /**
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/")
    public String index(Model model, HttpSession session) {

        if (getPriviledgeUser(session, PRIVILEDGE, VIEW)) {
            model.addAttribute("dptId", getDptIdFromSession(session));
            putIntoRequest(model);

            return BASE_VIEW + LIST_VIEW;
        }

        return getUnauthorizedPage();
    }
     
    private void putIntoRequest(Model model) {
        model.addAttribute("SELECTED_MENU", MENU);
        model.addAttribute("SELECTED_SUBMENU", PRIVILEDGE);
    }
}
