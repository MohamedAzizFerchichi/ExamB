package com.examb.examb.Controller;

import com.examb.examb.Entities.Parking;
import com.examb.examb.Entities.Personnel;
import com.examb.examb.Repository.ParkingRepository;
import com.examb.examb.Services.Services;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class Controller {


        @Autowired
        Services service;
        @Autowired
        ParkingRepository parkingRepository ;

        @PostMapping ("/addP")
        public Personnel AjouterPersonnel(@RequestBody Personnel personnel){
                return service.AjouterPersonnel(personnel);
        }

        @PostMapping("/addPar")
        public Parking ajoutParkingetZone(@RequestBody Parking parking){
                service.ajoutParkingetZone(parking);
                return parking;
        }
        @GetMapping("/{iz}/{idp}")
        public void affecterPersonnelZone(@PathVariable int iz ,@PathVariable int idp){
                service.affecterPersonnelZone(iz,idp);
        }

        @GetMapping("/{idp}")
        public List<Personnel> listPersonnel(@PathVariable int idp){
                Parking p =  parkingRepository.findById(idp).orElse(null);
                return service.getAllPersonnelByParking(p);
        }

        
        @GetMapping("/{startDate}/{endDate}")
        public List<Personnel> PersonnelByDates(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                 @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
                return service.getPersonnelByDate(startDate,endDate);
        }

}
