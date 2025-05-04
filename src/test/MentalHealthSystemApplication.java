package test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import repositories.AppointmentRepository;
import repositories.CounselorRepository;
import repositories.StudentRepository;
import repositories.inmemory.InMemoryAppointmentRepository;
import repositories.inmemory.InMemoryCounselorRepository;
import repositories.inmemory.InMemoryStudentRepository;
import services.AppointmentService;
import services.CounselorService;
import services.StudentService;

@SpringBootApplication
@ComponentScan(basePackages = {"api", "services", "repositories", "core"})
public class MentalHealthSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MentalHealthSystemApplication.class, args);
    }

    // Repository beans
    @Bean
    public StudentRepository studentRepository() {
        return new InMemoryStudentRepository();
    }
    
    @Bean
    public CounselorRepository counselorRepository() {
        return new InMemoryCounselorRepository();
    }
    
    @Bean
    public AppointmentRepository appointmentRepository() {
        return new InMemoryAppointmentRepository();
    }
    
    // Service beans
    @Bean
    public StudentService studentService(StudentRepository studentRepository) {
        return new StudentService(studentRepository);
    }
    
    @Bean
    public CounselorService counselorService(CounselorRepository counselorRepository) {
        return new CounselorService(counselorRepository);
    }
    
    @Bean
    public AppointmentService appointmentService(
            AppointmentRepository appointmentRepository,
            StudentRepository studentRepository,
            CounselorRepository counselorRepository) {
        return new AppointmentService(appointmentRepository, studentRepository, counselorRepository);
    }
}