package com.szh.sm.service;

import com.szh.sm.entity.Clazz;

import java.util.List;

/**
 * @ClassName ClazzService
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/26
 **/
public interface ClazzService {
    List<Clazz> getClazzByDepId(int department);
    int addClazz(Clazz clazz);

    int deleteClazz(Integer id);
}
