package com.zvz.generator.server;

import com.zvz.generator.mapper.GeneratorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by lilipo on 2017/5/11.
 */
@Service("GeneratorServiceMysql")
public class GeneratorServiceImpl implements GeneratorService {

    @Autowired
    private GeneratorDao generatorDao;


    public List<Map<String, Object>> queryList(Map<String, Object> map) {
        return generatorDao.queryList(map);
    }

    public int queryTotal(Map<String, Object> map) {
        return generatorDao.queryTotal(map);
    }

    public Map<String, String> queryTable(String tableName) {
        return generatorDao.queryTable(tableName);
    }

    public List<Map<String, String>> queryColumns(String tableName) {
        return null;
    }

    public byte[] generatorCode(String[] tableNames) {
        return new byte[0];
    }
}
