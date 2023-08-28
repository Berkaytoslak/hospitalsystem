package com.hospitalsystem.hospitalsystem.database.entity;

import com.hospitalsystem.hospitalsystem.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table
@Data
public class ReservationEntity extends BaseEntity {

    @Column
    private Long hospitalId;
    @Column
    private Long doctorId;
    @Column
    private LocalDateTime appointmentDate;
    @Column
    private Long flightId;
    @Column
    private Long hotelId;


}
