package com.cafe24.bitmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.bitmall.repository.UserRepository;
import com.cafe24.bitmall.vo.UserVo;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public UserVo getUser(UserVo vo) {	
		return userRepository.getUser(vo);
	}
	
}
