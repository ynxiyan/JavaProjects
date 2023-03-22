package com.springboot_generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot_generator.dao.UserDao;
import com.springboot_generator.model.User;
import com.springboot_generator.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author XIYAN
 * @since 2023-03-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {

}
