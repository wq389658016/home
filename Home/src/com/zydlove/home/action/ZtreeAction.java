package com.zydlove.home.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zydlove.home.service.ZtreeService;
import com.zydlove.home.service.impl.ZtreeServiceImpl;
@Controller
@Scope("prototype")
public class ZtreeAction {
    private ZtreeService ztreeService = new ZtreeServiceImpl();
    private InputStream inputStream;
    public String queryByZtree() throws UnsupportedEncodingException{
        String  ztree=ztreeService.queryByZtree();
        inputStream=new ByteArrayInputStream(ztree.getBytes("utf-8"));
        return "ztree";
    }
    public ZtreeService getZtreeService() {
        return ztreeService;
    }
    public void setZtreeService(ZtreeService ztreeService) {
        this.ztreeService = ztreeService;
    }
    public InputStream getInputStream() {
        return inputStream;
    }
    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
    
}
