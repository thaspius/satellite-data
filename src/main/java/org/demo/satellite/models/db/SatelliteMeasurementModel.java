package org.demo.satellite.models.db;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "satellite_measurements")
public class SatelliteMeasurementModel
{
    /**
     * ID is an auto-incremented primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    /**
     * Timestamp represents the date and time at which the measurement was taken
     */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "timestamp")
    private Date timestamp;
    
    @NotNull
    @Column(name = "ionosphere_index")
    private Integer ionosphereIndex;
    
    @NotNull
    @Column(name = "ndvi_index")
    private Integer ndviIndex;
    
    @NotNull
    @Column(name = "radiation_index", columnDefinition="Decimal(4,1)" )
    private BigDecimal radiationIndex;
    
    @Column(name = "sea_salinity", columnDefinition="Decimal(3,1)" )
    private BigDecimal seaSalinity;
    
    @Column(name = "earth_altitude", columnDefinition="Decimal(5,1)" )
    private BigDecimal earthAltitude;
    
    @Column(name = "vegetation_classification")
    private String vegetationClassification;
    
    @ManyToOne
    @JoinColumn(name = "satellite_id")
    private SatelliteModel satellite;
    
    public SatelliteMeasurementModel()
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
    
    public Date getTimestamp()
    {
        return timestamp;
    }
    
    public void setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;
    }
    
    public Integer getIonosphereIndex()
    {
        return ionosphereIndex;
    }
    
    public void setIonosphereIndex(Integer ionosphereIndex)
    {
        this.ionosphereIndex = ionosphereIndex;
    }
    
    public Integer getNdviIndex()
    {
        return ndviIndex;
    }
    
    public void setNdviIndex(Integer ndviIndex)
    {
        this.ndviIndex = ndviIndex;
    }
    
    public BigDecimal getRadiationIndex()
    {
        return radiationIndex;
    }
    
    public void setRadiationIndex(BigDecimal radiationIndex)
    {
        this.radiationIndex = radiationIndex;
    }
    
    public BigDecimal getSeaSalinity()
    {
        return seaSalinity;
    }
    
    public void setSeaSalinity(BigDecimal seaSalinity)
    {
        this.seaSalinity = seaSalinity;
    }
    
    public BigDecimal getEarthAltitude()
    {
        return earthAltitude;
    }
    
    public void setEarthAltitude(BigDecimal earthAltitude)
    {
        this.earthAltitude = earthAltitude;
    }
    
    public String getVegetationClassification()
    {
        return vegetationClassification;
    }
    
    public void setVegetationClassification(String vegetationClassification)
    {
        this.vegetationClassification = vegetationClassification;
    }
    
    public SatelliteModel getSatellite()
    {
        return satellite;
    }
    
    public void setSatellite(SatelliteModel satellite)
    {
        this.satellite = satellite;
    }
    
}
