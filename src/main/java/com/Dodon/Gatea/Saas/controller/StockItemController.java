package com.Dodon.Gatea.Saas.controller;

import com.Dodon.Gatea.Saas.exception.ResourceNotFoundException;
import com.Dodon.Gatea.Saas.model.StockItem;
import com.Dodon.Gatea.Saas.repository.StockItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StockItemController {
	@Autowired
	StockItemRepository stockItemRepository;
	@GetMapping("/stockItems")
	public List<StockItem> getAllStockItems() {
		return stockItemRepository.findAll();
	}
	@PostMapping("/stockItems")
	public StockItem createStockItem(@RequestBody StockItem stockItem) {
		return stockItemRepository.save(stockItem);
	}
	
	@GetMapping("/stockItems/{id}")
	public StockItem getStockItemById(@PathVariable(value = "id") Long id) {
	    return stockItemRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("StockItem", "id", id));
	}
	@PutMapping("/stockItems/{id}")
	public StockItem updateStockItem(@PathVariable(value = "id") Long id,
	                                        @Valid @RequestBody StockItem stockItemRequest) {

	    StockItem stockItem = stockItemRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("StockItem", "id", stockItemRequest));

	    stockItem.setName(stockItemRequest.getName());
	    stockItem.setQuantity(stockItemRequest.getQuantity());
	    stockItem.setSuppliers(stockItemRequest.getSuppliers());

	    StockItem updatedStockItem = stockItemRepository.save(stockItem);
	    return updatedStockItem;
	}
	@DeleteMapping("/stockItems/{id}")
	public ResponseEntity<?> deleteStockItem(@PathVariable(value = "id") Long id) {
	    StockItem stockItem = stockItemRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("StockItem", "id", id));

	    stockItemRepository.delete(stockItem);

	    return ResponseEntity.ok().build();
	}

}
