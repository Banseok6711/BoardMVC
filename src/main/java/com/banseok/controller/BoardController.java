package com.banseok.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.banseok.domain.BoardVO;
import com.banseok.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);	
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value= "/register" , method=RequestMethod.GET)
	public void registerGET() throws Exception{
		
		BoardVO vo = new BoardVO();
		vo.setTitle("test");
		vo.setContent("content test");
		vo.setWriter("test");
		
		service.insert(vo);
		
		List<BoardVO> list =service.listAll();
		for(int i=0;i<list.size();i++){
			logger.info(list.get(i).getBno()+": "+list.get(i).getTitle());
		}
			
		
	}
	

}
