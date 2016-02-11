package com.user.persistence;

import java.util.List;

import com.user.domain.UserVO;

public interface UserDAO {
	
	public void create(UserVO vo)throws Exception;

	public List<UserVO> listAll()throws Exception;

	public UserVO read(String userid)throws Exception;
	
	public void update(UserVO vo)throws Exception;
	
	public void delete(String userid)throws Exception;
	
	
}
