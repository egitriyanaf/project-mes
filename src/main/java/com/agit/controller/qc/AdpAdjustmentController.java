package com.agit.controller.qc;

import com.agit.controller.BaseController;
import static com.agit.controller.BaseController.VIEW;
import com.agit.controller.qc.model.AdpAdjustmentModel;
import com.agit.dao.AdpAdjustmentDao;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.services.AdpParamConfigService;
import com.project.common.DataTables;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author erwin guna setiawan
 */
@Controller
@RequestMapping("/qc/adjustment")//dari table menu
public class AdpAdjustmentController extends BaseController{

    final static String MENU = "QC";
    final static String PRIVILEDGE = "ADJ";
    private String BASE_VIEW = "04.qc/";
    private String LIST_VIEW = "adpadjustment";//panggil JSP
    private String ADJ_EDIT = "adpadjustment-edit";

    /**
     *
     */
    @Autowired
    protected AdpParamConfigService config;
    
    @Autowired
    SessionFactory sessionFactory;
    
    @Autowired
    AdpAdjustmentDao adpAdjustmentDao;

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
//            model.addAttribute("totadjmodal", "45");
            return BASE_VIEW + LIST_VIEW;
        }
        
        return getUnauthorizedPage();
    }
    
     private void putIntoRequest(Model model) {
        model.addAttribute("SELECTED_MENU", MENU);
            model.addAttribute("SELECTED_SUBMENU", PRIVILEDGE);
    }
     
    /**
     *
     * @param dataTables
     * @param inspTgl
     * @param lineCode
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/search")
    public @ResponseBody
    DataTables search(DataTables dataTables, @RequestParam(required = false) String lineCode, 
            @RequestParam(required = false) String inspTgl,
            HttpSession session, HttpServletRequest request) {
//        HttpSession sessionli = request.getSession();
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("ncvs", lineCode);
        searchMap.put("insptgl", inspTgl);
        DataTables dt = adpAdjustmentService.searchByMapCriteria(dataTables, searchMap);
//        Long total = adpAdjustmentGradeService.getCountAdjustmentHistory(searchMap);
//        sessionli.setAttribute("dt", dt);
        return dt;
    }
     
    /**
     *
     * @param dataTables
     * @param inspTgl
     * @param lineCode
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/search-total")
    public @ResponseBody
    DataTables search2(DataTables dataTables, @RequestParam(required = false) String lineCode, 
            @RequestParam(required = false) String inspTgl,
            HttpSession session, HttpServletRequest request) {
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("ncvs", lineCode);
        searchMap.put("insptgl", inspTgl);
        Long total = adpAdjustmentGradeService.getCountAdjustmentHistory(searchMap);
        List<String> datalist = new ArrayList();
        datalist.add(total.toString());
        long jum = 1;
        return dataTables.extract(datalist, jum);
    }
     
    /**
     *
     * @param dataTables
     * @param lineCode
     * @param ProdCode
     * @param Tgl
     * @param session
     * @param pono
     * @param poitem
     * @param request
     * @return
     */
    @RequestMapping("/search-history")
    public @ResponseBody
    DataTables search(DataTables dataTables, @RequestParam(required = false) String lineCode, 
            @RequestParam(required = false) String ProdCode,
            @RequestParam(required = false) String Tgl,
            @RequestParam(required = false) String pono,
            @RequestParam(required = false) String poitem,
            HttpSession session, HttpServletRequest request) {
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("updateTgl", Tgl);
        searchMap.put("prodCode", ProdCode);
        searchMap.put("pono", pono);
        searchMap.put("listNcvs", lineCode);
        searchMap.put("poitem", poitem);
        DataTables dt = adpAdjustmentService.searchHistory(dataTables, searchMap);
        return dt;
    }
    
    
    /**
     *
     * @param id
     * @param ncvs
     * @param po
     * @param item
     * @param demandclass
     * @param codeDemand
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/edit/{id}/{ncvs}/{po}/{item}/{demandclass}/{codeDemand}")
    public String create(@PathVariable String id, @PathVariable String ncvs, @PathVariable String po, @PathVariable String item, 
            @PathVariable String demandclass,@PathVariable String codeDemand, 
            Model model,HttpSession session) {
        if (getPriviledgeUser(session, PRIVILEDGE, EDIT)) {
            String bucket = demandclass+"/"+codeDemand;
            AdpAdjustmentModel ADJ = adpAdjustmentService.findByAdjustment(id, ncvs, po, item, bucket);
            List<String> datalist = new ArrayList();
            datalist.add("Rework");
            datalist.add("C-Grade");
            datalist.add("B-Grade");
            model.addAttribute("ListAdj", datalist);
            model.addAttribute("adj", ADJ);
            putIntoRequest(model);

            return BASE_VIEW + ADJ_EDIT;
        }

        return getUnauthorizedPage();
    }
    
    /**
     *  
     * @param InspDate
     * @param ncvs
     * @param session
     * @return
     */
    @RequestMapping(value = "/proses", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, String> confirm(
            @RequestParam("inspdate") String InspDate, @RequestParam("ncvs") String ncvs, HttpSession session,HttpServletRequest request) {
        HttpSession sessionli = request.getSession();
        Map<String, String> message = new HashMap<>();
        JdcAdpMstUser findUser = getLoginSecUser(session);
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("ncvs", ncvs);
        searchMap.put("insptgl", InspDate);
        DataTables  dataTables = (DataTables) sessionli.getAttribute("dt");
        sessionli.removeAttribute("dt");
        if (dataTables.getAaData().size() > 0) {
            DataTables dt = adpAdjustmentService.searchByMapCriteria(dataTables, searchMap);
            for (AdpAdjustmentModel ADJ : (List<AdpAdjustmentModel>) dt.getAaData()) {;
                adpAdjustmentGradeService.saveToGrade(ADJ, findUser, ADJ.getType());
            }
            message.put("message", "Success");
            message.put("status", "1");
        }else{
            message.put("message", "Failed");
            message.put("status", "0");
        }
        
        return message;
    }

    
    
    /**
     *  
     * @param ncvs
     * @param id
     * @param poNo
     * @param poItem
     * @param demandClass
     * @param Type
     * @param session
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, String> map(
            @RequestParam("ncvs") String ncvs, @RequestParam("poNo") String poNo, @RequestParam("id") String id, 
            @RequestParam("poItem") String poItem, @RequestParam("demandClass") String demandClass,
            @RequestParam("type") String Type, HttpSession session) {
        Map<String, String> message = new HashMap<>();
        JdcAdpMstUser findUser = getLoginSecUser(session);
        AdpAdjustmentModel ADJ = adpAdjustmentService.findByAdjustment(id, ncvs, poNo, poItem, demandClass);
        adpAdjustmentService.updateToQC(ADJ, findUser, Type); //dipake
        adpAdjustmentGradeService.saveToGrade(ADJ, findUser, Type); //insert for historycal
        
        message.put("message", "Success");
        message.put("status", "1");
        return message;
    }

    
    
}
