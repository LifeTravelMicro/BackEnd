package com.api.lifetravel.users.domain.persistence;

import com.api.lifetravel.users.domain.model.entity.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long> {

    Agency findByName(String name);
}
