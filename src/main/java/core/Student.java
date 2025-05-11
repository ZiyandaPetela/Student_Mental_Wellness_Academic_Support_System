package core;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    
    @Id
    private String studentId;
    
    private String name;
    private String email;
    private String academicYear;
    private String major;
    
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments = new ArrayList<>();
    
    // Required no-arg constructor
    public Student() {}
    
    public Student(String studentId, String name, String email, String academicYear, String major) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.academicYear = academicYear;
        this.major = major;
    }
     // Constructor for builder
    public Student(String studentId, String academicYear) {
        this.studentId = studentId;
        this.academicYear = academicYear;
    }
    
    // Getters
    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getAcademicYear() { return academicYear; }
    public String getMajor() { return major; }
    public List<Appointment> getAppointments() { return appointments; }
    
    // Setters
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setAcademicYear(String academicYear) { this.academicYear = academicYear; }
    public void setMajor(String major) { this.major = major; }
    
    // Appointment management
    public boolean addAppointment(Appointment appointment) {
        if (appointments.size() >= 3) {
            return false;
        }
        
        appointment.setStudent(this);
        return appointments.add(appointment);
    }
    
    public boolean removeAppointment(Appointment appointment) {
        return appointments.remove(appointment);
    }
}
