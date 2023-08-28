package com.hospitalsystem.hospitalsystem.service;

import com.hospitalsystem.hospitalsystem.database.entity.DoctorEntity;
import com.hospitalsystem.hospitalsystem.database.repository.DoctorEntityRepository;
import com.hospitalsystem.hospitalsystem.database.specification.DoctorSpecification;
import com.hospitalsystem.hospitalsystem.mapper.DoctorMapper;
import com.hospitalsystem.hospitalsystem.model.DoctorDTO;
import com.hospitalsystem.hospitalsystem.model.requestDTO.DoctorRequestDTO;
import com.hospitalsystem.hospitalsystem.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService extends
        BaseService<DoctorEntity, DoctorDTO, DoctorRequestDTO, DoctorMapper, DoctorEntityRepository, DoctorSpecification> {

    @Autowired
    DoctorEntityRepository doctorEntityRepository;

    @Autowired
    DoctorMapper doctorMapper;

    @Override
    protected DoctorMapper getMapper() {
        return this.doctorMapper;
    }

    @Override
    protected DoctorEntityRepository getRepository() {
        return this.doctorEntityRepository;
    }

    @Override
    protected DoctorSpecification getSpecification() {
        return null;
    }

    public List<DoctorEntity> getPatientNameStartWith(String key) {
        return doctorEntityRepository.findAllByNameStartingWith(key);
    }

    public List<DoctorEntity> getPatientNameIContains(String key) {
        return doctorEntityRepository.findAllByNameContainsIgnoreCase(key);
    }


    public List<DoctorEntity> getPatientNameStartWithAndSurnameStartWith(String name, String surname) {
        return doctorEntityRepository.findAllByNameStartingWithOrSurnameStartingWith(name, surname);
    }

    public DoctorEntity getDoctor(String name, String surname){
        return doctorEntityRepository.findDoctorEntitiesByNameAndSurname(name,surname);
    }

}
