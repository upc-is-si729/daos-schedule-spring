package pe.edu.upc.schedule.appointment.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.schedule.appointment.domain.model.entity.Student;
import pe.edu.upc.schedule.appointment.resource.CreateStudentResource;
import pe.edu.upc.schedule.appointment.resource.StudentResource;
import pe.edu.upc.schedule.appointment.resource.UpdateStudentResource;
import pe.edu.upc.schedule.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;

public class StudentMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public Student toModel(CreateStudentResource resource) {
        return this.mapper.map(resource, Student.class);
    }
    public Student toModel(UpdateStudentResource resource) {
        return this.mapper.map(resource, Student.class);
    }

    public StudentResource toResource(Student student) {
        return this.mapper.map(student, StudentResource.class);
    }


}
