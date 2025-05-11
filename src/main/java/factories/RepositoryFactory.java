package factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repositories.*;

@Component
public class RepositoryFactory {
    private final StudentRepository studentRepository;
    private final CounselorRepository counselorRepository;
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public RepositoryFactory(
        StudentRepository studentRepository,
        CounselorRepository counselorRepository,
        AppointmentRepository appointmentRepository
    ) {
        this.studentRepository = studentRepository;
        this.counselorRepository = counselorRepository;
        this.appointmentRepository = appointmentRepository;
    }

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    public CounselorRepository getCounselorRepository() {
        return counselorRepository;
    }

    public AppointmentRepository getAppointmentRepository() {
        return appointmentRepository;
    }
}