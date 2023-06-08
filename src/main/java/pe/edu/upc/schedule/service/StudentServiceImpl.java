package pe.edu.upc.schedule.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.schedule.domain.model.entity.Student;
import pe.edu.upc.schedule.domain.persistence.StudentRepository;
import pe.edu.upc.schedule.domain.service.StudentService;
import pe.edu.upc.schedule.shared.Constant;
import pe.edu.upc.schedule.shared.exception.ResourceNotFoundException;
import pe.edu.upc.schedule.shared.exception.ResourceValidationException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private Validator validator;

    @Transactional(readOnly = true)
    @Override
    public List<Student> fetchAll() {
        return studentRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Student> fetchById(Integer id) {
        if (studentRepository.existsById(id)) {
            return studentRepository.findById(id);
        } else {
            throw new ResourceNotFoundException("Student", id);
        }
    }

    @Transactional
    @Override
    public Student save(Student student) {
        Set<ConstraintViolation<Student>> violations = validator.validate(student);
        if (!violations.isEmpty()) {
            throw new ResourceValidationException(Constant.STUDENT_ENTITY, violations);
        }
        return studentRepository.save(student);
    }

    @Transactional
    @Override
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    @Override
    public boolean deleteById(Integer id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
