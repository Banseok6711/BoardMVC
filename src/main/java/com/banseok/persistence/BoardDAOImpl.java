package com.banseok.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.banseok.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	private static final String namespace="com.banseok.board";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public void create(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		sqlSession.insert(namespace+".create" , vo);

	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer bno) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".listAll");

	}

}
