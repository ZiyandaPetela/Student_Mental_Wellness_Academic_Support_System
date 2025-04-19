package core;

import java.util.ArrayList;
import java.util.List;

public class WellnessResource {
    private String resourceId;
    private String title;
    private String type; // ARTICLE, VIDEO, PODCAST
    private List<String> topics = new ArrayList<>();

    public WellnessResource(String resourceId, String title, String type) {
        this.resourceId = resourceId;
        this.title = title;
        setType(type);
    }

    // Getters/Setters
    public String getResourceId() { return resourceId; }
    public String getTitle() { return title; }
    public String getType() { return type; }
    public List<String> getTopics() { return new ArrayList<>(topics); }

    private void setType(String type) {
        String upperType = type.toUpperCase();
        if (List.of("ARTICLE", "VIDEO", "PODCAST").contains(upperType)) {
            this.type = upperType;
        } else {
            throw new IllegalArgumentException("Invalid resource type");
        }
    }

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