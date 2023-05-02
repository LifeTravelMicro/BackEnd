package com.api.lifetravel.transports.domain.service;


import com.api.lifetravel.transports.domain.model.entity.TransportImage;
import java.util.List;

public interface TransportImageService {
    List<TransportImage> getAll();
    TransportImage create(TransportImage image);

    TransportImage update(Long id, TransportImage image);

    TransportImage delete(Long id);
}
