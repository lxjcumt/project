package sys.spvision.core.entity.ana;

import java.io.Serializable;
import java.sql.Timestamp;

import org.hibernate.validator.constraints.Length;

public class RoleCase implements Serializable {
	public static final String STATUS_OPEN = "O";
	public static final String STATUS_CLOSED ="C";

	private static final long serialVersionUID = -5829285293791526390L;

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
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
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
	public static String getStatusOpen() {
		return STATUS_OPEN;
	}
	public static String getStatusClosed() {
		return STATUS_CLOSED;
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
