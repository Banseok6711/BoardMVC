package com.userBoard.persistence;

import java.util.List;

import com.userBoard.domain.UserBoardVO;

public interface UserBoardDAO {
	
	public void write(UserBoardVO boardVO)throws Exception;
	
	public UserBoardVO read(int bno)throws Exception;
	
	public UserBoardVO edit(UserBoardVO boardVO)throws Exception;
	
	public void delete(int bno)throws Exception;
	
	public List<UserBoardVO> list()throws Exception;

}
