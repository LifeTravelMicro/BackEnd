package com.api.lifetravel.transports.domain.persistence;
        import com.api.lifetravel.transports.domain.model.entity.TransportImage;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;
@Repository
public interface TransportImageRepository extends JpaRepository<TransportImage, Long> {
}
