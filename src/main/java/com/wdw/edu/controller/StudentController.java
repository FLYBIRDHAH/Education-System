package com.wdw.edu.controller;


import com.wdw.edu.common.R;
import com.wdw.edu.mapper.StudentMapper;
import com.wdw.edu.model.domain.Student;
import com.wdw.edu.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

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
    @Autowired
    StudentMapper studentMapper;

    /**
     * 获取学生列表
     * @return
     */
      @GetMapping("/list/{current}/{size}")
      public R GetStudentByPage(@PathVariable("current") int current,@PathVariable("size") int size){
          studentServiceImpl.GetStudentByPage(current,size);
          return R.ok();
      }

    /**
     * 新增学生
     * @param student
     * @return
     */
      @GetMapping("/insert")
    public R InsertStudent(Student student){
          studentMapper.insert(student);
          return R.ok();
      }
      @GetMapping("/Delete")
    public R DeleteStudentById( int [] id){
          ArrayList idList = new ArrayList(Arrays.asList(id));
          studentServiceImpl.DeleteStudent(idList);
          return R.ok();
      }
}

