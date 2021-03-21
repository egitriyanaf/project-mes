/**
 * 
 */
package com.agit.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yose
 * 
 */
public class StringUtils {

    /**
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
		boolean result = true;
		if (str != null) {
			result = str.trim().isEmpty();
		}
		return result;
	}

    /**
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

    /**
     *
     * @param encodedString
     * @return
     */
    public static String encodeString(String encodedString) {
		String encode = null;
		try {
			encode = URLEncoder.encode(encodedString, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encode;

	}
	
	/**
	 * Parse csv from a string and put the result to list
	 * @param input input string
	 * @param separator csv separator
	 * @return List of values from csv string 
	 */
	public static List<String> parseCsv(String input,char separator){
		final char SEPARATOR = separator;
		final String REGEX = "\"([^\"]++)\"?\\s*\\Q"+SEPARATOR+"\\E?|" +
				"([^\\Q"+SEPARATOR+"\\E]+)\\Q"+SEPARATOR+"\\E?|" +
				"\\Q"+SEPARATOR+"\\E{1}+";
		List<String> result = new ArrayList<String>();
		Pattern ptrn = Pattern.compile(REGEX);
		Matcher matcher = ptrn.matcher(input);
		while(matcher.find()){
			String matches = matcher.group();
			matches = matches.replaceAll("\\Q"+SEPARATOR+"\\E$", ""); // strip separator in the end
			matches = matches.replaceAll("^\\s*|\\s*$", ""); // strip space before and after
			matches = matches.replaceAll("^\"+|\"+$", ""); // strip "
			result.add(matches);
		}
		return result;
	}
	
    /**
     *
     * @param prefix
     * @return
     */
    public static String generateUniqueId(String prefix){
		String prf = prefix;
		if (prefix==null){
			prf = "";
		}
		StringBuffer result = new StringBuffer(prf);
		UUID uuid = UUID.randomUUID();
		result.append(uuid);
		return result.toString();
	}
	
    /**
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	
    /**
     *
     * @param str
     * @return
     */
    public static String print(String str){
		if(str == null)
			return "";
		
		return str;
	}
	
    /**
     *
     * @param str
     * @return
     */
    public static boolean isNotNumeric(String str){
		return !isNumeric(str);
	}
        
    /**
     *
     * @param o
     * @return
     */
    public static boolean hasValue(Object o) {
        if (o == null) {
            return false;
        } else if (o.toString().trim().equals("")) {
            return false;
        } else if (o.toString().isEmpty()) {
            return false;
        }
        return true;
    }
    
    /**
     *
     * @param value
     * @return
     */
    public static String[] splitBySpace(String value) {
        return value.split("\\s+");
    }
}
