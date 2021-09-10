package com.agit.controller.qc;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.agit.common.ParamPaging;
import com.agit.controller.BaseController;
import com.agit.controller.qc.model.AdpQcCounterModel;
import com.agit.entity.JdcAdpMstlookup;
import com.agit.entity.JdcAdpMstproduksi;
import com.agit.entity.JdcAdpTxnqcctrl;
import com.agit.services.AdpParamConfigService;
import com.project.common.AjaxResponse;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Ridwan
 */
@Controller
@RequestMapping("/qc/hourlyinspection")
public class AdpHourlyInspectionController extends BaseController {

    final static String MENU = "QC";
    final static String PRIVILEDGE = "HI";
    private String BASE_VIEW = "04.qc/";
    private String LIST_VIEW = "adphourlyinspection";

    /**
     *
     */
    @Autowired
    protected AdpParamConfigService config;
    
    /**
     *
     * @param model
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/")
    public String index(Model model, HttpSession session, HttpServletRequest request) {
        if (getPriviledgeUser(session, PRIVILEDGE, VIEW)) {
            List<JdcAdpMstproduksi> listNscvs = adpProduksiService.findBynCVS("");
            List<JdcAdpTxnqcctrl> sumBarcode = adpHourlyInspectionService.countAGrade(getLoginSecUser(session)); //To Count A Grade
            model.addAttribute("sumBarcode", sumBarcode.size());
            model.addAttribute("dptId", getDptIdFromSession(session));
            model.addAttribute("dptName", getUsrTypeFromSession(session));
            model.addAttribute("listNscvs", listNscvs);
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
    @RequestMapping(value = "/get-ncvs", method = RequestMethod.POST)
    public @ResponseBody
    List<JdcAdpMstproduksi> getLineCode(@RequestBody ParamPaging param, HttpSession session, HttpServletRequest request) {
        Map<String, Object> searchMap = param.getSearch();
        List<JdcAdpMstproduksi> data = adpProduksiService.findByLineCode(searchMap);
        return data;
    }
    
    /**
     *
     * @param param
     * @param session
     * @param request
     * @return
     */
    @RequestMapping(value = "/get-ncvs-new", method = RequestMethod.POST)//modify erwin
    public @ResponseBody
    List<JdcAdpMstproduksi> getLineCodeNew(@RequestBody ParamPaging param, HttpSession session, HttpServletRequest request) {
        Map<String, Object> searchMap = param.getSearch();
        String poItem = (String) searchMap.get("poItem");
        String poNo = (String) searchMap.get("poNo");
        String demand = (String) searchMap.get("demand");
        List<JdcAdpMstproduksi> data = adpProduksiService.findByLineCodeNew(searchMap);
        return data;
    }
    
    /**
     *
     * @param param
     * @param session
     * @param request
     * @return
     */
    @RequestMapping(value = "/get-pon", method = RequestMethod.POST)
    public @ResponseBody
    List<JdcAdpMstproduksi> getPoNo(@RequestBody ParamPaging param, HttpSession session, HttpServletRequest request) {
        Map<String, Object> searchMap = param.getSearch();
//        String demand = (String) searchMap.get("demand");
//        String ncvs = (String) searchMap.get("ncvs");
//        List<JdcAdpMstproduksi> data = adpProduksiService.findPoNoOk(searchMap);
        List<JdcAdpMstproduksi> data = adpProduksiService.findPoNoFrst(searchMap);
        return data;
    }

    /**
     *
     * @param param
     * @param session
     * @param request
     * @return
     */
    @SuppressWarnings("unused")
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public @ResponseBody
    List<JdcAdpMstproduksi> getProduct(@RequestBody ParamPaging param, HttpSession session, HttpServletRequest request) {
        Map<String, Object> searchMap = param.getSearch();
        String ncvs = (String) searchMap.get("ncvs");
        List<JdcAdpMstproduksi> product = adpProduksiService.findProductNoProductDesc(searchMap);
        return product;
    }
    
    /**
     *
     * @param param
     * @param session
     * @param request
     * @return
     */
    @SuppressWarnings("unused")
    @RequestMapping(value = "/po_item", method = RequestMethod.POST)
    public @ResponseBody
    List<JdcAdpMstproduksi> getPoItem(@RequestBody ParamPaging param, HttpSession session, HttpServletRequest request) {
        Map<String, Object> searchMap = param.getSearch();
        String poNo = (String) searchMap.get("poNo");
        List<JdcAdpMstproduksi> PoItem = adpProduksiService.findProductByPO(searchMap);
        return PoItem;
    }
    
    /**
     *
     * @param param
     * @param session
     * @param request
     * @return
     */
    @SuppressWarnings("unused")
    @RequestMapping(value = "/po_item_new", method = RequestMethod.POST)
    public @ResponseBody
    List<JdcAdpMstproduksi> getPoItemNew(@RequestBody ParamPaging param, HttpSession session, HttpServletRequest request) {
        Map<String, Object> searchMap = param.getSearch();
        String ncvs = (String) searchMap.get("ncvs");
        String poNo = (String) searchMap.get("poNo");
        String demand = (String) searchMap.get("demand");
        List<JdcAdpMstproduksi> PoItem = adpProduksiService.findPoItemByNcvsNew(searchMap);
        return PoItem;
    }

    /**
     *
     * @param param
     * @param session
     * @param request
     * @return
     */
    @RequestMapping(value = "/defect", method = RequestMethod.POST)
    public @ResponseBody
    List<JdcAdpMstlookup> getChart(@RequestBody ParamPaging param, HttpSession session, HttpServletRequest request) {
        Map<String, Object> filters = param.getSearch();
        String value = (String) filters.get("value");
        List<JdcAdpMstlookup> getDefect = adpHourlyInspectionService.getAllDefectByLogin(getLoginSecUser(session), value);
        return getDefect;
    }

    /**
     *
     * @param model
     * @param session
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    AjaxResponse save(@RequestBody JdcAdpTxnqcctrl model, HttpSession session, HttpServletRequest request) throws Exception {
        adpHourlyInspectionService.save(model, getLoginSecUser(session));
        return new AjaxResponse(model);
    }

    /**
     *
     * @param param
     * @param model
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/counter")
    public @ResponseBody
    List<JdcAdpTxnqcctrl> getCounter(@RequestBody ParamPaging param, Model model, HttpSession session, HttpServletRequest request) {
        List<JdcAdpTxnqcctrl> counter = adpHourlyInspectionService.findByCategory(getLoginSecUser(session));
        return counter;
    }

    /**
     *
     * @param param
     * @param session
     * @return
     */
    @RequestMapping(value = "/get-demandClass", method = RequestMethod.POST)//modify by erwin
    public @ResponseBody
    List<JdcAdpMstproduksi> getDemandClass(@RequestBody ParamPaging param, HttpSession session) {
        Map<String, Object> searchMap = param.getSearch();
        String poNo = (String) searchMap.get("poNo");
        String poItem = (String) searchMap.get("poItem");
        List<JdcAdpMstproduksi> data = adpProduksiService.findByDemandClass(searchMap);
        return data;
    }
    
    /**
     *
     * @param param
     * @param session
     * @return
     */
    @RequestMapping(value = "/get-demandClassNew", method = RequestMethod.POST)
    public @ResponseBody
    List<JdcAdpMstproduksi> getDemandClassNew(@RequestBody ParamPaging param, HttpSession session) {
        Map<String, Object> searchMap = param.getSearch();
        String ncvs = (String) searchMap.get("ncvs");
        List<JdcAdpMstproduksi> data = adpProduksiService.findByDemandClassNew(searchMap);
        return data;
    }

    /**
     *
     * @param session
     * @param param
     * @param request
     * @return
     */
    @RequestMapping("/get-countfullgrade")
    public @ResponseBody
    Integer getCountFullGrade(HttpSession session, @RequestBody ParamPaging param, HttpServletRequest request) {
        List<JdcAdpTxnqcctrl> sumGrade = adpHourlyInspectionService.countAGrade(getLoginSecUser(session));
        if (sumGrade.size() > 0) {
            return sumGrade.size();
        } else {
            return 0;
        }
    }

    /**
     *
     * @param param
     * @param session
     * @return
     */
    @RequestMapping(value = "/get-counter-all", method = RequestMethod.POST)
    public @ResponseBody
    AdpQcCounterModel getAllCounter(@RequestBody ParamPaging param, HttpSession session) {
        Map<String, Object> searchMap = param.getSearch();
        AdpQcCounterModel data = new AdpQcCounterModel();
        AdpQcCounterModel header = adpHourlyInspectionService.getAllCounter(getLoginSecUser(session), searchMap);
        AdpQcCounterModel detail = adpHourlyInspectionService.getDetailCounter(getLoginSecUser(session), searchMap);
        data.setCounter(header.getCounter());
        data.setAgrade(detail.getAgrade());
        data.setBgrade(detail.getBgrade());
        data.setCgrade(detail.getCgrade());
        data.setRewok(detail.getRewok());
        data.setPembagi(detail.getPembagi());
//        data.setDptName(detail.getDptName());
        return data;
    }
    
    /**
     *
     * @param param
     * @param session
     * @return
     */
    @RequestMapping(value = "/get-counter-new", method = RequestMethod.POST)
    public @ResponseBody
    AdpQcCounterModel getAllCounterNew(@RequestBody ParamPaging param, HttpSession session) {
        Map<String, Object> searchMap = param.getSearch();
        AdpQcCounterModel data = new AdpQcCounterModel();
        AdpQcCounterModel header = adpHourlyInspectionService.getAllCounterNew(getLoginSecUser(session), searchMap);
        AdpQcCounterModel detail = adpHourlyInspectionService.getDetailCounter(getLoginSecUser(session), searchMap);
        data.setCounter(header.getCounter());
        data.setAgrade(detail.getAgrade());
        data.setBgrade(detail.getBgrade());
        data.setCgrade(detail.getCgrade());
        data.setRewok(detail.getRewok());
//        data.setDptName(detail.getDptName());
        return data;
    }

    private void putIntoRequest(Model model) {
        model.addAttribute("SELECTED_MENU", MENU);
        model.addAttribute("SELECTED_SUBMENU", PRIVILEDGE);
    }

    
}
