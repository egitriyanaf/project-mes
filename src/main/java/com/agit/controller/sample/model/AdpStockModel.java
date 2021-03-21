package com.agit.controller.sample.model;

import java.math.BigInteger;

/**
 *
 * @author ridwans
 */
public class AdpStockModel {

    private Double qty;
    private String sample_req;
    private String model;
    private String size;
    private Double transfer;
    private Double onHand;
    private String product_code;
    private BigInteger spk_id;

    /**
     *
     * @return
     */
    public Double getQty() {
        return qty;
    }

    /**
     *
     * @param qty
     */
    public void setQty(Double qty) {
        this.qty = qty;
    }

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
    public String getModel() {
        return model;
    }

    /**
     *
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     *
     * @return
     */
    public String getSize() {
        return size;
    }

    /**
     *
     * @param size
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     *
     * @return
     */
    public Double getTransfer() {
        return transfer;
    }

    /**
     *
     * @param transfer
     */
    public void setTransfer(Double transfer) {
        this.transfer = transfer;
    }

    /**
     *
     * @return
     */
    public Double getOnHand() {
        return onHand;
    }

    /**
     *
     * @param onHand
     */
    public void setOnHand(Double onHand) {
        this.onHand = onHand;
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
    public BigInteger getSpk_id() {
        return spk_id;
    }

    /**
     *
     * @param spk_id
     */
    public void setSpk_id(BigInteger spk_id) {
        this.spk_id = spk_id;
    }

}
