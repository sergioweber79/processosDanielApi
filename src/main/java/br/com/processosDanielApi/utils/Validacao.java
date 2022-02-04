package br.com.processosDanielApi.utils;

import br.com.processosDanielApi.dominio.BaseDominio;
import br.com.processosDanielApi.exception.BaseException;

public class Validacao {
	
	
	
	public static void validarId(Integer id) throws BaseException {
		if (id==null || id.compareTo(new Integer(0))==0) {
			throw new BaseException("ID do Tamanho invalido!");
		}		
	}
	

	public static void validarExistencia(BaseDominio base) throws BaseException {
		
		if (base==null) {
			throw new BaseException("Registro nao encontrado!");
		}
	}

	
}
