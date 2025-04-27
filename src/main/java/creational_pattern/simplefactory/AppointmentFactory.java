// src/main/java/creational/simplefactory/AppointmentFactory.java
package creational_pattern.simplefactory;

import core.Appointment;
import java.time.LocalDateTime;

public class AppointmentFactory {
    public static Appointment createAppointment(String type, String id, LocalDateTime time) {
        if ("URGENT".equalsIgnoreCase(type)) {
            return new Appointment(id, time); // Add urgent-specific logic
        } else {
            return new Appointment(id, time); // Regular appointment
        }
    }
}