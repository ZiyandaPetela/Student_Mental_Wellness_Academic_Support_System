package core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MentalHealthAssessment {
    private String assessmentId;
    private String type; // PHQ-9 or GAD-7
    private int score;
    private LocalDateTime timestamp;
    private List<WellnessResource> recommendedResources = new ArrayList<>();
    private EmergencyAlert alert;

    public MentalHealthAssessment(String assessmentId, String type) {
        this.assessmentId = assessmentId;
        setType(type); // Validation
        this.timestamp = LocalDateTime.now();
    }

    // Getters/Setters
    public String getAssessmentId() { return assessmentId; }
    public String getType() { return type; }
    public int getScore() { return score; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public List<WellnessResource> getRecommendedResources() { return recommendedResources; }
    public EmergencyAlert getAlert() { return alert; }

    private void setType(String type) {
        if (!type.equals("PHQ-9") && !type.equals("GAD-7")) {
            throw new IllegalArgumentException("Invalid assessment type");
        }
        this.type = type;
    }

    public int calculateScore() {
        // Simulated scoring logic
        this.score = (int) (Math.random() * 27); // PHQ-9 range: 0-27
        return score;
    }

    public boolean generateRecommendations() {
        recommendedResources.clear();
        if (score >= 10) {
            recommendedResources.add(new WellnessResource("RES-101", "Stress Management Guide", "ARTICLE"));
            return true;
        }
        return false;
    }

    public boolean triggerAlerts() {
        if (score >= 15) {
            this.alert = new EmergencyAlert("ALERT-" + assessmentId, "HIGH");
            return true;
        }
        return false;
    }
}