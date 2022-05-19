package com.wdw.edu.controller;


import com.wdw.edu.common.R;
import com.wdw.edu.model.domain.Student;
import com.wdw.edu.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangdaiwu
 * @since 2022-05-14
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentServiceImpl studentServiceImpl;

    /**
     * 获取学生列表
     * @return
     */
      @GetMapping("/list/")
      public R GetStudentByPage(){
          studentServiceImpl.GetStudentByPage();
          return R.ok();
      }

    /**
     * 新增学生
     * @param student
     * @return
     */
      @GetMapping("/insert")
    public R InsertStudent(Student student){
          studentServiceImpl.InsertStudent(student);
          return R.ok();
      }
      @GetMapping("/Delete/{id}")
    public R DeleteStudentById(@PathVariable("id") int id){
          studentServiceImpl.DeleteStudent(id);
          return R.ok();
      }
}

