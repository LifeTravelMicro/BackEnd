package com.api.lifetravel.accommodations.api;

import com.api.lifetravel.accommodations.domain.model.entity.AccommodationImage;
import com.api.lifetravel.accommodations.domain.service.AccommodationImageService;
import com.api.lifetravel.accommodations.mapping.AccommodationImageMapper;
import com.api.lifetravel.accommodations.resource.AccommodationImageResource;
import com.api.lifetravel.accommodations.resource.CreateAccommodationImageResource;
import lombok.AllArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD})
@RestController
@RequestMapping(value = "api/v1/accommodation_images", produces = "application/json")
@AllArgsConstructor
public class AccommodationImageController {

    private final AccommodationImageService accommodationImageService;

    private final AccommodationImageMapper accommodationImageMapper;

    // Create a GET method to get all the accommodation images
    @GetMapping
    public Page<AccommodationImageResource> getAll(@ParameterObject Pageable pageable) {
        return accommodationImageMapper.modelListPage(accommodationImageService.getAll(), pageable);
    }

    // Create a POST method to create a new accommodation image
    @PostMapping
    public ResponseEntity<AccommodationImageResource> create(@RequestBody CreateAccommodationImageResource resource) {
        AccommodationImage accommodationImageInput = accommodationImageMapper.toModel(resource);
        AccommodationImage accommodationImageSaved = accommodationImageService.create(accommodationImageInput);
        AccommodationImageResource accommodationImageResource = accommodationImageMapper.toResource(accommodationImageSaved);
        return new ResponseEntity<>(accommodationImageResource, HttpStatus.CREATED); // 201
    }

    // Create a PUT method to update a accommodation image
    @PutMapping("/{id}")
    public ResponseEntity<AccommodationImageResource> update(@PathVariable Long id, @RequestBody CreateAccommodationImageResource resource) {
        AccommodationImage accommodationImageInput = accommodationImageMapper.toModel(resource);
        AccommodationImage accommodationImageUpdated = accommodationImageService.update(id, accommodationImageInput);
        AccommodationImageResource accommodationImageResource = accommodationImageMapper.toResource(accommodationImageUpdated);

        return new ResponseEntity<>(accommodationImageResource, HttpStatus.OK); // 200
    }

    // Create a DELETE method to delete a accommodation image
    @DeleteMapping("/{id}")
    public ResponseEntity<AccommodationImageResource> delete(@PathVariable Long id) {
        AccommodationImage accommodationImageDeleted = accommodationImageService.delete(id);
        AccommodationImageResource accommodationImageResource = accommodationImageMapper.toResource(accommodationImageDeleted);

        return new ResponseEntity<>(accommodationImageResource, HttpStatus.OK); // 200
    }

}
