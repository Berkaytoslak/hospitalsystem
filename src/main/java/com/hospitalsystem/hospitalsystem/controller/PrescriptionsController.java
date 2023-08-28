package com.hospitalsystem.hospitalsystem.controller;

import com.hospitalsystem.hospitalsystem.database.entity.PrescriptionsEntity;
import com.hospitalsystem.hospitalsystem.database.repository.PrescriptionsEntityRepository;
import com.hospitalsystem.hospitalsystem.database.specification.PrescriptionsSpecification;
import com.hospitalsystem.hospitalsystem.mapper.PrescriptionsMapper;
import com.hospitalsystem.hospitalsystem.model.PrescriptionsDTO;
import com.hospitalsystem.hospitalsystem.model.requestDTO.PrescriptionsRequestDTO;
import com.hospitalsystem.hospitalsystem.service.PrescriptionsService;
import com.hospitalsystem.hospitalsystem.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("prescriptions")
public class PrescriptionsController extends BaseController<
        PrescriptionsEntity,
        PrescriptionsDTO,
        PrescriptionsRequestDTO,
        PrescriptionsMapper,
        PrescriptionsEntityRepository,
        PrescriptionsSpecification,
        PrescriptionsService> {

    @Autowired
    PrescriptionsService prescriptionsService;

    @Override
    protected PrescriptionsService getService() {
        return this.prescriptionsService;
    }

    @PostMapping("prescriptions-create")
    public ResponseEntity<PrescriptionsEntity> prescriptionsCreate(@RequestBody PrescriptionsRequestDTO prescriptionsRequestDTO,@RequestParam String tc ){
        return new ResponseEntity<>(prescriptionsService.prescriptionsCreate(prescriptionsRequestDTO,tc), HttpStatus.OK);
    }
}