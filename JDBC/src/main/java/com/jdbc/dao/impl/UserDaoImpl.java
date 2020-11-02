package com.jdbc.dao.impl;

import com.jdbc.dao.UserDao;
import com.jdbc.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
//<bean id="UserDaoImpl" class="com.jdbc.dao.impl.UserDaoImpl"></bean>
@Repository("UserDaoImpl")
public class UserDaoImpl implements UserDao {
    @Resource(name = "JdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    public List<User> queryUser() {
        List<User> query = jdbcTemplate.query("select `Name`,`Sex` from  user_gwk", new BeanPropertyRowMapper<User>(User.class));
        return query;
    }


    /**
     * 自己实现
     */
    @Override
    @Test
    public void Test() {
        List<User> query = jdbcTemplate.query("select `Name`,`Sex` from  user_gwk", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                String name = resultSet.getString(1);
                String sex = resultSet.getString(2);
                user.setName(name);
                user.setSex(sex);
                return user;
            }
        });
        query.forEach(System.out::println);


    }

}
