package Barber.API.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Barber.API.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
}