package com.examb.examb.Repository;

import com.examb.examb.Entities.Parking;
import com.examb.examb.Entities.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneRepository extends JpaRepository<Zone,Integer>
{
        Zone findByParking(Parking parking) ;
}

