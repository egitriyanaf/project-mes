package com.agit.controller.sample;

import com.agit.controller.BaseController;
import static com.agit.controller.BaseController.EDIT;
import com.agit.controller.sample.model.AdpStockModel;
import com.agit.controller.sample.model.AdpStockTransferReportModel;
import com.agit.entity.JdcAdpMstlookup;
import com.agit.entity.JdcAdpMstspk;
import com.agit.entity.JdcAdpTxnstock;
import com.agit.services.AdpParamConfigService;
import com.agit.util.DateUtil;
import com.project.common.AjaxResponse;
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
@RequestMapping("/sr/stocktransfer")
public class AdpStockTransferController extends BaseController {

    final static String MENU = "SAMPLE_ROOM";
    final static String PRIVILEDGE = "STCK_TNF_SMPL";
    private String BASE_VIEW = "03.sample/";
    private String HOME = "adpstock";
    private String EDIT_VIEW = "adpstock-edit";
    
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

            putIntoRequest(model);

            return BASE_VIEW + HOME;
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
            model.addAttribute("spk_id", id);
            putIntoRequest(model);

            return BASE_VIEW + EDIT_VIEW;
        }

        return getUnauthorizedPage();
    }

    /**
     *
     * @param dataTables
     * @param sampleReq
     * @param spkId
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/searchDetail")
    public @ResponseBody
    DataTables searchDetail(DataTables dataTables, @RequestParam String sampleReq,@RequestParam Long spkId,
            HttpSession session, HttpServletRequest request) {
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("sampleReq", sampleReq);
        searchMap.put("spkId", spkId);
        DataTables dt = adpStockTransferService.searchByMapCriteria(dataTables, searchMap);
        return dt;
    }

    /**
     *
     * @param dataTables
     * @param sampleReq
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/search")
    public @ResponseBody
    DataTables search(DataTables dataTables, @RequestParam String sampleReq,
            HttpSession session, HttpServletRequest request) {
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("sampleReq", sampleReq);
        DataTables dt = adpStockTransferService.searchByMapCriteriaByGroup(dataTables, searchMap);
        return dt;
    }

    /**
     *
     * @param param
     * @param session
     * @return
     */
    @RequestMapping(value = "/get-samplereq", method = RequestMethod.POST)
    public @ResponseBody
    List<JdcAdpMstspk> getSampleReq(@RequestBody String param, HttpSession session) {
        List<JdcAdpMstspk> data = adpStockTransferService.findBySampleReq(param);
        return data;
    }
    
    /**
     *
     * @param param
     * @param session
     * @return
     */
    @RequestMapping(value = "/get-stock", method = RequestMethod.POST)
    public @ResponseBody
    List<AdpStockModel> getStock(@RequestBody String param, HttpSession session) {
        List<AdpStockModel> data = adpStockTransferService.getStock(param);
        return data;
    }

    /**
     *
     * @param model
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    AjaxResponse save(@RequestBody JdcAdpTxnstock model, HttpSession session) throws Exception {
        adpStockTransferService.saveTransfer(model, getLoginSecUser(session));
        return new AjaxResponse(model);
    }

    /**
     *
     * @param model
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/return", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    AjaxResponse returnQty(@RequestBody JdcAdpTxnstock model, HttpSession session) throws Exception {
        adpStockTransferService.returnTransfer(model, getLoginSecUser(session));
        return new AjaxResponse(model);
    }
    
    /**
     *
     * @param param
     * @param session
     * @return
     */
    @RequestMapping(value = "/get-remaining-qty", method = RequestMethod.POST)
    public @ResponseBody
    List<AdpStockModel> getRemainingQty(@RequestBody Long param, HttpSession session) {
        List<AdpStockModel> data = adpStockTransferService.getRemainingQty(param);
        return data;
    }

    private void putIntoRequest(Model model) {
        model.addAttribute("listRemarkType", genericService.lookup(JdcAdpMstlookup.LOOKUP_REMARK_TYPE));
        model.addAttribute("SELECTED_MENU", MENU);
        model.addAttribute("SELECTED_SUBMENU", PRIVILEDGE);
    }
    
    /**
     *
     * @param startDate
     * @param endDate
     * @param request
     * @param params
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/{startDate}/{endDate}", method = RequestMethod.GET)
    public void downloadReportStockTransfer(@PathVariable String startDate,
            @PathVariable String endDate, HttpServletRequest request, Map<String, String> params,
            HttpServletResponse response) throws Exception {
        HashMap<String, Object> searchMap = new HashMap<>();
        // databeans
        searchMap.put("startDate", startDate);
        searchMap.put("endDate", endDate);

        List<AdpStockTransferReportModel> dataBeans = adpStockTransferService.getDataReport(searchMap);

        // Template report
        String dir = request.getSession().getServletContext().getRealPath("/template");

        // setDatabeans in list report
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeans);

        String name = "StockTransferMovement.jrxml";
        String nameFile = "StockTransfer";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("tgl_awal", startDate);
        parameters.put("tgl_akhir", endDate);
        parameters.put("path", dir);
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
