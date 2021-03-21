/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.controller.production;

import com.agit.common.ParamPaging;
import com.agit.controller.BaseController;
import com.agit.controller.production.model.AdpLotbasisModel;
import com.agit.controller.qc.model.AdpProduksiModel;
import com.agit.entity.JdcAdpMstproduksi;
import com.agit.entity.JdcAdpTxnlotbasis;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.services.AdpParamConfigService;
import com.agit.util.FileUtil;
import com.agit.util.ReadExcel;
import com.agit.util.StringUtils;
import com.project.common.AjaxResponse;
import com.project.common.DataTables;

import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ridwan s
 */
@Controller
@RequestMapping("/production/lotbasis")
public class AdpLotBasisController extends BaseController {

    @Autowired
    AdpParamConfigService adpParamConfigService;

    final static String MENU = "PRODUCTION";
    final static String PRIVILEDGE = "LOT";
    private String BASE_VIEW = "05.production/";
    private String HOME = "adplotbasis";
    private String DETAIL = "adplotbasis-detail";

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
     * @param poItem
     * @param lineCode
     * @param poNo
     * @param demandClass
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/search")
    public @ResponseBody
    DataTables search(DataTables dataTables, @RequestParam(required = false) String poItem,
            @RequestParam(required = false) String lineCode, @RequestParam(required = false) String poNo, 
            @RequestParam(required = false) String demandClass,
            HttpSession session, HttpServletRequest request) {

        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("poItem", poItem);
        searchMap.put("ncvs", lineCode);
        searchMap.put("poNo", poNo);
        searchMap.put("demandClass", demandClass);
        
        DataTables dt = adpProduksiService.searchByMapCriteria(dataTables, searchMap);
        return dt;
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
    public String create(@PathVariable String ncvs, @PathVariable String po, @PathVariable String item, 
            @PathVariable String demandclass,@PathVariable String codeDemand, 
            Model model,HttpSession session) {
        if (getPriviledgeUser(session, PRIVILEDGE, EDIT)) {
            String bucket = demandclass+"/"+codeDemand;
            AdpProduksiModel produksi = adpProduksiService.findByLotBasis(ncvs, po, item, bucket);
            model.addAttribute("produksi", produksi);
            putIntoRequest(model);

            return BASE_VIEW + DETAIL;
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
     * @param uploadfile
     * @param ncvs
     * @param poNo
     * @param poItem
     * @param demandClass
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/file-prosess", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, String> map(@RequestParam("file") MultipartFile uploadfile,
            @RequestParam("ncvs") String ncvs, @RequestParam("poNo") String poNo, 
            @RequestParam("poItem") String poItem, @RequestParam("demandClass") String demandClass,
            Model model, HttpSession session) {
        Map<String, String> message = new HashMap<>();
        JdcAdpMstUser findUser = getLoginSecUser(session);
        String filepath = null;
        String filename = null;
        @SuppressWarnings("unused")
        String fileResource = null;
        try {
            /* setup file attribute */
            FileUtil fileUtil = new FileUtil(uploadfile.getOriginalFilename(), '/', '.');
            /* validate file extension format XLS */
            if (!"xls".equalsIgnoreCase(fileUtil.extension())) {
                if (!"xlsx".equalsIgnoreCase(fileUtil.extension())) {
                    message.put("status", "0");
                    message.put("message", "Error validation, format is not supported");
                }
            }
            Date current = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss");
            /* create file path if not exist */
            String directory = adpParamConfigService.getDocumentDirectory();
            /* generate business filename */
            filename = "file" + "_" + sdf.format(current).replaceAll("/", "_") + "." + fileUtil.extension();
            /* full path */
            filepath = Paths.get(directory, filename).toString();

            /* transfer file to destination */
            uploadfile.transferTo(new File(filepath));
            String pathFolders = adpParamConfigService.getDocumentDirectory();
            fileResource = filepath.replace(pathFolders, "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        File fIn = new File(filepath);
        List<ArrayList<String>> data = new ReadExcel().baca(fIn, filepath);
        if (data.size() > 0) {
            for (ArrayList<String> row : data) {
                JdcAdpTxnlotbasis list = new JdcAdpTxnlotbasis();
                list.setCreateBy(findUser.getId());
                list.setCreateDate(new Date());
                list.setLineCode(ncvs);
                list.setPoNo(poNo);
                list.setPoItem(poItem);
                list.setDemandClass(demandClass);
                if (row.get(0) != null) {
                    if (StringUtils.isNumeric(row.get(0))) {
                        if (StringUtils.isNotEmpty(row.get(0))) {
                            list.setHourly(Long.parseLong(row.get(0).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Hourly must be numeric");
                        break;
                    }
                }

                if (row.get(1) != null) {
                    if (StringUtils.isNumeric(row.get(1))) {
                        if (StringUtils.isNotEmpty(row.get(1))) {
                            list.setSize1(Long.parseLong(row.get(1).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 1 must be numeric");
                        break;
                    }
                }

                if (row.get(2) != null) {
                    if (StringUtils.isNumeric(row.get(2))) {
                        if (StringUtils.isNotEmpty(row.get(2))) {
                            list.setSize1T(Long.parseLong(row.get(2).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 1T must be numeric");
                        break;
                    }
                }

                if (row.get(3) != null) {
                    if (StringUtils.isNumeric(row.get(3))) {
                        if (StringUtils.isNotEmpty(row.get(3))) {
                            list.setSize2(Long.parseLong(row.get(3).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 2 must be numeric");
                        break;
                    }
                }

                if (row.get(4) != null) {
                    if (StringUtils.isNumeric(row.get(4))) {
                        if (StringUtils.isNotEmpty(row.get(4))) {
                            list.setSize2T(Long.parseLong(row.get(4).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 2T must be numeric");
                        break;
                    }
                }

                if (row.get(5) != null) {
                    if (StringUtils.isNumeric(row.get(5))) {
                        if (StringUtils.isNotEmpty(row.get(5))) {
                            list.setSize3(Long.parseLong(row.get(5).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 3 must be numeric");
                        break;
                    }
                }

                if (row.get(6) != null) {
                    if (StringUtils.isNumeric(row.get(6))) {
                        if (StringUtils.isNotEmpty(row.get(6))) {
                            list.setSize3T(Long.parseLong(row.get(6).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 3T must be numeric");
                        break;
                    }
                }

                if (row.get(7) != null) {
                    if (StringUtils.isNumeric(row.get(7))) {
                        if (StringUtils.isNotEmpty(row.get(7))) {
                            list.setSize4(Long.parseLong(row.get(7).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 4 must be numeric");
                        break;
                    }
                }

                if (row.get(8) != null) {
                    if (StringUtils.isNumeric(row.get(8))) {
                        if (StringUtils.isNotEmpty(row.get(8))) {
                            list.setSize4T(Long.parseLong(row.get(8).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 4T must be numeric");
                        break;
                    }
                }

                if (row.get(9) != null) {
                    if (StringUtils.isNumeric(row.get(9))) {
                        if (StringUtils.isNotEmpty(row.get(9))) {
                            list.setSize5(Long.parseLong(row.get(9).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 5 must be numeric");
                        break;
                    }
                }

                if (row.get(10) != null) {
                    if (StringUtils.isNumeric(row.get(10))) {
                        if (StringUtils.isNotEmpty(row.get(10))) {
                            list.setSize5T(Long.parseLong(row.get(10).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 5T must be numeric");
                        break;
                    }
                }

                if (row.get(11) != null) {
                    if (StringUtils.isNumeric(row.get(11))) {
                        if (StringUtils.isNotEmpty(row.get(11))) {
                            list.setSize6(Long.parseLong(row.get(11).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 6 must be numeric");
                        break;
                    }
                }

                if (row.get(12) != null) {
                    if (StringUtils.isNumeric(row.get(12))) {
                        if (StringUtils.isNotEmpty(row.get(12))) {
                            list.setSize6T(Long.parseLong(row.get(12).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 6T must be numeric");
                        break;
                    }
                }

                if (row.get(13) != null) {
                    if (StringUtils.isNumeric(row.get(13))) {
                        if (StringUtils.isNotEmpty(row.get(13))) {
                            list.setSize7(Long.parseLong(row.get(13).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 7 must be numeric");
                        break;
                    }
                }

                if (row.get(14) != null) {
                    if (StringUtils.isNumeric(row.get(14))) {
                        if (StringUtils.isNotEmpty(row.get(14))) {
                            list.setSize7T(Long.parseLong(row.get(14).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 7T must be numeric");
                        break;
                    }
                }

                if (row.get(15) != null) {
                    if (StringUtils.isNumeric(row.get(15))) {
                        if (StringUtils.isNotEmpty(row.get(15))) {
                            list.setSize8(Long.parseLong(row.get(15).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 8 must be numeric");
                        break;
                    }
                }

                if (row.get(16) != null) {
                    if (StringUtils.isNumeric(row.get(16))) {
                        if (StringUtils.isNotEmpty(row.get(16))) {
                            list.setSize8T(Long.parseLong(row.get(16).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 8T must be numeric");
                        break;
                    }
                }

                if (row.get(17) != null) {
                    if (StringUtils.isNumeric(row.get(17))) {
                        if (StringUtils.isNotEmpty(row.get(17))) {
                            list.setSize9(Long.parseLong(row.get(17).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 9 must be numeric");
                        break;
                    }
                }

                if (row.get(18) != null) {
                    if (StringUtils.isNumeric(row.get(18))) {
                        if (StringUtils.isNotEmpty(row.get(18))) {
                            list.setSize9T(Long.parseLong(row.get(18).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 9T must be numeric");
                        break;
                    }
                }

                if (row.get(19) != null) {
                    if (StringUtils.isNumeric(row.get(19))) {
                        if (StringUtils.isNotEmpty(row.get(19))) {
                            list.setSize10(Long.parseLong(row.get(19).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 10 must be numeric");
                        break;
                    }
                }

                if (row.get(20) != null) {
                    if (StringUtils.isNumeric(row.get(20))) {
                        if (StringUtils.isNotEmpty(row.get(20))) {
                            list.setSize10T(Long.parseLong(row.get(20).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 10T must be numeric");
                        break;
                    }
                }

                if (row.get(21) != null) {
                    if (StringUtils.isNumeric(row.get(21))) {
                        if (StringUtils.isNotEmpty(row.get(21))) {
                            list.setSize11(Long.parseLong(row.get(21).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 11 must be numeric");
                        break;
                    }
                }

                if (row.get(22) != null) {
                    if (StringUtils.isNumeric(row.get(22))) {
                        if (StringUtils.isNotEmpty(row.get(22))) {
                            list.setSize11T(Long.parseLong(row.get(22).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 11T must be numeric");
                        break;
                    }
                }

                if (row.get(23) != null) {
                    if (StringUtils.isNumeric(row.get(23))) {
                        if (StringUtils.isNotEmpty(row.get(23))) {
                            list.setSize12(Long.parseLong(row.get(23).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 12 must be numeric");
                        break;
                    }
                }

                if (row.get(24) != null) {
                    if (StringUtils.isNumeric(row.get(24))) {
                        if (StringUtils.isNotEmpty(row.get(24))) {
                            list.setSize12T(Long.parseLong(row.get(24).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 12T must be numeric");
                        break;
                    }
                }

                if (row.get(25) != null) {
                    if (StringUtils.isNumeric(row.get(25))) {
                        if (StringUtils.isNotEmpty(row.get(25))) {
                            list.setSize13(Long.parseLong(row.get(25).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 13 must be numeric");
                        break;
                    }
                }

                if (row.get(26) != null) {
                    if (StringUtils.isNumeric(row.get(26))) {
                        if (StringUtils.isNotEmpty(row.get(26))) {
                            list.setSize13T(Long.parseLong(row.get(26).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 13T must be numeric");
                        break;
                    }
                }

                if (row.get(27) != null) {
                    if (StringUtils.isNumeric(row.get(27))) {
                        if (StringUtils.isNotEmpty(row.get(27))) {
                            list.setSize14(Long.parseLong(row.get(27).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 14 must be numeric");
                        break;
                    }
                }

                if (row.get(28) != null) {
                    if (StringUtils.isNumeric(row.get(28))) {
                        if (StringUtils.isNotEmpty(row.get(28))) {
                            list.setSize15(Long.parseLong(row.get(28).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 15 must be numeric");
                        break;
                    }
                }

                if (row.get(29) != null) {
                    if (StringUtils.isNumeric(row.get(29))) {
                        if (StringUtils.isNotEmpty(row.get(29))) {
                            list.setSize16(Long.parseLong(row.get(29).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 16 must be numeric");
                        break;
                    }
                }

                if (row.get(30) != null) {
                    if (StringUtils.isNumeric(row.get(30))) {
                        if (StringUtils.isNotEmpty(row.get(30))) {
                            list.setSize17(Long.parseLong(row.get(30).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 17 must be numeric");
                        break;
                    }
                }

                if (row.get(31) != null) {
                    if (StringUtils.isNumeric(row.get(31))) {
                        if (StringUtils.isNotEmpty(row.get(31))) {
                            list.setSize18(Long.parseLong(row.get(31).replace(".0", "")));
                        }
                    } else {
                        message.put("status", "0");
                        message.put("message", "Size 18 must be numeric");
                        break;
                    }
                }

                adpLotbasisService.save(list, findUser);
                message.put("message", "Success");
                message.put("status", "1");
            }
        }
        return message;
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
            @RequestParam(required = false) String poNo, @RequestParam(required = false) String ncvs,
            @RequestParam(required = false) String demandClass,
            HttpSession session, HttpServletRequest request) {

        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("poItem", poItem);
        searchMap.put("poNo", poNo);
        searchMap.put("ncvs", ncvs);
        searchMap.put("demandClass", demandClass);
        DataTables dt = adpLotbasisService.searchByMapCriteria(dataTables, searchMap);
        return dt;
    }

    /**
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    AjaxResponse save(@RequestBody AdpLotbasisModel model, HttpSession session) {

        adpProduksiService.saveLotBasis(model, getLoginSecUser(session));
        adpLotbasisService.saveLot(model, getLoginSecUser(session));

        return new AjaxResponse(model);
    }

    private void putIntoRequest(Model model) {
        model.addAttribute("SELECTED_MENU", MENU);
        model.addAttribute("SELECTED_SUBMENU", PRIVILEDGE);
    }

}
