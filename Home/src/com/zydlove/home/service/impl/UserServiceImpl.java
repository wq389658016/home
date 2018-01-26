package com.zydlove.home.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zydlove.home.dao.UserDao;
import com.zydlove.home.dao.impl.UserDaoImpl;
import com.zydlove.home.po.User;
import com.zydlove.home.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public User queryUserByUsername(User user) throws Exception {
             String hql = "from User u where u.username = ? ";
             return userDao.querySingleRecord(hql, user.getUsername());
    }
   
    
    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
