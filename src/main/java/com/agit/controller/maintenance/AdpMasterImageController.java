/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.controller.maintenance;

import com.agit.common.ParamPaging;
import com.agit.controller.BaseController;
import com.agit.controller.maintenance.model.AdpProduksiAdressModel;
import com.agit.controller.maintenance.model.AdpProduksiSearchModel;
import com.agit.entity.JdcAdpMstimages;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.services.AdpParamConfigService;
import com.agit.util.FileUtil;
import com.agit.util.StringUtils;
import com.project.common.DataTables;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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
 * @author TriAA
 */
@Controller
@RequestMapping("/maintenance/masterimage")
public class AdpMasterImageController extends BaseController {

    final static String MENU = "MNTC";
    final static String PRIVILEDGE = "MST_IMG";
    private String BASE_VIEW = "07.maintenance/";
    private String LIST_VIEW = "adpMasterImage";
    private String EDIT_VIEW = "adpMasterImage-detail";
    @Autowired
    AdpParamConfigService adpParamConfigService;

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
     * @param dataTables
     * @param nameImage
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/search")
    public @ResponseBody
    DataTables search(DataTables dataTables,
            @RequestParam(required = false) String nameImage,
            HttpSession session, HttpServletRequest request) {

        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("nameImage", nameImage);

        DataTables dt = adpImageService.searchByMapCriteria(dataTables, searchMap);
        return dt;
    }

    /**
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/details")
    public String create(Model model, HttpSession session) {
        model.addAttribute("imageByte", null);
        return BASE_VIEW + EDIT_VIEW;
    }

    /**
     *
     * @param code
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/edit/{code}")
    public String edit(@PathVariable String code, Model model, HttpSession session) {

        if (getPriviledgeUser(session, PRIVILEDGE, EDIT)) {
            JdcAdpMstimages images = adpImageService.findByCode(code);
            FileUtil fileUtil = new FileUtil(images.getImageName(), '/', '.');
            String directory = adpParamConfigService.getDocumentDirectory();
            model.addAttribute("imageByte", fileUtil.readBytesFromFile(directory, images.getImageName()));
            model.addAttribute("imageExtension", fileUtil.extension());
            model.addAttribute("image", images);
            putIntoRequest(model);

            return BASE_VIEW + EDIT_VIEW;
        }

        return getUnauthorizedPage();
    }

    /**
     *
     * @param uploadfile
     * @param code
     * @param codeName
     * @param typeImage
     * @param flagStatus
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, String> save(@RequestParam("file") MultipartFile uploadfile,
            @RequestParam("code") String code,
            @RequestParam("codeName") String codeName,
            @RequestParam("typeImage") String typeImage, @RequestParam("flagStatus") String flagStatus,
            Model model, HttpSession session) {
        JdcAdpMstUser findUser = getLoginSecUser(session);
        Map<String, String> message = new HashMap<>();
        String filepath = null;
        String filename = null;
        @SuppressWarnings("unused")
        FileUtil fileUtil = null;
        String pathFolders = null;
        String directory = null;
        try {
            if (!StringUtils.hasValue(code)) {
                message.put("status", "0");
                message.put("message", "Error validation, code is empty");
                return message;
            }
            /* setup file attribute */
            fileUtil = new FileUtil(uploadfile.getOriginalFilename(), '/', '.');
            /* validate file extension format XLS */
            if (!"jpg".equalsIgnoreCase(fileUtil.extension())) {
                if (!"png".equalsIgnoreCase(fileUtil.extension())) {
                    message.put("status", "0");
                    message.put("message", "Error validation, format is not supported");
                    return message;
                }
            }
            /* create file path if not exist */
            directory = adpParamConfigService.getDocumentDirectory();
            /* generate business filename */
            filename = code + "." + fileUtil.extension();
            /* full path */
            filepath = Paths.get(directory, filename).toString();

            /* transfer file to destination */
            uploadfile.transferTo(new File(filepath));
//            pathFolders = adpParamConfigService.getDocumentDirectory();
            filepath.replace(directory, "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JdcAdpMstimages mstImages = new JdcAdpMstimages();
        mstImages.setId(code);
        mstImages.setCodeName(codeName);
        mstImages.setImageName(filename);
        mstImages.setImageFlag(typeImage);
        mstImages.setImagePath(filepath);
        mstImages.setImageStatus(flagStatus);
        mstImages.setCreateBy(findUser.getId());
        mstImages.setCreateDate(new Date());
        adpImageService.saveMstImages(mstImages, getLoginSecUser(session));
        model.addAttribute("imageByte", fileUtil.readBytesFromFile(directory, filename));
        model.addAttribute("imageExtension", fileUtil.extension());
        message.put("message", "Success");
        message.put("status", "1");
        return message;
    }

    /**
     *
     * @param param
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/search-joppic")
    public @ResponseBody
    List<AdpProduksiSearchModel> searchjoppic(@RequestBody ParamPaging param, HttpSession session, HttpServletRequest request) {
        Map<String, Object> searchMap = param.getSearch();
        List<AdpProduksiSearchModel> produk = adpImageService.searchProduct(searchMap);
        return produk;

    }

    /**
     *
     * @param param
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/search-address")
    public @ResponseBody
    List<AdpProduksiAdressModel> searchaddress(@RequestBody ParamPaging param, HttpSession session, HttpServletRequest request) {
        Map<String, Object> searchMap = param.getSearch();
        List<AdpProduksiAdressModel> address = adpImageService.searchAddress(searchMap);
        return address;

    }

    private void putIntoRequest(Model model) {
        model.addAttribute("SELECTED_MENU", MENU);
        model.addAttribute("SELECTED_SUBMENU", PRIVILEDGE);
    }

}
