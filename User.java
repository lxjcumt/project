package sys.spvision.core.entity.ana;

import java.sql.Timestamp;
import java.sql.Date;
import java.io.Serializable;
//jjjj

import org.hibernate.validator.constraints.Length;

import sys.spvision.core.annotation.Mobile;

public class User implements Serializable {
	
	public static final String STATUS_OPEN = "O";
	public static final String STATUS_CLOSED = "C";
	public static final String STATUS_LOCKED = "L";
	public static final String STATUS_EXPIRED = "E";
	
	private static final long serialVersionUID = -6541765821406875300L;
	
	private Long id;
	
	@Length(min=0,max=50)
	private String loginName;
	@Length(min=0,max=50)
	private String name;
	@Length(min=0,max=100)
	private String loginPassword;
	private String status;
	private String statusName;
	private int pwdErrCnt;
	
	@Length(min=0,max=50)
	@Mobile
	private String mobile;
	@Length(min=0,max=50)
	private String email;
	private String phone;
	private String memo;
	private Timestamp createDatetime;
	private Timestamp updateDatetime;
	private Date expirationDate;
	private String roles;
	private String checkStatus;
	
	/**
	 * 动态令牌序列号
	 */
	private String dkSerialNumber;
	
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPwdErrCnt() {
		return pwdErrCnt;
	}

	public void setPwdErrCnt(int pwdErrCnt) {
		this.pwdErrCnt = pwdErrCnt;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public Timestamp getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(Timestamp createDatetime) {
		this.createDatetime = createDatetime;
	}

	public Timestamp getUpdateDatetime() {
		return updateDatetime;
	}

	public void setUpdateDatetime(Timestamp updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getDkSerialNumber() {
		return dkSerialNumber;
	}

	public void setDkSerialNumber(String dkSerialNumber) {
		this.dkSerialNumber = dkSerialNumber;
	}

	public String getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}

	
}
