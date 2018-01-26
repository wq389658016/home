package com.zydlove.home.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibUtil {
	private static SessionFactory sessionFactory;
	private static ThreadLocal<Session> threadLocal= new ThreadLocal<Session>();
	static{
		//获取配置信息 hibernate.cfg.xml
		Configuration configuration = new Configuration().configure();
		//创建一个 ServiceRegistry的实例
		//首先获得其标准建造器，此处用了建造者模式 builder模式来创建对象
		//创建一个标准的构建器
		StandardServiceRegistryBuilder ssb = new StandardServiceRegistryBuilder();
		//建造(得到)ServiceRegistry的实例此处一定要传入configuration.getProperties()否则会报错UnsupportedOperationException
		ServiceRegistry build = ssb.applySettings(configuration.getProperties()).build();
		//获得session工厂
		sessionFactory = configuration.buildSessionFactory(build);
	}
	public static Session getCurrentSession(){
		Session session  = threadLocal.get();
		if(session==null||!session.isOpen()){
			threadLocal.set(sessionFactory.openSession());
		}
		return threadLocal.get();
	}
	public static void main(String[] args) {
		
	}
}
