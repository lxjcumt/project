package sys.spvision.console.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sys.spvision.core.entity.ana.Permission;
import sys.spvision.core.entity.ana.User;
import sys.spvision.core.service.ana.AnaService;

import com.octo.captcha.service.CaptchaServiceException;
import com.octo.captcha.service.multitype.GenericManageableCaptchaService;

@Controller
@RequestMapping("/ana")
public class AnaController {
	@Autowired
	AnaService anaService;

	@Autowired
	GenericManageableCaptchaService captchaService;
	
	/*@Autowired
	private Producer captchaProducer;*/
	private static final String LOGIN_URL = "/htm/login.htm";

	@RequestMapping("/login.ajax")
	public @ResponseBody
	Map<String, Object> login(@RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("dynamicPassword") String dynamicPassword, HttpSession session, HttpServletRequest req) {
		
		Map<String, Object> result = new HashMap<String, Object>(2);
				
		//check username and password
		User u = anaService.checkUser(username, password);

		if (u == null) {
			result.put("success", false);
			result.put("message", "用户名或密码错误");
			req.setAttribute("logType", "LOGIN_FAIL");
		} else {
			session.setAttribute("USER_NAME", u.getName());
			session.setAttribute("USER_ID", u.getId());
			// set user permissons
			List<Permission> permissions = anaService.getUserPermissions(u.getId());
			session.setAttribute("USER_PERMISSIONS", permissions);
			result.put("success", true);
			result.put("message", "登录成功");
			req.setAttribute("log", "登录成功");
			req.setAttribute("logType", "LOGIN_SUCCESS");
			
		}
		return result;
	}

	@RequestMapping("/logout.do")
	public void logout(HttpServletRequest req, HttpServletResponse res,
			HttpSession session) throws Exception {
		session.setAttribute("USER_ID", null);
		session.invalidate();
		res.sendRedirect(req.getContextPath() + LOGIN_URL);
	}

	@RequestMapping("/getCurrentUserName.ajax")
	public @ResponseBody
	Map<String, Object> getCurrentUserName(HttpServletRequest req,
			HttpServletResponse res, HttpSession session) {
		Map<String, Object> result = new HashMap<String, Object>(1);
		result.put("username", session.getAttribute("USER_NAME"));
		result.put("userId", session.getAttribute("USER_ID"));
		return result;
	}

	@RequestMapping("/getCurrentMenus.ajax")
	public @ResponseBody
	Map<String, Object> getCurrentMenus(HttpServletRequest req,
			HttpServletResponse res, HttpSession session) {

		long userId = (Long) session.getAttribute("USER_ID");
		return anaService.getUserMenus(userId);
	}

	@RequestMapping("/checkPermission.ajax")
	public @ResponseBody
	Map<String, Object> checkPermission(
			@RequestParam("permissionCode") String permissionCode,
			HttpSession session) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Permission> permissons = (List<Permission>) session
				.getAttribute("USER_PERMISSIONS");
		// find permission in current user permissions(in session)
		boolean find = false;
		for (Permission p : permissons) {
			if (permissionCode.equals(p.getCode())) {
				find = true;
				break;
			}
		}
		result.put("success", find);
		return result;
	}
	
	@RequestMapping("/checkCheckPermission.ajax")
	public @ResponseBody
	Map<String, Object> checkCheckPermission(HttpSession session) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Permission> permissons = (List<Permission>) session
				.getAttribute("USER_PERMISSIONS");
		// find permission in current user permissions(in session)
		boolean find = false;
		List<String> checkList = new ArrayList<String>();
		checkList.add("SELLER_CHECK");
		checkList.add("BUYER_CHECK");
		checkList.add("CONTRACT_CHECK");
		checkList.add("AR_CHECK");
		checkList.add("USER_CHECK");
		checkList.add("ROLE_CHECK");
		for(String check: checkList){
			for (Permission p : permissons) {
				if (check.equals(p.getCode())) {
					find = true;
					break;
				}
			}
			if(find){
				break;
			}
		}
		result.put("success", find);
		return result;
	}

	@RequestMapping("/captcha.do")
	public void captcha(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws Exception {
		byte[] captchaChallengeAsJpeg = null;

		ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
		try {
			// Session ID is used to identify the particular captcha.
		      String captchaId = request.getSession().getId();

		      // Generate the captcha image.
		      BufferedImage challengeImage = (BufferedImage) captchaService
						.getChallengeForID(captchaId, request.getLocale());
		      
		      ImageIO.write( challengeImage, "jpeg", jpegOutputStream );

		} catch (IllegalArgumentException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		} catch (CaptchaServiceException e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return;
		}

		captchaChallengeAsJpeg = jpegOutputStream.toByteArray();

		// flush it in the response
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		ServletOutputStream responseOutputStream = response.getOutputStream();
		responseOutputStream.write(captchaChallengeAsJpeg);
		responseOutputStream.flush();
		responseOutputStream.close();
	}
	
}
