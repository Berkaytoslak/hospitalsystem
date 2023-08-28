package com.hospitalsystem.hospitalsystem.service;

import com.hospitalsystem.hospitalsystem.database.entity.HotelEntity;
import com.hospitalsystem.hospitalsystem.database.repository.HotelEntityRepository;
import com.hospitalsystem.hospitalsystem.database.specification.HotelSpecification;
import com.hospitalsystem.hospitalsystem.mapper.HotelMapper;
import com.hospitalsystem.hospitalsystem.model.HotelDTO;
import com.hospitalsystem.hospitalsystem.model.requestDTO.HotelRequestDTO;
import com.hospitalsystem.hospitalsystem.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService extends BaseService<HotelEntity, HotelDTO, HotelRequestDTO,
        HotelMapper, HotelEntityRepository, HotelSpecification> {

    @Autowired
    HotelEntityRepository hotelEntityRepository;

    @Autowired
    HotelMapper hotelMapper;


    @Autowired
    HotelSpecification hotelSpecification;

    @Override
    protected HotelMapper getMapper() {
        return this.hotelMapper;
    }

    @Override
    protected HotelEntityRepository getRepository() {
        return this.hotelEntityRepository;
    }

    @Override
    protected HotelSpecification getSpecification() {
        return hotelSpecification;
    }

    public HotelEntity getHotel(String name) {
        return hotelEntityRepository.findHotelEntitiesByName(name);
    }
}
