package pe.edu.upc.schedule.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.schedule.domain.model.entity.Student;
import pe.edu.upc.schedule.resource.CreateStudentResource;
import pe.edu.upc.schedule.resource.StudentResource;
import pe.edu.upc.schedule.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;

public class StudentMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public Student toModel(CreateStudentResource resource) {
        return this.mapper.map(resource, Student.class);
    }

    public StudentResource toResource(Student student) {
        return this.mapper.map(student, StudentResource.class);
    }


}
