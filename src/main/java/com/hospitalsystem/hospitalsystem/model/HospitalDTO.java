package com.hospitalsystem.hospitalsystem.model;

import com.hospitalsystem.hospitalsystem.util.BaseDTO;
import lombok.Data;

@Data
public class HospitalDTO extends BaseDTO {

    private String name;
    private String city;
    private String category;

}
