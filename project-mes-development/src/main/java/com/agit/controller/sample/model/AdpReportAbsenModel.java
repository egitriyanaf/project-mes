/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.controller.sample.model;

/**
 *
 * @author Naufal
 */
public class AdpReportAbsenModel {

    private String nik;
    private String fullname;
    private String attend_code;
    private String cost_code;
    private String attend_date;
    private float precentage;

    /**
     *
     * @return
     */
    public String getCost_code() {
        return cost_code;
    }

    /**
     *
     * @param cost_code
     */
    public void setCost_code(String cost_code) {
        this.cost_code = cost_code;
    }

    /**
     *
     * @return
     */
    public String getAttend_date() {
        return attend_date;
    }

    /**
     *
     * @param attend_date
     */
    public void setAttend_date(String attend_date) {
        this.attend_date = attend_date;
    }

    /**
     *
     * @return
     */
    public float getPrecentage() {
        return precentage;
    }

    /**
     *
     * @param precentage
     */
    public void setPrecentage(float precentage) {
        this.precentage = precentage;
    }

    /**
     *
     * @return
     */
    public String getNik() {
        return nik;
    }

    /**
     *
     * @param nik
     */
    public void setNik(String nik) {
        this.nik = nik;
    }

    /**
     *
     * @return
     */
    public String getFullname() {
        return fullname;
    }

    /**
     *
     * @param fullname
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     *
     * @return
     */
    public String getAttend_code() {
        return attend_code;
    }

    /**
     *
     * @param attend_code
     */
    public void setAttend_code(String attend_code) {
        this.attend_code = attend_code;
    }

}
