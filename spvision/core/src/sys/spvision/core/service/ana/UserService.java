package sys.spvision.core.service.ana;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sys.spvision.core.criteria.ana.UserCaseCriteria;
import sys.spvision.core.criteria.ana.UserCriteria;
import sys.spvision.core.dao.ana.RoleDao;
import sys.spvision.core.dao.ana.UserCaseDao;
import sys.spvision.core.dao.ana.UserDao;
import sys.spvision.core.entity.ana.RoleCase;
import sys.spvision.core.entity.ana.User;
import sys.spvision.core.entity.ana.UserCase;
import sys.spvision.core.util.SecurityUtil;
import sys.spvision.core.vo.ana.UserConvertorCase;


@Service
public class UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	RoleDao roleDao;

	@Autowired
	RoleService roleService;
	
	@Autowired
	UserCaseDao userCaseDao;

	public User getUserByUserId(Long userId) {
		return userDao.getById(userId,false);
	}
	
	public UserCase getUserCaseByUserCaseId(Long userId) {
		return userCaseDao.getById(userId,false);
	}
	
	@Transactional
	public void addUser(UserCase user) {
		setMaskedPasswordUserCase(user);
//		userDao.insert(user);
		user.setCaseOwnerId(user.getCaseUserId());
		userCaseDao.insert(user);
		if(user.getRoles() != null){
			String[] roleIds = user.getRoles().split(";|,");
			for (String roleId : roleIds) {
				userCaseDao.insertUserRole(user.getId(), Long.parseLong(roleId));
//				userDao.insertUserRole(user.getId(), Long.parseLong(roleId));
			}
		}
	}

	@Transactional
//	public void editUser(User user, String roles) {
	public Long editUser(UserCase user) {
//		setMaskedPasswordUserCase(user);
//		userDao.update(user);
//		userDao.deleteAllUserRole(user.getId());
//
//		if(user.getRoles() != null){
//			if (user.getRoles().trim().length() > 0) {
//				String[] roleIds = user.getRoles().split(";|,");
//				for (String roleId : roleIds) {
//					userDao.insertUserRole(user.getId(), Long.parseLong(roleId));
//				}
//			}
//		}
		if(!user.getUpdateNew().equals("old")){
			UserCase userCase = userCaseDao.getById(user.getId(), false);
			userCase.setCaseOpenStatus("C");
			userCaseDao.update(userCase);
			userCaseDao.deleteAllUserRole(user.getId());
			user.setLoginPassword(userCase.getLoginPassword());
//			if(user.getCaseStatusValue().equals("UR") || user.getCaseStatusValue().equals("IR")){
//				lastCompanyId = companyCase.getLastCompanyCaseId();
//			}
			//插入被拒绝
			if(user.getCaseStatusValue().equals("IR")){
				user.setCaseStatus("IW");
			}
			user.setLastCompanyCaseId(user.getId());
		}else{
			User u = userDao.getById(user.getId(), false);
			u.setCheckStatus("C");
			userDao.update(u);
			userDao.deleteAllUserRole(user.getId());
			user.setRealId(u.getId());
			user.setLoginPassword(u.getLoginPassword());
		}
		user.setId(null);
		user.setCaseOwnerId(user.getCaseUserId());
		userCaseDao.insert(user);
		Long newUserId = user.getId();
		if(user.getRoles() != null){
			String[] roleIds = user.getRoles().split(";|,");
			for (String roleId : roleIds) {
				userCaseDao.insertUserRole(user.getId(), Long.parseLong(roleId));
//				userDao.insertUserRole(user.getId(), Long.parseLong(roleId));
			}
		}
		return newUserId;
	}
	
	@Transactional
	public void checkUser(UserCase userTemp){
		System.out.println(2);
		if(!userTemp.getJudgement().equals("C")){
			UserCase userCase = userCaseDao.getById(userTemp.getId(), false);
			//关闭这条数据
			userCase.setCaseOpenStatus("C");
			userCaseDao.update(userCase);
			System.out.println(3);
			if(userTemp.getJudgement().equals("A")){
				System.out.println(4);
				//同意
				User user = new UserConvertorCase().convert(userCase);
				user.setCheckStatus("O");
				if(userCase.getCaseStatus().equals("IW")){
					System.out.println(5);
					//新增同意
					userCase.setCaseStatus("IA");
					userDao.insert(user);
				}else{
					System.out.println(6);
					//修改同意
					userCase.setCaseStatus("UA");
					userDao.update(user);
				}
				//从UserRoleCase表中取出对应的值，插入UserCase表中
				List<RoleCase> roles = roleService.getRolesByUserCaseId(userCase.getId());
				for(RoleCase r: roles){
					userDao.insertUserRole(user.getId(), r.getId());
				}
			}else{
				//拒绝
				if(userCase.getCaseStatus().equals("IW")){
					userCase.setCaseStatus("IR");
				}else{
					userCase.setCaseStatus("UR");
				}
			}
			System.out.println(7);
			//保存到userCase表中
			userCase.setCaseOwnerId(userCase.getCaseUserId());
			userCase.setCaseUserId(userTemp.getCaseUserId());
			userCase.setCaseJudgment(userTemp.getCaseJudgment());
			userCase.setCaseOpenStatus(userTemp.getCaseOpenStatus());
			userCase.setLastCompanyCaseId(userCase.getId());
			userCase.setId(null);
			userCaseDao.insert(userCase);
		}
	}



	public List<User> query(UserCriteria criteria) {
		return userDao.query(criteria);
	}
	
	public List<UserCase> queryCheck(UserCaseCriteria criteria) {
		return userCaseDao.query(criteria);
	}
	
	public int queryCount(UserCriteria criteria) {
		return userDao.queryCount(criteria);
	}
	
	public int queryCheckCount(UserCaseCriteria criteria) {
		return userCaseDao.queryCount(criteria);
	}
	
	public void changePassword(long userId, String newPassword) {
		User user = (User)userDao.getById(userId, false);
		user.setLoginPassword(newPassword);
		setMaskedPassword(user);
		userDao.updatePassword(userId, user.getLoginPassword());
	}
	public void changePasswordForLoginUser(long userId, String password,String newPassword) {
		User user = (User)userDao.getById(userId, false);
		
		String selkey=user.getLoginName() ;
		String sel =SecurityUtil.genSalt(selkey);
		
		boolean success = SecurityUtil.matchPassword(user.getLoginPassword(),sel,password);
		if(false == success){
			throw new RuntimeException("原始密码错误");
		}
		user.setLoginPassword(newPassword);
		setMaskedPassword(user);
		userDao.updatePassword(userId, user.getLoginPassword());
	}
	
	public String setMaskedPassword(User user){
		String password= user.getLoginPassword();
		String selkey=user.getLoginName() ;
		String sel =SecurityUtil.genSalt(selkey);
	    String maskedPassword= SecurityUtil.calcMaskedPassword(sel,password);
	    user.setLoginPassword(maskedPassword);
	    return maskedPassword;
	}
	
	public String setMaskedPasswordUserCase(UserCase user){
		String password= user.getLoginPassword();
		String selkey=user.getLoginName() ;
		String sel =SecurityUtil.genSalt(selkey);
	    String maskedPassword= SecurityUtil.calcMaskedPassword(sel,password);
	    user.setLoginPassword(maskedPassword);
	    return maskedPassword;
	}

	
}
