/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.controller.samplereport;

import com.agit.controller.BaseController;
import static com.agit.controller.BaseController.VIEW;
import com.agit.controller.sample.model.AdpReportAbsenModel;
import com.agit.entity.JdcAdpMstlookup;
import com.agit.services.AdpParamConfigService;
import com.agit.util.DateUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.commons.io.IOUtils;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ridwans
 */
@Controller
@RequestMapping("/sr-rpt/greport")
public class AdpReportGnrController extends BaseController {

    final static String MENU = "REPORT_SAMPLE";
    final static String PRIVILEDGE = "REPORT_GNR";
    private String BASE_VIEW = "08.sample-report/";
    private String LIST_VIEW = "adpgnr";

    /**
     *
     */
    @Autowired
    protected AdpParamConfigService config;
    
    @Autowired
    SessionFactory sessionFactory;

    /**
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/")
    public String index(Model model, HttpSession session) {

        if (getPriviledgeUser(session, PRIVILEDGE, VIEW)) {
            model.addAttribute("listUserType", genericService.lookup(JdcAdpMstlookup.LOOKUP_USER_TYPE));
            putIntoRequest(model);
            return BASE_VIEW + LIST_VIEW;
        }

        return getUnauthorizedPage();
    }

    /**
     *
     * @param attendDate
     * @param request
     * @param params
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/{attendDate}", method = RequestMethod.GET)
    public void downloadReport(@PathVariable String attendDate, HttpServletRequest request, Map<String, String> params,
            HttpServletResponse response) throws Exception {
        Connection conn = sessionFactory.getSessionFactoryOptions().getServiceRegistry(). getService(ConnectionProvider.class).getConnection();
        // Template report
        String dir = request.getSession().getServletContext().getRealPath("/template");
        String name = "";
        String nameFile = "";
        InputStream inputStream = null;

        Map<String, Object> parameters = new HashMap<>();
        
            name = "ReportGeneralStatus.jrxml";
            nameFile = "ReportGeneralStatus_";   

        
        parameters.put("taping_date", attendDate);
        parameters.put("path", dir);
        // compile report
        JasperReport jasperReport = JasperCompileManager.compileReport(dir + "/" + name);
        // print report
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);

        String output = config.getDownloadDirectory();
        String fileName = nameFile + DateUtil.DateToString(new Date(), "ddMMyyyyHHmmss") + ".pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint, output + fileName);
        System.out.println("Done!");
        try {
            File fileToDownload = new File(output + '/' + fileName);
            System.out.println("Url " + fileToDownload);
            inputStream = new FileInputStream(fileToDownload);
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            IOUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
            inputStream.close();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            if (conn != null) {
                conn.close();
            }
        }

    }

    private void putIntoRequest(Model model) {
        model.addAttribute("SELECTED_MENU", MENU);
        model.addAttribute("SELECTED_SUBMENU", PRIVILEDGE);
    }

}
