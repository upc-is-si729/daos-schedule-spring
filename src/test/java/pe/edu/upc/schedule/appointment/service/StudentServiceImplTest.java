package pe.edu.upc.schedule.appointment.service;

import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.edu.upc.schedule.appointment.domain.model.entity.Student;
import pe.edu.upc.schedule.appointment.domain.persistence.StudentRepository;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceImplTest {

    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private Validator validator;

    @Test
    public void testFetchAll() {
        // Arrange
        List<Student> expected = this.expectedListStudents();
        Mockito.when(studentRepository.findAll())
                .thenReturn(this.actualListStudents());
        // Act
        List<Student> actual = studentService.fetchAll();

        // Assert
        Assertions.assertEquals(expected.get(0).getId(), actual.get(0).getId());
        Assertions.assertEquals(expected.get(0).getLastName(), actual.get(0).getLastName());
        Assertions.assertEquals(expected.get(0).getFirstName(), actual.get(0).getFirstName());
        //Assertions.assertEquals(expected.get(0).getBirthday(), actual.get(0).getBirthday());
        Assertions.assertEquals(expected.get(0).getTiu(), actual.get(0).getTiu());
    }

    @Test
    public void testFetchById() {
        // Arrange
        Integer idExpected = 15;
        Integer idActual = 15;
        Optional<Student> expected = this.expectedOptionalStudent(idExpected);

        Mockito.when(studentRepository.existsById(Mockito.anyInt()))
                .thenReturn(true);
        Mockito.when(studentRepository.findById(Mockito.anyInt()))
                .thenReturn(actualOptionalStudent(idActual));
        // Act
        Optional<Student> actual = studentService.fetchById(idActual);
        // Assert
        Assertions.assertEquals(expected.get().getId(), actual.get().getId());
        Assertions.assertEquals(expected.get().getLastName(), actual.get().getLastName());
        Assertions.assertEquals(expected.get().getFirstName(), actual.get().getFirstName());
        //Assertions.assertEquals(expected.get().getBirthday(), actual.get().getBirthday());
        Assertions.assertEquals(expected.get().getTiu(), actual.get().getTiu());



    }


    public List<Student> expectedListStudents() {
        List<Student> expected = new ArrayList<>();

        Calendar birthday = Calendar.getInstance();
        birthday.set(1990, 2, 15);

        Student student = new Student();
        student.setId(1);
        student.setLastName("Chura");
        student.setFirstName("Jose");
        student.setBirthday(birthday.getTime());
        student.setTiu("123456789");

        expected.add(student);
        return expected;
    }
    public List<Student> actualListStudents() {
        List<Student> expected = new ArrayList<>();

        Calendar birthday = Calendar.getInstance();
        birthday.set(1990, 2, 15);

        Student student = new Student();
        student.setId(1);
        student.setLastName("Chura");
        student.setFirstName("Jose");
        student.setBirthday(birthday.getTime());
        student.setTiu("123456789");

        expected.add(student);
        return expected;
    }

    public Optional<Student> expectedOptionalStudent(Integer id) {
        return Optional.of(createStudent(id));
    }
    public Optional<Student> actualOptionalStudent(Integer id) {
        return Optional.of(createStudent(id));
    }

    public Student createStudent(Integer id) {
        Calendar birthday = Calendar.getInstance();
        birthday.set(1990, 2, 15);

        Student student = new Student();
        student.setId(id);
        student.setLastName("Chura");
        student.setFirstName("Jose");
        student.setBirthday(birthday.getTime());
        student.setTiu("123456789");
        return student;
    }

}
