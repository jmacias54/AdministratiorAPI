package com.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.model.entity.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {
	
	List<Administrator> findByStatus(boolean status);
	  List<Administrator> findByArea(String area);

}
