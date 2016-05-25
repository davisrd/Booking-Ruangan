package com.websystique.springmvc.dao;

import java.io.Serializable;

import java.lang.reflect.ParameterizedType;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractDao<PK extends Serializable, T> {
	
	private final Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public AbstractDao(){
		this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public T getByKey(PK key) {
		return (T) getSession().get(persistentClass, key);
	}

	@SuppressWarnings("unchecked")
	public T getByKey(int key) {
		return (T) getSession().get(persistentClass, key);
	}
	
	@SuppressWarnings("unchecked")
	public T getByKey(String key) {
		return (T) getSession().get(persistentClass, key);
	}

	@Transactional
	public void persist(T entity) {
		getSession().persist(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}
	
	protected Criteria createEntityCriteria(){
		return getSession().createCriteria(persistentClass);
	}
	
	public void saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
	}
	
	public String dateToYYMM(Date date)
	{
		Date dateTest = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyMM");
		String dateToStr = format.format(dateTest.getTime());
		return dateToStr;
	}

}
