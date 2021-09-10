package com.agit.controller.qc;

import com.agit.controller.BaseController;
import com.agit.services.AdpParamConfigService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author egi
 */

@Controller
@RequestMapping("/qc/report")
public class AdfReportController extends BaseController {
    final static String MENU = "QC";
    final static String PRIVILEDGE = "RQC";
    private String BASE_VIEW = "04.qc/";
    private String LIST_VIEW = "reportqc";
    
    @Autowired
    protected AdpParamConfigService config;
    
    @RequestMapping("/")
    public String index(Model model,HttpSession session, HttpServletRequest request){
        return BASE_VIEW+LIST_VIEW;
    
    }
    
}
