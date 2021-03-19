/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.controller.samplereport;

import com.agit.common.ParamPaging;
import com.agit.controller.BaseController;
import com.agit.controller.sample.model.AdpDailyDefectQCAssemblyReportModel;
import com.agit.controller.sample.model.AdpDailyDefectQCPreparationReportModel;
import com.agit.controller.sample.model.AdpDailyDefectQCSewingReportModel;
import com.agit.controller.sample.model.AdpQualityRateModel;
import com.agit.entity.JdcAdpTxnqcctrl;
import com.agit.services.AdpParamConfigService;
import com.agit.util.DateUtil;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.agit.services.AdpQualityRateService;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author ridwans
 */
@Controller
@RequestMapping("/sr-rpt/qrate")
public class AdpReportQrController extends BaseController {

    final static String MENU = "REPORT_SAMPLE";
    final static String PRIVILEDGE = "REPORT_QR";
    private String BASE_VIEW = "08.sample-report/";
    private String LIST_VIEW = "adpqrate";

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
            List<JdcAdpTxnqcctrl> datas = adpQualityRateService.getListProductCode();
            model.addAttribute("productCode", datas);
            putIntoRequest(model);

            return BASE_VIEW + LIST_VIEW;
        }

        return getUnauthorizedPage();
    }

    /**
     *
     * @param param
     * @param session
     * @param request
     * @return
     */
    @RequestMapping(value = "get-report-qualityrate", method = RequestMethod.POST)
    public @ResponseBody
    List<AdpQualityRateModel> getProduct(@RequestBody ParamPaging param, HttpSession session, HttpServletRequest request) {
        Map<String, Object> searchMap = param.getSearch();
        List<AdpQualityRateModel> data = adpQualityRateService.getreportQualityRate(searchMap);
        return data;
    }

    private void putIntoRequest(Model model) {
        model.addAttribute("SELECTED_MENU", MENU);
        model.addAttribute("SELECTED_SUBMENU", PRIVILEDGE);
    }
    
    /**
     *
     * @param ncvs
     * @param startDate
     * @param endDate
     * @param supervisor
     * @param request
     * @param params
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/{ncvs}/{startDate}/{endDate}/{supervisor}", method = RequestMethod.GET)
    public void downloadReportHourlyInspectionDefect(@PathVariable String ncvs,
            @PathVariable String startDate,@PathVariable String endDate, @PathVariable String supervisor, HttpServletRequest request, Map<String, String> params,
            HttpServletResponse response) throws Exception {
        HashMap<String, Object> searchMap = new HashMap<>();
        // databeans
        searchMap.put("ncvs", ncvs);
        searchMap.put("startDate", startDate);
        searchMap.put("endDate", endDate);
        searchMap.put("supervisor", supervisor);
        
        JRBeanCollectionDataSource beanColDataSource;
        String name;
        String nameFile;
        
        if (supervisor == "assembly") {
            List<AdpDailyDefectQCAssemblyReportModel> dataBeans = adpQualityRateService.getDataReportAssembly(searchMap);
            beanColDataSource = new JRBeanCollectionDataSource(dataBeans);
            name = "DailyDefectQCAssembly.jrxml";
            nameFile = "StockTransfer";
        } else if (supervisor == "sewing") {
            List<AdpDailyDefectQCSewingReportModel> dataBeans = adpQualityRateService.getDataReportSewing(searchMap);
            beanColDataSource = new JRBeanCollectionDataSource(dataBeans);
            name = "DailyDefectQCSewing.jrxml";
            nameFile = "StockTransfer";
        } else {
            List<AdpDailyDefectQCPreparationReportModel> dataBeans = adpQualityRateService.getDataReportPreparation(searchMap);
            beanColDataSource = new JRBeanCollectionDataSource(dataBeans);
            name = "DailyDefectQCPreparation.jrxml";
            nameFile = "StockTransfer";
        }

        // Template report
        String dir = request.getSession().getServletContext().getRealPath("/template");

        // setDatabeans in list report
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("ncvs", ncvs);
        parameters.put("starDate", startDate);
        parameters.put("endDate", endDate);
        parameters.put("supervisor", supervisor);


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
}
