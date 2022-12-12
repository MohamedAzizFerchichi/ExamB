package com.examb.examb.Services;

import com.examb.examb.Entities.Parking;
import com.examb.examb.Entities.Personnel;
import com.examb.examb.Entities.Zone;
import com.examb.examb.Repository.ParkingRepository;
import com.examb.examb.Repository.PersonnelRepository;
import com.examb.examb.Repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;


@Service
public class ServiceImp implements Services {
     @Autowired
     PersonnelRepository personnelRepository;

     @Autowired
    ZoneRepository zoneRepository ;

     @Autowired
    ParkingRepository parkingRepository ;

    @Override
    public Personnel AjouterPersonnel(Personnel personnel) {


         return personnelRepository.save(personnel);
    }

    @Override
    @Transactional
    public void ajoutParkingetZone(Parking parking) {
        Parking p = parkingRepository.save(parking);
        System.out.println(p.getZones());
        for (Zone z :p.getZones()){
            z.setParking(p);
        }

    }

    @Override
    @Transactional
    public void affecterPersonnelZone(int idZone, int idGard) {
        Personnel p = personnelRepository.findById(idGard).orElse(null);
        Zone zone = zoneRepository.findById(idZone).orElse(null);

        assert zone != null;
        zone.setPersonnel(p);

        assert p != null;
        p.setZone(zone);

    }

    @Override
    public List<Personnel> getAllPersonnelByParking(Parking parking) {
        Zone zone = zoneRepository.findByParking(parking);
        return  personnelRepository.findByZone(zone);
    }

    @Override
    public List<Personnel> getPersonnelByDate(Date startDate, Date endDate) {
        List<Personnel> personnels = personnelRepository.findAll();
        List<Personnel> ps = new ArrayList<>();
        for(Personnel p  : personnels){
            if(p.getDateDeRecrutement().after(startDate)&&p.getDateDeRecrutement().before(endDate));
            {
                ps.add(p);

            }
        }
        return ps ;
    }


}

