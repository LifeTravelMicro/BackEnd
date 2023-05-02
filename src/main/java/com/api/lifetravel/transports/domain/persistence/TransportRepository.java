package com.api.lifetravel.transports.domain.persistence;
import com.api.lifetravel.transports.domain.model.entity.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TransportRepository extends JpaRepository<Transport, Long>{
}
