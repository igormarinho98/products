package webvest.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "suitability")
public class Suitability {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "profile")
	private String profile;

	@Column(name = "description")
	private String description;
	
	
	@Column(name = "register_date")
	private String register_date;
	
	
	
	public Suitability() {
		
	}
	
	public Suitability(String profile, String description, String register_date ) {
		this.profile = profile;
		this.description = description;
		this.register_date = register_date;
 	}

 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRegisterDate() {
		return register_date;
	}

	public void setRegisterDate(String register_date) {
		this.register_date = register_date;
	}
	
}
