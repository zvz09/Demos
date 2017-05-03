package com.zvz.mybatis.service;



import com.zvz.mybatis.domain.CsdnblogEntity;
import com.zvz.mybatis.domain2.MovecarVerificaEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-04-16 16:28:53
 */
public interface ICsdnblogService {
	
	CsdnblogEntity queryObject(Integer id);

	void save(CsdnblogEntity csdnblogEntity);

	void saveAll(CsdnblogEntity csdnblogEntity, MovecarVerificaEntity verificaEntity, boolean sta);
}
