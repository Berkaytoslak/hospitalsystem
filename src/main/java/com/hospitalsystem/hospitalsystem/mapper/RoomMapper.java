package com.hospitalsystem.hospitalsystem.mapper;

import com.hospitalsystem.hospitalsystem.database.entity.HospitalEntity;
import com.hospitalsystem.hospitalsystem.database.entity.HotelEntity;
import com.hospitalsystem.hospitalsystem.database.entity.RoomEntity;
import com.hospitalsystem.hospitalsystem.model.PageDTO;
import com.hospitalsystem.hospitalsystem.model.RoomDTO;
import com.hospitalsystem.hospitalsystem.model.requestDTO.RoomRequestDTO;
import com.hospitalsystem.hospitalsystem.service.HotelService;
import com.hospitalsystem.hospitalsystem.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoomMapper implements IBaseMapper<RoomDTO, RoomEntity, RoomRequestDTO> {

    @Autowired
    HotelService hotelService;
    @Autowired
    HotelMapper hotelMapper;

    @Override
    public RoomDTO entityToDTO(RoomEntity entity) {
        RoomDTO dto = new RoomDTO();
        dto.setRoomNumber(entity.getRoomNumber());
        dto.setCapacity(entity.getCapacity());
        dto.setIsAvailable(entity.getIsAvailable());
        dto.setPrice(entity.getPrice());
        dto.setEntryDate(entity.getEntryDate());
        dto.setExitDate(entity.getExitDate());

        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        return dto;
    }

    @Override
    public RoomEntity dtoToEntity(RoomDTO dto) {
        RoomEntity entity = new  RoomEntity();
        entity.setRoomNumber(dto.getRoomNumber());
        entity.setCapacity(dto.getCapacity());
        entity.setIsAvailable(dto.getIsAvailable());
        entity.setPrice(dto.getPrice());
        entity.setEntryDate(dto.getEntryDate());
        entity.setExitDate(dto.getExitDate());

        if (dto.getHotel() != null){
            HotelEntity hotelEntity = hotelService.getHotel(dto.getHotel().getName());
            entity.setHotel(hotelEntity);
        }
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        return entity;
    }

    @Override
    public List<RoomDTO> entityListToDTOList(List<RoomEntity> roomEntities) {
        List<RoomDTO> dtoList = new ArrayList<>();
        for (RoomEntity entity :roomEntities) {
            RoomDTO dto = entityToDTO(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public List<RoomEntity> dtoListTOEntityList(List<RoomDTO>roomDTOS) {
        List< RoomEntity> entityList = new ArrayList<>();
        for (RoomDTO dto :roomDTOS) {
            RoomEntity entity = dtoToEntity(dto);
            entityList.add(entity);
        }

        return entityList;
    }

    @Override
    public RoomEntity requestDTOToEntity(RoomRequestDTO dto) {
        RoomEntity entity = new RoomEntity();
        entity.setRoomNumber(dto.getRoomNumber());
        entity.setCapacity(dto.getCapacity());
        entity.setIsAvailable(dto.getIsAvailable());
        entity.setPrice(dto.getPrice());
        entity.setEntryDate(dto.getEntryDate());
        entity.setExitDate(dto.getExitDate());
        if (dto.getHotel() != null){
            HotelEntity hotelEntity = hotelService.getHotel(dto.getHotel().getName());
            entity.setHotel(hotelEntity);
        }
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        return entity;
    }

    @Override
    public List<RoomEntity> requestDtoListTOEntityList(List<RoomRequestDTO>roomRequestDTOS) {
        return null;
    }

    @Override
    public RoomEntity requestDtoToExistEntity(RoomEntity entity, RoomRequestDTO roomRequestDTO) {
        roomRequestDTO.setRoomNumber(entity.getRoomNumber());
        roomRequestDTO.setCapacity(entity.getCapacity());
        roomRequestDTO.setIsAvailable(entity.getIsAvailable());
        roomRequestDTO.setPrice(entity.getPrice());
        entity.setEntryDate(roomRequestDTO.getEntryDate());
        entity.setExitDate(roomRequestDTO.getExitDate());
        return entity;
    }

    @Override
    public PageDTO<RoomDTO> pageEntityToPageDTO(Page<RoomEntity> entityPage) {
        PageDTO<RoomDTO> dtoPage = new PageDTO<>();
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
