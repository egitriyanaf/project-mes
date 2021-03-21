package com.agit.controller.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.FileNameMap;
import java.net.URLConnection;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.agit.controller.BaseController;
import static com.agit.controller.BaseController.EDIT;
import com.agit.entity.JdcAdpMstimages;
import com.agit.services.AdpParamConfigService;
import com.agit.util.FileUtil;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author erwin
 */
@Controller
@RequestMapping("/file")
public class AdpFileController extends BaseController {

    /**
     *
     */
    @Autowired
    protected AdpParamConfigService config;

    private static final Logger logger = LoggerFactory.getLogger(AdpFileController.class);
    private static final FileNameMap mapping = URLConnection.getFileNameMap();

    /**
     *
     * @param type
     * @return
     */
    protected String getDefaultImageFileName(String type) {
        String fileName = null;
        if ("logo".equals(type)) {
            fileName = "no_image.png";
        }
        return fileName;
    }

    /**
     *
     * @param type
     * @return
     */
    protected String getDefaultLogoName(String type) {
        String fileName = null;
        if ("doc".equals(type)) {
            fileName = "Web_PETUNJUK_TEKNIS.pdf";
        }
        return fileName;
    }
    
    /**
     *
     * @param code
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/get-image/{code}")
    public @ResponseBody String edit(@PathVariable String code, Model model, HttpSession session) {
        JdcAdpMstimages images = adpImageService.findByCode(code);
        String base64String = null;
        String directory = config.getDocumentDirectory();
        if (com.agit.util.StringUtils.hasValue(images)) {
            FileUtil fileUtil = new FileUtil(images.getImageName(), '/', '.');
            base64String = fileUtil.readBytesFromFile(directory, images.getImageName());
        } else {
            FileUtil fileUtil = new FileUtil("no-profile-image.png", '/', '.');
            base64String = fileUtil.readBytesFromFile(directory, "no-profile-image.png");
        }
       
        return base64String;

    }

    /**
     *
     * @param type
     * @param name
     * @param response
     */
    @RequestMapping(value = "/get/{type}", method = RequestMethod.GET)
    public void getImage(@PathVariable("type") String type, @RequestParam("name") String name,
            HttpServletResponse response) {
        String fileName = name;
        String dir = "";
        if ("logo".equals(type)) {
            dir = config.getImageLogoDirectory();
            if (StringUtils.isBlank(name)) {
                fileName = getDefaultImageFileName(type);
            }
        } else {
            logger.error("Failed to get the file: Unknown type " + type);
            return;
        }
        File file = new File(dir, fileName);
        if (!file.exists()) {
            fileName = getDefaultImageFileName(type);
            file = new File(dir, fileName);
        }
        String contentType = mapping.getContentTypeFor(file.getAbsolutePath());
        response.setContentType(contentType);
        OutputStream os = null;
        InputStream is = null;
        try {
            os = response.getOutputStream();
            is = new FileInputStream(file);
            FileCopyUtils.copy(is, os);
            os.flush();
        } catch (IOException e) {
            logger.error("Error stream", e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    logger.error("Error closing stream", e);
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    logger.error("Error closing stream", e);
                }
            }
        }
    }

    /**
     *
     * @param type
     * @param response
     */
    @RequestMapping(value = "/download/{type}", method = RequestMethod.GET)
    public void getDoc(@PathVariable("type") String type,
            HttpServletResponse response) {
        String fileName = "";
        String dir = config.getDocumentDirectory();
        if ("Admin".equalsIgnoreCase(type)) {
            fileName = "PETUNJUK_TEKNIS_Admin.pdf";
        } else if ("Kantor Cabang".equalsIgnoreCase(type)) {
            fileName = "PETUNJUK_TEKNIS_Cabang_Web.pdf";
        } else if ("Kantor Kanwil".equalsIgnoreCase(type)) {
            fileName = "PETUNJUK_TEKNIS_Kanwil_Web.pdf";
        } else if ("Mitra".equalsIgnoreCase(type)) {
            fileName = "PETUNJUK_TEKNIS_Mitra_Web.pdf";
        } else if ("Kantor Pusat".equalsIgnoreCase(type)) {
            fileName = "PETUNJUK_TEKNIS_Kantor_Pusat.pdf";
        } else {
            logger.error("Failed to get the file: Unknown type " + type);
            return;
        }

        try {

            File fileToDownload = new File(dir + fileName);

            InputStream inputStream = new FileInputStream(fileToDownload);
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            IOUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
            inputStream.close();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }
}
