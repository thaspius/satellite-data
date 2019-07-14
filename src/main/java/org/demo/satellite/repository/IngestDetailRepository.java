package org.demo.satellite.repository;

import org.demo.satellite.models.db.IngestDetailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngestDetailRepository extends JpaRepository<IngestDetailModel, Long>
{
    
}
