package br.com.leojavadev.dsdeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.leojavadev.dsdeliver.dto.OrderDTO;
import br.com.leojavadev.dsdeliver.dto.ProductDTO;
import br.com.leojavadev.dsdeliver.entities.Order;
import br.com.leojavadev.dsdeliver.entities.OrderStatus;
import br.com.leojavadev.dsdeliver.entities.Product;
import br.com.leojavadev.dsdeliver.repositories.OrderRepository;
import br.com.leojavadev.dsdeliver.repositories.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repo;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		List<Order> orders = repo.findOrdersWithProducts();
		return orders.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO obj) {
		Order order = new Order(
				null, 
				obj.getAddress(), 
				obj.getLatitude(), 
				obj.getLongitude(), 
				Instant.now(), 
				OrderStatus.PENDING
		); 
		for(ProductDTO p : obj.getProducts()) {
			Product product = productRepository.getOne(p.getId());
			order.getProducts().add(product);
		}
		order = repo.save(order);
		return new OrderDTO(order);
	}
	
	@Transactional
	public OrderDTO setDelivered(Long id) {
		Order order = repo.getOne(id);
		order.setStatus(OrderStatus.DELIVERED);
		order = repo.save(order);
		return new OrderDTO(order);
	}

}
