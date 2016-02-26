package com.user.controller;

import java.awt.Dialog.ModalExclusionType;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.runner.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
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
	public String home(Model model , String msg , HttpSession session){
		
		Object admin= session.getAttribute("admin");
//		session.invalidate();
		
//		System.out.println("admin: "+admin);
		logger.info("admin:"+admin);
		
		//admin으로 접속중
		if(admin != null){
			return "adminUser/home";
		}else{
			model.addAttribute("MSG" , msg);
			return "user/home";
		}		
	}
	
	@RequestMapping(value="/listall")
	public String listAll(Model model , String result)throws Exception{
		
		logger.info("listall... result:"+result);
		
	
		if(result == null){
			
		}	//삭제된 뒤에 list를 부를경우
		else if(result.equals("deleteSuccess")){
			model.addAttribute("msg", result);
			
		}
		
		logger.info("userlist....... ");
		
		List<UserVO> userlist= service.listAll();
		
		for(int i=0;i<userlist.size();i++){
			logger.info(userlist.get(i).getUsername()+"가입날짜:"+userlist.get(i).getRegdate());
		}
		
		 
		 model.addAttribute("userList", userlist);
		
		return "adminUser/userlist";
	}
	
	@RequestMapping(value="/userinfo")
	public String userinfo(Model model , String userid , HttpSession session)throws Exception{
		
		logger.info("userinfo....");
		
		UserVO vo ;
		//listAll 에서 회원 정보누르는 경우 파라미터로 userid를 넘겨받기때문에 userid가 null이 아님
		
		if(userid != null){
			vo = service.read(userid);
			
		}else{ //내정보를 누를때는 로그인한 사용자의 아이디가 저장되있는 세션에서 찾는다.  
			UserVO loginUser=(UserVO)session.getAttribute("login");		
			 vo = service.read(loginUser.getUserid());
		}
		
		
		logger.info("vo:"+ vo.toString());
		
		model.addAttribute("userVO" , vo);
		
		Object admin =session.getAttribute("admin");
		
		if(admin == null){
			return "user/userinfo";
		}else{
			return "adminUser/userinfo";
		}
		
		

		//임시 주석처리( admin 화면 테스트)	
//		return "user/userinfo";
	}
	
	@RequestMapping(value="/userEdit", method=RequestMethod.GET)
	public String userEditGet(Model model , String userid, HttpSession session)throws Exception{
		
		logger.info("userEditGet....");
		
		UserVO vo = service.read(userid);
		
		logger.info("vo:"+ vo.toString());
		
		model.addAttribute("userVO" , vo);
		
		
		Object admin =session.getAttribute("admin");
		
		if(admin == null){
			return "user/userEdit";
		}else{
			return "adminUser/userEdit";
		}
		
		
		
		
	}
	
	
	@RequestMapping(value="/userEdit" , method=RequestMethod.POST)
	public String userEditPost(Model model , UserVO vo, HttpSession session)throws Exception {
		
		logger.info("userEditPost....");
		
		service.update(vo);
		
		logger.info("수정된후 vo:"+service.read(vo.getUserid()).toString());
		
		model.addAttribute("userid", vo.getUserid());
		
		Object admin =session.getAttribute("admin");
		
		if(admin == null){
			return "user/userinfo";
		}else{
			return "adminUser/userinfo";
		}
		
		
		
	}
	
	@RequestMapping(value="/userDelete" , method=RequestMethod.GET)
	public String userDelete(Model model, String userid)throws Exception{
		logger.info("userDelete.....");
		
		service.delete(userid);
		
		logger.info("삭제된후 :"+service.read(userid));
		
		model.addAttribute("result", "deleteSuccess");
		
		return "redirect:/user/listall";
	}
	
	
	@RequestMapping(value="/loginPost" , method=RequestMethod.POST)
	public String loginCheck(Model model ,UserVO vo)throws Exception{
		
		UserVO user =service.login(vo);
		
		//user == null
		/*if(user == null){
			
		}
		*/
		model.addAttribute("userVO", user);
		
		logger.info("Controller:loginPOst");
		
		
		return "forward:/user/home";
		
			
	}
	
	@RequestMapping("/logout")
	public String logout(Model model, HttpSession session)throws Exception{
		
		session.invalidate();
		
		model.addAttribute("msg", "logout");
		
		
		return "user/home";
	}
	
	
	
		

}
