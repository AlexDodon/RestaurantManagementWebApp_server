package com.Dodon.Gatea.Saas.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class StockItem extends AbstractItem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7307516576472307427L;
	
	@ElementCollection
	private List<Supplier> suppliers;

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}
}
