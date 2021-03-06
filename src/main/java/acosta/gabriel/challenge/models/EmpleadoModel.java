package acosta.gabriel.challenge.models;

import javax.persistence.*;

@Entity
@Table(name = "empleado")
public class EmpleadoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long idEmpleado;

    private String nombre;
    private String apellido;
    private Integer dni;
    private String empleado;
    
    
    public long getIdEmpleado() {
        return idEmpleado;
    }
    public void setIdEmpleado(long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Integer getDni() {
        return dni;
    }
    public void setDni(Integer dni) {
        this.dni = dni;
    }
    public String getEmpleado() {
        return empleado;
    }
    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }
}
