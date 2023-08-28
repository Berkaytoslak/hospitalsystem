package com.hospitalsystem.hospitalsystem.database.repository;

import com.hospitalsystem.hospitalsystem.database.entity.ReservationEntity;
import com.hospitalsystem.hospitalsystem.util.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReservationEntityRepository extends BaseRepository<ReservationEntity> {

    ReservationEntity findReservationEntitiesByUuid(UUID uuid);
    ReservationEntity findReservationEntitiesByCreatedBy(String patient);

}
