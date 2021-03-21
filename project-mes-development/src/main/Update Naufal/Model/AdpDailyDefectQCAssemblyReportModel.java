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
    private Float percentage;

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
           
    public Long getSock_liner() {
        return sock_liner;
    }

    public void setSock_liner(Long sock_liner) {
        this.sock_liner = sock_liner;
    }

    public Long getDoc_date() {
        return doc_date;
    }

    public void setDoc_date(Long doc_date) {
        this.doc_date = doc_date;
    }

    public Long getOthers() {
        return others;
    }

    public void setOthers(Long others) {
        this.others = others;
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

    public Long getOver_cement() {
        return over_cement;
    }

    public void setOver_cement(Long over_cement) {
        this.over_cement = over_cement;
    }

    public Long getStain_gauge_mk() {
        return stain_gauge_mk;
    }

    public void setStain_gauge_mk(Long stain_gauge_mk) {
        this.stain_gauge_mk = stain_gauge_mk;
    }

    public Long getStain_lace() {
        return stain_lace;
    }

    public void setStain_lace(Long stain_lace) {
        this.stain_lace = stain_lace;
    }

    public Long getStain_outsole() {
        return stain_outsole;
    }

    public void setStain_outsole(Long stain_outsole) {
        this.stain_outsole = stain_outsole;
    }

    public Long getStain_upper() {
        return stain_upper;
    }

    public void setStain_upper(Long stain_upper) {
        this.stain_upper = stain_upper;
    }

    public Long getCol_tongue_sp() {
        return col_tongue_sp;
    }

    public void setCol_tongue_sp(Long col_tongue_sp) {
        this.col_tongue_sp = col_tongue_sp;
    }

    public Long getCrooked() {
        return crooked;
    }

    public void setCrooked(Long crooked) {
        this.crooked = crooked;
    }

    public Long getDiff_toe() {
        return diff_toe;
    }

    public void setDiff_toe(Long diff_toe) {
        this.diff_toe = diff_toe;
    }

    public Long getLine_up() {
        return line_up;
    }

    public void setLine_up(Long line_up) {
        this.line_up = line_up;
    }

    public Long getAriance() {
        return ariance;
    }

    public void setAriance(Long ariance) {
        this.ariance = ariance;
    }

    public Long getBond_gap_os_up() {
        return bond_gap_os_up;
    }

    public void setBond_gap_os_up(Long bond_gap_os_up) {
        this.bond_gap_os_up = bond_gap_os_up;
    }

    public Long getBond_gap_os_ms() {
        return bond_gap_os_ms;
    }

    public void setBond_gap_os_ms(Long bond_gap_os_ms) {
        this.bond_gap_os_ms = bond_gap_os_ms;
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

    public Long getOver_buff() {
        return over_buff;
    }

    public void setOver_buff(Long over_buff) {
        this.over_buff = over_buff;
    }

    public Long getOver_color() {
        return over_color;
    }

    public void setOver_color(Long over_color) {
        this.over_color = over_color;
    }

    public Long getPainting() {
        return painting;
    }

    public void setPainting(Long painting) {
        this.painting = painting;
    }

    public Long getWrinkle_up() {
        return wrinkle_up;
    }

    public void setWrinkle_up(Long wrinkle_up) {
        this.wrinkle_up = wrinkle_up;
    }

    public Long getX_ray() {
        return x_ray;
    }

    public void setX_ray(Long x_ray) {
        this.x_ray = x_ray;
    }


    
}
