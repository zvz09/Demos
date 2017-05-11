package com.zvz.mybatis.mapper3;

import com.zvz.mybatis.domain3.MethodLogEntity;

/**
 * Created by lilipo on 2017/5/11.
 */
public interface MethodLogDao {

    MethodLogEntity queryObject(Object id);


    void save(MethodLogEntity methodLogEntity);
}
