package org.demo.satellite.service;

import java.util.ArrayList;
import java.util.Collection;

import org.demo.satellite.models.client.Satellite;
import org.demo.satellite.models.db.SatelliteModel;
import org.demo.satellite.repository.SatelliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Provide Services related to Satellite records
 * 
 * @author Jarrod Sears
 *
 */
@Service
@Transactional
public class SatelliteService
{
    @Autowired
    SatelliteRepository satelliteRepository;
    
    public Collection<Satellite> getAll() 
    {
        return this.modelToClient(this.satelliteRepository.findAll());
    }
    
    public Satellite get(Long id)
    {
        return this.modelToClient(this.satelliteRepository.getOne(id));
    }
    
    private Satellite modelToClient(SatelliteModel model)
    {
        Satellite satellite = new Satellite();
        satellite.setId(model.getId());
        satellite.setName(model.getName());
        satellite.setSatNumber(model.getSatNumber());
        satellite.setSpecificMeasurement(model.getSpecificMeasurement());
        
        return satellite;
    }
    
    private Collection<Satellite> modelToClient(Collection<SatelliteModel> models)
    {
        Collection<Satellite> satellites = new ArrayList<Satellite>();
        
        models.forEach(model -> satellites.add(this.modelToClient(model)));
        
        return satellites;
    }
}
