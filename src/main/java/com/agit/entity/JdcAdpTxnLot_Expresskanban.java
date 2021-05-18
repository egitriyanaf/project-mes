/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.entity.util.CustomJsonDateSerializer;

/**
 *
 * @author Egi
 */
@Entity
@Table(name = "jdcadp_txnlotbasis_expresskanban" )
public class JdcAdpTxnLot_Expresskanban implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "seq_lot", sequenceName = "seq_lot", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_lot")
    
    @Column(name="lot_id")
    private Long id_Ex;
    
    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    private Date createDate_Ex;
    
    @Column(name = "created_by")
    private Long createBy_Ex;
    
    @ManyToOne
    @JoinColumn(name = "created_by", insertable = false, nullable = false, updatable = false)
    private JdcAdpMstUser user;
    
    @Column(name = "last_updated_date")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    private Date updateDate_Ex;

    @Column(name = "last_updated_by")
    private Long updateBy_Ex;

    @Column(name = "hourly")
    private Long hourly_Ex;

    @Column(name = "size_1")
    private Long Size1_Ex;
    
    @Column(name = "size_2")
    private Long Size2_Ex;
    
    @Column(name = "size_3")
    private Long Size3_Ex;
    
    @Column(name = "size_4")
    private Long Size4_Ex;
    
    @Column(name = "size_5")
    private Long Size5_Ex;
    
    @Column(name = "size_6")
    private Long Size6_Ex;
    
    @Column(name = "size_7")
    private Long Size7_Ex;
    
    @Column(name = "size_8")
    private Long Size8_Ex;
    
    @Column(name = "size_9")
    private Long Size9_Ex;
    
    @Column(name = "size_10")
    private Long Size10_Ex;
    
    @Column(name = "size_11")
    private Long Size11_Ex;
    
    @Column(name = "size_12")
    private Long Size12_Ex;
    
    @Column(name = "size_13")
    private Long Size13_Ex;
    
    @Column(name = "size_14")
    private Long Size14_Ex;
    
    @Column(name = "size_15")
    private Long Size15_Ex;
    
    @Column(name = "size_16")
    private Long Size16_Ex;
    
    @Column(name = "size_17")
    private Long Size17_Ex;
    
    @Column(name = "size_18")
    private Long Size18_Ex;
    
    @Column(name = "size_1_t")
    private Long Size1_t_Ex;
    
    @Column(name = "size_2_t")
    private Long Size2_t_Ex;
    
    @Column(name = "size_3_t")
    private Long Size3_t_Ex;
    
    @Column(name = "size_4_t")
    private Long Size4_t_Ex;
    
    @Column(name = "size_5_t")
    private Long Size5_t_Ex;
    
    @Column(name = "size_6_t")
    private Long Size6_t_Ex;
    
    @Column(name = "size_7_t")
    private Long Size7_t_Ex;
    
    @Column(name = "size_8_t")
    private Long Size8_t_Ex;
    
    @Column(name = "size_9_t")
    private Long Size9_t_Ex;
    
    @Column(name = "size_10_t")
    private Long Size10_t_Ex;
    
    @Column(name = "size_11_t")
    private Long Size11_t_Ex;
    
    @Column(name = "size_12_t")
    private Long Size12_t_Ex;
    
    @Column(name = "size_13_t")
    private Long Size13_t_Ex;
    
    @Column(name = "flag_express_ct_in_size_1")
    private Long flag_express_CtInSize1;
    @Column(name = "flag_express_ct_in_size_2")
    private Long flag_express_CtInSize2;
    @Column(name = "flag_express_ct_in_size_3")
    private Long flag_express_CtInSize3;
    @Column(name = "flag_express_ct_in_size_4")
    private Long flag_express_CtInSize4;
    @Column(name = "flag_express_ct_in_size_5")
    private Long flag_express_CtInSize5;
    @Column(name = "flag_express_ct_in_size_6")
    private Long flag_express_CtInSize6;
    @Column(name = "flag_express_ct_in_size_7")
    private Long flag_express_CtInSize7;
    @Column(name = "flag_express_ct_in_size_8")
    private Long flag_express_CtInSize8;
    @Column(name = "flag_express_ct_in_size_9")
    private Long flag_express_CtInSize9;
    @Column(name = "flag_express_ct_in_size_10")
    private Long flag_express_CtInSize10;
    @Column(name = "flag_express_ct_in_size_11")
    private Long flag_express_CtInSize11;
    @Column(name = "flag_express_ct_in_size_12")
    private Long flag_express_CtInSize12;
    @Column(name = "flag_express_ct_in_size_13")
    private Long flag_express_CtInSize13;
    @Column(name = "flag_express_ct_in_size_14")
    private Long flag_express_CtInSize14;
    @Column(name = "flag_express_ct_in_size_15")
    private Long flag_express_CtInSize15;
    @Column(name = "flag_express_ct_in_size_16")
    private Long flag_express_CtInSize16;
    @Column(name = "flag_express_ct_in_size_17")
    private Long flag_express_CtInSize17;
    @Column(name = "flag_express_ct_in_size_18")
    private Long flag_express_CtInSize18;
    @Column(name = "flag_express_ct_in_size_1_t")
    private Long flag_express_CtInSize1T;
    @Column(name = "flag_express_ct_in_size_2_t")
    private Long flag_express_CtInSize2T;
    @Column(name = "flag_express_ct_in_size_3_t")
    private Long flag_express_CtInSize3T;
    @Column(name = "flag_express_ct_in_size_4_t")
    private Long flag_express_CtInSize4T;
    @Column(name = "flag_express_ct_in_size_5_t")
    private Long flag_express_CtInSize5T;
    @Column(name = "flag_express_ct_in_size_6_t")
    private Long flag_express_CtInSize6T;
    @Column(name = "flag_express_ct_in_size_7_t")
    private Long flag_express_CtInSize7T;
    @Column(name = "flag_express_ct_in_size_8_t")
    private Long flag_express_CtInSize8T;
    @Column(name = "flag_express_ct_in_size_9_t")
    private Long flag_express_CtInSize9T;
    @Column(name = "flag_express_ct_in_size_10_t")
    private Long flag_express_CtInSize10T;
    @Column(name = "flag_express_ct_in_size_11_t")
    private Long flag_express_CtInSize11T;
    @Column(name = "flag_express_ct_in_size_12_t")
    private Long flag_express_CtInSize12T;
    @Column(name = "flag_express_ct_in_size_13_t")
    private Long flag_express_CtInSize13T;
    
    @Column(name = "flag_express_ct_out_size_1")
    private Long flag_express_CtOutSize1;
    @Column(name = "flag_express_ct_out_size_2")
    private Long flag_express_CtOutSize2;
    @Column(name = "flag_express_ct_out_size_3")
    private Long flag_express_CtOutSize3;
    @Column(name = "flag_express_ct_out_size_4")
    private Long flag_express_CtOutSize4;
    @Column(name = "flag_express_ct_out_size_5")
    private Long flag_express_CtOutSize5;
    @Column(name = "flag_express_ct_out_size_6")
    private Long flag_express_CtOutSize6;
    @Column(name = "flag_express_ct_out_size_7")
    private Long flag_express_CtOutSize7;
    @Column(name = "flag_express_ct_out_size_8")
    private Long flag_express_CtOutSize8;
    @Column(name = "flag_express_ct_out_size_9")
    private Long flag_express_CtOutSize9;
    @Column(name = "flag_express_ct_out_size_10")
    private Long flag_express_CtOutSize10;
    @Column(name = "flag_express_ct_out_size_11")
    private Long flag_express_CtOutSize11;
    @Column(name = "flag_express_ct_out_size_12")
    private Long flag_express_CtOutSize12;
    @Column(name = "flag_express_ct_out_size_13")
    private Long flag_express_CtOutSize13;
    @Column(name = "flag_express_ct_out_size_14")
    private Long flag_express_CtOutSize14;
    @Column(name = "flag_express_ct_out_size_15")
    private Long flag_express_CtOutSize15;
    @Column(name = "flag_express_ct_out_size_16")
    private Long flag_express_CtOutSize16;
    @Column(name = "flag_express_ct_out_size_17")
    private Long flag_express_CtOutSize17;
    @Column(name = "flag_express_ct_out_size_18")
    private Long flag_express_CtOutSize18;
    @Column(name = "flag_express_ct_out_size_1_t")
    private Long flag_express_CtOutSize1T;
    @Column(name = "flag_express_ct_out_size_2_t")
    private Long flag_express_CtOutSize2T;
    @Column(name = "flag_express_ct_out_size_3_t")
    private Long flag_express_CtOutSize3T;
    @Column(name = "flag_express_ct_out_size_4_t")
    private Long flag_express_CtOutSize4T;
    @Column(name = "flag_express_ct_out_size_5_t")
    private Long flag_express_CtOutSize5T;
    @Column(name = "flag_express_ct_out_size_6_t")
    private Long flag_express_CtOutSize6T;
    @Column(name = "flag_express_ct_out_size_7_t")
    private Long flag_express_CtOutSize7T;
    @Column(name = "flag_express_ct_out_size_8_t")
    private Long flag_express_CtOutSize8T;
    @Column(name = "flag_express_ct_out_size_9_t")
    private Long flag_express_CtOutSize9T;
    @Column(name = "flag_express_ct_out_size_10_t")
    private Long flag_express_CtOutSize10T;
    @Column(name = "flag_express_ct_out_size_11_t")
    private Long flag_express_CtOutSize11T;
    @Column(name = "flag_express_ct_out_size_12_t")
    private Long flag_express_CtOutSize12T;
    @Column(name = "flag_express_ct_out_size_13_t")
    private Long flag_express_CtOutSize13T;
    
    @Column(name = "flag_express_prep_in_size_1")
    private Long flag_express_PrepInSize1;
    @Column(name = "flag_express_prep_in_size_2")
    private Long flag_express_PrepInSize2;
    @Column(name = "flag_express_prep_in_size_3")
    private Long flag_express_PrepInSize3;
    @Column(name = "flag_express_prep_in_size_4")
    private Long flag_express_PrepInSize4;
    @Column(name = "flag_express_prep_in_size_5")
    private Long flag_express_PrepInSize5;
    @Column(name = "flag_express_prep_in_size_6")
    private Long flag_express_PrepInSize6;
    @Column(name = "flag_express_prep_in_size_7")
    private Long flag_express_PrepInSize7;
    @Column(name = "flag_express_prep_in_size_8")
    private Long flag_express_PrepInSize8;
    @Column(name = "flag_express_prep_in_size_9")
    private Long flag_express_PrepInSize9;
    @Column(name = "flag_express_prep_in_size_10")
    private Long flag_express_PrepInSize10;
    @Column(name = "flag_express_prep_in_size_11")
    private Long flag_express_PrepInSize11;
    @Column(name = "flag_express_prep_in_size_12")
    private Long flag_express_PrepInSize12;
    @Column(name = "flag_express_prep_in_size_13")
    private Long flag_express_PrepInSize13;
    @Column(name = "flag_express_prep_in_size_14")
    private Long flag_express_PrepInSize14;
    @Column(name = "flag_express_prep_in_size_15")
    private Long flag_express_PrepInSize15;
    @Column(name = "flag_express_prep_in_size_16")
    private Long flag_express_PrepInSize16;
    @Column(name = "flag_express_prep_in_size_17")
    private Long flag_express_PrepInSize17;
    @Column(name = "flag_express_prep_in_size_18")
    private Long flag_express_PrepInSize18;
    @Column(name = "flag_express_prep_in_size_1_t")
    private Long flag_express_PrepInSize1T;
    @Column(name = "flag_express_prep_in_size_2_t")
    private Long flag_express_PrepInSize2T;
    @Column(name = "flag_express_prep_in_size_3_t")
    private Long flag_express_PrepInSize3T;
    @Column(name = "flag_express_prep_in_size_4_t")
    private Long flag_express_PrepInSize4T;
    @Column(name = "flag_express_prep_in_size_5_t")
    private Long flag_express_PrepInSize5T;
    @Column(name = "flag_express_prep_in_size_6_t")
    private Long flag_express_PrepInSize6T;
    @Column(name = "flag_express_prep_in_size_7_t")
    private Long flag_express_PrepInSize7T;
    @Column(name = "flag_express_prep_in_size_8_t")
    private Long flag_express_PrepInSize8T;
    @Column(name = "flag_express_prep_in_size_9_t")
    private Long flag_express_PrepInSize9T;
    @Column(name = "flag_express_prep_in_size_10_t")
    private Long flag_express_PrepInSize10T;
    @Column(name = "flag_express_prep_in_size_11_t")
    private Long flag_express_PrepInSize11T;
    @Column(name = "flag_express_prep_in_size_12_t")
    private Long flag_express_PrepInSize12T;
    @Column(name = "flag_express_prep_in_size_13_t")
    private Long flag_express_PrepInSize13T;
    
    @Column(name = "flag_express_prep_out_size_1")
    private Long flag_express_PrepOutSize1;
    @Column(name = "flag_express_prep_out_size_2")
    private Long flag_express_PrepOutSize2;
    @Column(name = "flag_express_prep_out_size_3")
    private Long flag_express_PrepOutSize3;
    @Column(name = "flag_express_prep_out_size_4")
    private Long flag_express_PrepOutSize4;
    @Column(name = "flag_express_prep_out_size_5")
    private Long flag_express_PrepOutSize5;
    @Column(name = "flag_express_prep_out_size_6")
    private Long flag_express_PrepOutSize6;
    @Column(name = "flag_express_prep_out_size_7")
    private Long flag_express_PrepOutSize7;
    @Column(name = "flag_express_prep_out_size_8")
    private Long flag_express_PrepOutSize8;
    @Column(name = "flag_express_prep_out_size_9")
    private Long flag_express_PrepOutSize9;
    @Column(name = "flag_express_prep_out_size_10")
    private Long flag_express_PrepOutSize10;
    @Column(name = "flag_express_prep_out_size_11")
    private Long flag_express_PrepOutSize11;
    @Column(name = "flag_express_prep_out_size_12")
    private Long flag_express_PrepOutSize12;
    @Column(name = "flag_express_prep_out_size_13")
    private Long flag_express_PrepOutSize13;
    @Column(name = "flag_express_prep_out_size_14")
    private Long flag_express_PrepOutSize14;
    @Column(name = "flag_express_prep_out_size_15")
    private Long flag_express_PrepOutSize15;
    @Column(name = "flag_express_prep_out_size_16")
    private Long flag_express_PrepOutSize16;
    @Column(name = "flag_express_prep_out_size_17")
    private Long flag_express_PrepOutSize17;
    @Column(name = "flag_express_prep_out_size_18")
    private Long flag_express_PrepOutSize18;
    @Column(name = "flag_express_prep_out_size_1_t")
    private Long flag_express_PrepOutSize1T;
    @Column(name = "flag_express_prep_out_size_2_t")
    private Long flag_express_PrepOutSize2T;
    @Column(name = "flag_express_prep_out_size_3_t")
    private Long flag_express_PrepOutSize3T;
    @Column(name = "flag_express_prep_out_size_4_t")
    private Long flag_express_PrepOutSize4T;
    @Column(name = "flag_express_prep_out_size_5_t")
    private Long flag_express_PrepOutSize5T;
    @Column(name = "flag_express_prep_out_size_6_t")
    private Long flag_express_PrepOutSize6T;
    @Column(name = "flag_express_prep_out_size_7_t")
    private Long flag_express_PrepOutSize7T;
    @Column(name = "flag_express_prep_out_size_8_t")
    private Long flag_express_PrepOutSize8T;
    @Column(name = "flag_express_prep_out_size_9_t")
    private Long flag_express_PrepOutSize9T;
    @Column(name = "flag_express_prep_out_size_10_t")
    private Long flag_express_PrepOutSize10T;
    @Column(name = "flag_express_prep_out_size_11_t")
    private Long flag_express_PrepOutSize11T;
    @Column(name = "flag_express_prep_out_size_12_t")
    private Long flag_express_PrepOutSize12T;
    @Column(name = "flag_express_prep_out_size_13_t")
    private Long flag_express_PrepOutSize13T;
    
    @Column(name = "flag_express_st_in_size_1")
    private Long flag_express_StInSize1;
    @Column(name = "flag_express_st_in_size_2")
    private Long flag_express_StInSize2;
    @Column(name = "flag_express_st_in_size_3")
    private Long flag_express_StInSize3;
    @Column(name = "flag_express_st_in_size_4")
    private Long flag_express_StInSize4;
    @Column(name = "flag_express_st_in_size_5")
    private Long flag_express_StInSize5;
    @Column(name = "flag_express_st_in_size_6")
    private Long flag_express_StInSize6;
    @Column(name = "flag_express_st_in_size_7")
    private Long flag_express_StInSize7;
    @Column(name = "flag_express_st_in_size_8")
    private Long flag_express_StInSize8;
    @Column(name = "flag_express_st_in_size_9")
    private Long flag_express_StInSize9;
    @Column(name = "flag_express_st_in_size_10")
    private Long flag_express_StInSize10;
    @Column(name = "flag_express_st_in_size_11")
    private Long flag_express_StInSize11;
    @Column(name = "flag_express_st_in_size_12")
    private Long flag_express_StInSize12;
    @Column(name = "flag_express_st_in_size_13")
    private Long flag_express_StInSize13;
    @Column(name = "flag_express_st_in_size_14")
    private Long flag_express_StInSize14;
    @Column(name = "flag_express_st_in_size_15")
    private Long flag_express_StInSize15;
    @Column(name = "flag_express_st_in_size_16")
    private Long flag_express_StInSize16;
    @Column(name = "flag_express_st_in_size_17")
    private Long flag_express_StInSize17;
    @Column(name = "flag_express_st_in_size_18")
    private Long flag_express_StInSize18;
    @Column(name = "flag_express_st_in_size_1_t")
    private Long flag_express_StInSize1T;
    @Column(name = "flag_express_st_in_size_2_t")
    private Long flag_express_StInSize2T;
    @Column(name = "flag_express_st_in_size_3_t")
    private Long flag_express_StInSize3T;
    @Column(name = "flag_express_st_in_size_4_t")
    private Long flag_express_StInSize4T;
    @Column(name = "flag_express_st_in_size_5_t")
    private Long flag_express_StInSize5T;
    @Column(name = "flag_express_st_in_size_6_t")
    private Long flag_express_StInSize6T;
    @Column(name = "flag_express_st_in_size_7_t")
    private Long flag_express_StInSize7T;
    @Column(name = "flag_express_st_in_size_8_t")
    private Long flag_express_StInSize8T;
    @Column(name = "flag_express_st_in_size_9_t")
    private Long flag_express_StInSize9T;
    @Column(name = "flag_express_st_in_size_10_t")
    private Long flag_express_StInSize10T;
    @Column(name = "flag_express_st_in_size_11_t")
    private Long flag_express_StInSize11T;
    @Column(name = "flag_express_st_in_size_12_t")
    private Long flag_express_StInSize12T;
    @Column(name = "flag_express_st_in_size_13_t")
    private Long flag_express_StInSize13T;
    
    @Column(name = "flag_express_st_out_size_1")
    private Long flag_express_StOutSize1;
    @Column(name = "flag_express_st_out_size_2")
    private Long flag_express_StOutSize2;
    @Column(name = "flag_express_st_out_size_3")
    private Long flag_express_StOutSize3;
    @Column(name = "flag_express_st_out_size_4")
    private Long flag_express_StOutSize4;
    @Column(name = "flag_express_st_out_size_5")
    private Long flag_express_StOutSize5;
    @Column(name = "flag_express_st_out_size_6")
    private Long flag_express_StOutSize6;
    @Column(name = "flag_express_st_out_size_7")
    private Long flag_express_StOutSize7;
    @Column(name = "flag_express_st_out_size_8")
    private Long flag_express_StOutSize8;
    @Column(name = "flag_express_st_out_size_9")
    private Long flag_express_StOutSize9;
    @Column(name = "flag_express_st_out_size_10")
    private Long flag_express_StOutSize10;
    @Column(name = "flag_express_st_out_size_11")
    private Long flag_express_StOutSize11;
    @Column(name = "flag_express_st_out_size_12")
    private Long flag_express_StOutSize12;
    @Column(name = "flag_express_st_out_size_13")
    private Long flag_express_StOutSize13;
    @Column(name = "flag_express_st_out_size_14")
    private Long flag_express_StOutSize14;
    @Column(name = "flag_express_st_out_size_15")
    private Long flag_express_StOutSize15;
    @Column(name = "flag_express_st_out_size_16")
    private Long flag_express_StOutSize16;
    @Column(name = "flag_express_st_out_size_17")
    private Long flag_express_StOutSize17;
    @Column(name = "flag_express_st_out_size_18")
    private Long flag_express_StOutSize18;
    @Column(name = "flag_express_st_out_size_1_t")
    private Long flag_express_StOutSize1T;
    @Column(name = "flag_express_st_out_size_2_t")
    private Long flag_express_StOutSize2T;
    @Column(name = "flag_express_st_out_size_3_t")
    private Long flag_express_StOutSize3T;
    @Column(name = "flag_express_st_out_size_4_t")
    private Long flag_express_StOutSize4T;
    @Column(name = "flag_express_st_out_size_5_t")
    private Long flag_express_StOutSize5T;
    @Column(name = "flag_express_st_out_size_6_t")
    private Long flag_express_StOutSize6T;
    @Column(name = "flag_express_st_out_size_7_t")
    private Long flag_express_StOutSize7T;
    @Column(name = "flag_express_st_out_size_8_t")
    private Long flag_express_StOutSize8T;
    @Column(name = "flag_express_st_out_size_9_t")
    private Long flag_express_StOutSize9T;
    @Column(name = "flag_express_st_out_size_10_t")
    private Long flag_express_StOutSize10T;
    @Column(name = "flag_express_st_out_size_11_t")
    private Long flag_express_StOutSize11T;
    @Column(name = "flag_express_st_out_size_12_t")
    private Long flag_express_StOutSize12T;
    @Column(name = "flag_express_st_out_size_13_t")
    private Long flag_express_StOutSize13T;
    
    @Column(name = "flag_express_as_in_size_1")
    private Long flag_express_AsInSize1;
    @Column(name = "flag_express_as_in_size_2")
    private Long flag_express_AsInSize2;
    @Column(name = "flag_express_as_in_size_3")
    private Long flag_express_AsInSize3;
    @Column(name = "flag_express_as_in_size_4")
    private Long flag_express_AsInSize4;
    @Column(name = "flag_express_as_in_size_5")
    private Long flag_express_AsInSize5;
    @Column(name = "flag_express_as_in_size_6")
    private Long flag_express_AsInSize6;
    @Column(name = "flag_express_as_in_size_7")
    private Long flag_express_AsInSize7;
    @Column(name = "flag_express_as_in_size_8")
    private Long flag_express_AsInSize8;
    @Column(name = "flag_express_as_in_size_9")
    private Long flag_express_AsInSize9;
    @Column(name = "flag_express_as_in_size_10")
    private Long flag_express_AsInSize10;
    @Column(name = "flag_express_as_in_size_11")
    private Long flag_express_AsInSize11;
    @Column(name = "flag_express_as_in_size_12")
    private Long flag_express_AsInSize12;
    @Column(name = "flag_express_as_in_size_13")
    private Long flag_express_AsInSize13;
    @Column(name = "flag_express_as_in_size_14")
    private Long flag_express_AsInSize14;
    @Column(name = "flag_express_as_in_size_15")
    private Long flag_express_AsInSize15;
    @Column(name = "flag_express_as_in_size_16")
    private Long flag_express_AsInSize16;
    @Column(name = "flag_express_as_in_size_17")
    private Long flag_express_AsInSize17;
    @Column(name = "flag_express_as_in_size_18")
    private Long flag_express_AsInSize18;
    @Column(name = "flag_express_as_in_size_1_t")
    private Long flag_express_AsInSize1T;
    @Column(name = "flag_express_as_in_size_2_t")
    private Long flag_express_AsInSize2T;
    @Column(name = "flag_express_as_in_size_3_t")
    private Long flag_express_AsInSize3T;
    @Column(name = "flag_express_as_in_size_4_t")
    private Long flag_express_AsInSize4T;
    @Column(name = "flag_express_as_in_size_5_t")
    private Long flag_express_AsInSize5T;
    @Column(name = "flag_express_as_in_size_6_t")
    private Long flag_express_AsInSize6T;
    @Column(name = "flag_express_as_in_size_7_t")
    private Long flag_express_AsInSize7T;
    @Column(name = "flag_express_as_in_size_8_t")
    private Long flag_express_AsInSize8T;
    @Column(name = "flag_express_as_in_size_9_t")
    private Long flag_express_AsInSize9T;
    @Column(name = "flag_express_as_in_size_10_t")
    private Long flag_express_AsInSize10T;
    @Column(name = "flag_express_as_in_size_11_t")
    private Long flag_express_AsInSize11T;
    @Column(name = "flag_express_as_in_size_12_t")
    private Long flag_express_AsInSize12T;
    @Column(name = "flag_express_as_in_size_13_t")
    private Long flag_express_AsInSize13T;
    
    @Column(name = "flag_express_as_out_size_1")
    private Long flag_express_AsOutSize1;
    @Column(name = "flag_express_as_out_size_2")
    private Long flag_express_AsOutSize2;
    @Column(name = "flag_express_as_out_size_3")
    private Long flag_express_AsOutSize3;
    @Column(name = "flag_express_as_out_size_4")
    private Long flag_express_AsOutSize4;
    @Column(name = "flag_express_as_out_size_5")
    private Long flag_express_AsOutSize5;
    @Column(name = "flag_express_as_out_size_6")
    private Long flag_express_AsOutSize6;
    @Column(name = "flag_express_as_out_size_7")
    private Long flag_express_AsOutSize7;
    @Column(name = "flag_express_as_out_size_8")
    private Long flag_express_AsOutSize8;
    @Column(name = "flag_express_as_out_size_9")
    private Long flag_express_AsOutSize9;
    @Column(name = "flag_express_as_out_size_10")
    private Long flag_express_AsOutSize10;
    @Column(name = "flag_express_as_out_size_11")
    private Long flag_express_AsOutSize11;
    @Column(name = "flag_express_as_out_size_12")
    private Long flag_express_AsOutSize12;
    @Column(name = "flag_express_as_out_size_13")
    private Long flag_express_AsOutSize13;
    @Column(name = "flag_express_as_out_size_14")
    private Long flag_express_AsOutSize14;
    @Column(name = "flag_express_as_out_size_15")
    private Long flag_express_AsOutSize15;
    @Column(name = "flag_express_as_out_size_16")
    private Long flag_express_AsOutSize16;
    @Column(name = "flag_express_as_out_size_17")
    private Long flag_express_AsOutSize17;
    @Column(name = "flag_express_as_out_size_18")
    private Long flag_express_AsOutSize18;
    @Column(name = "flag_express_as_out_size_1_t")
    private Long flag_express_AsOutSize1T;
    @Column(name = "flag_express_as_out_size_2_t")
    private Long flag_express_AsOutSize2T;
    @Column(name = "flag_express_as_out_size_3_t")
    private Long flag_express_AsOutSize3T;
    @Column(name = "flag_express_as_out_size_4_t")
    private Long flag_express_AsOutSize4T;
    @Column(name = "flag_express_as_out_size_5_t")
    private Long flag_express_AsOutSize5T;
    @Column(name = "flag_express_as_out_size_6_t")
    private Long flag_express_AsOutSize6T;
    @Column(name = "flag_express_as_out_size_7_t")
    private Long flag_express_AsOutSize7T;
    @Column(name = "flag_express_as_out_size_8_t")
    private Long flag_express_AsOutSize8T;
    @Column(name = "flag_express_as_out_size_9_t")
    private Long flag_express_AsOutSize9T;
    @Column(name = "flag_express_as_out_size_10_t")
    private Long flag_express_AsOutSize10T;
    @Column(name = "flag_express_as_out_size_11_t")
    private Long flag_express_AsOutSize11T;
    @Column(name = "flag_express_as_out_size_12_t")
    private Long flag_express_AsOutSize12T;
    @Column(name = "flag_express_as_out_size_13_t")
    private Long flag_express_AsOutSize13T;
    
    @Column(name = "flag_express_csc_in_size_1")
    private Long flag_express_CscInSize1;
    @Column(name = "flag_express_csc_in_size_2")
    private Long flag_express_CscInSize2;
    @Column(name = "flag_express_csc_in_size_3")
    private Long flag_express_CscInSize3;
    @Column(name = "flag_express_csc_in_size_4")
    private Long flag_express_CscInSize4;
    @Column(name = "flag_express_csc_in_size_5")
    private Long flag_express_CscInSize5;
    @Column(name = "flag_express_csc_in_size_6")
    private Long flag_express_CscInSize6;
    @Column(name = "flag_express_csc_in_size_7")
    private Long flag_express_CscInSize7;
    @Column(name = "flag_express_csc_in_size_8")
    private Long flag_express_CscInSize8;
    @Column(name = "flag_express_csc_in_size_9")
    private Long flag_express_CscInSize9;
    @Column(name = "flag_express_csc_in_size_10")
    private Long flag_express_CscInSize10;
    @Column(name = "flag_express_csc_in_size_11")
    private Long flag_express_CscInSize11;
    @Column(name = "flag_express_csc_in_size_12")
    private Long flag_express_CscInSize12;
    @Column(name = "flag_express_csc_in_size_13")
    private Long flag_express_CscInSize13;
    @Column(name = "flag_express_csc_in_size_14")
    private Long flag_express_CscInSize14;
    @Column(name = "flag_express_csc_in_size_15")
    private Long flag_express_CscInSize15;
    @Column(name = "flag_express_csc_in_size_16")
    private Long flag_express_CscInSize16;
    @Column(name = "flag_express_csc_in_size_17")
    private Long flag_express_CscInSize17;
    @Column(name = "flag_express_csc_in_size_18")
    private Long flag_express_CscInSize18;
    @Column(name = "flag_express_csc_in_size_1_t")
    private Long flag_express_CscInSize1T;
    @Column(name = "flag_express_csc_in_size_2_t")
    private Long flag_express_CscInSize2T;
    @Column(name = "flag_express_csc_in_size_3_t")
    private Long flag_express_CscInSize3T;
    @Column(name = "flag_express_csc_in_size_4_t")
    private Long flag_express_CscInSize4T;
    @Column(name = "flag_express_csc_in_size_5_t")
    private Long flag_express_CscInSize5T;
    @Column(name = "flag_express_csc_in_size_6_t")
    private Long flag_express_CscInSize6T;
    @Column(name = "flag_express_csc_in_size_7_t")
    private Long flag_express_CscInSize7T;
    @Column(name = "flag_express_csc_in_size_8_t")
    private Long flag_express_CscInSize8T;
    @Column(name = "flag_express_csc_in_size_9_t")
    private Long flag_express_CscInSize9T;
    @Column(name = "flag_express_csc_in_size_10_t")
    private Long flag_express_CscInSize10T;
    @Column(name = "flag_express_csc_in_size_11_t")
    private Long flag_express_CscInSize11T;
    @Column(name = "flag_express_csc_in_size_12_t")
    private Long flag_express_CscInSize12T;
    @Column(name = "flag_express_csc_in_size_13_t")
    private Long flag_express_CscInSize13T;
    
    @Column(name = "flag_express_csc_out_size_1")
    private Long flag_express_CscOutSize1;
    @Column(name = "flag_express_csc_out_size_2")
    private Long flag_express_CscOutSize2;
    @Column(name = "flag_express_csc_out_size_3")
    private Long flag_express_CscOutSize3;
    @Column(name = "flag_express_csc_out_size_4")
    private Long flag_express_CscOutSize4;
    @Column(name = "flag_express_csc_out_size_5")
    private Long flag_express_CscOutSize5;
    @Column(name = "flag_express_csc_out_size_6")
    private Long flag_express_CscOutSize6;
    @Column(name = "flag_express_csc_out_size_7")
    private Long flag_express_CscOutSize7;
    @Column(name = "flag_express_csc_out_size_8")
    private Long flag_express_CscOutSize8;
    @Column(name = "flag_express_csc_out_size_9")
    private Long flag_express_CscOutSize9;
    @Column(name = "flag_express_csc_out_size_10")
    private Long flag_express_CscOutSize10;
    @Column(name = "flag_express_csc_out_size_11")
    private Long flag_express_CscOutSize11;
    @Column(name = "flag_express_csc_out_size_12")
    private Long flag_express_CscOutSize12;
    @Column(name = "flag_express_csc_out_size_13")
    private Long flag_express_CscOutSize13;
    @Column(name = "flag_express_csc_out_size_14")
    private Long flag_express_CscOutSize14;
    @Column(name = "flag_express_csc_out_size_15")
    private Long flag_express_CscOutSize15;
    @Column(name = "flag_express_csc_out_size_16")
    private Long flag_express_CscOutSize16;
    @Column(name = "flag_express_csc_out_size_17")
    private Long flag_express_CscOutSize17;
    @Column(name = "flag_express_csc_out_size_18")
    private Long flag_express_CscOutSize18;
    @Column(name = "flag_express_csc_out_size_1_t")
    private Long flag_express_CscOutSize1T;
    @Column(name = "flag_express_csc_out_size_2_t")
    private Long flag_express_CscOutSize2T;
    @Column(name = "flag_express_csc_out_size_3_t")
    private Long flag_express_CscOutSize3T;
    @Column(name = "flag_express_csc_out_size_4_t")
    private Long flag_express_CscOutSize4T;
    @Column(name = "flag_express_csc_out_size_5_t")
    private Long flag_express_CscOutSize5T;
    @Column(name = "flag_express_csc_out_size_6_t")
    private Long flag_express_CscOutSize6T;
    @Column(name = "flag_express_csc_out_size_7_t")
    private Long flag_express_CscOutSize7T;
    @Column(name = "flag_express_csc_out_size_8_t")
    private Long flag_express_CscOutSize8T;
    @Column(name = "flag_express_csc_out_size_9_t")
    private Long flag_express_CscOutSize9T;
    @Column(name = "flag_express_csc_out_size_10_t")
    private Long flag_express_CscOutSize10T;
    @Column(name = "flag_express_csc_out_size_11_t")
    private Long flag_express_CscOutSize11T;
    @Column(name = "flag_express_csc_out_size_12_t")
    private Long flag_express_CscOutSize12T;
    @Column(name = "flag_express_csc_out_size_13_t")
    private Long flag_express_CscOutSize13T;
    
    @Column(name = "flag_express_ns_in_size_1")
    private Long flag_express_NsInSize1;
    @Column(name = "flag_express_ns_in_size_2")
    private Long flag_express_NsInSize2;
    @Column(name = "flag_express_ns_in_size_3")
    private Long flag_express_NsInSize3;
    @Column(name = "flag_express_ns_in_size_4")
    private Long flag_express_NsInSize4;
    @Column(name = "flag_express_ns_in_size_5")
    private Long flag_express_NsInSize5;
    @Column(name = "flag_express_ns_in_size_6")
    private Long flag_express_NsInSize6;
    @Column(name = "flag_express_ns_in_size_7")
    private Long flag_express_NsInSize7;
    @Column(name = "flag_express_ns_in_size_8")
    private Long flag_express_NsInSize8;
    @Column(name = "flag_express_ns_in_size_9")
    private Long flag_express_NsInSize9;
    @Column(name = "flag_express_ns_in_size_10")
    private Long flag_express_NsInSize10;
    @Column(name = "flag_express_ns_in_size_11")
    private Long flag_express_NsInSize11;
    @Column(name = "flag_express_ns_in_size_12")
    private Long flag_express_NsInSize12;
    @Column(name = "flag_express_ns_in_size_13")
    private Long flag_express_NsInSize13;
    @Column(name = "flag_express_ns_in_size_14")
    private Long flag_express_NsInSize14;
    @Column(name = "flag_express_ns_in_size_15")
    private Long flag_express_NsInSize15;
    @Column(name = "flag_express_ns_in_size_16")
    private Long flag_express_NsInSize16;
    @Column(name = "flag_express_ns_in_size_17")
    private Long flag_express_NsInSize17;
    @Column(name = "flag_express_ns_in_size_18")
    private Long flag_express_NsInSize18;
    @Column(name = "flag_express_ns_in_size_1_t")
    private Long flag_express_NsInSize1T;
    @Column(name = "flag_express_ns_in_size_2_t")
    private Long flag_express_NsInSize2T;
    @Column(name = "flag_express_ns_in_size_3_t")
    private Long flag_express_NsInSize3T;
    @Column(name = "flag_express_ns_in_size_4_t")
    private Long flag_express_NsInSize4T;
    @Column(name = "flag_express_ns_in_size_5_t")
    private Long flag_express_NsInSize5T;
    @Column(name = "flag_express_ns_in_size_6_t")
    private Long flag_express_NsInSize6T;
    @Column(name = "flag_express_ns_in_size_7_t")
    private Long flag_express_NsInSize7T;
    @Column(name = "flag_express_ns_in_size_8_t")
    private Long flag_express_NsInSize8T;
    @Column(name = "flag_express_ns_in_size_9_t")
    private Long flag_express_NsInSize9T;
    @Column(name = "flag_express_ns_in_size_10_t")
    private Long flag_express_NsInSize10T;
    @Column(name = "flag_express_ns_in_size_11_t")
    private Long flag_express_NsInSize11T;
    @Column(name = "flag_express_ns_in_size_12_t")
    private Long flag_express_NsInSize12T;
    @Column(name = "flag_express_ns_in_size_13_t")
    private Long flag_express_NsInSize13T;
    
    @Column(name = "flag_express_ns_out_size_1")
    private Long flag_express_NsOutSize1;
    @Column(name = "flag_express_ns_out_size_2")
    private Long flag_express_NsOutSize2;
    @Column(name = "flag_express_ns_out_size_3")
    private Long flag_express_NsOutSize3;
    @Column(name = "flag_express_ns_out_size_4")
    private Long flag_express_NsOutSize4;
    @Column(name = "flag_express_ns_out_size_5")
    private Long flag_express_NsOutSize5;
    @Column(name = "flag_express_ns_out_size_6")
    private Long flag_express_NsOutSize6;
    @Column(name = "flag_express_ns_out_size_7")
    private Long flag_express_NsOutSize7;
    @Column(name = "flag_express_ns_out_size_8")
    private Long flag_express_NsOutSize8;
    @Column(name = "flag_express_ns_out_size_9")
    private Long flag_express_NsOutSize9;
    @Column(name = "flag_express_ns_out_size_10")
    private Long flag_express_NsOutSize10;
    @Column(name = "flag_express_ns_out_size_11")
    private Long flag_express_NsOutSize11;
    @Column(name = "flag_express_ns_out_size_12")
    private Long flag_express_NsOutSize12;
    @Column(name = "flag_express_ns_out_size_13")
    private Long flag_express_NsOutSize13;
    @Column(name = "flag_express_ns_out_size_14")
    private Long flag_express_NsOutSize14;
    @Column(name = "flag_express_ns_out_size_15")
    private Long flag_express_NsOutSize15;
    @Column(name = "flag_express_ns_out_size_16")
    private Long flag_express_NsOutSize16;
    @Column(name = "flag_express_ns_out_size_17")
    private Long flag_express_NsOutSize17;
    @Column(name = "flag_express_ns_out_size_18")
    private Long flag_express_NsOutSize18;
    @Column(name = "flag_express_ns_out_size_1_t")
    private Long flag_express_NsOutSize1T;
    @Column(name = "flag_express_ns_out_size_2_t")
    private Long flag_express_NsOutSize2T;
    @Column(name = "flag_express_ns_out_size_3_t")
    private Long flag_express_NsOutSize3T;
    @Column(name = "flag_express_ns_out_size_4_t")
    private Long flag_express_NsOutSize4T;
    @Column(name = "flag_express_ns_out_size_5_t")
    private Long flag_express_NsOutSize5T;
    @Column(name = "flag_express_ns_out_size_6_t")
    private Long flag_express_NsOutSize6T;
    @Column(name = "flag_express_ns_out_size_7_t")
    private Long flag_express_NsOutSize7T;
    @Column(name = "flag_express_ns_out_size_8_t")
    private Long flag_express_NsOutSize8T;
    @Column(name = "flag_express_ns_out_size_9_t")
    private Long flag_express_NsOutSize9T;
    @Column(name = "flag_express_ns_out_size_10_t")
    private Long flag_express_NsOutSize10T;
    @Column(name = "flag_express_ns_out_size_11_t")
    private Long flag_express_NsOutSize11T;
    @Column(name = "flag_express_ns_out_size_12_t")
    private Long flag_express_NsOutSize12T;
    @Column(name = "flag_express_ns_out_size_13_t")
    private Long flag_express_NsOutSize13T;
    
    @Column(name = "flag_express_sc_in_size_1")
    private Long flag_express_ScInSize1;
    @Column(name = "flag_express_sc_in_size_2")
    private Long flag_express_ScInSize2;
    @Column(name = "flag_express_sc_in_size_3")
    private Long flag_express_ScInSize3;
    @Column(name = "flag_express_sc_in_size_4")
    private Long flag_express_ScInSize4;
    @Column(name = "flag_express_sc_in_size_5")
    private Long flag_express_ScInSize5;
    @Column(name = "flag_express_sc_in_size_6")
    private Long flag_express_ScInSize6;
    @Column(name = "flag_express_sc_in_size_7")
    private Long flag_express_ScInSize7;
    @Column(name = "flag_express_sc_in_size_8")
    private Long flag_express_ScInSize8;
    @Column(name = "flag_express_sc_in_size_9")
    private Long flag_express_ScInSize9;
    @Column(name = "flag_express_sc_in_size_10")
    private Long flag_express_ScInSize10;
    @Column(name = "flag_express_sc_in_size_11")
    private Long flag_express_ScInSize11;
    @Column(name = "flag_express_sc_in_size_12")
    private Long flag_express_ScInSize12;
    @Column(name = "flag_express_sc_in_size_13")
    private Long flag_express_ScInSize13;
    @Column(name = "flag_express_sc_in_size_14")
    private Long flag_express_ScInSize14;
    @Column(name = "flag_express_sc_in_size_15")
    private Long flag_express_ScInSize15;
    @Column(name = "flag_express_sc_in_size_16")
    private Long flag_express_ScInSize16;
    @Column(name = "flag_express_sc_in_size_17")
    private Long flag_express_ScInSize17;
    @Column(name = "flag_express_sc_in_size_18")
    private Long flag_express_ScInSize18;
    @Column(name = "flag_express_sc_in_size_1_t")
    private Long flag_express_ScInSize1T;
    @Column(name = "flag_express_sc_in_size_2_t")
    private Long flag_express_ScInSize2T;
    @Column(name = "flag_express_sc_in_size_3_t")
    private Long flag_express_ScInSize3T;
    @Column(name = "flag_express_sc_in_size_4_t")
    private Long flag_express_ScInSize4T;
    @Column(name = "flag_express_sc_in_size_5_t")
    private Long flag_express_ScInSize5T;
    @Column(name = "flag_express_sc_in_size_6_t")
    private Long flag_express_ScInSize6T;
    @Column(name = "flag_express_sc_in_size_7_t")
    private Long flag_express_ScInSize7T;
    @Column(name = "flag_express_sc_in_size_8_t")
    private Long flag_express_ScInSize8T;
    @Column(name = "flag_express_sc_in_size_9_t")
    private Long flag_express_ScInSize9T;
    @Column(name = "flag_express_sc_in_size_10_t")
    private Long flag_express_ScInSize10T;
    @Column(name = "flag_express_sc_in_size_11_t")
    private Long flag_express_ScInSize11T;
    @Column(name = "flag_express_sc_in_size_12_t")
    private Long flag_express_ScInSize12T;
    @Column(name = "flag_express_sc_in_size_13_t")
    private Long flag_express_ScInSize13T;
    
    @Column(name = "flag_express_sc_out_size_1")
    private Long flag_express_ScOutSize1;
    @Column(name = "flag_express_sc_out_size_2")
    private Long flag_express_ScOutSize2;
    @Column(name = "flag_express_sc_out_size_3")
    private Long flag_express_ScOutSize3;
    @Column(name = "flag_express_sc_out_size_4")
    private Long flag_express_ScOutSize4;
    @Column(name = "flag_express_sc_out_size_5")
    private Long flag_express_ScOutSize5;
    @Column(name = "flag_express_sc_out_size_6")
    private Long flag_express_ScOutSize6;
    @Column(name = "flag_express_sc_out_size_7")
    private Long flag_express_ScOutSize7;
    @Column(name = "flag_express_sc_out_size_8")
    private Long flag_express_ScOutSize8;
    @Column(name = "flag_express_sc_out_size_9")
    private Long flag_express_ScOutSize9;
    @Column(name = "flag_express_sc_out_size_10")
    private Long flag_express_ScOutSize10;
    @Column(name = "flag_express_sc_out_size_11")
    private Long flag_express_ScOutSize11;
    @Column(name = "flag_express_sc_out_size_12")
    private Long flag_express_ScOutSize12;
    @Column(name = "flag_express_sc_out_size_13")
    private Long flag_express_ScOutSize13;
    @Column(name = "flag_express_sc_out_size_14")
    private Long flag_express_ScOutSize14;
    @Column(name = "flag_express_sc_out_size_15")
    private Long flag_express_ScOutSize15;
    @Column(name = "flag_express_sc_out_size_16")
    private Long flag_express_ScOutSize16;
    @Column(name = "flag_express_sc_out_size_17")
    private Long flag_express_ScOutSize17;
    @Column(name = "flag_express_sc_out_size_18")
    private Long flag_express_ScOutSize18;
    @Column(name = "flag_express_sc_out_size_1_t")
    private Long flag_express_ScOutSize1T;
    @Column(name = "flag_express_sc_out_size_2_t")
    private Long flag_express_ScOutSize2T;
    @Column(name = "flag_express_sc_out_size_3_t")
    private Long flag_express_ScOutSize3T;
    @Column(name = "flag_express_sc_out_size_4_t")
    private Long flag_express_ScOutSize4T;
    @Column(name = "flag_express_sc_out_size_5_t")
    private Long flag_express_ScOutSize5T;
    @Column(name = "flag_express_sc_out_size_6_t")
    private Long flag_express_ScOutSize6T;
    @Column(name = "flag_express_sc_out_size_7_t")
    private Long flag_express_ScOutSize7T;
    @Column(name = "flag_express_sc_out_size_8_t")
    private Long flag_express_ScOutSize8T;
    @Column(name = "flag_express_sc_out_size_9_t")
    private Long flag_express_ScOutSize9T;
    @Column(name = "flag_express_sc_out_size_10_t")
    private Long flag_express_ScOutSize10T;
    @Column(name = "flag_express_sc_out_size_11_t")
    private Long flag_express_ScOutSize11T;
    @Column(name = "flag_express_sc_out_size_12_t")
    private Long flag_express_ScOutSize12T;
    @Column(name = "flag_express_sc_out_size_13_t")
    private Long flag_express_ScOutSize13T;
    
    @Column(name = "flag_express_os_in_size_1")
    private Long flag_express_OsInSize1;
    @Column(name = "flag_express_os_in_size_2")
    private Long flag_express_OsInSize2;
    @Column(name = "flag_express_os_in_size_3")
    private Long flag_express_OsInSize3;
    @Column(name = "flag_express_os_in_size_4")
    private Long flag_express_OsInSize4;
    @Column(name = "flag_express_os_in_size_5")
    private Long flag_express_OsInSize5;
    @Column(name = "flag_express_os_in_size_6")
    private Long flag_express_OsInSize6;
    @Column(name = "flag_express_os_in_size_7")
    private Long flag_express_OsInSize7;
    @Column(name = "flag_express_os_in_size_8")
    private Long flag_express_OsInSize8;
    @Column(name = "flag_express_os_in_size_9")
    private Long flag_express_OsInSize9;
    @Column(name = "flag_express_os_in_size_10")
    private Long flag_express_OsInSize10;
    @Column(name = "flag_express_os_in_size_11")
    private Long flag_express_OsInSize11;
    @Column(name = "flag_express_os_in_size_12")
    private Long flag_express_OsInSize12;
    @Column(name = "flag_express_os_in_size_13")
    private Long flag_express_OsInSize13;
    @Column(name = "flag_express_os_in_size_14")
    private Long flag_express_OsInSize14;
    @Column(name = "flag_express_os_in_size_15")
    private Long flag_express_OsInSize15;
    @Column(name = "flag_express_os_in_size_16")
    private Long flag_express_OsInSize16;
    @Column(name = "flag_express_os_in_size_17")
    private Long flag_express_OsInSize17;
    @Column(name = "flag_express_os_in_size_18")
    private Long flag_express_OsInSize18;
    @Column(name = "flag_express_os_in_size_1_t")
    private Long flag_express_OsInSize1T;
    @Column(name = "flag_express_os_in_size_2_t")
    private Long flag_express_OsInSize2T;
    @Column(name = "flag_express_os_in_size_3_t")
    private Long flag_express_OsInSize3T;
    @Column(name = "flag_express_os_in_size_4_t")
    private Long flag_express_OsInSize4T;
    @Column(name = "flag_express_os_in_size_5_t")
    private Long flag_express_OsInSize5T;
    @Column(name = "flag_express_os_in_size_6_t")
    private Long flag_express_OsInSize6T;
    @Column(name = "flag_express_os_in_size_7_t")
    private Long flag_express_OsInSize7T;
    @Column(name = "flag_express_os_in_size_8_t")
    private Long flag_express_OsInSize8T;
    @Column(name = "flag_express_os_in_size_9_t")
    private Long flag_express_OsInSize9T;
    @Column(name = "flag_express_os_in_size_10_t")
    private Long flag_express_OsInSize10T;
    @Column(name = "flag_express_os_in_size_11_t")
    private Long flag_express_OsInSize11T;
    @Column(name = "flag_express_os_in_size_12_t")
    private Long flag_express_OsInSize12T;
    @Column(name = "flag_express_os_in_size_13_t")
    private Long flag_express_OsInSize13T;
    
    @Column(name = "flag_express_os_out_size_1")
    private Long flag_express_OsOutSize1;
    @Column(name = "flag_express_os_out_size_2")
    private Long flag_express_OsOutSize2;
    @Column(name = "flag_express_os_out_size_3")
    private Long flag_express_OsOutSize3;
    @Column(name = "flag_express_os_out_size_4")
    private Long flag_express_OsOutSize4;
    @Column(name = "flag_express_os_out_size_5")
    private Long flag_express_OsOutSize5;
    @Column(name = "flag_express_os_out_size_6")
    private Long flag_express_OsOutSize6;
    @Column(name = "flag_express_os_out_size_7")
    private Long flag_express_OsOutSize7;
    @Column(name = "flag_express_os_out_size_8")
    private Long flag_express_OsOutSize8;
    @Column(name = "flag_express_os_out_size_9")
    private Long flag_express_OsOutSize9;
    @Column(name = "flag_express_os_out_size_10")
    private Long flag_express_OsOutSize10;
    @Column(name = "flag_express_os_out_size_11")
    private Long flag_express_OsOutSize11;
    @Column(name = "flag_express_os_out_size_12")
    private Long flag_express_OsOutSize12;
    @Column(name = "flag_express_os_out_size_13")
    private Long flag_express_OsOutSize13;
    @Column(name = "flag_express_os_out_size_14")
    private Long flag_express_OsOutSize14;
    @Column(name = "flag_express_os_out_size_15")
    private Long flag_express_OsOutSize15;
    @Column(name = "flag_express_os_out_size_16")
    private Long flag_express_OsOutSize16;
    @Column(name = "flag_express_os_out_size_17")
    private Long flag_express_OsOutSize17;
    @Column(name = "flag_express_os_out_size_18")
    private Long flag_express_OsOutSize18;
    @Column(name = "flag_express_os_out_size_1_t")
    private Long flag_express_OsOutSize1T;
    @Column(name = "flag_express_os_out_size_2_t")
    private Long flag_express_OsOutSize2T;
    @Column(name = "flag_express_os_out_size_3_t")
    private Long flag_express_OsOutSize3T;
    @Column(name = "flag_express_os_out_size_4_t")
    private Long flag_express_OsOutSize4T;
    @Column(name = "flag_express_os_out_size_5_t")
    private Long flag_express_OsOutSize5T;
    @Column(name = "flag_express_os_out_size_6_t")
    private Long flag_express_OsOutSize6T;
    @Column(name = "flag_express_os_out_size_7_t")
    private Long flag_express_OsOutSize7T;
    @Column(name = "flag_express_os_out_size_8_t")
    private Long flag_express_OsOutSize8T;
    @Column(name = "flag_express_os_out_size_9_t")
    private Long flag_express_OsOutSize9T;
    @Column(name = "flag_express_os_out_size_10_t")
    private Long flag_express_OsOutSize10T;
    @Column(name = "flag_express_os_out_size_11_t")
    private Long flag_express_OsOutSize11T;
    @Column(name = "flag_express_os_out_size_12_t")
    private Long flag_express_OsOutSize12T;
    @Column(name = "flag_express_os_out_size_13_t")
    private Long flag_express_OsOutSize13T;
    
    @Column(name = "flag_express_spcut_in_size_1")
    private Long flag_express_SpcutInSize1;
    @Column(name = "flag_express_spcut_in_size_2")
    private Long flag_express_SpcutInSize2;
    @Column(name = "flag_express_spcut_in_size_3")
    private Long flag_express_SpcutInSize3;
    @Column(name = "flag_express_spcut_in_size_4")
    private Long flag_express_SpcutInSize4;
    @Column(name = "flag_express_spcut_in_size_5")
    private Long flag_express_SpcutInSize5;
    @Column(name = "flag_express_spcut_in_size_6")
    private Long flag_express_SpcutInSize6;
    @Column(name = "flag_express_spcut_in_size_7")
    private Long flag_express_SpcutInSize7;
    @Column(name = "flag_express_spcut_in_size_8")
    private Long flag_express_SpcutInSize8;
    @Column(name = "flag_express_spcut_in_size_9")
    private Long flag_express_SpcutInSize9;
    @Column(name = "flag_express_spcut_in_size_10")
    private Long flag_express_SpcutInSize10;
    @Column(name = "flag_express_spcut_in_size_11")
    private Long flag_express_SpcutInSize11;
    @Column(name = "flag_express_spcut_in_size_12")
    private Long flag_express_SpcutInSize12;
    @Column(name = "flag_express_spcut_in_size_13")
    private Long flag_express_SpcutInSize13;
    @Column(name = "flag_express_spcut_in_size_14")
    private Long flag_express_SpcutInSize14;
    @Column(name = "flag_express_spcut_in_size_15")
    private Long flag_express_SpcutInSize15;
    @Column(name = "flag_express_spcut_in_size_16")
    private Long flag_express_SpcutInSize16;
    @Column(name = "flag_express_spcut_in_size_17")
    private Long flag_express_SpcutInSize17;
    @Column(name = "flag_express_spcut_in_size_18")
    private Long flag_express_SpcutInSize18;
    @Column(name = "flag_express_spcut_in_size_1_t")
    private Long flag_express_SpcutInSize1T;
    @Column(name = "flag_express_spcut_in_size_2_t")
    private Long flag_express_SpcutInSize2T;
    @Column(name = "flag_express_spcut_in_size_3_t")
    private Long flag_express_SpcutInSize3T;
    @Column(name = "flag_express_spcut_in_size_4_t")
    private Long flag_express_SpcutInSize4T;
    @Column(name = "flag_express_spcut_in_size_5_t")
    private Long flag_express_SpcutInSize5T;
    @Column(name = "flag_express_spcut_in_size_6_t")
    private Long flag_express_SpcutInSize6T;
    @Column(name = "flag_express_spcut_in_size_7_t")
    private Long flag_express_SpcutInSize7T;
    @Column(name = "flag_express_spcut_in_size_8_t")
    private Long flag_express_SpcutInSize8T;
    @Column(name = "flag_express_spcut_in_size_9_t")
    private Long flag_express_SpcutInSize9T;
    @Column(name = "flag_express_spcut_in_size_10_t")
    private Long flag_express_SpcutInSize10T;
    @Column(name = "flag_express_spcut_in_size_11_t")
    private Long flag_express_SpcutInSize11T;
    @Column(name = "flag_express_spcut_in_size_12_t")
    private Long flag_express_SpcutInSize12T;
    @Column(name = "flag_express_spcut_in_size_13_t")
    private Long flag_express_SpcutInSize13T;
    
    @Column(name = "flag_express_spcut_out_size_1")
    private Long flag_express_SpcutOutSize1;
    @Column(name = "flag_express_spcut_out_size_2")
    private Long flag_express_SpcutOutSize2;
    @Column(name = "flag_express_spcut_out_size_3")
    private Long flag_express_SpcutOutSize3;
    @Column(name = "flag_express_spcut_out_size_4")
    private Long flag_express_SpcutOutSize4;
    @Column(name = "flag_express_spcut_out_size_5")
    private Long flag_express_SpcutOutSize5;
    @Column(name = "flag_express_spcut_out_size_6")
    private Long flag_express_SpcutOutSize6;
    @Column(name = "flag_express_spcut_out_size_7")
    private Long flag_express_SpcutOutSize7;
    @Column(name = "flag_express_spcut_out_size_8")
    private Long flag_express_SpcutOutSize8;
    @Column(name = "flag_express_spcut_out_size_9")
    private Long flag_express_SpcutOutSize9;
    @Column(name = "flag_express_spcut_out_size_10")
    private Long flag_express_SpcutOutSize10;
    @Column(name = "flag_express_spcut_out_size_11")
    private Long flag_express_SpcutOutSize11;
    @Column(name = "flag_express_spcut_out_size_12")
    private Long flag_express_SpcutOutSize12;
    @Column(name = "flag_express_spcut_out_size_13")
    private Long flag_express_SpcutOutSize13;
    @Column(name = "flag_express_spcut_out_size_14")
    private Long flag_express_SpcutOutSize14;
    @Column(name = "flag_express_spcut_out_size_15")
    private Long flag_express_SpcutOutSize15;
    @Column(name = "flag_express_spcut_out_size_16")
    private Long flag_express_SpcutOutSize16;
    @Column(name = "flag_express_spcut_out_size_17")
    private Long flag_express_SpcutOutSize17;
    @Column(name = "flag_express_spcut_out_size_18")
    private Long flag_express_SpcutOutSize18;
    @Column(name = "flag_express_spcut_out_size_1_t")
    private Long flag_express_SpcutOutSize1T;
    @Column(name = "flag_express_spcut_out_size_2_t")
    private Long flag_express_SpcutOutSize2T;
    @Column(name = "flag_express_spcut_out_size_3_t")
    private Long flag_express_SpcutOutSize3T;
    @Column(name = "flag_express_spcut_out_size_4_t")
    private Long flag_express_SpcutOutSize4T;
    @Column(name = "flag_express_spcut_out_size_5_t")
    private Long flag_express_SpcutOutSize5T;
    @Column(name = "flag_express_spcut_out_size_6_t")
    private Long flag_express_SpcutOutSize6T;
    @Column(name = "flag_express_spcut_out_size_7_t")
    private Long flag_express_SpcutOutSize7T;
    @Column(name = "flag_express_spcut_out_size_8_t")
    private Long flag_express_SpcutOutSize8T;
    @Column(name = "flag_express_spcut_out_size_9_t")
    private Long flag_express_SpcutOutSize9T;
    @Column(name = "flag_express_spcut_out_size_10_t")
    private Long flag_express_SpcutOutSize10T;
    @Column(name = "flag_express_spcut_out_size_11_t")
    private Long flag_express_SpcutOutSize11T;
    @Column(name = "flag_express_spcut_out_size_12_t")
    private Long flag_express_SpcutOutSize12T;
    @Column(name = "flag_express_spcut_out_size_13_t")
    private Long flag_express_SpcutOutSize13T;
    
    @Column(name = "flag_express_spprep_in_size_1")
    private Long flag_express_SpprepInSize1;
    @Column(name = "flag_express_spprep_in_size_2")
    private Long flag_express_SpprepInSize2;
    @Column(name = "flag_express_spprep_in_size_3")
    private Long flag_express_SpprepInSize3;
    @Column(name = "flag_express_spprep_in_size_4")
    private Long flag_express_SpprepInSize4;
    @Column(name = "flag_express_spprep_in_size_5")
    private Long flag_express_SpprepInSize5;
    @Column(name = "flag_express_spprep_in_size_6")
    private Long flag_express_SpprepInSize6;
    @Column(name = "flag_express_spprep_in_size_7")
    private Long flag_express_SpprepInSize7;
    @Column(name = "flag_express_spprep_in_size_8")
    private Long flag_express_SpprepInSize8;
    @Column(name = "flag_express_spprep_in_size_9")
    private Long flag_express_SpprepInSize9;
    @Column(name = "flag_express_spprep_in_size_10")
    private Long flag_express_SpprepInSize10;
    @Column(name = "flag_express_spprep_in_size_11")
    private Long flag_express_SpprepInSize11;
    @Column(name = "flag_express_spprep_in_size_12")
    private Long flag_express_SpprepInSize12;
    @Column(name = "flag_express_spprep_in_size_13")
    private Long flag_express_SpprepInSize13;
    @Column(name = "flag_express_spprep_in_size_14")
    private Long flag_express_SpprepInSize14;
    @Column(name = "flag_express_spprep_in_size_15")
    private Long flag_express_SpprepInSize15;
    @Column(name = "flag_express_spprep_in_size_16")
    private Long flag_express_SpprepInSize16;
    @Column(name = "flag_express_spprep_in_size_17")
    private Long flag_express_SpprepInSize17;
    @Column(name = "flag_express_spprep_in_size_18")
    private Long flag_express_SpprepInSize18;
    @Column(name = "flag_express_spprep_in_size_1_t")
    private Long flag_express_SpprepInSize1T;
    @Column(name = "flag_express_spprep_in_size_2_t")
    private Long flag_express_SpprepInSize2T;
    @Column(name = "flag_express_spprep_in_size_3_t")
    private Long flag_express_SpprepInSize3T;
    @Column(name = "flag_express_spprep_in_size_4_t")
    private Long flag_express_SpprepInSize4T;
    @Column(name = "flag_express_spprep_in_size_5_t")
    private Long flag_express_SpprepInSize5T;
    @Column(name = "flag_express_spprep_in_size_6_t")
    private Long flag_express_SpprepInSize6T;
    @Column(name = "flag_express_spprep_in_size_7_t")
    private Long flag_express_SpprepInSize7T;
    @Column(name = "flag_express_spprep_in_size_8_t")
    private Long flag_express_SpprepInSize8T;
    @Column(name = "flag_express_spprep_in_size_9_t")
    private Long flag_express_SpprepInSize9T;
    @Column(name = "flag_express_spprep_in_size_10_t")
    private Long flag_express_SpprepInSize10T;
    @Column(name = "flag_express_spprep_in_size_11_t")
    private Long flag_express_SpprepInSize11T;
    @Column(name = "flag_express_spprep_in_size_12_t")
    private Long flag_express_SpprepInSize12T;
    @Column(name = "flag_express_spprep_in_size_13_t")
    private Long flag_express_SpprepInSize13T;
    
    @Column(name = "flag_express_spprep_out_size_1")
    private Long flag_express_SpprepOutSize1;
    @Column(name = "flag_express_spprep_out_size_2")
    private Long flag_express_SpprepOutSize2;
    @Column(name = "flag_express_spprep_out_size_3")
    private Long flag_express_SpprepOutSize3;
    @Column(name = "flag_express_spprep_out_size_4")
    private Long flag_express_SpprepOutSize4;
    @Column(name = "flag_express_spprep_out_size_5")
    private Long flag_express_SpprepOutSize5;
    @Column(name = "flag_express_spprep_out_size_6")
    private Long flag_express_SpprepOutSize6;
    @Column(name = "flag_express_spprep_out_size_7")
    private Long flag_express_SpprepOutSize7;
    @Column(name = "flag_express_spprep_out_size_8")
    private Long flag_express_SpprepOutSize8;
    @Column(name = "flag_express_spprep_out_size_9")
    private Long flag_express_SpprepOutSize9;
    @Column(name = "flag_express_spprep_out_size_10")
    private Long flag_express_SpprepOutSize10;
    @Column(name = "flag_express_spprep_out_size_11")
    private Long flag_express_SpprepOutSize11;
    @Column(name = "flag_express_spprep_out_size_12")
    private Long flag_express_SpprepOutSize12;
    @Column(name = "flag_express_spprep_out_size_13")
    private Long flag_express_SpprepOutSize13;
    @Column(name = "flag_express_spprep_out_size_14")
    private Long flag_express_SpprepOutSize14;
    @Column(name = "flag_express_spprep_out_size_15")
    private Long flag_express_SpprepOutSize15;
    @Column(name = "flag_express_spprep_out_size_16")
    private Long flag_express_SpprepOutSize16;
    @Column(name = "flag_express_spprep_out_size_17")
    private Long flag_express_SpprepOutSize17;
    @Column(name = "flag_express_spprep_out_size_18")
    private Long flag_express_SpprepOutSize18;
    @Column(name = "flag_express_spprep_out_size_1_t")
    private Long flag_express_SpprepOutSize1T;
    @Column(name = "flag_express_spprep_out_size_2_t")
    private Long flag_express_SpprepOutSize2T;
    @Column(name = "flag_express_spprep_out_size_3_t")
    private Long flag_express_SpprepOutSize3T;
    @Column(name = "flag_express_spprep_out_size_4_t")
    private Long flag_express_SpprepOutSize4T;
    @Column(name = "flag_express_spprep_out_size_5_t")
    private Long flag_express_SpprepOutSize5T;
    @Column(name = "flag_express_spprep_out_size_6_t")
    private Long flag_express_SpprepOutSize6T;
    @Column(name = "flag_express_spprep_out_size_7_t")
    private Long flag_express_SpprepOutSize7T;
    @Column(name = "flag_express_spprep_out_size_8_t")
    private Long flag_express_SpprepOutSize8T;
    @Column(name = "flag_express_spprep_out_size_9_t")
    private Long flag_express_SpprepOutSize9T;
    @Column(name = "flag_express_spprep_out_size_10_t")
    private Long flag_express_SpprepOutSize10T;
    @Column(name = "flag_express_spprep_out_size_11_t")
    private Long flag_express_SpprepOutSize11T;
    @Column(name = "flag_express_spprep_out_size_12_t")
    private Long flag_express_SpprepOutSize12T;
    @Column(name = "flag_express_spprep_out_size_13_t")
    private Long flag_express_SpprepOutSize13T;
    
    @Column(name = "flag_express_label_in_size_1")
    private Long flag_express_LabelInSize1;
    @Column(name = "flag_express_label_in_size_2")
    private Long flag_express_LabelInSize2;
    @Column(name = "flag_express_label_in_size_3")
    private Long flag_express_LabelInSize3;
    @Column(name = "flag_express_label_in_size_4")
    private Long flag_express_LabelInSize4;
    @Column(name = "flag_express_label_in_size_5")
    private Long flag_express_LabelInSize5;
    @Column(name = "flag_express_label_in_size_6")
    private Long flag_express_LabelInSize6;
    @Column(name = "flag_express_label_in_size_7")
    private Long flag_express_LabelInSize7;
    @Column(name = "flag_express_label_in_size_8")
    private Long flag_express_LabelInSize8;
    @Column(name = "flag_express_label_in_size_9")
    private Long flag_express_LabelInSize9;
    @Column(name = "flag_express_label_in_size_10")
    private Long flag_express_LabelInSize10;
    @Column(name = "flag_express_label_in_size_11")
    private Long flag_express_LabelInSize11;
    @Column(name = "flag_express_label_in_size_12")
    private Long flag_express_LabelInSize12;
    @Column(name = "flag_express_label_in_size_13")
    private Long flag_express_LabelInSize13;
    @Column(name = "flag_express_label_in_size_14")
    private Long flag_express_LabelInSize14;
    @Column(name = "flag_express_label_in_size_15")
    private Long flag_express_LabelInSize15;
    @Column(name = "flag_express_label_in_size_16")
    private Long flag_express_LabelInSize16;
    @Column(name = "flag_express_label_in_size_17")
    private Long flag_express_LabelInSize17;
    @Column(name = "flag_express_label_in_size_18")
    private Long flag_express_LabelInSize18;
    @Column(name = "flag_express_label_in_size_1_t")
    private Long flag_express_LabelInSize1T;
    @Column(name = "flag_express_label_in_size_2_t")
    private Long flag_express_LabelInSize2T;
    @Column(name = "flag_express_label_in_size_3_t")
    private Long flag_express_LabelInSize3T;
    @Column(name = "flag_express_label_in_size_4_t")
    private Long flag_express_LabelInSize4T;
    @Column(name = "flag_express_label_in_size_5_t")
    private Long flag_express_LabelInSize5T;
    @Column(name = "flag_express_label_in_size_6_t")
    private Long flag_express_LabelInSize6T;
    @Column(name = "flag_express_label_in_size_7_t")
    private Long flag_express_LabelInSize7T;
    @Column(name = "flag_express_label_in_size_8_t")
    private Long flag_express_LabelInSize8T;
    @Column(name = "flag_express_label_in_size_9_t")
    private Long flag_express_LabelInSize9T;
    @Column(name = "flag_express_label_in_size_10_t")
    private Long flag_express_LabelInSize10T;
    @Column(name = "flag_express_label_in_size_11_t")
    private Long flag_express_LabelInSize11T;
    @Column(name = "flag_express_label_in_size_12_t")
    private Long flag_express_LabelInSize12T;
    @Column(name = "flag_express_label_in_size_13_t")
    private Long flag_express_LabelInSize13T;
    
    @Column(name = "flag_express_label_out_size_1")
    private Long flag_express_LabelOutSize1;
    @Column(name = "flag_express_label_out_size_2")
    private Long flag_express_LabelOutSize2;
    @Column(name = "flag_express_label_out_size_3")
    private Long flag_express_LabelOutSize3;
    @Column(name = "flag_express_label_out_size_4")
    private Long flag_express_LabelOutSize4;
    @Column(name = "flag_express_label_out_size_5")
    private Long flag_express_LabelOutSize5;
    @Column(name = "flag_express_label_out_size_6")
    private Long flag_express_LabelOutSize6;
    @Column(name = "flag_express_label_out_size_7")
    private Long flag_express_LabelOutSize7;
    @Column(name = "flag_express_label_out_size_8")
    private Long flag_express_LabelOutSize8;
    @Column(name = "flag_express_label_out_size_9")
    private Long flag_express_LabelOutSize9;
    @Column(name = "flag_express_label_out_size_10")
    private Long flag_express_LabelOutSize10;
    @Column(name = "flag_express_label_out_size_11")
    private Long flag_express_LabelOutSize11;
    @Column(name = "flag_express_label_out_size_12")
    private Long flag_express_LabelOutSize12;
    @Column(name = "flag_express_label_out_size_13")
    private Long flag_express_LabelOutSize13;
    @Column(name = "flag_express_label_out_size_14")
    private Long flag_express_LabelOutSize14;
    @Column(name = "flag_express_label_out_size_15")
    private Long flag_express_LabelOutSize15;
    @Column(name = "flag_express_label_out_size_16")
    private Long flag_express_LabelOutSize16;
    @Column(name = "flag_express_label_out_size_17")
    private Long flag_express_LabelOutSize17;
    @Column(name = "flag_express_label_out_size_18")
    private Long flag_express_LabelOutSize18;
    @Column(name = "flag_express_label_out_size_1_t")
    private Long flag_express_LabelOutSize1T;
    @Column(name = "flag_express_label_out_size_2_t")
    private Long flag_express_LabelOutSize2T;
    @Column(name = "flag_express_label_out_size_3_t")
    private Long flag_express_LabelOutSize3T;
    @Column(name = "flag_express_label_out_size_4_t")
    private Long flag_express_LabelOutSize4T;
    @Column(name = "flag_express_label_out_size_5_t")
    private Long flag_express_LabelOutSize5T;
    @Column(name = "flag_express_label_out_size_6_t")
    private Long flag_express_LabelOutSize6T;
    @Column(name = "flag_express_label_out_size_7_t")
    private Long flag_express_LabelOutSize7T;
    @Column(name = "flag_express_label_out_size_8_t")
    private Long flag_express_LabelOutSize8T;
    @Column(name = "flag_express_label_out_size_9_t")
    private Long flag_express_LabelOutSize9T;
    @Column(name = "flag_express_label_out_size_10_t")
    private Long flag_express_LabelOutSize10T;
    @Column(name = "flag_express_label_out_size_11_t")
    private Long flag_express_LabelOutSize11T;
    @Column(name = "flag_express_label_out_size_12_t")
    private Long flag_express_LabelOutSize12T;
    @Column(name = "flag_express_label_out_size_13_t")
    private Long flag_express_LabelOutSize13T;
    
    @Column(name = "flag_express_laser_in_size_1")
    private Long flag_express_LaserInSize1;
    @Column(name = "flag_express_laser_in_size_2")
    private Long flag_express_LaserInSize2;
    @Column(name = "flag_express_laser_in_size_3")
    private Long flag_express_LaserInSize3;
    @Column(name = "flag_express_laser_in_size_4")
    private Long flag_express_LaserInSize4;
    @Column(name = "flag_express_laser_in_size_5")
    private Long flag_express_LaserInSize5;
    @Column(name = "flag_express_laser_in_size_6")
    private Long flag_express_LaserInSize6;
    @Column(name = "flag_express_laser_in_size_7")
    private Long flag_express_LaserInSize7;
    @Column(name = "flag_express_laser_in_size_8")
    private Long flag_express_LaserInSize8;
    @Column(name = "flag_express_laser_in_size_9")
    private Long flag_express_LaserInSize9;
    @Column(name = "flag_express_laser_in_size_10")
    private Long flag_express_LaserInSize10;
    @Column(name = "flag_express_laser_in_size_11")
    private Long flag_express_LaserInSize11;
    @Column(name = "flag_express_laser_in_size_12")
    private Long flag_express_LaserInSize12;
    @Column(name = "flag_express_laser_in_size_13")
    private Long flag_express_LaserInSize13;
    @Column(name = "flag_express_laser_in_size_14")
    private Long flag_express_LaserInSize14;
    @Column(name = "flag_express_laser_in_size_15")
    private Long flag_express_LaserInSize15;
    @Column(name = "flag_express_laser_in_size_16")
    private Long flag_express_LaserInSize16;
    @Column(name = "flag_express_laser_in_size_17")
    private Long flag_express_LaserInSize17;
    @Column(name = "flag_express_laser_in_size_18")
    private Long flag_express_LaserInSize18;
    @Column(name = "flag_express_laser_in_size_1_t")
    private Long flag_express_LaserInSize1T;
    @Column(name = "flag_express_laser_in_size_2_t")
    private Long flag_express_LaserInSize2T;
    @Column(name = "flag_express_laser_in_size_3_t")
    private Long flag_express_LaserInSize3T;
    @Column(name = "flag_express_laser_in_size_4_t")
    private Long flag_express_LaserInSize4T;
    @Column(name = "flag_express_laser_in_size_5_t")
    private Long flag_express_LaserInSize5T;
    @Column(name = "flag_express_laser_in_size_6_t")
    private Long flag_express_LaserInSize6T;
    @Column(name = "flag_express_laser_in_size_7_t")
    private Long flag_express_LaserInSize7T;
    @Column(name = "flag_express_laser_in_size_8_t")
    private Long flag_express_LaserInSize8T;
    @Column(name = "flag_express_laser_in_size_9_t")
    private Long flag_express_LaserInSize9T;
    @Column(name = "flag_express_laser_in_size_10_t")
    private Long flag_express_LaserInSize10T;
    @Column(name = "flag_express_laser_in_size_11_t")
    private Long flag_express_LaserInSize11T;
    @Column(name = "flag_express_laser_in_size_12_t")
    private Long flag_express_LaserInSize12T;
    @Column(name = "flag_express_laser_in_size_13_t")
    private Long flag_express_LaserInSize13T;
    
    @Column(name = "flag_express_laser_out_size_1")
    private Long flag_express_LaserOutSize1;
    @Column(name = "flag_express_laser_out_size_2")
    private Long flag_express_LaserOutSize2;
    @Column(name = "flag_express_laser_out_size_3")
    private Long flag_express_LaserOutSize3;
    @Column(name = "flag_express_laser_out_size_4")
    private Long flag_express_LaserOutSize4;
    @Column(name = "flag_express_laser_out_size_5")
    private Long flag_express_LaserOutSize5;
    @Column(name = "flag_express_laser_out_size_6")
    private Long flag_express_LaserOutSize6;
    @Column(name = "flag_express_laser_out_size_7")
    private Long flag_express_LaserOutSize7;
    @Column(name = "flag_express_laser_out_size_8")
    private Long flag_express_LaserOutSize8;
    @Column(name = "flag_express_laser_out_size_9")
    private Long flag_express_LaserOutSize9;
    @Column(name = "flag_express_laser_out_size_10")
    private Long flag_express_LaserOutSize10;
    @Column(name = "flag_express_laser_out_size_11")
    private Long flag_express_LaserOutSize11;
    @Column(name = "flag_express_laser_out_size_12")
    private Long flag_express_LaserOutSize12;
    @Column(name = "flag_express_laser_out_size_13")
    private Long flag_express_LaserOutSize13;
    @Column(name = "flag_express_laser_out_size_14")
    private Long flag_express_LaserOutSize14;
    @Column(name = "flag_express_laser_out_size_15")
    private Long flag_express_LaserOutSize15;
    @Column(name = "flag_express_laser_out_size_16")
    private Long flag_express_LaserOutSize16;
    @Column(name = "flag_express_laser_out_size_17")
    private Long flag_express_LaserOutSize17;
    @Column(name = "flag_express_laser_out_size_18")
    private Long flag_express_LaserOutSize18;
    @Column(name = "flag_express_laser_out_size_1_t")
    private Long flag_express_LaserOutSize1T;
    @Column(name = "flag_express_laser_out_size_2_t")
    private Long flag_express_LaserOutSize2T;
    @Column(name = "flag_express_laser_out_size_3_t")
    private Long flag_express_LaserOutSize3T;
    @Column(name = "flag_express_laser_out_size_4_t")
    private Long flag_express_LaserOutSize4T;
    @Column(name = "flag_express_laser_out_size_5_t")
    private Long flag_express_LaserOutSize5T;
    @Column(name = "flag_express_laser_out_size_6_t")
    private Long flag_express_LaserOutSize6T;
    @Column(name = "flag_express_laser_out_size_7_t")
    private Long flag_express_LaserOutSize7T;
    @Column(name = "flag_express_laser_out_size_8_t")
    private Long flag_express_LaserOutSize8T;
    @Column(name = "flag_express_laser_out_size_9_t")
    private Long flag_express_LaserOutSize9T;
    @Column(name = "flag_express_laser_out_size_10_t")
    private Long flag_express_LaserOutSize10T;
    @Column(name = "flag_express_laser_out_size_11_t")
    private Long flag_express_LaserOutSize11T;
    @Column(name = "flag_express_laser_out_size_12_t")
    private Long flag_express_LaserOutSize12T;
    @Column(name = "flag_express_laser_out_size_13_t")
    private Long flag_express_LaserOutSize13T;

    public Long getId_Ex() {
        return id_Ex;
    }

    public void setId_Ex(Long id_Ex) {
        this.id_Ex = id_Ex;
    }

    public Date getCreateDate_Ex() {
        return createDate_Ex;
    }

    public void setCreateDate_Ex(Date createDate_Ex) {
        this.createDate_Ex = createDate_Ex;
    }

    public Long getCreateBy_Ex() {
        return createBy_Ex;
    }

    public void setCreateBy_Ex(Long createBy_Ex) {
        this.createBy_Ex = createBy_Ex;
    }

    public JdcAdpMstUser getUser() {
        return user;
    }

    public void setUser(JdcAdpMstUser user) {
        this.user = user;
    }

    public Date getUpdateDate_Ex() {
        return updateDate_Ex;
    }

    public void setUpdateDate_Ex(Date updateDate_Ex) {
        this.updateDate_Ex = updateDate_Ex;
    }

    public Long getUpdateBy_Ex() {
        return updateBy_Ex;
    }

    public void setUpdateBy_Ex(Long updateBy_Ex) {
        this.updateBy_Ex = updateBy_Ex;
    }

    public Long getHourly_Ex() {
        return hourly_Ex;
    }

    public void setHourly_Ex(Long hourly_Ex) {
        this.hourly_Ex = hourly_Ex;
    }

    public Long getSize1_Ex() {
        return Size1_Ex;
    }

    public void setSize1_Ex(Long Size1_Ex) {
        this.Size1_Ex = Size1_Ex;
    }

    public Long getSize2_Ex() {
        return Size2_Ex;
    }

    public void setSize2_Ex(Long Size2_Ex) {
        this.Size2_Ex = Size2_Ex;
    }

    public Long getSize3_Ex() {
        return Size3_Ex;
    }

    public void setSize3_Ex(Long Size3_Ex) {
        this.Size3_Ex = Size3_Ex;
    }

    public Long getSize4_Ex() {
        return Size4_Ex;
    }

    public void setSize4_Ex(Long Size4_Ex) {
        this.Size4_Ex = Size4_Ex;
    }

    public Long getSize5_Ex() {
        return Size5_Ex;
    }

    public void setSize5_Ex(Long Size5_Ex) {
        this.Size5_Ex = Size5_Ex;
    }

    public Long getSize6_Ex() {
        return Size6_Ex;
    }

    public void setSize6_Ex(Long Size6_Ex) {
        this.Size6_Ex = Size6_Ex;
    }

    public Long getSize7_Ex() {
        return Size7_Ex;
    }

    public void setSize7_Ex(Long Size7_Ex) {
        this.Size7_Ex = Size7_Ex;
    }

    public Long getSize8_Ex() {
        return Size8_Ex;
    }

    public void setSize8_Ex(Long Size8_Ex) {
        this.Size8_Ex = Size8_Ex;
    }

    public Long getSize9_Ex() {
        return Size9_Ex;
    }

    public void setSize9_Ex(Long Size9_Ex) {
        this.Size9_Ex = Size9_Ex;
    }

    public Long getSize10_Ex() {
        return Size10_Ex;
    }

    public void setSize10_Ex(Long Size10_Ex) {
        this.Size10_Ex = Size10_Ex;
    }

    public Long getSize11_Ex() {
        return Size11_Ex;
    }

    public void setSize11_Ex(Long Size11_Ex) {
        this.Size11_Ex = Size11_Ex;
    }

    public Long getSize12_Ex() {
        return Size12_Ex;
    }

    public void setSize12_Ex(Long Size12_Ex) {
        this.Size12_Ex = Size12_Ex;
    }

    public Long getSize13_Ex() {
        return Size13_Ex;
    }

    public void setSize13_Ex(Long Size13_Ex) {
        this.Size13_Ex = Size13_Ex;
    }

    public Long getSize14_Ex() {
        return Size14_Ex;
    }

    public void setSize14_Ex(Long Size14_Ex) {
        this.Size14_Ex = Size14_Ex;
    }

    public Long getSize15_Ex() {
        return Size15_Ex;
    }

    public void setSize15_Ex(Long Size15_Ex) {
        this.Size15_Ex = Size15_Ex;
    }

    public Long getSize16_Ex() {
        return Size16_Ex;
    }

    public void setSize16_Ex(Long Size16_Ex) {
        this.Size16_Ex = Size16_Ex;
    }

    public Long getSize17_Ex() {
        return Size17_Ex;
    }

    public void setSize17_Ex(Long Size17_Ex) {
        this.Size17_Ex = Size17_Ex;
    }

    public Long getSize18_Ex() {
        return Size18_Ex;
    }

    public void setSize18_Ex(Long Size18_Ex) {
        this.Size18_Ex = Size18_Ex;
    }

    public Long getSize1_t_Ex() {
        return Size1_t_Ex;
    }

    public void setSize1_t_Ex(Long Size1_t_Ex) {
        this.Size1_t_Ex = Size1_t_Ex;
    }

    public Long getSize2_t_Ex() {
        return Size2_t_Ex;
    }

    public void setSize2_t_Ex(Long Size2_t_Ex) {
        this.Size2_t_Ex = Size2_t_Ex;
    }

    public Long getSize3_t_Ex() {
        return Size3_t_Ex;
    }

    public void setSize3_t_Ex(Long Size3_t_Ex) {
        this.Size3_t_Ex = Size3_t_Ex;
    }

    public Long getSize4_t_Ex() {
        return Size4_t_Ex;
    }

    public void setSize4_t_Ex(Long Size4_t_Ex) {
        this.Size4_t_Ex = Size4_t_Ex;
    }

    public Long getSize5_t_Ex() {
        return Size5_t_Ex;
    }

    public void setSize5_t_Ex(Long Size5_t_Ex) {
        this.Size5_t_Ex = Size5_t_Ex;
    }

    public Long getSize6_t_Ex() {
        return Size6_t_Ex;
    }

    public void setSize6_t_Ex(Long Size6_t_Ex) {
        this.Size6_t_Ex = Size6_t_Ex;
    }

    public Long getSize7_t_Ex() {
        return Size7_t_Ex;
    }

    public void setSize7_t_Ex(Long Size7_t_Ex) {
        this.Size7_t_Ex = Size7_t_Ex;
    }

    public Long getSize8_t_Ex() {
        return Size8_t_Ex;
    }

    public void setSize8_t_Ex(Long Size8_t_Ex) {
        this.Size8_t_Ex = Size8_t_Ex;
    }

    public Long getSize9_t_Ex() {
        return Size9_t_Ex;
    }

    public void setSize9_t_Ex(Long Size9_t_Ex) {
        this.Size9_t_Ex = Size9_t_Ex;
    }

    public Long getSize10_t_Ex() {
        return Size10_t_Ex;
    }

    public void setSize10_t_Ex(Long Size10_t_Ex) {
        this.Size10_t_Ex = Size10_t_Ex;
    }

    public Long getSize11_t_Ex() {
        return Size11_t_Ex;
    }

    public void setSize11_t_Ex(Long Size11_t_Ex) {
        this.Size11_t_Ex = Size11_t_Ex;
    }

    public Long getSize12_t_Ex() {
        return Size12_t_Ex;
    }

    public void setSize12_t_Ex(Long Size12_t_Ex) {
        this.Size12_t_Ex = Size12_t_Ex;
    }

    public Long getSize13_t_Ex() {
        return Size13_t_Ex;
    }

    public void setSize13_t_Ex(Long Size13_t_Ex) {
        this.Size13_t_Ex = Size13_t_Ex;
    }

    public Long getFlag_express_CtInSize1() {
        return flag_express_CtInSize1;
    }

    public void setFlag_express_CtInSize1(Long flag_express_CtInSize1) {
        this.flag_express_CtInSize1 = flag_express_CtInSize1;
    }

    public Long getFlag_express_CtInSize2() {
        return flag_express_CtInSize2;
    }

    public void setFlag_express_CtInSize2(Long flag_express_CtInSize2) {
        this.flag_express_CtInSize2 = flag_express_CtInSize2;
    }

    public Long getFlag_express_CtInSize3() {
        return flag_express_CtInSize3;
    }

    public void setFlag_express_CtInSize3(Long flag_express_CtInSize3) {
        this.flag_express_CtInSize3 = flag_express_CtInSize3;
    }

    public Long getFlag_express_CtInSize4() {
        return flag_express_CtInSize4;
    }

    public void setFlag_express_CtInSize4(Long flag_express_CtInSize4) {
        this.flag_express_CtInSize4 = flag_express_CtInSize4;
    }

    public Long getFlag_express_CtInSize5() {
        return flag_express_CtInSize5;
    }

    public void setFlag_express_CtInSize5(Long flag_express_CtInSize5) {
        this.flag_express_CtInSize5 = flag_express_CtInSize5;
    }

    public Long getFlag_express_CtInSize6() {
        return flag_express_CtInSize6;
    }

    public void setFlag_express_CtInSize6(Long flag_express_CtInSize6) {
        this.flag_express_CtInSize6 = flag_express_CtInSize6;
    }

    public Long getFlag_express_CtInSize7() {
        return flag_express_CtInSize7;
    }

    public void setFlag_express_CtInSize7(Long flag_express_CtInSize7) {
        this.flag_express_CtInSize7 = flag_express_CtInSize7;
    }

    public Long getFlag_express_CtInSize8() {
        return flag_express_CtInSize8;
    }

    public void setFlag_express_CtInSize8(Long flag_express_CtInSize8) {
        this.flag_express_CtInSize8 = flag_express_CtInSize8;
    }

    public Long getFlag_express_CtInSize9() {
        return flag_express_CtInSize9;
    }

    public void setFlag_express_CtInSize9(Long flag_express_CtInSize9) {
        this.flag_express_CtInSize9 = flag_express_CtInSize9;
    }

    public Long getFlag_express_CtInSize10() {
        return flag_express_CtInSize10;
    }

    public void setFlag_express_CtInSize10(Long flag_express_CtInSize10) {
        this.flag_express_CtInSize10 = flag_express_CtInSize10;
    }

    public Long getFlag_express_CtInSize11() {
        return flag_express_CtInSize11;
    }

    public void setFlag_express_CtInSize11(Long flag_express_CtInSize11) {
        this.flag_express_CtInSize11 = flag_express_CtInSize11;
    }

    public Long getFlag_express_CtInSize12() {
        return flag_express_CtInSize12;
    }

    public void setFlag_express_CtInSize12(Long flag_express_CtInSize12) {
        this.flag_express_CtInSize12 = flag_express_CtInSize12;
    }

    public Long getFlag_express_CtInSize13() {
        return flag_express_CtInSize13;
    }

    public void setFlag_express_CtInSize13(Long flag_express_CtInSize13) {
        this.flag_express_CtInSize13 = flag_express_CtInSize13;
    }

    public Long getFlag_express_CtInSize14() {
        return flag_express_CtInSize14;
    }

    public void setFlag_express_CtInSize14(Long flag_express_CtInSize14) {
        this.flag_express_CtInSize14 = flag_express_CtInSize14;
    }

    public Long getFlag_express_CtInSize15() {
        return flag_express_CtInSize15;
    }

    public void setFlag_express_CtInSize15(Long flag_express_CtInSize15) {
        this.flag_express_CtInSize15 = flag_express_CtInSize15;
    }

    public Long getFlag_express_CtInSize16() {
        return flag_express_CtInSize16;
    }

    public void setFlag_express_CtInSize16(Long flag_express_CtInSize16) {
        this.flag_express_CtInSize16 = flag_express_CtInSize16;
    }

    public Long getFlag_express_CtInSize17() {
        return flag_express_CtInSize17;
    }

    public void setFlag_express_CtInSize17(Long flag_express_CtInSize17) {
        this.flag_express_CtInSize17 = flag_express_CtInSize17;
    }

    public Long getFlag_express_CtInSize18() {
        return flag_express_CtInSize18;
    }

    public void setFlag_express_CtInSize18(Long flag_express_CtInSize18) {
        this.flag_express_CtInSize18 = flag_express_CtInSize18;
    }

    public Long getFlag_express_CtInSize1T() {
        return flag_express_CtInSize1T;
    }

    public void setFlag_express_CtInSize1T(Long flag_express_CtInSize1T) {
        this.flag_express_CtInSize1T = flag_express_CtInSize1T;
    }

    public Long getFlag_express_CtInSize2T() {
        return flag_express_CtInSize2T;
    }

    public void setFlag_express_CtInSize2T(Long flag_express_CtInSize2T) {
        this.flag_express_CtInSize2T = flag_express_CtInSize2T;
    }

    public Long getFlag_express_CtInSize3T() {
        return flag_express_CtInSize3T;
    }

    public void setFlag_express_CtInSize3T(Long flag_express_CtInSize3T) {
        this.flag_express_CtInSize3T = flag_express_CtInSize3T;
    }

    public Long getFlag_express_CtInSize4T() {
        return flag_express_CtInSize4T;
    }

    public void setFlag_express_CtInSize4T(Long flag_express_CtInSize4T) {
        this.flag_express_CtInSize4T = flag_express_CtInSize4T;
    }

    public Long getFlag_express_CtInSize5T() {
        return flag_express_CtInSize5T;
    }

    public void setFlag_express_CtInSize5T(Long flag_express_CtInSize5T) {
        this.flag_express_CtInSize5T = flag_express_CtInSize5T;
    }

    public Long getFlag_express_CtInSize6T() {
        return flag_express_CtInSize6T;
    }

    public void setFlag_express_CtInSize6T(Long flag_express_CtInSize6T) {
        this.flag_express_CtInSize6T = flag_express_CtInSize6T;
    }

    public Long getFlag_express_CtInSize7T() {
        return flag_express_CtInSize7T;
    }

    public void setFlag_express_CtInSize7T(Long flag_express_CtInSize7T) {
        this.flag_express_CtInSize7T = flag_express_CtInSize7T;
    }

    public Long getFlag_express_CtInSize8T() {
        return flag_express_CtInSize8T;
    }

    public void setFlag_express_CtInSize8T(Long flag_express_CtInSize8T) {
        this.flag_express_CtInSize8T = flag_express_CtInSize8T;
    }

    public Long getFlag_express_CtInSize9T() {
        return flag_express_CtInSize9T;
    }

    public void setFlag_express_CtInSize9T(Long flag_express_CtInSize9T) {
        this.flag_express_CtInSize9T = flag_express_CtInSize9T;
    }

    public Long getFlag_express_CtInSize10T() {
        return flag_express_CtInSize10T;
    }

    public void setFlag_express_CtInSize10T(Long flag_express_CtInSize10T) {
        this.flag_express_CtInSize10T = flag_express_CtInSize10T;
    }

    public Long getFlag_express_CtInSize11T() {
        return flag_express_CtInSize11T;
    }

    public void setFlag_express_CtInSize11T(Long flag_express_CtInSize11T) {
        this.flag_express_CtInSize11T = flag_express_CtInSize11T;
    }

    public Long getFlag_express_CtInSize12T() {
        return flag_express_CtInSize12T;
    }

    public void setFlag_express_CtInSize12T(Long flag_express_CtInSize12T) {
        this.flag_express_CtInSize12T = flag_express_CtInSize12T;
    }

    public Long getFlag_express_CtInSize13T() {
        return flag_express_CtInSize13T;
    }

    public void setFlag_express_CtInSize13T(Long flag_express_CtInSize13T) {
        this.flag_express_CtInSize13T = flag_express_CtInSize13T;
    }

    public Long getFlag_express_CtOutSize1() {
        return flag_express_CtOutSize1;
    }

    public void setFlag_express_CtOutSize1(Long flag_express_CtOutSize1) {
        this.flag_express_CtOutSize1 = flag_express_CtOutSize1;
    }

    public Long getFlag_express_CtOutSize2() {
        return flag_express_CtOutSize2;
    }

    public void setFlag_express_CtOutSize2(Long flag_express_CtOutSize2) {
        this.flag_express_CtOutSize2 = flag_express_CtOutSize2;
    }

    public Long getFlag_express_CtOutSize3() {
        return flag_express_CtOutSize3;
    }

    public void setFlag_express_CtOutSize3(Long flag_express_CtOutSize3) {
        this.flag_express_CtOutSize3 = flag_express_CtOutSize3;
    }

    public Long getFlag_express_CtOutSize4() {
        return flag_express_CtOutSize4;
    }

    public void setFlag_express_CtOutSize4(Long flag_express_CtOutSize4) {
        this.flag_express_CtOutSize4 = flag_express_CtOutSize4;
    }

    public Long getFlag_express_CtOutSize5() {
        return flag_express_CtOutSize5;
    }

    public void setFlag_express_CtOutSize5(Long flag_express_CtOutSize5) {
        this.flag_express_CtOutSize5 = flag_express_CtOutSize5;
    }

    public Long getFlag_express_CtOutSize6() {
        return flag_express_CtOutSize6;
    }

    public void setFlag_express_CtOutSize6(Long flag_express_CtOutSize6) {
        this.flag_express_CtOutSize6 = flag_express_CtOutSize6;
    }

    public Long getFlag_express_CtOutSize7() {
        return flag_express_CtOutSize7;
    }

    public void setFlag_express_CtOutSize7(Long flag_express_CtOutSize7) {
        this.flag_express_CtOutSize7 = flag_express_CtOutSize7;
    }

    public Long getFlag_express_CtOutSize8() {
        return flag_express_CtOutSize8;
    }

    public void setFlag_express_CtOutSize8(Long flag_express_CtOutSize8) {
        this.flag_express_CtOutSize8 = flag_express_CtOutSize8;
    }

    public Long getFlag_express_CtOutSize9() {
        return flag_express_CtOutSize9;
    }

    public void setFlag_express_CtOutSize9(Long flag_express_CtOutSize9) {
        this.flag_express_CtOutSize9 = flag_express_CtOutSize9;
    }

    public Long getFlag_express_CtOutSize10() {
        return flag_express_CtOutSize10;
    }

    public void setFlag_express_CtOutSize10(Long flag_express_CtOutSize10) {
        this.flag_express_CtOutSize10 = flag_express_CtOutSize10;
    }

    public Long getFlag_express_CtOutSize11() {
        return flag_express_CtOutSize11;
    }

    public void setFlag_express_CtOutSize11(Long flag_express_CtOutSize11) {
        this.flag_express_CtOutSize11 = flag_express_CtOutSize11;
    }

    public Long getFlag_express_CtOutSize12() {
        return flag_express_CtOutSize12;
    }

    public void setFlag_express_CtOutSize12(Long flag_express_CtOutSize12) {
        this.flag_express_CtOutSize12 = flag_express_CtOutSize12;
    }

    public Long getFlag_express_CtOutSize13() {
        return flag_express_CtOutSize13;
    }

    public void setFlag_express_CtOutSize13(Long flag_express_CtOutSize13) {
        this.flag_express_CtOutSize13 = flag_express_CtOutSize13;
    }

    public Long getFlag_express_CtOutSize14() {
        return flag_express_CtOutSize14;
    }

    public void setFlag_express_CtOutSize14(Long flag_express_CtOutSize14) {
        this.flag_express_CtOutSize14 = flag_express_CtOutSize14;
    }

    public Long getFlag_express_CtOutSize15() {
        return flag_express_CtOutSize15;
    }

    public void setFlag_express_CtOutSize15(Long flag_express_CtOutSize15) {
        this.flag_express_CtOutSize15 = flag_express_CtOutSize15;
    }

    public Long getFlag_express_CtOutSize16() {
        return flag_express_CtOutSize16;
    }

    public void setFlag_express_CtOutSize16(Long flag_express_CtOutSize16) {
        this.flag_express_CtOutSize16 = flag_express_CtOutSize16;
    }

    public Long getFlag_express_CtOutSize17() {
        return flag_express_CtOutSize17;
    }

    public void setFlag_express_CtOutSize17(Long flag_express_CtOutSize17) {
        this.flag_express_CtOutSize17 = flag_express_CtOutSize17;
    }

    public Long getFlag_express_CtOutSize18() {
        return flag_express_CtOutSize18;
    }

    public void setFlag_express_CtOutSize18(Long flag_express_CtOutSize18) {
        this.flag_express_CtOutSize18 = flag_express_CtOutSize18;
    }

    public Long getFlag_express_CtOutSize1T() {
        return flag_express_CtOutSize1T;
    }

    public void setFlag_express_CtOutSize1T(Long flag_express_CtOutSize1T) {
        this.flag_express_CtOutSize1T = flag_express_CtOutSize1T;
    }

    public Long getFlag_express_CtOutSize2T() {
        return flag_express_CtOutSize2T;
    }

    public void setFlag_express_CtOutSize2T(Long flag_express_CtOutSize2T) {
        this.flag_express_CtOutSize2T = flag_express_CtOutSize2T;
    }

    public Long getFlag_express_CtOutSize3T() {
        return flag_express_CtOutSize3T;
    }

    public void setFlag_express_CtOutSize3T(Long flag_express_CtOutSize3T) {
        this.flag_express_CtOutSize3T = flag_express_CtOutSize3T;
    }

    public Long getFlag_express_CtOutSize4T() {
        return flag_express_CtOutSize4T;
    }

    public void setFlag_express_CtOutSize4T(Long flag_express_CtOutSize4T) {
        this.flag_express_CtOutSize4T = flag_express_CtOutSize4T;
    }

    public Long getFlag_express_CtOutSize5T() {
        return flag_express_CtOutSize5T;
    }

    public void setFlag_express_CtOutSize5T(Long flag_express_CtOutSize5T) {
        this.flag_express_CtOutSize5T = flag_express_CtOutSize5T;
    }

    public Long getFlag_express_CtOutSize6T() {
        return flag_express_CtOutSize6T;
    }

    public void setFlag_express_CtOutSize6T(Long flag_express_CtOutSize6T) {
        this.flag_express_CtOutSize6T = flag_express_CtOutSize6T;
    }

    public Long getFlag_express_CtOutSize7T() {
        return flag_express_CtOutSize7T;
    }

    public void setFlag_express_CtOutSize7T(Long flag_express_CtOutSize7T) {
        this.flag_express_CtOutSize7T = flag_express_CtOutSize7T;
    }

    public Long getFlag_express_CtOutSize8T() {
        return flag_express_CtOutSize8T;
    }

    public void setFlag_express_CtOutSize8T(Long flag_express_CtOutSize8T) {
        this.flag_express_CtOutSize8T = flag_express_CtOutSize8T;
    }

    public Long getFlag_express_CtOutSize9T() {
        return flag_express_CtOutSize9T;
    }

    public void setFlag_express_CtOutSize9T(Long flag_express_CtOutSize9T) {
        this.flag_express_CtOutSize9T = flag_express_CtOutSize9T;
    }

    public Long getFlag_express_CtOutSize10T() {
        return flag_express_CtOutSize10T;
    }

    public void setFlag_express_CtOutSize10T(Long flag_express_CtOutSize10T) {
        this.flag_express_CtOutSize10T = flag_express_CtOutSize10T;
    }

    public Long getFlag_express_CtOutSize11T() {
        return flag_express_CtOutSize11T;
    }

    public void setFlag_express_CtOutSize11T(Long flag_express_CtOutSize11T) {
        this.flag_express_CtOutSize11T = flag_express_CtOutSize11T;
    }

    public Long getFlag_express_CtOutSize12T() {
        return flag_express_CtOutSize12T;
    }

    public void setFlag_express_CtOutSize12T(Long flag_express_CtOutSize12T) {
        this.flag_express_CtOutSize12T = flag_express_CtOutSize12T;
    }

    public Long getFlag_express_CtOutSize13T() {
        return flag_express_CtOutSize13T;
    }

    public void setFlag_express_CtOutSize13T(Long flag_express_CtOutSize13T) {
        this.flag_express_CtOutSize13T = flag_express_CtOutSize13T;
    }

    public Long getFlag_express_PrepInSize1() {
        return flag_express_PrepInSize1;
    }

    public void setFlag_express_PrepInSize1(Long flag_express_PrepInSize1) {
        this.flag_express_PrepInSize1 = flag_express_PrepInSize1;
    }

    public Long getFlag_express_PrepInSize2() {
        return flag_express_PrepInSize2;
    }

    public void setFlag_express_PrepInSize2(Long flag_express_PrepInSize2) {
        this.flag_express_PrepInSize2 = flag_express_PrepInSize2;
    }

    public Long getFlag_express_PrepInSize3() {
        return flag_express_PrepInSize3;
    }

    public void setFlag_express_PrepInSize3(Long flag_express_PrepInSize3) {
        this.flag_express_PrepInSize3 = flag_express_PrepInSize3;
    }

    public Long getFlag_express_PrepInSize4() {
        return flag_express_PrepInSize4;
    }

    public void setFlag_express_PrepInSize4(Long flag_express_PrepInSize4) {
        this.flag_express_PrepInSize4 = flag_express_PrepInSize4;
    }

    public Long getFlag_express_PrepInSize5() {
        return flag_express_PrepInSize5;
    }

    public void setFlag_express_PrepInSize5(Long flag_express_PrepInSize5) {
        this.flag_express_PrepInSize5 = flag_express_PrepInSize5;
    }

    public Long getFlag_express_PrepInSize6() {
        return flag_express_PrepInSize6;
    }

    public void setFlag_express_PrepInSize6(Long flag_express_PrepInSize6) {
        this.flag_express_PrepInSize6 = flag_express_PrepInSize6;
    }

    public Long getFlag_express_PrepInSize7() {
        return flag_express_PrepInSize7;
    }

    public void setFlag_express_PrepInSize7(Long flag_express_PrepInSize7) {
        this.flag_express_PrepInSize7 = flag_express_PrepInSize7;
    }

    public Long getFlag_express_PrepInSize8() {
        return flag_express_PrepInSize8;
    }

    public void setFlag_express_PrepInSize8(Long flag_express_PrepInSize8) {
        this.flag_express_PrepInSize8 = flag_express_PrepInSize8;
    }

    public Long getFlag_express_PrepInSize9() {
        return flag_express_PrepInSize9;
    }

    public void setFlag_express_PrepInSize9(Long flag_express_PrepInSize9) {
        this.flag_express_PrepInSize9 = flag_express_PrepInSize9;
    }

    public Long getFlag_express_PrepInSize10() {
        return flag_express_PrepInSize10;
    }

    public void setFlag_express_PrepInSize10(Long flag_express_PrepInSize10) {
        this.flag_express_PrepInSize10 = flag_express_PrepInSize10;
    }

    public Long getFlag_express_PrepInSize11() {
        return flag_express_PrepInSize11;
    }

    public void setFlag_express_PrepInSize11(Long flag_express_PrepInSize11) {
        this.flag_express_PrepInSize11 = flag_express_PrepInSize11;
    }

    public Long getFlag_express_PrepInSize12() {
        return flag_express_PrepInSize12;
    }

    public void setFlag_express_PrepInSize12(Long flag_express_PrepInSize12) {
        this.flag_express_PrepInSize12 = flag_express_PrepInSize12;
    }

    public Long getFlag_express_PrepInSize13() {
        return flag_express_PrepInSize13;
    }

    public void setFlag_express_PrepInSize13(Long flag_express_PrepInSize13) {
        this.flag_express_PrepInSize13 = flag_express_PrepInSize13;
    }

    public Long getFlag_express_PrepInSize14() {
        return flag_express_PrepInSize14;
    }

    public void setFlag_express_PrepInSize14(Long flag_express_PrepInSize14) {
        this.flag_express_PrepInSize14 = flag_express_PrepInSize14;
    }

    public Long getFlag_express_PrepInSize15() {
        return flag_express_PrepInSize15;
    }

    public void setFlag_express_PrepInSize15(Long flag_express_PrepInSize15) {
        this.flag_express_PrepInSize15 = flag_express_PrepInSize15;
    }

    public Long getFlag_express_PrepInSize16() {
        return flag_express_PrepInSize16;
    }

    public void setFlag_express_PrepInSize16(Long flag_express_PrepInSize16) {
        this.flag_express_PrepInSize16 = flag_express_PrepInSize16;
    }

    public Long getFlag_express_PrepInSize17() {
        return flag_express_PrepInSize17;
    }

    public void setFlag_express_PrepInSize17(Long flag_express_PrepInSize17) {
        this.flag_express_PrepInSize17 = flag_express_PrepInSize17;
    }

    public Long getFlag_express_PrepInSize18() {
        return flag_express_PrepInSize18;
    }

    public void setFlag_express_PrepInSize18(Long flag_express_PrepInSize18) {
        this.flag_express_PrepInSize18 = flag_express_PrepInSize18;
    }

    public Long getFlag_express_PrepInSize1T() {
        return flag_express_PrepInSize1T;
    }

    public void setFlag_express_PrepInSize1T(Long flag_express_PrepInSize1T) {
        this.flag_express_PrepInSize1T = flag_express_PrepInSize1T;
    }

    public Long getFlag_express_PrepInSize2T() {
        return flag_express_PrepInSize2T;
    }

    public void setFlag_express_PrepInSize2T(Long flag_express_PrepInSize2T) {
        this.flag_express_PrepInSize2T = flag_express_PrepInSize2T;
    }

    public Long getFlag_express_PrepInSize3T() {
        return flag_express_PrepInSize3T;
    }

    public void setFlag_express_PrepInSize3T(Long flag_express_PrepInSize3T) {
        this.flag_express_PrepInSize3T = flag_express_PrepInSize3T;
    }

    public Long getFlag_express_PrepInSize4T() {
        return flag_express_PrepInSize4T;
    }

    public void setFlag_express_PrepInSize4T(Long flag_express_PrepInSize4T) {
        this.flag_express_PrepInSize4T = flag_express_PrepInSize4T;
    }

    public Long getFlag_express_PrepInSize5T() {
        return flag_express_PrepInSize5T;
    }

    public void setFlag_express_PrepInSize5T(Long flag_express_PrepInSize5T) {
        this.flag_express_PrepInSize5T = flag_express_PrepInSize5T;
    }

    public Long getFlag_express_PrepInSize6T() {
        return flag_express_PrepInSize6T;
    }

    public void setFlag_express_PrepInSize6T(Long flag_express_PrepInSize6T) {
        this.flag_express_PrepInSize6T = flag_express_PrepInSize6T;
    }

    public Long getFlag_express_PrepInSize7T() {
        return flag_express_PrepInSize7T;
    }

    public void setFlag_express_PrepInSize7T(Long flag_express_PrepInSize7T) {
        this.flag_express_PrepInSize7T = flag_express_PrepInSize7T;
    }

    public Long getFlag_express_PrepInSize8T() {
        return flag_express_PrepInSize8T;
    }

    public void setFlag_express_PrepInSize8T(Long flag_express_PrepInSize8T) {
        this.flag_express_PrepInSize8T = flag_express_PrepInSize8T;
    }

    public Long getFlag_express_PrepInSize9T() {
        return flag_express_PrepInSize9T;
    }

    public void setFlag_express_PrepInSize9T(Long flag_express_PrepInSize9T) {
        this.flag_express_PrepInSize9T = flag_express_PrepInSize9T;
    }

    public Long getFlag_express_PrepInSize10T() {
        return flag_express_PrepInSize10T;
    }

    public void setFlag_express_PrepInSize10T(Long flag_express_PrepInSize10T) {
        this.flag_express_PrepInSize10T = flag_express_PrepInSize10T;
    }

    public Long getFlag_express_PrepInSize11T() {
        return flag_express_PrepInSize11T;
    }

    public void setFlag_express_PrepInSize11T(Long flag_express_PrepInSize11T) {
        this.flag_express_PrepInSize11T = flag_express_PrepInSize11T;
    }

    public Long getFlag_express_PrepInSize12T() {
        return flag_express_PrepInSize12T;
    }

    public void setFlag_express_PrepInSize12T(Long flag_express_PrepInSize12T) {
        this.flag_express_PrepInSize12T = flag_express_PrepInSize12T;
    }

    public Long getFlag_express_PrepInSize13T() {
        return flag_express_PrepInSize13T;
    }

    public void setFlag_express_PrepInSize13T(Long flag_express_PrepInSize13T) {
        this.flag_express_PrepInSize13T = flag_express_PrepInSize13T;
    }

    public Long getFlag_express_PrepOutSize1() {
        return flag_express_PrepOutSize1;
    }

    public void setFlag_express_PrepOutSize1(Long flag_express_PrepOutSize1) {
        this.flag_express_PrepOutSize1 = flag_express_PrepOutSize1;
    }

    public Long getFlag_express_PrepOutSize2() {
        return flag_express_PrepOutSize2;
    }

    public void setFlag_express_PrepOutSize2(Long flag_express_PrepOutSize2) {
        this.flag_express_PrepOutSize2 = flag_express_PrepOutSize2;
    }

    public Long getFlag_express_PrepOutSize3() {
        return flag_express_PrepOutSize3;
    }

    public void setFlag_express_PrepOutSize3(Long flag_express_PrepOutSize3) {
        this.flag_express_PrepOutSize3 = flag_express_PrepOutSize3;
    }

    public Long getFlag_express_PrepOutSize4() {
        return flag_express_PrepOutSize4;
    }

    public void setFlag_express_PrepOutSize4(Long flag_express_PrepOutSize4) {
        this.flag_express_PrepOutSize4 = flag_express_PrepOutSize4;
    }

    public Long getFlag_express_PrepOutSize5() {
        return flag_express_PrepOutSize5;
    }

    public void setFlag_express_PrepOutSize5(Long flag_express_PrepOutSize5) {
        this.flag_express_PrepOutSize5 = flag_express_PrepOutSize5;
    }

    public Long getFlag_express_PrepOutSize6() {
        return flag_express_PrepOutSize6;
    }

    public void setFlag_express_PrepOutSize6(Long flag_express_PrepOutSize6) {
        this.flag_express_PrepOutSize6 = flag_express_PrepOutSize6;
    }

    public Long getFlag_express_PrepOutSize7() {
        return flag_express_PrepOutSize7;
    }

    public void setFlag_express_PrepOutSize7(Long flag_express_PrepOutSize7) {
        this.flag_express_PrepOutSize7 = flag_express_PrepOutSize7;
    }

    public Long getFlag_express_PrepOutSize8() {
        return flag_express_PrepOutSize8;
    }

    public void setFlag_express_PrepOutSize8(Long flag_express_PrepOutSize8) {
        this.flag_express_PrepOutSize8 = flag_express_PrepOutSize8;
    }

    public Long getFlag_express_PrepOutSize9() {
        return flag_express_PrepOutSize9;
    }

    public void setFlag_express_PrepOutSize9(Long flag_express_PrepOutSize9) {
        this.flag_express_PrepOutSize9 = flag_express_PrepOutSize9;
    }

    public Long getFlag_express_PrepOutSize10() {
        return flag_express_PrepOutSize10;
    }

    public void setFlag_express_PrepOutSize10(Long flag_express_PrepOutSize10) {
        this.flag_express_PrepOutSize10 = flag_express_PrepOutSize10;
    }

    public Long getFlag_express_PrepOutSize11() {
        return flag_express_PrepOutSize11;
    }

    public void setFlag_express_PrepOutSize11(Long flag_express_PrepOutSize11) {
        this.flag_express_PrepOutSize11 = flag_express_PrepOutSize11;
    }

    public Long getFlag_express_PrepOutSize12() {
        return flag_express_PrepOutSize12;
    }

    public void setFlag_express_PrepOutSize12(Long flag_express_PrepOutSize12) {
        this.flag_express_PrepOutSize12 = flag_express_PrepOutSize12;
    }

    public Long getFlag_express_PrepOutSize13() {
        return flag_express_PrepOutSize13;
    }

    public void setFlag_express_PrepOutSize13(Long flag_express_PrepOutSize13) {
        this.flag_express_PrepOutSize13 = flag_express_PrepOutSize13;
    }

    public Long getFlag_express_PrepOutSize14() {
        return flag_express_PrepOutSize14;
    }

    public void setFlag_express_PrepOutSize14(Long flag_express_PrepOutSize14) {
        this.flag_express_PrepOutSize14 = flag_express_PrepOutSize14;
    }

    public Long getFlag_express_PrepOutSize15() {
        return flag_express_PrepOutSize15;
    }

    public void setFlag_express_PrepOutSize15(Long flag_express_PrepOutSize15) {
        this.flag_express_PrepOutSize15 = flag_express_PrepOutSize15;
    }

    public Long getFlag_express_PrepOutSize16() {
        return flag_express_PrepOutSize16;
    }

    public void setFlag_express_PrepOutSize16(Long flag_express_PrepOutSize16) {
        this.flag_express_PrepOutSize16 = flag_express_PrepOutSize16;
    }

    public Long getFlag_express_PrepOutSize17() {
        return flag_express_PrepOutSize17;
    }

    public void setFlag_express_PrepOutSize17(Long flag_express_PrepOutSize17) {
        this.flag_express_PrepOutSize17 = flag_express_PrepOutSize17;
    }

    public Long getFlag_express_PrepOutSize18() {
        return flag_express_PrepOutSize18;
    }

    public void setFlag_express_PrepOutSize18(Long flag_express_PrepOutSize18) {
        this.flag_express_PrepOutSize18 = flag_express_PrepOutSize18;
    }

    public Long getFlag_express_PrepOutSize1T() {
        return flag_express_PrepOutSize1T;
    }

    public void setFlag_express_PrepOutSize1T(Long flag_express_PrepOutSize1T) {
        this.flag_express_PrepOutSize1T = flag_express_PrepOutSize1T;
    }

    public Long getFlag_express_PrepOutSize2T() {
        return flag_express_PrepOutSize2T;
    }

    public void setFlag_express_PrepOutSize2T(Long flag_express_PrepOutSize2T) {
        this.flag_express_PrepOutSize2T = flag_express_PrepOutSize2T;
    }

    public Long getFlag_express_PrepOutSize3T() {
        return flag_express_PrepOutSize3T;
    }

    public void setFlag_express_PrepOutSize3T(Long flag_express_PrepOutSize3T) {
        this.flag_express_PrepOutSize3T = flag_express_PrepOutSize3T;
    }

    public Long getFlag_express_PrepOutSize4T() {
        return flag_express_PrepOutSize4T;
    }

    public void setFlag_express_PrepOutSize4T(Long flag_express_PrepOutSize4T) {
        this.flag_express_PrepOutSize4T = flag_express_PrepOutSize4T;
    }

    public Long getFlag_express_PrepOutSize5T() {
        return flag_express_PrepOutSize5T;
    }

    public void setFlag_express_PrepOutSize5T(Long flag_express_PrepOutSize5T) {
        this.flag_express_PrepOutSize5T = flag_express_PrepOutSize5T;
    }

    public Long getFlag_express_PrepOutSize6T() {
        return flag_express_PrepOutSize6T;
    }

    public void setFlag_express_PrepOutSize6T(Long flag_express_PrepOutSize6T) {
        this.flag_express_PrepOutSize6T = flag_express_PrepOutSize6T;
    }

    public Long getFlag_express_PrepOutSize7T() {
        return flag_express_PrepOutSize7T;
    }

    public void setFlag_express_PrepOutSize7T(Long flag_express_PrepOutSize7T) {
        this.flag_express_PrepOutSize7T = flag_express_PrepOutSize7T;
    }

    public Long getFlag_express_PrepOutSize8T() {
        return flag_express_PrepOutSize8T;
    }

    public void setFlag_express_PrepOutSize8T(Long flag_express_PrepOutSize8T) {
        this.flag_express_PrepOutSize8T = flag_express_PrepOutSize8T;
    }

    public Long getFlag_express_PrepOutSize9T() {
        return flag_express_PrepOutSize9T;
    }

    public void setFlag_express_PrepOutSize9T(Long flag_express_PrepOutSize9T) {
        this.flag_express_PrepOutSize9T = flag_express_PrepOutSize9T;
    }

    public Long getFlag_express_PrepOutSize10T() {
        return flag_express_PrepOutSize10T;
    }

    public void setFlag_express_PrepOutSize10T(Long flag_express_PrepOutSize10T) {
        this.flag_express_PrepOutSize10T = flag_express_PrepOutSize10T;
    }

    public Long getFlag_express_PrepOutSize11T() {
        return flag_express_PrepOutSize11T;
    }

    public void setFlag_express_PrepOutSize11T(Long flag_express_PrepOutSize11T) {
        this.flag_express_PrepOutSize11T = flag_express_PrepOutSize11T;
    }

    public Long getFlag_express_PrepOutSize12T() {
        return flag_express_PrepOutSize12T;
    }

    public void setFlag_express_PrepOutSize12T(Long flag_express_PrepOutSize12T) {
        this.flag_express_PrepOutSize12T = flag_express_PrepOutSize12T;
    }

    public Long getFlag_express_PrepOutSize13T() {
        return flag_express_PrepOutSize13T;
    }

    public void setFlag_express_PrepOutSize13T(Long flag_express_PrepOutSize13T) {
        this.flag_express_PrepOutSize13T = flag_express_PrepOutSize13T;
    }

    public Long getFlag_express_StInSize1() {
        return flag_express_StInSize1;
    }

    public void setFlag_express_StInSize1(Long flag_express_StInSize1) {
        this.flag_express_StInSize1 = flag_express_StInSize1;
    }

    public Long getFlag_express_StInSize2() {
        return flag_express_StInSize2;
    }

    public void setFlag_express_StInSize2(Long flag_express_StInSize2) {
        this.flag_express_StInSize2 = flag_express_StInSize2;
    }

    public Long getFlag_express_StInSize3() {
        return flag_express_StInSize3;
    }

    public void setFlag_express_StInSize3(Long flag_express_StInSize3) {
        this.flag_express_StInSize3 = flag_express_StInSize3;
    }

    public Long getFlag_express_StInSize4() {
        return flag_express_StInSize4;
    }

    public void setFlag_express_StInSize4(Long flag_express_StInSize4) {
        this.flag_express_StInSize4 = flag_express_StInSize4;
    }

    public Long getFlag_express_StInSize5() {
        return flag_express_StInSize5;
    }

    public void setFlag_express_StInSize5(Long flag_express_StInSize5) {
        this.flag_express_StInSize5 = flag_express_StInSize5;
    }

    public Long getFlag_express_StInSize6() {
        return flag_express_StInSize6;
    }

    public void setFlag_express_StInSize6(Long flag_express_StInSize6) {
        this.flag_express_StInSize6 = flag_express_StInSize6;
    }

    public Long getFlag_express_StInSize7() {
        return flag_express_StInSize7;
    }

    public void setFlag_express_StInSize7(Long flag_express_StInSize7) {
        this.flag_express_StInSize7 = flag_express_StInSize7;
    }

    public Long getFlag_express_StInSize8() {
        return flag_express_StInSize8;
    }

    public void setFlag_express_StInSize8(Long flag_express_StInSize8) {
        this.flag_express_StInSize8 = flag_express_StInSize8;
    }

    public Long getFlag_express_StInSize9() {
        return flag_express_StInSize9;
    }

    public void setFlag_express_StInSize9(Long flag_express_StInSize9) {
        this.flag_express_StInSize9 = flag_express_StInSize9;
    }

    public Long getFlag_express_StInSize10() {
        return flag_express_StInSize10;
    }

    public void setFlag_express_StInSize10(Long flag_express_StInSize10) {
        this.flag_express_StInSize10 = flag_express_StInSize10;
    }

    public Long getFlag_express_StInSize11() {
        return flag_express_StInSize11;
    }

    public void setFlag_express_StInSize11(Long flag_express_StInSize11) {
        this.flag_express_StInSize11 = flag_express_StInSize11;
    }

    public Long getFlag_express_StInSize12() {
        return flag_express_StInSize12;
    }

    public void setFlag_express_StInSize12(Long flag_express_StInSize12) {
        this.flag_express_StInSize12 = flag_express_StInSize12;
    }

    public Long getFlag_express_StInSize13() {
        return flag_express_StInSize13;
    }

    public void setFlag_express_StInSize13(Long flag_express_StInSize13) {
        this.flag_express_StInSize13 = flag_express_StInSize13;
    }

    public Long getFlag_express_StInSize14() {
        return flag_express_StInSize14;
    }

    public void setFlag_express_StInSize14(Long flag_express_StInSize14) {
        this.flag_express_StInSize14 = flag_express_StInSize14;
    }

    public Long getFlag_express_StInSize15() {
        return flag_express_StInSize15;
    }

    public void setFlag_express_StInSize15(Long flag_express_StInSize15) {
        this.flag_express_StInSize15 = flag_express_StInSize15;
    }

    public Long getFlag_express_StInSize16() {
        return flag_express_StInSize16;
    }

    public void setFlag_express_StInSize16(Long flag_express_StInSize16) {
        this.flag_express_StInSize16 = flag_express_StInSize16;
    }

    public Long getFlag_express_StInSize17() {
        return flag_express_StInSize17;
    }

    public void setFlag_express_StInSize17(Long flag_express_StInSize17) {
        this.flag_express_StInSize17 = flag_express_StInSize17;
    }

    public Long getFlag_express_StInSize18() {
        return flag_express_StInSize18;
    }

    public void setFlag_express_StInSize18(Long flag_express_StInSize18) {
        this.flag_express_StInSize18 = flag_express_StInSize18;
    }

    public Long getFlag_express_StInSize1T() {
        return flag_express_StInSize1T;
    }

    public void setFlag_express_StInSize1T(Long flag_express_StInSize1T) {
        this.flag_express_StInSize1T = flag_express_StInSize1T;
    }

    public Long getFlag_express_StInSize2T() {
        return flag_express_StInSize2T;
    }

    public void setFlag_express_StInSize2T(Long flag_express_StInSize2T) {
        this.flag_express_StInSize2T = flag_express_StInSize2T;
    }

    public Long getFlag_express_StInSize3T() {
        return flag_express_StInSize3T;
    }

    public void setFlag_express_StInSize3T(Long flag_express_StInSize3T) {
        this.flag_express_StInSize3T = flag_express_StInSize3T;
    }

    public Long getFlag_express_StInSize4T() {
        return flag_express_StInSize4T;
    }

    public void setFlag_express_StInSize4T(Long flag_express_StInSize4T) {
        this.flag_express_StInSize4T = flag_express_StInSize4T;
    }

    public Long getFlag_express_StInSize5T() {
        return flag_express_StInSize5T;
    }

    public void setFlag_express_StInSize5T(Long flag_express_StInSize5T) {
        this.flag_express_StInSize5T = flag_express_StInSize5T;
    }

    public Long getFlag_express_StInSize6T() {
        return flag_express_StInSize6T;
    }

    public void setFlag_express_StInSize6T(Long flag_express_StInSize6T) {
        this.flag_express_StInSize6T = flag_express_StInSize6T;
    }

    public Long getFlag_express_StInSize7T() {
        return flag_express_StInSize7T;
    }

    public void setFlag_express_StInSize7T(Long flag_express_StInSize7T) {
        this.flag_express_StInSize7T = flag_express_StInSize7T;
    }

    public Long getFlag_express_StInSize8T() {
        return flag_express_StInSize8T;
    }

    public void setFlag_express_StInSize8T(Long flag_express_StInSize8T) {
        this.flag_express_StInSize8T = flag_express_StInSize8T;
    }

    public Long getFlag_express_StInSize9T() {
        return flag_express_StInSize9T;
    }

    public void setFlag_express_StInSize9T(Long flag_express_StInSize9T) {
        this.flag_express_StInSize9T = flag_express_StInSize9T;
    }

    public Long getFlag_express_StInSize10T() {
        return flag_express_StInSize10T;
    }

    public void setFlag_express_StInSize10T(Long flag_express_StInSize10T) {
        this.flag_express_StInSize10T = flag_express_StInSize10T;
    }

    public Long getFlag_express_StInSize11T() {
        return flag_express_StInSize11T;
    }

    public void setFlag_express_StInSize11T(Long flag_express_StInSize11T) {
        this.flag_express_StInSize11T = flag_express_StInSize11T;
    }

    public Long getFlag_express_StInSize12T() {
        return flag_express_StInSize12T;
    }

    public void setFlag_express_StInSize12T(Long flag_express_StInSize12T) {
        this.flag_express_StInSize12T = flag_express_StInSize12T;
    }

    public Long getFlag_express_StInSize13T() {
        return flag_express_StInSize13T;
    }

    public void setFlag_express_StInSize13T(Long flag_express_StInSize13T) {
        this.flag_express_StInSize13T = flag_express_StInSize13T;
    }

    public Long getFlag_express_StOutSize1() {
        return flag_express_StOutSize1;
    }

    public void setFlag_express_StOutSize1(Long flag_express_StOutSize1) {
        this.flag_express_StOutSize1 = flag_express_StOutSize1;
    }

    public Long getFlag_express_StOutSize2() {
        return flag_express_StOutSize2;
    }

    public void setFlag_express_StOutSize2(Long flag_express_StOutSize2) {
        this.flag_express_StOutSize2 = flag_express_StOutSize2;
    }

    public Long getFlag_express_StOutSize3() {
        return flag_express_StOutSize3;
    }

    public void setFlag_express_StOutSize3(Long flag_express_StOutSize3) {
        this.flag_express_StOutSize3 = flag_express_StOutSize3;
    }

    public Long getFlag_express_StOutSize4() {
        return flag_express_StOutSize4;
    }

    public void setFlag_express_StOutSize4(Long flag_express_StOutSize4) {
        this.flag_express_StOutSize4 = flag_express_StOutSize4;
    }

    public Long getFlag_express_StOutSize5() {
        return flag_express_StOutSize5;
    }

    public void setFlag_express_StOutSize5(Long flag_express_StOutSize5) {
        this.flag_express_StOutSize5 = flag_express_StOutSize5;
    }

    public Long getFlag_express_StOutSize6() {
        return flag_express_StOutSize6;
    }

    public void setFlag_express_StOutSize6(Long flag_express_StOutSize6) {
        this.flag_express_StOutSize6 = flag_express_StOutSize6;
    }

    public Long getFlag_express_StOutSize7() {
        return flag_express_StOutSize7;
    }

    public void setFlag_express_StOutSize7(Long flag_express_StOutSize7) {
        this.flag_express_StOutSize7 = flag_express_StOutSize7;
    }

    public Long getFlag_express_StOutSize8() {
        return flag_express_StOutSize8;
    }

    public void setFlag_express_StOutSize8(Long flag_express_StOutSize8) {
        this.flag_express_StOutSize8 = flag_express_StOutSize8;
    }

    public Long getFlag_express_StOutSize9() {
        return flag_express_StOutSize9;
    }

    public void setFlag_express_StOutSize9(Long flag_express_StOutSize9) {
        this.flag_express_StOutSize9 = flag_express_StOutSize9;
    }

    public Long getFlag_express_StOutSize10() {
        return flag_express_StOutSize10;
    }

    public void setFlag_express_StOutSize10(Long flag_express_StOutSize10) {
        this.flag_express_StOutSize10 = flag_express_StOutSize10;
    }

    public Long getFlag_express_StOutSize11() {
        return flag_express_StOutSize11;
    }

    public void setFlag_express_StOutSize11(Long flag_express_StOutSize11) {
        this.flag_express_StOutSize11 = flag_express_StOutSize11;
    }

    public Long getFlag_express_StOutSize12() {
        return flag_express_StOutSize12;
    }

    public void setFlag_express_StOutSize12(Long flag_express_StOutSize12) {
        this.flag_express_StOutSize12 = flag_express_StOutSize12;
    }

    public Long getFlag_express_StOutSize13() {
        return flag_express_StOutSize13;
    }

    public void setFlag_express_StOutSize13(Long flag_express_StOutSize13) {
        this.flag_express_StOutSize13 = flag_express_StOutSize13;
    }

    public Long getFlag_express_StOutSize14() {
        return flag_express_StOutSize14;
    }

    public void setFlag_express_StOutSize14(Long flag_express_StOutSize14) {
        this.flag_express_StOutSize14 = flag_express_StOutSize14;
    }

    public Long getFlag_express_StOutSize15() {
        return flag_express_StOutSize15;
    }

    public void setFlag_express_StOutSize15(Long flag_express_StOutSize15) {
        this.flag_express_StOutSize15 = flag_express_StOutSize15;
    }

    public Long getFlag_express_StOutSize16() {
        return flag_express_StOutSize16;
    }

    public void setFlag_express_StOutSize16(Long flag_express_StOutSize16) {
        this.flag_express_StOutSize16 = flag_express_StOutSize16;
    }

    public Long getFlag_express_StOutSize17() {
        return flag_express_StOutSize17;
    }

    public void setFlag_express_StOutSize17(Long flag_express_StOutSize17) {
        this.flag_express_StOutSize17 = flag_express_StOutSize17;
    }

    public Long getFlag_express_StOutSize18() {
        return flag_express_StOutSize18;
    }

    public void setFlag_express_StOutSize18(Long flag_express_StOutSize18) {
        this.flag_express_StOutSize18 = flag_express_StOutSize18;
    }

    public Long getFlag_express_StOutSize1T() {
        return flag_express_StOutSize1T;
    }

    public void setFlag_express_StOutSize1T(Long flag_express_StOutSize1T) {
        this.flag_express_StOutSize1T = flag_express_StOutSize1T;
    }

    public Long getFlag_express_StOutSize2T() {
        return flag_express_StOutSize2T;
    }

    public void setFlag_express_StOutSize2T(Long flag_express_StOutSize2T) {
        this.flag_express_StOutSize2T = flag_express_StOutSize2T;
    }

    public Long getFlag_express_StOutSize3T() {
        return flag_express_StOutSize3T;
    }

    public void setFlag_express_StOutSize3T(Long flag_express_StOutSize3T) {
        this.flag_express_StOutSize3T = flag_express_StOutSize3T;
    }

    public Long getFlag_express_StOutSize4T() {
        return flag_express_StOutSize4T;
    }

    public void setFlag_express_StOutSize4T(Long flag_express_StOutSize4T) {
        this.flag_express_StOutSize4T = flag_express_StOutSize4T;
    }

    public Long getFlag_express_StOutSize5T() {
        return flag_express_StOutSize5T;
    }

    public void setFlag_express_StOutSize5T(Long flag_express_StOutSize5T) {
        this.flag_express_StOutSize5T = flag_express_StOutSize5T;
    }

    public Long getFlag_express_StOutSize6T() {
        return flag_express_StOutSize6T;
    }

    public void setFlag_express_StOutSize6T(Long flag_express_StOutSize6T) {
        this.flag_express_StOutSize6T = flag_express_StOutSize6T;
    }

    public Long getFlag_express_StOutSize7T() {
        return flag_express_StOutSize7T;
    }

    public void setFlag_express_StOutSize7T(Long flag_express_StOutSize7T) {
        this.flag_express_StOutSize7T = flag_express_StOutSize7T;
    }

    public Long getFlag_express_StOutSize8T() {
        return flag_express_StOutSize8T;
    }

    public void setFlag_express_StOutSize8T(Long flag_express_StOutSize8T) {
        this.flag_express_StOutSize8T = flag_express_StOutSize8T;
    }

    public Long getFlag_express_StOutSize9T() {
        return flag_express_StOutSize9T;
    }

    public void setFlag_express_StOutSize9T(Long flag_express_StOutSize9T) {
        this.flag_express_StOutSize9T = flag_express_StOutSize9T;
    }

    public Long getFlag_express_StOutSize10T() {
        return flag_express_StOutSize10T;
    }

    public void setFlag_express_StOutSize10T(Long flag_express_StOutSize10T) {
        this.flag_express_StOutSize10T = flag_express_StOutSize10T;
    }

    public Long getFlag_express_StOutSize11T() {
        return flag_express_StOutSize11T;
    }

    public void setFlag_express_StOutSize11T(Long flag_express_StOutSize11T) {
        this.flag_express_StOutSize11T = flag_express_StOutSize11T;
    }

    public Long getFlag_express_StOutSize12T() {
        return flag_express_StOutSize12T;
    }

    public void setFlag_express_StOutSize12T(Long flag_express_StOutSize12T) {
        this.flag_express_StOutSize12T = flag_express_StOutSize12T;
    }

    public Long getFlag_express_StOutSize13T() {
        return flag_express_StOutSize13T;
    }

    public void setFlag_express_StOutSize13T(Long flag_express_StOutSize13T) {
        this.flag_express_StOutSize13T = flag_express_StOutSize13T;
    }

    public Long getFlag_express_AsInSize1() {
        return flag_express_AsInSize1;
    }

    public void setFlag_express_AsInSize1(Long flag_express_AsInSize1) {
        this.flag_express_AsInSize1 = flag_express_AsInSize1;
    }

    public Long getFlag_express_AsInSize2() {
        return flag_express_AsInSize2;
    }

    public void setFlag_express_AsInSize2(Long flag_express_AsInSize2) {
        this.flag_express_AsInSize2 = flag_express_AsInSize2;
    }

    public Long getFlag_express_AsInSize3() {
        return flag_express_AsInSize3;
    }

    public void setFlag_express_AsInSize3(Long flag_express_AsInSize3) {
        this.flag_express_AsInSize3 = flag_express_AsInSize3;
    }

    public Long getFlag_express_AsInSize4() {
        return flag_express_AsInSize4;
    }

    public void setFlag_express_AsInSize4(Long flag_express_AsInSize4) {
        this.flag_express_AsInSize4 = flag_express_AsInSize4;
    }

    public Long getFlag_express_AsInSize5() {
        return flag_express_AsInSize5;
    }

    public void setFlag_express_AsInSize5(Long flag_express_AsInSize5) {
        this.flag_express_AsInSize5 = flag_express_AsInSize5;
    }

    public Long getFlag_express_AsInSize6() {
        return flag_express_AsInSize6;
    }

    public void setFlag_express_AsInSize6(Long flag_express_AsInSize6) {
        this.flag_express_AsInSize6 = flag_express_AsInSize6;
    }

    public Long getFlag_express_AsInSize7() {
        return flag_express_AsInSize7;
    }

    public void setFlag_express_AsInSize7(Long flag_express_AsInSize7) {
        this.flag_express_AsInSize7 = flag_express_AsInSize7;
    }

    public Long getFlag_express_AsInSize8() {
        return flag_express_AsInSize8;
    }

    public void setFlag_express_AsInSize8(Long flag_express_AsInSize8) {
        this.flag_express_AsInSize8 = flag_express_AsInSize8;
    }

    public Long getFlag_express_AsInSize9() {
        return flag_express_AsInSize9;
    }

    public void setFlag_express_AsInSize9(Long flag_express_AsInSize9) {
        this.flag_express_AsInSize9 = flag_express_AsInSize9;
    }

    public Long getFlag_express_AsInSize10() {
        return flag_express_AsInSize10;
    }

    public void setFlag_express_AsInSize10(Long flag_express_AsInSize10) {
        this.flag_express_AsInSize10 = flag_express_AsInSize10;
    }

    public Long getFlag_express_AsInSize11() {
        return flag_express_AsInSize11;
    }

    public void setFlag_express_AsInSize11(Long flag_express_AsInSize11) {
        this.flag_express_AsInSize11 = flag_express_AsInSize11;
    }

    public Long getFlag_express_AsInSize12() {
        return flag_express_AsInSize12;
    }

    public void setFlag_express_AsInSize12(Long flag_express_AsInSize12) {
        this.flag_express_AsInSize12 = flag_express_AsInSize12;
    }

    public Long getFlag_express_AsInSize13() {
        return flag_express_AsInSize13;
    }

    public void setFlag_express_AsInSize13(Long flag_express_AsInSize13) {
        this.flag_express_AsInSize13 = flag_express_AsInSize13;
    }

    public Long getFlag_express_AsInSize14() {
        return flag_express_AsInSize14;
    }

    public void setFlag_express_AsInSize14(Long flag_express_AsInSize14) {
        this.flag_express_AsInSize14 = flag_express_AsInSize14;
    }

    public Long getFlag_express_AsInSize15() {
        return flag_express_AsInSize15;
    }

    public void setFlag_express_AsInSize15(Long flag_express_AsInSize15) {
        this.flag_express_AsInSize15 = flag_express_AsInSize15;
    }

    public Long getFlag_express_AsInSize16() {
        return flag_express_AsInSize16;
    }

    public void setFlag_express_AsInSize16(Long flag_express_AsInSize16) {
        this.flag_express_AsInSize16 = flag_express_AsInSize16;
    }

    public Long getFlag_express_AsInSize17() {
        return flag_express_AsInSize17;
    }

    public void setFlag_express_AsInSize17(Long flag_express_AsInSize17) {
        this.flag_express_AsInSize17 = flag_express_AsInSize17;
    }

    public Long getFlag_express_AsInSize18() {
        return flag_express_AsInSize18;
    }

    public void setFlag_express_AsInSize18(Long flag_express_AsInSize18) {
        this.flag_express_AsInSize18 = flag_express_AsInSize18;
    }

    public Long getFlag_express_AsInSize1T() {
        return flag_express_AsInSize1T;
    }

    public void setFlag_express_AsInSize1T(Long flag_express_AsInSize1T) {
        this.flag_express_AsInSize1T = flag_express_AsInSize1T;
    }

    public Long getFlag_express_AsInSize2T() {
        return flag_express_AsInSize2T;
    }

    public void setFlag_express_AsInSize2T(Long flag_express_AsInSize2T) {
        this.flag_express_AsInSize2T = flag_express_AsInSize2T;
    }

    public Long getFlag_express_AsInSize3T() {
        return flag_express_AsInSize3T;
    }

    public void setFlag_express_AsInSize3T(Long flag_express_AsInSize3T) {
        this.flag_express_AsInSize3T = flag_express_AsInSize3T;
    }

    public Long getFlag_express_AsInSize4T() {
        return flag_express_AsInSize4T;
    }

    public void setFlag_express_AsInSize4T(Long flag_express_AsInSize4T) {
        this.flag_express_AsInSize4T = flag_express_AsInSize4T;
    }

    public Long getFlag_express_AsInSize5T() {
        return flag_express_AsInSize5T;
    }

    public void setFlag_express_AsInSize5T(Long flag_express_AsInSize5T) {
        this.flag_express_AsInSize5T = flag_express_AsInSize5T;
    }

    public Long getFlag_express_AsInSize6T() {
        return flag_express_AsInSize6T;
    }

    public void setFlag_express_AsInSize6T(Long flag_express_AsInSize6T) {
        this.flag_express_AsInSize6T = flag_express_AsInSize6T;
    }

    public Long getFlag_express_AsInSize7T() {
        return flag_express_AsInSize7T;
    }

    public void setFlag_express_AsInSize7T(Long flag_express_AsInSize7T) {
        this.flag_express_AsInSize7T = flag_express_AsInSize7T;
    }

    public Long getFlag_express_AsInSize8T() {
        return flag_express_AsInSize8T;
    }

    public void setFlag_express_AsInSize8T(Long flag_express_AsInSize8T) {
        this.flag_express_AsInSize8T = flag_express_AsInSize8T;
    }

    public Long getFlag_express_AsInSize9T() {
        return flag_express_AsInSize9T;
    }

    public void setFlag_express_AsInSize9T(Long flag_express_AsInSize9T) {
        this.flag_express_AsInSize9T = flag_express_AsInSize9T;
    }

    public Long getFlag_express_AsInSize10T() {
        return flag_express_AsInSize10T;
    }

    public void setFlag_express_AsInSize10T(Long flag_express_AsInSize10T) {
        this.flag_express_AsInSize10T = flag_express_AsInSize10T;
    }

    public Long getFlag_express_AsInSize11T() {
        return flag_express_AsInSize11T;
    }

    public void setFlag_express_AsInSize11T(Long flag_express_AsInSize11T) {
        this.flag_express_AsInSize11T = flag_express_AsInSize11T;
    }

    public Long getFlag_express_AsInSize12T() {
        return flag_express_AsInSize12T;
    }

    public void setFlag_express_AsInSize12T(Long flag_express_AsInSize12T) {
        this.flag_express_AsInSize12T = flag_express_AsInSize12T;
    }

    public Long getFlag_express_AsInSize13T() {
        return flag_express_AsInSize13T;
    }

    public void setFlag_express_AsInSize13T(Long flag_express_AsInSize13T) {
        this.flag_express_AsInSize13T = flag_express_AsInSize13T;
    }

    public Long getFlag_express_AsOutSize1() {
        return flag_express_AsOutSize1;
    }

    public void setFlag_express_AsOutSize1(Long flag_express_AsOutSize1) {
        this.flag_express_AsOutSize1 = flag_express_AsOutSize1;
    }

    public Long getFlag_express_AsOutSize2() {
        return flag_express_AsOutSize2;
    }

    public void setFlag_express_AsOutSize2(Long flag_express_AsOutSize2) {
        this.flag_express_AsOutSize2 = flag_express_AsOutSize2;
    }

    public Long getFlag_express_AsOutSize3() {
        return flag_express_AsOutSize3;
    }

    public void setFlag_express_AsOutSize3(Long flag_express_AsOutSize3) {
        this.flag_express_AsOutSize3 = flag_express_AsOutSize3;
    }

    public Long getFlag_express_AsOutSize4() {
        return flag_express_AsOutSize4;
    }

    public void setFlag_express_AsOutSize4(Long flag_express_AsOutSize4) {
        this.flag_express_AsOutSize4 = flag_express_AsOutSize4;
    }

    public Long getFlag_express_AsOutSize5() {
        return flag_express_AsOutSize5;
    }

    public void setFlag_express_AsOutSize5(Long flag_express_AsOutSize5) {
        this.flag_express_AsOutSize5 = flag_express_AsOutSize5;
    }

    public Long getFlag_express_AsOutSize6() {
        return flag_express_AsOutSize6;
    }

    public void setFlag_express_AsOutSize6(Long flag_express_AsOutSize6) {
        this.flag_express_AsOutSize6 = flag_express_AsOutSize6;
    }

    public Long getFlag_express_AsOutSize7() {
        return flag_express_AsOutSize7;
    }

    public void setFlag_express_AsOutSize7(Long flag_express_AsOutSize7) {
        this.flag_express_AsOutSize7 = flag_express_AsOutSize7;
    }

    public Long getFlag_express_AsOutSize8() {
        return flag_express_AsOutSize8;
    }

    public void setFlag_express_AsOutSize8(Long flag_express_AsOutSize8) {
        this.flag_express_AsOutSize8 = flag_express_AsOutSize8;
    }

    public Long getFlag_express_AsOutSize9() {
        return flag_express_AsOutSize9;
    }

    public void setFlag_express_AsOutSize9(Long flag_express_AsOutSize9) {
        this.flag_express_AsOutSize9 = flag_express_AsOutSize9;
    }

    public Long getFlag_express_AsOutSize10() {
        return flag_express_AsOutSize10;
    }

    public void setFlag_express_AsOutSize10(Long flag_express_AsOutSize10) {
        this.flag_express_AsOutSize10 = flag_express_AsOutSize10;
    }

    public Long getFlag_express_AsOutSize11() {
        return flag_express_AsOutSize11;
    }

    public void setFlag_express_AsOutSize11(Long flag_express_AsOutSize11) {
        this.flag_express_AsOutSize11 = flag_express_AsOutSize11;
    }

    public Long getFlag_express_AsOutSize12() {
        return flag_express_AsOutSize12;
    }

    public void setFlag_express_AsOutSize12(Long flag_express_AsOutSize12) {
        this.flag_express_AsOutSize12 = flag_express_AsOutSize12;
    }

    public Long getFlag_express_AsOutSize13() {
        return flag_express_AsOutSize13;
    }

    public void setFlag_express_AsOutSize13(Long flag_express_AsOutSize13) {
        this.flag_express_AsOutSize13 = flag_express_AsOutSize13;
    }

    public Long getFlag_express_AsOutSize14() {
        return flag_express_AsOutSize14;
    }

    public void setFlag_express_AsOutSize14(Long flag_express_AsOutSize14) {
        this.flag_express_AsOutSize14 = flag_express_AsOutSize14;
    }

    public Long getFlag_express_AsOutSize15() {
        return flag_express_AsOutSize15;
    }

    public void setFlag_express_AsOutSize15(Long flag_express_AsOutSize15) {
        this.flag_express_AsOutSize15 = flag_express_AsOutSize15;
    }

    public Long getFlag_express_AsOutSize16() {
        return flag_express_AsOutSize16;
    }

    public void setFlag_express_AsOutSize16(Long flag_express_AsOutSize16) {
        this.flag_express_AsOutSize16 = flag_express_AsOutSize16;
    }

    public Long getFlag_express_AsOutSize17() {
        return flag_express_AsOutSize17;
    }

    public void setFlag_express_AsOutSize17(Long flag_express_AsOutSize17) {
        this.flag_express_AsOutSize17 = flag_express_AsOutSize17;
    }

    public Long getFlag_express_AsOutSize18() {
        return flag_express_AsOutSize18;
    }

    public void setFlag_express_AsOutSize18(Long flag_express_AsOutSize18) {
        this.flag_express_AsOutSize18 = flag_express_AsOutSize18;
    }

    public Long getFlag_express_AsOutSize1T() {
        return flag_express_AsOutSize1T;
    }

    public void setFlag_express_AsOutSize1T(Long flag_express_AsOutSize1T) {
        this.flag_express_AsOutSize1T = flag_express_AsOutSize1T;
    }

    public Long getFlag_express_AsOutSize2T() {
        return flag_express_AsOutSize2T;
    }

    public void setFlag_express_AsOutSize2T(Long flag_express_AsOutSize2T) {
        this.flag_express_AsOutSize2T = flag_express_AsOutSize2T;
    }

    public Long getFlag_express_AsOutSize3T() {
        return flag_express_AsOutSize3T;
    }

    public void setFlag_express_AsOutSize3T(Long flag_express_AsOutSize3T) {
        this.flag_express_AsOutSize3T = flag_express_AsOutSize3T;
    }

    public Long getFlag_express_AsOutSize4T() {
        return flag_express_AsOutSize4T;
    }

    public void setFlag_express_AsOutSize4T(Long flag_express_AsOutSize4T) {
        this.flag_express_AsOutSize4T = flag_express_AsOutSize4T;
    }

    public Long getFlag_express_AsOutSize5T() {
        return flag_express_AsOutSize5T;
    }

    public void setFlag_express_AsOutSize5T(Long flag_express_AsOutSize5T) {
        this.flag_express_AsOutSize5T = flag_express_AsOutSize5T;
    }

    public Long getFlag_express_AsOutSize6T() {
        return flag_express_AsOutSize6T;
    }

    public void setFlag_express_AsOutSize6T(Long flag_express_AsOutSize6T) {
        this.flag_express_AsOutSize6T = flag_express_AsOutSize6T;
    }

    public Long getFlag_express_AsOutSize7T() {
        return flag_express_AsOutSize7T;
    }

    public void setFlag_express_AsOutSize7T(Long flag_express_AsOutSize7T) {
        this.flag_express_AsOutSize7T = flag_express_AsOutSize7T;
    }

    public Long getFlag_express_AsOutSize8T() {
        return flag_express_AsOutSize8T;
    }

    public void setFlag_express_AsOutSize8T(Long flag_express_AsOutSize8T) {
        this.flag_express_AsOutSize8T = flag_express_AsOutSize8T;
    }

    public Long getFlag_express_AsOutSize9T() {
        return flag_express_AsOutSize9T;
    }

    public void setFlag_express_AsOutSize9T(Long flag_express_AsOutSize9T) {
        this.flag_express_AsOutSize9T = flag_express_AsOutSize9T;
    }

    public Long getFlag_express_AsOutSize10T() {
        return flag_express_AsOutSize10T;
    }

    public void setFlag_express_AsOutSize10T(Long flag_express_AsOutSize10T) {
        this.flag_express_AsOutSize10T = flag_express_AsOutSize10T;
    }

    public Long getFlag_express_AsOutSize11T() {
        return flag_express_AsOutSize11T;
    }

    public void setFlag_express_AsOutSize11T(Long flag_express_AsOutSize11T) {
        this.flag_express_AsOutSize11T = flag_express_AsOutSize11T;
    }

    public Long getFlag_express_AsOutSize12T() {
        return flag_express_AsOutSize12T;
    }

    public void setFlag_express_AsOutSize12T(Long flag_express_AsOutSize12T) {
        this.flag_express_AsOutSize12T = flag_express_AsOutSize12T;
    }

    public Long getFlag_express_AsOutSize13T() {
        return flag_express_AsOutSize13T;
    }

    public void setFlag_express_AsOutSize13T(Long flag_express_AsOutSize13T) {
        this.flag_express_AsOutSize13T = flag_express_AsOutSize13T;
    }

    public Long getFlag_express_CscInSize1() {
        return flag_express_CscInSize1;
    }

    public void setFlag_express_CscInSize1(Long flag_express_CscInSize1) {
        this.flag_express_CscInSize1 = flag_express_CscInSize1;
    }

    public Long getFlag_express_CscInSize2() {
        return flag_express_CscInSize2;
    }

    public void setFlag_express_CscInSize2(Long flag_express_CscInSize2) {
        this.flag_express_CscInSize2 = flag_express_CscInSize2;
    }

    public Long getFlag_express_CscInSize3() {
        return flag_express_CscInSize3;
    }

    public void setFlag_express_CscInSize3(Long flag_express_CscInSize3) {
        this.flag_express_CscInSize3 = flag_express_CscInSize3;
    }

    public Long getFlag_express_CscInSize4() {
        return flag_express_CscInSize4;
    }

    public void setFlag_express_CscInSize4(Long flag_express_CscInSize4) {
        this.flag_express_CscInSize4 = flag_express_CscInSize4;
    }

    public Long getFlag_express_CscInSize5() {
        return flag_express_CscInSize5;
    }

    public void setFlag_express_CscInSize5(Long flag_express_CscInSize5) {
        this.flag_express_CscInSize5 = flag_express_CscInSize5;
    }

    public Long getFlag_express_CscInSize6() {
        return flag_express_CscInSize6;
    }

    public void setFlag_express_CscInSize6(Long flag_express_CscInSize6) {
        this.flag_express_CscInSize6 = flag_express_CscInSize6;
    }

    public Long getFlag_express_CscInSize7() {
        return flag_express_CscInSize7;
    }

    public void setFlag_express_CscInSize7(Long flag_express_CscInSize7) {
        this.flag_express_CscInSize7 = flag_express_CscInSize7;
    }

    public Long getFlag_express_CscInSize8() {
        return flag_express_CscInSize8;
    }

    public void setFlag_express_CscInSize8(Long flag_express_CscInSize8) {
        this.flag_express_CscInSize8 = flag_express_CscInSize8;
    }

    public Long getFlag_express_CscInSize9() {
        return flag_express_CscInSize9;
    }

    public void setFlag_express_CscInSize9(Long flag_express_CscInSize9) {
        this.flag_express_CscInSize9 = flag_express_CscInSize9;
    }

    public Long getFlag_express_CscInSize10() {
        return flag_express_CscInSize10;
    }

    public void setFlag_express_CscInSize10(Long flag_express_CscInSize10) {
        this.flag_express_CscInSize10 = flag_express_CscInSize10;
    }

    public Long getFlag_express_CscInSize11() {
        return flag_express_CscInSize11;
    }

    public void setFlag_express_CscInSize11(Long flag_express_CscInSize11) {
        this.flag_express_CscInSize11 = flag_express_CscInSize11;
    }

    public Long getFlag_express_CscInSize12() {
        return flag_express_CscInSize12;
    }

    public void setFlag_express_CscInSize12(Long flag_express_CscInSize12) {
        this.flag_express_CscInSize12 = flag_express_CscInSize12;
    }

    public Long getFlag_express_CscInSize13() {
        return flag_express_CscInSize13;
    }

    public void setFlag_express_CscInSize13(Long flag_express_CscInSize13) {
        this.flag_express_CscInSize13 = flag_express_CscInSize13;
    }

    public Long getFlag_express_CscInSize14() {
        return flag_express_CscInSize14;
    }

    public void setFlag_express_CscInSize14(Long flag_express_CscInSize14) {
        this.flag_express_CscInSize14 = flag_express_CscInSize14;
    }

    public Long getFlag_express_CscInSize15() {
        return flag_express_CscInSize15;
    }

    public void setFlag_express_CscInSize15(Long flag_express_CscInSize15) {
        this.flag_express_CscInSize15 = flag_express_CscInSize15;
    }

    public Long getFlag_express_CscInSize16() {
        return flag_express_CscInSize16;
    }

    public void setFlag_express_CscInSize16(Long flag_express_CscInSize16) {
        this.flag_express_CscInSize16 = flag_express_CscInSize16;
    }

    public Long getFlag_express_CscInSize17() {
        return flag_express_CscInSize17;
    }

    public void setFlag_express_CscInSize17(Long flag_express_CscInSize17) {
        this.flag_express_CscInSize17 = flag_express_CscInSize17;
    }

    public Long getFlag_express_CscInSize18() {
        return flag_express_CscInSize18;
    }

    public void setFlag_express_CscInSize18(Long flag_express_CscInSize18) {
        this.flag_express_CscInSize18 = flag_express_CscInSize18;
    }

    public Long getFlag_express_CscInSize1T() {
        return flag_express_CscInSize1T;
    }

    public void setFlag_express_CscInSize1T(Long flag_express_CscInSize1T) {
        this.flag_express_CscInSize1T = flag_express_CscInSize1T;
    }

    public Long getFlag_express_CscInSize2T() {
        return flag_express_CscInSize2T;
    }

    public void setFlag_express_CscInSize2T(Long flag_express_CscInSize2T) {
        this.flag_express_CscInSize2T = flag_express_CscInSize2T;
    }

    public Long getFlag_express_CscInSize3T() {
        return flag_express_CscInSize3T;
    }

    public void setFlag_express_CscInSize3T(Long flag_express_CscInSize3T) {
        this.flag_express_CscInSize3T = flag_express_CscInSize3T;
    }

    public Long getFlag_express_CscInSize4T() {
        return flag_express_CscInSize4T;
    }

    public void setFlag_express_CscInSize4T(Long flag_express_CscInSize4T) {
        this.flag_express_CscInSize4T = flag_express_CscInSize4T;
    }

    public Long getFlag_express_CscInSize5T() {
        return flag_express_CscInSize5T;
    }

    public void setFlag_express_CscInSize5T(Long flag_express_CscInSize5T) {
        this.flag_express_CscInSize5T = flag_express_CscInSize5T;
    }

    public Long getFlag_express_CscInSize6T() {
        return flag_express_CscInSize6T;
    }

    public void setFlag_express_CscInSize6T(Long flag_express_CscInSize6T) {
        this.flag_express_CscInSize6T = flag_express_CscInSize6T;
    }

    public Long getFlag_express_CscInSize7T() {
        return flag_express_CscInSize7T;
    }

    public void setFlag_express_CscInSize7T(Long flag_express_CscInSize7T) {
        this.flag_express_CscInSize7T = flag_express_CscInSize7T;
    }

    public Long getFlag_express_CscInSize8T() {
        return flag_express_CscInSize8T;
    }

    public void setFlag_express_CscInSize8T(Long flag_express_CscInSize8T) {
        this.flag_express_CscInSize8T = flag_express_CscInSize8T;
    }

    public Long getFlag_express_CscInSize9T() {
        return flag_express_CscInSize9T;
    }

    public void setFlag_express_CscInSize9T(Long flag_express_CscInSize9T) {
        this.flag_express_CscInSize9T = flag_express_CscInSize9T;
    }

    public Long getFlag_express_CscInSize10T() {
        return flag_express_CscInSize10T;
    }

    public void setFlag_express_CscInSize10T(Long flag_express_CscInSize10T) {
        this.flag_express_CscInSize10T = flag_express_CscInSize10T;
    }

    public Long getFlag_express_CscInSize11T() {
        return flag_express_CscInSize11T;
    }

    public void setFlag_express_CscInSize11T(Long flag_express_CscInSize11T) {
        this.flag_express_CscInSize11T = flag_express_CscInSize11T;
    }

    public Long getFlag_express_CscInSize12T() {
        return flag_express_CscInSize12T;
    }

    public void setFlag_express_CscInSize12T(Long flag_express_CscInSize12T) {
        this.flag_express_CscInSize12T = flag_express_CscInSize12T;
    }

    public Long getFlag_express_CscInSize13T() {
        return flag_express_CscInSize13T;
    }

    public void setFlag_express_CscInSize13T(Long flag_express_CscInSize13T) {
        this.flag_express_CscInSize13T = flag_express_CscInSize13T;
    }

    public Long getFlag_express_CscOutSize1() {
        return flag_express_CscOutSize1;
    }

    public void setFlag_express_CscOutSize1(Long flag_express_CscOutSize1) {
        this.flag_express_CscOutSize1 = flag_express_CscOutSize1;
    }

    public Long getFlag_express_CscOutSize2() {
        return flag_express_CscOutSize2;
    }

    public void setFlag_express_CscOutSize2(Long flag_express_CscOutSize2) {
        this.flag_express_CscOutSize2 = flag_express_CscOutSize2;
    }

    public Long getFlag_express_CscOutSize3() {
        return flag_express_CscOutSize3;
    }

    public void setFlag_express_CscOutSize3(Long flag_express_CscOutSize3) {
        this.flag_express_CscOutSize3 = flag_express_CscOutSize3;
    }

    public Long getFlag_express_CscOutSize4() {
        return flag_express_CscOutSize4;
    }

    public void setFlag_express_CscOutSize4(Long flag_express_CscOutSize4) {
        this.flag_express_CscOutSize4 = flag_express_CscOutSize4;
    }

    public Long getFlag_express_CscOutSize5() {
        return flag_express_CscOutSize5;
    }

    public void setFlag_express_CscOutSize5(Long flag_express_CscOutSize5) {
        this.flag_express_CscOutSize5 = flag_express_CscOutSize5;
    }

    public Long getFlag_express_CscOutSize6() {
        return flag_express_CscOutSize6;
    }

    public void setFlag_express_CscOutSize6(Long flag_express_CscOutSize6) {
        this.flag_express_CscOutSize6 = flag_express_CscOutSize6;
    }

    public Long getFlag_express_CscOutSize7() {
        return flag_express_CscOutSize7;
    }

    public void setFlag_express_CscOutSize7(Long flag_express_CscOutSize7) {
        this.flag_express_CscOutSize7 = flag_express_CscOutSize7;
    }

    public Long getFlag_express_CscOutSize8() {
        return flag_express_CscOutSize8;
    }

    public void setFlag_express_CscOutSize8(Long flag_express_CscOutSize8) {
        this.flag_express_CscOutSize8 = flag_express_CscOutSize8;
    }

    public Long getFlag_express_CscOutSize9() {
        return flag_express_CscOutSize9;
    }

    public void setFlag_express_CscOutSize9(Long flag_express_CscOutSize9) {
        this.flag_express_CscOutSize9 = flag_express_CscOutSize9;
    }

    public Long getFlag_express_CscOutSize10() {
        return flag_express_CscOutSize10;
    }

    public void setFlag_express_CscOutSize10(Long flag_express_CscOutSize10) {
        this.flag_express_CscOutSize10 = flag_express_CscOutSize10;
    }

    public Long getFlag_express_CscOutSize11() {
        return flag_express_CscOutSize11;
    }

    public void setFlag_express_CscOutSize11(Long flag_express_CscOutSize11) {
        this.flag_express_CscOutSize11 = flag_express_CscOutSize11;
    }

    public Long getFlag_express_CscOutSize12() {
        return flag_express_CscOutSize12;
    }

    public void setFlag_express_CscOutSize12(Long flag_express_CscOutSize12) {
        this.flag_express_CscOutSize12 = flag_express_CscOutSize12;
    }

    public Long getFlag_express_CscOutSize13() {
        return flag_express_CscOutSize13;
    }

    public void setFlag_express_CscOutSize13(Long flag_express_CscOutSize13) {
        this.flag_express_CscOutSize13 = flag_express_CscOutSize13;
    }

    public Long getFlag_express_CscOutSize14() {
        return flag_express_CscOutSize14;
    }

    public void setFlag_express_CscOutSize14(Long flag_express_CscOutSize14) {
        this.flag_express_CscOutSize14 = flag_express_CscOutSize14;
    }

    public Long getFlag_express_CscOutSize15() {
        return flag_express_CscOutSize15;
    }

    public void setFlag_express_CscOutSize15(Long flag_express_CscOutSize15) {
        this.flag_express_CscOutSize15 = flag_express_CscOutSize15;
    }

    public Long getFlag_express_CscOutSize16() {
        return flag_express_CscOutSize16;
    }

    public void setFlag_express_CscOutSize16(Long flag_express_CscOutSize16) {
        this.flag_express_CscOutSize16 = flag_express_CscOutSize16;
    }

    public Long getFlag_express_CscOutSize17() {
        return flag_express_CscOutSize17;
    }

    public void setFlag_express_CscOutSize17(Long flag_express_CscOutSize17) {
        this.flag_express_CscOutSize17 = flag_express_CscOutSize17;
    }

    public Long getFlag_express_CscOutSize18() {
        return flag_express_CscOutSize18;
    }

    public void setFlag_express_CscOutSize18(Long flag_express_CscOutSize18) {
        this.flag_express_CscOutSize18 = flag_express_CscOutSize18;
    }

    public Long getFlag_express_CscOutSize1T() {
        return flag_express_CscOutSize1T;
    }

    public void setFlag_express_CscOutSize1T(Long flag_express_CscOutSize1T) {
        this.flag_express_CscOutSize1T = flag_express_CscOutSize1T;
    }

    public Long getFlag_express_CscOutSize2T() {
        return flag_express_CscOutSize2T;
    }

    public void setFlag_express_CscOutSize2T(Long flag_express_CscOutSize2T) {
        this.flag_express_CscOutSize2T = flag_express_CscOutSize2T;
    }

    public Long getFlag_express_CscOutSize3T() {
        return flag_express_CscOutSize3T;
    }

    public void setFlag_express_CscOutSize3T(Long flag_express_CscOutSize3T) {
        this.flag_express_CscOutSize3T = flag_express_CscOutSize3T;
    }

    public Long getFlag_express_CscOutSize4T() {
        return flag_express_CscOutSize4T;
    }

    public void setFlag_express_CscOutSize4T(Long flag_express_CscOutSize4T) {
        this.flag_express_CscOutSize4T = flag_express_CscOutSize4T;
    }

    public Long getFlag_express_CscOutSize5T() {
        return flag_express_CscOutSize5T;
    }

    public void setFlag_express_CscOutSize5T(Long flag_express_CscOutSize5T) {
        this.flag_express_CscOutSize5T = flag_express_CscOutSize5T;
    }

    public Long getFlag_express_CscOutSize6T() {
        return flag_express_CscOutSize6T;
    }

    public void setFlag_express_CscOutSize6T(Long flag_express_CscOutSize6T) {
        this.flag_express_CscOutSize6T = flag_express_CscOutSize6T;
    }

    public Long getFlag_express_CscOutSize7T() {
        return flag_express_CscOutSize7T;
    }

    public void setFlag_express_CscOutSize7T(Long flag_express_CscOutSize7T) {
        this.flag_express_CscOutSize7T = flag_express_CscOutSize7T;
    }

    public Long getFlag_express_CscOutSize8T() {
        return flag_express_CscOutSize8T;
    }

    public void setFlag_express_CscOutSize8T(Long flag_express_CscOutSize8T) {
        this.flag_express_CscOutSize8T = flag_express_CscOutSize8T;
    }

    public Long getFlag_express_CscOutSize9T() {
        return flag_express_CscOutSize9T;
    }

    public void setFlag_express_CscOutSize9T(Long flag_express_CscOutSize9T) {
        this.flag_express_CscOutSize9T = flag_express_CscOutSize9T;
    }

    public Long getFlag_express_CscOutSize10T() {
        return flag_express_CscOutSize10T;
    }

    public void setFlag_express_CscOutSize10T(Long flag_express_CscOutSize10T) {
        this.flag_express_CscOutSize10T = flag_express_CscOutSize10T;
    }

    public Long getFlag_express_CscOutSize11T() {
        return flag_express_CscOutSize11T;
    }

    public void setFlag_express_CscOutSize11T(Long flag_express_CscOutSize11T) {
        this.flag_express_CscOutSize11T = flag_express_CscOutSize11T;
    }

    public Long getFlag_express_CscOutSize12T() {
        return flag_express_CscOutSize12T;
    }

    public void setFlag_express_CscOutSize12T(Long flag_express_CscOutSize12T) {
        this.flag_express_CscOutSize12T = flag_express_CscOutSize12T;
    }

    public Long getFlag_express_CscOutSize13T() {
        return flag_express_CscOutSize13T;
    }

    public void setFlag_express_CscOutSize13T(Long flag_express_CscOutSize13T) {
        this.flag_express_CscOutSize13T = flag_express_CscOutSize13T;
    }

    public Long getFlag_express_NsInSize1() {
        return flag_express_NsInSize1;
    }

    public void setFlag_express_NsInSize1(Long flag_express_NsInSize1) {
        this.flag_express_NsInSize1 = flag_express_NsInSize1;
    }

    public Long getFlag_express_NsInSize2() {
        return flag_express_NsInSize2;
    }

    public void setFlag_express_NsInSize2(Long flag_express_NsInSize2) {
        this.flag_express_NsInSize2 = flag_express_NsInSize2;
    }

    public Long getFlag_express_NsInSize3() {
        return flag_express_NsInSize3;
    }

    public void setFlag_express_NsInSize3(Long flag_express_NsInSize3) {
        this.flag_express_NsInSize3 = flag_express_NsInSize3;
    }

    public Long getFlag_express_NsInSize4() {
        return flag_express_NsInSize4;
    }

    public void setFlag_express_NsInSize4(Long flag_express_NsInSize4) {
        this.flag_express_NsInSize4 = flag_express_NsInSize4;
    }

    public Long getFlag_express_NsInSize5() {
        return flag_express_NsInSize5;
    }

    public void setFlag_express_NsInSize5(Long flag_express_NsInSize5) {
        this.flag_express_NsInSize5 = flag_express_NsInSize5;
    }

    public Long getFlag_express_NsInSize6() {
        return flag_express_NsInSize6;
    }

    public void setFlag_express_NsInSize6(Long flag_express_NsInSize6) {
        this.flag_express_NsInSize6 = flag_express_NsInSize6;
    }

    public Long getFlag_express_NsInSize7() {
        return flag_express_NsInSize7;
    }

    public void setFlag_express_NsInSize7(Long flag_express_NsInSize7) {
        this.flag_express_NsInSize7 = flag_express_NsInSize7;
    }

    public Long getFlag_express_NsInSize8() {
        return flag_express_NsInSize8;
    }

    public void setFlag_express_NsInSize8(Long flag_express_NsInSize8) {
        this.flag_express_NsInSize8 = flag_express_NsInSize8;
    }

    public Long getFlag_express_NsInSize9() {
        return flag_express_NsInSize9;
    }

    public void setFlag_express_NsInSize9(Long flag_express_NsInSize9) {
        this.flag_express_NsInSize9 = flag_express_NsInSize9;
    }

    public Long getFlag_express_NsInSize10() {
        return flag_express_NsInSize10;
    }

    public void setFlag_express_NsInSize10(Long flag_express_NsInSize10) {
        this.flag_express_NsInSize10 = flag_express_NsInSize10;
    }

    public Long getFlag_express_NsInSize11() {
        return flag_express_NsInSize11;
    }

    public void setFlag_express_NsInSize11(Long flag_express_NsInSize11) {
        this.flag_express_NsInSize11 = flag_express_NsInSize11;
    }

    public Long getFlag_express_NsInSize12() {
        return flag_express_NsInSize12;
    }

    public void setFlag_express_NsInSize12(Long flag_express_NsInSize12) {
        this.flag_express_NsInSize12 = flag_express_NsInSize12;
    }

    public Long getFlag_express_NsInSize13() {
        return flag_express_NsInSize13;
    }

    public void setFlag_express_NsInSize13(Long flag_express_NsInSize13) {
        this.flag_express_NsInSize13 = flag_express_NsInSize13;
    }

    public Long getFlag_express_NsInSize14() {
        return flag_express_NsInSize14;
    }

    public void setFlag_express_NsInSize14(Long flag_express_NsInSize14) {
        this.flag_express_NsInSize14 = flag_express_NsInSize14;
    }

    public Long getFlag_express_NsInSize15() {
        return flag_express_NsInSize15;
    }

    public void setFlag_express_NsInSize15(Long flag_express_NsInSize15) {
        this.flag_express_NsInSize15 = flag_express_NsInSize15;
    }

    public Long getFlag_express_NsInSize16() {
        return flag_express_NsInSize16;
    }

    public void setFlag_express_NsInSize16(Long flag_express_NsInSize16) {
        this.flag_express_NsInSize16 = flag_express_NsInSize16;
    }

    public Long getFlag_express_NsInSize17() {
        return flag_express_NsInSize17;
    }

    public void setFlag_express_NsInSize17(Long flag_express_NsInSize17) {
        this.flag_express_NsInSize17 = flag_express_NsInSize17;
    }

    public Long getFlag_express_NsInSize18() {
        return flag_express_NsInSize18;
    }

    public void setFlag_express_NsInSize18(Long flag_express_NsInSize18) {
        this.flag_express_NsInSize18 = flag_express_NsInSize18;
    }

    public Long getFlag_express_NsInSize1T() {
        return flag_express_NsInSize1T;
    }

    public void setFlag_express_NsInSize1T(Long flag_express_NsInSize1T) {
        this.flag_express_NsInSize1T = flag_express_NsInSize1T;
    }

    public Long getFlag_express_NsInSize2T() {
        return flag_express_NsInSize2T;
    }

    public void setFlag_express_NsInSize2T(Long flag_express_NsInSize2T) {
        this.flag_express_NsInSize2T = flag_express_NsInSize2T;
    }

    public Long getFlag_express_NsInSize3T() {
        return flag_express_NsInSize3T;
    }

    public void setFlag_express_NsInSize3T(Long flag_express_NsInSize3T) {
        this.flag_express_NsInSize3T = flag_express_NsInSize3T;
    }

    public Long getFlag_express_NsInSize4T() {
        return flag_express_NsInSize4T;
    }

    public void setFlag_express_NsInSize4T(Long flag_express_NsInSize4T) {
        this.flag_express_NsInSize4T = flag_express_NsInSize4T;
    }

    public Long getFlag_express_NsInSize5T() {
        return flag_express_NsInSize5T;
    }

    public void setFlag_express_NsInSize5T(Long flag_express_NsInSize5T) {
        this.flag_express_NsInSize5T = flag_express_NsInSize5T;
    }

    public Long getFlag_express_NsInSize6T() {
        return flag_express_NsInSize6T;
    }

    public void setFlag_express_NsInSize6T(Long flag_express_NsInSize6T) {
        this.flag_express_NsInSize6T = flag_express_NsInSize6T;
    }

    public Long getFlag_express_NsInSize7T() {
        return flag_express_NsInSize7T;
    }

    public void setFlag_express_NsInSize7T(Long flag_express_NsInSize7T) {
        this.flag_express_NsInSize7T = flag_express_NsInSize7T;
    }

    public Long getFlag_express_NsInSize8T() {
        return flag_express_NsInSize8T;
    }

    public void setFlag_express_NsInSize8T(Long flag_express_NsInSize8T) {
        this.flag_express_NsInSize8T = flag_express_NsInSize8T;
    }

    public Long getFlag_express_NsInSize9T() {
        return flag_express_NsInSize9T;
    }

    public void setFlag_express_NsInSize9T(Long flag_express_NsInSize9T) {
        this.flag_express_NsInSize9T = flag_express_NsInSize9T;
    }

    public Long getFlag_express_NsInSize10T() {
        return flag_express_NsInSize10T;
    }

    public void setFlag_express_NsInSize10T(Long flag_express_NsInSize10T) {
        this.flag_express_NsInSize10T = flag_express_NsInSize10T;
    }

    public Long getFlag_express_NsInSize11T() {
        return flag_express_NsInSize11T;
    }

    public void setFlag_express_NsInSize11T(Long flag_express_NsInSize11T) {
        this.flag_express_NsInSize11T = flag_express_NsInSize11T;
    }

    public Long getFlag_express_NsInSize12T() {
        return flag_express_NsInSize12T;
    }

    public void setFlag_express_NsInSize12T(Long flag_express_NsInSize12T) {
        this.flag_express_NsInSize12T = flag_express_NsInSize12T;
    }

    public Long getFlag_express_NsInSize13T() {
        return flag_express_NsInSize13T;
    }

    public void setFlag_express_NsInSize13T(Long flag_express_NsInSize13T) {
        this.flag_express_NsInSize13T = flag_express_NsInSize13T;
    }

    public Long getFlag_express_NsOutSize1() {
        return flag_express_NsOutSize1;
    }

    public void setFlag_express_NsOutSize1(Long flag_express_NsOutSize1) {
        this.flag_express_NsOutSize1 = flag_express_NsOutSize1;
    }

    public Long getFlag_express_NsOutSize2() {
        return flag_express_NsOutSize2;
    }

    public void setFlag_express_NsOutSize2(Long flag_express_NsOutSize2) {
        this.flag_express_NsOutSize2 = flag_express_NsOutSize2;
    }

    public Long getFlag_express_NsOutSize3() {
        return flag_express_NsOutSize3;
    }

    public void setFlag_express_NsOutSize3(Long flag_express_NsOutSize3) {
        this.flag_express_NsOutSize3 = flag_express_NsOutSize3;
    }

    public Long getFlag_express_NsOutSize4() {
        return flag_express_NsOutSize4;
    }

    public void setFlag_express_NsOutSize4(Long flag_express_NsOutSize4) {
        this.flag_express_NsOutSize4 = flag_express_NsOutSize4;
    }

    public Long getFlag_express_NsOutSize5() {
        return flag_express_NsOutSize5;
    }

    public void setFlag_express_NsOutSize5(Long flag_express_NsOutSize5) {
        this.flag_express_NsOutSize5 = flag_express_NsOutSize5;
    }

    public Long getFlag_express_NsOutSize6() {
        return flag_express_NsOutSize6;
    }

    public void setFlag_express_NsOutSize6(Long flag_express_NsOutSize6) {
        this.flag_express_NsOutSize6 = flag_express_NsOutSize6;
    }

    public Long getFlag_express_NsOutSize7() {
        return flag_express_NsOutSize7;
    }

    public void setFlag_express_NsOutSize7(Long flag_express_NsOutSize7) {
        this.flag_express_NsOutSize7 = flag_express_NsOutSize7;
    }

    public Long getFlag_express_NsOutSize8() {
        return flag_express_NsOutSize8;
    }

    public void setFlag_express_NsOutSize8(Long flag_express_NsOutSize8) {
        this.flag_express_NsOutSize8 = flag_express_NsOutSize8;
    }

    public Long getFlag_express_NsOutSize9() {
        return flag_express_NsOutSize9;
    }

    public void setFlag_express_NsOutSize9(Long flag_express_NsOutSize9) {
        this.flag_express_NsOutSize9 = flag_express_NsOutSize9;
    }

    public Long getFlag_express_NsOutSize10() {
        return flag_express_NsOutSize10;
    }

    public void setFlag_express_NsOutSize10(Long flag_express_NsOutSize10) {
        this.flag_express_NsOutSize10 = flag_express_NsOutSize10;
    }

    public Long getFlag_express_NsOutSize11() {
        return flag_express_NsOutSize11;
    }

    public void setFlag_express_NsOutSize11(Long flag_express_NsOutSize11) {
        this.flag_express_NsOutSize11 = flag_express_NsOutSize11;
    }

    public Long getFlag_express_NsOutSize12() {
        return flag_express_NsOutSize12;
    }

    public void setFlag_express_NsOutSize12(Long flag_express_NsOutSize12) {
        this.flag_express_NsOutSize12 = flag_express_NsOutSize12;
    }

    public Long getFlag_express_NsOutSize13() {
        return flag_express_NsOutSize13;
    }

    public void setFlag_express_NsOutSize13(Long flag_express_NsOutSize13) {
        this.flag_express_NsOutSize13 = flag_express_NsOutSize13;
    }

    public Long getFlag_express_NsOutSize14() {
        return flag_express_NsOutSize14;
    }

    public void setFlag_express_NsOutSize14(Long flag_express_NsOutSize14) {
        this.flag_express_NsOutSize14 = flag_express_NsOutSize14;
    }

    public Long getFlag_express_NsOutSize15() {
        return flag_express_NsOutSize15;
    }

    public void setFlag_express_NsOutSize15(Long flag_express_NsOutSize15) {
        this.flag_express_NsOutSize15 = flag_express_NsOutSize15;
    }

    public Long getFlag_express_NsOutSize16() {
        return flag_express_NsOutSize16;
    }

    public void setFlag_express_NsOutSize16(Long flag_express_NsOutSize16) {
        this.flag_express_NsOutSize16 = flag_express_NsOutSize16;
    }

    public Long getFlag_express_NsOutSize17() {
        return flag_express_NsOutSize17;
    }

    public void setFlag_express_NsOutSize17(Long flag_express_NsOutSize17) {
        this.flag_express_NsOutSize17 = flag_express_NsOutSize17;
    }

    public Long getFlag_express_NsOutSize18() {
        return flag_express_NsOutSize18;
    }

    public void setFlag_express_NsOutSize18(Long flag_express_NsOutSize18) {
        this.flag_express_NsOutSize18 = flag_express_NsOutSize18;
    }

    public Long getFlag_express_NsOutSize1T() {
        return flag_express_NsOutSize1T;
    }

    public void setFlag_express_NsOutSize1T(Long flag_express_NsOutSize1T) {
        this.flag_express_NsOutSize1T = flag_express_NsOutSize1T;
    }

    public Long getFlag_express_NsOutSize2T() {
        return flag_express_NsOutSize2T;
    }

    public void setFlag_express_NsOutSize2T(Long flag_express_NsOutSize2T) {
        this.flag_express_NsOutSize2T = flag_express_NsOutSize2T;
    }

    public Long getFlag_express_NsOutSize3T() {
        return flag_express_NsOutSize3T;
    }

    public void setFlag_express_NsOutSize3T(Long flag_express_NsOutSize3T) {
        this.flag_express_NsOutSize3T = flag_express_NsOutSize3T;
    }

    public Long getFlag_express_NsOutSize4T() {
        return flag_express_NsOutSize4T;
    }

    public void setFlag_express_NsOutSize4T(Long flag_express_NsOutSize4T) {
        this.flag_express_NsOutSize4T = flag_express_NsOutSize4T;
    }

    public Long getFlag_express_NsOutSize5T() {
        return flag_express_NsOutSize5T;
    }

    public void setFlag_express_NsOutSize5T(Long flag_express_NsOutSize5T) {
        this.flag_express_NsOutSize5T = flag_express_NsOutSize5T;
    }

    public Long getFlag_express_NsOutSize6T() {
        return flag_express_NsOutSize6T;
    }

    public void setFlag_express_NsOutSize6T(Long flag_express_NsOutSize6T) {
        this.flag_express_NsOutSize6T = flag_express_NsOutSize6T;
    }

    public Long getFlag_express_NsOutSize7T() {
        return flag_express_NsOutSize7T;
    }

    public void setFlag_express_NsOutSize7T(Long flag_express_NsOutSize7T) {
        this.flag_express_NsOutSize7T = flag_express_NsOutSize7T;
    }

    public Long getFlag_express_NsOutSize8T() {
        return flag_express_NsOutSize8T;
    }

    public void setFlag_express_NsOutSize8T(Long flag_express_NsOutSize8T) {
        this.flag_express_NsOutSize8T = flag_express_NsOutSize8T;
    }

    public Long getFlag_express_NsOutSize9T() {
        return flag_express_NsOutSize9T;
    }

    public void setFlag_express_NsOutSize9T(Long flag_express_NsOutSize9T) {
        this.flag_express_NsOutSize9T = flag_express_NsOutSize9T;
    }

    public Long getFlag_express_NsOutSize10T() {
        return flag_express_NsOutSize10T;
    }

    public void setFlag_express_NsOutSize10T(Long flag_express_NsOutSize10T) {
        this.flag_express_NsOutSize10T = flag_express_NsOutSize10T;
    }

    public Long getFlag_express_NsOutSize11T() {
        return flag_express_NsOutSize11T;
    }

    public void setFlag_express_NsOutSize11T(Long flag_express_NsOutSize11T) {
        this.flag_express_NsOutSize11T = flag_express_NsOutSize11T;
    }

    public Long getFlag_express_NsOutSize12T() {
        return flag_express_NsOutSize12T;
    }

    public void setFlag_express_NsOutSize12T(Long flag_express_NsOutSize12T) {
        this.flag_express_NsOutSize12T = flag_express_NsOutSize12T;
    }

    public Long getFlag_express_NsOutSize13T() {
        return flag_express_NsOutSize13T;
    }

    public void setFlag_express_NsOutSize13T(Long flag_express_NsOutSize13T) {
        this.flag_express_NsOutSize13T = flag_express_NsOutSize13T;
    }

    public Long getFlag_express_ScInSize1() {
        return flag_express_ScInSize1;
    }

    public void setFlag_express_ScInSize1(Long flag_express_ScInSize1) {
        this.flag_express_ScInSize1 = flag_express_ScInSize1;
    }

    public Long getFlag_express_ScInSize2() {
        return flag_express_ScInSize2;
    }

    public void setFlag_express_ScInSize2(Long flag_express_ScInSize2) {
        this.flag_express_ScInSize2 = flag_express_ScInSize2;
    }

    public Long getFlag_express_ScInSize3() {
        return flag_express_ScInSize3;
    }

    public void setFlag_express_ScInSize3(Long flag_express_ScInSize3) {
        this.flag_express_ScInSize3 = flag_express_ScInSize3;
    }

    public Long getFlag_express_ScInSize4() {
        return flag_express_ScInSize4;
    }

    public void setFlag_express_ScInSize4(Long flag_express_ScInSize4) {
        this.flag_express_ScInSize4 = flag_express_ScInSize4;
    }

    public Long getFlag_express_ScInSize5() {
        return flag_express_ScInSize5;
    }

    public void setFlag_express_ScInSize5(Long flag_express_ScInSize5) {
        this.flag_express_ScInSize5 = flag_express_ScInSize5;
    }

    public Long getFlag_express_ScInSize6() {
        return flag_express_ScInSize6;
    }

    public void setFlag_express_ScInSize6(Long flag_express_ScInSize6) {
        this.flag_express_ScInSize6 = flag_express_ScInSize6;
    }

    public Long getFlag_express_ScInSize7() {
        return flag_express_ScInSize7;
    }

    public void setFlag_express_ScInSize7(Long flag_express_ScInSize7) {
        this.flag_express_ScInSize7 = flag_express_ScInSize7;
    }

    public Long getFlag_express_ScInSize8() {
        return flag_express_ScInSize8;
    }

    public void setFlag_express_ScInSize8(Long flag_express_ScInSize8) {
        this.flag_express_ScInSize8 = flag_express_ScInSize8;
    }

    public Long getFlag_express_ScInSize9() {
        return flag_express_ScInSize9;
    }

    public void setFlag_express_ScInSize9(Long flag_express_ScInSize9) {
        this.flag_express_ScInSize9 = flag_express_ScInSize9;
    }

    public Long getFlag_express_ScInSize10() {
        return flag_express_ScInSize10;
    }

    public void setFlag_express_ScInSize10(Long flag_express_ScInSize10) {
        this.flag_express_ScInSize10 = flag_express_ScInSize10;
    }

    public Long getFlag_express_ScInSize11() {
        return flag_express_ScInSize11;
    }

    public void setFlag_express_ScInSize11(Long flag_express_ScInSize11) {
        this.flag_express_ScInSize11 = flag_express_ScInSize11;
    }

    public Long getFlag_express_ScInSize12() {
        return flag_express_ScInSize12;
    }

    public void setFlag_express_ScInSize12(Long flag_express_ScInSize12) {
        this.flag_express_ScInSize12 = flag_express_ScInSize12;
    }

    public Long getFlag_express_ScInSize13() {
        return flag_express_ScInSize13;
    }

    public void setFlag_express_ScInSize13(Long flag_express_ScInSize13) {
        this.flag_express_ScInSize13 = flag_express_ScInSize13;
    }

    public Long getFlag_express_ScInSize14() {
        return flag_express_ScInSize14;
    }

    public void setFlag_express_ScInSize14(Long flag_express_ScInSize14) {
        this.flag_express_ScInSize14 = flag_express_ScInSize14;
    }

    public Long getFlag_express_ScInSize15() {
        return flag_express_ScInSize15;
    }

    public void setFlag_express_ScInSize15(Long flag_express_ScInSize15) {
        this.flag_express_ScInSize15 = flag_express_ScInSize15;
    }

    public Long getFlag_express_ScInSize16() {
        return flag_express_ScInSize16;
    }

    public void setFlag_express_ScInSize16(Long flag_express_ScInSize16) {
        this.flag_express_ScInSize16 = flag_express_ScInSize16;
    }

    public Long getFlag_express_ScInSize17() {
        return flag_express_ScInSize17;
    }

    public void setFlag_express_ScInSize17(Long flag_express_ScInSize17) {
        this.flag_express_ScInSize17 = flag_express_ScInSize17;
    }

    public Long getFlag_express_ScInSize18() {
        return flag_express_ScInSize18;
    }

    public void setFlag_express_ScInSize18(Long flag_express_ScInSize18) {
        this.flag_express_ScInSize18 = flag_express_ScInSize18;
    }

    public Long getFlag_express_ScInSize1T() {
        return flag_express_ScInSize1T;
    }

    public void setFlag_express_ScInSize1T(Long flag_express_ScInSize1T) {
        this.flag_express_ScInSize1T = flag_express_ScInSize1T;
    }

    public Long getFlag_express_ScInSize2T() {
        return flag_express_ScInSize2T;
    }

    public void setFlag_express_ScInSize2T(Long flag_express_ScInSize2T) {
        this.flag_express_ScInSize2T = flag_express_ScInSize2T;
    }

    public Long getFlag_express_ScInSize3T() {
        return flag_express_ScInSize3T;
    }

    public void setFlag_express_ScInSize3T(Long flag_express_ScInSize3T) {
        this.flag_express_ScInSize3T = flag_express_ScInSize3T;
    }

    public Long getFlag_express_ScInSize4T() {
        return flag_express_ScInSize4T;
    }

    public void setFlag_express_ScInSize4T(Long flag_express_ScInSize4T) {
        this.flag_express_ScInSize4T = flag_express_ScInSize4T;
    }

    public Long getFlag_express_ScInSize5T() {
        return flag_express_ScInSize5T;
    }

    public void setFlag_express_ScInSize5T(Long flag_express_ScInSize5T) {
        this.flag_express_ScInSize5T = flag_express_ScInSize5T;
    }

    public Long getFlag_express_ScInSize6T() {
        return flag_express_ScInSize6T;
    }

    public void setFlag_express_ScInSize6T(Long flag_express_ScInSize6T) {
        this.flag_express_ScInSize6T = flag_express_ScInSize6T;
    }

    public Long getFlag_express_ScInSize7T() {
        return flag_express_ScInSize7T;
    }

    public void setFlag_express_ScInSize7T(Long flag_express_ScInSize7T) {
        this.flag_express_ScInSize7T = flag_express_ScInSize7T;
    }

    public Long getFlag_express_ScInSize8T() {
        return flag_express_ScInSize8T;
    }

    public void setFlag_express_ScInSize8T(Long flag_express_ScInSize8T) {
        this.flag_express_ScInSize8T = flag_express_ScInSize8T;
    }

    public Long getFlag_express_ScInSize9T() {
        return flag_express_ScInSize9T;
    }

    public void setFlag_express_ScInSize9T(Long flag_express_ScInSize9T) {
        this.flag_express_ScInSize9T = flag_express_ScInSize9T;
    }

    public Long getFlag_express_ScInSize10T() {
        return flag_express_ScInSize10T;
    }

    public void setFlag_express_ScInSize10T(Long flag_express_ScInSize10T) {
        this.flag_express_ScInSize10T = flag_express_ScInSize10T;
    }

    public Long getFlag_express_ScInSize11T() {
        return flag_express_ScInSize11T;
    }

    public void setFlag_express_ScInSize11T(Long flag_express_ScInSize11T) {
        this.flag_express_ScInSize11T = flag_express_ScInSize11T;
    }

    public Long getFlag_express_ScInSize12T() {
        return flag_express_ScInSize12T;
    }

    public void setFlag_express_ScInSize12T(Long flag_express_ScInSize12T) {
        this.flag_express_ScInSize12T = flag_express_ScInSize12T;
    }

    public Long getFlag_express_ScInSize13T() {
        return flag_express_ScInSize13T;
    }

    public void setFlag_express_ScInSize13T(Long flag_express_ScInSize13T) {
        this.flag_express_ScInSize13T = flag_express_ScInSize13T;
    }

    public Long getFlag_express_ScOutSize1() {
        return flag_express_ScOutSize1;
    }

    public void setFlag_express_ScOutSize1(Long flag_express_ScOutSize1) {
        this.flag_express_ScOutSize1 = flag_express_ScOutSize1;
    }

    public Long getFlag_express_ScOutSize2() {
        return flag_express_ScOutSize2;
    }

    public void setFlag_express_ScOutSize2(Long flag_express_ScOutSize2) {
        this.flag_express_ScOutSize2 = flag_express_ScOutSize2;
    }

    public Long getFlag_express_ScOutSize3() {
        return flag_express_ScOutSize3;
    }

    public void setFlag_express_ScOutSize3(Long flag_express_ScOutSize3) {
        this.flag_express_ScOutSize3 = flag_express_ScOutSize3;
    }

    public Long getFlag_express_ScOutSize4() {
        return flag_express_ScOutSize4;
    }

    public void setFlag_express_ScOutSize4(Long flag_express_ScOutSize4) {
        this.flag_express_ScOutSize4 = flag_express_ScOutSize4;
    }

    public Long getFlag_express_ScOutSize5() {
        return flag_express_ScOutSize5;
    }

    public void setFlag_express_ScOutSize5(Long flag_express_ScOutSize5) {
        this.flag_express_ScOutSize5 = flag_express_ScOutSize5;
    }

    public Long getFlag_express_ScOutSize6() {
        return flag_express_ScOutSize6;
    }

    public void setFlag_express_ScOutSize6(Long flag_express_ScOutSize6) {
        this.flag_express_ScOutSize6 = flag_express_ScOutSize6;
    }

    public Long getFlag_express_ScOutSize7() {
        return flag_express_ScOutSize7;
    }

    public void setFlag_express_ScOutSize7(Long flag_express_ScOutSize7) {
        this.flag_express_ScOutSize7 = flag_express_ScOutSize7;
    }

    public Long getFlag_express_ScOutSize8() {
        return flag_express_ScOutSize8;
    }

    public void setFlag_express_ScOutSize8(Long flag_express_ScOutSize8) {
        this.flag_express_ScOutSize8 = flag_express_ScOutSize8;
    }

    public Long getFlag_express_ScOutSize9() {
        return flag_express_ScOutSize9;
    }

    public void setFlag_express_ScOutSize9(Long flag_express_ScOutSize9) {
        this.flag_express_ScOutSize9 = flag_express_ScOutSize9;
    }

    public Long getFlag_express_ScOutSize10() {
        return flag_express_ScOutSize10;
    }

    public void setFlag_express_ScOutSize10(Long flag_express_ScOutSize10) {
        this.flag_express_ScOutSize10 = flag_express_ScOutSize10;
    }

    public Long getFlag_express_ScOutSize11() {
        return flag_express_ScOutSize11;
    }

    public void setFlag_express_ScOutSize11(Long flag_express_ScOutSize11) {
        this.flag_express_ScOutSize11 = flag_express_ScOutSize11;
    }

    public Long getFlag_express_ScOutSize12() {
        return flag_express_ScOutSize12;
    }

    public void setFlag_express_ScOutSize12(Long flag_express_ScOutSize12) {
        this.flag_express_ScOutSize12 = flag_express_ScOutSize12;
    }

    public Long getFlag_express_ScOutSize13() {
        return flag_express_ScOutSize13;
    }

    public void setFlag_express_ScOutSize13(Long flag_express_ScOutSize13) {
        this.flag_express_ScOutSize13 = flag_express_ScOutSize13;
    }

    public Long getFlag_express_ScOutSize14() {
        return flag_express_ScOutSize14;
    }

    public void setFlag_express_ScOutSize14(Long flag_express_ScOutSize14) {
        this.flag_express_ScOutSize14 = flag_express_ScOutSize14;
    }

    public Long getFlag_express_ScOutSize15() {
        return flag_express_ScOutSize15;
    }

    public void setFlag_express_ScOutSize15(Long flag_express_ScOutSize15) {
        this.flag_express_ScOutSize15 = flag_express_ScOutSize15;
    }

    public Long getFlag_express_ScOutSize16() {
        return flag_express_ScOutSize16;
    }

    public void setFlag_express_ScOutSize16(Long flag_express_ScOutSize16) {
        this.flag_express_ScOutSize16 = flag_express_ScOutSize16;
    }

    public Long getFlag_express_ScOutSize17() {
        return flag_express_ScOutSize17;
    }

    public void setFlag_express_ScOutSize17(Long flag_express_ScOutSize17) {
        this.flag_express_ScOutSize17 = flag_express_ScOutSize17;
    }

    public Long getFlag_express_ScOutSize18() {
        return flag_express_ScOutSize18;
    }

    public void setFlag_express_ScOutSize18(Long flag_express_ScOutSize18) {
        this.flag_express_ScOutSize18 = flag_express_ScOutSize18;
    }

    public Long getFlag_express_ScOutSize1T() {
        return flag_express_ScOutSize1T;
    }

    public void setFlag_express_ScOutSize1T(Long flag_express_ScOutSize1T) {
        this.flag_express_ScOutSize1T = flag_express_ScOutSize1T;
    }

    public Long getFlag_express_ScOutSize2T() {
        return flag_express_ScOutSize2T;
    }

    public void setFlag_express_ScOutSize2T(Long flag_express_ScOutSize2T) {
        this.flag_express_ScOutSize2T = flag_express_ScOutSize2T;
    }

    public Long getFlag_express_ScOutSize3T() {
        return flag_express_ScOutSize3T;
    }

    public void setFlag_express_ScOutSize3T(Long flag_express_ScOutSize3T) {
        this.flag_express_ScOutSize3T = flag_express_ScOutSize3T;
    }

    public Long getFlag_express_ScOutSize4T() {
        return flag_express_ScOutSize4T;
    }

    public void setFlag_express_ScOutSize4T(Long flag_express_ScOutSize4T) {
        this.flag_express_ScOutSize4T = flag_express_ScOutSize4T;
    }

    public Long getFlag_express_ScOutSize5T() {
        return flag_express_ScOutSize5T;
    }

    public void setFlag_express_ScOutSize5T(Long flag_express_ScOutSize5T) {
        this.flag_express_ScOutSize5T = flag_express_ScOutSize5T;
    }

    public Long getFlag_express_ScOutSize6T() {
        return flag_express_ScOutSize6T;
    }

    public void setFlag_express_ScOutSize6T(Long flag_express_ScOutSize6T) {
        this.flag_express_ScOutSize6T = flag_express_ScOutSize6T;
    }

    public Long getFlag_express_ScOutSize7T() {
        return flag_express_ScOutSize7T;
    }

    public void setFlag_express_ScOutSize7T(Long flag_express_ScOutSize7T) {
        this.flag_express_ScOutSize7T = flag_express_ScOutSize7T;
    }

    public Long getFlag_express_ScOutSize8T() {
        return flag_express_ScOutSize8T;
    }

    public void setFlag_express_ScOutSize8T(Long flag_express_ScOutSize8T) {
        this.flag_express_ScOutSize8T = flag_express_ScOutSize8T;
    }

    public Long getFlag_express_ScOutSize9T() {
        return flag_express_ScOutSize9T;
    }

    public void setFlag_express_ScOutSize9T(Long flag_express_ScOutSize9T) {
        this.flag_express_ScOutSize9T = flag_express_ScOutSize9T;
    }

    public Long getFlag_express_ScOutSize10T() {
        return flag_express_ScOutSize10T;
    }

    public void setFlag_express_ScOutSize10T(Long flag_express_ScOutSize10T) {
        this.flag_express_ScOutSize10T = flag_express_ScOutSize10T;
    }

    public Long getFlag_express_ScOutSize11T() {
        return flag_express_ScOutSize11T;
    }

    public void setFlag_express_ScOutSize11T(Long flag_express_ScOutSize11T) {
        this.flag_express_ScOutSize11T = flag_express_ScOutSize11T;
    }

    public Long getFlag_express_ScOutSize12T() {
        return flag_express_ScOutSize12T;
    }

    public void setFlag_express_ScOutSize12T(Long flag_express_ScOutSize12T) {
        this.flag_express_ScOutSize12T = flag_express_ScOutSize12T;
    }

    public Long getFlag_express_ScOutSize13T() {
        return flag_express_ScOutSize13T;
    }

    public void setFlag_express_ScOutSize13T(Long flag_express_ScOutSize13T) {
        this.flag_express_ScOutSize13T = flag_express_ScOutSize13T;
    }

    public Long getFlag_express_OsInSize1() {
        return flag_express_OsInSize1;
    }

    public void setFlag_express_OsInSize1(Long flag_express_OsInSize1) {
        this.flag_express_OsInSize1 = flag_express_OsInSize1;
    }

    public Long getFlag_express_OsInSize2() {
        return flag_express_OsInSize2;
    }

    public void setFlag_express_OsInSize2(Long flag_express_OsInSize2) {
        this.flag_express_OsInSize2 = flag_express_OsInSize2;
    }

    public Long getFlag_express_OsInSize3() {
        return flag_express_OsInSize3;
    }

    public void setFlag_express_OsInSize3(Long flag_express_OsInSize3) {
        this.flag_express_OsInSize3 = flag_express_OsInSize3;
    }

    public Long getFlag_express_OsInSize4() {
        return flag_express_OsInSize4;
    }

    public void setFlag_express_OsInSize4(Long flag_express_OsInSize4) {
        this.flag_express_OsInSize4 = flag_express_OsInSize4;
    }

    public Long getFlag_express_OsInSize5() {
        return flag_express_OsInSize5;
    }

    public void setFlag_express_OsInSize5(Long flag_express_OsInSize5) {
        this.flag_express_OsInSize5 = flag_express_OsInSize5;
    }

    public Long getFlag_express_OsInSize6() {
        return flag_express_OsInSize6;
    }

    public void setFlag_express_OsInSize6(Long flag_express_OsInSize6) {
        this.flag_express_OsInSize6 = flag_express_OsInSize6;
    }

    public Long getFlag_express_OsInSize7() {
        return flag_express_OsInSize7;
    }

    public void setFlag_express_OsInSize7(Long flag_express_OsInSize7) {
        this.flag_express_OsInSize7 = flag_express_OsInSize7;
    }

    public Long getFlag_express_OsInSize8() {
        return flag_express_OsInSize8;
    }

    public void setFlag_express_OsInSize8(Long flag_express_OsInSize8) {
        this.flag_express_OsInSize8 = flag_express_OsInSize8;
    }

    public Long getFlag_express_OsInSize9() {
        return flag_express_OsInSize9;
    }

    public void setFlag_express_OsInSize9(Long flag_express_OsInSize9) {
        this.flag_express_OsInSize9 = flag_express_OsInSize9;
    }

    public Long getFlag_express_OsInSize10() {
        return flag_express_OsInSize10;
    }

    public void setFlag_express_OsInSize10(Long flag_express_OsInSize10) {
        this.flag_express_OsInSize10 = flag_express_OsInSize10;
    }

    public Long getFlag_express_OsInSize11() {
        return flag_express_OsInSize11;
    }

    public void setFlag_express_OsInSize11(Long flag_express_OsInSize11) {
        this.flag_express_OsInSize11 = flag_express_OsInSize11;
    }

    public Long getFlag_express_OsInSize12() {
        return flag_express_OsInSize12;
    }

    public void setFlag_express_OsInSize12(Long flag_express_OsInSize12) {
        this.flag_express_OsInSize12 = flag_express_OsInSize12;
    }

    public Long getFlag_express_OsInSize13() {
        return flag_express_OsInSize13;
    }

    public void setFlag_express_OsInSize13(Long flag_express_OsInSize13) {
        this.flag_express_OsInSize13 = flag_express_OsInSize13;
    }

    public Long getFlag_express_OsInSize14() {
        return flag_express_OsInSize14;
    }

    public void setFlag_express_OsInSize14(Long flag_express_OsInSize14) {
        this.flag_express_OsInSize14 = flag_express_OsInSize14;
    }

    public Long getFlag_express_OsInSize15() {
        return flag_express_OsInSize15;
    }

    public void setFlag_express_OsInSize15(Long flag_express_OsInSize15) {
        this.flag_express_OsInSize15 = flag_express_OsInSize15;
    }

    public Long getFlag_express_OsInSize16() {
        return flag_express_OsInSize16;
    }

    public void setFlag_express_OsInSize16(Long flag_express_OsInSize16) {
        this.flag_express_OsInSize16 = flag_express_OsInSize16;
    }

    public Long getFlag_express_OsInSize17() {
        return flag_express_OsInSize17;
    }

    public void setFlag_express_OsInSize17(Long flag_express_OsInSize17) {
        this.flag_express_OsInSize17 = flag_express_OsInSize17;
    }

    public Long getFlag_express_OsInSize18() {
        return flag_express_OsInSize18;
    }

    public void setFlag_express_OsInSize18(Long flag_express_OsInSize18) {
        this.flag_express_OsInSize18 = flag_express_OsInSize18;
    }

    public Long getFlag_express_OsInSize1T() {
        return flag_express_OsInSize1T;
    }

    public void setFlag_express_OsInSize1T(Long flag_express_OsInSize1T) {
        this.flag_express_OsInSize1T = flag_express_OsInSize1T;
    }

    public Long getFlag_express_OsInSize2T() {
        return flag_express_OsInSize2T;
    }

    public void setFlag_express_OsInSize2T(Long flag_express_OsInSize2T) {
        this.flag_express_OsInSize2T = flag_express_OsInSize2T;
    }

    public Long getFlag_express_OsInSize3T() {
        return flag_express_OsInSize3T;
    }

    public void setFlag_express_OsInSize3T(Long flag_express_OsInSize3T) {
        this.flag_express_OsInSize3T = flag_express_OsInSize3T;
    }

    public Long getFlag_express_OsInSize4T() {
        return flag_express_OsInSize4T;
    }

    public void setFlag_express_OsInSize4T(Long flag_express_OsInSize4T) {
        this.flag_express_OsInSize4T = flag_express_OsInSize4T;
    }

    public Long getFlag_express_OsInSize5T() {
        return flag_express_OsInSize5T;
    }

    public void setFlag_express_OsInSize5T(Long flag_express_OsInSize5T) {
        this.flag_express_OsInSize5T = flag_express_OsInSize5T;
    }

    public Long getFlag_express_OsInSize6T() {
        return flag_express_OsInSize6T;
    }

    public void setFlag_express_OsInSize6T(Long flag_express_OsInSize6T) {
        this.flag_express_OsInSize6T = flag_express_OsInSize6T;
    }

    public Long getFlag_express_OsInSize7T() {
        return flag_express_OsInSize7T;
    }

    public void setFlag_express_OsInSize7T(Long flag_express_OsInSize7T) {
        this.flag_express_OsInSize7T = flag_express_OsInSize7T;
    }

    public Long getFlag_express_OsInSize8T() {
        return flag_express_OsInSize8T;
    }

    public void setFlag_express_OsInSize8T(Long flag_express_OsInSize8T) {
        this.flag_express_OsInSize8T = flag_express_OsInSize8T;
    }

    public Long getFlag_express_OsInSize9T() {
        return flag_express_OsInSize9T;
    }

    public void setFlag_express_OsInSize9T(Long flag_express_OsInSize9T) {
        this.flag_express_OsInSize9T = flag_express_OsInSize9T;
    }

    public Long getFlag_express_OsInSize10T() {
        return flag_express_OsInSize10T;
    }

    public void setFlag_express_OsInSize10T(Long flag_express_OsInSize10T) {
        this.flag_express_OsInSize10T = flag_express_OsInSize10T;
    }

    public Long getFlag_express_OsInSize11T() {
        return flag_express_OsInSize11T;
    }

    public void setFlag_express_OsInSize11T(Long flag_express_OsInSize11T) {
        this.flag_express_OsInSize11T = flag_express_OsInSize11T;
    }

    public Long getFlag_express_OsInSize12T() {
        return flag_express_OsInSize12T;
    }

    public void setFlag_express_OsInSize12T(Long flag_express_OsInSize12T) {
        this.flag_express_OsInSize12T = flag_express_OsInSize12T;
    }

    public Long getFlag_express_OsInSize13T() {
        return flag_express_OsInSize13T;
    }

    public void setFlag_express_OsInSize13T(Long flag_express_OsInSize13T) {
        this.flag_express_OsInSize13T = flag_express_OsInSize13T;
    }

    public Long getFlag_express_OsOutSize1() {
        return flag_express_OsOutSize1;
    }

    public void setFlag_express_OsOutSize1(Long flag_express_OsOutSize1) {
        this.flag_express_OsOutSize1 = flag_express_OsOutSize1;
    }

    public Long getFlag_express_OsOutSize2() {
        return flag_express_OsOutSize2;
    }

    public void setFlag_express_OsOutSize2(Long flag_express_OsOutSize2) {
        this.flag_express_OsOutSize2 = flag_express_OsOutSize2;
    }

    public Long getFlag_express_OsOutSize3() {
        return flag_express_OsOutSize3;
    }

    public void setFlag_express_OsOutSize3(Long flag_express_OsOutSize3) {
        this.flag_express_OsOutSize3 = flag_express_OsOutSize3;
    }

    public Long getFlag_express_OsOutSize4() {
        return flag_express_OsOutSize4;
    }

    public void setFlag_express_OsOutSize4(Long flag_express_OsOutSize4) {
        this.flag_express_OsOutSize4 = flag_express_OsOutSize4;
    }

    public Long getFlag_express_OsOutSize5() {
        return flag_express_OsOutSize5;
    }

    public void setFlag_express_OsOutSize5(Long flag_express_OsOutSize5) {
        this.flag_express_OsOutSize5 = flag_express_OsOutSize5;
    }

    public Long getFlag_express_OsOutSize6() {
        return flag_express_OsOutSize6;
    }

    public void setFlag_express_OsOutSize6(Long flag_express_OsOutSize6) {
        this.flag_express_OsOutSize6 = flag_express_OsOutSize6;
    }

    public Long getFlag_express_OsOutSize7() {
        return flag_express_OsOutSize7;
    }

    public void setFlag_express_OsOutSize7(Long flag_express_OsOutSize7) {
        this.flag_express_OsOutSize7 = flag_express_OsOutSize7;
    }

    public Long getFlag_express_OsOutSize8() {
        return flag_express_OsOutSize8;
    }

    public void setFlag_express_OsOutSize8(Long flag_express_OsOutSize8) {
        this.flag_express_OsOutSize8 = flag_express_OsOutSize8;
    }

    public Long getFlag_express_OsOutSize9() {
        return flag_express_OsOutSize9;
    }

    public void setFlag_express_OsOutSize9(Long flag_express_OsOutSize9) {
        this.flag_express_OsOutSize9 = flag_express_OsOutSize9;
    }

    public Long getFlag_express_OsOutSize10() {
        return flag_express_OsOutSize10;
    }

    public void setFlag_express_OsOutSize10(Long flag_express_OsOutSize10) {
        this.flag_express_OsOutSize10 = flag_express_OsOutSize10;
    }

    public Long getFlag_express_OsOutSize11() {
        return flag_express_OsOutSize11;
    }

    public void setFlag_express_OsOutSize11(Long flag_express_OsOutSize11) {
        this.flag_express_OsOutSize11 = flag_express_OsOutSize11;
    }

    public Long getFlag_express_OsOutSize12() {
        return flag_express_OsOutSize12;
    }

    public void setFlag_express_OsOutSize12(Long flag_express_OsOutSize12) {
        this.flag_express_OsOutSize12 = flag_express_OsOutSize12;
    }

    public Long getFlag_express_OsOutSize13() {
        return flag_express_OsOutSize13;
    }

    public void setFlag_express_OsOutSize13(Long flag_express_OsOutSize13) {
        this.flag_express_OsOutSize13 = flag_express_OsOutSize13;
    }

    public Long getFlag_express_OsOutSize14() {
        return flag_express_OsOutSize14;
    }

    public void setFlag_express_OsOutSize14(Long flag_express_OsOutSize14) {
        this.flag_express_OsOutSize14 = flag_express_OsOutSize14;
    }

    public Long getFlag_express_OsOutSize15() {
        return flag_express_OsOutSize15;
    }

    public void setFlag_express_OsOutSize15(Long flag_express_OsOutSize15) {
        this.flag_express_OsOutSize15 = flag_express_OsOutSize15;
    }

    public Long getFlag_express_OsOutSize16() {
        return flag_express_OsOutSize16;
    }

    public void setFlag_express_OsOutSize16(Long flag_express_OsOutSize16) {
        this.flag_express_OsOutSize16 = flag_express_OsOutSize16;
    }

    public Long getFlag_express_OsOutSize17() {
        return flag_express_OsOutSize17;
    }

    public void setFlag_express_OsOutSize17(Long flag_express_OsOutSize17) {
        this.flag_express_OsOutSize17 = flag_express_OsOutSize17;
    }

    public Long getFlag_express_OsOutSize18() {
        return flag_express_OsOutSize18;
    }

    public void setFlag_express_OsOutSize18(Long flag_express_OsOutSize18) {
        this.flag_express_OsOutSize18 = flag_express_OsOutSize18;
    }

    public Long getFlag_express_OsOutSize1T() {
        return flag_express_OsOutSize1T;
    }

    public void setFlag_express_OsOutSize1T(Long flag_express_OsOutSize1T) {
        this.flag_express_OsOutSize1T = flag_express_OsOutSize1T;
    }

    public Long getFlag_express_OsOutSize2T() {
        return flag_express_OsOutSize2T;
    }

    public void setFlag_express_OsOutSize2T(Long flag_express_OsOutSize2T) {
        this.flag_express_OsOutSize2T = flag_express_OsOutSize2T;
    }

    public Long getFlag_express_OsOutSize3T() {
        return flag_express_OsOutSize3T;
    }

    public void setFlag_express_OsOutSize3T(Long flag_express_OsOutSize3T) {
        this.flag_express_OsOutSize3T = flag_express_OsOutSize3T;
    }

    public Long getFlag_express_OsOutSize4T() {
        return flag_express_OsOutSize4T;
    }

    public void setFlag_express_OsOutSize4T(Long flag_express_OsOutSize4T) {
        this.flag_express_OsOutSize4T = flag_express_OsOutSize4T;
    }

    public Long getFlag_express_OsOutSize5T() {
        return flag_express_OsOutSize5T;
    }

    public void setFlag_express_OsOutSize5T(Long flag_express_OsOutSize5T) {
        this.flag_express_OsOutSize5T = flag_express_OsOutSize5T;
    }

    public Long getFlag_express_OsOutSize6T() {
        return flag_express_OsOutSize6T;
    }

    public void setFlag_express_OsOutSize6T(Long flag_express_OsOutSize6T) {
        this.flag_express_OsOutSize6T = flag_express_OsOutSize6T;
    }

    public Long getFlag_express_OsOutSize7T() {
        return flag_express_OsOutSize7T;
    }

    public void setFlag_express_OsOutSize7T(Long flag_express_OsOutSize7T) {
        this.flag_express_OsOutSize7T = flag_express_OsOutSize7T;
    }

    public Long getFlag_express_OsOutSize8T() {
        return flag_express_OsOutSize8T;
    }

    public void setFlag_express_OsOutSize8T(Long flag_express_OsOutSize8T) {
        this.flag_express_OsOutSize8T = flag_express_OsOutSize8T;
    }

    public Long getFlag_express_OsOutSize9T() {
        return flag_express_OsOutSize9T;
    }

    public void setFlag_express_OsOutSize9T(Long flag_express_OsOutSize9T) {
        this.flag_express_OsOutSize9T = flag_express_OsOutSize9T;
    }

    public Long getFlag_express_OsOutSize10T() {
        return flag_express_OsOutSize10T;
    }

    public void setFlag_express_OsOutSize10T(Long flag_express_OsOutSize10T) {
        this.flag_express_OsOutSize10T = flag_express_OsOutSize10T;
    }

    public Long getFlag_express_OsOutSize11T() {
        return flag_express_OsOutSize11T;
    }

    public void setFlag_express_OsOutSize11T(Long flag_express_OsOutSize11T) {
        this.flag_express_OsOutSize11T = flag_express_OsOutSize11T;
    }

    public Long getFlag_express_OsOutSize12T() {
        return flag_express_OsOutSize12T;
    }

    public void setFlag_express_OsOutSize12T(Long flag_express_OsOutSize12T) {
        this.flag_express_OsOutSize12T = flag_express_OsOutSize12T;
    }

    public Long getFlag_express_OsOutSize13T() {
        return flag_express_OsOutSize13T;
    }

    public void setFlag_express_OsOutSize13T(Long flag_express_OsOutSize13T) {
        this.flag_express_OsOutSize13T = flag_express_OsOutSize13T;
    }

    public Long getFlag_express_SpcutInSize1() {
        return flag_express_SpcutInSize1;
    }

    public void setFlag_express_SpcutInSize1(Long flag_express_SpcutInSize1) {
        this.flag_express_SpcutInSize1 = flag_express_SpcutInSize1;
    }

    public Long getFlag_express_SpcutInSize2() {
        return flag_express_SpcutInSize2;
    }

    public void setFlag_express_SpcutInSize2(Long flag_express_SpcutInSize2) {
        this.flag_express_SpcutInSize2 = flag_express_SpcutInSize2;
    }

    public Long getFlag_express_SpcutInSize3() {
        return flag_express_SpcutInSize3;
    }

    public void setFlag_express_SpcutInSize3(Long flag_express_SpcutInSize3) {
        this.flag_express_SpcutInSize3 = flag_express_SpcutInSize3;
    }

    public Long getFlag_express_SpcutInSize4() {
        return flag_express_SpcutInSize4;
    }

    public void setFlag_express_SpcutInSize4(Long flag_express_SpcutInSize4) {
        this.flag_express_SpcutInSize4 = flag_express_SpcutInSize4;
    }

    public Long getFlag_express_SpcutInSize5() {
        return flag_express_SpcutInSize5;
    }

    public void setFlag_express_SpcutInSize5(Long flag_express_SpcutInSize5) {
        this.flag_express_SpcutInSize5 = flag_express_SpcutInSize5;
    }

    public Long getFlag_express_SpcutInSize6() {
        return flag_express_SpcutInSize6;
    }

    public void setFlag_express_SpcutInSize6(Long flag_express_SpcutInSize6) {
        this.flag_express_SpcutInSize6 = flag_express_SpcutInSize6;
    }

    public Long getFlag_express_SpcutInSize7() {
        return flag_express_SpcutInSize7;
    }

    public void setFlag_express_SpcutInSize7(Long flag_express_SpcutInSize7) {
        this.flag_express_SpcutInSize7 = flag_express_SpcutInSize7;
    }

    public Long getFlag_express_SpcutInSize8() {
        return flag_express_SpcutInSize8;
    }

    public void setFlag_express_SpcutInSize8(Long flag_express_SpcutInSize8) {
        this.flag_express_SpcutInSize8 = flag_express_SpcutInSize8;
    }

    public Long getFlag_express_SpcutInSize9() {
        return flag_express_SpcutInSize9;
    }

    public void setFlag_express_SpcutInSize9(Long flag_express_SpcutInSize9) {
        this.flag_express_SpcutInSize9 = flag_express_SpcutInSize9;
    }

    public Long getFlag_express_SpcutInSize10() {
        return flag_express_SpcutInSize10;
    }

    public void setFlag_express_SpcutInSize10(Long flag_express_SpcutInSize10) {
        this.flag_express_SpcutInSize10 = flag_express_SpcutInSize10;
    }

    public Long getFlag_express_SpcutInSize11() {
        return flag_express_SpcutInSize11;
    }

    public void setFlag_express_SpcutInSize11(Long flag_express_SpcutInSize11) {
        this.flag_express_SpcutInSize11 = flag_express_SpcutInSize11;
    }

    public Long getFlag_express_SpcutInSize12() {
        return flag_express_SpcutInSize12;
    }

    public void setFlag_express_SpcutInSize12(Long flag_express_SpcutInSize12) {
        this.flag_express_SpcutInSize12 = flag_express_SpcutInSize12;
    }

    public Long getFlag_express_SpcutInSize13() {
        return flag_express_SpcutInSize13;
    }

    public void setFlag_express_SpcutInSize13(Long flag_express_SpcutInSize13) {
        this.flag_express_SpcutInSize13 = flag_express_SpcutInSize13;
    }

    public Long getFlag_express_SpcutInSize14() {
        return flag_express_SpcutInSize14;
    }

    public void setFlag_express_SpcutInSize14(Long flag_express_SpcutInSize14) {
        this.flag_express_SpcutInSize14 = flag_express_SpcutInSize14;
    }

    public Long getFlag_express_SpcutInSize15() {
        return flag_express_SpcutInSize15;
    }

    public void setFlag_express_SpcutInSize15(Long flag_express_SpcutInSize15) {
        this.flag_express_SpcutInSize15 = flag_express_SpcutInSize15;
    }

    public Long getFlag_express_SpcutInSize16() {
        return flag_express_SpcutInSize16;
    }

    public void setFlag_express_SpcutInSize16(Long flag_express_SpcutInSize16) {
        this.flag_express_SpcutInSize16 = flag_express_SpcutInSize16;
    }

    public Long getFlag_express_SpcutInSize17() {
        return flag_express_SpcutInSize17;
    }

    public void setFlag_express_SpcutInSize17(Long flag_express_SpcutInSize17) {
        this.flag_express_SpcutInSize17 = flag_express_SpcutInSize17;
    }

    public Long getFlag_express_SpcutInSize18() {
        return flag_express_SpcutInSize18;
    }

    public void setFlag_express_SpcutInSize18(Long flag_express_SpcutInSize18) {
        this.flag_express_SpcutInSize18 = flag_express_SpcutInSize18;
    }

    public Long getFlag_express_SpcutInSize1T() {
        return flag_express_SpcutInSize1T;
    }

    public void setFlag_express_SpcutInSize1T(Long flag_express_SpcutInSize1T) {
        this.flag_express_SpcutInSize1T = flag_express_SpcutInSize1T;
    }

    public Long getFlag_express_SpcutInSize2T() {
        return flag_express_SpcutInSize2T;
    }

    public void setFlag_express_SpcutInSize2T(Long flag_express_SpcutInSize2T) {
        this.flag_express_SpcutInSize2T = flag_express_SpcutInSize2T;
    }

    public Long getFlag_express_SpcutInSize3T() {
        return flag_express_SpcutInSize3T;
    }

    public void setFlag_express_SpcutInSize3T(Long flag_express_SpcutInSize3T) {
        this.flag_express_SpcutInSize3T = flag_express_SpcutInSize3T;
    }

    public Long getFlag_express_SpcutInSize4T() {
        return flag_express_SpcutInSize4T;
    }

    public void setFlag_express_SpcutInSize4T(Long flag_express_SpcutInSize4T) {
        this.flag_express_SpcutInSize4T = flag_express_SpcutInSize4T;
    }

    public Long getFlag_express_SpcutInSize5T() {
        return flag_express_SpcutInSize5T;
    }

    public void setFlag_express_SpcutInSize5T(Long flag_express_SpcutInSize5T) {
        this.flag_express_SpcutInSize5T = flag_express_SpcutInSize5T;
    }

    public Long getFlag_express_SpcutInSize6T() {
        return flag_express_SpcutInSize6T;
    }

    public void setFlag_express_SpcutInSize6T(Long flag_express_SpcutInSize6T) {
        this.flag_express_SpcutInSize6T = flag_express_SpcutInSize6T;
    }

    public Long getFlag_express_SpcutInSize7T() {
        return flag_express_SpcutInSize7T;
    }

    public void setFlag_express_SpcutInSize7T(Long flag_express_SpcutInSize7T) {
        this.flag_express_SpcutInSize7T = flag_express_SpcutInSize7T;
    }

    public Long getFlag_express_SpcutInSize8T() {
        return flag_express_SpcutInSize8T;
    }

    public void setFlag_express_SpcutInSize8T(Long flag_express_SpcutInSize8T) {
        this.flag_express_SpcutInSize8T = flag_express_SpcutInSize8T;
    }

    public Long getFlag_express_SpcutInSize9T() {
        return flag_express_SpcutInSize9T;
    }

    public void setFlag_express_SpcutInSize9T(Long flag_express_SpcutInSize9T) {
        this.flag_express_SpcutInSize9T = flag_express_SpcutInSize9T;
    }

    public Long getFlag_express_SpcutInSize10T() {
        return flag_express_SpcutInSize10T;
    }

    public void setFlag_express_SpcutInSize10T(Long flag_express_SpcutInSize10T) {
        this.flag_express_SpcutInSize10T = flag_express_SpcutInSize10T;
    }

    public Long getFlag_express_SpcutInSize11T() {
        return flag_express_SpcutInSize11T;
    }

    public void setFlag_express_SpcutInSize11T(Long flag_express_SpcutInSize11T) {
        this.flag_express_SpcutInSize11T = flag_express_SpcutInSize11T;
    }

    public Long getFlag_express_SpcutInSize12T() {
        return flag_express_SpcutInSize12T;
    }

    public void setFlag_express_SpcutInSize12T(Long flag_express_SpcutInSize12T) {
        this.flag_express_SpcutInSize12T = flag_express_SpcutInSize12T;
    }

    public Long getFlag_express_SpcutInSize13T() {
        return flag_express_SpcutInSize13T;
    }

    public void setFlag_express_SpcutInSize13T(Long flag_express_SpcutInSize13T) {
        this.flag_express_SpcutInSize13T = flag_express_SpcutInSize13T;
    }

    public Long getFlag_express_SpcutOutSize1() {
        return flag_express_SpcutOutSize1;
    }

    public void setFlag_express_SpcutOutSize1(Long flag_express_SpcutOutSize1) {
        this.flag_express_SpcutOutSize1 = flag_express_SpcutOutSize1;
    }

    public Long getFlag_express_SpcutOutSize2() {
        return flag_express_SpcutOutSize2;
    }

    public void setFlag_express_SpcutOutSize2(Long flag_express_SpcutOutSize2) {
        this.flag_express_SpcutOutSize2 = flag_express_SpcutOutSize2;
    }

    public Long getFlag_express_SpcutOutSize3() {
        return flag_express_SpcutOutSize3;
    }

    public void setFlag_express_SpcutOutSize3(Long flag_express_SpcutOutSize3) {
        this.flag_express_SpcutOutSize3 = flag_express_SpcutOutSize3;
    }

    public Long getFlag_express_SpcutOutSize4() {
        return flag_express_SpcutOutSize4;
    }

    public void setFlag_express_SpcutOutSize4(Long flag_express_SpcutOutSize4) {
        this.flag_express_SpcutOutSize4 = flag_express_SpcutOutSize4;
    }

    public Long getFlag_express_SpcutOutSize5() {
        return flag_express_SpcutOutSize5;
    }

    public void setFlag_express_SpcutOutSize5(Long flag_express_SpcutOutSize5) {
        this.flag_express_SpcutOutSize5 = flag_express_SpcutOutSize5;
    }

    public Long getFlag_express_SpcutOutSize6() {
        return flag_express_SpcutOutSize6;
    }

    public void setFlag_express_SpcutOutSize6(Long flag_express_SpcutOutSize6) {
        this.flag_express_SpcutOutSize6 = flag_express_SpcutOutSize6;
    }

    public Long getFlag_express_SpcutOutSize7() {
        return flag_express_SpcutOutSize7;
    }

    public void setFlag_express_SpcutOutSize7(Long flag_express_SpcutOutSize7) {
        this.flag_express_SpcutOutSize7 = flag_express_SpcutOutSize7;
    }

    public Long getFlag_express_SpcutOutSize8() {
        return flag_express_SpcutOutSize8;
    }

    public void setFlag_express_SpcutOutSize8(Long flag_express_SpcutOutSize8) {
        this.flag_express_SpcutOutSize8 = flag_express_SpcutOutSize8;
    }

    public Long getFlag_express_SpcutOutSize9() {
        return flag_express_SpcutOutSize9;
    }

    public void setFlag_express_SpcutOutSize9(Long flag_express_SpcutOutSize9) {
        this.flag_express_SpcutOutSize9 = flag_express_SpcutOutSize9;
    }

    public Long getFlag_express_SpcutOutSize10() {
        return flag_express_SpcutOutSize10;
    }

    public void setFlag_express_SpcutOutSize10(Long flag_express_SpcutOutSize10) {
        this.flag_express_SpcutOutSize10 = flag_express_SpcutOutSize10;
    }

    public Long getFlag_express_SpcutOutSize11() {
        return flag_express_SpcutOutSize11;
    }

    public void setFlag_express_SpcutOutSize11(Long flag_express_SpcutOutSize11) {
        this.flag_express_SpcutOutSize11 = flag_express_SpcutOutSize11;
    }

    public Long getFlag_express_SpcutOutSize12() {
        return flag_express_SpcutOutSize12;
    }

    public void setFlag_express_SpcutOutSize12(Long flag_express_SpcutOutSize12) {
        this.flag_express_SpcutOutSize12 = flag_express_SpcutOutSize12;
    }

    public Long getFlag_express_SpcutOutSize13() {
        return flag_express_SpcutOutSize13;
    }

    public void setFlag_express_SpcutOutSize13(Long flag_express_SpcutOutSize13) {
        this.flag_express_SpcutOutSize13 = flag_express_SpcutOutSize13;
    }

    public Long getFlag_express_SpcutOutSize14() {
        return flag_express_SpcutOutSize14;
    }

    public void setFlag_express_SpcutOutSize14(Long flag_express_SpcutOutSize14) {
        this.flag_express_SpcutOutSize14 = flag_express_SpcutOutSize14;
    }

    public Long getFlag_express_SpcutOutSize15() {
        return flag_express_SpcutOutSize15;
    }

    public void setFlag_express_SpcutOutSize15(Long flag_express_SpcutOutSize15) {
        this.flag_express_SpcutOutSize15 = flag_express_SpcutOutSize15;
    }

    public Long getFlag_express_SpcutOutSize16() {
        return flag_express_SpcutOutSize16;
    }

    public void setFlag_express_SpcutOutSize16(Long flag_express_SpcutOutSize16) {
        this.flag_express_SpcutOutSize16 = flag_express_SpcutOutSize16;
    }

    public Long getFlag_express_SpcutOutSize17() {
        return flag_express_SpcutOutSize17;
    }

    public void setFlag_express_SpcutOutSize17(Long flag_express_SpcutOutSize17) {
        this.flag_express_SpcutOutSize17 = flag_express_SpcutOutSize17;
    }

    public Long getFlag_express_SpcutOutSize18() {
        return flag_express_SpcutOutSize18;
    }

    public void setFlag_express_SpcutOutSize18(Long flag_express_SpcutOutSize18) {
        this.flag_express_SpcutOutSize18 = flag_express_SpcutOutSize18;
    }

    public Long getFlag_express_SpcutOutSize1T() {
        return flag_express_SpcutOutSize1T;
    }

    public void setFlag_express_SpcutOutSize1T(Long flag_express_SpcutOutSize1T) {
        this.flag_express_SpcutOutSize1T = flag_express_SpcutOutSize1T;
    }

    public Long getFlag_express_SpcutOutSize2T() {
        return flag_express_SpcutOutSize2T;
    }

    public void setFlag_express_SpcutOutSize2T(Long flag_express_SpcutOutSize2T) {
        this.flag_express_SpcutOutSize2T = flag_express_SpcutOutSize2T;
    }

    public Long getFlag_express_SpcutOutSize3T() {
        return flag_express_SpcutOutSize3T;
    }

    public void setFlag_express_SpcutOutSize3T(Long flag_express_SpcutOutSize3T) {
        this.flag_express_SpcutOutSize3T = flag_express_SpcutOutSize3T;
    }

    public Long getFlag_express_SpcutOutSize4T() {
        return flag_express_SpcutOutSize4T;
    }

    public void setFlag_express_SpcutOutSize4T(Long flag_express_SpcutOutSize4T) {
        this.flag_express_SpcutOutSize4T = flag_express_SpcutOutSize4T;
    }

    public Long getFlag_express_SpcutOutSize5T() {
        return flag_express_SpcutOutSize5T;
    }

    public void setFlag_express_SpcutOutSize5T(Long flag_express_SpcutOutSize5T) {
        this.flag_express_SpcutOutSize5T = flag_express_SpcutOutSize5T;
    }

    public Long getFlag_express_SpcutOutSize6T() {
        return flag_express_SpcutOutSize6T;
    }

    public void setFlag_express_SpcutOutSize6T(Long flag_express_SpcutOutSize6T) {
        this.flag_express_SpcutOutSize6T = flag_express_SpcutOutSize6T;
    }

    public Long getFlag_express_SpcutOutSize7T() {
        return flag_express_SpcutOutSize7T;
    }

    public void setFlag_express_SpcutOutSize7T(Long flag_express_SpcutOutSize7T) {
        this.flag_express_SpcutOutSize7T = flag_express_SpcutOutSize7T;
    }

    public Long getFlag_express_SpcutOutSize8T() {
        return flag_express_SpcutOutSize8T;
    }

    public void setFlag_express_SpcutOutSize8T(Long flag_express_SpcutOutSize8T) {
        this.flag_express_SpcutOutSize8T = flag_express_SpcutOutSize8T;
    }

    public Long getFlag_express_SpcutOutSize9T() {
        return flag_express_SpcutOutSize9T;
    }

    public void setFlag_express_SpcutOutSize9T(Long flag_express_SpcutOutSize9T) {
        this.flag_express_SpcutOutSize9T = flag_express_SpcutOutSize9T;
    }

    public Long getFlag_express_SpcutOutSize10T() {
        return flag_express_SpcutOutSize10T;
    }

    public void setFlag_express_SpcutOutSize10T(Long flag_express_SpcutOutSize10T) {
        this.flag_express_SpcutOutSize10T = flag_express_SpcutOutSize10T;
    }

    public Long getFlag_express_SpcutOutSize11T() {
        return flag_express_SpcutOutSize11T;
    }

    public void setFlag_express_SpcutOutSize11T(Long flag_express_SpcutOutSize11T) {
        this.flag_express_SpcutOutSize11T = flag_express_SpcutOutSize11T;
    }

    public Long getFlag_express_SpcutOutSize12T() {
        return flag_express_SpcutOutSize12T;
    }

    public void setFlag_express_SpcutOutSize12T(Long flag_express_SpcutOutSize12T) {
        this.flag_express_SpcutOutSize12T = flag_express_SpcutOutSize12T;
    }

    public Long getFlag_express_SpcutOutSize13T() {
        return flag_express_SpcutOutSize13T;
    }

    public void setFlag_express_SpcutOutSize13T(Long flag_express_SpcutOutSize13T) {
        this.flag_express_SpcutOutSize13T = flag_express_SpcutOutSize13T;
    }

    public Long getFlag_express_SpprepInSize1() {
        return flag_express_SpprepInSize1;
    }

    public void setFlag_express_SpprepInSize1(Long flag_express_SpprepInSize1) {
        this.flag_express_SpprepInSize1 = flag_express_SpprepInSize1;
    }

    public Long getFlag_express_SpprepInSize2() {
        return flag_express_SpprepInSize2;
    }

    public void setFlag_express_SpprepInSize2(Long flag_express_SpprepInSize2) {
        this.flag_express_SpprepInSize2 = flag_express_SpprepInSize2;
    }

    public Long getFlag_express_SpprepInSize3() {
        return flag_express_SpprepInSize3;
    }

    public void setFlag_express_SpprepInSize3(Long flag_express_SpprepInSize3) {
        this.flag_express_SpprepInSize3 = flag_express_SpprepInSize3;
    }

    public Long getFlag_express_SpprepInSize4() {
        return flag_express_SpprepInSize4;
    }

    public void setFlag_express_SpprepInSize4(Long flag_express_SpprepInSize4) {
        this.flag_express_SpprepInSize4 = flag_express_SpprepInSize4;
    }

    public Long getFlag_express_SpprepInSize5() {
        return flag_express_SpprepInSize5;
    }

    public void setFlag_express_SpprepInSize5(Long flag_express_SpprepInSize5) {
        this.flag_express_SpprepInSize5 = flag_express_SpprepInSize5;
    }

    public Long getFlag_express_SpprepInSize6() {
        return flag_express_SpprepInSize6;
    }

    public void setFlag_express_SpprepInSize6(Long flag_express_SpprepInSize6) {
        this.flag_express_SpprepInSize6 = flag_express_SpprepInSize6;
    }

    public Long getFlag_express_SpprepInSize7() {
        return flag_express_SpprepInSize7;
    }

    public void setFlag_express_SpprepInSize7(Long flag_express_SpprepInSize7) {
        this.flag_express_SpprepInSize7 = flag_express_SpprepInSize7;
    }

    public Long getFlag_express_SpprepInSize8() {
        return flag_express_SpprepInSize8;
    }

    public void setFlag_express_SpprepInSize8(Long flag_express_SpprepInSize8) {
        this.flag_express_SpprepInSize8 = flag_express_SpprepInSize8;
    }

    public Long getFlag_express_SpprepInSize9() {
        return flag_express_SpprepInSize9;
    }

    public void setFlag_express_SpprepInSize9(Long flag_express_SpprepInSize9) {
        this.flag_express_SpprepInSize9 = flag_express_SpprepInSize9;
    }

    public Long getFlag_express_SpprepInSize10() {
        return flag_express_SpprepInSize10;
    }

    public void setFlag_express_SpprepInSize10(Long flag_express_SpprepInSize10) {
        this.flag_express_SpprepInSize10 = flag_express_SpprepInSize10;
    }

    public Long getFlag_express_SpprepInSize11() {
        return flag_express_SpprepInSize11;
    }

    public void setFlag_express_SpprepInSize11(Long flag_express_SpprepInSize11) {
        this.flag_express_SpprepInSize11 = flag_express_SpprepInSize11;
    }

    public Long getFlag_express_SpprepInSize12() {
        return flag_express_SpprepInSize12;
    }

    public void setFlag_express_SpprepInSize12(Long flag_express_SpprepInSize12) {
        this.flag_express_SpprepInSize12 = flag_express_SpprepInSize12;
    }

    public Long getFlag_express_SpprepInSize13() {
        return flag_express_SpprepInSize13;
    }

    public void setFlag_express_SpprepInSize13(Long flag_express_SpprepInSize13) {
        this.flag_express_SpprepInSize13 = flag_express_SpprepInSize13;
    }

    public Long getFlag_express_SpprepInSize14() {
        return flag_express_SpprepInSize14;
    }

    public void setFlag_express_SpprepInSize14(Long flag_express_SpprepInSize14) {
        this.flag_express_SpprepInSize14 = flag_express_SpprepInSize14;
    }

    public Long getFlag_express_SpprepInSize15() {
        return flag_express_SpprepInSize15;
    }

    public void setFlag_express_SpprepInSize15(Long flag_express_SpprepInSize15) {
        this.flag_express_SpprepInSize15 = flag_express_SpprepInSize15;
    }

    public Long getFlag_express_SpprepInSize16() {
        return flag_express_SpprepInSize16;
    }

    public void setFlag_express_SpprepInSize16(Long flag_express_SpprepInSize16) {
        this.flag_express_SpprepInSize16 = flag_express_SpprepInSize16;
    }

    public Long getFlag_express_SpprepInSize17() {
        return flag_express_SpprepInSize17;
    }

    public void setFlag_express_SpprepInSize17(Long flag_express_SpprepInSize17) {
        this.flag_express_SpprepInSize17 = flag_express_SpprepInSize17;
    }

    public Long getFlag_express_SpprepInSize18() {
        return flag_express_SpprepInSize18;
    }

    public void setFlag_express_SpprepInSize18(Long flag_express_SpprepInSize18) {
        this.flag_express_SpprepInSize18 = flag_express_SpprepInSize18;
    }

    public Long getFlag_express_SpprepInSize1T() {
        return flag_express_SpprepInSize1T;
    }

    public void setFlag_express_SpprepInSize1T(Long flag_express_SpprepInSize1T) {
        this.flag_express_SpprepInSize1T = flag_express_SpprepInSize1T;
    }

    public Long getFlag_express_SpprepInSize2T() {
        return flag_express_SpprepInSize2T;
    }

    public void setFlag_express_SpprepInSize2T(Long flag_express_SpprepInSize2T) {
        this.flag_express_SpprepInSize2T = flag_express_SpprepInSize2T;
    }

    public Long getFlag_express_SpprepInSize3T() {
        return flag_express_SpprepInSize3T;
    }

    public void setFlag_express_SpprepInSize3T(Long flag_express_SpprepInSize3T) {
        this.flag_express_SpprepInSize3T = flag_express_SpprepInSize3T;
    }

    public Long getFlag_express_SpprepInSize4T() {
        return flag_express_SpprepInSize4T;
    }

    public void setFlag_express_SpprepInSize4T(Long flag_express_SpprepInSize4T) {
        this.flag_express_SpprepInSize4T = flag_express_SpprepInSize4T;
    }

    public Long getFlag_express_SpprepInSize5T() {
        return flag_express_SpprepInSize5T;
    }

    public void setFlag_express_SpprepInSize5T(Long flag_express_SpprepInSize5T) {
        this.flag_express_SpprepInSize5T = flag_express_SpprepInSize5T;
    }

    public Long getFlag_express_SpprepInSize6T() {
        return flag_express_SpprepInSize6T;
    }

    public void setFlag_express_SpprepInSize6T(Long flag_express_SpprepInSize6T) {
        this.flag_express_SpprepInSize6T = flag_express_SpprepInSize6T;
    }

    public Long getFlag_express_SpprepInSize7T() {
        return flag_express_SpprepInSize7T;
    }

    public void setFlag_express_SpprepInSize7T(Long flag_express_SpprepInSize7T) {
        this.flag_express_SpprepInSize7T = flag_express_SpprepInSize7T;
    }

    public Long getFlag_express_SpprepInSize8T() {
        return flag_express_SpprepInSize8T;
    }

    public void setFlag_express_SpprepInSize8T(Long flag_express_SpprepInSize8T) {
        this.flag_express_SpprepInSize8T = flag_express_SpprepInSize8T;
    }

    public Long getFlag_express_SpprepInSize9T() {
        return flag_express_SpprepInSize9T;
    }

    public void setFlag_express_SpprepInSize9T(Long flag_express_SpprepInSize9T) {
        this.flag_express_SpprepInSize9T = flag_express_SpprepInSize9T;
    }

    public Long getFlag_express_SpprepInSize10T() {
        return flag_express_SpprepInSize10T;
    }

    public void setFlag_express_SpprepInSize10T(Long flag_express_SpprepInSize10T) {
        this.flag_express_SpprepInSize10T = flag_express_SpprepInSize10T;
    }

    public Long getFlag_express_SpprepInSize11T() {
        return flag_express_SpprepInSize11T;
    }

    public void setFlag_express_SpprepInSize11T(Long flag_express_SpprepInSize11T) {
        this.flag_express_SpprepInSize11T = flag_express_SpprepInSize11T;
    }

    public Long getFlag_express_SpprepInSize12T() {
        return flag_express_SpprepInSize12T;
    }

    public void setFlag_express_SpprepInSize12T(Long flag_express_SpprepInSize12T) {
        this.flag_express_SpprepInSize12T = flag_express_SpprepInSize12T;
    }

    public Long getFlag_express_SpprepInSize13T() {
        return flag_express_SpprepInSize13T;
    }

    public void setFlag_express_SpprepInSize13T(Long flag_express_SpprepInSize13T) {
        this.flag_express_SpprepInSize13T = flag_express_SpprepInSize13T;
    }

    public Long getFlag_express_SpprepOutSize1() {
        return flag_express_SpprepOutSize1;
    }

    public void setFlag_express_SpprepOutSize1(Long flag_express_SpprepOutSize1) {
        this.flag_express_SpprepOutSize1 = flag_express_SpprepOutSize1;
    }

    public Long getFlag_express_SpprepOutSize2() {
        return flag_express_SpprepOutSize2;
    }

    public void setFlag_express_SpprepOutSize2(Long flag_express_SpprepOutSize2) {
        this.flag_express_SpprepOutSize2 = flag_express_SpprepOutSize2;
    }

    public Long getFlag_express_SpprepOutSize3() {
        return flag_express_SpprepOutSize3;
    }

    public void setFlag_express_SpprepOutSize3(Long flag_express_SpprepOutSize3) {
        this.flag_express_SpprepOutSize3 = flag_express_SpprepOutSize3;
    }

    public Long getFlag_express_SpprepOutSize4() {
        return flag_express_SpprepOutSize4;
    }

    public void setFlag_express_SpprepOutSize4(Long flag_express_SpprepOutSize4) {
        this.flag_express_SpprepOutSize4 = flag_express_SpprepOutSize4;
    }

    public Long getFlag_express_SpprepOutSize5() {
        return flag_express_SpprepOutSize5;
    }

    public void setFlag_express_SpprepOutSize5(Long flag_express_SpprepOutSize5) {
        this.flag_express_SpprepOutSize5 = flag_express_SpprepOutSize5;
    }

    public Long getFlag_express_SpprepOutSize6() {
        return flag_express_SpprepOutSize6;
    }

    public void setFlag_express_SpprepOutSize6(Long flag_express_SpprepOutSize6) {
        this.flag_express_SpprepOutSize6 = flag_express_SpprepOutSize6;
    }

    public Long getFlag_express_SpprepOutSize7() {
        return flag_express_SpprepOutSize7;
    }

    public void setFlag_express_SpprepOutSize7(Long flag_express_SpprepOutSize7) {
        this.flag_express_SpprepOutSize7 = flag_express_SpprepOutSize7;
    }

    public Long getFlag_express_SpprepOutSize8() {
        return flag_express_SpprepOutSize8;
    }

    public void setFlag_express_SpprepOutSize8(Long flag_express_SpprepOutSize8) {
        this.flag_express_SpprepOutSize8 = flag_express_SpprepOutSize8;
    }

    public Long getFlag_express_SpprepOutSize9() {
        return flag_express_SpprepOutSize9;
    }

    public void setFlag_express_SpprepOutSize9(Long flag_express_SpprepOutSize9) {
        this.flag_express_SpprepOutSize9 = flag_express_SpprepOutSize9;
    }

    public Long getFlag_express_SpprepOutSize10() {
        return flag_express_SpprepOutSize10;
    }

    public void setFlag_express_SpprepOutSize10(Long flag_express_SpprepOutSize10) {
        this.flag_express_SpprepOutSize10 = flag_express_SpprepOutSize10;
    }

    public Long getFlag_express_SpprepOutSize11() {
        return flag_express_SpprepOutSize11;
    }

    public void setFlag_express_SpprepOutSize11(Long flag_express_SpprepOutSize11) {
        this.flag_express_SpprepOutSize11 = flag_express_SpprepOutSize11;
    }

    public Long getFlag_express_SpprepOutSize12() {
        return flag_express_SpprepOutSize12;
    }

    public void setFlag_express_SpprepOutSize12(Long flag_express_SpprepOutSize12) {
        this.flag_express_SpprepOutSize12 = flag_express_SpprepOutSize12;
    }

    public Long getFlag_express_SpprepOutSize13() {
        return flag_express_SpprepOutSize13;
    }

    public void setFlag_express_SpprepOutSize13(Long flag_express_SpprepOutSize13) {
        this.flag_express_SpprepOutSize13 = flag_express_SpprepOutSize13;
    }

    public Long getFlag_express_SpprepOutSize14() {
        return flag_express_SpprepOutSize14;
    }

    public void setFlag_express_SpprepOutSize14(Long flag_express_SpprepOutSize14) {
        this.flag_express_SpprepOutSize14 = flag_express_SpprepOutSize14;
    }

    public Long getFlag_express_SpprepOutSize15() {
        return flag_express_SpprepOutSize15;
    }

    public void setFlag_express_SpprepOutSize15(Long flag_express_SpprepOutSize15) {
        this.flag_express_SpprepOutSize15 = flag_express_SpprepOutSize15;
    }

    public Long getFlag_express_SpprepOutSize16() {
        return flag_express_SpprepOutSize16;
    }

    public void setFlag_express_SpprepOutSize16(Long flag_express_SpprepOutSize16) {
        this.flag_express_SpprepOutSize16 = flag_express_SpprepOutSize16;
    }

    public Long getFlag_express_SpprepOutSize17() {
        return flag_express_SpprepOutSize17;
    }

    public void setFlag_express_SpprepOutSize17(Long flag_express_SpprepOutSize17) {
        this.flag_express_SpprepOutSize17 = flag_express_SpprepOutSize17;
    }

    public Long getFlag_express_SpprepOutSize18() {
        return flag_express_SpprepOutSize18;
    }

    public void setFlag_express_SpprepOutSize18(Long flag_express_SpprepOutSize18) {
        this.flag_express_SpprepOutSize18 = flag_express_SpprepOutSize18;
    }

    public Long getFlag_express_SpprepOutSize1T() {
        return flag_express_SpprepOutSize1T;
    }

    public void setFlag_express_SpprepOutSize1T(Long flag_express_SpprepOutSize1T) {
        this.flag_express_SpprepOutSize1T = flag_express_SpprepOutSize1T;
    }

    public Long getFlag_express_SpprepOutSize2T() {
        return flag_express_SpprepOutSize2T;
    }

    public void setFlag_express_SpprepOutSize2T(Long flag_express_SpprepOutSize2T) {
        this.flag_express_SpprepOutSize2T = flag_express_SpprepOutSize2T;
    }

    public Long getFlag_express_SpprepOutSize3T() {
        return flag_express_SpprepOutSize3T;
    }

    public void setFlag_express_SpprepOutSize3T(Long flag_express_SpprepOutSize3T) {
        this.flag_express_SpprepOutSize3T = flag_express_SpprepOutSize3T;
    }

    public Long getFlag_express_SpprepOutSize4T() {
        return flag_express_SpprepOutSize4T;
    }

    public void setFlag_express_SpprepOutSize4T(Long flag_express_SpprepOutSize4T) {
        this.flag_express_SpprepOutSize4T = flag_express_SpprepOutSize4T;
    }

    public Long getFlag_express_SpprepOutSize5T() {
        return flag_express_SpprepOutSize5T;
    }

    public void setFlag_express_SpprepOutSize5T(Long flag_express_SpprepOutSize5T) {
        this.flag_express_SpprepOutSize5T = flag_express_SpprepOutSize5T;
    }

    public Long getFlag_express_SpprepOutSize6T() {
        return flag_express_SpprepOutSize6T;
    }

    public void setFlag_express_SpprepOutSize6T(Long flag_express_SpprepOutSize6T) {
        this.flag_express_SpprepOutSize6T = flag_express_SpprepOutSize6T;
    }

    public Long getFlag_express_SpprepOutSize7T() {
        return flag_express_SpprepOutSize7T;
    }

    public void setFlag_express_SpprepOutSize7T(Long flag_express_SpprepOutSize7T) {
        this.flag_express_SpprepOutSize7T = flag_express_SpprepOutSize7T;
    }

    public Long getFlag_express_SpprepOutSize8T() {
        return flag_express_SpprepOutSize8T;
    }

    public void setFlag_express_SpprepOutSize8T(Long flag_express_SpprepOutSize8T) {
        this.flag_express_SpprepOutSize8T = flag_express_SpprepOutSize8T;
    }

    public Long getFlag_express_SpprepOutSize9T() {
        return flag_express_SpprepOutSize9T;
    }

    public void setFlag_express_SpprepOutSize9T(Long flag_express_SpprepOutSize9T) {
        this.flag_express_SpprepOutSize9T = flag_express_SpprepOutSize9T;
    }

    public Long getFlag_express_SpprepOutSize10T() {
        return flag_express_SpprepOutSize10T;
    }

    public void setFlag_express_SpprepOutSize10T(Long flag_express_SpprepOutSize10T) {
        this.flag_express_SpprepOutSize10T = flag_express_SpprepOutSize10T;
    }

    public Long getFlag_express_SpprepOutSize11T() {
        return flag_express_SpprepOutSize11T;
    }

    public void setFlag_express_SpprepOutSize11T(Long flag_express_SpprepOutSize11T) {
        this.flag_express_SpprepOutSize11T = flag_express_SpprepOutSize11T;
    }

    public Long getFlag_express_SpprepOutSize12T() {
        return flag_express_SpprepOutSize12T;
    }

    public void setFlag_express_SpprepOutSize12T(Long flag_express_SpprepOutSize12T) {
        this.flag_express_SpprepOutSize12T = flag_express_SpprepOutSize12T;
    }

    public Long getFlag_express_SpprepOutSize13T() {
        return flag_express_SpprepOutSize13T;
    }

    public void setFlag_express_SpprepOutSize13T(Long flag_express_SpprepOutSize13T) {
        this.flag_express_SpprepOutSize13T = flag_express_SpprepOutSize13T;
    }

    public Long getFlag_express_LabelInSize1() {
        return flag_express_LabelInSize1;
    }

    public void setFlag_express_LabelInSize1(Long flag_express_LabelInSize1) {
        this.flag_express_LabelInSize1 = flag_express_LabelInSize1;
    }

    public Long getFlag_express_LabelInSize2() {
        return flag_express_LabelInSize2;
    }

    public void setFlag_express_LabelInSize2(Long flag_express_LabelInSize2) {
        this.flag_express_LabelInSize2 = flag_express_LabelInSize2;
    }

    public Long getFlag_express_LabelInSize3() {
        return flag_express_LabelInSize3;
    }

    public void setFlag_express_LabelInSize3(Long flag_express_LabelInSize3) {
        this.flag_express_LabelInSize3 = flag_express_LabelInSize3;
    }

    public Long getFlag_express_LabelInSize4() {
        return flag_express_LabelInSize4;
    }

    public void setFlag_express_LabelInSize4(Long flag_express_LabelInSize4) {
        this.flag_express_LabelInSize4 = flag_express_LabelInSize4;
    }

    public Long getFlag_express_LabelInSize5() {
        return flag_express_LabelInSize5;
    }

    public void setFlag_express_LabelInSize5(Long flag_express_LabelInSize5) {
        this.flag_express_LabelInSize5 = flag_express_LabelInSize5;
    }

    public Long getFlag_express_LabelInSize6() {
        return flag_express_LabelInSize6;
    }

    public void setFlag_express_LabelInSize6(Long flag_express_LabelInSize6) {
        this.flag_express_LabelInSize6 = flag_express_LabelInSize6;
    }

    public Long getFlag_express_LabelInSize7() {
        return flag_express_LabelInSize7;
    }

    public void setFlag_express_LabelInSize7(Long flag_express_LabelInSize7) {
        this.flag_express_LabelInSize7 = flag_express_LabelInSize7;
    }

    public Long getFlag_express_LabelInSize8() {
        return flag_express_LabelInSize8;
    }

    public void setFlag_express_LabelInSize8(Long flag_express_LabelInSize8) {
        this.flag_express_LabelInSize8 = flag_express_LabelInSize8;
    }

    public Long getFlag_express_LabelInSize9() {
        return flag_express_LabelInSize9;
    }

    public void setFlag_express_LabelInSize9(Long flag_express_LabelInSize9) {
        this.flag_express_LabelInSize9 = flag_express_LabelInSize9;
    }

    public Long getFlag_express_LabelInSize10() {
        return flag_express_LabelInSize10;
    }

    public void setFlag_express_LabelInSize10(Long flag_express_LabelInSize10) {
        this.flag_express_LabelInSize10 = flag_express_LabelInSize10;
    }

    public Long getFlag_express_LabelInSize11() {
        return flag_express_LabelInSize11;
    }

    public void setFlag_express_LabelInSize11(Long flag_express_LabelInSize11) {
        this.flag_express_LabelInSize11 = flag_express_LabelInSize11;
    }

    public Long getFlag_express_LabelInSize12() {
        return flag_express_LabelInSize12;
    }

    public void setFlag_express_LabelInSize12(Long flag_express_LabelInSize12) {
        this.flag_express_LabelInSize12 = flag_express_LabelInSize12;
    }

    public Long getFlag_express_LabelInSize13() {
        return flag_express_LabelInSize13;
    }

    public void setFlag_express_LabelInSize13(Long flag_express_LabelInSize13) {
        this.flag_express_LabelInSize13 = flag_express_LabelInSize13;
    }

    public Long getFlag_express_LabelInSize14() {
        return flag_express_LabelInSize14;
    }

    public void setFlag_express_LabelInSize14(Long flag_express_LabelInSize14) {
        this.flag_express_LabelInSize14 = flag_express_LabelInSize14;
    }

    public Long getFlag_express_LabelInSize15() {
        return flag_express_LabelInSize15;
    }

    public void setFlag_express_LabelInSize15(Long flag_express_LabelInSize15) {
        this.flag_express_LabelInSize15 = flag_express_LabelInSize15;
    }

    public Long getFlag_express_LabelInSize16() {
        return flag_express_LabelInSize16;
    }

    public void setFlag_express_LabelInSize16(Long flag_express_LabelInSize16) {
        this.flag_express_LabelInSize16 = flag_express_LabelInSize16;
    }

    public Long getFlag_express_LabelInSize17() {
        return flag_express_LabelInSize17;
    }

    public void setFlag_express_LabelInSize17(Long flag_express_LabelInSize17) {
        this.flag_express_LabelInSize17 = flag_express_LabelInSize17;
    }

    public Long getFlag_express_LabelInSize18() {
        return flag_express_LabelInSize18;
    }

    public void setFlag_express_LabelInSize18(Long flag_express_LabelInSize18) {
        this.flag_express_LabelInSize18 = flag_express_LabelInSize18;
    }

    public Long getFlag_express_LabelInSize1T() {
        return flag_express_LabelInSize1T;
    }

    public void setFlag_express_LabelInSize1T(Long flag_express_LabelInSize1T) {
        this.flag_express_LabelInSize1T = flag_express_LabelInSize1T;
    }

    public Long getFlag_express_LabelInSize2T() {
        return flag_express_LabelInSize2T;
    }

    public void setFlag_express_LabelInSize2T(Long flag_express_LabelInSize2T) {
        this.flag_express_LabelInSize2T = flag_express_LabelInSize2T;
    }

    public Long getFlag_express_LabelInSize3T() {
        return flag_express_LabelInSize3T;
    }

    public void setFlag_express_LabelInSize3T(Long flag_express_LabelInSize3T) {
        this.flag_express_LabelInSize3T = flag_express_LabelInSize3T;
    }

    public Long getFlag_express_LabelInSize4T() {
        return flag_express_LabelInSize4T;
    }

    public void setFlag_express_LabelInSize4T(Long flag_express_LabelInSize4T) {
        this.flag_express_LabelInSize4T = flag_express_LabelInSize4T;
    }

    public Long getFlag_express_LabelInSize5T() {
        return flag_express_LabelInSize5T;
    }

    public void setFlag_express_LabelInSize5T(Long flag_express_LabelInSize5T) {
        this.flag_express_LabelInSize5T = flag_express_LabelInSize5T;
    }

    public Long getFlag_express_LabelInSize6T() {
        return flag_express_LabelInSize6T;
    }

    public void setFlag_express_LabelInSize6T(Long flag_express_LabelInSize6T) {
        this.flag_express_LabelInSize6T = flag_express_LabelInSize6T;
    }

    public Long getFlag_express_LabelInSize7T() {
        return flag_express_LabelInSize7T;
    }

    public void setFlag_express_LabelInSize7T(Long flag_express_LabelInSize7T) {
        this.flag_express_LabelInSize7T = flag_express_LabelInSize7T;
    }

    public Long getFlag_express_LabelInSize8T() {
        return flag_express_LabelInSize8T;
    }

    public void setFlag_express_LabelInSize8T(Long flag_express_LabelInSize8T) {
        this.flag_express_LabelInSize8T = flag_express_LabelInSize8T;
    }

    public Long getFlag_express_LabelInSize9T() {
        return flag_express_LabelInSize9T;
    }

    public void setFlag_express_LabelInSize9T(Long flag_express_LabelInSize9T) {
        this.flag_express_LabelInSize9T = flag_express_LabelInSize9T;
    }

    public Long getFlag_express_LabelInSize10T() {
        return flag_express_LabelInSize10T;
    }

    public void setFlag_express_LabelInSize10T(Long flag_express_LabelInSize10T) {
        this.flag_express_LabelInSize10T = flag_express_LabelInSize10T;
    }

    public Long getFlag_express_LabelInSize11T() {
        return flag_express_LabelInSize11T;
    }

    public void setFlag_express_LabelInSize11T(Long flag_express_LabelInSize11T) {
        this.flag_express_LabelInSize11T = flag_express_LabelInSize11T;
    }

    public Long getFlag_express_LabelInSize12T() {
        return flag_express_LabelInSize12T;
    }

    public void setFlag_express_LabelInSize12T(Long flag_express_LabelInSize12T) {
        this.flag_express_LabelInSize12T = flag_express_LabelInSize12T;
    }

    public Long getFlag_express_LabelInSize13T() {
        return flag_express_LabelInSize13T;
    }

    public void setFlag_express_LabelInSize13T(Long flag_express_LabelInSize13T) {
        this.flag_express_LabelInSize13T = flag_express_LabelInSize13T;
    }

    public Long getFlag_express_LabelOutSize1() {
        return flag_express_LabelOutSize1;
    }

    public void setFlag_express_LabelOutSize1(Long flag_express_LabelOutSize1) {
        this.flag_express_LabelOutSize1 = flag_express_LabelOutSize1;
    }

    public Long getFlag_express_LabelOutSize2() {
        return flag_express_LabelOutSize2;
    }

    public void setFlag_express_LabelOutSize2(Long flag_express_LabelOutSize2) {
        this.flag_express_LabelOutSize2 = flag_express_LabelOutSize2;
    }

    public Long getFlag_express_LabelOutSize3() {
        return flag_express_LabelOutSize3;
    }

    public void setFlag_express_LabelOutSize3(Long flag_express_LabelOutSize3) {
        this.flag_express_LabelOutSize3 = flag_express_LabelOutSize3;
    }

    public Long getFlag_express_LabelOutSize4() {
        return flag_express_LabelOutSize4;
    }

    public void setFlag_express_LabelOutSize4(Long flag_express_LabelOutSize4) {
        this.flag_express_LabelOutSize4 = flag_express_LabelOutSize4;
    }

    public Long getFlag_express_LabelOutSize5() {
        return flag_express_LabelOutSize5;
    }

    public void setFlag_express_LabelOutSize5(Long flag_express_LabelOutSize5) {
        this.flag_express_LabelOutSize5 = flag_express_LabelOutSize5;
    }

    public Long getFlag_express_LabelOutSize6() {
        return flag_express_LabelOutSize6;
    }

    public void setFlag_express_LabelOutSize6(Long flag_express_LabelOutSize6) {
        this.flag_express_LabelOutSize6 = flag_express_LabelOutSize6;
    }

    public Long getFlag_express_LabelOutSize7() {
        return flag_express_LabelOutSize7;
    }

    public void setFlag_express_LabelOutSize7(Long flag_express_LabelOutSize7) {
        this.flag_express_LabelOutSize7 = flag_express_LabelOutSize7;
    }

    public Long getFlag_express_LabelOutSize8() {
        return flag_express_LabelOutSize8;
    }

    public void setFlag_express_LabelOutSize8(Long flag_express_LabelOutSize8) {
        this.flag_express_LabelOutSize8 = flag_express_LabelOutSize8;
    }

    public Long getFlag_express_LabelOutSize9() {
        return flag_express_LabelOutSize9;
    }

    public void setFlag_express_LabelOutSize9(Long flag_express_LabelOutSize9) {
        this.flag_express_LabelOutSize9 = flag_express_LabelOutSize9;
    }

    public Long getFlag_express_LabelOutSize10() {
        return flag_express_LabelOutSize10;
    }

    public void setFlag_express_LabelOutSize10(Long flag_express_LabelOutSize10) {
        this.flag_express_LabelOutSize10 = flag_express_LabelOutSize10;
    }

    public Long getFlag_express_LabelOutSize11() {
        return flag_express_LabelOutSize11;
    }

    public void setFlag_express_LabelOutSize11(Long flag_express_LabelOutSize11) {
        this.flag_express_LabelOutSize11 = flag_express_LabelOutSize11;
    }

    public Long getFlag_express_LabelOutSize12() {
        return flag_express_LabelOutSize12;
    }

    public void setFlag_express_LabelOutSize12(Long flag_express_LabelOutSize12) {
        this.flag_express_LabelOutSize12 = flag_express_LabelOutSize12;
    }

    public Long getFlag_express_LabelOutSize13() {
        return flag_express_LabelOutSize13;
    }

    public void setFlag_express_LabelOutSize13(Long flag_express_LabelOutSize13) {
        this.flag_express_LabelOutSize13 = flag_express_LabelOutSize13;
    }

    public Long getFlag_express_LabelOutSize14() {
        return flag_express_LabelOutSize14;
    }

    public void setFlag_express_LabelOutSize14(Long flag_express_LabelOutSize14) {
        this.flag_express_LabelOutSize14 = flag_express_LabelOutSize14;
    }

    public Long getFlag_express_LabelOutSize15() {
        return flag_express_LabelOutSize15;
    }

    public void setFlag_express_LabelOutSize15(Long flag_express_LabelOutSize15) {
        this.flag_express_LabelOutSize15 = flag_express_LabelOutSize15;
    }

    public Long getFlag_express_LabelOutSize16() {
        return flag_express_LabelOutSize16;
    }

    public void setFlag_express_LabelOutSize16(Long flag_express_LabelOutSize16) {
        this.flag_express_LabelOutSize16 = flag_express_LabelOutSize16;
    }

    public Long getFlag_express_LabelOutSize17() {
        return flag_express_LabelOutSize17;
    }

    public void setFlag_express_LabelOutSize17(Long flag_express_LabelOutSize17) {
        this.flag_express_LabelOutSize17 = flag_express_LabelOutSize17;
    }

    public Long getFlag_express_LabelOutSize18() {
        return flag_express_LabelOutSize18;
    }

    public void setFlag_express_LabelOutSize18(Long flag_express_LabelOutSize18) {
        this.flag_express_LabelOutSize18 = flag_express_LabelOutSize18;
    }

    public Long getFlag_express_LabelOutSize1T() {
        return flag_express_LabelOutSize1T;
    }

    public void setFlag_express_LabelOutSize1T(Long flag_express_LabelOutSize1T) {
        this.flag_express_LabelOutSize1T = flag_express_LabelOutSize1T;
    }

    public Long getFlag_express_LabelOutSize2T() {
        return flag_express_LabelOutSize2T;
    }

    public void setFlag_express_LabelOutSize2T(Long flag_express_LabelOutSize2T) {
        this.flag_express_LabelOutSize2T = flag_express_LabelOutSize2T;
    }

    public Long getFlag_express_LabelOutSize3T() {
        return flag_express_LabelOutSize3T;
    }

    public void setFlag_express_LabelOutSize3T(Long flag_express_LabelOutSize3T) {
        this.flag_express_LabelOutSize3T = flag_express_LabelOutSize3T;
    }

    public Long getFlag_express_LabelOutSize4T() {
        return flag_express_LabelOutSize4T;
    }

    public void setFlag_express_LabelOutSize4T(Long flag_express_LabelOutSize4T) {
        this.flag_express_LabelOutSize4T = flag_express_LabelOutSize4T;
    }

    public Long getFlag_express_LabelOutSize5T() {
        return flag_express_LabelOutSize5T;
    }

    public void setFlag_express_LabelOutSize5T(Long flag_express_LabelOutSize5T) {
        this.flag_express_LabelOutSize5T = flag_express_LabelOutSize5T;
    }

    public Long getFlag_express_LabelOutSize6T() {
        return flag_express_LabelOutSize6T;
    }

    public void setFlag_express_LabelOutSize6T(Long flag_express_LabelOutSize6T) {
        this.flag_express_LabelOutSize6T = flag_express_LabelOutSize6T;
    }

    public Long getFlag_express_LabelOutSize7T() {
        return flag_express_LabelOutSize7T;
    }

    public void setFlag_express_LabelOutSize7T(Long flag_express_LabelOutSize7T) {
        this.flag_express_LabelOutSize7T = flag_express_LabelOutSize7T;
    }

    public Long getFlag_express_LabelOutSize8T() {
        return flag_express_LabelOutSize8T;
    }

    public void setFlag_express_LabelOutSize8T(Long flag_express_LabelOutSize8T) {
        this.flag_express_LabelOutSize8T = flag_express_LabelOutSize8T;
    }

    public Long getFlag_express_LabelOutSize9T() {
        return flag_express_LabelOutSize9T;
    }

    public void setFlag_express_LabelOutSize9T(Long flag_express_LabelOutSize9T) {
        this.flag_express_LabelOutSize9T = flag_express_LabelOutSize9T;
    }

    public Long getFlag_express_LabelOutSize10T() {
        return flag_express_LabelOutSize10T;
    }

    public void setFlag_express_LabelOutSize10T(Long flag_express_LabelOutSize10T) {
        this.flag_express_LabelOutSize10T = flag_express_LabelOutSize10T;
    }

    public Long getFlag_express_LabelOutSize11T() {
        return flag_express_LabelOutSize11T;
    }

    public void setFlag_express_LabelOutSize11T(Long flag_express_LabelOutSize11T) {
        this.flag_express_LabelOutSize11T = flag_express_LabelOutSize11T;
    }

    public Long getFlag_express_LabelOutSize12T() {
        return flag_express_LabelOutSize12T;
    }

    public void setFlag_express_LabelOutSize12T(Long flag_express_LabelOutSize12T) {
        this.flag_express_LabelOutSize12T = flag_express_LabelOutSize12T;
    }

    public Long getFlag_express_LabelOutSize13T() {
        return flag_express_LabelOutSize13T;
    }

    public void setFlag_express_LabelOutSize13T(Long flag_express_LabelOutSize13T) {
        this.flag_express_LabelOutSize13T = flag_express_LabelOutSize13T;
    }

    public Long getFlag_express_LaserInSize1() {
        return flag_express_LaserInSize1;
    }

    public void setFlag_express_LaserInSize1(Long flag_express_LaserInSize1) {
        this.flag_express_LaserInSize1 = flag_express_LaserInSize1;
    }

    public Long getFlag_express_LaserInSize2() {
        return flag_express_LaserInSize2;
    }

    public void setFlag_express_LaserInSize2(Long flag_express_LaserInSize2) {
        this.flag_express_LaserInSize2 = flag_express_LaserInSize2;
    }

    public Long getFlag_express_LaserInSize3() {
        return flag_express_LaserInSize3;
    }

    public void setFlag_express_LaserInSize3(Long flag_express_LaserInSize3) {
        this.flag_express_LaserInSize3 = flag_express_LaserInSize3;
    }

    public Long getFlag_express_LaserInSize4() {
        return flag_express_LaserInSize4;
    }

    public void setFlag_express_LaserInSize4(Long flag_express_LaserInSize4) {
        this.flag_express_LaserInSize4 = flag_express_LaserInSize4;
    }

    public Long getFlag_express_LaserInSize5() {
        return flag_express_LaserInSize5;
    }

    public void setFlag_express_LaserInSize5(Long flag_express_LaserInSize5) {
        this.flag_express_LaserInSize5 = flag_express_LaserInSize5;
    }

    public Long getFlag_express_LaserInSize6() {
        return flag_express_LaserInSize6;
    }

    public void setFlag_express_LaserInSize6(Long flag_express_LaserInSize6) {
        this.flag_express_LaserInSize6 = flag_express_LaserInSize6;
    }

    public Long getFlag_express_LaserInSize7() {
        return flag_express_LaserInSize7;
    }

    public void setFlag_express_LaserInSize7(Long flag_express_LaserInSize7) {
        this.flag_express_LaserInSize7 = flag_express_LaserInSize7;
    }

    public Long getFlag_express_LaserInSize8() {
        return flag_express_LaserInSize8;
    }

    public void setFlag_express_LaserInSize8(Long flag_express_LaserInSize8) {
        this.flag_express_LaserInSize8 = flag_express_LaserInSize8;
    }

    public Long getFlag_express_LaserInSize9() {
        return flag_express_LaserInSize9;
    }

    public void setFlag_express_LaserInSize9(Long flag_express_LaserInSize9) {
        this.flag_express_LaserInSize9 = flag_express_LaserInSize9;
    }

    public Long getFlag_express_LaserInSize10() {
        return flag_express_LaserInSize10;
    }

    public void setFlag_express_LaserInSize10(Long flag_express_LaserInSize10) {
        this.flag_express_LaserInSize10 = flag_express_LaserInSize10;
    }

    public Long getFlag_express_LaserInSize11() {
        return flag_express_LaserInSize11;
    }

    public void setFlag_express_LaserInSize11(Long flag_express_LaserInSize11) {
        this.flag_express_LaserInSize11 = flag_express_LaserInSize11;
    }

    public Long getFlag_express_LaserInSize12() {
        return flag_express_LaserInSize12;
    }

    public void setFlag_express_LaserInSize12(Long flag_express_LaserInSize12) {
        this.flag_express_LaserInSize12 = flag_express_LaserInSize12;
    }

    public Long getFlag_express_LaserInSize13() {
        return flag_express_LaserInSize13;
    }

    public void setFlag_express_LaserInSize13(Long flag_express_LaserInSize13) {
        this.flag_express_LaserInSize13 = flag_express_LaserInSize13;
    }

    public Long getFlag_express_LaserInSize14() {
        return flag_express_LaserInSize14;
    }

    public void setFlag_express_LaserInSize14(Long flag_express_LaserInSize14) {
        this.flag_express_LaserInSize14 = flag_express_LaserInSize14;
    }

    public Long getFlag_express_LaserInSize15() {
        return flag_express_LaserInSize15;
    }

    public void setFlag_express_LaserInSize15(Long flag_express_LaserInSize15) {
        this.flag_express_LaserInSize15 = flag_express_LaserInSize15;
    }

    public Long getFlag_express_LaserInSize16() {
        return flag_express_LaserInSize16;
    }

    public void setFlag_express_LaserInSize16(Long flag_express_LaserInSize16) {
        this.flag_express_LaserInSize16 = flag_express_LaserInSize16;
    }

    public Long getFlag_express_LaserInSize17() {
        return flag_express_LaserInSize17;
    }

    public void setFlag_express_LaserInSize17(Long flag_express_LaserInSize17) {
        this.flag_express_LaserInSize17 = flag_express_LaserInSize17;
    }

    public Long getFlag_express_LaserInSize18() {
        return flag_express_LaserInSize18;
    }

    public void setFlag_express_LaserInSize18(Long flag_express_LaserInSize18) {
        this.flag_express_LaserInSize18 = flag_express_LaserInSize18;
    }

    public Long getFlag_express_LaserInSize1T() {
        return flag_express_LaserInSize1T;
    }

    public void setFlag_express_LaserInSize1T(Long flag_express_LaserInSize1T) {
        this.flag_express_LaserInSize1T = flag_express_LaserInSize1T;
    }

    public Long getFlag_express_LaserInSize2T() {
        return flag_express_LaserInSize2T;
    }

    public void setFlag_express_LaserInSize2T(Long flag_express_LaserInSize2T) {
        this.flag_express_LaserInSize2T = flag_express_LaserInSize2T;
    }

    public Long getFlag_express_LaserInSize3T() {
        return flag_express_LaserInSize3T;
    }

    public void setFlag_express_LaserInSize3T(Long flag_express_LaserInSize3T) {
        this.flag_express_LaserInSize3T = flag_express_LaserInSize3T;
    }

    public Long getFlag_express_LaserInSize4T() {
        return flag_express_LaserInSize4T;
    }

    public void setFlag_express_LaserInSize4T(Long flag_express_LaserInSize4T) {
        this.flag_express_LaserInSize4T = flag_express_LaserInSize4T;
    }

    public Long getFlag_express_LaserInSize5T() {
        return flag_express_LaserInSize5T;
    }

    public void setFlag_express_LaserInSize5T(Long flag_express_LaserInSize5T) {
        this.flag_express_LaserInSize5T = flag_express_LaserInSize5T;
    }

    public Long getFlag_express_LaserInSize6T() {
        return flag_express_LaserInSize6T;
    }

    public void setFlag_express_LaserInSize6T(Long flag_express_LaserInSize6T) {
        this.flag_express_LaserInSize6T = flag_express_LaserInSize6T;
    }

    public Long getFlag_express_LaserInSize7T() {
        return flag_express_LaserInSize7T;
    }

    public void setFlag_express_LaserInSize7T(Long flag_express_LaserInSize7T) {
        this.flag_express_LaserInSize7T = flag_express_LaserInSize7T;
    }

    public Long getFlag_express_LaserInSize8T() {
        return flag_express_LaserInSize8T;
    }

    public void setFlag_express_LaserInSize8T(Long flag_express_LaserInSize8T) {
        this.flag_express_LaserInSize8T = flag_express_LaserInSize8T;
    }

    public Long getFlag_express_LaserInSize9T() {
        return flag_express_LaserInSize9T;
    }

    public void setFlag_express_LaserInSize9T(Long flag_express_LaserInSize9T) {
        this.flag_express_LaserInSize9T = flag_express_LaserInSize9T;
    }

    public Long getFlag_express_LaserInSize10T() {
        return flag_express_LaserInSize10T;
    }

    public void setFlag_express_LaserInSize10T(Long flag_express_LaserInSize10T) {
        this.flag_express_LaserInSize10T = flag_express_LaserInSize10T;
    }

    public Long getFlag_express_LaserInSize11T() {
        return flag_express_LaserInSize11T;
    }

    public void setFlag_express_LaserInSize11T(Long flag_express_LaserInSize11T) {
        this.flag_express_LaserInSize11T = flag_express_LaserInSize11T;
    }

    public Long getFlag_express_LaserInSize12T() {
        return flag_express_LaserInSize12T;
    }

    public void setFlag_express_LaserInSize12T(Long flag_express_LaserInSize12T) {
        this.flag_express_LaserInSize12T = flag_express_LaserInSize12T;
    }

    public Long getFlag_express_LaserInSize13T() {
        return flag_express_LaserInSize13T;
    }

    public void setFlag_express_LaserInSize13T(Long flag_express_LaserInSize13T) {
        this.flag_express_LaserInSize13T = flag_express_LaserInSize13T;
    }

    public Long getFlag_express_LaserOutSize1() {
        return flag_express_LaserOutSize1;
    }

    public void setFlag_express_LaserOutSize1(Long flag_express_LaserOutSize1) {
        this.flag_express_LaserOutSize1 = flag_express_LaserOutSize1;
    }

    public Long getFlag_express_LaserOutSize2() {
        return flag_express_LaserOutSize2;
    }

    public void setFlag_express_LaserOutSize2(Long flag_express_LaserOutSize2) {
        this.flag_express_LaserOutSize2 = flag_express_LaserOutSize2;
    }

    public Long getFlag_express_LaserOutSize3() {
        return flag_express_LaserOutSize3;
    }

    public void setFlag_express_LaserOutSize3(Long flag_express_LaserOutSize3) {
        this.flag_express_LaserOutSize3 = flag_express_LaserOutSize3;
    }

    public Long getFlag_express_LaserOutSize4() {
        return flag_express_LaserOutSize4;
    }

    public void setFlag_express_LaserOutSize4(Long flag_express_LaserOutSize4) {
        this.flag_express_LaserOutSize4 = flag_express_LaserOutSize4;
    }

    public Long getFlag_express_LaserOutSize5() {
        return flag_express_LaserOutSize5;
    }

    public void setFlag_express_LaserOutSize5(Long flag_express_LaserOutSize5) {
        this.flag_express_LaserOutSize5 = flag_express_LaserOutSize5;
    }

    public Long getFlag_express_LaserOutSize6() {
        return flag_express_LaserOutSize6;
    }

    public void setFlag_express_LaserOutSize6(Long flag_express_LaserOutSize6) {
        this.flag_express_LaserOutSize6 = flag_express_LaserOutSize6;
    }

    public Long getFlag_express_LaserOutSize7() {
        return flag_express_LaserOutSize7;
    }

    public void setFlag_express_LaserOutSize7(Long flag_express_LaserOutSize7) {
        this.flag_express_LaserOutSize7 = flag_express_LaserOutSize7;
    }

    public Long getFlag_express_LaserOutSize8() {
        return flag_express_LaserOutSize8;
    }

    public void setFlag_express_LaserOutSize8(Long flag_express_LaserOutSize8) {
        this.flag_express_LaserOutSize8 = flag_express_LaserOutSize8;
    }

    public Long getFlag_express_LaserOutSize9() {
        return flag_express_LaserOutSize9;
    }

    public void setFlag_express_LaserOutSize9(Long flag_express_LaserOutSize9) {
        this.flag_express_LaserOutSize9 = flag_express_LaserOutSize9;
    }

    public Long getFlag_express_LaserOutSize10() {
        return flag_express_LaserOutSize10;
    }

    public void setFlag_express_LaserOutSize10(Long flag_express_LaserOutSize10) {
        this.flag_express_LaserOutSize10 = flag_express_LaserOutSize10;
    }

    public Long getFlag_express_LaserOutSize11() {
        return flag_express_LaserOutSize11;
    }

    public void setFlag_express_LaserOutSize11(Long flag_express_LaserOutSize11) {
        this.flag_express_LaserOutSize11 = flag_express_LaserOutSize11;
    }

    public Long getFlag_express_LaserOutSize12() {
        return flag_express_LaserOutSize12;
    }

    public void setFlag_express_LaserOutSize12(Long flag_express_LaserOutSize12) {
        this.flag_express_LaserOutSize12 = flag_express_LaserOutSize12;
    }

    public Long getFlag_express_LaserOutSize13() {
        return flag_express_LaserOutSize13;
    }

    public void setFlag_express_LaserOutSize13(Long flag_express_LaserOutSize13) {
        this.flag_express_LaserOutSize13 = flag_express_LaserOutSize13;
    }

    public Long getFlag_express_LaserOutSize14() {
        return flag_express_LaserOutSize14;
    }

    public void setFlag_express_LaserOutSize14(Long flag_express_LaserOutSize14) {
        this.flag_express_LaserOutSize14 = flag_express_LaserOutSize14;
    }

    public Long getFlag_express_LaserOutSize15() {
        return flag_express_LaserOutSize15;
    }

    public void setFlag_express_LaserOutSize15(Long flag_express_LaserOutSize15) {
        this.flag_express_LaserOutSize15 = flag_express_LaserOutSize15;
    }

    public Long getFlag_express_LaserOutSize16() {
        return flag_express_LaserOutSize16;
    }

    public void setFlag_express_LaserOutSize16(Long flag_express_LaserOutSize16) {
        this.flag_express_LaserOutSize16 = flag_express_LaserOutSize16;
    }

    public Long getFlag_express_LaserOutSize17() {
        return flag_express_LaserOutSize17;
    }

    public void setFlag_express_LaserOutSize17(Long flag_express_LaserOutSize17) {
        this.flag_express_LaserOutSize17 = flag_express_LaserOutSize17;
    }

    public Long getFlag_express_LaserOutSize18() {
        return flag_express_LaserOutSize18;
    }

    public void setFlag_express_LaserOutSize18(Long flag_express_LaserOutSize18) {
        this.flag_express_LaserOutSize18 = flag_express_LaserOutSize18;
    }

    public Long getFlag_express_LaserOutSize1T() {
        return flag_express_LaserOutSize1T;
    }

    public void setFlag_express_LaserOutSize1T(Long flag_express_LaserOutSize1T) {
        this.flag_express_LaserOutSize1T = flag_express_LaserOutSize1T;
    }

    public Long getFlag_express_LaserOutSize2T() {
        return flag_express_LaserOutSize2T;
    }

    public void setFlag_express_LaserOutSize2T(Long flag_express_LaserOutSize2T) {
        this.flag_express_LaserOutSize2T = flag_express_LaserOutSize2T;
    }

    public Long getFlag_express_LaserOutSize3T() {
        return flag_express_LaserOutSize3T;
    }

    public void setFlag_express_LaserOutSize3T(Long flag_express_LaserOutSize3T) {
        this.flag_express_LaserOutSize3T = flag_express_LaserOutSize3T;
    }

    public Long getFlag_express_LaserOutSize4T() {
        return flag_express_LaserOutSize4T;
    }

    public void setFlag_express_LaserOutSize4T(Long flag_express_LaserOutSize4T) {
        this.flag_express_LaserOutSize4T = flag_express_LaserOutSize4T;
    }

    public Long getFlag_express_LaserOutSize5T() {
        return flag_express_LaserOutSize5T;
    }

    public void setFlag_express_LaserOutSize5T(Long flag_express_LaserOutSize5T) {
        this.flag_express_LaserOutSize5T = flag_express_LaserOutSize5T;
    }

    public Long getFlag_express_LaserOutSize6T() {
        return flag_express_LaserOutSize6T;
    }

    public void setFlag_express_LaserOutSize6T(Long flag_express_LaserOutSize6T) {
        this.flag_express_LaserOutSize6T = flag_express_LaserOutSize6T;
    }

    public Long getFlag_express_LaserOutSize7T() {
        return flag_express_LaserOutSize7T;
    }

    public void setFlag_express_LaserOutSize7T(Long flag_express_LaserOutSize7T) {
        this.flag_express_LaserOutSize7T = flag_express_LaserOutSize7T;
    }

    public Long getFlag_express_LaserOutSize8T() {
        return flag_express_LaserOutSize8T;
    }

    public void setFlag_express_LaserOutSize8T(Long flag_express_LaserOutSize8T) {
        this.flag_express_LaserOutSize8T = flag_express_LaserOutSize8T;
    }

    public Long getFlag_express_LaserOutSize9T() {
        return flag_express_LaserOutSize9T;
    }

    public void setFlag_express_LaserOutSize9T(Long flag_express_LaserOutSize9T) {
        this.flag_express_LaserOutSize9T = flag_express_LaserOutSize9T;
    }

    public Long getFlag_express_LaserOutSize10T() {
        return flag_express_LaserOutSize10T;
    }

    public void setFlag_express_LaserOutSize10T(Long flag_express_LaserOutSize10T) {
        this.flag_express_LaserOutSize10T = flag_express_LaserOutSize10T;
    }

    public Long getFlag_express_LaserOutSize11T() {
        return flag_express_LaserOutSize11T;
    }

    public void setFlag_express_LaserOutSize11T(Long flag_express_LaserOutSize11T) {
        this.flag_express_LaserOutSize11T = flag_express_LaserOutSize11T;
    }

    public Long getFlag_express_LaserOutSize12T() {
        return flag_express_LaserOutSize12T;
    }

    public void setFlag_express_LaserOutSize12T(Long flag_express_LaserOutSize12T) {
        this.flag_express_LaserOutSize12T = flag_express_LaserOutSize12T;
    }

    public Long getFlag_express_LaserOutSize13T() {
        return flag_express_LaserOutSize13T;
    }

    public void setFlag_express_LaserOutSize13T(Long flag_express_LaserOutSize13T) {
        this.flag_express_LaserOutSize13T = flag_express_LaserOutSize13T;
    } 
    
}
