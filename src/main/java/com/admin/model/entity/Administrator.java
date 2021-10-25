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
@Table(name = "administrators")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Administrator {

	// id_admin
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idAdmin;

	@Column(name = "name")
	private String name;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "area")
	private String area;

	@Column(name = "email")
	private String email;

	@Column(name = "status")
	private boolean status;

}
