package una.ac.cr.webservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import una.ac.cr.webservice.entity.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona,Long> {
}
