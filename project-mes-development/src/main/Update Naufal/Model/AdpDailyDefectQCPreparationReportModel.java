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

    public Long getOther() {
        return other;
    }

    public void setOther(Long other) {
        this.other = other;
    }

    public String getNcvs() {
        return ncvs;
    }

    public void setNcvs(String ncvs) {
        this.ncvs = ncvs;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }

    public Long getLoose_st() {
        return loose_st;
    }

    public void setLoose_st(Long loose_st) {
        this.loose_st = loose_st;
    }

    public Long getPoor_trim_td() {
        return poor_trim_td;
    }

    public void setPoor_trim_td(Long poor_trim_td) {
        this.poor_trim_td = poor_trim_td;
    }

    public Long getStain_comp() {
        return stain_comp;
    }

    public void setStain_comp(Long stain_comp) {
        this.stain_comp = stain_comp;
    }

    public Long getStain_gauge_mk() {
        return stain_gauge_mk;
    }

    public void setStain_gauge_mk(Long stain_gauge_mk) {
        this.stain_gauge_mk = stain_gauge_mk;
    }

    public Long getComputer_st() {
        return computer_st;
    }

    public void setComputer_st(Long computer_st) {
        this.computer_st = computer_st;
    }


    public Long getDiff_color() {
        return diff_color;
    }

    public void setDiff_color(Long diff_color) {
        this.diff_color = diff_color;
    }

    public Long getHairy() {
        return hairy;
    }

    public void setHairy(Long hairy) {
        this.hairy = hairy;
    }

    public Long getLogo_quality() {
        return logo_quality;
    }

    public void setLogo_quality(Long logo_quality) {
        this.logo_quality = logo_quality;
    }

    public Long getMaterial_fail() {
        return material_fail;
    }

    public void setMaterial_fail(Long material_fail) {
        this.material_fail = material_fail;
    }

    public Long getCrooked() {
        return crooked;
    }

    public void setCrooked(Long crooked) {
        this.crooked = crooked;
    }

    public Long getLine_up() {
        return line_up;
    }

    public void setLine_up(Long line_up) {
        this.line_up = line_up;
    }


    public Long getSt_margin() {
        return st_margin;
    }

    public void setSt_margin(Long st_margin) {
        this.st_margin = st_margin;
    }


    public Long getVisible_lining() {
        return visible_lining;
    }

    public void setVisible_lining(Long visible_lining) {
        this.visible_lining = visible_lining;
    }

    public Long getWrinkle() {
        return wrinkle;
    }

    public void setWrinkle(Long wrinkle) {
        this.wrinkle = wrinkle;
    }

    public Long getBroken_st() {
        return broken_st;
    }

    public void setBroken_st(Long broken_st) {
        this.broken_st = broken_st;
    }

    public Long getPeel_off() {
        return peel_off;
    }

    public void setPeel_off(Long peel_off) {
        this.peel_off = peel_off;
    }

    public Long getDefect() {
        return defect;
    }

    public void setDefect(Long defect) {
        this.defect = defect;
    }

    public Long getOutput() {
        return output;
    }

    public void setOutput(Long output) {
        this.output = output;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }
    
}
