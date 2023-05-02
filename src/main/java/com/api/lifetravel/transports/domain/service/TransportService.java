package com.api.lifetravel.transports.domain.service;


import com.api.lifetravel.transports.domain.model.entity.Transport;

import java.util.List;

public interface TransportService {
    List<Transport> getAll();
    Transport create(Transport transport);

    Transport getById(Long id);

    Transport update(Long id,Transport transport);

    Transport delete(Long id);
}
