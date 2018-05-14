package com.cafe24.bitmall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.OptVo;
import com.cafe24.bitmall.vo.OptsVo;

@Repository
public class OptRepository {

	@Autowired
	SqlSession session;

	public List<OptVo> getOptList() {
		return session.selectList("opt.getOptList");
	}

	public Integer getTotalCount() {
		return session.selectOne("opt.getTotalCount");
	}

	public boolean insertOpt(OptVo optVo) {
		int count = session.insert("opt.insertOpt", optVo);
		return count == 1;
	}
	
	public boolean editOpt(OptVo optVo) {
		int count = session.update("opt.editOpt", optVo);
		return count == 1;
	}

	public boolean deleteOpt(Long no) {
		int count = session.delete("opt.deleteOpt", no);
		return count == 1;
	}
	
	public OptVo getOpt(Long no) {
		return session.selectOne("opt.getOpt", no);
	}

	public List<OptsVo> getOptsList(Long no) {
		return session.selectList("opt.getOptsList", no);
	}

	public String getOptName(Long no) {
		return session.selectOne("opt.getOptName", no);
	}

	public boolean insertOpts(OptsVo optsVo) {
		int count = session.insert("opt.insertOpts", optsVo);
		return count == 1;
	}
	
	public boolean editOpts(OptsVo optsVo) {
		int count = session.update("opt.editOpts", optsVo);
		return count == 1;
	}

	public boolean deleteOpts(Long no) {
		int count = session.delete("opt.deleteOpts", no);
		return count == 1;
	}
	
	public OptsVo getOpts(Long no) {
		return session.selectOne("opt.getOpts", no);
	}
}
