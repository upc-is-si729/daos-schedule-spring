package pe.edu.upc.schedule.appointment.api;

import lombok.AllArgsConstructor;
import pe.edu.upc.schedule.appointment.domain.service.StudentService;

// 3. Lombook
@AllArgsConstructor
public class ProvitionalControlar {
    // 2. @Autowired // @Inject
    private final StudentService studentService;

    // 1. Constructor  -> final
    /*public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }*/
}

