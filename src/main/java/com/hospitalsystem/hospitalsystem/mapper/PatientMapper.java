package com.hospitalsystem.hospitalsystem.mapper;

import com.hospitalsystem.hospitalsystem.database.entity.PatientEntity;
import com.hospitalsystem.hospitalsystem.model.PageDTO;
import com.hospitalsystem.hospitalsystem.model.PatientDTO;
import com.hospitalsystem.hospitalsystem.model.requestDTO.PatientRequestDTO;
import com.hospitalsystem.hospitalsystem.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PatientMapper implements IBaseMapper<PatientDTO, PatientEntity, PatientRequestDTO> {


    @Override
    public PatientDTO entityToDTO(PatientEntity entity) {
        PatientDTO dto = new PatientDTO();
        dto.setTc(entity.getTc());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setBirthYear(entity.getBirthYear());
        dto.setUuid(entity.getUuid());
        dto.setId(entity.getId());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setMail(entity.getMail());

        return dto;
    }

    @Override
    public PatientEntity dtoToEntity(PatientDTO dto) {
        PatientEntity entity = new PatientEntity();
        entity.setTc(dto.getTc());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setBirthYear(dto.getBirthYear());
        entity.setUuid(dto.getUuid());
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());

        return entity;

    }

    @Override
    public List<PatientDTO> entityListToDTOList(List<PatientEntity> personEntities) {
        List<PatientDTO> patientDTOS = new ArrayList<>();
        for (PatientEntity PatientEntity : personEntities) {
            patientDTOS.add(entityToDTO(PatientEntity));
        }
        return patientDTOS;
    }

    @Override
    public List<PatientEntity> dtoListTOEntityList(List<PatientDTO> patientDTOS) {
        List<PatientEntity> patientEntities = new ArrayList<>();
        for (PatientDTO PatientDTO : patientDTOS) {
            patientEntities.add(dtoToEntity(PatientDTO));
        }
        return patientEntities;
    }

    @Override
    public PatientEntity requestDTOToEntity(PatientRequestDTO dto) {
        PatientEntity entity = new PatientEntity();
        entity.setTc(dto.getTc());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setBirthYear(dto.getBirthYear());
        entity.setUuid(dto.getUuid());
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setMail(dto.getMail());

        return entity;
    }

    @Override
    public List<PatientEntity> requestDtoListTOEntityList(List<PatientRequestDTO> patientRequestDTOS) {
        return null;
    }

    @Override
    public PatientEntity requestDtoToExistEntity(PatientEntity entity, PatientRequestDTO patientRequestDTO) {
        entity.setBirthYear(patientRequestDTO.getBirthYear());
        entity.setTc(patientRequestDTO.getTc());
        entity.setName(patientRequestDTO.getName());
        entity.setSurname(patientRequestDTO.getSurname());
        entity.setMail(patientRequestDTO.getMail());
        return entity;
    }

    @Override
    public PageDTO<PatientDTO> pageEntityToPageDTO(Page<PatientEntity> entityPage) {
        PageDTO<PatientDTO> dtoPage = new PageDTO<>();
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
