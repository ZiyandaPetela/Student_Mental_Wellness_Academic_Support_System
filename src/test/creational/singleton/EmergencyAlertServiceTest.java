// src/test/java/creational/singleton/EmergencyAlertServiceTest.java
package test.creational.singleton;

import org.junit.jupiter.api.Test;

import creational.singleton.EmergencyAlertService;

import static org.junit.jupiter.api.Assertions.*;

class EmergencyAlertServiceTest {
    @Test
    void testSingletonInstance() {
        EmergencyAlertService instance1 = EmergencyAlertService.getInstance();
        EmergencyAlertService instance2 = EmergencyAlertService.getInstance();
        assertSame(instance1, instance2, "Singleton instances should be the same");
    }

    @Test
    void testThreadSafety() throws InterruptedException {
        Runnable task = () -> {
            EmergencyAlertService instance = EmergencyAlertService.getInstance();
            assertNotNull(instance);
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}