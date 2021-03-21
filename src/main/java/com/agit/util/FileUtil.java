package com.agit.util;

import com.agit.controller.maintenance.AdpMasterImageController;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author erwin
 */
public class FileUtil {
	private final String fullPath;
    private final char pathSeparator, extensionSeparator;

    /**
     *
     * @param str
     * @param sep
     * @param ext
     */
    public FileUtil(String str, char sep, char ext) {
        fullPath = str;
        pathSeparator = sep;
        extensionSeparator = ext;
    }

    /* get file extension */

    /**
     *
     * @return
     */

    public String extension() {
        int dot = fullPath.lastIndexOf(extensionSeparator);
        return fullPath.substring(dot + 1);
    }

    /* get filename without extension */

    /**
     *
     * @return
     */

    public String filename() { 
        int dot = fullPath.lastIndexOf(extensionSeparator);
        int sep = fullPath.lastIndexOf(pathSeparator);
        return fullPath.substring(sep + 1, dot);
    }

    /* get path directory */

    /**
     *
     * @return
     */

    public String path() {
        int sep = fullPath.lastIndexOf(pathSeparator);
        return fullPath.substring(0, sep);
    }

    /* get fullname */

    /**
     *
     * @return
     */

    public String fullname() {
        File file = new File(fullPath);
        return file.getName();
    }

    /**
     * 
     * @param filePath : file directory
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static InputStream getStreamFromFile(String filePath) throws FileNotFoundException, IOException {
        InputStream input = new FileInputStream(filePath);
        int data = input.read();
        while (data != -1) {
            data = input.read();
        }
        return input;
    }
    
    /**
     * 
     * @param filePath : file directory
     * @return
     * @throws java.io.FileNotFoundException
     */
    public static OutputStream getOutputStreamFromFile(String filePath) throws FileNotFoundException, IOException {
        OutputStream output = new FileOutputStream(filePath);
        return output;
    }
    
    /**
     *
     * @param filePath
     * @param fileName
     * @return
     */
    public static String readBytesFromFile(String filePath, String fileName) {
        String directory = filePath;
        ByteArrayOutputStream baos=new ByteArrayOutputStream(1000);
        BufferedImage img = null;
        String base64String = null;
        FileUtil fileUtil = new FileUtil(fileName, '/', '.');
        try {
            img = ImageIO.read(new File(directory,fileName));
            ImageIO.write(img, fileUtil.extension(), baos);
            baos.flush();
            base64String=Base64.getEncoder().encodeToString(baos.toByteArray());
            baos.close();
        } catch (IOException ex) {
            Logger.getLogger(AdpMasterImageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return base64String;
    }
}
