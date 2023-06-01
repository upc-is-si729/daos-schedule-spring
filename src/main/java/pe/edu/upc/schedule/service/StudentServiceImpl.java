package pe.edu.upc.schedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.schedule.domain.model.entity.Student;
import pe.edu.upc.schedule.domain.persistence.StudentRepository;
import pe.edu.upc.schedule.domain.service.StudentService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

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
            return Optional.empty();
        }
    }

    @Transactional
    @Override
    public Student save(Student student) {
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
