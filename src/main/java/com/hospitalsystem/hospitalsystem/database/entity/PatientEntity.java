package com.hospitalsystem.hospitalsystem.database.entity;

import com.hospitalsystem.hospitalsystem.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "patient_uuid"
        )
)
@Data
public class PatientEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private int birthYear;

    @Column(unique = true)
    private String tc;

    @Column(unique = true)
    private String mail;


}
