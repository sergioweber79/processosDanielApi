package br.com.processosDanielApi.test;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class ValidacaoCamposProcessoTest {

	@Test
	@DisplayName("Verifica se todos os dados retornados da url estão preenchidos.")
	public void validarProcessoWIPO() {
				
		ProcessoValidador processoValidador = new ProcessoValidador();
		
		Assertions.assertEquals(true, processoValidador.validar("WO2002008676"));
		
		
	}
	
}
