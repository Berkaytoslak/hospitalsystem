package com.hospitalsystem.hospitalsystem.mapper;

import com.hospitalsystem.hospitalsystem.database.entity.HotelEntity;
import com.hospitalsystem.hospitalsystem.model.HotelDTO;
import com.hospitalsystem.hospitalsystem.model.PageDTO;
import com.hospitalsystem.hospitalsystem.model.requestDTO.HotelRequestDTO;
import com.hospitalsystem.hospitalsystem.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HotelMapper implements IBaseMapper<HotelDTO, HotelEntity, HotelRequestDTO> {


    @Override
    public HotelDTO entityToDTO(HotelEntity entity) {
        HotelDTO dto = new HotelDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCity(entity.getCity());
        dto.setAddress(entity.getAddress());

        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        return dto;
    }

    @Override
    public HotelEntity dtoToEntity(HotelDTO dto) {
        HotelEntity entity = new HotelEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCity(dto.getCity());
        entity.setAddress(dto.getAddress());

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        return entity;
    }

    @Override
    public List<HotelDTO> entityListToDTOList(List<HotelEntity> hotelEntities) {
        List<HotelDTO> dtoList = new ArrayList<>();
        for (HotelEntity entity : hotelEntities) {
            HotelDTO dto = entityToDTO(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public List<HotelEntity> dtoListTOEntityList(List<HotelDTO> hotelDTOS) {
        List<HotelEntity> entityList = new ArrayList<>();
        for (HotelDTO dto : hotelDTOS) {
            HotelEntity entity = dtoToEntity(dto);
            entityList.add(entity);
        }

        return entityList;
    }

    @Override
    public HotelEntity requestDTOToEntity(HotelRequestDTO dto) {
        HotelEntity entity = new HotelEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCity(dto.getCity());
        entity.setAddress(dto.getAddress());

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        return entity;
    }

    @Override
    public List<HotelEntity> requestDtoListTOEntityList(List<HotelRequestDTO> hotelRequestDTOS) {
        return null;
    }

    @Override
    public HotelEntity requestDtoToExistEntity(HotelEntity entity, HotelRequestDTO hotelRequestDTO) {
        entity.setId(hotelRequestDTO.getId());
        entity.setName(hotelRequestDTO.getName());
        entity.setCity(hotelRequestDTO.getCity());
        entity.setAddress(hotelRequestDTO.getAddress());
        return entity;
    }

    @Override
    public PageDTO<HotelDTO> pageEntityToPageDTO(Page<HotelEntity> entityPage) {
        PageDTO<HotelDTO> dtoPage = new PageDTO<>();
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
