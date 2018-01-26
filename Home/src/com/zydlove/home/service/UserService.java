package com.zydlove.home.service;

import com.zydlove.home.po.User;

public interface UserService {
    public User queryUserByUsername(User user)throws Exception;
}
