package sys.spvision.core.vo.ana;

import java.io.Serializable;

public class UserVo  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2947372233195027115L;
	
	private String id;
	private String loginName;
	private String name;
	private String status;
	private String statusName;
	private String pwdErrCnt;
	private String mobile;
	private String email;
	private String phone;
	private String memo;
	private String createDatetime;
	private String updateDatetime;
	private String expirationDate;
	private String dkSerialNumber;
	private Long realId;						//正式表中的id case表中使用
	private Long lastCompanyCaseId;			//上次的company_case
	private String caseStatus;				//状态
	private String caseJudgment;
	private String caseStatusDes;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwdErrCnt() {
		return pwdErrCnt;
	}
	public void setPwdErrCnt(String pwdErrCnt) {
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
	public String getCreateDatetime() {
		return createDatetime;
	}
	public void setCreateDatetime(String createDatetime) {
		this.createDatetime = createDatetime;
	}
	public String getUpdateDatetime() {
		return updateDatetime;
	}
	public void setUpdateDatetime(String updateDatetime) {
		this.updateDatetime = updateDatetime;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getDkSerialNumber() {
		return dkSerialNumber;
	}
	public void setDkSerialNumber(String dkSerialNumber) {
		this.dkSerialNumber = dkSerialNumber;
	}
	public Long getRealId() {
		return realId;
	}
	public void setRealId(Long realId) {
		this.realId = realId;
	}
	public Long getLastCompanyCaseId() {
		return lastCompanyCaseId;
	}
	public void setLastCompanyCaseId(Long lastCompanyCaseId) {
		this.lastCompanyCaseId = lastCompanyCaseId;
	}
	public String getCaseStatus() {
		return caseStatus;
	}
	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}
	public String getCaseJudgment() {
		return caseJudgment;
	}
	public void setCaseJudgment(String caseJudgment) {
		this.caseJudgment = caseJudgment;
	}
	public String getCaseStatusDes() {
		return caseStatusDes;
	}
	public void setCaseStatusDes(String caseStatusDes) {
		this.caseStatusDes = caseStatusDes;
	}

}
