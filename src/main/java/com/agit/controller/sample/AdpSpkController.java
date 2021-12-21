/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.controller.sample;

import com.agit.controller.BaseController;
import com.project.common.DataTables;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ridwans
 */
@Controller
@RequestMapping("/sr/spk")
public class AdpSpkController extends BaseController {

    final static String MENU = "SAMPLE_ROOM";
    final static String PRIVILEDGE = "SPK";
    private String BASE_VIEW = "03.sample/";
    private String LIST_VIEW = "adpspk";

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
     * @param startDate
     * @param season
     * @param category
     * @param sample
     * @param sampleReq
     * @param endDate
     * @param etcStart
     * @param etcEnd
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/search")
    public @ResponseBody
    DataTables search(DataTables dataTables, @RequestParam String startDate, @RequestParam String season,
            @RequestParam String category, @RequestParam String sample, @RequestParam String sampleReq,
            @RequestParam String endDate, @RequestParam String etcStart, @RequestParam String etcEnd,
            @RequestParam String itemNumber, @RequestParam String workOrderNumber,
            HttpSession session, HttpServletRequest request) {
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("startDate", startDate);
        searchMap.put("endDate", endDate);
        searchMap.put("etcStart", etcStart);
        searchMap.put("etcEnd", etcEnd);
        searchMap.put("season", season);
        searchMap.put("category", category);
        searchMap.put("sample", sample);
        searchMap.put("sampleReq", sampleReq);
        searchMap.put("itemNumber", itemNumber);
        searchMap.put("workOrderNumber", workOrderNumber);
        DataTables dt = adpSpkService.searchByMapCriteria(dataTables, searchMap);
        return dt;
    }

    private void putIntoRequest(Model model) {
        model.addAttribute("SELECTED_MENU", MENU);
        model.addAttribute("SELECTED_SUBMENU", PRIVILEDGE);
    }
}
