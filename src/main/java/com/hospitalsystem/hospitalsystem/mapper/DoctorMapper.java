package com.hospitalsystem.hospitalsystem.mapper;

import com.hospitalsystem.hospitalsystem.database.entity.DoctorEntity;
import com.hospitalsystem.hospitalsystem.database.entity.HospitalEntity;
import com.hospitalsystem.hospitalsystem.model.DoctorDTO;
import com.hospitalsystem.hospitalsystem.model.PageDTO;
import com.hospitalsystem.hospitalsystem.model.requestDTO.DoctorRequestDTO;
import com.hospitalsystem.hospitalsystem.service.HospitalService;
import com.hospitalsystem.hospitalsystem.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorMapper implements IBaseMapper<DoctorDTO, DoctorEntity, DoctorRequestDTO> {

    @Autowired
    HospitalMapper hospitalMapper;
    @Autowired
    PatientMapper patientMapper;
    @Autowired
    HospitalService hospitalService;


    @Override
    public DoctorDTO entityToDTO(DoctorEntity entity) {
        DoctorDTO dto = new DoctorDTO();
        dto.setCategory(entity.getCategory());
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
    public DoctorEntity dtoToEntity(DoctorDTO dto) {
        DoctorEntity entity = new DoctorEntity();
        entity.setCategory(dto.getCategory());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setBirthYear(dto.getBirthYear());
        if (dto.getHospitalId() != null){
            HospitalEntity hospitalForDoctor = hospitalService.getHospital(dto.getHospitalId().getName(), dto.getHospitalId().getCity());
            entity.setHospital(hospitalForDoctor);
        }
        entity.setUuid(dto.getUuid());
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());

        return entity;

    }

    @Override
    public List<DoctorDTO> entityListToDTOList(List<DoctorEntity> doctorEntities) {
        List<DoctorDTO> doctorDTOS = new ArrayList<>();
        for (DoctorEntity DoctorEntity : doctorEntities) {
            doctorDTOS.add(entityToDTO(DoctorEntity));
        }
        return doctorDTOS;
    }

    @Override
    public List<DoctorEntity> dtoListTOEntityList(List<DoctorDTO> doctorDTOS) {
        List<DoctorEntity> personEntities = new ArrayList<>();
        for (DoctorDTO DoctorDTO : doctorDTOS) {
            personEntities.add(dtoToEntity(DoctorDTO));
        }
        return personEntities;
    }

    @Override
    public DoctorEntity requestDTOToEntity(DoctorRequestDTO dto) {
        DoctorEntity entity = new DoctorEntity();
        entity.setCategory(dto.getCategory());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setBirthYear(dto.getBirthYear());
        if (dto.getHospitalId() != null){
            HospitalEntity hospitalForDoctor = hospitalService.getHospital(dto.getHospitalId().getName(), dto.getHospitalId().getCity());
            entity.setHospital(hospitalForDoctor);
        }
        entity.setUuid(dto.getUuid());
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setMail(dto.getMail());

        return entity;
    }

    @Override
    public List<DoctorEntity> requestDtoListTOEntityList(List<DoctorRequestDTO> doctorRequestDTOS) {
        return null;
    }

    @Override
    public DoctorEntity requestDtoToExistEntity(DoctorEntity entity, DoctorRequestDTO doctorRequestDTO) {
        entity.setBirthYear(doctorRequestDTO.getBirthYear());
        entity.setCategory(doctorRequestDTO.getCategory());
        entity.setName(doctorRequestDTO.getName());
        entity.setHospital(hospitalMapper.requestDTOToEntity(doctorRequestDTO.getHospitalId()));
        entity.setSurname(doctorRequestDTO.getSurname());
        entity.setMail(doctorRequestDTO.getMail());

        return entity;
    }

    @Override
    public PageDTO<DoctorDTO> pageEntityToPageDTO(Page<DoctorEntity> entityPage) {
        PageDTO<DoctorDTO> dtoPage = new PageDTO<>();
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
