package com.hospitalsystem.hospitalsystem.mapper;

import com.hospitalsystem.hospitalsystem.database.entity.FlightEntity;
import com.hospitalsystem.hospitalsystem.model.FlightDTO;
import com.hospitalsystem.hospitalsystem.model.PageDTO;
import com.hospitalsystem.hospitalsystem.model.requestDTO.FlightRequestDTO;
import com.hospitalsystem.hospitalsystem.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlightMapper implements IBaseMapper<FlightDTO, FlightEntity, FlightRequestDTO> {


    @Override
    public FlightDTO entityToDTO(FlightEntity entity) {
        FlightDTO dto = new FlightDTO();
        dto.setId(entity.getId());
        dto.setDepartureCity(entity.getDepartureCity());
        dto.setArrivalCity(entity.getArrivalCity());
        dto.setDepartureTime(entity.getDepartureTime());
        dto.setArrivalTime(entity.getArrivalTime());
        dto.setDestinationAirport(entity.getDestinationAirport());
        dto.setOrigin(entity.getOrigin());

        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        return dto;
    }

    @Override
    public FlightEntity dtoToEntity(FlightDTO dto) {
        FlightEntity entity = new FlightEntity();
        entity.setId(dto.getId());
        entity.setDepartureCity(dto.getDepartureCity());
        entity.setArrivalCity(dto.getArrivalCity());
        entity.setDepartureTime(dto.getDepartureTime());
        entity.setArrivalTime(dto.getArrivalTime());
        entity.setDestinationAirport(dto.getDestinationAirport());
        entity.setOrigin(dto.getOrigin());

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        return entity;
    }

    @Override
    public List<FlightDTO> entityListToDTOList(List<FlightEntity> flightEntities) {
        List<FlightDTO> dtoList = new ArrayList<>();
        for (FlightEntity entity : flightEntities) {
            FlightDTO dto = entityToDTO(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public List<FlightEntity> dtoListTOEntityList(List<FlightDTO> flightDTOS) {
        List<FlightEntity> entityList = new ArrayList<>();
        for (FlightDTO dto : flightDTOS) {
            FlightEntity entity = dtoToEntity(dto);
            entityList.add(entity);
        }

        return entityList;
    }

    @Override
    public FlightEntity requestDTOToEntity(FlightRequestDTO dto) {
        FlightEntity entity = new FlightEntity();
        entity.setId(dto.getId());
        entity.setDepartureCity(dto.getDepartureCity());
        entity.setArrivalCity(dto.getArrivalCity());
        entity.setDepartureTime(dto.getDepartureTime());
        entity.setArrivalTime(dto.getArrivalTime());
        entity.setDestinationAirport(dto.getDestinationAirport());
        entity.setOrigin(dto.getOrigin());

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        return entity;
    }

    @Override
    public List<FlightEntity> requestDtoListTOEntityList(List<FlightRequestDTO> flightRequestDTOS) {
        return null;
    }

    @Override
    public FlightEntity requestDtoToExistEntity(FlightEntity entity, FlightRequestDTO flightRequestDTO) {
        entity.setId(flightRequestDTO.getId());
        entity.setDepartureCity(flightRequestDTO.getDepartureCity());
        entity.setArrivalCity(flightRequestDTO.getArrivalCity());
        entity.setDepartureTime(flightRequestDTO.getDepartureTime());
        entity.setArrivalTime(flightRequestDTO.getArrivalTime());
        entity.setDestinationAirport(flightRequestDTO.getDestinationAirport());
        entity.setOrigin(flightRequestDTO.getOrigin());
        return entity;
    }

    @Override
    public PageDTO<FlightDTO> pageEntityToPageDTO(Page<FlightEntity> entityPage) {
        PageDTO<FlightDTO> dtoPage = new PageDTO<>();
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
