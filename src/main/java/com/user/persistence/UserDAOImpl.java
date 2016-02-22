package com.user.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.user.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	private static final String namespace="com.banseok.user";
	
	@Inject
	private SqlSession session;

	@Override
	public void create(UserVO vo) throws Exception {
		
		session.insert(namespace+".create", vo);

	}

	@Override
	public List<UserVO> listAll() throws Exception {
		return session.selectList(namespace+".listAll");
	}

	@Override
	public UserVO read(String userid) throws Exception {
		
		return session.selectOne(namespace+".read" , userid);
		
	}

	@Override
	public void update(UserVO vo) throws Exception {
		
		session.update(namespace+".update", vo);
	}

	@Override
	public void delete(String userid) throws Exception {
		session.delete(namespace+".delete", userid);
	}

	@Override
	public UserVO login(UserVO vo) throws Exception {
		
		return session.selectOne(namespace+".login" , vo);
	}

}
