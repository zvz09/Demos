package com.zvz.mybatis.service;

import com.zvz.mybatis.domain.CsdnblogEntity;
import com.zvz.mybatis.domain2.MovecarVerificaEntity;
import com.zvz.mybatis.mapper.CsdnblogDao;
import com.zvz.mybatis.mapper2.MovecarVerificaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("csdnblogService")
@Transactional
public class CsdnblogServiceImpl implements ICsdnblogService {
	@Autowired
	private CsdnblogDao csdnblogDao;

	@Autowired
	private MovecarVerificaDao movecarVerificaDao;

	public CsdnblogEntity queryObject(Integer id){
		return csdnblogDao.queryObject(id);
	}

	public void save(CsdnblogEntity csdnblogEntity) {
		csdnblogDao.save(csdnblogEntity);
	}

	public void saveAll(CsdnblogEntity csdnblogEntity, MovecarVerificaEntity verificaEntity, boolean sta) {
		csdnblogDao.save(csdnblogEntity);
		movecarVerificaDao.save(verificaEntity);
		if (sta){
			Integer i = 1/0;
		}
	}

}
