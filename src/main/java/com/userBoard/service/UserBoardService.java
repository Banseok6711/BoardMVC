package com.userBoard.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.userBoard.domain.UserBoardVO;
import com.userBoard.paging.Criteria;
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
	
	public void edit(UserBoardVO boardVO)throws Exception{
		
		dao.edit(boardVO);
	}
	
	public void delete(int bno)throws Exception{
		dao.delete(bno);
	}
	
	public List<UserBoardVO> list()throws Exception{
				
		return dao.list();		
	}
	
	public List<UserBoardVO> listCriteria(Criteria cri)throws Exception{
		
		return dao.listCriteria(cri);
	}
	
	public int listCountCriteria(Criteria cri)throws Exception{
		
		return dao.countPaging(cri);
	}
	
	
	

}
