package com.cafe24.bitmall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.ImageVo;

@Repository
public class FIleRepository {

	@Autowired
	SqlSession session;
	
	public boolean storeFile(ImageVo vo) {
		System.out.println("여긴 와?");
		int count = session.insert("file.insertImage", vo);
		System.out.println(count);
		return count == 1;
	}
	
	public List<ImageVo> getImageList(Long no) {
		return session.selectList("file.getImageList", no);
	}
	
}
