package com.wdw.edu.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wdw.edu.mapper.StudentMapper;
import com.wdw.edu.model.domain.College;
import com.wdw.edu.model.domain.CoursePlan;
import com.wdw.edu.mapper.CoursePlanMapper;
import com.wdw.edu.model.domain.Student;
import com.wdw.edu.service.CoursePlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangdaiwu
 * @since 2022-05-18
 */
@Service
public class CoursePlanServiceImpl extends ServiceImpl<CoursePlanMapper, CoursePlan> implements CoursePlanService {

}
