package com.api.lifetravel.users.api;

import com.api.lifetravel.users.domain.model.entity.Traveler;
import com.api.lifetravel.users.domain.service.TravelerService;
import com.api.lifetravel.users.mapping.TravelerMapper;
import com.api.lifetravel.users.resource.TravelerResource;
import com.api.lifetravel.users.resource.CreateTravelerResource;
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
@RequestMapping(value = "api/v1/travelers", produces = "application/json")
@AllArgsConstructor
public class TravelerController {

    private final TravelerService travelerService;

    private final TravelerMapper travelerMapper;

    @GetMapping
    @Operation(summary = "Get all travelers")
    public Page<TravelerResource> getAllAgencies(@ParameterObject Pageable pageable) {
        return travelerMapper.modelListPage(travelerService.getAll(), pageable);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get traveler by id")
    public TravelerResource getTravelerById(@PathVariable Long id) {
        return travelerMapper.toResource(travelerService.getById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new traveler")
    public ResponseEntity<TravelerResource> createTraveler(@RequestBody CreateTravelerResource resource) {
        Traveler travelerInput = travelerMapper.toModel(resource);
        Traveler travelerSaved = travelerService.create(travelerInput);
        TravelerResource travelerResource = travelerMapper.toResource(travelerSaved);
        return new ResponseEntity<>(travelerResource, HttpStatus.CREATED); // 201
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a traveler")
    public ResponseEntity<TravelerResource> updateTraveler(@PathVariable Long id, @RequestBody CreateTravelerResource resource) {
        Traveler travelerInput = travelerMapper.toModel(resource);
        Traveler travelerSaved = travelerService.update(id, travelerInput);
        TravelerResource travelerResource = travelerMapper.toResource(travelerSaved);
        return new ResponseEntity<>(travelerResource, HttpStatus.OK); // 200
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a traveler")
    public ResponseEntity<TravelerResource> deleteTraveler(@PathVariable Long id) {
        Traveler traveler = travelerService.delete(id);
        TravelerResource travelerResource = travelerMapper.toResource(traveler);
        return new ResponseEntity<>(travelerResource, HttpStatus.OK); // 200
    }

}
