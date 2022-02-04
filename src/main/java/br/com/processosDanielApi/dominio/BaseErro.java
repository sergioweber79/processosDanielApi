package br.com.processosDanielApi.dominio;

public class BaseErro extends BaseDominio {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5284470650982785841L;
	
	
	
	
	private Integer codigoErro;
	private String mensagemErro;
	private String detalheErro;
	
	
	
	
	
	public BaseErro(Integer codigoErro, String mensagemErro, String detalheErro) {
		super();
		this.codigoErro = codigoErro;
		this.mensagemErro = mensagemErro;
		this.detalheErro = detalheErro;
	}
	
	
	public Integer getCodigoErro() {
		return codigoErro;
	}
	public void setCodigoErro(Integer codigoErro) {
		this.codigoErro = codigoErro;
	}
	public String getMensagemErro() {
		return mensagemErro;
	}
	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}
	public String getDetalheErro() {
		return detalheErro;
	}
	public void setDetalheErro(String detalheErro) {
		this.detalheErro = detalheErro;
	}
	
	
	

}
