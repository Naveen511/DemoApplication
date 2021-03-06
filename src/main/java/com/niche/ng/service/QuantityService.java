/******************************************************************************
 *  Property of Nichehands
 *  Nichehands Confidential Proprietary
 *  Nichehands Copyright (C) 2018 All rights reserved
 *  ----------------------------------------------------------------------------
 *  Date  : 2018/08/22
 *  Target: yarn
 *  -----------------------------------------------------------------------------
 *  File Description    : This file performs QuantityService
 *
 *******************************************************************************/
package com.niche.ng.service;

import com.niche.ng.service.dto.QuantityDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing Quantity.
 */
public interface QuantityService {

    /**
     * Save a quantity.
     *
     * @param quantityDTO the entity to save
     * @return the persisted entity
     */
    QuantityDTO save(QuantityDTO quantityDTO);

    /**
     * Get all the quantities.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<QuantityDTO> findAll(Pageable pageable);


    /**
     * Get the "id" quantity.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<QuantityDTO> findOne(Long id);

    /**
     * Delete the "id" quantity.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
