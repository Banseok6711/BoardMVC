package com.localStore.user;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.user.domain.UserVO;
import com.user.persistence.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class UserTest {
	
	private static final Logger logger = LoggerFactory.getLogger(UserTest.class);  
	
	@Inject
	private UserDAO dao;
	
	@Test
	public void registerTest()throws Exception{
		
		UserVO vo = new UserVO();
		vo.setBirth(870311);
		vo.setEmail("seok7811@mail.com");
		vo.setPhone(01033331112);
		vo.setUserid("updateid6");
		vo.setUsername("Lee");
		vo.setUserpw("11111");
				
		dao.create(vo);
						
	}
	
	@Test
	public void readTest()throws Exception{
		
		logger.info(dao.read("idcheck").getUserid());
	}
	
	@Ignore
	@Test	
	public void updateTest()throws Exception{
		
		UserVO vo = new UserVO();

		vo.setUserid("updateid3");
		vo.setEmail("0000@mail.com");
		vo.setPhone(0000000);
		vo.setUserpw("0000");
		
		dao.update(vo);
		
		logger.info("update after email:"+dao.read("updateid3").getEmail());
	}
	
	@Test
	public void deleteTest() throws Exception{
		
		logger.info("before:"+dao.read("updateid6").toString());
		
		dao.delete("updateid6");
		
		logger.info("after:"+dao.read("updateid6"));
				
	}

}
