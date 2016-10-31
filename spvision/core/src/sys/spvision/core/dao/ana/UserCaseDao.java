package sys.spvision.core.dao.ana;

import org.apache.ibatis.annotations.Param;

import sys.spvision.core.dao.IGenericDao;
import sys.spvision.core.entity.ana.UserCase;

public interface UserCaseDao extends IGenericDao<UserCase, Long> {
	public void insertUserRole(@Param("userId")long userId, @Param("roleId")long roleId);
	public void deleteAllUserRole(@Param("userId")long userId);
}
