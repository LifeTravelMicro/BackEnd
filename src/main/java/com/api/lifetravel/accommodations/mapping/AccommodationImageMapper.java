package com.api.lifetravel.accommodations.mapping;

import com.api.lifetravel.accommodations.domain.model.entity.AccommodationImage;
import com.api.lifetravel.accommodations.resource.AccommodationImageResource;
import com.api.lifetravel.accommodations.resource.CreateAccommodationImageResource;
import com.api.lifetravel.shared.mapping.EnhancedModelMapper;
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
public class AccommodationImageMapper implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private EnhancedModelMapper modelMapper;
    public AccommodationImageMapper reviewMapper() {
        return new AccommodationImageMapper(modelMapper);
    }

    public Page<AccommodationImageResource> modelListPage(List<AccommodationImage> modelList, Pageable pageable) {
        return new PageImpl<>(modelMapper.mapList(modelList, AccommodationImageResource.class), pageable, modelList.size());
    }

    public AccommodationImage toModel(CreateAccommodationImageResource resource) {
        return modelMapper.map(resource, AccommodationImage.class);
    }

    public AccommodationImageResource toResource(AccommodationImage image) {
        return modelMapper.map(image, AccommodationImageResource.class);
    }
}
