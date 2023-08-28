package com.hospitalsystem.hospitalsystem.model;

import com.hospitalsystem.hospitalsystem.database.entity.RoomEntity;
import com.hospitalsystem.hospitalsystem.util.BaseDTO;
import lombok.Data;

import java.util.Set;

@Data
public class HotelDTO extends BaseDTO {
    private String name;
    private String city;
    private String address;
    private Set<RoomEntity> rooms;
}
