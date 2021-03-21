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
public class AdpDailyDefectQCPreparationReportModel {
    private String ncvs;
    private String month;
    private String supervisor;
    
    private Date date;
    private String product_code;
    private String product_desc;
//  clean
    private Long loose_st;
    private Long poor_trim_td;
    private Long stain_comp;
    private Long stain_gauge_mk;
//    cosmetic
    private Long material_fail;
    private Long diff_color;
    private Long computer_st;
    private Long logo_quality;
    private Long hairy;
//    straight
    private Long st_margin;
    private Long crooked;
    private Long line_up;
    private Long wrinkle;
    private Long visible_lining;
//    strong
    private Long broken_st;
    private Long peel_off;
//    others
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
    public Long getStain_comp() {
        return stain_comp;
    }

    /**
     *
     * @param stain_comp
     */
    public void setStain_comp(Long stain_comp) {
        this.stain_comp = stain_comp;
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
    public Long getHairy() {
        return hairy;
    }

    /**
     *
     * @param hairy
     */
    public void setHairy(Long hairy) {
        this.hairy = hairy;
    }

    /**
     *
     * @return
     */
    public Long getLogo_quality() {
        return logo_quality;
    }

    /**
     *
     * @param logo_quality
     */
    public void setLogo_quality(Long logo_quality) {
        this.logo_quality = logo_quality;
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
    public Long getVisible_lining() {
        return visible_lining;
    }

    /**
     *
     * @param visible_lining
     */
    public void setVisible_lining(Long visible_lining) {
        this.visible_lining = visible_lining;
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
