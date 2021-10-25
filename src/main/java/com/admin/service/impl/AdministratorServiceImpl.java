
package com.admin.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.exception.BadRequestException;
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

		if (area == null || "".equals(area))
			throw new BadRequestException("Invalid request.");

		return adminRepository.findByArea(area);
	}

	@Override
	public List<Administrator> findAll() {
		log.info("--- findAll --- ");
		return adminRepository.findAll();
	}

	@Override
	public int saveOrUpdate(Administrator admin) {
		log.info("--- saveOrUpdate --- ", admin);

		if (admin == null)
			throw new BadRequestException("Invalid request.");

		Administrator out = adminRepository.save(admin);

		if (out != null)
			return 1;

		return 0;
	}

	@Override
	public void delete(Integer idAdmin) {
		log.info("--- delete --- ", idAdmin);

		if (idAdmin == null || idAdmin == 0)
			throw new BadRequestException("Invalid request.");

		Optional<Administrator> admin = adminRepository.findById(idAdmin);
		if (admin.isPresent())
			adminRepository.delete(admin.get());

	}

	@Override
	public Administrator findByID(Integer idAdmin) {
		log.info("--- findByID --- ", idAdmin);

		if (idAdmin == null || idAdmin == 0)
			throw new BadRequestException("Invalid request.");

		Optional<Administrator> admin = adminRepository.findById(idAdmin);
		if (admin.isPresent())
			return admin.get();

		return null;
	}

}
