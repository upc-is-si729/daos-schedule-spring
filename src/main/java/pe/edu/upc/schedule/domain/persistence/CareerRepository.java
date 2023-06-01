package pe.edu.upc.schedule.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.schedule.domain.model.entity.Career;

@Repository
public interface CareerRepository extends JpaRepository<Career, Integer> {
}
