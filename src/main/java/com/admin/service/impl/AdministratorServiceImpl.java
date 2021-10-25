package com.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.model.entity.Administrator;
import com.admin.repository.AdministratorRepository;
import com.admin.service.AdministratorService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdministratorServiceImpl implements AdministratorService {

	@Autowired
	private AdministratorRepository adminRepository;

	@Override
	public List<Administrator> findByStatus(boolean status) {
        log.info("--- findByStatus --- ", status);
		
		return adminRepository.findByStatus(status);
	}

	@Override
	public List<Administrator> findByArea(String area) {
        log.info("--- findByArea --- ", area);
		return adminRepository.findByArea(area);
	}

	@Override
	public List<Administrator> findAll() {
        log.info("--- findAll --- ");
		return adminRepository.findAll();
	}

	@Override
	public int insert(Administrator admin) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Administrator admin) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer idAdmin) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Administrator findByID(Integer idAdmin) {
		// TODO Auto-generated method stub
		return null;
	}

}
