package una.ac.cr.webservice.repository;

import org.springframework.data.repository.CrudRepository;
import una.ac.cr.webservice.entity.Log;

public interface LogRepository extends CrudRepository<Log,Long> {
}
