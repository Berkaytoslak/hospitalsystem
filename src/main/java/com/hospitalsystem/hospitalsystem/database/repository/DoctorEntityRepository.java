package com.hospitalsystem.hospitalsystem.database.repository;

import com.hospitalsystem.hospitalsystem.database.entity.DoctorEntity;
import com.hospitalsystem.hospitalsystem.util.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorEntityRepository extends BaseRepository<DoctorEntity> {
    List<DoctorEntity> findAllByNameStartingWith(String key);

    List<DoctorEntity> findAllByNameContainsIgnoreCase(String key);

    List<DoctorEntity> findAllByNameStartingWithOrSurnameStartingWith(String name, String surname);

    DoctorEntity findDoctorEntitiesByNameAndSurname(String name, String surname);

}
