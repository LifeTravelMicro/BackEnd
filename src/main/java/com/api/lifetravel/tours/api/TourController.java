package com.api.lifetravel.tours.api;


import com.api.lifetravel.tours.domain.model.entity.Tour;
import com.api.lifetravel.tours.domain.service.TourService;
import com.api.lifetravel.tours.mapping.TourMapper;

import com.api.lifetravel.tours.resource.CreateTourResource;
import com.api.lifetravel.tours.resource.TourResource;

import com.api.lifetravel.transports.domain.model.entity.Transport;

import com.api.lifetravel.transports.resource.TransportResource;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD})
@RestController
@RequestMapping(value = "api/v1/tours", produces = "application/json")
@AllArgsConstructor
public class TourController {
    private final TourService tourService;

    private final TourMapper tourMapper;

    @GetMapping
    @Operation(summary = "Get all tours")
    public Page<TourResource> getAll(@ParameterObject Pageable pageable) {
        return tourMapper.modelListPage(tourService.getAll(), pageable);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get tour by id")
    public TourResource getById(@PathVariable Long id) {
        return tourMapper.toResource(tourService.getById(id));
    }

    @PostMapping
    @Operation(summary = "Create a tour")
    public ResponseEntity<TourResource> create(@RequestBody CreateTourResource resource) {
        Tour tourInput = tourMapper.toModel(resource);
        Tour tourSaved = tourService.create(tourInput);
        TourResource tourResource = tourMapper.toResource(tourSaved);
        return new ResponseEntity<>(tourResource, HttpStatus.CREATED); // 201
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a tour")
    public ResponseEntity<TourResource> update(@PathVariable Long id, @RequestBody CreateTourResource resource) {
        Tour tourInput = tourMapper.toModel(resource);
        Tour tourUpdate = tourService.update(id,tourInput);
        TourResource tourResource = tourMapper.toResource(tourUpdate);
        return new ResponseEntity<>(tourResource, HttpStatus.CREATED); // 200
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a tour")
    public ResponseEntity<TourResource> delete(@PathVariable Long id) {
        Tour tour = tourService.delete(id);
        TourResource tourResource = tourMapper.toResource(tour);
        return new ResponseEntity<>(tourResource, HttpStatus.OK); // 200
    }



}
