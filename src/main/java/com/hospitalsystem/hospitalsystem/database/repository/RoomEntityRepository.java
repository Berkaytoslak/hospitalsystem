package com.hospitalsystem.hospitalsystem.database.repository;

import com.hospitalsystem.hospitalsystem.database.entity.RoomEntity;
import com.hospitalsystem.hospitalsystem.util.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomEntityRepository extends BaseRepository<RoomEntity> {

    RoomEntity findRoomEntityByRoomNumber(int number);
}
