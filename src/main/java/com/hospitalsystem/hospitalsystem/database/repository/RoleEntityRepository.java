package com.hospitalsystem.hospitalsystem.database.repository;

import com.hospitalsystem.hospitalsystem.database.entity.RoleEntity;
import com.hospitalsystem.hospitalsystem.util.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleEntityRepository extends BaseRepository<RoleEntity> {
    Optional<RoleEntity> findByName(String name);

}
