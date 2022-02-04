package br.com.processosDanielApi.service;


import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.springframework.stereotype.Service;

import br.com.processosDanielApi.dominio.ProcessoWIPO;
import br.com.processosDanielApi.exception.BaseException;

@Service
public class ProcessoWIPOServiceImpl implements BaseService<ProcessoWIPO, Integer> {

	@Override
	public ProcessoWIPO save(ProcessoWIPO entity) throws BaseException {
		return null;
	}

	@Override
	public ProcessoWIPO update(ProcessoWIPO entity) throws BaseException {
		return null;
	}

	@Override
	public ProcessoWIPO remove(Integer id) throws BaseException {
		return null;
	}

	@Override
	public ProcessoWIPO findbyWIPO(String id) throws BaseException {
		  ProcessoWIPO processoWIPO = new ProcessoWIPO();
		  try {

			  HttpResponse httpresponse = conectarSiteWIPO(id);
			  
		      Scanner sc = new Scanner(httpresponse.getEntity().getContent(),"UTF-8");

		      processoWIPO = getCamposHtml(sc);
		      
		  } catch (Exception e) {
			 e.printStackTrace();
		  }
		
		  return processoWIPO;
	}
	
	public HttpResponse conectarSiteWIPO(String id) throws BaseException{
		try {
		      CloseableHttpClient httpclient = HttpClients.createDefault();

		      HttpGet httpget = new HttpGet("https://patentscope.wipo.int/search/pt/detail.jsf?docId="+id+"&redirectedID=true");

		      HttpResponse httpresponse = httpclient.execute(httpget);
		      
		      return httpresponse;
			
		} catch (Exception e) {
			throw new BaseException("URL WIPO não encontrada.");
		}
		
	}

	@Override
	public Iterable<ProcessoWIPO> findAll() {
		return null;
	}


	
	 public ProcessoWIPO getCamposHtml(Scanner sc) {
		 
		  ProcessoWIPO processoWIPO = new ProcessoWIPO();
		  boolean inicioDetail=false;
		  boolean fimDetail=false;
		  int campo=0;
		  
	      while(sc.hasNext()) {
		   	   String linha=sc.nextLine();
	   	  	   if (linha!=null && linha.contains("mytable")) { 
		  		   inicioDetail=true;
		  	   }
		  	   if (linha!=null && linha.contains("<script")) {
		  		   fimDetail=true;
		  	   }

		  	   if (inicioDetail && !fimDetail) {
		  		   ///span dos valores dos campos
		  		 if (linha!=null && linha.contains("ps-field--label ps-biblio-field--label")) {
			  			if (linha.contains("ps-field--label ps-biblio-field--label")){
			  				if (linha.contains("Número da publi")) {
			  					campo=1;
			  				}else if (linha.contains("Data de publica")) {
			  					campo=2;
			  				}else if (linha.contains("pedido internacional")) {
			  					campo=3;
			  				}else if (linha.contains("Requerentes")) {
			  					campo=4;	
			  					
			  				}else if (linha.contains("Título")) {
			  					campo=5;
			  				}
			  			}
			  	  }
		  		 if (linha!=null && linha.contains("ps-field--value ps-biblio-field--value")) {
		  			 
		  			 if (campo==1) {
		  				 linha = tratarNroPublicacao(tratarCampos(linha));
		  				 processoWIPO.setNumeroPublicacao(linha);
		  				 campo=0;
		  			 }else if (campo==2) {
		  				 linha = tratarDtPublicacao(tratarCampos(linha));
		  				 processoWIPO.setDtPublicacao(linha);
		  				 campo=0;
		  			 }else if (campo==3) {
		  				 linha = tratarNroPedidoInternacional(tratarCampos(linha));
		  				 processoWIPO.setNumeroPedidoInternacional(linha);
		  				 campo=0; 
		  			 }else if (campo == 4) { //requerentes
		  				 linha=sc.nextLine();
		  				 linha=sc.nextLine();
		  				 String requerentes = "";
		  				 while (!linha.contains("</ul>")) {
		  					linha=sc.nextLine();
		  					if (linha.contains("biblio-person-list--name")) {
		  						requerentes+=linha;	
		  					}
		  					
		  				 }
		  				requerentes = tratarRequerentes(tratarCampos(requerentes));
		  				processoWIPO.setRequerentes(requerentes);
		  				campo=0;
		  			 }else if (campo == 5) {// titulo
		  				 linha = sc.nextLine();
		  				 linha = tratarTitulo(tratarCampos(linha));
		  				 processoWIPO.setTitulo(linha);
		  				 campo=0;
		  			 }
		  		 }
		  	   }
		  	   fimDetail=false;
		  	   
		  	   System.out.println(linha);
	    	   	  		
	      }
	      System.out.println(processoWIPO.toString()+" - nro - "+processoWIPO.getNumeroPublicacao());
	      return processoWIPO;
	   }
	   
	   
	   public String tratarCampos(String campo) {
		   
		   if (campo==null ) return "";
		   
		   
		   return campo.replaceAll("<span", "").replaceAll("class", "")
				   .replaceAll("list--name", "").replaceAll("ps-field--value ps-biblio-field--value", "")
				   .replaceAll("</span>", "")
				   .replaceAll("</b>", "").replaceAll("<div>", "")
				   .replaceAll("<b", "").replaceAll("</div>", "")
				   .replaceAll("notranslate", "").replaceAll("patent-title", "")
				   .replaceAll("</span", "").replaceAll("id", "")
				   .replaceAll("=", "").replaceAll("\"", "")
				   .replaceAll("biblio-person-", "").replaceAll("\"", "")
				   .replaceAll("=", "").replaceAll("\"", "")
				   .replaceAll("<div >", "").replaceAll("PCTtitle>", "")
				   .replaceAll("/>", "").replaceAll(">", "").replaceAll("needTranslation-biblio", "")
				   .replaceAll("\t", "").replaceAll("</ul>", "");
				   
				   
		   
		   
	   }
	   
	   
	   public String tratarNroPublicacao(String campo) {
		   if (campo==null ) return "";
		   
		   return campo.substring(campo.length()-14, campo.length());
	   }
	   
	   public String tratarDtPublicacao(String campo) {
		   if (campo==null ) return "";
		   
		   return campo.replaceAll("\\.", "\\/").substring(1, campo.length());
	   }

	   public String tratarNroPedidoInternacional(String campo) {
		   if (campo==null ) return "";
		   
		   return campo.substring(1, campo.length());
	   }

	   public String tratarRequerentes(String campo) {
		   if (campo==null ) return "";
		   
		   return campo.substring(1, campo.length());
	   }

	   public String tratarTitulo(String campo) {
		   if (campo==null ) return "";
		   
		   return campo.replaceAll("                    ", "");
	   }

	@Override
	public ProcessoWIPO findbyId(Integer id) throws BaseException {
		return null;
	}


	

}
