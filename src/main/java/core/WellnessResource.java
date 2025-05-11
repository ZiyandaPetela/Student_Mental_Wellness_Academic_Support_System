package core;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ElementCollection;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WellnessResource {
    @Id
    private String resourceId;
    private String title;
    private String type;
    
    @ElementCollection
    private List<String> topics = new ArrayList<>();

    public WellnessResource() {} // JPA-required constructor

    public WellnessResource(String id, String title, String type) {
        this.resourceId = id;
        this.title = title;
        setType(type); // Validation through setter
    }

    // Getters
    public String getResourceId() { return resourceId; }
    public String getTitle() { return title; }
    public String getType() { return type; }
    public List<String> getTopics() { return new ArrayList<>(topics); }

    // Setters/Validation
    private void setType(String type) {
        String upperType = type.toUpperCase();
        if (List.of("ARTICLE", "VIDEO", "PODCAST").contains(upperType)) {
            this.type = upperType;
        } else {
            throw new IllegalArgumentException("Invalid resource type");
        }
    }

    // Business methods
    public void addTopic(String topic) {
        topics.add(topic);
    }

    public static List<WellnessResource> filterByTopic(List<WellnessResource> resources, String topic) {
        List<WellnessResource> filtered = new ArrayList<>();
        for (WellnessResource resource : resources) {
            if (resource.getTopics().contains(topic)) {
                filtered.add(resource);
            }
        }
        return filtered;
    }
}