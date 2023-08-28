package com.hospitalsystem.hospitalsystem.service;

import com.hospitalsystem.hospitalsystem.database.entity.PatientEntity;
import com.hospitalsystem.hospitalsystem.database.repository.PatientEntityRepository;
import com.hospitalsystem.hospitalsystem.database.specification.PatientSpecification;
import com.hospitalsystem.hospitalsystem.mapper.PatientMapper;
import com.hospitalsystem.hospitalsystem.model.PatientDTO;
import com.hospitalsystem.hospitalsystem.model.requestDTO.PatientRequestDTO;
import com.hospitalsystem.hospitalsystem.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService extends
        BaseService<PatientEntity, PatientDTO, PatientRequestDTO, PatientMapper, PatientEntityRepository, PatientSpecification> {

    @Autowired
    PatientEntityRepository patientEntityRepository;

    @Autowired
    PatientMapper patientMapper;

    @Override
    protected PatientMapper getMapper() {
        return this.patientMapper;
    }

    @Override
    protected PatientEntityRepository getRepository() {
        return this.patientEntityRepository;
    }

    @Override
    protected PatientSpecification getSpecification() {
        return null;
    }

    public List<PatientEntity> getPatientNameStartWith(String key) {
        return patientEntityRepository.findAllByNameStartingWith(key);
    }

    public List<PatientEntity> getPatientNameIContains(String key) {
        return patientEntityRepository.findAllByNameContainsIgnoreCase(key);
    }


    public List<PatientEntity> getPatientNameStartWithAndSurnameStartWith(String name, String surname) {
        return patientEntityRepository.findAllByNameStartingWithOrSurnameStartingWith(name, surname);
    }

    public PatientEntity getPatient(String tc){
        return patientEntityRepository.findPatientEntitiesByTc(tc);
    }

}
