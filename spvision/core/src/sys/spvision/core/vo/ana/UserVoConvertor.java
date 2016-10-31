package sys.spvision.core.vo.ana;

import sys.spvision.core.entity.ana.User;
import sys.spvision.core.util.DatetimeUtil;
import sys.spvision.core.vo.VoConvertor;


public class UserVoConvertor extends VoConvertor<UserVo, User> {
	
	@Override
	public UserVo convert(User bo) {
		if (bo==null)
			return null;
		
		UserVo vo = new UserVo();
		
		vo.setId(Long.toString(bo.getId()));
		vo.setLoginName(bo.getLoginName() != null ? bo.getLoginName() : "");
		vo.setName(bo.getName() != null ? bo.getName() : "");
		vo.setStatus(bo.getStatus() != null ? bo.getStatus() : "");
		vo.setStatusName(bo.getStatusName() != null ? bo.getStatusName() : "");
		vo.setPwdErrCnt(Integer.toString(bo.getPwdErrCnt()));
		vo.setMobile(bo.getMobile() != null ? bo.getMobile() : "");
		vo.setEmail(bo.getEmail() != null ? bo.getEmail() : "");
		vo.setPhone(bo.getPhone() != null ? bo.getPhone() : "");
		vo.setMemo(bo.getMemo() != null ? bo.getMemo() : "");
		vo.setCreateDatetime(bo.getCreateDatetime()!= null ? DatetimeUtil.timestamp2StringDatetime(bo.getCreateDatetime()) : "");
		vo.setUpdateDatetime(bo.getUpdateDatetime()!= null ? DatetimeUtil.timestamp2StringDatetime(bo.getUpdateDatetime()) : "");
		vo.setExpirationDate(bo.getExpirationDate()!= null ? DatetimeUtil.date2StringDate(bo.getExpirationDate()) : "");
		vo.setDkSerialNumber(bo.getDkSerialNumber() != null ? bo.getDkSerialNumber() : "");
		vo.setRealId(bo.getId());
		return vo;
	}

}
