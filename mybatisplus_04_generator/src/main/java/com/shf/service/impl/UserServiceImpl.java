package com.shf.service.impl;

import com.shf.domain.User;
import com.shf.dao.UserDao;
import com.shf.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shuhongfan
 * @since 2022-05-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {

}
