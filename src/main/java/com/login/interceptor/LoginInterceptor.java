package com.login.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.user.domain.UserVO;

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
		
		//admin test . ... permanent 
	/*	if(session.getAttribute("admin") != null){
			session.removeAttribute("admin");
		}*/
		
		
		return true;
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		logger.info("postHandle......");
		System.out.println("postHandledle.....");
		
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		UserVO userVO = (UserVO)modelMap.get("userVO");
		
		
		
		// 회원일때 로그인 처리 
		if(userVO != null){
			
			logger.info("new login success");
			
			//관리자로 로그인
			if(userVO.getUserid().equals("admin")){
				session.setAttribute("admin", "login");				
			}else{
				session.setAttribute(LOGIN, userVO);				
			}
			
			response.sendRedirect("/user/home");
			
		}else{ // 아이디나 비밀번호 틀리거나 회원이 아닐때 
			
			System.out.println("로그인 실패 ...");
			
//			request.setAttribute("msg", "loginFail");
			
			modelAndView.addObject("msg", "loginFail");
			modelAndView.setViewName("/user/home");
			
		}
		
		
	}

}
