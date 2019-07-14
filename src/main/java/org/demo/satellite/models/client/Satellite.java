package org.demo.satellite.models.client;

public class Satellite
{
    private Long id;
    private String name;
    private String satNumber;
    private String specificMeasurement;
    
    public Satellite()
    {
        
    }
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getSatNumber()
    {
        return satNumber;
    }
    
    public void setSatNumber(String satNumber)
    {
        this.satNumber = satNumber;
    }
    
    public String getSpecificMeasurement()
    {
        return specificMeasurement;
    }
    
    public void setSpecificMeasurement(String specificMeasurement)
    {
        this.specificMeasurement = specificMeasurement;
    }
    
}
