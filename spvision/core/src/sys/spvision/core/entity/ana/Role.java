package sys.spvision.core.entity.ana;

import java.io.Serializable;
import java.sql.Timestamp;

import org.hibernate.validator.constraints.Length;

public class Role implements Serializable {
	public static final String STATUS_OPEN = "O";
	public static final String STATUS_CLOSED ="C";
	
	private static final long serialVersionUID = 7581099124083186340L;
	
	private Long id;
	@Length(min=0,max=50)
	private String name;
	private String desc;
	private String status;
	private String statusName;
	private String moduleCode;
	private Timestamp createDatetime;
	private Timestamp updateDatetime;
	private String menuSelect;
	private String rolePermission;
	private String checkStatus;
	private Long realId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getModuleCode() {
		return moduleCode;
	}
	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
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
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getMenuSelect() {
		return menuSelect;
	}
	public void setMenuSelect(String menuSelect) {
		this.menuSelect = menuSelect;
	}
	public String getRolePermission() {
		return rolePermission;
	}
	public void setRolePermission(String rolePermission) {
		this.rolePermission = rolePermission;
	}
	public String getCheckStatus() {
		return checkStatus;
	}
	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}
	public Long getRealId() {
		return realId;
	}
	public void setRealId(Long realId) {
		this.realId = realId;
	}
}
