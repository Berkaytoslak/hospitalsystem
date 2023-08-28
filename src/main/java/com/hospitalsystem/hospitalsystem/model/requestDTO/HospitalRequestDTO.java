package com.hospitalsystem.hospitalsystem.model.requestDTO;

import com.hospitalsystem.hospitalsystem.util.BaseDTO;
import lombok.Data;

@Data
public class HospitalRequestDTO extends BaseDTO {

    private String name;
    private String city;
    private String category;

}
