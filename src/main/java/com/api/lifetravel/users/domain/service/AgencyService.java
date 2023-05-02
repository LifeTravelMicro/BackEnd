package com.api.lifetravel.users.domain.service;

import com.api.lifetravel.users.domain.model.entity.Agency;

import java.util.List;

public interface AgencyService{

    List<Agency> getAll();

    Agency getAgencyById(Long id);

    Agency create(Agency agency);

    Agency update(Long id, Agency agencyInput);

    Agency delete(Long id);
}
