package com.hospitalsystem.hospitalsystem.service;

import com.hospitalsystem.hospitalsystem.database.entity.*;
import com.hospitalsystem.hospitalsystem.database.repository.ReservationEntityRepository;
import com.hospitalsystem.hospitalsystem.database.specification.ReservationSpecification;
import com.hospitalsystem.hospitalsystem.mapper.ReservationMapper;
import com.hospitalsystem.hospitalsystem.model.DoctorDTO;
import com.hospitalsystem.hospitalsystem.model.FlightDTO;
import com.hospitalsystem.hospitalsystem.model.ReservationDTO;
import com.hospitalsystem.hospitalsystem.model.RoomDTO;
import com.hospitalsystem.hospitalsystem.model.requestDTO.ReservationRequestDTO;
import com.hospitalsystem.hospitalsystem.util.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@EnableScheduling
public class ReservationService extends BaseService<ReservationEntity, ReservationDTO, ReservationRequestDTO,
        ReservationMapper, ReservationEntityRepository, ReservationSpecification> {

    @Autowired
    ReservationEntityRepository reservationEntityRepository;
    @Autowired
    HospitalService hospitalService;
    @Autowired
    DoctorService doctorService;
    @Autowired
    FlightService flightService;
    @Autowired
    RoomService roomService;

    @Autowired
    ReservationMapper reservationMapper;

    @Autowired
    ReservationSpecification reservationSpecification;

    @Override
    protected ReservationMapper getMapper() {
        return this.reservationMapper;
    }

    @Override
    protected ReservationEntityRepository getRepository() {
        return this.reservationEntityRepository;
    }

    @Override
    protected ReservationSpecification getSpecification() {
        return reservationSpecification;
    }

    public ReservationEntity getReservation(PatientEntity patientId){
        return reservationEntityRepository.findReservationEntitiesByCreatedBy(patientId.getCreatedBy());
    }

    @Transactional
    public ReservationEntity reservationHospitalAndDoctor(DoctorDTO doctorDTO, LocalDateTime dateTime) {
        ReservationRequestDTO reservationRequestDTO = new ReservationRequestDTO();
        DoctorEntity doctorEntity = doctorService.getDoctor(doctorDTO.getName(), doctorDTO.getSurname());
        if (doctorEntity != null && doctorEntity.getHospital() != null){
            reservationRequestDTO.setDoctorId(doctorEntity.getId());
            HospitalEntity hospital1 = hospitalService.getHospital(doctorDTO.getHospitalId().getName(), doctorDTO.getHospitalId().getCity());
            if (hospital1 != null && doctorEntity.getHospital().getCity().equals(hospital1.getCity())){
                reservationRequestDTO.setHospitalId(hospital1.getId());
                reservationRequestDTO.setAppointmentDate(dateTime);
                ReservationEntity reservationEntity = reservationMapper.requestDTOToEntity(reservationRequestDTO);

                return reservationEntityRepository.save(reservationEntity);
            }

        }

        log.error("Kayıt oluşturulamadı!!!");
        return null;

    }

    @Transactional
    public ReservationEntity reservationFlight(FlightDTO flightDTO, UUID uuid) {
        ReservationEntity reservationEntity = reservationEntityRepository.findReservationEntitiesByUuid(uuid);
        if (reservationEntity != null && reservationEntity.getHospitalId() != null && reservationEntity.getDoctorId() != null && reservationEntity.getFlightId() == null){
            FlightEntity flight = flightService.getFlight(flightDTO.getDepartureCity(), flightDTO.getArrivalCity());
            if (flight != null){
                reservationEntity.setFlightId(flight.getId());
                return reservationEntityRepository.save(reservationEntity);
            }
        }
        return null;
    }

    @Transactional
    public ReservationEntity reservationRoom(RoomDTO roomDTO, UUID uuid) {
        ReservationEntity reservationEntity = reservationEntityRepository.findReservationEntitiesByUuid(uuid);
        boolean isWithinRange = isDateWithinRange(reservationEntity.getAppointmentDate().toLocalDate(), roomDTO.getEntryDate(), roomDTO.getExitDate());
        if (reservationEntity.getHospitalId() != null && reservationEntity.getDoctorId() != null && reservationEntity.getHotelId() == null && !isWithinRange){
            RoomEntity room = roomService.getRoom(roomDTO.getRoomNumber());
            if (room != null && Boolean.TRUE.equals(room.getIsAvailable())){
                reservationEntity.setHotelId(room.getHotel().getId());
                return reservationEntityRepository.save(reservationEntity);
            }
        }
        return null;
    }

    public static boolean isDateWithinRange(LocalDate date, LocalDate startDate, LocalDate endDate) {
        return !date.isBefore(startDate) && !date.isAfter(endDate);
    }

    @Scheduled(fixedRate = 100000)
    public void reservationCheck(){

        List<ReservationEntity> reservationEntities = reservationEntityRepository.findAll();
        for (ReservationEntity reservationEntity : reservationEntities){
            if (reservationEntity.getHotelId() == null && reservationEntity.getFlightId() == null){
                reservationEntityRepository.delete(reservationEntity);
                log.info("Hotel kaydı olmayan rezervasyon silindi");
            }
        }

    }

}
