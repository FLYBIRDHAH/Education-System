package com.wdw.edu.service.impl;

import com.wdw.edu.model.domain.User;
import com.wdw.edu.mapper.UserMapper;
import com.wdw.edu.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangdaiwu
 * @since 2022-05-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
