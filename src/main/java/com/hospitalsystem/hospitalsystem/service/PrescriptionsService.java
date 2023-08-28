package com.hospitalsystem.hospitalsystem.service;

import com.hospitalsystem.hospitalsystem.database.entity.*;
import com.hospitalsystem.hospitalsystem.database.repository.PrescriptionsEntityRepository;
import com.hospitalsystem.hospitalsystem.database.specification.PrescriptionsSpecification;
import com.hospitalsystem.hospitalsystem.mapper.PatientMapper;
import com.hospitalsystem.hospitalsystem.mapper.PrescriptionsMapper;
import com.hospitalsystem.hospitalsystem.model.PatientDTO;
import com.hospitalsystem.hospitalsystem.model.PrescriptionsDTO;
import com.hospitalsystem.hospitalsystem.model.requestDTO.PatientRequestDTO;
import com.hospitalsystem.hospitalsystem.model.requestDTO.PrescriptionsRequestDTO;
import com.hospitalsystem.hospitalsystem.util.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@EnableScheduling
public class PrescriptionsService extends BaseService<PrescriptionsEntity, PrescriptionsDTO, PrescriptionsRequestDTO,
        PrescriptionsMapper, PrescriptionsEntityRepository, PrescriptionsSpecification> {

    @Autowired
    PrescriptionsEntityRepository prescriptionsEntityRepository;

    @Autowired
    PrescriptionsMapper prescriptionsMapper;
    @Autowired
    PatientMapper patientMapper;
    @Autowired
    PatientService patientService;
    @Autowired
    ReservationService reservationService;
    @Autowired
    DoctorService doctorService;

    @Override
    protected PrescriptionsMapper getMapper() {
        return this.prescriptionsMapper;
    }

    @Override
    protected PrescriptionsEntityRepository getRepository() {
        return this.prescriptionsEntityRepository;
    }

    @Override
    protected PrescriptionsSpecification getSpecification() {
        return null;
    }

    @Transactional
    public PrescriptionsEntity prescriptionsCreate(PrescriptionsRequestDTO prescriptionsRequestDTO,String tc) {
        PrescriptionsDTO prescriptionsDTO = new PrescriptionsDTO();
        PatientEntity patient = patientService.getPatient(tc);
        if (patient != null){
            prescriptionsDTO.setPatientId(patient.getId());
            ReservationEntity reservation = reservationService.getReservation(patient);
            if (reservation != null){
                prescriptionsDTO.setReservationId(reservation.getId());
                prescriptionsDTO.setMedicine(prescriptionsRequestDTO.getMedicine());
                prescriptionsDTO.setDescription(prescriptionsRequestDTO.getDescription());
                PrescriptionsEntity prescriptionsEntity = prescriptionsMapper.dtoToEntity(prescriptionsDTO);
                return prescriptionsEntityRepository.save(prescriptionsEntity);
            }
        }
        return null;
    }
}
