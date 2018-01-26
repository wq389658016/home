package com.zydlove.home.dao.impl;

import org.springframework.stereotype.Repository;


import com.zydlove.base.impl.BaseDaoImpl;
import com.zydlove.home.dao.UserDao;
import com.zydlove.home.po.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

}
