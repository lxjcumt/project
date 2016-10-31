package sys.spvision.core.criteria.ana;

import sys.spvision.core.criteria.AbstractCriteria;


public class RoleCriteria extends AbstractCriteria{
	private Long roleId;
	private String roleName;
	
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
	
	
}
