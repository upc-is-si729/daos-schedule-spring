package pe.edu.upc.schedule.domain.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "faculties")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    // Additional
    @OneToMany(mappedBy = "faculty")
    private ArrayList<Career> careers;

}
