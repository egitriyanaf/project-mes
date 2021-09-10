/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author egi
 */
@Entity
@Table(name = "defect_header")
public class defect_header implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="defect_header_id_seq", sequenceName="defect_header_id_seq",initialValue=1000, allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="defect_header_id_seq")
    @Column(name="id")
    private Long id_defect_header;
    
    @Column(name="po_no")
    private String po_no;
    
    @Column(name = "po_item")
    private String po_item;
    
    @Column(name="bucket")
    private String bucket;
    
    @Column(name="ncvs")
    private String ncvs;
    
    @Column(name="product_code")
    private String product_code;
    
    @Column(name="position")
    private String position;
    
    @Column(name="category")
    private String category;
    
    @Column(name = "type")
    private String type;

    public Long getId_defect_header() {
        return id_defect_header;
    }

    public void setId_defect_header(Long id_defect_header) {
        this.id_defect_header = id_defect_header;
    }

    public String getPo_no() {
        return po_no;
    }

    public void setPo_no(String po_no) {
        this.po_no = po_no;
    }

    public String getPo_item() {
        return po_item;
    }

    public void setPo_item(String po_item) {
        this.po_item = po_item;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getNcvs() {
        return ncvs;
    }

    public void setNcvs(String ncvs) {
        this.ncvs = ncvs;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
    
}
