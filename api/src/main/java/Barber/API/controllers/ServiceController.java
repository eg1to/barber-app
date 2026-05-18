package Barber.API.controllers; // Lembre-se de ajustar para o seu pacote

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Barber.API.entities.Service;
import Barber.API.repositories.ServiceRepository;

@RestController 
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @PostMapping
    public Service createService(@RequestBody Service newService) {
        return serviceRepository.save(newService); 
    }


    @GetMapping
    public List<Service> listAllServices() {
        return serviceRepository.findAll();
    }
}