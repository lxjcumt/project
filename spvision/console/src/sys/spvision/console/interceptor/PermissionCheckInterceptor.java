package sys.spvision.console.interceptor;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import sys.spvision.core.entity.ana.Permission;


public class PermissionCheckInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
			Object handler) throws Exception {
		HttpSession session = req.getSession(false);
		if (session == null) {
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			return false;
		}

		boolean find = false;
		String curPath = req.getServletPath();
		List<Permission> permissions = (List<Permission>) session.getAttribute("USER_PERMISSIONS");
		
		outer:
		for (Permission p : permissions) {
			String urlFilter = p.getUrlFilter().trim();
			if ((urlFilter == "") || (urlFilter == null)) {
				continue;
			}
			
			String[] subFilters = urlFilter.split(";|,");
			for (String subFilter : subFilters) {
				Pattern pat = Pattern.compile(subFilter, Pattern.CASE_INSENSITIVE);
				Matcher mat = pat.matcher(curPath);
				if (mat.find()) {
					find = true;
					break outer;
				}
			}			
		}
		
		if (find) {
			return true;
		} else {
//			res.sendError(HttpServletResponse.SC_FORBIDDEN);
//			res.sendError(HttpServletResponse.SC_FORBIDDEN, new String("没有操作权限，请于管理员联系")); 
			System.out.println("缺少权限:"+curPath);
			res.getWriter().print("403——没有操作权限，请于管理员联系");
			return false;
		}
	}

}
