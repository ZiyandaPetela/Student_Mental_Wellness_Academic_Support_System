package core;

import java.time.LocalDateTime;
import java.util.List;       // For List<>

public class Appointment {
    private String appointmentId;
    private LocalDateTime datetime;
    private String status; // REQUESTED, CONFIRMED, CANCELLED
    private Student student;
    private Counselor counselor;

    public Appointment(String appointmentId, LocalDateTime datetime) {
        this.appointmentId = appointmentId;
        this.datetime = datetime;
        this.status = "REQUESTED";
    }

    // Getters/Setters
    public String getAppointmentId() { return appointmentId; }
    public LocalDateTime getDatetime() { return datetime; }
    public String getStatus() { return status; }
    public Student getStudent() { return student; }
    public Counselor getCounselor() { return counselor; }

    public void setStatus(String status) {
        if (List.of("REQUESTED", "CONFIRMED", "CANCELLED").contains(status)) {
            this.status = status;
        }
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCounselor(Counselor counselor) {
        this.counselor = counselor;
    }

    public boolean schedule() {
        return student.scheduleAppointment(this);
    }

    public boolean cancel() {
        if (!status.equals("CANCELLED")) {
            status = "CANCELLED";
            return true;
        }
        return false;
    }
}