package com.agit.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author erwin
 */
@Entity
@Table(name = "mfs.log_password")
public class JdcAdpMstlog  implements Serializable {
	private static final long serialVersionUID = -4766966230697392291L;
	@Id
	@SequenceGenerator(name = "mfs.seq_log_password", sequenceName = "mfs.seq_log_password", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mfs.seq_log_password")
	@Column(name = "log_id")
	private Long id;
	
	@Column (name="user_login")
	private String userLogin;
	
	@Column (name="user_passwd")
	private String userPassword;
	
	@Column (name="created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

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
    public String getUserLogin() {
		return userLogin;
	}

    /**
     *
     * @param userLogin
     */
    public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

    /**
     *
     * @return
     */
    public String getUserPassword() {
		return userPassword;
	}

    /**
     *
     * @param userPassword
     */
    public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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
}
