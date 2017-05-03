package com.zvz.mybatis.service;

import com.zvz.mybatis.domain.CsdnblogEntity;
import com.zvz.mybatis.mapper.CsdnblogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("csdnblogService")
public class CsdnblogServiceImpl implements ICsdnblogService {
	@Autowired
	private CsdnblogDao csdnblogDao;
	
	public CsdnblogEntity queryObject(Integer id){
		return csdnblogDao.queryObject(id);
	}

}
