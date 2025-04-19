package core;
import java.util.List;       // For List<>

public class EmergencyAlert {
    private String alertId;
    private String severity; // LOW, MEDIUM, HIGH
    private boolean escalated = false;

    public EmergencyAlert(String alertId, String severity) {
        this.alertId = alertId;
        setSeverity(severity);
    }

    // Getters/Setters
    public String getAlertId() { return alertId; }
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

    public boolean escalate() {
        if (!escalated && severity.equals("HIGH")) {
            System.out.println("Emergency protocol activated!");
            escalated = true;
            return true;
        }
        return false;
    }
}