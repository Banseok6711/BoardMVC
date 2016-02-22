package com.userBoard.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.userBoard.domain.UserBoardVO;
import com.userBoard.service.UserBoardService;

@Controller
@RequestMapping("/userBoard/*")
public class UserBoardController {
	
	private static Logger logger = LoggerFactory.getLogger(UserBoardController.class);
	
	@Inject
	private UserBoardService service;
	
	@RequestMapping(value="/write" ,method=RequestMethod.POST)
	public String write(Model model , UserBoardVO vo)throws Exception{
		
		return "userBoard/userBoardRegister";
	}
	
	

}
