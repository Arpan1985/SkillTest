package com.testyourskills.dao.common.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.testyourskills.dao.common.IGenericDAO;

/**
 *This class contains the DAO methods used in the application
 *for communicating with the Database.
 * @param <T>
 * @param <PK>
 */
public abstract class GenericDAO<T,PK extends Serializable>
implements IGenericDAO<T,PK>
{
	/**
	 *This variable holds the SessionFactory instance
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * This variable holds the generic Class types(entity bean types)
	 * passed to the DAO constructor.
	 */
	private Class<T> clazz;

	/**
	 * Parameterized constructor of the class.
	 * @param obj
	 */
	public GenericDAO(final Class<T> obj){
		this.clazz=obj;
	}

	/**
	 * This method inserts the given object in the database and returns the primary key
	 * @param T obj
	 * @return PK
	 */
	@Override
	public T insert(final T obj) {
		getSession().save(obj);
		return obj;
	}
	 /**
	 * @param obj
	 * @return
	 */
	@Override
	public void update(T obj){
		getSession().update(obj);
	}
	
	@Override
	public void saveOrUpdate(T obj){
		getSession().saveOrUpdate(obj);
	}
	
	 /**
	 * @param id
	 * @return
	 */
	@Override
	public T get(PK id){
		return  (T)getSession().get(clazz, id);
	}
	
	/**
	 * @param sessionFactory
	 */
	public void setSessionFactory(final SessionFactory sRessionFactory) {
		this.sessionFactory = sRessionFactory;
	}

	/**
	 * Getter method for the session object
	 * @return Session
	 */
	public Session getSession(){
		Session currentSession = sessionFactory.getCurrentSession();
		if(currentSession==null){
			currentSession = sessionFactory.openSession();
		}
		return currentSession;
	}

	/**
	 * Getter method for the SessionFactory object
	 * @return SessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @return the clazz
	 */
	public Class<T> getClazz() {
		return clazz;
	}

	/**
	 * @param clazz the clazz to set
	 */
	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}
}
