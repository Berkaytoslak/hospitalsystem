package com.hospitalsystem.hospitalsystem.model;

import com.hospitalsystem.hospitalsystem.database.entity.DoctorEntity;
import com.hospitalsystem.hospitalsystem.util.BaseDTO;
import lombok.Data;

import java.util.Set;


@Data
public class PatientDTO extends BaseDTO {

    private String name;
    private String surname;
    private int birthYear;
    private String tc;
    private String mail;

}


