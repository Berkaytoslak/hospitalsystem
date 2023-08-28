package com.hospitalsystem.hospitalsystem.mapper;

import com.hospitalsystem.hospitalsystem.database.entity.PrescriptionsEntity;
import com.hospitalsystem.hospitalsystem.model.PageDTO;
import com.hospitalsystem.hospitalsystem.model.PrescriptionsDTO;
import com.hospitalsystem.hospitalsystem.model.requestDTO.PrescriptionsRequestDTO;
import com.hospitalsystem.hospitalsystem.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PrescriptionsMapper implements IBaseMapper<PrescriptionsDTO, PrescriptionsEntity, PrescriptionsRequestDTO> {


    @Override
    public PrescriptionsDTO entityToDTO(PrescriptionsEntity entity) {
        PrescriptionsDTO dto = new PrescriptionsDTO();
        dto.setReservationId(entity.getReservationId());
        dto.setPatientId(entity.getPatientId());
        dto.setMedicine(entity.getMedicine());
        dto.setDescription(entity.getDescription());

        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        return dto;
    }

    @Override
    public PrescriptionsEntity dtoToEntity(PrescriptionsDTO dto) {
        PrescriptionsEntity entity = new PrescriptionsEntity();
        entity.setReservationId(dto.getReservationId());
        entity.setPatientId(dto.getPatientId());
        entity.setMedicine(dto.getMedicine());
        entity.setDescription(dto.getDescription());

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        return entity;
    }

    @Override
    public List<PrescriptionsDTO> entityListToDTOList(List<PrescriptionsEntity> prescriptionsEntities) {
        List<PrescriptionsDTO> dtoList = new ArrayList<>();
        for (PrescriptionsEntity entity : prescriptionsEntities) {
            PrescriptionsDTO dto = entityToDTO(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public List<PrescriptionsEntity> dtoListTOEntityList(List<PrescriptionsDTO> prescriptionsDTOS) {
        List<PrescriptionsEntity> entityList = new ArrayList<>();
        for (PrescriptionsDTO dto : prescriptionsDTOS) {
            PrescriptionsEntity entity = dtoToEntity(dto);
            entityList.add(entity);
        }

        return entityList;
    }

    @Override
    public PrescriptionsEntity requestDTOToEntity(PrescriptionsRequestDTO dto) {
        PrescriptionsEntity entity = new PrescriptionsEntity();
        entity.setReservationId(dto.getReservationId());
        entity.setPatientId(dto.getPatientId());
        entity.setMedicine(dto.getMedicine());
        entity.setDescription(dto.getDescription());

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        return entity;
    }

    @Override
    public List<PrescriptionsEntity> requestDtoListTOEntityList(List<PrescriptionsRequestDTO> prescriptionsRequestDTOS) {
        return null;
    }

    @Override
    public PrescriptionsEntity requestDtoToExistEntity(PrescriptionsEntity entity, PrescriptionsRequestDTO prescriptionsRequestDTO) {
        entity.setReservationId(prescriptionsRequestDTO.getReservationId());
        entity.setPatientId(prescriptionsRequestDTO.getPatientId());
        entity.setMedicine(prescriptionsRequestDTO.getMedicine());
        entity.setDescription(prescriptionsRequestDTO.getDescription());
        return entity;
    }

    @Override
    public PageDTO<PrescriptionsDTO> pageEntityToPageDTO(Page<PrescriptionsEntity> entityPage) {
        PageDTO<PrescriptionsDTO> dtoPage = new PageDTO<>();
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
