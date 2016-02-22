package com.userBoard.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.userBoard.domain.UserBoardVO;

@Repository
public class UserBoardDAOImpl implements UserBoardDAO{
	
	private final String nameSpace="com.banseok.userBoard";
	
	private static final Logger logger  =LoggerFactory.getLogger(UserBoardDAOImpl.class);
	
	@Inject
	SqlSession session;

	@Override
	public void write(UserBoardVO boardVO) throws Exception {
		
		logger.info("write.....");
		logger.info("boardVO:"+boardVO.toString());
		
		session.insert(nameSpace+".write" , boardVO);
		
	}

	@Override
	public UserBoardVO read(int bno) throws Exception {
		
		logger.info("read.....");		
		
		return session.selectOne(nameSpace+".read", Integer.valueOf(bno));		
		
	}

	@Override
	public UserBoardVO edit(UserBoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserBoardVO> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
