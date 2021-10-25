package com.admin.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idUser;

	@Column(name = "password")
	private String password;
	
	@Column(name = "user")
	private String user;


}
