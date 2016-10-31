package sys.spvision.core.vo.ana;

import sys.spvision.core.entity.ana.Role;
import sys.spvision.core.util.DatetimeUtil;
import sys.spvision.core.vo.VoConvertor;

public class RoleVoConvertor extends VoConvertor<RoleVo, Role> {

	@Override
	public RoleVo convert(Role bo) {
		
		RoleVo vo = new RoleVo();
		
		vo.setId(Long.toString(bo.getId()));
		vo.setName(bo.getName());
		vo.setDesc(bo.getDesc());
		vo.setStatus(bo.getStatus());
		vo.setStatusName(bo.getStatusName());
		vo.setModuleCode(bo.getModuleCode());
		vo.setCreateDatetime(DatetimeUtil.timestamp2StringDatetime(bo.getCreateDatetime()));
		vo.setUpdateDatetime(DatetimeUtil.timestamp2StringDatetime(bo.getUpdateDatetime()));
		vo.setRealId(bo.getId());
		return vo;
	}
	

}
