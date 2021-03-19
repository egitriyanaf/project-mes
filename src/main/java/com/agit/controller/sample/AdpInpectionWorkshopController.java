package com.agit.controller.sample;

import com.agit.controller.qc.*;
import com.agit.common.ParamPaging;
import com.agit.controller.BaseController;
import com.agit.entity.JdcAdpMstlookup;
import com.agit.entity.JdcAdpMstspk;
import com.agit.entity.JdcAdpTxnqcctrl;
import com.project.common.AjaxResponse;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author TriAA
 */
@Controller
@RequestMapping("/sr/inspectionworkshop")
public class AdpInpectionWorkshopController extends BaseController {

    final static String MENU = "SAMPLE_ROOM";
    final static String PRIVILEDGE = "INS_WORK_SMPLR";
    private String BASE_VIEW = "03.sample/";
    private String LIST_VIEW = "adpInpectionWorkshop";

    /**
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/")
    public String index(Model model, HttpSession session) {
        if (getPriviledgeUser(session, PRIVILEDGE, VIEW)) {
            model.addAttribute("dptName", getUsrTypeFromSession(session));
            putIntoRequest(model);
            return BASE_VIEW + LIST_VIEW;
        }
        return getUnauthorizedPage();
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
        List<JdcAdpMstspk> dataSampleReq = adpWorkshopInspectionService.findBySpk(param);
        return dataSampleReq;
    }

    /**
     *
     * @param param
     * @param session
     * @return
     */
    @RequestMapping(value = "/defect", method = RequestMethod.POST)
    public @ResponseBody
    List<JdcAdpMstlookup> getChart(@RequestBody ParamPaging param, HttpSession session) {
        Map<String, Object> filters = param.getSearch();
        String value = (String) filters.get("value");
        List<JdcAdpMstlookup> getDefect = adpHourlyInspectionService.getAllDefectByLogin(getLoginSecUser(session), value);
        return getDefect;
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
    AjaxResponse save(@RequestBody JdcAdpTxnqcctrl model, HttpSession session) throws Exception {
        adpHourlyInspectionService.save(model, getLoginSecUser(session));
        return new AjaxResponse(model);
    }

    /**
     *
     * @param param
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/counter")
    public @ResponseBody
    List<JdcAdpTxnqcctrl> getCounter(@RequestBody ParamPaging param, Model model, HttpSession session) {
        List<JdcAdpTxnqcctrl> counter = adpHourlyInspectionService.getCounterWorkshop(getLoginSecUser(session));
        return counter;
    };

    private void putIntoRequest(Model model) {
        model.addAttribute("SELECTED_MENU", MENU);
        model.addAttribute("SELECTED_SUBMENU", PRIVILEDGE);
    }

}
