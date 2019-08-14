package com.jk.service;

import com.jk.dao.UserDao;
import com.jk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao da;

    @Override
    public List<User> cha() {
        return da.cha();
    }

    @Override
    public void xin(List<User> list) {
        da.xin(list);
    }
}
