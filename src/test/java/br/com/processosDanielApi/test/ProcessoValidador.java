package br.com.processosDanielApi.test;


import br.com.processosDanielApi.dominio.ProcessoWIPO;
import br.com.processosDanielApi.service.ProcessoWIPOServiceImpl;

public class ProcessoValidador {
	
	public boolean validar(String processoWIPO) {
		try {
			ProcessoWIPOServiceImpl service = new ProcessoWIPOServiceImpl();
			ProcessoWIPO processo = service.findbyWIPO(processoWIPO);
			
			if (processo==null ) {
				return false;
			}
			
			if (processo.getNumeroPublicacao()==null || processo.getNumeroPublicacao().isEmpty()) {
				return false;
			}
			if (processo.getNumeroPedidoInternacional()==null || processo.getNumeroPedidoInternacional().isEmpty()) {
				return false;
			}

			if (processo.getDtPublicacao()==null || processo.getDtPublicacao().isEmpty()) {
				return false;
			}
			
			if (processo.getRequerentes()==null || processo.getRequerentes().isEmpty()) {
				return false;
			}
			if (processo.getTitulo()==null || processo.getTitulo().isEmpty()) {
				return false;
			}

			return true;
			
		} catch (Exception e) {
			return false;
		}
		
	}

}
