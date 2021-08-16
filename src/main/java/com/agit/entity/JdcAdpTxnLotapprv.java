package com.agit.entity;

import com.agit.entity.security.JdcAdpMstUser;
import com.agit.entity.util.CustomJsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ridwans
 */
@Entity
@Table(name = "jdcadp_txnlotapprv")
public class JdcAdpTxnLotapprv implements Serializable {

    private static final long serialVersionUID = -4766966230697392291L;

    @Id
    @SequenceGenerator(name = "seq_lotapprv", sequenceName = "seq_lotapprv", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_lotapprv")
    @Column(name = "lotapprv_id")
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

    @Column(name = "size_1")
    private Long size1;

    @Column(name = "size_1_t")
    private Long size1T;

    @Column(name = "size_2")
    private Long size2;

    @Column(name = "size_2_t")
    private Long size2T;

    @Column(name = "size_3")
    private Long size3;

    @Column(name = "size_3_t")
    private Long size3T;

    @Column(name = "size_4")
    private Long size4;

    @Column(name = "size_4_t")
    private Long size4T;

    @Column(name = "size_5")
    private Long size5;

    @Column(name = "size_5_t")
    private Long size5T;

    @Column(name = "size_6")
    private Long size6;

    @Column(name = "size_6_t")
    private Long size6T;

    @Column(name = "size_7")
    private Long size7;

    @Column(name = "size_7_t")
    private Long size7T;

    @Column(name = "size_8")
    private Long size8;

    @Column(name = "size_8_t")
    private Long size8T;

    @Column(name = "size_9")
    private Long size9;

    @Column(name = "size_9_t")
    private Long size9T;

    @Column(name = "size_10")
    private Long size10;

    @Column(name = "size_10_t")
    private Long size10T;

    @Column(name = "size_11")
    private Long size11;

    @Column(name = "size_11_t")
    private Long size11T;

    @Column(name = "size_12")
    private Long size12;

    @Column(name = "size_12_t")
    private Long size12T;

    @Column(name = "size_13")
    private Long size13;

    @Column(name = "size_13_t")
    private Long size13T;

    @Column(name = "size_14")
    private Long size14;

    @Column(name = "size_15")
    private Long size15;

    @Column(name = "size_16")
    private Long size16;

    @Column(name = "size_17")
    private Long size17;

    @Column(name = "size_18")
    private Long size18;

    @Column(name = "approve_1")
    private Long approve1;

    @Column(name = "approve_2")
    private Long approve2;

    @Column(name = "assign_to")
    private Long assignTo;

    @Column(name = "persentase")
    private Long persentase;

    @Column(name = "status")
    private Long status;

    @Column(name = "line_code")
    private String lineCode;

    @Column(name = "po_item")
    private String poItem;

    @Column(name = "po_no")
    private String poNo;

    @Column(name = "remark")
    private String remark;
    
    @Column(name = "flag_express_ct_in_size_1")
    private Long flagExCtInSize1;
    @Column(name = "flag_express_ct_out_size_1")
    private Long flagExCtOutSize1;
    @Column(name = "flag_express_ct_in_size_2")
    private Long flagExCtInSize2;
    @Column(name = "flag_express_ct_out_size_2")
    private Long flagExCtOutSize2;
    @Column(name = "flag_express_ct_in_size_3")
    private Long flagExCtInSize3;
    @Column(name = "flag_express_ct_out_size_3")
    private Long flagExCtOutSize3;
    @Column(name = "flag_express_ct_in_size_4")
    private Long flagExCtInSize4;
    @Column(name = "flag_express_ct_out_size_4")
    private Long flagExCtOutSize4;
    @Column(name = "flag_express_ct_in_size_5")
    private Long flagExCtInSize5;
    @Column(name = "flag_express_ct_out_size_5")
    private Long flagExCtOutSize5;
    @Column(name = "flag_express_ct_in_size_6")
    private Long flagExCtInSize6;
    @Column(name = "flag_express_ct_out_size_6")
    private Long flagExCtOutSize6;
    @Column(name = "flag_express_ct_in_size_7")
    private Long flagExCtInSize7;
    @Column(name = "flag_express_ct_out_size_7")
    private Long flagExCtOutSize7;
    @Column(name = "flag_express_ct_in_size_8")
    private Long flagExCtInSize8;
    @Column(name = "flag_express_ct_out_size_8")
    private Long flagExCtOutSize8;
    @Column(name = "flag_express_ct_in_size_9")
    private Long flagExCtInSize9;
    @Column(name = "flag_express_ct_out_size_9")
    private Long flagExCtOutSize9;
    @Column(name = "flag_express_ct_in_size_10")
    private Long flagExCtInSize10;
    @Column(name = "flag_express_ct_out_size_10")
    private Long flagExCtOutSize10;
    @Column(name = "flag_express_ct_in_size_11")
    private Long flagExCtInSize11;
    @Column(name = "flag_express_ct_out_size_11")
    private Long flagExCtOutSize11;
    @Column(name = "flag_express_ct_in_size_12")
    private Long flagExCtInSize12;
    @Column(name = "flag_express_ct_out_size_12")
    private Long flagExCtOutSize12;
    @Column(name = "flag_express_ct_in_size_13")
    private Long flagExCtInSize13;
    @Column(name = "flag_express_ct_out_size_13")
    private Long flagExCtOutSize13;
    @Column(name = "flag_express_ct_in_size_14")
    private Long flagExCtInSize14;
    @Column(name = "flag_express_ct_out_size_14")
    private Long flagExCtOutSize14;
    @Column(name = "flag_express_ct_in_size_15")
    private Long flagExCtInSize15;
    @Column(name = "flag_express_ct_out_size_15")
    private Long flagExCtOutSize15;
    @Column(name = "flag_express_ct_in_size_16")
    private Long flagExCtInSize16;
    @Column(name = "flag_express_ct_out_size_16")
    private Long flagExCtOutSize16;
    @Column(name = "flag_express_ct_in_size_17")
    private Long flagExCtInSize17;
    @Column(name = "flag_express_ct_out_size_17")
    private Long flagExCtOutSize17;
    @Column(name = "flag_express_ct_in_size_18")
    private Long flagExCtInSize18;
    @Column(name = "flag_express_ct_out_size_18")
    private Long flagExCtOutSize18;
    @Column(name = "flag_express_ct_in_size_1_t")
    private Long flagExCtInSize1T;
    @Column(name = "flag_express_ct_out_size_1_t")
    private Long flagExCtOutSize1T;
    @Column(name = "flag_express_ct_in_size_2_t")
    private Long flagExCtInSize2T;
    @Column(name = "flag_express_ct_out_size_2_t")
    private Long flagExCtOutSize2T;
    @Column(name = "flag_express_ct_in_size_3_t")
    private Long flagExCtInSize3T;
    @Column(name = "flag_express_ct_out_size_3_t")
    private Long flagExCtOutSize3T;
    @Column(name = "flag_express_ct_in_size_4_t")
    private Long flagExCtInSize4T;
    @Column(name = "flag_express_ct_out_size_4_t")
    private Long flagExCtOutSize4T;
    @Column(name = "flag_express_ct_in_size_5_t")
    private Long flagExCtInSize5T;
    @Column(name = "flag_express_ct_out_size_5_t")
    private Long flagExCtOutSize5T;
    @Column(name = "flag_express_ct_in_size_6_t")
    private Long flagExCtInSize6T;
    @Column(name = "flag_express_ct_out_size_6_t")
    private Long flagExCtOutSize6T;
    @Column(name = "flag_express_ct_in_size_7_t")
    private Long flagExCtInSize7T;
    @Column(name = "flag_express_ct_out_size_7_t")
    private Long flagExCtOutSize7T;
    @Column(name = "flag_express_ct_in_size_8_t")
    private Long flagExCtInSize8T;
    @Column(name = "flag_express_ct_out_size_8_t")
    private Long flagExCtOutSize8T;
    @Column(name = "flag_express_ct_in_size_9_t")
    private Long flagExCtInSize9T;
    @Column(name = "flag_express_ct_out_size_9_t")
    private Long flagExCtOutSize9T;
    @Column(name = "flag_express_ct_in_size_10_t")
    private Long flagExCtInSize10T;
    @Column(name = "flag_express_ct_out_size_10_t")
    private Long flagExCtOutSize10T;
    @Column(name = "flag_express_ct_in_size_11_t")
    private Long flagExCtInSize11T;
    @Column(name = "flag_express_ct_out_size_11_t")
    private Long flagExCtOutSize11T;
    @Column(name = "flag_express_ct_in_size_12_t")
    private Long flagExCtInSize12T;
    @Column(name = "flag_express_ct_out_size_12_t")
    private Long flagExCtOutSize12T;
    @Column(name = "flag_express_ct_in_size_13_t")
    private Long flagExCtInSize13T;
    @Column(name = "flag_express_ct_out_size_13_t")
    private Long flagExCtOutSize13T;
    
        @Column(name = "flag_express_prep_in_size_1")
    private Long flagExPrepInSize1;
    @Column(name = "flag_express_prep_out_size_1")
    private Long flagExPrepOutSize1;
    @Column(name = "flag_express_prep_in_size_2")
    private Long flagExPrepInSize2;
    @Column(name = "flag_express_prep_out_size_2")
    private Long flagExPrepOutSize2;
    @Column(name = "flag_express_prep_in_size_3")
    private Long flagExPrepInSize3;
    @Column(name = "flag_express_prep_out_size_3")
    private Long flagExPrepOutSize3;
    @Column(name = "flag_express_prep_in_size_4")
    private Long flagExPrepInSize4;
    @Column(name = "flag_express_prep_out_size_4")
    private Long flagExPrepOutSize4;
    @Column(name = "flag_express_prep_in_size_5")
    private Long flagExPrepInSize5;
    @Column(name = "flag_express_prep_out_size_5")
    private Long flagExPrepOutSize5;
    @Column(name = "flag_express_prep_in_size_6")
    private Long flagExPrepInSize6;
    @Column(name = "flag_express_prep_out_size_6")
    private Long flagExPrepOutSize6;
    @Column(name = "flag_express_prep_in_size_7")
    private Long flagExPrepInSize7;
    @Column(name = "flag_express_prep_out_size_7")
    private Long flagExPrepOutSize7;
    @Column(name = "flag_express_prep_in_size_8")
    private Long flagExPrepInSize8;
    @Column(name = "flag_express_prep_out_size_8")
    private Long flagExPrepOutSize8;
    @Column(name = "flag_express_prep_in_size_9")
    private Long flagExPrepInSize9;
    @Column(name = "flag_express_prep_out_size_9")
    private Long flagExPrepOutSize9;
    @Column(name = "flag_express_prep_in_size_10")
    private Long flagExPrepInSize10;
    @Column(name = "flag_express_prep_out_size_10")
    private Long flagExPrepOutSize10;
    @Column(name = "flag_express_prep_in_size_11")
    private Long flagExPrepInSize11;
    @Column(name = "flag_express_prep_out_size_11")
    private Long flagExPrepOutSize11;
    @Column(name = "flag_express_prep_in_size_12")
    private Long flagExPrepInSize12;
    @Column(name = "flag_express_prep_out_size_12")
    private Long flagExPrepOutSize12;
    @Column(name = "flag_express_prep_in_size_13")
    private Long flagExPrepInSize13;
    @Column(name = "flag_express_prep_out_size_13")
    private Long flagExPrepOutSize13;
    @Column(name = "flag_express_prep_in_size_14")
    private Long flagExPrepInSize14;
    @Column(name = "flag_express_prep_out_size_14")
    private Long flagExPrepOutSize14;
    @Column(name = "flag_express_prep_in_size_15")
    private Long flagExPrepInSize15;
    @Column(name = "flag_express_prep_out_size_15")
    private Long flagExPrepOutSize15;
    @Column(name = "flag_express_prep_in_size_16")
    private Long flagExPrepInSize16;
    @Column(name = "flag_express_prep_out_size_16")
    private Long flagExPrepOutSize16;
    @Column(name = "flag_express_prep_in_size_17")
    private Long flagExPrepInSize17;
    @Column(name = "flag_express_prep_out_size_17")
    private Long flagExPrepOutSize17;
    @Column(name = "flag_express_prep_in_size_18")
    private Long flagExPrepInSize18;
    @Column(name = "flag_express_prep_out_size_18")
    private Long flagExPrepOutSize18;
    @Column(name = "flag_express_prep_in_size_1_t")
    private Long flagExPrepInSize1T;
    @Column(name = "flag_express_prep_out_size_1_t")
    private Long flagExPrepOutSize1T;
    @Column(name = "flag_express_prep_in_size_2_t")
    private Long flagExPrepInSize2T;
    @Column(name = "flag_express_prep_out_size_2_t")
    private Long flagExPrepOutSize2T;
    @Column(name = "flag_express_prep_in_size_3_t")
    private Long flagExPrepInSize3T;
    @Column(name = "flag_express_prep_out_size_3_t")
    private Long flagExPrepOutSize3T;
    @Column(name = "flag_express_prep_in_size_4_t")
    private Long flagExPrepInSize4T;
    @Column(name = "flag_express_prep_out_size_4_t")
    private Long flagExPrepOutSize4T;
    @Column(name = "flag_express_prep_in_size_5_t")
    private Long flagExPrepInSize5T;
    @Column(name = "flag_express_prep_out_size_5_t")
    private Long flagExPrepOutSize5T;
    @Column(name = "flag_express_prep_in_size_6_t")
    private Long flagExPrepInSize6T;
    @Column(name = "flag_express_prep_out_size_6_t")
    private Long flagExPrepOutSize6T;
    @Column(name = "flag_express_prep_in_size_7_t")
    private Long flagExPrepInSize7T;
    @Column(name = "flag_express_prep_out_size_7_t")
    private Long flagExPrepOutSize7T;
    @Column(name = "flag_express_prep_in_size_8_t")
    private Long flagExPrepInSize8T;
    @Column(name = "flag_express_prep_out_size_8_t")
    private Long flagExPrepOutSize8T;
    @Column(name = "flag_express_prep_in_size_9_t")
    private Long flagExPrepInSize9T;
    @Column(name = "flag_express_prep_out_size_9_t")
    private Long flagExPrepOutSize9T;
    @Column(name = "flag_express_prep_in_size_10_t")
    private Long flagExPrepInSize10T;
    @Column(name = "flag_express_prep_out_size_10_t")
    private Long flagExPrepOutSize10T;
    @Column(name = "flag_express_prep_in_size_11_t")
    private Long flagExPrepInSize11T;
    @Column(name = "flag_express_prep_out_size_11_t")
    private Long flagExPrepOutSize11T;
    @Column(name = "flag_express_prep_in_size_12_t")
    private Long flagExPrepInSize12T;
    @Column(name = "flag_express_prep_out_size_12_t")
    private Long flagExPrepOutSize12T;
    @Column(name = "flag_express_prep_in_size_13_t")
    private Long flagExPrepInSize13T;
    @Column(name = "flag_express_prep_out_size_13_t")
    private Long flagExPrepOutSize13T;
    
        @Column(name = "flag_express_st_in_size_1")
    private Long flagExStInSize1;
    @Column(name = "flag_express_st_out_size_1")
    private Long flagExStOutSize1;
    @Column(name = "flag_express_st_in_size_2")
    private Long flagExStInSize2;
    @Column(name = "flag_express_st_out_size_2")
    private Long flagExStOutSize2;
    @Column(name = "flag_express_st_in_size_3")
    private Long flagExStInSize3;
    @Column(name = "flag_express_st_out_size_3")
    private Long flagExStOutSize3;
    @Column(name = "flag_express_st_in_size_4")
    private Long flagExStInSize4;
    @Column(name = "flag_express_st_out_size_4")
    private Long flagExStOutSize4;
    @Column(name = "flag_express_st_in_size_5")
    private Long flagExStInSize5;
    @Column(name = "flag_express_st_out_size_5")
    private Long flagExStOutSize5;
    @Column(name = "flag_express_st_in_size_6")
    private Long flagExStInSize6;
    @Column(name = "flag_express_st_out_size_6")
    private Long flagExStOutSize6;
    @Column(name = "flag_express_st_in_size_7")
    private Long flagExStInSize7;
    @Column(name = "flag_express_st_out_size_7")
    private Long flagExStOutSize7;
    @Column(name = "flag_express_st_in_size_8")
    private Long flagExStInSize8;
    @Column(name = "flag_express_st_out_size_8")
    private Long flagExStOutSize8;
    @Column(name = "flag_express_st_in_size_9")
    private Long flagExStInSize9;
    @Column(name = "flag_express_st_out_size_9")
    private Long flagExStOutSize9;
    @Column(name = "flag_express_st_in_size_10")
    private Long flagExStInSize10;
    @Column(name = "flag_express_st_out_size_10")
    private Long flagExStOutSize10;
    @Column(name = "flag_express_st_in_size_11")
    private Long flagExStInSize11;
    @Column(name = "flag_express_st_out_size_11")
    private Long flagExStOutSize11;
    @Column(name = "flag_express_st_in_size_12")
    private Long flagExStInSize12;
    @Column(name = "flag_express_st_out_size_12")
    private Long flagExStOutSize12;
    @Column(name = "flag_express_st_in_size_13")
    private Long flagExStInSize13;
    @Column(name = "flag_express_st_out_size_13")
    private Long flagExStOutSize13;
    @Column(name = "flag_express_st_in_size_14")
    private Long flagExStInSize14;
    @Column(name = "flag_express_st_out_size_14")
    private Long flagExStOutSize14;
    @Column(name = "flag_express_st_in_size_15")
    private Long flagExStInSize15;
    @Column(name = "flag_express_st_out_size_15")
    private Long flagExStOutSize15;
    @Column(name = "flag_express_st_in_size_16")
    private Long flagExStInSize16;
    @Column(name = "flag_express_st_out_size_16")
    private Long flagExStOutSize16;
    @Column(name = "flag_express_st_in_size_17")
    private Long flagExStInSize17;
    @Column(name = "flag_express_st_out_size_17")
    private Long flagExStOutSize17;
    @Column(name = "flag_express_st_in_size_18")
    private Long flagExStInSize18;
    @Column(name = "flag_express_st_out_size_18")
    private Long flagExStOutSize18;
    @Column(name = "flag_express_st_in_size_1_t")
    private Long flagExStInSize1T;
    @Column(name = "flag_express_st_out_size_1_t")
    private Long flagExStOutSize1T;
    @Column(name = "flag_express_st_in_size_2_t")
    private Long flagExStInSize2T;
    @Column(name = "flag_express_st_out_size_2_t")
    private Long flagExStOutSize2T;
    @Column(name = "flag_express_st_in_size_3_t")
    private Long flagExStInSize3T;
    @Column(name = "flag_express_st_out_size_3_t")
    private Long flagExStOutSize3T;
    @Column(name = "flag_express_st_in_size_4_t")
    private Long flagExStInSize4T;
    @Column(name = "flag_express_st_out_size_4_t")
    private Long flagExStOutSize4T;
    @Column(name = "flag_express_st_in_size_5_t")
    private Long flagExStInSize5T;
    @Column(name = "flag_express_st_out_size_5_t")
    private Long flagExStOutSize5T;
    @Column(name = "flag_express_st_in_size_6_t")
    private Long flagExStInSize6T;
    @Column(name = "flag_express_st_out_size_6_t")
    private Long flagExStOutSize6T;
    @Column(name = "flag_express_st_in_size_7_t")
    private Long flagExStInSize7T;
    @Column(name = "flag_express_st_out_size_7_t")
    private Long flagExStOutSize7T;
    @Column(name = "flag_express_st_in_size_8_t")
    private Long flagExStInSize8T;
    @Column(name = "flag_express_st_out_size_8_t")
    private Long flagExStOutSize8T;
    @Column(name = "flag_express_st_in_size_9_t")
    private Long flagExStInSize9T;
    @Column(name = "flag_express_st_out_size_9_t")
    private Long flagExStOutSize9T;
    @Column(name = "flag_express_st_in_size_10_t")
    private Long flagExStInSize10T;
    @Column(name = "flag_express_st_out_size_10_t")
    private Long flagExStOutSize10T;
    @Column(name = "flag_express_st_in_size_11_t")
    private Long flagExStInSize11T;
    @Column(name = "flag_express_st_out_size_11_t")
    private Long flagExStOutSize11T;
    @Column(name = "flag_express_st_in_size_12_t")
    private Long flagExStInSize12T;
    @Column(name = "flag_express_st_out_size_12_t")
    private Long flagExStOutSize12T;
    @Column(name = "flag_express_st_in_size_13_t")
    private Long flagExStInSize13T;
    @Column(name = "flag_express_st_out_size_13_t")
    private Long flagExStOutSize13T;
    
        @Column(name = "flag_express_as_in_size_1")
    private Long flagExAsInSize1;
    @Column(name = "flag_express_as_out_size_1")
    private Long flagExAsOutSize1;
    @Column(name = "flag_express_as_in_size_2")
    private Long flagExAsInSize2;
    @Column(name = "flag_express_as_out_size_2")
    private Long flagExAsOutSize2;
    @Column(name = "flag_express_as_in_size_3")
    private Long flagExAsInSize3;
    @Column(name = "flag_express_as_out_size_3")
    private Long flagExAsOutSize3;
    @Column(name = "flag_express_as_in_size_4")
    private Long flagExAsInSize4;
    @Column(name = "flag_express_as_out_size_4")
    private Long flagExAsOutSize4;
    @Column(name = "flag_express_as_in_size_5")
    private Long flagExAsInSize5;
    @Column(name = "flag_express_as_out_size_5")
    private Long flagExAsOutSize5;
    @Column(name = "flag_express_as_in_size_6")
    private Long flagExAsInSize6;
    @Column(name = "flag_express_as_out_size_6")
    private Long flagExAsOutSize6;
    @Column(name = "flag_express_as_in_size_7")
    private Long flagExAsInSize7;
    @Column(name = "flag_express_as_out_size_7")
    private Long flagExAsOutSize7;
    @Column(name = "flag_express_as_in_size_8")
    private Long flagExAsInSize8;
    @Column(name = "flag_express_as_out_size_8")
    private Long flagExAsOutSize8;
    @Column(name = "flag_express_as_in_size_9")
    private Long flagExAsInSize9;
    @Column(name = "flag_express_as_out_size_9")
    private Long flagExAsOutSize9;
    @Column(name = "flag_express_as_in_size_10")
    private Long flagExAsInSize10;
    @Column(name = "flag_express_as_out_size_10")
    private Long flagExAsOutSize10;
    @Column(name = "flag_express_as_in_size_11")
    private Long flagExAsInSize11;
    @Column(name = "flag_express_as_out_size_11")
    private Long flagExAsOutSize11;
    @Column(name = "flag_express_as_in_size_12")
    private Long flagExAsInSize12;
    @Column(name = "flag_express_as_out_size_12")
    private Long flagExAsOutSize12;
    @Column(name = "flag_express_as_in_size_13")
    private Long flagExAsInSize13;
    @Column(name = "flag_express_as_out_size_13")
    private Long flagExAsOutSize13;
    @Column(name = "flag_express_as_in_size_14")
    private Long flagExAsInSize14;
    @Column(name = "flag_express_as_out_size_14")
    private Long flagExAsOutSize14;
    @Column(name = "flag_express_as_in_size_15")
    private Long flagExAsInSize15;
    @Column(name = "flag_express_as_out_size_15")
    private Long flagExAsOutSize15;
    @Column(name = "flag_express_as_in_size_16")
    private Long flagExAsInSize16;
    @Column(name = "flag_express_as_out_size_16")
    private Long flagExAsOutSize16;
    @Column(name = "flag_express_as_in_size_17")
    private Long flagExAsInSize17;
    @Column(name = "flag_express_as_out_size_17")
    private Long flagExAsOutSize17;
    @Column(name = "flag_express_as_in_size_18")
    private Long flagExAsInSize18;
    @Column(name = "flag_express_as_out_size_18")
    private Long flagExAsOutSize18;
    @Column(name = "flag_express_as_in_size_1_t")
    private Long flagExAsInSize1T;
    @Column(name = "flag_express_as_out_size_1_t")
    private Long flagExAsOutSize1T;
    @Column(name = "flag_express_as_in_size_2_t")
    private Long flagExAsInSize2T;
    @Column(name = "flag_express_as_out_size_2_t")
    private Long flagExAsOutSize2T;
    @Column(name = "flag_express_as_in_size_3_t")
    private Long flagExAsInSize3T;
    @Column(name = "flag_express_as_out_size_3_t")
    private Long flagExAsOutSize3T;
    @Column(name = "flag_express_as_in_size_4_t")
    private Long flagExAsInSize4T;
    @Column(name = "flag_express_as_out_size_4_t")
    private Long flagExAsOutSize4T;
    @Column(name = "flag_express_as_in_size_5_t")
    private Long flagExAsInSize5T;
    @Column(name = "flag_express_as_out_size_5_t")
    private Long flagExAsOutSize5T;
    @Column(name = "flag_express_as_in_size_6_t")
    private Long flagExAsInSize6T;
    @Column(name = "flag_express_as_out_size_6_t")
    private Long flagExAsOutSize6T;
    @Column(name = "flag_express_as_in_size_7_t")
    private Long flagExAsInSize7T;
    @Column(name = "flag_express_as_out_size_7_t")
    private Long flagExAsOutSize7T;
    @Column(name = "flag_express_as_in_size_8_t")
    private Long flagExAsInSize8T;
    @Column(name = "flag_express_as_out_size_8_t")
    private Long flagExAsOutSize8T;
    @Column(name = "flag_express_as_in_size_9_t")
    private Long flagExAsInSize9T;
    @Column(name = "flag_express_as_out_size_9_t")
    private Long flagExAsOutSize9T;
    @Column(name = "flag_express_as_in_size_10_t")
    private Long flagExAsInSize10T;
    @Column(name = "flag_express_as_out_size_10_t")
    private Long flagExAsOutSize10T;
    @Column(name = "flag_express_as_in_size_11_t")
    private Long flagExAsInSize11T;
    @Column(name = "flag_express_as_out_size_11_t")
    private Long flagExAsOutSize11T;
    @Column(name = "flag_express_as_in_size_12_t")
    private Long flagExAsInSize12T;
    @Column(name = "flag_express_as_out_size_12_t")
    private Long flagExAsOutSize12T;
    @Column(name = "flag_express_as_in_size_13_t")
    private Long flagExAsInSize13T;
    @Column(name = "flag_express_as_out_size_13_t")
    private Long flagExAsOutSize13T;
    
        @Column(name = "flag_express_csc_in_size_1")
    private Long flagExCscInSize1;
    @Column(name = "flag_express_csc_out_size_1")
    private Long flagExCscOutSize1;
    @Column(name = "flag_express_csc_in_size_2")
    private Long flagExCscInSize2;
    @Column(name = "flag_express_csc_out_size_2")
    private Long flagExCscOutSize2;
    @Column(name = "flag_express_csc_in_size_3")
    private Long flagExCscInSize3;
    @Column(name = "flag_express_csc_out_size_3")
    private Long flagExCscOutSize3;
    @Column(name = "flag_express_csc_in_size_4")
    private Long flagExCscInSize4;
    @Column(name = "flag_express_csc_out_size_4")
    private Long flagExCscOutSize4;
    @Column(name = "flag_express_csc_in_size_5")
    private Long flagExCscInSize5;
    @Column(name = "flag_express_csc_out_size_5")
    private Long flagExCscOutSize5;
    @Column(name = "flag_express_csc_in_size_6")
    private Long flagExCscInSize6;
    @Column(name = "flag_express_csc_out_size_6")
    private Long flagExCscOutSize6;
    @Column(name = "flag_express_csc_in_size_7")
    private Long flagExCscInSize7;
    @Column(name = "flag_express_csc_out_size_7")
    private Long flagExCscOutSize7;
    @Column(name = "flag_express_csc_in_size_8")
    private Long flagExCscInSize8;
    @Column(name = "flag_express_csc_out_size_8")
    private Long flagExCscOutSize8;
    @Column(name = "flag_express_csc_in_size_9")
    private Long flagExCscInSize9;
    @Column(name = "flag_express_csc_out_size_9")
    private Long flagExCscOutSize9;
    @Column(name = "flag_express_csc_in_size_10")
    private Long flagExCscInSize10;
    @Column(name = "flag_express_csc_out_size_10")
    private Long flagExCscOutSize10;
    @Column(name = "flag_express_csc_in_size_11")
    private Long flagExCscInSize11;
    @Column(name = "flag_express_csc_out_size_11")
    private Long flagExCscOutSize11;
    @Column(name = "flag_express_csc_in_size_12")
    private Long flagExCscInSize12;
    @Column(name = "flag_express_csc_out_size_12")
    private Long flagExCscOutSize12;
    @Column(name = "flag_express_csc_in_size_13")
    private Long flagExCscInSize13;
    @Column(name = "flag_express_csc_out_size_13")
    private Long flagExCscOutSize13;
    @Column(name = "flag_express_csc_in_size_14")
    private Long flagExCscInSize14;
    @Column(name = "flag_express_csc_out_size_14")
    private Long flagExCscOutSize14;
    @Column(name = "flag_express_csc_in_size_15")
    private Long flagExCscInSize15;
    @Column(name = "flag_express_csc_out_size_15")
    private Long flagExCscOutSize15;
    @Column(name = "flag_express_csc_in_size_16")
    private Long flagExCscInSize16;
    @Column(name = "flag_express_csc_out_size_16")
    private Long flagExCscOutSize16;
    @Column(name = "flag_express_csc_in_size_17")
    private Long flagExCscInSize17;
    @Column(name = "flag_express_csc_out_size_17")
    private Long flagExCscOutSize17;
    @Column(name = "flag_express_csc_in_size_18")
    private Long flagExCscInSize18;
    @Column(name = "flag_express_csc_out_size_18")
    private Long flagExCscOutSize18;
    @Column(name = "flag_express_csc_in_size_1_t")
    private Long flagExCscInSize1T;
    @Column(name = "flag_express_csc_out_size_1_t")
    private Long flagExCscOutSize1T;
    @Column(name = "flag_express_csc_in_size_2_t")
    private Long flagExCscInSize2T;
    @Column(name = "flag_express_csc_out_size_2_t")
    private Long flagExCscOutSize2T;
    @Column(name = "flag_express_csc_in_size_3_t")
    private Long flagExCscInSize3T;
    @Column(name = "flag_express_csc_out_size_3_t")
    private Long flagExCscOutSize3T;
    @Column(name = "flag_express_csc_in_size_4_t")
    private Long flagExCscInSize4T;
    @Column(name = "flag_express_csc_out_size_4_t")
    private Long flagExCscOutSize4T;
    @Column(name = "flag_express_csc_in_size_5_t")
    private Long flagExCscInSize5T;
    @Column(name = "flag_express_csc_out_size_5_t")
    private Long flagExCscOutSize5T;
    @Column(name = "flag_express_csc_in_size_6_t")
    private Long flagExCscInSize6T;
    @Column(name = "flag_express_csc_out_size_6_t")
    private Long flagExCscOutSize6T;
    @Column(name = "flag_express_csc_in_size_7_t")
    private Long flagExCscInSize7T;
    @Column(name = "flag_express_csc_out_size_7_t")
    private Long flagExCscOutSize7T;
    @Column(name = "flag_express_csc_in_size_8_t")
    private Long flagExCscInSize8T;
    @Column(name = "flag_express_csc_out_size_8_t")
    private Long flagExCscOutSize8T;
    @Column(name = "flag_express_csc_in_size_9_t")
    private Long flagExCscInSize9T;
    @Column(name = "flag_express_csc_out_size_9_t")
    private Long flagExCscOutSize9T;
    @Column(name = "flag_express_csc_in_size_10_t")
    private Long flagExCscInSize10T;
    @Column(name = "flag_express_csc_out_size_10_t")
    private Long flagExCscOutSize10T;
    @Column(name = "flag_express_csc_in_size_11_t")
    private Long flagExCscInSize11T;
    @Column(name = "flag_express_csc_out_size_11_t")
    private Long flagExCscOutSize11T;
    @Column(name = "flag_express_csc_in_size_12_t")
    private Long flagExCscInSize12T;
    @Column(name = "flag_express_csc_out_size_12_t")
    private Long flagExCscOutSize12T;
    @Column(name = "flag_express_csc_in_size_13_t")
    private Long flagExCscInSize13T;
    @Column(name = "flag_express_csc_out_size_13_t")
    private Long flagExCscOutSize13T;
    
        @Column(name = "flag_express_ns_in_size_1")
    private Long flagExNsInSize1;
    @Column(name = "flag_express_ns_out_size_1")
    private Long flagExNsOutSize1;
    @Column(name = "flag_express_ns_in_size_2")
    private Long flagExNsInSize2;
    @Column(name = "flag_express_ns_out_size_2")
    private Long flagExNsOutSize2;
    @Column(name = "flag_express_ns_in_size_3")
    private Long flagExNsInSize3;
    @Column(name = "flag_express_ns_out_size_3")
    private Long flagExNsOutSize3;
    @Column(name = "flag_express_ns_in_size_4")
    private Long flagExNsInSize4;
    @Column(name = "flag_express_ns_out_size_4")
    private Long flagExNsOutSize4;
    @Column(name = "flag_express_ns_in_size_5")
    private Long flagExNsInSize5;
    @Column(name = "flag_express_ns_out_size_5")
    private Long flagExNsOutSize5;
    @Column(name = "flag_express_ns_in_size_6")
    private Long flagExNsInSize6;
    @Column(name = "flag_express_ns_out_size_6")
    private Long flagExNsOutSize6;
    @Column(name = "flag_express_ns_in_size_7")
    private Long flagExNsInSize7;
    @Column(name = "flag_express_ns_out_size_7")
    private Long flagExNsOutSize7;
    @Column(name = "flag_express_ns_in_size_8")
    private Long flagExNsInSize8;
    @Column(name = "flag_express_ns_out_size_8")
    private Long flagExNsOutSize8;
    @Column(name = "flag_express_ns_in_size_9")
    private Long flagExNsInSize9;
    @Column(name = "flag_express_ns_out_size_9")
    private Long flagExNsOutSize9;
    @Column(name = "flag_express_ns_in_size_10")
    private Long flagExNsInSize10;
    @Column(name = "flag_express_ns_out_size_10")
    private Long flagExNsOutSize10;
    @Column(name = "flag_express_ns_in_size_11")
    private Long flagExNsInSize11;
    @Column(name = "flag_express_ns_out_size_11")
    private Long flagExNsOutSize11;
    @Column(name = "flag_express_ns_in_size_12")
    private Long flagExNsInSize12;
    @Column(name = "flag_express_ns_out_size_12")
    private Long flagExNsOutSize12;
    @Column(name = "flag_express_ns_in_size_13")
    private Long flagExNsInSize13;
    @Column(name = "flag_express_ns_out_size_13")
    private Long flagExNsOutSize13;
    @Column(name = "flag_express_ns_in_size_14")
    private Long flagExNsInSize14;
    @Column(name = "flag_express_ns_out_size_14")
    private Long flagExNsOutSize14;
    @Column(name = "flag_express_ns_in_size_15")
    private Long flagExNsInSize15;
    @Column(name = "flag_express_ns_out_size_15")
    private Long flagExNsOutSize15;
    @Column(name = "flag_express_ns_in_size_16")
    private Long flagExNsInSize16;
    @Column(name = "flag_express_ns_out_size_16")
    private Long flagExNsOutSize16;
    @Column(name = "flag_express_ns_in_size_17")
    private Long flagExNsInSize17;
    @Column(name = "flag_express_ns_out_size_17")
    private Long flagExNsOutSize17;
    @Column(name = "flag_express_ns_in_size_18")
    private Long flagExNsInSize18;
    @Column(name = "flag_express_ns_out_size_18")
    private Long flagExNsOutSize18;
    @Column(name = "flag_express_ns_in_size_1_t")
    private Long flagExNsInSize1T;
    @Column(name = "flag_express_ns_out_size_1_t")
    private Long flagExNsOutSize1T;
    @Column(name = "flag_express_ns_in_size_2_t")
    private Long flagExNsInSize2T;
    @Column(name = "flag_express_ns_out_size_2_t")
    private Long flagExNsOutSize2T;
    @Column(name = "flag_express_ns_in_size_3_t")
    private Long flagExNsInSize3T;
    @Column(name = "flag_express_ns_out_size_3_t")
    private Long flagExNsOutSize3T;
    @Column(name = "flag_express_ns_in_size_4_t")
    private Long flagExNsInSize4T;
    @Column(name = "flag_express_ns_out_size_4_t")
    private Long flagExNsOutSize4T;
    @Column(name = "flag_express_ns_in_size_5_t")
    private Long flagExNsInSize5T;
    @Column(name = "flag_express_ns_out_size_5_t")
    private Long flagExNsOutSize5T;
    @Column(name = "flag_express_ns_in_size_6_t")
    private Long flagExNsInSize6T;
    @Column(name = "flag_express_ns_out_size_6_t")
    private Long flagExNsOutSize6T;
    @Column(name = "flag_express_ns_in_size_7_t")
    private Long flagExNsInSize7T;
    @Column(name = "flag_express_ns_out_size_7_t")
    private Long flagExNsOutSize7T;
    @Column(name = "flag_express_ns_in_size_8_t")
    private Long flagExNsInSize8T;
    @Column(name = "flag_express_ns_out_size_8_t")
    private Long flagExNsOutSize8T;
    @Column(name = "flag_express_ns_in_size_9_t")
    private Long flagExNsInSize9T;
    @Column(name = "flag_express_ns_out_size_9_t")
    private Long flagExNsOutSize9T;
    @Column(name = "flag_express_ns_in_size_10_t")
    private Long flagExNsInSize10T;
    @Column(name = "flag_express_ns_out_size_10_t")
    private Long flagExNsOutSize10T;
    @Column(name = "flag_express_ns_in_size_11_t")
    private Long flagExNsInSize11T;
    @Column(name = "flag_express_ns_out_size_11_t")
    private Long flagExNsOutSize11T;
    @Column(name = "flag_express_ns_in_size_12_t")
    private Long flagExNsInSize12T;
    @Column(name = "flag_express_ns_out_size_12_t")
    private Long flagExNsOutSize12T;
    @Column(name = "flag_express_ns_in_size_13_t")
    private Long flagExNsInSize13T;
    @Column(name = "flag_express_ns_out_size_13_t")
    private Long flagExNsOutSize13T;
    
        @Column(name = "flag_express_sc_in_size_1")
    private Long flagExScInSize1;
    @Column(name = "flag_express_sc_out_size_1")
    private Long flagExScOutSize1;
    @Column(name = "flag_express_sc_in_size_2")
    private Long flagExScInSize2;
    @Column(name = "flag_express_sc_out_size_2")
    private Long flagExScOutSize2;
    @Column(name = "flag_express_sc_in_size_3")
    private Long flagExScInSize3;
    @Column(name = "flag_express_sc_out_size_3")
    private Long flagExScOutSize3;
    @Column(name = "flag_express_sc_in_size_4")
    private Long flagExScInSize4;
    @Column(name = "flag_express_sc_out_size_4")
    private Long flagExScOutSize4;
    @Column(name = "flag_express_sc_in_size_5")
    private Long flagExScInSize5;
    @Column(name = "flag_express_sc_out_size_5")
    private Long flagExScOutSize5;
    @Column(name = "flag_express_sc_in_size_6")
    private Long flagExScInSize6;
    @Column(name = "flag_express_sc_out_size_6")
    private Long flagExScOutSize6;
    @Column(name = "flag_express_sc_in_size_7")
    private Long flagExScInSize7;
    @Column(name = "flag_express_sc_out_size_7")
    private Long flagExScOutSize7;
    @Column(name = "flag_express_sc_in_size_8")
    private Long flagExScInSize8;
    @Column(name = "flag_express_sc_out_size_8")
    private Long flagExScOutSize8;
    @Column(name = "flag_express_sc_in_size_9")
    private Long flagExScInSize9;
    @Column(name = "flag_express_sc_out_size_9")
    private Long flagExScOutSize9;
    @Column(name = "flag_express_sc_in_size_10")
    private Long flagExScInSize10;
    @Column(name = "flag_express_sc_out_size_10")
    private Long flagExScOutSize10;
    @Column(name = "flag_express_sc_in_size_11")
    private Long flagExScInSize11;
    @Column(name = "flag_express_sc_out_size_11")
    private Long flagExScOutSize11;
    @Column(name = "flag_express_sc_in_size_12")
    private Long flagExScInSize12;
    @Column(name = "flag_express_sc_out_size_12")
    private Long flagExScOutSize12;
    @Column(name = "flag_express_sc_in_size_13")
    private Long flagExScInSize13;
    @Column(name = "flag_express_sc_out_size_13")
    private Long flagExScOutSize13;
    @Column(name = "flag_express_sc_in_size_14")
    private Long flagExScInSize14;
    @Column(name = "flag_express_sc_out_size_14")
    private Long flagExScOutSize14;
    @Column(name = "flag_express_sc_in_size_15")
    private Long flagExScInSize15;
    @Column(name = "flag_express_sc_out_size_15")
    private Long flagExScOutSize15;
    @Column(name = "flag_express_sc_in_size_16")
    private Long flagExScInSize16;
    @Column(name = "flag_express_sc_out_size_16")
    private Long flagExScOutSize16;
    @Column(name = "flag_express_sc_in_size_17")
    private Long flagExScInSize17;
    @Column(name = "flag_express_sc_out_size_17")
    private Long flagExScOutSize17;
    @Column(name = "flag_express_sc_in_size_18")
    private Long flagExScInSize18;
    @Column(name = "flag_express_sc_out_size_18")
    private Long flagExScOutSize18;
    @Column(name = "flag_express_sc_in_size_1_t")
    private Long flagExScInSize1T;
    @Column(name = "flag_express_sc_out_size_1_t")
    private Long flagExScOutSize1T;
    @Column(name = "flag_express_sc_in_size_2_t")
    private Long flagExScInSize2T;
    @Column(name = "flag_express_sc_out_size_2_t")
    private Long flagExScOutSize2T;
    @Column(name = "flag_express_sc_in_size_3_t")
    private Long flagExScInSize3T;
    @Column(name = "flag_express_sc_out_size_3_t")
    private Long flagExScOutSize3T;
    @Column(name = "flag_express_sc_in_size_4_t")
    private Long flagExScInSize4T;
    @Column(name = "flag_express_sc_out_size_4_t")
    private Long flagExScOutSize4T;
    @Column(name = "flag_express_sc_in_size_5_t")
    private Long flagExScInSize5T;
    @Column(name = "flag_express_sc_out_size_5_t")
    private Long flagExScOutSize5T;
    @Column(name = "flag_express_sc_in_size_6_t")
    private Long flagExScInSize6T;
    @Column(name = "flag_express_sc_out_size_6_t")
    private Long flagExScOutSize6T;
    @Column(name = "flag_express_sc_in_size_7_t")
    private Long flagExScInSize7T;
    @Column(name = "flag_express_sc_out_size_7_t")
    private Long flagExScOutSize7T;
    @Column(name = "flag_express_sc_in_size_8_t")
    private Long flagExScInSize8T;
    @Column(name = "flag_express_sc_out_size_8_t")
    private Long flagExScOutSize8T;
    @Column(name = "flag_express_sc_in_size_9_t")
    private Long flagExScInSize9T;
    @Column(name = "flag_express_sc_out_size_9_t")
    private Long flagExScOutSize9T;
    @Column(name = "flag_express_sc_in_size_10_t")
    private Long flagExScInSize10T;
    @Column(name = "flag_express_sc_out_size_10_t")
    private Long flagExScOutSize10T;
    @Column(name = "flag_express_sc_in_size_11_t")
    private Long flagExScInSize11T;
    @Column(name = "flag_express_sc_out_size_11_t")
    private Long flagExScOutSize11T;
    @Column(name = "flag_express_sc_in_size_12_t")
    private Long flagExScInSize12T;
    @Column(name = "flag_express_sc_out_size_12_t")
    private Long flagExScOutSize12T;
    @Column(name = "flag_express_sc_in_size_13_t")
    private Long flagExScInSize13T;
    @Column(name = "flag_express_sc_out_size_13_t")
    private Long flagExScOutSize13T;
    
        @Column(name = "flag_express_os_in_size_1")
    private Long flagExOsInSize1;
    @Column(name = "flag_express_os_out_size_1")
    private Long flagExOsOutSize1;
    @Column(name = "flag_express_os_in_size_2")
    private Long flagExOsInSize2;
    @Column(name = "flag_express_os_out_size_2")
    private Long flagExOsOutSize2;
    @Column(name = "flag_express_os_in_size_3")
    private Long flagExOsInSize3;
    @Column(name = "flag_express_os_out_size_3")
    private Long flagExOsOutSize3;
    @Column(name = "flag_express_os_in_size_4")
    private Long flagExOsInSize4;
    @Column(name = "flag_express_os_out_size_4")
    private Long flagExOsOutSize4;
    @Column(name = "flag_express_os_in_size_5")
    private Long flagExOsInSize5;
    @Column(name = "flag_express_os_out_size_5")
    private Long flagExOsOutSize5;
    @Column(name = "flag_express_os_in_size_6")
    private Long flagExOsInSize6;
    @Column(name = "flag_express_os_out_size_6")
    private Long flagExOsOutSize6;
    @Column(name = "flag_express_os_in_size_7")
    private Long flagExOsInSize7;
    @Column(name = "flag_express_os_out_size_7")
    private Long flagExOsOutSize7;
    @Column(name = "flag_express_os_in_size_8")
    private Long flagExOsInSize8;
    @Column(name = "flag_express_os_out_size_8")
    private Long flagExOsOutSize8;
    @Column(name = "flag_express_os_in_size_9")
    private Long flagExOsInSize9;
    @Column(name = "flag_express_os_out_size_9")
    private Long flagExOsOutSize9;
    @Column(name = "flag_express_os_in_size_10")
    private Long flagExOsInSize10;
    @Column(name = "flag_express_os_out_size_10")
    private Long flagExOsOutSize10;
    @Column(name = "flag_express_os_in_size_11")
    private Long flagExOsInSize11;
    @Column(name = "flag_express_os_out_size_11")
    private Long flagExOsOutSize11;
    @Column(name = "flag_express_os_in_size_12")
    private Long flagExOsInSize12;
    @Column(name = "flag_express_os_out_size_12")
    private Long flagExOsOutSize12;
    @Column(name = "flag_express_os_in_size_13")
    private Long flagExOsInSize13;
    @Column(name = "flag_express_os_out_size_13")
    private Long flagExOsOutSize13;
    @Column(name = "flag_express_os_in_size_14")
    private Long flagExOsInSize14;
    @Column(name = "flag_express_os_out_size_14")
    private Long flagExOsOutSize14;
    @Column(name = "flag_express_os_in_size_15")
    private Long flagExOsInSize15;
    @Column(name = "flag_express_os_out_size_15")
    private Long flagExOsOutSize15;
    @Column(name = "flag_express_os_in_size_16")
    private Long flagExOsInSize16;
    @Column(name = "flag_express_os_out_size_16")
    private Long flagExOsOutSize16;
    @Column(name = "flag_express_os_in_size_17")
    private Long flagExOsInSize17;
    @Column(name = "flag_express_os_out_size_17")
    private Long flagExOsOutSize17;
    @Column(name = "flag_express_os_in_size_18")
    private Long flagExOsInSize18;
    @Column(name = "flag_express_os_out_size_18")
    private Long flagExOsOutSize18;
    @Column(name = "flag_express_os_in_size_1_t")
    private Long flagExOsInSize1T;
    @Column(name = "flag_express_os_out_size_1_t")
    private Long flagExOsOutSize1T;
    @Column(name = "flag_express_os_in_size_2_t")
    private Long flagExOsInSize2T;
    @Column(name = "flag_express_os_out_size_2_t")
    private Long flagExOsOutSize2T;
    @Column(name = "flag_express_os_in_size_3_t")
    private Long flagExOsInSize3T;
    @Column(name = "flag_express_os_out_size_3_t")
    private Long flagExOsOutSize3T;
    @Column(name = "flag_express_os_in_size_4_t")
    private Long flagExOsInSize4T;
    @Column(name = "flag_express_os_out_size_4_t")
    private Long flagExOsOutSize4T;
    @Column(name = "flag_express_os_in_size_5_t")
    private Long flagExOsInSize5T;
    @Column(name = "flag_express_os_out_size_5_t")
    private Long flagExOsOutSize5T;
    @Column(name = "flag_express_os_in_size_6_t")
    private Long flagExOsInSize6T;
    @Column(name = "flag_express_os_out_size_6_t")
    private Long flagExOsOutSize6T;
    @Column(name = "flag_express_os_in_size_7_t")
    private Long flagExOsInSize7T;
    @Column(name = "flag_express_os_out_size_7_t")
    private Long flagExOsOutSize7T;
    @Column(name = "flag_express_os_in_size_8_t")
    private Long flagExOsInSize8T;
    @Column(name = "flag_express_os_out_size_8_t")
    private Long flagExOsOutSize8T;
    @Column(name = "flag_express_os_in_size_9_t")
    private Long flagExOsInSize9T;
    @Column(name = "flag_express_os_out_size_9_t")
    private Long flagExOsOutSize9T;
    @Column(name = "flag_express_os_in_size_10_t")
    private Long flagExOsInSize10T;
    @Column(name = "flag_express_os_out_size_10_t")
    private Long flagExOsOutSize10T;
    @Column(name = "flag_express_os_in_size_11_t")
    private Long flagExOsInSize11T;
    @Column(name = "flag_express_os_out_size_11_t")
    private Long flagExOsOutSize11T;
    @Column(name = "flag_express_os_in_size_12_t")
    private Long flagExOsInSize12T;
    @Column(name = "flag_express_os_out_size_12_t")
    private Long flagExOsOutSize12T;
    @Column(name = "flag_express_os_in_size_13_t")
    private Long flagExOsInSize13T;
    @Column(name = "flag_express_os_out_size_13_t")
    private Long flagExOsOutSize13T;
    
        @Column(name = "flag_express_spcut_in_size_1")
    private Long flagExSpcutInSize1;
    @Column(name = "flag_express_spcut_out_size_1")
    private Long flagExSpcutOutSize1;
    @Column(name = "flag_express_spcut_in_size_2")
    private Long flagExSpcutInSize2;
    @Column(name = "flag_express_spcut_out_size_2")
    private Long flagExSpcutOutSize2;
    @Column(name = "flag_express_spcut_in_size_3")
    private Long flagExSpcutInSize3;
    @Column(name = "flag_express_spcut_out_size_3")
    private Long flagExSpcutOutSize3;
    @Column(name = "flag_express_spcut_in_size_4")
    private Long flagExSpcutInSize4;
    @Column(name = "flag_express_spcut_out_size_4")
    private Long flagExSpcutOutSize4;
    @Column(name = "flag_express_spcut_in_size_5")
    private Long flagExSpcutInSize5;
    @Column(name = "flag_express_spcut_out_size_5")
    private Long flagExSpcutOutSize5;
    @Column(name = "flag_express_spcut_in_size_6")
    private Long flagExSpcutInSize6;
    @Column(name = "flag_express_spcut_out_size_6")
    private Long flagExSpcutOutSize6;
    @Column(name = "flag_express_spcut_in_size_7")
    private Long flagExSpcutInSize7;
    @Column(name = "flag_express_spcut_out_size_7")
    private Long flagExSpcutOutSize7;
    @Column(name = "flag_express_spcut_in_size_8")
    private Long flagExSpcutInSize8;
    @Column(name = "flag_express_spcut_out_size_8")
    private Long flagExSpcutOutSize8;
    @Column(name = "flag_express_spcut_in_size_9")
    private Long flagExSpcutInSize9;
    @Column(name = "flag_express_spcut_out_size_9")
    private Long flagExSpcutOutSize9;
    @Column(name = "flag_express_spcut_in_size_10")
    private Long flagExSpcutInSize10;
    @Column(name = "flag_express_spcut_out_size_10")
    private Long flagExSpcutOutSize10;
    @Column(name = "flag_express_spcut_in_size_11")
    private Long flagExSpcutInSize11;
    @Column(name = "flag_express_spcut_out_size_11")
    private Long flagExSpcutOutSize11;
    @Column(name = "flag_express_spcut_in_size_12")
    private Long flagExSpcutInSize12;
    @Column(name = "flag_express_spcut_out_size_12")
    private Long flagExSpcutOutSize12;
    @Column(name = "flag_express_spcut_in_size_13")
    private Long flagExSpcutInSize13;
    @Column(name = "flag_express_spcut_out_size_13")
    private Long flagExSpcutOutSize13;
    @Column(name = "flag_express_spcut_in_size_14")
    private Long flagExSpcutInSize14;
    @Column(name = "flag_express_spcut_out_size_14")
    private Long flagExSpcutOutSize14;
    @Column(name = "flag_express_spcut_in_size_15")
    private Long flagExSpcutInSize15;
    @Column(name = "flag_express_spcut_out_size_15")
    private Long flagExSpcutOutSize15;
    @Column(name = "flag_express_spcut_in_size_16")
    private Long flagExSpcutInSize16;
    @Column(name = "flag_express_spcut_out_size_16")
    private Long flagExSpcutOutSize16;
    @Column(name = "flag_express_spcut_in_size_17")
    private Long flagExSpcutInSize17;
    @Column(name = "flag_express_spcut_out_size_17")
    private Long flagExSpcutOutSize17;
    @Column(name = "flag_express_spcut_in_size_18")
    private Long flagExSpcutInSize18;
    @Column(name = "flag_express_spcut_out_size_18")
    private Long flagExSpcutOutSize18;
    @Column(name = "flag_express_spcut_in_size_1_t")
    private Long flagExSpcutInSize1T;
    @Column(name = "flag_express_spcut_out_size_1_t")
    private Long flagExSpcutOutSize1T;
    @Column(name = "flag_express_spcut_in_size_2_t")
    private Long flagExSpcutInSize2T;
    @Column(name = "flag_express_spcut_out_size_2_t")
    private Long flagExSpcutOutSize2T;
    @Column(name = "flag_express_spcut_in_size_3_t")
    private Long flagExSpcutInSize3T;
    @Column(name = "flag_express_spcut_out_size_3_t")
    private Long flagExSpcutOutSize3T;
    @Column(name = "flag_express_spcut_in_size_4_t")
    private Long flagExSpcutInSize4T;
    @Column(name = "flag_express_spcut_out_size_4_t")
    private Long flagExSpcutOutSize4T;
    @Column(name = "flag_express_spcut_in_size_5_t")
    private Long flagExSpcutInSize5T;
    @Column(name = "flag_express_spcut_out_size_5_t")
    private Long flagExSpcutOutSize5T;
    @Column(name = "flag_express_spcut_in_size_6_t")
    private Long flagExSpcutInSize6T;
    @Column(name = "flag_express_spcut_out_size_6_t")
    private Long flagExSpcutOutSize6T;
    @Column(name = "flag_express_spcut_in_size_7_t")
    private Long flagExSpcutInSize7T;
    @Column(name = "flag_express_spcut_out_size_7_t")
    private Long flagExSpcutOutSize7T;
    @Column(name = "flag_express_spcut_in_size_8_t")
    private Long flagExSpcutInSize8T;
    @Column(name = "flag_express_spcut_out_size_8_t")
    private Long flagExSpcutOutSize8T;
    @Column(name = "flag_express_spcut_in_size_9_t")
    private Long flagExSpcutInSize9T;
    @Column(name = "flag_express_spcut_out_size_9_t")
    private Long flagExSpcutOutSize9T;
    @Column(name = "flag_express_spcut_in_size_10_t")
    private Long flagExSpcutInSize10T;
    @Column(name = "flag_express_spcut_out_size_10_t")
    private Long flagExSpcutOutSize10T;
    @Column(name = "flag_express_spcut_in_size_11_t")
    private Long flagExSpcutInSize11T;
    @Column(name = "flag_express_spcut_out_size_11_t")
    private Long flagExSpcutOutSize11T;
    @Column(name = "flag_express_spcut_in_size_12_t")
    private Long flagExSpcutInSize12T;
    @Column(name = "flag_express_spcut_out_size_12_t")
    private Long flagExSpcutOutSize12T;
    @Column(name = "flag_express_spcut_in_size_13_t")
    private Long flagExSpcutInSize13T;
    @Column(name = "flag_express_spcut_out_size_13_t")
    private Long flagExSpcutOutSize13T;
    
        @Column(name = "flag_express_spprep_in_size_1")
    private Long flagExSpprepInSize1;
    @Column(name = "flag_express_spprep_out_size_1")
    private Long flagExSpprepOutSize1;
    @Column(name = "flag_express_spprep_in_size_2")
    private Long flagExSpprepInSize2;
    @Column(name = "flag_express_spprep_out_size_2")
    private Long flagExSpprepOutSize2;
    @Column(name = "flag_express_spprep_in_size_3")
    private Long flagExSpprepInSize3;
    @Column(name = "flag_express_spprep_out_size_3")
    private Long flagExSpprepOutSize3;
    @Column(name = "flag_express_spprep_in_size_4")
    private Long flagExSpprepInSize4;
    @Column(name = "flag_express_spprep_out_size_4")
    private Long flagExSpprepOutSize4;
    @Column(name = "flag_express_spprep_in_size_5")
    private Long flagExSpprepInSize5;
    @Column(name = "flag_express_spprep_out_size_5")
    private Long flagExSpprepOutSize5;
    @Column(name = "flag_express_spprep_in_size_6")
    private Long flagExSpprepInSize6;
    @Column(name = "flag_express_spprep_out_size_6")
    private Long flagExSpprepOutSize6;
    @Column(name = "flag_express_spprep_in_size_7")
    private Long flagExSpprepInSize7;
    @Column(name = "flag_express_spprep_out_size_7")
    private Long flagExSpprepOutSize7;
    @Column(name = "flag_express_spprep_in_size_8")
    private Long flagExSpprepInSize8;
    @Column(name = "flag_express_spprep_out_size_8")
    private Long flagExSpprepOutSize8;
    @Column(name = "flag_express_spprep_in_size_9")
    private Long flagExSpprepInSize9;
    @Column(name = "flag_express_spprep_out_size_9")
    private Long flagExSpprepOutSize9;
    @Column(name = "flag_express_spprep_in_size_10")
    private Long flagExSpprepInSize10;
    @Column(name = "flag_express_spprep_out_size_10")
    private Long flagExSpprepOutSize10;
    @Column(name = "flag_express_spprep_in_size_11")
    private Long flagExSpprepInSize11;
    @Column(name = "flag_express_spprep_out_size_11")
    private Long flagExSpprepOutSize11;
    @Column(name = "flag_express_spprep_in_size_12")
    private Long flagExSpprepInSize12;
    @Column(name = "flag_express_spprep_out_size_12")
    private Long flagExSpprepOutSize12;
    @Column(name = "flag_express_spprep_in_size_13")
    private Long flagExSpprepInSize13;
    @Column(name = "flag_express_spprep_out_size_13")
    private Long flagExSpprepOutSize13;
    @Column(name = "flag_express_spprep_in_size_14")
    private Long flagExSpprepInSize14;
    @Column(name = "flag_express_spprep_out_size_14")
    private Long flagExSpprepOutSize14;
    @Column(name = "flag_express_spprep_in_size_15")
    private Long flagExSpprepInSize15;
    @Column(name = "flag_express_spprep_out_size_15")
    private Long flagExSpprepOutSize15;
    @Column(name = "flag_express_spprep_in_size_16")
    private Long flagExSpprepInSize16;
    @Column(name = "flag_express_spprep_out_size_16")
    private Long flagExSpprepOutSize16;
    @Column(name = "flag_express_spprep_in_size_17")
    private Long flagExSpprepInSize17;
    @Column(name = "flag_express_spprep_out_size_17")
    private Long flagExSpprepOutSize17;
    @Column(name = "flag_express_spprep_in_size_18")
    private Long flagExSpprepInSize18;
    @Column(name = "flag_express_spprep_out_size_18")
    private Long flagExSpprepOutSize18;
    @Column(name = "flag_express_spprep_in_size_1_t")
    private Long flagExSpprepInSize1T;
    @Column(name = "flag_express_spprep_out_size_1_t")
    private Long flagExSpprepOutSize1T;
    @Column(name = "flag_express_spprep_in_size_2_t")
    private Long flagExSpprepInSize2T;
    @Column(name = "flag_express_spprep_out_size_2_t")
    private Long flagExSpprepOutSize2T;
    @Column(name = "flag_express_spprep_in_size_3_t")
    private Long flagExSpprepInSize3T;
    @Column(name = "flag_express_spprep_out_size_3_t")
    private Long flagExSpprepOutSize3T;
    @Column(name = "flag_express_spprep_in_size_4_t")
    private Long flagExSpprepInSize4T;
    @Column(name = "flag_express_spprep_out_size_4_t")
    private Long flagExSpprepOutSize4T;
    @Column(name = "flag_express_spprep_in_size_5_t")
    private Long flagExSpprepInSize5T;
    @Column(name = "flag_express_spprep_out_size_5_t")
    private Long flagExSpprepOutSize5T;
    @Column(name = "flag_express_spprep_in_size_6_t")
    private Long flagExSpprepInSize6T;
    @Column(name = "flag_express_spprep_out_size_6_t")
    private Long flagExSpprepOutSize6T;
    @Column(name = "flag_express_spprep_in_size_7_t")
    private Long flagExSpprepInSize7T;
    @Column(name = "flag_express_spprep_out_size_7_t")
    private Long flagExSpprepOutSize7T;
    @Column(name = "flag_express_spprep_in_size_8_t")
    private Long flagExSpprepInSize8T;
    @Column(name = "flag_express_spprep_out_size_8_t")
    private Long flagExSpprepOutSize8T;
    @Column(name = "flag_express_spprep_in_size_9_t")
    private Long flagExSpprepInSize9T;
    @Column(name = "flag_express_spprep_out_size_9_t")
    private Long flagExSpprepOutSize9T;
    @Column(name = "flag_express_spprep_in_size_10_t")
    private Long flagExSpprepInSize10T;
    @Column(name = "flag_express_spprep_out_size_10_t")
    private Long flagExSpprepOutSize10T;
    @Column(name = "flag_express_spprep_in_size_11_t")
    private Long flagExSpprepInSize11T;
    @Column(name = "flag_express_spprep_out_size_11_t")
    private Long flagExSpprepOutSize11T;
    @Column(name = "flag_express_spprep_in_size_12_t")
    private Long flagExSpprepInSize12T;
    @Column(name = "flag_express_spprep_out_size_12_t")
    private Long flagExSpprepOutSize12T;
    @Column(name = "flag_express_spprep_in_size_13_t")
    private Long flagExSpprepInSize13T;
    @Column(name = "flag_express_spprep_out_size_13_t")
    private Long flagExSpprepOutSize13T;
    
        @Column(name = "flag_express_label_in_size_1")
    private Long flagExLabelInSize1;
    @Column(name = "flag_express_label_out_size_1")
    private Long flagExLabelOutSize1;
    @Column(name = "flag_express_label_in_size_2")
    private Long flagExLabelInSize2;
    @Column(name = "flag_express_label_out_size_2")
    private Long flagExLabelOutSize2;
    @Column(name = "flag_express_label_in_size_3")
    private Long flagExLabelInSize3;
    @Column(name = "flag_express_label_out_size_3")
    private Long flagExLabelOutSize3;
    @Column(name = "flag_express_label_in_size_4")
    private Long flagExLabelInSize4;
    @Column(name = "flag_express_label_out_size_4")
    private Long flagExLabelOutSize4;
    @Column(name = "flag_express_label_in_size_5")
    private Long flagExLabelInSize5;
    @Column(name = "flag_express_label_out_size_5")
    private Long flagExLabelOutSize5;
    @Column(name = "flag_express_label_in_size_6")
    private Long flagExLabelInSize6;
    @Column(name = "flag_express_label_out_size_6")
    private Long flagExLabelOutSize6;
    @Column(name = "flag_express_label_in_size_7")
    private Long flagExLabelInSize7;
    @Column(name = "flag_express_label_out_size_7")
    private Long flagExLabelOutSize7;
    @Column(name = "flag_express_label_in_size_8")
    private Long flagExLabelInSize8;
    @Column(name = "flag_express_label_out_size_8")
    private Long flagExLabelOutSize8;
    @Column(name = "flag_express_label_in_size_9")
    private Long flagExLabelInSize9;
    @Column(name = "flag_express_label_out_size_9")
    private Long flagExLabelOutSize9;
    @Column(name = "flag_express_label_in_size_10")
    private Long flagExLabelInSize10;
    @Column(name = "flag_express_label_out_size_10")
    private Long flagExLabelOutSize10;
    @Column(name = "flag_express_label_in_size_11")
    private Long flagExLabelInSize11;
    @Column(name = "flag_express_label_out_size_11")
    private Long flagExLabelOutSize11;
    @Column(name = "flag_express_label_in_size_12")
    private Long flagExLabelInSize12;
    @Column(name = "flag_express_label_out_size_12")
    private Long flagExLabelOutSize12;
    @Column(name = "flag_express_label_in_size_13")
    private Long flagExLabelInSize13;
    @Column(name = "flag_express_label_out_size_13")
    private Long flagExLabelOutSize13;
    @Column(name = "flag_express_label_in_size_14")
    private Long flagExLabelInSize14;
    @Column(name = "flag_express_label_out_size_14")
    private Long flagExLabelOutSize14;
    @Column(name = "flag_express_label_in_size_15")
    private Long flagExLabelInSize15;
    @Column(name = "flag_express_label_out_size_15")
    private Long flagExLabelOutSize15;
    @Column(name = "flag_express_label_in_size_16")
    private Long flagExLabelInSize16;
    @Column(name = "flag_express_label_out_size_16")
    private Long flagExLabelOutSize16;
    @Column(name = "flag_express_label_in_size_17")
    private Long flagExLabelInSize17;
    @Column(name = "flag_express_label_out_size_17")
    private Long flagExLabelOutSize17;
    @Column(name = "flag_express_label_in_size_18")
    private Long flagExLabelInSize18;
    @Column(name = "flag_express_label_out_size_18")
    private Long flagExLabelOutSize18;
    @Column(name = "flag_express_label_in_size_1_t")
    private Long flagExLabelInSize1T;
    @Column(name = "flag_express_label_out_size_1_t")
    private Long flagExLabelOutSize1T;
    @Column(name = "flag_express_label_in_size_2_t")
    private Long flagExLabelInSize2T;
    @Column(name = "flag_express_label_out_size_2_t")
    private Long flagExLabelOutSize2T;
    @Column(name = "flag_express_label_in_size_3_t")
    private Long flagExLabelInSize3T;
    @Column(name = "flag_express_label_out_size_3_t")
    private Long flagExLabelOutSize3T;
    @Column(name = "flag_express_label_in_size_4_t")
    private Long flagExLabelInSize4T;
    @Column(name = "flag_express_label_out_size_4_t")
    private Long flagExLabelOutSize4T;
    @Column(name = "flag_express_label_in_size_5_t")
    private Long flagExLabelInSize5T;
    @Column(name = "flag_express_label_out_size_5_t")
    private Long flagExLabelOutSize5T;
    @Column(name = "flag_express_label_in_size_6_t")
    private Long flagExLabelInSize6T;
    @Column(name = "flag_express_label_out_size_6_t")
    private Long flagExLabelOutSize6T;
    @Column(name = "flag_express_label_in_size_7_t")
    private Long flagExLabelInSize7T;
    @Column(name = "flag_express_label_out_size_7_t")
    private Long flagExLabelOutSize7T;
    @Column(name = "flag_express_label_in_size_8_t")
    private Long flagExLabelInSize8T;
    @Column(name = "flag_express_label_out_size_8_t")
    private Long flagExLabelOutSize8T;
    @Column(name = "flag_express_label_in_size_9_t")
    private Long flagExLabelInSize9T;
    @Column(name = "flag_express_label_out_size_9_t")
    private Long flagExLabelOutSize9T;
    @Column(name = "flag_express_label_in_size_10_t")
    private Long flagExLabelInSize10T;
    @Column(name = "flag_express_label_out_size_10_t")
    private Long flagExLabelOutSize10T;
    @Column(name = "flag_express_label_in_size_11_t")
    private Long flagExLabelInSize11T;
    @Column(name = "flag_express_label_out_size_11_t")
    private Long flagExLabelOutSize11T;
    @Column(name = "flag_express_label_in_size_12_t")
    private Long flagExLabelInSize12T;
    @Column(name = "flag_express_label_out_size_12_t")
    private Long flagExLabelOutSize12T;
    @Column(name = "flag_express_label_in_size_13_t")
    private Long flagExLabelInSize13T;
    @Column(name = "flag_express_label_out_size_13_t")
    private Long flagExLabelOutSize13T;
    
        @Column(name = "flag_express_laser_in_size_1")
    private Long flagExLaserInSize1;
    @Column(name = "flag_express_laser_out_size_1")
    private Long flagExLaserOutSize1;
    @Column(name = "flag_express_laser_in_size_2")
    private Long flagExLaserInSize2;
    @Column(name = "flag_express_laser_out_size_2")
    private Long flagExLaserOutSize2;
    @Column(name = "flag_express_laser_in_size_3")
    private Long flagExLaserInSize3;
    @Column(name = "flag_express_laser_out_size_3")
    private Long flagExLaserOutSize3;
    @Column(name = "flag_express_laser_in_size_4")
    private Long flagExLaserInSize4;
    @Column(name = "flag_express_laser_out_size_4")
    private Long flagExLaserOutSize4;
    @Column(name = "flag_express_laser_in_size_5")
    private Long flagExLaserInSize5;
    @Column(name = "flag_express_laser_out_size_5")
    private Long flagExLaserOutSize5;
    @Column(name = "flag_express_laser_in_size_6")
    private Long flagExLaserInSize6;
    @Column(name = "flag_express_laser_out_size_6")
    private Long flagExLaserOutSize6;
    @Column(name = "flag_express_laser_in_size_7")
    private Long flagExLaserInSize7;
    @Column(name = "flag_express_laser_out_size_7")
    private Long flagExLaserOutSize7;
    @Column(name = "flag_express_laser_in_size_8")
    private Long flagExLaserInSize8;
    @Column(name = "flag_express_laser_out_size_8")
    private Long flagExLaserOutSize8;
    @Column(name = "flag_express_laser_in_size_9")
    private Long flagExLaserInSize9;
    @Column(name = "flag_express_laser_out_size_9")
    private Long flagExLaserOutSize9;
    @Column(name = "flag_express_laser_in_size_10")
    private Long flagExLaserInSize10;
    @Column(name = "flag_express_laser_out_size_10")
    private Long flagExLaserOutSize10;
    @Column(name = "flag_express_laser_in_size_11")
    private Long flagExLaserInSize11;
    @Column(name = "flag_express_laser_out_size_11")
    private Long flagExLaserOutSize11;
    @Column(name = "flag_express_laser_in_size_12")
    private Long flagExLaserInSize12;
    @Column(name = "flag_express_laser_out_size_12")
    private Long flagExLaserOutSize12;
    @Column(name = "flag_express_laser_in_size_13")
    private Long flagExLaserInSize13;
    @Column(name = "flag_express_laser_out_size_13")
    private Long flagExLaserOutSize13;
    @Column(name = "flag_express_laser_in_size_14")
    private Long flagExLaserInSize14;
    @Column(name = "flag_express_laser_out_size_14")
    private Long flagExLaserOutSize14;
    @Column(name = "flag_express_laser_in_size_15")
    private Long flagExLaserInSize15;
    @Column(name = "flag_express_laser_out_size_15")
    private Long flagExLaserOutSize15;
    @Column(name = "flag_express_laser_in_size_16")
    private Long flagExLaserInSize16;
    @Column(name = "flag_express_laser_out_size_16")
    private Long flagExLaserOutSize16;
    @Column(name = "flag_express_laser_in_size_17")
    private Long flagExLaserInSize17;
    @Column(name = "flag_express_laser_out_size_17")
    private Long flagExLaserOutSize17;
    @Column(name = "flag_express_laser_in_size_18")
    private Long flagExLaserInSize18;
    @Column(name = "flag_express_laser_out_size_18")
    private Long flagExLaserOutSize18;
    @Column(name = "flag_express_laser_in_size_1_t")
    private Long flagExLaserInSize1T;
    @Column(name = "flag_express_laser_out_size_1_t")
    private Long flagExLaserOutSize1T;
    @Column(name = "flag_express_laser_in_size_2_t")
    private Long flagExLaserInSize2T;
    @Column(name = "flag_express_laser_out_size_2_t")
    private Long flagExLaserOutSize2T;
    @Column(name = "flag_express_laser_in_size_3_t")
    private Long flagExLaserInSize3T;
    @Column(name = "flag_express_laser_out_size_3_t")
    private Long flagExLaserOutSize3T;
    @Column(name = "flag_express_laser_in_size_4_t")
    private Long flagExLaserInSize4T;
    @Column(name = "flag_express_laser_out_size_4_t")
    private Long flagExLaserOutSize4T;
    @Column(name = "flag_express_laser_in_size_5_t")
    private Long flagExLaserInSize5T;
    @Column(name = "flag_express_laser_out_size_5_t")
    private Long flagExLaserOutSize5T;
    @Column(name = "flag_express_laser_in_size_6_t")
    private Long flagExLaserInSize6T;
    @Column(name = "flag_express_laser_out_size_6_t")
    private Long flagExLaserOutSize6T;
    @Column(name = "flag_express_laser_in_size_7_t")
    private Long flagExLaserInSize7T;
    @Column(name = "flag_express_laser_out_size_7_t")
    private Long flagExLaserOutSize7T;
    @Column(name = "flag_express_laser_in_size_8_t")
    private Long flagExLaserInSize8T;
    @Column(name = "flag_express_laser_out_size_8_t")
    private Long flagExLaserOutSize8T;
    @Column(name = "flag_express_laser_in_size_9_t")
    private Long flagExLaserInSize9T;
    @Column(name = "flag_express_laser_out_size_9_t")
    private Long flagExLaserOutSize9T;
    @Column(name = "flag_express_laser_in_size_10_t")
    private Long flagExLaserInSize10T;
    @Column(name = "flag_express_laser_out_size_10_t")
    private Long flagExLaserOutSize10T;
    @Column(name = "flag_express_laser_in_size_11_t")
    private Long flagExLaserInSize11T;
    @Column(name = "flag_express_laser_out_size_11_t")
    private Long flagExLaserOutSize11T;
    @Column(name = "flag_express_laser_in_size_12_t")
    private Long flagExLaserInSize12T;
    @Column(name = "flag_express_laser_out_size_12_t")
    private Long flagExLaserOutSize12T;
    @Column(name = "flag_express_laser_in_size_13_t")
    private Long flagExLaserInSize13T;
    @Column(name = "flag_express_laser_out_size_13_t")
    private Long flagExLaserOutSize13T;
    
//    column rednote
@Column(name = "rednote_express_ct_size_1")
private String redExCtSize1;
@Column(name = "rednote_express_ct_size_2")
private String redExCtSize2;
@Column(name = "rednote_express_ct_size_3")
private String redExCtSize3;
@Column(name = "rednote_express_ct_size_4")
private String redExCtSize4;
@Column(name = "rednote_express_ct_size_5")
private String redExCtSize5;
@Column(name = "rednote_express_ct_size_6")
private String redExCtSize6;
@Column(name = "rednote_express_ct_size_7")
private String redExCtSize7;
@Column(name = "rednote_express_ct_size_8")
private String redExCtSize8;
@Column(name = "rednote_express_ct_size_9")
private String redExCtSize9;
@Column(name = "rednote_express_ct_size_10")
private String redExCtSize10;
@Column(name = "rednote_express_ct_size_11")
private String redExCtSize11;
@Column(name = "rednote_express_ct_size_12")
private String redExCtSize12;
@Column(name = "rednote_express_ct_size_13")
private String redExCtSize13;
@Column(name = "rednote_express_ct_size_14")
private String redExCtSize14;
@Column(name = "rednote_express_ct_size_15")
private String redExCtSize15;
@Column(name = "rednote_express_ct_size_16")
private String redExCtSize16;
@Column(name = "rednote_express_ct_size_17")
private String redExCtSize17;
@Column(name = "rednote_express_ct_size_18")
private String redExCtSize18;
@Column(name = "rednote_express_ct_size_1_t")
private String redExCtSize1T;
@Column(name = "rednote_express_ct_size_2_t")
private String redExCtSize2T;
@Column(name = "rednote_express_ct_size_3_t")
private String redExCtSize3T;
@Column(name = "rednote_express_ct_size_4_t")
private String redExCtSize4T;
@Column(name = "rednote_express_ct_size_5_t")
private String redExCtSize5T;
@Column(name = "rednote_express_ct_size_6_t")
private String redExCtSize6T;
@Column(name = "rednote_express_ct_size_7_t")
private String redExCtSize7T;
@Column(name = "rednote_express_ct_size_8_t")
private String redExCtSize8T;
@Column(name = "rednote_express_ct_size_9_t")
private String redExCtSize9T;
@Column(name = "rednote_express_ct_size_10_t")
private String redExCtSize10T;
@Column(name = "rednote_express_ct_size_11_t")
private String redExCtSize11T;
@Column(name = "rednote_express_ct_size_12_t")
private String redExCtSize12T;
@Column(name = "rednote_express_ct_size_13_t")
private String redExCtSize13T;
@Column(name = "rednote_express_prep_size_1")
private String redExPrepSize1;
@Column(name = "rednote_express_prep_size_2")
private String redExPrepSize2;
@Column(name = "rednote_express_prep_size_3")
private String redExPrepSize3;
@Column(name = "rednote_express_prep_size_4")
private String redExPrepSize4;
@Column(name = "rednote_express_prep_size_5")
private String redExPrepSize5;
@Column(name = "rednote_express_prep_size_6")
private String redExPrepSize6;
@Column(name = "rednote_express_prep_size_7")
private String redExPrepSize7;
@Column(name = "rednote_express_prep_size_8")
private String redExPrepSize8;
@Column(name = "rednote_express_prep_size_9")
private String redExPrepSize9;
@Column(name = "rednote_express_prep_size_10")
private String redExPrepSize10;
@Column(name = "rednote_express_prep_size_11")
private String redExPrepSize11;
@Column(name = "rednote_express_prep_size_12")
private String redExPrepSize12;
@Column(name = "rednote_express_prep_size_13")
private String redExPrepSize13;
@Column(name = "rednote_express_prep_size_14")
private String redExPrepSize14;
@Column(name = "rednote_express_prep_size_15")
private String redExPrepSize15;
@Column(name = "rednote_express_prep_size_16")
private String redExPrepSize16;
@Column(name = "rednote_express_prep_size_17")
private String redExPrepSize17;
@Column(name = "rednote_express_prep_size_18")
private String redExPrepSize18;
@Column(name = "rednote_express_prep_size_1_t")
private String redExPrepSize1T;
@Column(name = "rednote_express_prep_size_2_t")
private String redExPrepSize2T;
@Column(name = "rednote_express_prep_size_3_t")
private String redExPrepSize3T;
@Column(name = "rednote_express_prep_size_4_t")
private String redExPrepSize4T;
@Column(name = "rednote_express_prep_size_5_t")
private String redExPrepSize5T;
@Column(name = "rednote_express_prep_size_6_t")
private String redExPrepSize6T;
@Column(name = "rednote_express_prep_size_7_t")
private String redExPrepSize7T;
@Column(name = "rednote_express_prep_size_8_t")
private String redExPrepSize8T;
@Column(name = "rednote_express_prep_size_9_t")
private String redExPrepSize9T;
@Column(name = "rednote_express_prep_size_10_t")
private String redExPrepSize10T;
@Column(name = "rednote_express_prep_size_11_t")
private String redExPrepSize11T;
@Column(name = "rednote_express_prep_size_12_t")
private String redExPrepSize12T;
@Column(name = "rednote_express_prep_size_13_t")
private String redExPrepSize13T;
@Column(name = "rednote_express_st_size_1")
private String redExStSize1;
@Column(name = "rednote_express_st_size_2")
private String redExStSize2;
@Column(name = "rednote_express_st_size_3")
private String redExStSize3;
@Column(name = "rednote_express_st_size_4")
private String redExStSize4;
@Column(name = "rednote_express_st_size_5")
private String redExStSize5;
@Column(name = "rednote_express_st_size_6")
private String redExStSize6;
@Column(name = "rednote_express_st_size_7")
private String redExStSize7;
@Column(name = "rednote_express_st_size_8")
private String redExStSize8;
@Column(name = "rednote_express_st_size_9")
private String redExStSize9;
@Column(name = "rednote_express_st_size_10")
private String redExStSize10;
@Column(name = "rednote_express_st_size_11")
private String redExStSize11;
@Column(name = "rednote_express_st_size_12")
private String redExStSize12;
@Column(name = "rednote_express_st_size_13")
private String redExStSize13;
@Column(name = "rednote_express_st_size_14")
private String redExStSize14;
@Column(name = "rednote_express_st_size_15")
private String redExStSize15;
@Column(name = "rednote_express_st_size_16")
private String redExStSize16;
@Column(name = "rednote_express_st_size_17")
private String redExStSize17;
@Column(name = "rednote_express_st_size_18")
private String redExStSize18;
@Column(name = "rednote_express_st_size_1_t")
private String redExStSize1T;
@Column(name = "rednote_express_st_size_2_t")
private String redExStSize2T;
@Column(name = "rednote_express_st_size_3_t")
private String redExStSize3T;
@Column(name = "rednote_express_st_size_4_t")
private String redExStSize4T;
@Column(name = "rednote_express_st_size_5_t")
private String redExStSize5T;
@Column(name = "rednote_express_st_size_6_t")
private String redExStSize6T;
@Column(name = "rednote_express_st_size_7_t")
private String redExStSize7T;
@Column(name = "rednote_express_st_size_8_t")
private String redExStSize8T;
@Column(name = "rednote_express_st_size_9_t")
private String redExStSize9T;
@Column(name = "rednote_express_st_size_10_t")
private String redExStSize10T;
@Column(name = "rednote_express_st_size_11_t")
private String redExStSize11T;
@Column(name = "rednote_express_st_size_12_t")
private String redExStSize12T;
@Column(name = "rednote_express_st_size_13_t")
private String redExStSize13T;
@Column(name = "rednote_express_as_size_1")
private String redExAsSize1;
@Column(name = "rednote_express_as_size_2")
private String redExAsSize2;
@Column(name = "rednote_express_as_size_3")
private String redExAsSize3;
@Column(name = "rednote_express_as_size_4")
private String redExAsSize4;
@Column(name = "rednote_express_as_size_5")
private String redExAsSize5;
@Column(name = "rednote_express_as_size_6")
private String redExAsSize6;
@Column(name = "rednote_express_as_size_7")
private String redExAsSize7;
@Column(name = "rednote_express_as_size_8")
private String redExAsSize8;
@Column(name = "rednote_express_as_size_9")
private String redExAsSize9;
@Column(name = "rednote_express_as_size_10")
private String redExAsSize10;
@Column(name = "rednote_express_as_size_11")
private String redExAsSize11;
@Column(name = "rednote_express_as_size_12")
private String redExAsSize12;
@Column(name = "rednote_express_as_size_13")
private String redExAsSize13;
@Column(name = "rednote_express_as_size_14")
private String redExAsSize14;
@Column(name = "rednote_express_as_size_15")
private String redExAsSize15;
@Column(name = "rednote_express_as_size_16")
private String redExAsSize16;
@Column(name = "rednote_express_as_size_17")
private String redExAsSize17;
@Column(name = "rednote_express_as_size_18")
private String redExAsSize18;
@Column(name = "rednote_express_as_size_1_t")
private String redExAsSize1T;
@Column(name = "rednote_express_as_size_2_t")
private String redExAsSize2T;
@Column(name = "rednote_express_as_size_3_t")
private String redExAsSize3T;
@Column(name = "rednote_express_as_size_4_t")
private String redExAsSize4T;
@Column(name = "rednote_express_as_size_5_t")
private String redExAsSize5T;
@Column(name = "rednote_express_as_size_6_t")
private String redExAsSize6T;
@Column(name = "rednote_express_as_size_7_t")
private String redExAsSize7T;
@Column(name = "rednote_express_as_size_8_t")
private String redExAsSize8T;
@Column(name = "rednote_express_as_size_9_t")
private String redExAsSize9T;
@Column(name = "rednote_express_as_size_10_t")
private String redExAsSize10T;
@Column(name = "rednote_express_as_size_11_t")
private String redExAsSize11T;
@Column(name = "rednote_express_as_size_12_t")
private String redExAsSize12T;
@Column(name = "rednote_express_as_size_13_t")
private String redExAsSize13T;
@Column(name = "rednote_express_csc_size_1")
private String redExCscSize1;
@Column(name = "rednote_express_csc_size_2")
private String redExCscSize2;
@Column(name = "rednote_express_csc_size_3")
private String redExCscSize3;
@Column(name = "rednote_express_csc_size_4")
private String redExCscSize4;
@Column(name = "rednote_express_csc_size_5")
private String redExCscSize5;
@Column(name = "rednote_express_csc_size_6")
private String redExCscSize6;
@Column(name = "rednote_express_csc_size_7")
private String redExCscSize7;
@Column(name = "rednote_express_csc_size_8")
private String redExCscSize8;
@Column(name = "rednote_express_csc_size_9")
private String redExCscSize9;
@Column(name = "rednote_express_csc_size_10")
private String redExCscSize10;
@Column(name = "rednote_express_csc_size_11")
private String redExCscSize11;
@Column(name = "rednote_express_csc_size_12")
private String redExCscSize12;
@Column(name = "rednote_express_csc_size_13")
private String redExCscSize13;
@Column(name = "rednote_express_csc_size_14")
private String redExCscSize14;
@Column(name = "rednote_express_csc_size_15")
private String redExCscSize15;
@Column(name = "rednote_express_csc_size_16")
private String redExCscSize16;
@Column(name = "rednote_express_csc_size_17")
private String redExCscSize17;
@Column(name = "rednote_express_csc_size_18")
private String redExCscSize18;
@Column(name = "rednote_express_csc_size_1_t")
private String redExCscSize1T;
@Column(name = "rednote_express_csc_size_2_t")
private String redExCscSize2T;
@Column(name = "rednote_express_csc_size_3_t")
private String redExCscSize3T;
@Column(name = "rednote_express_csc_size_4_t")
private String redExCscSize4T;
@Column(name = "rednote_express_csc_size_5_t")
private String redExCscSize5T;
@Column(name = "rednote_express_csc_size_6_t")
private String redExCscSize6T;
@Column(name = "rednote_express_csc_size_7_t")
private String redExCscSize7T;
@Column(name = "rednote_express_csc_size_8_t")
private String redExCscSize8T;
@Column(name = "rednote_express_csc_size_9_t")
private String redExCscSize9T;
@Column(name = "rednote_express_csc_size_10_t")
private String redExCscSize10T;
@Column(name = "rednote_express_csc_size_11_t")
private String redExCscSize11T;
@Column(name = "rednote_express_csc_size_12_t")
private String redExCscSize12T;
@Column(name = "rednote_express_csc_size_13_t")
private String redExCscSize13T;
@Column(name = "rednote_express_ns_size_1")
private String redExNsSize1;
@Column(name = "rednote_express_ns_size_2")
private String redExNsSize2;
@Column(name = "rednote_express_ns_size_3")
private String redExNsSize3;
@Column(name = "rednote_express_ns_size_4")
private String redExNsSize4;
@Column(name = "rednote_express_ns_size_5")
private String redExNsSize5;
@Column(name = "rednote_express_ns_size_6")
private String redExNsSize6;
@Column(name = "rednote_express_ns_size_7")
private String redExNsSize7;
@Column(name = "rednote_express_ns_size_8")
private String redExNsSize8;
@Column(name = "rednote_express_ns_size_9")
private String redExNsSize9;
@Column(name = "rednote_express_ns_size_10")
private String redExNsSize10;
@Column(name = "rednote_express_ns_size_11")
private String redExNsSize11;
@Column(name = "rednote_express_ns_size_12")
private String redExNsSize12;
@Column(name = "rednote_express_ns_size_13")
private String redExNsSize13;
@Column(name = "rednote_express_ns_size_14")
private String redExNsSize14;
@Column(name = "rednote_express_ns_size_15")
private String redExNsSize15;
@Column(name = "rednote_express_ns_size_16")
private String redExNsSize16;
@Column(name = "rednote_express_ns_size_17")
private String redExNsSize17;
@Column(name = "rednote_express_ns_size_18")
private String redExNsSize18;
@Column(name = "rednote_express_ns_size_1_t")
private String redExNsSize1T;
@Column(name = "rednote_express_ns_size_2_t")
private String redExNsSize2T;
@Column(name = "rednote_express_ns_size_3_t")
private String redExNsSize3T;
@Column(name = "rednote_express_ns_size_4_t")
private String redExNsSize4T;
@Column(name = "rednote_express_ns_size_5_t")
private String redExNsSize5T;
@Column(name = "rednote_express_ns_size_6_t")
private String redExNsSize6T;
@Column(name = "rednote_express_ns_size_7_t")
private String redExNsSize7T;
@Column(name = "rednote_express_ns_size_8_t")
private String redExNsSize8T;
@Column(name = "rednote_express_ns_size_9_t")
private String redExNsSize9T;
@Column(name = "rednote_express_ns_size_10_t")
private String redExNsSize10T;
@Column(name = "rednote_express_ns_size_11_t")
private String redExNsSize11T;
@Column(name = "rednote_express_ns_size_12_t")
private String redExNsSize12T;
@Column(name = "rednote_express_ns_size_13_t")
private String redExNsSize13T;
@Column(name = "rednote_express_sc_size_1")
private String redExScSize1;
@Column(name = "rednote_express_sc_size_2")
private String redExScSize2;
@Column(name = "rednote_express_sc_size_3")
private String redExScSize3;
@Column(name = "rednote_express_sc_size_4")
private String redExScSize4;
@Column(name = "rednote_express_sc_size_5")
private String redExScSize5;
@Column(name = "rednote_express_sc_size_6")
private String redExScSize6;
@Column(name = "rednote_express_sc_size_7")
private String redExScSize7;
@Column(name = "rednote_express_sc_size_8")
private String redExScSize8;
@Column(name = "rednote_express_sc_size_9")
private String redExScSize9;
@Column(name = "rednote_express_sc_size_10")
private String redExScSize10;
@Column(name = "rednote_express_sc_size_11")
private String redExScSize11;
@Column(name = "rednote_express_sc_size_12")
private String redExScSize12;
@Column(name = "rednote_express_sc_size_13")
private String redExScSize13;
@Column(name = "rednote_express_sc_size_14")
private String redExScSize14;
@Column(name = "rednote_express_sc_size_15")
private String redExScSize15;
@Column(name = "rednote_express_sc_size_16")
private String redExScSize16;
@Column(name = "rednote_express_sc_size_17")
private String redExScSize17;
@Column(name = "rednote_express_sc_size_18")
private String redExScSize18;
@Column(name = "rednote_express_sc_size_1_t")
private String redExScSize1T;
@Column(name = "rednote_express_sc_size_2_t")
private String redExScSize2T;
@Column(name = "rednote_express_sc_size_3_t")
private String redExScSize3T;
@Column(name = "rednote_express_sc_size_4_t")
private String redExScSize4T;
@Column(name = "rednote_express_sc_size_5_t")
private String redExScSize5T;
@Column(name = "rednote_express_sc_size_6_t")
private String redExScSize6T;
@Column(name = "rednote_express_sc_size_7_t")
private String redExScSize7T;
@Column(name = "rednote_express_sc_size_8_t")
private String redExScSize8T;
@Column(name = "rednote_express_sc_size_9_t")
private String redExScSize9T;
@Column(name = "rednote_express_sc_size_10_t")
private String redExScSize10T;
@Column(name = "rednote_express_sc_size_11_t")
private String redExScSize11T;
@Column(name = "rednote_express_sc_size_12_t")
private String redExScSize12T;
@Column(name = "rednote_express_sc_size_13_t")
private String redExScSize13T;
@Column(name = "rednote_express_os_size_1")
private String redExOsSize1;
@Column(name = "rednote_express_os_size_2")
private String redExOsSize2;
@Column(name = "rednote_express_os_size_3")
private String redExOsSize3;
@Column(name = "rednote_express_os_size_4")
private String redExOsSize4;
@Column(name = "rednote_express_os_size_5")
private String redExOsSize5;
@Column(name = "rednote_express_os_size_6")
private String redExOsSize6;
@Column(name = "rednote_express_os_size_7")
private String redExOsSize7;
@Column(name = "rednote_express_os_size_8")
private String redExOsSize8;
@Column(name = "rednote_express_os_size_9")
private String redExOsSize9;
@Column(name = "rednote_express_os_size_10")
private String redExOsSize10;
@Column(name = "rednote_express_os_size_11")
private String redExOsSize11;
@Column(name = "rednote_express_os_size_12")
private String redExOsSize12;
@Column(name = "rednote_express_os_size_13")
private String redExOsSize13;
@Column(name = "rednote_express_os_size_14")
private String redExOsSize14;
@Column(name = "rednote_express_os_size_15")
private String redExOsSize15;
@Column(name = "rednote_express_os_size_16")
private String redExOsSize16;
@Column(name = "rednote_express_os_size_17")
private String redExOsSize17;
@Column(name = "rednote_express_os_size_18")
private String redExOsSize18;
@Column(name = "rednote_express_os_size_1_t")
private String redExOsSize1T;
@Column(name = "rednote_express_os_size_2_t")
private String redExOsSize2T;
@Column(name = "rednote_express_os_size_3_t")
private String redExOsSize3T;
@Column(name = "rednote_express_os_size_4_t")
private String redExOsSize4T;
@Column(name = "rednote_express_os_size_5_t")
private String redExOsSize5T;
@Column(name = "rednote_express_os_size_6_t")
private String redExOsSize6T;
@Column(name = "rednote_express_os_size_7_t")
private String redExOsSize7T;
@Column(name = "rednote_express_os_size_8_t")
private String redExOsSize8T;
@Column(name = "rednote_express_os_size_9_t")
private String redExOsSize9T;
@Column(name = "rednote_express_os_size_10_t")
private String redExOsSize10T;
@Column(name = "rednote_express_os_size_11_t")
private String redExOsSize11T;
@Column(name = "rednote_express_os_size_12_t")
private String redExOsSize12T;
@Column(name = "rednote_express_os_size_13_t")
private String redExOsSize13T;
@Column(name = "rednote_express_spcut_size_1")
private String redExSpcutSize1;
@Column(name = "rednote_express_spcut_size_2")
private String redExSpcutSize2;
@Column(name = "rednote_express_spcut_size_3")
private String redExSpcutSize3;
@Column(name = "rednote_express_spcut_size_4")
private String redExSpcutSize4;
@Column(name = "rednote_express_spcut_size_5")
private String redExSpcutSize5;
@Column(name = "rednote_express_spcut_size_6")
private String redExSpcutSize6;
@Column(name = "rednote_express_spcut_size_7")
private String redExSpcutSize7;
@Column(name = "rednote_express_spcut_size_8")
private String redExSpcutSize8;
@Column(name = "rednote_express_spcut_size_9")
private String redExSpcutSize9;
@Column(name = "rednote_express_spcut_size_10")
private String redExSpcutSize10;
@Column(name = "rednote_express_spcut_size_11")
private String redExSpcutSize11;
@Column(name = "rednote_express_spcut_size_12")
private String redExSpcutSize12;
@Column(name = "rednote_express_spcut_size_13")
private String redExSpcutSize13;
@Column(name = "rednote_express_spcut_size_14")
private String redExSpcutSize14;
@Column(name = "rednote_express_spcut_size_15")
private String redExSpcutSize15;
@Column(name = "rednote_express_spcut_size_16")
private String redExSpcutSize16;
@Column(name = "rednote_express_spcut_size_17")
private String redExSpcutSize17;
@Column(name = "rednote_express_spcut_size_18")
private String redExSpcutSize18;
@Column(name = "rednote_express_spcut_size_1_t")
private String redExSpcutSize1T;
@Column(name = "rednote_express_spcut_size_2_t")
private String redExSpcutSize2T;
@Column(name = "rednote_express_spcut_size_3_t")
private String redExSpcutSize3T;
@Column(name = "rednote_express_spcut_size_4_t")
private String redExSpcutSize4T;
@Column(name = "rednote_express_spcut_size_5_t")
private String redExSpcutSize5T;
@Column(name = "rednote_express_spcut_size_6_t")
private String redExSpcutSize6T;
@Column(name = "rednote_express_spcut_size_7_t")
private String redExSpcutSize7T;
@Column(name = "rednote_express_spcut_size_8_t")
private String redExSpcutSize8T;
@Column(name = "rednote_express_spcut_size_9_t")
private String redExSpcutSize9T;
@Column(name = "rednote_express_spcut_size_10_t")
private String redExSpcutSize10T;
@Column(name = "rednote_express_spcut_size_11_t")
private String redExSpcutSize11T;
@Column(name = "rednote_express_spcut_size_12_t")
private String redExSpcutSize12T;
@Column(name = "rednote_express_spcut_size_13_t")
private String redExSpcutSize13T;
@Column(name = "rednote_express_spprep_size_1")
private String redExSpprepSize1;
@Column(name = "rednote_express_spprep_size_2")
private String redExSpprepSize2;
@Column(name = "rednote_express_spprep_size_3")
private String redExSpprepSize3;
@Column(name = "rednote_express_spprep_size_4")
private String redExSpprepSize4;
@Column(name = "rednote_express_spprep_size_5")
private String redExSpprepSize5;
@Column(name = "rednote_express_spprep_size_6")
private String redExSpprepSize6;
@Column(name = "rednote_express_spprep_size_7")
private String redExSpprepSize7;
@Column(name = "rednote_express_spprep_size_8")
private String redExSpprepSize8;
@Column(name = "rednote_express_spprep_size_9")
private String redExSpprepSize9;
@Column(name = "rednote_express_spprep_size_10")
private String redExSpprepSize10;
@Column(name = "rednote_express_spprep_size_11")
private String redExSpprepSize11;
@Column(name = "rednote_express_spprep_size_12")
private String redExSpprepSize12;
@Column(name = "rednote_express_spprep_size_13")
private String redExSpprepSize13;
@Column(name = "rednote_express_spprep_size_14")
private String redExSpprepSize14;
@Column(name = "rednote_express_spprep_size_15")
private String redExSpprepSize15;
@Column(name = "rednote_express_spprep_size_16")
private String redExSpprepSize16;
@Column(name = "rednote_express_spprep_size_17")
private String redExSpprepSize17;
@Column(name = "rednote_express_spprep_size_18")
private String redExSpprepSize18;
@Column(name = "rednote_express_spprep_size_1_t")
private String redExSpprepSize1T;
@Column(name = "rednote_express_spprep_size_2_t")
private String redExSpprepSize2T;
@Column(name = "rednote_express_spprep_size_3_t")
private String redExSpprepSize3T;
@Column(name = "rednote_express_spprep_size_4_t")
private String redExSpprepSize4T;
@Column(name = "rednote_express_spprep_size_5_t")
private String redExSpprepSize5T;
@Column(name = "rednote_express_spprep_size_6_t")
private String redExSpprepSize6T;
@Column(name = "rednote_express_spprep_size_7_t")
private String redExSpprepSize7T;
@Column(name = "rednote_express_spprep_size_8_t")
private String redExSpprepSize8T;
@Column(name = "rednote_express_spprep_size_9_t")
private String redExSpprepSize9T;
@Column(name = "rednote_express_spprep_size_10_t")
private String redExSpprepSize10T;
@Column(name = "rednote_express_spprep_size_11_t")
private String redExSpprepSize11T;
@Column(name = "rednote_express_spprep_size_12_t")
private String redExSpprepSize12T;
@Column(name = "rednote_express_spprep_size_13_t")
private String redExSpprepSize13T;
@Column(name = "rednote_express_label_size_1")
private String redExLabelSize1;
@Column(name = "rednote_express_label_size_2")
private String redExLabelSize2;
@Column(name = "rednote_express_label_size_3")
private String redExLabelSize3;
@Column(name = "rednote_express_label_size_4")
private String redExLabelSize4;
@Column(name = "rednote_express_label_size_5")
private String redExLabelSize5;
@Column(name = "rednote_express_label_size_6")
private String redExLabelSize6;
@Column(name = "rednote_express_label_size_7")
private String redExLabelSize7;
@Column(name = "rednote_express_label_size_8")
private String redExLabelSize8;
@Column(name = "rednote_express_label_size_9")
private String redExLabelSize9;
@Column(name = "rednote_express_label_size_10")
private String redExLabelSize10;
@Column(name = "rednote_express_label_size_11")
private String redExLabelSize11;
@Column(name = "rednote_express_label_size_12")
private String redExLabelSize12;
@Column(name = "rednote_express_label_size_13")
private String redExLabelSize13;
@Column(name = "rednote_express_label_size_14")
private String redExLabelSize14;
@Column(name = "rednote_express_label_size_15")
private String redExLabelSize15;
@Column(name = "rednote_express_label_size_16")
private String redExLabelSize16;
@Column(name = "rednote_express_label_size_17")
private String redExLabelSize17;
@Column(name = "rednote_express_label_size_18")
private String redExLabelSize18;
@Column(name = "rednote_express_label_size_1_t")
private String redExLabelSize1T;
@Column(name = "rednote_express_label_size_2_t")
private String redExLabelSize2T;
@Column(name = "rednote_express_label_size_3_t")
private String redExLabelSize3T;
@Column(name = "rednote_express_label_size_4_t")
private String redExLabelSize4T;
@Column(name = "rednote_express_label_size_5_t")
private String redExLabelSize5T;
@Column(name = "rednote_express_label_size_6_t")
private String redExLabelSize6T;
@Column(name = "rednote_express_label_size_7_t")
private String redExLabelSize7T;
@Column(name = "rednote_express_label_size_8_t")
private String redExLabelSize8T;
@Column(name = "rednote_express_label_size_9_t")
private String redExLabelSize9T;
@Column(name = "rednote_express_label_size_10_t")
private String redExLabelSize10T;
@Column(name = "rednote_express_label_size_11_t")
private String redExLabelSize11T;
@Column(name = "rednote_express_label_size_12_t")
private String redExLabelSize12T;
@Column(name = "rednote_express_label_size_13_t")
private String redExLabelSize13T;
@Column(name = "rednote_express_laser_size_1")
private String redExLaserSize1;
@Column(name = "rednote_express_laser_size_2")
private String redExLaserSize2;
@Column(name = "rednote_express_laser_size_3")
private String redExLaserSize3;
@Column(name = "rednote_express_laser_size_4")
private String redExLaserSize4;
@Column(name = "rednote_express_laser_size_5")
private String redExLaserSize5;
@Column(name = "rednote_express_laser_size_6")
private String redExLaserSize6;
@Column(name = "rednote_express_laser_size_7")
private String redExLaserSize7;
@Column(name = "rednote_express_laser_size_8")
private String redExLaserSize8;
@Column(name = "rednote_express_laser_size_9")
private String redExLaserSize9;
@Column(name = "rednote_express_laser_size_10")
private String redExLaserSize10;
@Column(name = "rednote_express_laser_size_11")
private String redExLaserSize11;
@Column(name = "rednote_express_laser_size_12")
private String redExLaserSize12;
@Column(name = "rednote_express_laser_size_13")
private String redExLaserSize13;
@Column(name = "rednote_express_laser_size_14")
private String redExLaserSize14;
@Column(name = "rednote_express_laser_size_15")
private String redExLaserSize15;
@Column(name = "rednote_express_laser_size_16")
private String redExLaserSize16;
@Column(name = "rednote_express_laser_size_17")
private String redExLaserSize17;
@Column(name = "rednote_express_laser_size_18")
private String redExLaserSize18;
@Column(name = "rednote_express_laser_size_1_t")
private String redExLaserSize1T;
@Column(name = "rednote_express_laser_size_2_t")
private String redExLaserSize2T;
@Column(name = "rednote_express_laser_size_3_t")
private String redExLaserSize3T;
@Column(name = "rednote_express_laser_size_4_t")
private String redExLaserSize4T;
@Column(name = "rednote_express_laser_size_5_t")
private String redExLaserSize5T;
@Column(name = "rednote_express_laser_size_6_t")
private String redExLaserSize6T;
@Column(name = "rednote_express_laser_size_7_t")
private String redExLaserSize7T;
@Column(name = "rednote_express_laser_size_8_t")
private String redExLaserSize8T;
@Column(name = "rednote_express_laser_size_9_t")
private String redExLaserSize9T;
@Column(name = "rednote_express_laser_size_10_t")
private String redExLaserSize10T;
@Column(name = "rednote_express_laser_size_11_t")
private String redExLaserSize11T;
@Column(name = "rednote_express_laser_size_12_t")
private String redExLaserSize12T;
@Column(name = "rednote_express_laser_size_13_t")
private String redExLaserSize13T;
    
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
        return size1;
    }

    /**
     *
     * @param size1
     */
    public void setSize1(Long size1) {
        this.size1 = size1;
    }

    /**
     *
     * @return
     */
    public Long getSize1T() {
        return size1T;
    }

    /**
     *
     * @param size1T
     */
    public void setSize1T(Long size1T) {
        this.size1T = size1T;
    }

    /**
     *
     * @return
     */
    public Long getSize2() {
        return size2;
    }

    /**
     *
     * @param size2
     */
    public void setSize2(Long size2) {
        this.size2 = size2;
    }

    /**
     *
     * @return
     */
    public Long getSize2T() {
        return size2T;
    }

    /**
     *
     * @param size2T
     */
    public void setSize2T(Long size2T) {
        this.size2T = size2T;
    }

    /**
     *
     * @return
     */
    public Long getSize3() {
        return size3;
    }

    /**
     *
     * @param size3
     */
    public void setSize3(Long size3) {
        this.size3 = size3;
    }

    /**
     *
     * @return
     */
    public Long getSize3T() {
        return size3T;
    }

    /**
     *
     * @param size3T
     */
    public void setSize3T(Long size3T) {
        this.size3T = size3T;
    }

    /**
     *
     * @return
     */
    public Long getSize4() {
        return size4;
    }

    /**
     *
     * @param size4
     */
    public void setSize4(Long size4) {
        this.size4 = size4;
    }

    /**
     *
     * @return
     */
    public Long getSize4T() {
        return size4T;
    }

    /**
     *
     * @param size4T
     */
    public void setSize4T(Long size4T) {
        this.size4T = size4T;
    }

    /**
     *
     * @return
     */
    public Long getSize5() {
        return size5;
    }

    /**
     *
     * @param size5
     */
    public void setSize5(Long size5) {
        this.size5 = size5;
    }

    /**
     *
     * @return
     */
    public Long getSize5T() {
        return size5T;
    }

    /**
     *
     * @param size5T
     */
    public void setSize5T(Long size5T) {
        this.size5T = size5T;
    }

    /**
     *
     * @return
     */
    public Long getSize6() {
        return size6;
    }

    /**
     *
     * @param size6
     */
    public void setSize6(Long size6) {
        this.size6 = size6;
    }

    /**
     *
     * @return
     */
    public Long getSize6T() {
        return size6T;
    }

    /**
     *
     * @param size6T
     */
    public void setSize6T(Long size6T) {
        this.size6T = size6T;
    }

    /**
     *
     * @return
     */
    public Long getSize7() {
        return size7;
    }

    /**
     *
     * @param size7
     */
    public void setSize7(Long size7) {
        this.size7 = size7;
    }

    /**
     *
     * @return
     */
    public Long getSize7T() {
        return size7T;
    }

    /**
     *
     * @param size7T
     */
    public void setSize7T(Long size7T) {
        this.size7T = size7T;
    }

    /**
     *
     * @return
     */
    public Long getSize8() {
        return size8;
    }

    /**
     *
     * @param size8
     */
    public void setSize8(Long size8) {
        this.size8 = size8;
    }

    /**
     *
     * @return
     */
    public Long getSize8T() {
        return size8T;
    }

    /**
     *
     * @param size8T
     */
    public void setSize8T(Long size8T) {
        this.size8T = size8T;
    }

    /**
     *
     * @return
     */
    public Long getSize9() {
        return size9;
    }

    /**
     *
     * @param size9
     */
    public void setSize9(Long size9) {
        this.size9 = size9;
    }

    /**
     *
     * @return
     */
    public Long getSize9T() {
        return size9T;
    }

    /**
     *
     * @param size9T
     */
    public void setSize9T(Long size9T) {
        this.size9T = size9T;
    }

    /**
     *
     * @return
     */
    public Long getSize10() {
        return size10;
    }

    /**
     *
     * @param size10
     */
    public void setSize10(Long size10) {
        this.size10 = size10;
    }

    /**
     *
     * @return
     */
    public Long getSize10T() {
        return size10T;
    }

    /**
     *
     * @param size10T
     */
    public void setSize10T(Long size10T) {
        this.size10T = size10T;
    }

    /**
     *
     * @return
     */
    public Long getSize11() {
        return size11;
    }

    /**
     *
     * @param size11
     */
    public void setSize11(Long size11) {
        this.size11 = size11;
    }

    /**
     *
     * @return
     */
    public Long getSize11T() {
        return size11T;
    }

    /**
     *
     * @param size11T
     */
    public void setSize11T(Long size11T) {
        this.size11T = size11T;
    }

    /**
     *
     * @return
     */
    public Long getSize12() {
        return size12;
    }

    /**
     *
     * @param size12
     */
    public void setSize12(Long size12) {
        this.size12 = size12;
    }

    /**
     *
     * @return
     */
    public Long getSize12T() {
        return size12T;
    }

    /**
     *
     * @param size12T
     */
    public void setSize12T(Long size12T) {
        this.size12T = size12T;
    }

    /**
     *
     * @return
     */
    public Long getSize13() {
        return size13;
    }

    /**
     *
     * @param size13
     */
    public void setSize13(Long size13) {
        this.size13 = size13;
    }

    /**
     *
     * @return
     */
    public Long getSize13T() {
        return size13T;
    }

    /**
     *
     * @param size13T
     */
    public void setSize13T(Long size13T) {
        this.size13T = size13T;
    }

    /**
     *
     * @return
     */
    public Long getSize14() {
        return size14;
    }

    /**
     *
     * @param size14
     */
    public void setSize14(Long size14) {
        this.size14 = size14;
    }

    /**
     *
     * @return
     */
    public Long getSize15() {
        return size15;
    }

    /**
     *
     * @param size15
     */
    public void setSize15(Long size15) {
        this.size15 = size15;
    }

    /**
     *
     * @return
     */
    public Long getSize16() {
        return size16;
    }

    /**
     *
     * @param size16
     */
    public void setSize16(Long size16) {
        this.size16 = size16;
    }

    /**
     *
     * @return
     */
    public Long getSize17() {
        return size17;
    }

    /**
     *
     * @param size17
     */
    public void setSize17(Long size17) {
        this.size17 = size17;
    }

    /**
     *
     * @return
     */
    public Long getSize18() {
        return size18;
    }

    /**
     *
     * @param size18
     */
    public void setSize18(Long size18) {
        this.size18 = size18;
    }

    /**
     *
     * @return
     */
    public Long getApprove1() {
        return approve1;
    }

    /**
     *
     * @param approve1
     */
    public void setApprove1(Long approve1) {
        this.approve1 = approve1;
    }

    /**
     *
     * @return
     */
    public Long getApprove2() {
        return approve2;
    }

    /**
     *
     * @param approve2
     */
    public void setApprove2(Long approve2) {
        this.approve2 = approve2;
    }

    /**
     *
     * @return
     */
    public Long getAssignTo() {
        return assignTo;
    }

    /**
     *
     * @param assignTo
     */
    public void setAssignTo(Long assignTo) {
        this.assignTo = assignTo;
    }

    /**
     *
     * @return
     */
    public Long getPersentase() {
        return persentase;
    }

    /**
     *
     * @param persentase
     */
    public void setPersentase(Long persentase) {
        this.persentase = persentase;
    }

    /**
     *
     * @return
     */
    public Long getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(Long status) {
        this.status = status;
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

    public Long getFlagExCtInSize1() {
        return flagExCtInSize1;
    }

    public void setFlagExCtInSize1(Long flagExCtInSize1) {
        this.flagExCtInSize1 = flagExCtInSize1;
    }

    public Long getFlagExCtOutSize1() {
        return flagExCtOutSize1;
    }

    public void setFlagExCtOutSize1(Long flagExCtOutSize1) {
        this.flagExCtOutSize1 = flagExCtOutSize1;
    }

    public Long getFlagExCtInSize2() {
        return flagExCtInSize2;
    }

    public void setFlagExCtInSize2(Long flagExCtInSize2) {
        this.flagExCtInSize2 = flagExCtInSize2;
    }

    public Long getFlagExCtOutSize2() {
        return flagExCtOutSize2;
    }

    public void setFlagExCtOutSize2(Long flagExCtOutSize2) {
        this.flagExCtOutSize2 = flagExCtOutSize2;
    }

    public Long getFlagExCtInSize3() {
        return flagExCtInSize3;
    }

    public void setFlagExCtInSize3(Long flagExCtInSize3) {
        this.flagExCtInSize3 = flagExCtInSize3;
    }

    public Long getFlagExCtOutSize3() {
        return flagExCtOutSize3;
    }

    public void setFlagExCtOutSize3(Long flagExCtOutSize3) {
        this.flagExCtOutSize3 = flagExCtOutSize3;
    }

    public Long getFlagExCtInSize4() {
        return flagExCtInSize4;
    }

    public void setFlagExCtInSize4(Long flagExCtInSize4) {
        this.flagExCtInSize4 = flagExCtInSize4;
    }

    public Long getFlagExCtOutSize4() {
        return flagExCtOutSize4;
    }

    public void setFlagExCtOutSize4(Long flagExCtOutSize4) {
        this.flagExCtOutSize4 = flagExCtOutSize4;
    }

    public Long getFlagExCtInSize5() {
        return flagExCtInSize5;
    }

    public void setFlagExCtInSize5(Long flagExCtInSize5) {
        this.flagExCtInSize5 = flagExCtInSize5;
    }

    public Long getFlagExCtOutSize5() {
        return flagExCtOutSize5;
    }

    public void setFlagExCtOutSize5(Long flagExCtOutSize5) {
        this.flagExCtOutSize5 = flagExCtOutSize5;
    }

    public Long getFlagExCtInSize6() {
        return flagExCtInSize6;
    }

    public void setFlagExCtInSize6(Long flagExCtInSize6) {
        this.flagExCtInSize6 = flagExCtInSize6;
    }

    public Long getFlagExCtOutSize6() {
        return flagExCtOutSize6;
    }

    public void setFlagExCtOutSize6(Long flagExCtOutSize6) {
        this.flagExCtOutSize6 = flagExCtOutSize6;
    }

    public Long getFlagExCtInSize7() {
        return flagExCtInSize7;
    }

    public void setFlagExCtInSize7(Long flagExCtInSize7) {
        this.flagExCtInSize7 = flagExCtInSize7;
    }

    public Long getFlagExCtOutSize7() {
        return flagExCtOutSize7;
    }

    public void setFlagExCtOutSize7(Long flagExCtOutSize7) {
        this.flagExCtOutSize7 = flagExCtOutSize7;
    }

    public Long getFlagExCtInSize8() {
        return flagExCtInSize8;
    }

    public void setFlagExCtInSize8(Long flagExCtInSize8) {
        this.flagExCtInSize8 = flagExCtInSize8;
    }

    public Long getFlagExCtOutSize8() {
        return flagExCtOutSize8;
    }

    public void setFlagExCtOutSize8(Long flagExCtOutSize8) {
        this.flagExCtOutSize8 = flagExCtOutSize8;
    }

    public Long getFlagExCtInSize9() {
        return flagExCtInSize9;
    }

    public void setFlagExCtInSize9(Long flagExCtInSize9) {
        this.flagExCtInSize9 = flagExCtInSize9;
    }

    public Long getFlagExCtOutSize9() {
        return flagExCtOutSize9;
    }

    public void setFlagExCtOutSize9(Long flagExCtOutSize9) {
        this.flagExCtOutSize9 = flagExCtOutSize9;
    }

    public Long getFlagExCtInSize10() {
        return flagExCtInSize10;
    }

    public void setFlagExCtInSize10(Long flagExCtInSize10) {
        this.flagExCtInSize10 = flagExCtInSize10;
    }

    public Long getFlagExCtOutSize10() {
        return flagExCtOutSize10;
    }

    public void setFlagExCtOutSize10(Long flagExCtOutSize10) {
        this.flagExCtOutSize10 = flagExCtOutSize10;
    }

    public Long getFlagExCtInSize11() {
        return flagExCtInSize11;
    }

    public void setFlagExCtInSize11(Long flagExCtInSize11) {
        this.flagExCtInSize11 = flagExCtInSize11;
    }

    public Long getFlagExCtOutSize11() {
        return flagExCtOutSize11;
    }

    public void setFlagExCtOutSize11(Long flagExCtOutSize11) {
        this.flagExCtOutSize11 = flagExCtOutSize11;
    }

    public Long getFlagExCtInSize12() {
        return flagExCtInSize12;
    }

    public void setFlagExCtInSize12(Long flagExCtInSize12) {
        this.flagExCtInSize12 = flagExCtInSize12;
    }

    public Long getFlagExCtOutSize12() {
        return flagExCtOutSize12;
    }

    public void setFlagExCtOutSize12(Long flagExCtOutSize12) {
        this.flagExCtOutSize12 = flagExCtOutSize12;
    }

    public Long getFlagExCtInSize13() {
        return flagExCtInSize13;
    }

    public void setFlagExCtInSize13(Long flagExCtInSize13) {
        this.flagExCtInSize13 = flagExCtInSize13;
    }

    public Long getFlagExCtOutSize13() {
        return flagExCtOutSize13;
    }

    public void setFlagExCtOutSize13(Long flagExCtOutSize13) {
        this.flagExCtOutSize13 = flagExCtOutSize13;
    }

    public Long getFlagExCtInSize14() {
        return flagExCtInSize14;
    }

    public void setFlagExCtInSize14(Long flagExCtInSize14) {
        this.flagExCtInSize14 = flagExCtInSize14;
    }

    public Long getFlagExCtOutSize14() {
        return flagExCtOutSize14;
    }

    public void setFlagExCtOutSize14(Long flagExCtOutSize14) {
        this.flagExCtOutSize14 = flagExCtOutSize14;
    }

    public Long getFlagExCtInSize15() {
        return flagExCtInSize15;
    }

    public void setFlagExCtInSize15(Long flagExCtInSize15) {
        this.flagExCtInSize15 = flagExCtInSize15;
    }

    public Long getFlagExCtOutSize15() {
        return flagExCtOutSize15;
    }

    public void setFlagExCtOutSize15(Long flagExCtOutSize15) {
        this.flagExCtOutSize15 = flagExCtOutSize15;
    }

    public Long getFlagExCtInSize16() {
        return flagExCtInSize16;
    }

    public void setFlagExCtInSize16(Long flagExCtInSize16) {
        this.flagExCtInSize16 = flagExCtInSize16;
    }

    public Long getFlagExCtOutSize16() {
        return flagExCtOutSize16;
    }

    public void setFlagExCtOutSize16(Long flagExCtOutSize16) {
        this.flagExCtOutSize16 = flagExCtOutSize16;
    }

    public Long getFlagExCtInSize17() {
        return flagExCtInSize17;
    }

    public void setFlagExCtInSize17(Long flagExCtInSize17) {
        this.flagExCtInSize17 = flagExCtInSize17;
    }

    public Long getFlagExCtOutSize17() {
        return flagExCtOutSize17;
    }

    public void setFlagExCtOutSize17(Long flagExCtOutSize17) {
        this.flagExCtOutSize17 = flagExCtOutSize17;
    }

    public Long getFlagExCtInSize18() {
        return flagExCtInSize18;
    }

    public void setFlagExCtInSize18(Long flagExCtInSize18) {
        this.flagExCtInSize18 = flagExCtInSize18;
    }

    public Long getFlagExCtOutSize18() {
        return flagExCtOutSize18;
    }

    public void setFlagExCtOutSize18(Long flagExCtOutSize18) {
        this.flagExCtOutSize18 = flagExCtOutSize18;
    }

    public Long getFlagExCtInSize1T() {
        return flagExCtInSize1T;
    }

    public void setFlagExCtInSize1T(Long flagExCtInSize1T) {
        this.flagExCtInSize1T = flagExCtInSize1T;
    }

    public Long getFlagExCtOutSize1T() {
        return flagExCtOutSize1T;
    }

    public void setFlagExCtOutSize1T(Long flagExCtOutSize1T) {
        this.flagExCtOutSize1T = flagExCtOutSize1T;
    }

    public Long getFlagExCtInSize2T() {
        return flagExCtInSize2T;
    }

    public void setFlagExCtInSize2T(Long flagExCtInSize2T) {
        this.flagExCtInSize2T = flagExCtInSize2T;
    }

    public Long getFlagExCtOutSize2T() {
        return flagExCtOutSize2T;
    }

    public void setFlagExCtOutSize2T(Long flagExCtOutSize2T) {
        this.flagExCtOutSize2T = flagExCtOutSize2T;
    }

    public Long getFlagExCtInSize3T() {
        return flagExCtInSize3T;
    }

    public void setFlagExCtInSize3T(Long flagExCtInSize3T) {
        this.flagExCtInSize3T = flagExCtInSize3T;
    }

    public Long getFlagExCtOutSize3T() {
        return flagExCtOutSize3T;
    }

    public void setFlagExCtOutSize3T(Long flagExCtOutSize3T) {
        this.flagExCtOutSize3T = flagExCtOutSize3T;
    }

    public Long getFlagExCtInSize4T() {
        return flagExCtInSize4T;
    }

    public void setFlagExCtInSize4T(Long flagExCtInSize4T) {
        this.flagExCtInSize4T = flagExCtInSize4T;
    }

    public Long getFlagExCtOutSize4T() {
        return flagExCtOutSize4T;
    }

    public void setFlagExCtOutSize4T(Long flagExCtOutSize4T) {
        this.flagExCtOutSize4T = flagExCtOutSize4T;
    }

    public Long getFlagExCtInSize5T() {
        return flagExCtInSize5T;
    }

    public void setFlagExCtInSize5T(Long flagExCtInSize5T) {
        this.flagExCtInSize5T = flagExCtInSize5T;
    }

    public Long getFlagExCtOutSize5T() {
        return flagExCtOutSize5T;
    }

    public void setFlagExCtOutSize5T(Long flagExCtOutSize5T) {
        this.flagExCtOutSize5T = flagExCtOutSize5T;
    }

    public Long getFlagExCtInSize6T() {
        return flagExCtInSize6T;
    }

    public void setFlagExCtInSize6T(Long flagExCtInSize6T) {
        this.flagExCtInSize6T = flagExCtInSize6T;
    }

    public Long getFlagExCtOutSize6T() {
        return flagExCtOutSize6T;
    }

    public void setFlagExCtOutSize6T(Long flagExCtOutSize6T) {
        this.flagExCtOutSize6T = flagExCtOutSize6T;
    }

    public Long getFlagExCtInSize7T() {
        return flagExCtInSize7T;
    }

    public void setFlagExCtInSize7T(Long flagExCtInSize7T) {
        this.flagExCtInSize7T = flagExCtInSize7T;
    }

    public Long getFlagExCtOutSize7T() {
        return flagExCtOutSize7T;
    }

    public void setFlagExCtOutSize7T(Long flagExCtOutSize7T) {
        this.flagExCtOutSize7T = flagExCtOutSize7T;
    }

    public Long getFlagExCtInSize8T() {
        return flagExCtInSize8T;
    }

    public void setFlagExCtInSize8T(Long flagExCtInSize8T) {
        this.flagExCtInSize8T = flagExCtInSize8T;
    }

    public Long getFlagExCtOutSize8T() {
        return flagExCtOutSize8T;
    }

    public void setFlagExCtOutSize8T(Long flagExCtOutSize8T) {
        this.flagExCtOutSize8T = flagExCtOutSize8T;
    }

    public Long getFlagExCtInSize9T() {
        return flagExCtInSize9T;
    }

    public void setFlagExCtInSize9T(Long flagExCtInSize9T) {
        this.flagExCtInSize9T = flagExCtInSize9T;
    }

    public Long getFlagExCtOutSize9T() {
        return flagExCtOutSize9T;
    }

    public void setFlagExCtOutSize9T(Long flagExCtOutSize9T) {
        this.flagExCtOutSize9T = flagExCtOutSize9T;
    }

    public Long getFlagExCtInSize10T() {
        return flagExCtInSize10T;
    }

    public void setFlagExCtInSize10T(Long flagExCtInSize10T) {
        this.flagExCtInSize10T = flagExCtInSize10T;
    }

    public Long getFlagExCtOutSize10T() {
        return flagExCtOutSize10T;
    }

    public void setFlagExCtOutSize10T(Long flagExCtOutSize10T) {
        this.flagExCtOutSize10T = flagExCtOutSize10T;
    }

    public Long getFlagExCtInSize11T() {
        return flagExCtInSize11T;
    }

    public void setFlagExCtInSize11T(Long flagExCtInSize11T) {
        this.flagExCtInSize11T = flagExCtInSize11T;
    }

    public Long getFlagExCtOutSize11T() {
        return flagExCtOutSize11T;
    }

    public void setFlagExCtOutSize11T(Long flagExCtOutSize11T) {
        this.flagExCtOutSize11T = flagExCtOutSize11T;
    }

    public Long getFlagExCtInSize12T() {
        return flagExCtInSize12T;
    }

    public void setFlagExCtInSize12T(Long flagExCtInSize12T) {
        this.flagExCtInSize12T = flagExCtInSize12T;
    }

    public Long getFlagExCtOutSize12T() {
        return flagExCtOutSize12T;
    }

    public void setFlagExCtOutSize12T(Long flagExCtOutSize12T) {
        this.flagExCtOutSize12T = flagExCtOutSize12T;
    }

    public Long getFlagExCtInSize13T() {
        return flagExCtInSize13T;
    }

    public void setFlagExCtInSize13T(Long flagExCtInSize13T) {
        this.flagExCtInSize13T = flagExCtInSize13T;
    }

    public Long getFlagExCtOutSize13T() {
        return flagExCtOutSize13T;
    }

    public void setFlagExCtOutSize13T(Long flagExCtOutSize13T) {
        this.flagExCtOutSize13T = flagExCtOutSize13T;
    }

    public Long getFlagExPrepInSize1() {
        return flagExPrepInSize1;
    }

    public void setFlagExPrepInSize1(Long flagExPrepInSize1) {
        this.flagExPrepInSize1 = flagExPrepInSize1;
    }

    public Long getFlagExPrepOutSize1() {
        return flagExPrepOutSize1;
    }

    public void setFlagExPrepOutSize1(Long flagExPrepOutSize1) {
        this.flagExPrepOutSize1 = flagExPrepOutSize1;
    }

    public Long getFlagExPrepInSize2() {
        return flagExPrepInSize2;
    }

    public void setFlagExPrepInSize2(Long flagExPrepInSize2) {
        this.flagExPrepInSize2 = flagExPrepInSize2;
    }

    public Long getFlagExPrepOutSize2() {
        return flagExPrepOutSize2;
    }

    public void setFlagExPrepOutSize2(Long flagExPrepOutSize2) {
        this.flagExPrepOutSize2 = flagExPrepOutSize2;
    }

    public Long getFlagExPrepInSize3() {
        return flagExPrepInSize3;
    }

    public void setFlagExPrepInSize3(Long flagExPrepInSize3) {
        this.flagExPrepInSize3 = flagExPrepInSize3;
    }

    public Long getFlagExPrepOutSize3() {
        return flagExPrepOutSize3;
    }

    public void setFlagExPrepOutSize3(Long flagExPrepOutSize3) {
        this.flagExPrepOutSize3 = flagExPrepOutSize3;
    }

    public Long getFlagExPrepInSize4() {
        return flagExPrepInSize4;
    }

    public void setFlagExPrepInSize4(Long flagExPrepInSize4) {
        this.flagExPrepInSize4 = flagExPrepInSize4;
    }

    public Long getFlagExPrepOutSize4() {
        return flagExPrepOutSize4;
    }

    public void setFlagExPrepOutSize4(Long flagExPrepOutSize4) {
        this.flagExPrepOutSize4 = flagExPrepOutSize4;
    }

    public Long getFlagExPrepInSize5() {
        return flagExPrepInSize5;
    }

    public void setFlagExPrepInSize5(Long flagExPrepInSize5) {
        this.flagExPrepInSize5 = flagExPrepInSize5;
    }

    public Long getFlagExPrepOutSize5() {
        return flagExPrepOutSize5;
    }

    public void setFlagExPrepOutSize5(Long flagExPrepOutSize5) {
        this.flagExPrepOutSize5 = flagExPrepOutSize5;
    }

    public Long getFlagExPrepInSize6() {
        return flagExPrepInSize6;
    }

    public void setFlagExPrepInSize6(Long flagExPrepInSize6) {
        this.flagExPrepInSize6 = flagExPrepInSize6;
    }

    public Long getFlagExPrepOutSize6() {
        return flagExPrepOutSize6;
    }

    public void setFlagExPrepOutSize6(Long flagExPrepOutSize6) {
        this.flagExPrepOutSize6 = flagExPrepOutSize6;
    }

    public Long getFlagExPrepInSize7() {
        return flagExPrepInSize7;
    }

    public void setFlagExPrepInSize7(Long flagExPrepInSize7) {
        this.flagExPrepInSize7 = flagExPrepInSize7;
    }

    public Long getFlagExPrepOutSize7() {
        return flagExPrepOutSize7;
    }

    public void setFlagExPrepOutSize7(Long flagExPrepOutSize7) {
        this.flagExPrepOutSize7 = flagExPrepOutSize7;
    }

    public Long getFlagExPrepInSize8() {
        return flagExPrepInSize8;
    }

    public void setFlagExPrepInSize8(Long flagExPrepInSize8) {
        this.flagExPrepInSize8 = flagExPrepInSize8;
    }

    public Long getFlagExPrepOutSize8() {
        return flagExPrepOutSize8;
    }

    public void setFlagExPrepOutSize8(Long flagExPrepOutSize8) {
        this.flagExPrepOutSize8 = flagExPrepOutSize8;
    }

    public Long getFlagExPrepInSize9() {
        return flagExPrepInSize9;
    }

    public void setFlagExPrepInSize9(Long flagExPrepInSize9) {
        this.flagExPrepInSize9 = flagExPrepInSize9;
    }

    public Long getFlagExPrepOutSize9() {
        return flagExPrepOutSize9;
    }

    public void setFlagExPrepOutSize9(Long flagExPrepOutSize9) {
        this.flagExPrepOutSize9 = flagExPrepOutSize9;
    }

    public Long getFlagExPrepInSize10() {
        return flagExPrepInSize10;
    }

    public void setFlagExPrepInSize10(Long flagExPrepInSize10) {
        this.flagExPrepInSize10 = flagExPrepInSize10;
    }

    public Long getFlagExPrepOutSize10() {
        return flagExPrepOutSize10;
    }

    public void setFlagExPrepOutSize10(Long flagExPrepOutSize10) {
        this.flagExPrepOutSize10 = flagExPrepOutSize10;
    }

    public Long getFlagExPrepInSize11() {
        return flagExPrepInSize11;
    }

    public void setFlagExPrepInSize11(Long flagExPrepInSize11) {
        this.flagExPrepInSize11 = flagExPrepInSize11;
    }

    public Long getFlagExPrepOutSize11() {
        return flagExPrepOutSize11;
    }

    public void setFlagExPrepOutSize11(Long flagExPrepOutSize11) {
        this.flagExPrepOutSize11 = flagExPrepOutSize11;
    }

    public Long getFlagExPrepInSize12() {
        return flagExPrepInSize12;
    }

    public void setFlagExPrepInSize12(Long flagExPrepInSize12) {
        this.flagExPrepInSize12 = flagExPrepInSize12;
    }

    public Long getFlagExPrepOutSize12() {
        return flagExPrepOutSize12;
    }

    public void setFlagExPrepOutSize12(Long flagExPrepOutSize12) {
        this.flagExPrepOutSize12 = flagExPrepOutSize12;
    }

    public Long getFlagExPrepInSize13() {
        return flagExPrepInSize13;
    }

    public void setFlagExPrepInSize13(Long flagExPrepInSize13) {
        this.flagExPrepInSize13 = flagExPrepInSize13;
    }

    public Long getFlagExPrepOutSize13() {
        return flagExPrepOutSize13;
    }

    public void setFlagExPrepOutSize13(Long flagExPrepOutSize13) {
        this.flagExPrepOutSize13 = flagExPrepOutSize13;
    }

    public Long getFlagExPrepInSize14() {
        return flagExPrepInSize14;
    }

    public void setFlagExPrepInSize14(Long flagExPrepInSize14) {
        this.flagExPrepInSize14 = flagExPrepInSize14;
    }

    public Long getFlagExPrepOutSize14() {
        return flagExPrepOutSize14;
    }

    public void setFlagExPrepOutSize14(Long flagExPrepOutSize14) {
        this.flagExPrepOutSize14 = flagExPrepOutSize14;
    }

    public Long getFlagExPrepInSize15() {
        return flagExPrepInSize15;
    }

    public void setFlagExPrepInSize15(Long flagExPrepInSize15) {
        this.flagExPrepInSize15 = flagExPrepInSize15;
    }

    public Long getFlagExPrepOutSize15() {
        return flagExPrepOutSize15;
    }

    public void setFlagExPrepOutSize15(Long flagExPrepOutSize15) {
        this.flagExPrepOutSize15 = flagExPrepOutSize15;
    }

    public Long getFlagExPrepInSize16() {
        return flagExPrepInSize16;
    }

    public void setFlagExPrepInSize16(Long flagExPrepInSize16) {
        this.flagExPrepInSize16 = flagExPrepInSize16;
    }

    public Long getFlagExPrepOutSize16() {
        return flagExPrepOutSize16;
    }

    public void setFlagExPrepOutSize16(Long flagExPrepOutSize16) {
        this.flagExPrepOutSize16 = flagExPrepOutSize16;
    }

    public Long getFlagExPrepInSize17() {
        return flagExPrepInSize17;
    }

    public void setFlagExPrepInSize17(Long flagExPrepInSize17) {
        this.flagExPrepInSize17 = flagExPrepInSize17;
    }

    public Long getFlagExPrepOutSize17() {
        return flagExPrepOutSize17;
    }

    public void setFlagExPrepOutSize17(Long flagExPrepOutSize17) {
        this.flagExPrepOutSize17 = flagExPrepOutSize17;
    }

    public Long getFlagExPrepInSize18() {
        return flagExPrepInSize18;
    }

    public void setFlagExPrepInSize18(Long flagExPrepInSize18) {
        this.flagExPrepInSize18 = flagExPrepInSize18;
    }

    public Long getFlagExPrepOutSize18() {
        return flagExPrepOutSize18;
    }

    public void setFlagExPrepOutSize18(Long flagExPrepOutSize18) {
        this.flagExPrepOutSize18 = flagExPrepOutSize18;
    }

    public Long getFlagExPrepInSize1T() {
        return flagExPrepInSize1T;
    }

    public void setFlagExPrepInSize1T(Long flagExPrepInSize1T) {
        this.flagExPrepInSize1T = flagExPrepInSize1T;
    }

    public Long getFlagExPrepOutSize1T() {
        return flagExPrepOutSize1T;
    }

    public void setFlagExPrepOutSize1T(Long flagExPrepOutSize1T) {
        this.flagExPrepOutSize1T = flagExPrepOutSize1T;
    }

    public Long getFlagExPrepInSize2T() {
        return flagExPrepInSize2T;
    }

    public void setFlagExPrepInSize2T(Long flagExPrepInSize2T) {
        this.flagExPrepInSize2T = flagExPrepInSize2T;
    }

    public Long getFlagExPrepOutSize2T() {
        return flagExPrepOutSize2T;
    }

    public void setFlagExPrepOutSize2T(Long flagExPrepOutSize2T) {
        this.flagExPrepOutSize2T = flagExPrepOutSize2T;
    }

    public Long getFlagExPrepInSize3T() {
        return flagExPrepInSize3T;
    }

    public void setFlagExPrepInSize3T(Long flagExPrepInSize3T) {
        this.flagExPrepInSize3T = flagExPrepInSize3T;
    }

    public Long getFlagExPrepOutSize3T() {
        return flagExPrepOutSize3T;
    }

    public void setFlagExPrepOutSize3T(Long flagExPrepOutSize3T) {
        this.flagExPrepOutSize3T = flagExPrepOutSize3T;
    }

    public Long getFlagExPrepInSize4T() {
        return flagExPrepInSize4T;
    }

    public void setFlagExPrepInSize4T(Long flagExPrepInSize4T) {
        this.flagExPrepInSize4T = flagExPrepInSize4T;
    }

    public Long getFlagExPrepOutSize4T() {
        return flagExPrepOutSize4T;
    }

    public void setFlagExPrepOutSize4T(Long flagExPrepOutSize4T) {
        this.flagExPrepOutSize4T = flagExPrepOutSize4T;
    }

    public Long getFlagExPrepInSize5T() {
        return flagExPrepInSize5T;
    }

    public void setFlagExPrepInSize5T(Long flagExPrepInSize5T) {
        this.flagExPrepInSize5T = flagExPrepInSize5T;
    }

    public Long getFlagExPrepOutSize5T() {
        return flagExPrepOutSize5T;
    }

    public void setFlagExPrepOutSize5T(Long flagExPrepOutSize5T) {
        this.flagExPrepOutSize5T = flagExPrepOutSize5T;
    }

    public Long getFlagExPrepInSize6T() {
        return flagExPrepInSize6T;
    }

    public void setFlagExPrepInSize6T(Long flagExPrepInSize6T) {
        this.flagExPrepInSize6T = flagExPrepInSize6T;
    }

    public Long getFlagExPrepOutSize6T() {
        return flagExPrepOutSize6T;
    }

    public void setFlagExPrepOutSize6T(Long flagExPrepOutSize6T) {
        this.flagExPrepOutSize6T = flagExPrepOutSize6T;
    }

    public Long getFlagExPrepInSize7T() {
        return flagExPrepInSize7T;
    }

    public void setFlagExPrepInSize7T(Long flagExPrepInSize7T) {
        this.flagExPrepInSize7T = flagExPrepInSize7T;
    }

    public Long getFlagExPrepOutSize7T() {
        return flagExPrepOutSize7T;
    }

    public void setFlagExPrepOutSize7T(Long flagExPrepOutSize7T) {
        this.flagExPrepOutSize7T = flagExPrepOutSize7T;
    }

    public Long getFlagExPrepInSize8T() {
        return flagExPrepInSize8T;
    }

    public void setFlagExPrepInSize8T(Long flagExPrepInSize8T) {
        this.flagExPrepInSize8T = flagExPrepInSize8T;
    }

    public Long getFlagExPrepOutSize8T() {
        return flagExPrepOutSize8T;
    }

    public void setFlagExPrepOutSize8T(Long flagExPrepOutSize8T) {
        this.flagExPrepOutSize8T = flagExPrepOutSize8T;
    }

    public Long getFlagExPrepInSize9T() {
        return flagExPrepInSize9T;
    }

    public void setFlagExPrepInSize9T(Long flagExPrepInSize9T) {
        this.flagExPrepInSize9T = flagExPrepInSize9T;
    }

    public Long getFlagExPrepOutSize9T() {
        return flagExPrepOutSize9T;
    }

    public void setFlagExPrepOutSize9T(Long flagExPrepOutSize9T) {
        this.flagExPrepOutSize9T = flagExPrepOutSize9T;
    }

    public Long getFlagExPrepInSize10T() {
        return flagExPrepInSize10T;
    }

    public void setFlagExPrepInSize10T(Long flagExPrepInSize10T) {
        this.flagExPrepInSize10T = flagExPrepInSize10T;
    }

    public Long getFlagExPrepOutSize10T() {
        return flagExPrepOutSize10T;
    }

    public void setFlagExPrepOutSize10T(Long flagExPrepOutSize10T) {
        this.flagExPrepOutSize10T = flagExPrepOutSize10T;
    }

    public Long getFlagExPrepInSize11T() {
        return flagExPrepInSize11T;
    }

    public void setFlagExPrepInSize11T(Long flagExPrepInSize11T) {
        this.flagExPrepInSize11T = flagExPrepInSize11T;
    }

    public Long getFlagExPrepOutSize11T() {
        return flagExPrepOutSize11T;
    }

    public void setFlagExPrepOutSize11T(Long flagExPrepOutSize11T) {
        this.flagExPrepOutSize11T = flagExPrepOutSize11T;
    }

    public Long getFlagExPrepInSize12T() {
        return flagExPrepInSize12T;
    }

    public void setFlagExPrepInSize12T(Long flagExPrepInSize12T) {
        this.flagExPrepInSize12T = flagExPrepInSize12T;
    }

    public Long getFlagExPrepOutSize12T() {
        return flagExPrepOutSize12T;
    }

    public void setFlagExPrepOutSize12T(Long flagExPrepOutSize12T) {
        this.flagExPrepOutSize12T = flagExPrepOutSize12T;
    }

    public Long getFlagExPrepInSize13T() {
        return flagExPrepInSize13T;
    }

    public void setFlagExPrepInSize13T(Long flagExPrepInSize13T) {
        this.flagExPrepInSize13T = flagExPrepInSize13T;
    }

    public Long getFlagExPrepOutSize13T() {
        return flagExPrepOutSize13T;
    }

    public void setFlagExPrepOutSize13T(Long flagExPrepOutSize13T) {
        this.flagExPrepOutSize13T = flagExPrepOutSize13T;
    }

    public Long getFlagExStInSize1() {
        return flagExStInSize1;
    }

    public void setFlagExStInSize1(Long flagExStInSize1) {
        this.flagExStInSize1 = flagExStInSize1;
    }

    public Long getFlagExStOutSize1() {
        return flagExStOutSize1;
    }

    public void setFlagExStOutSize1(Long flagExStOutSize1) {
        this.flagExStOutSize1 = flagExStOutSize1;
    }

    public Long getFlagExStInSize2() {
        return flagExStInSize2;
    }

    public void setFlagExStInSize2(Long flagExStInSize2) {
        this.flagExStInSize2 = flagExStInSize2;
    }

    public Long getFlagExStOutSize2() {
        return flagExStOutSize2;
    }

    public void setFlagExStOutSize2(Long flagExStOutSize2) {
        this.flagExStOutSize2 = flagExStOutSize2;
    }

    public Long getFlagExStInSize3() {
        return flagExStInSize3;
    }

    public void setFlagExStInSize3(Long flagExStInSize3) {
        this.flagExStInSize3 = flagExStInSize3;
    }

    public Long getFlagExStOutSize3() {
        return flagExStOutSize3;
    }

    public void setFlagExStOutSize3(Long flagExStOutSize3) {
        this.flagExStOutSize3 = flagExStOutSize3;
    }

    public Long getFlagExStInSize4() {
        return flagExStInSize4;
    }

    public void setFlagExStInSize4(Long flagExStInSize4) {
        this.flagExStInSize4 = flagExStInSize4;
    }

    public Long getFlagExStOutSize4() {
        return flagExStOutSize4;
    }

    public void setFlagExStOutSize4(Long flagExStOutSize4) {
        this.flagExStOutSize4 = flagExStOutSize4;
    }

    public Long getFlagExStInSize5() {
        return flagExStInSize5;
    }

    public void setFlagExStInSize5(Long flagExStInSize5) {
        this.flagExStInSize5 = flagExStInSize5;
    }

    public Long getFlagExStOutSize5() {
        return flagExStOutSize5;
    }

    public void setFlagExStOutSize5(Long flagExStOutSize5) {
        this.flagExStOutSize5 = flagExStOutSize5;
    }

    public Long getFlagExStInSize6() {
        return flagExStInSize6;
    }

    public void setFlagExStInSize6(Long flagExStInSize6) {
        this.flagExStInSize6 = flagExStInSize6;
    }

    public Long getFlagExStOutSize6() {
        return flagExStOutSize6;
    }

    public void setFlagExStOutSize6(Long flagExStOutSize6) {
        this.flagExStOutSize6 = flagExStOutSize6;
    }

    public Long getFlagExStInSize7() {
        return flagExStInSize7;
    }

    public void setFlagExStInSize7(Long flagExStInSize7) {
        this.flagExStInSize7 = flagExStInSize7;
    }

    public Long getFlagExStOutSize7() {
        return flagExStOutSize7;
    }

    public void setFlagExStOutSize7(Long flagExStOutSize7) {
        this.flagExStOutSize7 = flagExStOutSize7;
    }

    public Long getFlagExStInSize8() {
        return flagExStInSize8;
    }

    public void setFlagExStInSize8(Long flagExStInSize8) {
        this.flagExStInSize8 = flagExStInSize8;
    }

    public Long getFlagExStOutSize8() {
        return flagExStOutSize8;
    }

    public void setFlagExStOutSize8(Long flagExStOutSize8) {
        this.flagExStOutSize8 = flagExStOutSize8;
    }

    public Long getFlagExStInSize9() {
        return flagExStInSize9;
    }

    public void setFlagExStInSize9(Long flagExStInSize9) {
        this.flagExStInSize9 = flagExStInSize9;
    }

    public Long getFlagExStOutSize9() {
        return flagExStOutSize9;
    }

    public void setFlagExStOutSize9(Long flagExStOutSize9) {
        this.flagExStOutSize9 = flagExStOutSize9;
    }

    public Long getFlagExStInSize10() {
        return flagExStInSize10;
    }

    public void setFlagExStInSize10(Long flagExStInSize10) {
        this.flagExStInSize10 = flagExStInSize10;
    }

    public Long getFlagExStOutSize10() {
        return flagExStOutSize10;
    }

    public void setFlagExStOutSize10(Long flagExStOutSize10) {
        this.flagExStOutSize10 = flagExStOutSize10;
    }

    public Long getFlagExStInSize11() {
        return flagExStInSize11;
    }

    public void setFlagExStInSize11(Long flagExStInSize11) {
        this.flagExStInSize11 = flagExStInSize11;
    }

    public Long getFlagExStOutSize11() {
        return flagExStOutSize11;
    }

    public void setFlagExStOutSize11(Long flagExStOutSize11) {
        this.flagExStOutSize11 = flagExStOutSize11;
    }

    public Long getFlagExStInSize12() {
        return flagExStInSize12;
    }

    public void setFlagExStInSize12(Long flagExStInSize12) {
        this.flagExStInSize12 = flagExStInSize12;
    }

    public Long getFlagExStOutSize12() {
        return flagExStOutSize12;
    }

    public void setFlagExStOutSize12(Long flagExStOutSize12) {
        this.flagExStOutSize12 = flagExStOutSize12;
    }

    public Long getFlagExStInSize13() {
        return flagExStInSize13;
    }

    public void setFlagExStInSize13(Long flagExStInSize13) {
        this.flagExStInSize13 = flagExStInSize13;
    }

    public Long getFlagExStOutSize13() {
        return flagExStOutSize13;
    }

    public void setFlagExStOutSize13(Long flagExStOutSize13) {
        this.flagExStOutSize13 = flagExStOutSize13;
    }

    public Long getFlagExStInSize14() {
        return flagExStInSize14;
    }

    public void setFlagExStInSize14(Long flagExStInSize14) {
        this.flagExStInSize14 = flagExStInSize14;
    }

    public Long getFlagExStOutSize14() {
        return flagExStOutSize14;
    }

    public void setFlagExStOutSize14(Long flagExStOutSize14) {
        this.flagExStOutSize14 = flagExStOutSize14;
    }

    public Long getFlagExStInSize15() {
        return flagExStInSize15;
    }

    public void setFlagExStInSize15(Long flagExStInSize15) {
        this.flagExStInSize15 = flagExStInSize15;
    }

    public Long getFlagExStOutSize15() {
        return flagExStOutSize15;
    }

    public void setFlagExStOutSize15(Long flagExStOutSize15) {
        this.flagExStOutSize15 = flagExStOutSize15;
    }

    public Long getFlagExStInSize16() {
        return flagExStInSize16;
    }

    public void setFlagExStInSize16(Long flagExStInSize16) {
        this.flagExStInSize16 = flagExStInSize16;
    }

    public Long getFlagExStOutSize16() {
        return flagExStOutSize16;
    }

    public void setFlagExStOutSize16(Long flagExStOutSize16) {
        this.flagExStOutSize16 = flagExStOutSize16;
    }

    public Long getFlagExStInSize17() {
        return flagExStInSize17;
    }

    public void setFlagExStInSize17(Long flagExStInSize17) {
        this.flagExStInSize17 = flagExStInSize17;
    }

    public Long getFlagExStOutSize17() {
        return flagExStOutSize17;
    }

    public void setFlagExStOutSize17(Long flagExStOutSize17) {
        this.flagExStOutSize17 = flagExStOutSize17;
    }

    public Long getFlagExStInSize18() {
        return flagExStInSize18;
    }

    public void setFlagExStInSize18(Long flagExStInSize18) {
        this.flagExStInSize18 = flagExStInSize18;
    }

    public Long getFlagExStOutSize18() {
        return flagExStOutSize18;
    }

    public void setFlagExStOutSize18(Long flagExStOutSize18) {
        this.flagExStOutSize18 = flagExStOutSize18;
    }

    public Long getFlagExStInSize1T() {
        return flagExStInSize1T;
    }

    public void setFlagExStInSize1T(Long flagExStInSize1T) {
        this.flagExStInSize1T = flagExStInSize1T;
    }

    public Long getFlagExStOutSize1T() {
        return flagExStOutSize1T;
    }

    public void setFlagExStOutSize1T(Long flagExStOutSize1T) {
        this.flagExStOutSize1T = flagExStOutSize1T;
    }

    public Long getFlagExStInSize2T() {
        return flagExStInSize2T;
    }

    public void setFlagExStInSize2T(Long flagExStInSize2T) {
        this.flagExStInSize2T = flagExStInSize2T;
    }

    public Long getFlagExStOutSize2T() {
        return flagExStOutSize2T;
    }

    public void setFlagExStOutSize2T(Long flagExStOutSize2T) {
        this.flagExStOutSize2T = flagExStOutSize2T;
    }

    public Long getFlagExStInSize3T() {
        return flagExStInSize3T;
    }

    public void setFlagExStInSize3T(Long flagExStInSize3T) {
        this.flagExStInSize3T = flagExStInSize3T;
    }

    public Long getFlagExStOutSize3T() {
        return flagExStOutSize3T;
    }

    public void setFlagExStOutSize3T(Long flagExStOutSize3T) {
        this.flagExStOutSize3T = flagExStOutSize3T;
    }

    public Long getFlagExStInSize4T() {
        return flagExStInSize4T;
    }

    public void setFlagExStInSize4T(Long flagExStInSize4T) {
        this.flagExStInSize4T = flagExStInSize4T;
    }

    public Long getFlagExStOutSize4T() {
        return flagExStOutSize4T;
    }

    public void setFlagExStOutSize4T(Long flagExStOutSize4T) {
        this.flagExStOutSize4T = flagExStOutSize4T;
    }

    public Long getFlagExStInSize5T() {
        return flagExStInSize5T;
    }

    public void setFlagExStInSize5T(Long flagExStInSize5T) {
        this.flagExStInSize5T = flagExStInSize5T;
    }

    public Long getFlagExStOutSize5T() {
        return flagExStOutSize5T;
    }

    public void setFlagExStOutSize5T(Long flagExStOutSize5T) {
        this.flagExStOutSize5T = flagExStOutSize5T;
    }

    public Long getFlagExStInSize6T() {
        return flagExStInSize6T;
    }

    public void setFlagExStInSize6T(Long flagExStInSize6T) {
        this.flagExStInSize6T = flagExStInSize6T;
    }

    public Long getFlagExStOutSize6T() {
        return flagExStOutSize6T;
    }

    public void setFlagExStOutSize6T(Long flagExStOutSize6T) {
        this.flagExStOutSize6T = flagExStOutSize6T;
    }

    public Long getFlagExStInSize7T() {
        return flagExStInSize7T;
    }

    public void setFlagExStInSize7T(Long flagExStInSize7T) {
        this.flagExStInSize7T = flagExStInSize7T;
    }

    public Long getFlagExStOutSize7T() {
        return flagExStOutSize7T;
    }

    public void setFlagExStOutSize7T(Long flagExStOutSize7T) {
        this.flagExStOutSize7T = flagExStOutSize7T;
    }

    public Long getFlagExStInSize8T() {
        return flagExStInSize8T;
    }

    public void setFlagExStInSize8T(Long flagExStInSize8T) {
        this.flagExStInSize8T = flagExStInSize8T;
    }

    public Long getFlagExStOutSize8T() {
        return flagExStOutSize8T;
    }

    public void setFlagExStOutSize8T(Long flagExStOutSize8T) {
        this.flagExStOutSize8T = flagExStOutSize8T;
    }

    public Long getFlagExStInSize9T() {
        return flagExStInSize9T;
    }

    public void setFlagExStInSize9T(Long flagExStInSize9T) {
        this.flagExStInSize9T = flagExStInSize9T;
    }

    public Long getFlagExStOutSize9T() {
        return flagExStOutSize9T;
    }

    public void setFlagExStOutSize9T(Long flagExStOutSize9T) {
        this.flagExStOutSize9T = flagExStOutSize9T;
    }

    public Long getFlagExStInSize10T() {
        return flagExStInSize10T;
    }

    public void setFlagExStInSize10T(Long flagExStInSize10T) {
        this.flagExStInSize10T = flagExStInSize10T;
    }

    public Long getFlagExStOutSize10T() {
        return flagExStOutSize10T;
    }

    public void setFlagExStOutSize10T(Long flagExStOutSize10T) {
        this.flagExStOutSize10T = flagExStOutSize10T;
    }

    public Long getFlagExStInSize11T() {
        return flagExStInSize11T;
    }

    public void setFlagExStInSize11T(Long flagExStInSize11T) {
        this.flagExStInSize11T = flagExStInSize11T;
    }

    public Long getFlagExStOutSize11T() {
        return flagExStOutSize11T;
    }

    public void setFlagExStOutSize11T(Long flagExStOutSize11T) {
        this.flagExStOutSize11T = flagExStOutSize11T;
    }

    public Long getFlagExStInSize12T() {
        return flagExStInSize12T;
    }

    public void setFlagExStInSize12T(Long flagExStInSize12T) {
        this.flagExStInSize12T = flagExStInSize12T;
    }

    public Long getFlagExStOutSize12T() {
        return flagExStOutSize12T;
    }

    public void setFlagExStOutSize12T(Long flagExStOutSize12T) {
        this.flagExStOutSize12T = flagExStOutSize12T;
    }

    public Long getFlagExStInSize13T() {
        return flagExStInSize13T;
    }

    public void setFlagExStInSize13T(Long flagExStInSize13T) {
        this.flagExStInSize13T = flagExStInSize13T;
    }

    public Long getFlagExStOutSize13T() {
        return flagExStOutSize13T;
    }

    public void setFlagExStOutSize13T(Long flagExStOutSize13T) {
        this.flagExStOutSize13T = flagExStOutSize13T;
    }

    public Long getFlagExAsInSize1() {
        return flagExAsInSize1;
    }

    public void setFlagExAsInSize1(Long flagExAsInSize1) {
        this.flagExAsInSize1 = flagExAsInSize1;
    }

    public Long getFlagExAsOutSize1() {
        return flagExAsOutSize1;
    }

    public void setFlagExAsOutSize1(Long flagExAsOutSize1) {
        this.flagExAsOutSize1 = flagExAsOutSize1;
    }

    public Long getFlagExAsInSize2() {
        return flagExAsInSize2;
    }

    public void setFlagExAsInSize2(Long flagExAsInSize2) {
        this.flagExAsInSize2 = flagExAsInSize2;
    }

    public Long getFlagExAsOutSize2() {
        return flagExAsOutSize2;
    }

    public void setFlagExAsOutSize2(Long flagExAsOutSize2) {
        this.flagExAsOutSize2 = flagExAsOutSize2;
    }

    public Long getFlagExAsInSize3() {
        return flagExAsInSize3;
    }

    public void setFlagExAsInSize3(Long flagExAsInSize3) {
        this.flagExAsInSize3 = flagExAsInSize3;
    }

    public Long getFlagExAsOutSize3() {
        return flagExAsOutSize3;
    }

    public void setFlagExAsOutSize3(Long flagExAsOutSize3) {
        this.flagExAsOutSize3 = flagExAsOutSize3;
    }

    public Long getFlagExAsInSize4() {
        return flagExAsInSize4;
    }

    public void setFlagExAsInSize4(Long flagExAsInSize4) {
        this.flagExAsInSize4 = flagExAsInSize4;
    }

    public Long getFlagExAsOutSize4() {
        return flagExAsOutSize4;
    }

    public void setFlagExAsOutSize4(Long flagExAsOutSize4) {
        this.flagExAsOutSize4 = flagExAsOutSize4;
    }

    public Long getFlagExAsInSize5() {
        return flagExAsInSize5;
    }

    public void setFlagExAsInSize5(Long flagExAsInSize5) {
        this.flagExAsInSize5 = flagExAsInSize5;
    }

    public Long getFlagExAsOutSize5() {
        return flagExAsOutSize5;
    }

    public void setFlagExAsOutSize5(Long flagExAsOutSize5) {
        this.flagExAsOutSize5 = flagExAsOutSize5;
    }

    public Long getFlagExAsInSize6() {
        return flagExAsInSize6;
    }

    public void setFlagExAsInSize6(Long flagExAsInSize6) {
        this.flagExAsInSize6 = flagExAsInSize6;
    }

    public Long getFlagExAsOutSize6() {
        return flagExAsOutSize6;
    }

    public void setFlagExAsOutSize6(Long flagExAsOutSize6) {
        this.flagExAsOutSize6 = flagExAsOutSize6;
    }

    public Long getFlagExAsInSize7() {
        return flagExAsInSize7;
    }

    public void setFlagExAsInSize7(Long flagExAsInSize7) {
        this.flagExAsInSize7 = flagExAsInSize7;
    }

    public Long getFlagExAsOutSize7() {
        return flagExAsOutSize7;
    }

    public void setFlagExAsOutSize7(Long flagExAsOutSize7) {
        this.flagExAsOutSize7 = flagExAsOutSize7;
    }

    public Long getFlagExAsInSize8() {
        return flagExAsInSize8;
    }

    public void setFlagExAsInSize8(Long flagExAsInSize8) {
        this.flagExAsInSize8 = flagExAsInSize8;
    }

    public Long getFlagExAsOutSize8() {
        return flagExAsOutSize8;
    }

    public void setFlagExAsOutSize8(Long flagExAsOutSize8) {
        this.flagExAsOutSize8 = flagExAsOutSize8;
    }

    public Long getFlagExAsInSize9() {
        return flagExAsInSize9;
    }

    public void setFlagExAsInSize9(Long flagExAsInSize9) {
        this.flagExAsInSize9 = flagExAsInSize9;
    }

    public Long getFlagExAsOutSize9() {
        return flagExAsOutSize9;
    }

    public void setFlagExAsOutSize9(Long flagExAsOutSize9) {
        this.flagExAsOutSize9 = flagExAsOutSize9;
    }

    public Long getFlagExAsInSize10() {
        return flagExAsInSize10;
    }

    public void setFlagExAsInSize10(Long flagExAsInSize10) {
        this.flagExAsInSize10 = flagExAsInSize10;
    }

    public Long getFlagExAsOutSize10() {
        return flagExAsOutSize10;
    }

    public void setFlagExAsOutSize10(Long flagExAsOutSize10) {
        this.flagExAsOutSize10 = flagExAsOutSize10;
    }

    public Long getFlagExAsInSize11() {
        return flagExAsInSize11;
    }

    public void setFlagExAsInSize11(Long flagExAsInSize11) {
        this.flagExAsInSize11 = flagExAsInSize11;
    }

    public Long getFlagExAsOutSize11() {
        return flagExAsOutSize11;
    }

    public void setFlagExAsOutSize11(Long flagExAsOutSize11) {
        this.flagExAsOutSize11 = flagExAsOutSize11;
    }

    public Long getFlagExAsInSize12() {
        return flagExAsInSize12;
    }

    public void setFlagExAsInSize12(Long flagExAsInSize12) {
        this.flagExAsInSize12 = flagExAsInSize12;
    }

    public Long getFlagExAsOutSize12() {
        return flagExAsOutSize12;
    }

    public void setFlagExAsOutSize12(Long flagExAsOutSize12) {
        this.flagExAsOutSize12 = flagExAsOutSize12;
    }

    public Long getFlagExAsInSize13() {
        return flagExAsInSize13;
    }

    public void setFlagExAsInSize13(Long flagExAsInSize13) {
        this.flagExAsInSize13 = flagExAsInSize13;
    }

    public Long getFlagExAsOutSize13() {
        return flagExAsOutSize13;
    }

    public void setFlagExAsOutSize13(Long flagExAsOutSize13) {
        this.flagExAsOutSize13 = flagExAsOutSize13;
    }

    public Long getFlagExAsInSize14() {
        return flagExAsInSize14;
    }

    public void setFlagExAsInSize14(Long flagExAsInSize14) {
        this.flagExAsInSize14 = flagExAsInSize14;
    }

    public Long getFlagExAsOutSize14() {
        return flagExAsOutSize14;
    }

    public void setFlagExAsOutSize14(Long flagExAsOutSize14) {
        this.flagExAsOutSize14 = flagExAsOutSize14;
    }

    public Long getFlagExAsInSize15() {
        return flagExAsInSize15;
    }

    public void setFlagExAsInSize15(Long flagExAsInSize15) {
        this.flagExAsInSize15 = flagExAsInSize15;
    }

    public Long getFlagExAsOutSize15() {
        return flagExAsOutSize15;
    }

    public void setFlagExAsOutSize15(Long flagExAsOutSize15) {
        this.flagExAsOutSize15 = flagExAsOutSize15;
    }

    public Long getFlagExAsInSize16() {
        return flagExAsInSize16;
    }

    public void setFlagExAsInSize16(Long flagExAsInSize16) {
        this.flagExAsInSize16 = flagExAsInSize16;
    }

    public Long getFlagExAsOutSize16() {
        return flagExAsOutSize16;
    }

    public void setFlagExAsOutSize16(Long flagExAsOutSize16) {
        this.flagExAsOutSize16 = flagExAsOutSize16;
    }

    public Long getFlagExAsInSize17() {
        return flagExAsInSize17;
    }

    public void setFlagExAsInSize17(Long flagExAsInSize17) {
        this.flagExAsInSize17 = flagExAsInSize17;
    }

    public Long getFlagExAsOutSize17() {
        return flagExAsOutSize17;
    }

    public void setFlagExAsOutSize17(Long flagExAsOutSize17) {
        this.flagExAsOutSize17 = flagExAsOutSize17;
    }

    public Long getFlagExAsInSize18() {
        return flagExAsInSize18;
    }

    public void setFlagExAsInSize18(Long flagExAsInSize18) {
        this.flagExAsInSize18 = flagExAsInSize18;
    }

    public Long getFlagExAsOutSize18() {
        return flagExAsOutSize18;
    }

    public void setFlagExAsOutSize18(Long flagExAsOutSize18) {
        this.flagExAsOutSize18 = flagExAsOutSize18;
    }

    public Long getFlagExAsInSize1T() {
        return flagExAsInSize1T;
    }

    public void setFlagExAsInSize1T(Long flagExAsInSize1T) {
        this.flagExAsInSize1T = flagExAsInSize1T;
    }

    public Long getFlagExAsOutSize1T() {
        return flagExAsOutSize1T;
    }

    public void setFlagExAsOutSize1T(Long flagExAsOutSize1T) {
        this.flagExAsOutSize1T = flagExAsOutSize1T;
    }

    public Long getFlagExAsInSize2T() {
        return flagExAsInSize2T;
    }

    public void setFlagExAsInSize2T(Long flagExAsInSize2T) {
        this.flagExAsInSize2T = flagExAsInSize2T;
    }

    public Long getFlagExAsOutSize2T() {
        return flagExAsOutSize2T;
    }

    public void setFlagExAsOutSize2T(Long flagExAsOutSize2T) {
        this.flagExAsOutSize2T = flagExAsOutSize2T;
    }

    public Long getFlagExAsInSize3T() {
        return flagExAsInSize3T;
    }

    public void setFlagExAsInSize3T(Long flagExAsInSize3T) {
        this.flagExAsInSize3T = flagExAsInSize3T;
    }

    public Long getFlagExAsOutSize3T() {
        return flagExAsOutSize3T;
    }

    public void setFlagExAsOutSize3T(Long flagExAsOutSize3T) {
        this.flagExAsOutSize3T = flagExAsOutSize3T;
    }

    public Long getFlagExAsInSize4T() {
        return flagExAsInSize4T;
    }

    public void setFlagExAsInSize4T(Long flagExAsInSize4T) {
        this.flagExAsInSize4T = flagExAsInSize4T;
    }

    public Long getFlagExAsOutSize4T() {
        return flagExAsOutSize4T;
    }

    public void setFlagExAsOutSize4T(Long flagExAsOutSize4T) {
        this.flagExAsOutSize4T = flagExAsOutSize4T;
    }

    public Long getFlagExAsInSize5T() {
        return flagExAsInSize5T;
    }

    public void setFlagExAsInSize5T(Long flagExAsInSize5T) {
        this.flagExAsInSize5T = flagExAsInSize5T;
    }

    public Long getFlagExAsOutSize5T() {
        return flagExAsOutSize5T;
    }

    public void setFlagExAsOutSize5T(Long flagExAsOutSize5T) {
        this.flagExAsOutSize5T = flagExAsOutSize5T;
    }

    public Long getFlagExAsInSize6T() {
        return flagExAsInSize6T;
    }

    public void setFlagExAsInSize6T(Long flagExAsInSize6T) {
        this.flagExAsInSize6T = flagExAsInSize6T;
    }

    public Long getFlagExAsOutSize6T() {
        return flagExAsOutSize6T;
    }

    public void setFlagExAsOutSize6T(Long flagExAsOutSize6T) {
        this.flagExAsOutSize6T = flagExAsOutSize6T;
    }

    public Long getFlagExAsInSize7T() {
        return flagExAsInSize7T;
    }

    public void setFlagExAsInSize7T(Long flagExAsInSize7T) {
        this.flagExAsInSize7T = flagExAsInSize7T;
    }

    public Long getFlagExAsOutSize7T() {
        return flagExAsOutSize7T;
    }

    public void setFlagExAsOutSize7T(Long flagExAsOutSize7T) {
        this.flagExAsOutSize7T = flagExAsOutSize7T;
    }

    public Long getFlagExAsInSize8T() {
        return flagExAsInSize8T;
    }

    public void setFlagExAsInSize8T(Long flagExAsInSize8T) {
        this.flagExAsInSize8T = flagExAsInSize8T;
    }

    public Long getFlagExAsOutSize8T() {
        return flagExAsOutSize8T;
    }

    public void setFlagExAsOutSize8T(Long flagExAsOutSize8T) {
        this.flagExAsOutSize8T = flagExAsOutSize8T;
    }

    public Long getFlagExAsInSize9T() {
        return flagExAsInSize9T;
    }

    public void setFlagExAsInSize9T(Long flagExAsInSize9T) {
        this.flagExAsInSize9T = flagExAsInSize9T;
    }

    public Long getFlagExAsOutSize9T() {
        return flagExAsOutSize9T;
    }

    public void setFlagExAsOutSize9T(Long flagExAsOutSize9T) {
        this.flagExAsOutSize9T = flagExAsOutSize9T;
    }

    public Long getFlagExAsInSize10T() {
        return flagExAsInSize10T;
    }

    public void setFlagExAsInSize10T(Long flagExAsInSize10T) {
        this.flagExAsInSize10T = flagExAsInSize10T;
    }

    public Long getFlagExAsOutSize10T() {
        return flagExAsOutSize10T;
    }

    public void setFlagExAsOutSize10T(Long flagExAsOutSize10T) {
        this.flagExAsOutSize10T = flagExAsOutSize10T;
    }

    public Long getFlagExAsInSize11T() {
        return flagExAsInSize11T;
    }

    public void setFlagExAsInSize11T(Long flagExAsInSize11T) {
        this.flagExAsInSize11T = flagExAsInSize11T;
    }

    public Long getFlagExAsOutSize11T() {
        return flagExAsOutSize11T;
    }

    public void setFlagExAsOutSize11T(Long flagExAsOutSize11T) {
        this.flagExAsOutSize11T = flagExAsOutSize11T;
    }

    public Long getFlagExAsInSize12T() {
        return flagExAsInSize12T;
    }

    public void setFlagExAsInSize12T(Long flagExAsInSize12T) {
        this.flagExAsInSize12T = flagExAsInSize12T;
    }

    public Long getFlagExAsOutSize12T() {
        return flagExAsOutSize12T;
    }

    public void setFlagExAsOutSize12T(Long flagExAsOutSize12T) {
        this.flagExAsOutSize12T = flagExAsOutSize12T;
    }

    public Long getFlagExAsInSize13T() {
        return flagExAsInSize13T;
    }

    public void setFlagExAsInSize13T(Long flagExAsInSize13T) {
        this.flagExAsInSize13T = flagExAsInSize13T;
    }

    public Long getFlagExAsOutSize13T() {
        return flagExAsOutSize13T;
    }

    public void setFlagExAsOutSize13T(Long flagExAsOutSize13T) {
        this.flagExAsOutSize13T = flagExAsOutSize13T;
    }

    public Long getFlagExCscInSize1() {
        return flagExCscInSize1;
    }

    public void setFlagExCscInSize1(Long flagExCscInSize1) {
        this.flagExCscInSize1 = flagExCscInSize1;
    }

    public Long getFlagExCscOutSize1() {
        return flagExCscOutSize1;
    }

    public void setFlagExCscOutSize1(Long flagExCscOutSize1) {
        this.flagExCscOutSize1 = flagExCscOutSize1;
    }

    public Long getFlagExCscInSize2() {
        return flagExCscInSize2;
    }

    public void setFlagExCscInSize2(Long flagExCscInSize2) {
        this.flagExCscInSize2 = flagExCscInSize2;
    }

    public Long getFlagExCscOutSize2() {
        return flagExCscOutSize2;
    }

    public void setFlagExCscOutSize2(Long flagExCscOutSize2) {
        this.flagExCscOutSize2 = flagExCscOutSize2;
    }

    public Long getFlagExCscInSize3() {
        return flagExCscInSize3;
    }

    public void setFlagExCscInSize3(Long flagExCscInSize3) {
        this.flagExCscInSize3 = flagExCscInSize3;
    }

    public Long getFlagExCscOutSize3() {
        return flagExCscOutSize3;
    }

    public void setFlagExCscOutSize3(Long flagExCscOutSize3) {
        this.flagExCscOutSize3 = flagExCscOutSize3;
    }

    public Long getFlagExCscInSize4() {
        return flagExCscInSize4;
    }

    public void setFlagExCscInSize4(Long flagExCscInSize4) {
        this.flagExCscInSize4 = flagExCscInSize4;
    }

    public Long getFlagExCscOutSize4() {
        return flagExCscOutSize4;
    }

    public void setFlagExCscOutSize4(Long flagExCscOutSize4) {
        this.flagExCscOutSize4 = flagExCscOutSize4;
    }

    public Long getFlagExCscInSize5() {
        return flagExCscInSize5;
    }

    public void setFlagExCscInSize5(Long flagExCscInSize5) {
        this.flagExCscInSize5 = flagExCscInSize5;
    }

    public Long getFlagExCscOutSize5() {
        return flagExCscOutSize5;
    }

    public void setFlagExCscOutSize5(Long flagExCscOutSize5) {
        this.flagExCscOutSize5 = flagExCscOutSize5;
    }

    public Long getFlagExCscInSize6() {
        return flagExCscInSize6;
    }

    public void setFlagExCscInSize6(Long flagExCscInSize6) {
        this.flagExCscInSize6 = flagExCscInSize6;
    }

    public Long getFlagExCscOutSize6() {
        return flagExCscOutSize6;
    }

    public void setFlagExCscOutSize6(Long flagExCscOutSize6) {
        this.flagExCscOutSize6 = flagExCscOutSize6;
    }

    public Long getFlagExCscInSize7() {
        return flagExCscInSize7;
    }

    public void setFlagExCscInSize7(Long flagExCscInSize7) {
        this.flagExCscInSize7 = flagExCscInSize7;
    }

    public Long getFlagExCscOutSize7() {
        return flagExCscOutSize7;
    }

    public void setFlagExCscOutSize7(Long flagExCscOutSize7) {
        this.flagExCscOutSize7 = flagExCscOutSize7;
    }

    public Long getFlagExCscInSize8() {
        return flagExCscInSize8;
    }

    public void setFlagExCscInSize8(Long flagExCscInSize8) {
        this.flagExCscInSize8 = flagExCscInSize8;
    }

    public Long getFlagExCscOutSize8() {
        return flagExCscOutSize8;
    }

    public void setFlagExCscOutSize8(Long flagExCscOutSize8) {
        this.flagExCscOutSize8 = flagExCscOutSize8;
    }

    public Long getFlagExCscInSize9() {
        return flagExCscInSize9;
    }

    public void setFlagExCscInSize9(Long flagExCscInSize9) {
        this.flagExCscInSize9 = flagExCscInSize9;
    }

    public Long getFlagExCscOutSize9() {
        return flagExCscOutSize9;
    }

    public void setFlagExCscOutSize9(Long flagExCscOutSize9) {
        this.flagExCscOutSize9 = flagExCscOutSize9;
    }

    public Long getFlagExCscInSize10() {
        return flagExCscInSize10;
    }

    public void setFlagExCscInSize10(Long flagExCscInSize10) {
        this.flagExCscInSize10 = flagExCscInSize10;
    }

    public Long getFlagExCscOutSize10() {
        return flagExCscOutSize10;
    }

    public void setFlagExCscOutSize10(Long flagExCscOutSize10) {
        this.flagExCscOutSize10 = flagExCscOutSize10;
    }

    public Long getFlagExCscInSize11() {
        return flagExCscInSize11;
    }

    public void setFlagExCscInSize11(Long flagExCscInSize11) {
        this.flagExCscInSize11 = flagExCscInSize11;
    }

    public Long getFlagExCscOutSize11() {
        return flagExCscOutSize11;
    }

    public void setFlagExCscOutSize11(Long flagExCscOutSize11) {
        this.flagExCscOutSize11 = flagExCscOutSize11;
    }

    public Long getFlagExCscInSize12() {
        return flagExCscInSize12;
    }

    public void setFlagExCscInSize12(Long flagExCscInSize12) {
        this.flagExCscInSize12 = flagExCscInSize12;
    }

    public Long getFlagExCscOutSize12() {
        return flagExCscOutSize12;
    }

    public void setFlagExCscOutSize12(Long flagExCscOutSize12) {
        this.flagExCscOutSize12 = flagExCscOutSize12;
    }

    public Long getFlagExCscInSize13() {
        return flagExCscInSize13;
    }

    public void setFlagExCscInSize13(Long flagExCscInSize13) {
        this.flagExCscInSize13 = flagExCscInSize13;
    }

    public Long getFlagExCscOutSize13() {
        return flagExCscOutSize13;
    }

    public void setFlagExCscOutSize13(Long flagExCscOutSize13) {
        this.flagExCscOutSize13 = flagExCscOutSize13;
    }

    public Long getFlagExCscInSize14() {
        return flagExCscInSize14;
    }

    public void setFlagExCscInSize14(Long flagExCscInSize14) {
        this.flagExCscInSize14 = flagExCscInSize14;
    }

    public Long getFlagExCscOutSize14() {
        return flagExCscOutSize14;
    }

    public void setFlagExCscOutSize14(Long flagExCscOutSize14) {
        this.flagExCscOutSize14 = flagExCscOutSize14;
    }

    public Long getFlagExCscInSize15() {
        return flagExCscInSize15;
    }

    public void setFlagExCscInSize15(Long flagExCscInSize15) {
        this.flagExCscInSize15 = flagExCscInSize15;
    }

    public Long getFlagExCscOutSize15() {
        return flagExCscOutSize15;
    }

    public void setFlagExCscOutSize15(Long flagExCscOutSize15) {
        this.flagExCscOutSize15 = flagExCscOutSize15;
    }

    public Long getFlagExCscInSize16() {
        return flagExCscInSize16;
    }

    public void setFlagExCscInSize16(Long flagExCscInSize16) {
        this.flagExCscInSize16 = flagExCscInSize16;
    }

    public Long getFlagExCscOutSize16() {
        return flagExCscOutSize16;
    }

    public void setFlagExCscOutSize16(Long flagExCscOutSize16) {
        this.flagExCscOutSize16 = flagExCscOutSize16;
    }

    public Long getFlagExCscInSize17() {
        return flagExCscInSize17;
    }

    public void setFlagExCscInSize17(Long flagExCscInSize17) {
        this.flagExCscInSize17 = flagExCscInSize17;
    }

    public Long getFlagExCscOutSize17() {
        return flagExCscOutSize17;
    }

    public void setFlagExCscOutSize17(Long flagExCscOutSize17) {
        this.flagExCscOutSize17 = flagExCscOutSize17;
    }

    public Long getFlagExCscInSize18() {
        return flagExCscInSize18;
    }

    public void setFlagExCscInSize18(Long flagExCscInSize18) {
        this.flagExCscInSize18 = flagExCscInSize18;
    }

    public Long getFlagExCscOutSize18() {
        return flagExCscOutSize18;
    }

    public void setFlagExCscOutSize18(Long flagExCscOutSize18) {
        this.flagExCscOutSize18 = flagExCscOutSize18;
    }

    public Long getFlagExCscInSize1T() {
        return flagExCscInSize1T;
    }

    public void setFlagExCscInSize1T(Long flagExCscInSize1T) {
        this.flagExCscInSize1T = flagExCscInSize1T;
    }

    public Long getFlagExCscOutSize1T() {
        return flagExCscOutSize1T;
    }

    public void setFlagExCscOutSize1T(Long flagExCscOutSize1T) {
        this.flagExCscOutSize1T = flagExCscOutSize1T;
    }

    public Long getFlagExCscInSize2T() {
        return flagExCscInSize2T;
    }

    public void setFlagExCscInSize2T(Long flagExCscInSize2T) {
        this.flagExCscInSize2T = flagExCscInSize2T;
    }

    public Long getFlagExCscOutSize2T() {
        return flagExCscOutSize2T;
    }

    public void setFlagExCscOutSize2T(Long flagExCscOutSize2T) {
        this.flagExCscOutSize2T = flagExCscOutSize2T;
    }

    public Long getFlagExCscInSize3T() {
        return flagExCscInSize3T;
    }

    public void setFlagExCscInSize3T(Long flagExCscInSize3T) {
        this.flagExCscInSize3T = flagExCscInSize3T;
    }

    public Long getFlagExCscOutSize3T() {
        return flagExCscOutSize3T;
    }

    public void setFlagExCscOutSize3T(Long flagExCscOutSize3T) {
        this.flagExCscOutSize3T = flagExCscOutSize3T;
    }

    public Long getFlagExCscInSize4T() {
        return flagExCscInSize4T;
    }

    public void setFlagExCscInSize4T(Long flagExCscInSize4T) {
        this.flagExCscInSize4T = flagExCscInSize4T;
    }

    public Long getFlagExCscOutSize4T() {
        return flagExCscOutSize4T;
    }

    public void setFlagExCscOutSize4T(Long flagExCscOutSize4T) {
        this.flagExCscOutSize4T = flagExCscOutSize4T;
    }

    public Long getFlagExCscInSize5T() {
        return flagExCscInSize5T;
    }

    public void setFlagExCscInSize5T(Long flagExCscInSize5T) {
        this.flagExCscInSize5T = flagExCscInSize5T;
    }

    public Long getFlagExCscOutSize5T() {
        return flagExCscOutSize5T;
    }

    public void setFlagExCscOutSize5T(Long flagExCscOutSize5T) {
        this.flagExCscOutSize5T = flagExCscOutSize5T;
    }

    public Long getFlagExCscInSize6T() {
        return flagExCscInSize6T;
    }

    public void setFlagExCscInSize6T(Long flagExCscInSize6T) {
        this.flagExCscInSize6T = flagExCscInSize6T;
    }

    public Long getFlagExCscOutSize6T() {
        return flagExCscOutSize6T;
    }

    public void setFlagExCscOutSize6T(Long flagExCscOutSize6T) {
        this.flagExCscOutSize6T = flagExCscOutSize6T;
    }

    public Long getFlagExCscInSize7T() {
        return flagExCscInSize7T;
    }

    public void setFlagExCscInSize7T(Long flagExCscInSize7T) {
        this.flagExCscInSize7T = flagExCscInSize7T;
    }

    public Long getFlagExCscOutSize7T() {
        return flagExCscOutSize7T;
    }

    public void setFlagExCscOutSize7T(Long flagExCscOutSize7T) {
        this.flagExCscOutSize7T = flagExCscOutSize7T;
    }

    public Long getFlagExCscInSize8T() {
        return flagExCscInSize8T;
    }

    public void setFlagExCscInSize8T(Long flagExCscInSize8T) {
        this.flagExCscInSize8T = flagExCscInSize8T;
    }

    public Long getFlagExCscOutSize8T() {
        return flagExCscOutSize8T;
    }

    public void setFlagExCscOutSize8T(Long flagExCscOutSize8T) {
        this.flagExCscOutSize8T = flagExCscOutSize8T;
    }

    public Long getFlagExCscInSize9T() {
        return flagExCscInSize9T;
    }

    public void setFlagExCscInSize9T(Long flagExCscInSize9T) {
        this.flagExCscInSize9T = flagExCscInSize9T;
    }

    public Long getFlagExCscOutSize9T() {
        return flagExCscOutSize9T;
    }

    public void setFlagExCscOutSize9T(Long flagExCscOutSize9T) {
        this.flagExCscOutSize9T = flagExCscOutSize9T;
    }

    public Long getFlagExCscInSize10T() {
        return flagExCscInSize10T;
    }

    public void setFlagExCscInSize10T(Long flagExCscInSize10T) {
        this.flagExCscInSize10T = flagExCscInSize10T;
    }

    public Long getFlagExCscOutSize10T() {
        return flagExCscOutSize10T;
    }

    public void setFlagExCscOutSize10T(Long flagExCscOutSize10T) {
        this.flagExCscOutSize10T = flagExCscOutSize10T;
    }

    public Long getFlagExCscInSize11T() {
        return flagExCscInSize11T;
    }

    public void setFlagExCscInSize11T(Long flagExCscInSize11T) {
        this.flagExCscInSize11T = flagExCscInSize11T;
    }

    public Long getFlagExCscOutSize11T() {
        return flagExCscOutSize11T;
    }

    public void setFlagExCscOutSize11T(Long flagExCscOutSize11T) {
        this.flagExCscOutSize11T = flagExCscOutSize11T;
    }

    public Long getFlagExCscInSize12T() {
        return flagExCscInSize12T;
    }

    public void setFlagExCscInSize12T(Long flagExCscInSize12T) {
        this.flagExCscInSize12T = flagExCscInSize12T;
    }

    public Long getFlagExCscOutSize12T() {
        return flagExCscOutSize12T;
    }

    public void setFlagExCscOutSize12T(Long flagExCscOutSize12T) {
        this.flagExCscOutSize12T = flagExCscOutSize12T;
    }

    public Long getFlagExCscInSize13T() {
        return flagExCscInSize13T;
    }

    public void setFlagExCscInSize13T(Long flagExCscInSize13T) {
        this.flagExCscInSize13T = flagExCscInSize13T;
    }

    public Long getFlagExCscOutSize13T() {
        return flagExCscOutSize13T;
    }

    public void setFlagExCscOutSize13T(Long flagExCscOutSize13T) {
        this.flagExCscOutSize13T = flagExCscOutSize13T;
    }

    public Long getFlagExNsInSize1() {
        return flagExNsInSize1;
    }

    public void setFlagExNsInSize1(Long flagExNsInSize1) {
        this.flagExNsInSize1 = flagExNsInSize1;
    }

    public Long getFlagExNsOutSize1() {
        return flagExNsOutSize1;
    }

    public void setFlagExNsOutSize1(Long flagExNsOutSize1) {
        this.flagExNsOutSize1 = flagExNsOutSize1;
    }

    public Long getFlagExNsInSize2() {
        return flagExNsInSize2;
    }

    public void setFlagExNsInSize2(Long flagExNsInSize2) {
        this.flagExNsInSize2 = flagExNsInSize2;
    }

    public Long getFlagExNsOutSize2() {
        return flagExNsOutSize2;
    }

    public void setFlagExNsOutSize2(Long flagExNsOutSize2) {
        this.flagExNsOutSize2 = flagExNsOutSize2;
    }

    public Long getFlagExNsInSize3() {
        return flagExNsInSize3;
    }

    public void setFlagExNsInSize3(Long flagExNsInSize3) {
        this.flagExNsInSize3 = flagExNsInSize3;
    }

    public Long getFlagExNsOutSize3() {
        return flagExNsOutSize3;
    }

    public void setFlagExNsOutSize3(Long flagExNsOutSize3) {
        this.flagExNsOutSize3 = flagExNsOutSize3;
    }

    public Long getFlagExNsInSize4() {
        return flagExNsInSize4;
    }

    public void setFlagExNsInSize4(Long flagExNsInSize4) {
        this.flagExNsInSize4 = flagExNsInSize4;
    }

    public Long getFlagExNsOutSize4() {
        return flagExNsOutSize4;
    }

    public void setFlagExNsOutSize4(Long flagExNsOutSize4) {
        this.flagExNsOutSize4 = flagExNsOutSize4;
    }

    public Long getFlagExNsInSize5() {
        return flagExNsInSize5;
    }

    public void setFlagExNsInSize5(Long flagExNsInSize5) {
        this.flagExNsInSize5 = flagExNsInSize5;
    }

    public Long getFlagExNsOutSize5() {
        return flagExNsOutSize5;
    }

    public void setFlagExNsOutSize5(Long flagExNsOutSize5) {
        this.flagExNsOutSize5 = flagExNsOutSize5;
    }

    public Long getFlagExNsInSize6() {
        return flagExNsInSize6;
    }

    public void setFlagExNsInSize6(Long flagExNsInSize6) {
        this.flagExNsInSize6 = flagExNsInSize6;
    }

    public Long getFlagExNsOutSize6() {
        return flagExNsOutSize6;
    }

    public void setFlagExNsOutSize6(Long flagExNsOutSize6) {
        this.flagExNsOutSize6 = flagExNsOutSize6;
    }

    public Long getFlagExNsInSize7() {
        return flagExNsInSize7;
    }

    public void setFlagExNsInSize7(Long flagExNsInSize7) {
        this.flagExNsInSize7 = flagExNsInSize7;
    }

    public Long getFlagExNsOutSize7() {
        return flagExNsOutSize7;
    }

    public void setFlagExNsOutSize7(Long flagExNsOutSize7) {
        this.flagExNsOutSize7 = flagExNsOutSize7;
    }

    public Long getFlagExNsInSize8() {
        return flagExNsInSize8;
    }

    public void setFlagExNsInSize8(Long flagExNsInSize8) {
        this.flagExNsInSize8 = flagExNsInSize8;
    }

    public Long getFlagExNsOutSize8() {
        return flagExNsOutSize8;
    }

    public void setFlagExNsOutSize8(Long flagExNsOutSize8) {
        this.flagExNsOutSize8 = flagExNsOutSize8;
    }

    public Long getFlagExNsInSize9() {
        return flagExNsInSize9;
    }

    public void setFlagExNsInSize9(Long flagExNsInSize9) {
        this.flagExNsInSize9 = flagExNsInSize9;
    }

    public Long getFlagExNsOutSize9() {
        return flagExNsOutSize9;
    }

    public void setFlagExNsOutSize9(Long flagExNsOutSize9) {
        this.flagExNsOutSize9 = flagExNsOutSize9;
    }

    public Long getFlagExNsInSize10() {
        return flagExNsInSize10;
    }

    public void setFlagExNsInSize10(Long flagExNsInSize10) {
        this.flagExNsInSize10 = flagExNsInSize10;
    }

    public Long getFlagExNsOutSize10() {
        return flagExNsOutSize10;
    }

    public void setFlagExNsOutSize10(Long flagExNsOutSize10) {
        this.flagExNsOutSize10 = flagExNsOutSize10;
    }

    public Long getFlagExNsInSize11() {
        return flagExNsInSize11;
    }

    public void setFlagExNsInSize11(Long flagExNsInSize11) {
        this.flagExNsInSize11 = flagExNsInSize11;
    }

    public Long getFlagExNsOutSize11() {
        return flagExNsOutSize11;
    }

    public void setFlagExNsOutSize11(Long flagExNsOutSize11) {
        this.flagExNsOutSize11 = flagExNsOutSize11;
    }

    public Long getFlagExNsInSize12() {
        return flagExNsInSize12;
    }

    public void setFlagExNsInSize12(Long flagExNsInSize12) {
        this.flagExNsInSize12 = flagExNsInSize12;
    }

    public Long getFlagExNsOutSize12() {
        return flagExNsOutSize12;
    }

    public void setFlagExNsOutSize12(Long flagExNsOutSize12) {
        this.flagExNsOutSize12 = flagExNsOutSize12;
    }

    public Long getFlagExNsInSize13() {
        return flagExNsInSize13;
    }

    public void setFlagExNsInSize13(Long flagExNsInSize13) {
        this.flagExNsInSize13 = flagExNsInSize13;
    }

    public Long getFlagExNsOutSize13() {
        return flagExNsOutSize13;
    }

    public void setFlagExNsOutSize13(Long flagExNsOutSize13) {
        this.flagExNsOutSize13 = flagExNsOutSize13;
    }

    public Long getFlagExNsInSize14() {
        return flagExNsInSize14;
    }

    public void setFlagExNsInSize14(Long flagExNsInSize14) {
        this.flagExNsInSize14 = flagExNsInSize14;
    }

    public Long getFlagExNsOutSize14() {
        return flagExNsOutSize14;
    }

    public void setFlagExNsOutSize14(Long flagExNsOutSize14) {
        this.flagExNsOutSize14 = flagExNsOutSize14;
    }

    public Long getFlagExNsInSize15() {
        return flagExNsInSize15;
    }

    public void setFlagExNsInSize15(Long flagExNsInSize15) {
        this.flagExNsInSize15 = flagExNsInSize15;
    }

    public Long getFlagExNsOutSize15() {
        return flagExNsOutSize15;
    }

    public void setFlagExNsOutSize15(Long flagExNsOutSize15) {
        this.flagExNsOutSize15 = flagExNsOutSize15;
    }

    public Long getFlagExNsInSize16() {
        return flagExNsInSize16;
    }

    public void setFlagExNsInSize16(Long flagExNsInSize16) {
        this.flagExNsInSize16 = flagExNsInSize16;
    }

    public Long getFlagExNsOutSize16() {
        return flagExNsOutSize16;
    }

    public void setFlagExNsOutSize16(Long flagExNsOutSize16) {
        this.flagExNsOutSize16 = flagExNsOutSize16;
    }

    public Long getFlagExNsInSize17() {
        return flagExNsInSize17;
    }

    public void setFlagExNsInSize17(Long flagExNsInSize17) {
        this.flagExNsInSize17 = flagExNsInSize17;
    }

    public Long getFlagExNsOutSize17() {
        return flagExNsOutSize17;
    }

    public void setFlagExNsOutSize17(Long flagExNsOutSize17) {
        this.flagExNsOutSize17 = flagExNsOutSize17;
    }

    public Long getFlagExNsInSize18() {
        return flagExNsInSize18;
    }

    public void setFlagExNsInSize18(Long flagExNsInSize18) {
        this.flagExNsInSize18 = flagExNsInSize18;
    }

    public Long getFlagExNsOutSize18() {
        return flagExNsOutSize18;
    }

    public void setFlagExNsOutSize18(Long flagExNsOutSize18) {
        this.flagExNsOutSize18 = flagExNsOutSize18;
    }

    public Long getFlagExNsInSize1T() {
        return flagExNsInSize1T;
    }

    public void setFlagExNsInSize1T(Long flagExNsInSize1T) {
        this.flagExNsInSize1T = flagExNsInSize1T;
    }

    public Long getFlagExNsOutSize1T() {
        return flagExNsOutSize1T;
    }

    public void setFlagExNsOutSize1T(Long flagExNsOutSize1T) {
        this.flagExNsOutSize1T = flagExNsOutSize1T;
    }

    public Long getFlagExNsInSize2T() {
        return flagExNsInSize2T;
    }

    public void setFlagExNsInSize2T(Long flagExNsInSize2T) {
        this.flagExNsInSize2T = flagExNsInSize2T;
    }

    public Long getFlagExNsOutSize2T() {
        return flagExNsOutSize2T;
    }

    public void setFlagExNsOutSize2T(Long flagExNsOutSize2T) {
        this.flagExNsOutSize2T = flagExNsOutSize2T;
    }

    public Long getFlagExNsInSize3T() {
        return flagExNsInSize3T;
    }

    public void setFlagExNsInSize3T(Long flagExNsInSize3T) {
        this.flagExNsInSize3T = flagExNsInSize3T;
    }

    public Long getFlagExNsOutSize3T() {
        return flagExNsOutSize3T;
    }

    public void setFlagExNsOutSize3T(Long flagExNsOutSize3T) {
        this.flagExNsOutSize3T = flagExNsOutSize3T;
    }

    public Long getFlagExNsInSize4T() {
        return flagExNsInSize4T;
    }

    public void setFlagExNsInSize4T(Long flagExNsInSize4T) {
        this.flagExNsInSize4T = flagExNsInSize4T;
    }

    public Long getFlagExNsOutSize4T() {
        return flagExNsOutSize4T;
    }

    public void setFlagExNsOutSize4T(Long flagExNsOutSize4T) {
        this.flagExNsOutSize4T = flagExNsOutSize4T;
    }

    public Long getFlagExNsInSize5T() {
        return flagExNsInSize5T;
    }

    public void setFlagExNsInSize5T(Long flagExNsInSize5T) {
        this.flagExNsInSize5T = flagExNsInSize5T;
    }

    public Long getFlagExNsOutSize5T() {
        return flagExNsOutSize5T;
    }

    public void setFlagExNsOutSize5T(Long flagExNsOutSize5T) {
        this.flagExNsOutSize5T = flagExNsOutSize5T;
    }

    public Long getFlagExNsInSize6T() {
        return flagExNsInSize6T;
    }

    public void setFlagExNsInSize6T(Long flagExNsInSize6T) {
        this.flagExNsInSize6T = flagExNsInSize6T;
    }

    public Long getFlagExNsOutSize6T() {
        return flagExNsOutSize6T;
    }

    public void setFlagExNsOutSize6T(Long flagExNsOutSize6T) {
        this.flagExNsOutSize6T = flagExNsOutSize6T;
    }

    public Long getFlagExNsInSize7T() {
        return flagExNsInSize7T;
    }

    public void setFlagExNsInSize7T(Long flagExNsInSize7T) {
        this.flagExNsInSize7T = flagExNsInSize7T;
    }

    public Long getFlagExNsOutSize7T() {
        return flagExNsOutSize7T;
    }

    public void setFlagExNsOutSize7T(Long flagExNsOutSize7T) {
        this.flagExNsOutSize7T = flagExNsOutSize7T;
    }

    public Long getFlagExNsInSize8T() {
        return flagExNsInSize8T;
    }

    public void setFlagExNsInSize8T(Long flagExNsInSize8T) {
        this.flagExNsInSize8T = flagExNsInSize8T;
    }

    public Long getFlagExNsOutSize8T() {
        return flagExNsOutSize8T;
    }

    public void setFlagExNsOutSize8T(Long flagExNsOutSize8T) {
        this.flagExNsOutSize8T = flagExNsOutSize8T;
    }

    public Long getFlagExNsInSize9T() {
        return flagExNsInSize9T;
    }

    public void setFlagExNsInSize9T(Long flagExNsInSize9T) {
        this.flagExNsInSize9T = flagExNsInSize9T;
    }

    public Long getFlagExNsOutSize9T() {
        return flagExNsOutSize9T;
    }

    public void setFlagExNsOutSize9T(Long flagExNsOutSize9T) {
        this.flagExNsOutSize9T = flagExNsOutSize9T;
    }

    public Long getFlagExNsInSize10T() {
        return flagExNsInSize10T;
    }

    public void setFlagExNsInSize10T(Long flagExNsInSize10T) {
        this.flagExNsInSize10T = flagExNsInSize10T;
    }

    public Long getFlagExNsOutSize10T() {
        return flagExNsOutSize10T;
    }

    public void setFlagExNsOutSize10T(Long flagExNsOutSize10T) {
        this.flagExNsOutSize10T = flagExNsOutSize10T;
    }

    public Long getFlagExNsInSize11T() {
        return flagExNsInSize11T;
    }

    public void setFlagExNsInSize11T(Long flagExNsInSize11T) {
        this.flagExNsInSize11T = flagExNsInSize11T;
    }

    public Long getFlagExNsOutSize11T() {
        return flagExNsOutSize11T;
    }

    public void setFlagExNsOutSize11T(Long flagExNsOutSize11T) {
        this.flagExNsOutSize11T = flagExNsOutSize11T;
    }

    public Long getFlagExNsInSize12T() {
        return flagExNsInSize12T;
    }

    public void setFlagExNsInSize12T(Long flagExNsInSize12T) {
        this.flagExNsInSize12T = flagExNsInSize12T;
    }

    public Long getFlagExNsOutSize12T() {
        return flagExNsOutSize12T;
    }

    public void setFlagExNsOutSize12T(Long flagExNsOutSize12T) {
        this.flagExNsOutSize12T = flagExNsOutSize12T;
    }

    public Long getFlagExNsInSize13T() {
        return flagExNsInSize13T;
    }

    public void setFlagExNsInSize13T(Long flagExNsInSize13T) {
        this.flagExNsInSize13T = flagExNsInSize13T;
    }

    public Long getFlagExNsOutSize13T() {
        return flagExNsOutSize13T;
    }

    public void setFlagExNsOutSize13T(Long flagExNsOutSize13T) {
        this.flagExNsOutSize13T = flagExNsOutSize13T;
    }

    public Long getFlagExScInSize1() {
        return flagExScInSize1;
    }

    public void setFlagExScInSize1(Long flagExScInSize1) {
        this.flagExScInSize1 = flagExScInSize1;
    }

    public Long getFlagExScOutSize1() {
        return flagExScOutSize1;
    }

    public void setFlagExScOutSize1(Long flagExScOutSize1) {
        this.flagExScOutSize1 = flagExScOutSize1;
    }

    public Long getFlagExScInSize2() {
        return flagExScInSize2;
    }

    public void setFlagExScInSize2(Long flagExScInSize2) {
        this.flagExScInSize2 = flagExScInSize2;
    }

    public Long getFlagExScOutSize2() {
        return flagExScOutSize2;
    }

    public void setFlagExScOutSize2(Long flagExScOutSize2) {
        this.flagExScOutSize2 = flagExScOutSize2;
    }

    public Long getFlagExScInSize3() {
        return flagExScInSize3;
    }

    public void setFlagExScInSize3(Long flagExScInSize3) {
        this.flagExScInSize3 = flagExScInSize3;
    }

    public Long getFlagExScOutSize3() {
        return flagExScOutSize3;
    }

    public void setFlagExScOutSize3(Long flagExScOutSize3) {
        this.flagExScOutSize3 = flagExScOutSize3;
    }

    public Long getFlagExScInSize4() {
        return flagExScInSize4;
    }

    public void setFlagExScInSize4(Long flagExScInSize4) {
        this.flagExScInSize4 = flagExScInSize4;
    }

    public Long getFlagExScOutSize4() {
        return flagExScOutSize4;
    }

    public void setFlagExScOutSize4(Long flagExScOutSize4) {
        this.flagExScOutSize4 = flagExScOutSize4;
    }

    public Long getFlagExScInSize5() {
        return flagExScInSize5;
    }

    public void setFlagExScInSize5(Long flagExScInSize5) {
        this.flagExScInSize5 = flagExScInSize5;
    }

    public Long getFlagExScOutSize5() {
        return flagExScOutSize5;
    }

    public void setFlagExScOutSize5(Long flagExScOutSize5) {
        this.flagExScOutSize5 = flagExScOutSize5;
    }

    public Long getFlagExScInSize6() {
        return flagExScInSize6;
    }

    public void setFlagExScInSize6(Long flagExScInSize6) {
        this.flagExScInSize6 = flagExScInSize6;
    }

    public Long getFlagExScOutSize6() {
        return flagExScOutSize6;
    }

    public void setFlagExScOutSize6(Long flagExScOutSize6) {
        this.flagExScOutSize6 = flagExScOutSize6;
    }

    public Long getFlagExScInSize7() {
        return flagExScInSize7;
    }

    public void setFlagExScInSize7(Long flagExScInSize7) {
        this.flagExScInSize7 = flagExScInSize7;
    }

    public Long getFlagExScOutSize7() {
        return flagExScOutSize7;
    }

    public void setFlagExScOutSize7(Long flagExScOutSize7) {
        this.flagExScOutSize7 = flagExScOutSize7;
    }

    public Long getFlagExScInSize8() {
        return flagExScInSize8;
    }

    public void setFlagExScInSize8(Long flagExScInSize8) {
        this.flagExScInSize8 = flagExScInSize8;
    }

    public Long getFlagExScOutSize8() {
        return flagExScOutSize8;
    }

    public void setFlagExScOutSize8(Long flagExScOutSize8) {
        this.flagExScOutSize8 = flagExScOutSize8;
    }

    public Long getFlagExScInSize9() {
        return flagExScInSize9;
    }

    public void setFlagExScInSize9(Long flagExScInSize9) {
        this.flagExScInSize9 = flagExScInSize9;
    }

    public Long getFlagExScOutSize9() {
        return flagExScOutSize9;
    }

    public void setFlagExScOutSize9(Long flagExScOutSize9) {
        this.flagExScOutSize9 = flagExScOutSize9;
    }

    public Long getFlagExScInSize10() {
        return flagExScInSize10;
    }

    public void setFlagExScInSize10(Long flagExScInSize10) {
        this.flagExScInSize10 = flagExScInSize10;
    }

    public Long getFlagExScOutSize10() {
        return flagExScOutSize10;
    }

    public void setFlagExScOutSize10(Long flagExScOutSize10) {
        this.flagExScOutSize10 = flagExScOutSize10;
    }

    public Long getFlagExScInSize11() {
        return flagExScInSize11;
    }

    public void setFlagExScInSize11(Long flagExScInSize11) {
        this.flagExScInSize11 = flagExScInSize11;
    }

    public Long getFlagExScOutSize11() {
        return flagExScOutSize11;
    }

    public void setFlagExScOutSize11(Long flagExScOutSize11) {
        this.flagExScOutSize11 = flagExScOutSize11;
    }

    public Long getFlagExScInSize12() {
        return flagExScInSize12;
    }

    public void setFlagExScInSize12(Long flagExScInSize12) {
        this.flagExScInSize12 = flagExScInSize12;
    }

    public Long getFlagExScOutSize12() {
        return flagExScOutSize12;
    }

    public void setFlagExScOutSize12(Long flagExScOutSize12) {
        this.flagExScOutSize12 = flagExScOutSize12;
    }

    public Long getFlagExScInSize13() {
        return flagExScInSize13;
    }

    public void setFlagExScInSize13(Long flagExScInSize13) {
        this.flagExScInSize13 = flagExScInSize13;
    }

    public Long getFlagExScOutSize13() {
        return flagExScOutSize13;
    }

    public void setFlagExScOutSize13(Long flagExScOutSize13) {
        this.flagExScOutSize13 = flagExScOutSize13;
    }

    public Long getFlagExScInSize14() {
        return flagExScInSize14;
    }

    public void setFlagExScInSize14(Long flagExScInSize14) {
        this.flagExScInSize14 = flagExScInSize14;
    }

    public Long getFlagExScOutSize14() {
        return flagExScOutSize14;
    }

    public void setFlagExScOutSize14(Long flagExScOutSize14) {
        this.flagExScOutSize14 = flagExScOutSize14;
    }

    public Long getFlagExScInSize15() {
        return flagExScInSize15;
    }

    public void setFlagExScInSize15(Long flagExScInSize15) {
        this.flagExScInSize15 = flagExScInSize15;
    }

    public Long getFlagExScOutSize15() {
        return flagExScOutSize15;
    }

    public void setFlagExScOutSize15(Long flagExScOutSize15) {
        this.flagExScOutSize15 = flagExScOutSize15;
    }

    public Long getFlagExScInSize16() {
        return flagExScInSize16;
    }

    public void setFlagExScInSize16(Long flagExScInSize16) {
        this.flagExScInSize16 = flagExScInSize16;
    }

    public Long getFlagExScOutSize16() {
        return flagExScOutSize16;
    }

    public void setFlagExScOutSize16(Long flagExScOutSize16) {
        this.flagExScOutSize16 = flagExScOutSize16;
    }

    public Long getFlagExScInSize17() {
        return flagExScInSize17;
    }

    public void setFlagExScInSize17(Long flagExScInSize17) {
        this.flagExScInSize17 = flagExScInSize17;
    }

    public Long getFlagExScOutSize17() {
        return flagExScOutSize17;
    }

    public void setFlagExScOutSize17(Long flagExScOutSize17) {
        this.flagExScOutSize17 = flagExScOutSize17;
    }

    public Long getFlagExScInSize18() {
        return flagExScInSize18;
    }

    public void setFlagExScInSize18(Long flagExScInSize18) {
        this.flagExScInSize18 = flagExScInSize18;
    }

    public Long getFlagExScOutSize18() {
        return flagExScOutSize18;
    }

    public void setFlagExScOutSize18(Long flagExScOutSize18) {
        this.flagExScOutSize18 = flagExScOutSize18;
    }

    public Long getFlagExScInSize1T() {
        return flagExScInSize1T;
    }

    public void setFlagExScInSize1T(Long flagExScInSize1T) {
        this.flagExScInSize1T = flagExScInSize1T;
    }

    public Long getFlagExScOutSize1T() {
        return flagExScOutSize1T;
    }

    public void setFlagExScOutSize1T(Long flagExScOutSize1T) {
        this.flagExScOutSize1T = flagExScOutSize1T;
    }

    public Long getFlagExScInSize2T() {
        return flagExScInSize2T;
    }

    public void setFlagExScInSize2T(Long flagExScInSize2T) {
        this.flagExScInSize2T = flagExScInSize2T;
    }

    public Long getFlagExScOutSize2T() {
        return flagExScOutSize2T;
    }

    public void setFlagExScOutSize2T(Long flagExScOutSize2T) {
        this.flagExScOutSize2T = flagExScOutSize2T;
    }

    public Long getFlagExScInSize3T() {
        return flagExScInSize3T;
    }

    public void setFlagExScInSize3T(Long flagExScInSize3T) {
        this.flagExScInSize3T = flagExScInSize3T;
    }

    public Long getFlagExScOutSize3T() {
        return flagExScOutSize3T;
    }

    public void setFlagExScOutSize3T(Long flagExScOutSize3T) {
        this.flagExScOutSize3T = flagExScOutSize3T;
    }

    public Long getFlagExScInSize4T() {
        return flagExScInSize4T;
    }

    public void setFlagExScInSize4T(Long flagExScInSize4T) {
        this.flagExScInSize4T = flagExScInSize4T;
    }

    public Long getFlagExScOutSize4T() {
        return flagExScOutSize4T;
    }

    public void setFlagExScOutSize4T(Long flagExScOutSize4T) {
        this.flagExScOutSize4T = flagExScOutSize4T;
    }

    public Long getFlagExScInSize5T() {
        return flagExScInSize5T;
    }

    public void setFlagExScInSize5T(Long flagExScInSize5T) {
        this.flagExScInSize5T = flagExScInSize5T;
    }

    public Long getFlagExScOutSize5T() {
        return flagExScOutSize5T;
    }

    public void setFlagExScOutSize5T(Long flagExScOutSize5T) {
        this.flagExScOutSize5T = flagExScOutSize5T;
    }

    public Long getFlagExScInSize6T() {
        return flagExScInSize6T;
    }

    public void setFlagExScInSize6T(Long flagExScInSize6T) {
        this.flagExScInSize6T = flagExScInSize6T;
    }

    public Long getFlagExScOutSize6T() {
        return flagExScOutSize6T;
    }

    public void setFlagExScOutSize6T(Long flagExScOutSize6T) {
        this.flagExScOutSize6T = flagExScOutSize6T;
    }

    public Long getFlagExScInSize7T() {
        return flagExScInSize7T;
    }

    public void setFlagExScInSize7T(Long flagExScInSize7T) {
        this.flagExScInSize7T = flagExScInSize7T;
    }

    public Long getFlagExScOutSize7T() {
        return flagExScOutSize7T;
    }

    public void setFlagExScOutSize7T(Long flagExScOutSize7T) {
        this.flagExScOutSize7T = flagExScOutSize7T;
    }

    public Long getFlagExScInSize8T() {
        return flagExScInSize8T;
    }

    public void setFlagExScInSize8T(Long flagExScInSize8T) {
        this.flagExScInSize8T = flagExScInSize8T;
    }

    public Long getFlagExScOutSize8T() {
        return flagExScOutSize8T;
    }

    public void setFlagExScOutSize8T(Long flagExScOutSize8T) {
        this.flagExScOutSize8T = flagExScOutSize8T;
    }

    public Long getFlagExScInSize9T() {
        return flagExScInSize9T;
    }

    public void setFlagExScInSize9T(Long flagExScInSize9T) {
        this.flagExScInSize9T = flagExScInSize9T;
    }

    public Long getFlagExScOutSize9T() {
        return flagExScOutSize9T;
    }

    public void setFlagExScOutSize9T(Long flagExScOutSize9T) {
        this.flagExScOutSize9T = flagExScOutSize9T;
    }

    public Long getFlagExScInSize10T() {
        return flagExScInSize10T;
    }

    public void setFlagExScInSize10T(Long flagExScInSize10T) {
        this.flagExScInSize10T = flagExScInSize10T;
    }

    public Long getFlagExScOutSize10T() {
        return flagExScOutSize10T;
    }

    public void setFlagExScOutSize10T(Long flagExScOutSize10T) {
        this.flagExScOutSize10T = flagExScOutSize10T;
    }

    public Long getFlagExScInSize11T() {
        return flagExScInSize11T;
    }

    public void setFlagExScInSize11T(Long flagExScInSize11T) {
        this.flagExScInSize11T = flagExScInSize11T;
    }

    public Long getFlagExScOutSize11T() {
        return flagExScOutSize11T;
    }

    public void setFlagExScOutSize11T(Long flagExScOutSize11T) {
        this.flagExScOutSize11T = flagExScOutSize11T;
    }

    public Long getFlagExScInSize12T() {
        return flagExScInSize12T;
    }

    public void setFlagExScInSize12T(Long flagExScInSize12T) {
        this.flagExScInSize12T = flagExScInSize12T;
    }

    public Long getFlagExScOutSize12T() {
        return flagExScOutSize12T;
    }

    public void setFlagExScOutSize12T(Long flagExScOutSize12T) {
        this.flagExScOutSize12T = flagExScOutSize12T;
    }

    public Long getFlagExScInSize13T() {
        return flagExScInSize13T;
    }

    public void setFlagExScInSize13T(Long flagExScInSize13T) {
        this.flagExScInSize13T = flagExScInSize13T;
    }

    public Long getFlagExScOutSize13T() {
        return flagExScOutSize13T;
    }

    public void setFlagExScOutSize13T(Long flagExScOutSize13T) {
        this.flagExScOutSize13T = flagExScOutSize13T;
    }

    public Long getFlagExOsInSize1() {
        return flagExOsInSize1;
    }

    public void setFlagExOsInSize1(Long flagExOsInSize1) {
        this.flagExOsInSize1 = flagExOsInSize1;
    }

    public Long getFlagExOsOutSize1() {
        return flagExOsOutSize1;
    }

    public void setFlagExOsOutSize1(Long flagExOsOutSize1) {
        this.flagExOsOutSize1 = flagExOsOutSize1;
    }

    public Long getFlagExOsInSize2() {
        return flagExOsInSize2;
    }

    public void setFlagExOsInSize2(Long flagExOsInSize2) {
        this.flagExOsInSize2 = flagExOsInSize2;
    }

    public Long getFlagExOsOutSize2() {
        return flagExOsOutSize2;
    }

    public void setFlagExOsOutSize2(Long flagExOsOutSize2) {
        this.flagExOsOutSize2 = flagExOsOutSize2;
    }

    public Long getFlagExOsInSize3() {
        return flagExOsInSize3;
    }

    public void setFlagExOsInSize3(Long flagExOsInSize3) {
        this.flagExOsInSize3 = flagExOsInSize3;
    }

    public Long getFlagExOsOutSize3() {
        return flagExOsOutSize3;
    }

    public void setFlagExOsOutSize3(Long flagExOsOutSize3) {
        this.flagExOsOutSize3 = flagExOsOutSize3;
    }

    public Long getFlagExOsInSize4() {
        return flagExOsInSize4;
    }

    public void setFlagExOsInSize4(Long flagExOsInSize4) {
        this.flagExOsInSize4 = flagExOsInSize4;
    }

    public Long getFlagExOsOutSize4() {
        return flagExOsOutSize4;
    }

    public void setFlagExOsOutSize4(Long flagExOsOutSize4) {
        this.flagExOsOutSize4 = flagExOsOutSize4;
    }

    public Long getFlagExOsInSize5() {
        return flagExOsInSize5;
    }

    public void setFlagExOsInSize5(Long flagExOsInSize5) {
        this.flagExOsInSize5 = flagExOsInSize5;
    }

    public Long getFlagExOsOutSize5() {
        return flagExOsOutSize5;
    }

    public void setFlagExOsOutSize5(Long flagExOsOutSize5) {
        this.flagExOsOutSize5 = flagExOsOutSize5;
    }

    public Long getFlagExOsInSize6() {
        return flagExOsInSize6;
    }

    public void setFlagExOsInSize6(Long flagExOsInSize6) {
        this.flagExOsInSize6 = flagExOsInSize6;
    }

    public Long getFlagExOsOutSize6() {
        return flagExOsOutSize6;
    }

    public void setFlagExOsOutSize6(Long flagExOsOutSize6) {
        this.flagExOsOutSize6 = flagExOsOutSize6;
    }

    public Long getFlagExOsInSize7() {
        return flagExOsInSize7;
    }

    public void setFlagExOsInSize7(Long flagExOsInSize7) {
        this.flagExOsInSize7 = flagExOsInSize7;
    }

    public Long getFlagExOsOutSize7() {
        return flagExOsOutSize7;
    }

    public void setFlagExOsOutSize7(Long flagExOsOutSize7) {
        this.flagExOsOutSize7 = flagExOsOutSize7;
    }

    public Long getFlagExOsInSize8() {
        return flagExOsInSize8;
    }

    public void setFlagExOsInSize8(Long flagExOsInSize8) {
        this.flagExOsInSize8 = flagExOsInSize8;
    }

    public Long getFlagExOsOutSize8() {
        return flagExOsOutSize8;
    }

    public void setFlagExOsOutSize8(Long flagExOsOutSize8) {
        this.flagExOsOutSize8 = flagExOsOutSize8;
    }

    public Long getFlagExOsInSize9() {
        return flagExOsInSize9;
    }

    public void setFlagExOsInSize9(Long flagExOsInSize9) {
        this.flagExOsInSize9 = flagExOsInSize9;
    }

    public Long getFlagExOsOutSize9() {
        return flagExOsOutSize9;
    }

    public void setFlagExOsOutSize9(Long flagExOsOutSize9) {
        this.flagExOsOutSize9 = flagExOsOutSize9;
    }

    public Long getFlagExOsInSize10() {
        return flagExOsInSize10;
    }

    public void setFlagExOsInSize10(Long flagExOsInSize10) {
        this.flagExOsInSize10 = flagExOsInSize10;
    }

    public Long getFlagExOsOutSize10() {
        return flagExOsOutSize10;
    }

    public void setFlagExOsOutSize10(Long flagExOsOutSize10) {
        this.flagExOsOutSize10 = flagExOsOutSize10;
    }

    public Long getFlagExOsInSize11() {
        return flagExOsInSize11;
    }

    public void setFlagExOsInSize11(Long flagExOsInSize11) {
        this.flagExOsInSize11 = flagExOsInSize11;
    }

    public Long getFlagExOsOutSize11() {
        return flagExOsOutSize11;
    }

    public void setFlagExOsOutSize11(Long flagExOsOutSize11) {
        this.flagExOsOutSize11 = flagExOsOutSize11;
    }

    public Long getFlagExOsInSize12() {
        return flagExOsInSize12;
    }

    public void setFlagExOsInSize12(Long flagExOsInSize12) {
        this.flagExOsInSize12 = flagExOsInSize12;
    }

    public Long getFlagExOsOutSize12() {
        return flagExOsOutSize12;
    }

    public void setFlagExOsOutSize12(Long flagExOsOutSize12) {
        this.flagExOsOutSize12 = flagExOsOutSize12;
    }

    public Long getFlagExOsInSize13() {
        return flagExOsInSize13;
    }

    public void setFlagExOsInSize13(Long flagExOsInSize13) {
        this.flagExOsInSize13 = flagExOsInSize13;
    }

    public Long getFlagExOsOutSize13() {
        return flagExOsOutSize13;
    }

    public void setFlagExOsOutSize13(Long flagExOsOutSize13) {
        this.flagExOsOutSize13 = flagExOsOutSize13;
    }

    public Long getFlagExOsInSize14() {
        return flagExOsInSize14;
    }

    public void setFlagExOsInSize14(Long flagExOsInSize14) {
        this.flagExOsInSize14 = flagExOsInSize14;
    }

    public Long getFlagExOsOutSize14() {
        return flagExOsOutSize14;
    }

    public void setFlagExOsOutSize14(Long flagExOsOutSize14) {
        this.flagExOsOutSize14 = flagExOsOutSize14;
    }

    public Long getFlagExOsInSize15() {
        return flagExOsInSize15;
    }

    public void setFlagExOsInSize15(Long flagExOsInSize15) {
        this.flagExOsInSize15 = flagExOsInSize15;
    }

    public Long getFlagExOsOutSize15() {
        return flagExOsOutSize15;
    }

    public void setFlagExOsOutSize15(Long flagExOsOutSize15) {
        this.flagExOsOutSize15 = flagExOsOutSize15;
    }

    public Long getFlagExOsInSize16() {
        return flagExOsInSize16;
    }

    public void setFlagExOsInSize16(Long flagExOsInSize16) {
        this.flagExOsInSize16 = flagExOsInSize16;
    }

    public Long getFlagExOsOutSize16() {
        return flagExOsOutSize16;
    }

    public void setFlagExOsOutSize16(Long flagExOsOutSize16) {
        this.flagExOsOutSize16 = flagExOsOutSize16;
    }

    public Long getFlagExOsInSize17() {
        return flagExOsInSize17;
    }

    public void setFlagExOsInSize17(Long flagExOsInSize17) {
        this.flagExOsInSize17 = flagExOsInSize17;
    }

    public Long getFlagExOsOutSize17() {
        return flagExOsOutSize17;
    }

    public void setFlagExOsOutSize17(Long flagExOsOutSize17) {
        this.flagExOsOutSize17 = flagExOsOutSize17;
    }

    public Long getFlagExOsInSize18() {
        return flagExOsInSize18;
    }

    public void setFlagExOsInSize18(Long flagExOsInSize18) {
        this.flagExOsInSize18 = flagExOsInSize18;
    }

    public Long getFlagExOsOutSize18() {
        return flagExOsOutSize18;
    }

    public void setFlagExOsOutSize18(Long flagExOsOutSize18) {
        this.flagExOsOutSize18 = flagExOsOutSize18;
    }

    public Long getFlagExOsInSize1T() {
        return flagExOsInSize1T;
    }

    public void setFlagExOsInSize1T(Long flagExOsInSize1T) {
        this.flagExOsInSize1T = flagExOsInSize1T;
    }

    public Long getFlagExOsOutSize1T() {
        return flagExOsOutSize1T;
    }

    public void setFlagExOsOutSize1T(Long flagExOsOutSize1T) {
        this.flagExOsOutSize1T = flagExOsOutSize1T;
    }

    public Long getFlagExOsInSize2T() {
        return flagExOsInSize2T;
    }

    public void setFlagExOsInSize2T(Long flagExOsInSize2T) {
        this.flagExOsInSize2T = flagExOsInSize2T;
    }

    public Long getFlagExOsOutSize2T() {
        return flagExOsOutSize2T;
    }

    public void setFlagExOsOutSize2T(Long flagExOsOutSize2T) {
        this.flagExOsOutSize2T = flagExOsOutSize2T;
    }

    public Long getFlagExOsInSize3T() {
        return flagExOsInSize3T;
    }

    public void setFlagExOsInSize3T(Long flagExOsInSize3T) {
        this.flagExOsInSize3T = flagExOsInSize3T;
    }

    public Long getFlagExOsOutSize3T() {
        return flagExOsOutSize3T;
    }

    public void setFlagExOsOutSize3T(Long flagExOsOutSize3T) {
        this.flagExOsOutSize3T = flagExOsOutSize3T;
    }

    public Long getFlagExOsInSize4T() {
        return flagExOsInSize4T;
    }

    public void setFlagExOsInSize4T(Long flagExOsInSize4T) {
        this.flagExOsInSize4T = flagExOsInSize4T;
    }

    public Long getFlagExOsOutSize4T() {
        return flagExOsOutSize4T;
    }

    public void setFlagExOsOutSize4T(Long flagExOsOutSize4T) {
        this.flagExOsOutSize4T = flagExOsOutSize4T;
    }

    public Long getFlagExOsInSize5T() {
        return flagExOsInSize5T;
    }

    public void setFlagExOsInSize5T(Long flagExOsInSize5T) {
        this.flagExOsInSize5T = flagExOsInSize5T;
    }

    public Long getFlagExOsOutSize5T() {
        return flagExOsOutSize5T;
    }

    public void setFlagExOsOutSize5T(Long flagExOsOutSize5T) {
        this.flagExOsOutSize5T = flagExOsOutSize5T;
    }

    public Long getFlagExOsInSize6T() {
        return flagExOsInSize6T;
    }

    public void setFlagExOsInSize6T(Long flagExOsInSize6T) {
        this.flagExOsInSize6T = flagExOsInSize6T;
    }

    public Long getFlagExOsOutSize6T() {
        return flagExOsOutSize6T;
    }

    public void setFlagExOsOutSize6T(Long flagExOsOutSize6T) {
        this.flagExOsOutSize6T = flagExOsOutSize6T;
    }

    public Long getFlagExOsInSize7T() {
        return flagExOsInSize7T;
    }

    public void setFlagExOsInSize7T(Long flagExOsInSize7T) {
        this.flagExOsInSize7T = flagExOsInSize7T;
    }

    public Long getFlagExOsOutSize7T() {
        return flagExOsOutSize7T;
    }

    public void setFlagExOsOutSize7T(Long flagExOsOutSize7T) {
        this.flagExOsOutSize7T = flagExOsOutSize7T;
    }

    public Long getFlagExOsInSize8T() {
        return flagExOsInSize8T;
    }

    public void setFlagExOsInSize8T(Long flagExOsInSize8T) {
        this.flagExOsInSize8T = flagExOsInSize8T;
    }

    public Long getFlagExOsOutSize8T() {
        return flagExOsOutSize8T;
    }

    public void setFlagExOsOutSize8T(Long flagExOsOutSize8T) {
        this.flagExOsOutSize8T = flagExOsOutSize8T;
    }

    public Long getFlagExOsInSize9T() {
        return flagExOsInSize9T;
    }

    public void setFlagExOsInSize9T(Long flagExOsInSize9T) {
        this.flagExOsInSize9T = flagExOsInSize9T;
    }

    public Long getFlagExOsOutSize9T() {
        return flagExOsOutSize9T;
    }

    public void setFlagExOsOutSize9T(Long flagExOsOutSize9T) {
        this.flagExOsOutSize9T = flagExOsOutSize9T;
    }

    public Long getFlagExOsInSize10T() {
        return flagExOsInSize10T;
    }

    public void setFlagExOsInSize10T(Long flagExOsInSize10T) {
        this.flagExOsInSize10T = flagExOsInSize10T;
    }

    public Long getFlagExOsOutSize10T() {
        return flagExOsOutSize10T;
    }

    public void setFlagExOsOutSize10T(Long flagExOsOutSize10T) {
        this.flagExOsOutSize10T = flagExOsOutSize10T;
    }

    public Long getFlagExOsInSize11T() {
        return flagExOsInSize11T;
    }

    public void setFlagExOsInSize11T(Long flagExOsInSize11T) {
        this.flagExOsInSize11T = flagExOsInSize11T;
    }

    public Long getFlagExOsOutSize11T() {
        return flagExOsOutSize11T;
    }

    public void setFlagExOsOutSize11T(Long flagExOsOutSize11T) {
        this.flagExOsOutSize11T = flagExOsOutSize11T;
    }

    public Long getFlagExOsInSize12T() {
        return flagExOsInSize12T;
    }

    public void setFlagExOsInSize12T(Long flagExOsInSize12T) {
        this.flagExOsInSize12T = flagExOsInSize12T;
    }

    public Long getFlagExOsOutSize12T() {
        return flagExOsOutSize12T;
    }

    public void setFlagExOsOutSize12T(Long flagExOsOutSize12T) {
        this.flagExOsOutSize12T = flagExOsOutSize12T;
    }

    public Long getFlagExOsInSize13T() {
        return flagExOsInSize13T;
    }

    public void setFlagExOsInSize13T(Long flagExOsInSize13T) {
        this.flagExOsInSize13T = flagExOsInSize13T;
    }

    public Long getFlagExOsOutSize13T() {
        return flagExOsOutSize13T;
    }

    public void setFlagExOsOutSize13T(Long flagExOsOutSize13T) {
        this.flagExOsOutSize13T = flagExOsOutSize13T;
    }

    public Long getFlagExSpcutInSize1() {
        return flagExSpcutInSize1;
    }

    public void setFlagExSpcutInSize1(Long flagExSpcutInSize1) {
        this.flagExSpcutInSize1 = flagExSpcutInSize1;
    }

    public Long getFlagExSpcutOutSize1() {
        return flagExSpcutOutSize1;
    }

    public void setFlagExSpcutOutSize1(Long flagExSpcutOutSize1) {
        this.flagExSpcutOutSize1 = flagExSpcutOutSize1;
    }

    public Long getFlagExSpcutInSize2() {
        return flagExSpcutInSize2;
    }

    public void setFlagExSpcutInSize2(Long flagExSpcutInSize2) {
        this.flagExSpcutInSize2 = flagExSpcutInSize2;
    }

    public Long getFlagExSpcutOutSize2() {
        return flagExSpcutOutSize2;
    }

    public void setFlagExSpcutOutSize2(Long flagExSpcutOutSize2) {
        this.flagExSpcutOutSize2 = flagExSpcutOutSize2;
    }

    public Long getFlagExSpcutInSize3() {
        return flagExSpcutInSize3;
    }

    public void setFlagExSpcutInSize3(Long flagExSpcutInSize3) {
        this.flagExSpcutInSize3 = flagExSpcutInSize3;
    }

    public Long getFlagExSpcutOutSize3() {
        return flagExSpcutOutSize3;
    }

    public void setFlagExSpcutOutSize3(Long flagExSpcutOutSize3) {
        this.flagExSpcutOutSize3 = flagExSpcutOutSize3;
    }

    public Long getFlagExSpcutInSize4() {
        return flagExSpcutInSize4;
    }

    public void setFlagExSpcutInSize4(Long flagExSpcutInSize4) {
        this.flagExSpcutInSize4 = flagExSpcutInSize4;
    }

    public Long getFlagExSpcutOutSize4() {
        return flagExSpcutOutSize4;
    }

    public void setFlagExSpcutOutSize4(Long flagExSpcutOutSize4) {
        this.flagExSpcutOutSize4 = flagExSpcutOutSize4;
    }

    public Long getFlagExSpcutInSize5() {
        return flagExSpcutInSize5;
    }

    public void setFlagExSpcutInSize5(Long flagExSpcutInSize5) {
        this.flagExSpcutInSize5 = flagExSpcutInSize5;
    }

    public Long getFlagExSpcutOutSize5() {
        return flagExSpcutOutSize5;
    }

    public void setFlagExSpcutOutSize5(Long flagExSpcutOutSize5) {
        this.flagExSpcutOutSize5 = flagExSpcutOutSize5;
    }

    public Long getFlagExSpcutInSize6() {
        return flagExSpcutInSize6;
    }

    public void setFlagExSpcutInSize6(Long flagExSpcutInSize6) {
        this.flagExSpcutInSize6 = flagExSpcutInSize6;
    }

    public Long getFlagExSpcutOutSize6() {
        return flagExSpcutOutSize6;
    }

    public void setFlagExSpcutOutSize6(Long flagExSpcutOutSize6) {
        this.flagExSpcutOutSize6 = flagExSpcutOutSize6;
    }

    public Long getFlagExSpcutInSize7() {
        return flagExSpcutInSize7;
    }

    public void setFlagExSpcutInSize7(Long flagExSpcutInSize7) {
        this.flagExSpcutInSize7 = flagExSpcutInSize7;
    }

    public Long getFlagExSpcutOutSize7() {
        return flagExSpcutOutSize7;
    }

    public void setFlagExSpcutOutSize7(Long flagExSpcutOutSize7) {
        this.flagExSpcutOutSize7 = flagExSpcutOutSize7;
    }

    public Long getFlagExSpcutInSize8() {
        return flagExSpcutInSize8;
    }

    public void setFlagExSpcutInSize8(Long flagExSpcutInSize8) {
        this.flagExSpcutInSize8 = flagExSpcutInSize8;
    }

    public Long getFlagExSpcutOutSize8() {
        return flagExSpcutOutSize8;
    }

    public void setFlagExSpcutOutSize8(Long flagExSpcutOutSize8) {
        this.flagExSpcutOutSize8 = flagExSpcutOutSize8;
    }

    public Long getFlagExSpcutInSize9() {
        return flagExSpcutInSize9;
    }

    public void setFlagExSpcutInSize9(Long flagExSpcutInSize9) {
        this.flagExSpcutInSize9 = flagExSpcutInSize9;
    }

    public Long getFlagExSpcutOutSize9() {
        return flagExSpcutOutSize9;
    }

    public void setFlagExSpcutOutSize9(Long flagExSpcutOutSize9) {
        this.flagExSpcutOutSize9 = flagExSpcutOutSize9;
    }

    public Long getFlagExSpcutInSize10() {
        return flagExSpcutInSize10;
    }

    public void setFlagExSpcutInSize10(Long flagExSpcutInSize10) {
        this.flagExSpcutInSize10 = flagExSpcutInSize10;
    }

    public Long getFlagExSpcutOutSize10() {
        return flagExSpcutOutSize10;
    }

    public void setFlagExSpcutOutSize10(Long flagExSpcutOutSize10) {
        this.flagExSpcutOutSize10 = flagExSpcutOutSize10;
    }

    public Long getFlagExSpcutInSize11() {
        return flagExSpcutInSize11;
    }

    public void setFlagExSpcutInSize11(Long flagExSpcutInSize11) {
        this.flagExSpcutInSize11 = flagExSpcutInSize11;
    }

    public Long getFlagExSpcutOutSize11() {
        return flagExSpcutOutSize11;
    }

    public void setFlagExSpcutOutSize11(Long flagExSpcutOutSize11) {
        this.flagExSpcutOutSize11 = flagExSpcutOutSize11;
    }

    public Long getFlagExSpcutInSize12() {
        return flagExSpcutInSize12;
    }

    public void setFlagExSpcutInSize12(Long flagExSpcutInSize12) {
        this.flagExSpcutInSize12 = flagExSpcutInSize12;
    }

    public Long getFlagExSpcutOutSize12() {
        return flagExSpcutOutSize12;
    }

    public void setFlagExSpcutOutSize12(Long flagExSpcutOutSize12) {
        this.flagExSpcutOutSize12 = flagExSpcutOutSize12;
    }

    public Long getFlagExSpcutInSize13() {
        return flagExSpcutInSize13;
    }

    public void setFlagExSpcutInSize13(Long flagExSpcutInSize13) {
        this.flagExSpcutInSize13 = flagExSpcutInSize13;
    }

    public Long getFlagExSpcutOutSize13() {
        return flagExSpcutOutSize13;
    }

    public void setFlagExSpcutOutSize13(Long flagExSpcutOutSize13) {
        this.flagExSpcutOutSize13 = flagExSpcutOutSize13;
    }

    public Long getFlagExSpcutInSize14() {
        return flagExSpcutInSize14;
    }

    public void setFlagExSpcutInSize14(Long flagExSpcutInSize14) {
        this.flagExSpcutInSize14 = flagExSpcutInSize14;
    }

    public Long getFlagExSpcutOutSize14() {
        return flagExSpcutOutSize14;
    }

    public void setFlagExSpcutOutSize14(Long flagExSpcutOutSize14) {
        this.flagExSpcutOutSize14 = flagExSpcutOutSize14;
    }

    public Long getFlagExSpcutInSize15() {
        return flagExSpcutInSize15;
    }

    public void setFlagExSpcutInSize15(Long flagExSpcutInSize15) {
        this.flagExSpcutInSize15 = flagExSpcutInSize15;
    }

    public Long getFlagExSpcutOutSize15() {
        return flagExSpcutOutSize15;
    }

    public void setFlagExSpcutOutSize15(Long flagExSpcutOutSize15) {
        this.flagExSpcutOutSize15 = flagExSpcutOutSize15;
    }

    public Long getFlagExSpcutInSize16() {
        return flagExSpcutInSize16;
    }

    public void setFlagExSpcutInSize16(Long flagExSpcutInSize16) {
        this.flagExSpcutInSize16 = flagExSpcutInSize16;
    }

    public Long getFlagExSpcutOutSize16() {
        return flagExSpcutOutSize16;
    }

    public void setFlagExSpcutOutSize16(Long flagExSpcutOutSize16) {
        this.flagExSpcutOutSize16 = flagExSpcutOutSize16;
    }

    public Long getFlagExSpcutInSize17() {
        return flagExSpcutInSize17;
    }

    public void setFlagExSpcutInSize17(Long flagExSpcutInSize17) {
        this.flagExSpcutInSize17 = flagExSpcutInSize17;
    }

    public Long getFlagExSpcutOutSize17() {
        return flagExSpcutOutSize17;
    }

    public void setFlagExSpcutOutSize17(Long flagExSpcutOutSize17) {
        this.flagExSpcutOutSize17 = flagExSpcutOutSize17;
    }

    public Long getFlagExSpcutInSize18() {
        return flagExSpcutInSize18;
    }

    public void setFlagExSpcutInSize18(Long flagExSpcutInSize18) {
        this.flagExSpcutInSize18 = flagExSpcutInSize18;
    }

    public Long getFlagExSpcutOutSize18() {
        return flagExSpcutOutSize18;
    }

    public void setFlagExSpcutOutSize18(Long flagExSpcutOutSize18) {
        this.flagExSpcutOutSize18 = flagExSpcutOutSize18;
    }

    public Long getFlagExSpcutInSize1T() {
        return flagExSpcutInSize1T;
    }

    public void setFlagExSpcutInSize1T(Long flagExSpcutInSize1T) {
        this.flagExSpcutInSize1T = flagExSpcutInSize1T;
    }

    public Long getFlagExSpcutOutSize1T() {
        return flagExSpcutOutSize1T;
    }

    public void setFlagExSpcutOutSize1T(Long flagExSpcutOutSize1T) {
        this.flagExSpcutOutSize1T = flagExSpcutOutSize1T;
    }

    public Long getFlagExSpcutInSize2T() {
        return flagExSpcutInSize2T;
    }

    public void setFlagExSpcutInSize2T(Long flagExSpcutInSize2T) {
        this.flagExSpcutInSize2T = flagExSpcutInSize2T;
    }

    public Long getFlagExSpcutOutSize2T() {
        return flagExSpcutOutSize2T;
    }

    public void setFlagExSpcutOutSize2T(Long flagExSpcutOutSize2T) {
        this.flagExSpcutOutSize2T = flagExSpcutOutSize2T;
    }

    public Long getFlagExSpcutInSize3T() {
        return flagExSpcutInSize3T;
    }

    public void setFlagExSpcutInSize3T(Long flagExSpcutInSize3T) {
        this.flagExSpcutInSize3T = flagExSpcutInSize3T;
    }

    public Long getFlagExSpcutOutSize3T() {
        return flagExSpcutOutSize3T;
    }

    public void setFlagExSpcutOutSize3T(Long flagExSpcutOutSize3T) {
        this.flagExSpcutOutSize3T = flagExSpcutOutSize3T;
    }

    public Long getFlagExSpcutInSize4T() {
        return flagExSpcutInSize4T;
    }

    public void setFlagExSpcutInSize4T(Long flagExSpcutInSize4T) {
        this.flagExSpcutInSize4T = flagExSpcutInSize4T;
    }

    public Long getFlagExSpcutOutSize4T() {
        return flagExSpcutOutSize4T;
    }

    public void setFlagExSpcutOutSize4T(Long flagExSpcutOutSize4T) {
        this.flagExSpcutOutSize4T = flagExSpcutOutSize4T;
    }

    public Long getFlagExSpcutInSize5T() {
        return flagExSpcutInSize5T;
    }

    public void setFlagExSpcutInSize5T(Long flagExSpcutInSize5T) {
        this.flagExSpcutInSize5T = flagExSpcutInSize5T;
    }

    public Long getFlagExSpcutOutSize5T() {
        return flagExSpcutOutSize5T;
    }

    public void setFlagExSpcutOutSize5T(Long flagExSpcutOutSize5T) {
        this.flagExSpcutOutSize5T = flagExSpcutOutSize5T;
    }

    public Long getFlagExSpcutInSize6T() {
        return flagExSpcutInSize6T;
    }

    public void setFlagExSpcutInSize6T(Long flagExSpcutInSize6T) {
        this.flagExSpcutInSize6T = flagExSpcutInSize6T;
    }

    public Long getFlagExSpcutOutSize6T() {
        return flagExSpcutOutSize6T;
    }

    public void setFlagExSpcutOutSize6T(Long flagExSpcutOutSize6T) {
        this.flagExSpcutOutSize6T = flagExSpcutOutSize6T;
    }

    public Long getFlagExSpcutInSize7T() {
        return flagExSpcutInSize7T;
    }

    public void setFlagExSpcutInSize7T(Long flagExSpcutInSize7T) {
        this.flagExSpcutInSize7T = flagExSpcutInSize7T;
    }

    public Long getFlagExSpcutOutSize7T() {
        return flagExSpcutOutSize7T;
    }

    public void setFlagExSpcutOutSize7T(Long flagExSpcutOutSize7T) {
        this.flagExSpcutOutSize7T = flagExSpcutOutSize7T;
    }

    public Long getFlagExSpcutInSize8T() {
        return flagExSpcutInSize8T;
    }

    public void setFlagExSpcutInSize8T(Long flagExSpcutInSize8T) {
        this.flagExSpcutInSize8T = flagExSpcutInSize8T;
    }

    public Long getFlagExSpcutOutSize8T() {
        return flagExSpcutOutSize8T;
    }

    public void setFlagExSpcutOutSize8T(Long flagExSpcutOutSize8T) {
        this.flagExSpcutOutSize8T = flagExSpcutOutSize8T;
    }

    public Long getFlagExSpcutInSize9T() {
        return flagExSpcutInSize9T;
    }

    public void setFlagExSpcutInSize9T(Long flagExSpcutInSize9T) {
        this.flagExSpcutInSize9T = flagExSpcutInSize9T;
    }

    public Long getFlagExSpcutOutSize9T() {
        return flagExSpcutOutSize9T;
    }

    public void setFlagExSpcutOutSize9T(Long flagExSpcutOutSize9T) {
        this.flagExSpcutOutSize9T = flagExSpcutOutSize9T;
    }

    public Long getFlagExSpcutInSize10T() {
        return flagExSpcutInSize10T;
    }

    public void setFlagExSpcutInSize10T(Long flagExSpcutInSize10T) {
        this.flagExSpcutInSize10T = flagExSpcutInSize10T;
    }

    public Long getFlagExSpcutOutSize10T() {
        return flagExSpcutOutSize10T;
    }

    public void setFlagExSpcutOutSize10T(Long flagExSpcutOutSize10T) {
        this.flagExSpcutOutSize10T = flagExSpcutOutSize10T;
    }

    public Long getFlagExSpcutInSize11T() {
        return flagExSpcutInSize11T;
    }

    public void setFlagExSpcutInSize11T(Long flagExSpcutInSize11T) {
        this.flagExSpcutInSize11T = flagExSpcutInSize11T;
    }

    public Long getFlagExSpcutOutSize11T() {
        return flagExSpcutOutSize11T;
    }

    public void setFlagExSpcutOutSize11T(Long flagExSpcutOutSize11T) {
        this.flagExSpcutOutSize11T = flagExSpcutOutSize11T;
    }

    public Long getFlagExSpcutInSize12T() {
        return flagExSpcutInSize12T;
    }

    public void setFlagExSpcutInSize12T(Long flagExSpcutInSize12T) {
        this.flagExSpcutInSize12T = flagExSpcutInSize12T;
    }

    public Long getFlagExSpcutOutSize12T() {
        return flagExSpcutOutSize12T;
    }

    public void setFlagExSpcutOutSize12T(Long flagExSpcutOutSize12T) {
        this.flagExSpcutOutSize12T = flagExSpcutOutSize12T;
    }

    public Long getFlagExSpcutInSize13T() {
        return flagExSpcutInSize13T;
    }

    public void setFlagExSpcutInSize13T(Long flagExSpcutInSize13T) {
        this.flagExSpcutInSize13T = flagExSpcutInSize13T;
    }

    public Long getFlagExSpcutOutSize13T() {
        return flagExSpcutOutSize13T;
    }

    public void setFlagExSpcutOutSize13T(Long flagExSpcutOutSize13T) {
        this.flagExSpcutOutSize13T = flagExSpcutOutSize13T;
    }

    public Long getFlagExSpprepInSize1() {
        return flagExSpprepInSize1;
    }

    public void setFlagExSpprepInSize1(Long flagExSpprepInSize1) {
        this.flagExSpprepInSize1 = flagExSpprepInSize1;
    }

    public Long getFlagExSpprepOutSize1() {
        return flagExSpprepOutSize1;
    }

    public void setFlagExSpprepOutSize1(Long flagExSpprepOutSize1) {
        this.flagExSpprepOutSize1 = flagExSpprepOutSize1;
    }

    public Long getFlagExSpprepInSize2() {
        return flagExSpprepInSize2;
    }

    public void setFlagExSpprepInSize2(Long flagExSpprepInSize2) {
        this.flagExSpprepInSize2 = flagExSpprepInSize2;
    }

    public Long getFlagExSpprepOutSize2() {
        return flagExSpprepOutSize2;
    }

    public void setFlagExSpprepOutSize2(Long flagExSpprepOutSize2) {
        this.flagExSpprepOutSize2 = flagExSpprepOutSize2;
    }

    public Long getFlagExSpprepInSize3() {
        return flagExSpprepInSize3;
    }

    public void setFlagExSpprepInSize3(Long flagExSpprepInSize3) {
        this.flagExSpprepInSize3 = flagExSpprepInSize3;
    }

    public Long getFlagExSpprepOutSize3() {
        return flagExSpprepOutSize3;
    }

    public void setFlagExSpprepOutSize3(Long flagExSpprepOutSize3) {
        this.flagExSpprepOutSize3 = flagExSpprepOutSize3;
    }

    public Long getFlagExSpprepInSize4() {
        return flagExSpprepInSize4;
    }

    public void setFlagExSpprepInSize4(Long flagExSpprepInSize4) {
        this.flagExSpprepInSize4 = flagExSpprepInSize4;
    }

    public Long getFlagExSpprepOutSize4() {
        return flagExSpprepOutSize4;
    }

    public void setFlagExSpprepOutSize4(Long flagExSpprepOutSize4) {
        this.flagExSpprepOutSize4 = flagExSpprepOutSize4;
    }

    public Long getFlagExSpprepInSize5() {
        return flagExSpprepInSize5;
    }

    public void setFlagExSpprepInSize5(Long flagExSpprepInSize5) {
        this.flagExSpprepInSize5 = flagExSpprepInSize5;
    }

    public Long getFlagExSpprepOutSize5() {
        return flagExSpprepOutSize5;
    }

    public void setFlagExSpprepOutSize5(Long flagExSpprepOutSize5) {
        this.flagExSpprepOutSize5 = flagExSpprepOutSize5;
    }

    public Long getFlagExSpprepInSize6() {
        return flagExSpprepInSize6;
    }

    public void setFlagExSpprepInSize6(Long flagExSpprepInSize6) {
        this.flagExSpprepInSize6 = flagExSpprepInSize6;
    }

    public Long getFlagExSpprepOutSize6() {
        return flagExSpprepOutSize6;
    }

    public void setFlagExSpprepOutSize6(Long flagExSpprepOutSize6) {
        this.flagExSpprepOutSize6 = flagExSpprepOutSize6;
    }

    public Long getFlagExSpprepInSize7() {
        return flagExSpprepInSize7;
    }

    public void setFlagExSpprepInSize7(Long flagExSpprepInSize7) {
        this.flagExSpprepInSize7 = flagExSpprepInSize7;
    }

    public Long getFlagExSpprepOutSize7() {
        return flagExSpprepOutSize7;
    }

    public void setFlagExSpprepOutSize7(Long flagExSpprepOutSize7) {
        this.flagExSpprepOutSize7 = flagExSpprepOutSize7;
    }

    public Long getFlagExSpprepInSize8() {
        return flagExSpprepInSize8;
    }

    public void setFlagExSpprepInSize8(Long flagExSpprepInSize8) {
        this.flagExSpprepInSize8 = flagExSpprepInSize8;
    }

    public Long getFlagExSpprepOutSize8() {
        return flagExSpprepOutSize8;
    }

    public void setFlagExSpprepOutSize8(Long flagExSpprepOutSize8) {
        this.flagExSpprepOutSize8 = flagExSpprepOutSize8;
    }

    public Long getFlagExSpprepInSize9() {
        return flagExSpprepInSize9;
    }

    public void setFlagExSpprepInSize9(Long flagExSpprepInSize9) {
        this.flagExSpprepInSize9 = flagExSpprepInSize9;
    }

    public Long getFlagExSpprepOutSize9() {
        return flagExSpprepOutSize9;
    }

    public void setFlagExSpprepOutSize9(Long flagExSpprepOutSize9) {
        this.flagExSpprepOutSize9 = flagExSpprepOutSize9;
    }

    public Long getFlagExSpprepInSize10() {
        return flagExSpprepInSize10;
    }

    public void setFlagExSpprepInSize10(Long flagExSpprepInSize10) {
        this.flagExSpprepInSize10 = flagExSpprepInSize10;
    }

    public Long getFlagExSpprepOutSize10() {
        return flagExSpprepOutSize10;
    }

    public void setFlagExSpprepOutSize10(Long flagExSpprepOutSize10) {
        this.flagExSpprepOutSize10 = flagExSpprepOutSize10;
    }

    public Long getFlagExSpprepInSize11() {
        return flagExSpprepInSize11;
    }

    public void setFlagExSpprepInSize11(Long flagExSpprepInSize11) {
        this.flagExSpprepInSize11 = flagExSpprepInSize11;
    }

    public Long getFlagExSpprepOutSize11() {
        return flagExSpprepOutSize11;
    }

    public void setFlagExSpprepOutSize11(Long flagExSpprepOutSize11) {
        this.flagExSpprepOutSize11 = flagExSpprepOutSize11;
    }

    public Long getFlagExSpprepInSize12() {
        return flagExSpprepInSize12;
    }

    public void setFlagExSpprepInSize12(Long flagExSpprepInSize12) {
        this.flagExSpprepInSize12 = flagExSpprepInSize12;
    }

    public Long getFlagExSpprepOutSize12() {
        return flagExSpprepOutSize12;
    }

    public void setFlagExSpprepOutSize12(Long flagExSpprepOutSize12) {
        this.flagExSpprepOutSize12 = flagExSpprepOutSize12;
    }

    public Long getFlagExSpprepInSize13() {
        return flagExSpprepInSize13;
    }

    public void setFlagExSpprepInSize13(Long flagExSpprepInSize13) {
        this.flagExSpprepInSize13 = flagExSpprepInSize13;
    }

    public Long getFlagExSpprepOutSize13() {
        return flagExSpprepOutSize13;
    }

    public void setFlagExSpprepOutSize13(Long flagExSpprepOutSize13) {
        this.flagExSpprepOutSize13 = flagExSpprepOutSize13;
    }

    public Long getFlagExSpprepInSize14() {
        return flagExSpprepInSize14;
    }

    public void setFlagExSpprepInSize14(Long flagExSpprepInSize14) {
        this.flagExSpprepInSize14 = flagExSpprepInSize14;
    }

    public Long getFlagExSpprepOutSize14() {
        return flagExSpprepOutSize14;
    }

    public void setFlagExSpprepOutSize14(Long flagExSpprepOutSize14) {
        this.flagExSpprepOutSize14 = flagExSpprepOutSize14;
    }

    public Long getFlagExSpprepInSize15() {
        return flagExSpprepInSize15;
    }

    public void setFlagExSpprepInSize15(Long flagExSpprepInSize15) {
        this.flagExSpprepInSize15 = flagExSpprepInSize15;
    }

    public Long getFlagExSpprepOutSize15() {
        return flagExSpprepOutSize15;
    }

    public void setFlagExSpprepOutSize15(Long flagExSpprepOutSize15) {
        this.flagExSpprepOutSize15 = flagExSpprepOutSize15;
    }

    public Long getFlagExSpprepInSize16() {
        return flagExSpprepInSize16;
    }

    public void setFlagExSpprepInSize16(Long flagExSpprepInSize16) {
        this.flagExSpprepInSize16 = flagExSpprepInSize16;
    }

    public Long getFlagExSpprepOutSize16() {
        return flagExSpprepOutSize16;
    }

    public void setFlagExSpprepOutSize16(Long flagExSpprepOutSize16) {
        this.flagExSpprepOutSize16 = flagExSpprepOutSize16;
    }

    public Long getFlagExSpprepInSize17() {
        return flagExSpprepInSize17;
    }

    public void setFlagExSpprepInSize17(Long flagExSpprepInSize17) {
        this.flagExSpprepInSize17 = flagExSpprepInSize17;
    }

    public Long getFlagExSpprepOutSize17() {
        return flagExSpprepOutSize17;
    }

    public void setFlagExSpprepOutSize17(Long flagExSpprepOutSize17) {
        this.flagExSpprepOutSize17 = flagExSpprepOutSize17;
    }

    public Long getFlagExSpprepInSize18() {
        return flagExSpprepInSize18;
    }

    public void setFlagExSpprepInSize18(Long flagExSpprepInSize18) {
        this.flagExSpprepInSize18 = flagExSpprepInSize18;
    }

    public Long getFlagExSpprepOutSize18() {
        return flagExSpprepOutSize18;
    }

    public void setFlagExSpprepOutSize18(Long flagExSpprepOutSize18) {
        this.flagExSpprepOutSize18 = flagExSpprepOutSize18;
    }

    public Long getFlagExSpprepInSize1T() {
        return flagExSpprepInSize1T;
    }

    public void setFlagExSpprepInSize1T(Long flagExSpprepInSize1T) {
        this.flagExSpprepInSize1T = flagExSpprepInSize1T;
    }

    public Long getFlagExSpprepOutSize1T() {
        return flagExSpprepOutSize1T;
    }

    public void setFlagExSpprepOutSize1T(Long flagExSpprepOutSize1T) {
        this.flagExSpprepOutSize1T = flagExSpprepOutSize1T;
    }

    public Long getFlagExSpprepInSize2T() {
        return flagExSpprepInSize2T;
    }

    public void setFlagExSpprepInSize2T(Long flagExSpprepInSize2T) {
        this.flagExSpprepInSize2T = flagExSpprepInSize2T;
    }

    public Long getFlagExSpprepOutSize2T() {
        return flagExSpprepOutSize2T;
    }

    public void setFlagExSpprepOutSize2T(Long flagExSpprepOutSize2T) {
        this.flagExSpprepOutSize2T = flagExSpprepOutSize2T;
    }

    public Long getFlagExSpprepInSize3T() {
        return flagExSpprepInSize3T;
    }

    public void setFlagExSpprepInSize3T(Long flagExSpprepInSize3T) {
        this.flagExSpprepInSize3T = flagExSpprepInSize3T;
    }

    public Long getFlagExSpprepOutSize3T() {
        return flagExSpprepOutSize3T;
    }

    public void setFlagExSpprepOutSize3T(Long flagExSpprepOutSize3T) {
        this.flagExSpprepOutSize3T = flagExSpprepOutSize3T;
    }

    public Long getFlagExSpprepInSize4T() {
        return flagExSpprepInSize4T;
    }

    public void setFlagExSpprepInSize4T(Long flagExSpprepInSize4T) {
        this.flagExSpprepInSize4T = flagExSpprepInSize4T;
    }

    public Long getFlagExSpprepOutSize4T() {
        return flagExSpprepOutSize4T;
    }

    public void setFlagExSpprepOutSize4T(Long flagExSpprepOutSize4T) {
        this.flagExSpprepOutSize4T = flagExSpprepOutSize4T;
    }

    public Long getFlagExSpprepInSize5T() {
        return flagExSpprepInSize5T;
    }

    public void setFlagExSpprepInSize5T(Long flagExSpprepInSize5T) {
        this.flagExSpprepInSize5T = flagExSpprepInSize5T;
    }

    public Long getFlagExSpprepOutSize5T() {
        return flagExSpprepOutSize5T;
    }

    public void setFlagExSpprepOutSize5T(Long flagExSpprepOutSize5T) {
        this.flagExSpprepOutSize5T = flagExSpprepOutSize5T;
    }

    public Long getFlagExSpprepInSize6T() {
        return flagExSpprepInSize6T;
    }

    public void setFlagExSpprepInSize6T(Long flagExSpprepInSize6T) {
        this.flagExSpprepInSize6T = flagExSpprepInSize6T;
    }

    public Long getFlagExSpprepOutSize6T() {
        return flagExSpprepOutSize6T;
    }

    public void setFlagExSpprepOutSize6T(Long flagExSpprepOutSize6T) {
        this.flagExSpprepOutSize6T = flagExSpprepOutSize6T;
    }

    public Long getFlagExSpprepInSize7T() {
        return flagExSpprepInSize7T;
    }

    public void setFlagExSpprepInSize7T(Long flagExSpprepInSize7T) {
        this.flagExSpprepInSize7T = flagExSpprepInSize7T;
    }

    public Long getFlagExSpprepOutSize7T() {
        return flagExSpprepOutSize7T;
    }

    public void setFlagExSpprepOutSize7T(Long flagExSpprepOutSize7T) {
        this.flagExSpprepOutSize7T = flagExSpprepOutSize7T;
    }

    public Long getFlagExSpprepInSize8T() {
        return flagExSpprepInSize8T;
    }

    public void setFlagExSpprepInSize8T(Long flagExSpprepInSize8T) {
        this.flagExSpprepInSize8T = flagExSpprepInSize8T;
    }

    public Long getFlagExSpprepOutSize8T() {
        return flagExSpprepOutSize8T;
    }

    public void setFlagExSpprepOutSize8T(Long flagExSpprepOutSize8T) {
        this.flagExSpprepOutSize8T = flagExSpprepOutSize8T;
    }

    public Long getFlagExSpprepInSize9T() {
        return flagExSpprepInSize9T;
    }

    public void setFlagExSpprepInSize9T(Long flagExSpprepInSize9T) {
        this.flagExSpprepInSize9T = flagExSpprepInSize9T;
    }

    public Long getFlagExSpprepOutSize9T() {
        return flagExSpprepOutSize9T;
    }

    public void setFlagExSpprepOutSize9T(Long flagExSpprepOutSize9T) {
        this.flagExSpprepOutSize9T = flagExSpprepOutSize9T;
    }

    public Long getFlagExSpprepInSize10T() {
        return flagExSpprepInSize10T;
    }

    public void setFlagExSpprepInSize10T(Long flagExSpprepInSize10T) {
        this.flagExSpprepInSize10T = flagExSpprepInSize10T;
    }

    public Long getFlagExSpprepOutSize10T() {
        return flagExSpprepOutSize10T;
    }

    public void setFlagExSpprepOutSize10T(Long flagExSpprepOutSize10T) {
        this.flagExSpprepOutSize10T = flagExSpprepOutSize10T;
    }

    public Long getFlagExSpprepInSize11T() {
        return flagExSpprepInSize11T;
    }

    public void setFlagExSpprepInSize11T(Long flagExSpprepInSize11T) {
        this.flagExSpprepInSize11T = flagExSpprepInSize11T;
    }

    public Long getFlagExSpprepOutSize11T() {
        return flagExSpprepOutSize11T;
    }

    public void setFlagExSpprepOutSize11T(Long flagExSpprepOutSize11T) {
        this.flagExSpprepOutSize11T = flagExSpprepOutSize11T;
    }

    public Long getFlagExSpprepInSize12T() {
        return flagExSpprepInSize12T;
    }

    public void setFlagExSpprepInSize12T(Long flagExSpprepInSize12T) {
        this.flagExSpprepInSize12T = flagExSpprepInSize12T;
    }

    public Long getFlagExSpprepOutSize12T() {
        return flagExSpprepOutSize12T;
    }

    public void setFlagExSpprepOutSize12T(Long flagExSpprepOutSize12T) {
        this.flagExSpprepOutSize12T = flagExSpprepOutSize12T;
    }

    public Long getFlagExSpprepInSize13T() {
        return flagExSpprepInSize13T;
    }

    public void setFlagExSpprepInSize13T(Long flagExSpprepInSize13T) {
        this.flagExSpprepInSize13T = flagExSpprepInSize13T;
    }

    public Long getFlagExSpprepOutSize13T() {
        return flagExSpprepOutSize13T;
    }

    public void setFlagExSpprepOutSize13T(Long flagExSpprepOutSize13T) {
        this.flagExSpprepOutSize13T = flagExSpprepOutSize13T;
    }

    public Long getFlagExLabelInSize1() {
        return flagExLabelInSize1;
    }

    public void setFlagExLabelInSize1(Long flagExLabelInSize1) {
        this.flagExLabelInSize1 = flagExLabelInSize1;
    }

    public Long getFlagExLabelOutSize1() {
        return flagExLabelOutSize1;
    }

    public void setFlagExLabelOutSize1(Long flagExLabelOutSize1) {
        this.flagExLabelOutSize1 = flagExLabelOutSize1;
    }

    public Long getFlagExLabelInSize2() {
        return flagExLabelInSize2;
    }

    public void setFlagExLabelInSize2(Long flagExLabelInSize2) {
        this.flagExLabelInSize2 = flagExLabelInSize2;
    }

    public Long getFlagExLabelOutSize2() {
        return flagExLabelOutSize2;
    }

    public void setFlagExLabelOutSize2(Long flagExLabelOutSize2) {
        this.flagExLabelOutSize2 = flagExLabelOutSize2;
    }

    public Long getFlagExLabelInSize3() {
        return flagExLabelInSize3;
    }

    public void setFlagExLabelInSize3(Long flagExLabelInSize3) {
        this.flagExLabelInSize3 = flagExLabelInSize3;
    }

    public Long getFlagExLabelOutSize3() {
        return flagExLabelOutSize3;
    }

    public void setFlagExLabelOutSize3(Long flagExLabelOutSize3) {
        this.flagExLabelOutSize3 = flagExLabelOutSize3;
    }

    public Long getFlagExLabelInSize4() {
        return flagExLabelInSize4;
    }

    public void setFlagExLabelInSize4(Long flagExLabelInSize4) {
        this.flagExLabelInSize4 = flagExLabelInSize4;
    }

    public Long getFlagExLabelOutSize4() {
        return flagExLabelOutSize4;
    }

    public void setFlagExLabelOutSize4(Long flagExLabelOutSize4) {
        this.flagExLabelOutSize4 = flagExLabelOutSize4;
    }

    public Long getFlagExLabelInSize5() {
        return flagExLabelInSize5;
    }

    public void setFlagExLabelInSize5(Long flagExLabelInSize5) {
        this.flagExLabelInSize5 = flagExLabelInSize5;
    }

    public Long getFlagExLabelOutSize5() {
        return flagExLabelOutSize5;
    }

    public void setFlagExLabelOutSize5(Long flagExLabelOutSize5) {
        this.flagExLabelOutSize5 = flagExLabelOutSize5;
    }

    public Long getFlagExLabelInSize6() {
        return flagExLabelInSize6;
    }

    public void setFlagExLabelInSize6(Long flagExLabelInSize6) {
        this.flagExLabelInSize6 = flagExLabelInSize6;
    }

    public Long getFlagExLabelOutSize6() {
        return flagExLabelOutSize6;
    }

    public void setFlagExLabelOutSize6(Long flagExLabelOutSize6) {
        this.flagExLabelOutSize6 = flagExLabelOutSize6;
    }

    public Long getFlagExLabelInSize7() {
        return flagExLabelInSize7;
    }

    public void setFlagExLabelInSize7(Long flagExLabelInSize7) {
        this.flagExLabelInSize7 = flagExLabelInSize7;
    }

    public Long getFlagExLabelOutSize7() {
        return flagExLabelOutSize7;
    }

    public void setFlagExLabelOutSize7(Long flagExLabelOutSize7) {
        this.flagExLabelOutSize7 = flagExLabelOutSize7;
    }

    public Long getFlagExLabelInSize8() {
        return flagExLabelInSize8;
    }

    public void setFlagExLabelInSize8(Long flagExLabelInSize8) {
        this.flagExLabelInSize8 = flagExLabelInSize8;
    }

    public Long getFlagExLabelOutSize8() {
        return flagExLabelOutSize8;
    }

    public void setFlagExLabelOutSize8(Long flagExLabelOutSize8) {
        this.flagExLabelOutSize8 = flagExLabelOutSize8;
    }

    public Long getFlagExLabelInSize9() {
        return flagExLabelInSize9;
    }

    public void setFlagExLabelInSize9(Long flagExLabelInSize9) {
        this.flagExLabelInSize9 = flagExLabelInSize9;
    }

    public Long getFlagExLabelOutSize9() {
        return flagExLabelOutSize9;
    }

    public void setFlagExLabelOutSize9(Long flagExLabelOutSize9) {
        this.flagExLabelOutSize9 = flagExLabelOutSize9;
    }

    public Long getFlagExLabelInSize10() {
        return flagExLabelInSize10;
    }

    public void setFlagExLabelInSize10(Long flagExLabelInSize10) {
        this.flagExLabelInSize10 = flagExLabelInSize10;
    }

    public Long getFlagExLabelOutSize10() {
        return flagExLabelOutSize10;
    }

    public void setFlagExLabelOutSize10(Long flagExLabelOutSize10) {
        this.flagExLabelOutSize10 = flagExLabelOutSize10;
    }

    public Long getFlagExLabelInSize11() {
        return flagExLabelInSize11;
    }

    public void setFlagExLabelInSize11(Long flagExLabelInSize11) {
        this.flagExLabelInSize11 = flagExLabelInSize11;
    }

    public Long getFlagExLabelOutSize11() {
        return flagExLabelOutSize11;
    }

    public void setFlagExLabelOutSize11(Long flagExLabelOutSize11) {
        this.flagExLabelOutSize11 = flagExLabelOutSize11;
    }

    public Long getFlagExLabelInSize12() {
        return flagExLabelInSize12;
    }

    public void setFlagExLabelInSize12(Long flagExLabelInSize12) {
        this.flagExLabelInSize12 = flagExLabelInSize12;
    }

    public Long getFlagExLabelOutSize12() {
        return flagExLabelOutSize12;
    }

    public void setFlagExLabelOutSize12(Long flagExLabelOutSize12) {
        this.flagExLabelOutSize12 = flagExLabelOutSize12;
    }

    public Long getFlagExLabelInSize13() {
        return flagExLabelInSize13;
    }

    public void setFlagExLabelInSize13(Long flagExLabelInSize13) {
        this.flagExLabelInSize13 = flagExLabelInSize13;
    }

    public Long getFlagExLabelOutSize13() {
        return flagExLabelOutSize13;
    }

    public void setFlagExLabelOutSize13(Long flagExLabelOutSize13) {
        this.flagExLabelOutSize13 = flagExLabelOutSize13;
    }

    public Long getFlagExLabelInSize14() {
        return flagExLabelInSize14;
    }

    public void setFlagExLabelInSize14(Long flagExLabelInSize14) {
        this.flagExLabelInSize14 = flagExLabelInSize14;
    }

    public Long getFlagExLabelOutSize14() {
        return flagExLabelOutSize14;
    }

    public void setFlagExLabelOutSize14(Long flagExLabelOutSize14) {
        this.flagExLabelOutSize14 = flagExLabelOutSize14;
    }

    public Long getFlagExLabelInSize15() {
        return flagExLabelInSize15;
    }

    public void setFlagExLabelInSize15(Long flagExLabelInSize15) {
        this.flagExLabelInSize15 = flagExLabelInSize15;
    }

    public Long getFlagExLabelOutSize15() {
        return flagExLabelOutSize15;
    }

    public void setFlagExLabelOutSize15(Long flagExLabelOutSize15) {
        this.flagExLabelOutSize15 = flagExLabelOutSize15;
    }

    public Long getFlagExLabelInSize16() {
        return flagExLabelInSize16;
    }

    public void setFlagExLabelInSize16(Long flagExLabelInSize16) {
        this.flagExLabelInSize16 = flagExLabelInSize16;
    }

    public Long getFlagExLabelOutSize16() {
        return flagExLabelOutSize16;
    }

    public void setFlagExLabelOutSize16(Long flagExLabelOutSize16) {
        this.flagExLabelOutSize16 = flagExLabelOutSize16;
    }

    public Long getFlagExLabelInSize17() {
        return flagExLabelInSize17;
    }

    public void setFlagExLabelInSize17(Long flagExLabelInSize17) {
        this.flagExLabelInSize17 = flagExLabelInSize17;
    }

    public Long getFlagExLabelOutSize17() {
        return flagExLabelOutSize17;
    }

    public void setFlagExLabelOutSize17(Long flagExLabelOutSize17) {
        this.flagExLabelOutSize17 = flagExLabelOutSize17;
    }

    public Long getFlagExLabelInSize18() {
        return flagExLabelInSize18;
    }

    public void setFlagExLabelInSize18(Long flagExLabelInSize18) {
        this.flagExLabelInSize18 = flagExLabelInSize18;
    }

    public Long getFlagExLabelOutSize18() {
        return flagExLabelOutSize18;
    }

    public void setFlagExLabelOutSize18(Long flagExLabelOutSize18) {
        this.flagExLabelOutSize18 = flagExLabelOutSize18;
    }

    public Long getFlagExLabelInSize1T() {
        return flagExLabelInSize1T;
    }

    public void setFlagExLabelInSize1T(Long flagExLabelInSize1T) {
        this.flagExLabelInSize1T = flagExLabelInSize1T;
    }

    public Long getFlagExLabelOutSize1T() {
        return flagExLabelOutSize1T;
    }

    public void setFlagExLabelOutSize1T(Long flagExLabelOutSize1T) {
        this.flagExLabelOutSize1T = flagExLabelOutSize1T;
    }

    public Long getFlagExLabelInSize2T() {
        return flagExLabelInSize2T;
    }

    public void setFlagExLabelInSize2T(Long flagExLabelInSize2T) {
        this.flagExLabelInSize2T = flagExLabelInSize2T;
    }

    public Long getFlagExLabelOutSize2T() {
        return flagExLabelOutSize2T;
    }

    public void setFlagExLabelOutSize2T(Long flagExLabelOutSize2T) {
        this.flagExLabelOutSize2T = flagExLabelOutSize2T;
    }

    public Long getFlagExLabelInSize3T() {
        return flagExLabelInSize3T;
    }

    public void setFlagExLabelInSize3T(Long flagExLabelInSize3T) {
        this.flagExLabelInSize3T = flagExLabelInSize3T;
    }

    public Long getFlagExLabelOutSize3T() {
        return flagExLabelOutSize3T;
    }

    public void setFlagExLabelOutSize3T(Long flagExLabelOutSize3T) {
        this.flagExLabelOutSize3T = flagExLabelOutSize3T;
    }

    public Long getFlagExLabelInSize4T() {
        return flagExLabelInSize4T;
    }

    public void setFlagExLabelInSize4T(Long flagExLabelInSize4T) {
        this.flagExLabelInSize4T = flagExLabelInSize4T;
    }

    public Long getFlagExLabelOutSize4T() {
        return flagExLabelOutSize4T;
    }

    public void setFlagExLabelOutSize4T(Long flagExLabelOutSize4T) {
        this.flagExLabelOutSize4T = flagExLabelOutSize4T;
    }

    public Long getFlagExLabelInSize5T() {
        return flagExLabelInSize5T;
    }

    public void setFlagExLabelInSize5T(Long flagExLabelInSize5T) {
        this.flagExLabelInSize5T = flagExLabelInSize5T;
    }

    public Long getFlagExLabelOutSize5T() {
        return flagExLabelOutSize5T;
    }

    public void setFlagExLabelOutSize5T(Long flagExLabelOutSize5T) {
        this.flagExLabelOutSize5T = flagExLabelOutSize5T;
    }

    public Long getFlagExLabelInSize6T() {
        return flagExLabelInSize6T;
    }

    public void setFlagExLabelInSize6T(Long flagExLabelInSize6T) {
        this.flagExLabelInSize6T = flagExLabelInSize6T;
    }

    public Long getFlagExLabelOutSize6T() {
        return flagExLabelOutSize6T;
    }

    public void setFlagExLabelOutSize6T(Long flagExLabelOutSize6T) {
        this.flagExLabelOutSize6T = flagExLabelOutSize6T;
    }

    public Long getFlagExLabelInSize7T() {
        return flagExLabelInSize7T;
    }

    public void setFlagExLabelInSize7T(Long flagExLabelInSize7T) {
        this.flagExLabelInSize7T = flagExLabelInSize7T;
    }

    public Long getFlagExLabelOutSize7T() {
        return flagExLabelOutSize7T;
    }

    public void setFlagExLabelOutSize7T(Long flagExLabelOutSize7T) {
        this.flagExLabelOutSize7T = flagExLabelOutSize7T;
    }

    public Long getFlagExLabelInSize8T() {
        return flagExLabelInSize8T;
    }

    public void setFlagExLabelInSize8T(Long flagExLabelInSize8T) {
        this.flagExLabelInSize8T = flagExLabelInSize8T;
    }

    public Long getFlagExLabelOutSize8T() {
        return flagExLabelOutSize8T;
    }

    public void setFlagExLabelOutSize8T(Long flagExLabelOutSize8T) {
        this.flagExLabelOutSize8T = flagExLabelOutSize8T;
    }

    public Long getFlagExLabelInSize9T() {
        return flagExLabelInSize9T;
    }

    public void setFlagExLabelInSize9T(Long flagExLabelInSize9T) {
        this.flagExLabelInSize9T = flagExLabelInSize9T;
    }

    public Long getFlagExLabelOutSize9T() {
        return flagExLabelOutSize9T;
    }

    public void setFlagExLabelOutSize9T(Long flagExLabelOutSize9T) {
        this.flagExLabelOutSize9T = flagExLabelOutSize9T;
    }

    public Long getFlagExLabelInSize10T() {
        return flagExLabelInSize10T;
    }

    public void setFlagExLabelInSize10T(Long flagExLabelInSize10T) {
        this.flagExLabelInSize10T = flagExLabelInSize10T;
    }

    public Long getFlagExLabelOutSize10T() {
        return flagExLabelOutSize10T;
    }

    public void setFlagExLabelOutSize10T(Long flagExLabelOutSize10T) {
        this.flagExLabelOutSize10T = flagExLabelOutSize10T;
    }

    public Long getFlagExLabelInSize11T() {
        return flagExLabelInSize11T;
    }

    public void setFlagExLabelInSize11T(Long flagExLabelInSize11T) {
        this.flagExLabelInSize11T = flagExLabelInSize11T;
    }

    public Long getFlagExLabelOutSize11T() {
        return flagExLabelOutSize11T;
    }

    public void setFlagExLabelOutSize11T(Long flagExLabelOutSize11T) {
        this.flagExLabelOutSize11T = flagExLabelOutSize11T;
    }

    public Long getFlagExLabelInSize12T() {
        return flagExLabelInSize12T;
    }

    public void setFlagExLabelInSize12T(Long flagExLabelInSize12T) {
        this.flagExLabelInSize12T = flagExLabelInSize12T;
    }

    public Long getFlagExLabelOutSize12T() {
        return flagExLabelOutSize12T;
    }

    public void setFlagExLabelOutSize12T(Long flagExLabelOutSize12T) {
        this.flagExLabelOutSize12T = flagExLabelOutSize12T;
    }

    public Long getFlagExLabelInSize13T() {
        return flagExLabelInSize13T;
    }

    public void setFlagExLabelInSize13T(Long flagExLabelInSize13T) {
        this.flagExLabelInSize13T = flagExLabelInSize13T;
    }

    public Long getFlagExLabelOutSize13T() {
        return flagExLabelOutSize13T;
    }

    public void setFlagExLabelOutSize13T(Long flagExLabelOutSize13T) {
        this.flagExLabelOutSize13T = flagExLabelOutSize13T;
    }

    public Long getFlagExLaserInSize1() {
        return flagExLaserInSize1;
    }

    public void setFlagExLaserInSize1(Long flagExLaserInSize1) {
        this.flagExLaserInSize1 = flagExLaserInSize1;
    }

    public Long getFlagExLaserOutSize1() {
        return flagExLaserOutSize1;
    }

    public void setFlagExLaserOutSize1(Long flagExLaserOutSize1) {
        this.flagExLaserOutSize1 = flagExLaserOutSize1;
    }

    public Long getFlagExLaserInSize2() {
        return flagExLaserInSize2;
    }

    public void setFlagExLaserInSize2(Long flagExLaserInSize2) {
        this.flagExLaserInSize2 = flagExLaserInSize2;
    }

    public Long getFlagExLaserOutSize2() {
        return flagExLaserOutSize2;
    }

    public void setFlagExLaserOutSize2(Long flagExLaserOutSize2) {
        this.flagExLaserOutSize2 = flagExLaserOutSize2;
    }

    public Long getFlagExLaserInSize3() {
        return flagExLaserInSize3;
    }

    public void setFlagExLaserInSize3(Long flagExLaserInSize3) {
        this.flagExLaserInSize3 = flagExLaserInSize3;
    }

    public Long getFlagExLaserOutSize3() {
        return flagExLaserOutSize3;
    }

    public void setFlagExLaserOutSize3(Long flagExLaserOutSize3) {
        this.flagExLaserOutSize3 = flagExLaserOutSize3;
    }

    public Long getFlagExLaserInSize4() {
        return flagExLaserInSize4;
    }

    public void setFlagExLaserInSize4(Long flagExLaserInSize4) {
        this.flagExLaserInSize4 = flagExLaserInSize4;
    }

    public Long getFlagExLaserOutSize4() {
        return flagExLaserOutSize4;
    }

    public void setFlagExLaserOutSize4(Long flagExLaserOutSize4) {
        this.flagExLaserOutSize4 = flagExLaserOutSize4;
    }

    public Long getFlagExLaserInSize5() {
        return flagExLaserInSize5;
    }

    public void setFlagExLaserInSize5(Long flagExLaserInSize5) {
        this.flagExLaserInSize5 = flagExLaserInSize5;
    }

    public Long getFlagExLaserOutSize5() {
        return flagExLaserOutSize5;
    }

    public void setFlagExLaserOutSize5(Long flagExLaserOutSize5) {
        this.flagExLaserOutSize5 = flagExLaserOutSize5;
    }

    public Long getFlagExLaserInSize6() {
        return flagExLaserInSize6;
    }

    public void setFlagExLaserInSize6(Long flagExLaserInSize6) {
        this.flagExLaserInSize6 = flagExLaserInSize6;
    }

    public Long getFlagExLaserOutSize6() {
        return flagExLaserOutSize6;
    }

    public void setFlagExLaserOutSize6(Long flagExLaserOutSize6) {
        this.flagExLaserOutSize6 = flagExLaserOutSize6;
    }

    public Long getFlagExLaserInSize7() {
        return flagExLaserInSize7;
    }

    public void setFlagExLaserInSize7(Long flagExLaserInSize7) {
        this.flagExLaserInSize7 = flagExLaserInSize7;
    }

    public Long getFlagExLaserOutSize7() {
        return flagExLaserOutSize7;
    }

    public void setFlagExLaserOutSize7(Long flagExLaserOutSize7) {
        this.flagExLaserOutSize7 = flagExLaserOutSize7;
    }

    public Long getFlagExLaserInSize8() {
        return flagExLaserInSize8;
    }

    public void setFlagExLaserInSize8(Long flagExLaserInSize8) {
        this.flagExLaserInSize8 = flagExLaserInSize8;
    }

    public Long getFlagExLaserOutSize8() {
        return flagExLaserOutSize8;
    }

    public void setFlagExLaserOutSize8(Long flagExLaserOutSize8) {
        this.flagExLaserOutSize8 = flagExLaserOutSize8;
    }

    public Long getFlagExLaserInSize9() {
        return flagExLaserInSize9;
    }

    public void setFlagExLaserInSize9(Long flagExLaserInSize9) {
        this.flagExLaserInSize9 = flagExLaserInSize9;
    }

    public Long getFlagExLaserOutSize9() {
        return flagExLaserOutSize9;
    }

    public void setFlagExLaserOutSize9(Long flagExLaserOutSize9) {
        this.flagExLaserOutSize9 = flagExLaserOutSize9;
    }

    public Long getFlagExLaserInSize10() {
        return flagExLaserInSize10;
    }

    public void setFlagExLaserInSize10(Long flagExLaserInSize10) {
        this.flagExLaserInSize10 = flagExLaserInSize10;
    }

    public Long getFlagExLaserOutSize10() {
        return flagExLaserOutSize10;
    }

    public void setFlagExLaserOutSize10(Long flagExLaserOutSize10) {
        this.flagExLaserOutSize10 = flagExLaserOutSize10;
    }

    public Long getFlagExLaserInSize11() {
        return flagExLaserInSize11;
    }

    public void setFlagExLaserInSize11(Long flagExLaserInSize11) {
        this.flagExLaserInSize11 = flagExLaserInSize11;
    }

    public Long getFlagExLaserOutSize11() {
        return flagExLaserOutSize11;
    }

    public void setFlagExLaserOutSize11(Long flagExLaserOutSize11) {
        this.flagExLaserOutSize11 = flagExLaserOutSize11;
    }

    public Long getFlagExLaserInSize12() {
        return flagExLaserInSize12;
    }

    public void setFlagExLaserInSize12(Long flagExLaserInSize12) {
        this.flagExLaserInSize12 = flagExLaserInSize12;
    }

    public Long getFlagExLaserOutSize12() {
        return flagExLaserOutSize12;
    }

    public void setFlagExLaserOutSize12(Long flagExLaserOutSize12) {
        this.flagExLaserOutSize12 = flagExLaserOutSize12;
    }

    public Long getFlagExLaserInSize13() {
        return flagExLaserInSize13;
    }

    public void setFlagExLaserInSize13(Long flagExLaserInSize13) {
        this.flagExLaserInSize13 = flagExLaserInSize13;
    }

    public Long getFlagExLaserOutSize13() {
        return flagExLaserOutSize13;
    }

    public void setFlagExLaserOutSize13(Long flagExLaserOutSize13) {
        this.flagExLaserOutSize13 = flagExLaserOutSize13;
    }

    public Long getFlagExLaserInSize14() {
        return flagExLaserInSize14;
    }

    public void setFlagExLaserInSize14(Long flagExLaserInSize14) {
        this.flagExLaserInSize14 = flagExLaserInSize14;
    }

    public Long getFlagExLaserOutSize14() {
        return flagExLaserOutSize14;
    }

    public void setFlagExLaserOutSize14(Long flagExLaserOutSize14) {
        this.flagExLaserOutSize14 = flagExLaserOutSize14;
    }

    public Long getFlagExLaserInSize15() {
        return flagExLaserInSize15;
    }

    public void setFlagExLaserInSize15(Long flagExLaserInSize15) {
        this.flagExLaserInSize15 = flagExLaserInSize15;
    }

    public Long getFlagExLaserOutSize15() {
        return flagExLaserOutSize15;
    }

    public void setFlagExLaserOutSize15(Long flagExLaserOutSize15) {
        this.flagExLaserOutSize15 = flagExLaserOutSize15;
    }

    public Long getFlagExLaserInSize16() {
        return flagExLaserInSize16;
    }

    public void setFlagExLaserInSize16(Long flagExLaserInSize16) {
        this.flagExLaserInSize16 = flagExLaserInSize16;
    }

    public Long getFlagExLaserOutSize16() {
        return flagExLaserOutSize16;
    }

    public void setFlagExLaserOutSize16(Long flagExLaserOutSize16) {
        this.flagExLaserOutSize16 = flagExLaserOutSize16;
    }

    public Long getFlagExLaserInSize17() {
        return flagExLaserInSize17;
    }

    public void setFlagExLaserInSize17(Long flagExLaserInSize17) {
        this.flagExLaserInSize17 = flagExLaserInSize17;
    }

    public Long getFlagExLaserOutSize17() {
        return flagExLaserOutSize17;
    }

    public void setFlagExLaserOutSize17(Long flagExLaserOutSize17) {
        this.flagExLaserOutSize17 = flagExLaserOutSize17;
    }

    public Long getFlagExLaserInSize18() {
        return flagExLaserInSize18;
    }

    public void setFlagExLaserInSize18(Long flagExLaserInSize18) {
        this.flagExLaserInSize18 = flagExLaserInSize18;
    }

    public Long getFlagExLaserOutSize18() {
        return flagExLaserOutSize18;
    }

    public void setFlagExLaserOutSize18(Long flagExLaserOutSize18) {
        this.flagExLaserOutSize18 = flagExLaserOutSize18;
    }

    public Long getFlagExLaserInSize1T() {
        return flagExLaserInSize1T;
    }

    public void setFlagExLaserInSize1T(Long flagExLaserInSize1T) {
        this.flagExLaserInSize1T = flagExLaserInSize1T;
    }

    public Long getFlagExLaserOutSize1T() {
        return flagExLaserOutSize1T;
    }

    public void setFlagExLaserOutSize1T(Long flagExLaserOutSize1T) {
        this.flagExLaserOutSize1T = flagExLaserOutSize1T;
    }

    public Long getFlagExLaserInSize2T() {
        return flagExLaserInSize2T;
    }

    public void setFlagExLaserInSize2T(Long flagExLaserInSize2T) {
        this.flagExLaserInSize2T = flagExLaserInSize2T;
    }

    public Long getFlagExLaserOutSize2T() {
        return flagExLaserOutSize2T;
    }

    public void setFlagExLaserOutSize2T(Long flagExLaserOutSize2T) {
        this.flagExLaserOutSize2T = flagExLaserOutSize2T;
    }

    public Long getFlagExLaserInSize3T() {
        return flagExLaserInSize3T;
    }

    public void setFlagExLaserInSize3T(Long flagExLaserInSize3T) {
        this.flagExLaserInSize3T = flagExLaserInSize3T;
    }

    public Long getFlagExLaserOutSize3T() {
        return flagExLaserOutSize3T;
    }

    public void setFlagExLaserOutSize3T(Long flagExLaserOutSize3T) {
        this.flagExLaserOutSize3T = flagExLaserOutSize3T;
    }

    public Long getFlagExLaserInSize4T() {
        return flagExLaserInSize4T;
    }

    public void setFlagExLaserInSize4T(Long flagExLaserInSize4T) {
        this.flagExLaserInSize4T = flagExLaserInSize4T;
    }

    public Long getFlagExLaserOutSize4T() {
        return flagExLaserOutSize4T;
    }

    public void setFlagExLaserOutSize4T(Long flagExLaserOutSize4T) {
        this.flagExLaserOutSize4T = flagExLaserOutSize4T;
    }

    public Long getFlagExLaserInSize5T() {
        return flagExLaserInSize5T;
    }

    public void setFlagExLaserInSize5T(Long flagExLaserInSize5T) {
        this.flagExLaserInSize5T = flagExLaserInSize5T;
    }

    public Long getFlagExLaserOutSize5T() {
        return flagExLaserOutSize5T;
    }

    public void setFlagExLaserOutSize5T(Long flagExLaserOutSize5T) {
        this.flagExLaserOutSize5T = flagExLaserOutSize5T;
    }

    public Long getFlagExLaserInSize6T() {
        return flagExLaserInSize6T;
    }

    public void setFlagExLaserInSize6T(Long flagExLaserInSize6T) {
        this.flagExLaserInSize6T = flagExLaserInSize6T;
    }

    public Long getFlagExLaserOutSize6T() {
        return flagExLaserOutSize6T;
    }

    public void setFlagExLaserOutSize6T(Long flagExLaserOutSize6T) {
        this.flagExLaserOutSize6T = flagExLaserOutSize6T;
    }

    public Long getFlagExLaserInSize7T() {
        return flagExLaserInSize7T;
    }

    public void setFlagExLaserInSize7T(Long flagExLaserInSize7T) {
        this.flagExLaserInSize7T = flagExLaserInSize7T;
    }

    public Long getFlagExLaserOutSize7T() {
        return flagExLaserOutSize7T;
    }

    public void setFlagExLaserOutSize7T(Long flagExLaserOutSize7T) {
        this.flagExLaserOutSize7T = flagExLaserOutSize7T;
    }

    public Long getFlagExLaserInSize8T() {
        return flagExLaserInSize8T;
    }

    public void setFlagExLaserInSize8T(Long flagExLaserInSize8T) {
        this.flagExLaserInSize8T = flagExLaserInSize8T;
    }

    public Long getFlagExLaserOutSize8T() {
        return flagExLaserOutSize8T;
    }

    public void setFlagExLaserOutSize8T(Long flagExLaserOutSize8T) {
        this.flagExLaserOutSize8T = flagExLaserOutSize8T;
    }

    public Long getFlagExLaserInSize9T() {
        return flagExLaserInSize9T;
    }

    public void setFlagExLaserInSize9T(Long flagExLaserInSize9T) {
        this.flagExLaserInSize9T = flagExLaserInSize9T;
    }

    public Long getFlagExLaserOutSize9T() {
        return flagExLaserOutSize9T;
    }

    public void setFlagExLaserOutSize9T(Long flagExLaserOutSize9T) {
        this.flagExLaserOutSize9T = flagExLaserOutSize9T;
    }

    public Long getFlagExLaserInSize10T() {
        return flagExLaserInSize10T;
    }

    public void setFlagExLaserInSize10T(Long flagExLaserInSize10T) {
        this.flagExLaserInSize10T = flagExLaserInSize10T;
    }

    public Long getFlagExLaserOutSize10T() {
        return flagExLaserOutSize10T;
    }

    public void setFlagExLaserOutSize10T(Long flagExLaserOutSize10T) {
        this.flagExLaserOutSize10T = flagExLaserOutSize10T;
    }

    public Long getFlagExLaserInSize11T() {
        return flagExLaserInSize11T;
    }

    public void setFlagExLaserInSize11T(Long flagExLaserInSize11T) {
        this.flagExLaserInSize11T = flagExLaserInSize11T;
    }

    public Long getFlagExLaserOutSize11T() {
        return flagExLaserOutSize11T;
    }

    public void setFlagExLaserOutSize11T(Long flagExLaserOutSize11T) {
        this.flagExLaserOutSize11T = flagExLaserOutSize11T;
    }

    public Long getFlagExLaserInSize12T() {
        return flagExLaserInSize12T;
    }

    public void setFlagExLaserInSize12T(Long flagExLaserInSize12T) {
        this.flagExLaserInSize12T = flagExLaserInSize12T;
    }

    public Long getFlagExLaserOutSize12T() {
        return flagExLaserOutSize12T;
    }

    public void setFlagExLaserOutSize12T(Long flagExLaserOutSize12T) {
        this.flagExLaserOutSize12T = flagExLaserOutSize12T;
    }

    public Long getFlagExLaserInSize13T() {
        return flagExLaserInSize13T;
    }

    public void setFlagExLaserInSize13T(Long flagExLaserInSize13T) {
        this.flagExLaserInSize13T = flagExLaserInSize13T;
    }

    public Long getFlagExLaserOutSize13T() {
        return flagExLaserOutSize13T;
    }

    public void setFlagExLaserOutSize13T(Long flagExLaserOutSize13T) {
        this.flagExLaserOutSize13T = flagExLaserOutSize13T;
    }

    public String getRedExCtSize1() {
        return redExCtSize1;
    }

    public void setRedExCtSize1(String redExCtSize1) {
        this.redExCtSize1 = redExCtSize1;
    }

    public String getRedExCtSize2() {
        return redExCtSize2;
    }

    public void setRedExCtSize2(String redExCtSize2) {
        this.redExCtSize2 = redExCtSize2;
    }

    public String getRedExCtSize3() {
        return redExCtSize3;
    }

    public void setRedExCtSize3(String redExCtSize3) {
        this.redExCtSize3 = redExCtSize3;
    }

    public String getRedExCtSize4() {
        return redExCtSize4;
    }

    public void setRedExCtSize4(String redExCtSize4) {
        this.redExCtSize4 = redExCtSize4;
    }

    public String getRedExCtSize5() {
        return redExCtSize5;
    }

    public void setRedExCtSize5(String redExCtSize5) {
        this.redExCtSize5 = redExCtSize5;
    }

    public String getRedExCtSize6() {
        return redExCtSize6;
    }

    public void setRedExCtSize6(String redExCtSize6) {
        this.redExCtSize6 = redExCtSize6;
    }

    public String getRedExCtSize7() {
        return redExCtSize7;
    }

    public void setRedExCtSize7(String redExCtSize7) {
        this.redExCtSize7 = redExCtSize7;
    }

    public String getRedExCtSize8() {
        return redExCtSize8;
    }

    public void setRedExCtSize8(String redExCtSize8) {
        this.redExCtSize8 = redExCtSize8;
    }

    public String getRedExCtSize9() {
        return redExCtSize9;
    }

    public void setRedExCtSize9(String redExCtSize9) {
        this.redExCtSize9 = redExCtSize9;
    }

    public String getRedExCtSize10() {
        return redExCtSize10;
    }

    public void setRedExCtSize10(String redExCtSize10) {
        this.redExCtSize10 = redExCtSize10;
    }

    public String getRedExCtSize11() {
        return redExCtSize11;
    }

    public void setRedExCtSize11(String redExCtSize11) {
        this.redExCtSize11 = redExCtSize11;
    }

    public String getRedExCtSize12() {
        return redExCtSize12;
    }

    public void setRedExCtSize12(String redExCtSize12) {
        this.redExCtSize12 = redExCtSize12;
    }

    public String getRedExCtSize13() {
        return redExCtSize13;
    }

    public void setRedExCtSize13(String redExCtSize13) {
        this.redExCtSize13 = redExCtSize13;
    }

    public String getRedExCtSize14() {
        return redExCtSize14;
    }

    public void setRedExCtSize14(String redExCtSize14) {
        this.redExCtSize14 = redExCtSize14;
    }

    public String getRedExCtSize15() {
        return redExCtSize15;
    }

    public void setRedExCtSize15(String redExCtSize15) {
        this.redExCtSize15 = redExCtSize15;
    }

    public String getRedExCtSize16() {
        return redExCtSize16;
    }

    public void setRedExCtSize16(String redExCtSize16) {
        this.redExCtSize16 = redExCtSize16;
    }

    public String getRedExCtSize17() {
        return redExCtSize17;
    }

    public void setRedExCtSize17(String redExCtSize17) {
        this.redExCtSize17 = redExCtSize17;
    }

    public String getRedExCtSize18() {
        return redExCtSize18;
    }

    public void setRedExCtSize18(String redExCtSize18) {
        this.redExCtSize18 = redExCtSize18;
    }

    public String getRedExCtSize1T() {
        return redExCtSize1T;
    }

    public void setRedExCtSize1T(String redExCtSize1T) {
        this.redExCtSize1T = redExCtSize1T;
    }

    public String getRedExCtSize2T() {
        return redExCtSize2T;
    }

    public void setRedExCtSize2T(String redExCtSize2T) {
        this.redExCtSize2T = redExCtSize2T;
    }

    public String getRedExCtSize3T() {
        return redExCtSize3T;
    }

    public void setRedExCtSize3T(String redExCtSize3T) {
        this.redExCtSize3T = redExCtSize3T;
    }

    public String getRedExCtSize4T() {
        return redExCtSize4T;
    }

    public void setRedExCtSize4T(String redExCtSize4T) {
        this.redExCtSize4T = redExCtSize4T;
    }

    public String getRedExCtSize5T() {
        return redExCtSize5T;
    }

    public void setRedExCtSize5T(String redExCtSize5T) {
        this.redExCtSize5T = redExCtSize5T;
    }

    public String getRedExCtSize6T() {
        return redExCtSize6T;
    }

    public void setRedExCtSize6T(String redExCtSize6T) {
        this.redExCtSize6T = redExCtSize6T;
    }

    public String getRedExCtSize7T() {
        return redExCtSize7T;
    }

    public void setRedExCtSize7T(String redExCtSize7T) {
        this.redExCtSize7T = redExCtSize7T;
    }

    public String getRedExCtSize8T() {
        return redExCtSize8T;
    }

    public void setRedExCtSize8T(String redExCtSize8T) {
        this.redExCtSize8T = redExCtSize8T;
    }

    public String getRedExCtSize9T() {
        return redExCtSize9T;
    }

    public void setRedExCtSize9T(String redExCtSize9T) {
        this.redExCtSize9T = redExCtSize9T;
    }

    public String getRedExCtSize10T() {
        return redExCtSize10T;
    }

    public void setRedExCtSize10T(String redExCtSize10T) {
        this.redExCtSize10T = redExCtSize10T;
    }

    public String getRedExCtSize11T() {
        return redExCtSize11T;
    }

    public void setRedExCtSize11T(String redExCtSize11T) {
        this.redExCtSize11T = redExCtSize11T;
    }

    public String getRedExCtSize12T() {
        return redExCtSize12T;
    }

    public void setRedExCtSize12T(String redExCtSize12T) {
        this.redExCtSize12T = redExCtSize12T;
    }

    public String getRedExCtSize13T() {
        return redExCtSize13T;
    }

    public void setRedExCtSize13T(String redExCtSize13T) {
        this.redExCtSize13T = redExCtSize13T;
    }

    public String getRedExPrepSize1() {
        return redExPrepSize1;
    }

    public void setRedExPrepSize1(String redExPrepSize1) {
        this.redExPrepSize1 = redExPrepSize1;
    }

    public String getRedExPrepSize2() {
        return redExPrepSize2;
    }

    public void setRedExPrepSize2(String redExPrepSize2) {
        this.redExPrepSize2 = redExPrepSize2;
    }

    public String getRedExPrepSize3() {
        return redExPrepSize3;
    }

    public void setRedExPrepSize3(String redExPrepSize3) {
        this.redExPrepSize3 = redExPrepSize3;
    }

    public String getRedExPrepSize4() {
        return redExPrepSize4;
    }

    public void setRedExPrepSize4(String redExPrepSize4) {
        this.redExPrepSize4 = redExPrepSize4;
    }

    public String getRedExPrepSize5() {
        return redExPrepSize5;
    }

    public void setRedExPrepSize5(String redExPrepSize5) {
        this.redExPrepSize5 = redExPrepSize5;
    }

    public String getRedExPrepSize6() {
        return redExPrepSize6;
    }

    public void setRedExPrepSize6(String redExPrepSize6) {
        this.redExPrepSize6 = redExPrepSize6;
    }

    public String getRedExPrepSize7() {
        return redExPrepSize7;
    }

    public void setRedExPrepSize7(String redExPrepSize7) {
        this.redExPrepSize7 = redExPrepSize7;
    }

    public String getRedExPrepSize8() {
        return redExPrepSize8;
    }

    public void setRedExPrepSize8(String redExPrepSize8) {
        this.redExPrepSize8 = redExPrepSize8;
    }

    public String getRedExPrepSize9() {
        return redExPrepSize9;
    }

    public void setRedExPrepSize9(String redExPrepSize9) {
        this.redExPrepSize9 = redExPrepSize9;
    }

    public String getRedExPrepSize10() {
        return redExPrepSize10;
    }

    public void setRedExPrepSize10(String redExPrepSize10) {
        this.redExPrepSize10 = redExPrepSize10;
    }

    public String getRedExPrepSize11() {
        return redExPrepSize11;
    }

    public void setRedExPrepSize11(String redExPrepSize11) {
        this.redExPrepSize11 = redExPrepSize11;
    }

    public String getRedExPrepSize12() {
        return redExPrepSize12;
    }

    public void setRedExPrepSize12(String redExPrepSize12) {
        this.redExPrepSize12 = redExPrepSize12;
    }

    public String getRedExPrepSize13() {
        return redExPrepSize13;
    }

    public void setRedExPrepSize13(String redExPrepSize13) {
        this.redExPrepSize13 = redExPrepSize13;
    }

    public String getRedExPrepSize14() {
        return redExPrepSize14;
    }

    public void setRedExPrepSize14(String redExPrepSize14) {
        this.redExPrepSize14 = redExPrepSize14;
    }

    public String getRedExPrepSize15() {
        return redExPrepSize15;
    }

    public void setRedExPrepSize15(String redExPrepSize15) {
        this.redExPrepSize15 = redExPrepSize15;
    }

    public String getRedExPrepSize16() {
        return redExPrepSize16;
    }

    public void setRedExPrepSize16(String redExPrepSize16) {
        this.redExPrepSize16 = redExPrepSize16;
    }

    public String getRedExPrepSize17() {
        return redExPrepSize17;
    }

    public void setRedExPrepSize17(String redExPrepSize17) {
        this.redExPrepSize17 = redExPrepSize17;
    }

    public String getRedExPrepSize18() {
        return redExPrepSize18;
    }

    public void setRedExPrepSize18(String redExPrepSize18) {
        this.redExPrepSize18 = redExPrepSize18;
    }

    public String getRedExPrepSize1T() {
        return redExPrepSize1T;
    }

    public void setRedExPrepSize1T(String redExPrepSize1T) {
        this.redExPrepSize1T = redExPrepSize1T;
    }

    public String getRedExPrepSize2T() {
        return redExPrepSize2T;
    }

    public void setRedExPrepSize2T(String redExPrepSize2T) {
        this.redExPrepSize2T = redExPrepSize2T;
    }

    public String getRedExPrepSize3T() {
        return redExPrepSize3T;
    }

    public void setRedExPrepSize3T(String redExPrepSize3T) {
        this.redExPrepSize3T = redExPrepSize3T;
    }

    public String getRedExPrepSize4T() {
        return redExPrepSize4T;
    }

    public void setRedExPrepSize4T(String redExPrepSize4T) {
        this.redExPrepSize4T = redExPrepSize4T;
    }

    public String getRedExPrepSize5T() {
        return redExPrepSize5T;
    }

    public void setRedExPrepSize5T(String redExPrepSize5T) {
        this.redExPrepSize5T = redExPrepSize5T;
    }

    public String getRedExPrepSize6T() {
        return redExPrepSize6T;
    }

    public void setRedExPrepSize6T(String redExPrepSize6T) {
        this.redExPrepSize6T = redExPrepSize6T;
    }

    public String getRedExPrepSize7T() {
        return redExPrepSize7T;
    }

    public void setRedExPrepSize7T(String redExPrepSize7T) {
        this.redExPrepSize7T = redExPrepSize7T;
    }

    public String getRedExPrepSize8T() {
        return redExPrepSize8T;
    }

    public void setRedExPrepSize8T(String redExPrepSize8T) {
        this.redExPrepSize8T = redExPrepSize8T;
    }

    public String getRedExPrepSize9T() {
        return redExPrepSize9T;
    }

    public void setRedExPrepSize9T(String redExPrepSize9T) {
        this.redExPrepSize9T = redExPrepSize9T;
    }

    public String getRedExPrepSize10T() {
        return redExPrepSize10T;
    }

    public void setRedExPrepSize10T(String redExPrepSize10T) {
        this.redExPrepSize10T = redExPrepSize10T;
    }

    public String getRedExPrepSize11T() {
        return redExPrepSize11T;
    }

    public void setRedExPrepSize11T(String redExPrepSize11T) {
        this.redExPrepSize11T = redExPrepSize11T;
    }

    public String getRedExPrepSize12T() {
        return redExPrepSize12T;
    }

    public void setRedExPrepSize12T(String redExPrepSize12T) {
        this.redExPrepSize12T = redExPrepSize12T;
    }

    public String getRedExPrepSize13T() {
        return redExPrepSize13T;
    }

    public void setRedExPrepSize13T(String redExPrepSize13T) {
        this.redExPrepSize13T = redExPrepSize13T;
    }

    public String getRedExStSize1() {
        return redExStSize1;
    }

    public void setRedExStSize1(String redExStSize1) {
        this.redExStSize1 = redExStSize1;
    }

    public String getRedExStSize2() {
        return redExStSize2;
    }

    public void setRedExStSize2(String redExStSize2) {
        this.redExStSize2 = redExStSize2;
    }

    public String getRedExStSize3() {
        return redExStSize3;
    }

    public void setRedExStSize3(String redExStSize3) {
        this.redExStSize3 = redExStSize3;
    }

    public String getRedExStSize4() {
        return redExStSize4;
    }

    public void setRedExStSize4(String redExStSize4) {
        this.redExStSize4 = redExStSize4;
    }

    public String getRedExStSize5() {
        return redExStSize5;
    }

    public void setRedExStSize5(String redExStSize5) {
        this.redExStSize5 = redExStSize5;
    }

    public String getRedExStSize6() {
        return redExStSize6;
    }

    public void setRedExStSize6(String redExStSize6) {
        this.redExStSize6 = redExStSize6;
    }

    public String getRedExStSize7() {
        return redExStSize7;
    }

    public void setRedExStSize7(String redExStSize7) {
        this.redExStSize7 = redExStSize7;
    }

    public String getRedExStSize8() {
        return redExStSize8;
    }

    public void setRedExStSize8(String redExStSize8) {
        this.redExStSize8 = redExStSize8;
    }

    public String getRedExStSize9() {
        return redExStSize9;
    }

    public void setRedExStSize9(String redExStSize9) {
        this.redExStSize9 = redExStSize9;
    }

    public String getRedExStSize10() {
        return redExStSize10;
    }

    public void setRedExStSize10(String redExStSize10) {
        this.redExStSize10 = redExStSize10;
    }

    public String getRedExStSize11() {
        return redExStSize11;
    }

    public void setRedExStSize11(String redExStSize11) {
        this.redExStSize11 = redExStSize11;
    }

    public String getRedExStSize12() {
        return redExStSize12;
    }

    public void setRedExStSize12(String redExStSize12) {
        this.redExStSize12 = redExStSize12;
    }

    public String getRedExStSize13() {
        return redExStSize13;
    }

    public void setRedExStSize13(String redExStSize13) {
        this.redExStSize13 = redExStSize13;
    }

    public String getRedExStSize14() {
        return redExStSize14;
    }

    public void setRedExStSize14(String redExStSize14) {
        this.redExStSize14 = redExStSize14;
    }

    public String getRedExStSize15() {
        return redExStSize15;
    }

    public void setRedExStSize15(String redExStSize15) {
        this.redExStSize15 = redExStSize15;
    }

    public String getRedExStSize16() {
        return redExStSize16;
    }

    public void setRedExStSize16(String redExStSize16) {
        this.redExStSize16 = redExStSize16;
    }

    public String getRedExStSize17() {
        return redExStSize17;
    }

    public void setRedExStSize17(String redExStSize17) {
        this.redExStSize17 = redExStSize17;
    }

    public String getRedExStSize18() {
        return redExStSize18;
    }

    public void setRedExStSize18(String redExStSize18) {
        this.redExStSize18 = redExStSize18;
    }

    public String getRedExStSize1T() {
        return redExStSize1T;
    }

    public void setRedExStSize1T(String redExStSize1T) {
        this.redExStSize1T = redExStSize1T;
    }

    public String getRedExStSize2T() {
        return redExStSize2T;
    }

    public void setRedExStSize2T(String redExStSize2T) {
        this.redExStSize2T = redExStSize2T;
    }

    public String getRedExStSize3T() {
        return redExStSize3T;
    }

    public void setRedExStSize3T(String redExStSize3T) {
        this.redExStSize3T = redExStSize3T;
    }

    public String getRedExStSize4T() {
        return redExStSize4T;
    }

    public void setRedExStSize4T(String redExStSize4T) {
        this.redExStSize4T = redExStSize4T;
    }

    public String getRedExStSize5T() {
        return redExStSize5T;
    }

    public void setRedExStSize5T(String redExStSize5T) {
        this.redExStSize5T = redExStSize5T;
    }

    public String getRedExStSize6T() {
        return redExStSize6T;
    }

    public void setRedExStSize6T(String redExStSize6T) {
        this.redExStSize6T = redExStSize6T;
    }

    public String getRedExStSize7T() {
        return redExStSize7T;
    }

    public void setRedExStSize7T(String redExStSize7T) {
        this.redExStSize7T = redExStSize7T;
    }

    public String getRedExStSize8T() {
        return redExStSize8T;
    }

    public void setRedExStSize8T(String redExStSize8T) {
        this.redExStSize8T = redExStSize8T;
    }

    public String getRedExStSize9T() {
        return redExStSize9T;
    }

    public void setRedExStSize9T(String redExStSize9T) {
        this.redExStSize9T = redExStSize9T;
    }

    public String getRedExStSize10T() {
        return redExStSize10T;
    }

    public void setRedExStSize10T(String redExStSize10T) {
        this.redExStSize10T = redExStSize10T;
    }

    public String getRedExStSize11T() {
        return redExStSize11T;
    }

    public void setRedExStSize11T(String redExStSize11T) {
        this.redExStSize11T = redExStSize11T;
    }

    public String getRedExStSize12T() {
        return redExStSize12T;
    }

    public void setRedExStSize12T(String redExStSize12T) {
        this.redExStSize12T = redExStSize12T;
    }

    public String getRedExStSize13T() {
        return redExStSize13T;
    }

    public void setRedExStSize13T(String redExStSize13T) {
        this.redExStSize13T = redExStSize13T;
    }

    public String getRedExAsSize1() {
        return redExAsSize1;
    }

    public void setRedExAsSize1(String redExAsSize1) {
        this.redExAsSize1 = redExAsSize1;
    }

    public String getRedExAsSize2() {
        return redExAsSize2;
    }

    public void setRedExAsSize2(String redExAsSize2) {
        this.redExAsSize2 = redExAsSize2;
    }

    public String getRedExAsSize3() {
        return redExAsSize3;
    }

    public void setRedExAsSize3(String redExAsSize3) {
        this.redExAsSize3 = redExAsSize3;
    }

    public String getRedExAsSize4() {
        return redExAsSize4;
    }

    public void setRedExAsSize4(String redExAsSize4) {
        this.redExAsSize4 = redExAsSize4;
    }

    public String getRedExAsSize5() {
        return redExAsSize5;
    }

    public void setRedExAsSize5(String redExAsSize5) {
        this.redExAsSize5 = redExAsSize5;
    }

    public String getRedExAsSize6() {
        return redExAsSize6;
    }

    public void setRedExAsSize6(String redExAsSize6) {
        this.redExAsSize6 = redExAsSize6;
    }

    public String getRedExAsSize7() {
        return redExAsSize7;
    }

    public void setRedExAsSize7(String redExAsSize7) {
        this.redExAsSize7 = redExAsSize7;
    }

    public String getRedExAsSize8() {
        return redExAsSize8;
    }

    public void setRedExAsSize8(String redExAsSize8) {
        this.redExAsSize8 = redExAsSize8;
    }

    public String getRedExAsSize9() {
        return redExAsSize9;
    }

    public void setRedExAsSize9(String redExAsSize9) {
        this.redExAsSize9 = redExAsSize9;
    }

    public String getRedExAsSize10() {
        return redExAsSize10;
    }

    public void setRedExAsSize10(String redExAsSize10) {
        this.redExAsSize10 = redExAsSize10;
    }

    public String getRedExAsSize11() {
        return redExAsSize11;
    }

    public void setRedExAsSize11(String redExAsSize11) {
        this.redExAsSize11 = redExAsSize11;
    }

    public String getRedExAsSize12() {
        return redExAsSize12;
    }

    public void setRedExAsSize12(String redExAsSize12) {
        this.redExAsSize12 = redExAsSize12;
    }

    public String getRedExAsSize13() {
        return redExAsSize13;
    }

    public void setRedExAsSize13(String redExAsSize13) {
        this.redExAsSize13 = redExAsSize13;
    }

    public String getRedExAsSize14() {
        return redExAsSize14;
    }

    public void setRedExAsSize14(String redExAsSize14) {
        this.redExAsSize14 = redExAsSize14;
    }

    public String getRedExAsSize15() {
        return redExAsSize15;
    }

    public void setRedExAsSize15(String redExAsSize15) {
        this.redExAsSize15 = redExAsSize15;
    }

    public String getRedExAsSize16() {
        return redExAsSize16;
    }

    public void setRedExAsSize16(String redExAsSize16) {
        this.redExAsSize16 = redExAsSize16;
    }

    public String getRedExAsSize17() {
        return redExAsSize17;
    }

    public void setRedExAsSize17(String redExAsSize17) {
        this.redExAsSize17 = redExAsSize17;
    }

    public String getRedExAsSize18() {
        return redExAsSize18;
    }

    public void setRedExAsSize18(String redExAsSize18) {
        this.redExAsSize18 = redExAsSize18;
    }

    public String getRedExAsSize1T() {
        return redExAsSize1T;
    }

    public void setRedExAsSize1T(String redExAsSize1T) {
        this.redExAsSize1T = redExAsSize1T;
    }

    public String getRedExAsSize2T() {
        return redExAsSize2T;
    }

    public void setRedExAsSize2T(String redExAsSize2T) {
        this.redExAsSize2T = redExAsSize2T;
    }

    public String getRedExAsSize3T() {
        return redExAsSize3T;
    }

    public void setRedExAsSize3T(String redExAsSize3T) {
        this.redExAsSize3T = redExAsSize3T;
    }

    public String getRedExAsSize4T() {
        return redExAsSize4T;
    }

    public void setRedExAsSize4T(String redExAsSize4T) {
        this.redExAsSize4T = redExAsSize4T;
    }

    public String getRedExAsSize5T() {
        return redExAsSize5T;
    }

    public void setRedExAsSize5T(String redExAsSize5T) {
        this.redExAsSize5T = redExAsSize5T;
    }

    public String getRedExAsSize6T() {
        return redExAsSize6T;
    }

    public void setRedExAsSize6T(String redExAsSize6T) {
        this.redExAsSize6T = redExAsSize6T;
    }

    public String getRedExAsSize7T() {
        return redExAsSize7T;
    }

    public void setRedExAsSize7T(String redExAsSize7T) {
        this.redExAsSize7T = redExAsSize7T;
    }

    public String getRedExAsSize8T() {
        return redExAsSize8T;
    }

    public void setRedExAsSize8T(String redExAsSize8T) {
        this.redExAsSize8T = redExAsSize8T;
    }

    public String getRedExAsSize9T() {
        return redExAsSize9T;
    }

    public void setRedExAsSize9T(String redExAsSize9T) {
        this.redExAsSize9T = redExAsSize9T;
    }

    public String getRedExAsSize10T() {
        return redExAsSize10T;
    }

    public void setRedExAsSize10T(String redExAsSize10T) {
        this.redExAsSize10T = redExAsSize10T;
    }

    public String getRedExAsSize11T() {
        return redExAsSize11T;
    }

    public void setRedExAsSize11T(String redExAsSize11T) {
        this.redExAsSize11T = redExAsSize11T;
    }

    public String getRedExAsSize12T() {
        return redExAsSize12T;
    }

    public void setRedExAsSize12T(String redExAsSize12T) {
        this.redExAsSize12T = redExAsSize12T;
    }

    public String getRedExAsSize13T() {
        return redExAsSize13T;
    }

    public void setRedExAsSize13T(String redExAsSize13T) {
        this.redExAsSize13T = redExAsSize13T;
    }

    public String getRedExCscSize1() {
        return redExCscSize1;
    }

    public void setRedExCscSize1(String redExCscSize1) {
        this.redExCscSize1 = redExCscSize1;
    }

    public String getRedExCscSize2() {
        return redExCscSize2;
    }

    public void setRedExCscSize2(String redExCscSize2) {
        this.redExCscSize2 = redExCscSize2;
    }

    public String getRedExCscSize3() {
        return redExCscSize3;
    }

    public void setRedExCscSize3(String redExCscSize3) {
        this.redExCscSize3 = redExCscSize3;
    }

    public String getRedExCscSize4() {
        return redExCscSize4;
    }

    public void setRedExCscSize4(String redExCscSize4) {
        this.redExCscSize4 = redExCscSize4;
    }

    public String getRedExCscSize5() {
        return redExCscSize5;
    }

    public void setRedExCscSize5(String redExCscSize5) {
        this.redExCscSize5 = redExCscSize5;
    }

    public String getRedExCscSize6() {
        return redExCscSize6;
    }

    public void setRedExCscSize6(String redExCscSize6) {
        this.redExCscSize6 = redExCscSize6;
    }

    public String getRedExCscSize7() {
        return redExCscSize7;
    }

    public void setRedExCscSize7(String redExCscSize7) {
        this.redExCscSize7 = redExCscSize7;
    }

    public String getRedExCscSize8() {
        return redExCscSize8;
    }

    public void setRedExCscSize8(String redExCscSize8) {
        this.redExCscSize8 = redExCscSize8;
    }

    public String getRedExCscSize9() {
        return redExCscSize9;
    }

    public void setRedExCscSize9(String redExCscSize9) {
        this.redExCscSize9 = redExCscSize9;
    }

    public String getRedExCscSize10() {
        return redExCscSize10;
    }

    public void setRedExCscSize10(String redExCscSize10) {
        this.redExCscSize10 = redExCscSize10;
    }

    public String getRedExCscSize11() {
        return redExCscSize11;
    }

    public void setRedExCscSize11(String redExCscSize11) {
        this.redExCscSize11 = redExCscSize11;
    }

    public String getRedExCscSize12() {
        return redExCscSize12;
    }

    public void setRedExCscSize12(String redExCscSize12) {
        this.redExCscSize12 = redExCscSize12;
    }

    public String getRedExCscSize13() {
        return redExCscSize13;
    }

    public void setRedExCscSize13(String redExCscSize13) {
        this.redExCscSize13 = redExCscSize13;
    }

    public String getRedExCscSize14() {
        return redExCscSize14;
    }

    public void setRedExCscSize14(String redExCscSize14) {
        this.redExCscSize14 = redExCscSize14;
    }

    public String getRedExCscSize15() {
        return redExCscSize15;
    }

    public void setRedExCscSize15(String redExCscSize15) {
        this.redExCscSize15 = redExCscSize15;
    }

    public String getRedExCscSize16() {
        return redExCscSize16;
    }

    public void setRedExCscSize16(String redExCscSize16) {
        this.redExCscSize16 = redExCscSize16;
    }

    public String getRedExCscSize17() {
        return redExCscSize17;
    }

    public void setRedExCscSize17(String redExCscSize17) {
        this.redExCscSize17 = redExCscSize17;
    }

    public String getRedExCscSize18() {
        return redExCscSize18;
    }

    public void setRedExCscSize18(String redExCscSize18) {
        this.redExCscSize18 = redExCscSize18;
    }

    public String getRedExCscSize1T() {
        return redExCscSize1T;
    }

    public void setRedExCscSize1T(String redExCscSize1T) {
        this.redExCscSize1T = redExCscSize1T;
    }

    public String getRedExCscSize2T() {
        return redExCscSize2T;
    }

    public void setRedExCscSize2T(String redExCscSize2T) {
        this.redExCscSize2T = redExCscSize2T;
    }

    public String getRedExCscSize3T() {
        return redExCscSize3T;
    }

    public void setRedExCscSize3T(String redExCscSize3T) {
        this.redExCscSize3T = redExCscSize3T;
    }

    public String getRedExCscSize4T() {
        return redExCscSize4T;
    }

    public void setRedExCscSize4T(String redExCscSize4T) {
        this.redExCscSize4T = redExCscSize4T;
    }

    public String getRedExCscSize5T() {
        return redExCscSize5T;
    }

    public void setRedExCscSize5T(String redExCscSize5T) {
        this.redExCscSize5T = redExCscSize5T;
    }

    public String getRedExCscSize6T() {
        return redExCscSize6T;
    }

    public void setRedExCscSize6T(String redExCscSize6T) {
        this.redExCscSize6T = redExCscSize6T;
    }

    public String getRedExCscSize7T() {
        return redExCscSize7T;
    }

    public void setRedExCscSize7T(String redExCscSize7T) {
        this.redExCscSize7T = redExCscSize7T;
    }

    public String getRedExCscSize8T() {
        return redExCscSize8T;
    }

    public void setRedExCscSize8T(String redExCscSize8T) {
        this.redExCscSize8T = redExCscSize8T;
    }

    public String getRedExCscSize9T() {
        return redExCscSize9T;
    }

    public void setRedExCscSize9T(String redExCscSize9T) {
        this.redExCscSize9T = redExCscSize9T;
    }

    public String getRedExCscSize10T() {
        return redExCscSize10T;
    }

    public void setRedExCscSize10T(String redExCscSize10T) {
        this.redExCscSize10T = redExCscSize10T;
    }

    public String getRedExCscSize11T() {
        return redExCscSize11T;
    }

    public void setRedExCscSize11T(String redExCscSize11T) {
        this.redExCscSize11T = redExCscSize11T;
    }

    public String getRedExCscSize12T() {
        return redExCscSize12T;
    }

    public void setRedExCscSize12T(String redExCscSize12T) {
        this.redExCscSize12T = redExCscSize12T;
    }

    public String getRedExCscSize13T() {
        return redExCscSize13T;
    }

    public void setRedExCscSize13T(String redExCscSize13T) {
        this.redExCscSize13T = redExCscSize13T;
    }

    public String getRedExNsSize1() {
        return redExNsSize1;
    }

    public void setRedExNsSize1(String redExNsSize1) {
        this.redExNsSize1 = redExNsSize1;
    }

    public String getRedExNsSize2() {
        return redExNsSize2;
    }

    public void setRedExNsSize2(String redExNsSize2) {
        this.redExNsSize2 = redExNsSize2;
    }

    public String getRedExNsSize3() {
        return redExNsSize3;
    }

    public void setRedExNsSize3(String redExNsSize3) {
        this.redExNsSize3 = redExNsSize3;
    }

    public String getRedExNsSize4() {
        return redExNsSize4;
    }

    public void setRedExNsSize4(String redExNsSize4) {
        this.redExNsSize4 = redExNsSize4;
    }

    public String getRedExNsSize5() {
        return redExNsSize5;
    }

    public void setRedExNsSize5(String redExNsSize5) {
        this.redExNsSize5 = redExNsSize5;
    }

    public String getRedExNsSize6() {
        return redExNsSize6;
    }

    public void setRedExNsSize6(String redExNsSize6) {
        this.redExNsSize6 = redExNsSize6;
    }

    public String getRedExNsSize7() {
        return redExNsSize7;
    }

    public void setRedExNsSize7(String redExNsSize7) {
        this.redExNsSize7 = redExNsSize7;
    }

    public String getRedExNsSize8() {
        return redExNsSize8;
    }

    public void setRedExNsSize8(String redExNsSize8) {
        this.redExNsSize8 = redExNsSize8;
    }

    public String getRedExNsSize9() {
        return redExNsSize9;
    }

    public void setRedExNsSize9(String redExNsSize9) {
        this.redExNsSize9 = redExNsSize9;
    }

    public String getRedExNsSize10() {
        return redExNsSize10;
    }

    public void setRedExNsSize10(String redExNsSize10) {
        this.redExNsSize10 = redExNsSize10;
    }

    public String getRedExNsSize11() {
        return redExNsSize11;
    }

    public void setRedExNsSize11(String redExNsSize11) {
        this.redExNsSize11 = redExNsSize11;
    }

    public String getRedExNsSize12() {
        return redExNsSize12;
    }

    public void setRedExNsSize12(String redExNsSize12) {
        this.redExNsSize12 = redExNsSize12;
    }

    public String getRedExNsSize13() {
        return redExNsSize13;
    }

    public void setRedExNsSize13(String redExNsSize13) {
        this.redExNsSize13 = redExNsSize13;
    }

    public String getRedExNsSize14() {
        return redExNsSize14;
    }

    public void setRedExNsSize14(String redExNsSize14) {
        this.redExNsSize14 = redExNsSize14;
    }

    public String getRedExNsSize15() {
        return redExNsSize15;
    }

    public void setRedExNsSize15(String redExNsSize15) {
        this.redExNsSize15 = redExNsSize15;
    }

    public String getRedExNsSize16() {
        return redExNsSize16;
    }

    public void setRedExNsSize16(String redExNsSize16) {
        this.redExNsSize16 = redExNsSize16;
    }

    public String getRedExNsSize17() {
        return redExNsSize17;
    }

    public void setRedExNsSize17(String redExNsSize17) {
        this.redExNsSize17 = redExNsSize17;
    }

    public String getRedExNsSize18() {
        return redExNsSize18;
    }

    public void setRedExNsSize18(String redExNsSize18) {
        this.redExNsSize18 = redExNsSize18;
    }

    public String getRedExNsSize1T() {
        return redExNsSize1T;
    }

    public void setRedExNsSize1T(String redExNsSize1T) {
        this.redExNsSize1T = redExNsSize1T;
    }

    public String getRedExNsSize2T() {
        return redExNsSize2T;
    }

    public void setRedExNsSize2T(String redExNsSize2T) {
        this.redExNsSize2T = redExNsSize2T;
    }

    public String getRedExNsSize3T() {
        return redExNsSize3T;
    }

    public void setRedExNsSize3T(String redExNsSize3T) {
        this.redExNsSize3T = redExNsSize3T;
    }

    public String getRedExNsSize4T() {
        return redExNsSize4T;
    }

    public void setRedExNsSize4T(String redExNsSize4T) {
        this.redExNsSize4T = redExNsSize4T;
    }

    public String getRedExNsSize5T() {
        return redExNsSize5T;
    }

    public void setRedExNsSize5T(String redExNsSize5T) {
        this.redExNsSize5T = redExNsSize5T;
    }

    public String getRedExNsSize6T() {
        return redExNsSize6T;
    }

    public void setRedExNsSize6T(String redExNsSize6T) {
        this.redExNsSize6T = redExNsSize6T;
    }

    public String getRedExNsSize7T() {
        return redExNsSize7T;
    }

    public void setRedExNsSize7T(String redExNsSize7T) {
        this.redExNsSize7T = redExNsSize7T;
    }

    public String getRedExNsSize8T() {
        return redExNsSize8T;
    }

    public void setRedExNsSize8T(String redExNsSize8T) {
        this.redExNsSize8T = redExNsSize8T;
    }

    public String getRedExNsSize9T() {
        return redExNsSize9T;
    }

    public void setRedExNsSize9T(String redExNsSize9T) {
        this.redExNsSize9T = redExNsSize9T;
    }

    public String getRedExNsSize10T() {
        return redExNsSize10T;
    }

    public void setRedExNsSize10T(String redExNsSize10T) {
        this.redExNsSize10T = redExNsSize10T;
    }

    public String getRedExNsSize11T() {
        return redExNsSize11T;
    }

    public void setRedExNsSize11T(String redExNsSize11T) {
        this.redExNsSize11T = redExNsSize11T;
    }

    public String getRedExNsSize12T() {
        return redExNsSize12T;
    }

    public void setRedExNsSize12T(String redExNsSize12T) {
        this.redExNsSize12T = redExNsSize12T;
    }

    public String getRedExNsSize13T() {
        return redExNsSize13T;
    }

    public void setRedExNsSize13T(String redExNsSize13T) {
        this.redExNsSize13T = redExNsSize13T;
    }

    public String getRedExScSize1() {
        return redExScSize1;
    }

    public void setRedExScSize1(String redExScSize1) {
        this.redExScSize1 = redExScSize1;
    }

    public String getRedExScSize2() {
        return redExScSize2;
    }

    public void setRedExScSize2(String redExScSize2) {
        this.redExScSize2 = redExScSize2;
    }

    public String getRedExScSize3() {
        return redExScSize3;
    }

    public void setRedExScSize3(String redExScSize3) {
        this.redExScSize3 = redExScSize3;
    }

    public String getRedExScSize4() {
        return redExScSize4;
    }

    public void setRedExScSize4(String redExScSize4) {
        this.redExScSize4 = redExScSize4;
    }

    public String getRedExScSize5() {
        return redExScSize5;
    }

    public void setRedExScSize5(String redExScSize5) {
        this.redExScSize5 = redExScSize5;
    }

    public String getRedExScSize6() {
        return redExScSize6;
    }

    public void setRedExScSize6(String redExScSize6) {
        this.redExScSize6 = redExScSize6;
    }

    public String getRedExScSize7() {
        return redExScSize7;
    }

    public void setRedExScSize7(String redExScSize7) {
        this.redExScSize7 = redExScSize7;
    }

    public String getRedExScSize8() {
        return redExScSize8;
    }

    public void setRedExScSize8(String redExScSize8) {
        this.redExScSize8 = redExScSize8;
    }

    public String getRedExScSize9() {
        return redExScSize9;
    }

    public void setRedExScSize9(String redExScSize9) {
        this.redExScSize9 = redExScSize9;
    }

    public String getRedExScSize10() {
        return redExScSize10;
    }

    public void setRedExScSize10(String redExScSize10) {
        this.redExScSize10 = redExScSize10;
    }

    public String getRedExScSize11() {
        return redExScSize11;
    }

    public void setRedExScSize11(String redExScSize11) {
        this.redExScSize11 = redExScSize11;
    }

    public String getRedExScSize12() {
        return redExScSize12;
    }

    public void setRedExScSize12(String redExScSize12) {
        this.redExScSize12 = redExScSize12;
    }

    public String getRedExScSize13() {
        return redExScSize13;
    }

    public void setRedExScSize13(String redExScSize13) {
        this.redExScSize13 = redExScSize13;
    }

    public String getRedExScSize14() {
        return redExScSize14;
    }

    public void setRedExScSize14(String redExScSize14) {
        this.redExScSize14 = redExScSize14;
    }

    public String getRedExScSize15() {
        return redExScSize15;
    }

    public void setRedExScSize15(String redExScSize15) {
        this.redExScSize15 = redExScSize15;
    }

    public String getRedExScSize16() {
        return redExScSize16;
    }

    public void setRedExScSize16(String redExScSize16) {
        this.redExScSize16 = redExScSize16;
    }

    public String getRedExScSize17() {
        return redExScSize17;
    }

    public void setRedExScSize17(String redExScSize17) {
        this.redExScSize17 = redExScSize17;
    }

    public String getRedExScSize18() {
        return redExScSize18;
    }

    public void setRedExScSize18(String redExScSize18) {
        this.redExScSize18 = redExScSize18;
    }

    public String getRedExScSize1T() {
        return redExScSize1T;
    }

    public void setRedExScSize1T(String redExScSize1T) {
        this.redExScSize1T = redExScSize1T;
    }

    public String getRedExScSize2T() {
        return redExScSize2T;
    }

    public void setRedExScSize2T(String redExScSize2T) {
        this.redExScSize2T = redExScSize2T;
    }

    public String getRedExScSize3T() {
        return redExScSize3T;
    }

    public void setRedExScSize3T(String redExScSize3T) {
        this.redExScSize3T = redExScSize3T;
    }

    public String getRedExScSize4T() {
        return redExScSize4T;
    }

    public void setRedExScSize4T(String redExScSize4T) {
        this.redExScSize4T = redExScSize4T;
    }

    public String getRedExScSize5T() {
        return redExScSize5T;
    }

    public void setRedExScSize5T(String redExScSize5T) {
        this.redExScSize5T = redExScSize5T;
    }

    public String getRedExScSize6T() {
        return redExScSize6T;
    }

    public void setRedExScSize6T(String redExScSize6T) {
        this.redExScSize6T = redExScSize6T;
    }

    public String getRedExScSize7T() {
        return redExScSize7T;
    }

    public void setRedExScSize7T(String redExScSize7T) {
        this.redExScSize7T = redExScSize7T;
    }

    public String getRedExScSize8T() {
        return redExScSize8T;
    }

    public void setRedExScSize8T(String redExScSize8T) {
        this.redExScSize8T = redExScSize8T;
    }

    public String getRedExScSize9T() {
        return redExScSize9T;
    }

    public void setRedExScSize9T(String redExScSize9T) {
        this.redExScSize9T = redExScSize9T;
    }

    public String getRedExScSize10T() {
        return redExScSize10T;
    }

    public void setRedExScSize10T(String redExScSize10T) {
        this.redExScSize10T = redExScSize10T;
    }

    public String getRedExScSize11T() {
        return redExScSize11T;
    }

    public void setRedExScSize11T(String redExScSize11T) {
        this.redExScSize11T = redExScSize11T;
    }

    public String getRedExScSize12T() {
        return redExScSize12T;
    }

    public void setRedExScSize12T(String redExScSize12T) {
        this.redExScSize12T = redExScSize12T;
    }

    public String getRedExScSize13T() {
        return redExScSize13T;
    }

    public void setRedExScSize13T(String redExScSize13T) {
        this.redExScSize13T = redExScSize13T;
    }

    public String getRedExOsSize1() {
        return redExOsSize1;
    }

    public void setRedExOsSize1(String redExOsSize1) {
        this.redExOsSize1 = redExOsSize1;
    }

    public String getRedExOsSize2() {
        return redExOsSize2;
    }

    public void setRedExOsSize2(String redExOsSize2) {
        this.redExOsSize2 = redExOsSize2;
    }

    public String getRedExOsSize3() {
        return redExOsSize3;
    }

    public void setRedExOsSize3(String redExOsSize3) {
        this.redExOsSize3 = redExOsSize3;
    }

    public String getRedExOsSize4() {
        return redExOsSize4;
    }

    public void setRedExOsSize4(String redExOsSize4) {
        this.redExOsSize4 = redExOsSize4;
    }

    public String getRedExOsSize5() {
        return redExOsSize5;
    }

    public void setRedExOsSize5(String redExOsSize5) {
        this.redExOsSize5 = redExOsSize5;
    }

    public String getRedExOsSize6() {
        return redExOsSize6;
    }

    public void setRedExOsSize6(String redExOsSize6) {
        this.redExOsSize6 = redExOsSize6;
    }

    public String getRedExOsSize7() {
        return redExOsSize7;
    }

    public void setRedExOsSize7(String redExOsSize7) {
        this.redExOsSize7 = redExOsSize7;
    }

    public String getRedExOsSize8() {
        return redExOsSize8;
    }

    public void setRedExOsSize8(String redExOsSize8) {
        this.redExOsSize8 = redExOsSize8;
    }

    public String getRedExOsSize9() {
        return redExOsSize9;
    }

    public void setRedExOsSize9(String redExOsSize9) {
        this.redExOsSize9 = redExOsSize9;
    }

    public String getRedExOsSize10() {
        return redExOsSize10;
    }

    public void setRedExOsSize10(String redExOsSize10) {
        this.redExOsSize10 = redExOsSize10;
    }

    public String getRedExOsSize11() {
        return redExOsSize11;
    }

    public void setRedExOsSize11(String redExOsSize11) {
        this.redExOsSize11 = redExOsSize11;
    }

    public String getRedExOsSize12() {
        return redExOsSize12;
    }

    public void setRedExOsSize12(String redExOsSize12) {
        this.redExOsSize12 = redExOsSize12;
    }

    public String getRedExOsSize13() {
        return redExOsSize13;
    }

    public void setRedExOsSize13(String redExOsSize13) {
        this.redExOsSize13 = redExOsSize13;
    }

    public String getRedExOsSize14() {
        return redExOsSize14;
    }

    public void setRedExOsSize14(String redExOsSize14) {
        this.redExOsSize14 = redExOsSize14;
    }

    public String getRedExOsSize15() {
        return redExOsSize15;
    }

    public void setRedExOsSize15(String redExOsSize15) {
        this.redExOsSize15 = redExOsSize15;
    }

    public String getRedExOsSize16() {
        return redExOsSize16;
    }

    public void setRedExOsSize16(String redExOsSize16) {
        this.redExOsSize16 = redExOsSize16;
    }

    public String getRedExOsSize17() {
        return redExOsSize17;
    }

    public void setRedExOsSize17(String redExOsSize17) {
        this.redExOsSize17 = redExOsSize17;
    }

    public String getRedExOsSize18() {
        return redExOsSize18;
    }

    public void setRedExOsSize18(String redExOsSize18) {
        this.redExOsSize18 = redExOsSize18;
    }

    public String getRedExOsSize1T() {
        return redExOsSize1T;
    }

    public void setRedExOsSize1T(String redExOsSize1T) {
        this.redExOsSize1T = redExOsSize1T;
    }

    public String getRedExOsSize2T() {
        return redExOsSize2T;
    }

    public void setRedExOsSize2T(String redExOsSize2T) {
        this.redExOsSize2T = redExOsSize2T;
    }

    public String getRedExOsSize3T() {
        return redExOsSize3T;
    }

    public void setRedExOsSize3T(String redExOsSize3T) {
        this.redExOsSize3T = redExOsSize3T;
    }

    public String getRedExOsSize4T() {
        return redExOsSize4T;
    }

    public void setRedExOsSize4T(String redExOsSize4T) {
        this.redExOsSize4T = redExOsSize4T;
    }

    public String getRedExOsSize5T() {
        return redExOsSize5T;
    }

    public void setRedExOsSize5T(String redExOsSize5T) {
        this.redExOsSize5T = redExOsSize5T;
    }

    public String getRedExOsSize6T() {
        return redExOsSize6T;
    }

    public void setRedExOsSize6T(String redExOsSize6T) {
        this.redExOsSize6T = redExOsSize6T;
    }

    public String getRedExOsSize7T() {
        return redExOsSize7T;
    }

    public void setRedExOsSize7T(String redExOsSize7T) {
        this.redExOsSize7T = redExOsSize7T;
    }

    public String getRedExOsSize8T() {
        return redExOsSize8T;
    }

    public void setRedExOsSize8T(String redExOsSize8T) {
        this.redExOsSize8T = redExOsSize8T;
    }

    public String getRedExOsSize9T() {
        return redExOsSize9T;
    }

    public void setRedExOsSize9T(String redExOsSize9T) {
        this.redExOsSize9T = redExOsSize9T;
    }

    public String getRedExOsSize10T() {
        return redExOsSize10T;
    }

    public void setRedExOsSize10T(String redExOsSize10T) {
        this.redExOsSize10T = redExOsSize10T;
    }

    public String getRedExOsSize11T() {
        return redExOsSize11T;
    }

    public void setRedExOsSize11T(String redExOsSize11T) {
        this.redExOsSize11T = redExOsSize11T;
    }

    public String getRedExOsSize12T() {
        return redExOsSize12T;
    }

    public void setRedExOsSize12T(String redExOsSize12T) {
        this.redExOsSize12T = redExOsSize12T;
    }

    public String getRedExOsSize13T() {
        return redExOsSize13T;
    }

    public void setRedExOsSize13T(String redExOsSize13T) {
        this.redExOsSize13T = redExOsSize13T;
    }

    public String getRedExSpcutSize1() {
        return redExSpcutSize1;
    }

    public void setRedExSpcutSize1(String redExSpcutSize1) {
        this.redExSpcutSize1 = redExSpcutSize1;
    }

    public String getRedExSpcutSize2() {
        return redExSpcutSize2;
    }

    public void setRedExSpcutSize2(String redExSpcutSize2) {
        this.redExSpcutSize2 = redExSpcutSize2;
    }

    public String getRedExSpcutSize3() {
        return redExSpcutSize3;
    }

    public void setRedExSpcutSize3(String redExSpcutSize3) {
        this.redExSpcutSize3 = redExSpcutSize3;
    }

    public String getRedExSpcutSize4() {
        return redExSpcutSize4;
    }

    public void setRedExSpcutSize4(String redExSpcutSize4) {
        this.redExSpcutSize4 = redExSpcutSize4;
    }

    public String getRedExSpcutSize5() {
        return redExSpcutSize5;
    }

    public void setRedExSpcutSize5(String redExSpcutSize5) {
        this.redExSpcutSize5 = redExSpcutSize5;
    }

    public String getRedExSpcutSize6() {
        return redExSpcutSize6;
    }

    public void setRedExSpcutSize6(String redExSpcutSize6) {
        this.redExSpcutSize6 = redExSpcutSize6;
    }

    public String getRedExSpcutSize7() {
        return redExSpcutSize7;
    }

    public void setRedExSpcutSize7(String redExSpcutSize7) {
        this.redExSpcutSize7 = redExSpcutSize7;
    }

    public String getRedExSpcutSize8() {
        return redExSpcutSize8;
    }

    public void setRedExSpcutSize8(String redExSpcutSize8) {
        this.redExSpcutSize8 = redExSpcutSize8;
    }

    public String getRedExSpcutSize9() {
        return redExSpcutSize9;
    }

    public void setRedExSpcutSize9(String redExSpcutSize9) {
        this.redExSpcutSize9 = redExSpcutSize9;
    }

    public String getRedExSpcutSize10() {
        return redExSpcutSize10;
    }

    public void setRedExSpcutSize10(String redExSpcutSize10) {
        this.redExSpcutSize10 = redExSpcutSize10;
    }

    public String getRedExSpcutSize11() {
        return redExSpcutSize11;
    }

    public void setRedExSpcutSize11(String redExSpcutSize11) {
        this.redExSpcutSize11 = redExSpcutSize11;
    }

    public String getRedExSpcutSize12() {
        return redExSpcutSize12;
    }

    public void setRedExSpcutSize12(String redExSpcutSize12) {
        this.redExSpcutSize12 = redExSpcutSize12;
    }

    public String getRedExSpcutSize13() {
        return redExSpcutSize13;
    }

    public void setRedExSpcutSize13(String redExSpcutSize13) {
        this.redExSpcutSize13 = redExSpcutSize13;
    }

    public String getRedExSpcutSize14() {
        return redExSpcutSize14;
    }

    public void setRedExSpcutSize14(String redExSpcutSize14) {
        this.redExSpcutSize14 = redExSpcutSize14;
    }

    public String getRedExSpcutSize15() {
        return redExSpcutSize15;
    }

    public void setRedExSpcutSize15(String redExSpcutSize15) {
        this.redExSpcutSize15 = redExSpcutSize15;
    }

    public String getRedExSpcutSize16() {
        return redExSpcutSize16;
    }

    public void setRedExSpcutSize16(String redExSpcutSize16) {
        this.redExSpcutSize16 = redExSpcutSize16;
    }

    public String getRedExSpcutSize17() {
        return redExSpcutSize17;
    }

    public void setRedExSpcutSize17(String redExSpcutSize17) {
        this.redExSpcutSize17 = redExSpcutSize17;
    }

    public String getRedExSpcutSize18() {
        return redExSpcutSize18;
    }

    public void setRedExSpcutSize18(String redExSpcutSize18) {
        this.redExSpcutSize18 = redExSpcutSize18;
    }

    public String getRedExSpcutSize1T() {
        return redExSpcutSize1T;
    }

    public void setRedExSpcutSize1T(String redExSpcutSize1T) {
        this.redExSpcutSize1T = redExSpcutSize1T;
    }

    public String getRedExSpcutSize2T() {
        return redExSpcutSize2T;
    }

    public void setRedExSpcutSize2T(String redExSpcutSize2T) {
        this.redExSpcutSize2T = redExSpcutSize2T;
    }

    public String getRedExSpcutSize3T() {
        return redExSpcutSize3T;
    }

    public void setRedExSpcutSize3T(String redExSpcutSize3T) {
        this.redExSpcutSize3T = redExSpcutSize3T;
    }

    public String getRedExSpcutSize4T() {
        return redExSpcutSize4T;
    }

    public void setRedExSpcutSize4T(String redExSpcutSize4T) {
        this.redExSpcutSize4T = redExSpcutSize4T;
    }

    public String getRedExSpcutSize5T() {
        return redExSpcutSize5T;
    }

    public void setRedExSpcutSize5T(String redExSpcutSize5T) {
        this.redExSpcutSize5T = redExSpcutSize5T;
    }

    public String getRedExSpcutSize6T() {
        return redExSpcutSize6T;
    }

    public void setRedExSpcutSize6T(String redExSpcutSize6T) {
        this.redExSpcutSize6T = redExSpcutSize6T;
    }

    public String getRedExSpcutSize7T() {
        return redExSpcutSize7T;
    }

    public void setRedExSpcutSize7T(String redExSpcutSize7T) {
        this.redExSpcutSize7T = redExSpcutSize7T;
    }

    public String getRedExSpcutSize8T() {
        return redExSpcutSize8T;
    }

    public void setRedExSpcutSize8T(String redExSpcutSize8T) {
        this.redExSpcutSize8T = redExSpcutSize8T;
    }

    public String getRedExSpcutSize9T() {
        return redExSpcutSize9T;
    }

    public void setRedExSpcutSize9T(String redExSpcutSize9T) {
        this.redExSpcutSize9T = redExSpcutSize9T;
    }

    public String getRedExSpcutSize10T() {
        return redExSpcutSize10T;
    }

    public void setRedExSpcutSize10T(String redExSpcutSize10T) {
        this.redExSpcutSize10T = redExSpcutSize10T;
    }

    public String getRedExSpcutSize11T() {
        return redExSpcutSize11T;
    }

    public void setRedExSpcutSize11T(String redExSpcutSize11T) {
        this.redExSpcutSize11T = redExSpcutSize11T;
    }

    public String getRedExSpcutSize12T() {
        return redExSpcutSize12T;
    }

    public void setRedExSpcutSize12T(String redExSpcutSize12T) {
        this.redExSpcutSize12T = redExSpcutSize12T;
    }

    public String getRedExSpcutSize13T() {
        return redExSpcutSize13T;
    }

    public void setRedExSpcutSize13T(String redExSpcutSize13T) {
        this.redExSpcutSize13T = redExSpcutSize13T;
    }

    public String getRedExSpprepSize1() {
        return redExSpprepSize1;
    }

    public void setRedExSpprepSize1(String redExSpprepSize1) {
        this.redExSpprepSize1 = redExSpprepSize1;
    }

    public String getRedExSpprepSize2() {
        return redExSpprepSize2;
    }

    public void setRedExSpprepSize2(String redExSpprepSize2) {
        this.redExSpprepSize2 = redExSpprepSize2;
    }

    public String getRedExSpprepSize3() {
        return redExSpprepSize3;
    }

    public void setRedExSpprepSize3(String redExSpprepSize3) {
        this.redExSpprepSize3 = redExSpprepSize3;
    }

    public String getRedExSpprepSize4() {
        return redExSpprepSize4;
    }

    public void setRedExSpprepSize4(String redExSpprepSize4) {
        this.redExSpprepSize4 = redExSpprepSize4;
    }

    public String getRedExSpprepSize5() {
        return redExSpprepSize5;
    }

    public void setRedExSpprepSize5(String redExSpprepSize5) {
        this.redExSpprepSize5 = redExSpprepSize5;
    }

    public String getRedExSpprepSize6() {
        return redExSpprepSize6;
    }

    public void setRedExSpprepSize6(String redExSpprepSize6) {
        this.redExSpprepSize6 = redExSpprepSize6;
    }

    public String getRedExSpprepSize7() {
        return redExSpprepSize7;
    }

    public void setRedExSpprepSize7(String redExSpprepSize7) {
        this.redExSpprepSize7 = redExSpprepSize7;
    }

    public String getRedExSpprepSize8() {
        return redExSpprepSize8;
    }

    public void setRedExSpprepSize8(String redExSpprepSize8) {
        this.redExSpprepSize8 = redExSpprepSize8;
    }

    public String getRedExSpprepSize9() {
        return redExSpprepSize9;
    }

    public void setRedExSpprepSize9(String redExSpprepSize9) {
        this.redExSpprepSize9 = redExSpprepSize9;
    }

    public String getRedExSpprepSize10() {
        return redExSpprepSize10;
    }

    public void setRedExSpprepSize10(String redExSpprepSize10) {
        this.redExSpprepSize10 = redExSpprepSize10;
    }

    public String getRedExSpprepSize11() {
        return redExSpprepSize11;
    }

    public void setRedExSpprepSize11(String redExSpprepSize11) {
        this.redExSpprepSize11 = redExSpprepSize11;
    }

    public String getRedExSpprepSize12() {
        return redExSpprepSize12;
    }

    public void setRedExSpprepSize12(String redExSpprepSize12) {
        this.redExSpprepSize12 = redExSpprepSize12;
    }

    public String getRedExSpprepSize13() {
        return redExSpprepSize13;
    }

    public void setRedExSpprepSize13(String redExSpprepSize13) {
        this.redExSpprepSize13 = redExSpprepSize13;
    }

    public String getRedExSpprepSize14() {
        return redExSpprepSize14;
    }

    public void setRedExSpprepSize14(String redExSpprepSize14) {
        this.redExSpprepSize14 = redExSpprepSize14;
    }

    public String getRedExSpprepSize15() {
        return redExSpprepSize15;
    }

    public void setRedExSpprepSize15(String redExSpprepSize15) {
        this.redExSpprepSize15 = redExSpprepSize15;
    }

    public String getRedExSpprepSize16() {
        return redExSpprepSize16;
    }

    public void setRedExSpprepSize16(String redExSpprepSize16) {
        this.redExSpprepSize16 = redExSpprepSize16;
    }

    public String getRedExSpprepSize17() {
        return redExSpprepSize17;
    }

    public void setRedExSpprepSize17(String redExSpprepSize17) {
        this.redExSpprepSize17 = redExSpprepSize17;
    }

    public String getRedExSpprepSize18() {
        return redExSpprepSize18;
    }

    public void setRedExSpprepSize18(String redExSpprepSize18) {
        this.redExSpprepSize18 = redExSpprepSize18;
    }

    public String getRedExSpprepSize1T() {
        return redExSpprepSize1T;
    }

    public void setRedExSpprepSize1T(String redExSpprepSize1T) {
        this.redExSpprepSize1T = redExSpprepSize1T;
    }

    public String getRedExSpprepSize2T() {
        return redExSpprepSize2T;
    }

    public void setRedExSpprepSize2T(String redExSpprepSize2T) {
        this.redExSpprepSize2T = redExSpprepSize2T;
    }

    public String getRedExSpprepSize3T() {
        return redExSpprepSize3T;
    }

    public void setRedExSpprepSize3T(String redExSpprepSize3T) {
        this.redExSpprepSize3T = redExSpprepSize3T;
    }

    public String getRedExSpprepSize4T() {
        return redExSpprepSize4T;
    }

    public void setRedExSpprepSize4T(String redExSpprepSize4T) {
        this.redExSpprepSize4T = redExSpprepSize4T;
    }

    public String getRedExSpprepSize5T() {
        return redExSpprepSize5T;
    }

    public void setRedExSpprepSize5T(String redExSpprepSize5T) {
        this.redExSpprepSize5T = redExSpprepSize5T;
    }

    public String getRedExSpprepSize6T() {
        return redExSpprepSize6T;
    }

    public void setRedExSpprepSize6T(String redExSpprepSize6T) {
        this.redExSpprepSize6T = redExSpprepSize6T;
    }

    public String getRedExSpprepSize7T() {
        return redExSpprepSize7T;
    }

    public void setRedExSpprepSize7T(String redExSpprepSize7T) {
        this.redExSpprepSize7T = redExSpprepSize7T;
    }

    public String getRedExSpprepSize8T() {
        return redExSpprepSize8T;
    }

    public void setRedExSpprepSize8T(String redExSpprepSize8T) {
        this.redExSpprepSize8T = redExSpprepSize8T;
    }

    public String getRedExSpprepSize9T() {
        return redExSpprepSize9T;
    }

    public void setRedExSpprepSize9T(String redExSpprepSize9T) {
        this.redExSpprepSize9T = redExSpprepSize9T;
    }

    public String getRedExSpprepSize10T() {
        return redExSpprepSize10T;
    }

    public void setRedExSpprepSize10T(String redExSpprepSize10T) {
        this.redExSpprepSize10T = redExSpprepSize10T;
    }

    public String getRedExSpprepSize11T() {
        return redExSpprepSize11T;
    }

    public void setRedExSpprepSize11T(String redExSpprepSize11T) {
        this.redExSpprepSize11T = redExSpprepSize11T;
    }

    public String getRedExSpprepSize12T() {
        return redExSpprepSize12T;
    }

    public void setRedExSpprepSize12T(String redExSpprepSize12T) {
        this.redExSpprepSize12T = redExSpprepSize12T;
    }

    public String getRedExSpprepSize13T() {
        return redExSpprepSize13T;
    }

    public void setRedExSpprepSize13T(String redExSpprepSize13T) {
        this.redExSpprepSize13T = redExSpprepSize13T;
    }

    public String getRedExLabelSize1() {
        return redExLabelSize1;
    }

    public void setRedExLabelSize1(String redExLabelSize1) {
        this.redExLabelSize1 = redExLabelSize1;
    }

    public String getRedExLabelSize2() {
        return redExLabelSize2;
    }

    public void setRedExLabelSize2(String redExLabelSize2) {
        this.redExLabelSize2 = redExLabelSize2;
    }

    public String getRedExLabelSize3() {
        return redExLabelSize3;
    }

    public void setRedExLabelSize3(String redExLabelSize3) {
        this.redExLabelSize3 = redExLabelSize3;
    }

    public String getRedExLabelSize4() {
        return redExLabelSize4;
    }

    public void setRedExLabelSize4(String redExLabelSize4) {
        this.redExLabelSize4 = redExLabelSize4;
    }

    public String getRedExLabelSize5() {
        return redExLabelSize5;
    }

    public void setRedExLabelSize5(String redExLabelSize5) {
        this.redExLabelSize5 = redExLabelSize5;
    }

    public String getRedExLabelSize6() {
        return redExLabelSize6;
    }

    public void setRedExLabelSize6(String redExLabelSize6) {
        this.redExLabelSize6 = redExLabelSize6;
    }

    public String getRedExLabelSize7() {
        return redExLabelSize7;
    }

    public void setRedExLabelSize7(String redExLabelSize7) {
        this.redExLabelSize7 = redExLabelSize7;
    }

    public String getRedExLabelSize8() {
        return redExLabelSize8;
    }

    public void setRedExLabelSize8(String redExLabelSize8) {
        this.redExLabelSize8 = redExLabelSize8;
    }

    public String getRedExLabelSize9() {
        return redExLabelSize9;
    }

    public void setRedExLabelSize9(String redExLabelSize9) {
        this.redExLabelSize9 = redExLabelSize9;
    }

    public String getRedExLabelSize10() {
        return redExLabelSize10;
    }

    public void setRedExLabelSize10(String redExLabelSize10) {
        this.redExLabelSize10 = redExLabelSize10;
    }

    public String getRedExLabelSize11() {
        return redExLabelSize11;
    }

    public void setRedExLabelSize11(String redExLabelSize11) {
        this.redExLabelSize11 = redExLabelSize11;
    }

    public String getRedExLabelSize12() {
        return redExLabelSize12;
    }

    public void setRedExLabelSize12(String redExLabelSize12) {
        this.redExLabelSize12 = redExLabelSize12;
    }

    public String getRedExLabelSize13() {
        return redExLabelSize13;
    }

    public void setRedExLabelSize13(String redExLabelSize13) {
        this.redExLabelSize13 = redExLabelSize13;
    }

    public String getRedExLabelSize14() {
        return redExLabelSize14;
    }

    public void setRedExLabelSize14(String redExLabelSize14) {
        this.redExLabelSize14 = redExLabelSize14;
    }

    public String getRedExLabelSize15() {
        return redExLabelSize15;
    }

    public void setRedExLabelSize15(String redExLabelSize15) {
        this.redExLabelSize15 = redExLabelSize15;
    }

    public String getRedExLabelSize16() {
        return redExLabelSize16;
    }

    public void setRedExLabelSize16(String redExLabelSize16) {
        this.redExLabelSize16 = redExLabelSize16;
    }

    public String getRedExLabelSize17() {
        return redExLabelSize17;
    }

    public void setRedExLabelSize17(String redExLabelSize17) {
        this.redExLabelSize17 = redExLabelSize17;
    }

    public String getRedExLabelSize18() {
        return redExLabelSize18;
    }

    public void setRedExLabelSize18(String redExLabelSize18) {
        this.redExLabelSize18 = redExLabelSize18;
    }

    public String getRedExLabelSize1T() {
        return redExLabelSize1T;
    }

    public void setRedExLabelSize1T(String redExLabelSize1T) {
        this.redExLabelSize1T = redExLabelSize1T;
    }

    public String getRedExLabelSize2T() {
        return redExLabelSize2T;
    }

    public void setRedExLabelSize2T(String redExLabelSize2T) {
        this.redExLabelSize2T = redExLabelSize2T;
    }

    public String getRedExLabelSize3T() {
        return redExLabelSize3T;
    }

    public void setRedExLabelSize3T(String redExLabelSize3T) {
        this.redExLabelSize3T = redExLabelSize3T;
    }

    public String getRedExLabelSize4T() {
        return redExLabelSize4T;
    }

    public void setRedExLabelSize4T(String redExLabelSize4T) {
        this.redExLabelSize4T = redExLabelSize4T;
    }

    public String getRedExLabelSize5T() {
        return redExLabelSize5T;
    }

    public void setRedExLabelSize5T(String redExLabelSize5T) {
        this.redExLabelSize5T = redExLabelSize5T;
    }

    public String getRedExLabelSize6T() {
        return redExLabelSize6T;
    }

    public void setRedExLabelSize6T(String redExLabelSize6T) {
        this.redExLabelSize6T = redExLabelSize6T;
    }

    public String getRedExLabelSize7T() {
        return redExLabelSize7T;
    }

    public void setRedExLabelSize7T(String redExLabelSize7T) {
        this.redExLabelSize7T = redExLabelSize7T;
    }

    public String getRedExLabelSize8T() {
        return redExLabelSize8T;
    }

    public void setRedExLabelSize8T(String redExLabelSize8T) {
        this.redExLabelSize8T = redExLabelSize8T;
    }

    public String getRedExLabelSize9T() {
        return redExLabelSize9T;
    }

    public void setRedExLabelSize9T(String redExLabelSize9T) {
        this.redExLabelSize9T = redExLabelSize9T;
    }

    public String getRedExLabelSize10T() {
        return redExLabelSize10T;
    }

    public void setRedExLabelSize10T(String redExLabelSize10T) {
        this.redExLabelSize10T = redExLabelSize10T;
    }

    public String getRedExLabelSize11T() {
        return redExLabelSize11T;
    }

    public void setRedExLabelSize11T(String redExLabelSize11T) {
        this.redExLabelSize11T = redExLabelSize11T;
    }

    public String getRedExLabelSize12T() {
        return redExLabelSize12T;
    }

    public void setRedExLabelSize12T(String redExLabelSize12T) {
        this.redExLabelSize12T = redExLabelSize12T;
    }

    public String getRedExLabelSize13T() {
        return redExLabelSize13T;
    }

    public void setRedExLabelSize13T(String redExLabelSize13T) {
        this.redExLabelSize13T = redExLabelSize13T;
    }

    public String getRedExLaserSize1() {
        return redExLaserSize1;
    }

    public void setRedExLaserSize1(String redExLaserSize1) {
        this.redExLaserSize1 = redExLaserSize1;
    }

    public String getRedExLaserSize2() {
        return redExLaserSize2;
    }

    public void setRedExLaserSize2(String redExLaserSize2) {
        this.redExLaserSize2 = redExLaserSize2;
    }

    public String getRedExLaserSize3() {
        return redExLaserSize3;
    }

    public void setRedExLaserSize3(String redExLaserSize3) {
        this.redExLaserSize3 = redExLaserSize3;
    }

    public String getRedExLaserSize4() {
        return redExLaserSize4;
    }

    public void setRedExLaserSize4(String redExLaserSize4) {
        this.redExLaserSize4 = redExLaserSize4;
    }

    public String getRedExLaserSize5() {
        return redExLaserSize5;
    }

    public void setRedExLaserSize5(String redExLaserSize5) {
        this.redExLaserSize5 = redExLaserSize5;
    }

    public String getRedExLaserSize6() {
        return redExLaserSize6;
    }

    public void setRedExLaserSize6(String redExLaserSize6) {
        this.redExLaserSize6 = redExLaserSize6;
    }

    public String getRedExLaserSize7() {
        return redExLaserSize7;
    }

    public void setRedExLaserSize7(String redExLaserSize7) {
        this.redExLaserSize7 = redExLaserSize7;
    }

    public String getRedExLaserSize8() {
        return redExLaserSize8;
    }

    public void setRedExLaserSize8(String redExLaserSize8) {
        this.redExLaserSize8 = redExLaserSize8;
    }

    public String getRedExLaserSize9() {
        return redExLaserSize9;
    }

    public void setRedExLaserSize9(String redExLaserSize9) {
        this.redExLaserSize9 = redExLaserSize9;
    }

    public String getRedExLaserSize10() {
        return redExLaserSize10;
    }

    public void setRedExLaserSize10(String redExLaserSize10) {
        this.redExLaserSize10 = redExLaserSize10;
    }

    public String getRedExLaserSize11() {
        return redExLaserSize11;
    }

    public void setRedExLaserSize11(String redExLaserSize11) {
        this.redExLaserSize11 = redExLaserSize11;
    }

    public String getRedExLaserSize12() {
        return redExLaserSize12;
    }

    public void setRedExLaserSize12(String redExLaserSize12) {
        this.redExLaserSize12 = redExLaserSize12;
    }

    public String getRedExLaserSize13() {
        return redExLaserSize13;
    }

    public void setRedExLaserSize13(String redExLaserSize13) {
        this.redExLaserSize13 = redExLaserSize13;
    }

    public String getRedExLaserSize14() {
        return redExLaserSize14;
    }

    public void setRedExLaserSize14(String redExLaserSize14) {
        this.redExLaserSize14 = redExLaserSize14;
    }

    public String getRedExLaserSize15() {
        return redExLaserSize15;
    }

    public void setRedExLaserSize15(String redExLaserSize15) {
        this.redExLaserSize15 = redExLaserSize15;
    }

    public String getRedExLaserSize16() {
        return redExLaserSize16;
    }

    public void setRedExLaserSize16(String redExLaserSize16) {
        this.redExLaserSize16 = redExLaserSize16;
    }

    public String getRedExLaserSize17() {
        return redExLaserSize17;
    }

    public void setRedExLaserSize17(String redExLaserSize17) {
        this.redExLaserSize17 = redExLaserSize17;
    }

    public String getRedExLaserSize18() {
        return redExLaserSize18;
    }

    public void setRedExLaserSize18(String redExLaserSize18) {
        this.redExLaserSize18 = redExLaserSize18;
    }

    public String getRedExLaserSize1T() {
        return redExLaserSize1T;
    }

    public void setRedExLaserSize1T(String redExLaserSize1T) {
        this.redExLaserSize1T = redExLaserSize1T;
    }

    public String getRedExLaserSize2T() {
        return redExLaserSize2T;
    }

    public void setRedExLaserSize2T(String redExLaserSize2T) {
        this.redExLaserSize2T = redExLaserSize2T;
    }

    public String getRedExLaserSize3T() {
        return redExLaserSize3T;
    }

    public void setRedExLaserSize3T(String redExLaserSize3T) {
        this.redExLaserSize3T = redExLaserSize3T;
    }

    public String getRedExLaserSize4T() {
        return redExLaserSize4T;
    }

    public void setRedExLaserSize4T(String redExLaserSize4T) {
        this.redExLaserSize4T = redExLaserSize4T;
    }

    public String getRedExLaserSize5T() {
        return redExLaserSize5T;
    }

    public void setRedExLaserSize5T(String redExLaserSize5T) {
        this.redExLaserSize5T = redExLaserSize5T;
    }

    public String getRedExLaserSize6T() {
        return redExLaserSize6T;
    }

    public void setRedExLaserSize6T(String redExLaserSize6T) {
        this.redExLaserSize6T = redExLaserSize6T;
    }

    public String getRedExLaserSize7T() {
        return redExLaserSize7T;
    }

    public void setRedExLaserSize7T(String redExLaserSize7T) {
        this.redExLaserSize7T = redExLaserSize7T;
    }

    public String getRedExLaserSize8T() {
        return redExLaserSize8T;
    }

    public void setRedExLaserSize8T(String redExLaserSize8T) {
        this.redExLaserSize8T = redExLaserSize8T;
    }

    public String getRedExLaserSize9T() {
        return redExLaserSize9T;
    }

    public void setRedExLaserSize9T(String redExLaserSize9T) {
        this.redExLaserSize9T = redExLaserSize9T;
    }

    public String getRedExLaserSize10T() {
        return redExLaserSize10T;
    }

    public void setRedExLaserSize10T(String redExLaserSize10T) {
        this.redExLaserSize10T = redExLaserSize10T;
    }

    public String getRedExLaserSize11T() {
        return redExLaserSize11T;
    }

    public void setRedExLaserSize11T(String redExLaserSize11T) {
        this.redExLaserSize11T = redExLaserSize11T;
    }

    public String getRedExLaserSize12T() {
        return redExLaserSize12T;
    }

    public void setRedExLaserSize12T(String redExLaserSize12T) {
        this.redExLaserSize12T = redExLaserSize12T;
    }

    public String getRedExLaserSize13T() {
        return redExLaserSize13T;
    }

    public void setRedExLaserSize13T(String redExLaserSize13T) {
        this.redExLaserSize13T = redExLaserSize13T;
    }
    
    
    
    

}
