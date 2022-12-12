package com.examb.examb.Services;

import com.examb.examb.Entities.Parking;
import com.examb.examb.Entities.Personnel;

import java.util.Date;
import java.util.List;

public interface Services {
    Personnel AjouterPersonnel(Personnel personnel);

    void ajoutParkingetZone(Parking parking);

    void  affecterPersonnelZone(int idZone,int idGard);

    List<Personnel> getAllPersonnelByParking(Parking parking) ;

    List<Personnel> getPersonnelByDate(Date startDate,Date endDate);

}
