package com.api.lifetravel.users.mapping;

import com.api.lifetravel.shared.mapping.EnhancedModelMapper;
import com.api.lifetravel.users.domain.model.entity.Agency;
import com.api.lifetravel.users.resource.AgencyResource;
import com.api.lifetravel.users.resource.AgencyResourceId;
import com.api.lifetravel.users.resource.CreateAgencyResource;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@AllArgsConstructor
public class AgencyMapper implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private EnhancedModelMapper modelMapper;

    public AgencyMapper agencyMapper() {
        return new AgencyMapper(modelMapper);
    }

    public Page<AgencyResource> modelListPage(List<Agency> modelList, Pageable pageable) {
        return new PageImpl<>(modelMapper.mapList(modelList, AgencyResource.class), pageable, modelList.size());
    }

    public Page<AgencyResourceId> modelListPageId(List<Agency> modelList, Pageable pageable) {
        return new PageImpl<>(modelMapper.mapList(modelList, AgencyResourceId.class), pageable, modelList.size());
    }

    public Agency toModel(CreateAgencyResource resource) {
        return modelMapper.map(resource, Agency.class);
    }

    public AgencyResource toResource(Agency agency) {
        return modelMapper.map(agency, AgencyResource.class);
    }
}
