package com.agit.services;

import java.util.List;

import com.agit.entity.JdcAdpMstlookup;
import com.agit.entity.JdcAdpFndparams;

/**
 *
 * @author erwin
 */
public interface AdpGenericService {

    /**
     *
     * @param type
     * @return
     */
    public List<JdcAdpMstlookup> lookup(String type);
	
    /**
     *
     * @param type
     * @param value
     * @return
     */
    public JdcAdpMstlookup getLookupByValue(String type, String value);
	
    /**
     *
     * @param type
     * @param value
     * @return
     */
    public String getLookupDesc(String type, String value);

    /**
     *
     * @param name
     * @return
     */
    public JdcAdpFndparams getConfigByName(String name);
	
	//public List<Long> getChildIds(Long parenId);
}
