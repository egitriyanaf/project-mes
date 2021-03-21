/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.controller.samplereport;

import com.agit.common.ParamPaging;
import com.agit.controller.BaseController;
import com.agit.controller.sample.model.AdpScannerModel;
import com.project.common.DataTables;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ridwans
 */
@Controller
@RequestMapping("/sr-rpt/scanner")
public class AdpReportScannerController extends BaseController {

    final static String MENU = "REPORT_SAMPLE";
    final static String PRIVILEDGE = "REPORT_SCAN";
    private String BASE_VIEW = "08.sample-report/";
    private String LIST_VIEW = "adpscanner";

    /**
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/")
    public String index(Model model, HttpSession session) {

        if (getPriviledgeUser(session, PRIVILEDGE, VIEW)) {
//            model.addAttribute("dptId", getDptIdFromSession(session));
            putIntoRequest(model);

            return BASE_VIEW + LIST_VIEW;
        }

        return getUnauthorizedPage();
    }

    /**
     *
     * @param dataTables
     * @param fullname
     * @param nik
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/search")
    public @ResponseBody
    DataTables search(DataTables dataTables, @RequestParam(required = false) String fullname,
            @RequestParam(required = false) String nik, HttpSession session, HttpServletRequest request) {

        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("fullname", fullname);
        searchMap.put("nik", nik);

        DataTables dt = adminService.searchByMapCriteria(dataTables, searchMap);
        return dt;
    }

    /**
     *
     * @param session
     * @param request
     * @param param
     * @return
     */
    @RequestMapping(value = "/get-data-scan", method = RequestMethod.POST)
    public @ResponseBody
    List<AdpScannerModel> getProduct(HttpSession session, HttpServletRequest request,
            @RequestBody ParamPaging param) {
        Map<String, Object> searchMap = param.getSearch();
        if ((String) searchMap.get("dptId") != null) {
            Long nDptId = new Long((String) searchMap.get("dptId"));
            searchMap.put("dptId", nDptId);
        }
        if ((String) searchMap.get("scanDate") != null) {
            String nScanDate = (String) searchMap.get("scanDate");
        }
        List<AdpScannerModel> data = adpBarcodeService.getDashboardAbsen(searchMap);
        return data;
    }

    private void putIntoRequest(Model model) {
        model.addAttribute("listDepartement", adpDepartementService.getPcc());
        model.addAttribute("SELECTED_MENU", MENU);
        model.addAttribute("SELECTED_SUBMENU", PRIVILEDGE);
    }

}
