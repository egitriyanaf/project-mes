package com.agit.dao;

import java.util.List;

import com.agit.entity.JdcAdpMstlookup;
import com.agit.entity.JdcAdpFndparams;
/**
*
* @author Ridwan
*/
public interface AdpGenericDao {

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

	//public List<Integer> getChildIds(Long parenId);
	
	
}
