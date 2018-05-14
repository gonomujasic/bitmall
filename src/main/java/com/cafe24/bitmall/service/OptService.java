package com.cafe24.bitmall.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.bitmall.repository.OptRepository;
import com.cafe24.bitmall.vo.OptVo;
import com.cafe24.bitmall.vo.OptsVo;

@Service
public class OptService {

	@Autowired
	OptRepository optRepository;

	public Map<String, Object> getOptList() {

		Map<String, Object> map = new HashMap<>();
		map.put("oList", optRepository.getOptList());
		map.put("totalCount", optRepository.getTotalCount());
		System.out.println(map.get("oList"));
		System.out.println(map.get("totalCount"));
		return map;
	}

	public boolean insertOpt(OptVo optVo) {
		return optRepository.insertOpt(optVo);
	}

	public boolean editOpt(OptVo optVo) {
		return optRepository.editOpt(optVo);
	}

	public boolean deleteOpt(Long no) {
		return optRepository.deleteOpt(no);
	}

	public OptVo getOpt(Long no) {
		return optRepository.getOpt(no);
	}

	public OptVo getOptsList(Long no) {

		OptVo vo = new OptVo();
		vo.setNo(no);
		vo.setName(optRepository.getOptName(no));
		vo.setOptsList(optRepository.getOptsList(no));

		return vo;
	}

	public boolean insertOpts(OptsVo optsVo) {
		return optRepository.insertOpts(optsVo);
	}

	public boolean editOpts(OptsVo optsVo) {
		return optRepository.editOpts(optsVo);
	}
	
	public boolean deleteOpts(Long no) {
		return optRepository.deleteOpts(no);
	}
	
	public OptsVo getOpts(Long no) {
		
		OptsVo vo = optRepository.getOpts(no);
		vo.setOptNo(no);
		return vo;
	}

}
