package sys.spvision.core.criteria.ana;

import java.util.List;

import sys.spvision.core.criteria.AbstractCriteria;

public class RoleCaseCriteria extends AbstractCriteria {
	private Long roleId;
	private String roleName;
	private String myStatus;
	private List<String> caseStatus;
	private Long caseOperator;
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
