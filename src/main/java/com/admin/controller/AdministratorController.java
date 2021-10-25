package com.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.model.entity.Administrator;
import com.admin.service.AdministratorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/admin")
@Slf4j
public class AdministratorController {

	@Autowired
	private AdministratorService adminService;

	@GetMapping("/")
	public ResponseEntity<List<Administrator>> getAll() {
		log.info("--- findAll --- ");

		List<Administrator> list = adminService.findAll();

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Integer> insert(@RequestBody Administrator admin) {
		log.info("--- findAll --- ");

		Integer out = adminService.saveOrUpdate(admin);

		return new ResponseEntity<>(out, HttpStatus.OK);
	}

	@PutMapping("/")
	public ResponseEntity<Integer> update(@RequestBody Administrator admin) {
		log.info("--- update --- ");

		Integer out = adminService.saveOrUpdate(admin);

		return new ResponseEntity<>(out, HttpStatus.OK);
	}

	@DeleteMapping("/{idAdmin}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Integer idAdmin) {
		log.info("--- delete --- ");

		adminService.delete(idAdmin);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/{idAdmin}")
	public ResponseEntity<Administrator> findByID(@PathVariable Integer idAdmin) {
		log.info("--- findByID --- ");

		Administrator out = adminService.findByID(idAdmin);

		return new ResponseEntity<>(out, HttpStatus.OK);
	}

}
