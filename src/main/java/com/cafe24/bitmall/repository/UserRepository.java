package com.cafe24.bitmall.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.UserVo;

@Repository
public class UserRepository {

	@Autowired
	SqlSession session;
	
	public UserVo getUser(UserVo vo) {
		return session.selectOne("user.getByIdAndPassword", vo);
	}
	
}
