package com.wdw.edu.service;

import com.wdw.edu.model.domain.College;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangdaiwu
 * @since 2022-05-14
 */
public interface CollegeService extends IService<College> {

    boolean noIsExisted(Integer no);

    boolean nameIsExisted(String name);

    void updateCollegeNoById(College college);

    void updateCollegeNameById(College college);

    void saveCollege(College college);

    Map<Integer, String> getId2NameMapping();
}
