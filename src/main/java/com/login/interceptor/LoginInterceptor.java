package com.login.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	private static final String LOGIN = "login";
	private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		
		logger.info("prehandle .....");
		System.out.println("prehandle.....");
		
		if(session.getAttribute(LOGIN) != null){
			logger.info("clear login data before");
			session.removeAttribute(LOGIN);
		}
		
		return true;
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		logger.info("postHandle......");
		System.out.println("postHandledle.....");
		
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		Object userVO = modelMap.get("userVO");
		
		
		
		// 회원일때 로그인 처리 
		if(userVO != null){
			
			logger.info("new login success");
			session.setAttribute(LOGIN, userVO);
			response.sendRedirect("/user/home");
		}else{ // 아이디나 비밀번호 틀리거나 회원이 아닐때 
			
			System.out.println("로그인 실패 ...");			
			response.sendRedirect("/user/home");
		}
		
		
	}

}
