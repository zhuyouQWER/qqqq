package com.jk.dao;

import com.jk.model.User;

import java.util.List;

public interface UserDao {
    List<User> cha();

    void xin(List<User> list);
}
