package com.szh.sm.service;

import com.szh.sm.entity.Student;
import com.szh.sm.vo.StudentVo;

import java.util.List;

/**
 * @ClassName StudentService
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/12/6
 **/

/**
 * 学生服务接口
 */
public interface StudentService {
    /**
     * 查询所有学生
     * @return list
     */
    List<StudentVo> selectAll();

    /**
     * 根据院系id查询学生
     * @param depId 院系id
     * @return
     */
    List<StudentVo> selectByDepId(int depId);

    /**
     * 根据班级id查询学生
     * @param classId
     * @return
     */
    List<StudentVo> selectByClassId(int classId);

    /**
     * 根据关键字查询学生
     * @param keywords 关键字
     * @return
     */
    List<StudentVo> selectByKeywords(String keywords);



    /**
     * 更新学生信息
     *
     * @param student 学生对象
     * @return int
     */
    int updateStudent(Student student);

    /**
     * 删除学生
     *
     * @param id id
     * @return int
     */
    int deleteById(String id);

    /**
     * 新增学生
     *
     * @param student 学生对象
     * @return int
     */
   int insertStudent(Student student);

    /**
     * 根据院系统计学生数
     *
     * @param departmentId 院系id
     * @return 学生数量
     */
   int countByDepartmentId(int departmentId);

    /**
     * 根据班级统计学生数量
     *
     * @param classId 班级id
     * @return 学生数量
     */
    int countStudentByClassId(int classId);
}
