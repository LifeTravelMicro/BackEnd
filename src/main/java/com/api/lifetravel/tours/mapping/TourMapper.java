package com.api.lifetravel.tours.mapping;

import com.api.lifetravel.shared.mapping.EnhancedModelMapper;
import com.api.lifetravel.tours.domain.model.entity.Tour;
import com.api.lifetravel.tours.resource.CreateTourResource;
import com.api.lifetravel.tours.resource.TourResource;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@AllArgsConstructor
public class TourMapper implements Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    private EnhancedModelMapper modelMapper;

    public  TourMapper tourMapper(){return new TourMapper(modelMapper);}

    public Page<TourResource> modelListPage(List<Tour> modelList, Pageable pageable) {
        return new PageImpl<>(modelMapper.mapList(modelList, TourResource.class), pageable, modelList.size());
    }

    public Tour toModel(CreateTourResource resource) { return modelMapper.map(resource, Tour.class);}

    public TourResource toResource(Tour tour) {
        return modelMapper.map(tour, TourResource.class);
    }
}
