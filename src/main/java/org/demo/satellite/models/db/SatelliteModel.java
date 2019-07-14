package org.demo.satellite.models.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "satellites")
public class SatelliteModel
{
    public static final String TYPE_SEA_SALINITY = "Sea salinity";
    public static final String TYPE_VEGETATION_CLASSIFICATION = "Vegetation classification";
    public static final String TYPE_EARTH_ALTITUDE = "Earth altitude";
    
    /**
     * ID is an auto-incremented primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    /**
     * Name is the human readable name of the satellite
     */
    @NotNull
    @Column(name = "name", unique=true)
    private String name;
    
    /**
     * Satellite Number is the satellite identification number
     */
    @NotNull
    @Column(name = "sat_number", unique=true)
    private String satNumber;
    
    /**
     * Specific measurement is the customer measurement provided by this
     * satellite
     */
    @NotNull
    @Column(name = "specific_measurement")
    private String specificMeasurement;
    
    
    public SatelliteModel()
    {
        
    }
    
    public Long getId()
    {
        return this.id;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public String getSatNumber()
    {
        return this.satNumber;
    }
    
    public String getSpecificMeasurement()
    {
        return this.specificMeasurement;
    }
}
