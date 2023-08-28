package com.hospitalsystem.hospitalsystem.database.entity;

import com.hospitalsystem.hospitalsystem.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "hospital_uuid"
        )
)
@Data
public class HospitalEntity extends BaseEntity {

    @Column(unique = true, length = 1250)
    private String name;

    @Column
    private String city;

    @Column
    private String category;

    @OneToMany(mappedBy = "hospital", fetch = FetchType.EAGER)
    private List<DoctorEntity> doctorEntities;



}
