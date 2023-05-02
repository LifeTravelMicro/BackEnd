package com.api.lifetravel.users.domain.service;

import com.api.lifetravel.users.domain.model.entity.Traveler;

import java.util.List;

public interface TravelerService {

    List<Traveler> getAll();

    Traveler getById(Long id);

    Traveler create(Traveler agency);

    Traveler update(Long id, Traveler agencyInput);

    Traveler delete(Long id);
}
