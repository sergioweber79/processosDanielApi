package br.com.processosDanielApi.test;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import br.com.processosDanielApi.exception.BaseException;
import br.com.processosDanielApi.service.ProcessoWIPOServiceImpl;

public class ConexaoWIPOTest {

	
	@Test
	@DisplayName("Verifica se ao conectar ao WIPO tem execeção")
	public void validarConexaoWIPO() {
		ProcessoWIPOServiceImpl service = new ProcessoWIPOServiceImpl();
		Assertions.assertThrows(BaseException.class, () -> {service.conectarSiteWIPO("WO2002008676");});
		
	}
	
}
