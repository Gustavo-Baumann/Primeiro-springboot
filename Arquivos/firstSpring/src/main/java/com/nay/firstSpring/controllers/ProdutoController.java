package com.nay.firstSpring.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nay.firstSpring.models.entidades.Produto;
import com.nay.firstSpring.models.repositorios.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository proRep;
	
	@RequestMapping(method = {RequestMethod.POST,RequestMethod.PUT})
	public @ResponseBody Produto salvarProduto(@Valid Produto produto) {
		try {
			proRep.save(produto);
		}catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
		return produto;	
	}
	
	@GetMapping
	public Iterable<Produto> obterProdutos(){
		return proRep.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Produto> obterProdutoPorID(@PathVariable int id) {
		return proRep.findById(id);
	}
	
	@GetMapping(path = "/nome/{nomes}")
	public Iterable<Produto> obterProdutoPorNome(@PathVariable String nomes){
		return proRep.findByNomeContainingIgnoreCase(nomes);
	}
	
	@GetMapping(path = "/pagina/{pagina}/{num_res}")
	public Iterable<Produto> obterProdutosPorPagina
	(@PathVariable int pagina, @PathVariable int num_res) {
		Pageable page = PageRequest.of(pagina, num_res);
		return proRep.findAll(page);
	}
	
	@DeleteMapping(path = "/{id}")
	public void deletarProdutoPorID(@PathVariable int id) {
		try {
			proRep.deleteById(id);
		}catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}	
	}
}
