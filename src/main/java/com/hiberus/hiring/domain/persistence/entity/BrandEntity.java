package com.hiberus.hiring.domain.persistence.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="BrandEntity")
public class BrandEntity implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -4035720456947480907L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long brandId;

	@Column(name="name")
	private String name;

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
