package com.hospitalsystem.hospitalsystem.controller;

import com.hospitalsystem.hospitalsystem.database.entity.DoctorEntity;
import com.hospitalsystem.hospitalsystem.database.repository.DoctorEntityRepository;
import com.hospitalsystem.hospitalsystem.database.specification.DoctorSpecification;
import com.hospitalsystem.hospitalsystem.mapper.DoctorMapper;
import com.hospitalsystem.hospitalsystem.model.DoctorDTO;
import com.hospitalsystem.hospitalsystem.model.requestDTO.DoctorRequestDTO;
import com.hospitalsystem.hospitalsystem.service.DoctorService;
import com.hospitalsystem.hospitalsystem.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doctor")
public class DoctorController extends BaseController<
        DoctorEntity,
        DoctorDTO,
        DoctorRequestDTO,
        DoctorMapper,
        DoctorEntityRepository,
        DoctorSpecification,
        DoctorService> {

    @Autowired
    DoctorService doctorService;

    @Override
    protected DoctorService getService() {
        return this.doctorService;
    }

    @PostMapping("add-hospital")
    public ResponseEntity<DoctorDTO> addOtherRelations(@RequestBody DoctorRequestDTO doctorRequestDTO){
        return new ResponseEntity<>(doctorService.save(doctorRequestDTO), HttpStatus.OK);

    }
}