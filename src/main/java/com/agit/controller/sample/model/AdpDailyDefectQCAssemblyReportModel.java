/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.controller.sample.model;

import java.util.Date;

/**
 *
 * @author Naufal
 */
public class AdpDailyDefectQCAssemblyReportModel {
    private String ncvs;
    private String month;
    private String supervisor;
    private Date date;
    private String product_code;
    private String product_desc;
    
    private Long over_cement;
    private Long stain_upper;    
    private Long stain_gauge_mk;
    private Long stain_lace;
    private Long stain_outsole;
    
    private Long over_buff;
    private Long wrinkle_up;
    private Long x_ray;
    private Long over_color;
    private Long painting;
    
    private Long crooked;
    private Long diff_toe;        
    private Long line_up;
    private Long col_tongue_sp;
        
    private Long bond_gap_os_up;
    private Long bond_gap_os_ms;
    private Long broken_st;
    private Long ariance;
    private Long peel_off;
    
    private Long sock_liner;
    private Long doc_date;
    private Long others;
           
    private Long defect;
    private Long output;
    private float percentage;

    /**
     *
     * @return
     */
    public Long getSock_liner() {
        return sock_liner;
    }

    /**
     *
     * @param sock_liner
     */
    public void setSock_liner(Long sock_liner) {
        this.sock_liner = sock_liner;
    }

    /**
     *
     * @return
     */
    public Long getDoc_date() {
        return doc_date;
    }

    /**
     *
     * @param doc_date
     */
    public void setDoc_date(Long doc_date) {
        this.doc_date = doc_date;
    }

    /**
     *
     * @return
     */
    public Long getOthers() {
        return others;
    }

    /**
     *
     * @param others
     */
    public void setOthers(Long others) {
        this.others = others;
    }

    /**
     *
     * @return
     */
    public String getNcvs() {
        return ncvs;
    }

    /**
     *
     * @param ncvs
     */
    public void setNcvs(String ncvs) {
        this.ncvs = ncvs;
    }

    /**
     *
     * @return
     */
    public String getMonth() {
        return month;
    }

    /**
     *
     * @param month
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     *
     * @return
     */
    public String getSupervisor() {
        return supervisor;
    }

    /**
     *
     * @param supervisor
     */
    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    /**
     *
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @return
     */
    public String getProduct_code() {
        return product_code;
    }

    /**
     *
     * @param product_code
     */
    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    /**
     *
     * @return
     */
    public String getProduct_desc() {
        return product_desc;
    }

    /**
     *
     * @param product_desc
     */
    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }

    /**
     *
     * @return
     */
    public Long getOver_cement() {
        return over_cement;
    }

    /**
     *
     * @param over_cement
     */
    public void setOver_cement(Long over_cement) {
        this.over_cement = over_cement;
    }

    /**
     *
     * @return
     */
    public Long getStain_gauge_mk() {
        return stain_gauge_mk;
    }

    /**
     *
     * @param stain_gauge_mk
     */
    public void setStain_gauge_mk(Long stain_gauge_mk) {
        this.stain_gauge_mk = stain_gauge_mk;
    }

    /**
     *
     * @return
     */
    public Long getStain_lace() {
        return stain_lace;
    }

    /**
     *
     * @param stain_lace
     */
    public void setStain_lace(Long stain_lace) {
        this.stain_lace = stain_lace;
    }

    /**
     *
     * @return
     */
    public Long getStain_outsole() {
        return stain_outsole;
    }

    /**
     *
     * @param stain_outsole
     */
    public void setStain_outsole(Long stain_outsole) {
        this.stain_outsole = stain_outsole;
    }

    /**
     *
     * @return
     */
    public Long getStain_upper() {
        return stain_upper;
    }

    /**
     *
     * @param stain_upper
     */
    public void setStain_upper(Long stain_upper) {
        this.stain_upper = stain_upper;
    }

    /**
     *
     * @return
     */
    public Long getCol_tongue_sp() {
        return col_tongue_sp;
    }

    /**
     *
     * @param col_tongue_sp
     */
    public void setCol_tongue_sp(Long col_tongue_sp) {
        this.col_tongue_sp = col_tongue_sp;
    }

    /**
     *
     * @return
     */
    public Long getCrooked() {
        return crooked;
    }

    /**
     *
     * @param crooked
     */
    public void setCrooked(Long crooked) {
        this.crooked = crooked;
    }

    /**
     *
     * @return
     */
    public Long getDiff_toe() {
        return diff_toe;
    }

    /**
     *
     * @param diff_toe
     */
    public void setDiff_toe(Long diff_toe) {
        this.diff_toe = diff_toe;
    }

    /**
     *
     * @return
     */
    public Long getLine_up() {
        return line_up;
    }

    /**
     *
     * @param line_up
     */
    public void setLine_up(Long line_up) {
        this.line_up = line_up;
    }

    /**
     *
     * @return
     */
    public Long getAriance() {
        return ariance;
    }

    /**
     *
     * @param ariance
     */
    public void setAriance(Long ariance) {
        this.ariance = ariance;
    }

    /**
     *
     * @return
     */
    public Long getBond_gap_os_up() {
        return bond_gap_os_up;
    }

    /**
     *
     * @param bond_gap_os_up
     */
    public void setBond_gap_os_up(Long bond_gap_os_up) {
        this.bond_gap_os_up = bond_gap_os_up;
    }

    /**
     *
     * @return
     */
    public Long getBond_gap_os_ms() {
        return bond_gap_os_ms;
    }

    /**
     *
     * @param bond_gap_os_ms
     */
    public void setBond_gap_os_ms(Long bond_gap_os_ms) {
        this.bond_gap_os_ms = bond_gap_os_ms;
    }

    /**
     *
     * @return
     */
    public Long getBroken_st() {
        return broken_st;
    }

    /**
     *
     * @param broken_st
     */
    public void setBroken_st(Long broken_st) {
        this.broken_st = broken_st;
    }

    /**
     *
     * @return
     */
    public Long getPeel_off() {
        return peel_off;
    }

    /**
     *
     * @param peel_off
     */
    public void setPeel_off(Long peel_off) {
        this.peel_off = peel_off;
    }

    /**
     *
     * @return
     */
    public Long getOver_buff() {
        return over_buff;
    }

    /**
     *
     * @param over_buff
     */
    public void setOver_buff(Long over_buff) {
        this.over_buff = over_buff;
    }

    /**
     *
     * @return
     */
    public Long getOver_color() {
        return over_color;
    }

    /**
     *
     * @param over_color
     */
    public void setOver_color(Long over_color) {
        this.over_color = over_color;
    }

    /**
     *
     * @return
     */
    public Long getPainting() {
        return painting;
    }

    /**
     *
     * @param painting
     */
    public void setPainting(Long painting) {
        this.painting = painting;
    }

    /**
     *
     * @return
     */
    public Long getWrinkle_up() {
        return wrinkle_up;
    }

    /**
     *
     * @param wrinkle_up
     */
    public void setWrinkle_up(Long wrinkle_up) {
        this.wrinkle_up = wrinkle_up;
    }

    /**
     *
     * @return
     */
    public Long getX_ray() {
        return x_ray;
    }

    /**
     *
     * @param x_ray
     */
    public void setX_ray(Long x_ray) {
        this.x_ray = x_ray;
    }

    /**
     *
     * @return
     */
    public Long getDefect() {
        return defect;
    }

    /**
     *
     * @param defect
     */
    public void setDefect(Long defect) {
        this.defect = defect;
    }

    /**
     *
     * @return
     */
    public Long getOutput() {
        return output;
    }

    /**
     *
     * @param output
     */
    public void setOutput(Long output) {
        this.output = output;
    }

    /**
     *
     * @return
     */
    public float getPercentage() {
        return percentage;
    }

    /**
     *
     * @param percentage
     */
    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }
    
}
