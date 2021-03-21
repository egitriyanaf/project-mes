package com.agit.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agit.entity.JdcAdpMstlookup;
import com.agit.entity.JdcAdpFndparams;
import com.agit.dao.AdpGenericDao;
import com.agit.services.AdpGenericService;

/**
 *
 * @author erwin
 */
@Service
@Transactional(readOnly = true)
public class AdpGenericServiceImpl implements AdpGenericService {
	
	@Autowired
	private AdpGenericDao genericDao;

    /**
     *
     * @param type
     * @return
     */
    @Override
	public List<JdcAdpMstlookup> lookup(String type) {
		return genericDao.lookup(type);
	}
	
    /**
     *
     * @param type
     * @param value
     * @return
     */
    @Override
	public JdcAdpMstlookup getLookupByValue(String type, String value) {
		return genericDao.getLookupByValue(type, value);
	}

    /**
     *
     * @param type
     * @param value
     * @return
     */
    @Override
	public String getLookupDesc(String type, String value) {
		return genericDao.getLookupDesc(type, value);
	}
	
    /**
     *
     * @param name
     * @return
     */
    @Override
	public JdcAdpFndparams getConfigByName(String name) {
		return genericDao.getConfigByName(name);
	}

	/*@Override
	public List<Long> getChildIds(Long parenId) {
		
		List<Integer> res = genericDao.getChildIds(parenId);
		List<Long> result =null;;
		if(res!=null){
			result = new ArrayList<Long>();
			for (Integer integer : res) {
				result.add(integer.longValue());
			}
		}
		return result;
		
	}*/
	

	
}
