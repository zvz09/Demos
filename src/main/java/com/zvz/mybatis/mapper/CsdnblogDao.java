package com.zvz.mybatis.mapper;


import com.zvz.mybatis.domain.CsdnblogEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-04-16 16:28:53
 */
public interface CsdnblogDao  {
	CsdnblogEntity queryObject(Object id);


	void save(CsdnblogEntity csdnblogEntity);

}
