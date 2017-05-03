package com.zvz.mybatis.mapper2;

import com.zvz.mybatis.domain2.MovecarVerificaEntity;

/**
 * Created by lilipo on 2017/5/2.
 */
public interface MovecarVerificaDao {
    void save(MovecarVerificaEntity verificaEntity);

    MovecarVerificaEntity queryObject(Object id);
}
