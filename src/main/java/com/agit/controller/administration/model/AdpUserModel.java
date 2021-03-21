/**
 *
 */
package com.agit.controller.administration.model;

import com.agit.controller.administration.model.AdpStateModel;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Ridwan
 */
public class AdpUserModel {

    private Long id;
    @JsonProperty("roles")
    private List<AdpStateModel> states;
    private String companyName;
    private String chatLogin;
    private String usrLogin;
    private String usrPassword;
    private String usrLastName;
    private String usrFirstName;
    private String usrEmail;
    private String usrPhone;
    private Date createdDate;
    private Long createdBy;
    private Long lastUpdatedBy;
    private Date lastUpdatedDate;
    private String usrType;
    private String enabled;
    private Long dptId;

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
    public List<AdpStateModel> getStates() {
        return states;
    }

    /**
     *
     * @param states
     */
    public void setStates(List<AdpStateModel> states) {
        this.states = states;
    }

    /**
     *
     * @return
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     *
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     *
     * @return
     */
    public String getChatLogin() {
        return chatLogin;
    }

    /**
     *
     * @param chatLogin
     */
    public void setChatLogin(String chatLogin) {
        this.chatLogin = chatLogin;
    }

    /**
     *
     * @return
     */
    public String getUsrLogin() {
        return usrLogin;
    }

    /**
     *
     * @param usrLogin
     */
    public void setUsrLogin(String usrLogin) {
        this.usrLogin = usrLogin;
    }

    /**
     *
     * @return
     */
    public String getUsrPassword() {
        return usrPassword;
    }

    /**
     *
     * @param usrPassword
     */
    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }

    /**
     *
     * @return
     */
    public String getUsrLastName() {
        return usrLastName;
    }

    /**
     *
     * @param usrLastName
     */
    public void setUsrLastName(String usrLastName) {
        this.usrLastName = usrLastName;
    }

    /**
     *
     * @return
     */
    public String getUsrFirstName() {
        return usrFirstName;
    }

    /**
     *
     * @param usrFirstName
     */
    public void setUsrFirstName(String usrFirstName) {
        this.usrFirstName = usrFirstName;
    }

    /**
     *
     * @return
     */
    public String getUsrEmail() {
        return usrEmail;
    }

    /**
     *
     * @param usrEmail
     */
    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    /**
     *
     * @return
     */
    public String getUsrPhone() {
        return usrPhone;
    }

    /**
     *
     * @param usrPhone
     */
    public void setUsrPhone(String usrPhone) {
        this.usrPhone = usrPhone;
    }

    /**
     *
     * @return
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     *
     * @param createdDate
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     *
     * @return
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     *
     * @param createdBy
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     *
     * @return
     */
    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    /**
     *
     * @param lastUpdatedBy
     */
    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     *
     * @return
     */
    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    /**
     *
     * @param lastUpdatedDate
     */
    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    /**
     *
     * @return
     */
    public String getUsrType() {
        return usrType;
    }

    /**
     *
     * @param usrType
     */
    public void setUsrType(String usrType) {
        this.usrType = usrType;
    }

    /**
     *
     * @return
     */
    public Long getDptId() {
		return dptId;
	}

    /**
     *
     * @param dptId
     */
    public void setDptId(Long dptId) {
		this.dptId = dptId;
	}

    /**
     *
     * @return
     */
    public String getEnabled() {
		return enabled;
	}

    /**
     *
     * @param enabled
     */
    public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	

}
