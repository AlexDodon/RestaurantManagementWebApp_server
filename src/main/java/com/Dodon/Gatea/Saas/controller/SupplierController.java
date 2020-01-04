package com.Dodon.Gatea.Saas.controller;

import com.Dodon.Gatea.Saas.exception.ResourceNotFoundException;
import com.Dodon.Gatea.Saas.model.Supplier;
import com.Dodon.Gatea.Saas.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SupplierController {
	@Autowired
	SupplierRepository supplierRepository;
	@GetMapping("/suppliers")
	public List<Supplier> getAllSuppliers() {
		return supplierRepository.findAll();
	}
	@PostMapping("/suppliers")
	public Supplier createSupplier(@RequestBody Supplier supplier) {
		return supplierRepository.save(supplier);
	}
	
	@GetMapping("/suppliers/{id}")
	public Supplier getSupplierById(@PathVariable(value = "id") Long id) {
	    return supplierRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Supplier", "id", id));
	}
	@PutMapping("/suppliers/{id}")
	public Supplier updateSupplier(@PathVariable(value = "id") Long id,
	                                        @Valid @RequestBody Supplier supplierRequest) {

	    Supplier supplier = supplierRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Supplier", "id", supplierRequest));

	    supplier.setName(supplierRequest.getName());
	    supplier.setEmail(supplierRequest.getEmail());
	    supplier.setLocation(supplierRequest.getLocation());
	    supplier.setTelephone(supplierRequest.getTelephone());

	    Supplier updatedSupplier = supplierRepository.save(supplier);
	    return updatedSupplier;
	}
	@DeleteMapping("/suppliers/{id}")
	public ResponseEntity<?> deleteSupplier(@PathVariable(value = "id") Long id) {
	    Supplier supplier = supplierRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Supplier", "id", id));

	    supplierRepository.delete(supplier);

	    return ResponseEntity.ok().build();
	}

}
