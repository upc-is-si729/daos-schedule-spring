package pe.edu.upc.schedule.api;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.schedule.domain.model.entity.Student;
import pe.edu.upc.schedule.domain.service.StudentService;
import pe.edu.upc.schedule.mapping.StudentMapper;
import pe.edu.upc.schedule.resource.CreateStudentResource;
import pe.edu.upc.schedule.resource.StudentResource;

import java.util.List;

@RestController
@RequestMapping("students")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final StudentMapper mapper;

    @PostMapping
    public StudentResource save(@RequestBody CreateStudentResource resource) {
        return mapper.toResource( studentService.save( mapper.toModel(resource) ) );
    }

    @GetMapping
    public List<Student> fetchAll() {
        return studentService.fetchAll();
    }

    @GetMapping("{id}")
    public Student fetchId(@PathVariable Integer id) {
        return studentService.fetchById(id).get();
    }



}




