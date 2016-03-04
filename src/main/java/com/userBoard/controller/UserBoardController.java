package com.userBoard.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.user.domain.UserVO;
import com.user.service.UserService;
import com.userBoard.domain.UserBoardVO;
import com.userBoard.service.UserBoardService;

@Controller
@RequestMapping("/userBoard/*")
public class UserBoardController {
	
	private static Logger logger = LoggerFactory.getLogger(UserBoardController.class);
	
	@Inject	
	private UserService userService;
	
	@RequestMapping(value="/write" ,method=RequestMethod.GET)
	public String write(Model model , UserBoardVO vo , HttpSession session)throws Exception{
		
		UserVO user=(UserVO)session.getAttribute("login");
		
//		logger.info("userid:"+user.getUserid());
		
		
		
		// session is valid
		if( user != null ){
			UserVO userVO =userService.read(user.getUserid());
			model.addAttribute("userVO",userVO);
			
			System.out.println("userid:"+user.getUserid());
		}else{
			
		}
		//session is invalid
		
		
		return "userBoard/userBoardRegister";
	}
	
	
	
	
	
	

}
