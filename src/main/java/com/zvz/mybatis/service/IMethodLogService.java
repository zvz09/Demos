package com.zvz.mybatis.service;

import com.zvz.mybatis.domain3.MethodLogEntity;

/**
 * Created by lilipo on 2017/5/11.
 */
public interface IMethodLogService {
    void save(MethodLogEntity methodLogEntity);

    MethodLogEntity queryObject(Object id);
}
