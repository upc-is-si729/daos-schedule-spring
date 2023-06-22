package pe.edu.upc.schedule.appointment.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.schedule.appointment.domain.model.entity.Career;

@Repository
public interface CareerRepository extends JpaRepository<Career, Integer> {
}
