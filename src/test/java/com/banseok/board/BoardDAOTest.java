package com.banseok.board;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.banseok.domain.BoardVO;
import com.banseok.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {
	
	@Inject
	private BoardDAO dao ;
	
	@Test
	public void testTime()throws Exception{
		
		System.out.println(dao);
	}
	
	@Test
	public void testInsert()throws Exception{
		
		BoardVO vo = new BoardVO();
		vo.setContent("new123");
		vo.setTitle("title123");
		vo.setWriter("writer123");
		
		dao.create(vo);
	}

}
