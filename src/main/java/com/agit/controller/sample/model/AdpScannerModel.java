package com.agit.controller.sample.model;

import java.math.BigInteger;

/**
 *
 * @author erwin
 */
public class AdpScannerModel {
	
	private Double totalIn;
	private Double totalOut;
	private BigInteger dptId;
	private String departement;
	
    /**
     *
     * @return
     */
    public Double getTotalIn() {
		return totalIn;
	}

    /**
     *
     * @param totalIn
     */
    public void setTotalIn(Double totalIn) {
		this.totalIn = totalIn;
	}

    /**
     *
     * @return
     */
    public Double getTotalOut() {
		return totalOut;
	}

    /**
     *
     * @param totalOut
     */
    public void setTotalOut(Double totalOut) {
		this.totalOut = totalOut;
	}

    /**
     *
     * @return
     */
    public BigInteger getDptId() {
		return dptId;
	}

    /**
     *
     * @param dptId
     */
    public void setDptId(BigInteger dptId) {
		this.dptId = dptId;
	}

    /**
     *
     * @return
     */
    public String getDepartement() {
		return departement;
	}

    /**
     *
     * @param departement
     */
    public void setDepartement(String departement) {
		this.departement = departement;
	}
	
	

}
