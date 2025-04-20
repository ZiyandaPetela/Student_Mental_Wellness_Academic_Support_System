// src/main/java/Main.java
package core;

import creational.singleton.EmergencyAlertService;
import creational.abstractfactory.AnxietyResourceFactory;
import creational.abstractfactory.ResourceFactory;
import creational.builder.StudentBuilder;
import creational.factorymethod.AssessmentFactory;
import creational.factorymethod.PHQ9Factory;
import creational.prototype.ResourcePrototype;
import creational.simplefactory.AppointmentFactory;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Test Singleton
        EmergencyAlertService alertService = EmergencyAlertService.getInstance();
        alertService.handleAlert(new EmergencyAlert("ALERT-001", "HIGH"));

        // Test Factory Method
        AssessmentFactory phq9Factory = new PHQ9Factory();
        MentalHealthAssessment phq9 = phq9Factory.createAssessment("PHQ-001");
        System.out.println("Created PHQ-9 Assessment: " + phq9.getType());

        // Test Abstract Factory
        ResourceFactory anxietyFactory = new AnxietyResourceFactory();
        WellnessResource anxietyArticle = anxietyFactory.createArticle("ART-101", "Managing Anxiety");
        System.out.println("Created Article: " + anxietyArticle.getTitle() + " | Topics: " + anxietyArticle.getTopics());

        // Test Builder
        Student student = new StudentBuilder("S1001", "student@uni.edu")
            .setAcademicYear("Junior")
            .setMajor("Computer Science")
            .build();
        System.out.println("Built Student: " + student.getStudentId() + " | Major: " + student.getMajor());

        // Test Prototype
        WellnessResource template = new WellnessResource("TMP-001", "Template", "ARTICLE");
        ResourcePrototype prototype = new ResourcePrototype(template);
        WellnessResource clonedResource = prototype.cloneResource("CLONE-001");
        System.out.println("Cloned Resource: " + clonedResource.getTitle());

        // Test Simple Factory
        Appointment appointment = AppointmentFactory.createAppointment("URGENT", "APT-001", LocalDateTime.now());
        System.out.println("Created Appointment: " + appointment.getAppointmentId());
    }
}