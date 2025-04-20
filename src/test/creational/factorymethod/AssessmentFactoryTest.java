// src/test/java/creational/factorymethod/AssessmentFactoryTest.java
package test.creational.factorymethod;

import core.MentalHealthAssessment;
import creational.factorymethod.AssessmentFactory;
import creational.factorymethod.GAD7Factory;
import creational.factorymethod.PHQ9Factory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AssessmentFactoryTest {
    @Test
    void testPHQ9Factory() {
        AssessmentFactory factory = new PHQ9Factory();
        MentalHealthAssessment assessment = factory.createAssessment("PHQ-001");
        assertEquals("PHQ-9", assessment.getType());
    }

    @Test
    void testGAD7Factory() {
        AssessmentFactory factory = new GAD7Factory();
        MentalHealthAssessment assessment = factory.createAssessment("GAD-001");
        assertEquals("GAD-7", assessment.getType());
    }
}