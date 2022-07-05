package acosta.gabriel.challenge.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import acosta.gabriel.challenge.models.EmpleadoModel;

@Repository
public interface EmpleadoRepository extends CrudRepository<EmpleadoModel, Long> {
    public abstract ArrayList<EmpleadoModel> findByDni(Integer dni);

}
