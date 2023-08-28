package com.hospitalsystem.hospitalsystem.service;
 
import com.hospitalsystem.hospitalsystem.database.entity.RoomEntity;
import com.hospitalsystem.hospitalsystem.database.repository.RoomEntityRepository;
import com.hospitalsystem.hospitalsystem.database.specification.RoomSpecification;
import com.hospitalsystem.hospitalsystem.mapper.RoomMapper;
import com.hospitalsystem.hospitalsystem.model.RoomDTO;
import com.hospitalsystem.hospitalsystem.model.requestDTO.RoomRequestDTO;
import com.hospitalsystem.hospitalsystem.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService extends BaseService<RoomEntity, RoomDTO, RoomRequestDTO,
        RoomMapper, RoomEntityRepository, RoomSpecification> {

    @Autowired
    RoomEntityRepository roomEntityRepository;

    @Autowired
    RoomMapper roomMapper;


    @Autowired
    RoomSpecification roomSpecification;

    @Override
    protected RoomMapper getMapper() {
        return this.roomMapper;
    }

    @Override
    protected RoomEntityRepository getRepository() {
        return this.roomEntityRepository;
    }

    @Override
    protected RoomSpecification getSpecification() {
        return roomSpecification;
    }

    public RoomEntity getRoom(int number){
        return roomEntityRepository.findRoomEntityByRoomNumber(number);
    }

}
