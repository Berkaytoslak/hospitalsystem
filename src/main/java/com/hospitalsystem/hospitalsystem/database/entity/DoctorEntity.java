package com.hospitalsystem.hospitalsystem.database.entity;

import com.hospitalsystem.hospitalsystem.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name", "surname"}))
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "doctor_uuid"
        )
)
@Data
public class DoctorEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private int birthYear;

    @Column
    private String category;

    @Column(unique = true)
    private String mail;

    @ManyToOne(fetch = FetchType.EAGER)
    private HospitalEntity hospital;


}
