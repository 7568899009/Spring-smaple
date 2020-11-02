package com.jdbc.service.impl;

import com.jdbc.dao.impl.UserDaoImpl;
import com.jdbc.entity.User;
import com.jdbc.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
//<bean id="UserService" class="com.jdbc.service.impl.UserServiceImpl" p:userDao-ref="UserDaoImpl"></bean>
@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
//    p:userDao-ref="UserDaoImpl"
    @Resource(name = "UserDaoImpl")
    private UserDaoImpl userDao;

    @Override
    public List<User> queryUser() {

        List<User> users = userDao.queryUser();
        if (users==null) {
            System.out.println("元素为空");
        }
        return users;
    }
}
