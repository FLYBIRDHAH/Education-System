package com.wdw.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wdw.edu.common.BaseException;
import com.wdw.edu.common.ErrorCode;
import com.wdw.edu.common.RPage;
import com.wdw.edu.model.domain.College;
import com.wdw.edu.model.domain.Major;
import com.wdw.edu.mapper.MajorMapper;
import com.wdw.edu.model.view.MajorResponse;
import com.wdw.edu.service.CollegeService;
import com.wdw.edu.service.MajorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major> implements MajorService {

    private final CollegeService collegeService;

    @Override
    public RPage<MajorResponse> listMajorResponse(Long current, Long size) {
        Map<Integer, String> collegeId2CollegeNameMapping = collegeService.getId2NameMapping();

        Page<Major> page = this.page(new Page<>(current, size));
        List<Major> majorList = page.getRecords();
        List<MajorResponse> majorResponseList = new ArrayList<>();
        majorList.forEach(major -> {
            MajorResponse majorResponse = new MajorResponse();
            BeanUtils.copyProperties(major, majorResponse);
            majorResponse.setCollegeName(collegeId2CollegeNameMapping.get(majorResponse.getCollegeId()));
            majorResponseList.add(majorResponse);
        });

        return new RPage<>(majorResponseList,
                page.getTotal(), 
                page.getSize(),
                page.getCurrent());
    }

    @Override
    public boolean noIsExisted(Integer no, Integer collegeID) {
        QueryWrapper<Major> queryWrapper = new QueryWrapper<Major>().eq("no", no).eq("college_id", collegeID);
        return baseMapper.selectOne(queryWrapper) != null;
    }

    @Override
    public boolean nameIsExisted(String name) {
        QueryWrapper<Major> queryWrapper = new QueryWrapper<Major>().eq("name", name);
        return baseMapper.selectOne(queryWrapper) != null;
    }

    @Override
    public void updateMajorNoById(Major major) {
        if (noIsExisted(major.getNo(), major.getCollegeId())) {
            throw new BaseException(ErrorCode.PARAMS_ERROR);
        }
        baseMapper.updateById(major);
    }

    @Override
    public void updateMajorNameById(Major major) {
        if (nameIsExisted(major.getName())) {
            throw new BaseException(ErrorCode.PARAMS_ERROR);
        }
        baseMapper.updateById(major);
    }

    @Override
    public void saveMajor(Major major) {
        if (noIsExisted(major.getNo(), major.getCollegeId()) || nameIsExisted(major.getName())) {
            throw new BaseException(ErrorCode.PARAMS_ERROR);
        }
        baseMapper.insert(major);
    }
}
