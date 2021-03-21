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
public class AdpStockTransferReportModel {
    private String sample_req;
    private String remark;
    private String tgl_awal;
    private String tgl_akhir;
    private Float transfer_qty;
    private Float qty;
    private Float return_qty;

    /**
     *
     * @return
     */
    public String getSample_req() {
        return sample_req;
    }

    /**
     *
     * @param sample_req
     */
    public void setSample_req(String sample_req) {
        this.sample_req = sample_req;
    }

    /**
     *
     * @return
     */
    public String getRemark() {
        return remark;
    }

    /**
     *
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     *
     * @return
     */
    public String getTgl_awal() {
        return tgl_awal;
    }

    /**
     *
     * @param tgl_awal
     */
    public void setTgl_awal(String tgl_awal) {
        this.tgl_awal = tgl_awal;
    }

    /**
     *
     * @return
     */
    public String getTgl_akhir() {
        return tgl_akhir;
    }

    /**
     *
     * @param tgl_akhir
     */
    public void setTgl_akhir(String tgl_akhir) {
        this.tgl_akhir = tgl_akhir;
    }

    /**
     *
     * @return
     */
    public Float getTransfer_qty() {
        return transfer_qty;
    }

    /**
     *
     * @param transfer_qty
     */
    public void setTransfer_qty(Float transfer_qty) {
        this.transfer_qty = transfer_qty;
    }

    /**
     *
     * @return
     */
    public Float getQty() {
        return qty;
    }

    /**
     *
     * @param qty
     */
    public void setQty(Float qty) {
        this.qty = qty;
    }

    /**
     *
     * @return
     */
    public Float getReturn_qty() {
        return return_qty;
    }

    /**
     *
     * @param return_qty
     */
    public void setReturn_qty(Float return_qty) {
        this.return_qty = return_qty;
    }

    
}
