package com.hiberus.hiring.domain.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiberus.hiring.domain.persistence.entity.OfferEntity;

/**
 * Offer Repository port
 */
public interface OfferRepository extends JpaRepository<OfferEntity, Long> {

	public List<OfferEntity> findByBrandId(Integer brandId);
	public List<OfferEntity> findByBrandIdAndProductPartnumber(Integer brandId, String partnumber);
}
