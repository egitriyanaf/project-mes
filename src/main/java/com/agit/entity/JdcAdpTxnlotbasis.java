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
 * @author erwin
 */
@Entity
@Table(name = "jdcadp_txnlotbasis")
public class JdcAdpTxnlotbasis implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4766966230697392291L;

    @Id
    @SequenceGenerator(name = "seq_lot", sequenceName = "seq_lot", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_lot")
    @Column(name = "lot_id")
    private Long id;

    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    private Date createDate;

    @Column(name = "created_by")
    private Long createBy;

    @ManyToOne
    @JoinColumn(name = "created_by", insertable = false, nullable = false, updatable = false)
    private JdcAdpMstUser user;

    @Column(name = "last_updated_date")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    private Date updateDate;

    @Column(name = "last_updated_by")
    private Long updateBy;

    @Column(name = "hourly")
    private Long hourly;

    @Column(name = "Size_1")
    private Long Size1;

    @Column(name = "flag_ct_in_size_1")
    private Long flagCtInSize1;

    @Column(name = "flag_ct_out_size_1")
    private Long flagCtOutSize1;
    
    @Column(name = "flag_express_ct_in_size_1")
    private long flagExpressCtInSize1;
    
    @Column(name = "flag_express_ct_out_size_1")
    private long flagExpressCtOutSize1;

    @Column(name = "flag_prep_in_size_1")
    private Long flagPrepInSize1;

    @Column(name = "flag_prep_out_size_1")
    private Long flagPrepOutSize1;
    
    @Column(name = "flag_express_prep_in_size_1")
    private Long flagExpressPrepInSize1;
    
    @Column(name = "flag_express_prep_out_size_1")
    private Long flagExpressPrepOutSize1;

    @Column(name = "flag_st_in_size_1")
    private Long flagStInSize1;

    @Column(name = "flag_st_out_size_1")
    private Long flagStOutSize1;
    
    @Column(name = "flag_express_st_in_size_1")
    private Long flagExpressStInSize1;
    
    @Column(name = "flag_express_st_out_size_1")
    private Long flagExpressStOutSize1;

    @Column(name = "flag_as_in_size_1")
    private Long flagAsInSize1;

    @Column(name = "flag_as_out_size_1")
    private Long flagAsOutSize1;
    
    @Column(name = "flag_express_as_in_size_1")
    private Long flagExpressAsInSize1;
    
    @Column(name = "flag_express_as_out_size_1")
    private Long flagExpressAsOutSize1;

    @Column(name = "flag_sc_in_size_1")
    private Long flagScInSize1;

    @Column(name = "flag_sc_out_size_1")
    private Long flagScOutSize1;
    
    @Column(name = "flag_express_sc_in_size_1")
    private Long flagExpressScInSize1;
    
    @Column(name = "flag_express_sc_out_size_1")
    private Long flagExpressScOutSize1;

    @Column(name = "flag_ns_in_size_1")
    private Long flagNsInSize1;

    @Column(name = "flag_ns_out_size_1")
    private Long flagNsOutSize1;

    @Column(name = "flag_express_ns_in_size_1")
    private Long flagExpressNsInSize1;
    
    @Column(name = "flag_express_ns_out_size_1")
    private Long flagExpressNsOutSize1;

    @Column(name = "flag_csc_in_size_1")
    private Long flagCscInSize1;

    @Column(name = "flag_csc_out_size_1")
    private Long flagCscOutSize1;
    
    @Column(name = "flag_express_csc_in_size_1")
    private Long flagExpressCscInSize1;
    
    @Column(name = "flag_express_csc_out_size_1")
    private Long flagExpressCscOutSize1;

    @Column(name = "flag_os_in_size_1")
    private Long flagOsInSize1;

    @Column(name = "flag_os_out_size_1")
    private Long flagOsOutSize1;

    @Column(name = "flag_express_os_in_size_1")
    private Long flagExpressOsInSize1;
    
    @Column(name = "flag_express_os_out_size_1")
    private Long flagExpressOsOutSize1;

    @Column(name = "flag_spcut_in_size_1")
    private Long flagspcutInSize1;
    @Column(name = "flag_spcut_out_size_1")
    private Long flagspcutOutSize1;
    
    @Column(name = "flag_express_spcut_in_size_1")
    private Long flagExpressSpcutInSize1;
    @Column(name = "flag_express_spcut_out_size_1")
    private Long flagExpressSpcutOutSize1;

    @Column(name = "flag_spprep_in_size_1")
    private Long flagspprepInSize1;
    @Column(name = "flag_spprep_out_size_1")
    private Long flagspprepOutSize1;

    @Column(name = "flag_express_spprep_in_size_1")
    private Long flagExpressSpprepInSize1;
    @Column(name = "flag_express_spprep_out_size_1")
    private Long flagExpressSpprepOutSize1;

    @Column(name = "Size_1_t")
    private Long Size1T;

    @Column(name = "flag_ct_in_size_1_t")
    private Long flagCtInSize1T;
    @Column(name = "flag_ct_out_size_1_t")
    private Long flagCtOutSize1T;
    
    @Column(name = "flag_express_ct_in_size_1_t")
    private Long flagExpressCtInSize1T;
    @Column(name = "flag_express_ct_out_size_1_t")
    private Long flagExpressCtOutSize1T;

    @Column(name = "flag_prep_in_size_1_t")
    private Long flagPrepInSize1T;
    @Column(name = "flag_prep_out_size_1_t")
    private Long flagPrepOutSize1T;

    @Column(name = "flag_express_prep_in_size_1_t")
    private Long flagExpressPrepInSize1T;
    @Column(name = "flag_express_prep_out_size_1_t")
    private Long flagExpressPrepOutSize1T;

    @Column(name = "flag_st_in_size_1_t")
    private Long flagStInSize1T;
    @Column(name = "flag_st_out_size_1_t")
    private Long flagStOutSize1T;

    @Column(name = "flag_express_st_in_size_1_t")
    private Long flagExpressStInSize1T;
    @Column(name = "flag_express_st_out_size_1_t")
    private Long flagExpressStOutSize1T;

    @Column(name = "flag_as_in_size_1_t")
    private Long flagAsInSize1T;
    @Column(name = "flag_as_out_size_1_t")
    private Long flagAsOutSize1T;
    
    @Column(name = "flag_express_as_in_size_1_t")
    private Long flagExpressAsInSize1T;
    @Column(name = "flag_express_as_out_size_1_t")
    private Long flagExpressAsOutSize1T;

    @Column(name = "flag_sc_in_size_1_t")
    private Long flagScInSize1T;
    @Column(name = "flag_sc_out_size_1_t")
    private Long flagScOutSize1T;

    @Column(name = "flag_express_sc_in_size_1_t")
    private Long flagExpressScInSize1T;
    @Column(name = "flag_express_sc_out_size_1_t")
    private Long flagExpressScOutSize1T;

    @Column(name = "flag_ns_in_size_1_t")
    private Long flagNsInSize1T;
    @Column(name = "flag_ns_out_size_1_t")
    private Long flagNsOutSize1T;
    
    @Column(name = "flag_express_ns_in_size_1_t")
    private Long flagExpressNsInSize1T;
    @Column(name = "flag_express_ns_out_size_1_t")
    private Long flagExpressNsOutSize1T;
    
    @Column(name = "flag_csc_in_size_1_t")
    private Long flagCscInSize1T;
    @Column(name = "flag_csc_out_size_1_t")
    private Long flagCscOutSize1T;

    @Column(name = "flag_express_csc_in_size_1_t")
    private Long flagExpressCscInSize1T;
    @Column(name = "flag_express_csc_out_size_1_t")
    private Long flagExpressCscOutSize1T;

    @Column(name = "flag_os_in_size_1_t")
    private Long flagOsInSize1T;
    @Column(name = "flag_os_out_size_1_t")
    private Long flagOsOutSize1T;
    
    @Column(name = "flag_express_os_in_size_1_t")
    private Long flagExpressOsInSize1T;
    @Column(name = "flag_express_os_out_size_1_t")
    private Long flagExpressOsOutSize1T;

    @Column(name = "flag_spcut_in_size_1_t")
    private Long flagspcutInSize1T;
    @Column(name = "flag_spcut_out_size_1_t")
    private Long flagspcutOutSize1T;
    
    @Column(name = "flag_express_spcut_in_size_1_t")
    private Long flagExpressSpcutInSize1T;
    @Column(name = "flag_express_spcut_out_size_1_t")
    private Long flagExpressSpcutOutSize1T;

    @Column(name = "flag_spprep_in_size_1_t")
    private Long flagspprepInSize1T;
    @Column(name = "flag_spprep_out_size_1_t")
    private Long flagspprepOutSize1T;
    
    @Column(name = "flag_express_spprep_in_size_1_t")
    private Long flagExpressSpprepInSize1T;
    @Column(name = "flag_express_spprep_out_size_1_t")
    private Long flagExpressSpprepOutSize1T;

    @Column(name = "Size_2")
    private Long Size2;

    @Column(name = "flag_ct_in_size_2")
    private Long flagCtInSize2;
    @Column(name = "flag_ct_out_size_2")
    private Long flagCtOutSize2;

    @Column(name = "flag_express_ct_in_size_2")
    private Long flagExpressCtInSize2;
    @Column(name = "flag_express_ct_out_size_2")
    private Long flagExpressCtOutSize2;
    
    @Column(name = "flag_prep_in_size_2")
    private Long flagPrepInSize2;
    @Column(name = "flag_prep_out_size_2")
    private Long flagPrepOutSize2;
    
    @Column(name = "flag_express_prep_in_size_2")
    private Long flagExpressPrepInSize2;
    @Column(name = "flag_express_prep_out_size_2")
    private Long flagExpressPrepOutSize2;
    

    @Column(name = "flag_st_in_size_2")
    private Long flagStInSize2;
    @Column(name = "flag_st_out_size_2")
    private Long flagStOutSize2;
    
    @Column(name = "flag_express_st_in_size_2")
    private Long flagExpressStInSize2;
    @Column(name = "flag_express_st_out_size_2")
    private Long flagExpressStOutSize2;
    
    @Column(name = "flag_as_in_size_2")
    private Long flagAsInSize2;
    @Column(name = "flag_as_out_size_2")
    private Long flagAsOutSize2;

    @Column(name = "flag_express_as_in_size_2")
    private Long flagExpressAsInSize2;
    @Column(name = "flag_express_as_out_size_2")
    private Long flagExpressAsOutSize2;
    
    @Column(name = "flag_sc_in_size_2")
    private Long flagScInSize2;
    @Column(name = "flag_sc_out_size_2")
    private Long flagScOutSize2;
    
    @Column(name = "flag_express_sc_in_size_2")
    private Long flagExpressScInSize2;
    @Column(name = "flag_express_sc_out_size_2")
    private Long flagExpressScOutSize2;
    
    @Column(name = "flag_ns_in_size_2")
    private Long flagNsInSize2;
    @Column(name = "flag_ns_out_size_2")
    private Long flagNsOutSize2;
    
    @Column(name = "flag_express_ns_in_size_2")
    private Long flagExpressNsInSize2;
    @Column(name = "flag_express_ns_out_size_2")
    private Long flagExpressNsOutSize2;
    
    @Column(name = "flag_csc_in_size_2")
    private Long flagCscInSize2;
    @Column(name = "flag_csc_out_size_2")
    private Long flagCscOutSize2;

    @Column(name = "flag_express_csc_in_size_2")
    private Long flagExpressCscInSize2;
    @Column(name = "flag_express_csc_out_size_2")
    private Long flagExpressCscOutSize2;
    
    @Column(name = "flag_os_in_size_2")
    private Long flagOsInSize2;
    @Column(name = "flag_os_out_size_2")
    private Long flagOsOutSize2;
    
    @Column(name = "flag_express_os_in_size_2")
    private Long flagExpressOsInSize2;
    @Column(name = "flag_express_os_out_size_2")
    private Long flagExpressOsOutSize2;
   
    @Column(name = "flag_spcut_in_size_2")
    private Long flagspcutInSize2;    
    @Column(name = "flag_spcut_out_size_2")
    private Long flagspcutOutSize2;
    
    @Column(name = "flag_express_spcut_in_size_2")
    private Long flagExpressSpcutInSize2;
    @Column(name = "flag_express_spcut_out_size_2")
    private Long flagExpressSpcutOutSize2;
    
    
    @Column(name = "flag_spprep_in_size_2")
    private Long flagspprepInSize2;
    @Column(name = "flag_spprep_out_size_2")
    private Long flagspprepOutSize2;
    
    @Column(name = "flag_express_spprep_in_size_2")
    private Long flagExpressSpprepInSize2;
    @Column(name = "flag_express_spprep_out_size_2")
    private Long flagExpressSpprepOutSize2;
    
    @Column(name = "Size_2_t")
    private Long Size2T;

    @Column(name = "flag_ct_in_size_2_t")
    private Long flagCtInSize2T;
    @Column(name = "flag_ct_out_size_2_t")
    private Long flagCtOutSize2T;
    
    @Column(name = "flag_express_ct_in_size_2_t")
    private Long flagExpressCtInSize2T;
    @Column(name = "flag_express_ct_out_size_2_t")
    private Long flagExpressCtOutSize2T;

    @Column(name = "flag_prep_in_size_2_t")
    private Long flagPrepInSize2T;
    @Column(name = "flag_prep_out_size_2_t")
    private Long flagPrepOutSize2T;
    
    @Column(name = "flag_express_prep_in_size_2_t")
    private Long flagExpressPrepInSize2T;
    @Column(name = "flag_express_prep_out_size_2_t")
    private Long flagExpressPrepOutSize2T;

    @Column(name = "flag_st_in_size_2_t")
    private Long flagStInSize2T;
    @Column(name = "flag_st_out_size_2_t")
    private Long flagStOutSize2T;
    
    @Column(name = "flag_express_st_in_size_2_t")
    private Long flagExpressStInSize2T;
    @Column(name = "flag_express_st_out_size_2_t")
    private Long flagExpressStOutSize2T;

    @Column(name = "flag_as_in_size_2_t")
    private Long flagAsInSize2T;
    @Column(name = "flag_as_out_size_2_t")
    private Long flagAsOutSize2T;
    
    @Column(name = "flag_express_as_in_size_2_t")
    private Long flagExpressAsInSize2T;
    @Column(name = "flag_express_as_out_size_2_t")
    private Long flagExpressAsOutSize2T;

    @Column(name = "flag_sc_in_size_2_t")
    private Long flagScInSize2T;
    @Column(name = "flag_sc_out_size_2_t")
    private Long flagScOutSize2T;

    @Column(name = "flag_express_sc_in_size_2_t")
    private Long flagExpressScInSize2T;
    @Column(name = "flag_express_sc_out_size_2_t")
    private Long flagExpressScOutSize2T;
    
    @Column(name = "flag_ns_in_size_2_t")
    private Long flagNsInSize2T;
    @Column(name = "flag_ns_out_size_2_t")
    private Long flagNsOutSize2T;

    @Column(name = "flag_express_ns_in_size_2_t")
    private Long flagExpressNsInSize2T;
    @Column(name = "flag_express_ns_out_size_2_t")
    private Long flagExpressNsOutSize2T;
    
    @Column(name = "flag_csc_in_size_2_t")
    private Long flagCscInSize2T;
    @Column(name = "flag_csc_out_size_2_t")
    private Long flagCscOutSize2T;

    @Column(name = "flag_express_csc_in_size_2_t")
    private Long flagExpressCscInSize2T;
    @Column(name = "flag_express_csc_out_size_2_t")
    private Long flagExpressCscOutSize2T;
    
    @Column(name = "flag_os_in_size_2_t")
    private Long flagOsInSize2T;
    @Column(name = "flag_os_out_size_2_t")
    private Long flagOsOutSize2T;

    @Column(name = "flag_express_os_in_size_2_t")
    private Long flagExpressOsInSize2T;
    @Column(name = "flag_express_os_out_size_2_t")
    private Long flagExpressOsOutSize2T;
    
    @Column(name = "flag_spcut_in_size_2_t")
    private Long flagspcutInSize2T;
    @Column(name = "flag_spcut_out_size_2_t")
    private Long flagspcutOutSize2T;
    
    @Column(name = "flag_express_spcut_in_size_2_t")
    private Long flagExpressSpcutInSize2T;
    @Column(name = "flag_express_spcut_out_size_2_t")
    private Long flagExpressSpcutOutSize2T;
    
    @Column(name = "flag_spprep_in_size_2_t")
    private Long flagspprepInSize2T;
    @Column(name = "flag_spprep_out_size_2_t")
    private Long flagspprepOutSize2T;

    @Column(name = "flag_express_spprep_in_size_2_t")
    private Long flagExpressSpprepInSize2T;
    @Column(name = "flag_express_spprep_out_size_2_t")
    private Long flagExpressSpprepOutSize2T;
    
    @Column(name = "Size_3")
    private Long Size3;
    
    @Column(name = "flag_ct_in_size_3")
    private Long flagCtInSize3;
    @Column(name = "flag_ct_out_size_3")
    private Long flagCtOutSize3;

    @Column(name = "flag_Express_ct_in_size_3")
    private Long flagExpressCtInSize3;
    @Column(name = "flag_Express_ct_out_size_3")
    private Long flagExpressCtOutSize3;
    
    @Column(name = "flag_prep_in_size_3")
    private Long flagPrepInSize3;
    @Column(name = "flag_prep_out_size_3")
    private Long flagPrepOutSize3;

    @Column(name = "flag_Express_prep_in_size_3")
    private Long flagExpressPrepInSize3;
    @Column(name = "flag_Express_prep_out_size_3")
    private Long flagExpressPrepOutSize3;
    
    @Column(name = "flag_st_in_size_3")
    private Long flagStInSize3;
    @Column(name = "flag_st_out_size_3")
    private Long flagStOutSize3;
    
    @Column(name = "flag_Express_st_in_size_3")
    private Long flagExpressStInSize3;
    @Column(name = "flag_Express_st_out_size_3")
    private Long flagExpressStOutSize3;
    
    @Column(name = "flag_as_in_size_3")
    private Long flagAsInSize3;
    @Column(name = "flag_as_out_size_3")
    private Long flagAsOutSize3;

    @Column(name = "flag_Express_as_in_size_3")
    private Long flagExpressAsInSize3;
    @Column(name = "flag_Express_as_out_size_3")
    private Long flagExpressAsOutSize3;
    
    @Column(name = "flag_sc_in_size_3")
    private Long flagScInSize3;
    @Column(name = "flag_sc_out_size_3")
    private Long flagScOutSize3;
    
    @Column(name = "flag_Express_sc_in_size_3")
    private Long flagExpressScInSize3;
    @Column(name = "flag_Express_sc_out_size_3")
    private Long flagExpressScOutSize3;
    
    @Column(name = "flag_ns_in_size_3")
    private Long flagNsInSize3;
    @Column(name = "flag_ns_out_size_3")
    private Long flagNsOutSize3;

    @Column(name = "flag_Express_ns_in_size_3")
    private Long flagExpressNsInSize3;
    @Column(name = "flag_Express_ns_out_size_3")
    private Long flagExpressNsOutSize3;
    
    @Column(name = "flag_csc_in_size_3")
    private Long flagCscInSize3;
    @Column(name = "flag_csc_out_size_3")
    private Long flagCscOutSize3;
    
    @Column(name = "flag_Express_csc_in_size_3")
    private Long flagExpressCscInSize3;
    @Column(name = "flag_Express_csc_out_size_3")
    private Long flagExpressCscOutSize3;
    
    @Column(name = "flag_os_in_size_3")
    private Long flagOsInSize3;
    @Column(name = "flag_os_out_size_3")
    private Long flagOsOutSize3;

    @Column(name = "flag_Express_os_in_size_3")
    private Long flagExpressOsInSize3;
    @Column(name = "flag_Express_os_out_size_3")
    private Long flagExpressOsOutSize3;
    
    @Column(name = "flag_spcut_in_size_3")
    private Long flagspcutInSize3;
    @Column(name = "flag_spcut_out_size_3")
    private Long flagspcutOutSize3;
    
    @Column(name = "flag_Express_spcut_in_size_3")
    private Long flagExpressSpcutInSize3;
    @Column(name = "flag_Express_spcut_out_size_3")
    private Long flagExpressSpcutOutSize3;
    
    @Column(name = "flag_spprep_in_size_3")
    private Long flagspprepInSize3;
    @Column(name = "flag_spprep_out_size_3")
    private Long flagspprepOutSize3;
    
    @Column(name = "flag_Express_spprep_in_size_3")
    private Long flagExpressSpprepInSize3;
    @Column(name = "flag_Express_spprep_out_size_3")
    private Long flagExpressSpprepOutSize3;
    
    @Column(name = "Size_3_t")
    private Long Size3T;

    @Column(name = "flag_ct_in_size_3_t")
    private Long flagCtInSize3T;
    @Column(name = "flag_ct_out_size_3_t")
    private Long flagCtOutSize3T;
    
    @Column(name = "flag_express_ct_in_size_3_t")
    private Long flagExpressCtInSize3T;
    @Column(name = "flag_express_ct_out_size_3_t")
    private Long flagExpressCtOutSize3T;

    @Column(name = "flag_prep_in_size_3_t")
    private Long flagPrepInSize3T;
    @Column(name = "flag_prep_out_size_3_t")
    private Long flagPrepOutSize3T;
    
    @Column(name = "flag_express_prep_in_size_3_t")
    private Long flagExpressPrepInSize3T;
    @Column(name = "flag_express_prep_out_size_3_t")
    private Long flagExpressPrepOutSize3T;

    @Column(name = "flag_st_in_size_3_t")
    private Long flagStInSize3T;
    @Column(name = "flag_st_out_size_3_t")
    private Long flagStOutSize3T;
    
    @Column(name = "flag_express_st_in_size_3_t")
    private Long flagExpressStInSize3T;
    @Column(name = "flag_express_st_out_size_3_t")
    private Long flagExpressStOutSize3T;

    @Column(name = "flag_as_in_size_3_t")
    private Long flagAsInSize3T;
    @Column(name = "flag_as_out_size_3_t")
    private Long flagAsOutSize3T;
    
    @Column(name = "flag_express_as_in_size_3_t")
    private Long flagExpressAsInSize3T;
    @Column(name = "flag_express_as_out_size_3_t")
    private Long flagExpressAsOutSize3T;
    
    @Column(name = "flag_sc_in_size_3_t")
    private Long flagScInSize3T;
    @Column(name = "flag_sc_out_size_3_t")
    private Long flagScOutSize3T;
    
    @Column(name = "flag_express_sc_in_size_3_t")
    private Long flagExpressScInSize3T;
    @Column(name = "flag_express_sc_out_size_3_t")
    private Long flagExpressScOutSize3T;


    @Column(name = "flag_ns_in_size_3_t")
    private Long flagNsInSize3T;
    @Column(name = "flag_ns_out_size_3_t")
    private Long flagNsOutSize3T;

    @Column(name = "flag_express_ns_in_size_3_t")
    private Long flagExpressNsInSize3T;
    @Column(name = "flag_express_ns_out_size_3_t")
    private Long flagExpressNsOutSize3T;

    @Column(name = "flag_csc_in_size_3_t")
    private Long flagCscInSize3T;
    @Column(name = "flag_csc_out_size_3_t")
    private Long flagCscOutSize3T;
    
    @Column(name = "flag_express_csc_in_size_3_t")
    private Long flagExpressCscInSize3T;
    @Column(name = "flag_express_csc_out_size_3_t")
    private Long flagExpressCscOutSize3T;

    @Column(name = "flag_os_in_size_3_t")
    private Long flagOsInSize3T;
    @Column(name = "flag_os_out_size_3_t")
    private Long flagOsOutSize3T;

    @Column(name = "flag_express_os_in_size_3_t")
    private Long flagExpressOsInSize3T;
    @Column(name = "flag_express_os_out_size_3_t")
    private Long flagExpressOsOutSize3T;

    @Column(name = "flag_spcut_in_size_3_t")
    private Long flagspcutInSize3T;
    @Column(name = "flag_spcut_out_size_3_t")
    private Long flagspcutOutSize3T;
    
    @Column(name = "flag_express_spcut_in_size_3_t")
    private Long flagExpressSpcutInSize3T;
    @Column(name = "flag_express_spcut_out_size_3_t")
    private Long flagExpressSpcutOutSize3T;

    @Column(name = "flag_spprep_in_size_3_t")
    private Long flagspprepInSize3T;
    @Column(name = "flag_spprep_out_size_3_t")
    private Long flagspprepOutSize3T;
    
    @Column(name = "flag_express_spprep_in_size_3_t")
    private Long flagExpressSpprepInSize3T;
    @Column(name = "flag_express_spprep_out_size_3_t")
    private Long flagExpressSpprepOutSize3T;

    @Column(name = "Size_4")
    private Long Size4;

    @Column(name = "flag_ct_in_size_4")
    private Long flagCtInSize4;
    @Column(name = "flag_ct_out_size_4")
    private Long flagCtOutSize4;
    
    @Column(name = "flag_express_ct_in_size_4")
    private Long flagExpressCtInSize4;
    @Column(name = "flag_express_ct_out_size_4")
    private Long flagExpressCtOutSize4;

    @Column(name = "flag_prep_in_size_4")
    private Long flagPrepInSize4;
    @Column(name = "flag_prep_out_size_4")
    private Long flagPrepOutSize4;
    
    @Column(name = "flag_express_prep_in_size_4")
    private Long flagExpressPrepInSize4;
    @Column(name = "flag_express_prep_out_size_4")
    private Long flagExpressPrepOutSize4;

    @Column(name = "flag_st_in_size_4")
    private Long flagStInSize4;
    @Column(name = "flag_st_out_size_4")
    private Long flagStOutSize4;
    
    @Column(name = "flag_express_st_in_size_4")
    private Long flagExpressStInSize4;
    @Column(name = "flag_express_st_out_size_4")
    private Long flagExpressStOutSize4;

    @Column(name = "flag_as_in_size_4")
    private Long flagAsInSize4;
    @Column(name = "flag_as_out_size_4")
    private Long flagAsOutSize4;
    
    @Column(name = "flag_express_as_in_size_4")
    private Long flagExpressAsInSize4;
    @Column(name = "flag_express_as_out_size_4")
    private Long flagExpressAsOutSize4;

    @Column(name = "flag_sc_in_size_4")
    private Long flagScInSize4;
    @Column(name = "flag_sc_out_size_4")
    private Long flagScOutSize4;
    
    @Column(name = "flag_express_sc_in_size_4")
    private Long flagExpressScInSize4;
    @Column(name = "flag_express_sc_out_size_4")
    private Long flagExpressScOutSize4;

    @Column(name = "flag_ns_in_size_4")
    private Long flagNsInSize4;
    @Column(name = "flag_ns_out_size_4")
    private Long flagNsOutSize4;
    
    @Column(name = "flag_express_ns_in_size_4")
    private Long flagExpressNsInSize4;
    @Column(name = "flag_express_ns_out_size_4")
    private Long flagExpressNsOutSize4;

    @Column(name = "flag_csc_in_size_4")
    private Long flagCscInSize4;
    @Column(name = "flag_csc_out_size_4")
    private Long flagCscOutSize4;
    
    @Column(name = "flag_express_csc_in_size_4")
    private Long flagExpressCscInSize4;
    @Column(name = "flag_express_csc_out_size_4")
    private Long flagExpressCscOutSize4;

    @Column(name = "flag_os_in_size_4")
    private Long flagOsInSize4;
    @Column(name = "flag_os_out_size_4")
    private Long flagOsOutSize4;
    
    @Column(name = "flag_express_os_in_size_4")
    private Long flagExpressOsInSize4;
    @Column(name = "flag_express_os_out_size_4")
    private Long flagExpressOsOutSize4;

    @Column(name = "flag_spcut_in_size_4")
    private Long flagspcutInSize4;
    @Column(name = "flag_spcut_out_size_4")
    private Long flagspcutOutSize4;
    
    @Column(name = "flag_express_spcut_in_size_4")
    private Long flagExpressSpcutInSize4;
    @Column(name = "flag_express_spcut_out_size_4")
    private Long flagExpressSpcutOutSize4;
    
    @Column(name = "flag_spprep_in_size_4")
    private Long flagspprepInSize4;
    @Column(name = "flag_spprep_out_size_4")
    private Long flagspprepOutSize4;
    
    @Column(name = "flag_express_spprep_in_size_4")
    private Long flagExpressSpprepInSize4;
    @Column(name = "flag_express_spprep_out_size_4")
    private Long flagExpressSpprepOutSize4;

    @Column(name = "Size_4_t")
    private Long Size4T;

    @Column(name = "flag_ct_in_size_4_t")
    private Long flagCtInSize4T;
    @Column(name = "flag_ct_out_size_4_t")
    private Long flagCtOutSize4T;

    @Column(name = "flag_express_ct_in_size_4_t")
    private Long flagExpressCtInSize4T;
    @Column(name = "flag_express_ct_out_size_4_t")
    private Long flagExpressCtOutSize4T;
    
    @Column(name = "flag_prep_in_size_4_t")
    private Long flagPrepInSize4T;
    @Column(name = "flag_prep_out_size_4_t")
    private Long flagPrepOutSize4T;

    @Column(name = "flag_express_prep_in_size_4_t")
    private Long flagExpressPrepInSize4T;
    @Column(name = "flag_express_prep_out_size_4_t")
    private Long flagExpressPrepOutSize4T;
    
    @Column(name = "flag_st_in_size_4_t")
    private Long flagStInSize4T;
    @Column(name = "flag_st_out_size_4_t")
    private Long flagStOutSize4T;
    
    @Column(name = "flag_express_st_in_size_4_t")
    private Long flagExpressStInSize4T;
    @Column(name = "flag_express_st_out_size_4_t")
    private Long flagExpressStOutSize4T;

    @Column(name = "flag_as_in_size_4_t")
    private Long flagAsInSize4T;
    @Column(name = "flag_as_out_size_4_t")
    private Long flagAsOutSize4T;
    
    @Column(name = "flag_express_as_in_size_4_t")
    private Long flagExpressAsInSize4T;
    @Column(name = "flag_express_as_out_size_4_t")
    private Long flagExpressAsOutSize4T;

    @Column(name = "flag_sc_in_size_4_t")
    private Long flagScInSize4T;
    @Column(name = "flag_sc_out_size_4_t")
    private Long flagScOutSize4T;

    @Column(name = "flag_express_sc_in_size_4_t")
    private Long flagExpressScInSize4T;
    @Column(name = "flag_express_sc_out_size_4_t")
    private Long flagExpressScOutSize4T;
    
    @Column(name = "flag_ns_in_size_4_t")
    private Long flagNsInSize4T;
    @Column(name = "flag_ns_out_size_4_t")
    private Long flagNsOutSize4T;

    @Column(name = "flag_express_ns_in_size_4_t")
    private Long flagExpressNsInSize4T;
    @Column(name = "flag_express_ns_out_size_4_t")
    private Long flagExpressNsOutSize4T;
    
    @Column(name = "flag_csc_in_size_4_t")
    private Long flagCscInSize4T;
    @Column(name = "flag_csc_out_size_4_t")
    private Long flagCscOutSize4T;

    @Column(name = "flag_express_csc_in_size_4_t")
    private Long flagExpressCscInSize4T;
    @Column(name = "flag_express_csc_out_size_4_t")
    private Long flagExpressCscOutSize4T;
    
    @Column(name = "flag_os_in_size_4_t")
    private Long flagOsInSize4T;
    @Column(name = "flag_os_out_size_4_t")
    private Long flagOsOutSize4T;

    @Column(name = "flag_express_os_in_size_4_t")
    private Long flagExpressOsInSize4T;
    @Column(name = "flag_express_os_out_size_4_t")
    private Long flagExpressOsOutSize4T;
    
    @Column(name = "flag_spcut_in_size_4_t")
    private Long flagspcutInSize4T;
    @Column(name = "flag_spcut_out_size_4_t")
    private Long flagspcutOutSize4T;
    
    @Column(name = "flag_express_spcut_in_size_4_t")
    private Long flagExpressSpcutInSize4T;
    @Column(name = "flag_express_spcut_out_size_4_t")
    private Long flagExpressSpcutOutSize4T;
    
    @Column(name = "flag_spprep_in_size_4_t")
    private Long flagspprepInSize4T;
    @Column(name = "flag_spprep_out_size_4_t")
    private Long flagspprepOutSize4T;

    @Column(name = "flag_express_spprep_in_size_4_t")
    private Long flagExpressSpprepInSize4T;
    @Column(name = "flag_express_spprep_out_size_4_t")
    private Long flagExpressSpprepOutSize4T;
    
    @Column(name = "Size_5")
    private Long Size5;

    @Column(name = "flag_ct_in_size_5")
    private Long flagCtInSize5;
    @Column(name = "flag_ct_out_size_5")
    private Long flagCtOutSize5;
    
    @Column(name = "flag_express_ct_in_size_5")
    private Long flagExpressCtInSize5;
    @Column(name = "flag_express_ct_out_size_5")
    private Long flagExpressCtOutSize5;

    @Column(name = "flag_prep_in_size_5")
    private Long flagPrepInSize5;
    @Column(name = "flag_prep_out_size_5")
    private Long flagPrepOutSize5;
    
    @Column(name = "flag_express_prep_in_size_5")
    private Long flagExpressPrepInSize5;
    @Column(name = "flag_express_prep_out_size_5")
    private Long flagExpressPrepOutSize5;

    @Column(name = "flag_st_in_size_5")
    private Long flagStInSize5;
    @Column(name = "flag_st_out_size_5")
    private Long flagStOutSize5;
    
    @Column(name = "flag_express_st_in_size_5")
    private Long flagExpressStInSize5;
    @Column(name = "flag_express_st_out_size_5")
    private Long flagExpressStOutSize5;

    @Column(name = "flag_as_in_size_5")
    private Long flagAsInSize5;
    @Column(name = "flag_as_out_size_5")
    private Long flagAsOutSize5;
    
    @Column(name = "flag_express_as_in_size_5")
    private Long flagExpressAsInSize5;
    @Column(name = "flag_express_as_out_size_5")
    private Long flagExpressAsOutSize5;

    @Column(name = "flag_sc_in_size_5")
    private Long flagScInSize5;
    @Column(name = "flag_sc_out_size_5")
    private Long flagScOutSize5;

    @Column(name = "flag_express_sc_in_size_5")
    private Long flagExpressScInSize5;
    @Column(name = "flag_express_sc_out_size_5")
    private Long flagExpressScOutSize5;
    
    @Column(name = "flag_ns_in_size_5")
    private Long flagNsInSize5;
    @Column(name = "flag_ns_out_size_5")
    private Long flagNsOutSize5;
    
    @Column(name = "flag_express_ns_in_size_5")
    private Long flagExpressNsInSize5;
    @Column(name = "flag_express_ns_out_size_5")
    private Long flagExpressNsOutSize5;

    @Column(name = "flag_csc_in_size_5")
    private Long flagCscInSize5;
    @Column(name = "flag_csc_out_size_5")
    private Long flagCscOutSize5;

    @Column(name = "flag_express_csc_in_size_5")
    private Long flagExpressCscInSize5;
    @Column(name = "flag_express_csc_out_size_5")
    private Long flagExpressCscOutSize5;
    
    @Column(name = "flag_os_in_size_5")
    private Long flagOsInSize5;
    @Column(name = "flag_os_out_size_5")
    private Long flagOsOutSize5;
    
    @Column(name = "flag_express_os_in_size_5")
    private Long flagExpressOsInSize5;
    @Column(name = "flag_express_os_out_size_5")
    private Long flagExpressOsOutSize5;

    @Column(name = "flag_spcut_in_size_5")
    private Long flagspcutInSize5;
    @Column(name = "flag_spcut_out_size_5")
    private Long flagspcutOutSize5;
    
    @Column(name = "flag_express_spcut_in_size_5")
    private Long flagExpressSpcutInSize5;
    @Column(name = "flag_express_spcut_out_size_5")
    private Long flagExpressSpcutOutSize5;
    
    @Column(name = "flag_spprep_in_size_5")
    private Long flagspprepInSize5;
    @Column(name = "flag_spprep_out_size_5")
    private Long flagspprepOutSize5;

    @Column(name = "flag_express_spprep_in_size_5")
    private Long flagExpressSpprepInSize5;
    @Column(name = "flag_express_spprep_out_size_5")
    private Long flagExpressSpprepOutSize5;
    
    @Column(name = "Size_5_t")
    private Long Size5T;
    
    @Column(name = "flag_ct_in_size_5_t")
    private Long flagCtInSize5T;
    @Column(name = "flag_ct_out_size_5_t")
    private Long flagCtOutSize5T;
    
    @Column(name = "flag_express_ct_in_size_5_t")
    private Long flagExpressCtInSize5T;
    @Column(name = "flag_express_ct_out_size_5_t")
    private Long flagExpressCtOutSize5T;

    @Column(name = "flag_prep_in_size_5_t")
    private Long flagPrepInSize5T;
    @Column(name = "flag_prep_out_size_5_t")
    private Long flagPrepOutSize5T;
    
    @Column(name = "flag_express_prep_in_size_5_t")
    private Long flagExpressPrepInSize5T;
    @Column(name = "flag_express_prep_out_size_5_t")
    private Long flagExpressPrepOutSize5T;

    @Column(name = "flag_st_in_size_5_t")
    private Long flagStInSize5T;
    @Column(name = "flag_st_out_size_5_t")
    private Long flagStOutSize5T;
    
    @Column(name = "flag_express_st_in_size_5_t")
    private Long flagExpressStInSize5T;
    @Column(name = "flag_express_st_out_size_5_t")
    private Long flagExpressStOutSize5T;

    @Column(name = "flag_as_in_size_5_t")
    private Long flagAsInSize5T;
    @Column(name = "flag_as_out_size_5_t")
    private Long flagAsOutSize5T;
    
    @Column(name = "flag_express_as_in_size_5_t")
    private Long flagExpressAsInSize5T;
    @Column(name = "flag_express_as_out_size_5_t")
    private Long flagExpressAsOutSize5T;

    @Column(name = "flag_sc_in_size_5_t")
    private Long flagScInSize5T;
    @Column(name = "flag_sc_out_size_5_t")
    private Long flagScOutSize5T;
    
    @Column(name = "flag_express_sc_in_size_5_t")
    private Long flagExpressScInSize5T;
    @Column(name = "flag_express_sc_out_size_5_t")
    private Long flagExpressScOutSize5T;

    @Column(name = "flag_ns_in_size_5_t")
    private Long flagNsInSize5T;
    @Column(name = "flag_ns_out_size_5_t")
    private Long flagNsOutSize5T;

    @Column(name = "flag_express_ns_in_size_5_t")
    private Long flagExpressNsInSize5T;
    @Column(name = "flag_express_ns_out_size_5_t")
    private Long flagExpressNsOutSize5T;
    
    @Column(name = "flag_csc_in_size_5_t")
    private Long flagCscInSize5T;
    @Column(name = "flag_csc_out_size_5_t")
    private Long flagCscOutSize5T;
    
    @Column(name = "flag_express_csc_in_size_5_t")
    private Long flagExpressCscInSize5T;
    @Column(name = "flag_express_csc_out_size_5_t")
    private Long flagExpressCscOutSize5T;

    @Column(name = "flag_os_in_size_5_t")
    private Long flagOsInSize5T;
    @Column(name = "flag_os_out_size_5_t")
    private Long flagOsOutSize5T;
    
    @Column(name = "flag_express_os_in_size_5_t")
    private Long flagExpressOsInSize5T;
    @Column(name = "flag_express_os_out_size_5_t")
    private Long flagExpressOsOutSize5T;

    @Column(name = "flag_spcut_in_size_5_t")
    private Long flagspcutInSize5T;
    @Column(name = "flag_spcut_out_size_5_t")
    private Long flagspcutOutSize5T;
    
    @Column(name = "flag_express_spcut_in_size_5_t")
    private Long flagExpressSpcutInSize5T;
    @Column(name = "flag_express_spcut_out_size_5_t")
    private Long flagExpressSpcutOutSize5T;
    
    @Column(name = "flag_spprep_in_size_5_t")
    private Long flagspprepInSize5T;
    @Column(name = "flag_spprep_out_size_5_t")
    private Long flagspprepOutSize5T;
    
    @Column(name = "flag_express_spprep_in_size_5_t")
    private Long flagExpressSpprepInSize5T;
    @Column(name = "flag_express_spprep_out_size_5_t")
    private Long flagExpressSpprepOutSize5T;
    
    @Column(name = "Size_6")
    private Long Size6;

    @Column(name = "flag_ct_in_size_6")
    private Long flagCtInSize6;
    @Column(name = "flag_ct_out_size_6")
    private Long flagCtOutSize6;

    @Column(name = "flag_express_ct_in_size_6")
    private Long flagExpressCtInSize6;
    @Column(name = "flag_express_ct_out_size_6")
    private Long flagExpressCtOutSize6;
    
    @Column(name = "flag_prep_in_size_6")
    private Long flagPrepInSize6;
    @Column(name = "flag_prep_out_size_6")
    private Long flagPrepOutSize6;
    
    @Column(name = "flag_express_prep_in_size_6")
    private Long flagExpressPrepInSize6;
    @Column(name = "flag_express_prep_out_size_6")
    private Long flagExpressPrepOutSize6;

    @Column(name = "flag_st_in_size_6")
    private Long flagStInSize6;
    @Column(name = "flag_st_out_size_6")
    private Long flagStOutSize6;
    
    @Column(name = "flag_express_st_in_size_6")
    private Long flagExpressStInSize6;
    @Column(name = "flag_express_st_out_size_6")
    private Long flagExpressStOutSize6;

    @Column(name = "flag_as_in_size_6")
    private Long flagAsInSize6;
    @Column(name = "flag_as_out_size_6")
    private Long flagAsOutSize6;
    
    @Column(name = "flag_express_as_in_size_6")
    private Long flagExpressAsInSize6;
    @Column(name = "flag_express_as_out_size_6")
    private Long flagExpressAsOutSize6;

    @Column(name = "flag_sc_in_size_6")
    private Long flagScInSize6;
    @Column(name = "flag_sc_out_size_6")
    private Long flagScOutSize6;
    
    @Column(name = "flag_express_sc_in_size_6")
    private Long flagExpressScInSize6;
    @Column(name = "flag_express_sc_out_size_6")
    private Long flagExpressScOutSize6;

    @Column(name = "flag_ns_in_size_6")
    private Long flagNsInSize6;
    @Column(name = "flag_ns_out_size_6")
    private Long flagNsOutSize6;
    
    @Column(name = "flag_express_ns_in_size_6")
    private Long flagExpressNsInSize6;
    @Column(name = "flag_express_ns_out_size_6")
    private Long flagExpressNsOutSize6;

    @Column(name = "flag_csc_in_size_6")
    private Long flagCscInSize6;
    @Column(name = "flag_csc_out_size_6")
    private Long flagCscOutSize6;
    
    @Column(name = "flag_express_csc_in_size_6")
    private Long flagExpressCscInSize6;
    @Column(name = "flag_express_csc_out_size_6")
    private Long flagExpressCscOutSize6;

    @Column(name = "flag_os_in_size_6")
    private Long flagOsInSize6;
    @Column(name = "flag_os_out_size_6")
    private Long flagOsOutSize6;

    @Column(name = "flag_express_os_in_size_6")
    private Long flagExpressOsInSize6;
    @Column(name = "flag_express_os_out_size_6")
    private Long flagExpressOsOutSize6;
    
    @Column(name = "flag_spcut_in_size_6")
    private Long flagspcutInSize6;
    @Column(name = "flag_spcut_out_size_6")
    private Long flagspcutOutSize6;
    
    @Column(name = "flag_express_spcut_in_size_6")
    private Long flagExpressSpcutInSize6;
    @Column(name = "flag_express_spcut_out_size_6")
    private Long flagExpressSpcutOutSize6;
    
    @Column(name = "flag_spprep_in_size_6")
    private Long flagspprepInSize6;
    @Column(name = "flag_spprep_out_size_6")
    private Long flagspprepOutSize6;
    
    @Column(name = "flag_express_spprep_in_size_6")
    private Long flagExpressSpprepInSize6;
    @Column(name = "flag_express_spprep_out_size_6")
    private Long flagExpressSpprepOutSize6;

    @Column(name = "Size_6_t")
    private Long Size6T;

    @Column(name = "flag_ct_in_size_6_t")
    private Long flagCtInSize6T;
    @Column(name = "flag_ct_out_size_6_t")
    private Long flagCtOutSize6T;
    
    @Column(name = "flag_express_ct_in_size_6_t")
    private Long flagExpressCtInSize6T;
    @Column(name = "flag_express_ct_out_size_6_t")
    private Long flagExpressCtOutSize6T;

    @Column(name = "flag_prep_in_size_6_t")
    private Long flagPrepInSize6T;
    @Column(name = "flag_prep_out_size_6_t")
    private Long flagPrepOutSize6T;
    
    @Column(name = "flag_express_prep_in_size_6_t")
    private Long flagExpressPrepInSize6T;
    @Column(name = "flag_express_prep_out_size_6_t")
    private Long flagExpressPrepOutSize6T;

    @Column(name = "flag_st_in_size_6_t")
    private Long flagStInSize6T;
    @Column(name = "flag_st_out_size_6_t")
    private Long flagStOutSize6T;
    
    @Column(name = "flag_express_st_in_size_6_t")
    private Long flagExpressStInSize6T;
    @Column(name = "flag_express_st_out_size_6_t")
    private Long flagExpressStOutSize6T;

    @Column(name = "flag_as_in_size_6_t")
    private Long flagAsInSize6T;
    @Column(name = "flag_as_out_size_6_t")
    private Long flagAsOutSize6T;
    
    @Column(name = "flag_express_as_in_size_6_t")
    private Long flagExpressAsInSize6T;
    @Column(name = "flag_express_as_out_size_6_t")
    private Long flagExpressAsOutSize6T;

    @Column(name = "flag_sc_in_size_6_t")
    private Long flagScInSize6T;
    @Column(name = "flag_sc_out_size_6_t")
    private Long flagScOutSize6T;
    
    @Column(name = "flag_express_sc_in_size_6_t")
    private Long flagExpressScInSize6T;
    @Column(name = "flag_express_sc_out_size_6_t")
    private Long flagExpressScOutSize6T;

    @Column(name = "flag_ns_in_size_6_t")
    private Long flagNsInSize6T;
    @Column(name = "flag_ns_out_size_6_t")
    private Long flagNsOutSize6T;
    
    @Column(name = "flag_express_ns_in_size_6_t")
    private Long flagExpressNsInSize6T;
    @Column(name = "flag_express_ns_out_size_6_t")
    private Long flagExpressNsOutSize6T;

    @Column(name = "flag_csc_in_size_6_t")
    private Long flagCscInSize6T;
    @Column(name = "flag_csc_out_size_6_t")
    private Long flagCscOutSize6T;
    
    @Column(name = "flag_express_csc_in_size_6_t")
    private Long flagExpressCscInSize6T;
    @Column(name = "flag_express_csc_out_size_6_t")
    private Long flagExpressCscOutSize6T;

    @Column(name = "flag_os_in_size_6_t")
    private Long flagOsInSize6T;
    @Column(name = "flag_os_out_size_6_t")
    private Long flagOsOutSize6T;
    
    @Column(name = "flag_express_os_in_size_6_t")
    private Long flagExpressOsInSize6T;
    @Column(name = "flag_express_os_out_size_6_t")
    private Long flagExpressOsOutSize6T;

    @Column(name = "flag_spcut_in_size_6_t")
    private Long flagspcutInSize6T;
    @Column(name = "flag_spcut_out_size_6_t")
    private Long flagspcutOutSize6T;
    
    @Column(name = "flag_express_spcut_in_size_6_t")
    private Long flagExpressSpcutInSize6T;
    @Column(name = "flag_express_spcut_out_size_6_t")
    private Long flagExpressSpcutOutSize6T;
    
    @Column(name = "flag_spprep_in_size_6_t")
    private Long flagspprepInSize6T;
    @Column(name = "flag_spprep_out_size_6_t")
    private Long flagspprepOutSize6T;

    @Column(name = "flag_express_spprep_in_size_6_t")
    private Long flagExpressSpprepInSize6T;
    @Column(name = "flag_express_spprep_out_size_6_t")
    private Long flagExpressSpprepOutSize6T;
    
    @Column(name = "Size_7")
    private Long Size7;
    
    @Column(name = "flag_ct_in_size_7")
    private Long flagCtInSize7;
    @Column(name = "flag_ct_out_size_7")
    private Long flagCtOutSize7;
    
    @Column(name = "flag_express_ct_in_size_7")
    private Long flagExpressCtInSize7;
    @Column(name = "flag_express_ct_out_size_7")
    private Long flagExpressCtOutSize7;

    @Column(name = "flag_prep_in_size_7")
    private Long flagPrepInSize7;
    @Column(name = "flag_prep_out_size_7")
    private Long flagPrepOutSize7;
    
    @Column(name = "flag_express_prep_in_size_7")
    private Long flagExpressPrepInSize7;
    @Column(name = "flag_express_prep_out_size_7")
    private Long flagExpressPrepOutSize7;

    @Column(name = "flag_st_in_size_7")
    private Long flagStInSize7;
    @Column(name = "flag_st_out_size_7")
    private Long flagStOutSize7;
    
    @Column(name = "flag_express_st_in_size_7")
    private Long flagExpressStInSize7;
    @Column(name = "flag_express_st_out_size_7")
    private Long flagExpressStOutSize7;

    @Column(name = "flag_as_in_size_7")
    private Long flagAsInSize7;
    @Column(name = "flag_as_out_size_7")
    private Long flagAsOutSize7;
    
    @Column(name = "flag_express_as_in_size_7")
    private Long flagExpressAsInSize7;
    @Column(name = "flag_express_as_out_size_7")
    private Long flagExpressAsOutSize7;

    @Column(name = "flag_sc_in_size_7")
    private Long flagScInSize7;
    @Column(name = "flag_sc_out_size_7")
    private Long flagScOutSize7;
    
    @Column(name = "flag_express_sc_in_size_7")
    private Long flagExpressScInSize7;
    @Column(name = "flag_express_sc_out_size_7")
    private Long flagExpressScOutSize7;

    @Column(name = "flag_ns_in_size_7")
    private Long flagNsInSize7;
    @Column(name = "flag_ns_out_size_7")
    private Long flagNsOutSize7;
    
    @Column(name = "flag_express_ns_in_size_7")
    private Long flagExpressNsInSize7;
    @Column(name = "flag_express_ns_out_size_7")
    private Long flagExpressNsOutSize7;

    @Column(name = "flag_csc_in_size_7")
    private Long flagCscInSize7;
    @Column(name = "flag_csc_out_size_7")
    private Long flagCscOutSize7;
    
    @Column(name = "flag_express_csc_in_size_7")
    private Long flagExpressCscInSize7;
    @Column(name = "flag_express_csc_out_size_7")
    private Long flagExpressCscOutSize7;

    @Column(name = "flag_os_in_size_7")
    private Long flagOsInSize7;
    @Column(name = "flag_os_out_size_7")
    private Long flagOsOutSize7;
    
    @Column(name = "flag_express_os_in_size_7")
    private Long flagExpressOsInSize7;
    @Column(name = "flag_express_os_out_size_7")
    private Long flagExpressOsOutSize7;

    @Column(name = "flag_spcut_in_size_7")
    private Long flagspcutInSize7;
    @Column(name = "flag_spcut_out_size_7")
    private Long flagspcutOutSize7;
    
    @Column(name = "flag_express_spcut_in_size_7")
    private Long flagExpressSpcutInSize7;
    @Column(name = "flag_express_spcut_out_size_7")
    private Long flagExpressSpcutOutSize7;
    
    @Column(name = "flag_spprep_in_size_7")
    private Long flagspprepInSize7;
    @Column(name = "flag_spprep_out_size_7")
    private Long flagspprepOutSize7;
    
    @Column(name = "flag_express_spprep_in_size_7")
    private Long flagExpressSpprepInSize7;
    @Column(name = "flag_express_spprep_out_size_7")
    private Long flagExpressSpprepOutSize7;

    @Column(name = "Size_7_t")
    private Long Size7T;

    @Column(name = "flag_ct_in_size_7_t")
    private Long flagCtInSize7T;
    @Column(name = "flag_ct_out_size_7_t")
    private Long flagCtOutSize7T;
    
    @Column(name = "flag_express_ct_in_size_7_t")
    private Long flagExpressCtInSize7T;
    @Column(name = "flag_express_ct_out_size_7_t")
    private Long flagExpressCtOutSize7T;

    @Column(name = "flag_prep_in_size_7_t")
    private Long flagPrepInSize7T;
    @Column(name = "flag_prep_out_size_7_t")
    private Long flagPrepOutSize7T;
    
    @Column(name = "flag_express_prep_in_size_7_t")
    private Long flagExpressPrepInSize7T;
    @Column(name = "flag_express_prep_out_size_7_t")
    private Long flagExpressPrepOutSize7T;

    @Column(name = "flag_st_in_size_7_t")
    private Long flagStInSize7T;
    @Column(name = "flag_st_out_size_7_t")
    private Long flagStOutSize7T;
    
    @Column(name = "flag_express_st_in_size_7_t")
    private Long flagExpressStInSize7T;
    @Column(name = "flag_express_st_out_size_7_t")
    private Long flagExpressStOutSize7T;
    
    @Column(name = "flag_as_in_size_7_t")
    private Long flagAsInSize7T;
    @Column(name = "flag_as_out_size_7_t")
    private Long flagAsOutSize7T;
    
    @Column(name = "flag_express_as_in_size_7_t")
    private Long flagExpressAsInSize7T;
    @Column(name = "flag_express_as_out_size_7_t")
    private Long flagExpressAsOutSize7T;

    @Column(name = "flag_sc_in_size_7_t")
    private Long flagScInSize7T;
    @Column(name = "flag_sc_out_size_7_t")
    private Long flagScOutSize7T;
    
    @Column(name = "flag_express_sc_in_size_7_t")
    private Long flagExpressScInSize7T;
    @Column(name = "flag_express_sc_out_size_7_t")
    private Long flagExpressScOutSize7T;

    @Column(name = "flag_ns_in_size_7_t")
    private Long flagNsInSize7T;
    @Column(name = "flag_ns_out_size_7_t")
    private Long flagNsOutSize7T;
    
    @Column(name = "flag_express_ns_in_size_7_t")
    private Long flagExpressNsInSize7T;
    @Column(name = "flag_express_ns_out_size_7_t")
    private Long flagExpressNsOutSize7T;

    @Column(name = "flag_csc_in_size_7_t")
    private Long flagCscInSize7T;
    @Column(name = "flag_csc_out_size_7_t")
    private Long flagCscOutSize7T;
    
    @Column(name = "flag_express_csc_in_size_7_t")
    private Long flagExpressCscInSize7T;
    @Column(name = "flag_express_csc_out_size_7_t")
    private Long flagExpressCscOutSize7T;

    @Column(name = "flag_os_in_size_7_t")
    private Long flagOsInSize7T;
    @Column(name = "flag_os_out_size_7_t")
    private Long flagOsOutSize7T;
    
    @Column(name = "flag_express_os_in_size_7_t")
    private Long flagExpressOsInSize7T;
    @Column(name = "flag_express_os_out_size_7_t")
    private Long flagExpressOsOutSize7T;

    @Column(name = "flag_spcut_in_size_7_t")
    private Long flagspcutInSize7T;
    @Column(name = "flag_spcut_out_size_7_t")
    private Long flagspcutOutSize7T;
    
    @Column(name = "flag_express_spcut_in_size_7_t")
    private Long flagExpressSpcutInSize7T;
    @Column(name = "flag_express_spcut_out_size_7_t")
    private Long flagExpressSpcutOutSize7T;
    
    @Column(name = "flag_spprep_in_size_7_t")
    private Long flagspprepInSize7T;
    @Column(name = "flag_spprep_out_size_7_t")
    private Long flagspprepOutSize7T;
    
    @Column(name = "flag_express_spprep_in_size_7_t")
    private Long flagExpressSpprepInSize7T;
    @Column(name = "flag_express_spprep_out_size_7_t")
    private Long flagExpressSpprepOutSize7T;

    @Column(name = "Size_8")
    private Long Size8;

    @Column(name = "flag_ct_in_size_8")
    private Long flagCtInSize8;
    @Column(name = "flag_ct_out_size_8")
    private Long flagCtOutSize8;
    
    @Column(name = "flag_express_ct_in_size_8")
    private Long flagExpressCtInSize8;
    @Column(name = "flag_express_ct_out_size_8")
    private Long flagExpressCtOutSize8;

    @Column(name = "flag_prep_in_size_8")
    private Long flagPrepInSize8;
    @Column(name = "flag_prep_out_size_8")
    private Long flagPrepOutSize8;
    
    @Column(name = "flag_express_prep_in_size_8")
    private Long flagExpressPrepInSize8;
    @Column(name = "flag_express_prep_out_size_8")
    private Long flagExpressPrepOutSize8;

    @Column(name = "flag_st_in_size_8")
    private Long flagStInSize8;
    @Column(name = "flag_st_out_size_8")
    private Long flagStOutSize8;
    
    @Column(name = "flag_express_st_in_size_8")
    private Long flagExpressStInSize8;
    @Column(name = "flag_express_st_out_size_8")
    private Long flagExpressStOutSize8;

    @Column(name = "flag_as_in_size_8")
    private Long flagAsInSize8;
    @Column(name = "flag_as_out_size_8")
    private Long flagAsOutSize8;
    
    @Column(name = "flag_express_as_in_size_8")
    private Long flagExpressAsInSize8;
    @Column(name = "flag_express_as_out_size_8")
    private Long flagExpressAsOutSize8;

    @Column(name = "flag_sc_in_size_8")
    private Long flagScInSize8;
    @Column(name = "flag_sc_out_size_8")
    private Long flagScOutSize8;
    
    @Column(name = "flag_express_sc_in_size_8")
    private Long flagExpressScInSize8;
    @Column(name = "flag_express_sc_out_size_8")
    private Long flagExpressScOutSize8;

    @Column(name = "flag_ns_in_size_8")
    private Long flagNsInSize8;
    @Column(name = "flag_ns_out_size_8")
    private Long flagNsOutSize8;
    
    @Column(name = "flag_express_ns_in_size_8")
    private Long flagExpressNsInSize8;
    @Column(name = "flag_express_ns_out_size_8")
    private Long flagExpressNsOutSize8;

    @Column(name = "flag_csc_in_size_8")
    private Long flagCscInSize8;
    @Column(name = "flag_csc_out_size_8")
    private Long flagCscOutSize8;
    
    @Column(name = "flag_express_csc_in_size_8")
    private Long flagExpressCscInSize8;
    @Column(name = "flag_express_csc_out_size_8")
    private Long flagExpressCscOutSize8;

    @Column(name = "flag_os_in_size_8")
    private Long flagOsInSize8;
    @Column(name = "flag_os_out_size_8")
    private Long flagOsOutSize8;
    
    @Column(name = "flag_express_os_in_size_8")
    private Long flagExpressOsInSize8;
    @Column(name = "flag_express_os_out_size_8")
    private Long flagExpressOsOutSize8;

    @Column(name = "flag_spcut_in_size_8")
    private Long flagspcutInSize8;
    @Column(name = "flag_spcut_out_size_8")
    private Long flagspcutOutSize8;
    
    @Column(name = "flag_express_spcut_in_size_8")
    private Long flagExpressSpcutInSize8;
    @Column(name = "flag_express_spcut_out_size_8")
    private Long flagExpressSpcutOutSize8;
    
    @Column(name = "flag_spprep_in_size_8")
    private Long flagspprepInSize8;
    @Column(name = "flag_spprep_out_size_8")
    private Long flagspprepOutSize8;
    
    @Column(name = "flag_express_spprep_in_size_8")
    private Long flagExpressSpprepInSize8;
    @Column(name = "flag_express_spprep_out_size_8")
    private Long flagExpressSpprepOutSize8;

    @Column(name = "Size_8_t")
    private Long Size8T;

    @Column(name = "flag_ct_in_size_8_t")
    private Long flagCtInSize8T;
    @Column(name = "flag_ct_out_size_8_t")
    private Long flagCtOutSize8T;
    
    @Column(name = "flag_express_ct_in_size_8_t")
    private Long flagExpressCtInSize8T;
    @Column(name = "flag_express_ct_out_size_8_t")
    private Long flagExpressCtOutSize8T;

    @Column(name = "flag_prep_in_size_8_t")
    private Long flagPrepInSize8T;
    @Column(name = "flag_prep_out_size_8_t")
    private Long flagPrepOutSize8T;
    
    @Column(name = "flag_express_prep_in_size_8_t")
    private Long flagExpressPrepInSize8T;
    @Column(name = "flag_express_prep_out_size_8_t")
    private Long flagExpressPrepOutSize8T;

    @Column(name = "flag_st_in_size_8_t")
    private Long flagStInSize8T;
    @Column(name = "flag_st_out_size_8_t")
    private Long flagStOutSize8T;
    
    @Column(name = "flag_express_st_in_size_8_t")
    private Long flagExpressStInSize8T;
    @Column(name = "flag_express_st_out_size_8_t")
    private Long flagExpressStOutSize8T;

    @Column(name = "flag_as_in_size_8_t")
    private Long flagAsInSize8T;
    @Column(name = "flag_as_out_size_8_t")
    private Long flagAsOutSize8T;
    
    @Column(name = "flag_express_as_in_size_8_t")
    private Long flagExpressAsInSize8T;
    @Column(name = "flag_express_as_out_size_8_t")
    private Long flagExpressAsOutSize8T;

    @Column(name = "flag_sc_in_size_8_t")
    private Long flagScInSize8T;
    @Column(name = "flag_sc_out_size_8_t")
    private Long flagScOutSize8T;
    
    @Column(name = "flag_express_sc_in_size_8_t")
    private Long flagExpressScInSize8T;
    @Column(name = "flag_express_sc_out_size_8_t")
    private Long flagExpressScOutSize8T;

    @Column(name = "flag_ns_in_size_8_t")
    private Long flagNsInSize8T;
    @Column(name = "flag_ns_out_size_8_t")
    private Long flagNsOutSize8T;
    
    @Column(name = "flag_express_ns_in_size_8_t")
    private Long flagExpressNsInSize8T;
    @Column(name = "flag_express_ns_out_size_8_t")
    private Long flagExpressNsOutSize8T;

    @Column(name = "flag_csc_in_size_8_t")
    private Long flagCscInSize8T;
    @Column(name = "flag_csc_out_size_8_t")
    private Long flagCscOutSize8T;
    
    @Column(name = "flag_express_csc_in_size_8_t")
    private Long flagExpressCscInSize8T;
    @Column(name = "flag_express_csc_out_size_8_t")
    private Long flagExpressCscOutSize8T;

    @Column(name = "flag_os_in_size_8_t")
    private Long flagOsInSize8T;
    @Column(name = "flag_os_out_size_8_t")
    private Long flagOsOutSize8T;
    
    @Column(name = "flag_express_os_in_size_8_t")
    private Long flagExpressOsInSize8T;
    @Column(name = "flag_express_os_out_size_8_t")
    private Long flagExpressOsOutSize8T;

    @Column(name = "flag_spcut_in_size_8_t")
    private Long flagspcutInSize8T;
    @Column(name = "flag_spcut_out_size_8_t")
    private Long flagspcutOutSize8T;
    
    @Column(name = "flag_express_spcut_in_size_8_t")
    private Long flagExpressSpcutInSize8T;
    @Column(name = "flag_express_spcut_out_size_8_t")
    private Long flagExpressSpcutOutSize8T;
    
    @Column(name = "flag_spprep_in_size_8_t")
    private Long flagspprepInSize8T;
    @Column(name = "flag_spprep_out_size_8_t")
    private Long flagspprepOutSize8T;
    
    @Column(name = "flag_express_spprep_in_size_8_t")
    private Long flagExpressSpprepInSize8T;
    @Column(name = "flag_express_spprep_out_size_8_t")
    private Long flagExpressSpprepOutSize8T;

    @Column(name = "Size_9")
    private Long Size9;

    @Column(name = "flag_ct_in_size_9")
    private Long flagCtInSize9;
    @Column(name = "flag_ct_out_size_9")
    private Long flagCtOutSize9;
    
    @Column(name = "flag_express_ct_in_size_9")
    private Long flagExpressCtInSize9;
    @Column(name = "flag_express_ct_out_size_9")
    private Long flagExpressCtOutSize9;

    @Column(name = "flag_prep_in_size_9")
    private Long flagPrepInSize9;
    @Column(name = "flag_prep_out_size_9")
    private Long flagPrepOutSize9;
    
    @Column(name = "flag_express_prep_in_size_9")
    private Long flagExpressPrepInSize9;
    @Column(name = "flag_express_prep_out_size_9")
    private Long flagExpressPrepOutSize9;

    @Column(name = "flag_st_in_size_9")
    private Long flagStInSize9;
    @Column(name = "flag_st_out_size_9")
    private Long flagStOutSize9;
    
    @Column(name = "flag_express_st_in_size_9")
    private Long flagExpressStInSize9;
    @Column(name = "flag_express_st_out_size_9")
    private Long flagExpressStOutSize9;

    @Column(name = "flag_as_in_size_9")
    private Long flagAsInSize9;
    @Column(name = "flag_as_out_size_9")
    private Long flagAsOutSize9;
    
    @Column(name = "flag_express_as_in_size_9")
    private Long flagExpressAsInSize9;
    @Column(name = "flag_express_as_out_size_9")
    private Long flagExpressAsOutSize9;

    @Column(name = "flag_sc_in_size_9")
    private Long flagScInSize9;
    @Column(name = "flag_sc_out_size_9")
    private Long flagScOutSize9;
    
    @Column(name = "flag_express_sc_in_size_9")
    private Long flagExpressScInSize9;
    @Column(name = "flag_express_sc_out_size_9")
    private Long flagExpressScOutSize9;

    @Column(name = "flag_ns_in_size_9")
    private Long flagNsInSize9;
    @Column(name = "flag_ns_out_size_9")
    private Long flagNsOutSize9;
    
    @Column(name = "flag_express_ns_in_size_9")
    private Long flagExpressNsInSize9;
    @Column(name = "flag_express_ns_out_size_9")
    private Long flagExpressNsOutSize9;

    @Column(name = "flag_csc_in_size_9")
    private Long flagCscInSize9;
    @Column(name = "flag_csc_out_size_9")
    private Long flagCscOutSize9;
    
    @Column(name = "flag_express_csc_in_size_9")
    private Long flagExpressCscInSize9;
    @Column(name = "flag_express_csc_out_size_9")
    private Long flagExpressCscOutSize9;

    @Column(name = "flag_os_in_size_9")
    private Long flagOsInSize9;
    @Column(name = "flag_os_out_size_9")
    private Long flagOsOutSize9;
    
    @Column(name = "flag_express_os_in_size_9")
    private Long flagExpressOsInSize9;
    @Column(name = "flag_express_os_out_size_9")
    private Long flagExpressOsOutSize9;

    @Column(name = "flag_spcut_in_size_9")
    private Long flagspcutInSize9;
    @Column(name = "flag_spcut_out_size_9")
    private Long flagspcutOutSize9;
    
    @Column(name = "flag_express_spcut_in_size_9")
    private Long flagExpressSpcutInSize9;
    @Column(name = "flag_express_spcut_out_size_9")
    private Long flagExpressSpcutOutSize9;
    
    @Column(name = "flag_spprep_in_size_9")
    private Long flagspprepInSize9;
    @Column(name = "flag_spprep_out_size_9")
    private Long flagspprepOutSize9;
    
    @Column(name = "flag_express_spprep_in_size_9")
    private Long flagExpressSpprepInSize9;
    @Column(name = "flag_express_spprep_out_size_9")
    private Long flagExpressSpprepOutSize9;

    @Column(name = "Size_9_t")
    private Long Size9T;

    @Column(name = "flag_ct_in_size_9_t")
    private Long flagCtInSize9T;
    @Column(name = "flag_ct_out_size_9_t")
    private Long flagCtOutSize9T;
    
    @Column(name = "flag_express_ct_in_size_9_t")
    private Long flagExpressCtInSize9T;
    @Column(name = "flag_express_ct_out_size_9_t")
    private Long flagExpressCtOutSize9T;
    
    @Column(name = "flag_prep_in_size_9_t")
    private Long flagPrepInSize9T;
    @Column(name = "flag_prep_out_size_9_t")
    private Long flagPrepOutSize9T;
    
    @Column(name = "flag_express_prep_in_size_9_t")
    private Long flagExpressPrepInSize9T;
    @Column(name = "flag_express_prep_out_size_9_t")
    private Long flagExpressPrepOutSize9T;

    @Column(name = "flag_st_in_size_9_t")
    private Long flagStInSize9T;
    @Column(name = "flag_st_out_size_9_t")
    private Long flagStOutSize9T;
    
    @Column(name = "flag_express_st_in_size_9_t")
    private Long flagExpressStInSize9T;
    @Column(name = "flag_express_st_out_size_9_t")
    private Long flagExpressStOutSize9T;

    @Column(name = "flag_as_in_size_9_t")
    private Long flagAsInSize9T;
    @Column(name = "flag_as_out_size_9_t")
    private Long flagAsOutSize9T;
    
    @Column(name = "flag_express_as_in_size_9_t")
    private Long flagExpressAsInSize9T;
    @Column(name = "flag_express_as_out_size_9_t")
    private Long flagExpressAsOutSize9T;

    @Column(name = "flag_sc_in_size_9_t")
    private Long flagScInSize9T;
    @Column(name = "flag_sc_out_size_9_t")
    private Long flagScOutSize9T;
    
    @Column(name = "flag_express_sc_in_size_9_t")
    private Long flagExpressScInSize9T;
    @Column(name = "flag_express_sc_out_size_9_t")
    private Long flagExpressScOutSize9T;

    @Column(name = "flag_ns_in_size_9_t")
    private Long flagNsInSize9T;
    @Column(name = "flag_ns_out_size_9_t")
    private Long flagNsOutSize9T;
    
    @Column(name = "flag_express_ns_in_size_9_t")
    private Long flagExpressNsInSize9T;
    @Column(name = "flag_express_ns_out_size_9_t")
    private Long flagExpressNsOutSize9T;

    @Column(name = "flag_csc_in_size_9_t")
    private Long flagCscInSize9T;
    @Column(name = "flag_csc_out_size_9_t")
    private Long flagCscOutSize9T;
    
    @Column(name = "flag_express_csc_in_size_9_t")
    private Long flagExpressCscInSize9T;
    @Column(name = "flag_express_csc_out_size_9_t")
    private Long flagExpressCscOutSize9T;

    @Column(name = "flag_os_in_size_9_t")
    private Long flagOsInSize9T;
    @Column(name = "flag_os_out_size_9_t")
    private Long flagOsOutSize9T;
    
    @Column(name = "flag_express_os_in_size_9_t")
    private Long flagExpressOsInSize9T;
    @Column(name = "flag_express_os_out_size_9_t")
    private Long flagExpressOsOutSize9T;

    @Column(name = "flag_spcut_in_size_9_t")
    private Long flagspcutInSize9T;
    @Column(name = "flag_spcut_out_size_9_t")
    private Long flagspcutOutSize9T;
    
    @Column(name = "flag_express_spcut_in_size_9_t")
    private Long flagExpressSpcutInSize9T;
    @Column(name = "flag_express_spcut_out_size_9_t")
    private Long flagExpressSpcutOutSize9T;
    
    @Column(name = "flag_spprep_in_size_9_t")
    private Long flagspprepInSize9T;
    @Column(name = "flag_spprep_out_size_9_t")
    private Long flagspprepOutSize9T;
    
    @Column(name = "flag_express_spprep_in_size_9_t")
    private Long flagExpressSpprepInSize9T;
    @Column(name = "flag_express_spprep_out_size_9_t")
    private Long flagExpressSpprepOutSize9T;

    @Column(name = "Size_10")
    private Long Size10;

    @Column(name = "flag_ct_in_size_10")
    private Long flagCtInSize10;
    @Column(name = "flag_ct_out_size_10")
    private Long flagCtOutSize10;
    
    @Column(name = "flag_express_ct_in_size_10")
    private Long flagExpressCtInSize10;
    @Column(name = "flag_express_ct_out_size_10")
    private Long flagExpressCtOutSize10;
    
    @Column(name = "flag_prep_in_size_10")
    private Long flagPrepInSize10;
    @Column(name = "flag_prep_out_size_10")
    private Long flagPrepOutSize10;
    
    @Column(name = "flag_express_prep_in_size_10")
    private Long flagExpressPrepInSize10;
    @Column(name = "flag_express_prep_out_size_10")
    private Long flagExpressPrepOutSize10;

    @Column(name = "flag_st_in_size_10")
    private Long flagStInSize10;
    @Column(name = "flag_st_out_size_10")
    private Long flagStOutSize10;
    
    @Column(name = "flag_express_st_in_size_10")
    private Long flagExpressStInSize10;
    @Column(name = "flag_express_st_out_size_10")
    private Long flagExpressStOutSize10;

    @Column(name = "flag_as_in_size_10")
    private Long flagAsInSize10;
    @Column(name = "flag_as_out_size_10")
    private Long flagAsOutSize10;
    
    @Column(name = "flag_express_as_in_size_10")
    private Long flagExpressAsInSize10;
    @Column(name = "flag_express_as_out_size_10")
    private Long flagExpressAsOutSize10;

    @Column(name = "flag_sc_in_size_10")
    private Long flagScInSize10;
    @Column(name = "flag_sc_out_size_10")
    private Long flagScOutSize10;
    
    @Column(name = "flag_express_sc_in_size_10")
    private Long flagExpressScInSize10;
    @Column(name = "flag_express_sc_out_size_10")
    private Long flagExpressScOutSize10;

    @Column(name = "flag_ns_in_size_10")
    private Long flagNsInSize10;
    @Column(name = "flag_ns_out_size_10")
    private Long flagNsOutSize10;
    
    @Column(name = "flag_express_ns_in_size_10")
    private Long flagExpressNsInSize10;
    @Column(name = "flag_express_ns_out_size_10")
    private Long flagExpressNsOutSize10;

    @Column(name = "flag_csc_in_size_10")
    private Long flagCscInSize10;
    @Column(name = "flag_csc_out_size_10")
    private Long flagCscOutSize10;
    
    @Column(name = "flag_express_csc_in_size_10")
    private Long flagExpressCscInSize10;
    @Column(name = "flag_express_csc_out_size_10")
    private Long flagExpressCscOutSize10;

    @Column(name = "flag_os_in_size_10")
    private Long flagOsInSize10;
    @Column(name = "flag_os_out_size_10")
    private Long flagOsOutSize10;
    
    @Column(name = "flag_express_os_in_size_10")
    private Long flagExpressOsInSize10;
    @Column(name = "flag_express_os_out_size_10")
    private Long flagExpressOsOutSize10;

    @Column(name = "flag_spcut_in_size_10")
    private Long flagspcutInSize10;
    @Column(name = "flag_spcut_out_size_10")
    private Long flagspcutOutSize10;
    
    @Column(name = "flag_express_spcut_in_size_10")
    private Long flagExpressSpcutInSize10;
    @Column(name = "flag_express_spcut_out_size_10")
    private Long flagExpressSpcutOutSize10;
    
    @Column(name = "flag_spprep_in_size_10")
    private Long flagspprepInSize10;
    @Column(name = "flag_spprep_out_size_10")
    private Long flagspprepOutSize10;
    
    @Column(name = "flag_express_spprep_in_size_10")
    private Long flagExpressSpprepInSize10;
    @Column(name = "flag_express_spprep_out_size_10")
    private Long flagExpressSpprepOutSize10;

    @Column(name = "Size_10_t")
    private Long Size10T;

    @Column(name = "flag_ct_in_size_10_t")
    private Long flagCtInSize10T;
    @Column(name = "flag_ct_out_size_10_t")
    private Long flagCtOutSize10T;
    
    @Column(name = "flag_express_ct_in_size_10_t")
    private Long flagExpressCtInSize10T;
    @Column(name = "flag_express_ct_out_size_10_t")
    private Long flagExpressCtOutSize10T;

    @Column(name = "flag_prep_in_size_10_t")
    private Long flagPrepInSize10T;
    @Column(name = "flag_prep_out_size_10_t")
    private Long flagPrepOutSize10T;
    
    @Column(name = "flag_express_prep_in_size_10_t")
    private Long flagExpressPrepInSize10T;
    @Column(name = "flag_express_prep_out_size_10_t")
    private Long flagExpressPrepOutSize10T;

    @Column(name = "flag_st_in_size_10_t")
    private Long flagStInSize10T;
    @Column(name = "flag_st_out_size_10_t")
    private Long flagStOutSize10T;
    
    @Column(name = "flag_express_st_in_size_10_t")
    private Long flagExpressStInSize10T;
    @Column(name = "flag_express_st_out_size_10_t")
    private Long flagExpressStOutSize10T;

    @Column(name = "flag_as_in_size_10_t")
    private Long flagAsInSize10T;
    @Column(name = "flag_as_out_size_10_t")
    private Long flagAsOutSize10T;
    
    @Column(name = "flag_express_as_in_size_10_t")
    private Long flagExpressAsInSize10T;
    @Column(name = "flag_express_as_out_size_10_t")
    private Long flagExpressAsOutSize10T;

    @Column(name = "flag_sc_in_size_10_t")
    private Long flagScInSize10T;
    @Column(name = "flag_sc_out_size_10_t")
    private Long flagScOutSize10T;
    
    @Column(name = "flag_express_sc_in_size_10_t")
    private Long flagExpressScInSize10T;
    @Column(name = "flag_express_sc_out_size_10_t")
    private Long flagExpressScOutSize10T;

    @Column(name = "flag_ns_in_size_10_t")
    private Long flagNsInSize10T;
    @Column(name = "flag_ns_out_size_10_t")
    private Long flagNsOutSize10T;
    
    @Column(name = "flag_express_ns_in_size_10_t")
    private Long flagExpressNsInSize10T;
    @Column(name = "flag_express_ns_out_size_10_t")
    private Long flagExpressNsOutSize10T;

    @Column(name = "flag_csc_in_size_10_t")
    private Long flagCscInSize10T;
    @Column(name = "flag_csc_out_size_10_t")
    private Long flagCscOutSize10T;
    
    @Column(name = "flag_express_csc_in_size_10_t")
    private Long flagExpressCscInSize10T;
    @Column(name = "flag_express_csc_out_size_10_t")
    private Long flagExpressCscOutSize10T;

    @Column(name = "flag_os_in_size_10_t")
    private Long flagOsInSize10T;
    @Column(name = "flag_os_out_size_10_t")
    private Long flagOsOutSize10T;
    
    @Column(name = "flag_express_os_in_size_10_t")
    private Long flagExpressOsInSize10T;
    @Column(name = "flag_express_os_out_size_10_t")
    private Long flagExpressOsOutSize10T;

    @Column(name = "flag_spcut_in_size_10_t")
    private Long flagspcutInSize10T;
    @Column(name = "flag_spcut_out_size_10_t")
    private Long flagspcutOutSize10T;
    
    @Column(name = "flag_express_spcut_in_size_10_t")
    private Long flagExpressSpcutInSize10T;
    @Column(name = "flag_express_spcut_out_size_10_t")
    private Long flagExpressSpcutOutSize10T;
    
    @Column(name = "flag_spprep_in_size_10_t")
    private Long flagspprepInSize10T;
    @Column(name = "flag_spprep_out_size_10_t")
    private Long flagspprepOutSize10T;
    
    @Column(name = "flag_express_spprep_in_size_10_t")
    private Long flagExpressSpprepInSize10T;
    @Column(name = "flag_express_spprep_out_size_10_t")
    private Long flagExpressSpprepOutSize10T;

    @Column(name = "Size_11")
    private Long Size11;

    @Column(name = "flag_ct_in_size_11")
    private Long flagCtInSize11;
    @Column(name = "flag_ct_out_size_11")
    private Long flagCtOutSize11;
    
    @Column(name = "flag_express_ct_in_size_11")
    private Long flagExpressCtInSize11;
    @Column(name = "flag_express_ct_out_size_11")
    private Long flagExpressCtOutSize11;

    @Column(name = "flag_prep_in_size_11")
    private Long flagPrepInSize11;
    @Column(name = "flag_prep_out_size_11")
    private Long flagPrepOutSize11;
    
    @Column(name = "flag_express_prep_in_size_11")
    private Long flagExpressPrepInSize11;
    @Column(name = "flag_express_prep_out_size_11")
    private Long flagExpressPrepOutSize11;

    @Column(name = "flag_st_in_size_11")
    private Long flagStInSize11;
    @Column(name = "flag_st_out_size_11")
    private Long flagStOutSize11;
    
    @Column(name = "flag_express_st_in_size_11")
    private Long flagExpressStInSize11;
    @Column(name = "flag_express_st_out_size_11")
    private Long flagExpressStOutSize11;

    @Column(name = "flag_as_in_size_11")
    private Long flagAsInSize11;
    @Column(name = "flag_as_out_size_11")
    private Long flagAsOutSize11;
    
    @Column(name = "flag_express_as_in_size_11")
    private Long flagExpressAsInSize11;
    @Column(name = "flag_express_as_out_size_11")
    private Long flagExpressAsOutSize11;

    @Column(name = "flag_sc_in_size_11")
    private Long flagScInSize11;
    @Column(name = "flag_sc_out_size_11")
    private Long flagScOutSize11;
    
    @Column(name = "flag_express_sc_in_size_11")
    private Long flagExpressScInSize11;
    @Column(name = "flag_express_sc_out_size_11")
    private Long flagExpressScOutSize11;

    @Column(name = "flag_ns_in_size_11")
    private Long flagNsInSize11;
    @Column(name = "flag_ns_out_size_11")
    private Long flagNsOutSize11;
    
    @Column(name = "flag_express_ns_in_size_11")
    private Long flagExpressNsInSize11;
    @Column(name = "flag_express_ns_out_size_11")
    private Long flagExpressNsOutSize11;

    @Column(name = "flag_csc_in_size_11")
    private Long flagCscInSize11;
    @Column(name = "flag_csc_out_size_11")
    private Long flagCscOutSize11;
    
    @Column(name = "flag_express_csc_in_size_11")
    private Long flagExpressCscInSize11;
    @Column(name = "flag_express_csc_out_size_11")
    private Long flagExpressCscOutSize11;

    @Column(name = "flag_os_in_size_11")
    private Long flagOsInSize11;
    @Column(name = "flag_os_out_size_11")
    private Long flagOsOutSize11;
    
    @Column(name = "flag_express_os_in_size_11")
    private Long flagExpressOsInSize11;
    @Column(name = "flag_express_os_out_size_11")
    private Long flagExpressOsOutSize11;

    @Column(name = "flag_spcut_in_size_11")
    private Long flagspcutInSize11;
    @Column(name = "flag_spcut_out_size_11")
    private Long flagspcutOutSize11;
    
    @Column(name = "flag_express_spcut_in_size_11")
    private Long flagExpressSpcutInSize11;
    @Column(name = "flag_express_spcut_out_size_11")
    private Long flagExpressSpcutOutSize11;
    
    @Column(name = "flag_spprep_in_size_11")
    private Long flagspprepInSize11;
    @Column(name = "flag_spprep_out_size_11")
    private Long flagspprepOutSize11;

    @Column(name = "flag_express_spprep_in_size_11")
    private Long flagExpressSpprepInSize11;
    @Column(name = "flag_express_spprep_out_size_11")
    private Long flagExpressSpprepOutSize11;
    
    @Column(name = "Size_11_t")
    private Long Size11T;

    @Column(name = "flag_ct_in_size_11_t")
    private Long flagCtInSize11T;
    @Column(name = "flag_ct_out_size_11_t")
    private Long flagCtOutSize11T;
    
    @Column(name = "flag_express_ct_in_size_11_t")
    private Long flagExpressCtInSize11T;
    @Column(name = "flag_express_ct_out_size_11_t")
    private Long flagExpressCtOutSize11T;

    @Column(name = "flag_prep_in_size_11_t")
    private Long flagPrepInSize11T;
    @Column(name = "flag_prep_out_size_11_t")
    private Long flagPrepOutSize11T;
    
    @Column(name = "flag_express_prep_in_size_11_t")
    private Long flagExpressPrepInSize11T;
    @Column(name = "flag_express_prep_out_size_11_t")
    private Long flagExpressPrepOutSize11T;

    @Column(name = "flag_st_in_size_11_t")
    private Long flagStInSize11T;
    @Column(name = "flag_st_out_size_11_t")
    private Long flagStOutSize11T;
    
    @Column(name = "flag_express_st_in_size_11_t")
    private Long flagExpressStInSize11T;
    @Column(name = "flag_express_st_out_size_11_t")
    private Long flagExpressStOutSize11T;

    @Column(name = "flag_as_in_size_11_t")
    private Long flagAsInSize11T;
    @Column(name = "flag_as_out_size_11_t")
    private Long flagAsOutSize11T;

    @Column(name = "flag_express_as_in_size_11_t")
    private Long flagExpressAsInSize11T;
    @Column(name = "flag_express_as_out_size_11_t")
    private Long flagExpressAsOutSize11T;
    
    @Column(name = "flag_sc_in_size_11_t")
    private Long flagScInSize11T;
    @Column(name = "flag_sc_out_size_11_t")
    private Long flagScOutSize11T;
    
    @Column(name = "flag_express_sc_in_size_11_t")
    private Long flagExpressScInSize11T;
    @Column(name = "flag_express_sc_out_size_11_t")
    private Long flagExpressScOutSize11T;

    @Column(name = "flag_ns_in_size_11_t")
    private Long flagNsInSize11T;
    @Column(name = "flag_ns_out_size_11_t")
    private Long flagNsOutSize11T;
    
    @Column(name = "flag_express_ns_in_size_11_t")
    private Long flagExpressNsInSize11T;
    @Column(name = "flag_express_ns_out_size_11_t")
    private Long flagExpressNsOutSize11T;

    @Column(name = "flag_csc_in_size_11_t")
    private Long flagCscInSize11T;
    @Column(name = "flag_csc_out_size_11_t")
    private Long flagCscOutSize11T;
    
    @Column(name = "flag_express_csc_in_size_11_t")
    private Long flagExpressCscInSize11T;
    @Column(name = "flag_express_csc_out_size_11_t")
    private Long flagExpressCscOutSize11T;

    @Column(name = "flag_os_in_size_11_t")
    private Long flagOsInSize11T;
    @Column(name = "flag_os_out_size_11_t")
    private Long flagOsOutSize11T;
    
    @Column(name = "flag_express_os_in_size_11_t")
    private Long flagExpressOsInSize11T;
    @Column(name = "flag_express_os_out_size_11_t")
    private Long flagExpressOsOutSize11T;

    @Column(name = "flag_spcut_in_size_11_t")
    private Long flagspcutInSize11T;
    @Column(name = "flag_spcut_out_size_11_t")
    private Long flagspcutOutSize11T;
    
    @Column(name = "flag_express_spcut_in_size_11_t")
    private Long flagExpressSpcutInSize11T;
    @Column(name = "flag_express_spcut_out_size_11_t")
    private Long flagExpressSpcutOutSize11T;
    
    @Column(name = "flag_spprep_in_size_11_t")
    private Long flagspprepInSize11T;
    @Column(name = "flag_spprep_out_size_11_t")
    private Long flagspprepOutSize11T;
    
    @Column(name = "flag_express_spprep_in_size_11_t")
    private Long flagExpressSpprepInSize11T;
    @Column(name = "flag_express_spprep_out_size_11_t")
    private Long flagExpressSpprepOutSize11T;

    @Column(name = "Size_12")
    private Long Size12;

    @Column(name = "flag_ct_in_size_12")
    private Long flagCtInSize12;
    @Column(name = "flag_ct_out_size_12")
    private Long flagCtOutSize12;
    
    @Column(name = "flag_express_ct_in_size_12")
    private Long flagExpressCtInSize12;
    @Column(name = "flag_express_ct_out_size_12")
    private Long flagExpressCtOutSize12;

    @Column(name = "flag_prep_in_size_12")
    private Long flagPrepInSize12;
    @Column(name = "flag_prep_out_size_12")
    private Long flagPrepOutSize12;
    
    @Column(name = "flag_express_prep_in_size_12")
    private Long flagExpressPrepInSize12;
    @Column(name = "flag_express_prep_out_size_12")
    private Long flagExpressPrepOutSize12;

    @Column(name = "flag_st_in_size_12")
    private Long flagStInSize12;
    @Column(name = "flag_st_out_size_12")
    private Long flagStOutSize12;
    
    @Column(name = "flag_express_st_in_size_12")
    private Long flagExpressStInSize12;
    @Column(name = "flag_express_st_out_size_12")
    private Long flagExpressStOutSize12;

    @Column(name = "flag_as_in_size_12")
    private Long flagAsInSize12;
    @Column(name = "flag_as_out_size_12")
    private Long flagAsOutSize12;
    
    @Column(name = "flag_express_as_in_size_12")
    private Long flagExpressAsInSize12;
    @Column(name = "flag_express_as_out_size_12")
    private Long flagExpressAsOutSize12;

    @Column(name = "flag_sc_in_size_12")
    private Long flagScInSize12;
    @Column(name = "flag_sc_out_size_12")
    private Long flagScOutSize12;
    
    @Column(name = "flag_express_sc_in_size_12")
    private Long flagExpressScInSize12;
    @Column(name = "flag_express_sc_out_size_12")
    private Long flagExpressScOutSize12;

    @Column(name = "flag_ns_in_size_12")
    private Long flagNsInSize12;
    @Column(name = "flag_ns_out_size_12")
    private Long flagNsOutSize12;
    
    @Column(name = "flag_express_ns_in_size_12")
    private Long flagExpressNsInSize12;
    @Column(name = "flag_express_ns_out_size_12")
    private Long flagExpressNsOutSize12;

    @Column(name = "flag_csc_in_size_12")
    private Long flagCscInSize12;
    @Column(name = "flag_csc_out_size_12")
    private Long flagCscOutSize12;
    
    @Column(name = "flag_express_csc_in_size_12")
    private Long flagExpressCscInSize12;
    @Column(name = "flag_express_csc_out_size_12")
    private Long flagExpressCscOutSize12;

    @Column(name = "flag_os_in_size_12")
    private Long flagOsInSize12;
    @Column(name = "flag_os_out_size_12")
    private Long flagOsOutSize12;
    
    @Column(name = "flag_express_os_in_size_12")
    private Long flagExpressOsInSize12;
    @Column(name = "flag_express_os_out_size_12")
    private Long flagExpressOsOutSize12;

    @Column(name = "flag_spcut_in_size_12")
    private Long flagspcutInSize12;
    @Column(name = "flag_spcut_out_size_12")
    private Long flagspcutOutSize12;
    
    @Column(name = "flag_express_spcut_in_size_12")
    private Long flagExpressSpcutInSize12;
    @Column(name = "flag_express_spcut_out_size_12")
    private Long flagExpressSpcutOutSize12;
    
    @Column(name = "flag_spprep_in_size_12")
    private Long flagspprepInSize12;
    @Column(name = "flag_spprep_out_size_12")
    private Long flagspprepOutSize12;
    
    @Column(name = "flag_express_spprep_in_size_12")
    private Long flagExpressSpprepInSize12;
    @Column(name = "flag_express_spprep_out_size_12")
    private Long flagExpressSpprepOutSize12;

    @Column(name = "Size_12_t")
    private Long Size12T;

    @Column(name = "flag_ct_in_size_12_t")
    private Long flagCtInSize12T;
    @Column(name = "flag_ct_out_size_12_t")
    private Long flagCtOutSize12T;
    
    @Column(name = "flag_express_ct_in_size_12_t")
    private Long flagExpressCtInSize12T;
    @Column(name = "flag_express_ct_out_size_12_t")
    private Long flagExpressCtOutSize12T;

    @Column(name = "flag_prep_in_size_12_t")
    private Long flagPrepInSize12T;
    @Column(name = "flag_prep_out_size_12_t")
    private Long flagPrepOutSize12T;
    
    @Column(name = "flag_express_prep_in_size_12_t")
    private Long flagExpressPrepInSize12T;
    @Column(name = "flag_express_prep_out_size_12_t")
    private Long flagExpressPrepOutSize12T;

    @Column(name = "flag_st_in_size_12_t")
    private Long flagStInSize12T;
    @Column(name = "flag_st_out_size_12_t")
    private Long flagStOutSize12T;
    
    @Column(name = "flag_express_st_in_size_12_t")
    private Long flagExpressStInSize12T;
    @Column(name = "flag_express_st_out_size_12_t")
    private Long flagExpressStOutSize12T;

    @Column(name = "flag_as_in_size_12_t")
    private Long flagAsInSize12T;
    @Column(name = "flag_as_out_size_12_t")
    private Long flagAsOutSize12T;
    
    @Column(name = "flag_express_as_in_size_12_t")
    private Long flagExpressAsInSize12T;
    @Column(name = "flag_express_as_out_size_12_t")
    private Long flagExpressAsOutSize12T;

    @Column(name = "flag_sc_in_size_12_t")
    private Long flagScInSize12T;
    @Column(name = "flag_sc_out_size_12_t")
    private Long flagScOutSize12T;
    
    @Column(name = "flag_express_sc_in_size_12_t")
    private Long flagExpressScInSize12T;
    @Column(name = "flag_express_sc_out_size_12_t")
    private Long flagExpressScOutSize12T;

    @Column(name = "flag_ns_in_size_12_t")
    private Long flagNsInSize12T;
    @Column(name = "flag_ns_out_size_12_t")
    private Long flagNsOutSize12T;
    
    @Column(name = "flag_express_ns_in_size_12_t")
    private Long flagExpressNsInSize12T;
    @Column(name = "flag_express_ns_out_size_12_t")
    private Long flagExpressNsOutSize12T;

    @Column(name = "flag_csc_in_size_12_t")
    private Long flagCscInSize12T;
    @Column(name = "flag_csc_out_size_12_t")
    private Long flagCscOutSize12T;
    
    @Column(name = "flag_express_csc_in_size_12_t")
    private Long flagExpressCscInSize12T;
    @Column(name = "flag_express_csc_out_size_12_t")
    private Long flagExpressCscOutSize12T;

    @Column(name = "flag_os_in_size_12_t")
    private Long flagOsInSize12T;
    @Column(name = "flag_os_out_size_12_t")
    private Long flagOsOutSize12T;
    
    @Column(name = "flag_express_os_in_size_12_t")
    private Long flagExpressOsInSize12T;
    @Column(name = "flag_express_os_out_size_12_t")
    private Long flagExpressOsOutSize12T;

    @Column(name = "flag_spcut_in_size_12_t")
    private Long flagspcutInSize12T;
    @Column(name = "flag_spcut_out_size_12_t")
    private Long flagspcutOutSize12T;
    
    @Column(name = "flag_express_spcut_in_size_12_t")
    private Long flagExpressSpcutInSize12T;
    @Column(name = "flag_express_spcut_out_size_12_t")
    private Long flagExpressSpcutOutSize12T;
    
    @Column(name = "flag_spprep_in_size_12_t")
    private Long flagspprepInSize12T;
    @Column(name = "flag_spprep_out_size_12_t")
    private Long flagspprepOutSize12T;
    
    @Column(name = "flag_express_spprep_in_size_12_t")
    private Long flagExpressSpprepInSize12T;
    @Column(name = "flag_express_spprep_out_size_12_t")
    private Long flagExpressSpprepOutSize12T;

    @Column(name = "Size_13")
    private Long Size13;

    @Column(name = "flag_ct_in_size_13")
    private Long flagCtInSize13;
    @Column(name = "flag_ct_out_size_13")
    private Long flagCtOutSize13;
    
    @Column(name = "flag_express_ct_in_size_13")
    private Long flagExpressCtInSize13;
    @Column(name = "flag_express_ct_out_size_13")
    private Long flagExpressCtOutSize13;

    @Column(name = "flag_prep_in_size_13")
    private Long flagPrepInSize13;
    @Column(name = "flag_prep_out_size_13")
    private Long flagPrepOutSize13;
    
    @Column(name = "flag_express_prep_in_size_13")
    private Long flagExpressPrepInSize13;
    @Column(name = "flag_express_prep_out_size_13")
    private Long flagExpressPrepOutSize13;

    @Column(name = "flag_st_in_size_13")
    private Long flagStInSize13;
    @Column(name = "flag_st_out_size_13")
    private Long flagStOutSize13;
    
    @Column(name = "flag_express_st_in_size_13")
    private Long flagExpressStInSize13;
    @Column(name = "flag_express_st_out_size_13")
    private Long flagExpressStOutSize13;

    @Column(name = "flag_as_in_size_13")
    private Long flagAsInSize13;
    @Column(name = "flag_as_out_size_13")
    private Long flagAsOutSize13;
    
    @Column(name = "flag_express_as_in_size_13")
    private Long flagExpressAsInSize13;
    @Column(name = "flag_express_as_out_size_13")
    private Long flagExpressAsOutSize13;

    @Column(name = "flag_sc_in_size_13")
    private Long flagScInSize13;
    @Column(name = "flag_sc_out_size_13")
    private Long flagScOutSize13;
    
    @Column(name = "flag_express_sc_in_size_13")
    private Long flagExpressScInSize13;
    @Column(name = "flag_express_sc_out_size_13")
    private Long flagExpressScOutSize13;

    @Column(name = "flag_ns_in_size_13")
    private Long flagNsInSize13;
    @Column(name = "flag_ns_out_size_13")
    private Long flagNsOutSize13;

    @Column(name = "flag_express_ns_in_size_13")
    private Long flagExpressNsInSize13;
    @Column(name = "flag_express_ns_out_size_13")
    private Long flagExpressNsOutSize13;
    
    @Column(name = "flag_csc_in_size_13")
    private Long flagCscInSize13;
    @Column(name = "flag_csc_out_size_13")
    private Long flagCscOutSize13;
    
    @Column(name = "flag_express_csc_in_size_13")
    private Long flagExpressCscInSize13;
    @Column(name = "flag_express_csc_out_size_13")
    private Long flagExpressCscOutSize13;

    @Column(name = "flag_os_in_size_13")
    private Long flagOsInSize13;
    @Column(name = "flag_os_out_size_13")
    private Long flagOsOutSize13;
    
    @Column(name = "flag_express_os_in_size_13")
    private Long flagExpressOsInSize13;
    @Column(name = "flag_express_os_out_size_13")
    private Long flagExpressOsOutSize13;

    @Column(name = "flag_spcut_in_size_13")
    private Long flagspcutInSize13;
    @Column(name = "flag_spcut_out_size_13")
    private Long flagspcutOutSize13;
    
    @Column(name = "flag_express_spcut_in_size_13")
    private Long flagExpressSpcutInSize13;
    @Column(name = "flag_express_spcut_out_size_13")
    private Long flagExpressSpcutOutSize13;
    
    @Column(name = "flag_spprep_in_size_13")
    private Long flagspprepInSize13;
    @Column(name = "flag_spprep_out_size_13")
    private Long flagspprepOutSize13;
    
    @Column(name = "flag_express_spprep_in_size_13")
    private Long flagExpressSpprepInSize13;
    @Column(name = "flag_express_spprep_out_size_13")
    private Long flagExpressSpprepOutSize13;

    @Column(name = "Size_13_t")
    private Long Size13T;
    
    @Column(name = "flag_ct_in_size_13_t")
    private Long flagCtInSize13T;
    @Column(name = "flag_ct_out_size_13_t")
    private Long flagCtOutSize13T;
    
    @Column(name = "flag_express_ct_in_size_13_t")
    private Long flagExpressCtInSize13T;
    @Column(name = "flag_express_ct_out_size_13_t")
    private Long flagExpressCtOutSize13T;

    @Column(name = "flag_prep_in_size_13_t")
    private Long flagPrepInSize13T;
    @Column(name = "flag_prep_out_size_13_t")
    private Long flagPrepOutSize13T;
    
    @Column(name = "flag_express_prep_in_size_13_t")
    private Long flagExpressPrepInSize13T;
    @Column(name = "flag_express_prep_out_size_13_t")
    private Long flagExpressPrepOutSize13T;

    @Column(name = "flag_st_in_size_13_t")
    private Long flagStInSize13T;
    @Column(name = "flag_st_out_size_13_t")
    private Long flagStOutSize13T;
    
    @Column(name = "flag_express_st_in_size_13_t")
    private Long flagExpressStInSize13T;
    @Column(name = "flag_express_st_out_size_13_t")
    private Long flagExpressStOutSize13T;

    @Column(name = "flag_as_in_size_13_t")
    private Long flagAsInSize13T;
    @Column(name = "flag_as_out_size_13_t")
    private Long flagAsOutSize13T;
    
    @Column(name = "flag_express_as_in_size_13_t")
    private Long flagExpressAsInSize13T;
    @Column(name = "flag_express_as_out_size_13_t")
    private Long flagExpressAsOutSize13T;

    @Column(name = "flag_sc_in_size_13_t")
    private Long flagScInSize13T;
    @Column(name = "flag_sc_out_size_13_t")
    private Long flagScOutSize13T;
    
    @Column(name = "flag_express_sc_in_size_13_t")
    private Long flagExpressScInSize13T;
    @Column(name = "flag_express_sc_out_size_13_t")
    private Long flagExpressScOutSize13T;

    @Column(name = "flag_ns_in_size_13_t")
    private Long flagNsInSize13T;
    @Column(name = "flag_ns_out_size_13_t")
    private Long flagNsOutSize13T;
    
    @Column(name = "flag_express_ns_in_size_13_t")
    private Long flagExpressNsInSize13T;
    @Column(name = "flag_express_ns_out_size_13_t")
    private Long flagExpressNsOutSize13T;

    @Column(name = "flag_csc_in_size_13_t")
    private Long flagCscInSize13T;
    @Column(name = "flag_csc_out_size_13_t")
    private Long flagCscOutSize13T;
    
    @Column(name = "flag_express_csc_in_size_13_t")
    private Long flagExpressCscInSize13T;
    @Column(name = "flag_express_csc_out_size_13_t")
    private Long flagExpressCscOutSize13T;

    @Column(name = "flag_os_in_size_13_t")
    private Long flagOsInSize13T;
    @Column(name = "flag_os_out_size_13_t")
    private Long flagOsOutSize13T;
    
    @Column(name = "flag_os_express_in_size_13_t")
    private Long flagExpressOsInSize13T;
    @Column(name = "flag_os_express_out_size_13_t")
    private Long flagExpressOsOutSize13T;

    @Column(name = "flag_spcut_in_size_13_t")
    private Long flagspcutInSize13T;
    @Column(name = "flag_spcut_out_size_13_t")
    private Long flagspcutOutSize13T;
    
    @Column(name = "flag_spcut_express_in_size_13_t")
    private Long flagExpressSpcutInSize13T;
    @Column(name = "flag_spcut_express_out_size_13_t")
    private Long flagExpressSpcutOutSize13T;
    
    @Column(name = "flag_spprep_in_size_13_t")
    private Long flagspprepInSize13T;
    @Column(name = "flag_spprep_out_size_13_t")
    private Long flagspprepOutSize13T;
    
    @Column(name = "flag_spprep_express_in_size_13_t")
    private Long flagExpressSpprepInSize13T;
    @Column(name = "flag_spprep_express_out_size_13_t")
    private Long flagExpressSpprepOutSize13T;

    @Column(name = "Size_14")
    private Long Size14;

    @Column(name = "flag_ct_in_size_14")
    private Long flagCtInSize14;
    @Column(name = "flag_ct_out_size_14")
    private Long flagCtOutSize14;
    
    @Column(name = "flag_express_ct_in_size_14")
    private Long flagExpressCtInSize14;
    @Column(name = "flag_express_ct_out_size_14")
    private Long flagExpressCtOutSize14;

    @Column(name = "flag_prep_in_size_14")
    private Long flagPrepInSize14;
    @Column(name = "flag_prep_out_size_14")
    private Long flagPrepOutSize14;
    
    @Column(name = "flag_express_prep_in_size_14")
    private Long flagExpressPrepInSize14;
    @Column(name = "flag_express_prep_out_size_14")
    private Long flagExpressPrepOutSize14;

    @Column(name = "flag_st_in_size_14")
    private Long flagStInSize14;
    @Column(name = "flag_st_out_size_14")
    private Long flagStOutSize14;
    
    @Column(name = "flag_express_st_in_size_14")
    private Long flagExpressStInSize14;
    @Column(name = "flag_express_st_out_size_14")
    private Long flagExpressStOutSize14;

    @Column(name = "flag_as_in_size_14")
    private Long flagAsInSize14;
    @Column(name = "flag_as_out_size_14")
    private Long flagAsOutSize14;
    
    @Column(name = "flag_express_as_in_size_14")
    private Long flagExpressAsInSize14;
    @Column(name = "flag_express_as_out_size_14")
    private Long flagExpressAsOutSize14;

    @Column(name = "flag_sc_in_size_14")
    private Long flagScInSize14;
    @Column(name = "flag_sc_out_size_14")
    private Long flagScOutSize14;
    
    @Column(name = "flag_express_sc_in_size_14")
    private Long flagExpressScInSize14;
    @Column(name = "flag_express_sc_out_size_14")
    private Long flagExpressScOutSize14;

    @Column(name = "flag_ns_in_size_14")
    private Long flagNsInSize14;
    @Column(name = "flag_ns_out_size_14")
    private Long flagNsOutSize14;
    
    @Column(name = "flag_express_ns_in_size_14")
    private Long flagExpressNsInSize14;
    @Column(name = "flag_express_ns_out_size_14")
    private Long flagExpressNsOutSize14;

    @Column(name = "flag_csc_in_size_14")
    private Long flagCscInSize14;
    @Column(name = "flag_csc_out_size_14")
    private Long flagCscOutSize14;
    
    @Column(name = "flag_express_csc_in_size_14")
    private Long flagExpressCscInSize14;
    @Column(name = "flag_express_csc_out_size_14")
    private Long flagExpressCscOutSize14;

    @Column(name = "flag_os_in_size_14")
    private Long flagOsInSize14;
    @Column(name = "flag_os_out_size_14")
    private Long flagOsOutSize14;
    
    @Column(name = "flag_express_os_in_size_14")
    private Long flagExpressOsInSize14;
    @Column(name = "flag_express_os_out_size_14")
    private Long flagExpressOsOutSize14;

    @Column(name = "flag_spcut_in_size_14")
    private Long flagspcutInSize14;
    @Column(name = "flag_spcut_out_size_14")
    private Long flagspcutOutSize14;
    
    @Column(name = "flag_express_spcut_in_size_14")
    private Long flagExpressSpcutInSize14;
    @Column(name = "flag_express_spcut_out_size_14")
    private Long flagExpressSpcutOutSize14;
    
    @Column(name = "flag_spprep_in_size_14")
    private Long flagspprepInSize14;
    @Column(name = "flag_spprep_out_size_14")
    private Long flagspprepOutSize14;
    
    @Column(name = "flag_express_spprep_in_size_14")
    private Long flagExpressSpprepInSize14;
    @Column(name = "flag_express_spprep_out_size_14")
    private Long flagExpressSpprepOutSize14;

    @Column(name = "Size_15")
    private Long Size15;

    @Column(name = "flag_ct_in_size_15")
    private Long flagCtInSize15;
    @Column(name = "flag_ct_out_size_15")
    private Long flagCtOutSize15;
    
    @Column(name = "flag_express_ct_in_size_15")
    private Long flagExpressCtInSize15;
    @Column(name = "flag_express_ct_out_size_15")
    private Long flagExpressCtOutSize15;

    @Column(name = "flag_prep_in_size_15")
    private Long flagPrepInSize15;
    @Column(name = "flag_prep_out_size_15")
    private Long flagPrepOutSize15;
    
    @Column(name = "flag_express_prep_in_size_15")
    private Long flagExpressPrepInSize15;
    @Column(name = "flag_express_prep_out_size_15")
    private Long flagExpressPrepOutSize15;

    @Column(name = "flag_st_in_size_15")
    private Long flagStInSize15;
    @Column(name = "flag_st_out_size_15")
    private Long flagStOutSize15;
    
    @Column(name = "flag_express_st_in_size_15")
    private Long flagExpressStInSize15;
    @Column(name = "flag_express_st_out_size_15")
    private Long flagExpressStOutSize15;

    @Column(name = "flag_as_in_size_15")
    private Long flagAsInSize15;
    @Column(name = "flag_as_out_size_15")
    private Long flagAsOutSize15;
    
    @Column(name = "flag_express_as_in_size_15")
    private Long flagExpressAsInSize15;
    @Column(name = "flag_express_as_out_size_15")
    private Long flagExpressAsOutSize15;

    @Column(name = "flag_sc_in_size_15")
    private Long flagScInSize15;
    @Column(name = "flag_sc_out_size_15")
    private Long flagScOutSize15;
    
    @Column(name = "flag_express_sc_in_size_15")
    private Long flagExpressScInSize15;
    @Column(name = "flag_express_sc_out_size_15")
    private Long flagExpressScOutSize15;
    
    @Column(name = "flag_ns_in_size_15")
    private Long flagNsInSize15;
    @Column(name = "flag_ns_out_size_15")
    private Long flagNsOutSize15;
    
    @Column(name = "flag_express_ns_in_size_15")
    private Long flagExpressNsInSize15;
    @Column(name = "flag_express_ns_out_size_15")
    private Long flagExpressNsOutSize15;
    
    @Column(name = "flag_csc_in_size_15")
    private Long flagCscInSize15;
    @Column(name = "flag_csc_out_size_15")
    private Long flagCscOutSize15;
    
    @Column(name = "flag_express_csc_in_size_15")
    private Long flagExpressCscInSize15;
    @Column(name = "flag_express_csc_out_size_15")
    private Long flagExpressCscOutSize15;

    @Column(name = "flag_os_in_size_15")
    private Long flagOsInSize15;
    @Column(name = "flag_os_out_size_15")
    private Long flagOsOutSize15;
    
    @Column(name = "flag_express_os_in_size_15")
    private Long flagExpressOsInSize15;
    @Column(name = "flag_express_os_out_size_15")
    private Long flagExpressOsOutSize15;

    @Column(name = "flag_spcut_in_size_15")
    private Long flagspcutInSize15;
    @Column(name = "flag_spcut_out_size_15")
    private Long flagspcutOutSize15;
    
    @Column(name = "flag_express_spcut_in_size_15")
    private Long flagExpressSpcutInSize15;
    @Column(name = "flag_express_spcut_out_size_15")
    private Long flagExpressSpcutOutSize15;
    
    @Column(name = "flag_spprep_in_size_15")
    private Long flagspprepInSize15;
    @Column(name = "flag_spprep_out_size_15")
    private Long flagspprepOutSize15;
    
    @Column(name = "flag_express_spprep_in_size_15")
    private Long flagExpressSpprepInSize15;
    @Column(name = "flag_express_spprep_out_size_15")
    private Long flagExpressSpprepOutSize15;

    @Column(name = "Size_16")
    private Long Size16;

    @Column(name = "flag_ct_in_size_16")
    private Long flagCtInSize16;
    @Column(name = "flag_ct_out_size_16")
    private Long flagCtOutSize16;
    
    @Column(name = "flag_express_ct_in_size_16")
    private Long flagExpressCtInSize16;
    @Column(name = "flag_express_ct_out_size_16")
    private Long flagExpressCtOutSize16;

    @Column(name = "flag_prep_in_size_16")
    private Long flagPrepInSize16;
    @Column(name = "flag_prep_out_size_16")
    private Long flagPrepOutSize16;
    
    @Column(name = "flag_express_prep_in_size_16")
    private Long flagExpressPrepInSize16;
    @Column(name = "flag_express_prep_out_size_16")
    private Long flagExpressPrepOutSize16;

    @Column(name = "flag_st_in_size_16")
    private Long flagStInSize16;
    @Column(name = "flag_st_out_size_16")
    private Long flagStOutSize16;
    
    @Column(name = "flag_express_st_in_size_16")
    private Long flagExpressStInSize16;
    @Column(name = "flag_express_st_out_size_16")
    private Long flagExpressStOutSize16;

    @Column(name = "flag_as_in_size_16")
    private Long flagAsInSize16;
    @Column(name = "flag_as_out_size_16")
    private Long flagAsOutSize16;
    
    @Column(name = "flag_express_as_in_size_16")
    private Long flagExpressAsInSize16;
    @Column(name = "flag_express_as_out_size_16")
    private Long flagExpressAsOutSize16;

    @Column(name = "flag_sc_in_size_16")
    private Long flagScInSize16;
    @Column(name = "flag_sc_out_size_16")
    private Long flagScOutSize16;
    
    @Column(name = "flag_express_sc_in_size_16")
    private Long flagExpressScInSize16;
    @Column(name = "flag_express_sc_out_size_16")
    private Long flagExpressScOutSize16;

    @Column(name = "flag_ns_in_size_16")
    private Long flagNsInSize16;
    @Column(name = "flag_ns_out_size_16")
    private Long flagNsOutSize16;
    
    @Column(name = "flag_express_ns_in_size_16")
    private Long flagExpressNsInSize16;
    @Column(name = "flag_express_ns_out_size_16")
    private Long flagExpressNsOutSize16;
    
    @Column(name = "flag_csc_in_size_16")
    private Long flagCscInSize16;
    @Column(name = "flag_csc_out_size_16")
    private Long flagCscOutSize16;
    
    @Column(name = "flag_express_csc_in_size_16")
    private Long flagExpressCscInSize16;
    @Column(name = "flag_express_csc_out_size_16")
    private Long flagExpressCscOutSize16;

    @Column(name = "flag_os_in_size_16")
    private Long flagOsInSize16;
    @Column(name = "flag_os_out_size_16")
    private Long flagOsOutSize16;
    
    @Column(name = "flag_express_os_in_size_16")
    private Long flagExpressOsInSize16;
    @Column(name = "flag_express_os_out_size_16")
    private Long flagExpressOSOutSize16;

    @Column(name = "flag_spcut_in_size_16")
    private Long flagspcutInSize16;
    @Column(name = "flag_spcut_out_size_16")
    private Long flagspcutOutSize16;
    @Column(name = "flag_spprep_in_size_16")
    private Long flagspprepInSize16;
    @Column(name = "flag_spprep_out_size_16")
    private Long flagspprepOutSize16;

    @Column(name = "Size_17")
    private Long Size17;

    @Column(name = "flag_ct_in_size_17")
    private Long flagCtInSize17;

    @Column(name = "flag_ct_out_size_17")
    private Long flagCtOutSize17;

    @Column(name = "flag_prep_in_size_17")
    private Long flagPrepInSize17;

    @Column(name = "flag_prep_out_size_17")
    private Long flagPrepOutSize17;

    @Column(name = "flag_st_in_size_17")
    private Long flagStInSize17;

    @Column(name = "flag_st_out_size_17")
    private Long flagStOutSize17;

    @Column(name = "flag_as_in_size_17")
    private Long flagAsInSize17;

    @Column(name = "flag_as_out_size_17")
    private Long flagAsOutSize17;

    @Column(name = "flag_sc_in_size_17")
    private Long flagScInSize17;

    @Column(name = "flag_sc_out_size_17")
    private Long flagScOutSize17;

    @Column(name = "flag_ns_in_size_17")
    private Long flagNsInSize17;

    @Column(name = "flag_ns_out_size_17")
    private Long flagNsOutSize17;

    @Column(name = "flag_csc_in_size_17")
    private Long flagCscInSize17;

    @Column(name = "flag_csc_out_size_17")
    private Long flagCscOutSize17;

    @Column(name = "flag_os_in_size_17")
    private Long flagOsInSize17;

    @Column(name = "flag_os_out_size_17")
    private Long flagOsOutSize17;

    @Column(name = "flag_spcut_in_size_17")
    private Long flagspcutInSize17;
    @Column(name = "flag_spcut_out_size_17")
    private Long flagspcutOutSize17;
    @Column(name = "flag_spprep_in_size_17")
    private Long flagspprepInSize17;
    @Column(name = "flag_spprep_out_size_17")
    private Long flagspprepOutSize17;

    @Column(name = "Size_18")
    private Long Size18;

    @Column(name = "flag_ct_in_size_18")
    private Long flagCtInSize18;

    @Column(name = "flag_ct_out_size_18")
    private Long flagCtOutSize18;

    @Column(name = "flag_prep_in_size_18")
    private Long flagPrepInSize18;

    @Column(name = "flag_prep_out_size_18")
    private Long flagPrepOutSize18;

    @Column(name = "flag_st_in_size_18")
    private Long flagStInSize18;

    @Column(name = "flag_st_out_size_18")
    private Long flagStOutSize18;

    @Column(name = "flag_as_in_size_18")
    private Long flagAsInSize18;

    @Column(name = "flag_as_out_size_18")
    private Long flagAsOutSize18;

    @Column(name = "flag_sc_in_size_18")
    private Long flagScInSize18;

    @Column(name = "flag_sc_out_size_18")
    private Long flagScOutSize18;

    @Column(name = "flag_ns_in_size_18")
    private Long flagNsInSize18;

    @Column(name = "flag_ns_out_size_18")
    private Long flagNsOutSize18;

    @Column(name = "flag_csc_in_size_18")
    private Long flagCscInSize18;

    @Column(name = "flag_csc_out_size_18")
    private Long flagCscOutSize18;

    @Column(name = "flag_os_in_size_18")
    private Long flagOsInSize18;

    @Column(name = "flag_os_out_size_18")
    private Long flagOsOutSize18;

    @Column(name = "flag_spcut_in_size_18")
    private Long flagspcutInSize18;
    @Column(name = "flag_spcut_out_size_18")
    private Long flagspcutOutSize18;
    @Column(name = "flag_spprep_in_size_18")
    private Long flagspprepInSize18;
    @Column(name = "flag_spprep_out_size_18")
    private Long flagspprepOutSize18;

    @Column(name = "line_code")
    private String lineCode;

    @Column(name = "po_item")
    private String poItem;

    @Column(name = "po_no")
    private String poNo;

    @Column(name = "demand_class")
    private String demandClass;

//    new add laser and label
    @Column(name = "flag_label_in_size_1")
    private Long flagLabelInSize1;
    @Column(name = "flag_label_in_size_1_t")
    private Long flagLabelInSize1T;
    @Column(name = "flag_label_in_size_2")
    private Long flagLabelInSize2;
    @Column(name = "flag_label_in_size_2_t")
    private Long flagLabelInSize2T;
    @Column(name = "flag_label_in_size_3")
    private Long flagLabelInSize3;
    @Column(name = "flag_label_in_size_3_t")
    private Long flagLabelInSize3T;
    @Column(name = "flag_label_in_size_4")
    private Long flagLabelInSize4;
    @Column(name = "flag_label_in_size_4_t")
    private Long flagLabelInSize4T;
    @Column(name = "flag_label_in_size_5")
    private Long flagLabelInSize5;
    @Column(name = "flag_label_in_size_5_t")
    private Long flagLabelInSize5T;
    @Column(name = "flag_label_in_size_6")
    private Long flagLabelInSize6;
    @Column(name = "flag_label_in_size_6_t")
    private Long flagLabelInSize6T;
    @Column(name = "flag_label_in_size_7")
    private Long flagLabelInSize7;
    @Column(name = "flag_label_in_size_7_t")
    private Long flagLabelInSize7T;
    @Column(name = "flag_label_in_size_8")
    private Long flagLabelInSize8;
    @Column(name = "flag_label_in_size_8_t")
    private Long flagLabelInSize8T;
    @Column(name = "flag_label_in_size_9")
    private Long flagLabelInSize9;
    @Column(name = "flag_label_in_size_9_t")
    private Long flagLabelInSize9T;
    @Column(name = "flag_label_in_size_10")
    private Long flagLabelInSize10;
    @Column(name = "flag_label_in_size_10_t")
    private Long flagLabelInSize10T;
    @Column(name = "flag_label_in_size_11")
    private Long flagLabelInSize11;
    @Column(name = "flag_label_in_size_11_t")
    private Long flagLabelInSize11T;
    @Column(name = "flag_label_in_size_12")
    private Long flagLabelInSize12;
    @Column(name = "flag_label_in_size_12_t")
    private Long flagLabelInSize12T;
    @Column(name = "flag_label_in_size_13")
    private Long flagLabelInSize13;
    @Column(name = "flag_label_in_size_13_t")
    private Long flagLabelInSize13T;
    @Column(name = "flag_label_in_size_14")
    private Long flagLabelInSize14;
    @Column(name = "flag_label_in_size_15")
    private Long flagLabelInSize15;
    @Column(name = "flag_label_in_size_16")
    private Long flagLabelInSize16;
    @Column(name = "flag_label_in_size_17")
    private Long flagLabelInSize17;
    @Column(name = "flag_label_in_size_18")
    private Long flagLabelInSize18;
    
    @Column(name = "flag_laser_in_size_1")
    private Long flagLaserInSize1;
    @Column(name = "flag_laser_in_size_1_t")
    private Long flagLaserInSize1T;
    @Column(name = "flag_laser_in_size_2")
    private Long flagLaserInSize2;
    @Column(name = "flag_laser_in_size_2_t")
    private Long flagLaserInSize2T;
    @Column(name = "flag_laser_in_size_3")
    private Long flagLaserInSize3;
    @Column(name = "flag_laser_in_size_3_t")
    private Long flagLaserInSize3T;
    @Column(name = "flag_laser_in_size_4")
    private Long flagLaserInSize4;
    @Column(name = "flag_laser_in_size_4_t")
    private Long flagLaserInSize4T;
    @Column(name = "flag_laser_in_size_5")
    private Long flagLaserInSize5;
    @Column(name = "flag_laser_in_size_5_t")
    private Long flagLaserInSize5T;
    @Column(name = "flag_laser_in_size_6")
    private Long flagLaserInSize6;
    @Column(name = "flag_laser_in_size_6_t")
    private Long flagLaserInSize6T;
    @Column(name = "flag_laser_in_size_7")
    private Long flagLaserInSize7;
    @Column(name = "flag_laser_in_size_7_t")
    private Long flagLaserInSize7T;
    @Column(name = "flag_laser_in_size_8")
    private Long flagLaserInSize8;
    @Column(name = "flag_laser_in_size_8_t")
    private Long flagLaserInSize8T;
    @Column(name = "flag_laser_in_size_9")
    private Long flagLaserInSize9;
    @Column(name = "flag_laser_in_size_9_t")
    private Long flagLaserInSize9T;
    @Column(name = "flag_laser_in_size_10")
    private Long flagLaserInSize10;
    @Column(name = "flag_laser_in_size_10_t")
    private Long flagLaserInSize10T;
    @Column(name = "flag_laser_in_size_11")
    private Long flagLaserInSize11;
    @Column(name = "flag_laser_in_size_11_t")
    private Long flagLaserInSize11T;
    @Column(name = "flag_laser_in_size_12")
    private Long flagLaserInSize12;
    @Column(name = "flag_laser_in_size_12_t")
    private Long flagLaserInSize12T;
    @Column(name = "flag_laser_in_size_13")
    private Long flagLaserInSize13;
    @Column(name = "flag_laser_in_size_13_t")
    private Long flagLaserInSize13T;
    @Column(name = "flag_laser_in_size_14")
    private Long flagLaserInSize14;
    @Column(name = "flag_laser_in_size_15")
    private Long flagLaserInSize15;
    @Column(name = "flag_laser_in_size_16")
    private Long flagLaserInSize16;
    @Column(name = "flag_laser_in_size_17")
    private Long flagLaserInSize17;
    @Column(name = "flag_laser_in_size_18")
    private Long flagLaserInSize18;
    
    @Column(name = "flag_label_out_size_1")
    private Long flagLabelOutSize1;
    @Column(name = "flag_label_out_size_1_t")
    private Long flagLabelOutSize1T;
    @Column(name = "flag_label_out_size_2")
    private Long flagLabelOutSize2;
    @Column(name = "flag_label_out_size_2_t")
    private Long flagLabelOutSize2T;
    @Column(name = "flag_label_out_size_3")
    private Long flagLabelOutSize3;
    @Column(name = "flag_label_out_size_3_t")
    private Long flagLabelOutSize3T;
    @Column(name = "flag_label_out_size_4")
    private Long flagLabelOutSize4;
    @Column(name = "flag_label_out_size_4_t")
    private Long flagLabelOutSize4T;
    @Column(name = "flag_label_out_size_5")
    private Long flagLabelOutSize5;
    @Column(name = "flag_label_out_size_5_t")
    private Long flagLabelOutSize5T;
    @Column(name = "flag_label_out_size_6")
    private Long flagLabelOutSize6;
    @Column(name = "flag_label_out_size_6_t")
    private Long flagLabelOutSize6T;
    @Column(name = "flag_label_out_size_7")
    private Long flagLabelOutSize7;
    @Column(name = "flag_label_out_size_7_t")
    private Long flagLabelOutSize7T;
    @Column(name = "flag_label_out_size_8")
    private Long flagLabelOutSize8;
    @Column(name = "flag_label_out_size_8_t")
    private Long flagLabelOutSize8T;
    @Column(name = "flag_label_out_size_9")
    private Long flagLabelOutSize9;
    @Column(name = "flag_label_out_size_9_t")
    private Long flagLabelOutSize9T;
    @Column(name = "flag_label_out_size_10")
    private Long flagLabelOutSize10;
    @Column(name = "flag_label_out_size_10_t")
    private Long flagLabelOutSize10T;
    @Column(name = "flag_label_out_size_11")
    private Long flagLabelOutSize11;
    @Column(name = "flag_label_out_size_11_t")
    private Long flagLabelOutSize11T;
    @Column(name = "flag_label_out_size_12")
    private Long flagLabelOutSize12;
    @Column(name = "flag_label_out_size_12_t")
    private Long flagLabelOutSize12T;
    @Column(name = "flag_label_out_size_13")
    private Long flagLabelOutSize13;
    @Column(name = "flag_label_out_size_13_t")
    private Long flagLabelOutSize13T;
    @Column(name = "flag_label_out_size_14")
    private Long flagLabelOutSize14;
    @Column(name = "flag_label_out_size_15")
    private Long flagLabelOutSize15;
    @Column(name = "flag_label_out_size_16")
    private Long flagLabelOutSize16;
    @Column(name = "flag_label_out_size_17")
    private Long flagLabelOutSize17;
    @Column(name = "flag_label_out_size_18")
    private Long flagLabelOutSize18;
    
    @Column(name = "flag_laser_out_size_1")
    private Long flagLaserOutSize1;
    @Column(name = "flag_laser_out_size_1_t")
    private Long flagLaserOutSize1T;
    @Column(name = "flag_laser_out_size_2")
    private Long flagLaserOutSize2;
    @Column(name = "flag_laser_out_size_2_t")
    private Long flagLaserOutSize2T;
    @Column(name = "flag_laser_out_size_3")
    private Long flagLaserOutSize3;
    @Column(name = "flag_laser_out_size_3_t")
    private Long flagLaserOutSize3T;
    @Column(name = "flag_laser_out_size_4")
    private Long flagLaserOutSize4;
    @Column(name = "flag_laser_out_size_4_t")
    private Long flagLaserOutSize4T;
    @Column(name = "flag_laser_out_size_5")
    private Long flagLaserOutSize5;
    @Column(name = "flag_laser_out_size_5_t")
    private Long flagLaserOutSize5T;
    @Column(name = "flag_laser_out_size_6")
    private Long flagLaserOutSize6;
    @Column(name = "flag_laser_out_size_6_t")
    private Long flagLaserOutSize6T;
    @Column(name = "flag_laser_out_size_7")
    private Long flagLaserOutSize7;
    @Column(name = "flag_laser_out_size_7_t")
    private Long flagLaserOutSize7T;
    @Column(name = "flag_laser_out_size_8")
    private Long flagLaserOutSize8;
    @Column(name = "flag_laser_out_size_8_t")
    private Long flagLaserOutSize8T;
    @Column(name = "flag_laser_out_size_9")
    private Long flagLaserOutSize9;
    @Column(name = "flag_laser_out_size_9_t")
    private Long flagLaserOutSize9T;
    @Column(name = "flag_laser_out_size_10")
    private Long flagLaserOutSize10;
    @Column(name = "flag_laser_out_size_10_t")
    private Long flagLaserOutSize10T;
    @Column(name = "flag_laser_out_size_11")
    private Long flagLaserOutSize11;
    @Column(name = "flag_laser_out_size_11_t")
    private Long flagLaserOutSize11T;
    @Column(name = "flag_laser_out_size_12")
    private Long flagLaserOutSize12;
    @Column(name = "flag_laser_out_size_12_t")
    private Long flagLaserOutSize12T;
    @Column(name = "flag_laser_out_size_13")
    private Long flagLaserOutSize13;
    @Column(name = "flag_laser_out_size_13_t")
    private Long flagLaserOutSize13T;
    @Column(name = "flag_laser_out_size_14")
    private Long flagLaserOutSize14;
    @Column(name = "flag_laser_out_size_15")
    private Long flagLaserOutSize15;
    @Column(name = "flag_laser_out_size_16")
    private Long flagLaserOutSize16;
    @Column(name = "flag_laser_out_size_17")
    private Long flagLaserOutSize17;
    @Column(name = "flag_laser_out_size_18")
    private Long flagLaserOutSize18;

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     *
     * @return
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     *
     * @param createBy
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     *
     * @return
     */
    public JdcAdpMstUser getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(JdcAdpMstUser user) {
        this.user = user;
    }

    /**
     *
     * @return
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *
     * @param updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     *
     * @return
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     *
     * @param updateBy
     */
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    /**
     *
     * @return
     */
    public Long getHourly() {
        return hourly;
    }

    /**
     *
     * @param hourly
     */
    public void setHourly(Long hourly) {
        this.hourly = hourly;
    }

    /**
     *
     * @return
     */
    public Long getSize1() {
        return Size1;
    }

    /**
     *
     * @param Size1
     */
    public void setSize1(Long Size1) {
        this.Size1 = Size1;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize1() {
        return flagCtInSize1;
    }

    /**
     *
     * @param flagCtInSize1
     */
    public void setFlagCtInSize1(Long flagCtInSize1) {
        this.flagCtInSize1 = flagCtInSize1;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize1() {
        return flagCtOutSize1;
    }

    /**
     *
     * @param flagCtOutSize1
     */
    public void setFlagCtOutSize1(Long flagCtOutSize1) {
        this.flagCtOutSize1 = flagCtOutSize1;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize1() {
        return flagPrepInSize1;
    }

    /**
     *
     * @param flagPrepInSize1
     */
    public void setFlagPrepInSize1(Long flagPrepInSize1) {
        this.flagPrepInSize1 = flagPrepInSize1;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize1() {
        return flagPrepOutSize1;
    }

    /**
     *
     * @param flagPrepOutSize1
     */
    public void setFlagPrepOutSize1(Long flagPrepOutSize1) {
        this.flagPrepOutSize1 = flagPrepOutSize1;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize1() {
        return flagStInSize1;
    }

    /**
     *
     * @param flagStInSize1
     */
    public void setFlagStInSize1(Long flagStInSize1) {
        this.flagStInSize1 = flagStInSize1;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize1() {
        return flagStOutSize1;
    }

    /**
     *
     * @param flagStOutSize1
     */
    public void setFlagStOutSize1(Long flagStOutSize1) {
        this.flagStOutSize1 = flagStOutSize1;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize1() {
        return flagAsInSize1;
    }

    /**
     *
     * @param flagAsInSize1
     */
    public void setFlagAsInSize1(Long flagAsInSize1) {
        this.flagAsInSize1 = flagAsInSize1;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize1() {
        return flagAsOutSize1;
    }

    /**
     *
     * @param flagAsOutSize1
     */
    public void setFlagAsOutSize1(Long flagAsOutSize1) {
        this.flagAsOutSize1 = flagAsOutSize1;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize1() {
        return flagScInSize1;
    }

    /**
     *
     * @param flagScInSize1
     */
    public void setFlagScInSize1(Long flagScInSize1) {
        this.flagScInSize1 = flagScInSize1;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize1() {
        return flagScOutSize1;
    }

    /**
     *
     * @param flagScOutSize1
     */
    public void setFlagScOutSize1(Long flagScOutSize1) {
        this.flagScOutSize1 = flagScOutSize1;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize1() {
        return flagNsInSize1;
    }

    /**
     *
     * @param flagNsInSize1
     */
    public void setFlagNsInSize1(Long flagNsInSize1) {
        this.flagNsInSize1 = flagNsInSize1;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize1() {
        return flagNsOutSize1;
    }

    /**
     *
     * @param flagNsOutSize1
     */
    public void setFlagNsOutSize1(Long flagNsOutSize1) {
        this.flagNsOutSize1 = flagNsOutSize1;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize1() {
        return flagCscInSize1;
    }

    /**
     *
     * @param flagCscInSize1
     */
    public void setFlagCscInSize1(Long flagCscInSize1) {
        this.flagCscInSize1 = flagCscInSize1;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize1() {
        return flagCscOutSize1;
    }

    /**
     *
     * @param flagCscOutSize1
     */
    public void setFlagCscOutSize1(Long flagCscOutSize1) {
        this.flagCscOutSize1 = flagCscOutSize1;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize1() {
        return flagOsInSize1;
    }

    /**
     *
     * @param flagOsInSize1
     */
    public void setFlagOsInSize1(Long flagOsInSize1) {
        this.flagOsInSize1 = flagOsInSize1;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize1() {
        return flagOsOutSize1;
    }

    /**
     *
     * @param flagOsOutSize1
     */
    public void setFlagOsOutSize1(Long flagOsOutSize1) {
        this.flagOsOutSize1 = flagOsOutSize1;
    }

    /**
     *
     * @return
     */
    public Long getSize1T() {
        return Size1T;
    }

    /**
     *
     * @param Size1T
     */
    public void setSize1T(Long Size1T) {
        this.Size1T = Size1T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize1T() {
        return flagCtInSize1T;
    }

    /**
     *
     * @param flagCtInSize1T
     */
    public void setFlagCtInSize1T(Long flagCtInSize1T) {
        this.flagCtInSize1T = flagCtInSize1T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize1T() {
        return flagCtOutSize1T;
    }

    /**
     *
     * @param flagCtOutSize1T
     */
    public void setFlagCtOutSize1T(Long flagCtOutSize1T) {
        this.flagCtOutSize1T = flagCtOutSize1T;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize1T() {
        return flagPrepInSize1T;
    }

    /**
     *
     * @param flagPrepInSize1T
     */
    public void setFlagPrepInSize1T(Long flagPrepInSize1T) {
        this.flagPrepInSize1T = flagPrepInSize1T;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize1T() {
        return flagPrepOutSize1T;
    }

    /**
     *
     * @param flagPrepOutSize1T
     */
    public void setFlagPrepOutSize1T(Long flagPrepOutSize1T) {
        this.flagPrepOutSize1T = flagPrepOutSize1T;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize1T() {
        return flagStInSize1T;
    }

    /**
     *
     * @param flagStInSize1T
     */
    public void setFlagStInSize1T(Long flagStInSize1T) {
        this.flagStInSize1T = flagStInSize1T;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize1T() {
        return flagStOutSize1T;
    }

    /**
     *
     * @param flagStOutSize1T
     */
    public void setFlagStOutSize1T(Long flagStOutSize1T) {
        this.flagStOutSize1T = flagStOutSize1T;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize1T() {
        return flagAsInSize1T;
    }

    /**
     *
     * @param flagAsInSize1T
     */
    public void setFlagAsInSize1T(Long flagAsInSize1T) {
        this.flagAsInSize1T = flagAsInSize1T;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize1T() {
        return flagAsOutSize1T;
    }

    /**
     *
     * @param flagAsOutSize1T
     */
    public void setFlagAsOutSize1T(Long flagAsOutSize1T) {
        this.flagAsOutSize1T = flagAsOutSize1T;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize1T() {
        return flagScInSize1T;
    }

    /**
     *
     * @param flagScInSize1T
     */
    public void setFlagScInSize1T(Long flagScInSize1T) {
        this.flagScInSize1T = flagScInSize1T;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize1T() {
        return flagScOutSize1T;
    }

    /**
     *
     * @param flagScOutSize1T
     */
    public void setFlagScOutSize1T(Long flagScOutSize1T) {
        this.flagScOutSize1T = flagScOutSize1T;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize1T() {
        return flagNsInSize1T;
    }

    /**
     *
     * @param flagNsInSize1T
     */
    public void setFlagNsInSize1T(Long flagNsInSize1T) {
        this.flagNsInSize1T = flagNsInSize1T;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize1T() {
        return flagNsOutSize1T;
    }

    /**
     *
     * @param flagNsOutSize1T
     */
    public void setFlagNsOutSize1T(Long flagNsOutSize1T) {
        this.flagNsOutSize1T = flagNsOutSize1T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize1T() {
        return flagCscInSize1T;
    }

    /**
     *
     * @param flagCscInSize1T
     */
    public void setFlagCscInSize1T(Long flagCscInSize1T) {
        this.flagCscInSize1T = flagCscInSize1T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize1T() {
        return flagCscOutSize1T;
    }

    /**
     *
     * @param flagCscOutSize1T
     */
    public void setFlagCscOutSize1T(Long flagCscOutSize1T) {
        this.flagCscOutSize1T = flagCscOutSize1T;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize1T() {
        return flagOsInSize1T;
    }

    /**
     *
     * @param flagOsInSize1T
     */
    public void setFlagOsInSize1T(Long flagOsInSize1T) {
        this.flagOsInSize1T = flagOsInSize1T;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize1T() {
        return flagOsOutSize1T;
    }

    /**
     *
     * @param flagOsOutSize1T
     */
    public void setFlagOsOutSize1T(Long flagOsOutSize1T) {
        this.flagOsOutSize1T = flagOsOutSize1T;
    }

    /**
     *
     * @return
     */
    public Long getSize2() {
        return Size2;
    }

    /**
     *
     * @param Size2
     */
    public void setSize2(Long Size2) {
        this.Size2 = Size2;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize2() {
        return flagCtInSize2;
    }

    /**
     *
     * @param flagCtInSize2
     */
    public void setFlagCtInSize2(Long flagCtInSize2) {
        this.flagCtInSize2 = flagCtInSize2;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize2() {
        return flagCtOutSize2;
    }

    /**
     *
     * @param flagCtOutSize2
     */
    public void setFlagCtOutSize2(Long flagCtOutSize2) {
        this.flagCtOutSize2 = flagCtOutSize2;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize2() {
        return flagPrepInSize2;
    }

    /**
     *
     * @param flagPrepInSize2
     */
    public void setFlagPrepInSize2(Long flagPrepInSize2) {
        this.flagPrepInSize2 = flagPrepInSize2;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize2() {
        return flagPrepOutSize2;
    }

    /**
     *
     * @param flagPrepOutSize2
     */
    public void setFlagPrepOutSize2(Long flagPrepOutSize2) {
        this.flagPrepOutSize2 = flagPrepOutSize2;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize2() {
        return flagStInSize2;
    }

    /**
     *
     * @param flagStInSize2
     */
    public void setFlagStInSize2(Long flagStInSize2) {
        this.flagStInSize2 = flagStInSize2;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize2() {
        return flagStOutSize2;
    }

    /**
     *
     * @param flagStOutSize2
     */
    public void setFlagStOutSize2(Long flagStOutSize2) {
        this.flagStOutSize2 = flagStOutSize2;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize2() {
        return flagAsInSize2;
    }

    /**
     *
     * @param flagAsInSize2
     */
    public void setFlagAsInSize2(Long flagAsInSize2) {
        this.flagAsInSize2 = flagAsInSize2;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize2() {
        return flagAsOutSize2;
    }

    /**
     *
     * @param flagAsOutSize2
     */
    public void setFlagAsOutSize2(Long flagAsOutSize2) {
        this.flagAsOutSize2 = flagAsOutSize2;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize2() {
        return flagScInSize2;
    }

    /**
     *
     * @param flagScInSize2
     */
    public void setFlagScInSize2(Long flagScInSize2) {
        this.flagScInSize2 = flagScInSize2;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize2() {
        return flagScOutSize2;
    }

    /**
     *
     * @param flagScOutSize2
     */
    public void setFlagScOutSize2(Long flagScOutSize2) {
        this.flagScOutSize2 = flagScOutSize2;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize2() {
        return flagNsInSize2;
    }

    /**
     *
     * @param flagNsInSize2
     */
    public void setFlagNsInSize2(Long flagNsInSize2) {
        this.flagNsInSize2 = flagNsInSize2;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize2() {
        return flagNsOutSize2;
    }

    /**
     *
     * @param flagNsOutSize2
     */
    public void setFlagNsOutSize2(Long flagNsOutSize2) {
        this.flagNsOutSize2 = flagNsOutSize2;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize2() {
        return flagCscInSize2;
    }

    /**
     *
     * @param flagCscInSize2
     */
    public void setFlagCscInSize2(Long flagCscInSize2) {
        this.flagCscInSize2 = flagCscInSize2;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize2() {
        return flagCscOutSize2;
    }

    /**
     *
     * @param flagCscOutSize2
     */
    public void setFlagCscOutSize2(Long flagCscOutSize2) {
        this.flagCscOutSize2 = flagCscOutSize2;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize2() {
        return flagOsInSize2;
    }

    /**
     *
     * @param flagOsInSize2
     */
    public void setFlagOsInSize2(Long flagOsInSize2) {
        this.flagOsInSize2 = flagOsInSize2;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize2() {
        return flagOsOutSize2;
    }

    /**
     *
     * @param flagOsOutSize2
     */
    public void setFlagOsOutSize2(Long flagOsOutSize2) {
        this.flagOsOutSize2 = flagOsOutSize2;
    }

    /**
     *
     * @return
     */
    public Long getSize2T() {
        return Size2T;
    }

    /**
     *
     * @param Size2T
     */
    public void setSize2T(Long Size2T) {
        this.Size2T = Size2T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize2T() {
        return flagCtInSize2T;
    }

    /**
     *
     * @param flagCtInSize2T
     */
    public void setFlagCtInSize2T(Long flagCtInSize2T) {
        this.flagCtInSize2T = flagCtInSize2T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize2T() {
        return flagCtOutSize2T;
    }

    /**
     *
     * @param flagCtOutSize2T
     */
    public void setFlagCtOutSize2T(Long flagCtOutSize2T) {
        this.flagCtOutSize2T = flagCtOutSize2T;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize2T() {
        return flagPrepInSize2T;
    }

    /**
     *
     * @param flagPrepInSize2T
     */
    public void setFlagPrepInSize2T(Long flagPrepInSize2T) {
        this.flagPrepInSize2T = flagPrepInSize2T;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize2T() {
        return flagPrepOutSize2T;
    }

    /**
     *
     * @param flagPrepOutSize2T
     */
    public void setFlagPrepOutSize2T(Long flagPrepOutSize2T) {
        this.flagPrepOutSize2T = flagPrepOutSize2T;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize2T() {
        return flagStInSize2T;
    }

    /**
     *
     * @param flagStInSize2T
     */
    public void setFlagStInSize2T(Long flagStInSize2T) {
        this.flagStInSize2T = flagStInSize2T;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize2T() {
        return flagStOutSize2T;
    }

    /**
     *
     * @param flagStOutSize2T
     */
    public void setFlagStOutSize2T(Long flagStOutSize2T) {
        this.flagStOutSize2T = flagStOutSize2T;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize2T() {
        return flagAsInSize2T;
    }

    /**
     *
     * @param flagAsInSize2T
     */
    public void setFlagAsInSize2T(Long flagAsInSize2T) {
        this.flagAsInSize2T = flagAsInSize2T;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize2T() {
        return flagAsOutSize2T;
    }

    /**
     *
     * @param flagAsOutSize2T
     */
    public void setFlagAsOutSize2T(Long flagAsOutSize2T) {
        this.flagAsOutSize2T = flagAsOutSize2T;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize2T() {
        return flagScInSize2T;
    }

    /**
     *
     * @param flagScInSize2T
     */
    public void setFlagScInSize2T(Long flagScInSize2T) {
        this.flagScInSize2T = flagScInSize2T;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize2T() {
        return flagScOutSize2T;
    }

    /**
     *
     * @param flagScOutSize2T
     */
    public void setFlagScOutSize2T(Long flagScOutSize2T) {
        this.flagScOutSize2T = flagScOutSize2T;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize2T() {
        return flagNsInSize2T;
    }

    /**
     *
     * @param flagNsInSize2T
     */
    public void setFlagNsInSize2T(Long flagNsInSize2T) {
        this.flagNsInSize2T = flagNsInSize2T;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize2T() {
        return flagNsOutSize2T;
    }

    /**
     *
     * @param flagNsOutSize2T
     */
    public void setFlagNsOutSize2T(Long flagNsOutSize2T) {
        this.flagNsOutSize2T = flagNsOutSize2T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize2T() {
        return flagCscInSize2T;
    }

    /**
     *
     * @param flagCscInSize2T
     */
    public void setFlagCscInSize2T(Long flagCscInSize2T) {
        this.flagCscInSize2T = flagCscInSize2T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize2T() {
        return flagCscOutSize2T;
    }

    /**
     *
     * @param flagCscOutSize2T
     */
    public void setFlagCscOutSize2T(Long flagCscOutSize2T) {
        this.flagCscOutSize2T = flagCscOutSize2T;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize2T() {
        return flagOsInSize2T;
    }

    /**
     *
     * @param flagOsInSize2T
     */
    public void setFlagOsInSize2T(Long flagOsInSize2T) {
        this.flagOsInSize2T = flagOsInSize2T;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize2T() {
        return flagOsOutSize2T;
    }

    /**
     *
     * @param flagOsOutSize2T
     */
    public void setFlagOsOutSize2T(Long flagOsOutSize2T) {
        this.flagOsOutSize2T = flagOsOutSize2T;
    }

    /**
     *
     * @return
     */
    public Long getSize3() {
        return Size3;
    }

    /**
     *
     * @param Size3
     */
    public void setSize3(Long Size3) {
        this.Size3 = Size3;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize3() {
        return flagCtInSize3;
    }

    /**
     *
     * @param flagCtInSize3
     */
    public void setFlagCtInSize3(Long flagCtInSize3) {
        this.flagCtInSize3 = flagCtInSize3;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize3() {
        return flagCtOutSize3;
    }

    /**
     *
     * @param flagCtOutSize3
     */
    public void setFlagCtOutSize3(Long flagCtOutSize3) {
        this.flagCtOutSize3 = flagCtOutSize3;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize3() {
        return flagPrepInSize3;
    }

    /**
     *
     * @param flagPrepInSize3
     */
    public void setFlagPrepInSize3(Long flagPrepInSize3) {
        this.flagPrepInSize3 = flagPrepInSize3;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize3() {
        return flagPrepOutSize3;
    }

    /**
     *
     * @param flagPrepOutSize3
     */
    public void setFlagPrepOutSize3(Long flagPrepOutSize3) {
        this.flagPrepOutSize3 = flagPrepOutSize3;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize3() {
        return flagStInSize3;
    }

    /**
     *
     * @param flagStInSize3
     */
    public void setFlagStInSize3(Long flagStInSize3) {
        this.flagStInSize3 = flagStInSize3;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize3() {
        return flagStOutSize3;
    }

    /**
     *
     * @param flagStOutSize3
     */
    public void setFlagStOutSize3(Long flagStOutSize3) {
        this.flagStOutSize3 = flagStOutSize3;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize3() {
        return flagAsInSize3;
    }

    /**
     *
     * @param flagAsInSize3
     */
    public void setFlagAsInSize3(Long flagAsInSize3) {
        this.flagAsInSize3 = flagAsInSize3;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize3() {
        return flagAsOutSize3;
    }

    /**
     *
     * @param flagAsOutSize3
     */
    public void setFlagAsOutSize3(Long flagAsOutSize3) {
        this.flagAsOutSize3 = flagAsOutSize3;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize3() {
        return flagScInSize3;
    }

    /**
     *
     * @param flagScInSize3
     */
    public void setFlagScInSize3(Long flagScInSize3) {
        this.flagScInSize3 = flagScInSize3;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize3() {
        return flagScOutSize3;
    }

    /**
     *
     * @param flagScOutSize3
     */
    public void setFlagScOutSize3(Long flagScOutSize3) {
        this.flagScOutSize3 = flagScOutSize3;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize3() {
        return flagNsInSize3;
    }

    /**
     *
     * @param flagNsInSize3
     */
    public void setFlagNsInSize3(Long flagNsInSize3) {
        this.flagNsInSize3 = flagNsInSize3;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize3() {
        return flagNsOutSize3;
    }

    /**
     *
     * @param flagNsOutSize3
     */
    public void setFlagNsOutSize3(Long flagNsOutSize3) {
        this.flagNsOutSize3 = flagNsOutSize3;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize3() {
        return flagCscInSize3;
    }

    /**
     *
     * @param flagCscInSize3
     */
    public void setFlagCscInSize3(Long flagCscInSize3) {
        this.flagCscInSize3 = flagCscInSize3;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize3() {
        return flagCscOutSize3;
    }

    /**
     *
     * @param flagCscOutSize3
     */
    public void setFlagCscOutSize3(Long flagCscOutSize3) {
        this.flagCscOutSize3 = flagCscOutSize3;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize3() {
        return flagOsInSize3;
    }

    /**
     *
     * @param flagOsInSize3
     */
    public void setFlagOsInSize3(Long flagOsInSize3) {
        this.flagOsInSize3 = flagOsInSize3;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize3() {
        return flagOsOutSize3;
    }

    /**
     *
     * @param flagOsOutSize3
     */
    public void setFlagOsOutSize3(Long flagOsOutSize3) {
        this.flagOsOutSize3 = flagOsOutSize3;
    }

    /**
     *
     * @return
     */
    public Long getSize3T() {
        return Size3T;
    }

    /**
     *
     * @param Size3T
     */
    public void setSize3T(Long Size3T) {
        this.Size3T = Size3T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize3T() {
        return flagCtInSize3T;
    }

    /**
     *
     * @param flagCtInSize3T
     */
    public void setFlagCtInSize3T(Long flagCtInSize3T) {
        this.flagCtInSize3T = flagCtInSize3T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize3T() {
        return flagCtOutSize3T;
    }

    /**
     *
     * @param flagCtOutSize3T
     */
    public void setFlagCtOutSize3T(Long flagCtOutSize3T) {
        this.flagCtOutSize3T = flagCtOutSize3T;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize3T() {
        return flagPrepInSize3T;
    }

    /**
     *
     * @param flagPrepInSize3T
     */
    public void setFlagPrepInSize3T(Long flagPrepInSize3T) {
        this.flagPrepInSize3T = flagPrepInSize3T;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize3T() {
        return flagPrepOutSize3T;
    }

    /**
     *
     * @param flagPrepOutSize3T
     */
    public void setFlagPrepOutSize3T(Long flagPrepOutSize3T) {
        this.flagPrepOutSize3T = flagPrepOutSize3T;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize3T() {
        return flagStInSize3T;
    }

    /**
     *
     * @param flagStInSize3T
     */
    public void setFlagStInSize3T(Long flagStInSize3T) {
        this.flagStInSize3T = flagStInSize3T;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize3T() {
        return flagStOutSize3T;
    }

    /**
     *
     * @param flagStOutSize3T
     */
    public void setFlagStOutSize3T(Long flagStOutSize3T) {
        this.flagStOutSize3T = flagStOutSize3T;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize3T() {
        return flagAsInSize3T;
    }

    /**
     *
     * @param flagAsInSize3T
     */
    public void setFlagAsInSize3T(Long flagAsInSize3T) {
        this.flagAsInSize3T = flagAsInSize3T;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize3T() {
        return flagAsOutSize3T;
    }

    /**
     *
     * @param flagAsOutSize3T
     */
    public void setFlagAsOutSize3T(Long flagAsOutSize3T) {
        this.flagAsOutSize3T = flagAsOutSize3T;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize3T() {
        return flagScInSize3T;
    }

    /**
     *
     * @param flagScInSize3T
     */
    public void setFlagScInSize3T(Long flagScInSize3T) {
        this.flagScInSize3T = flagScInSize3T;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize3T() {
        return flagScOutSize3T;
    }

    /**
     *
     * @param flagScOutSize3T
     */
    public void setFlagScOutSize3T(Long flagScOutSize3T) {
        this.flagScOutSize3T = flagScOutSize3T;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize3T() {
        return flagNsInSize3T;
    }

    /**
     *
     * @param flagNsInSize3T
     */
    public void setFlagNsInSize3T(Long flagNsInSize3T) {
        this.flagNsInSize3T = flagNsInSize3T;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize3T() {
        return flagNsOutSize3T;
    }

    /**
     *
     * @param flagNsOutSize3T
     */
    public void setFlagNsOutSize3T(Long flagNsOutSize3T) {
        this.flagNsOutSize3T = flagNsOutSize3T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize3T() {
        return flagCscInSize3T;
    }

    /**
     *
     * @param flagCscInSize3T
     */
    public void setFlagCscInSize3T(Long flagCscInSize3T) {
        this.flagCscInSize3T = flagCscInSize3T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize3T() {
        return flagCscOutSize3T;
    }

    /**
     *
     * @param flagCscOutSize3T
     */
    public void setFlagCscOutSize3T(Long flagCscOutSize3T) {
        this.flagCscOutSize3T = flagCscOutSize3T;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize3T() {
        return flagOsInSize3T;
    }

    /**
     *
     * @param flagOsInSize3T
     */
    public void setFlagOsInSize3T(Long flagOsInSize3T) {
        this.flagOsInSize3T = flagOsInSize3T;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize3T() {
        return flagOsOutSize3T;
    }

    /**
     *
     * @param flagOsOutSize3T
     */
    public void setFlagOsOutSize3T(Long flagOsOutSize3T) {
        this.flagOsOutSize3T = flagOsOutSize3T;
    }

    /**
     *
     * @return
     */
    public Long getSize4() {
        return Size4;
    }

    /**
     *
     * @param Size4
     */
    public void setSize4(Long Size4) {
        this.Size4 = Size4;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize4() {
        return flagCtInSize4;
    }

    /**
     *
     * @param flagCtInSize4
     */
    public void setFlagCtInSize4(Long flagCtInSize4) {
        this.flagCtInSize4 = flagCtInSize4;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize4() {
        return flagCtOutSize4;
    }

    /**
     *
     * @param flagCtOutSize4
     */
    public void setFlagCtOutSize4(Long flagCtOutSize4) {
        this.flagCtOutSize4 = flagCtOutSize4;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize4() {
        return flagPrepInSize4;
    }

    /**
     *
     * @param flagPrepInSize4
     */
    public void setFlagPrepInSize4(Long flagPrepInSize4) {
        this.flagPrepInSize4 = flagPrepInSize4;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize4() {
        return flagPrepOutSize4;
    }

    /**
     *
     * @param flagPrepOutSize4
     */
    public void setFlagPrepOutSize4(Long flagPrepOutSize4) {
        this.flagPrepOutSize4 = flagPrepOutSize4;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize4() {
        return flagStInSize4;
    }

    /**
     *
     * @param flagStInSize4
     */
    public void setFlagStInSize4(Long flagStInSize4) {
        this.flagStInSize4 = flagStInSize4;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize4() {
        return flagStOutSize4;
    }

    /**
     *
     * @param flagStOutSize4
     */
    public void setFlagStOutSize4(Long flagStOutSize4) {
        this.flagStOutSize4 = flagStOutSize4;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize4() {
        return flagAsInSize4;
    }

    /**
     *
     * @param flagAsInSize4
     */
    public void setFlagAsInSize4(Long flagAsInSize4) {
        this.flagAsInSize4 = flagAsInSize4;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize4() {
        return flagAsOutSize4;
    }

    /**
     *
     * @param flagAsOutSize4
     */
    public void setFlagAsOutSize4(Long flagAsOutSize4) {
        this.flagAsOutSize4 = flagAsOutSize4;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize4() {
        return flagScInSize4;
    }

    /**
     *
     * @param flagScInSize4
     */
    public void setFlagScInSize4(Long flagScInSize4) {
        this.flagScInSize4 = flagScInSize4;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize4() {
        return flagScOutSize4;
    }

    /**
     *
     * @param flagScOutSize4
     */
    public void setFlagScOutSize4(Long flagScOutSize4) {
        this.flagScOutSize4 = flagScOutSize4;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize4() {
        return flagNsInSize4;
    }

    /**
     *
     * @param flagNsInSize4
     */
    public void setFlagNsInSize4(Long flagNsInSize4) {
        this.flagNsInSize4 = flagNsInSize4;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize4() {
        return flagNsOutSize4;
    }

    /**
     *
     * @param flagNsOutSize4
     */
    public void setFlagNsOutSize4(Long flagNsOutSize4) {
        this.flagNsOutSize4 = flagNsOutSize4;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize4() {
        return flagCscInSize4;
    }

    /**
     *
     * @param flagCscInSize4
     */
    public void setFlagCscInSize4(Long flagCscInSize4) {
        this.flagCscInSize4 = flagCscInSize4;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize4() {
        return flagCscOutSize4;
    }

    /**
     *
     * @param flagCscOutSize4
     */
    public void setFlagCscOutSize4(Long flagCscOutSize4) {
        this.flagCscOutSize4 = flagCscOutSize4;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize4() {
        return flagOsInSize4;
    }

    /**
     *
     * @param flagOsInSize4
     */
    public void setFlagOsInSize4(Long flagOsInSize4) {
        this.flagOsInSize4 = flagOsInSize4;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize4() {
        return flagOsOutSize4;
    }

    /**
     *
     * @param flagOsOutSize4
     */
    public void setFlagOsOutSize4(Long flagOsOutSize4) {
        this.flagOsOutSize4 = flagOsOutSize4;
    }

    /**
     *
     * @return
     */
    public Long getSize4T() {
        return Size4T;
    }

    /**
     *
     * @param Size4T
     */
    public void setSize4T(Long Size4T) {
        this.Size4T = Size4T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize4T() {
        return flagCtInSize4T;
    }

    /**
     *
     * @param flagCtInSize4T
     */
    public void setFlagCtInSize4T(Long flagCtInSize4T) {
        this.flagCtInSize4T = flagCtInSize4T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize4T() {
        return flagCtOutSize4T;
    }

    /**
     *
     * @param flagCtOutSize4T
     */
    public void setFlagCtOutSize4T(Long flagCtOutSize4T) {
        this.flagCtOutSize4T = flagCtOutSize4T;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize4T() {
        return flagPrepInSize4T;
    }

    /**
     *
     * @param flagPrepInSize4T
     */
    public void setFlagPrepInSize4T(Long flagPrepInSize4T) {
        this.flagPrepInSize4T = flagPrepInSize4T;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize4T() {
        return flagPrepOutSize4T;
    }

    /**
     *
     * @param flagPrepOutSize4T
     */
    public void setFlagPrepOutSize4T(Long flagPrepOutSize4T) {
        this.flagPrepOutSize4T = flagPrepOutSize4T;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize4T() {
        return flagStInSize4T;
    }

    /**
     *
     * @param flagStInSize4T
     */
    public void setFlagStInSize4T(Long flagStInSize4T) {
        this.flagStInSize4T = flagStInSize4T;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize4T() {
        return flagStOutSize4T;
    }

    /**
     *
     * @param flagStOutSize4T
     */
    public void setFlagStOutSize4T(Long flagStOutSize4T) {
        this.flagStOutSize4T = flagStOutSize4T;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize4T() {
        return flagAsInSize4T;
    }

    /**
     *
     * @param flagAsInSize4T
     */
    public void setFlagAsInSize4T(Long flagAsInSize4T) {
        this.flagAsInSize4T = flagAsInSize4T;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize4T() {
        return flagAsOutSize4T;
    }

    /**
     *
     * @param flagAsOutSize4T
     */
    public void setFlagAsOutSize4T(Long flagAsOutSize4T) {
        this.flagAsOutSize4T = flagAsOutSize4T;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize4T() {
        return flagScInSize4T;
    }

    /**
     *
     * @param flagScInSize4T
     */
    public void setFlagScInSize4T(Long flagScInSize4T) {
        this.flagScInSize4T = flagScInSize4T;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize4T() {
        return flagScOutSize4T;
    }

    /**
     *
     * @param flagScOutSize4T
     */
    public void setFlagScOutSize4T(Long flagScOutSize4T) {
        this.flagScOutSize4T = flagScOutSize4T;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize4T() {
        return flagNsInSize4T;
    }

    /**
     *
     * @param flagNsInSize4T
     */
    public void setFlagNsInSize4T(Long flagNsInSize4T) {
        this.flagNsInSize4T = flagNsInSize4T;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize4T() {
        return flagNsOutSize4T;
    }

    /**
     *
     * @param flagNsOutSize4T
     */
    public void setFlagNsOutSize4T(Long flagNsOutSize4T) {
        this.flagNsOutSize4T = flagNsOutSize4T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize4T() {
        return flagCscInSize4T;
    }

    /**
     *
     * @param flagCscInSize4T
     */
    public void setFlagCscInSize4T(Long flagCscInSize4T) {
        this.flagCscInSize4T = flagCscInSize4T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize4T() {
        return flagCscOutSize4T;
    }

    /**
     *
     * @param flagCscOutSize4T
     */
    public void setFlagCscOutSize4T(Long flagCscOutSize4T) {
        this.flagCscOutSize4T = flagCscOutSize4T;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize4T() {
        return flagOsInSize4T;
    }

    /**
     *
     * @param flagOsInSize4T
     */
    public void setFlagOsInSize4T(Long flagOsInSize4T) {
        this.flagOsInSize4T = flagOsInSize4T;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize4T() {
        return flagOsOutSize4T;
    }

    /**
     *
     * @param flagOsOutSize4T
     */
    public void setFlagOsOutSize4T(Long flagOsOutSize4T) {
        this.flagOsOutSize4T = flagOsOutSize4T;
    }

    /**
     *
     * @return
     */
    public Long getSize5() {
        return Size5;
    }

    /**
     *
     * @param Size5
     */
    public void setSize5(Long Size5) {
        this.Size5 = Size5;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize5() {
        return flagCtInSize5;
    }

    /**
     *
     * @param flagCtInSize5
     */
    public void setFlagCtInSize5(Long flagCtInSize5) {
        this.flagCtInSize5 = flagCtInSize5;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize5() {
        return flagCtOutSize5;
    }

    /**
     *
     * @param flagCtOutSize5
     */
    public void setFlagCtOutSize5(Long flagCtOutSize5) {
        this.flagCtOutSize5 = flagCtOutSize5;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize5() {
        return flagPrepInSize5;
    }

    /**
     *
     * @param flagPrepInSize5
     */
    public void setFlagPrepInSize5(Long flagPrepInSize5) {
        this.flagPrepInSize5 = flagPrepInSize5;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize5() {
        return flagPrepOutSize5;
    }

    /**
     *
     * @param flagPrepOutSize5
     */
    public void setFlagPrepOutSize5(Long flagPrepOutSize5) {
        this.flagPrepOutSize5 = flagPrepOutSize5;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize5() {
        return flagStInSize5;
    }

    /**
     *
     * @param flagStInSize5
     */
    public void setFlagStInSize5(Long flagStInSize5) {
        this.flagStInSize5 = flagStInSize5;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize5() {
        return flagStOutSize5;
    }

    /**
     *
     * @param flagStOutSize5
     */
    public void setFlagStOutSize5(Long flagStOutSize5) {
        this.flagStOutSize5 = flagStOutSize5;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize5() {
        return flagAsInSize5;
    }

    /**
     *
     * @param flagAsInSize5
     */
    public void setFlagAsInSize5(Long flagAsInSize5) {
        this.flagAsInSize5 = flagAsInSize5;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize5() {
        return flagAsOutSize5;
    }

    /**
     *
     * @param flagAsOutSize5
     */
    public void setFlagAsOutSize5(Long flagAsOutSize5) {
        this.flagAsOutSize5 = flagAsOutSize5;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize5() {
        return flagScInSize5;
    }

    /**
     *
     * @param flagScInSize5
     */
    public void setFlagScInSize5(Long flagScInSize5) {
        this.flagScInSize5 = flagScInSize5;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize5() {
        return flagScOutSize5;
    }

    /**
     *
     * @param flagScOutSize5
     */
    public void setFlagScOutSize5(Long flagScOutSize5) {
        this.flagScOutSize5 = flagScOutSize5;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize5() {
        return flagNsInSize5;
    }

    /**
     *
     * @param flagNsInSize5
     */
    public void setFlagNsInSize5(Long flagNsInSize5) {
        this.flagNsInSize5 = flagNsInSize5;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize5() {
        return flagNsOutSize5;
    }

    /**
     *
     * @param flagNsOutSize5
     */
    public void setFlagNsOutSize5(Long flagNsOutSize5) {
        this.flagNsOutSize5 = flagNsOutSize5;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize5() {
        return flagCscInSize5;
    }

    /**
     *
     * @param flagCscInSize5
     */
    public void setFlagCscInSize5(Long flagCscInSize5) {
        this.flagCscInSize5 = flagCscInSize5;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize5() {
        return flagCscOutSize5;
    }

    /**
     *
     * @param flagCscOutSize5
     */
    public void setFlagCscOutSize5(Long flagCscOutSize5) {
        this.flagCscOutSize5 = flagCscOutSize5;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize5() {
        return flagOsInSize5;
    }

    /**
     *
     * @param flagOsInSize5
     */
    public void setFlagOsInSize5(Long flagOsInSize5) {
        this.flagOsInSize5 = flagOsInSize5;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize5() {
        return flagOsOutSize5;
    }

    /**
     *
     * @param flagOsOutSize5
     */
    public void setFlagOsOutSize5(Long flagOsOutSize5) {
        this.flagOsOutSize5 = flagOsOutSize5;
    }

    /**
     *
     * @return
     */
    public Long getSize5T() {
        return Size5T;
    }

    /**
     *
     * @param Size5T
     */
    public void setSize5T(Long Size5T) {
        this.Size5T = Size5T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize5T() {
        return flagCtInSize5T;
    }

    /**
     *
     * @param flagCtInSize5T
     */
    public void setFlagCtInSize5T(Long flagCtInSize5T) {
        this.flagCtInSize5T = flagCtInSize5T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize5T() {
        return flagCtOutSize5T;
    }

    /**
     *
     * @param flagCtOutSize5T
     */
    public void setFlagCtOutSize5T(Long flagCtOutSize5T) {
        this.flagCtOutSize5T = flagCtOutSize5T;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize5T() {
        return flagPrepInSize5T;
    }

    /**
     *
     * @param flagPrepInSize5T
     */
    public void setFlagPrepInSize5T(Long flagPrepInSize5T) {
        this.flagPrepInSize5T = flagPrepInSize5T;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize5T() {
        return flagPrepOutSize5T;
    }

    /**
     *
     * @param flagPrepOutSize5T
     */
    public void setFlagPrepOutSize5T(Long flagPrepOutSize5T) {
        this.flagPrepOutSize5T = flagPrepOutSize5T;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize5T() {
        return flagStInSize5T;
    }

    /**
     *
     * @param flagStInSize5T
     */
    public void setFlagStInSize5T(Long flagStInSize5T) {
        this.flagStInSize5T = flagStInSize5T;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize5T() {
        return flagStOutSize5T;
    }

    /**
     *
     * @param flagStOutSize5T
     */
    public void setFlagStOutSize5T(Long flagStOutSize5T) {
        this.flagStOutSize5T = flagStOutSize5T;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize5T() {
        return flagAsInSize5T;
    }

    /**
     *
     * @param flagAsInSize5T
     */
    public void setFlagAsInSize5T(Long flagAsInSize5T) {
        this.flagAsInSize5T = flagAsInSize5T;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize5T() {
        return flagAsOutSize5T;
    }

    /**
     *
     * @param flagAsOutSize5T
     */
    public void setFlagAsOutSize5T(Long flagAsOutSize5T) {
        this.flagAsOutSize5T = flagAsOutSize5T;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize5T() {
        return flagScInSize5T;
    }

    /**
     *
     * @param flagScInSize5T
     */
    public void setFlagScInSize5T(Long flagScInSize5T) {
        this.flagScInSize5T = flagScInSize5T;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize5T() {
        return flagScOutSize5T;
    }

    /**
     *
     * @param flagScOutSize5T
     */
    public void setFlagScOutSize5T(Long flagScOutSize5T) {
        this.flagScOutSize5T = flagScOutSize5T;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize5T() {
        return flagNsInSize5T;
    }

    /**
     *
     * @param flagNsInSize5T
     */
    public void setFlagNsInSize5T(Long flagNsInSize5T) {
        this.flagNsInSize5T = flagNsInSize5T;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize5T() {
        return flagNsOutSize5T;
    }

    /**
     *
     * @param flagNsOutSize5T
     */
    public void setFlagNsOutSize5T(Long flagNsOutSize5T) {
        this.flagNsOutSize5T = flagNsOutSize5T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize5T() {
        return flagCscInSize5T;
    }

    /**
     *
     * @param flagCscInSize5T
     */
    public void setFlagCscInSize5T(Long flagCscInSize5T) {
        this.flagCscInSize5T = flagCscInSize5T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize5T() {
        return flagCscOutSize5T;
    }

    /**
     *
     * @param flagCscOutSize5T
     */
    public void setFlagCscOutSize5T(Long flagCscOutSize5T) {
        this.flagCscOutSize5T = flagCscOutSize5T;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize5T() {
        return flagOsInSize5T;
    }

    /**
     *
     * @param flagOsInSize5T
     */
    public void setFlagOsInSize5T(Long flagOsInSize5T) {
        this.flagOsInSize5T = flagOsInSize5T;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize5T() {
        return flagOsOutSize5T;
    }

    /**
     *
     * @param flagOsOutSize5T
     */
    public void setFlagOsOutSize5T(Long flagOsOutSize5T) {
        this.flagOsOutSize5T = flagOsOutSize5T;
    }

    /**
     *
     * @return
     */
    public Long getSize6() {
        return Size6;
    }

    /**
     *
     * @param Size6
     */
    public void setSize6(Long Size6) {
        this.Size6 = Size6;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize6() {
        return flagCtInSize6;
    }

    /**
     *
     * @param flagCtInSize6
     */
    public void setFlagCtInSize6(Long flagCtInSize6) {
        this.flagCtInSize6 = flagCtInSize6;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize6() {
        return flagCtOutSize6;
    }

    /**
     *
     * @param flagCtOutSize6
     */
    public void setFlagCtOutSize6(Long flagCtOutSize6) {
        this.flagCtOutSize6 = flagCtOutSize6;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize6() {
        return flagPrepInSize6;
    }

    /**
     *
     * @param flagPrepInSize6
     */
    public void setFlagPrepInSize6(Long flagPrepInSize6) {
        this.flagPrepInSize6 = flagPrepInSize6;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize6() {
        return flagPrepOutSize6;
    }

    /**
     *
     * @param flagPrepOutSize6
     */
    public void setFlagPrepOutSize6(Long flagPrepOutSize6) {
        this.flagPrepOutSize6 = flagPrepOutSize6;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize6() {
        return flagStInSize6;
    }

    /**
     *
     * @param flagStInSize6
     */
    public void setFlagStInSize6(Long flagStInSize6) {
        this.flagStInSize6 = flagStInSize6;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize6() {
        return flagStOutSize6;
    }

    /**
     *
     * @param flagStOutSize6
     */
    public void setFlagStOutSize6(Long flagStOutSize6) {
        this.flagStOutSize6 = flagStOutSize6;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize6() {
        return flagAsInSize6;
    }

    /**
     *
     * @param flagAsInSize6
     */
    public void setFlagAsInSize6(Long flagAsInSize6) {
        this.flagAsInSize6 = flagAsInSize6;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize6() {
        return flagAsOutSize6;
    }

    /**
     *
     * @param flagAsOutSize6
     */
    public void setFlagAsOutSize6(Long flagAsOutSize6) {
        this.flagAsOutSize6 = flagAsOutSize6;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize6() {
        return flagScInSize6;
    }

    /**
     *
     * @param flagScInSize6
     */
    public void setFlagScInSize6(Long flagScInSize6) {
        this.flagScInSize6 = flagScInSize6;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize6() {
        return flagScOutSize6;
    }

    /**
     *
     * @param flagScOutSize6
     */
    public void setFlagScOutSize6(Long flagScOutSize6) {
        this.flagScOutSize6 = flagScOutSize6;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize6() {
        return flagNsInSize6;
    }

    /**
     *
     * @param flagNsInSize6
     */
    public void setFlagNsInSize6(Long flagNsInSize6) {
        this.flagNsInSize6 = flagNsInSize6;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize6() {
        return flagNsOutSize6;
    }

    /**
     *
     * @param flagNsOutSize6
     */
    public void setFlagNsOutSize6(Long flagNsOutSize6) {
        this.flagNsOutSize6 = flagNsOutSize6;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize6() {
        return flagCscInSize6;
    }

    /**
     *
     * @param flagCscInSize6
     */
    public void setFlagCscInSize6(Long flagCscInSize6) {
        this.flagCscInSize6 = flagCscInSize6;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize6() {
        return flagCscOutSize6;
    }

    /**
     *
     * @param flagCscOutSize6
     */
    public void setFlagCscOutSize6(Long flagCscOutSize6) {
        this.flagCscOutSize6 = flagCscOutSize6;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize6() {
        return flagOsInSize6;
    }

    /**
     *
     * @param flagOsInSize6
     */
    public void setFlagOsInSize6(Long flagOsInSize6) {
        this.flagOsInSize6 = flagOsInSize6;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize6() {
        return flagOsOutSize6;
    }

    /**
     *
     * @param flagOsOutSize6
     */
    public void setFlagOsOutSize6(Long flagOsOutSize6) {
        this.flagOsOutSize6 = flagOsOutSize6;
    }

    /**
     *
     * @return
     */
    public Long getSize6T() {
        return Size6T;
    }

    /**
     *
     * @param Size6T
     */
    public void setSize6T(Long Size6T) {
        this.Size6T = Size6T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize6T() {
        return flagCtInSize6T;
    }

    /**
     *
     * @param flagCtInSize6T
     */
    public void setFlagCtInSize6T(Long flagCtInSize6T) {
        this.flagCtInSize6T = flagCtInSize6T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize6T() {
        return flagCtOutSize6T;
    }

    /**
     *
     * @param flagCtOutSize6T
     */
    public void setFlagCtOutSize6T(Long flagCtOutSize6T) {
        this.flagCtOutSize6T = flagCtOutSize6T;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize6T() {
        return flagPrepInSize6T;
    }

    /**
     *
     * @param flagPrepInSize6T
     */
    public void setFlagPrepInSize6T(Long flagPrepInSize6T) {
        this.flagPrepInSize6T = flagPrepInSize6T;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize6T() {
        return flagPrepOutSize6T;
    }

    /**
     *
     * @param flagPrepOutSize6T
     */
    public void setFlagPrepOutSize6T(Long flagPrepOutSize6T) {
        this.flagPrepOutSize6T = flagPrepOutSize6T;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize6T() {
        return flagStInSize6T;
    }

    /**
     *
     * @param flagStInSize6T
     */
    public void setFlagStInSize6T(Long flagStInSize6T) {
        this.flagStInSize6T = flagStInSize6T;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize6T() {
        return flagStOutSize6T;
    }

    /**
     *
     * @param flagStOutSize6T
     */
    public void setFlagStOutSize6T(Long flagStOutSize6T) {
        this.flagStOutSize6T = flagStOutSize6T;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize6T() {
        return flagAsInSize6T;
    }

    /**
     *
     * @param flagAsInSize6T
     */
    public void setFlagAsInSize6T(Long flagAsInSize6T) {
        this.flagAsInSize6T = flagAsInSize6T;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize6T() {
        return flagAsOutSize6T;
    }

    /**
     *
     * @param flagAsOutSize6T
     */
    public void setFlagAsOutSize6T(Long flagAsOutSize6T) {
        this.flagAsOutSize6T = flagAsOutSize6T;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize6T() {
        return flagScInSize6T;
    }

    /**
     *
     * @param flagScInSize6T
     */
    public void setFlagScInSize6T(Long flagScInSize6T) {
        this.flagScInSize6T = flagScInSize6T;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize6T() {
        return flagScOutSize6T;
    }

    /**
     *
     * @param flagScOutSize6T
     */
    public void setFlagScOutSize6T(Long flagScOutSize6T) {
        this.flagScOutSize6T = flagScOutSize6T;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize6T() {
        return flagNsInSize6T;
    }

    /**
     *
     * @param flagNsInSize6T
     */
    public void setFlagNsInSize6T(Long flagNsInSize6T) {
        this.flagNsInSize6T = flagNsInSize6T;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize6T() {
        return flagNsOutSize6T;
    }

    /**
     *
     * @param flagNsOutSize6T
     */
    public void setFlagNsOutSize6T(Long flagNsOutSize6T) {
        this.flagNsOutSize6T = flagNsOutSize6T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize6T() {
        return flagCscInSize6T;
    }

    /**
     *
     * @param flagCscInSize6T
     */
    public void setFlagCscInSize6T(Long flagCscInSize6T) {
        this.flagCscInSize6T = flagCscInSize6T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize6T() {
        return flagCscOutSize6T;
    }

    /**
     *
     * @param flagCscOutSize6T
     */
    public void setFlagCscOutSize6T(Long flagCscOutSize6T) {
        this.flagCscOutSize6T = flagCscOutSize6T;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize6T() {
        return flagOsInSize6T;
    }

    /**
     *
     * @param flagOsInSize6T
     */
    public void setFlagOsInSize6T(Long flagOsInSize6T) {
        this.flagOsInSize6T = flagOsInSize6T;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize6T() {
        return flagOsOutSize6T;
    }

    /**
     *
     * @param flagOsOutSize6T
     */
    public void setFlagOsOutSize6T(Long flagOsOutSize6T) {
        this.flagOsOutSize6T = flagOsOutSize6T;
    }

    /**
     *
     * @return
     */
    public Long getSize7() {
        return Size7;
    }

    /**
     *
     * @param Size7
     */
    public void setSize7(Long Size7) {
        this.Size7 = Size7;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize7() {
        return flagCtInSize7;
    }

    /**
     *
     * @param flagCtInSize7
     */
    public void setFlagCtInSize7(Long flagCtInSize7) {
        this.flagCtInSize7 = flagCtInSize7;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize7() {
        return flagCtOutSize7;
    }

    /**
     *
     * @param flagCtOutSize7
     */
    public void setFlagCtOutSize7(Long flagCtOutSize7) {
        this.flagCtOutSize7 = flagCtOutSize7;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize7() {
        return flagPrepInSize7;
    }

    /**
     *
     * @param flagPrepInSize7
     */
    public void setFlagPrepInSize7(Long flagPrepInSize7) {
        this.flagPrepInSize7 = flagPrepInSize7;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize7() {
        return flagPrepOutSize7;
    }

    /**
     *
     * @param flagPrepOutSize7
     */
    public void setFlagPrepOutSize7(Long flagPrepOutSize7) {
        this.flagPrepOutSize7 = flagPrepOutSize7;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize7() {
        return flagStInSize7;
    }

    /**
     *
     * @param flagStInSize7
     */
    public void setFlagStInSize7(Long flagStInSize7) {
        this.flagStInSize7 = flagStInSize7;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize7() {
        return flagStOutSize7;
    }

    /**
     *
     * @param flagStOutSize7
     */
    public void setFlagStOutSize7(Long flagStOutSize7) {
        this.flagStOutSize7 = flagStOutSize7;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize7() {
        return flagAsInSize7;
    }

    /**
     *
     * @param flagAsInSize7
     */
    public void setFlagAsInSize7(Long flagAsInSize7) {
        this.flagAsInSize7 = flagAsInSize7;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize7() {
        return flagAsOutSize7;
    }

    /**
     *
     * @param flagAsOutSize7
     */
    public void setFlagAsOutSize7(Long flagAsOutSize7) {
        this.flagAsOutSize7 = flagAsOutSize7;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize7() {
        return flagScInSize7;
    }

    /**
     *
     * @param flagScInSize7
     */
    public void setFlagScInSize7(Long flagScInSize7) {
        this.flagScInSize7 = flagScInSize7;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize7() {
        return flagScOutSize7;
    }

    /**
     *
     * @param flagScOutSize7
     */
    public void setFlagScOutSize7(Long flagScOutSize7) {
        this.flagScOutSize7 = flagScOutSize7;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize7() {
        return flagNsInSize7;
    }

    /**
     *
     * @param flagNsInSize7
     */
    public void setFlagNsInSize7(Long flagNsInSize7) {
        this.flagNsInSize7 = flagNsInSize7;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize7() {
        return flagNsOutSize7;
    }

    /**
     *
     * @param flagNsOutSize7
     */
    public void setFlagNsOutSize7(Long flagNsOutSize7) {
        this.flagNsOutSize7 = flagNsOutSize7;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize7() {
        return flagCscInSize7;
    }

    /**
     *
     * @param flagCscInSize7
     */
    public void setFlagCscInSize7(Long flagCscInSize7) {
        this.flagCscInSize7 = flagCscInSize7;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize7() {
        return flagCscOutSize7;
    }

    /**
     *
     * @param flagCscOutSize7
     */
    public void setFlagCscOutSize7(Long flagCscOutSize7) {
        this.flagCscOutSize7 = flagCscOutSize7;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize7() {
        return flagOsInSize7;
    }

    /**
     *
     * @param flagOsInSize7
     */
    public void setFlagOsInSize7(Long flagOsInSize7) {
        this.flagOsInSize7 = flagOsInSize7;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize7() {
        return flagOsOutSize7;
    }

    /**
     *
     * @param flagOsOutSize7
     */
    public void setFlagOsOutSize7(Long flagOsOutSize7) {
        this.flagOsOutSize7 = flagOsOutSize7;
    }

    /**
     *
     * @return
     */
    public Long getSize7T() {
        return Size7T;
    }

    /**
     *
     * @param Size7T
     */
    public void setSize7T(Long Size7T) {
        this.Size7T = Size7T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize7T() {
        return flagCtInSize7T;
    }

    /**
     *
     * @param flagCtInSize7T
     */
    public void setFlagCtInSize7T(Long flagCtInSize7T) {
        this.flagCtInSize7T = flagCtInSize7T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize7T() {
        return flagCtOutSize7T;
    }

    /**
     *
     * @param flagCtOutSize7T
     */
    public void setFlagCtOutSize7T(Long flagCtOutSize7T) {
        this.flagCtOutSize7T = flagCtOutSize7T;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize7T() {
        return flagPrepInSize7T;
    }

    /**
     *
     * @param flagPrepInSize7T
     */
    public void setFlagPrepInSize7T(Long flagPrepInSize7T) {
        this.flagPrepInSize7T = flagPrepInSize7T;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize7T() {
        return flagPrepOutSize7T;
    }

    /**
     *
     * @param flagPrepOutSize7T
     */
    public void setFlagPrepOutSize7T(Long flagPrepOutSize7T) {
        this.flagPrepOutSize7T = flagPrepOutSize7T;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize7T() {
        return flagStInSize7T;
    }

    /**
     *
     * @param flagStInSize7T
     */
    public void setFlagStInSize7T(Long flagStInSize7T) {
        this.flagStInSize7T = flagStInSize7T;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize7T() {
        return flagStOutSize7T;
    }

    /**
     *
     * @param flagStOutSize7T
     */
    public void setFlagStOutSize7T(Long flagStOutSize7T) {
        this.flagStOutSize7T = flagStOutSize7T;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize7T() {
        return flagAsInSize7T;
    }

    /**
     *
     * @param flagAsInSize7T
     */
    public void setFlagAsInSize7T(Long flagAsInSize7T) {
        this.flagAsInSize7T = flagAsInSize7T;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize7T() {
        return flagAsOutSize7T;
    }

    /**
     *
     * @param flagAsOutSize7T
     */
    public void setFlagAsOutSize7T(Long flagAsOutSize7T) {
        this.flagAsOutSize7T = flagAsOutSize7T;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize7T() {
        return flagScInSize7T;
    }

    /**
     *
     * @param flagScInSize7T
     */
    public void setFlagScInSize7T(Long flagScInSize7T) {
        this.flagScInSize7T = flagScInSize7T;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize7T() {
        return flagScOutSize7T;
    }

    /**
     *
     * @param flagScOutSize7T
     */
    public void setFlagScOutSize7T(Long flagScOutSize7T) {
        this.flagScOutSize7T = flagScOutSize7T;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize7T() {
        return flagNsInSize7T;
    }

    /**
     *
     * @param flagNsInSize7T
     */
    public void setFlagNsInSize7T(Long flagNsInSize7T) {
        this.flagNsInSize7T = flagNsInSize7T;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize7T() {
        return flagNsOutSize7T;
    }

    /**
     *
     * @param flagNsOutSize7T
     */
    public void setFlagNsOutSize7T(Long flagNsOutSize7T) {
        this.flagNsOutSize7T = flagNsOutSize7T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize7T() {
        return flagCscInSize7T;
    }

    /**
     *
     * @param flagCscInSize7T
     */
    public void setFlagCscInSize7T(Long flagCscInSize7T) {
        this.flagCscInSize7T = flagCscInSize7T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize7T() {
        return flagCscOutSize7T;
    }

    /**
     *
     * @param flagCscOutSize7T
     */
    public void setFlagCscOutSize7T(Long flagCscOutSize7T) {
        this.flagCscOutSize7T = flagCscOutSize7T;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize7T() {
        return flagOsInSize7T;
    }

    /**
     *
     * @param flagOsInSize7T
     */
    public void setFlagOsInSize7T(Long flagOsInSize7T) {
        this.flagOsInSize7T = flagOsInSize7T;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize7T() {
        return flagOsOutSize7T;
    }

    /**
     *
     * @param flagOsOutSize7T
     */
    public void setFlagOsOutSize7T(Long flagOsOutSize7T) {
        this.flagOsOutSize7T = flagOsOutSize7T;
    }

    /**
     *
     * @return
     */
    public Long getSize8() {
        return Size8;
    }

    /**
     *
     * @param Size8
     */
    public void setSize8(Long Size8) {
        this.Size8 = Size8;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize8() {
        return flagCtInSize8;
    }

    /**
     *
     * @param flagCtInSize8
     */
    public void setFlagCtInSize8(Long flagCtInSize8) {
        this.flagCtInSize8 = flagCtInSize8;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize8() {
        return flagCtOutSize8;
    }

    /**
     *
     * @param flagCtOutSize8
     */
    public void setFlagCtOutSize8(Long flagCtOutSize8) {
        this.flagCtOutSize8 = flagCtOutSize8;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize8() {
        return flagPrepInSize8;
    }

    /**
     *
     * @param flagPrepInSize8
     */
    public void setFlagPrepInSize8(Long flagPrepInSize8) {
        this.flagPrepInSize8 = flagPrepInSize8;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize8() {
        return flagPrepOutSize8;
    }

    /**
     *
     * @param flagPrepOutSize8
     */
    public void setFlagPrepOutSize8(Long flagPrepOutSize8) {
        this.flagPrepOutSize8 = flagPrepOutSize8;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize8() {
        return flagStInSize8;
    }

    /**
     *
     * @param flagStInSize8
     */
    public void setFlagStInSize8(Long flagStInSize8) {
        this.flagStInSize8 = flagStInSize8;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize8() {
        return flagStOutSize8;
    }

    /**
     *
     * @param flagStOutSize8
     */
    public void setFlagStOutSize8(Long flagStOutSize8) {
        this.flagStOutSize8 = flagStOutSize8;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize8() {
        return flagAsInSize8;
    }

    /**
     *
     * @param flagAsInSize8
     */
    public void setFlagAsInSize8(Long flagAsInSize8) {
        this.flagAsInSize8 = flagAsInSize8;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize8() {
        return flagAsOutSize8;
    }

    /**
     *
     * @param flagAsOutSize8
     */
    public void setFlagAsOutSize8(Long flagAsOutSize8) {
        this.flagAsOutSize8 = flagAsOutSize8;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize8() {
        return flagScInSize8;
    }

    /**
     *
     * @param flagScInSize8
     */
    public void setFlagScInSize8(Long flagScInSize8) {
        this.flagScInSize8 = flagScInSize8;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize8() {
        return flagScOutSize8;
    }

    /**
     *
     * @param flagScOutSize8
     */
    public void setFlagScOutSize8(Long flagScOutSize8) {
        this.flagScOutSize8 = flagScOutSize8;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize8() {
        return flagNsInSize8;
    }

    /**
     *
     * @param flagNsInSize8
     */
    public void setFlagNsInSize8(Long flagNsInSize8) {
        this.flagNsInSize8 = flagNsInSize8;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize8() {
        return flagNsOutSize8;
    }

    /**
     *
     * @param flagNsOutSize8
     */
    public void setFlagNsOutSize8(Long flagNsOutSize8) {
        this.flagNsOutSize8 = flagNsOutSize8;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize8() {
        return flagCscInSize8;
    }

    /**
     *
     * @param flagCscInSize8
     */
    public void setFlagCscInSize8(Long flagCscInSize8) {
        this.flagCscInSize8 = flagCscInSize8;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize8() {
        return flagCscOutSize8;
    }

    /**
     *
     * @param flagCscOutSize8
     */
    public void setFlagCscOutSize8(Long flagCscOutSize8) {
        this.flagCscOutSize8 = flagCscOutSize8;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize8() {
        return flagOsInSize8;
    }

    /**
     *
     * @param flagOsInSize8
     */
    public void setFlagOsInSize8(Long flagOsInSize8) {
        this.flagOsInSize8 = flagOsInSize8;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize8() {
        return flagOsOutSize8;
    }

    /**
     *
     * @param flagOsOutSize8
     */
    public void setFlagOsOutSize8(Long flagOsOutSize8) {
        this.flagOsOutSize8 = flagOsOutSize8;
    }

    /**
     *
     * @return
     */
    public Long getSize8T() {
        return Size8T;
    }

    /**
     *
     * @param Size8T
     */
    public void setSize8T(Long Size8T) {
        this.Size8T = Size8T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize8T() {
        return flagCtInSize8T;
    }

    /**
     *
     * @param flagCtInSize8T
     */
    public void setFlagCtInSize8T(Long flagCtInSize8T) {
        this.flagCtInSize8T = flagCtInSize8T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize8T() {
        return flagCtOutSize8T;
    }

    /**
     *
     * @param flagCtOutSize8T
     */
    public void setFlagCtOutSize8T(Long flagCtOutSize8T) {
        this.flagCtOutSize8T = flagCtOutSize8T;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize8T() {
        return flagPrepInSize8T;
    }

    /**
     *
     * @param flagPrepInSize8T
     */
    public void setFlagPrepInSize8T(Long flagPrepInSize8T) {
        this.flagPrepInSize8T = flagPrepInSize8T;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize8T() {
        return flagPrepOutSize8T;
    }

    /**
     *
     * @param flagPrepOutSize8T
     */
    public void setFlagPrepOutSize8T(Long flagPrepOutSize8T) {
        this.flagPrepOutSize8T = flagPrepOutSize8T;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize8T() {
        return flagStInSize8T;
    }

    /**
     *
     * @param flagStInSize8T
     */
    public void setFlagStInSize8T(Long flagStInSize8T) {
        this.flagStInSize8T = flagStInSize8T;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize8T() {
        return flagStOutSize8T;
    }

    /**
     *
     * @param flagStOutSize8T
     */
    public void setFlagStOutSize8T(Long flagStOutSize8T) {
        this.flagStOutSize8T = flagStOutSize8T;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize8T() {
        return flagAsInSize8T;
    }

    /**
     *
     * @param flagAsInSize8T
     */
    public void setFlagAsInSize8T(Long flagAsInSize8T) {
        this.flagAsInSize8T = flagAsInSize8T;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize8T() {
        return flagAsOutSize8T;
    }

    /**
     *
     * @param flagAsOutSize8T
     */
    public void setFlagAsOutSize8T(Long flagAsOutSize8T) {
        this.flagAsOutSize8T = flagAsOutSize8T;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize8T() {
        return flagScInSize8T;
    }

    /**
     *
     * @param flagScInSize8T
     */
    public void setFlagScInSize8T(Long flagScInSize8T) {
        this.flagScInSize8T = flagScInSize8T;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize8T() {
        return flagScOutSize8T;
    }

    /**
     *
     * @param flagScOutSize8T
     */
    public void setFlagScOutSize8T(Long flagScOutSize8T) {
        this.flagScOutSize8T = flagScOutSize8T;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize8T() {
        return flagNsInSize8T;
    }

    /**
     *
     * @param flagNsInSize8T
     */
    public void setFlagNsInSize8T(Long flagNsInSize8T) {
        this.flagNsInSize8T = flagNsInSize8T;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize8T() {
        return flagNsOutSize8T;
    }

    /**
     *
     * @param flagNsOutSize8T
     */
    public void setFlagNsOutSize8T(Long flagNsOutSize8T) {
        this.flagNsOutSize8T = flagNsOutSize8T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize8T() {
        return flagCscInSize8T;
    }

    /**
     *
     * @param flagCscInSize8T
     */
    public void setFlagCscInSize8T(Long flagCscInSize8T) {
        this.flagCscInSize8T = flagCscInSize8T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize8T() {
        return flagCscOutSize8T;
    }

    /**
     *
     * @param flagCscOutSize8T
     */
    public void setFlagCscOutSize8T(Long flagCscOutSize8T) {
        this.flagCscOutSize8T = flagCscOutSize8T;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize8T() {
        return flagOsInSize8T;
    }

    /**
     *
     * @param flagOsInSize8T
     */
    public void setFlagOsInSize8T(Long flagOsInSize8T) {
        this.flagOsInSize8T = flagOsInSize8T;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize8T() {
        return flagOsOutSize8T;
    }

    /**
     *
     * @param flagOsOutSize8T
     */
    public void setFlagOsOutSize8T(Long flagOsOutSize8T) {
        this.flagOsOutSize8T = flagOsOutSize8T;
    }

    /**
     *
     * @return
     */
    public Long getSize9() {
        return Size9;
    }

    /**
     *
     * @param Size9
     */
    public void setSize9(Long Size9) {
        this.Size9 = Size9;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize9() {
        return flagCtInSize9;
    }

    /**
     *
     * @param flagCtInSize9
     */
    public void setFlagCtInSize9(Long flagCtInSize9) {
        this.flagCtInSize9 = flagCtInSize9;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize9() {
        return flagCtOutSize9;
    }

    /**
     *
     * @param flagCtOutSize9
     */
    public void setFlagCtOutSize9(Long flagCtOutSize9) {
        this.flagCtOutSize9 = flagCtOutSize9;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize9() {
        return flagPrepInSize9;
    }

    /**
     *
     * @param flagPrepInSize9
     */
    public void setFlagPrepInSize9(Long flagPrepInSize9) {
        this.flagPrepInSize9 = flagPrepInSize9;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize9() {
        return flagPrepOutSize9;
    }

    /**
     *
     * @param flagPrepOutSize9
     */
    public void setFlagPrepOutSize9(Long flagPrepOutSize9) {
        this.flagPrepOutSize9 = flagPrepOutSize9;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize9() {
        return flagStInSize9;
    }

    /**
     *
     * @param flagStInSize9
     */
    public void setFlagStInSize9(Long flagStInSize9) {
        this.flagStInSize9 = flagStInSize9;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize9() {
        return flagStOutSize9;
    }

    /**
     *
     * @param flagStOutSize9
     */
    public void setFlagStOutSize9(Long flagStOutSize9) {
        this.flagStOutSize9 = flagStOutSize9;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize9() {
        return flagAsInSize9;
    }

    /**
     *
     * @param flagAsInSize9
     */
    public void setFlagAsInSize9(Long flagAsInSize9) {
        this.flagAsInSize9 = flagAsInSize9;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize9() {
        return flagAsOutSize9;
    }

    /**
     *
     * @param flagAsOutSize9
     */
    public void setFlagAsOutSize9(Long flagAsOutSize9) {
        this.flagAsOutSize9 = flagAsOutSize9;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize9() {
        return flagScInSize9;
    }

    /**
     *
     * @param flagScInSize9
     */
    public void setFlagScInSize9(Long flagScInSize9) {
        this.flagScInSize9 = flagScInSize9;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize9() {
        return flagScOutSize9;
    }

    /**
     *
     * @param flagScOutSize9
     */
    public void setFlagScOutSize9(Long flagScOutSize9) {
        this.flagScOutSize9 = flagScOutSize9;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize9() {
        return flagNsInSize9;
    }

    /**
     *
     * @param flagNsInSize9
     */
    public void setFlagNsInSize9(Long flagNsInSize9) {
        this.flagNsInSize9 = flagNsInSize9;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize9() {
        return flagNsOutSize9;
    }

    /**
     *
     * @param flagNsOutSize9
     */
    public void setFlagNsOutSize9(Long flagNsOutSize9) {
        this.flagNsOutSize9 = flagNsOutSize9;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize9() {
        return flagCscInSize9;
    }

    /**
     *
     * @param flagCscInSize9
     */
    public void setFlagCscInSize9(Long flagCscInSize9) {
        this.flagCscInSize9 = flagCscInSize9;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize9() {
        return flagCscOutSize9;
    }

    /**
     *
     * @param flagCscOutSize9
     */
    public void setFlagCscOutSize9(Long flagCscOutSize9) {
        this.flagCscOutSize9 = flagCscOutSize9;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize9() {
        return flagOsInSize9;
    }

    /**
     *
     * @param flagOsInSize9
     */
    public void setFlagOsInSize9(Long flagOsInSize9) {
        this.flagOsInSize9 = flagOsInSize9;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize9() {
        return flagOsOutSize9;
    }

    /**
     *
     * @param flagOsOutSize9
     */
    public void setFlagOsOutSize9(Long flagOsOutSize9) {
        this.flagOsOutSize9 = flagOsOutSize9;
    }

    /**
     *
     * @return
     */
    public Long getSize9T() {
        return Size9T;
    }

    /**
     *
     * @param Size9T
     */
    public void setSize9T(Long Size9T) {
        this.Size9T = Size9T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize9T() {
        return flagCtInSize9T;
    }

    /**
     *
     * @param flagCtInSize9T
     */
    public void setFlagCtInSize9T(Long flagCtInSize9T) {
        this.flagCtInSize9T = flagCtInSize9T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize9T() {
        return flagCtOutSize9T;
    }

    /**
     *
     * @param flagCtOutSize9T
     */
    public void setFlagCtOutSize9T(Long flagCtOutSize9T) {
        this.flagCtOutSize9T = flagCtOutSize9T;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize9T() {
        return flagPrepInSize9T;
    }

    /**
     *
     * @param flagPrepInSize9T
     */
    public void setFlagPrepInSize9T(Long flagPrepInSize9T) {
        this.flagPrepInSize9T = flagPrepInSize9T;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize9T() {
        return flagPrepOutSize9T;
    }

    /**
     *
     * @param flagPrepOutSize9T
     */
    public void setFlagPrepOutSize9T(Long flagPrepOutSize9T) {
        this.flagPrepOutSize9T = flagPrepOutSize9T;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize9T() {
        return flagStInSize9T;
    }

    /**
     *
     * @param flagStInSize9T
     */
    public void setFlagStInSize9T(Long flagStInSize9T) {
        this.flagStInSize9T = flagStInSize9T;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize9T() {
        return flagStOutSize9T;
    }

    /**
     *
     * @param flagStOutSize9T
     */
    public void setFlagStOutSize9T(Long flagStOutSize9T) {
        this.flagStOutSize9T = flagStOutSize9T;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize9T() {
        return flagAsInSize9T;
    }

    /**
     *
     * @param flagAsInSize9T
     */
    public void setFlagAsInSize9T(Long flagAsInSize9T) {
        this.flagAsInSize9T = flagAsInSize9T;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize9T() {
        return flagAsOutSize9T;
    }

    /**
     *
     * @param flagAsOutSize9T
     */
    public void setFlagAsOutSize9T(Long flagAsOutSize9T) {
        this.flagAsOutSize9T = flagAsOutSize9T;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize9T() {
        return flagScInSize9T;
    }

    /**
     *
     * @param flagScInSize9T
     */
    public void setFlagScInSize9T(Long flagScInSize9T) {
        this.flagScInSize9T = flagScInSize9T;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize9T() {
        return flagScOutSize9T;
    }

    /**
     *
     * @param flagScOutSize9T
     */
    public void setFlagScOutSize9T(Long flagScOutSize9T) {
        this.flagScOutSize9T = flagScOutSize9T;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize9T() {
        return flagNsInSize9T;
    }

    /**
     *
     * @param flagNsInSize9T
     */
    public void setFlagNsInSize9T(Long flagNsInSize9T) {
        this.flagNsInSize9T = flagNsInSize9T;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize9T() {
        return flagNsOutSize9T;
    }

    /**
     *
     * @param flagNsOutSize9T
     */
    public void setFlagNsOutSize9T(Long flagNsOutSize9T) {
        this.flagNsOutSize9T = flagNsOutSize9T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize9T() {
        return flagCscInSize9T;
    }

    /**
     *
     * @param flagCscInSize9T
     */
    public void setFlagCscInSize9T(Long flagCscInSize9T) {
        this.flagCscInSize9T = flagCscInSize9T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize9T() {
        return flagCscOutSize9T;
    }

    /**
     *
     * @param flagCscOutSize9T
     */
    public void setFlagCscOutSize9T(Long flagCscOutSize9T) {
        this.flagCscOutSize9T = flagCscOutSize9T;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize9T() {
        return flagOsInSize9T;
    }

    /**
     *
     * @param flagOsInSize9T
     */
    public void setFlagOsInSize9T(Long flagOsInSize9T) {
        this.flagOsInSize9T = flagOsInSize9T;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize9T() {
        return flagOsOutSize9T;
    }

    /**
     *
     * @param flagOsOutSize9T
     */
    public void setFlagOsOutSize9T(Long flagOsOutSize9T) {
        this.flagOsOutSize9T = flagOsOutSize9T;
    }

    /**
     *
     * @return
     */
    public Long getSize10() {
        return Size10;
    }

    /**
     *
     * @param Size10
     */
    public void setSize10(Long Size10) {
        this.Size10 = Size10;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize10() {
        return flagCtInSize10;
    }

    /**
     *
     * @param flagCtInSize10
     */
    public void setFlagCtInSize10(Long flagCtInSize10) {
        this.flagCtInSize10 = flagCtInSize10;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize10() {
        return flagCtOutSize10;
    }

    /**
     *
     * @param flagCtOutSize10
     */
    public void setFlagCtOutSize10(Long flagCtOutSize10) {
        this.flagCtOutSize10 = flagCtOutSize10;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize10() {
        return flagPrepInSize10;
    }

    /**
     *
     * @param flagPrepInSize10
     */
    public void setFlagPrepInSize10(Long flagPrepInSize10) {
        this.flagPrepInSize10 = flagPrepInSize10;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize10() {
        return flagPrepOutSize10;
    }

    /**
     *
     * @param flagPrepOutSize10
     */
    public void setFlagPrepOutSize10(Long flagPrepOutSize10) {
        this.flagPrepOutSize10 = flagPrepOutSize10;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize10() {
        return flagStInSize10;
    }

    /**
     *
     * @param flagStInSize10
     */
    public void setFlagStInSize10(Long flagStInSize10) {
        this.flagStInSize10 = flagStInSize10;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize10() {
        return flagStOutSize10;
    }

    /**
     *
     * @param flagStOutSize10
     */
    public void setFlagStOutSize10(Long flagStOutSize10) {
        this.flagStOutSize10 = flagStOutSize10;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize10() {
        return flagAsInSize10;
    }

    /**
     *
     * @param flagAsInSize10
     */
    public void setFlagAsInSize10(Long flagAsInSize10) {
        this.flagAsInSize10 = flagAsInSize10;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize10() {
        return flagAsOutSize10;
    }

    /**
     *
     * @param flagAsOutSize10
     */
    public void setFlagAsOutSize10(Long flagAsOutSize10) {
        this.flagAsOutSize10 = flagAsOutSize10;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize10() {
        return flagScInSize10;
    }

    /**
     *
     * @param flagScInSize10
     */
    public void setFlagScInSize10(Long flagScInSize10) {
        this.flagScInSize10 = flagScInSize10;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize10() {
        return flagScOutSize10;
    }

    /**
     *
     * @param flagScOutSize10
     */
    public void setFlagScOutSize10(Long flagScOutSize10) {
        this.flagScOutSize10 = flagScOutSize10;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize10() {
        return flagNsInSize10;
    }

    /**
     *
     * @param flagNsInSize10
     */
    public void setFlagNsInSize10(Long flagNsInSize10) {
        this.flagNsInSize10 = flagNsInSize10;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize10() {
        return flagNsOutSize10;
    }

    /**
     *
     * @param flagNsOutSize10
     */
    public void setFlagNsOutSize10(Long flagNsOutSize10) {
        this.flagNsOutSize10 = flagNsOutSize10;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize10() {
        return flagCscInSize10;
    }

    /**
     *
     * @param flagCscInSize10
     */
    public void setFlagCscInSize10(Long flagCscInSize10) {
        this.flagCscInSize10 = flagCscInSize10;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize10() {
        return flagCscOutSize10;
    }

    /**
     *
     * @param flagCscOutSize10
     */
    public void setFlagCscOutSize10(Long flagCscOutSize10) {
        this.flagCscOutSize10 = flagCscOutSize10;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize10() {
        return flagOsInSize10;
    }

    /**
     *
     * @param flagOsInSize10
     */
    public void setFlagOsInSize10(Long flagOsInSize10) {
        this.flagOsInSize10 = flagOsInSize10;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize10() {
        return flagOsOutSize10;
    }

    /**
     *
     * @param flagOsOutSize10
     */
    public void setFlagOsOutSize10(Long flagOsOutSize10) {
        this.flagOsOutSize10 = flagOsOutSize10;
    }

    /**
     *
     * @return
     */
    public Long getSize10T() {
        return Size10T;
    }

    /**
     *
     * @param Size10T
     */
    public void setSize10T(Long Size10T) {
        this.Size10T = Size10T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize10T() {
        return flagCtInSize10T;
    }

    /**
     *
     * @param flagCtInSize10T
     */
    public void setFlagCtInSize10T(Long flagCtInSize10T) {
        this.flagCtInSize10T = flagCtInSize10T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize10T() {
        return flagCtOutSize10T;
    }

    /**
     *
     * @param flagCtOutSize10T
     */
    public void setFlagCtOutSize10T(Long flagCtOutSize10T) {
        this.flagCtOutSize10T = flagCtOutSize10T;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize10T() {
        return flagPrepInSize10T;
    }

    /**
     *
     * @param flagPrepInSize10T
     */
    public void setFlagPrepInSize10T(Long flagPrepInSize10T) {
        this.flagPrepInSize10T = flagPrepInSize10T;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize10T() {
        return flagPrepOutSize10T;
    }

    /**
     *
     * @param flagPrepOutSize10T
     */
    public void setFlagPrepOutSize10T(Long flagPrepOutSize10T) {
        this.flagPrepOutSize10T = flagPrepOutSize10T;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize10T() {
        return flagStInSize10T;
    }

    /**
     *
     * @param flagStInSize10T
     */
    public void setFlagStInSize10T(Long flagStInSize10T) {
        this.flagStInSize10T = flagStInSize10T;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize10T() {
        return flagStOutSize10T;
    }

    /**
     *
     * @param flagStOutSize10T
     */
    public void setFlagStOutSize10T(Long flagStOutSize10T) {
        this.flagStOutSize10T = flagStOutSize10T;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize10T() {
        return flagAsInSize10T;
    }

    /**
     *
     * @param flagAsInSize10T
     */
    public void setFlagAsInSize10T(Long flagAsInSize10T) {
        this.flagAsInSize10T = flagAsInSize10T;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize10T() {
        return flagAsOutSize10T;
    }

    /**
     *
     * @param flagAsOutSize10T
     */
    public void setFlagAsOutSize10T(Long flagAsOutSize10T) {
        this.flagAsOutSize10T = flagAsOutSize10T;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize10T() {
        return flagScInSize10T;
    }

    /**
     *
     * @param flagScInSize10T
     */
    public void setFlagScInSize10T(Long flagScInSize10T) {
        this.flagScInSize10T = flagScInSize10T;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize10T() {
        return flagScOutSize10T;
    }

    /**
     *
     * @param flagScOutSize10T
     */
    public void setFlagScOutSize10T(Long flagScOutSize10T) {
        this.flagScOutSize10T = flagScOutSize10T;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize10T() {
        return flagNsInSize10T;
    }

    /**
     *
     * @param flagNsInSize10T
     */
    public void setFlagNsInSize10T(Long flagNsInSize10T) {
        this.flagNsInSize10T = flagNsInSize10T;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize10T() {
        return flagNsOutSize10T;
    }

    /**
     *
     * @param flagNsOutSize10T
     */
    public void setFlagNsOutSize10T(Long flagNsOutSize10T) {
        this.flagNsOutSize10T = flagNsOutSize10T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize10T() {
        return flagCscInSize10T;
    }

    /**
     *
     * @param flagCscInSize10T
     */
    public void setFlagCscInSize10T(Long flagCscInSize10T) {
        this.flagCscInSize10T = flagCscInSize10T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize10T() {
        return flagCscOutSize10T;
    }

    /**
     *
     * @param flagCscOutSize10T
     */
    public void setFlagCscOutSize10T(Long flagCscOutSize10T) {
        this.flagCscOutSize10T = flagCscOutSize10T;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize10T() {
        return flagOsInSize10T;
    }

    /**
     *
     * @param flagOsInSize10T
     */
    public void setFlagOsInSize10T(Long flagOsInSize10T) {
        this.flagOsInSize10T = flagOsInSize10T;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize10T() {
        return flagOsOutSize10T;
    }

    /**
     *
     * @param flagOsOutSize10T
     */
    public void setFlagOsOutSize10T(Long flagOsOutSize10T) {
        this.flagOsOutSize10T = flagOsOutSize10T;
    }

    /**
     *
     * @return
     */
    public Long getSize11() {
        return Size11;
    }

    /**
     *
     * @param Size11
     */
    public void setSize11(Long Size11) {
        this.Size11 = Size11;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize11() {
        return flagCtInSize11;
    }

    /**
     *
     * @param flagCtInSize11
     */
    public void setFlagCtInSize11(Long flagCtInSize11) {
        this.flagCtInSize11 = flagCtInSize11;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize11() {
        return flagCtOutSize11;
    }

    /**
     *
     * @param flagCtOutSize11
     */
    public void setFlagCtOutSize11(Long flagCtOutSize11) {
        this.flagCtOutSize11 = flagCtOutSize11;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize11() {
        return flagPrepInSize11;
    }

    /**
     *
     * @param flagPrepInSize11
     */
    public void setFlagPrepInSize11(Long flagPrepInSize11) {
        this.flagPrepInSize11 = flagPrepInSize11;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize11() {
        return flagPrepOutSize11;
    }

    /**
     *
     * @param flagPrepOutSize11
     */
    public void setFlagPrepOutSize11(Long flagPrepOutSize11) {
        this.flagPrepOutSize11 = flagPrepOutSize11;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize11() {
        return flagStInSize11;
    }

    /**
     *
     * @param flagStInSize11
     */
    public void setFlagStInSize11(Long flagStInSize11) {
        this.flagStInSize11 = flagStInSize11;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize11() {
        return flagStOutSize11;
    }

    /**
     *
     * @param flagStOutSize11
     */
    public void setFlagStOutSize11(Long flagStOutSize11) {
        this.flagStOutSize11 = flagStOutSize11;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize11() {
        return flagAsInSize11;
    }

    /**
     *
     * @param flagAsInSize11
     */
    public void setFlagAsInSize11(Long flagAsInSize11) {
        this.flagAsInSize11 = flagAsInSize11;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize11() {
        return flagAsOutSize11;
    }

    /**
     *
     * @param flagAsOutSize11
     */
    public void setFlagAsOutSize11(Long flagAsOutSize11) {
        this.flagAsOutSize11 = flagAsOutSize11;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize11() {
        return flagScInSize11;
    }

    /**
     *
     * @param flagScInSize11
     */
    public void setFlagScInSize11(Long flagScInSize11) {
        this.flagScInSize11 = flagScInSize11;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize11() {
        return flagScOutSize11;
    }

    /**
     *
     * @param flagScOutSize11
     */
    public void setFlagScOutSize11(Long flagScOutSize11) {
        this.flagScOutSize11 = flagScOutSize11;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize11() {
        return flagNsInSize11;
    }

    /**
     *
     * @param flagNsInSize11
     */
    public void setFlagNsInSize11(Long flagNsInSize11) {
        this.flagNsInSize11 = flagNsInSize11;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize11() {
        return flagNsOutSize11;
    }

    /**
     *
     * @param flagNsOutSize11
     */
    public void setFlagNsOutSize11(Long flagNsOutSize11) {
        this.flagNsOutSize11 = flagNsOutSize11;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize11() {
        return flagCscInSize11;
    }

    /**
     *
     * @param flagCscInSize11
     */
    public void setFlagCscInSize11(Long flagCscInSize11) {
        this.flagCscInSize11 = flagCscInSize11;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize11() {
        return flagCscOutSize11;
    }

    /**
     *
     * @param flagCscOutSize11
     */
    public void setFlagCscOutSize11(Long flagCscOutSize11) {
        this.flagCscOutSize11 = flagCscOutSize11;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize11() {
        return flagOsInSize11;
    }

    /**
     *
     * @param flagOsInSize11
     */
    public void setFlagOsInSize11(Long flagOsInSize11) {
        this.flagOsInSize11 = flagOsInSize11;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize11() {
        return flagOsOutSize11;
    }

    /**
     *
     * @param flagOsOutSize11
     */
    public void setFlagOsOutSize11(Long flagOsOutSize11) {
        this.flagOsOutSize11 = flagOsOutSize11;
    }

    /**
     *
     * @return
     */
    public Long getSize11T() {
        return Size11T;
    }

    /**
     *
     * @param Size11T
     */
    public void setSize11T(Long Size11T) {
        this.Size11T = Size11T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize11T() {
        return flagCtInSize11T;
    }

    /**
     *
     * @param flagCtInSize11T
     */
    public void setFlagCtInSize11T(Long flagCtInSize11T) {
        this.flagCtInSize11T = flagCtInSize11T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize11T() {
        return flagCtOutSize11T;
    }

    /**
     *
     * @param flagCtOutSize11T
     */
    public void setFlagCtOutSize11T(Long flagCtOutSize11T) {
        this.flagCtOutSize11T = flagCtOutSize11T;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize11T() {
        return flagPrepInSize11T;
    }

    /**
     *
     * @param flagPrepInSize11T
     */
    public void setFlagPrepInSize11T(Long flagPrepInSize11T) {
        this.flagPrepInSize11T = flagPrepInSize11T;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize11T() {
        return flagPrepOutSize11T;
    }

    /**
     *
     * @param flagPrepOutSize11T
     */
    public void setFlagPrepOutSize11T(Long flagPrepOutSize11T) {
        this.flagPrepOutSize11T = flagPrepOutSize11T;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize11T() {
        return flagStInSize11T;
    }

    /**
     *
     * @param flagStInSize11T
     */
    public void setFlagStInSize11T(Long flagStInSize11T) {
        this.flagStInSize11T = flagStInSize11T;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize11T() {
        return flagStOutSize11T;
    }

    /**
     *
     * @param flagStOutSize11T
     */
    public void setFlagStOutSize11T(Long flagStOutSize11T) {
        this.flagStOutSize11T = flagStOutSize11T;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize11T() {
        return flagAsInSize11T;
    }

    /**
     *
     * @param flagAsInSize11T
     */
    public void setFlagAsInSize11T(Long flagAsInSize11T) {
        this.flagAsInSize11T = flagAsInSize11T;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize11T() {
        return flagAsOutSize11T;
    }

    /**
     *
     * @param flagAsOutSize11T
     */
    public void setFlagAsOutSize11T(Long flagAsOutSize11T) {
        this.flagAsOutSize11T = flagAsOutSize11T;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize11T() {
        return flagScInSize11T;
    }

    /**
     *
     * @param flagScInSize11T
     */
    public void setFlagScInSize11T(Long flagScInSize11T) {
        this.flagScInSize11T = flagScInSize11T;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize11T() {
        return flagScOutSize11T;
    }

    /**
     *
     * @param flagScOutSize11T
     */
    public void setFlagScOutSize11T(Long flagScOutSize11T) {
        this.flagScOutSize11T = flagScOutSize11T;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize11T() {
        return flagNsInSize11T;
    }

    /**
     *
     * @param flagNsInSize11T
     */
    public void setFlagNsInSize11T(Long flagNsInSize11T) {
        this.flagNsInSize11T = flagNsInSize11T;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize11T() {
        return flagNsOutSize11T;
    }

    /**
     *
     * @param flagNsOutSize11T
     */
    public void setFlagNsOutSize11T(Long flagNsOutSize11T) {
        this.flagNsOutSize11T = flagNsOutSize11T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize11T() {
        return flagCscInSize11T;
    }

    /**
     *
     * @param flagCscInSize11T
     */
    public void setFlagCscInSize11T(Long flagCscInSize11T) {
        this.flagCscInSize11T = flagCscInSize11T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize11T() {
        return flagCscOutSize11T;
    }

    /**
     *
     * @param flagCscOutSize11T
     */
    public void setFlagCscOutSize11T(Long flagCscOutSize11T) {
        this.flagCscOutSize11T = flagCscOutSize11T;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize11T() {
        return flagOsInSize11T;
    }

    /**
     *
     * @param flagOsInSize11T
     */
    public void setFlagOsInSize11T(Long flagOsInSize11T) {
        this.flagOsInSize11T = flagOsInSize11T;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize11T() {
        return flagOsOutSize11T;
    }

    /**
     *
     * @param flagOsOutSize11T
     */
    public void setFlagOsOutSize11T(Long flagOsOutSize11T) {
        this.flagOsOutSize11T = flagOsOutSize11T;
    }

    /**
     *
     * @return
     */
    public Long getSize12() {
        return Size12;
    }

    /**
     *
     * @param Size12
     */
    public void setSize12(Long Size12) {
        this.Size12 = Size12;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize12() {
        return flagCtInSize12;
    }

    /**
     *
     * @param flagCtInSize12
     */
    public void setFlagCtInSize12(Long flagCtInSize12) {
        this.flagCtInSize12 = flagCtInSize12;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize12() {
        return flagCtOutSize12;
    }

    /**
     *
     * @param flagCtOutSize12
     */
    public void setFlagCtOutSize12(Long flagCtOutSize12) {
        this.flagCtOutSize12 = flagCtOutSize12;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize12() {
        return flagPrepInSize12;
    }

    /**
     *
     * @param flagPrepInSize12
     */
    public void setFlagPrepInSize12(Long flagPrepInSize12) {
        this.flagPrepInSize12 = flagPrepInSize12;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize12() {
        return flagPrepOutSize12;
    }

    /**
     *
     * @param flagPrepOutSize12
     */
    public void setFlagPrepOutSize12(Long flagPrepOutSize12) {
        this.flagPrepOutSize12 = flagPrepOutSize12;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize12() {
        return flagStInSize12;
    }

    /**
     *
     * @param flagStInSize12
     */
    public void setFlagStInSize12(Long flagStInSize12) {
        this.flagStInSize12 = flagStInSize12;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize12() {
        return flagStOutSize12;
    }

    /**
     *
     * @param flagStOutSize12
     */
    public void setFlagStOutSize12(Long flagStOutSize12) {
        this.flagStOutSize12 = flagStOutSize12;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize12() {
        return flagAsInSize12;
    }

    /**
     *
     * @param flagAsInSize12
     */
    public void setFlagAsInSize12(Long flagAsInSize12) {
        this.flagAsInSize12 = flagAsInSize12;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize12() {
        return flagAsOutSize12;
    }

    /**
     *
     * @param flagAsOutSize12
     */
    public void setFlagAsOutSize12(Long flagAsOutSize12) {
        this.flagAsOutSize12 = flagAsOutSize12;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize12() {
        return flagScInSize12;
    }

    /**
     *
     * @param flagScInSize12
     */
    public void setFlagScInSize12(Long flagScInSize12) {
        this.flagScInSize12 = flagScInSize12;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize12() {
        return flagScOutSize12;
    }

    /**
     *
     * @param flagScOutSize12
     */
    public void setFlagScOutSize12(Long flagScOutSize12) {
        this.flagScOutSize12 = flagScOutSize12;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize12() {
        return flagNsInSize12;
    }

    /**
     *
     * @param flagNsInSize12
     */
    public void setFlagNsInSize12(Long flagNsInSize12) {
        this.flagNsInSize12 = flagNsInSize12;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize12() {
        return flagNsOutSize12;
    }

    /**
     *
     * @param flagNsOutSize12
     */
    public void setFlagNsOutSize12(Long flagNsOutSize12) {
        this.flagNsOutSize12 = flagNsOutSize12;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize12() {
        return flagCscInSize12;
    }

    /**
     *
     * @param flagCscInSize12
     */
    public void setFlagCscInSize12(Long flagCscInSize12) {
        this.flagCscInSize12 = flagCscInSize12;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize12() {
        return flagCscOutSize12;
    }

    /**
     *
     * @param flagCscOutSize12
     */
    public void setFlagCscOutSize12(Long flagCscOutSize12) {
        this.flagCscOutSize12 = flagCscOutSize12;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize12() {
        return flagOsInSize12;
    }

    /**
     *
     * @param flagOsInSize12
     */
    public void setFlagOsInSize12(Long flagOsInSize12) {
        this.flagOsInSize12 = flagOsInSize12;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize12() {
        return flagOsOutSize12;
    }

    /**
     *
     * @param flagOsOutSize12
     */
    public void setFlagOsOutSize12(Long flagOsOutSize12) {
        this.flagOsOutSize12 = flagOsOutSize12;
    }

    /**
     *
     * @return
     */
    public Long getSize12T() {
        return Size12T;
    }

    /**
     *
     * @param Size12T
     */
    public void setSize12T(Long Size12T) {
        this.Size12T = Size12T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize12T() {
        return flagCtInSize12T;
    }

    /**
     *
     * @param flagCtInSize12T
     */
    public void setFlagCtInSize12T(Long flagCtInSize12T) {
        this.flagCtInSize12T = flagCtInSize12T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize12T() {
        return flagCtOutSize12T;
    }

    /**
     *
     * @param flagCtOutSize12T
     */
    public void setFlagCtOutSize12T(Long flagCtOutSize12T) {
        this.flagCtOutSize12T = flagCtOutSize12T;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize12T() {
        return flagPrepInSize12T;
    }

    /**
     *
     * @param flagPrepInSize12T
     */
    public void setFlagPrepInSize12T(Long flagPrepInSize12T) {
        this.flagPrepInSize12T = flagPrepInSize12T;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize12T() {
        return flagPrepOutSize12T;
    }

    /**
     *
     * @param flagPrepOutSize12T
     */
    public void setFlagPrepOutSize12T(Long flagPrepOutSize12T) {
        this.flagPrepOutSize12T = flagPrepOutSize12T;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize12T() {
        return flagStInSize12T;
    }

    /**
     *
     * @param flagStInSize12T
     */
    public void setFlagStInSize12T(Long flagStInSize12T) {
        this.flagStInSize12T = flagStInSize12T;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize12T() {
        return flagStOutSize12T;
    }

    /**
     *
     * @param flagStOutSize12T
     */
    public void setFlagStOutSize12T(Long flagStOutSize12T) {
        this.flagStOutSize12T = flagStOutSize12T;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize12T() {
        return flagAsInSize12T;
    }

    /**
     *
     * @param flagAsInSize12T
     */
    public void setFlagAsInSize12T(Long flagAsInSize12T) {
        this.flagAsInSize12T = flagAsInSize12T;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize12T() {
        return flagAsOutSize12T;
    }

    /**
     *
     * @param flagAsOutSize12T
     */
    public void setFlagAsOutSize12T(Long flagAsOutSize12T) {
        this.flagAsOutSize12T = flagAsOutSize12T;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize12T() {
        return flagScInSize12T;
    }

    /**
     *
     * @param flagScInSize12T
     */
    public void setFlagScInSize12T(Long flagScInSize12T) {
        this.flagScInSize12T = flagScInSize12T;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize12T() {
        return flagScOutSize12T;
    }

    /**
     *
     * @param flagScOutSize12T
     */
    public void setFlagScOutSize12T(Long flagScOutSize12T) {
        this.flagScOutSize12T = flagScOutSize12T;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize12T() {
        return flagNsInSize12T;
    }

    /**
     *
     * @param flagNsInSize12T
     */
    public void setFlagNsInSize12T(Long flagNsInSize12T) {
        this.flagNsInSize12T = flagNsInSize12T;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize12T() {
        return flagNsOutSize12T;
    }

    /**
     *
     * @param flagNsOutSize12T
     */
    public void setFlagNsOutSize12T(Long flagNsOutSize12T) {
        this.flagNsOutSize12T = flagNsOutSize12T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize12T() {
        return flagCscInSize12T;
    }

    /**
     *
     * @param flagCscInSize12T
     */
    public void setFlagCscInSize12T(Long flagCscInSize12T) {
        this.flagCscInSize12T = flagCscInSize12T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize12T() {
        return flagCscOutSize12T;
    }

    /**
     *
     * @param flagCscOutSize12T
     */
    public void setFlagCscOutSize12T(Long flagCscOutSize12T) {
        this.flagCscOutSize12T = flagCscOutSize12T;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize12T() {
        return flagOsInSize12T;
    }

    /**
     *
     * @param flagOsInSize12T
     */
    public void setFlagOsInSize12T(Long flagOsInSize12T) {
        this.flagOsInSize12T = flagOsInSize12T;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize12T() {
        return flagOsOutSize12T;
    }

    /**
     *
     * @param flagOsOutSize12T
     */
    public void setFlagOsOutSize12T(Long flagOsOutSize12T) {
        this.flagOsOutSize12T = flagOsOutSize12T;
    }

    /**
     *
     * @return
     */
    public Long getSize13() {
        return Size13;
    }

    /**
     *
     * @param Size13
     */
    public void setSize13(Long Size13) {
        this.Size13 = Size13;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize13() {
        return flagCtInSize13;
    }

    /**
     *
     * @param flagCtInSize13
     */
    public void setFlagCtInSize13(Long flagCtInSize13) {
        this.flagCtInSize13 = flagCtInSize13;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize13() {
        return flagCtOutSize13;
    }

    /**
     *
     * @param flagCtOutSize13
     */
    public void setFlagCtOutSize13(Long flagCtOutSize13) {
        this.flagCtOutSize13 = flagCtOutSize13;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize13() {
        return flagPrepInSize13;
    }

    /**
     *
     * @param flagPrepInSize13
     */
    public void setFlagPrepInSize13(Long flagPrepInSize13) {
        this.flagPrepInSize13 = flagPrepInSize13;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize13() {
        return flagPrepOutSize13;
    }

    /**
     *
     * @param flagPrepOutSize13
     */
    public void setFlagPrepOutSize13(Long flagPrepOutSize13) {
        this.flagPrepOutSize13 = flagPrepOutSize13;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize13() {
        return flagStInSize13;
    }

    /**
     *
     * @param flagStInSize13
     */
    public void setFlagStInSize13(Long flagStInSize13) {
        this.flagStInSize13 = flagStInSize13;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize13() {
        return flagStOutSize13;
    }

    /**
     *
     * @param flagStOutSize13
     */
    public void setFlagStOutSize13(Long flagStOutSize13) {
        this.flagStOutSize13 = flagStOutSize13;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize13() {
        return flagAsInSize13;
    }

    /**
     *
     * @param flagAsInSize13
     */
    public void setFlagAsInSize13(Long flagAsInSize13) {
        this.flagAsInSize13 = flagAsInSize13;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize13() {
        return flagAsOutSize13;
    }

    /**
     *
     * @param flagAsOutSize13
     */
    public void setFlagAsOutSize13(Long flagAsOutSize13) {
        this.flagAsOutSize13 = flagAsOutSize13;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize13() {
        return flagScInSize13;
    }

    /**
     *
     * @param flagScInSize13
     */
    public void setFlagScInSize13(Long flagScInSize13) {
        this.flagScInSize13 = flagScInSize13;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize13() {
        return flagScOutSize13;
    }

    /**
     *
     * @param flagScOutSize13
     */
    public void setFlagScOutSize13(Long flagScOutSize13) {
        this.flagScOutSize13 = flagScOutSize13;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize13() {
        return flagNsInSize13;
    }

    /**
     *
     * @param flagNsInSize13
     */
    public void setFlagNsInSize13(Long flagNsInSize13) {
        this.flagNsInSize13 = flagNsInSize13;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize13() {
        return flagNsOutSize13;
    }

    /**
     *
     * @param flagNsOutSize13
     */
    public void setFlagNsOutSize13(Long flagNsOutSize13) {
        this.flagNsOutSize13 = flagNsOutSize13;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize13() {
        return flagCscInSize13;
    }

    /**
     *
     * @param flagCscInSize13
     */
    public void setFlagCscInSize13(Long flagCscInSize13) {
        this.flagCscInSize13 = flagCscInSize13;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize13() {
        return flagCscOutSize13;
    }

    /**
     *
     * @param flagCscOutSize13
     */
    public void setFlagCscOutSize13(Long flagCscOutSize13) {
        this.flagCscOutSize13 = flagCscOutSize13;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize13() {
        return flagOsInSize13;
    }

    /**
     *
     * @param flagOsInSize13
     */
    public void setFlagOsInSize13(Long flagOsInSize13) {
        this.flagOsInSize13 = flagOsInSize13;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize13() {
        return flagOsOutSize13;
    }

    /**
     *
     * @param flagOsOutSize13
     */
    public void setFlagOsOutSize13(Long flagOsOutSize13) {
        this.flagOsOutSize13 = flagOsOutSize13;
    }

    /**
     *
     * @return
     */
    public Long getSize13T() {
        return Size13T;
    }

    /**
     *
     * @param Size13T
     */
    public void setSize13T(Long Size13T) {
        this.Size13T = Size13T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize13T() {
        return flagCtInSize13T;
    }

    /**
     *
     * @param flagCtInSize13T
     */
    public void setFlagCtInSize13T(Long flagCtInSize13T) {
        this.flagCtInSize13T = flagCtInSize13T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize13T() {
        return flagCtOutSize13T;
    }

    /**
     *
     * @param flagCtOutSize13T
     */
    public void setFlagCtOutSize13T(Long flagCtOutSize13T) {
        this.flagCtOutSize13T = flagCtOutSize13T;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize13T() {
        return flagPrepInSize13T;
    }

    /**
     *
     * @param flagPrepInSize13T
     */
    public void setFlagPrepInSize13T(Long flagPrepInSize13T) {
        this.flagPrepInSize13T = flagPrepInSize13T;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize13T() {
        return flagPrepOutSize13T;
    }

    /**
     *
     * @param flagPrepOutSize13T
     */
    public void setFlagPrepOutSize13T(Long flagPrepOutSize13T) {
        this.flagPrepOutSize13T = flagPrepOutSize13T;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize13T() {
        return flagStInSize13T;
    }

    /**
     *
     * @param flagStInSize13T
     */
    public void setFlagStInSize13T(Long flagStInSize13T) {
        this.flagStInSize13T = flagStInSize13T;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize13T() {
        return flagStOutSize13T;
    }

    /**
     *
     * @param flagStOutSize13T
     */
    public void setFlagStOutSize13T(Long flagStOutSize13T) {
        this.flagStOutSize13T = flagStOutSize13T;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize13T() {
        return flagAsInSize13T;
    }

    /**
     *
     * @param flagAsInSize13T
     */
    public void setFlagAsInSize13T(Long flagAsInSize13T) {
        this.flagAsInSize13T = flagAsInSize13T;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize13T() {
        return flagAsOutSize13T;
    }

    /**
     *
     * @param flagAsOutSize13T
     */
    public void setFlagAsOutSize13T(Long flagAsOutSize13T) {
        this.flagAsOutSize13T = flagAsOutSize13T;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize13T() {
        return flagScInSize13T;
    }

    /**
     *
     * @param flagScInSize13T
     */
    public void setFlagScInSize13T(Long flagScInSize13T) {
        this.flagScInSize13T = flagScInSize13T;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize13T() {
        return flagScOutSize13T;
    }

    /**
     *
     * @param flagScOutSize13T
     */
    public void setFlagScOutSize13T(Long flagScOutSize13T) {
        this.flagScOutSize13T = flagScOutSize13T;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize13T() {
        return flagNsInSize13T;
    }

    /**
     *
     * @param flagNsInSize13T
     */
    public void setFlagNsInSize13T(Long flagNsInSize13T) {
        this.flagNsInSize13T = flagNsInSize13T;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize13T() {
        return flagNsOutSize13T;
    }

    /**
     *
     * @param flagNsOutSize13T
     */
    public void setFlagNsOutSize13T(Long flagNsOutSize13T) {
        this.flagNsOutSize13T = flagNsOutSize13T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize13T() {
        return flagCscInSize13T;
    }

    /**
     *
     * @param flagCscInSize13T
     */
    public void setFlagCscInSize13T(Long flagCscInSize13T) {
        this.flagCscInSize13T = flagCscInSize13T;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize13T() {
        return flagCscOutSize13T;
    }

    /**
     *
     * @param flagCscOutSize13T
     */
    public void setFlagCscOutSize13T(Long flagCscOutSize13T) {
        this.flagCscOutSize13T = flagCscOutSize13T;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize13T() {
        return flagOsInSize13T;
    }

    /**
     *
     * @param flagOsInSize13T
     */
    public void setFlagOsInSize13T(Long flagOsInSize13T) {
        this.flagOsInSize13T = flagOsInSize13T;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize13T() {
        return flagOsOutSize13T;
    }

    /**
     *
     * @param flagOsOutSize13T
     */
    public void setFlagOsOutSize13T(Long flagOsOutSize13T) {
        this.flagOsOutSize13T = flagOsOutSize13T;
    }

    /**
     *
     * @return
     */
    public Long getSize14() {
        return Size14;
    }

    /**
     *
     * @param Size14
     */
    public void setSize14(Long Size14) {
        this.Size14 = Size14;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize14() {
        return flagCtInSize14;
    }

    /**
     *
     * @param flagCtInSize14
     */
    public void setFlagCtInSize14(Long flagCtInSize14) {
        this.flagCtInSize14 = flagCtInSize14;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize14() {
        return flagCtOutSize14;
    }

    /**
     *
     * @param flagCtOutSize14
     */
    public void setFlagCtOutSize14(Long flagCtOutSize14) {
        this.flagCtOutSize14 = flagCtOutSize14;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize14() {
        return flagPrepInSize14;
    }

    /**
     *
     * @param flagPrepInSize14
     */
    public void setFlagPrepInSize14(Long flagPrepInSize14) {
        this.flagPrepInSize14 = flagPrepInSize14;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize14() {
        return flagPrepOutSize14;
    }

    /**
     *
     * @param flagPrepOutSize14
     */
    public void setFlagPrepOutSize14(Long flagPrepOutSize14) {
        this.flagPrepOutSize14 = flagPrepOutSize14;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize14() {
        return flagStInSize14;
    }

    /**
     *
     * @param flagStInSize14
     */
    public void setFlagStInSize14(Long flagStInSize14) {
        this.flagStInSize14 = flagStInSize14;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize14() {
        return flagStOutSize14;
    }

    /**
     *
     * @param flagStOutSize14
     */
    public void setFlagStOutSize14(Long flagStOutSize14) {
        this.flagStOutSize14 = flagStOutSize14;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize14() {
        return flagAsInSize14;
    }

    /**
     *
     * @param flagAsInSize14
     */
    public void setFlagAsInSize14(Long flagAsInSize14) {
        this.flagAsInSize14 = flagAsInSize14;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize14() {
        return flagAsOutSize14;
    }

    /**
     *
     * @param flagAsOutSize14
     */
    public void setFlagAsOutSize14(Long flagAsOutSize14) {
        this.flagAsOutSize14 = flagAsOutSize14;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize14() {
        return flagScInSize14;
    }

    /**
     *
     * @param flagScInSize14
     */
    public void setFlagScInSize14(Long flagScInSize14) {
        this.flagScInSize14 = flagScInSize14;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize14() {
        return flagScOutSize14;
    }

    /**
     *
     * @param flagScOutSize14
     */
    public void setFlagScOutSize14(Long flagScOutSize14) {
        this.flagScOutSize14 = flagScOutSize14;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize14() {
        return flagNsInSize14;
    }

    /**
     *
     * @param flagNsInSize14
     */
    public void setFlagNsInSize14(Long flagNsInSize14) {
        this.flagNsInSize14 = flagNsInSize14;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize14() {
        return flagNsOutSize14;
    }

    /**
     *
     * @param flagNsOutSize14
     */
    public void setFlagNsOutSize14(Long flagNsOutSize14) {
        this.flagNsOutSize14 = flagNsOutSize14;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize14() {
        return flagCscInSize14;
    }

    /**
     *
     * @param flagCscInSize14
     */
    public void setFlagCscInSize14(Long flagCscInSize14) {
        this.flagCscInSize14 = flagCscInSize14;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize14() {
        return flagCscOutSize14;
    }

    /**
     *
     * @param flagCscOutSize14
     */
    public void setFlagCscOutSize14(Long flagCscOutSize14) {
        this.flagCscOutSize14 = flagCscOutSize14;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize14() {
        return flagOsInSize14;
    }

    /**
     *
     * @param flagOsInSize14
     */
    public void setFlagOsInSize14(Long flagOsInSize14) {
        this.flagOsInSize14 = flagOsInSize14;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize14() {
        return flagOsOutSize14;
    }

    /**
     *
     * @param flagOsOutSize14
     */
    public void setFlagOsOutSize14(Long flagOsOutSize14) {
        this.flagOsOutSize14 = flagOsOutSize14;
    }

    /**
     *
     * @return
     */
    public Long getSize15() {
        return Size15;
    }

    /**
     *
     * @param Size15
     */
    public void setSize15(Long Size15) {
        this.Size15 = Size15;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize15() {
        return flagCtInSize15;
    }

    /**
     *
     * @param flagCtInSize15
     */
    public void setFlagCtInSize15(Long flagCtInSize15) {
        this.flagCtInSize15 = flagCtInSize15;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize15() {
        return flagCtOutSize15;
    }

    /**
     *
     * @param flagCtOutSize15
     */
    public void setFlagCtOutSize15(Long flagCtOutSize15) {
        this.flagCtOutSize15 = flagCtOutSize15;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize15() {
        return flagPrepInSize15;
    }

    /**
     *
     * @param flagPrepInSize15
     */
    public void setFlagPrepInSize15(Long flagPrepInSize15) {
        this.flagPrepInSize15 = flagPrepInSize15;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize15() {
        return flagPrepOutSize15;
    }

    /**
     *
     * @param flagPrepOutSize15
     */
    public void setFlagPrepOutSize15(Long flagPrepOutSize15) {
        this.flagPrepOutSize15 = flagPrepOutSize15;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize15() {
        return flagStInSize15;
    }

    /**
     *
     * @param flagStInSize15
     */
    public void setFlagStInSize15(Long flagStInSize15) {
        this.flagStInSize15 = flagStInSize15;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize15() {
        return flagStOutSize15;
    }

    /**
     *
     * @param flagStOutSize15
     */
    public void setFlagStOutSize15(Long flagStOutSize15) {
        this.flagStOutSize15 = flagStOutSize15;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize15() {
        return flagAsInSize15;
    }

    /**
     *
     * @param flagAsInSize15
     */
    public void setFlagAsInSize15(Long flagAsInSize15) {
        this.flagAsInSize15 = flagAsInSize15;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize15() {
        return flagAsOutSize15;
    }

    /**
     *
     * @param flagAsOutSize15
     */
    public void setFlagAsOutSize15(Long flagAsOutSize15) {
        this.flagAsOutSize15 = flagAsOutSize15;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize15() {
        return flagScInSize15;
    }

    /**
     *
     * @param flagScInSize15
     */
    public void setFlagScInSize15(Long flagScInSize15) {
        this.flagScInSize15 = flagScInSize15;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize15() {
        return flagScOutSize15;
    }

    /**
     *
     * @param flagScOutSize15
     */
    public void setFlagScOutSize15(Long flagScOutSize15) {
        this.flagScOutSize15 = flagScOutSize15;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize15() {
        return flagNsInSize15;
    }

    /**
     *
     * @param flagNsInSize15
     */
    public void setFlagNsInSize15(Long flagNsInSize15) {
        this.flagNsInSize15 = flagNsInSize15;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize15() {
        return flagNsOutSize15;
    }

    /**
     *
     * @param flagNsOutSize15
     */
    public void setFlagNsOutSize15(Long flagNsOutSize15) {
        this.flagNsOutSize15 = flagNsOutSize15;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize15() {
        return flagCscInSize15;
    }

    /**
     *
     * @param flagCscInSize15
     */
    public void setFlagCscInSize15(Long flagCscInSize15) {
        this.flagCscInSize15 = flagCscInSize15;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize15() {
        return flagCscOutSize15;
    }

    /**
     *
     * @param flagCscOutSize15
     */
    public void setFlagCscOutSize15(Long flagCscOutSize15) {
        this.flagCscOutSize15 = flagCscOutSize15;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize15() {
        return flagOsInSize15;
    }

    /**
     *
     * @param flagOsInSize15
     */
    public void setFlagOsInSize15(Long flagOsInSize15) {
        this.flagOsInSize15 = flagOsInSize15;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize15() {
        return flagOsOutSize15;
    }

    /**
     *
     * @param flagOsOutSize15
     */
    public void setFlagOsOutSize15(Long flagOsOutSize15) {
        this.flagOsOutSize15 = flagOsOutSize15;
    }

    /**
     *
     * @return
     */
    public Long getSize16() {
        return Size16;
    }

    /**
     *
     * @param Size16
     */
    public void setSize16(Long Size16) {
        this.Size16 = Size16;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize16() {
        return flagCtInSize16;
    }

    /**
     *
     * @param flagCtInSize16
     */
    public void setFlagCtInSize16(Long flagCtInSize16) {
        this.flagCtInSize16 = flagCtInSize16;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize16() {
        return flagCtOutSize16;
    }

    /**
     *
     * @param flagCtOutSize16
     */
    public void setFlagCtOutSize16(Long flagCtOutSize16) {
        this.flagCtOutSize16 = flagCtOutSize16;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize16() {
        return flagPrepInSize16;
    }

    /**
     *
     * @param flagPrepInSize16
     */
    public void setFlagPrepInSize16(Long flagPrepInSize16) {
        this.flagPrepInSize16 = flagPrepInSize16;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize16() {
        return flagPrepOutSize16;
    }

    /**
     *
     * @param flagPrepOutSize16
     */
    public void setFlagPrepOutSize16(Long flagPrepOutSize16) {
        this.flagPrepOutSize16 = flagPrepOutSize16;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize16() {
        return flagStInSize16;
    }

    /**
     *
     * @param flagStInSize16
     */
    public void setFlagStInSize16(Long flagStInSize16) {
        this.flagStInSize16 = flagStInSize16;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize16() {
        return flagStOutSize16;
    }

    /**
     *
     * @param flagStOutSize16
     */
    public void setFlagStOutSize16(Long flagStOutSize16) {
        this.flagStOutSize16 = flagStOutSize16;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize16() {
        return flagAsInSize16;
    }

    /**
     *
     * @param flagAsInSize16
     */
    public void setFlagAsInSize16(Long flagAsInSize16) {
        this.flagAsInSize16 = flagAsInSize16;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize16() {
        return flagAsOutSize16;
    }

    /**
     *
     * @param flagAsOutSize16
     */
    public void setFlagAsOutSize16(Long flagAsOutSize16) {
        this.flagAsOutSize16 = flagAsOutSize16;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize16() {
        return flagScInSize16;
    }

    /**
     *
     * @param flagScInSize16
     */
    public void setFlagScInSize16(Long flagScInSize16) {
        this.flagScInSize16 = flagScInSize16;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize16() {
        return flagScOutSize16;
    }

    /**
     *
     * @param flagScOutSize16
     */
    public void setFlagScOutSize16(Long flagScOutSize16) {
        this.flagScOutSize16 = flagScOutSize16;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize16() {
        return flagNsInSize16;
    }

    /**
     *
     * @param flagNsInSize16
     */
    public void setFlagNsInSize16(Long flagNsInSize16) {
        this.flagNsInSize16 = flagNsInSize16;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize16() {
        return flagNsOutSize16;
    }

    /**
     *
     * @param flagNsOutSize16
     */
    public void setFlagNsOutSize16(Long flagNsOutSize16) {
        this.flagNsOutSize16 = flagNsOutSize16;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize16() {
        return flagCscInSize16;
    }

    /**
     *
     * @param flagCscInSize16
     */
    public void setFlagCscInSize16(Long flagCscInSize16) {
        this.flagCscInSize16 = flagCscInSize16;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize16() {
        return flagCscOutSize16;
    }

    /**
     *
     * @param flagCscOutSize16
     */
    public void setFlagCscOutSize16(Long flagCscOutSize16) {
        this.flagCscOutSize16 = flagCscOutSize16;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize16() {
        return flagOsInSize16;
    }

    /**
     *
     * @param flagOsInSize16
     */
    public void setFlagOsInSize16(Long flagOsInSize16) {
        this.flagOsInSize16 = flagOsInSize16;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize16() {
        return flagOsOutSize16;
    }

    /**
     *
     * @param flagOsOutSize16
     */
    public void setFlagOsOutSize16(Long flagOsOutSize16) {
        this.flagOsOutSize16 = flagOsOutSize16;
    }

    /**
     *
     * @return
     */
    public Long getSize17() {
        return Size17;
    }

    /**
     *
     * @param Size17
     */
    public void setSize17(Long Size17) {
        this.Size17 = Size17;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize17() {
        return flagCtInSize17;
    }

    /**
     *
     * @param flagCtInSize17
     */
    public void setFlagCtInSize17(Long flagCtInSize17) {
        this.flagCtInSize17 = flagCtInSize17;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize17() {
        return flagCtOutSize17;
    }

    /**
     *
     * @param flagCtOutSize17
     */
    public void setFlagCtOutSize17(Long flagCtOutSize17) {
        this.flagCtOutSize17 = flagCtOutSize17;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize17() {
        return flagPrepInSize17;
    }

    /**
     *
     * @param flagPrepInSize17
     */
    public void setFlagPrepInSize17(Long flagPrepInSize17) {
        this.flagPrepInSize17 = flagPrepInSize17;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize17() {
        return flagPrepOutSize17;
    }

    /**
     *
     * @param flagPrepOutSize17
     */
    public void setFlagPrepOutSize17(Long flagPrepOutSize17) {
        this.flagPrepOutSize17 = flagPrepOutSize17;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize17() {
        return flagStInSize17;
    }

    /**
     *
     * @param flagStInSize17
     */
    public void setFlagStInSize17(Long flagStInSize17) {
        this.flagStInSize17 = flagStInSize17;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize17() {
        return flagStOutSize17;
    }

    /**
     *
     * @param flagStOutSize17
     */
    public void setFlagStOutSize17(Long flagStOutSize17) {
        this.flagStOutSize17 = flagStOutSize17;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize17() {
        return flagAsInSize17;
    }

    /**
     *
     * @param flagAsInSize17
     */
    public void setFlagAsInSize17(Long flagAsInSize17) {
        this.flagAsInSize17 = flagAsInSize17;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize17() {
        return flagAsOutSize17;
    }

    /**
     *
     * @param flagAsOutSize17
     */
    public void setFlagAsOutSize17(Long flagAsOutSize17) {
        this.flagAsOutSize17 = flagAsOutSize17;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize17() {
        return flagScInSize17;
    }

    /**
     *
     * @param flagScInSize17
     */
    public void setFlagScInSize17(Long flagScInSize17) {
        this.flagScInSize17 = flagScInSize17;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize17() {
        return flagScOutSize17;
    }

    /**
     *
     * @param flagScOutSize17
     */
    public void setFlagScOutSize17(Long flagScOutSize17) {
        this.flagScOutSize17 = flagScOutSize17;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize17() {
        return flagNsInSize17;
    }

    /**
     *
     * @param flagNsInSize17
     */
    public void setFlagNsInSize17(Long flagNsInSize17) {
        this.flagNsInSize17 = flagNsInSize17;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize17() {
        return flagNsOutSize17;
    }

    /**
     *
     * @param flagNsOutSize17
     */
    public void setFlagNsOutSize17(Long flagNsOutSize17) {
        this.flagNsOutSize17 = flagNsOutSize17;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize17() {
        return flagCscInSize17;
    }

    /**
     *
     * @param flagCscInSize17
     */
    public void setFlagCscInSize17(Long flagCscInSize17) {
        this.flagCscInSize17 = flagCscInSize17;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize17() {
        return flagCscOutSize17;
    }

    /**
     *
     * @param flagCscOutSize17
     */
    public void setFlagCscOutSize17(Long flagCscOutSize17) {
        this.flagCscOutSize17 = flagCscOutSize17;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize17() {
        return flagOsInSize17;
    }

    /**
     *
     * @param flagOsInSize17
     */
    public void setFlagOsInSize17(Long flagOsInSize17) {
        this.flagOsInSize17 = flagOsInSize17;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize17() {
        return flagOsOutSize17;
    }

    /**
     *
     * @param flagOsOutSize17
     */
    public void setFlagOsOutSize17(Long flagOsOutSize17) {
        this.flagOsOutSize17 = flagOsOutSize17;
    }

    /**
     *
     * @return
     */
    public Long getSize18() {
        return Size18;
    }

    /**
     *
     * @param Size18
     */
    public void setSize18(Long Size18) {
        this.Size18 = Size18;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtInSize18() {
        return flagCtInSize18;
    }

    /**
     *
     * @param flagCtInSize18
     */
    public void setFlagCtInSize18(Long flagCtInSize18) {
        this.flagCtInSize18 = flagCtInSize18;
    }

    /**
     *
     * @return
     */
    public Long getFlagCtOutSize18() {
        return flagCtOutSize18;
    }

    /**
     *
     * @param flagCtOutSize18
     */
    public void setFlagCtOutSize18(Long flagCtOutSize18) {
        this.flagCtOutSize18 = flagCtOutSize18;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepInSize18() {
        return flagPrepInSize18;
    }

    /**
     *
     * @param flagPrepInSize18
     */
    public void setFlagPrepInSize18(Long flagPrepInSize18) {
        this.flagPrepInSize18 = flagPrepInSize18;
    }

    /**
     *
     * @return
     */
    public Long getFlagPrepOutSize18() {
        return flagPrepOutSize18;
    }

    /**
     *
     * @param flagPrepOutSize18
     */
    public void setFlagPrepOutSize18(Long flagPrepOutSize18) {
        this.flagPrepOutSize18 = flagPrepOutSize18;
    }

    /**
     *
     * @return
     */
    public Long getFlagStInSize18() {
        return flagStInSize18;
    }

    /**
     *
     * @param flagStInSize18
     */
    public void setFlagStInSize18(Long flagStInSize18) {
        this.flagStInSize18 = flagStInSize18;
    }

    /**
     *
     * @return
     */
    public Long getFlagStOutSize18() {
        return flagStOutSize18;
    }

    /**
     *
     * @param flagStOutSize18
     */
    public void setFlagStOutSize18(Long flagStOutSize18) {
        this.flagStOutSize18 = flagStOutSize18;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsInSize18() {
        return flagAsInSize18;
    }

    /**
     *
     * @param flagAsInSize18
     */
    public void setFlagAsInSize18(Long flagAsInSize18) {
        this.flagAsInSize18 = flagAsInSize18;
    }

    /**
     *
     * @return
     */
    public Long getFlagAsOutSize18() {
        return flagAsOutSize18;
    }

    /**
     *
     * @param flagAsOutSize18
     */
    public void setFlagAsOutSize18(Long flagAsOutSize18) {
        this.flagAsOutSize18 = flagAsOutSize18;
    }

    /**
     *
     * @return
     */
    public Long getFlagScInSize18() {
        return flagScInSize18;
    }

    /**
     *
     * @param flagScInSize18
     */
    public void setFlagScInSize18(Long flagScInSize18) {
        this.flagScInSize18 = flagScInSize18;
    }

    /**
     *
     * @return
     */
    public Long getFlagScOutSize18() {
        return flagScOutSize18;
    }

    /**
     *
     * @param flagScOutSize18
     */
    public void setFlagScOutSize18(Long flagScOutSize18) {
        this.flagScOutSize18 = flagScOutSize18;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsInSize18() {
        return flagNsInSize18;
    }

    /**
     *
     * @param flagNsInSize18
     */
    public void setFlagNsInSize18(Long flagNsInSize18) {
        this.flagNsInSize18 = flagNsInSize18;
    }

    /**
     *
     * @return
     */
    public Long getFlagNsOutSize18() {
        return flagNsOutSize18;
    }

    /**
     *
     * @param flagNsOutSize18
     */
    public void setFlagNsOutSize18(Long flagNsOutSize18) {
        this.flagNsOutSize18 = flagNsOutSize18;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscInSize18() {
        return flagCscInSize18;
    }

    /**
     *
     * @param flagCscInSize18
     */
    public void setFlagCscInSize18(Long flagCscInSize18) {
        this.flagCscInSize18 = flagCscInSize18;
    }

    /**
     *
     * @return
     */
    public Long getFlagCscOutSize18() {
        return flagCscOutSize18;
    }

    /**
     *
     * @param flagCscOutSize18
     */
    public void setFlagCscOutSize18(Long flagCscOutSize18) {
        this.flagCscOutSize18 = flagCscOutSize18;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsInSize18() {
        return flagOsInSize18;
    }

    /**
     *
     * @param flagOsInSize18
     */
    public void setFlagOsInSize18(Long flagOsInSize18) {
        this.flagOsInSize18 = flagOsInSize18;
    }

    /**
     *
     * @return
     */
    public Long getFlagOsOutSize18() {
        return flagOsOutSize18;
    }

    /**
     *
     * @param flagOsOutSize18
     */
    public void setFlagOsOutSize18(Long flagOsOutSize18) {
        this.flagOsOutSize18 = flagOsOutSize18;
    }

    /**
     *
     * @return
     */
    public String getLineCode() {
        return lineCode;
    }

    /**
     *
     * @param lineCode
     */
    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    /**
     *
     * @return
     */
    public String getPoItem() {
        return poItem;
    }

    /**
     *
     * @param poItem
     */
    public void setPoItem(String poItem) {
        this.poItem = poItem;
    }

    /**
     *
     * @return
     */
    public String getPoNo() {
        return poNo;
    }

    /**
     *
     * @param poNo
     */
    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    /**
     *
     * @return
     */
    public String getDemandClass() {
        return demandClass;
    }

    /**
     *
     * @param demandClass
     */
    public void setDemandClass(String demandClass) {
        this.demandClass = demandClass;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize1() {
        return flagspcutInSize1;
    }

    /**
     *
     * @param flagspcutInSize1
     */
    public void setFlagspcutInSize1(Long flagspcutInSize1) {
        this.flagspcutInSize1 = flagspcutInSize1;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize1() {
        return flagspcutOutSize1;
    }

    /**
     *
     * @param flagspcutOutSize1
     */
    public void setFlagspcutOutSize1(Long flagspcutOutSize1) {
        this.flagspcutOutSize1 = flagspcutOutSize1;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize1() {
        return flagspprepInSize1;
    }

    /**
     *
     * @param flagspprepInSize1
     */
    public void setFlagspprepInSize1(Long flagspprepInSize1) {
        this.flagspprepInSize1 = flagspprepInSize1;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize1() {
        return flagspprepOutSize1;
    }

    /**
     *
     * @param flagspprepOutSize1
     */
    public void setFlagspprepOutSize1(Long flagspprepOutSize1) {
        this.flagspprepOutSize1 = flagspprepOutSize1;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize1T() {
        return flagspcutInSize1T;
    }

    /**
     *
     * @param flagspcutInSize1T
     */
    public void setFlagspcutInSize1T(Long flagspcutInSize1T) {
        this.flagspcutInSize1T = flagspcutInSize1T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize1T() {
        return flagspcutOutSize1T;
    }

    /**
     *
     * @param flagspcutOutSize1T
     */
    public void setFlagspcutOutSize1T(Long flagspcutOutSize1T) {
        this.flagspcutOutSize1T = flagspcutOutSize1T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize1T() {
        return flagspprepInSize1T;
    }

    /**
     *
     * @param flagspprepInSize1T
     */
    public void setFlagspprepInSize1T(Long flagspprepInSize1T) {
        this.flagspprepInSize1T = flagspprepInSize1T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize1T() {
        return flagspprepOutSize1T;
    }

    /**
     *
     * @param flagspprepOutSize1T
     */
    public void setFlagspprepOutSize1T(Long flagspprepOutSize1T) {
        this.flagspprepOutSize1T = flagspprepOutSize1T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize2() {
        return flagspcutInSize2;
    }

    /**
     *
     * @param flagspcutInSize2
     */
    public void setFlagspcutInSize2(Long flagspcutInSize2) {
        this.flagspcutInSize2 = flagspcutInSize2;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize2() {
        return flagspcutOutSize2;
    }

    /**
     *
     * @param flagspcutOutSize2
     */
    public void setFlagspcutOutSize2(Long flagspcutOutSize2) {
        this.flagspcutOutSize2 = flagspcutOutSize2;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize2() {
        return flagspprepInSize2;
    }

    /**
     *
     * @param flagspprepInSize2
     */
    public void setFlagspprepInSize2(Long flagspprepInSize2) {
        this.flagspprepInSize2 = flagspprepInSize2;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize2() {
        return flagspprepOutSize2;
    }

    /**
     *
     * @param flagspprepOutSize2
     */
    public void setFlagspprepOutSize2(Long flagspprepOutSize2) {
        this.flagspprepOutSize2 = flagspprepOutSize2;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize2T() {
        return flagspcutInSize2T;
    }

    /**
     *
     * @param flagspcutInSize2T
     */
    public void setFlagspcutInSize2T(Long flagspcutInSize2T) {
        this.flagspcutInSize2T = flagspcutInSize2T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize2T() {
        return flagspcutOutSize2T;
    }

    /**
     *
     * @param flagspcutOutSize2T
     */
    public void setFlagspcutOutSize2T(Long flagspcutOutSize2T) {
        this.flagspcutOutSize2T = flagspcutOutSize2T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize2T() {
        return flagspprepInSize2T;
    }

    /**
     *
     * @param flagspprepInSize2T
     */
    public void setFlagspprepInSize2T(Long flagspprepInSize2T) {
        this.flagspprepInSize2T = flagspprepInSize2T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize2T() {
        return flagspprepOutSize2T;
    }

    /**
     *
     * @param flagspprepOutSize2T
     */
    public void setFlagspprepOutSize2T(Long flagspprepOutSize2T) {
        this.flagspprepOutSize2T = flagspprepOutSize2T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize3() {
        return flagspcutInSize3;
    }

    /**
     *
     * @param flagspcutInSize3
     */
    public void setFlagspcutInSize3(Long flagspcutInSize3) {
        this.flagspcutInSize3 = flagspcutInSize3;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize3() {
        return flagspcutOutSize3;
    }

    /**
     *
     * @param flagspcutOutSize3
     */
    public void setFlagspcutOutSize3(Long flagspcutOutSize3) {
        this.flagspcutOutSize3 = flagspcutOutSize3;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize3() {
        return flagspprepInSize3;
    }

    /**
     *
     * @param flagspprepInSize3
     */
    public void setFlagspprepInSize3(Long flagspprepInSize3) {
        this.flagspprepInSize3 = flagspprepInSize3;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize3() {
        return flagspprepOutSize3;
    }

    /**
     *
     * @param flagspprepOutSize3
     */
    public void setFlagspprepOutSize3(Long flagspprepOutSize3) {
        this.flagspprepOutSize3 = flagspprepOutSize3;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize3T() {
        return flagspcutInSize3T;
    }

    /**
     *
     * @param flagspcutInSize3T
     */
    public void setFlagspcutInSize3T(Long flagspcutInSize3T) {
        this.flagspcutInSize3T = flagspcutInSize3T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize3T() {
        return flagspcutOutSize3T;
    }

    /**
     *
     * @param flagspcutOutSize3T
     */
    public void setFlagspcutOutSize3T(Long flagspcutOutSize3T) {
        this.flagspcutOutSize3T = flagspcutOutSize3T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize3T() {
        return flagspprepInSize3T;
    }

    /**
     *
     * @param flagspprepInSize3T
     */
    public void setFlagspprepInSize3T(Long flagspprepInSize3T) {
        this.flagspprepInSize3T = flagspprepInSize3T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize3T() {
        return flagspprepOutSize3T;
    }

    /**
     *
     * @param flagspprepOutSize3T
     */
    public void setFlagspprepOutSize3T(Long flagspprepOutSize3T) {
        this.flagspprepOutSize3T = flagspprepOutSize3T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize4() {
        return flagspcutInSize4;
    }

    /**
     *
     * @param flagspcutInSize4
     */
    public void setFlagspcutInSize4(Long flagspcutInSize4) {
        this.flagspcutInSize4 = flagspcutInSize4;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize4() {
        return flagspcutOutSize4;
    }

    /**
     *
     * @param flagspcutOutSize4
     */
    public void setFlagspcutOutSize4(Long flagspcutOutSize4) {
        this.flagspcutOutSize4 = flagspcutOutSize4;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize4() {
        return flagspprepInSize4;
    }

    /**
     *
     * @param flagspprepInSize4
     */
    public void setFlagspprepInSize4(Long flagspprepInSize4) {
        this.flagspprepInSize4 = flagspprepInSize4;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize4() {
        return flagspprepOutSize4;
    }

    /**
     *
     * @param flagspprepOutSize4
     */
    public void setFlagspprepOutSize4(Long flagspprepOutSize4) {
        this.flagspprepOutSize4 = flagspprepOutSize4;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize4T() {
        return flagspcutInSize4T;
    }

    /**
     *
     * @param flagspcutInSize4T
     */
    public void setFlagspcutInSize4T(Long flagspcutInSize4T) {
        this.flagspcutInSize4T = flagspcutInSize4T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize4T() {
        return flagspcutOutSize4T;
    }

    /**
     *
     * @param flagspcutOutSize4T
     */
    public void setFlagspcutOutSize4T(Long flagspcutOutSize4T) {
        this.flagspcutOutSize4T = flagspcutOutSize4T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize4T() {
        return flagspprepInSize4T;
    }

    /**
     *
     * @param flagspprepInSize4T
     */
    public void setFlagspprepInSize4T(Long flagspprepInSize4T) {
        this.flagspprepInSize4T = flagspprepInSize4T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize4T() {
        return flagspprepOutSize4T;
    }

    /**
     *
     * @param flagspprepOutSize4T
     */
    public void setFlagspprepOutSize4T(Long flagspprepOutSize4T) {
        this.flagspprepOutSize4T = flagspprepOutSize4T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize5() {
        return flagspcutInSize5;
    }

    /**
     *
     * @param flagspcutInSize5
     */
    public void setFlagspcutInSize5(Long flagspcutInSize5) {
        this.flagspcutInSize5 = flagspcutInSize5;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize5() {
        return flagspcutOutSize5;
    }

    /**
     *
     * @param flagspcutOutSize5
     */
    public void setFlagspcutOutSize5(Long flagspcutOutSize5) {
        this.flagspcutOutSize5 = flagspcutOutSize5;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize5() {
        return flagspprepInSize5;
    }

    /**
     *
     * @param flagspprepInSize5
     */
    public void setFlagspprepInSize5(Long flagspprepInSize5) {
        this.flagspprepInSize5 = flagspprepInSize5;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize5() {
        return flagspprepOutSize5;
    }

    /**
     *
     * @param flagspprepOutSize5
     */
    public void setFlagspprepOutSize5(Long flagspprepOutSize5) {
        this.flagspprepOutSize5 = flagspprepOutSize5;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize5T() {
        return flagspcutInSize5T;
    }

    /**
     *
     * @param flagspcutInSize5T
     */
    public void setFlagspcutInSize5T(Long flagspcutInSize5T) {
        this.flagspcutInSize5T = flagspcutInSize5T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize5T() {
        return flagspcutOutSize5T;
    }

    /**
     *
     * @param flagspcutOutSize5T
     */
    public void setFlagspcutOutSize5T(Long flagspcutOutSize5T) {
        this.flagspcutOutSize5T = flagspcutOutSize5T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize5T() {
        return flagspprepInSize5T;
    }

    /**
     *
     * @param flagspprepInSize5T
     */
    public void setFlagspprepInSize5T(Long flagspprepInSize5T) {
        this.flagspprepInSize5T = flagspprepInSize5T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize5T() {
        return flagspprepOutSize5T;
    }

    /**
     *
     * @param flagspprepOutSize5T
     */
    public void setFlagspprepOutSize5T(Long flagspprepOutSize5T) {
        this.flagspprepOutSize5T = flagspprepOutSize5T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize6() {
        return flagspcutInSize6;
    }

    /**
     *
     * @param flagspcutInSize6
     */
    public void setFlagspcutInSize6(Long flagspcutInSize6) {
        this.flagspcutInSize6 = flagspcutInSize6;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize6() {
        return flagspcutOutSize6;
    }

    /**
     *
     * @param flagspcutOutSize6
     */
    public void setFlagspcutOutSize6(Long flagspcutOutSize6) {
        this.flagspcutOutSize6 = flagspcutOutSize6;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize6() {
        return flagspprepInSize6;
    }

    /**
     *
     * @param flagspprepInSize6
     */
    public void setFlagspprepInSize6(Long flagspprepInSize6) {
        this.flagspprepInSize6 = flagspprepInSize6;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize6() {
        return flagspprepOutSize6;
    }

    /**
     *
     * @param flagspprepOutSize6
     */
    public void setFlagspprepOutSize6(Long flagspprepOutSize6) {
        this.flagspprepOutSize6 = flagspprepOutSize6;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize6T() {
        return flagspcutInSize6T;
    }

    /**
     *
     * @param flagspcutInSize6T
     */
    public void setFlagspcutInSize6T(Long flagspcutInSize6T) {
        this.flagspcutInSize6T = flagspcutInSize6T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize6T() {
        return flagspcutOutSize6T;
    }

    /**
     *
     * @param flagspcutOutSize6T
     */
    public void setFlagspcutOutSize6T(Long flagspcutOutSize6T) {
        this.flagspcutOutSize6T = flagspcutOutSize6T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize6T() {
        return flagspprepInSize6T;
    }

    /**
     *
     * @param flagspprepInSize6T
     */
    public void setFlagspprepInSize6T(Long flagspprepInSize6T) {
        this.flagspprepInSize6T = flagspprepInSize6T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize6T() {
        return flagspprepOutSize6T;
    }

    /**
     *
     * @param flagspprepOutSize6T
     */
    public void setFlagspprepOutSize6T(Long flagspprepOutSize6T) {
        this.flagspprepOutSize6T = flagspprepOutSize6T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize7() {
        return flagspcutInSize7;
    }

    /**
     *
     * @param flagspcutInSize7
     */
    public void setFlagspcutInSize7(Long flagspcutInSize7) {
        this.flagspcutInSize7 = flagspcutInSize7;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize7() {
        return flagspcutOutSize7;
    }

    /**
     *
     * @param flagspcutOutSize7
     */
    public void setFlagspcutOutSize7(Long flagspcutOutSize7) {
        this.flagspcutOutSize7 = flagspcutOutSize7;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize7() {
        return flagspprepInSize7;
    }

    /**
     *
     * @param flagspprepInSize7
     */
    public void setFlagspprepInSize7(Long flagspprepInSize7) {
        this.flagspprepInSize7 = flagspprepInSize7;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize7() {
        return flagspprepOutSize7;
    }

    /**
     *
     * @param flagspprepOutSize7
     */
    public void setFlagspprepOutSize7(Long flagspprepOutSize7) {
        this.flagspprepOutSize7 = flagspprepOutSize7;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize7T() {
        return flagspcutInSize7T;
    }

    /**
     *
     * @param flagspcutInSize7T
     */
    public void setFlagspcutInSize7T(Long flagspcutInSize7T) {
        this.flagspcutInSize7T = flagspcutInSize7T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize7T() {
        return flagspcutOutSize7T;
    }

    /**
     *
     * @param flagspcutOutSize7T
     */
    public void setFlagspcutOutSize7T(Long flagspcutOutSize7T) {
        this.flagspcutOutSize7T = flagspcutOutSize7T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize7T() {
        return flagspprepInSize7T;
    }

    /**
     *
     * @param flagspprepInSize7T
     */
    public void setFlagspprepInSize7T(Long flagspprepInSize7T) {
        this.flagspprepInSize7T = flagspprepInSize7T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize7T() {
        return flagspprepOutSize7T;
    }

    /**
     *
     * @param flagspprepOutSize7T
     */
    public void setFlagspprepOutSize7T(Long flagspprepOutSize7T) {
        this.flagspprepOutSize7T = flagspprepOutSize7T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize8() {
        return flagspcutInSize8;
    }

    /**
     *
     * @param flagspcutInSize8
     */
    public void setFlagspcutInSize8(Long flagspcutInSize8) {
        this.flagspcutInSize8 = flagspcutInSize8;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize8() {
        return flagspcutOutSize8;
    }

    /**
     *
     * @param flagspcutOutSize8
     */
    public void setFlagspcutOutSize8(Long flagspcutOutSize8) {
        this.flagspcutOutSize8 = flagspcutOutSize8;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize8() {
        return flagspprepInSize8;
    }

    /**
     *
     * @param flagspprepInSize8
     */
    public void setFlagspprepInSize8(Long flagspprepInSize8) {
        this.flagspprepInSize8 = flagspprepInSize8;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize8() {
        return flagspprepOutSize8;
    }

    /**
     *
     * @param flagspprepOutSize8
     */
    public void setFlagspprepOutSize8(Long flagspprepOutSize8) {
        this.flagspprepOutSize8 = flagspprepOutSize8;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize8T() {
        return flagspcutInSize8T;
    }

    /**
     *
     * @param flagspcutInSize8T
     */
    public void setFlagspcutInSize8T(Long flagspcutInSize8T) {
        this.flagspcutInSize8T = flagspcutInSize8T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize8T() {
        return flagspcutOutSize8T;
    }

    /**
     *
     * @param flagspcutOutSize8T
     */
    public void setFlagspcutOutSize8T(Long flagspcutOutSize8T) {
        this.flagspcutOutSize8T = flagspcutOutSize8T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize8T() {
        return flagspprepInSize8T;
    }

    /**
     *
     * @param flagspprepInSize8T
     */
    public void setFlagspprepInSize8T(Long flagspprepInSize8T) {
        this.flagspprepInSize8T = flagspprepInSize8T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize8T() {
        return flagspprepOutSize8T;
    }

    /**
     *
     * @param flagspprepOutSize8T
     */
    public void setFlagspprepOutSize8T(Long flagspprepOutSize8T) {
        this.flagspprepOutSize8T = flagspprepOutSize8T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize9() {
        return flagspcutInSize9;
    }

    /**
     *
     * @param flagspcutInSize9
     */
    public void setFlagspcutInSize9(Long flagspcutInSize9) {
        this.flagspcutInSize9 = flagspcutInSize9;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize9() {
        return flagspcutOutSize9;
    }

    /**
     *
     * @param flagspcutOutSize9
     */
    public void setFlagspcutOutSize9(Long flagspcutOutSize9) {
        this.flagspcutOutSize9 = flagspcutOutSize9;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize9() {
        return flagspprepInSize9;
    }

    /**
     *
     * @param flagspprepInSize9
     */
    public void setFlagspprepInSize9(Long flagspprepInSize9) {
        this.flagspprepInSize9 = flagspprepInSize9;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize9() {
        return flagspprepOutSize9;
    }

    /**
     *
     * @param flagspprepOutSize9
     */
    public void setFlagspprepOutSize9(Long flagspprepOutSize9) {
        this.flagspprepOutSize9 = flagspprepOutSize9;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize9T() {
        return flagspcutInSize9T;
    }

    /**
     *
     * @param flagspcutInSize9T
     */
    public void setFlagspcutInSize9T(Long flagspcutInSize9T) {
        this.flagspcutInSize9T = flagspcutInSize9T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize9T() {
        return flagspcutOutSize9T;
    }

    /**
     *
     * @param flagspcutOutSize9T
     */
    public void setFlagspcutOutSize9T(Long flagspcutOutSize9T) {
        this.flagspcutOutSize9T = flagspcutOutSize9T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize9T() {
        return flagspprepInSize9T;
    }

    /**
     *
     * @param flagspprepInSize9T
     */
    public void setFlagspprepInSize9T(Long flagspprepInSize9T) {
        this.flagspprepInSize9T = flagspprepInSize9T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize9T() {
        return flagspprepOutSize9T;
    }

    /**
     *
     * @param flagspprepOutSize9T
     */
    public void setFlagspprepOutSize9T(Long flagspprepOutSize9T) {
        this.flagspprepOutSize9T = flagspprepOutSize9T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize10() {
        return flagspcutInSize10;
    }

    /**
     *
     * @param flagspcutInSize10
     */
    public void setFlagspcutInSize10(Long flagspcutInSize10) {
        this.flagspcutInSize10 = flagspcutInSize10;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize10() {
        return flagspcutOutSize10;
    }

    /**
     *
     * @param flagspcutOutSize10
     */
    public void setFlagspcutOutSize10(Long flagspcutOutSize10) {
        this.flagspcutOutSize10 = flagspcutOutSize10;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize10() {
        return flagspprepInSize10;
    }

    /**
     *
     * @param flagspprepInSize10
     */
    public void setFlagspprepInSize10(Long flagspprepInSize10) {
        this.flagspprepInSize10 = flagspprepInSize10;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize10() {
        return flagspprepOutSize10;
    }

    /**
     *
     * @param flagspprepOutSize10
     */
    public void setFlagspprepOutSize10(Long flagspprepOutSize10) {
        this.flagspprepOutSize10 = flagspprepOutSize10;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize10T() {
        return flagspcutInSize10T;
    }

    /**
     *
     * @param flagspcutInSize10T
     */
    public void setFlagspcutInSize10T(Long flagspcutInSize10T) {
        this.flagspcutInSize10T = flagspcutInSize10T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize10T() {
        return flagspcutOutSize10T;
    }

    /**
     *
     * @param flagspcutOutSize10T
     */
    public void setFlagspcutOutSize10T(Long flagspcutOutSize10T) {
        this.flagspcutOutSize10T = flagspcutOutSize10T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize10T() {
        return flagspprepInSize10T;
    }

    /**
     *
     * @param flagspprepInSize10T
     */
    public void setFlagspprepInSize10T(Long flagspprepInSize10T) {
        this.flagspprepInSize10T = flagspprepInSize10T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize10T() {
        return flagspprepOutSize10T;
    }

    /**
     *
     * @param flagspprepOutSize10T
     */
    public void setFlagspprepOutSize10T(Long flagspprepOutSize10T) {
        this.flagspprepOutSize10T = flagspprepOutSize10T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize11() {
        return flagspcutInSize11;
    }

    /**
     *
     * @param flagspcutInSize11
     */
    public void setFlagspcutInSize11(Long flagspcutInSize11) {
        this.flagspcutInSize11 = flagspcutInSize11;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize11() {
        return flagspcutOutSize11;
    }

    /**
     *
     * @param flagspcutOutSize11
     */
    public void setFlagspcutOutSize11(Long flagspcutOutSize11) {
        this.flagspcutOutSize11 = flagspcutOutSize11;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize11() {
        return flagspprepInSize11;
    }

    /**
     *
     * @param flagspprepInSize11
     */
    public void setFlagspprepInSize11(Long flagspprepInSize11) {
        this.flagspprepInSize11 = flagspprepInSize11;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize11() {
        return flagspprepOutSize11;
    }

    /**
     *
     * @param flagspprepOutSize11
     */
    public void setFlagspprepOutSize11(Long flagspprepOutSize11) {
        this.flagspprepOutSize11 = flagspprepOutSize11;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize11T() {
        return flagspcutInSize11T;
    }

    /**
     *
     * @param flagspcutInSize11T
     */
    public void setFlagspcutInSize11T(Long flagspcutInSize11T) {
        this.flagspcutInSize11T = flagspcutInSize11T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize11T() {
        return flagspcutOutSize11T;
    }

    /**
     *
     * @param flagspcutOutSize11T
     */
    public void setFlagspcutOutSize11T(Long flagspcutOutSize11T) {
        this.flagspcutOutSize11T = flagspcutOutSize11T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize11T() {
        return flagspprepInSize11T;
    }

    /**
     *
     * @param flagspprepInSize11T
     */
    public void setFlagspprepInSize11T(Long flagspprepInSize11T) {
        this.flagspprepInSize11T = flagspprepInSize11T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize11T() {
        return flagspprepOutSize11T;
    }

    /**
     *
     * @param flagspprepOutSize11T
     */
    public void setFlagspprepOutSize11T(Long flagspprepOutSize11T) {
        this.flagspprepOutSize11T = flagspprepOutSize11T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize12() {
        return flagspcutInSize12;
    }

    /**
     *
     * @param flagspcutInSize12
     */
    public void setFlagspcutInSize12(Long flagspcutInSize12) {
        this.flagspcutInSize12 = flagspcutInSize12;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize12() {
        return flagspcutOutSize12;
    }

    /**
     *
     * @param flagspcutOutSize12
     */
    public void setFlagspcutOutSize12(Long flagspcutOutSize12) {
        this.flagspcutOutSize12 = flagspcutOutSize12;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize12() {
        return flagspprepInSize12;
    }

    /**
     *
     * @param flagspprepInSize12
     */
    public void setFlagspprepInSize12(Long flagspprepInSize12) {
        this.flagspprepInSize12 = flagspprepInSize12;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize12() {
        return flagspprepOutSize12;
    }

    /**
     *
     * @param flagspprepOutSize12
     */
    public void setFlagspprepOutSize12(Long flagspprepOutSize12) {
        this.flagspprepOutSize12 = flagspprepOutSize12;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize12T() {
        return flagspcutInSize12T;
    }

    /**
     *
     * @param flagspcutInSize12T
     */
    public void setFlagspcutInSize12T(Long flagspcutInSize12T) {
        this.flagspcutInSize12T = flagspcutInSize12T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize12T() {
        return flagspcutOutSize12T;
    }

    /**
     *
     * @param flagspcutOutSize12T
     */
    public void setFlagspcutOutSize12T(Long flagspcutOutSize12T) {
        this.flagspcutOutSize12T = flagspcutOutSize12T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize12T() {
        return flagspprepInSize12T;
    }

    /**
     *
     * @param flagspprepInSize12T
     */
    public void setFlagspprepInSize12T(Long flagspprepInSize12T) {
        this.flagspprepInSize12T = flagspprepInSize12T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize12T() {
        return flagspprepOutSize12T;
    }

    /**
     *
     * @param flagspprepOutSize12T
     */
    public void setFlagspprepOutSize12T(Long flagspprepOutSize12T) {
        this.flagspprepOutSize12T = flagspprepOutSize12T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize13() {
        return flagspcutInSize13;
    }

    /**
     *
     * @param flagspcutInSize13
     */
    public void setFlagspcutInSize13(Long flagspcutInSize13) {
        this.flagspcutInSize13 = flagspcutInSize13;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize13() {
        return flagspcutOutSize13;
    }

    /**
     *
     * @param flagspcutOutSize13
     */
    public void setFlagspcutOutSize13(Long flagspcutOutSize13) {
        this.flagspcutOutSize13 = flagspcutOutSize13;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize13() {
        return flagspprepInSize13;
    }

    /**
     *
     * @param flagspprepInSize13
     */
    public void setFlagspprepInSize13(Long flagspprepInSize13) {
        this.flagspprepInSize13 = flagspprepInSize13;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize13() {
        return flagspprepOutSize13;
    }

    /**
     *
     * @param flagspprepOutSize13
     */
    public void setFlagspprepOutSize13(Long flagspprepOutSize13) {
        this.flagspprepOutSize13 = flagspprepOutSize13;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize13T() {
        return flagspcutInSize13T;
    }

    /**
     *
     * @param flagspcutInSize13T
     */
    public void setFlagspcutInSize13T(Long flagspcutInSize13T) {
        this.flagspcutInSize13T = flagspcutInSize13T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize13T() {
        return flagspcutOutSize13T;
    }

    /**
     *
     * @param flagspcutOutSize13T
     */
    public void setFlagspcutOutSize13T(Long flagspcutOutSize13T) {
        this.flagspcutOutSize13T = flagspcutOutSize13T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize13T() {
        return flagspprepInSize13T;
    }

    /**
     *
     * @param flagspprepInSize13T
     */
    public void setFlagspprepInSize13T(Long flagspprepInSize13T) {
        this.flagspprepInSize13T = flagspprepInSize13T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize13T() {
        return flagspprepOutSize13T;
    }

    /**
     *
     * @param flagspprepOutSize13T
     */
    public void setFlagspprepOutSize13T(Long flagspprepOutSize13T) {
        this.flagspprepOutSize13T = flagspprepOutSize13T;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize14() {
        return flagspcutInSize14;
    }

    /**
     *
     * @param flagspcutInSize14
     */
    public void setFlagspcutInSize14(Long flagspcutInSize14) {
        this.flagspcutInSize14 = flagspcutInSize14;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize14() {
        return flagspcutOutSize14;
    }

    /**
     *
     * @param flagspcutOutSize14
     */
    public void setFlagspcutOutSize14(Long flagspcutOutSize14) {
        this.flagspcutOutSize14 = flagspcutOutSize14;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize14() {
        return flagspprepInSize14;
    }

    /**
     *
     * @param flagspprepInSize14
     */
    public void setFlagspprepInSize14(Long flagspprepInSize14) {
        this.flagspprepInSize14 = flagspprepInSize14;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize14() {
        return flagspprepOutSize14;
    }

    /**
     *
     * @param flagspprepOutSize14
     */
    public void setFlagspprepOutSize14(Long flagspprepOutSize14) {
        this.flagspprepOutSize14 = flagspprepOutSize14;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize15() {
        return flagspcutInSize15;
    }

    /**
     *
     * @param flagspcutInSize15
     */
    public void setFlagspcutInSize15(Long flagspcutInSize15) {
        this.flagspcutInSize15 = flagspcutInSize15;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize15() {
        return flagspcutOutSize15;
    }

    /**
     *
     * @param flagspcutOutSize15
     */
    public void setFlagspcutOutSize15(Long flagspcutOutSize15) {
        this.flagspcutOutSize15 = flagspcutOutSize15;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize15() {
        return flagspprepInSize15;
    }

    /**
     *
     * @param flagspprepInSize15
     */
    public void setFlagspprepInSize15(Long flagspprepInSize15) {
        this.flagspprepInSize15 = flagspprepInSize15;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize15() {
        return flagspprepOutSize15;
    }

    /**
     *
     * @param flagspprepOutSize15
     */
    public void setFlagspprepOutSize15(Long flagspprepOutSize15) {
        this.flagspprepOutSize15 = flagspprepOutSize15;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize16() {
        return flagspcutInSize16;
    }

    /**
     *
     * @param flagspcutInSize16
     */
    public void setFlagspcutInSize16(Long flagspcutInSize16) {
        this.flagspcutInSize16 = flagspcutInSize16;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize16() {
        return flagspcutOutSize16;
    }

    /**
     *
     * @param flagspcutOutSize16
     */
    public void setFlagspcutOutSize16(Long flagspcutOutSize16) {
        this.flagspcutOutSize16 = flagspcutOutSize16;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize16() {
        return flagspprepInSize16;
    }

    /**
     *
     * @param flagspprepInSize16
     */
    public void setFlagspprepInSize16(Long flagspprepInSize16) {
        this.flagspprepInSize16 = flagspprepInSize16;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize16() {
        return flagspprepOutSize16;
    }

    /**
     *
     * @param flagspprepOutSize16
     */
    public void setFlagspprepOutSize16(Long flagspprepOutSize16) {
        this.flagspprepOutSize16 = flagspprepOutSize16;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize17() {
        return flagspcutInSize17;
    }

    /**
     *
     * @param flagspcutInSize17
     */
    public void setFlagspcutInSize17(Long flagspcutInSize17) {
        this.flagspcutInSize17 = flagspcutInSize17;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize17() {
        return flagspcutOutSize17;
    }

    /**
     *
     * @param flagspcutOutSize17
     */
    public void setFlagspcutOutSize17(Long flagspcutOutSize17) {
        this.flagspcutOutSize17 = flagspcutOutSize17;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize17() {
        return flagspprepInSize17;
    }

    /**
     *
     * @param flagspprepInSize17
     */
    public void setFlagspprepInSize17(Long flagspprepInSize17) {
        this.flagspprepInSize17 = flagspprepInSize17;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize17() {
        return flagspprepOutSize17;
    }

    /**
     *
     * @param flagspprepOutSize17
     */
    public void setFlagspprepOutSize17(Long flagspprepOutSize17) {
        this.flagspprepOutSize17 = flagspprepOutSize17;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutInSize18() {
        return flagspcutInSize18;
    }

    /**
     *
     * @param flagspcutInSize18
     */
    public void setFlagspcutInSize18(Long flagspcutInSize18) {
        this.flagspcutInSize18 = flagspcutInSize18;
    }

    /**
     *
     * @return
     */
    public Long getFlagspcutOutSize18() {
        return flagspcutOutSize18;
    }

    /**
     *
     * @param flagspcutOutSize18
     */
    public void setFlagspcutOutSize18(Long flagspcutOutSize18) {
        this.flagspcutOutSize18 = flagspcutOutSize18;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepInSize18() {
        return flagspprepInSize18;
    }

    /**
     *
     * @param flagspprepInSize18
     */
    public void setFlagspprepInSize18(Long flagspprepInSize18) {
        this.flagspprepInSize18 = flagspprepInSize18;
    }

    /**
     *
     * @return
     */
    public Long getFlagspprepOutSize18() {
        return flagspprepOutSize18;
    }

    /**
     *
     * @param flagspprepOutSize18
     */
    public void setFlagspprepOutSize18(Long flagspprepOutSize18) {
        this.flagspprepOutSize18 = flagspprepOutSize18;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize1() {
        return flagLabelInSize1;
    }

    /**
     *
     * @param flagLabelInSize1
     */
    public void setFlagLabelInSize1(Long flagLabelInSize1) {
        this.flagLabelInSize1 = flagLabelInSize1;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize1t() {
        return flagLabelInSize1T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize1T() {
        return flagLabelInSize1T;
    }

    /**
     *
     * @param flagLabelInSize1T
     */
    public void setFlagLabelInSize1T(Long flagLabelInSize1T) {
        this.flagLabelInSize1T = flagLabelInSize1T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize2() {
        return flagLabelInSize2;
    }

    /**
     *
     * @param flagLabelInSize2
     */
    public void setFlagLabelInSize2(Long flagLabelInSize2) {
        this.flagLabelInSize2 = flagLabelInSize2;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize2T() {
        return flagLabelInSize2T;
    }

    /**
     *
     * @param flagLabelInSize2T
     */
    public void setFlagLabelInSize2T(Long flagLabelInSize2T) {
        this.flagLabelInSize2T = flagLabelInSize2T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize3() {
        return flagLabelInSize3;
    }

    /**
     *
     * @param flagLabelInSize3
     */
    public void setFlagLabelInSize3(Long flagLabelInSize3) {
        this.flagLabelInSize3 = flagLabelInSize3;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize3T() {
        return flagLabelInSize3T;
    }

    /**
     *
     * @param flagLabelInSize3T
     */
    public void setFlagLabelInSize3T(Long flagLabelInSize3T) {
        this.flagLabelInSize3T = flagLabelInSize3T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize4() {
        return flagLabelInSize4;
    }

    /**
     *
     * @param flagLabelInSize4
     */
    public void setFlagLabelInSize4(Long flagLabelInSize4) {
        this.flagLabelInSize4 = flagLabelInSize4;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize4T() {
        return flagLabelInSize4T;
    }

    /**
     *
     * @param flagLabelInSize4T
     */
    public void setFlagLabelInSize4T(Long flagLabelInSize4T) {
        this.flagLabelInSize4T = flagLabelInSize4T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize5() {
        return flagLabelInSize5;
    }

    /**
     *
     * @param flagLabelInSize5
     */
    public void setFlagLabelInSize5(Long flagLabelInSize5) {
        this.flagLabelInSize5 = flagLabelInSize5;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize5T() {
        return flagLabelInSize5T;
    }

    /**
     *
     * @param flagLabelInSize5T
     */
    public void setFlagLabelInSize5T(Long flagLabelInSize5T) {
        this.flagLabelInSize5T = flagLabelInSize5T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize6() {
        return flagLabelInSize6;
    }

    /**
     *
     * @param flagLabelInSize6
     */
    public void setFlagLabelInSize6(Long flagLabelInSize6) {
        this.flagLabelInSize6 = flagLabelInSize6;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize6T() {
        return flagLabelInSize6T;
    }

    /**
     *
     * @param flagLabelInSize6T
     */
    public void setFlagLabelInSize6T(Long flagLabelInSize6T) {
        this.flagLabelInSize6T = flagLabelInSize6T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize7() {
        return flagLabelInSize7;
    }

    /**
     *
     * @param flagLabelInSize7
     */
    public void setFlagLabelInSize7(Long flagLabelInSize7) {
        this.flagLabelInSize7 = flagLabelInSize7;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize7T() {
        return flagLabelInSize7T;
    }

    /**
     *
     * @param flagLabelInSize7T
     */
    public void setFlagLabelInSize7T(Long flagLabelInSize7T) {
        this.flagLabelInSize7T = flagLabelInSize7T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize8() {
        return flagLabelInSize8;
    }

    /**
     *
     * @param flagLabelInSize8
     */
    public void setFlagLabelInSize8(Long flagLabelInSize8) {
        this.flagLabelInSize8 = flagLabelInSize8;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize8T() {
        return flagLabelInSize8T;
    }

    /**
     *
     * @param flagLabelInSize8T
     */
    public void setFlagLabelInSize8T(Long flagLabelInSize8T) {
        this.flagLabelInSize8T = flagLabelInSize8T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize9() {
        return flagLabelInSize9;
    }

    /**
     *
     * @param flagLabelInSize9
     */
    public void setFlagLabelInSize9(Long flagLabelInSize9) {
        this.flagLabelInSize9 = flagLabelInSize9;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize9T() {
        return flagLabelInSize9T;
    }

    /**
     *
     * @param flagLabelInSize9T
     */
    public void setFlagLabelInSize9T(Long flagLabelInSize9T) {
        this.flagLabelInSize9T = flagLabelInSize9T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize10() {
        return flagLabelInSize10;
    }

    /**
     *
     * @param flagLabelInSize10
     */
    public void setFlagLabelInSize10(Long flagLabelInSize10) {
        this.flagLabelInSize10 = flagLabelInSize10;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize10T() {
        return flagLabelInSize10T;
    }

    /**
     *
     * @param flagLabelInSize10T
     */
    public void setFlagLabelInSize10T(Long flagLabelInSize10T) {
        this.flagLabelInSize10T = flagLabelInSize10T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize11() {
        return flagLabelInSize11;
    }

    /**
     *
     * @param flagLabelInSize11
     */
    public void setFlagLabelInSize11(Long flagLabelInSize11) {
        this.flagLabelInSize11 = flagLabelInSize11;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize11T() {
        return flagLabelInSize11T;
    }

    /**
     *
     * @param flagLabelInSize11T
     */
    public void setFlagLabelInSize11T(Long flagLabelInSize11T) {
        this.flagLabelInSize11T = flagLabelInSize11T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize12() {
        return flagLabelInSize12;
    }

    /**
     *
     * @param flagLabelInSize12
     */
    public void setFlagLabelInSize12(Long flagLabelInSize12) {
        this.flagLabelInSize12 = flagLabelInSize12;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize12T() {
        return flagLabelInSize12T;
    }

    /**
     *
     * @param flagLabelInSize12T
     */
    public void setFlagLabelInSize12T(Long flagLabelInSize12T) {
        this.flagLabelInSize12T = flagLabelInSize12T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize13() {
        return flagLabelInSize13;
    }

    /**
     *
     * @param flagLabelInSize13
     */
    public void setFlagLabelInSize13(Long flagLabelInSize13) {
        this.flagLabelInSize13 = flagLabelInSize13;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize13T() {
        return flagLabelInSize13T;
    }

    /**
     *
     * @param flagLabelInSize13T
     */
    public void setFlagLabelInSize13T(Long flagLabelInSize13T) {
        this.flagLabelInSize13T = flagLabelInSize13T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize14() {
        return flagLabelInSize14;
    }

    /**
     *
     * @param flagLabelInSize14
     */
    public void setFlagLabelInSize14(Long flagLabelInSize14) {
        this.flagLabelInSize14 = flagLabelInSize14;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize15() {
        return flagLabelInSize15;
    }

    /**
     *
     * @param flagLabelInSize15
     */
    public void setFlagLabelInSize15(Long flagLabelInSize15) {
        this.flagLabelInSize15 = flagLabelInSize15;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize16() {
        return flagLabelInSize16;
    }

    /**
     *
     * @param flagLabelInSize16
     */
    public void setFlagLabelInSize16(Long flagLabelInSize16) {
        this.flagLabelInSize16 = flagLabelInSize16;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize17() {
        return flagLabelInSize17;
    }

    /**
     *
     * @param flagLabelInSize17
     */
    public void setFlagLabelInSize17(Long flagLabelInSize17) {
        this.flagLabelInSize17 = flagLabelInSize17;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelInSize18() {
        return flagLabelInSize18;
    }

    /**
     *
     * @param flagLabelInSize18
     */
    public void setFlagLabelInSize18(Long flagLabelInSize18) {
        this.flagLabelInSize18 = flagLabelInSize18;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize1() {
        return flagLaserInSize1;
    }

    /**
     *
     * @param flagLaserInSize1
     */
    public void setFlagLaserInSize1(Long flagLaserInSize1) {
        this.flagLaserInSize1 = flagLaserInSize1;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize1T() {
        return flagLaserInSize1T;
    }

    /**
     *
     * @param flagLaserInSize1T
     */
    public void setFlagLaserInSize1T(Long flagLaserInSize1T) {
        this.flagLaserInSize1T = flagLaserInSize1T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize2() {
        return flagLaserInSize2;
    }

    /**
     *
     * @param flagLaserInSize2
     */
    public void setFlagLaserInSize2(Long flagLaserInSize2) {
        this.flagLaserInSize2 = flagLaserInSize2;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize2T() {
        return flagLaserInSize2T;
    }

    /**
     *
     * @param flagLaserInSize2T
     */
    public void setFlagLaserInSize2T(Long flagLaserInSize2T) {
        this.flagLaserInSize2T = flagLaserInSize2T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize3() {
        return flagLaserInSize3;
    }

    /**
     *
     * @param flagLaserInSize3
     */
    public void setFlagLaserInSize3(Long flagLaserInSize3) {
        this.flagLaserInSize3 = flagLaserInSize3;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize3T() {
        return flagLaserInSize3T;
    }

    /**
     *
     * @param flagLaserInSize3T
     */
    public void setFlagLaserInSize3T(Long flagLaserInSize3T) {
        this.flagLaserInSize3T = flagLaserInSize3T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize4() {
        return flagLaserInSize4;
    }

    /**
     *
     * @param flagLaserInSize4
     */
    public void setFlagLaserInSize4(Long flagLaserInSize4) {
        this.flagLaserInSize4 = flagLaserInSize4;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize4T() {
        return flagLaserInSize4T;
    }

    /**
     *
     * @param flagLaserInSize4T
     */
    public void setFlagLaserInSize4T(Long flagLaserInSize4T) {
        this.flagLaserInSize4T = flagLaserInSize4T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize5() {
        return flagLaserInSize5;
    }

    /**
     *
     * @param flagLaserInSize5
     */
    public void setFlagLaserInSize5(Long flagLaserInSize5) {
        this.flagLaserInSize5 = flagLaserInSize5;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize5T() {
        return flagLaserInSize5T;
    }

    /**
     *
     * @param flagLaserInSize5T
     */
    public void setFlagLaserInSize5T(Long flagLaserInSize5T) {
        this.flagLaserInSize5T = flagLaserInSize5T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize6() {
        return flagLaserInSize6;
    }

    /**
     *
     * @param flagLaserInSize6
     */
    public void setFlagLaserInSize6(Long flagLaserInSize6) {
        this.flagLaserInSize6 = flagLaserInSize6;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize6T() {
        return flagLaserInSize6T;
    }

    /**
     *
     * @param flagLaserInSize6T
     */
    public void setFlagLaserInSize6T(Long flagLaserInSize6T) {
        this.flagLaserInSize6T = flagLaserInSize6T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize7() {
        return flagLaserInSize7;
    }

    /**
     *
     * @param flagLaserInSize7
     */
    public void setFlagLaserInSize7(Long flagLaserInSize7) {
        this.flagLaserInSize7 = flagLaserInSize7;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize7T() {
        return flagLaserInSize7T;
    }

    /**
     *
     * @param flagLaserInSize7T
     */
    public void setFlagLaserInSize7T(Long flagLaserInSize7T) {
        this.flagLaserInSize7T = flagLaserInSize7T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize8() {
        return flagLaserInSize8;
    }

    /**
     *
     * @param flagLaserInSize8
     */
    public void setFlagLaserInSize8(Long flagLaserInSize8) {
        this.flagLaserInSize8 = flagLaserInSize8;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize8T() {
        return flagLaserInSize8T;
    }

    /**
     *
     * @param flagLaserInSize8T
     */
    public void setFlagLaserInSize8T(Long flagLaserInSize8T) {
        this.flagLaserInSize8T = flagLaserInSize8T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize9() {
        return flagLaserInSize9;
    }

    /**
     *
     * @param flagLaserInSize9
     */
    public void setFlagLaserInSize9(Long flagLaserInSize9) {
        this.flagLaserInSize9 = flagLaserInSize9;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize9T() {
        return flagLaserInSize9T;
    }

    /**
     *
     * @param flagLaserInSize9T
     */
    public void setFlagLaserInSize9T(Long flagLaserInSize9T) {
        this.flagLaserInSize9T = flagLaserInSize9T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize10() {
        return flagLaserInSize10;
    }

    /**
     *
     * @param flagLaserInSize10
     */
    public void setFlagLaserInSize10(Long flagLaserInSize10) {
        this.flagLaserInSize10 = flagLaserInSize10;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize10T() {
        return flagLaserInSize10T;
    }

    /**
     *
     * @param flagLaserInSize10T
     */
    public void setFlagLaserInSize10T(Long flagLaserInSize10T) {
        this.flagLaserInSize10T = flagLaserInSize10T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize11() {
        return flagLaserInSize11;
    }

    /**
     *
     * @param flagLaserInSize11
     */
    public void setFlagLaserInSize11(Long flagLaserInSize11) {
        this.flagLaserInSize11 = flagLaserInSize11;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize11T() {
        return flagLaserInSize11T;
    }

    /**
     *
     * @param flagLaserInSize11T
     */
    public void setFlagLaserInSize11T(Long flagLaserInSize11T) {
        this.flagLaserInSize11T = flagLaserInSize11T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize12() {
        return flagLaserInSize12;
    }

    /**
     *
     * @param flagLaserInSize12
     */
    public void setFlagLaserInSize12(Long flagLaserInSize12) {
        this.flagLaserInSize12 = flagLaserInSize12;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize12T() {
        return flagLaserInSize12T;
    }

    /**
     *
     * @param flagLaserInSize12T
     */
    public void setFlagLaserInSize12T(Long flagLaserInSize12T) {
        this.flagLaserInSize12T = flagLaserInSize12T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize13() {
        return flagLaserInSize13;
    }

    /**
     *
     * @param flagLaserInSize13
     */
    public void setFlagLaserInSize13(Long flagLaserInSize13) {
        this.flagLaserInSize13 = flagLaserInSize13;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize13T() {
        return flagLaserInSize13T;
    }

    /**
     *
     * @param flagLaserInSize13T
     */
    public void setFlagLaserInSize13T(Long flagLaserInSize13T) {
        this.flagLaserInSize13T = flagLaserInSize13T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize14() {
        return flagLaserInSize14;
    }

    /**
     *
     * @param flagLaserInSize14
     */
    public void setFlagLaserInSize14(Long flagLaserInSize14) {
        this.flagLaserInSize14 = flagLaserInSize14;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize15() {
        return flagLaserInSize15;
    }

    /**
     *
     * @param flagLaserInSize15
     */
    public void setFlagLaserInSize15(Long flagLaserInSize15) {
        this.flagLaserInSize15 = flagLaserInSize15;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize16() {
        return flagLaserInSize16;
    }

    /**
     *
     * @param flagLaserInSize16
     */
    public void setFlagLaserInSize16(Long flagLaserInSize16) {
        this.flagLaserInSize16 = flagLaserInSize16;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize17() {
        return flagLaserInSize17;
    }

    /**
     *
     * @param flagLaserInSize17
     */
    public void setFlagLaserInSize17(Long flagLaserInSize17) {
        this.flagLaserInSize17 = flagLaserInSize17;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserInSize18() {
        return flagLaserInSize18;
    }

    /**
     *
     * @param flagLaserInSize18
     */
    public void setFlagLaserInSize18(Long flagLaserInSize18) {
        this.flagLaserInSize18 = flagLaserInSize18;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize1() {
        return flagLabelOutSize1;
    }

    /**
     *
     * @param flagLabelOutSize1
     */
    public void setFlagLabelOutSize1(Long flagLabelOutSize1) {
        this.flagLabelOutSize1 = flagLabelOutSize1;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize1T() {
        return flagLabelOutSize1T;
    }

    /**
     *
     * @param flagLabelOutSize1T
     */
    public void setFlagLabelOutSize1T(Long flagLabelOutSize1T) {
        this.flagLabelOutSize1T = flagLabelOutSize1T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize2() {
        return flagLabelOutSize2;
    }

    /**
     *
     * @param flagLabelOutSize2
     */
    public void setFlagLabelOutSize2(Long flagLabelOutSize2) {
        this.flagLabelOutSize2 = flagLabelOutSize2;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize2T() {
        return flagLabelOutSize2T;
    }

    /**
     *
     * @param flagLabelOutSize2T
     */
    public void setFlagLabelOutSize2T(Long flagLabelOutSize2T) {
        this.flagLabelOutSize2T = flagLabelOutSize2T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize3() {
        return flagLabelOutSize3;
    }

    /**
     *
     * @param flagLabelOutSize3
     */
    public void setFlagLabelOutSize3(Long flagLabelOutSize3) {
        this.flagLabelOutSize3 = flagLabelOutSize3;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize3T() {
        return flagLabelOutSize3T;
    }

    /**
     *
     * @param flagLabelOutSize3T
     */
    public void setFlagLabelOutSize3T(Long flagLabelOutSize3T) {
        this.flagLabelOutSize3T = flagLabelOutSize3T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize4() {
        return flagLabelOutSize4;
    }

    /**
     *
     * @param flagLabelOutSize4
     */
    public void setFlagLabelOutSize4(Long flagLabelOutSize4) {
        this.flagLabelOutSize4 = flagLabelOutSize4;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize4T() {
        return flagLabelOutSize4T;
    }

    /**
     *
     * @param flagLabelOutSize4T
     */
    public void setFlagLabelOutSize4T(Long flagLabelOutSize4T) {
        this.flagLabelOutSize4T = flagLabelOutSize4T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize5() {
        return flagLabelOutSize5;
    }

    /**
     *
     * @param flagLabelOutSize5
     */
    public void setFlagLabelOutSize5(Long flagLabelOutSize5) {
        this.flagLabelOutSize5 = flagLabelOutSize5;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize5T() {
        return flagLabelOutSize5T;
    }

    /**
     *
     * @param flagLabelOutSize5T
     */
    public void setFlagLabelOutSize5T(Long flagLabelOutSize5T) {
        this.flagLabelOutSize5T = flagLabelOutSize5T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize6() {
        return flagLabelOutSize6;
    }

    /**
     *
     * @param flagLabelOutSize6
     */
    public void setFlagLabelOutSize6(Long flagLabelOutSize6) {
        this.flagLabelOutSize6 = flagLabelOutSize6;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize6T() {
        return flagLabelOutSize6T;
    }

    /**
     *
     * @param flagLabelOutSize6T
     */
    public void setFlagLabelOutSize6T(Long flagLabelOutSize6T) {
        this.flagLabelOutSize6T = flagLabelOutSize6T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize7() {
        return flagLabelOutSize7;
    }

    /**
     *
     * @param flagLabelOutSize7
     */
    public void setFlagLabelOutSize7(Long flagLabelOutSize7) {
        this.flagLabelOutSize7 = flagLabelOutSize7;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize7T() {
        return flagLabelOutSize7T;
    }

    /**
     *
     * @param flagLabelOutSize7T
     */
    public void setFlagLabelOutSize7T(Long flagLabelOutSize7T) {
        this.flagLabelOutSize7T = flagLabelOutSize7T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize8() {
        return flagLabelOutSize8;
    }

    /**
     *
     * @param flagLabelOutSize8
     */
    public void setFlagLabelOutSize8(Long flagLabelOutSize8) {
        this.flagLabelOutSize8 = flagLabelOutSize8;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize8T() {
        return flagLabelOutSize8T;
    }

    /**
     *
     * @param flagLabelOutSize8T
     */
    public void setFlagLabelOutSize8T(Long flagLabelOutSize8T) {
        this.flagLabelOutSize8T = flagLabelOutSize8T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize9() {
        return flagLabelOutSize9;
    }

    /**
     *
     * @param flagLabelOutSize9
     */
    public void setFlagLabelOutSize9(Long flagLabelOutSize9) {
        this.flagLabelOutSize9 = flagLabelOutSize9;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize9T() {
        return flagLabelOutSize9T;
    }

    /**
     *
     * @param flagLabelOutSize9T
     */
    public void setFlagLabelOutSize9T(Long flagLabelOutSize9T) {
        this.flagLabelOutSize9T = flagLabelOutSize9T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize10() {
        return flagLabelOutSize10;
    }

    /**
     *
     * @param flagLabelOutSize10
     */
    public void setFlagLabelOutSize10(Long flagLabelOutSize10) {
        this.flagLabelOutSize10 = flagLabelOutSize10;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize10T() {
        return flagLabelOutSize10T;
    }

    /**
     *
     * @param flagLabelOutSize10T
     */
    public void setFlagLabelOutSize10T(Long flagLabelOutSize10T) {
        this.flagLabelOutSize10T = flagLabelOutSize10T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize11() {
        return flagLabelOutSize11;
    }

    /**
     *
     * @param flagLabelOutSize11
     */
    public void setFlagLabelOutSize11(Long flagLabelOutSize11) {
        this.flagLabelOutSize11 = flagLabelOutSize11;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize11T() {
        return flagLabelOutSize11T;
    }

    /**
     *
     * @param flagLabelOutSize11T
     */
    public void setFlagLabelOutSize11T(Long flagLabelOutSize11T) {
        this.flagLabelOutSize11T = flagLabelOutSize11T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize12() {
        return flagLabelOutSize12;
    }

    /**
     *
     * @param flagLabelOutSize12
     */
    public void setFlagLabelOutSize12(Long flagLabelOutSize12) {
        this.flagLabelOutSize12 = flagLabelOutSize12;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize12T() {
        return flagLabelOutSize12T;
    }

    /**
     *
     * @param flagLabelOutSize12T
     */
    public void setFlagLabelOutSize12T(Long flagLabelOutSize12T) {
        this.flagLabelOutSize12T = flagLabelOutSize12T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize13() {
        return flagLabelOutSize13;
    }

    /**
     *
     * @param flagLabelOutSize13
     */
    public void setFlagLabelOutSize13(Long flagLabelOutSize13) {
        this.flagLabelOutSize13 = flagLabelOutSize13;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize13T() {
        return flagLabelOutSize13T;
    }

    /**
     *
     * @param flagLabelOutSize13T
     */
    public void setFlagLabelOutSize13T(Long flagLabelOutSize13T) {
        this.flagLabelOutSize13T = flagLabelOutSize13T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize14() {
        return flagLabelOutSize14;
    }

    /**
     *
     * @param flagLabelOutSize14
     */
    public void setFlagLabelOutSize14(Long flagLabelOutSize14) {
        this.flagLabelOutSize14 = flagLabelOutSize14;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize15() {
        return flagLabelOutSize15;
    }

    /**
     *
     * @param flagLabelOutSize15
     */
    public void setFlagLabelOutSize15(Long flagLabelOutSize15) {
        this.flagLabelOutSize15 = flagLabelOutSize15;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize16() {
        return flagLabelOutSize16;
    }

    /**
     *
     * @param flagLabelOutSize16
     */
    public void setFlagLabelOutSize16(Long flagLabelOutSize16) {
        this.flagLabelOutSize16 = flagLabelOutSize16;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize17() {
        return flagLabelOutSize17;
    }

    /**
     *
     * @param flagLabelOutSize17
     */
    public void setFlagLabelOutSize17(Long flagLabelOutSize17) {
        this.flagLabelOutSize17 = flagLabelOutSize17;
    }

    /**
     *
     * @return
     */
    public Long getFlagLabelOutSize18() {
        return flagLabelOutSize18;
    }

    /**
     *
     * @param flagLabelOutSize18
     */
    public void setFlagLabelOutSize18(Long flagLabelOutSize18) {
        this.flagLabelOutSize18 = flagLabelOutSize18;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize1() {
        return flagLaserOutSize1;
    }

    /**
     *
     * @param flagLaserOutSize1
     */
    public void setFlagLaserOutSize1(Long flagLaserOutSize1) {
        this.flagLaserOutSize1 = flagLaserOutSize1;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize1T() {
        return flagLaserOutSize1T;
    }

    /**
     *
     * @param flagLaserOutSize1T
     */
    public void setFlagLaserOutSize1T(Long flagLaserOutSize1T) {
        this.flagLaserOutSize1T = flagLaserOutSize1T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize2() {
        return flagLaserOutSize2;
    }

    /**
     *
     * @param flagLaserOutSize2
     */
    public void setFlagLaserOutSize2(Long flagLaserOutSize2) {
        this.flagLaserOutSize2 = flagLaserOutSize2;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize2T() {
        return flagLaserOutSize2T;
    }

    /**
     *
     * @param flagLaserOutSize2T
     */
    public void setFlagLaserOutSize2T(Long flagLaserOutSize2T) {
        this.flagLaserOutSize2T = flagLaserOutSize2T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize3() {
        return flagLaserOutSize3;
    }

    /**
     *
     * @param flagLaserOutSize3
     */
    public void setFlagLaserOutSize3(Long flagLaserOutSize3) {
        this.flagLaserOutSize3 = flagLaserOutSize3;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize3T() {
        return flagLaserOutSize3T;
    }

    /**
     *
     * @param flagLaserOutSize3T
     */
    public void setFlagLaserOutSize3T(Long flagLaserOutSize3T) {
        this.flagLaserOutSize3T = flagLaserOutSize3T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize4() {
        return flagLaserOutSize4;
    }

    /**
     *
     * @param flagLaserOutSize4
     */
    public void setFlagLaserOutSize4(Long flagLaserOutSize4) {
        this.flagLaserOutSize4 = flagLaserOutSize4;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize4T() {
        return flagLaserOutSize4T;
    }

    /**
     *
     * @param flagLaserOutSize4T
     */
    public void setFlagLaserOutSize4T(Long flagLaserOutSize4T) {
        this.flagLaserOutSize4T = flagLaserOutSize4T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize5() {
        return flagLaserOutSize5;
    }

    /**
     *
     * @param flagLaserOutSize5
     */
    public void setFlagLaserOutSize5(Long flagLaserOutSize5) {
        this.flagLaserOutSize5 = flagLaserOutSize5;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize5T() {
        return flagLaserOutSize5T;
    }

    /**
     *
     * @param flagLaserOutSize5T
     */
    public void setFlagLaserOutSize5T(Long flagLaserOutSize5T) {
        this.flagLaserOutSize5T = flagLaserOutSize5T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize6() {
        return flagLaserOutSize6;
    }

    /**
     *
     * @param flagLaserOutSize6
     */
    public void setFlagLaserOutSize6(Long flagLaserOutSize6) {
        this.flagLaserOutSize6 = flagLaserOutSize6;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize6T() {
        return flagLaserOutSize6T;
    }

    /**
     *
     * @param flagLaserOutSize6T
     */
    public void setFlagLaserOutSize6T(Long flagLaserOutSize6T) {
        this.flagLaserOutSize6T = flagLaserOutSize6T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize7() {
        return flagLaserOutSize7;
    }

    /**
     *
     * @param flagLaserOutSize7
     */
    public void setFlagLaserOutSize7(Long flagLaserOutSize7) {
        this.flagLaserOutSize7 = flagLaserOutSize7;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize7T() {
        return flagLaserOutSize7T;
    }

    /**
     *
     * @param flagLaserOutSize7T
     */
    public void setFlagLaserOutSize7T(Long flagLaserOutSize7T) {
        this.flagLaserOutSize7T = flagLaserOutSize7T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize8() {
        return flagLaserOutSize8;
    }

    /**
     *
     * @param flagLaserOutSize8
     */
    public void setFlagLaserOutSize8(Long flagLaserOutSize8) {
        this.flagLaserOutSize8 = flagLaserOutSize8;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize8T() {
        return flagLaserOutSize8T;
    }

    /**
     *
     * @param flagLaserOutSize8T
     */
    public void setFlagLaserOutSize8T(Long flagLaserOutSize8T) {
        this.flagLaserOutSize8T = flagLaserOutSize8T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize9() {
        return flagLaserOutSize9;
    }

    /**
     *
     * @param flagLaserOutSize9
     */
    public void setFlagLaserOutSize9(Long flagLaserOutSize9) {
        this.flagLaserOutSize9 = flagLaserOutSize9;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize9T() {
        return flagLaserOutSize9T;
    }

    /**
     *
     * @param flagLaserOutSize9T
     */
    public void setFlagLaserOutSize9T(Long flagLaserOutSize9T) {
        this.flagLaserOutSize9T = flagLaserOutSize9T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize10() {
        return flagLaserOutSize10;
    }

    /**
     *
     * @param flagLaserOutSize10
     */
    public void setFlagLaserOutSize10(Long flagLaserOutSize10) {
        this.flagLaserOutSize10 = flagLaserOutSize10;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize10T() {
        return flagLaserOutSize10T;
    }

    /**
     *
     * @param flagLaserOutSize10T
     */
    public void setFlagLaserOutSize10T(Long flagLaserOutSize10T) {
        this.flagLaserOutSize10T = flagLaserOutSize10T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize11() {
        return flagLaserOutSize11;
    }

    /**
     *
     * @param flagLaserOutSize11
     */
    public void setFlagLaserOutSize11(Long flagLaserOutSize11) {
        this.flagLaserOutSize11 = flagLaserOutSize11;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize11T() {
        return flagLaserOutSize11T;
    }

    /**
     *
     * @param flagLaserOutSize11T
     */
    public void setFlagLaserOutSize11T(Long flagLaserOutSize11T) {
        this.flagLaserOutSize11T = flagLaserOutSize11T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize12() {
        return flagLaserOutSize12;
    }

    /**
     *
     * @param flagLaserOutSize12
     */
    public void setFlagLaserOutSize12(Long flagLaserOutSize12) {
        this.flagLaserOutSize12 = flagLaserOutSize12;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize12T() {
        return flagLaserOutSize12T;
    }

    /**
     *
     * @param flagLaserOutSize12T
     */
    public void setFlagLaserOutSize12T(Long flagLaserOutSize12T) {
        this.flagLaserOutSize12T = flagLaserOutSize12T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize13() {
        return flagLaserOutSize13;
    }

    /**
     *
     * @param flagLaserOutSize13
     */
    public void setFlagLaserOutSize13(Long flagLaserOutSize13) {
        this.flagLaserOutSize13 = flagLaserOutSize13;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize13T() {
        return flagLaserOutSize13T;
    }

    /**
     *
     * @param flagLaserOutSize13T
     */
    public void setFlagLaserOutSize13T(Long flagLaserOutSize13T) {
        this.flagLaserOutSize13T = flagLaserOutSize13T;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize14() {
        return flagLaserOutSize14;
    }

    /**
     *
     * @param flagLaserOutSize14
     */
    public void setFlagLaserOutSize14(Long flagLaserOutSize14) {
        this.flagLaserOutSize14 = flagLaserOutSize14;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize15() {
        return flagLaserOutSize15;
    }

    /**
     *
     * @param flagLaserOutSize15
     */
    public void setFlagLaserOutSize15(Long flagLaserOutSize15) {
        this.flagLaserOutSize15 = flagLaserOutSize15;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize16() {
        return flagLaserOutSize16;
    }

    /**
     *
     * @param flagLaserOutSize16
     */
    public void setFlagLaserOutSize16(Long flagLaserOutSize16) {
        this.flagLaserOutSize16 = flagLaserOutSize16;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize17() {
        return flagLaserOutSize17;
    }

    /**
     *
     * @param flagLaserOutSize17
     */
    public void setFlagLaserOutSize17(Long flagLaserOutSize17) {
        this.flagLaserOutSize17 = flagLaserOutSize17;
    }

    /**
     *
     * @return
     */
    public Long getFlagLaserOutSize18() {
        return flagLaserOutSize18;
    }

    /**
     *
     * @param flagLaserOutSize18
     */
    public void setFlagLaserOutSize18(Long flagLaserOutSize18) {
        this.flagLaserOutSize18 = flagLaserOutSize18;
    }

  
    
}
