package com.api.lifetravel.accommodations.mapping;

import com.api.lifetravel.accommodations.resource.AccommodationResource;
import com.api.lifetravel.accommodations.resource.AccommodationResourceId;
import com.api.lifetravel.accommodations.resource.CreateAccommodationResource;
import com.api.lifetravel.accommodations.domain.model.entity.Accommodation;
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
public class AccommodationMapper implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private EnhancedModelMapper modelMapper;

    public AccommodationMapper accommodationMapper() { return new AccommodationMapper(modelMapper); }

    public Page<AccommodationResource> modelListPage(List<Accommodation> modelList, Pageable pageable) {
        return new PageImpl<>(modelMapper.mapList(modelList, AccommodationResource.class), pageable, modelList.size());
    }

    public Accommodation toModel(CreateAccommodationResource resource) { return modelMapper.map(resource, Accommodation.class);}

    public AccommodationResource toResource(Accommodation accommodation) {
        return modelMapper.map(accommodation, AccommodationResource.class);
    }
}
