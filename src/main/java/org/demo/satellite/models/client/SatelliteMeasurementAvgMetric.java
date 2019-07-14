package org.demo.satellite.models.client;

import java.math.BigDecimal;

/**
 * Standard access for measurement average metric
 * @author Jarrod Sears
 *
 */
public interface SatelliteMeasurementAvgMetric
{
    String getSatelliteName();
    BigDecimal getAvgMetric();
}
