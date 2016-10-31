package sys.spvision.core.entity.ana;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import org.hibernate.validator.constraints.Length;

import sys.spvision.core.annotation.Mobile;

public class UserCase implements Serializable {
	
	public static final String STATUS_OPEN = "O";
	public static final String STATUS_CLOSED = "C";
	public static final String STATUS_LOCKED = "L";
	public static final String STATUS_EXPIRED = "E";

	private static final long serialVersionUID = -2674655367174082837L;
	
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
	
	private Long caseUserId;				//操作人员
	private String caseStatus;				//状态
	private String caseOpenStatus;			//启用状态
	private Timestamp caseTime;				//添加时间
	private String caseJudgment;			//意见
	private String updateNew;					//判断是否提交成功
	private Long realId;					//正式表id
	private Long lastCompanyCaseId;			//上次的company_case
	private Long caseOwnerId;				//数据录入者
	private String judgement;
	private String caseStatusValue;
	
	private String caseStatusDes;
	
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

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
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

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
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

	public static String getStatusOpen() {
		return STATUS_OPEN;
	}

	public static String getStatusClosed() {
		return STATUS_CLOSED;
	}

	public static String getStatusLocked() {
		return STATUS_LOCKED;
	}

	public static String getStatusExpired() {
		return STATUS_EXPIRED;
	}

	public Long getCaseUserId() {
		return caseUserId;
	}

	public void setCaseUserId(Long caseUserId) {
		this.caseUserId = caseUserId;
	}

	public String getCaseStatus() {
		return caseStatus;
	}

	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}

	public String getCaseOpenStatus() {
		return caseOpenStatus;
	}

	public void setCaseOpenStatus(String caseOpenStatus) {
		this.caseOpenStatus = caseOpenStatus;
	}

	public Timestamp getCaseTime() {
		return caseTime;
	}

	public void setCaseTime(Timestamp caseTime) {
		this.caseTime = caseTime;
	}

	public String getCaseJudgment() {
		return caseJudgment;
	}

	public void setCaseJudgment(String caseJudgment) {
		this.caseJudgment = caseJudgment;
	}

	public Long getRealId() {
		return realId;
	}

	public void setRealId(Long realId) {
		this.realId = realId;
	}

	public String getUpdateNew() {
		return updateNew;
	}

	public void setUpdateNew(String updateNew) {
		this.updateNew = updateNew;
	}

	public Long getLastCompanyCaseId() {
		return lastCompanyCaseId;
	}

	public void setLastCompanyCaseId(Long lastCompanyCaseId) {
		this.lastCompanyCaseId = lastCompanyCaseId;
	}

	public Long getCaseOwnerId() {
		return caseOwnerId;
	}

	public void setCaseOwnerId(Long caseOwnerId) {
		this.caseOwnerId = caseOwnerId;
	}

	public String getJudgement() {
		return judgement;
	}

	public void setJudgement(String judgement) {
		this.judgement = judgement;
	}

	public String getCaseStatusValue() {
		return caseStatusValue;
	}

	public void setCaseStatusValue(String caseStatusValue) {
		this.caseStatusValue = caseStatusValue;
	}

	public String getCaseStatusDes() {
		return caseStatusDes;
	}

	public void setCaseStatusDes(String caseStatusDes) {
		this.caseStatusDes = caseStatusDes;
	}

}
