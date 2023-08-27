package com.hospitalsystem.hospitalsystem.database.repository;

import com.hospitalsystem.hospitalsystem.database.entity.UserEntity;
import com.hospitalsystem.hospitalsystem.util.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends BaseRepository<UserEntity> {

    Optional<UserEntity> findByEmail(String email);
}
