package org.demo.satellite.models.db;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Data projection specifically for satellites that record Earth altitude
 * @author Jarrod Sears
 *
 */
public interface SatelliteMeasurementEarthAltitudeProjection
{
    Date getTimestamp();
    Long getSatelliteId();
    String getSatelliteName();
    BigDecimal getEarthAltitude();
}
