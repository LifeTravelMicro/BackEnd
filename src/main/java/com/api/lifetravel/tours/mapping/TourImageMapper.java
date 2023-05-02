package com.api.lifetravel.tours.mapping;

import com.api.lifetravel.shared.mapping.EnhancedModelMapper;
import com.api.lifetravel.tours.domain.model.entity.TourImage;
import com.api.lifetravel.tours.resource.CreateTourImageResource;
import com.api.lifetravel.tours.resource.TourImageResource;
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
public class TourImageMapper implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private EnhancedModelMapper modelMapper;

    public TourImageMapper tourImageMapper() {return new TourImageMapper(modelMapper);}

    public Page<TourImageResource> modelListPage(List<TourImage> modelList, Pageable pageable) {
        return new PageImpl<>(modelMapper.mapList(modelList, TourImageResource.class), pageable, modelList.size());
    }

    public TourImage toModel(CreateTourImageResource resource) {
        return modelMapper.map(resource, TourImage.class);
    }

    public TourImageResource toResource(TourImage image) {
        return modelMapper.map(image, TourImageResource.class);
    }
}
