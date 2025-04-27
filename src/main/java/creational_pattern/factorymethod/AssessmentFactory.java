// src/main/java/creational/factorymethod/AssessmentFactory.java
package creational_pattern.factorymethod;

import core.MentalHealthAssessment;

public interface AssessmentFactory {
    MentalHealthAssessment createAssessment(String assessmentId);
}

