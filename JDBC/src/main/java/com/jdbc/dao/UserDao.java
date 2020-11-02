package com.jdbc.dao;

import com.jdbc.entity.User;

import java.util.List;

public interface UserDao {
    List<User> queryUser();

    void  Test();
}
