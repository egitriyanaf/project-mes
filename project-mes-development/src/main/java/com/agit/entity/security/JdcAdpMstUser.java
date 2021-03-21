package com.agit.entity.security;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.agit.entity.Entity;
import com.agit.entity.JdcAdpMstdepartement;

/**
 *
 * @author erwin
 */
public class JdcAdpMstUser implements Serializable, Entity {

    /**
     *
     * @author Ridwan
     */
    public static final String COMP_ADMIN = "COMP_ADMIN";

    /**
     *
     */
    public static final String SUPER_ADMIN = "ADMIN";

    private static final long serialVersionUID = 6751516406395916644L;
    private Long id;
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
    private String roles;
    private Set<JdcAdpMstUserrole> userroles = new HashSet<JdcAdpMstUserrole>(0);
    private String enabled;
    private Long dptId;
    private JdcAdpMstdepartement departement;

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
    public Long getId() {
        return id;
    }

    /**
     *
     * @param userroles
     */
    public void setUserroles(Set<JdcAdpMstUserrole> userroles) {
        this.userroles = userroles;
    }

    /**
     *
     * @return
     */
    public Set<JdcAdpMstUserrole> getUserroles() {
        return userroles;
    }

    /**
     *
     * @return
     */
    public boolean isNew() {
        return getId() == null;
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
    public String getRoles() {
        return roles;
    }

    /**
     *
     * @param roles
     */
    public void setRoles(String roles) {
        this.roles = roles;
    }

    /**
     *
     * @return
     */
    public boolean isPasswordDefault() {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     *
     * @return
     */
    public String getName() {
        String pico = "";
        if (StringUtils.isNotBlank(getUsrFirstName())) {
            pico = getUsrFirstName();
        }

        if (StringUtils.isNotBlank(getUsrLastName())) {
            pico += " " + getUsrLastName();
        }

        return pico;
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
    public JdcAdpMstdepartement getDepartement() {
		return departement;
	}

    /**
     *
     * @param departement
     */
    public void setDepartement(JdcAdpMstdepartement departement) {
		this.departement = departement;
	}
    
	
}
