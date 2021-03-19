package com.agit.entity;


import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;

import javax.persistence.Id;


/**
 *
 * @author ridwans
 */
@Entity
@Table(name = "jdcadp_mstmail")
public class JdcAdpTxnLotMail implements Serializable {    

    @Id
    @Basic(optional = false)
    @Column(name = "VTMPLTID", nullable = false, length = 15)
    private String vtemplateid;
    @Column(name = "VTMPLTSUB", length = 100)
    private String vtemplatsub;
    @Column(name = "VTMPLTMSG", length = 4000)
    private String vtemplatmsg;
    @Column(name = "VTMPLTEMT", length = 100)
    private String vtemplatemt;
    @Column(name = "VTMPLTECC", length = 100)
    private String vtemplatecc;
    @Column(name = "VTMPLTPAR", length = 100)
    private String vtemplatpar;

    /**
     * @return the vtemplateid
     */
    public String getVtemplateid() {
        return vtemplateid;
    }

    /**
     * @param vtemplateid the vtemplateid to set
     */
    public void setVtemplateid(String vtemplateid) {
        this.vtemplateid = vtemplateid;
    }


    /**
     * @return the vtemplatsub
     */
    public String getVtemplatsub() {
        return vtemplatsub;
    }

    /**
     * @param vtemplatsub the vtemplatsub to set
     */
    public void setVtemplatsub(String vtemplatsub) {
        this.vtemplatsub = vtemplatsub;
    }

    /**
     * @return the vtemplatmsg
     */
    public String getVtemplatmsg() {
        return vtemplatmsg;
    }

    /**
     * @param vtemplatmsg the vtemplatmsg to set
     */
    public void setVtemplatmsg(String vtemplatmsg) {
        this.vtemplatmsg = vtemplatmsg;
    }

    /**
     * @return the vtemplatpar
     */
    public String getVtemplatpar() {
        return vtemplatpar;
    }

    /**
     * @param vtemplatpar the vtemplatpar to set
     */
    public void setVtemplatpar(String vtemplatpar) {
        this.vtemplatpar = vtemplatpar;
    }

    /**
     * @return the vtemplatemt
     */
    public String getVtemplatemt() {
        return vtemplatemt;
    }

    /**
     * @param vtemplatemt the vtemplatemt to set
     */
    public void setVtemplatemt(String vtemplatemt) {
        this.vtemplatemt = vtemplatemt;
    }

    /**
     * @return the vtemplatecc
     */
    public String getVtemplatecc() {
        return vtemplatecc;
    }

    /**
     * @param vtemplatecc the vtemplatecc to set
     */
    public void setVtemplatecc(String vtemplatecc) {
        this.vtemplatecc = vtemplatecc;
    }

    
    
}
