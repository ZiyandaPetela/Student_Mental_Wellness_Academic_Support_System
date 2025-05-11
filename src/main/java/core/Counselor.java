package core;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Counselor {
    
    @Id
    private String counselorId;
    
    private String name;
    private String specialization;
    
    @OneToMany(mappedBy = "counselor")
    private List<Appointment> managedAppointments = new ArrayList<>();
    
    // Required no-arg constructor
    public Counselor() {}
    
    public Counselor(String counselorId, String name, String specialization) {
        this.counselorId = counselorId;
        this.name = name;
        this.specialization = specialization;
    }
    
    // Getters
    public String getCounselorId() { return counselorId; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public List<Appointment> getManagedAppointments() { return managedAppointments; }
    
    // Setters
    public void setCounselorId(String counselorId) { this.counselorId = counselorId; }
    public void setName(String name) { this.name = name; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    
    public void viewTrends() {
        System.out.println("Generating counseling trends report...");
    }
    
    public boolean confirmAppointment(Appointment appointment) {
        appointment.setStatus(Appointment.Status.CONFIRMED);
        appointment.setCounselor(this);
        return managedAppointments.add(appointment);
    }
}