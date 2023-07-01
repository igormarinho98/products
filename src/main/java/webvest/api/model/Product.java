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
	private String category_id;
	
	
	
	public Product() {
		
	}
	
	public Product(String name, String description, boolean active, String category_id) {
		this.name = name;
		this.description = description;
		this.active = active;
		this.category_id = category_id;
		
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
	
	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", name=" + name + ", desc=" + description + ", active=" + active + "]";
	}
	
	
	public String getCategoryId() {
		return category_id;
	}
	
	public void setCategoryId(String category_id) {
		this.category_id = category_id;
		
	}
	
	
}
