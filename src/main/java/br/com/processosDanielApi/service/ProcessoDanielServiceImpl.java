package br.com.processosDanielApi.service;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import br.com.processosDanielApi.dominio.ProcessoDaniel;
import br.com.processosDanielApi.exception.BaseException;
import br.com.processosDanielApi.repository.ProcessoDanielRepository;
import br.com.processosDanielApi.utils.Validacao;

@Service
public class ProcessoDanielServiceImpl implements BaseService<ProcessoDaniel, Integer> {

	
	@Autowired 
	private ProcessoDanielRepository processoDanielRepository;
	
	@Override
	public ProcessoDaniel save(ProcessoDaniel processoDaniel) throws BaseException {

		validarProcessoDaniel(processoDaniel);
		processoDanielRepository.save(processoDaniel);
		return processoDaniel;
	}

	@Override
	public ProcessoDaniel update(ProcessoDaniel processoDaniel) throws BaseException {
	
		validarIdProcessoDaniel(processoDaniel);
		validarProcessoDaniel(processoDaniel);
		
		processoDanielRepository.save(processoDaniel);
		return processoDaniel;
	}

	
	
	@Override
	public Iterable<ProcessoDaniel> findAll(){
		return processoDanielRepository.findAll();
	}


	@Override
	public ProcessoDaniel remove(Integer id)  throws BaseException {
		Validacao.validarId(id);		
		
		ProcessoDaniel processoDaniel = processoDanielRepository.findOne(id);
		
		
		Validacao.validarExistencia(processoDaniel);
	

		processoDanielRepository.delete(processoDaniel);
		return new ProcessoDaniel();
	}

	@Override
	public ProcessoDaniel findbyId(Integer id)  throws BaseException {
		
		Validacao.validarId(id);
		
		ProcessoDaniel processoDaniel = processoDanielRepository.findOne(id);

		Validacao.validarExistencia(processoDaniel);
		
		return processoDaniel; 
	}
	
	
	private void validarProcessoDaniel(ProcessoDaniel processoDaniel) throws BaseException {
		processoDaniel.setNumeroPublicacao(processoDaniel.getNumeroPublicacao().replaceAll("\\/", ""));	
	}
	
	private void validarIdProcessoDaniel(ProcessoDaniel processoDaniel) throws BaseException {
		if (processoDaniel==null || processoDaniel.getIdProcesso()==null || processoDaniel.getIdProcesso().compareTo(new Integer(0))==0 ) {
			throw new BaseException("ID ProcessoDaniel invalido!");
		}
		
	}

	@Override
	public ProcessoDaniel findbyWIPO(String wipo) throws BaseException {
		return null;
	}
	
	


	public Iterable<ProcessoDaniel> findByNumeroPublicacao(String processo){
		
		return processoDanielRepository.findByNumeroPublicacao(processo);
		
	}
	
	public Iterable<ProcessoDaniel> findByRequerentesContaining(String requerentes){
		
		return processoDanielRepository.findByRequerentesContaining(requerentes);
		
	}
	
	public Iterable<ProcessoDaniel> findByNumeroPublicacaoAndRequerentesContaining(String numero, String requerentes){
		
		return processoDanielRepository.findByNumeroPublicacaoAndRequerentesContaining(numero, requerentes);
		
	}
	
	
}
