package com.hospitalsystem.hospitalsystem.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hospitalsystem.hospitalsystem.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Table
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "hotel_uuid"
        )
)
@Data
public class HotelEntity extends BaseEntity {

    @Column(unique = true, length = 1250)
    private String name;

    @Column
    private String city;
    @Column
    private String address;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<RoomEntity> rooms;


}
