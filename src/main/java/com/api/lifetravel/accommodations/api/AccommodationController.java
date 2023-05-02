package com.api.lifetravel.accommodations.api;

import com.api.lifetravel.accommodations.domain.service.AccommodationService;
import com.api.lifetravel.accommodations.mapping.AccommodationMapper;
import com.api.lifetravel.accommodations.resource.AccommodationResource;
import com.api.lifetravel.accommodations.resource.AccommodationResourceId;
import com.api.lifetravel.accommodations.resource.CreateAccommodationResource;
import com.api.lifetravel.accommodations.domain.model.entity.Accommodation;
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
@RequestMapping(value = "api/v1/accommodations", produces = "application/json")
@AllArgsConstructor
public class AccommodationController {

    private final AccommodationService accommodationService;

    private final AccommodationMapper accommodationMapper;

    @GetMapping
    @Operation(summary = "Get all accommodations")
    public Page<AccommodationResource> getAll(@ParameterObject Pageable pageable) {
        return accommodationMapper.modelListPage(accommodationService.getAll(), pageable);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get accommodation by id")
    public AccommodationResource getById(@PathVariable Long id) {
        return accommodationMapper.toResource(accommodationService.getById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new accommodation")
    public ResponseEntity<AccommodationResource> create(@RequestBody CreateAccommodationResource resource) {
        Accommodation accommodationInput = accommodationMapper.toModel(resource);

        Accommodation accommodationSaved = accommodationService.create(accommodationInput);
        AccommodationResource accommodationResource = accommodationMapper.toResource(accommodationSaved);


        return new ResponseEntity<>(accommodationResource, HttpStatus.CREATED); // 201
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an accommodation")
    public ResponseEntity<AccommodationResource> update(@PathVariable Long id, @RequestBody CreateAccommodationResource resource) {
        Accommodation accommodationInput = accommodationMapper.toModel(resource);
        Accommodation accommodationUpdated = accommodationService.update(id, accommodationInput);
        AccommodationResource accommodationResource = accommodationMapper.toResource(accommodationUpdated);

        return new ResponseEntity<>(accommodationResource, HttpStatus.OK); // 200
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an accommodation")
    public ResponseEntity<AccommodationResource> delete(@PathVariable Long id) {
        Accommodation accommodation = accommodationService.delete(id);
        AccommodationResource accommodationResource = accommodationMapper.toResource(accommodation);

        return new ResponseEntity<>(accommodationResource, HttpStatus.OK); // 200
    }


}
