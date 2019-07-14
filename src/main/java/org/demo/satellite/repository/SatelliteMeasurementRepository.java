package org.demo.satellite.repository;

import java.util.List;

import org.demo.satellite.models.db.SatelliteMeasurementCommonMetricsProjection;
import org.demo.satellite.models.db.SatelliteMeasurementModel;
import org.demo.satellite.models.db.SatelliteMeasurementTimeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Interface to backing Database for Satellite Measurement data
 * @author Jarrod Sears
 *
 */
@Repository
public interface SatelliteMeasurementRepository extends JpaRepository<SatelliteMeasurementModel, Long>
{
    /**
     * Get common metric aggregate values from satellite measurements
     * @return
     */
    @Query(nativeQuery = true, value=" " + 
            "SELECT " + 
            "    MIN(ionosphere_index) as MinIonosphereIndex, " + 
            "    MAX(ionosphere_index) as MaxIonosphereIndex, " + 
            "    AVG(ionosphere_index) as AvgIonosphereIndex, " + 
            "    MIN(ndvi_index) as MinNdviIndex, " + 
            "    MAX(ndvi_index) as MaxNdviIndex, " + 
            "    AVG(ndvi_index) as AvgNdviIndex, " + 
            "    MIN(radiation_index) as MinRadiationIndex, " + 
            "    MAX(radiation_index) as MaxRadiationIndex, " + 
            "    AVG(radiation_index) as AvgRadiationIndex, " + 
            "    satellite_id as SatelliteId, " + 
            "    s.name as SatelliteName " + 
            "FROM " + 
            "    satellite_measurements sm, " + 
            "    satellites s  " + 
            "WHERE  " + 
            "    sm.satellite_id = s.id  " + 
            "GROUP BY " + 
            "    sm.satellite_id, " + 
            "    s.name")
    List<SatelliteMeasurementCommonMetricsProjection> findSatelliteMeasurementCommonMetrics();
    
    /**
     * Get Time in minutes that each satellite was over the target area
     * @return
     */
    @Query(nativeQuery = true, value =
            "SELECT " + 
            "    f.satellite_id as SatelliteId, " + 
            "    s.name as SatelliteName, " + 
            "    TIMESTAMPDIFF(MINUTE,f.firstTimestamp,l.lastTimestamp) as TimeInMinutes " + 
            "FROM " + 
            "    ( " + 
            "        SELECT  " + 
            "            MIN(timestamp) as firstTimestamp, " + 
            "            satellite_id  " + 
            "        FROM  " + 
            "            satellite_measurements " + 
            "        GROUP BY " + 
            "            satellite_id  " + 
            "    ) f, " + 
            "    ( " + 
            "        SELECT  " + 
            "            MAX(timestamp) as lastTimestamp, " + 
            "            satellite_id  " + 
            "        FROM  " + 
            "            satellite_measurements " + 
            "        GROUP BY " + 
            "            satellite_id  " + 
            "    ) l, " + 
            "    satellites s " + 
            "WHERE " + 
            "    f.satellite_id = l.satellite_id AND " + 
            "    s.id = f.satellite_id")
    List<SatelliteMeasurementTimeProjection> findSatelliteMeasurementTime();
}
