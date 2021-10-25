package com.admin.service;

import java.util.List;

import com.admin.model.entity.Administrator;

public interface AdministratorService {

	List<Administrator> findByStatus(boolean status);

	List<Administrator> findByArea(String area);

	List<Administrator> findAll();

	int saveOrUpdate(Administrator admin);

	void delete(Integer idAdmin);

	Administrator findByID(Integer idAdmin);

}
