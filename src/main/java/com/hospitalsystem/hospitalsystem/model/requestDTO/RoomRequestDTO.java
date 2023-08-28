package com.hospitalsystem.hospitalsystem.model.requestDTO;

import com.hospitalsystem.hospitalsystem.util.BaseDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RoomRequestDTO extends BaseDTO {

    private int roomNumber;
    private int capacity;
    private Boolean isAvailable;
    private double price;
    private LocalDate entryDate;
    private LocalDate exitDate;
    private HotelRequestDTO hotel;
}
