package com.examb.examb.Repository;

import com.examb.examb.Entities.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkingRepository extends JpaRepository<Parking,Integer> {
    //@Query("select count (u) from Personnel u where u.niveau = :niveau")
    //int count(@Param("niveau") Niveau niveau) ;

}
