package com.Dodon.Gatea.Saas.controller;


import com.Dodon.Gatea.Saas.exception.ResourceNotFoundException;
import com.Dodon.Gatea.Saas.model.Order;
import com.Dodon.Gatea.Saas.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {
	@Autowired
	OrderRepository orderRepository;
	@GetMapping("/orders")
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}
	@PostMapping("/orders")
	public Order createOrder(@RequestBody Order order) {
		return orderRepository.save(order);
	}
	
	@GetMapping("/orders/{id}")
	public Order getOrderById(@PathVariable(value = "id") Long id) {
	    return orderRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));
	}
	@PutMapping("/orders/{id}")
	public Order updateOrder(@PathVariable(value = "id") Long id,
	                                        @Valid @RequestBody Order orderRequest) {

	    Order order = orderRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderRequest));
	    order.setWaiter(orderRequest.getWaiter());
	    order.setOrderItems(orderRequest.getOrderItems());

	    Order updatedOrder = orderRepository.save(order);
	    return updatedOrder;
	}
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable(value = "id") Long id) {
	    Order order = orderRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));

	    orderRepository.delete(order);

	    return ResponseEntity.ok().build();
	}

}