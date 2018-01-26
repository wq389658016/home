package com.zydlove.home.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.zydlove.home.dao.ZtreeDao;
import com.zydlove.home.dao.impl.ZtreeDaoImpl;
import com.zydlove.home.po.Ztree;
import com.zydlove.home.service.ZtreeService;

@Service("ztreeService")
public class ZtreeServiceImpl implements ZtreeService{
    private ZtreeDao ztreeDao = new ZtreeDaoImpl();
    @Override
    public String queryByZtree() {
        List<Ztree> ztreeList=ztreeDao.queryList("from Ztree z");
        return new Gson().toJson(ztreeList);
    }

}
