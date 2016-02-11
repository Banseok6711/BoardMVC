package com.user.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.user.domain.UserVO;
import com.user.persistence.UserDAO;

@Service
public class UserService {
	
	@Inject
	private UserDAO dao;
	
	public void insert(UserVO vo)throws Exception{
		dao.create(vo);
	}
	
	public List<UserVO> listAll() throws Exception{
		return dao.listAll();
	}
	
	public UserVO read(String userid)throws Exception{
		
		return dao.read(userid);
	}
	
	
	public void update(UserVO vo)throws Exception{
		
		dao.update(vo);
	}
	
	public void delete(String userid)throws Exception{
		dao.delete(userid);
	}

}
