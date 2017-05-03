package com.zvz.mybatis.service;


import com.zvz.mybatis.domain2.MovecarVerificaEntity;


/**
 * Created by lilipo on 2017/4/25.
 */
public interface IMovecarVerifica{

    void save(MovecarVerificaEntity verificaEntity);

    MovecarVerificaEntity queryObject(Object id);

}
