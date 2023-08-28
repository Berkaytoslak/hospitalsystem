package com.hospitalsystem.hospitalsystem.database.entity;

import com.hospitalsystem.hospitalsystem.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "prescriptions_uuid"
        )
)
@Data
public class PrescriptionsEntity extends BaseEntity {

    @Column
    private Long reservationId;

    @Column
    private Long patientId;

    @Column
    private String medicine;

    @Column
    private String description;



}
