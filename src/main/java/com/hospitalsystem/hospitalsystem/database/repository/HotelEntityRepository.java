package com.hospitalsystem.hospitalsystem.database.repository;

import com.hospitalsystem.hospitalsystem.database.entity.DoctorEntity;
import com.hospitalsystem.hospitalsystem.database.entity.HotelEntity;
import com.hospitalsystem.hospitalsystem.util.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelEntityRepository extends BaseRepository<HotelEntity> {

    HotelEntity findHotelEntitiesByName(String name);

}
