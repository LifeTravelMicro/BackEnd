package com.api.lifetravel.users.mapping;

import com.api.lifetravel.shared.mapping.EnhancedModelMapper;
import com.api.lifetravel.users.domain.model.entity.Traveler;
import com.api.lifetravel.users.resource.TravelerResource;
import com.api.lifetravel.users.resource.CreateTravelerResource;
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
public class TravelerMapper implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private EnhancedModelMapper modelMapper;

    public TravelerMapper travelerMapper() {
        return new TravelerMapper(modelMapper);
    }

    public Page<TravelerResource> modelListPage(List<Traveler> modelList, Pageable pageable) {
        return new PageImpl<>(modelMapper.mapList(modelList, TravelerResource.class), pageable, modelList.size());
    }

    public Traveler toModel(CreateTravelerResource resource) {
        return modelMapper.map(resource, Traveler.class);
    }

    public TravelerResource toResource(Traveler agency) {
        return modelMapper.map(agency, TravelerResource.class);
    }
}
