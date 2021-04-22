/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.controller.operator;

import com.agit.common.ParamPaging;
import com.agit.controller.BaseController;
import com.agit.controller.mail.MailMail;
import com.agit.controller.operator.model.AdpLotOperatorModel;
import com.agit.controller.qc.model.AdpProduksiModel;
import com.agit.entity.JdcAdpMstproduksi;
import com.project.common.AjaxResponse;
import com.project.common.DataTables;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
 * @author ridwan m
 */
@Controller
@RequestMapping("/operator/lotbasis")
public class AdpLotOperatorController extends BaseController {

    final static String MENU = "OPERATOR";
    final static String PRIVILEDGE = "LOT_OPT";
    private String BASE_VIEW = "06.operator/";
    private String HOME = "adplotoperator";
    private String DETAIL_OTHERS = "adplotoperator-oth-detail";
    private String HOME_MANAGER = "adplotoperator_manager";
    private String DETAIL_MANAGER = "adplotoperator-detail";
    private String DETAIL_CT_IN = "adplotoperator-ct-detail-in";
    private String DETAIL_CT_OUT = "adplotoperator-ct-detail-out";
    private String DETAIL_PREP_IN = "adplotoperator-prep-detail-in";
    private String DETAIL_PREP_OUT = "adplotoperator-prep-detail-out";
    private String DETAIL_ST_IN = "adplotoperator-st-detail-in";
    private String DETAIL_ST_OUT = "adplotoperator-st-detail-out";
    private String DETAIL_AS_IN = "adplotoperator-as-detail-in";
    private String DETAIL_AS_OUT = "adplotoperator-as-detail-out";
    private String EXPRESS = "adpkanban";

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
            if (getUsrTypeFromSession(session).equalsIgnoreCase(MANAGER)) {
                return BASE_VIEW + HOME_MANAGER;
            } else {
                return BASE_VIEW + HOME;
            }

        }

        return getUnauthorizedPage();
    }

    /**
     *
     * @param dataTables
     * @param poItem
     * @param lineCode
     * @param poNo
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/search")
    public @ResponseBody
    DataTables search(DataTables dataTables, @RequestParam(required = false) String poItem,
            @RequestParam(required = false) String lineCode, @RequestParam(required = false) String poNo, HttpSession session, HttpServletRequest request) {

        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("flagUpload", 1l);
        searchMap.put("poNo", poNo);
        searchMap.put("poItem", poItem);
        searchMap.put("ncvs", lineCode);

        DataTables dt = adpProduksiService.searchByMapCriteria(dataTables, searchMap);
        return dt;
    }

    /**
     *
     * @param dataTables
     * @param poItem
     * @param poNo
     * @param ncvs
     * @param demandClass
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/searchLotBasis")
    public @ResponseBody
    DataTables searchLotBasis(DataTables dataTables, @RequestParam(required = false) String poItem,
            @RequestParam(required = false) String poNo, 
            @RequestParam(required = false) String ncvs,
            @RequestParam(required = false) String demandClass,
            HttpSession session, HttpServletRequest request) {

        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("poItem", poItem);
        searchMap.put("poNo", poNo);
        searchMap.put("ncvs", ncvs);
        searchMap.put("demandClass", demandClass);
        DataTables dt = adpLotOperatorService.searchByMapCriteria(dataTables, searchMap);
        return dt;
    }

    /**
     *
     * @param ncvs
     * @param po
     * @param item
     * @param type
     * @param departement
     * @param demandclass
     * @param codeDemand
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/detail/{ncvs}/{po}/{item}/{type}/{departement}/{demandclass}/{codeDemand}")
    public String create(@PathVariable String ncvs, @PathVariable String po, @PathVariable String item, @PathVariable String type,
            @PathVariable String departement, @PathVariable String demandclass,@PathVariable String codeDemand,
            Model model, HttpSession session) {
        if (getPriviledgeUser(session, PRIVILEDGE, EDIT)) {
            String bucket = demandclass+"/"+codeDemand;
            AdpProduksiModel produksi = adpProduksiService.findByLotBasis(ncvs, po, item, bucket);
            model.addAttribute("produksi", produksi);
            model.addAttribute("userType", getUsrTypeFromSession(session));
            model.addAttribute("departement", departement);
            model.addAttribute("type", type);
            putIntoRequest(model);
            if (type.equalsIgnoreCase("in")) {
                if (departement.equalsIgnoreCase("Cutting")) {
                    return BASE_VIEW + DETAIL_CT_IN;
                } else if (departement.equalsIgnoreCase("Preparation")) {
                    return BASE_VIEW + DETAIL_PREP_IN;
                } else if (departement.equalsIgnoreCase("Stiching")) {
                    return BASE_VIEW + DETAIL_ST_IN;
                } else if (departement.equalsIgnoreCase("Assembly")) {
                    return BASE_VIEW + DETAIL_AS_IN;
                } else {
                    return BASE_VIEW + DETAIL_OTHERS;
                } 
                
//                else if (departement.equalsIgnoreCase("CSC")) {
//                    return BASE_VIEW + DETAIL_CT_IN;
//                } else if (departement.equalsIgnoreCase("No Sew")) {
//                    return BASE_VIEW + DETAIL_CT_IN;
//                } else if (departement.equalsIgnoreCase("Subcon")) {
//                    return BASE_VIEW + DETAIL_CT_IN;
//                } else if (departement.equalsIgnoreCase("OutSole")) {
//                    return BASE_VIEW + DETAIL_CT_IN;
//                } 
//                else if (departement.equalsIgnoreCase("Stiching")) {
//                    return BASE_VIEW + DETAIL_ST_IN;
//                } else if (departement.equalsIgnoreCase("Assembly")) {
//                    return BASE_VIEW + DETAIL_AS_IN;
//                }
            } else {
                if (departement.equalsIgnoreCase("Cutting")) {
                    return BASE_VIEW + DETAIL_CT_OUT;
                } else if (departement.equalsIgnoreCase("Preparation")) {
                    return BASE_VIEW + DETAIL_PREP_OUT;
                } else if (departement.equalsIgnoreCase("Stiching")) {
                    return BASE_VIEW + DETAIL_ST_OUT;
                } else if (departement.equalsIgnoreCase("Assembly")) {
                    return BASE_VIEW + DETAIL_AS_OUT;
                } else {
                    return BASE_VIEW + DETAIL_OTHERS;
                }
//                else if (departement.equalsIgnoreCase("CSC")) {
//                    return BASE_VIEW + DETAIL_CT_OUT;
//                } else if (departement.equalsIgnoreCase("No Sew")) {
//                    return BASE_VIEW + DETAIL_CT_OUT;
//                } else if (departement.equalsIgnoreCase("Subcon")) {
//                    return BASE_VIEW + DETAIL_CT_OUT;
//                } else if (departement.equalsIgnoreCase("OutSole")) {
//                    return BASE_VIEW + DETAIL_CT_OUT;
//                } else if (departement.equalsIgnoreCase("Stiching")) {
//                    return BASE_VIEW + DETAIL_ST_OUT;
//                } else if (departement.equalsIgnoreCase("Assembly")) {
//                    return BASE_VIEW + DETAIL_AS_OUT;
//                }
            }
        }

        return getUnauthorizedPage();
    }

    /**
     *
     * @param ncvs
     * @param po
     * @param item
     * @param demandclass
     * @param codeDemand
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/detail/{ncvs}/{po}/{item}/{demandclass}/{codeDemand}")
    public String edit(@PathVariable String ncvs, @PathVariable String po, @PathVariable String item, 
            @PathVariable String demandclass,@PathVariable String codeDemand,
            Model model, HttpSession session) {
        if (getPriviledgeUser(session, PRIVILEDGE, EDIT)) {
            String bucket = demandclass+"/"+codeDemand;
            AdpProduksiModel produksi = adpProduksiService.findByLotBasis(ncvs, po, item, bucket);
            model.addAttribute("produksi", produksi);
            model.addAttribute("userType", getUsrTypeFromSession(session));
            putIntoRequest(model);

            return BASE_VIEW + DETAIL_MANAGER;
        }

        return getUnauthorizedPage();
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
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/approve-in", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    AjaxResponse approveIn(@RequestBody AdpLotOperatorModel model, HttpSession session) {

        adpLotOperatorService.approveIn(model, getLoginSecUser(session));

        return new AjaxResponse(model);
    }

    /**
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/approve-out", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    AjaxResponse approveOut(@RequestBody AdpLotOperatorModel model, HttpSession session) {

        adpLotOperatorService.approveOut(model, getLoginSecUser(session));

        return new AjaxResponse(model);
    }

    /**
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/reject-in", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    AjaxResponse rejectIn(@RequestBody AdpLotOperatorModel model, HttpSession session) {

        adpLotOperatorService.rejectIn(model, getLoginSecUser(session));

        return new AjaxResponse(model);
    }

    /**
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/reject-out", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    AjaxResponse rejectOut(@RequestBody AdpLotOperatorModel model, HttpSession session) {

        adpLotOperatorService.rejectOut(model, getLoginSecUser(session));

        return new AjaxResponse(model);
    }

    /**
     *
     * @param ncvs
     * @param po
     * @param item
     * @param demandclass
     * @param codeDemand
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/detail/{ncvs}/{po}/{item}/expesskanban/{demandclass}/{codeDemand}")
    public String expressKanban(@PathVariable String ncvs, @PathVariable String po,
            @PathVariable String item, 
            @PathVariable String demandclass,@PathVariable String codeDemand,
            Model model, HttpSession session) {

        if (getPriviledgeUser(session, PRIVILEDGE, EDIT)) {
            String bucket = demandclass+"/"+codeDemand;
            AdpProduksiModel produksi = adpProduksiService.findByLotBasis(ncvs, po, item, bucket);
            model.addAttribute("produksi", produksi);
            putIntoRequest(model);
            return BASE_VIEW + EXPRESS;
        }

        return getUnauthorizedPage();
    }

    private void putIntoRequest(Model model) {
        model.addAttribute("listDepartement", adpDepartementService.getAll());
        model.addAttribute("SELECTED_MENU", MENU);
        model.addAttribute("SELECTED_SUBMENU", PRIVILEDGE);
    }

}
