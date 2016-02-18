package com.user.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.user.domain.UserVO;
import com.user.service.UserService;

@Controller
@RequestMapping("/user/*")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	private UserService service;
	// private BoardService service;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET() throws Exception {
		
		logger.info("register get......");
	/*	
		UserVO vo = new UserVO();
		vo.setUserid("banseok");
		vo.setUserpw("1234");
		vo.setUsername("이반석");
		vo.setAge(14);
		vo.setBirth(870411);
		vo.setPhone(01023232232);

		service.insert(vo);

		List<UserVO> list = service.listAll();
		for (int i = 0; i < list.size(); i++) {
			logger.info("list.num :" + i + " , " + list.get(i).getUserid() + ": " + list.get(i).getUsername());

		}*/
		

	}
	
	@RequestMapping(value="/register" , method= RequestMethod.POST)
	public String registerPOST(Model Model ,UserVO vo) throws Exception{
		
		
		
		logger.info("regist post.....");
		logger.info(vo.toString());
		
		service.insert(vo);
		
		Model.addAttribute("result", "success");
		
		return "redirect:listall";
	}

	
	@RequestMapping(value="/home")
	public String home(){
		
		return "user/home";
	}
	
	@RequestMapping(value="/listall")
	public String listAll(Model model)throws Exception{
		
		
		logger.info("userlist....... ");
		
		List<UserVO> userlist= service.listAll();
		
		for(int i=0;i<userlist.size();i++){
			logger.info(userlist.get(i).getUsername()+"가입날짜:"+userlist.get(i).getRegdate());
		}
		
		 
		 model.addAttribute("userList", userlist);
		
		return "user/userlist";
	}
	
	@RequestMapping(value="/userinfo")
	public String userinfo(Model model , String userid)throws Exception{
		
		logger.info("userinfo....");
		
		UserVO vo = service.read(userid);
		
		logger.info("vo:"+ vo.toString());
		
		model.addAttribute("userVO" , vo);
		
		return "user/userinfo";
	}
	
	@RequestMapping(value="/userEdit", method=RequestMethod.GET)
	public String userEditGet(Model model , String userid)throws Exception{
		
		logger.info("userEditGet....");
		
		UserVO vo = service.read(userid);
		
		logger.info("vo:"+ vo.toString());
		
		model.addAttribute("userVO" , vo);
		
		return "user/userEdit";
	}
	
	
	@RequestMapping(value="/userEdit" , method=RequestMethod.POST)
	public String userEditPost(Model model , UserVO vo)throws Exception {
		
		logger.info("userEditPost....");
		
		service.update(vo);
		
		logger.info("수정된후 vo:"+service.read(vo.getUserid()).toString());
		
		model.addAttribute("userid", vo.getUserid());
		
		return "user/userinfo";
	}
	
		

}
