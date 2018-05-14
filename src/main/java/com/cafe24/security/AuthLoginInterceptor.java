package com.cafe24.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.bitmall.service.UserService;
import com.cafe24.bitmall.vo.UserVo;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)	throws Exception {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		//UserService userService = new UserService();
		
		UserVo vo = new UserVo();
		vo.setId(id);
		vo.setPassword(password);

		ApplicationContext ac = 
		WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		UserService userService = ac.getBean(UserService.class);

		UserVo authUser = userService.getUser(vo);
		
		if(authUser == null && request.getHeader("referer").contains("user/login")) {
			response.sendRedirect(request.getContextPath()+"/user/login");
			return false;
		} else if(authUser == null && request.getHeader("referer").contains("admin/login")) {
			response.sendRedirect(request.getContextPath()+"/admin/login");
			return false;
		}
		
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", authUser);
		
		System.out.println(authUser.getUserClassNo());
		
		if(1L == authUser.getUserClassNo()) {
			response.sendRedirect(request.getContextPath()+"/admin/product");
			return false;
		}
		
		response.sendRedirect(request.getContextPath()+"/main");
		
		return false;
	}

	
}
