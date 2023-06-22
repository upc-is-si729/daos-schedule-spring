package pe.edu.upc.schedule.appointment.domain.service;

import pe.edu.upc.schedule.appointment.domain.model.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> fetchAll();    // getAll, fetchAll, getStudents
    Optional<Student> fetchById(Integer id);
    Student save(Student student);
    Student update(Student student);
    boolean deleteById(Integer id);

}
