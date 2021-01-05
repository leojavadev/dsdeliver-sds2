package br.com.leojavadev.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.leojavadev.dsdeliver.dto.ProductDTO;
import br.com.leojavadev.dsdeliver.entities.Product;
import br.com.leojavadev.dsdeliver.repositories.ProductRepository;

@Service //ou @Component
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll(){
		List<Product> products = repo.findAllByOrderByNameAsc();
		return products.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}
}
