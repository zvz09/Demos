package com.zvz.mybatis.service;

import com.zvz.mybatis.domain3.MethodLogEntity;
import com.zvz.mybatis.mapper3.MethodLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lilipo on 2017/5/11.
 */
@Service("methodLogServiceImpl")
@Transactional
public class MethodLogServiceImpl implements IMethodLogService {

    @Autowired
    private MethodLogDao methodLogDao;

    public void save(MethodLogEntity methodLogEntity) {
        methodLogDao.save(methodLogEntity);
    }

    public MethodLogEntity queryObject(Object id) {
        return methodLogDao.queryObject(id);
    }
}
