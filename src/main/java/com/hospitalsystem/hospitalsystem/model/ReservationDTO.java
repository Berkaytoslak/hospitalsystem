package com.hospitalsystem.hospitalsystem.model;

import com.hospitalsystem.hospitalsystem.util.BaseDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationDTO extends BaseDTO {

    private Long hospitalId;
    private Long doctorId;
    private LocalDateTime appointmentDate;
    private Long flightId;
    private Long hotelId;
    private String prescriptions;

}
