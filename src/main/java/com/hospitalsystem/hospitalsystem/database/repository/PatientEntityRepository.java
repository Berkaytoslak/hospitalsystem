package com.hospitalsystem.hospitalsystem.database.repository;

import com.hospitalsystem.hospitalsystem.database.entity.PatientEntity;
import com.hospitalsystem.hospitalsystem.util.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientEntityRepository extends BaseRepository<PatientEntity> {
    List<PatientEntity> findAllByNameStartingWith(String key);

    List<PatientEntity> findAllByNameContainsIgnoreCase(String key);

    List<PatientEntity> findAllByNameStartingWithOrSurnameStartingWith(String name, String surname);

    PatientEntity findPatientEntitiesByTc(String tc);

}
