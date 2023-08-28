package com.hospitalsystem.hospitalsystem.model;

import com.hospitalsystem.hospitalsystem.database.entity.HotelEntity;
import com.hospitalsystem.hospitalsystem.util.BaseDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RoomDTO extends BaseDTO {
    private int roomNumber;
    private int capacity;
    private Boolean isAvailable;
    private double price;
    private LocalDate entryDate;
    private LocalDate exitDate;
    private HotelEntity hotel;
}
