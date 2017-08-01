package com.by.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.by.model.MenuData;
public interface MenuDataRepository extends CrudRepository<MenuData, Integer>{
	List<MenuData> findAll();
}
