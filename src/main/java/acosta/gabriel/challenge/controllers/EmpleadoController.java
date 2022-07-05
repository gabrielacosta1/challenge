package acosta.gabriel.challenge.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import acosta.gabriel.challenge.models.EmpleadoModel;
import acosta.gabriel.challenge.services.EmpleadoService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping()
    public ArrayList<EmpleadoModel> obtenerEmpleados(){
        return empleadoService.obtenerEmpleados();
    }

    @PostMapping()
    public EmpleadoModel guardarEmpleado(@RequestBody EmpleadoModel empleado){
        if (empleado.getEmpleado().equals("Si") || empleado.getEmpleado().equals("No") 
        || empleado.getEmpleado().equals("si") || empleado.getEmpleado().equals("no")){
            return this.empleadoService.guardarEmpleado(empleado);
        } else {
            return null;
        }
    }

    @GetMapping( path = "/{id}")
    public Optional<EmpleadoModel> obtenerEmpleadoPorId(@PathVariable("id") Long id) {
        return this.empleadoService.obtenerPorId(id);
    }

    @GetMapping(value="query")
    public ArrayList<EmpleadoModel> obtenerEmpleadoPorDni(@RequestParam("dni") Integer dni) {
        return this.empleadoService.obtenerPorDni(dni);
    }

    @PutMapping
    public EmpleadoModel modificarEmpleado(@RequestBody EmpleadoModel empleado){
        if (empleado.getEmpleado().equals("Si") || empleado.getEmpleado().equals("No") 
        || empleado.getEmpleado().equals("si") || empleado.getEmpleado().equals("no")){
            return this.empleadoService.guardarEmpleado(empleado);
        } else {
            return null;
        }
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.empleadoService.eliminarEmpleado(id);
        if (ok) {
            return "Se elimino el empleado con el id " + id;
        } else {
            return "No se pudo eliminar el empleado";
        }
    }
}
