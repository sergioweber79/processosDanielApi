package br.com.processosDanielApi.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_processo")
public class ProcessoDaniel extends BaseDominio {

	/**
	 * 
	 */
	private static final long serialVersionUID = -301631308384718357L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sqtb_processo")
	@SequenceGenerator(name="sqtb_processo", sequenceName="sqtb_processo")
	@Column(name="idprocesso")
	private Integer idProcesso;
	
	@Column(name="nro_pub")
	private String numeroPublicacao;
	
	@Column(name="nro_pedido_internacional")
	private String numeroPedidoInternacional;
	
	@Column(name="dtpublicacao")
	private Date dtPublicacao;
	
	@Column(name="requerentes")
	private String requerentes;
	
	@Column(name="titulo")
	private String titulo;

	public Integer getIdProcesso() {
		return idProcesso;
	}

	public void setIdProcesso(Integer idprocesso) {
		this.idProcesso = idprocesso;
	}

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

	public Date getDtPublicacao() {
		return dtPublicacao;
	}

	public void setDtPublicacao(Date dtPublicacao) {
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
