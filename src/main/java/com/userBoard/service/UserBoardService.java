package com.userBoard.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.userBoard.domain.UserBoardVO;
import com.userBoard.persistence.UserBoardDAO;

@Service
public class UserBoardService {
	
	@Inject
	UserBoardDAO dao;
	
	public void write(UserBoardVO boardVO)throws Exception{
		dao.write(boardVO);
	}
	
	public UserBoardVO read(int bno)throws Exception{
		return dao.read(bno);
	}
	
	public UserBoardVO edit(UserBoardVO boardVO)throws Exception{
		
		return dao.edit(boardVO);
	}
	
	public void delete(int bno)throws Exception{
		dao.delete(bno);
	}
	
	public List<UserBoardVO> list()throws Exception{
		
		return dao.list();		
	}
	
	
	

}