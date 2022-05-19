package com.wdw.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wdw.edu.common.BaseException;
import com.wdw.edu.common.ErrorCode;
import com.wdw.edu.model.domain.College;
import com.wdw.edu.mapper.CollegeMapper;
import com.wdw.edu.service.CollegeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangdaiwu
 * @since 2022-05-14
 */
@Service
public class CollegeServiceImpl extends ServiceImpl<CollegeMapper, College> implements CollegeService {

    @Override
    public boolean noIsExisted(Integer no) {
        QueryWrapper<College> queryWrapper = new QueryWrapper<College>().eq("no", no);
        return baseMapper.selectOne(queryWrapper) != null;
    }

    @Override
    public boolean nameIsExisted(String name) {
        QueryWrapper<College> queryWrapper = new QueryWrapper<College>().eq("name", name);
        return baseMapper.selectOne(queryWrapper) != null;
    }

    @Override
    public void updateCollegeNoById(College college) {
        if (noIsExisted(college.getNo())) {
            throw new BaseException(ErrorCode.PARAMS_ERROR);
        }
        baseMapper.updateById(college);
    }

    @Override
    public void updateCollegeNameById(College college) {
        if (nameIsExisted(college.getName())) {
            throw new BaseException(ErrorCode.PARAMS_ERROR);
        }
        baseMapper.updateById(college);
    }

    @Override
    public void saveCollege(College college) {
        if (noIsExisted(college.getNo()) || nameIsExisted(college.getName())) {
            throw new BaseException(ErrorCode.PARAMS_ERROR);
        }
        baseMapper.insert(college);
    }

    @Override
    public Map<Integer, String> getId2NameMapping() {
        return this.list().stream().collect(Collectors.toMap(College::getId, College::getName));
    }
}
