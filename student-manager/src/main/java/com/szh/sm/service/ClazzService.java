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
    /**
     * 根据院系id查询班级列表
     *
     * @param depId 院系id
     * @return 班级列表
     */
    List<Clazz> getClazzByDepId(int depId);

    /**
     * 新增班级
     *
     * @param clazz 班级实体
     * @return int
     */
    int addClazz(Clazz clazz);


    /**
     * 删除班级
     *
     * @param clazzId 班级id
     * @return int
     */
   int deleteClazz(int clazzId);

    /**
     * 查询所有班级
     *
     * @return List<Clazz>
     */
    List<Clazz> selectAll();



}
