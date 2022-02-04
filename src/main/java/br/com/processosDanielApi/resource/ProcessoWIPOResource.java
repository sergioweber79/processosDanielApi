package br.com.processosDanielApi.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.processosDanielApi.dominio.BaseDominio;
import br.com.processosDanielApi.dominio.BaseErro;
import br.com.processosDanielApi.dominio.ProcessoDaniel;
import br.com.processosDanielApi.dominio.ProcessoWIPO;
import br.com.processosDanielApi.service.BaseService;
import br.com.processosDanielApi.service.ProcessoWIPOServiceImpl;



@RestController
@RequestMapping("/processowipo")
public class ProcessoWIPOResource extends BaseResource<ProcessoWIPO, Integer> {
	

}
