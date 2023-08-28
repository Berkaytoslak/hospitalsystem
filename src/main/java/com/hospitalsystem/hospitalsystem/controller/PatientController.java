package com.hospitalsystem.hospitalsystem.controller;

import com.hospitalsystem.hospitalsystem.database.entity.PatientEntity;
import com.hospitalsystem.hospitalsystem.database.repository.PatientEntityRepository;
import com.hospitalsystem.hospitalsystem.database.specification.PatientSpecification;
import com.hospitalsystem.hospitalsystem.mapper.PatientMapper;
import com.hospitalsystem.hospitalsystem.model.PatientDTO;
import com.hospitalsystem.hospitalsystem.model.requestDTO.PatientRequestDTO;
import com.hospitalsystem.hospitalsystem.service.PatientService;
import com.hospitalsystem.hospitalsystem.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("patient")
public class PatientController extends BaseController<
        PatientEntity,
        PatientDTO,
        PatientRequestDTO,
        PatientMapper,
        PatientEntityRepository,
        PatientSpecification,
        PatientService> {

    @Autowired
    PatientService patientService;

    @Override
    protected PatientService getService() {
        return this.patientService;
    }
}