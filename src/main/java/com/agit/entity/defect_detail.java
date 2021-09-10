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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author egi
 */
@Entity
@Table(name = "defect_detail")
public class defect_detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "defect_detail_id_seq", sequenceName = "defect_detail_id_seq", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "defect_detail_id_seq")
    
    @Column(name="id")
    private Long id_defect_detail;

    @Column(name="defect_header")
    private Long defect_header;
    
    @Column(name="defect_name")
    private String defect_name;
    
    @ManyToOne
    @JoinColumn(name = "defect_header", insertable = false, nullable = false, updatable = false)
    private defect_header id_defect_header;

    public Long getId_defect_detail() {
        return id_defect_detail;
    }

    public void setId_defect_detail(Long id_defect_detail) {
        this.id_defect_detail = id_defect_detail;
    }

    public Long getDefect_header() {
        return defect_header;
    }

    public void setDefect_header(Long defect_header) {
        this.defect_header = defect_header;
    }

    public String getDefect_name() {
        return defect_name;
    }

    public void setDefect_name(String defect_name) {
        this.defect_name = defect_name;
    }

    public defect_header getId_defect_header() {
        return id_defect_header;
    }

    public void setId_defect_header(defect_header id_defect_header) {
        this.id_defect_header = id_defect_header;
    }
    
    
}
