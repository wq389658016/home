package com.zydlove.home.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zydlove.home.po.User;
import com.zydlove.home.service.UserService;

@Controller
@Scope("prototype")
public class UserAction {
    @Autowired
    private UserService userService;
    private User user;
    private String msg=null;
    
    public String queryUser() throws Exception{
    //    Map<String, Object> session=ActionContext.getContext().getSession();//取得session
        if(user!=null){
            User user1=userService.queryUserByUsername(user);
                if(!"".equals(user.getUsername())&&!"".equals(user.getPassword())){//1、用户名和密码都不为空
                    if(user1!=null){//页面输入用户名不正确数据库查询不到用户名返回null
                       if(user1.getPassword().equals(user.getPassword())){//2、用户名正确就比较密码
                         //  session.put("username", user1.getUsername());
                         //  session.put("password", user1.getPassword());
                           return "success";
                       }
                       msg="密码错误";
                       return "login"; 
                    }
                    msg="用户名或密码错误";
                    return "login"; 
                }else if("".equals(user.getUsername())&&"".equals(user.getPassword())){//3、用户和密码都为空
                    msg="用户名和密码都为空";
                    return "login";
                }else if(!"".equals(user.getUsername())&&"".equals(user.getPassword())){//4、密码为空
                    msg="密码为空";
                    return "login";
                }
                msg="用户名为空";
                return "login";
        }
            return "login";
    }
   
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public UserService getUserService() {
        return userService;
    }
    public void setUserService(UserService userService) {
        this.userService = userService;
    }    
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    
}
