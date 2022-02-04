package br.com.processosDanielApi.resource;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.processosDanielApi.dominio.ProcessoDaniel;
import br.com.processosDanielApi.service.ProcessoDanielServiceImpl;




@RestController
@RequestMapping("/processodaniel")
public class ProcessoDanielResource extends BaseResource<ProcessoDaniel, Integer> {
	
	@Autowired
	private ProcessoDanielServiceImpl serviceProcessoDaniel;
	
	@GetMapping(path="/numeropublicacao/{id}") 
	public ResponseEntity<Iterable<ProcessoDaniel>> findByNumeroPublicacao (@PathVariable("id") String id) {
		try {

			return new ResponseEntity<>(serviceProcessoDaniel.findByNumeroPublicacao(id), HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@GetMapping(path="/requerentes/{requerentes}") 
	public ResponseEntity<Iterable<ProcessoDaniel>> findByRequerentesLike (@PathVariable("requerentes") String requerentes) {
		try {

			return new ResponseEntity<>(serviceProcessoDaniel.findByRequerentesContaining(requerentes.toUpperCase()), HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@GetMapping(path="/numeropublicacao/{numero}/requerentes/{requerentes}") 
	public ResponseEntity<Iterable<ProcessoDaniel>> findByNumeroPublicacaoAndRequerentesContaining (@PathVariable("numero") String numero,@PathVariable("requerentes") String requerentes) {
		try {

			
			return new ResponseEntity<>(serviceProcessoDaniel.findByNumeroPublicacaoAndRequerentesContaining(numero,requerentes.toUpperCase()), HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			//TODO veriicar retorno de erro qdo lista
			
			//return new ResponseEntity<>(new BaseErro(HttpStatus.UNPROCESSABLE_ENTITY.value(), e.getMessage(), e.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

}
