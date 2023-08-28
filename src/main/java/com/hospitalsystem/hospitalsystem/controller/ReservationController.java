package com.hospitalsystem.hospitalsystem.controller;

import com.hospitalsystem.hospitalsystem.database.entity.ReservationEntity;
import com.hospitalsystem.hospitalsystem.database.repository.ReservationEntityRepository;
import com.hospitalsystem.hospitalsystem.database.specification.ReservationSpecification;
import com.hospitalsystem.hospitalsystem.mapper.ReservationMapper;
import com.hospitalsystem.hospitalsystem.model.DoctorDTO;
import com.hospitalsystem.hospitalsystem.model.FlightDTO;
import com.hospitalsystem.hospitalsystem.model.ReservationDTO;
import com.hospitalsystem.hospitalsystem.model.RoomDTO;
import com.hospitalsystem.hospitalsystem.model.requestDTO.ReservationRequestDTO;
import com.hospitalsystem.hospitalsystem.service.ReservationService;
import com.hospitalsystem.hospitalsystem.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("reservation")
public class ReservationController extends BaseController<
        ReservationEntity,
        ReservationDTO,
        ReservationRequestDTO,
        ReservationMapper,
        ReservationEntityRepository,
        ReservationSpecification,
        ReservationService> {

    @Autowired
    ReservationService reservationService;

    @Override
    protected ReservationService getService() {
        return this.reservationService;
    }

    @PostMapping("reservation-doctor")
    public ResponseEntity<ReservationEntity> reservationHospitalAndDoctor(@RequestBody DoctorDTO doctorDTO, @RequestParam LocalDateTime dateTime){
        return new ResponseEntity<>(reservationService.reservationHospitalAndDoctor(doctorDTO,dateTime), HttpStatus.OK);
    }
    @PostMapping("reservation-flight")
    public ResponseEntity<ReservationEntity> reservationFlight(@RequestBody FlightDTO flightDTO, @RequestParam UUID uuid){
        return new ResponseEntity<>(reservationService.reservationFlight(flightDTO,uuid), HttpStatus.OK);
    }
    @PostMapping("reservation-room")
    public ResponseEntity<ReservationEntity> reservationRoom(@RequestBody RoomDTO roomDTO, @RequestParam UUID uuid){
        return new ResponseEntity<>(reservationService.reservationRoom(roomDTO,uuid), HttpStatus.OK);
    }
}