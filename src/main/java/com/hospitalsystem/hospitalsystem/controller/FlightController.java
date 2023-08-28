package com.hospitalsystem.hospitalsystem.controller;

import com.hospitalsystem.hospitalsystem.database.entity.FlightEntity;
import com.hospitalsystem.hospitalsystem.database.repository.FlightEntityRepository;
import com.hospitalsystem.hospitalsystem.database.specification.FlightSpecification;
import com.hospitalsystem.hospitalsystem.mapper.FlightMapper;
import com.hospitalsystem.hospitalsystem.model.FlightDTO;
import com.hospitalsystem.hospitalsystem.model.requestDTO.FlightRequestDTO;
import com.hospitalsystem.hospitalsystem.service.FlightService;
import com.hospitalsystem.hospitalsystem.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("flight")
public class FlightController extends BaseController<
        FlightEntity,
        FlightDTO,
        FlightRequestDTO,
        FlightMapper,
        FlightEntityRepository,
        FlightSpecification,
        FlightService> {

    @Autowired
    FlightService flightService;

    @Override
    protected FlightService getService() {
        return this.flightService;
    }
}