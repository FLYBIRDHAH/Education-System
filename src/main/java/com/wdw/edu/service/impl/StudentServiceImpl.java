package com.wdw.edu.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wdw.edu.model.domain.Student;
import com.wdw.edu.mapper.StudentMapper;
import com.wdw.edu.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wangdaiwu
 * @since 2022-05-14
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    /**
     * 分页查询获取学生
     */
    public List<Student> GetStudentByPage() {
        Page<Student> page = new Page<>(1,5);
        studentMapper.selectPage(page, null);
        return page.getRecords();
    }

    /**
     * 新增学生
     */
    public void InsertStudent(Student student) {
        studentMapper.insert(student);
    }

    /**
     * 删除学生(通过Id)
     */
    public void DeleteStudent(int id) {
        studentMapper.deleteById(id);
    }
}
