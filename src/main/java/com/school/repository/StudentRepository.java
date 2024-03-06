package com.school.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {

	public Optional<StudentEntity> findByName(String name);
}
