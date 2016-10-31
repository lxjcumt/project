package sys.spvision.core.vo.ana;

import java.io.Serializable;
import java.sql.Timestamp;

public class RoleVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6501570295052546521L;
	
	private String id;
	private String name;
	private String desc;
	private String status;
	private String statusName;
	private String moduleCode;
	private String createDatetime;
	private String updateDatetime;
	
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
