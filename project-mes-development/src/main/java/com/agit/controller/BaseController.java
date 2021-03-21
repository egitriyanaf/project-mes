package com.agit.controller;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.common.DataTables;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.services.AdpAbsenService;
import com.agit.services.AdpAdjustmentGradeService;
import com.agit.services.AdpAdjustmentService;
import com.agit.services.AdpAdminService;
import com.agit.services.AdpBarcodeService;
import com.agit.services.AdpComponentService;
import com.agit.services.AdpDepartementService;
import com.agit.services.AdpGenericService;
import com.agit.services.AdpHourlyInspectionService;
import com.agit.services.AdpImageService;
import com.agit.services.AdpLogSummaryDtlService;
import com.agit.services.AdpLogSummaryService;
import com.agit.services.AdpLotOperatorService;
import com.agit.services.AdpLotStockKanbanServices;
import com.agit.services.AdpLotbasisService;
import com.agit.services.AdpMenuService;
import com.agit.services.AdpParamConfigService;
import com.agit.services.AdpProduksiService;
import com.agit.services.AdpQualityRateService;
import com.agit.services.AdpReportPphService;
import com.agit.services.AdpRoleService;
import com.agit.services.AdpSpkService;
import com.agit.services.AdpStockTransferService;
import com.agit.services.AdpTemplateService;
import com.agit.services.AdpWorkshopInspectionService;
import com.agit.services.AdpLookupService;

/**
 *
 * @author Ridwan
 */
@PropertySource("classpath:app.properties")
public class BaseController {

    /**
     *
     */
    @Autowired
    protected Environment env;

    /**
     *
     */
    @Autowired
    protected AdpGenericService genericService;

    /**
     *
     */
    @Autowired
    protected AdpAdminService adminService;

    /**
     *
     */
    @Autowired
    protected AdpRoleService roleService;

    /**
     *
     */
    @Autowired
    protected AdpMenuService menuService;

    /**
     *
     */
    @Autowired
    protected AdpComponentService componentService;

    /**
     *
     */
    @Autowired
    protected AdpParamConfigService paramConfigService;

    /**
     *
     */
    @Autowired
    protected AdpBarcodeService adpBarcodeService;

    /**
     *
     */
    @Autowired
    protected AdpHourlyInspectionService adpHourlyInspectionService;

    /**
     *
     */
    @Autowired
    protected AdpProduksiService adpProduksiService;
    
    /**
     *
     */
    @Autowired
    protected AdpAdjustmentService adpAdjustmentService;

    /**
     *
     */
    @Autowired
    protected AdpAdjustmentGradeService adpAdjustmentGradeService;


    /**
     *
     */
    @Autowired
    protected AdpSpkService adpSpkService;

    /**
     *
     */
    @Autowired
    protected AdpDepartementService adpDepartementService;

    /**
     *
     */
    @Autowired
    protected AdpAbsenService adpAbsenService;

    /**
     *
     */
    @Autowired
    protected AdpLogSummaryService adpLogSummaryService;

    /**
     *
     */
    @Autowired
    protected AdpLogSummaryDtlService adpLogSummaryDtlService;

    /**
     *
     */
    @Autowired
    protected AdpImageService adpImageService;

    /**
     *
     */
    @Autowired
    protected AdpStockTransferService adpStockTransferService;

    /**
     *
     */
    @Autowired
    protected AdpLotbasisService adpLotbasisService;

    /**
     *
     */
    @Autowired
    protected AdpLotStockKanbanServices adpLotStockKanbanServices;

    /**
     *
     */
    @Autowired
    protected AdpLotOperatorService adpLotOperatorService;

    /**
     *
     */
    @Autowired
    protected AdpWorkshopInspectionService adpWorkshopInspectionService;

    /**
     *
     */
    @Autowired
    protected AdpTemplateService adpTemplateService;

    /**
     *
     */
    @Autowired
    protected AdpQualityRateService adpQualityRateService;

    /**
     *
     */
    @Autowired
    protected AdpLookupService adpLookupService;

    /**
     *
     */
    @Autowired
    protected AdpReportPphService adpReportPphService;
    
//    @Autowired
//    protected AdpParamConfigService adpParamConfigService;

    /**
     *
     */
    protected DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    /**
     *
     */
    protected final NumberFormat numberFormat = new DecimalFormat("#,##0.00");

    /**
     *
     */
    public static final String SUPER_ADMIN = "Admin";

    /**
     *
     */
    public static final String USER_ADMIN = "USER";

    /**
     *
     */
    public static final String MANAGER = "Manager";

    /**
     *
     */
    public static final String VIEW = "VIEW";

    /**
     *
     */
    public static final String NEW = "NEW";

    /**
     *
     */
    public static final String EDIT = "EDIT";

    /**
     *
     */
    public static final String DELETE = "DELETE";

    /**
     *
     * @return
     */
    public String getUnauthorizedPage() {
        return "01.misc/not_authorized";
    }

    /**
     *
     * @param binder
     * @throws Exception
     */
    @InitBinder
    public void initBinder(DataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        binder.registerCustomEditor(BigDecimal.class, new CustomNumberEditor(Double.class, numberFormat, true));
    }

    /**
     *
     * @param session
     * @return
     */
    protected JdcAdpMstUser getLoginSecUser(HttpSession session) {
        return (JdcAdpMstUser) session.getAttribute("loginSecUser");
    }

    /**
     *
     * @param session
     * @return
     */
    protected String getLoginPasswordPlan(HttpSession session) {
        return (String) session.getAttribute("passwordPlain");
    }

    /**
     *
     * @param session
     * @return
     */
    protected Long getUserIdFromSession(HttpSession session) {
        JdcAdpMstUser user = this.getLoginSecUser(session);
        if (user != null) {
            return user.getId();
        }
        return null;
    }

    /**
     *
     * @param session
     * @return
     */
    protected String getUsrTypeFromSession(HttpSession session) {
        JdcAdpMstUser user = this.getLoginSecUser(session);
        if (user != null) {
            return user.getUsrType();
        }
        return null;
    }

    /**
     *
     * @param session
     * @return
     */
    protected Long getLoginIdFromSession(HttpSession session) {
        JdcAdpMstUser user = this.getLoginSecUser(session);
        if (user != null) {
            if (user.getUsrType().equals(SUPER_ADMIN)) {
                return null;
            } else {
                return user.getId();
            }
        }

        return 0L;
    }

    /**
     *
     * @param session
     * @return
     */
    protected Long getDptIdFromSession(HttpSession session) {
        JdcAdpMstUser user = this.getLoginSecUser(session);
        if (user != null) {
            if (user.getUsrType().equals(SUPER_ADMIN)) {
                return user.getDptId();
            } else {
                return user.getDptId();
            }
        }

        return 0L;
    }

    /**
     *
     * @param session
     * @param menu
     * @param component
     * @return
     */
    protected boolean getPriviledgeUser(HttpSession session, String menu, String component) {
        JdcAdpMstUser user = getLoginSecUser(session);
        if (user.getUsrType().equals(USER_ADMIN)) {
            return true;
        }

        return adminService.getPriviledge(user.getId(), menu, component);
    }

    /**
     *
     * @param object
     * @return
     */
    public String getXMLValue(Object object) {
        String XML = "";
        try {
            String className = object.getClass().getSimpleName();
            XML = "<" + className + ">\n";
            for (Field field : object.getClass().getDeclaredFields()) {
                field.setAccessible(true);

                String name = field.getName();
                Object value = field.get(object);

                XML += "\t<" + name + ">" + value + "</" + name + ">\n";

            }
            XML += "</" + className + ">\n";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return XML;
    }

    /**
     *
     * @param dataTables
     * @param userName
     * @param session
     * @return
     */
    @RequestMapping("/getUser")
    public @ResponseBody
    DataTables getUser(DataTables dataTables, @RequestParam(required = false) String userName,
            HttpSession session) {

        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("loginId", getLoginIdFromSession(session));
        searchMap.put("userLogin", userName);
        dataTables = adminService.searchByMapCriteria(dataTables, searchMap);

        return dataTables;
    }

    /**
     *
     * @param dataTables
     * @param name
     * @param session
     * @return
     */
    @RequestMapping("/getMenu")
    public @ResponseBody
    DataTables getMenu(DataTables dataTables, @RequestParam(required = false) String name,
            HttpSession session) {
        HashMap<String, Object> searchMap = new HashMap<>();
        long parentId = 12345678910L;
        searchMap.put("name", name);
        searchMap.put("parentId", parentId);
        dataTables = menuService.searchByMapCriteria(dataTables, searchMap);
        return dataTables;
    }

    /**
     *
     * @param dataTables
     * @param dptName
     * @param session
     * @return
     */
    @RequestMapping("/getDepartement")
    public @ResponseBody
    DataTables getProductByNcvs(DataTables dataTables,
            @RequestParam(required = false) String dptName,
            HttpSession session) {
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("name", dptName);
        dataTables = adpDepartementService.searchByMapCriteria(dataTables, searchMap);
        return dataTables;
    }
    
    /**
     *
     * @param dataTables
     * @param productDesc
     * @param session
     * @return
     */
    @RequestMapping("/getProduct")
    public @ResponseBody
    DataTables getProductAll(DataTables dataTables,
            @RequestParam(required = false) String productDesc,
            HttpSession session) {
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("name", productDesc);
        dataTables = adpProduksiService.searchByMapCriteriaProduct(dataTables, searchMap);
        return dataTables;
    }
    
    /**
     *
     * @param dataTables
     * @param addressLine
     * @param session
     * @return
     */
    @RequestMapping("/getDiamondMark")
    public @ResponseBody
    DataTables getDiamondMark(DataTables dataTables,
            @RequestParam(required = false) String addressLine,
            HttpSession session) {
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("name", addressLine);
        dataTables = adpProduksiService.searchByMapCriteriaDiamondMark(dataTables, searchMap);
        return dataTables;
    }

}
