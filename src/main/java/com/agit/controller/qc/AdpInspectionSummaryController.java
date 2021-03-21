/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.controller.qc;

import com.agit.common.ParamPaging;
import com.agit.controller.BaseController;
import com.agit.controller.qc.model.AdpProduksiModel;
import com.agit.entity.JdcAdpMstlookup;
import com.agit.entity.JdcAdpMstproduksi;
import com.agit.entity.JdcAdpTxnLogsummary;
import com.agit.services.AdpParamConfigService;
import com.agit.util.DateUtil;
import com.project.common.AjaxResponse;
import com.project.common.DataTables;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
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
import org.apache.commons.io.IOUtils;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author TriAA
 */
@Controller
@RequestMapping("/qc/inspectionsummary")
public class AdpInspectionSummaryController extends BaseController {

    final static String MENU = "QC";
    final static String PRIVILEDGE = "INSP_SUMM";
    private String BASE_VIEW = "04.qc/";
    private String LIST_VIEW = "adpinspection";
    private String DETAILS_VIEW = "adpinspection-detail";

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
            List<JdcAdpMstproduksi> listNscvs = adpProduksiService.findBynCVS("");
            model.addAttribute("listNscvs", listNscvs);
            putIntoRequest(model);

            return BASE_VIEW + LIST_VIEW;
        }

        return getUnauthorizedPage();
    }

    /**
     *
     * @param dataTables
     * @param lineCode
     * @param poNo
     * @param poItem
     * @return
     */
    @RequestMapping("/search")
    public @ResponseBody
    DataTables search(DataTables dataTables, @RequestParam String lineCode,
            @RequestParam String poNo, @RequestParam String poItem) {

        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("lineCode", lineCode);
        searchMap.put("poNo", poNo);
        searchMap.put("poItem", poItem);

        return adpLogSummaryService.searchByMapCriteria(dataTables, searchMap);
    }
    
    /**
     *
     * @param dataTables
     * @param lineCode
     * @param poNo
     * @param poItem
     * @return
     */
    @RequestMapping("/search-dtl")
    public @ResponseBody
    DataTables searchDtl(DataTables dataTables, @RequestParam String lineCode,
            @RequestParam String poNo, @RequestParam String poItem) {

        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("lineCode", lineCode);
        searchMap.put("poNo", poNo);
        searchMap.put("poItem", poItem);

        return adpLogSummaryDtlService.searchByMapCriteria(dataTables, searchMap);
    }

    /**
     *
     * @param param
     * @param session
     * @return
     */
    @RequestMapping(value = "/get-ncvs", method = RequestMethod.POST)
    public @ResponseBody
    List<JdcAdpMstproduksi> getProduct(@RequestBody ParamPaging param, HttpSession session) {
        Map<String, Object> searchMap = param.getSearch();
        List<JdcAdpMstproduksi> data = adpProduksiService.findByLineCode(searchMap);
        return data;
    }

    /**
     *
     * @param param
     * @param session
     * @return
     */
    @RequestMapping(value = "/get-po-item", method = RequestMethod.POST)
    public @ResponseBody
    List<JdcAdpMstproduksi> getPoItem(@RequestBody ParamPaging param, HttpSession session) {
        Map<String, Object> searchMap = param.getSearch();
        List<JdcAdpMstproduksi> data = adpProduksiService.findPoItemByNcvs(searchMap);
        return data;
    }

    /**
     *
     * @param param
     * @param session
     * @return
     */
    @RequestMapping(value = "/get-po-no", method = RequestMethod.POST)
    public @ResponseBody
    List<JdcAdpMstproduksi> getPoNo(@RequestBody ParamPaging param, HttpSession session) {
        Map<String, Object> searchMap = param.getSearch();
        List<JdcAdpMstproduksi> data = adpProduksiService.findPoNoByNcvs(searchMap);
        return data;
    }

    /**
     *
     * @param param
     * @param session
     * @return
     */
    @RequestMapping(value = "/get-retrieve-data", method = RequestMethod.POST)
    public @ResponseBody
    List<AdpProduksiModel> retrieveData(@RequestBody ParamPaging param, HttpSession session) {
        Map<String, Object> searchMap = param.getSearch();
        List<AdpProduksiModel> data = adpProduksiService.retrieveData(searchMap);
        return data;
    }

    /**
     *
     * @param param
     * @param session
     * @return
     */
    @RequestMapping(value = "/get-list-data", method = RequestMethod.POST)
    public @ResponseBody
    List<JdcAdpTxnLogsummary> retrieveListData(@RequestBody ParamPaging param,
            HttpSession session) {
        Map<String, Object> searchMap = param.getSearch();
        List<JdcAdpTxnLogsummary> data = adpLogSummaryService.retrieveData(searchMap);
        return data;
    }

    /**
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    AjaxResponse save(@RequestBody AdpProduksiModel model, HttpSession session) {
//        adpLogSummaryService.deleteLines(model);
        adpLogSummaryService.save(model, getLoginSecUser(session));
        adpLogSummaryDtlService.deleteLines(model);
        adpLogSummaryDtlService.save(model, getLoginSecUser(session));
        adpProduksiService.save(model, getLoginSecUser(session));
        return new AjaxResponse(model);
    }

    /**
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/submit", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    AjaxResponse submit(@RequestBody AdpProduksiModel model, HttpSession session) {
        adpLogSummaryService.deleteLines(model);//ini delete buat apa?
        adpLogSummaryService.submit(model, getLoginSecUser(session));
        adpLogSummaryDtlService.deleteLines(model);//ini delete buat apa?
        adpLogSummaryDtlService.submit(model, getLoginSecUser(session));
        adpProduksiService.submit(model, getLoginSecUser(session));
        return new AjaxResponse(model);
    }

    /**
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/save-remark", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    AjaxResponse saveRemark(@RequestBody AdpProduksiModel model, HttpSession session) {
        adpProduksiService.saveRemark(model, getLoginSecUser(session));
        return new AjaxResponse(model);
    }

    /**
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/details")
    public String create(Model model, HttpSession session) {
        return BASE_VIEW + DETAILS_VIEW;
    }

    private void putIntoRequest(Model model) {
        model.addAttribute("listIssueType", genericService.lookup(JdcAdpMstlookup.LOOKUP_ISSUE_TYPE));
        model.addAttribute("listSizeType", genericService.lookup("QC_INS"));
        model.addAttribute("SELECTED_MENU", MENU);
        model.addAttribute("SELECTED_SUBMENU", PRIVILEDGE);
    }

    /**
     *
     * @param line_code
     * @param po_no
     * @param po_item
     * @param request
     * @param params
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/{line_code}/{po_no}/{po_item}", method = RequestMethod.GET)
    public void downloadReportInspectionSummary(@PathVariable String line_code, @PathVariable String po_no,
            @PathVariable String po_item, HttpServletRequest request, Map<String, String> params,
            HttpServletResponse response) throws Exception {
        HashMap<String, Object> searchMap = new HashMap<>();
        Connection conn = sessionFactory.getSessionFactoryOptions().getServiceRegistry(). getService(ConnectionProvider.class).getConnection();
        // databeans
        searchMap.put("ncvs", line_code);
        searchMap.put("poNo", po_no);
        searchMap.put("poItem", po_item);

//        List<AdpInspectionLogSummaryReportModel> dataBeans = adpLogSummaryService.getDataReport(searchMap);

        List<AdpProduksiModel> data = adpProduksiService.retrieveData(searchMap);
        String desc = "";
        String joppic = "";
        String gac = "";
        String qty = "";
        String city = "";
        String diamondMk = "";
        String docDate = "";
        for (AdpProduksiModel list : data) {
            desc = list.getProductDesc();
            joppic = list.getJoPpic();
            gac = list.getGacDate().toString();
            qty = list.getQty().toString();
            city = list.getAddress1();
            diamondMk = list.getAddressLine();
            docDate = list.getSchStartdate().toString();
        }

        // Template report
        String dir = request.getSession().getServletContext().getRealPath("/template");

        // setDatabeans in list report
//        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeans);
        String name = "InspectionLogSummary.jrxml";
        String nameFile = "InspectionLogSummary_";
        String nameSubreport_1 = "SubInspectionLogSummary.jasper";
        String nameSubreport_2 = "SubInspectionLogSummaryImg.jasper";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("ncvs", line_code);
        parameters.put("po_item", po_item);
        parameters.put("po_no", po_no);
        parameters.put("product_desc", desc);
        parameters.put("material", joppic);
        parameters.put("gac_date", gac);
        parameters.put("qty", qty);
        parameters.put("city", city);
        parameters.put("diamond_mark", diamondMk);
        parameters.put("doc_date", docDate);
        parameters.put("created_by", "admin");
        parameters.put("path", dir);
        parameters.put("SUBREPORT_DIR_1", dir+ "/"+ nameSubreport_1);
        parameters.put("SUBREPORT_DIR_2", dir+ "/"+ nameSubreport_2);
        
        // compile report
        JasperReport jasperReport = JasperCompileManager.compileReport(dir + "/"+ name);
        // print report
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);

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
