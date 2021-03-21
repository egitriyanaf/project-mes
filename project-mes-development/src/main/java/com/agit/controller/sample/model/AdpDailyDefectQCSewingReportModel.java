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
public class AdpDailyDefectQCSewingReportModel {
    private String product_code;;
    private String date;
    private String product_desc;
    private String ncvs;
    private String month;       
    private String supervisor;
    //clean
    private Long loose_st;
    private Long poor_trim_td;
    private Long stain_gauge_mk;
    private Long stain_up;
    //straight
    private Long crooked;
    private Long line_up;
    private Long st_margin;
    private Long tongue_sp;
    private Long wrinkle;
    
    //strong
    private Long broken_st;
    private Long join_tongue;
    private Long peel_off;
    
//    cosmetic
    private Long material_fail;
    private Long vamp_sp;
    private Long col_blacksp;
    private Long computer_st;
    private Long diff_color; 
    
    private Long other;
            
    private Long defect;
    private Long output;
    private Float percentage;

    /**
     *
     * @return
     */
    public Long getOther() {
        return other;
    }

    /**
     *
     * @param other
     */
    public void setOther(Long other) {
        this.other = other;
    }
    
    /**
     *
     * @return
     */
    public Long getDiff_color() {
        return diff_color;
    }

    /**
     *
     * @param diff_color
     */
    public void setDiff_color(Long diff_color) {
        this.diff_color = diff_color;
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
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
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
    public Long getLoose_st() {
        return loose_st;
    }

    /**
     *
     * @param loose_st
     */
    public void setLoose_st(Long loose_st) {
        this.loose_st = loose_st;
    }

    /**
     *
     * @return
     */
    public Long getPoor_trim_td() {
        return poor_trim_td;
    }

    /**
     *
     * @param poor_trim_td
     */
    public void setPoor_trim_td(Long poor_trim_td) {
        this.poor_trim_td = poor_trim_td;
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
    public Long getStain_up() {
        return stain_up;
    }

    /**
     *
     * @param stain_up
     */
    public void setStain_up(Long stain_up) {
        this.stain_up = stain_up;
    }

    /**
     *
     * @return
     */
    public Long getCol_blacksp() {
        return col_blacksp;
    }

    /**
     *
     * @param col_blacksp
     */
    public void setCol_blacksp(Long col_blacksp) {
        this.col_blacksp = col_blacksp;
    }

    /**
     *
     * @return
     */
    public Long getComputer_st() {
        return computer_st;
    }

    /**
     *
     * @param computer_st
     */
    public void setComputer_st(Long computer_st) {
        this.computer_st = computer_st;
    }

    /**
     *
     * @return
     */
    public Long getMaterial_fail() {
        return material_fail;
    }

    /**
     *
     * @param material_fail
     */
    public void setMaterial_fail(Long material_fail) {
        this.material_fail = material_fail;
    }

    /**
     *
     * @return
     */
    public Long getVamp_sp() {
        return vamp_sp;
    }

    /**
     *
     * @param vamp_sp
     */
    public void setVamp_sp(Long vamp_sp) {
        this.vamp_sp = vamp_sp;
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
    public Long getSt_margin() {
        return st_margin;
    }

    /**
     *
     * @param st_margin
     */
    public void setSt_margin(Long st_margin) {
        this.st_margin = st_margin;
    }

    /**
     *
     * @return
     */
    public Long getTongue_sp() {
        return tongue_sp;
    }

    /**
     *
     * @param tongue_sp
     */
    public void setTongue_sp(Long tongue_sp) {
        this.tongue_sp = tongue_sp;
    }

    /**
     *
     * @return
     */
    public Long getWrinkle() {
        return wrinkle;
    }

    /**
     *
     * @param wrinkle
     */
    public void setWrinkle(Long wrinkle) {
        this.wrinkle = wrinkle;
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
    public Long getJoin_tongue() {
        return join_tongue;
    }

    /**
     *
     * @param join_tongue
     */
    public void setJoin_tongue(Long join_tongue) {
        this.join_tongue = join_tongue;
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
    public Float getPercentage() {
        return percentage;
    }

    /**
     *
     * @param percentage
     */
    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }
    
    
}
