package com.localStore.userBoard;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.userBoard.domain.UserBoardVO;
import com.userBoard.paging.Criteria;
import com.userBoard.paging.SearchCriteria;
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
	
	@Test
	public void testListPage()throws Exception{
		
		int page = 1 ;
		
		List<UserBoardVO> list = dao.listPage(page);
		
		for(UserBoardVO boardVO  : list){
			logger.info(boardVO.getBno()+ " : "+ boardVO.getTitle());
		}
		
	}
	
	@Test
	public void testListCriteria()throws Exception{
		
		Criteria cri = new Criteria();
		
		cri.setPage(3);
		cri.setPerPageNum(20);
		
		List<UserBoardVO> list = dao.listCriteria(cri);
		
		for(UserBoardVO boardVO : list){
			logger.info(boardVO.getBno()+ ":" + boardVO.getTitle());
		}
	}
	
	@Test
	public void testURI()throws Exception{
		
		UriComponents uriComponents = 
				UriComponentsBuilder.newInstance()
				.path("/userBoard/listPage")
				.queryParam("bno", 12)
				.queryParam("perPageNum", 20)
				.build();
		
		logger.info("/userBoard/listPage?bno=12&perPageNum=20");
		logger.info(uriComponents.toString());
	}
	
	@Test
	public void testDynamic1() throws Exception{
		
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(1);
		cri.setKeyword("타이틀");
		cri.setSearchType("t");
		
		logger.info("===================");
		
		List<UserBoardVO> list =dao.listSearch(cri);
		
		for(UserBoardVO boardVo :list){
			logger.info(boardVo.getBno()+" : "+ boardVo.getTitle());
		}
		
		logger.info("===================");
		
		logger.info("count:"+dao.listSearchCount(cri));
		
	}
	

}
