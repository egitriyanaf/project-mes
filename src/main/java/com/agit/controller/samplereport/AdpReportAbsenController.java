/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.controller.samplereport;

import com.agit.controller.BaseController;
import com.agit.controller.sample.model.AdpAbsenModel;
import com.agit.controller.sample.model.AdpCostCodeModel;
import com.agit.controller.sample.model.AdpReportAbsenModel;
import com.agit.services.AdpParamConfigService;
import com.agit.util.DateUtil;
import com.project.common.DataTables;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ridwans
 */
@Controller
@RequestMapping("/sr-rpt/absen")
public class AdpReportAbsenController extends BaseController {

    final static String MENU = "REPORT_SAMPLE";
    final static String PRIVILEDGE = "REPORT_ABSEN";
    private String BASE_VIEW = "08.sample-report/";
    private String LIST_VIEW = "adpabsen";

    /**
     *
     */
    @Autowired
    protected AdpParamConfigService config;

    /**
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/")
    public String index(Model model, HttpSession session) {

        if (getPriviledgeUser(session, PRIVILEDGE, VIEW)) {
            List<AdpCostCodeModel> absenGroup = adpAbsenService.groupCostCode();
            model.addAttribute("absenGroup", absenGroup);
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
     * @param department
     * @param attendDate
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/search")
    public @ResponseBody
    DataTables search(DataTables dataTables, @RequestParam(required = false) String fullname,
            @RequestParam(required = false) String nik, @RequestParam(required = false) String department,
            @RequestParam(required = false) String attendDate,
            HttpSession session, HttpServletRequest request) {

        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("fullname", fullname);
        searchMap.put("nik", nik);
        searchMap.put("department", department);
        searchMap.put("attendDate", attendDate);

        DataTables dt = adpAbsenService.searchByMapCriteria(dataTables, searchMap);
        return dt;
    }

    /**
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/get-dashboard-absen", method = RequestMethod.POST)
    public @ResponseBody
    List<AdpAbsenModel> getProduct(HttpSession session) {
        List<AdpAbsenModel> data = adpAbsenService.getDashboardAbsen();
        return data;
    }

    /**
     *
     * @param departemen
     * @param startDate
     * @param endDate
     * @param request
     * @param params
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/{departemen}/{startDate}/{endDate}", method = RequestMethod.GET)
    public void downloadReportAbsen(@PathVariable String departemen, @PathVariable String startDate,
            @PathVariable String endDate, HttpServletRequest request, Map<String, String> params,
            HttpServletResponse response) throws Exception {
        HashMap<String, Object> searchMap = new HashMap<>();
        // databeans
        searchMap.put("departemen", departemen);
        searchMap.put("startDate", startDate);
        searchMap.put("endDate", endDate);

        List<AdpReportAbsenModel> dataBeans = adpAbsenService.getDataReport(searchMap);

        // Template report
        String dir = request.getSession().getServletContext().getRealPath("/template");

        // setDatabeans in list report
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeans);

        String name = "rpt_absen.jrxml";
        String nameFile = "ReportAbsen";

        Map<String, Object> parameters = new HashMap<>();
        if (departemen.equals("0")) {
            parameters.put("departemen", "All");
        } else {
            parameters.put("departemen", departemen);
        }
        parameters.put("attend_date", endDate);
        parameters.put("title", "Report Absensi");

        // compile report
        JasperReport jasperReport = JasperCompileManager.compileReport(dir + "/" + name);
        // print report
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);

        String output = config.getDownloadDirectory();
        String fileName = nameFile + DateUtil.DateToString(new Date(), "ddMMyyyyHHmmss") + ".pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint, output + fileName);
        System.out.println("Done!");
        try {
            File fileToDownload = new File(output + '/' + fileName);
            System.out.println("Url " + fileToDownload);
            InputStream inputStream = new FileInputStream(fileToDownload);
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            IOUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
            inputStream.close();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }

    private void putIntoRequest(Model model) {
        model.addAttribute("SELECTED_MENU", MENU);
        model.addAttribute("SELECTED_SUBMENU", PRIVILEDGE);
    }

}
