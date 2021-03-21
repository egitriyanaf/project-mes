/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.controller.samplereport;

import com.agit.common.ParamPaging;
import com.agit.controller.BaseController;
import com.agit.entity.JdcAdpTxnrpph;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ridwans
 */
@Controller
@RequestMapping("/sr-rpt/pph")
public class AdpReportPphController extends BaseController {

	final static String MENU = "REPORT_SAMPLE";
    final static String PRIVILEDGE = "REPORT_PPH";
    private String BASE_VIEW = "08.sample-report/";
    private String LIST_VIEW = "adppph";

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
     * @param session
     * @param request
     * @param param
     * @return
     */
    @RequestMapping(value = "/get-report-pph", method = RequestMethod.POST)
    public @ResponseBody
    List<JdcAdpTxnrpph> getReport(HttpSession session, HttpServletRequest request, @RequestBody ParamPaging param) {
        Map<String, Object> searchMap = param.getSearch();
        List<JdcAdpTxnrpph> data = adpReportPphService.getDataReport(searchMap);
        return data;
    }

    private void putIntoRequest(Model model) {
        model.addAttribute("SELECTED_MENU", MENU);
        model.addAttribute("SELECTED_SUBMENU", PRIVILEDGE);
    }

}
