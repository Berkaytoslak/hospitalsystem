package com.hospitalsystem.hospitalsystem.model.requestDTO;

import com.hospitalsystem.hospitalsystem.util.BaseDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationRequestDTO extends BaseDTO {

    private Long hospitalId;
    private Long doctorId;
    private LocalDateTime appointmentDate;
    private Long flightId;
    private Long hotelId;
    private String prescriptions;
}
