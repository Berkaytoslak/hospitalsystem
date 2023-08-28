package com.hospitalsystem.hospitalsystem.controller;

import com.hospitalsystem.hospitalsystem.database.entity.RoomEntity;
import com.hospitalsystem.hospitalsystem.database.repository.RoomEntityRepository;
import com.hospitalsystem.hospitalsystem.database.specification.RoomSpecification;
import com.hospitalsystem.hospitalsystem.mapper.RoomMapper;
import com.hospitalsystem.hospitalsystem.model.RoomDTO;
import com.hospitalsystem.hospitalsystem.model.requestDTO.RoomRequestDTO;
import com.hospitalsystem.hospitalsystem.service.RoomService;
import com.hospitalsystem.hospitalsystem.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("room")
public class RoomController extends BaseController<
        RoomEntity,
        RoomDTO,
        RoomRequestDTO,
        RoomMapper,
        RoomEntityRepository,
        RoomSpecification,
        RoomService> {

    @Autowired
    RoomService roomService;

    @Override
    protected RoomService getService() {
        return this.roomService;
    }

    @PostMapping("add-room")
    public ResponseEntity<RoomDTO> addOtherRelations(@RequestBody RoomRequestDTO roomRequestDTO){
        return new ResponseEntity<>(roomService.save(roomRequestDTO), HttpStatus.OK);

    }
}