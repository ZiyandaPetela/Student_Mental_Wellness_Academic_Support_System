// src/test/java/creational/simplefactory/AppointmentFactoryTest.java
package test.creational_patterns.simplefactory;

import core.Appointment;
import creational.simplefactory.AppointmentFactory;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppointmentFactoryTest {
    @Test
    void testUrgentAppointment() {
        Appointment appointment = AppointmentFactory.createAppointment("URGENT", "APT-001", LocalDateTime.now());
        assertEquals("APT-001", appointment.getAppointmentId());
    }

    @Test
    void testInvalidType() {
        assertThrows(IlllegalArgumentException.class, () -> 
            AppointmentFactory.createAppointment("INVALID", "APT-002", LocalDateTime.now())
        );
    }
}