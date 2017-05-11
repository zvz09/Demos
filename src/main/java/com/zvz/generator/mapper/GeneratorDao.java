package com.zvz.generator.mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by lilipo on 2017/5/11.
 *
 * mysql 数据库
 */
public interface GeneratorDao {
    List<Map<String, Object>> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    Map<String, String> queryTable(String tableName);

     // 根据表名查询所有字段
    List<Map<String, String>> queryColumns(String tableName);
}
