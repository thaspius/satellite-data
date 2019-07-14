package org.demo.satellite.repository;

import java.util.Collection;

import org.demo.satellite.models.db.SatelliteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface to backing Database for Satellite data
 * @author Jarrod Sears
 *
 */
@Repository
public interface SatelliteRepository extends JpaRepository<SatelliteModel, Long>
{
    public SatelliteModel findSatelliteByName(String name);
    
    public Collection<SatelliteModel> findBySatNumber(String satNumber);

    public SatelliteModel findSatelliteBySatNumber(String satNumber);
}
