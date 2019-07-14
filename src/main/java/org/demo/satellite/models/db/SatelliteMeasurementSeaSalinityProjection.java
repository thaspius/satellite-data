package org.demo.satellite.models.db;

import java.math.BigDecimal;
import java.util.Date;

public interface SatelliteMeasurementSeaSalinityProjection
{
    Date getTimestamp();
    Long getSatelliteId();
    String getSatelliteName();
    BigDecimal getSeaSalinity();
}
