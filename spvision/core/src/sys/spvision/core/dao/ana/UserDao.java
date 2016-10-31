package sys.spvision.core.dao.ana;

import org.apache.ibatis.annotations.Param;

import sys.spvision.core.dao.IGenericDao;
import sys.spvision.core.entity.ana.User;

public interface UserDao extends IGenericDao<User, Long>{
	public User checkUser(@Param("userName") String userName, @Param("password") String password);
	public void insertUserRole(@Param("userId")long userId, @Param("roleId")long roleId);
	public void deleteUserRole(@Param("userId")long userId, @Param("roleId")long roleId);
	public void deleteAllUserRole(@Param("userId")long userId);
	public void updatePassword(@Param("userId")long userId, @Param("newPassword")String newPassword);
	public User getUserbyLoginname(@Param("userName") String userName);
	
}
