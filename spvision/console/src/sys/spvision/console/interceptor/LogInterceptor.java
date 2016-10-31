package sys.spvision.console.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LogInterceptor implements HandlerInterceptor {
	
	private static Logger logger = Logger.getLogger(LogInterceptor.class);
	
	private static Map<String, ActionMsg> urlMsgs = new HashMap<String, ActionMsg>(); 

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		if(req.getAttribute("log") != null ){
			HttpSession session = req.getSession(false);
			String msg = req.getAttribute("log").toString();
			if(session != null && session.getAttribute("USER_ID") != null){
				MDC.put("userId", session.getAttribute("USER_ID"));
				MDC.put("userName", session.getAttribute("USER_NAME"));
			}else{
				MDC.put("userId", 1);
			}
			MDC.put("ip", req.getRemoteAddr());
			MDC.put("type", req.getAttribute("logType"));
			logger.info(msg);
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("path:"+req.getServletPath());
		if(urlMsgs.get(req.getServletPath()) != null){
			HttpSession session = req.getSession(false);
			ActionMsg actionMsg = urlMsgs.get(req.getServletPath());
			String msg = "";
			msg += actionMsg.getMsg()+" params:";
			for(String key:req.getParameterMap().keySet()){
				//密码不计入日志
				if(!req.getServletPath().equals("/ana/login.ajax") || !key.equals("password")){
					msg += "["+key+":"+req.getParameter(key)+"]";
				}
			}
			if(session != null && session.getAttribute("USER_ID") != null){
				MDC.put("userId", session.getAttribute("USER_ID"));
				MDC.put("userName", session.getAttribute("USER_NAME"));
			}else{
				MDC.put("userId", 1);
				MDC.put("userName", "游客");
			}
			MDC.put("ip", req.getRemoteAddr());
			MDC.put("type", actionMsg.getType());
			logger.info(msg);
		}
		return true;
	}
	
	 static class ActionMsg{
		private String msg;
		private String type;
		public ActionMsg(String msg, String type){
			this.msg = msg;
			this.type = type;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		
	}
	 
	static{
			urlMsgs.put("/htm/login.htm", new ActionMsg("打开登陆页面", "LOGIN_HTM"));
			urlMsgs.put("/htm/main.htm", new ActionMsg("打开主页面", "MAIN_HTM"));
			urlMsgs.put("/htm/seller/add.htm", new ActionMsg("打开新增供货商页面", "SELLER_ADD_HTM"));
			urlMsgs.put("/htm/seller/edit.htm", new ActionMsg("打开修改供货商页面", "SELLER_EDIT_HTM"));
			urlMsgs.put("/htm/seller/list.htm", new ActionMsg("打开供货商列表页面", "SELLER_LIST_HTM"));
			urlMsgs.put("/htm/seller/view.htm", new ActionMsg("打开查看供货商页面", "SELLER_VIEW_HTM"));
			urlMsgs.put("/htm/buyer/add.htm", new ActionMsg("打开新增购货商页面", "BUYER_ADD_HTM"));
			urlMsgs.put("/htm/buyer/edit.htm", new ActionMsg("打开修改购货商页面", "BUYER_EDIT_HTM"));
			urlMsgs.put("/htm/buyer/list.htm", new ActionMsg("打开购货商列表页面", "BUYER_LIST_HTM"));
			urlMsgs.put("/htm/buyer/view.htm", new ActionMsg("打开查看购货商页面", "BUYER_VIEW_HTM"));
			urlMsgs.put("/htm/contract/add.htm", new ActionMsg("打开新增保理合同页面", "CONTRACT_ADD_HTM"));
			urlMsgs.put("/htm/contract/edit.htm", new ActionMsg("打开修改保理合同页面", "CONTRACT_EDIT_HTM"));
			urlMsgs.put("/htm/contract/list.htm", new ActionMsg("打开保理合同列表页面", "CONTRACT_LIST_HTM"));
			urlMsgs.put("/htm/contract/view.htm", new ActionMsg("打开查看保理合同页面", "CONTRACT_VIEW_HTM"));
			urlMsgs.put("/htm/ar/add.htm", new ActionMsg("打开新增应收账款页面", "AR_ADD_HTM"));
			urlMsgs.put("/htm/ar/edit.htm", new ActionMsg("打开修改应收账款页面", "AR_EDIT_HTM"));
			urlMsgs.put("/htm/ar/list.htm", new ActionMsg("打开应收账款列表页面", "AR_LIST_HTM"));
			urlMsgs.put("/htm/ar/view.htm", new ActionMsg("打开查看应收账款页面", "AR_VIEW_HTM"));
			urlMsgs.put("/htm/user/add.htm", new ActionMsg("打开新增用户页面", "USER_ADD_HTM"));
			urlMsgs.put("/htm/user/edit.htm", new ActionMsg("打开修改用户页面", "USER_EDIT_HTM"));
			urlMsgs.put("/htm/user/list.htm", new ActionMsg("打开用户列表页面", "USER_LIST_HTM"));
			urlMsgs.put("/htm/user/view.htm", new ActionMsg("打开查看用户页面", "USER_VIEW_HTM"));
			urlMsgs.put("/htm/user/pwd.htm", new ActionMsg("打开修改用户密码页面", "USER_PWD_HTM"));
			urlMsgs.put("/htm/role/add.htm", new ActionMsg("打开新增角色页面", "USER_ADD_HTM"));
			urlMsgs.put("/htm/role/edit.htm", new ActionMsg("打开修改角色页面", "USER_EDIT_HTM"));
			urlMsgs.put("/htm/role/list.htm", new ActionMsg("打开角色列表页面", "USER_LIST_HTM"));
			urlMsgs.put("/htm/role/view.htm", new ActionMsg("打开查看角色页面", "USER_VIEW_HTM"));
			
			urlMsgs.put("/htm/work/check.htm", new ActionMsg("打开待审核工作页面", "WORK_CHECK_HTM"));
			urlMsgs.put("/htm/seller/check.htm", new ActionMsg("打开供货商审核工作页面", "SELLER_CHECK_HTM"));
			urlMsgs.put("/htm/buyer/check.htm", new ActionMsg("打开购货商审核工作页面", "BUYER_CHECK_HTM"));
			urlMsgs.put("/htm/contract/check.htm", new ActionMsg("打开保理合同审核工作页面", "CONTRACT_CHECK_HTM"));
			urlMsgs.put("/htm/ar/check.htm", new ActionMsg("打开应收账款审核工作页面", "AR_CHECK_HTM"));
			urlMsgs.put("/htm/user/check.htm", new ActionMsg("打开用户审核工作页面", "USER_CHECK_HTM"));
			urlMsgs.put("/htm/role/check.htm", new ActionMsg("打开角色审核工作页面", "ROLE_CHECK_HTM"));
			
			urlMsgs.put("/htm/seller/checklist.htm", new ActionMsg("打开供货商审核列表页面", "SELLER_CHECK_LIST_HTM"));
			urlMsgs.put("/htm/buyer/checklist.htm", new ActionMsg("打开购货商审核列表页面", "BUYER_CHECK_LIST_HTM"));
			urlMsgs.put("/htm/contract/checklist.htm", new ActionMsg("打开保理合同审核列表页面", "CONTRACT_CHECK_LIST_HTM"));
			urlMsgs.put("/htm/ar/checklist.htm", new ActionMsg("打开应收账款审核列表页面", "AR_CHECK_LIST_HTM"));
			urlMsgs.put("/htm/user/checklist.htm", new ActionMsg("打开用户审核列表页面", "USER_CHECK_LIST_HTM"));
			urlMsgs.put("/htm/role/checklist.htm", new ActionMsg("打开角色审核列表页面", "ROLE_CHECK_LIST_HTM"));
			
			urlMsgs.put("/htm/seller/status.htm", new ActionMsg("打开供货商状态列表页面", "SELLER_STATUS_LIST_HTM"));
			urlMsgs.put("/htm/buyer/status.htm", new ActionMsg("打开购货商状态列表页面", "BUYER_STATUS_LIST_HTM"));
			urlMsgs.put("/htm/contract/status.htm", new ActionMsg("打开保理合同状态列表页面", "CONTRACT_STATUS_LIST_HTM"));
			urlMsgs.put("/htm/ar/status.htm", new ActionMsg("打开应收账款状态列表页面", "AR_STATUS_LIST_HTM"));
			urlMsgs.put("/htm/user/status.htm", new ActionMsg("打开用户状态列表页面", "USER_STATUS_LIST_HTM"));
			urlMsgs.put("/htm/role/status.htm", new ActionMsg("打开角色状态列表页面", "ROLE_STATUS_LIST_HTM"));
			
			urlMsgs.put("/htm/work/toast.htm", new ActionMsg("打开到期提醒列表页面", "WORK_TOAST_HTM"));
			urlMsgs.put("/htm/ar/toast.htm", new ActionMsg("打开应收账款到期提醒查看页面", "AR_TOAST_HTM"));
			
			urlMsgs.put("/ana/login.ajax", new ActionMsg("登陆操作", "USER_LOGIN_AJAX"));
			urlMsgs.put("/ana/logout.do", new ActionMsg("退出操作", "USER_LOGOUT_DO"));
			urlMsgs.put("/company/querySeller.ajax", new ActionMsg("查询供货商", "SELLER_QUERY_AJAX"));
			urlMsgs.put("/company/querSellerCheck.ajax", new ActionMsg("查询供货商待审核列表", "SELLER_QUERY_CHECK_AJAX"));
			urlMsgs.put("/company/querBuyerCheck.ajax", new ActionMsg("查询购货商待审核列表", "BUYER_QUERY_CHECK_AJAX"));
			urlMsgs.put("/company/querSellerStatus.ajax", new ActionMsg("查询供货商状态列表", "SELLER_QUERY_STATUS_AJAX"));
			urlMsgs.put("/company/querBuyerStatus.ajax", new ActionMsg("查询购货商状态列表", "BUYER_QUERY_STATUS_AJAX"));
			urlMsgs.put("/company/queryBuyer.ajax", new ActionMsg("查询购货商", "BUYER_QUERY_AJAX"));
			urlMsgs.put("/company/addSeller.ajax", new ActionMsg("新增供货商", "SELLER_ADD_AJAX"));
			urlMsgs.put("/company/addBuyer.ajax", new ActionMsg("新增购货商", "BUYER_ADD_AJAX"));
			urlMsgs.put("/company/editSeller.ajax", new ActionMsg("修改供货商", "SELLER_EDIT_AJAX"));
			urlMsgs.put("/company/editBuyer.ajax", new ActionMsg("修改购货商", "BUYER_EDIT_AJAX"));
			urlMsgs.put("/company/checkSeller.ajax", new ActionMsg("审核供（购）货商", "SELLER_CHECK_AJAX"));
			urlMsgs.put("/company/downloadCompanyFile.ajax", new ActionMsg("下载供（购）货商附件", "DOWNLOAD_COMPANY_FILE_AJAX"));
			urlMsgs.put("/company/downloadCompanyCaseFile.ajax", new ActionMsg("下载供（购）货商临时附件", "DOWNLOAD_COMPANY_CASE_FILE_AJAX"));
			urlMsgs.put("/company/getCompanyById.ajax", new ActionMsg("获取单个供（购）货商信息", "GET_COMPANY_BY_ID_AJAX"));
			urlMsgs.put("/company/getCompanyCaseById.ajax", new ActionMsg("获取单个供（购）货商临时信息", "GET_COMPANY_CASE_BY_ID_AJAX"));
			urlMsgs.put("/company/loadSellerById.ajax", new ActionMsg("加载供货商信息", "LOAD_SELLER_BY_ID_AJAX"));
			urlMsgs.put("/company/downloadBuyerByQuery.ajax", new ActionMsg("下载购货商信息", "DOWNLOAD_BUYER_AJAX"));
			urlMsgs.put("/company/downloadSellerByQuery.ajax", new ActionMsg("下载供货商信息", "DOWNLOAD_SELLER_AJAX"));
			urlMsgs.put("/contract/queryContract.ajax", new ActionMsg("查询保理合同", "CONTRACT_QUERY_AJAX"));
			urlMsgs.put("/contract/queryContractCheck.ajax", new ActionMsg("查询保理合同审核列表", "CONTRACT_QUERY_CHECK_AJAX"));
			urlMsgs.put("/contract/queryContractStatus.ajax", new ActionMsg("查询保理合同状态", "CONTRACT_QUERY_STATUS_AJAX"));
			urlMsgs.put("/contract/addContract.ajax", new ActionMsg("新增保理合同", "CONTRACT_ADD_AJAX"));
			urlMsgs.put("/contract/editContract.ajax", new ActionMsg("修改保理合同", "CONTRACT_EDIT_AJAX"));
			urlMsgs.put("/contract/checkContract.ajax", new ActionMsg("审核保理合同", "CONTRACT_CHECK_AJAX"));
			urlMsgs.put("/contract/downloadContractFileById.ajax", new ActionMsg("下载保理合同附件", "DOWNLOAD_CONTRACT_FILE_AJAX"));
			urlMsgs.put("/contract/getContractById.ajax", new ActionMsg("获取单个保理合同信息", "GET_CONTRACT_BY_ID_AJAX"));
			urlMsgs.put("/contract/getContractCaseById.ajax", new ActionMsg("获取单个保理合同临时信息", "GET_CONTRACT_CASE_BY_ID_AJAX"));
			urlMsgs.put("/contract/downloadContractByQuery.ajax", new ActionMsg("下载保理合同信息", "DOWNLOAD_CONTRACT_AJAX"));
			urlMsgs.put("/ar/queryAr.ajax", new ActionMsg("查询应收账款", "AR_QUERY_AJAX"));
			urlMsgs.put("/ar/queryArCheck.ajax", new ActionMsg("查询应收账款审核列表", "AR_QUERY_CHECK_AJAX"));
			urlMsgs.put("/ar/queryToast.ajax", new ActionMsg("查询应收账款到期提醒", "AR_TOAST_QUERY_AJAX"));
			urlMsgs.put("/ar/queryArStatus.ajax", new ActionMsg("查询应收账款状态", "AR_QUERY_STATUS_AJAX"));
			urlMsgs.put("/ar/addAr.ajax", new ActionMsg("新增应收账款", "AR_ADD_AJAX"));
			urlMsgs.put("/ar/editAr.ajax", new ActionMsg("修改应收账款", "AR_EDIT_AJAX"));
			urlMsgs.put("/ar/checkAr.ajax", new ActionMsg("审核应收账款", "AR_CHECK_AJAX"));
			urlMsgs.put("/ar/downloadArFileById.ajax", new ActionMsg("下载应收账款附件", "DOWNLOAD_AR_FILE_AJAX"));
			urlMsgs.put("/ar/getArById.ajax", new ActionMsg("获取单个应收账款信息", "GET_AR_BY_ID_AJAX"));
			urlMsgs.put("/ar/getToastArById.ajax", new ActionMsg("获取单个应收账款到期提醒信息", "GET_AR_TOAST_BY_ID_AJAX"));
			urlMsgs.put("/ar/getArCaseById.ajax", new ActionMsg("获取单个应收账款临时信息", "GET_AR_CASE_BY_ID_AJAX"));
			urlMsgs.put("/ar/downloadArByQuery.ajax", new ActionMsg("下载应收账款信息", "DOWNLOAD_AR_AJAX"));
			urlMsgs.put("/user/query.ajax", new ActionMsg("查询用户信息", "USER_QUERY_AJAX"));
			urlMsgs.put("/user/queryCheck.ajax", new ActionMsg("查询用户审核列表信息", "USER_QUERY_CHECK_AJAX"));
			urlMsgs.put("/user/queryStatus.ajax", new ActionMsg("查询用户状态信息", "USER_QUERY_STATUS_AJAX"));
			urlMsgs.put("/user/getUserByUserId.ajax", new ActionMsg("获取单个用户信息", "GET_USER_BY_ID_AJAX"));
			urlMsgs.put("/user/getUserCaseByUserId.ajax", new ActionMsg("获取单个用户临时信息", "GET_USER_CASE_BY_ID_AJAX"));
			urlMsgs.put("/user/addUser.ajax", new ActionMsg("新增用户", "USER_ADD_AJAX"));
			urlMsgs.put("/user/editUser.ajax", new ActionMsg("修改用户", "USER_EDIT_AJAX"));
			urlMsgs.put("/user/checkUser.ajax", new ActionMsg("审核用户", "USER_CHECK_AJAX"));
			urlMsgs.put("/user/changePassword.ajax", new ActionMsg("修改用户密码", "USER_CHANGE_PASSWORD_AJAX"));
			urlMsgs.put("/user/changePasswordForLoginUser.ajax", new ActionMsg("修改登陆用户密码", "CHANGE_PASSWORD_FOR_LOGIN_USER_AJAX"));
			urlMsgs.put("/user/downloadUserByQuery.ajax", new ActionMsg("下载用户信息", "DOWNLOAD_USER_AJAX"));
			urlMsgs.put("/role/query.ajax", new ActionMsg("查询角色信息", "ROLE_QUERY_AJAX"));
			urlMsgs.put("/role/queryCheck.ajax", new ActionMsg("查询角色审核列表信息", "ROLE_QUERY_CHECK_AJAX"));
			urlMsgs.put("/role/queryStatus.ajax", new ActionMsg("查询角色状态信息", "ROLE_QUERY_STATUS_AJAX"));
			urlMsgs.put("/role/addRole.ajax", new ActionMsg("新增角色", "ROLE_ADD_AJAX"));
			urlMsgs.put("/role/editRole.ajax", new ActionMsg("修改角色", "ROLE_EDIT_AJAX"));
			urlMsgs.put("/role/checkRole.ajax", new ActionMsg("审核角色", "ROLE_CHECK_AJAX"));
			urlMsgs.put("/role/getRoleByRoleId.ajax", new ActionMsg("获取单个角色信息", "GET_ROLE_BY_ID_AJAX"));
			urlMsgs.put("/role/getRoleCaseByRoleId.ajax", new ActionMsg("获取单个角色临时信息", "GET_ROLE_CASE_BY_ID_AJAX"));
			urlMsgs.put("/role/downloadRoleByQuery.ajax", new ActionMsg("下载角色信息", "DOWNLOAD_ROLE_AJAX"));
			
			urlMsgs.put("/work/getCheckWorksCount.ajax", new ActionMsg("获取待审核信息统计", "CHECK_WORKS_COUNT_AJAX"));
	}

}
