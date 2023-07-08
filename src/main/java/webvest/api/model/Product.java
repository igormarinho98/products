package webvest.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "category_id")
	private Integer category_id;
	
	@Column(name = "rentabiity")
	private double rentabiity;
	
	
	
	public Product() {
		
	}
	
	public Product(String name, String description, boolean active, Integer category_id, double rentabiity) {
		this.name = name;
		this.description = description;
		this.active = active;
		this.category_id = category_id;
		this.rentabiity = rentabiity;
		
	}

	public Long getId() {
		return id;
	}
	 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	 
	
	
	public Integer getCategoryId() {
		return category_id;
	}
	
	public void setCategoryId(Integer category_id) {
		this.category_id = category_id;
		
	}
	
	public double getRentability() {
		return rentabiity;
	}
	
	public void setRentability(double rentability) {
		this.rentabiity = rentability;
	}
	
	
	
	
}
