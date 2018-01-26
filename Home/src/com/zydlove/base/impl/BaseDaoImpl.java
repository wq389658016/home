package com.zydlove.base.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zydlove.base.BaseDao;
import com.zydlove.home.util.PageUtil;


@Component
public class BaseDaoImpl<T> implements BaseDao<T> {
	private Class clazz;
	@Autowired
	private SessionFactory sessionFactory;
	public BaseDaoImpl(){
		ParameterizedType type= (ParameterizedType)this.getClass().getGenericSuperclass();
		clazz = (Class) type.getActualTypeArguments()[0];	
	}
	@Override
	public List<T> queryList(String hql, Object... param) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		if(param!=null&&param.length>0){
			for(int i = 0;i<param.length;i++){
				query.setParameter(i,param[i]);
			}
		}
		return query.list();
	}
	@Override
	public int queryTotalCount(String hql, Object... param) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select count(*)  "+hql);
		if(param!=null&&param.length>0){
			for(int i = 0;i<param.length;i++){
				query.setParameter(i,param[i]);
			}
		}
		return ((Number)query.uniqueResult()).intValue();
	}

	@Override
	public PageUtil queryListByPage(String cureentPageNum, int pageSize,
			String hql, Object... param) {
		Session session = sessionFactory.getCurrentSession();
		PageUtil page = new PageUtil(cureentPageNum, queryTotalCount(hql,param), pageSize);
		Query query = session.createQuery(hql);
		if(param!=null&&param.length>0){
			for(int i = 0;i<param.length;i++){
				query.setParameter(i,param[i]);
			}
		}
		query.setFirstResult(page.getPerPageStartNum()-1);   //从第几条开始取数据
		query.setMaxResults(pageSize);  //设置每页最多显示记录的个数
		page.setList(query.list());
		return page;
	}

	@Override
	public T querySingleRecord(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (T)session.get(clazz, id);
	}

	@Override
	public T querySingleRecord(String hql, Object... param) {
        Session session = sessionFactory.getCurrentSession();
		List<T> list = queryList(hql,param);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(t);
	}

	@Override
	public void add(T t) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(t);
	}

	@Override
	public void delete(T t) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(t);
	}

	@Override
	public void delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(querySingleRecord(id));
	}
	public Class getClazz() {
		return clazz;
	}
	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}