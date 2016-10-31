package sys.spvision.core.criteria.ana;

import java.util.List;

import sys.spvision.core.criteria.AbstractCriteria;

public class UserCaseCriteria extends AbstractCriteria {
	
	private Long userId;
	private String userName;
	private String userLoginName;
	private String email;
	private String dkSerialNumber;
	private String myStatus;
	private List<String> caseStatus;
	private Long caseOperator;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserLoginName() {
		return userLoginName;
	}
	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDkSerialNumber() {
		return dkSerialNumber;
	}
	public void setDkSerialNumber(String dkSerialNumber) {
		this.dkSerialNumber = dkSerialNumber;
	}
	public String getMyStatus() {
		return myStatus;
	}
	public void setMyStatus(String myStatus) {
		this.myStatus = myStatus;
	}
	public List<String> getCaseStatus() {
		return caseStatus;
	}
	public void setCaseStatus(List<String> caseStatus) {
		this.caseStatus = caseStatus;
	}
	public Long getCaseOperator() {
		return caseOperator;
	}
	public void setCaseOperator(Long caseOperator) {
		this.caseOperator = caseOperator;
	}
}
