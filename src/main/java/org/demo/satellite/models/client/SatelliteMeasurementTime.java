package org.demo.satellite.models.client;


public class SatelliteMeasurementTime
{
    private String satelliteName;
    private Long timeInMinutes;
    
    public SatelliteMeasurementTime(String satelliteName, Long timeInMinutes)
    {
        this.satelliteName = satelliteName;
        this.timeInMinutes = timeInMinutes;
    }
    public String getSatelliteName()
    {
        return satelliteName;
    }
    public void setSatelliteName(String satelliteName)
    {
        this.satelliteName = satelliteName;
    }
    public Long getTimeInMinutes()
    {
        return timeInMinutes;
    }
    public void setTimeInMinutes(Long timeInMinutes)
    {
        this.timeInMinutes = timeInMinutes;
    }
}
