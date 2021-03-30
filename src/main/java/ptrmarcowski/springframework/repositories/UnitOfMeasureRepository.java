package ptrmarcowski.springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import ptrmarcowski.springframework.domain.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

	Optional<UnitOfMeasure> findByDescription(String description);
	
}
