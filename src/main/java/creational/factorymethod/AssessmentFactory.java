// src/main/java/creational/factorymethod/AssessmentFactory.java
package creational.factorymethod;

import core.MentalHealthAssessment;

public interface AssessmentFactory {
    MentalHealthAssessment createAssessment(String assessmentId);
}

