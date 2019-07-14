package org.demo.satellite.models.client;

import java.math.BigDecimal;

public class SatelliteMeasurementVegetationClassification
{
    String satelliteName;
    
    String vegetationClassification;
    
    BigDecimal classificationPercent;
    
    public SatelliteMeasurementVegetationClassification(String satelliteName, String vegetationClassification,
            BigDecimal classificationPercent)
    {
        this.satelliteName = satelliteName;
        this.vegetationClassification = vegetationClassification;
        this.classificationPercent = classificationPercent;
    }
    
    public String getSatelliteName()
    {
        return satelliteName;
    }
    
    public void setSatelliteName(String satelliteName)
    {
        this.satelliteName = satelliteName;
    }
    
    public String getVegetationClassification()
    {
        return vegetationClassification;
    }
    
    public void setVegetationClassification(String vegetationClassification)
    {
        this.vegetationClassification = vegetationClassification;
    }
    
    public BigDecimal getClassificationPercent()
    {
        return classificationPercent;
    }
    
    public void setClassificationPercent(BigDecimal classificationPercent)
    {
        this.classificationPercent = classificationPercent;
    }
    
}
