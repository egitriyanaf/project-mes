package com.agit.controller.operator;

import com.agit.common.ParamPaging;
import com.agit.controller.BaseController;
import static com.agit.controller.BaseController.VIEW;
import com.agit.controller.mail.MailMail;
import com.agit.controller.operator.model.AdpExpressKanbanModel;
import com.agit.controller.operator.model.AdpLotOperatorModel;
import com.agit.entity.JdcAdpFndapprv;
import com.agit.entity.JdcAdpTxnLotapprv;
import com.agit.entity.JdcAdpTxnlotbasis;
import com.project.common.AjaxResponse;
import com.project.common.DataTables;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
@RequestMapping("/operator/kanban")
public class AdpExpressKanbanController extends BaseController {

    final static String MENU = "OPERATOR";
    final static String PRIVILEDGE = "APPRV_LOT";
    private String BASE_VIEW = "06.operator/";
    private String HOME = "adpkanban-approve";
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

            return BASE_VIEW + HOME;
        }

        return getUnauthorizedPage();
    }

    /**
     *
     * @param dataTables
     * @param lineCode
     * @param poItem
     * @param poNo
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/search")
    public @ResponseBody
    DataTables search(DataTables dataTables, @RequestParam String lineCode,
            @RequestParam String poItem,
            @RequestParam String poNo,
            HttpSession session, HttpServletRequest request) {
        HashMap<String, Object> searchMap = new HashMap<>();

        searchMap.put("lineCode", lineCode);
        searchMap.put("poItem", poItem);
        searchMap.put("poNo", poNo);
        searchMap.put("userId", getLoginIdFromSession(session));
        DataTables dt = adpLotStockKanbanServices.searchByMapCriteria(dataTables, searchMap);
        return dt;
    }

    /**
     *
     * @param dataTables
     * @param ncvs
     * @param poItem
     * @param poNo
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/search-lot-kanban")
    public @ResponseBody
    DataTables searchLotKanban(DataTables dataTables, @RequestParam String ncvs,
            @RequestParam String poItem,
            @RequestParam String poNo,
            HttpSession session, HttpServletRequest request) {
        HashMap<String, Object> searchMap = new HashMap<>();

        searchMap.put("lineCode", ncvs);
        searchMap.put("poItem", poItem);
        searchMap.put("poNo", poNo);
        searchMap.put("userId", getLoginIdFromSession(session));
        DataTables dt = adpLotStockKanbanServices.searchByMapCriteriaLotKanban(dataTables, searchMap);
        return dt;
    }

    /**
     *
     * @param param
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/searchKanban")
    public @ResponseBody
    Long searchToKanban(@RequestBody ParamPaging param, HttpSession session, HttpServletRequest request) {

        Map<String, Object> searchMap = param.getSearch();

        String lineCode = (String) searchMap.get("lineCode");
        String poNo = (String) searchMap.get("poNo");
        String poItem = (String) searchMap.get("poItem");
        String paramHourly = (String) searchMap.get("hourly");
        Long hourly = (Long) Long.parseLong(paramHourly);
        Long id = 0l;
        JdcAdpTxnlotbasis lotbasis = adpProduksiService.findByToKanban(lineCode, poNo, poItem, hourly);
        if (lotbasis != null) {
            id = lotbasis.getId();
        }
        return id;

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
    AjaxResponse saveKanban(@RequestBody JdcAdpTxnLotapprv model, HttpSession session) throws Exception {
        Long persentase = 0l;
        Long persentaseSize1 = 0l;
        Long persentaseSize1T = 0l;
        Long persentaseSize2 = 0l;
        Long persentaseSize2T = 0l;
        Long persentaseSize3 = 0l;
        Long persentaseSize3T = 0l;
        Long persentaseSize4 = 0l;
        Long persentaseSize4T = 0l;
        Long persentaseSize5 = 0l;
        Long persentaseSize5T = 0l;
        Long persentaseSize6 = 0l;
        Long persentaseSize6T = 0l;
        Long persentaseSize7 = 0l;
        Long persentaseSize7T = 0l;
        Long persentaseSize8 = 0l;
        Long persentaseSize8T = 0l;
        Long persentaseSize9 = 0l;
        Long persentaseSize9T = 0l;
        Long persentaseSize10 = 0l;
        Long persentaseSize10T = 0l;
        Long persentaseSize11 = 0l;
        Long persentaseSize11T = 0l;
        Long persentaseSize12 = 0l;
        Long persentaseSize12T = 0l;
        Long persentaseSize13 = 0l;
        Long persentaseSize13T = 0l;
        Long persentaseSize14 = 0l;
        Long persentaseSize15 = 0l;
        Long persentaseSize16 = 0l;
        Long persentaseSize17 = 0l;
        Long persentaseSize18 = 0l;
        JdcAdpTxnLotapprv data = new JdcAdpTxnLotapprv();
        JdcAdpTxnlotbasis retVal = adpLotbasisService.findById(model.getId());
        if (model.getSize1() != null) {
            persentase += model.getSize1() / retVal.getSize1() * 100;
            persentaseSize1 = model.getSize1() / retVal.getSize1() * 100;
            data.setSize1(model.getSize1());
        }
        if (model.getSize1T() != null) {
            persentase += model.getSize1T() / retVal.getSize1T() * 100;
            persentaseSize1T = model.getSize1T() / retVal.getSize1T() * 100;
            data.setSize1T(model.getSize1T());
        }
        if (model.getSize2() != null) {
            persentase += model.getSize2() / retVal.getSize2() * 100;
            persentaseSize2 = model.getSize2() / retVal.getSize2() * 100;
            data.setSize2(model.getSize2());
        }
        if (model.getSize2T() != null) {
            persentase += model.getSize2T() / retVal.getSize2T() * 100;
            persentaseSize12T = model.getSize2T() / retVal.getSize2T() * 100;
            data.setSize2T(model.getSize2T());
        }
        if (model.getSize3() != null) {
            persentase += model.getSize3() / retVal.getSize3() * 100;
            persentaseSize3 = model.getSize3() / retVal.getSize3() * 100;
            data.setSize3(model.getSize3());
        }
        if (model.getSize3T() != null) {
            persentase += model.getSize3T() / retVal.getSize3T() * 100;
            persentaseSize3T = model.getSize3T() / retVal.getSize3T() * 100;
            data.setSize3T(model.getSize3T());
        }
        if (model.getSize4() != null) {
            persentase += model.getSize4() / retVal.getSize4() * 100;
            persentaseSize4 = model.getSize4() / retVal.getSize4() * 100;
            data.setSize4(model.getSize4());
        }
        if (model.getSize4T() != null) {
            persentase += model.getSize4T() / retVal.getSize4T() * 100;
            persentaseSize4T = model.getSize4T() / retVal.getSize4T() * 100;
            data.setSize4T(model.getSize4T());
        }

        if (model.getSize5() != null) {
            persentase += model.getSize5() / retVal.getSize5() * 100;
            persentaseSize5 = model.getSize5() / retVal.getSize5() * 100;
            data.setSize5(model.getSize5());
        }
        if (model.getSize5T() != null) {
            persentase += model.getSize5T() / retVal.getSize5T() * 100;
            persentaseSize5T = model.getSize5T() / retVal.getSize5T() * 100;
            data.setSize5T(model.getSize5T());
        }
        if (model.getSize6() != null) {
            persentase += model.getSize6() / retVal.getSize6() * 100;
            persentaseSize6 = model.getSize6() / retVal.getSize6() * 100;
            data.setSize6(model.getSize6());
        }
        if (model.getSize6T() != null) {
            persentase += model.getSize6T() / retVal.getSize6T() * 100;
            persentaseSize6T = model.getSize6T() / retVal.getSize6T() * 100;
            data.setSize6T(model.getSize6T());
        }
        if (model.getSize7() != null) {
            persentase += model.getSize7() / retVal.getSize7() * 100;
            persentaseSize7 = model.getSize7() / retVal.getSize7() * 100;
            data.setSize7(model.getSize7());
        }
        if (model.getSize7T() != null) {
            persentase += model.getSize7T() / retVal.getSize7T() * 100;
            persentaseSize7T = model.getSize7T() / retVal.getSize7T() * 100;
            data.setSize7T(model.getSize7T());
        }
        if (model.getSize8() != null) {
            persentase += model.getSize8() / retVal.getSize8() * 100;
            persentaseSize8 = model.getSize8() / retVal.getSize8() * 100;
            data.setSize8(model.getSize8());
        }
        if (model.getSize8T() != null) {
            persentase += model.getSize8T() / retVal.getSize8T() * 100;
            persentaseSize8T = model.getSize8T() / retVal.getSize8T() * 100;
            data.setSize8T(model.getSize8T());
        }
        if (model.getSize9() != null) {
            persentase += model.getSize9() / retVal.getSize9() * 100;
            persentaseSize9 = model.getSize9() / retVal.getSize9() * 100;
            data.setSize9(model.getSize9());
        }
        if (model.getSize9T() != null) {
            persentase += model.getSize9T() / retVal.getSize9T() * 100;
            persentaseSize9T = model.getSize9T() / retVal.getSize9T() * 100;
            data.setSize9T(model.getSize9T());
        }
        if (model.getSize10() != null) {
            persentase += model.getSize10() / retVal.getSize10() * 100;
            persentaseSize10 = model.getSize10() / retVal.getSize10() * 100;
            data.setSize10(model.getSize10());
        }
        if (model.getSize10T() != null) {
            persentase += model.getSize10T() / retVal.getSize10T() * 100;
            persentaseSize10T = model.getSize10T() / retVal.getSize10T() * 100;
            data.setSize10T(model.getSize10T());
        }
        if (model.getSize11() != null) {
            persentase += model.getSize11() / retVal.getSize11() * 100;
            persentaseSize11 = model.getSize11() / retVal.getSize11() * 100;
            data.setSize11(model.getSize11());
        }
        if (model.getSize11T() != null) {
            persentase += model.getSize11T() / retVal.getSize11T() * 100;
            persentaseSize11T = model.getSize11T() / retVal.getSize11T() * 100;
            data.setSize11T(model.getSize11T());
        }
        if (model.getSize12() != null) {
            persentase += model.getSize12() / retVal.getSize12() * 100;
            persentaseSize12 = model.getSize12() / retVal.getSize12() * 100;
            data.setSize12(model.getSize12());
        }
        if (model.getSize12T() != null) {
            persentase += model.getSize12T() / retVal.getSize12T() * 100;
            persentaseSize12T = model.getSize12T() / retVal.getSize12T() * 100;
            data.setSize12T(model.getSize12T());
        }
        if (model.getSize13() != null) {
            persentase += model.getSize13() / retVal.getSize13() * 100;
            persentaseSize13 = model.getSize13() / retVal.getSize13() * 100;
            data.setSize13(model.getSize13());
        }
        if (model.getSize13T() != null) {
            persentase += model.getSize13T() / retVal.getSize13T() * 100;
            persentaseSize13T = model.getSize13T() / retVal.getSize13T() * 100;
            data.setSize13T(model.getSize13T());
        }
        if (model.getSize14() != null) {
            persentase += model.getSize14() / retVal.getSize14() * 100;
            persentaseSize14 = model.getSize14() / retVal.getSize14() * 100;
            data.setSize14(model.getSize14());
        }
        if (model.getSize15() != null) {
            persentase += model.getSize15() / retVal.getSize15() * 100;
            persentaseSize15 = model.getSize15() / retVal.getSize15() * 100;
            data.setSize15(model.getSize15());
        }
        if (model.getSize16() != null) {
            persentase += model.getSize16() / retVal.getSize16() * 100;
            persentaseSize16 = model.getSize16() / retVal.getSize16() * 100;
            data.setSize16(model.getSize16());
        }
        if (model.getSize17() != null) {
            persentase += model.getSize17() / retVal.getSize17() * 100;
            persentaseSize17 = model.getSize17() / retVal.getSize17() * 100;
            data.setSize17(model.getSize17());
        }
        if (model.getSize18() != null) {
            persentase += model.getSize18() / retVal.getSize18() * 100;
            persentaseSize18 = model.getSize18() / retVal.getSize18() * 100;
            data.setSize18(model.getSize18());
        }
        JdcAdpFndapprv apprv = adpLotStockKanbanServices.getApprovalBypers(persentase);
        data.setAssignTo(apprv.getUser1());
        data.setPersentase(persentase);
        data.setHourly(model.getHourly());
        data.setLineCode(model.getLineCode());
        data.setPoNo(model.getPoNo());
        data.setPoItem(model.getPoItem());
        data.setRemark(model.getRemark());
        adpLotStockKanbanServices.save(data, getLoginSecUser(session));

        if (persentaseSize1 <= 1 || persentaseSize1T <= 1 || persentaseSize2 <= 1
                || persentaseSize2T <= 1 || persentaseSize3 <= 1
                || persentaseSize3T <= 1 || persentaseSize4 <= 1
                || persentaseSize4T <= 1 || persentaseSize5 <= 1
                || persentaseSize5T <= 1 || persentaseSize6 <= 1
                || persentaseSize6T <= 1 || persentaseSize7 <= 1
                || persentaseSize7T <= 1 || persentaseSize8 <= 1
                || persentaseSize8T <= 1 || persentaseSize9 <= 1
                || persentaseSize9T <= 1 || persentaseSize10 <= 1
                || persentaseSize10T <= 1 || persentaseSize11 <= 1
                || persentaseSize11T <= 1 || persentaseSize12 <= 1
                || persentaseSize12T <= 1 || persentaseSize13 <= 1
                || persentaseSize13T <= 1 || persentaseSize14 <= 1
                || persentaseSize15 <= 1 || persentaseSize16 <= 1
                || persentaseSize17 <= 1 || persentaseSize18 <= 1) {
            try {
                ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");

                MailMail mm = (MailMail) context.getBean("po1Lv1");
                MailMail mm4 = (MailMail) context.getBean("po1Lv4");
                mm.sendMail("Manager", "Silahkan cek approval ada barang yang akan ditransfer");
                mm4.sendMail("Manager", "Silahkan cek approval ada barang yang akan ditransfer");
                return new AjaxResponse(model);
            } catch (Exception e) {
                System.out.println(e);
                return new AjaxResponse(model);
            }

        } else {
            try {
                ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");

                MailMail m1 = (MailMail) context.getBean("po1Lv1");
                MailMail m2 = (MailMail) context.getBean("po1Lv2");
                MailMail m3 = (MailMail) context.getBean("po1Lv3");
                MailMail mm4 = (MailMail) context.getBean("po1Lv4");

                m1.sendMail("Manager", "Silahkan cek approval ada barang yang akan ditransfer");
                m2.sendMail("Manager", "Silahkan cek approval ada barang yang akan ditransfer");
                m3.sendMail("Manager", "Silahkan cek approval ada barang yang akan ditransfer");
                mm4.sendMail("Manager", "Silahkan cek approval ada barang yang akan ditransfer");
                return new AjaxResponse(model);
            } catch (Exception e) {
                System.out.println(e);
                return new AjaxResponse(model);
            }
        }
//        return new AjaxResponse(model);
    }

    /**
     *
     * @param id
     * @param session
     * @return
     */
    @RequestMapping("/approve/{id}")
    public String aprove(@PathVariable Long id, HttpSession session) {
        if (getPriviledgeUser(session, PRIVILEDGE, EDIT)) {
            Long status = 0l;
            JdcAdpTxnLotapprv approve = adpLotStockKanbanServices.findById(id);
            if (approve.getPersentase() > 1) {
                if (approve.getApprove1() == null) {
                    JdcAdpFndapprv apprv = adpLotStockKanbanServices.getApprovalBypers(approve.getPersentase());
                    approve.setAssignTo(apprv.getUser2());
                    approve.setApprove1(1l);
                    status = 1l;
                } else {
                    approve.setApprove2(1l);
                    status = 2l;
                }
            } else {
                approve.setApprove1(1l);
                status = 2l;
            }

            approve.setStatus(status);
            adpLotStockKanbanServices.saveUpdate(approve, getLoginSecUser(session));
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
    @RequestMapping("/reject/{id}")
    public String reject(@PathVariable Long id, Model model, HttpSession session) {

        if (getPriviledgeUser(session, PRIVILEDGE, EDIT)) {
            JdcAdpTxnLotapprv approve = adpLotStockKanbanServices.findById(id);
            approve.setStatus(3L);
            adpLotStockKanbanServices.saveUpdate(approve, getLoginSecUser(session));
            return BASE_VIEW + HOME;
        }

        return getUnauthorizedPage();
    }

    private void putIntoRequest(Model model) {
        model.addAttribute("SELECTED_MENU", MENU);
        model.addAttribute("SELECTED_SUBMENU", PRIVILEDGE);
    }

        /**
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/approve-in", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    AjaxResponse approveIn(@RequestBody AdpExpressKanbanModel model, HttpSession session) {

        adpLotStockKanbanServices.approveIn(model, getLoginSecUser(session));

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
    AjaxResponse approveOut(@RequestBody AdpExpressKanbanModel model, HttpSession session) {

        adpLotStockKanbanServices.approveOut(model, getLoginSecUser(session));

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
    AjaxResponse rejectIn(@RequestBody AdpExpressKanbanModel model, HttpSession session) {

        adpLotStockKanbanServices.rejectIn(model, getLoginSecUser(session));

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
    AjaxResponse rejectOut(@RequestBody AdpExpressKanbanModel model, HttpSession session) {

        adpLotStockKanbanServices.rejectOut(model, getLoginSecUser(session));

        return new AjaxResponse(model);
    }
}
