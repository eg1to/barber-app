package Barber.API.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Barber.API.entities.Service;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
    
}
