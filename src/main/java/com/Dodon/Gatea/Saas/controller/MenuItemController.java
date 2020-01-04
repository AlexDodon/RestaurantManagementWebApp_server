package com.Dodon.Gatea.Saas.controller;

import com.Dodon.Gatea.Saas.exception.ResourceNotFoundException;
import com.Dodon.Gatea.Saas.model.MenuItem;
import com.Dodon.Gatea.Saas.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MenuItemController {
	@Autowired
	MenuItemRepository menuItemRepository;
	@GetMapping("/menuItems")
	public List<MenuItem> getAllMenuItems() {
		return menuItemRepository.findAll();
	}
	@PostMapping("/menuItems")
	public MenuItem createMenuItem(@RequestBody MenuItem menuItem) {
		return menuItemRepository.save(menuItem);
	}
	
	@GetMapping("/menuItems/{id}")
	public MenuItem getMenuItemById(@PathVariable(value = "id") Long id) {
	    return menuItemRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("MenuItem", "id", id));
	}
	@PutMapping("/menuItems/{id}")
	public MenuItem updateMenuItem(@PathVariable(value = "id") Long id,
	                                        @Valid @RequestBody MenuItem menuItemRequest) {

	    MenuItem menuItem = menuItemRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("MenuItem", "id", menuItemRequest));

	    menuItem.setName(menuItemRequest.getName());
	    menuItem.setIngredients(menuItemRequest.getIngredients());
	    menuItem.setPrice(menuItemRequest.getPrice());
	    menuItem.setQuantity(menuItemRequest.getQuantity());

	    MenuItem updatedMenuItem = menuItemRepository.save(menuItem);
	    return updatedMenuItem;
	}
	@DeleteMapping("/menuItems/{id}")
	public ResponseEntity<?> deleteMenuItem(@PathVariable(value = "id") Long id) {
	    MenuItem menuItem = menuItemRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("MenuItem", "id", id));

	    menuItemRepository.delete(menuItem);

	    return ResponseEntity.ok().build();
	}

}
