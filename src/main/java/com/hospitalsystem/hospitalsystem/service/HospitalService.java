package com.hospitalsystem.hospitalsystem.service;

import com.hospitalsystem.hospitalsystem.database.entity.HospitalEntity;
import com.hospitalsystem.hospitalsystem.database.repository.HospitalEntityRepository;
import com.hospitalsystem.hospitalsystem.database.specification.HospitalSpecification;
import com.hospitalsystem.hospitalsystem.mapper.HospitalMapper;
import com.hospitalsystem.hospitalsystem.model.HospitalDTO;
import com.hospitalsystem.hospitalsystem.model.requestDTO.HospitalRequestDTO;
import com.hospitalsystem.hospitalsystem.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService extends
        BaseService<HospitalEntity, HospitalDTO, HospitalRequestDTO, HospitalMapper, HospitalEntityRepository, HospitalSpecification> {

    @Autowired
    HospitalEntityRepository hospitalEntityRepository;

    @Autowired
    HospitalMapper hospitalMapper;

    @Override
    protected HospitalMapper getMapper() {
        return this.hospitalMapper;
    }

    @Override
    protected HospitalEntityRepository getRepository() {
        return this.hospitalEntityRepository;
    }

    @Override
    protected HospitalSpecification getSpecification() {
        return null;
    }

    public List<HospitalEntity> getPatientNameStartWith(String key) {
        return hospitalEntityRepository.findAllByNameStartingWith(key);
    }

    public List<HospitalEntity> getPatientNameIContains(String key) {
        return hospitalEntityRepository.findAllByNameContainsIgnoreCase(key);
    }

    public HospitalEntity getHospital(String name, String city){
        return hospitalEntityRepository.findHospitalEntityByNameAndCity(name, city);
    }

}
