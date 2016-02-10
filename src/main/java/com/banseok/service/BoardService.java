package com.banseok.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.banseok.domain.BoardVO;
import com.banseok.persistence.BoardDAO;

@Service
public class BoardService {
	
	@Inject
	private BoardDAO dao;
	
	
	public void insert(BoardVO vo)throws Exception{
		
		dao.create(vo);
	}


	public List<BoardVO> listAll() throws Exception{
		// TODO Auto-generated method stub
		return dao.listAll();
	}
	
	

}
