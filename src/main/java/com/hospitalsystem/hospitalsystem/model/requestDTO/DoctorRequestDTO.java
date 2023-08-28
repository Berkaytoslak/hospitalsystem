package com.hospitalsystem.hospitalsystem.model.requestDTO;

import com.hospitalsystem.hospitalsystem.database.entity.PatientEntity;
import com.hospitalsystem.hospitalsystem.model.HospitalDTO;
import com.hospitalsystem.hospitalsystem.util.BaseDTO;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class DoctorRequestDTO extends BaseDTO {

    private String name;
    private String surname;
    private int birthYear;
    private String category;
    private String mail;
    private HospitalRequestDTO hospitalId;


}
