package pe.edu.upc.schedule.appointment.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
@Entity
@Table(name = "careers")
public class Career {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 50, min = 1)
    @NotBlank
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @NotNull
    @Min(5)
    @Max(value = 7)
    @Column(name = "duration", nullable = false)
    private Integer duration;

    // Aditional
    @JsonIgnore
    @OneToMany(mappedBy = "career") // mapperBy es el object que permite la relación
    private ArrayList<Student> students;
}
