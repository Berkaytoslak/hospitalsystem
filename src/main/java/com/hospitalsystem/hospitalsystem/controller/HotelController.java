package com.hospitalsystem.hospitalsystem.controller;

import com.hospitalsystem.hospitalsystem.database.entity.HotelEntity;
import com.hospitalsystem.hospitalsystem.database.repository.HotelEntityRepository;
import com.hospitalsystem.hospitalsystem.database.specification.HotelSpecification;
import com.hospitalsystem.hospitalsystem.mapper.HotelMapper;
import com.hospitalsystem.hospitalsystem.model.HotelDTO;
import com.hospitalsystem.hospitalsystem.model.requestDTO.HotelRequestDTO;
import com.hospitalsystem.hospitalsystem.service.HotelService;
import com.hospitalsystem.hospitalsystem.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hotel")
public class HotelController extends BaseController<
        HotelEntity,
        HotelDTO,
        HotelRequestDTO,
        HotelMapper,
        HotelEntityRepository,
        HotelSpecification,
        HotelService> {

    @Autowired
    HotelService hotelService;

    @Override
    protected HotelService getService() {
        return this.hotelService;
    }
}