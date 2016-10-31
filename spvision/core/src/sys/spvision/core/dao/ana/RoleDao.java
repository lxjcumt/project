package sys.spvision.core.dao.ana;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import sys.spvision.core.dao.IGenericDao;
import sys.spvision.core.entity.ana.Role;

public interface RoleDao extends IGenericDao<Role, Long> {
	public List<Role> getRolesByModuleCode(String moduleCode);
	public List<Role> getRolesByUserId(Long userId);
	public void insertRoleMenu(@Param("roleId")long roleId, @Param("menuId")long menuId);
	public void insertRolePermission(@Param("roleId")long roleId, @Param("permissionId")long permissionId);
	public void deleteAllRoleMenu(@Param("roleId")long roleId);
	public void deleteAllRolePermission(@Param("roleId")long roleId);
}
