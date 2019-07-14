package org.demo.satellite.models.csv;

import org.demo.satellite.models.db.SatelliteMeasurementModel;

public class VegetationClassificationSatelliteMeasurement extends BaseSatelliteMeasurement
{
    private String vegetationClassification;
    
    @Override
    public void setSpecificMeasurement(String specificMeasurement)
    {
        this.vegetationClassification = specificMeasurement;
    }

    @Override
    public SatelliteMeasurementModel addSpecificMeasurementToConvertedModel(SatelliteMeasurementModel model)
    {
        model.setVegetationClassification(this.vegetationClassification);
        return model;
    }
    
}
