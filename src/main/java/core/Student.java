package core;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String email;
    private String academicYear;
    private String major;
    private List<MentalHealthAssessment> assessments = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>(3); // Max 3

    public Student(String studentId, String email) {
        this.studentId = studentId;
        setEmail(email); // Validation in setter
    }

    // Getters/Setters
    public String getStudentId() { return studentId; }
    public String getEmail() { return email; }
    public String getAcademicYear() { return academicYear; }
    public String getMajor() { return major; }
    public List<Appointment> getAppointments() { return new ArrayList<>(appointments); }

    public void setEmail(String email) {
        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email;
    }

    public void setAcademicYear(String academicYear) { this.academicYear = academicYear; }
    public void setMajor(String major) { this.major = major; }

    // Core methods
    public boolean register() { return true; }
    public boolean login() { return true; }
    
    public boolean completeAssessment(MentalHealthAssessment assessment) {
        return assessments.add(assessment);
    }
    
    public boolean scheduleAppointment(Appointment appointment) {
        if (appointments.size() < 3) {
            return appointments.add(appointment);
        }
        return false;
    }
}