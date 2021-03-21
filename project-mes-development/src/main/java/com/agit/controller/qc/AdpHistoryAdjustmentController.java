/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.controller.qc;

import com.agit.controller.BaseController;
import static com.agit.controller.BaseController.VIEW;
import static com.agit.controller.qc.AdpAdjustmentController.MENU;
import com.agit.entity.JdcAdpMstproduksi;
import com.agit.entity.JdcAdpTxnqcctrl;
import com.agit.services.AdpParamConfigService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author erwin guna setiawan
 */
@Controller
@RequestMapping("/qc/historyadjustment")
public class AdpHistoryAdjustmentController extends BaseController{
    final static String MENU = "QC";
    final static String PRIVILEDGE = "HISTORY";
    private String BASE_VIEW = "04.qc/";
    private String LIST_VIEW = "adphistoryadjustment";//panggil JSP

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
    
    private void putIntoRequest(Model model) {
        model.addAttribute("SELECTED_MENU", MENU);
        model.addAttribute("SELECTED_SUBMENU", PRIVILEDGE);
    }
}
