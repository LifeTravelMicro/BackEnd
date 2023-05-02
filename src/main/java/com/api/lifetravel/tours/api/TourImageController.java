package com.api.lifetravel.tours.api;


import com.api.lifetravel.tours.domain.model.entity.TourImage;
import com.api.lifetravel.tours.domain.service.TourImageService;


import com.api.lifetravel.tours.mapping.TourImageMapper;
import com.api.lifetravel.tours.resource.CreateTourImageResource;
import com.api.lifetravel.tours.resource.TourImageResource;
import com.api.lifetravel.transports.resource.CreateTransportImageResource;

import lombok.AllArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD})
@RestController
@RequestMapping(value = "api/v1/tour_images", produces = "application/json")
@AllArgsConstructor
public class TourImageController {

    private final TourImageService tourImageService;

    private final TourImageMapper tourImageMapper;

    // Create a GET method to get all the transport images
    @GetMapping
    public Page<TourImageResource> getAll(@ParameterObject Pageable pageable) {
        return tourImageMapper.modelListPage(tourImageService.getAll(), pageable);
    }

    // Create a POST method to create a new transport image
    @PostMapping
    public ResponseEntity<TourImageResource> create(@RequestBody CreateTourImageResource resource) {
        TourImage tourImageInput = tourImageMapper.toModel(resource);
        TourImage tourImageSaved = tourImageService.create(tourImageInput);
        TourImageResource tourImageResource = tourImageMapper.toResource(tourImageSaved);
        return new ResponseEntity<>(tourImageResource, HttpStatus.CREATED); // 201
    }

    // Create a PUT method to update a transport image
    @PutMapping("/{id}")
    public ResponseEntity<TourImageResource> update(@PathVariable Long id, @RequestBody CreateTourImageResource resource) {
        TourImage tourImageInput = tourImageMapper.toModel(resource);
        TourImage tourImageUpdated = tourImageService.update(id, tourImageInput);
        TourImageResource tourImageResource = tourImageMapper.toResource(tourImageUpdated);

        return new ResponseEntity<>(tourImageResource, HttpStatus.OK); // 200
    }

    // Create a DELETE method to delete a transport image
    @DeleteMapping("/{id}")
    public ResponseEntity<TourImageResource> delete(@PathVariable Long id) {
        TourImage tourImageDeleted = tourImageService.delete(id);
        TourImageResource tourImageResource = tourImageMapper.toResource(tourImageDeleted);
        return new ResponseEntity<>(tourImageResource, HttpStatus.OK); // 200
    }
    
}
