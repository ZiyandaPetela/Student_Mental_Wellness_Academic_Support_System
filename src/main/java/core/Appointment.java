package core;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment {
    
    @Id
    private String appointmentId;
    
    private LocalDateTime dateTime;
    
    @Enumerated(EnumType.STRING)
    private Status status = Status.SCHEDULED;
    
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    
    @ManyToOne
    @JoinColumn(name = "counselor_id")
    private Counselor counselor;
    
    public enum Status {
        SCHEDULED, CONFIRMED, COMPLETED, CANCELLED
    }
    
    // Required no-arg constructor
    public Appointment() {}
    
    public Appointment(String appointmentId, LocalDateTime dateTime) {
        this.appointmentId = appointmentId;
        this.dateTime = dateTime;
    }
    
    // Getters
    public String getAppointmentId() { return appointmentId; }
    public LocalDateTime getDateTime() { return dateTime; }
    public Status getStatus() { return status; }
    public Student getStudent() { return student; }
    public Counselor getCounselor() { return counselor; }
    
    // Setters
    public void setAppointmentId(String appointmentId) { this.appointmentId = appointmentId; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
    public void setStatus(Status status) { this.status = status; }
    public void setStudent(Student student) { this.student = student; }
    public void setCounselor(Counselor counselor) { this.counselor = counselor; }
    
    // For backward compatibility with string status
    public void setStatus(String statusStr) {
        try {
            this.status = Status.valueOf(statusStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid status: " + statusStr);
        }
    }
    
    public boolean cancel() {
        if (status == Status.CANCELLED) {
            return false;
        }
        status = Status.CANCELLED;
        return true;
    }
}
