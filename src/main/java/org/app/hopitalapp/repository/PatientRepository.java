package org.app.hopitalapp.repository;


import org.app.hopitalapp.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient,Long> {

}
