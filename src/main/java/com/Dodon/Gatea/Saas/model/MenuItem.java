package com.Dodon.Gatea.Saas.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
public class MenuItem extends AbstractItem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -760750689649986722L;
	
	public enum TYPE {
		RESTAURANT, BAR, BOTH
	}
	@ElementCollection
	private List<StockItem> ingredients;
	@NotBlank
	@Column
	private double price;
	public List<StockItem> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<StockItem> ingredients) {
		this.ingredients = ingredients;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
