package core;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.List;

@Entity
public class EmergencyAlert {
    @Id
    private String alertId;
    private String severity; // LOW, MEDIUM, HIGH
    private boolean escalated = false;

    // JPA-required no-arg constructor
    public EmergencyAlert() {}

    public EmergencyAlert(String alertId, String severity) {
        this.alertId = alertId;
        setSeverity(severity);
    }

    // Getters/Setters
    public String getAlertId() { return alertId; }
    public void setAlertId(String alertId) { this.alertId = alertId; } // Required for JPA

    public String getSeverity() { return severity; }
    public boolean isEscalated() { return escalated; }

    private void setSeverity(String severity) {
        String upperSev = severity.toUpperCase();
        if (List.of("LOW", "MEDIUM", "HIGH").contains(upperSev)) {
            this.severity = upperSev;
        } else {
            throw new IllegalArgumentException("Invalid severity level");
        }
    }

    // Setter for JPA (escalated field)
    public void setEscalated(boolean escalated) { this.escalated = escalated; }

    public boolean escalate() {
        if (!escalated && "HIGH".equals(severity)) {
            System.out.println("Emergency protocol activated!");
            escalated = true;
            return true;
        }
        return false;
    }
}