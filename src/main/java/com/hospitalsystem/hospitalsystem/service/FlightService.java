package com.hospitalsystem.hospitalsystem.service;

import com.hospitalsystem.hospitalsystem.database.entity.FlightEntity;
import com.hospitalsystem.hospitalsystem.database.repository.FlightEntityRepository;
import com.hospitalsystem.hospitalsystem.database.specification.FlightSpecification;
import com.hospitalsystem.hospitalsystem.mapper.FlightMapper;
import com.hospitalsystem.hospitalsystem.model.FlightDTO;
import com.hospitalsystem.hospitalsystem.model.requestDTO.FlightRequestDTO;
import com.hospitalsystem.hospitalsystem.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FlightService extends BaseService<FlightEntity, FlightDTO, FlightRequestDTO,
        FlightMapper, FlightEntityRepository, FlightSpecification> {

    @Autowired
    FlightEntityRepository flightEntityRepository;

    @Autowired
    FlightMapper flightMapper;


    @Autowired
    FlightSpecification flightSpecification;

    @Override
    protected FlightMapper getMapper() {
        return this.flightMapper;
    }

    @Override
    protected FlightEntityRepository getRepository() {
        return this.flightEntityRepository;
    }

    @Override
    protected FlightSpecification getSpecification() {
        return flightSpecification;
    }

    public FlightEntity getFlight(String departureCity, String arrivalCity){
        return flightEntityRepository.findFlightEntitiesByDepartureCityAndArrivalCity(departureCity, arrivalCity);
    }

}
