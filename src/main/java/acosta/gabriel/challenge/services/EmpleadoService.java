package acosta.gabriel.challenge.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acosta.gabriel.challenge.models.EmpleadoModel;
import acosta.gabriel.challenge.repositories.EmpleadoRepository;

@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepository;

    public ArrayList<EmpleadoModel> obtenerEmpleados(){
        return (ArrayList<EmpleadoModel>) empleadoRepository.findAll();

    }
    
    public EmpleadoModel guardarEmpleado(EmpleadoModel empleado){
        return empleadoRepository.save(empleado);
    } 

    public Optional<EmpleadoModel> obtenerPorId(Long id){
        return empleadoRepository.findById(id);
    }

    public ArrayList<EmpleadoModel> obtenerPorDni(Integer dni){
        return empleadoRepository.findByDni(dni);
    }

    public EmpleadoModel modificarEmpleado(EmpleadoModel empleado){
        return empleadoRepository.save(empleado);
    } 

    public boolean eliminarEmpleado(Long id){
        try {
            empleadoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
