/******************************************************************************
 *  Property of Nichehands
 *  Nichehands Confidential Proprietary
 *  Nichehands Copyright (C) 2018 All rights reserved
 *  ----------------------------------------------------------------------------
 *  Date  : 2018/08/02
 *  Target: yarn
 *  -----------------------------------------------------------------------------
 *  File Description    : This file performs PickListValueService
 *
 *******************************************************************************/
package com.niche.ng.service;

import com.niche.ng.service.dto.PickListValueDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
/**
 * Service Interface for managing PickListValue.
 */
public interface PickListValueService {

    /**
     * Save a pickListValue.
     *
     * @param pickListValueDTO the entity to save
     * @return the persisted entity
     */
    PickListValueDTO save(PickListValueDTO pickListValueDTO);

    /**
     * Get all the pickListValues.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<PickListValueDTO> findAll(Pageable pageable);


    /**
     * Get the "id" pickListValue.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<PickListValueDTO> findOne(Long id);

    /**
     * Delete the "id" pickListValue.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
