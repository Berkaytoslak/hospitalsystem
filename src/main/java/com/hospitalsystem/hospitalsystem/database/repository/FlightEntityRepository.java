package com.hospitalsystem.hospitalsystem.database.repository;

import com.hospitalsystem.hospitalsystem.database.entity.FlightEntity;
import com.hospitalsystem.hospitalsystem.util.BaseRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface FlightEntityRepository extends BaseRepository<FlightEntity> {
    FlightEntity findFlightEntitiesByDepartureCityAndArrivalCity(String departureCity,String arrivalCity);

}
