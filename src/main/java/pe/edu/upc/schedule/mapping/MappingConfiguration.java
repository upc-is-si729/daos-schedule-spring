package pe.edu.upc.schedule.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("learningMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public StudentMapper studentMapper() {
        return new StudentMapper();
    }
}
