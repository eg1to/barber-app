package Barber.API.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Barber.API.entities.Appointment;
import Barber.API.repositories.AppointmentRepository;
import Barber.API.entities.Service;
import Barber.API.entities.User;
import Barber.API.repositories.ServiceRepository;
import Barber.API.repositories.UserRepository;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment newAppointment) {
    // 1. Buscamos o Cliente Real no banco (Usamos o .orElseThrow() caso o ID não exista)
        User clientReal = userRepository.findById(newAppointment.getClient().getUserId()).orElseThrow();
        
        // 2. Buscamos o Profissional Real no banco
        User professionalReal = userRepository.findById(newAppointment.getProfessional().getUserId()).orElseThrow();
        
        // 3. Buscamos o Serviço Real no banco
        Service serviceReal = serviceRepository.findById(newAppointment.getService().getServiceId()).orElseThrow();

        // 4. Substituímos os fantasmas que vieram do JSON pelos objetos reais
        newAppointment.setClient(clientReal);
        newAppointment.setProfessional(professionalReal);
        newAppointment.setService(serviceReal);

        // 5. Agora sim, com objetos reais vinculados, o Hibernate deixa salvar!
        return appointmentRepository.save(newAppointment);
    }

    @GetMapping
    public List<Appointment> listAllAppointments() {
        return appointmentRepository.findAll();
    }

}
