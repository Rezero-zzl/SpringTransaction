package org.example.transaction.mybatis.service.base;

import org.apache.ibatis.annotations.Options;

/**
 * @author zzl
 * @date 2024/1/8 16:44
 */
public interface BaseMapper<T> {
    int insert(T t);
    int update(T t);
    int delete(T t);
    T select(Integer id);
}
