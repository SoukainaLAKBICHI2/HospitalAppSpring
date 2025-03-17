package org.app.hopitalapp;


import org.app.hopitalapp.entities.Patient;
import org.app.hopitalapp.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HopitalAppApplication implements CommandLineRunner {

    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(HopitalAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(null,"Soukaina",new Date(),false,23));
        patientRepository.save(new Patient(null,"Hajar",new Date(),false,40));
        patientRepository.save(new Patient(null,"Sara",new Date(),false,96));


    }
}

