package com.agit.controller.qc.model;

import java.math.BigInteger;

/**
 *
 * @author erwin
 */
public class AdpQcCounterModel {

    private BigInteger counter;
    private BigInteger agrade;
    private BigInteger bgrade;
    private BigInteger cgrade;
    private BigInteger rewok;
    private String dptName;

    /**
     *
     * @return
     */
    public BigInteger getCounter() {
        return counter;
    }

    /**
     *
     * @param counter
     */
    public void setCounter(BigInteger counter) {
        this.counter = counter;
    }

    /**
     *
     * @return
     */
    public BigInteger getAgrade() {
        return agrade;
    }

    /**
     *
     * @param agrade
     */
    public void setAgrade(BigInteger agrade) {
        this.agrade = agrade;
    }

    /**
     *
     * @return
     */
    public BigInteger getBgrade() {
        return bgrade;
    }

    /**
     *
     * @param bgrade
     */
    public void setBgrade(BigInteger bgrade) {
        this.bgrade = bgrade;
    }

    /**
     *
     * @return
     */
    public BigInteger getCgrade() {
        return cgrade;
    }

    /**
     *
     * @param cgrade
     */
    public void setCgrade(BigInteger cgrade) {
        this.cgrade = cgrade;
    }

    /**
     *
     * @return
     */
    public BigInteger getRewok() {
        return rewok;
    }

    /**
     *
     * @param rewok
     */
    public void setRewok(BigInteger rewok) {
        this.rewok = rewok;
    }

    /**
     *
     * @return
     */
    public String getDptName() {
        return dptName;
    }

    /**
     *
     * @param dptName
     */
    public void setDptName(String dptName) {
        this.dptName = dptName;
    }

}
