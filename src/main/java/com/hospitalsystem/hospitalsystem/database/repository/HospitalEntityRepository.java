package com.hospitalsystem.hospitalsystem.database.repository;

import com.hospitalsystem.hospitalsystem.database.entity.HospitalEntity;
import com.hospitalsystem.hospitalsystem.util.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalEntityRepository extends BaseRepository<HospitalEntity> {
    List<HospitalEntity> findAllByNameStartingWith(String key);

    List<HospitalEntity> findAllByNameContainsIgnoreCase(String key);

    HospitalEntity findHospitalEntityByNameAndCity(String name, String city);


}
