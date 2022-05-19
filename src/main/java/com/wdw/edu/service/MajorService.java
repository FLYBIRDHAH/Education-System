package com.wdw.edu.service;

import com.wdw.edu.common.RPage;
import com.wdw.edu.model.domain.Major;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wdw.edu.model.view.MajorResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangdaiwu
 * @since 2022-05-14
 */
public interface MajorService extends IService<Major> {

    RPage<MajorResponse> listMajorResponse(Long current, Long size);

    boolean noIsExisted(Integer no, Integer collegeID);

    boolean nameIsExisted(String name);

    void updateMajorNoById(Major major);

    void updateMajorNameById(Major major);

    void saveMajor(Major major);
}
