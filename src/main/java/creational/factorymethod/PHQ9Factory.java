package creational.factorymethod;

import core.MentalHealthAssessment;


    public class PHQ9Factory implements AssessmentFactory {
    @Override
    public MentalHealthAssessment createAssessment(String id) {
        return new MentalHealthAssessment(id, "PHQ-9");
    }
}

