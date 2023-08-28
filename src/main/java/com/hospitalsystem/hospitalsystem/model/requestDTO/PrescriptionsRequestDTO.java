package com.hospitalsystem.hospitalsystem.model.requestDTO;

import com.hospitalsystem.hospitalsystem.util.BaseDTO;
import lombok.Data;

@Data
public class PrescriptionsRequestDTO extends BaseDTO {

    private Long reservationId;
    private Long patientId;
    private String medicine;
    private String description;

}
