package org.demo.satellite.repository;

import org.demo.satellite.models.db.IngestDetailModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface to backing Database for Ingest Details data
 * 
 * @author Jarrod Sears
 *
 */
@Repository
public interface IngestDetailRepository extends JpaRepository<IngestDetailModel, Long>
{
    
}
