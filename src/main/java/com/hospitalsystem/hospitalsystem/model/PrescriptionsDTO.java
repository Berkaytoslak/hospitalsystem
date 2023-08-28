package com.hospitalsystem.hospitalsystem.model;

import com.hospitalsystem.hospitalsystem.util.BaseDTO;
import lombok.Data;

@Data
public class PrescriptionsDTO extends BaseDTO {

    private Long reservationId;
    private Long patientId;
    private String medicine;
    private String description;

}
