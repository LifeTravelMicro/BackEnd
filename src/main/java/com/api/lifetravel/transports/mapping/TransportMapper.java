package com.api.lifetravel.transports.mapping;

import com.api.lifetravel.shared.mapping.EnhancedModelMapper;
import com.api.lifetravel.transports.domain.model.entity.Transport;
import com.api.lifetravel.transports.resource.CreateTransportResource;
import com.api.lifetravel.transports.resource.TransportResource;
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
public class TransportMapper implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private EnhancedModelMapper modelMapper;

    public TransportMapper transportMapper() { return new TransportMapper(modelMapper); }

    public Page<TransportResource> modelListPage(List<Transport> modelList, Pageable pageable) {
        return new PageImpl<>(modelMapper.mapList(modelList, TransportResource.class), pageable, modelList.size());
    }

    public Transport toModel(CreateTransportResource resource) { return modelMapper.map(resource, Transport.class);}

    public TransportResource toResource(Transport transport) {
        return modelMapper.map(transport, TransportResource.class);
    }
}
