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
		
	
		
		public Category() {
			
		}
		
		public Category(String name, String description, boolean active) {
			this.name = name;
			this.description = description;
			this.active = active;
 			 
			
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

		 
}
