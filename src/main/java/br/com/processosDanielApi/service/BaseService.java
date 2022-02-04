package br.com.processosDanielApi.service;

import java.io.Serializable;


import br.com.processosDanielApi.dominio.BaseDominio;
import br.com.processosDanielApi.exception.BaseException;


public interface BaseService<T extends BaseDominio, ID extends Serializable> {
	
	public T save(T entity) throws BaseException;
	
	public T update(T entity) throws BaseException;
	
	
	public T remove(ID id)  throws BaseException;
	
	
	public T findbyId(ID id)  throws BaseException;
	
	
	public Iterable<T> findAll();
	
	public T findbyWIPO(String wipo)  throws BaseException;
	

}
