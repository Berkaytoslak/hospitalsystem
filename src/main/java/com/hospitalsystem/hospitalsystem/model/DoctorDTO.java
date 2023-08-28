package com.hospitalsystem.hospitalsystem.model;

import com.hospitalsystem.hospitalsystem.database.entity.PatientEntity;
import com.hospitalsystem.hospitalsystem.util.BaseDTO;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Data
public class DoctorDTO extends BaseDTO {

    private String name;
    private String surname;
    private int birthYear;
    private String category;
    private String mail;
    private HospitalDTO hospitalId;

}


