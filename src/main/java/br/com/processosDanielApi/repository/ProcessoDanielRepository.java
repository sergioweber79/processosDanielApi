package br.com.processosDanielApi.repository;

import org.springframework.data.repository.CrudRepository;


import br.com.processosDanielApi.dominio.ProcessoDaniel;


public interface ProcessoDanielRepository  extends CrudRepository<ProcessoDaniel, Integer>{
	
	public Iterable<ProcessoDaniel> findByNumeroPublicacao(String numero);
	
	public Iterable<ProcessoDaniel> findByRequerentesContaining(String requerentes);
	
	public Iterable<ProcessoDaniel> findByNumeroPublicacaoAndRequerentesContaining(String numero,String requerentes);

}
