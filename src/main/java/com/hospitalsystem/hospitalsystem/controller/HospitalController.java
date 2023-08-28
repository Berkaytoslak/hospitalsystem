package com.hospitalsystem.hospitalsystem.controller;

import com.hospitalsystem.hospitalsystem.database.entity.HospitalEntity;
import com.hospitalsystem.hospitalsystem.database.repository.HospitalEntityRepository;
import com.hospitalsystem.hospitalsystem.database.specification.HospitalSpecification;
import com.hospitalsystem.hospitalsystem.mapper.HospitalMapper;
import com.hospitalsystem.hospitalsystem.model.HospitalDTO;
import com.hospitalsystem.hospitalsystem.model.requestDTO.HospitalRequestDTO;
import com.hospitalsystem.hospitalsystem.service.HospitalService;
import com.hospitalsystem.hospitalsystem.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hospital")
public class HospitalController extends BaseController<
        HospitalEntity,
        HospitalDTO,
        HospitalRequestDTO,
        HospitalMapper,
        HospitalEntityRepository,
        HospitalSpecification,
        HospitalService> {

    @Autowired
    HospitalService hospitalService;

    @Override
    protected HospitalService getService() {
        return this.hospitalService;
    }
}