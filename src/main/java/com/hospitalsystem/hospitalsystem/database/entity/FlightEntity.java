package com.hospitalsystem.hospitalsystem.database.entity;

import com.hospitalsystem.hospitalsystem.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"departureCity", "departureTime"}))
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "flight_uuid"
        )
)
@Data
public class FlightEntity extends BaseEntity {

    @Column
    private String departureCity;
    @Column
    private String arrivalCity;
    @Column
    private LocalDateTime departureTime;
    @Column
    private LocalDateTime arrivalTime;
    @Column
    private String destinationAirport;
    @Column
    private String origin;

}
