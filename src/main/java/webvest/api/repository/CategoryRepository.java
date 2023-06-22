package webvest.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import webvest.api.model.Category;
 
public interface CategoryRepository extends JpaRepository<Category, Long>  {
	
	List<Category> findByActive(boolean active);

	  List<Category> findByNameContaining(String name);
	  

}
