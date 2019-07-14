package org.demo.satellite.models.client;

public abstract class SatelliteMeasurementBaseAvgMetric
        implements SatelliteMeasurementAvgMetric, Comparable<SatelliteMeasurementBaseAvgMetric>
{
    protected String satelliteName;
    
    public int compareTo(SatelliteMeasurementBaseAvgMetric otherMetric)
    {
        return this.getAvgMetric().compareTo(otherMetric.getAvgMetric());
    }
    
    public String getSatelliteName()
    {
        return satelliteName;
    }
    
    public void setSatelliteName(String satelliteName)
    {
        this.satelliteName = satelliteName;
    }
}
