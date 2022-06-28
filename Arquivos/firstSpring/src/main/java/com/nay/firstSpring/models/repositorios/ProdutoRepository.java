package com.nay.firstSpring.models.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nay.firstSpring.models.entidades.Produto;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer>{

	public Iterable<Produto> findByNomeContainingIgnoreCase(String nomes);
		
}
