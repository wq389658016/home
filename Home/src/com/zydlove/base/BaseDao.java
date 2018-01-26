package com.zydlove.base;

import java.util.List;

import com.zydlove.home.util.PageUtil;



public interface BaseDao<T> {
    public List<T> queryList(String hql,Object...param);
    public int queryTotalCount(String hql,Object...param);
    public PageUtil queryListByPage(String cureentPageNum,int pageSize,String hql,Object...param);
    public T querySingleRecord(int id);
    public T querySingleRecord(String hql,Object...param);
    public void update(T t);
    public void add(T t);
    public void delete(T t);
    public void delete(Integer id);
}
