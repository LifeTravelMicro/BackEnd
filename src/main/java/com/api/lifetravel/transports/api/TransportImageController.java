package com.api.lifetravel.transports.api;

import com.api.lifetravel.transports.domain.model.entity.TransportImage;
import com.api.lifetravel.transports.domain.service.TransportImageService;
import com.api.lifetravel.transports.mapping.TransportImageMapper;
import com.api.lifetravel.transports.resource.CreateTransportImageResource;
import com.api.lifetravel.transports.resource.TransportImageResource;
import lombok.AllArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD})
@RestController
@RequestMapping(value = "api/v1/transport_images", produces = "application/json")
@AllArgsConstructor
public class TransportImageController {

    private final TransportImageService transportImageService;

    private final TransportImageMapper transportImageMapper;

    // Create a GET method to get all the transport images
    @GetMapping
    public Page<TransportImageResource> getAll(@ParameterObject Pageable pageable) {
        return transportImageMapper.modelListPage(transportImageService.getAll(), pageable);
    }

    // Create a POST method to create a new transport image
    @PostMapping
    public ResponseEntity<TransportImageResource> create(@RequestBody CreateTransportImageResource resource) {
        TransportImage transportImageInput = transportImageMapper.toModel(resource);
        TransportImage transportImageSaved = transportImageService.create(transportImageInput);
        TransportImageResource transportImageResource = transportImageMapper.toResource(transportImageSaved);
        return new ResponseEntity<>(transportImageResource, HttpStatus.CREATED); // 201
    }

    // Create a PUT method to update a transport image
    @PutMapping("/{id}")
    public ResponseEntity<TransportImageResource> update(@PathVariable Long id, @RequestBody CreateTransportImageResource resource) {
        TransportImage transportImageInput = transportImageMapper.toModel(resource);
        TransportImage transportImageUpdated = transportImageService.update(id, transportImageInput);
        TransportImageResource transportImageResource = transportImageMapper.toResource(transportImageUpdated);

        return new ResponseEntity<>(transportImageResource, HttpStatus.OK); // 200
    }

    // Create a DELETE method to delete a transport image
    @DeleteMapping("/{id}")
    public ResponseEntity<TransportImageResource> delete(@PathVariable Long id) {
        TransportImage transportImageDeleted = transportImageService.delete(id);
        TransportImageResource transportImageResource = transportImageMapper.toResource(transportImageDeleted);

        return new ResponseEntity<>(transportImageResource, HttpStatus.OK); // 200
    }

}
