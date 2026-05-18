package Barber.API.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Barber.API.entities.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    
}
