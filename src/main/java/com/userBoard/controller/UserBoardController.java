package com.userBoard.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.user.domain.UserVO;
import com.user.service.UserService;
import com.userBoard.domain.UserBoardVO;
import com.userBoard.paging.Criteria;
import com.userBoard.paging.PageMaker;
import com.userBoard.paging.SearchCriteria;
import com.userBoard.service.UserBoardService;


@Controller
@RequestMapping("/userBoard/*")
public class UserBoardController {
	
	private static Logger logger = LoggerFactory.getLogger(UserBoardController.class);
	
	@Inject	
	private UserService userService;
	
	@Inject
	private UserBoardService userBoardService;
	
	@RequestMapping(value="/write" ,method=RequestMethod.GET)
	public String write(Model model ,  HttpSession session)throws Exception{
		
		UserVO user=(UserVO)session.getAttribute("login");
		
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
	
	@RequestMapping(value="/write" , method=RequestMethod.POST)
	public String write(Model model , HttpSession session, UserBoardVO boardVO,String writer )throws Exception{
		
		UserVO vo =(UserVO)session.getAttribute("login");
		
		
		//not login -> set Writer where userid = writer
		if(vo == null){
			boardVO.setUserid(writer);
		}else{
			boardVO.setUserid(vo.getUserid());
		}
		
		
		userBoardService.write(boardVO);		
		
		UserVO userVO = userService.read(boardVO.getUserid());
		
		logger.info(userVO.toString());
		
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("userVO", userVO);
		
		return "userBoard/userBoardInfoPage";
	}
	
	@RequestMapping(value="/read" , method=RequestMethod.GET)
	//@RequestParam , @ModelAttribute는 생략가능( nomarl data type  (int ,String..) ->RequstParam , specific object which is made(Criteria,Car,User..)  ->ModelAttribute
	public String read(@ModelAttribute Model model ,@RequestParam("bno") int bno , HttpSession session)throws Exception{
		
//		int bnoNumber = Integer.parseInt(bno);
		
		UserBoardVO boardVO= userBoardService.read(bno);
		
		UserVO userVO = userService.read(boardVO.getUserid());
				
		
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("userVO", userVO);
		
		return "userBoard/userBoardInfo";
	}
	
	@RequestMapping(value="/boardList" , method=RequestMethod.GET)
	public String list(Model model)throws Exception{
		
		List<UserBoardVO> list= userBoardService.list();
		
		model.addAttribute("boardList", list);
		
		return "userBoard/userBoardList";
	}
	
	
	@RequestMapping(value="/userBoardDelete" , method=RequestMethod.GET)
	public String delete(String bno , Criteria cri , RedirectAttributes rttr)throws Exception{
		
		int bnoNumber = Integer.parseInt(bno);
		
		userBoardService.delete(bnoNumber);
		
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum",cri.getPerPageNum());
		
		return "redirect:/userBoard/listPage";
	}
	
	@RequestMapping(value="/userBoardEdit" , method=RequestMethod.POST)
	public String edit(UserBoardVO boardVO , Model model , String username)throws Exception{
		
		
		System.out.println("boardVO:"+boardVO.toString());
		
		UserBoardVO vo= userBoardService.read(boardVO.getBno());
		
		boardVO.setUserid(vo.getUserid());
		
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("username", username);
		
		return "userBoard/userBoardEdit";
	}
	
	@RequestMapping(value="/userBoardEditPro" , method=RequestMethod.POST)
	public String editPro(Model model , UserBoardVO boardVO ,Criteria cri, RedirectAttributes rttr)throws Exception{
		
//		int bnoNum = Integer.parseInt(bno);
		
//		boardVO.setBno(bnoNum);
		
		userBoardService.edit(boardVO);
		
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum",cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "SUCESS");
		
		
		return "redirect:/userBoard/listPage";
	}
	
	@RequestMapping(value="/listCri" , method=RequestMethod.GET)
	public String listAll(@ModelAttribute Criteria cri , Model model)throws Exception{
		
		logger.info("show list page with Criteria.......");
		
		model.addAttribute("boardList", userBoardService.listCriteria(cri));
		
		return "userBoard/userBoardListCri";
	}
	
	@RequestMapping(value="/listPage" )
	public String listPage(SearchCriteria cri , Model model)throws Exception{
		
		logger.info(cri.toString());
		
//		model.addAttribute("boardList",userBoardService.listCriteria(cri));
		model.addAttribute("boardList", userBoardService.listSearchCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
//		pageMaker.setTotalCount(userBoardService.listCountCriteria(cri));
		pageMaker.setTotalCount(userBoardService.listSearchCount(cri));
		

		
		System.out.println("searchCriteria.toString() : "+cri.toString());
		
		
		
		model.addAttribute("pageMaker", pageMaker);
		
		return "userBoard/userBoardListPage";
		
	}
		

	@RequestMapping(value="/readPage" , method= RequestMethod.GET)
	public String read(@RequestParam("bno") int bno , @ModelAttribute("cri") Criteria cri ,
					Model model)throws Exception{
		
		
		UserBoardVO boardVO= userBoardService.read(bno);
		
		UserVO userVO = userService.read(boardVO.getUserid());
				
		
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("userVO", userVO);
		
		//@ModelAttirbute로 받은 객체는 model에 안넣어줘도 자동으로 model에 포함 되는것 같음 .
//		model.addAttribute("cri", cri);
		
		return "userBoard/userBoardInfoPage";
	}
	
	@RequestMapping(value="/userBoardEditPage" , method=RequestMethod.POST)
	public String editPage(UserBoardVO boardVO , Model model , String username ,
							@ModelAttribute("cri") Criteria cri)throws Exception{
		
		
		System.out.println("boardVO:"+boardVO.toString());
		
		UserBoardVO vo= userBoardService.read(boardVO.getBno());
		
		boardVO.setUserid(vo.getUserid());
		
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("username", username);
		
		return "userBoard/userBoardEditPage";
	}
	
	
	
	
	

}
