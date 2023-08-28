package com.hospitalsystem.hospitalsystem.mapper;

import com.hospitalsystem.hospitalsystem.database.entity.HospitalEntity;
import com.hospitalsystem.hospitalsystem.model.HospitalDTO;
import com.hospitalsystem.hospitalsystem.model.PageDTO;
import com.hospitalsystem.hospitalsystem.model.requestDTO.HospitalRequestDTO;
import com.hospitalsystem.hospitalsystem.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HospitalMapper implements IBaseMapper<HospitalDTO, HospitalEntity, HospitalRequestDTO> {


    @Override
    public HospitalDTO entityToDTO(HospitalEntity entity) {
        HospitalDTO dto = new HospitalDTO();
        dto.setCategory(entity.getCategory());
        dto.setName(entity.getName());
        dto.setCity(entity.getCity());
        dto.setUuid(entity.getUuid());
        dto.setId(entity.getId());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());

        return dto;
    }

    @Override
    public HospitalEntity dtoToEntity(HospitalDTO dto) {
        HospitalEntity entity = new HospitalEntity();
        entity.setCategory(dto.getCategory());
        entity.setName(dto.getName());
        entity.setCity(dto.getCity());
        entity.setUuid(dto.getUuid());
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());

        return entity;

    }

    @Override
    public List<HospitalDTO> entityListToDTOList(List<HospitalEntity> hospitalEntities) {
        List<HospitalDTO> hospitalDTOS = new ArrayList<>();
        for (HospitalEntity HospitalEntity : hospitalEntities) {
            hospitalDTOS.add(entityToDTO(HospitalEntity));
        }
        return hospitalDTOS;
    }

    @Override
    public List<HospitalEntity> dtoListTOEntityList(List<HospitalDTO> hospitalDTOS) {
        List<HospitalEntity> personEntities = new ArrayList<>();
        for (HospitalDTO HospitalDTO : hospitalDTOS) {
            personEntities.add(dtoToEntity(HospitalDTO));
        }
        return personEntities;
    }

    @Override
    public HospitalEntity requestDTOToEntity(HospitalRequestDTO dto) {
        HospitalEntity entity = new HospitalEntity();
        entity.setCategory(dto.getCategory());
        entity.setName(dto.getName());
        entity.setUuid(dto.getUuid());
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setCity(dto.getCity());

        return entity;
    }

    @Override
    public List<HospitalEntity> requestDtoListTOEntityList(List<HospitalRequestDTO> hospitalRequestDTOS) {
        return null;
    }

    @Override
    public HospitalEntity requestDtoToExistEntity(HospitalEntity entity, HospitalRequestDTO hospitalRequestDTO) {
        entity.setCategory(hospitalRequestDTO.getCategory());
        entity.setName(hospitalRequestDTO.getName());
        entity.setCity(hospitalRequestDTO.getCity());
        return entity;
    }

    @Override
    public PageDTO<HospitalDTO> pageEntityToPageDTO(Page<HospitalEntity> entityPage) {
        PageDTO<HospitalDTO> dtoPage = new PageDTO<>();
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
