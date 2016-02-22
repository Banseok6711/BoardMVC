package com.localStore.userBoard;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.userBoard.domain.UserBoardVO;
import com.userBoard.persistence.UserBoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class UserBoardTest {
	
	
	private static final Logger logger = LoggerFactory.getLogger(UserBoardTest.class);
	
	@Inject
	UserBoardDAO dao;
	
	@Test
	public void writeTest()throws Exception{
		
		UserBoardVO boardVO = new UserBoardVO();
		boardVO.setTitle("타이틀");
		boardVO.setContent("컨텐트");
		boardVO.setUserid("seok6711");
				
		dao.write(boardVO);
		
	}
	
	@Test
	public void readTest()throws Exception{
		
		
		
		UserBoardVO vo= dao.read(3);
		
		logger.info(vo.toString());
		
	}

}
