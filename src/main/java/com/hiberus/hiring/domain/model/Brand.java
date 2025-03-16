package com.hiberus.hiring.domain.model;

import java.io.Serializable;

public class Brand implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -9072368546638312387L;
	private Long brandId;
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
