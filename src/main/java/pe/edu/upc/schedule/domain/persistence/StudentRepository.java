package pe.edu.upc.schedule.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.schedule.domain.model.entity.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findByTiu(String tiu);
    List<Student> findByLastNameStartingWith(String lastName);

    // SELECT <Objeto>/<Objeto.atributo>
    @Query("SELECT estu FROM Student estu WHERE estu.tiu = :tiu or estu.lastName = :lastname")
    List<Student> fetchByTiuOrlastName(@Param("tiu") String tiu, @Param("lastname") String lastName);

}







