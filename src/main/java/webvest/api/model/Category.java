package webvest.api.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "categories")
public class Category {
	
	
 		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		
		@Column(name = "name")
		private String name;
		
		@Column(name = "description")
		private String description;
		
		@Column(name = "active")
		private boolean active;
		
		@Column(name = "product_id")
		private String product_id;
		
		
		
		public Category() {
			
		}
		
		public Category(String name, String description, boolean active, String product_id) {
			this.name = name;
			this.description = description;
			this.active = active;
			this.product_id = UUID.randomUUID().toString();
			 
			
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

		public String getProduct_id() {
			return product_id;
		}

		public void setProduct_id(String product_id) {
			this.product_id = product_id ;
		}

}
