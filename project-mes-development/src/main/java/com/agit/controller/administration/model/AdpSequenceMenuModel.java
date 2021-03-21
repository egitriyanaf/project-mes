/**
 * 
 */
package com.agit.controller.administration.model;

/**
*
* @author Ridwan
*/

public class AdpSequenceMenuModel {
	private String flag;
	private Integer lastSequence;
	
    /**
     *
     * @return
     */
    public String getFlag() {
		return flag;
	}

    /**
     *
     * @param flag
     */
    public void setFlag(String flag) {
		this.flag = flag;
	}

    /**
     *
     * @return
     */
    public Integer getLastSequence() {
		return lastSequence;
	}

    /**
     *
     * @param lastSequence
     */
    public void setLastSequence(Integer lastSequence) {
		this.lastSequence = lastSequence;
	}
}
