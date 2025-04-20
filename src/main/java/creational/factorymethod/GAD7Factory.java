package creational.factorymethod;

import core.MentalHealthAssessment;


public class GAD7Factory implements AssessmentFactory {
    @Override
    public MentalHealthAssessment createAssessment(String id) {
        return new MentalHealthAssessment(id, "GAD-7");
    }
}

