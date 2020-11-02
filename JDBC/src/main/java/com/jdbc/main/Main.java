package com.jdbc.main;


import com.jdbc.config.SpringCore_Config;
import com.jdbc.config.SpringDruidConfig;
import com.jdbc.entity.User;
import com.jdbc.service.impl.UserServiceImpl;
import com.jdbc.utility.DruidUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringCore_Config.class);
        UserServiceImpl bean = annotationConfigApplicationContext.getBean(UserServiceImpl.class);
        List<User> users = bean.queryUser();
        users.forEach(System.out::println);

    }
}
