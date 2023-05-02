package com.api.lifetravel.transports.mapping;

import com.api.lifetravel.shared.mapping.EnhancedModelMapper;
import com.api.lifetravel.transports.domain.model.entity.TransportImage;
import com.api.lifetravel.transports.resource.CreateTransportImageResource;
import com.api.lifetravel.transports.resource.TransportImageResource;
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
public class TransportImageMapper implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private EnhancedModelMapper modelMapper;
    public TransportImageMapper transportImageMapper() {
        return new TransportImageMapper(modelMapper);
    }

    public Page<TransportImageResource> modelListPage(List<TransportImage> modelList, Pageable pageable) {
        return new PageImpl<>(modelMapper.mapList(modelList, TransportImageResource.class), pageable, modelList.size());
    }

    public TransportImage toModel(CreateTransportImageResource resource) {
        return modelMapper.map(resource, TransportImage.class);
    }

    public TransportImageResource toResource(TransportImage image) {
        return modelMapper.map(image, TransportImageResource.class);
    }
}
