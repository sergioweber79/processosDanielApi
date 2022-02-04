package br.com.processosDanielApi.dominio;

public class ProcessoWIPO extends BaseDominio {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4393623545471180150L;


	
	private String numeroPublicacao;
	
	
	private String numeroPedidoInternacional;
	
	
	private String dtPublicacao;
	
	
	private String requerentes;
	
	
	private String titulo;


	public String getNumeroPublicacao() {
		return numeroPublicacao;
	}


	public void setNumeroPublicacao(String numeroPublicacao) {
		this.numeroPublicacao = numeroPublicacao;
	}


	public String getNumeroPedidoInternacional() {
		return numeroPedidoInternacional;
	}


	public void setNumeroPedidoInternacional(String numeroPedidoInternacional) {
		this.numeroPedidoInternacional = numeroPedidoInternacional;
	}


	public String getDtPublicacao() {
		return dtPublicacao;
	}


	public void setDtPublicacao(String dtPublicacao) {
		this.dtPublicacao = dtPublicacao;
	}


	public String getRequerentes() {
		return requerentes;
	}


	public void setRequerentes(String requerentes) {
		this.requerentes = requerentes;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



}
