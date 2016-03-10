package com.userBoard.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.userBoard.domain.UserBoardVO;
import com.userBoard.paging.Criteria;

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
	public void edit(UserBoardVO boardVO) throws Exception {
				
		 session.update(nameSpace+".edit", boardVO);
	}

	@Override
	public void delete(int bno) throws Exception {
		
		session.delete(nameSpace+".delete" , Integer.valueOf(bno));
		
	}

	@Override
	public List<UserBoardVO> list() throws Exception {
		
		logger.info("list...");
		
		
		return session.selectList(nameSpace+".list");
	}

	@Override
	public List<UserBoardVO> listPage(int page) throws Exception {
		
		if(page <=0){
			page = 1;
		}
		
		page = (page-1)*10;
		return session.selectList(nameSpace+".listPage" , page);
	}

	@Override
	public List<UserBoardVO> listCriteria(Criteria cri) throws Exception {
		
		
		
		return session.selectList(nameSpace+".listCriteria" , cri);
	}
	
	

}
