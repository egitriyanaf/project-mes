package com.agit.controller.sample;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.agit.controller.BaseController;
import com.agit.entity.JdcAdpTxnbarcode;
import com.project.common.AjaxResponse;

/**
 *
 * @author Ridwan
 */
@Controller
@RequestMapping("/sr/scanout")
public class AdpScanOutController extends BaseController {

    final static String MENU = "SAMPLE_ROOM";
    final static String PRIVILEDGE = "SCAN_OUT";
    private String BASE_VIEW = "03.sample/";
    private String LIST_VIEW = "adpscanout";

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
     * @param model
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    AjaxResponse save(@RequestBody JdcAdpTxnbarcode model, HttpSession session) throws Exception {
    	JdcAdpTxnbarcode data = adpBarcodeService.findValidasi(model.getQrCode(), model.getProductCode(), model.getSampleReq(), model.getQty(), model.getSize(), getDptIdFromSession(session),model.getType());
        if (data != null) {
            return new AjaxResponse(false, "Data Already axist !");
        }

        adpBarcodeService.save(model, getLoginSecUser(session));
        return new AjaxResponse(model);
    }

   

    private void putIntoRequest(Model model) {
        model.addAttribute("SELECTED_MENU", MENU);
        model.addAttribute("SELECTED_SUBMENU", PRIVILEDGE);
    }

}
