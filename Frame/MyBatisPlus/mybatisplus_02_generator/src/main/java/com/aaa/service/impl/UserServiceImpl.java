package com.aaa.service.impl;

import com.aaa.domain.User;
import com.aaa.dao.UserDao;
import com.aaa.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author star
 * @since 2023-12-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {

}
