package com.wdw.edu.mapper;

import com.wdw.edu.model.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangdaiwu
 * @since 2022-05-14
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
