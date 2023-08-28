package com.hospitalsystem.hospitalsystem.database.entity;

import com.hospitalsystem.hospitalsystem.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "room_uuid"
        )
)
@Data
public class RoomEntity extends BaseEntity {

    @Column(unique = true)
    private int roomNumber;
    @Column
    private int capacity;
    @Column
    private Boolean isAvailable;
    @Column
    private double price;
    @Column
    private LocalDate entryDate;
    @Column
    private LocalDate exitDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private HotelEntity hotel;
}
