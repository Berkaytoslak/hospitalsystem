package com.hospitalsystem.hospitalsystem.mapper;

import com.hospitalsystem.hospitalsystem.database.entity.ReservationEntity;
import com.hospitalsystem.hospitalsystem.model.PageDTO;
import com.hospitalsystem.hospitalsystem.model.ReservationDTO;
import com.hospitalsystem.hospitalsystem.model.requestDTO.ReservationRequestDTO;
import com.hospitalsystem.hospitalsystem.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReservationMapper implements IBaseMapper<ReservationDTO, ReservationEntity, ReservationRequestDTO> {


    @Override
    public ReservationDTO entityToDTO(ReservationEntity entity) {
        ReservationDTO dto = new ReservationDTO();
        dto.setHospitalId(entity.getHospitalId());
        dto.setDoctorId(entity.getDoctorId());
        dto.setFlightId(entity.getFlightId());
        dto.setHotelId(entity.getHotelId());
        dto.setAppointmentDate(entity.getAppointmentDate());

        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        return dto;
    }

    @Override
    public ReservationEntity dtoToEntity(ReservationDTO dto) {
        ReservationEntity entity = new ReservationEntity();
        entity.setHospitalId(dto.getHospitalId());
        entity.setDoctorId(dto.getDoctorId());
        entity.setFlightId(dto.getFlightId());
        entity.setHotelId(dto.getHotelId());
        entity.setAppointmentDate(dto.getAppointmentDate());

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        return entity;
    }

    @Override
    public List<ReservationDTO> entityListToDTOList(List<ReservationEntity> reservationEntities) {
        List<ReservationDTO> dtoList = new ArrayList<>();
        for (ReservationEntity entity : reservationEntities) {
            ReservationDTO dto = entityToDTO(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public List<ReservationEntity> dtoListTOEntityList(List<ReservationDTO> reservationDTOS) {
        List<ReservationEntity> entityList = new ArrayList<>();
        for (ReservationDTO dto : reservationDTOS) {
            ReservationEntity entity = dtoToEntity(dto);
            entityList.add(entity);
        }

        return entityList;
    }

    @Override
    public ReservationEntity requestDTOToEntity(ReservationRequestDTO dto) {
        ReservationEntity entity = new ReservationEntity();
        entity.setHospitalId(dto.getHospitalId());
        entity.setDoctorId(dto.getDoctorId());
        entity.setFlightId(dto.getFlightId());
        entity.setHotelId(dto.getHotelId());
        entity.setAppointmentDate(dto.getAppointmentDate());

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        return entity;
    }

    @Override
    public List<ReservationEntity> requestDtoListTOEntityList(List<ReservationRequestDTO> reservationRequestDTOS) {
        return null;
    }

    @Override
    public ReservationEntity requestDtoToExistEntity(ReservationEntity entity, ReservationRequestDTO reservationRequestDTO) {
        entity.setHospitalId(reservationRequestDTO.getHospitalId());
        entity.setDoctorId(reservationRequestDTO.getDoctorId());
        entity.setFlightId(reservationRequestDTO.getFlightId());
        entity.setHotelId(reservationRequestDTO.getHotelId());
        entity.setAppointmentDate(reservationRequestDTO.getAppointmentDate());
        return entity;
    }

    @Override
    public PageDTO<ReservationDTO> pageEntityToPageDTO(Page<ReservationEntity> entityPage) {
        PageDTO<ReservationDTO> dtoPage = new PageDTO<>();
        dtoPage.setTotalPages(entityPage.getTotalPages());
        dtoPage.setTotalElements(entityPage.getTotalElements());
        dtoPage.setSort(entityPage.getSort());
        dtoPage.setSize(entityPage.getSize());
        dtoPage.setNumber(entityPage.getNumber());
        dtoPage.setContent(entityListToDTOList(entityPage.getContent()));
        dtoPage.setHasContent(entityPage.hasContent());

        return dtoPage;
    }
}
