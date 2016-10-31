package sys.spvision.core.vo.ana;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.Length;

import sys.spvision.core.entity.ana.Role;
import sys.spvision.core.entity.ana.RoleCase;
import sys.spvision.core.vo.VoConvertor;

public class RoleConvertorCase extends VoConvertor<Role, RoleCase> {

	@Override
	public Role convert(RoleCase bo) {
		if (bo == null)
			return null;
		Role vo = new Role();
		vo.setId(bo.getRealId());
		vo.setName(bo.getName());
		vo.setDesc(bo.getDesc());
		vo.setStatus(bo.getStatus());
		vo.setStatusName(bo.getStatusName());
		vo.setModuleCode(bo.getModuleCode());
		vo.setCreateDatetime(bo.getCreateDatetime());
		vo.setUpdateDatetime(bo.getUpdateDatetime());
		return vo;
	}

}
