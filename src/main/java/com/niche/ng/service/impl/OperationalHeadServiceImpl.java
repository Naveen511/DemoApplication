/******************************************************************************
 *  Property of Nichehands
 *  Nichehands Confidential Proprietary
 *  Nichehands Copyright (C) 2018 All rights reserved
 *  ----------------------------------------------------------------------------
 *  Date  : 2018/09/16
 *  Target: yarn
 *  -----------------------------------------------------------------------------
 *  File Description    : This file performs OperationalHeadServiceImpl
 *
 *******************************************************************************/
package com.niche.ng.service.impl;

import com.niche.ng.service.OperationalHeadService;
import com.niche.ng.domain.OperationalHead;
import com.niche.ng.repository.OperationalHeadRepository;
import com.niche.ng.service.dto.OperationalHeadDTO;
import com.niche.ng.service.mapper.OperationalHeadMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing OperationalHead.
 *
 * Implementing OperationalHeadService with IMPL suffix class
 * as OperationalHeadServiceImpl.
 * Using of business logic in the service layer which is present in the service file
 * using impl as a interface to access the repository layer.
 * Once we got the responce from the repository layer, mapper convert the entity
 * object to data transfer object(DTO).
 */
@Service
@Transactional
public class OperationalHeadServiceImpl implements OperationalHeadService {

    private final Logger log = LoggerFactory.getLogger(OperationalHeadServiceImpl.class);

    private final OperationalHeadRepository operationalHeadRepository;

    private final OperationalHeadMapper operationalHeadMapper;

    public OperationalHeadServiceImpl(OperationalHeadRepository operationalHeadRepository, OperationalHeadMapper operationalHeadMapper) {
        this.operationalHeadRepository = operationalHeadRepository;
        this.operationalHeadMapper = operationalHeadMapper;
    }

    /**
     * Save a operationalHead.
     *
     * @param operationalHeadDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public OperationalHeadDTO save(OperationalHeadDTO operationalHeadDTO) {
        log.debug("Request to save OperationalHead : {}", operationalHeadDTO);
        OperationalHead operationalHead = operationalHeadMapper.toEntity(operationalHeadDTO);
        operationalHead = operationalHeadRepository.save(operationalHead);
        return operationalHeadMapper.toDto(operationalHead);
    }

    /**
     * Get all the operationalHeads.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<OperationalHeadDTO> findAll(Pageable pageable) {
        log.debug("Request to get all OperationalHeads");
        return operationalHeadRepository.findAll(pageable)
            .map(operationalHeadMapper::toDto);
    }


    /**
     * Get one operationalHead by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<OperationalHeadDTO> findOne(Long id) {
        log.debug("Request to get OperationalHead : {}", id);
        return operationalHeadRepository.findById(id)
            .map(operationalHeadMapper::toDto);
    }

    /**
     * Delete the operationalHead by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete OperationalHead : {}", id);
        operationalHeadRepository.deleteById(id);
    }

    /**
     * Get the count of head office by status
     *
     * @param status the status of the entity
     * @return Long value of nursery count
     */
    @Override
    public Long findActiveCount(Integer status) {
        return operationalHeadRepository.countByStatus(status);
    }
    
}
