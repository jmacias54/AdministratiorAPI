package com.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.model.entity.Administrator;
import com.admin.service.AdministratorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class AdministratorController {

	@Autowired
	private AdministratorService adminService;

	@GetMapping("/administrators")
	public ResponseEntity<List<Administrator>> getAll() {
        log.info("--- findAll --- ");

		List<Administrator> list = adminService.findAll();

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
