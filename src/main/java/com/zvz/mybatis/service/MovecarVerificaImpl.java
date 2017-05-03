package com.zvz.mybatis.service;

import com.zvz.mybatis.domain2.MovecarVerificaEntity;
import com.zvz.mybatis.mapper2.MovecarVerificaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by lilipo on 2017/4/25.
 */
@Service("movecarVerificaImpl")
@Transactional
public class MovecarVerificaImpl implements IMovecarVerifica {

    private static final long serialVersionUID = -3138634627974206490L;
    @Autowired
    private MovecarVerificaDao movecarVerificaDao;

    public void save(MovecarVerificaEntity verificaEntity) {
        movecarVerificaDao.save(verificaEntity);
    }

    public MovecarVerificaEntity queryObject(Object id) {
        return movecarVerificaDao.queryObject(id);
    }
}
