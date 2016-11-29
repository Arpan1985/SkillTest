package com.testyourskills.dao.common;

import java.io.Serializable;

/**
 *This interface defines DAO methods used in the application
 *for communicating with the Database.
 * @param <T>
 * @param <PK>
 */
public interface GenericDAO<T,PK extends Serializable> {

	/**
	 * This method inserts the given object in the database and returns the primary key
	 * @param T obj
	 * @return T
	 */
	 T insert(T obj);
	 
	 /**
	 * @param obj
	 * @return
	 */
	T update(T obj);
	 
	 /**
	 * @param id
	 * @return
	 */
	T get(PK id);
	 
}