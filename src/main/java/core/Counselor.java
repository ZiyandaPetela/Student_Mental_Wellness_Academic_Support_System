package core;

import java.util.ArrayList;
import java.util.List;

public class Counselor {
    private String counselorId;
    private String specialization;
    private List<Appointment> managedAppointments = new ArrayList<>();

    public Counselor(String counselorId, String specialization) {
        this.counselorId = counselorId;
        this.specialization = specialization;
    }

    // Getters/Setters
    public String getCounselorId() { return counselorId; }
    public String getSpecialization() { return specialization; }
    public List<Appointment> getManagedAppointments() { return new ArrayList<>(managedAppointments); }

    public void viewTrends() {
        System.out.println("Generating counseling trends report...");
    }

    public boolean confirmAppointment(Appointment appointment) {
        appointment.setStatus("CONFIRMED");
        return managedAppointments.add(appointment);
    }
}