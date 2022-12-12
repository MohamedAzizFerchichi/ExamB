package com.examb.examb.Repository;

import com.examb.examb.Entities.Personnel;
import com.examb.examb.Entities.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonnelRepository extends JpaRepository<Personnel, Integer> {

    List<Personnel> findByZone(Zone zone);
}

