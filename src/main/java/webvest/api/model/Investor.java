package webvest.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "investors")
public class Investor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "birthday")
	private String birthday;
	
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "zip_code")
	private String zip_code;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone_number")
	private String phone_number;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "suitability")
	private Long suitability;
	
	
	
	
	public Investor() {
		
	}
		
	
	public Investor (String first_name, String last_name, String birthday, String cpf, String address, String city, String state, String zip_code, String email, String phone_number, String password, Long suitability) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.birthday = birthday;
		this.cpf = cpf;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip_code = zip_code;
		this.email = email;
		this.phone_number = phone_number;
		this.password = password;
		this.suitability = suitability;
		
		
	}


	public Long getSuitability() {
		return suitability;
	}


	public void setSuitability(Long suitability) {
		this.suitability = suitability;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return first_name;
	}


	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}


	public String getLastName() {
		return last_name;
	}


	public void setLastName(String last_name) {
		this.last_name = last_name;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZipCode() {
		return zip_code;
	}


	public void setZipCode(String zip_code) {
		this.zip_code = zip_code;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phone_number;
	}


	public void setPhoneNumber(String phone_number) {
		this.phone_number = phone_number;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
}
