package core;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MentalHealthAssessment {
    @Id
    private String assessmentId;
    
    private String type; // PHQ-9 or GAD-7
    private int score;
    private LocalDateTime timestamp;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;  // Added JPA relationship
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WellnessResource> recommendedResources = new ArrayList<>();
    
    @OneToOne(cascade = CascadeType.ALL)
    private EmergencyAlert alert;

    public MentalHealthAssessment() {}  // Required JPA no-arg constructor

    public MentalHealthAssessment(String assessmentId, String type) {
        this.assessmentId = assessmentId;
        setType(type);
        this.timestamp = LocalDateTime.now();
    }

    // Added student relationship methods
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }  // Fixes the red underline

    // Rest of getters/setters
    public String getAssessmentId() { return assessmentId; }
    public void setAssessmentId(String assessmentId) { this.assessmentId = assessmentId; }

    public String getType() { return type; }
    private void setType(String type) {
        if (!type.equals("PHQ-9") && !type.equals("GAD-7")) {
            throw new IllegalArgumentException("Invalid assessment type");
        }
        this.type = type;
    }

    public int getScore() { return score; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public List<WellnessResource> getRecommendedResources() { return recommendedResources; }
    public EmergencyAlert getAlert() { return alert; }

    public int calculateScore() {
        this.score = (int) (Math.random() * 27);
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
